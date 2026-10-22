package com.facebook.net;

import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.fresco.cloudcontrol.CloudControl;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash.BlurHashListener;
import com.facebook.imagepipeline.blurhash.BlurHashMapUtils;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.exception.BDErrorCodeConst;
import com.facebook.imagepipeline.exception.BDException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.net.ExpiredUrlException;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.TTDiskCacheProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FrescoTTNetFetcher extends BaseNetworkFetcher<TTNetFetchState> {
    public static final String BLURHASH_DECODE_DURATION = "blurhash_decode_duration";
    public static final String BLURHASH_PRODUCER_NAME = "BlurhashProducer";
    private static final String FETCH_TIME = "fetch_time";
    public static final String HEADER_LENGTH = "X-Length";
    public static final String HEADER_MD5 = "X-Md5";
    public static final String HEADER_TYPE = "Content-Type";
    public static final String HIT_CACHE = "hit_cdn_cache";
    public static final String IMAGEX_CONSISTENCY = "imagex_consistency";
    private static final String IMAGEX_CUSTOM_PARAM = "customParam";
    public static final String IMAGEX_DEMOTION = "imagex_demotion";
    public static final String IMAGEX_IS_PREFETCH = "is_prefetch_image";
    public static final String IMAGEX_TRUE_FMT = "imagex_true_fmt";
    public static final String IMAGEX_WANT_FMT = "imagex_want_fmt";
    private static final int IMAGE_REQUEST_ORDER_ERROR = -1;
    private static final int IMAGE_REQUEST_ORDER_FIRST = 1;
    private static final int IMAGE_REQUEST_ORDER_ZERO = 0;
    private static final String IMAGE_SIZE = "image_size";
    private static final int NET_CDN_CACHE_VERIFY_EXCEPTION = 1001;
    private static final int NET_CLIENT_PROTOCOL_EXCEPTION = 1002;
    private static final int NET_NOT_ALLOW_API_HTTP_EXCEPTION = 1005;
    private static final int NET_NOT_ALLOW_USE_NETWORK_EXCEPTION = 1006;
    private static final int NET_NOT_AVAILABLE_EXCEPTION = 1003;
    private static final int NET_NO_HTTP_RESPONSE_EXCEPTION = 1004;
    private static final int NET_OTHERS_EXCEPTION = 1000;
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TAG = "FrescoTTNetFetcher";
    private static final String TOTAL_TIME = "total_time";
    private static final String X_IMAGEX_EXTRA = "x-imagex-extra";
    public static final String X_RESPONSE_CACHE = "x_response_cache";
    public static boolean ignoreContentLengthCheck;
    private static RequestUrlCallBack mRequestUrlCallBack;
    private static IRequestUrlReplace mRequestUrlReplace;
    private static FetcherInterceptorProvider sFetcherInterceptorProvider;
    private static ImageNetworkCallback sImageCallBack;
    private Executor mCancellationExecutor;
    private boolean mEnableNetworkPriority;

    /* JADX INFO: renamed from: com.facebook.net.FrescoTTNetFetcher$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public class AnonymousClass1 implements ExpandCallback<TypedInput> {
        long completeReadResponse;
        HttpRequestInfo reqInfo;
        final /* synthetic */ FrescoTTNetFetcher this$0;
        final /* synthetic */ Call val$call;
        final /* synthetic */ NetworkFetcher.Callback val$callback;
        final /* synthetic */ TTNetFetchState val$fetchState;
        final /* synthetic */ FetcherInterceptor val$finalInterceptor;
        final /* synthetic */ boolean val$finalIsCdnSampling;
        final /* synthetic */ RequestContext val$requestContext;
        final /* synthetic */ String val$urlKey;
        final /* synthetic */ boolean val$useHttps;

        @Override // com.bytedance.retrofit2.ExpandCallback
        public void onAsyncPreRequest(RequestBuilder r100) {
        }

        @Override // com.bytedance.retrofit2.Callback
        public void onResponse(Call<TypedInput> r100, SsResponse<TypedInput> r101) {
        }

        private void callHandleException(SsResponse r100, Exception r101) {
            if (r101 != null) goto L5;
            return;
        L5:
            if ((r101 instanceof RetryInterceptManager.RetryWrapException) == false) goto L7;
            RetryInterceptManager.RetryWrapException r102 = (RetryInterceptManager.RetryWrapException) r101;
            Exception r103 = r102.f274109e;
            this.val$fetchState.retryCount += r102.retryCount;
        L8:
            boolean r104 = true;
            if ((r101 instanceof RetryHttpsException) == false) goto L13;
            FrescoTTNetFetcher.access$700(this.this$0, this.val$fetchState, this.val$callback, true);
            return;
        L13:
            if (RetryInterceptManager.inst().isOpen() == false) goto L19;
            int r105 = FrescoTTNetFetcher.access$800(this.this$0, this.val$fetchState);
            TTNetFetchState r106 = this.val$fetchState;
            int r107 = r106.retryCount;
            if (r107 >= r105) goto L19;
            r106.retryCount = r107 + 1;
            FrescoTTNetFetcher.access$700(this.this$0, r106, this.val$callback, false);
            return;
        L19:
            if ((r103 instanceof HttpResponseException) == false) goto L26;
            HttpResponseException r108 = (HttpResponseException) r103;
            if (r108 == null) goto L26;
            if (r108.getStatusCode() != 304) goto L26;
            r104 = false;
        L26:
            if ((r103 instanceof CronetIOException) == false) goto L31;
            CronetIOException r109 = (CronetIOException) r103;
            BaseHttpRequestInfo r110 = r109.getRequestInfo();
            if ((r110 instanceof HttpRequestInfo) == false) goto L30;
            this.reqInfo = (HttpRequestInfo) r110;
            goto L31
        L30:
            HttpRequestInfo r111 = new HttpRequestInfo();
            this.reqInfo = r111;
            r111.httpClientType = 0;
            r111.requestLog = r109.getRequestLog();
        L31:
            if (r104 == true) goto L77;
        L76:
        L73:
            th = move-exception;
            th.printStackTrace();
            return;
        L65:
            if (this.val$callback == null) goto L81;
            Call r112 = this.val$call;     // Catch: Throwable -> L73
            if (r112 != null) goto L69;
        L71:
            this.val$callback.onFailure(r103);     // Catch: Throwable -> L73
            return;
        L69:
            if (r112.isCanceled() == false) goto L71;
            this.val$callback.onCancellation();     // Catch: Throwable -> L73
            return;
        L81:
            return;
        L77:
        L62:
            th = move-exception;
            th.printStackTrace();
            goto L76
        L33:
            if (this.reqInfo != null) goto L40;
            Call r113 = this.val$call;     // Catch: Throwable -> L62
            if ((r113 instanceof IRequestInfo) == false) goto L40;
            Object r114 = ((IRequestInfo) r113).getRequestInfo();     // Catch: Throwable -> L62
            if ((r114 instanceof HttpRequestInfo) == false) goto L40;
            this.reqInfo = (HttpRequestInfo) r114;     // Catch: Throwable -> L62
        L40:
            if (this.reqInfo != null) goto L45;
            Call r115 = this.val$call;     // Catch: Throwable -> L62
            if ((r115 instanceof IMetricsCollect) == false) goto L45;
            if (r100 == null) goto L45;
            ((IMetricsCollect) r115).doCollect();     // Catch: Throwable -> L62
            this.reqInfo = (HttpRequestInfo) r100.raw().getExtraInfo();     // Catch: Throwable -> L62
        L45:
            HttpRequestInfo r116 = this.reqInfo;     // Catch: Throwable -> L62
            if (r100 == null) goto L48;
            List<Header> r117 = r100.headers();     // Catch: Throwable -> L62
        L49:
            FrescoTTNetFetcher.access$200(r116, r117, this.val$requestContext, r103);     // Catch: Throwable -> L62
            HttpRequestInfo r118 = this.reqInfo;     // Catch: Throwable -> L62
            if (r118 == null) goto L60;
            r118.requestEnd = System.currentTimeMillis();     // Catch: Throwable -> L62
            HttpRequestInfo r119 = this.reqInfo;     // Catch: Throwable -> L62
            if (r119.completeReadResponse > 0) goto L54;
            r119.completeReadResponse = this.completeReadResponse;     // Catch: Throwable -> L62
        L54:
            JSONObject r120 = r119.extraInfo;     // Catch: Throwable -> L62
            if (r120 == null) goto L60;
            r120.put(BaseHttpRequestInfo.KEY_EXCEPTION, r103.getMessage());     // Catch: Throwable -> L58
        L58:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L62
        L60:
            FrescoTTNetFetcher.access$900(this.this$0, r100, this.val$fetchState, r103, this.reqInfo);     // Catch: Throwable -> L62
            goto L76
        L48:
            r117 = null;
            goto L49
        L7:
            r103 = r101;
            goto L8
        }

        @Override // com.bytedance.retrofit2.ExpandCallback
        public void onAsyncResponse(final Call<TypedInput> r110, final SsResponse<TypedInput> r111) {
            InputStream r100 = null;
            this.completeReadResponse = System.currentTimeMillis();     // Catch: Throwable -> L81 Exception -> L83
            if (r111 == null) goto L6;
            this.this$0.processResponse(this.val$fetchState, r111);     // Catch: Throwable -> L81 Exception -> L83
            TypedInput r101 = r111.body();     // Catch: Throwable -> L81 Exception -> L83
            if (r111.isSuccessful() == false) goto L80;
            FetcherInterceptor r102 = this.val$finalInterceptor;     // Catch: Throwable -> L81 Exception -> L83
            if (r102 == null) goto L24;
            Pair<InputStream, Long> r103 = r102.intercepterStream(r101.in(), r111.raw().getUrl(), r101.length());     // Catch: Throwable -> L81 Exception -> L83
            InputStream r104 = (InputStream) r103.first;     // Catch: Throwable -> L81 Exception -> L83
            long r105 = ((Long) r103.second).longValue();     // Catch: Throwable -> L20 Exception -> L22
            InputStream r106 = r104;
        L27:
            if (TextUtils.isEmpty(this.val$urlKey) == false) goto L101;
        L33:
            InputStream r112 = r106;
        L35:
            if (r105 >= 0) goto L114;
        L46:
            long r113 = 0;
        L47:
            final String r107 = FrescoTTNetFetcher.access$000(r111.headers(), FrescoTTNetFetcher.HEADER_MD5);     // Catch: Throwable -> L42 Exception -> L44
            FrescoTTNetFetcher.access$100(this.this$0, r111, r107, this.val$fetchState);     // Catch: Throwable -> L42 Exception -> L44
            String r108 = FrescoTTNetFetcher.access$000(r111.headers(), "x-imagex-blurhash");     // Catch: Throwable -> L42 Exception -> L44
            if (TextUtils.isEmpty(r108) == true) goto L67;
            BlurHashConfig r114 = this.val$fetchState.getContext().getImageRequest().getBlurHashOptions();     // Catch: Throwable -> L42 Exception -> L64
            WeakReference<BlurHashListener> r115 = BlurHashMapUtils.getListener(this.val$fetchState.getUri());     // Catch: Throwable -> L42 Exception -> L64
            long r109 = Long.parseLong(FrescoTTNetFetcher.access$000(r111.headers(), FrescoTTNetFetcher.HEADER_LENGTH));     // Catch: Throwable -> L42 Exception -> L52
        L55:
            if (r115 == null) goto L67;
            if (r115.get() == null) goto L67;
            if (ImageBlurhashStrategy.getStrategy().isUseBlurhash(this.val$fetchState.getUri(), r109) == false) goto L67;
            long r116 = r115.get().onBlurHashReady(r108, r114);     // Catch: Throwable -> L42 Exception -> L64
            if (this.val$fetchState.getListener() == null) goto L67;
            HashMap r117 = new HashMap(1);     // Catch: Throwable -> L42 Exception -> L64
            r117.put("blurhash_decode_duration", String.valueOf(r116));     // Catch: Throwable -> L42 Exception -> L64
            this.val$fetchState.getListener().onProducerFinishWithSuccess(this.val$fetchState.getId(), FrescoTTNetFetcher.BLURHASH_PRODUCER_NAME, r117);     // Catch: Throwable -> L42 Exception -> L64
        L52:
            e = move-exception;
            FLog.d(FrescoTTNetFetcher.TAG, "onAsyncResponse: contentLengthStr parser exception is: " + e);     // Catch: Throwable -> L42 Exception -> L64
            r109 = -1;
        L64:
            e = move-exception;
            FLog.d(FrescoTTNetFetcher.TAG, "onAsyncResponse: blurhash exception is " + e);     // Catch: Throwable -> L42 Exception -> L44
        L67:
            if (FrescoTTNetFetcher.ignoreContentLengthCheck == false) goto L69;
        L73:
            final long r118 = r113;
            this.val$fetchState.completeRunnable = new RunnableC38371(this, r118, r110, r111, r107);     // Catch: Throwable -> L42 Exception -> L44
            this.val$callback.onResponse(r112, (int) r113);     // Catch: Throwable -> L42 Exception -> L44
            if (this.val$finalIsCdnSampling == false) goto L77;
            CdnDeviceBandwidthSampler.getInstance().stopSampling();
        L77:
            StreamParser.safeClose(r112);     // Catch: Throwable -> L90
        L105:
            return;
        L69:
            if (r113 > 0) goto L73;
            throw new BDException(BDErrorCodeConst.BD_ERROR_CODE_DATA_PARSE, BDErrorCodeConst.BD_ERROR_MSG_DATA_PARSE);     // Catch: Throwable -> L42 Exception -> L44
        L114:
        L42:
            th = move-exception;
            Throwable r119 = th;
            r100 = r112;
        L94:
            if (this.val$finalIsCdnSampling == false) goto L112;
            CdnDeviceBandwidthSampler.getInstance().stopSampling();
        L112:
            StreamParser.safeClose(r100);     // Catch: Throwable -> L98
            throw r119;
        L98:
            th = move-exception;
            th.printStackTrace();
            throw r119;
        L44:
            e = e;
            r100 = r112;
        L84:
            callHandleException(r111, e);     // Catch: Throwable -> L81
            if (this.val$finalIsCdnSampling == false) goto L88;
            CdnDeviceBandwidthSampler.getInstance().stopSampling();
        L88:
            StreamParser.safeClose(r100);     // Catch: Throwable -> L90
            goto L105
        L37:
            if (this.val$fetchState.tempFileLength > 0) goto L39;
        L41:
            r113 = r105;
            goto L47
        L39:
            if (r111.code() == 206) goto L41;
        L101:
            r112 = new ByteArrayInputStream(AESEncrypt.decrypt(AESEncrypt.toByteArray(r106), this.val$urlKey));     // Catch: Exception -> L31 Throwable -> L81
        L31:
            e = move-exception;
            FLog.d(FrescoTTNetFetcher.TAG, "onAsyncResponse: decrypt e = " + e);     // Catch: Throwable -> L81 Exception -> L83
            e.printStackTrace();     // Catch: Throwable -> L81 Exception -> L83
            goto L33
        L22:
            e = e;
            r100 = r104;
        L20:
            th = move-exception;
            r119 = th;
            r100 = r104;
            goto L94
        L24:
            r106 = r101.in();     // Catch: Throwable -> L81 Exception -> L83
            r105 = r101.length();     // Catch: Throwable -> L81 Exception -> L83
            goto L27
        L80:
            throw new IOException("Unexpected HTTP code " + r111.code());     // Catch: Throwable -> L81 Exception -> L83
        L6:
            if (this.val$finalIsCdnSampling == false) goto L110;
            CdnDeviceBandwidthSampler.getInstance().stopSampling();
        L110:
            StreamParser.safeClose(null);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        L90:
            th = move-exception;
            th.printStackTrace();
            return;
        L83:
            e = e;
        L81:
            th = move-exception;
            r119 = th;
            goto L94
        }

        @Override // com.bytedance.retrofit2.Callback
        public void onFailure(Call<TypedInput> r100, Throwable r101) {
            this.completeReadResponse = System.currentTimeMillis();
            if (this.val$finalIsCdnSampling == false) goto L6;
            CdnDeviceBandwidthSampler.getInstance().stopSampling();
        L6:
            if ((r101 instanceof Exception) == false) goto L8;
            Exception r102 = (Exception) r101;
        L9:
            callHandleException(null, r102);
            return;
        L8:
            r102 = new Exception(r101.getMessage(), r101.getCause());
            goto L9
        }

        public AnonymousClass1(FrescoTTNetFetcher r100, TTNetFetchState r101, FetcherInterceptor r102, String r103, boolean r104, RequestContext r105, NetworkFetcher.Callback r106, boolean r107, Call r108) {
            this.this$0 = r100;
            this.val$fetchState = r101;
            this.val$finalInterceptor = r102;
            this.val$urlKey = r103;
            this.val$useHttps = r104;
            this.val$requestContext = r105;
            this.val$callback = r106;
            this.val$finalIsCdnSampling = r107;
            this.val$call = r108;
            this.reqInfo = null;
            this.completeReadResponse = -1;
        }
    }

    /* JADX INFO: renamed from: com.facebook.net.FrescoTTNetFetcher$4, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$common$Priority = null;

        static {
            int[] r100 = new int[Priority.values().length];
            $SwitchMap$com$facebook$imagepipeline$common$Priority = r100;
            r100[Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.IMMEDIATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public interface FetcherInterceptor {
        Pair<InputStream, Long> intercepterStream(InputStream r100, String r101, long r102) throws Exception;

        String intercepterUrl(String r100);
    }

    public interface FetcherInterceptorProvider {
        FetcherInterceptor getInterceptor();
    }

    /* JADX INFO: loaded from: classes23.dex */
    public interface IRequestUrlReplace {
        String replaceRequestUrl(String r100, Object r101, int r102, int r103);
    }

    /* JADX INFO: loaded from: classes23.dex */
    public interface RequestUrlCallBack {
        boolean canRequestUrl(Uri r100);
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class SimpleNetFetchState {
        private List<Uri> backUris;
        private int mCurrentPos;
        private int retryCount;
        private Uri uri;

        public int getMaxRetryCount() {
            int r100 = this.retryCount;
            if (r100 != 0) goto L9;
            List<Uri> r101 = this.backUris;
            if (r101 != null) goto L14;
            return 0;
        L14:
            return r101.size();
        L9:
            int r102 = 1;
            int r103 = r100 + 1;
            List<Uri> r104 = this.backUris;
            if (r104 == null) goto L13;
            r102 = 1 + r104.size();
        L13:
            return r103 * r102;
        }

        public Uri getUri() {
            List<Uri> r100 = this.backUris;
            if (r100 == null) goto L5;
            int r101 = this.retryCount;
            if (r101 != 0) goto L13;
            int r102 = this.mCurrentPos;
            if (r102 != 0) goto L12;
            return this.uri;
        L12:
            return r100.get(r102 - 1);
        L13:
            int r103 = this.mCurrentPos;
            if (r103 > r101) goto L18;
            return this.uri;
        L18:
            return r100.get((r103 / (r101 + 1)) - 1);
        L5:
            return this.uri;
        }

        public List<Uri> getBackUris() {
            return this.backUris;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public SimpleNetFetchState(Uri r100) {
            this(r100, null, 0);
        }

        public static /* synthetic */ int access$1000(SimpleNetFetchState r100) {
            return r100.mCurrentPos;
        }

        public static /* synthetic */ int access$1008(SimpleNetFetchState r100) {
            int r101 = r100.mCurrentPos;
            r100.mCurrentPos = r101 + 1;
            return r101;
        }

        public SimpleNetFetchState(Uri r100, List<Uri> r101, int r102) {
            this.mCurrentPos = 0;
            this.uri = r100;
            this.backUris = r101;
            this.retryCount = r102;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class TTNetFetchState extends FetchState {
        public Runnable completeRunnable;
        public long fetchCompleteTime;
        public String hitCdnCache;
        public String imagexConsistency;
        public String imagexDemotion;
        public String imagexTrueFmt;
        public String imagexWantFmt;
        public long requestStartTime;
        public int retryCount;
        public long submitTime;
        public long tempFileLength;
        public String xImageXExtra;
        public String xResponseCache;

        public TTNetFetchState(Consumer<EncodedImage> r100, ProducerContext r101) {
            super(r100, r101);
            this.retryCount = 0;
            if ((r100 instanceof TTDiskCacheProducer.DiskCacheConsumer) == false) goto L8;
            TTDiskCacheProducer.DiskCacheConsumer r102 = (TTDiskCacheProducer.DiskCacheConsumer) r100;
            if (r102.getTempEncodedImage() == null) goto L9;
            this.tempFileLength = r102.getTempEncodedImage().getSize();
            return;
        L9:
            return;
        }
    }

    public static void setDebugOk3(boolean r100) {
    }

    public FrescoTTNetFetcher() {
        this(new SsHttpExecutor());
    }

    public static /* synthetic */ ImageNetworkCallback access$500() {
        return sImageCallBack;
    }

    public FrescoTTNetFetcher(boolean r100) {
        this(r100, new SsHttpExecutor());
    }

    public static /* synthetic */ Executor access$1100(FrescoTTNetFetcher r100) {
        return r100.mCancellationExecutor;
    }

    private boolean checkXCropRs(Rect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == false) goto L8;
        return false;
    L8:
        if (r100.left >= 0) goto L10;
        return false;
    L10:
        if (r100.top < 0) goto L15;
        return true;
    L15:
        return false;
    }

    private List<Header> getCdnCacheHeaders(SsResponse<TypedInput> r110) {
        String[] r100 = {DownloadHelper.X_CACHE, "X-Cache-new", "X-Cache-Status", "via", "X-Via-Ucdn", "X-Cache-Lookup", "X-Response-Cache", "Ctl-Cache-Status", "Via"};
        int r101 = 0;
    L4:
        if (r101 >= 9) goto L11;
        String r102 = r100[r101];
        List<Header> r103 = r110.raw().headers(r102);
        if (r103 == null) goto L10;
        if (r103.size() <= 0) goto L10;
        return r103;
    L10:
        r101 = r101 + 1;
        goto L4
    L11:
        return null;
    }

    private int getErrCodeFromRequestLog(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L13;
        JSONObject r101 = new JSONObject(r100).optJSONObject("response");     // Catch: Exception -> L8
        if (r101 == null) goto L14;
        return r101.optInt("code");
    L14:
        return -1;
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L13:
        return -1;
    }

    private int getErrorCode(Throwable r100) {
        if ((r100 instanceof NetworkNotAvailabeException) == false) goto L6;
        return 1003;
    L6:
        if ((r100 instanceof CronetIOException) == false) goto L9;
        return getErrCodeFromRequestLog(((CronetIOException) r100).getRequestLog());
    L9:
        if ((r100 instanceof HttpResponseException) == false) goto L12;
        return ((HttpResponseException) r100).getStatusCode();
    L12:
        if ((r100 instanceof CdnCacheVerifyException) == false) goto L15;
        return 1001;
    L15:
        if ((r100 instanceof ClientProtocolException) == false) goto L18;
        return 1002;
    L18:
        if ((r100 instanceof NoHttpResponseException) == false) goto L21;
        return 1004;
    L21:
        if ((r100 instanceof NotAllowApiHttpException) == false) goto L24;
        return 1005;
    L24:
        if ((r100 instanceof NotAllowUseNetworkException) == false) goto L26;
        return 1006;
    L26:
        return 1000;
    }

    private static String getHostAddress(Throwable r100) {
        if (r100 != null) goto L17;
        return "";
    L17:
        String[] r101 = r100.getMessage().split("\\|");     // Catch: Throwable -> L14
        if (r101 != null) goto L8;
    L16:
        return "";
    L8:
        if (r101.length < 2) goto L16;
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "getHostAddress remoteIp = " + r101[0]);     // Catch: Throwable -> L14
    L12:
        return r101[0];
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    private int getImageRequestOrder(TTNetFetchState r100) {
        if (r100 != null) goto L5;
    L15:
        return -1;
    L5:
        if (r100.getContext() == null) goto L15;
        if (r100.getContext().getCallerContext() == null) goto L15;
        Object r101 = r100.getContext().getCallerContext();
        if ((r101 instanceof TTCallerContext) == false) goto L15;
        Uri r102 = r100.getUri();
        if (r102 == null) goto L15;
        return ((TTCallerContext) r101).getUrlIndex(r102.toString());
    }

    private int getMaxRetryCount(TTNetFetchState r100) {
        List<Uri> r101 = r100.getBackupUris();
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return 0;
    L8:
        return r101.size();
    }

    private int getRetryCount(HttpRequestInfo r100) {
        JSONObject r101 = r100.extraInfo;
        if (r101 == null) goto L8;
        Object r102 = r101.remove(DBDefinition.RETRY_COUNT);
        if ((r102 instanceof Integer) == true) goto L7;
        return 0;
    L7:
        return ((Integer) r102).intValue();
    L8:
        return 0;
    }

    public static void setFetcherInterceptorProvider(FetcherInterceptorProvider r100) {
        sFetcherInterceptorProvider = r100;
    }

    public static void setImageCallBack(ImageNetworkCallback r100) {
        sImageCallBack = r100;
    }

    public static void setRequestUrlCallBack(RequestUrlCallBack r100) {
        mRequestUrlCallBack = r100;
    }

    public static void setRequestUrlReplace(IRequestUrlReplace r100) {
        mRequestUrlReplace = r100;
    }

    public String getUrl(TTNetFetchState r100) {
        Uri r101 = r100.getUri();
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.toString();
        if (StringUtils.isEmpty(r102) == false) goto L8;
        return null;
    L8:
        return r102;
    }

    public FrescoTTNetFetcher(Executor r100) {
        this(false, r100);
    }

    public FrescoTTNetFetcher(boolean r100, Executor r101) {
        this.mEnableNetworkPriority = r100;
        this.mCancellationExecutor = r101;
        FLog.e(TAG, "init FrescoTTNetFetcher");
    }

    public static /* synthetic */ String access$000(List r100, String r101) {
        return getHeaderForName(r100, r101);
    }

    public static /* synthetic */ int access$300(FrescoTTNetFetcher r100, HttpRequestInfo r101) {
        return r100.getRetryCount(r101);
    }

    public static /* synthetic */ int access$800(FrescoTTNetFetcher r100, TTNetFetchState r101) {
        return r100.getMaxRetryCount(r101);
    }

    private void addCancelCallback(TTNetFetchState r100, final Call<TypedInput> r101) {
        r100.getContext().addCallbacks(new AnonymousClass3(this, r101));
    }

    private static String getHeaderForName(List<Header> r100, String r101) {
        String r102 = null;
        if (r100 != null) goto L5;
    L12:
        return r102;
    L5:
        if (r100.size() <= 0) goto L12;
        Iterator<Header> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Header r104 = r103.next();
        if (r101.equalsIgnoreCase(r104.getName()) == false) goto L8;
        r102 = r104.getValue();
        goto L8
    }

    private void handleDemotion(SsResponse<TypedInput> r100, TTNetFetchState r101) {
        String r102 = getHeaderForName(r100.headers(), "ImageX-Demotion");
        if (r102 != null) goto L5;
        r102 = "undefined";
    L5:
        r101.imagexDemotion = r102;
        String r103 = getHeaderForName(r100.headers(), "ImageX-Fmt");
        if (r103 != null) goto L8;
        String[] r104 = null;
    L9:
        if (r104 != null) goto L11;
    L16:
        r101.imagexWantFmt = "undefined";
        r101.imagexTrueFmt = "undefined";
    L18:
        if ("undefined".equals(r101.imagexWantFmt) == false) goto L20;
    L26:
        r101.imagexConsistency = "-1";
        return;
    L20:
        if ("undefined".equals(r101.imagexTrueFmt) == true) goto L26;
        if (r101.imagexWantFmt.equalsIgnoreCase(r101.imagexTrueFmt) == false) goto L24;
        String r105 = "1";
    L25:
        r101.imagexConsistency = r105;
        return;
    L24:
        r105 = "0";
        goto L25
    L11:
        if (r104.length <= 0) goto L16;
        r101.imagexWantFmt = r104[0];
        if (r104.length <= 1) goto L15;
        r101.imagexTrueFmt = r104[1];
        goto L18
    L15:
        r101.imagexTrueFmt = "undefined";
        goto L18
    L8:
        r104 = r103.split("2");
        goto L9
    }

    private String handleHttps(String r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        return r100.replace("http://", "https://");
    }

    private void handleRequestTime(JSONObject r110, TTNetFetchState r111) {
        long r100 = r111.requestStartTime;     // Catch: JSONException -> L27
        if (r100 == 0) goto L9;
        long r101 = r111.submitTime;     // Catch: JSONException -> L27
        if (r101 == 0) goto L9;
        r110.put(QUEUE_TIME, r100 - r101);     // Catch: JSONException -> L27
    L10:
        long r102 = r111.fetchCompleteTime;     // Catch: JSONException -> L27
        if (r102 == 0) goto L17;
        long r103 = r111.requestStartTime;     // Catch: JSONException -> L27
        if (r103 == 0) goto L17;
        r110.put(FETCH_TIME, r102 - r103);     // Catch: JSONException -> L27
    L18:
        long r104 = r111.fetchCompleteTime;     // Catch: JSONException -> L27
        if (r104 == 0) goto L25;
        long r105 = r111.submitTime;     // Catch: JSONException -> L27
        if (r105 == 0) goto L25;
        r110.put(TOTAL_TIME, r104 - r105);     // Catch: JSONException -> L27
        return;
    L25:
        r110.put(TOTAL_TIME, -1);     // Catch: JSONException -> L27
        return;
    L17:
        r110.put(FETCH_TIME, -1);     // Catch: JSONException -> L27
    L9:
        r110.put(QUEUE_TIME, -1);     // Catch: JSONException -> L27
        goto L10
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public TTNetFetchState createFetchState(Consumer<EncodedImage> r100, ProducerContext r101) {
        return new TTNetFetchState(r100, r101);
    }

    public void fetch(TTNetFetchState r100, NetworkFetcher.Callback r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        fetchWithTtnet(r100, r101, false);
    }

    public Map<String, String> getExtraMap(TTNetFetchState r100, int r101) {
        HashMap r102 = new HashMap(1);
        r102.put(IMAGE_SIZE, Integer.toString(r101));
        r102.put("hit_cdn_cache", r100.hitCdnCache);
        r102.put("x_response_cache", r100.xResponseCache);
        r102.put("imagex_demotion", r100.imagexDemotion);
        r102.put("imagex_want_fmt", r100.imagexWantFmt);
        r102.put("imagex_true_fmt", r100.imagexTrueFmt);
        r102.put("imagex_consistency", r100.imagexConsistency);
        r102.put("x-imagex-extra", r100.xImageXExtra);
        if (r100.getContext() == null) goto L16;
        if (r100.getContext().getImageRequest() == null) goto L16;
        Map<String, String> r103 = r100.getContext().getImageRequest().getCustomParam();
        if (r103 == null) goto L16;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L14
        Iterator<String> r105 = r103.keySet().iterator();     // Catch: JSONException -> L14
    L10:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();     // Catch: JSONException -> L14
        r104.put(r106, r103.get(r106));     // Catch: JSONException -> L14
        goto L10
    L12:
        r102.put("customParam", r104.toString());     // Catch: JSONException -> L14
    L16:
        if (r100.getContext() == null) goto L18;
        r102.put("is_prefetch_image", Boolean.toString(r100.getContext().isPrefetch()));
    L18:
        return r102;
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void onFetchCompletion(FetchState r100, int r101) {
        onFetchCompletion((TTNetFetchState) r100, r101);
    }

    public InputStream processResponse(TTNetFetchState r100, SsResponse<TypedInput> r101) throws IOException {
        if (r101.isSuccessful() == false) goto L7;
        return r101.body().in();
    L7:
        throw new IOException("Unexpected HTTP code " + r101.code());
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer r100, ProducerContext r101) {
        return createFetchState(r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void fetch(FetchState r100, NetworkFetcher.Callback r101) {
        fetch((TTNetFetchState) r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ Map getExtraMap(FetchState r100, int r101) {
        return getExtraMap((TTNetFetchState) r100, r101);
    }

    public void onFetchCompletion(TTNetFetchState r100, int r101) {
        r100.completeRunnable.run();
    }

    public static /* synthetic */ void access$400(FrescoTTNetFetcher r100, JSONObject r101, TTNetFetchState r102) {
        r100.handleRequestTime(r101, r102);
    }

    private void fetchWithTtnet(TTNetFetchState r210, NetworkFetcher.Callback r211, boolean r212) {
        r210.submitTime = System.currentTimeMillis();
        Uri r100 = r210.getUri();
        if (r100 != null) goto L5;
        return;
    L5:
        RequestUrlCallBack r101 = mRequestUrlCallBack;
        if (r101 != null) goto L8;
    L17:
        FetcherInterceptorProvider r102 = sFetcherInterceptorProvider;
        if (r102 == null) goto L20;
        FetcherInterceptor r103 = r102.getInterceptor();
    L21:
        String r104 = r100.toString();
        if (mRequestUrlReplace != null) goto L24;
    L38:
        if (r103 == null) goto L40;
        r104 = r103.intercepterUrl(r104);
    L40:
        String r110 = r104;
        if (StringUtils.isEmpty(r110) == false) goto L90;
        return;
    L90:
        Map<String, String> r105 = new LinkedHashMap();     // Catch: Exception -> L82
        Pair<String, String> r106 = UrlUtils.parseUrl(r110, r105);     // Catch: Exception -> L82
        String r107 = handleHttps((String) r106.first, r212);     // Catch: Exception -> L82
        String r108 = (String) r106.second;     // Catch: Exception -> L82
        if (RetryInterceptManager.inst().isOpen() == false) goto L46;
        IDownloadImage r109 = (IDownloadImage) RetryInterceptManager.inst().getRetrofitService(r107, IDownloadImage.class);     // Catch: Exception -> L82
    L47:
        RequestContext r111 = new FrescoRequestContext(r210.getBackupUris(), r210.retryCount);     // Catch: Exception -> L82
        LinkedList r112 = new LinkedList();     // Catch: Exception -> L82
        if (r210.tempFileLength <= 0) goto L52;
        r112.add(new Header("Range", "bytes=" + r210.tempFileLength + "-"));     // Catch: Exception -> L82
    L52:
        if (r210.getContext() != null) goto L54;
    L63:
        String r113 = null;
    L86:
        if (CloudControl.getInitConfig().isEnableAddRequestHeader() == false) goto L67;
        r112.add(new Header("Accept", "image/" + CloudControl.getExpectImageFormat()));     // Catch: IllegalStateException -> L85 Exception -> L82
    L67:
        Map<String, String> r114 = r210.getContext().getImageRequest().getHttpHeader();     // Catch: Exception -> L82
        if (r114 == null) goto L73;
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();     // Catch: Exception -> L82
    L71:
        if (r115.hasNext() == false) goto L73;
        Map.Entry<String, String> r116 = r115.next();     // Catch: Exception -> L82
        r112.add(new Header(r116.getKey(), r116.getValue()));     // Catch: Exception -> L82
    L73:
        if (r109 == null) goto L94;
        Call<TypedInput> r117 = dealAndGetCall(r105, r108, r109, r111, r112, r210);     // Catch: Exception -> L82
        addCancelCallback(r210, r117);     // Catch: Exception -> L82
        NetworkParams.CdnConnectionQualitySamplerHook r118 = NetworkParams.getCdnConnectionQualitySamplerHook();     // Catch: Exception -> L82
        if (r118 != null) goto L77;
    L79:
        boolean r119 = false;
    L80:
        r117.enqueue(new AnonymousClass1(this, r210, r103, r113, r212, r111, r211, r119, r117));     // Catch: Exception -> L82
        return;
    L77:
        if (r118.cdnShouldSampling(r110) == false) goto L79;
        CdnDeviceBandwidthSampler.getInstance().startSampling();     // Catch: Exception -> L82
        r119 = true;
        goto L80
    L94:
        return;
    L54:
        if (r210.getContext().getImageRequest() == null) goto L63;
        ImageRequest r120 = r210.getContext().getImageRequest();     // Catch: Exception -> L82
        String r121 = r120.getPublicKey();     // Catch: Exception -> L82
        String r122 = r120.getUrlKey();     // Catch: Exception -> L82
        if (TextUtils.isEmpty(r121) == false) goto L58;
    L62:
        r113 = r122;
        goto L86
    L58:
        if (TextUtils.isEmpty(r122) == true) goto L62;
        String r123 = EncryptUtil.encryptByPublicKey(r121, r122);     // Catch: Exception -> L82
        if (TextUtils.isEmpty(r123) == true) goto L62;
        r112.add(new Header("imagex-decrypt-key", r123));     // Catch: Exception -> L82
        goto L62
    L46:
        r109 = (IDownloadImage) RetrofitUtils.createSsService(r107, IDownloadImage.class);     // Catch: Exception -> L82
    L82:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        if (r210.getContext() == null) goto L38;
        if (r210.getContext().getImageRequest() == null) goto L38;
        if (r210.getContext().getImageRequest().isNeedReplaceUri() == false) goto L38;
        SizeDeterminer r124 = r210.getContext().getImageRequest().getSizeDeterminer();
        if (r124 != null) goto L32;
    L36:
        int r125 = 0;
        int r126 = 0;
    L37:
        r104 = mRequestUrlReplace.replaceRequestUrl(r104, r210.getContext().getCallerContext(), r126, r125);
        goto L38
    L32:
        if (r124.getSize() == null) goto L36;
        Pair<Integer, Integer> r127 = r124.getSize();
        if (r127 == null) goto L36;
        r126 = ((Integer) r127.first).intValue();
        r125 = ((Integer) r127.second).intValue();
        goto L37
    L20:
        r103 = null;
        goto L21
    L8:
        if (r101.canRequestUrl(r210.getUri()) == true) goto L17;
        Throwable r128 = new ExpiredUrlException("The expired url does not request network");     // Catch: Throwable -> L14
        if (r211 == null) goto L12;
        r211.onFailure(r128);     // Catch: Throwable -> L14
    L12:
        handleException(null, r210, r128, null);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    }

    private void handleFetchState(SsResponse<TypedInput> r110, String r111, TTNetFetchState r112) {
        String r100 = "";
        r112.hitCdnCache = "0";
        List<Header> r101 = getCdnCacheHeaders(r110);
        boolean r102 = true;
        if (CollectionUtils.isEmpty(r101) == true) goto L23;
        Iterator<Header> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L48;
        Header r104 = r103.next();
        if (r104 == null) goto L6;
        String r105 = r104.getValue();
        if (TextUtils.isEmpty(r105) == true) goto L14;
        if (r105.toLowerCase(Locale.US).contains(BaseHttpRequestInfo.KEY_HIT) == false) goto L14;
    L19:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L6;
        r112.hitCdnCache = "1";
    L14:
        if ("Via".equals(r104.getName()) == true) goto L16;
    L20:
        r106 = false;
        goto L21
    L16:
        if ("cHs f".equals(r105) == true) goto L19;
        if ("cRs f".equals(r105) == false) goto L20;
    L48:
        Header r107 = r110.raw().getFirstHeader(FrescoMonitorConst.RESPONSE_HEADER_X_RESPONSE_CACHE);     // Catch: Exception -> L34
        if (r107 == null) goto L27;
        r112.xResponseCache = r107.getValue();     // Catch: Exception -> L34
    L28:
        String r108 = getHeaderForName(r110.headers(), "X-Crop-Rs");     // Catch: Exception -> L34
        if (TextUtils.isEmpty(r108) == true) goto L37;
        String r109 = r108.replace("(", "").replace(")", "").replace("-", ",").replace(",", " ");     // Catch: Exception -> L34
        if (checkXCropRs(Rect.unflattenFromString(r109)) == false) goto L37;
        HashMap r113 = new HashMap();     // Catch: Exception -> L34
        r113.put("regionToDecode", r109);     // Catch: Exception -> L34
        r112.setEncodeImageExtraInfo(r113);     // Catch: Exception -> L34
    L37:
        if (TextUtils.isEmpty(r111) == false) goto L39;
    L41:
        r102 = false;
    L42:
        r112.setNeedMd5(r102);
        handleDemotion(r110, r112);
        String r114 = getHeaderForName(r110.headers(), "x-imagex-extra");
        if (r114 == null) goto L46;
        r100 = r114;
    L46:
        r112.xImageXExtra = r100;
        return;
    L39:
        if (RetryInterceptManager.inst().isMd5Open() == false) goto L41;
    L27:
        r112.xResponseCache = "undefined";     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L23:
        r112.hitCdnCache = "-1";
        goto L48
    }

    private void handleRequest(TTNetFetchState r100, boolean r110, long r111) {
        if (getImageRequestOrder(r100) != 1) goto L6;
        ImageStrategy.getInstance().handleImageRequest(r100.getUri().toString(), r110, r111, true);
        return;
    L6:
        if (getImageRequestOrder(r100) != 0) goto L10;
        ImageStrategy.getInstance().handleImageRequest(r100.getUri().toString(), r110, r111, false);
        return;
    }

    public static /* synthetic */ void access$100(FrescoTTNetFetcher r100, SsResponse r101, String r102, TTNetFetchState r103) {
        r100.handleFetchState(r101, r102, r103);
    }

    public static /* synthetic */ void access$200(BaseHttpRequestInfo r100, List r101, RequestContext r102, Exception r103) {
        getOutIp(r100, r101, r102, r103);
    }

    public static /* synthetic */ void access$600(FrescoTTNetFetcher r100, TTNetFetchState r101, boolean r102, long r103) {
        r100.handleRequest(r101, r102, r103);
    }

    public static /* synthetic */ void access$700(FrescoTTNetFetcher r100, TTNetFetchState r101, NetworkFetcher.Callback r102, boolean r103) {
        r100.fetchWithTtnet(r101, r102, r103);
    }

    private static void getOutIp(BaseHttpRequestInfo r100, List<Header> r101, RequestContext r102, Exception r103) {
        if (r100 != null) goto L34;
        return;
    L34:
    L31:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (StringUtils.isEmpty(r100.remoteIp) == true) goto L7;
        return;
    L7:
        String r104 = null;
        if (r101 == null) goto L18;
        if (r101.size() <= 0) goto L18;
        Iterator<Header> r105 = r101.iterator();     // Catch: Throwable -> L31
    L13:
        if (r105.hasNext() == false) goto L18;
        Header r106 = r105.next();     // Catch: Throwable -> L31
        if ("x-snssdk.remoteaddr".equalsIgnoreCase(r106.getName()) == false) goto L13;
        r104 = r106.getValue();     // Catch: Throwable -> L31
    L18:
        if (StringUtils.isEmpty(r104) == false) goto L22;
        if (r102 == null) goto L22;
        r104 = r102.remoteIp;     // Catch: Throwable -> L31
    L22:
        if (StringUtils.isEmpty(r104) == false) goto L25;
        r104 = getHostAddress(r103);     // Catch: Throwable -> L31
    L25:
        if (StringUtils.isEmpty(r104) == false) goto L27;
        return;
    L27:
        r100.remoteIp = r104;     // Catch: Throwable -> L31
        T r107 = r100.reqContext;     // Catch: Throwable -> L31
        if (r107 == 0) goto L41;
        r107.remoteIp = r104;     // Catch: Throwable -> L31
        return;
    }

    private void handleException(SsResponse r110, TTNetFetchState r111, Throwable r112, HttpRequestInfo r113) {
        if (r111 == null) goto L25;
        long r100 = r111.submitTime;     // Catch: Throwable -> L20
        long r101 = r111.fetchCompleteTime - r100;     // Catch: Throwable -> L20
        if (r101 > 0) goto L7;
        r101 = System.currentTimeMillis() - r111.submitTime;     // Catch: Throwable -> L20
    L7:
        long r102 = r101;
        String r103 = null;
        if (StringUtils.isEmpty(null) == false) goto L13;
        if (r110 == null) goto L11;
        r103 = r110.raw().getUrl();     // Catch: Throwable -> L20
        goto L13
    L11:
        r103 = r111.getUri().toString();     // Catch: Throwable -> L20
    L13:
        if (Logger.debug() == false) goto L16;
        if (r112 == null) goto L16;
        Logger.d(TAG, "exception for ttnet response url = " + r103 + " exception = " + r112.toString());     // Catch: Throwable -> L20
    L16:
        handleRequest(r111, false, r102);     // Catch: Throwable -> L20
        ResponseWrap r104 = new ResponseWrap();     // Catch: Throwable -> L20
        r104.ssResponse = r110;     // Catch: Throwable -> L20
        r104.url = r103;     // Catch: Throwable -> L20
        if (sImageCallBack == null) goto L26;
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L20
        r105.put("requestId", r111.getId());     // Catch: Throwable -> L20
        r105.put(DBDefinition.RETRY_COUNT, r111.retryCount);     // Catch: Throwable -> L20
        r105.put(BdpAppEventConstant.HTTP_STATUS, getErrorCode(r112));     // Catch: Throwable -> L20
        sImageCallBack.onImageErrorCallBack(r102, r100, r104, r113, r112, r105);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static /* synthetic */ void access$900(FrescoTTNetFetcher r100, SsResponse r101, TTNetFetchState r102, Throwable r103, HttpRequestInfo r104) {
        r100.handleException(r101, r102, r103, r104);
    }

    public void checkLegal(TTNetFetchState r100, String r101, boolean r102, List<Header> r103, long r104) {
        if (r102 == false) goto L37;
        return;
    L37:
        long r105 = Long.parseLong(getHeaderForName(r103, HEADER_LENGTH));     // Catch: Exception -> L7
    L9:
        if (r105 != (-1)) goto L11;
    L19:
        String r106 = getHeaderForName(r103, "Content-Type");
        if (TextUtils.isEmpty(r106) == true) goto L24;
        if (r106.contains("image") == false) goto L24;
    L25:
        String r107 = r100.getMd5();
        if (TextUtils.isEmpty(r101) == false) goto L28;
        return;
    L28:
        if (TextUtils.isEmpty(r107) == false) goto L30;
        return;
    L30:
        if (r101.equals(r107) == false) goto L33;
        return;
    L33:
        throw new RetryHttpsException("MD5 does not match！！");
    L24:
        if (RetryInterceptManager.inst().isContentTypeOpen() == false) goto L25;
        throw new RetryHttpsException("content-type does not match！！");
    L11:
        if (r104 == (-1)) goto L19;
        if (r105 == r104) goto L19;
        if (RetryInterceptManager.inst().isContentLengthOpen() == false) goto L19;
        throw new RetryHttpsException("content-length does not match！！");
    L7:
        r105 = -1;
        goto L9
    }

    public void fetchSimpleWithTtnet(final SimpleNetFetchState r110, final Map<String, String> r111, final Priority r112, final NetworkFetcher.Callback r113, final boolean r114) {
        Uri r100 = r110.getUri();
        if (r100 != null) goto L5;
        return;
    L5:
        FetcherInterceptorProvider r101 = sFetcherInterceptorProvider;
        if (r101 == null) goto L8;
        FetcherInterceptor r102 = r101.getInterceptor();
    L9:
        final FetcherInterceptor r103 = r102;
        String r104 = r100.toString();
        if (r103 == null) goto L13;
        r104 = r103.intercepterUrl(r104);
    L13:
        if (StringUtils.isEmpty(r104) == false) goto L42;
        return;
    L42:
        Map<String, String> r105 = new LinkedHashMap();     // Catch: Exception -> L38
        Pair<String, String> r106 = UrlUtils.parseUrl(r104, r105);     // Catch: Exception -> L38
        String r107 = handleHttps((String) r106.first, r114);     // Catch: Exception -> L36
        String r108 = (String) r106.second;     // Catch: Exception -> L36
        if (RetryInterceptManager.inst().isOpen() == false) goto L20;
        IDownloadImage r109 = (IDownloadImage) RetryInterceptManager.inst().getRetrofitService(r107, IDownloadImage.class);     // Catch: Exception -> L36
    L21:
        IDownloadImage r115 = r109;
        RequestContext r116 = new FrescoRequestContext(r110.getBackUris(), r110.getRetryCount());     // Catch: Exception -> L36
        LinkedList r117 = new LinkedList();     // Catch: Exception -> L36
        if (r111 == null) goto L27;
        Iterator<Map.Entry<String, String>> r118 = r111.entrySet().iterator();     // Catch: Exception -> L36
    L25:
        if (r118.hasNext() == false) goto L27;
        Map.Entry<String, String> r119 = r118.next();     // Catch: Exception -> L36
        r117.add(new Header(r119.getKey(), r119.getValue()));     // Catch: Exception -> L36
    L27:
        if (r115 == null) goto L47;
        Call<TypedInput> r120 = dealAndGetSimpleCall(r105, r108, r115, r116, r117, r112);     // Catch: Exception -> L36
        NetworkParams.CdnConnectionQualitySamplerHook r121 = NetworkParams.getCdnConnectionQualitySamplerHook();     // Catch: Exception -> L36
        if (r121 != null) goto L31;
    L33:
        final boolean r122 = false;
    L34:
        r120.enqueue(new AnonymousClass2(this, r103, r113, r122, r110, r111, r112, r114));     // Catch: Exception -> L36
        return;
    L31:
        if (r121.cdnShouldSampling(r104) == false) goto L33;
        CdnDeviceBandwidthSampler.getInstance().startSampling();     // Catch: Exception -> L36
        r122 = true;
        goto L34
    L47:
        return;
    L20:
        r109 = (IDownloadImage) RetrofitUtils.createSsService(r107, IDownloadImage.class);     // Catch: Exception -> L36
    L36:
        e = e;
    L40:
        e.printStackTrace();
        return;
    L38:
        e = e;
        goto L40
    L8:
        r102 = null;
        goto L9
    }

    public Call<TypedInput> dealAndGetCall(Map<String, String> r110, String r111, IDownloadImage r112, RequestContext r113, List<Header> r114, TTNetFetchState r115) {
        if (r115 != null) goto L4;
    L8:
        boolean r100 = false;
    L10:
        if (this.mEnableNetworkPriority == true) goto L15;
        if (r100 == true) goto L15;
        return r112.downloadFileForNormal(false, -1, r111, r110, r114, r113);
    L15:
        int r116 = AnonymousClass4.$SwitchMap$com$facebook$imagepipeline$common$Priority[r115.getContext().getPriority().ordinal()];
        if (r116 == 1) goto L32;
        if (r116 == 2) goto L30;
        if (r116 == 3) goto L28;
        if (r116 == 4) goto L26;
        return r112.downloadFileForNormal(false, -1, r111, r110, r114, r113);
    L26:
        return r112.downloadFileForImmediate(false, -1, r111, r110, r114, r113);
    L28:
        return r112.downloadFileForHigh(false, -1, r111, r110, r114, r113);
    L30:
        return r112.downloadFileForNormal(false, -1, r111, r110, r114, r113);
    L32:
        return r112.downloadFileForLow(false, -1, r111, r110, r114, r113);
    L4:
        if (r115.getContext() == null) goto L8;
        if (r115.getContext().getImageRequest() == null) goto L8;
        r100 = r115.getContext().getImageRequest().isEnableNetworkPriority();
        goto L10
    }

    public Call<TypedInput> dealAndGetSimpleCall(Map<String, String> r100, String r110, IDownloadImage r111, RequestContext r112, List<Header> r113, Priority r114) {
        if (this.mEnableNetworkPriority == false) goto L23;
        int r115 = AnonymousClass4.$SwitchMap$com$facebook$imagepipeline$common$Priority[r114.ordinal()];
        if (r115 == 1) goto L21;
        if (r115 == 2) goto L19;
        if (r115 == 3) goto L17;
        if (r115 == 4) goto L15;
        return r111.downloadFileForNormal(false, -1, r110, r100, r113, r112);
    L15:
        return r111.downloadFileForImmediate(false, -1, r110, r100, r113, r112);
    L17:
        return r111.downloadFileForHigh(false, -1, r110, r100, r113, r112);
    L19:
        return r111.downloadFileForNormal(false, -1, r110, r100, r113, r112);
    L21:
        return r111.downloadFileForLow(false, -1, r110, r100, r113, r112);
    L23:
        return r111.downloadFileForNormal(false, -1, r110, r100, r113, r112);
    }
}
