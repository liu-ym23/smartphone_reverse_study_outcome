package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.parser.CacheControlParser;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.http.util.e;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
import qx5.b;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class RetrofitUtils {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String HNAME_CACHE_CONTROL = "Cache-Control";
    public static final String HNAME_ETAG = "ETag";
    public static final String HNAME_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HNAME_IF_NONE_MATCH = "If-None-Match";
    public static final String HNAME_LAST_MODIFIED = "Last-Modified";
    public static final int IO_TIMEOUT = 15000;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    private static final String TAG = "RetrofitUtils";
    private static volatile List<Interceptor> sDefaultInterceptorChain;
    private static volatile CopyOnWriteArrayList<Interceptor> sInterceptors;
    private static g<String, Retrofit> sOKRetrofitCache;
    private static g<String, Retrofit> sRetrofitCache;

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r102;
            $VALUES = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) a.a(CompressType.class, r100);
        }

        private CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public RetrofitUtils() {
    }

    private static void invalidateDefaultInterceptorChain() {
        sDefaultInterceptorChain = null;
    }

    static {
        sInterceptors = new CopyOnWriteArrayList();
        Retrofit.setCommonInterceptor(sInterceptors);
        sRetrofitCache = new g(10);
        sOKRetrofitCache = new g(10);
    }

    private static List<Interceptor> buildDefaultInterceptorChain() {
        if (sInterceptors != null) goto L5;
        int r100 = 0;
    L6:
        ArrayList r101 = new ArrayList(r100 + 2);
        r101.add(new SsInterceptor());
        if (r100 <= 0) goto L9;
        r101.addAll(sInterceptors);
    L9:
        r101.add(new b());
        return r101;
    L5:
        r100 = sInterceptors.size();
        goto L6
    }

    private static List<Interceptor> getDefaultInterceptorChain() {
        List<Interceptor> r100 = sDefaultInterceptorChain;
        if (r100 != null) goto L15;
        monitor-enter(RetrofitUtils.class);
        r100 = sDefaultInterceptorChain;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        r100 = buildDefaultInterceptorChain();     // Catch: Throwable -> L11
        sDefaultInterceptorChain = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(RetrofitUtils.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return new ArrayList(r100);
    }

    public static synchronized void addInterceptor(Interceptor r100) {
        monitor-enter(RetrofitUtils.class);
        if (r100 != null) goto L16;
        monitor-exit(RetrofitUtils.class);
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L8:
        if (sInterceptors.contains(r100) == true) goto L10;
        sInterceptors.add(r100);     // Catch: Throwable -> L13
        invalidateDefaultInterceptorChain();     // Catch: Throwable -> L13
    L10:
        TtnetUtil.safeAddInterceptorInRetrofitCache(sRetrofitCache, r100);     // Catch: Throwable -> L13
        TtnetUtil.safeAddInterceptorInRetrofitCache(sOKRetrofitCache, r100);     // Catch: Throwable -> L13
        monitor-exit(RetrofitUtils.class);
    }

    private static String buildBaseUrlKey(String r100) {
        URI r101 = l.b(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101.getScheme()) == false) goto L7;
        String r102 = "https";
    L8:
        String r103 = r101.getRawAuthority();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r103) == true) goto L18;
        return r102 + "://" + r103 + HTTP.URL_DEFAULT;
    L18:
        return null;
    L7:
        r102 = r101.getScheme();     // Catch: Throwable -> L12
    L12:
        Logger.w(TAG, "url invalid");
        return null;
    }

    public static long extractMaxAge(List<Header> r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        Header r101 = getFirstHeader(r100, "Cache-Control");
        if (r101 != null) goto L15;
        return -1;
    L15:
        CacheControlParser r102 = new CacheControlParser(r101.getValue());     // Catch: Exception -> L12
        String r103 = r102.f244762a.get(CacheControlParser.Directive.MAXAGE);     // Catch: Exception -> L12
        if (r103 == null) goto L17;
        return CastLongProtector.parseLong(r103);
    L17:
        return -1;
    L12:
        e = move-exception;
        Logger.w(TAG, "extract max-age exception: " + e);
        return -1;
    }

    private static Retrofit findRetrofitFromCache(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        g<String, Retrofit> r101 = sRetrofitCache;
        if (r101 == null) goto L18;
        Retrofit r102 = r101.b(r100);
        if (r102 == null) goto L11;
        return r102;
    L11:
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L13;
        String r103 = r100.substring(0, r100.length() - 1);
    L15:
        return sRetrofitCache.b(r103);
    L13:
        r103 = r100.concat(HTTP.URL_DEFAULT);
        goto L15
    L18:
        return null;
    L16:
        return null;
    }

    public static String getEtag(List<Header> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Header r101 = getFirstHeader(r100, "ETag");
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getValue();
    }

    public static String getHostAddress(Exception r100) {
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

    public static List<Interceptor> getInterceptorChainByUrl(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = buildBaseUrlKey(r100);
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r100 = r101;
    L10:
        Retrofit r102 = findRetrofitFromCache(r100);
        if (r102 == null) goto L18;
        List<Interceptor> r103 = r102.interceptors();
        if (r103 == null) goto L16;
        return r103;
    L16:
        return getDefaultInterceptorChain();
    L18:
        return getDefaultInterceptorChain();
    L5:
        return getDefaultInterceptorChain();
    }

    public static String getLastModified(List<Header> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Header r101 = getFirstHeader(r100, "Last-Modified");
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getValue();
    }

    public static synchronized Retrofit getOkRetrofit(String r100) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r101 = sOKRetrofitCache.b(r100);     // Catch: Throwable -> L16
        if (r101 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r101;
    L13:
        Retrofit r102 = createOkRetrofit(r100, null, null, null);     // Catch: Throwable -> L16
        sOKRetrofitCache.d(r100, r102);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r102;
    }

    public static synchronized Retrofit getSsRetrofit(String r100) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r101 = sRetrofitCache.b(r100);     // Catch: Throwable -> L16
        if (r101 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r101;
    L13:
        Retrofit r102 = createSsRetrofit(r100, null, null, null);     // Catch: Throwable -> L16
        sRetrofitCache.d(r100, r102);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r102;
    }

    public static Pair<String, String> parseContentType(String r100) {
        String r101 = null;
        if (r100 != null) goto L17;
        return null;
    L17:
        MimeType r102 = new MimeType(r100);     // Catch: Throwable -> L10
        String r103 = r102.getBaseType();     // Catch: Throwable -> L10
        r101 = r102.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r103, r101);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r103 = null;
        goto L12
    }

    public static synchronized void removeInterceptor(Interceptor r100) {
        monitor-enter(RetrofitUtils.class);
        if (r100 != null) goto L17;
        monitor-exit(RetrofitUtils.class);
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (sInterceptors.contains(r100) == true) goto L11;
        monitor-exit(RetrofitUtils.class);
        return;
    L11:
        sInterceptors.remove(r100);     // Catch: Throwable -> L14
        invalidateDefaultInterceptorChain();     // Catch: Throwable -> L14
        TtnetUtil.safeRemoveInterceptorInRetrofitCache(sRetrofitCache, r100);     // Catch: Throwable -> L14
        TtnetUtil.safeRemoveInterceptorInRetrofitCache(sOKRetrofitCache, r100);     // Catch: Throwable -> L14
        monitor-exit(RetrofitUtils.class);
    }

    public static void setTimeout(URLConnection r100) {
        if (r100 == null) goto L5;
        r100.setConnectTimeout(15000);
        r100.setReadTimeout(15000);
        return;
    }

    public static synchronized <S> S createOkService(String r100, Class<S> r101) {
        monitor-enter(RetrofitUtils.class);
        S r102 = (S) createService(getOkRetrofit(r100), r101);
        monitor-exit(RetrofitUtils.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S createService(Retrofit r100, Class<S> r101) {
        monitor-enter(RetrofitUtils.class);
        if (r100 != null) goto L14;
        monitor-exit(RetrofitUtils.class);
        return null;
    L14:
        S r102 = (S) r100.create(r101);
        monitor-exit(RetrofitUtils.class);
        return r102;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S createSsService(String r100, Class<S> r101) {
        monitor-enter(RetrofitUtils.class);
        S r102 = (S) createService(getSsRetrofit(r100), r101);
        monitor-exit(RetrofitUtils.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static Header getFirstHeader(List<Header> r100, String r101) {
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L13;
        Iterator<Header> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Header r103 = r102.next();
        if (r101.equalsIgnoreCase(r103.getName()) == false) goto L9;
        return r103;
    }

    public static String getHeaderValueIgnoreCase(List<Header> r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        Iterator<Header> r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L15;
        Header r103 = r102.next();
        if (r101.equalsIgnoreCase(r103.getName()) == false) goto L10;
        return r103.getValue();
    L15:
        return "";
    L23:
        return null;
    }

    public static Pair<byte[], String> tryCompressData(byte[] r100, CompressType r101) throws IOException {
        byte[] r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        int r103 = r100.length;
        if (CompressType.GZIP != r101) goto L19;
        if (r103 <= 128) goto L19;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r105 = new GZIPOutputStream(r104);
        r105.write(r100);     // Catch: Throwable -> L11
        r105.close();
        r102 = r104.toByteArray();
        String r106 = DownloadHelper.GZIP;
    L28:
        return new Pair(r102, r106);
    L11:
        th = move-exception;
        Logger.w(TAG, "compress with gzip exception: " + th);     // Catch: Throwable -> L15
        r105.close();
        return null;
    L15:
        th = move-exception;
        r105.close();
        throw th;
    L19:
        if (CompressType.DEFLATER != r101) goto L26;
        if (r103 <= 128) goto L26;
        ByteArrayOutputStream r107 = new ByteArrayOutputStream(8192);
        Deflater r108 = new Deflater();
        r108.setInput(r100);
        r108.finish();
        byte[] r109 = new byte[8192];
    L23:
        if (r108.finished() == true) goto L25;
        r107.write(r109, 0, r108.deflate(r109));
        goto L23
    L25:
        r108.end();
        r102 = r107.toByteArray();
        r106 = "deflate";
    L26:
        r106 = null;
        goto L28
    }

    public static void addCacheValidationHeaders(List<Header> r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L8;
        r100.add(new Header("If-None-Match", r101));
    L8:
        if (StringUtils.isEmpty(r102) == true) goto L11;
        r100.add(new Header("If-Modified-Since", r102));
        return;
    }

    public static synchronized Retrofit createSsRetrofit(String r100, List<Interceptor> r101, Converter.Factory r102) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r103 = createSsRetrofit(r100, r101, r102, null);     // Catch: Throwable -> L8
        monitor-exit(RetrofitUtils.class);
        return r103;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createOkRetrofit(String r100, List<Interceptor> r101, Converter.Factory r102, CallAdapter.Factory r103) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r104 = createRetrofit(r100, r101, r102, r103, new AnonymousClass4());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createSsRetrofit(String r100, List<Interceptor> r101, Converter.Factory r102, CallAdapter.Factory r103) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r104 = createRetrofit(r100, r101, r102, r103, new AnonymousClass2());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createTTNetRetrofit(String r100, List<Interceptor> r101, List<Converter.Factory> r102, List<CallAdapter.Factory> r103) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r104 = createRetrofit(r101, r102, r103, new AnonymousClass3(), r100);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createRetrofit(List<Interceptor> r100, List<Converter.Factory> r101, List<CallAdapter.Factory> r102, Client.Provider r103, String r104) {
        monitor-enter(RetrofitUtils.class);
        if (r103 == null) goto L56;
    L6:
        Retrofit.Builder r105 = new Retrofit.Builder().setEndpoint(r104).client(r103).httpExecutor(new SsHttpExecutor());     // Catch: Throwable -> L53
        if (r101 != null) goto L10;
        r101 = new ArrayList();     // Catch: Throwable -> L53
    L10:
        if (r101.isEmpty() == false) goto L12;
        r101.add(rx5.a.a());     // Catch: Throwable -> L53
    L12:
        Iterator<Converter.Factory> r106 = r101.iterator();     // Catch: Throwable -> L53
    L14:
        if (r106.hasNext() == false) goto L16;
        r105.addConverterFactory(r106.next());     // Catch: Throwable -> L53
        goto L14
    L16:
        if (r102 != null) goto L18;
    L23:
        LinkedList r107 = new LinkedList();     // Catch: Throwable -> L53
        if (r100 != null) goto L26;
    L38:
        boolean r108 = false;
    L39:
        if (r108 == true) goto L42;
        ListProtector.add(r107, 0, new SsInterceptor());     // Catch: Throwable -> L53
    L42:
        if (sInterceptors != null) goto L44;
    L46:
        r107.add(new b());     // Catch: Throwable -> L53
        Iterator r109 = r107.iterator();     // Catch: Throwable -> L53
    L48:
        if (r109.hasNext() == false) goto L50;
        r105.addInterceptor((Interceptor) r109.next());     // Catch: Throwable -> L53
        goto L48
    L50:
        Retrofit r110 = r105.build();     // Catch: Throwable -> L53
        monitor-exit(RetrofitUtils.class);
        return r110;
    L53:
        th = move-exception;
        throw th;
    L44:
        if (sInterceptors.size() <= 0) goto L46;
        r107.addAll(sInterceptors);     // Catch: Throwable -> L53
        goto L46
    L26:
        if (r100.size() <= 0) goto L38;
        Iterator<Interceptor> r111 = r100.iterator();     // Catch: Throwable -> L53
        r108 = false;
    L29:
        if (r111.hasNext() == false) goto L39;
        Interceptor r112 = r111.next();     // Catch: Throwable -> L53
        if ((r112 instanceof SsInterceptor) == true) goto L32;
        if ((r112 instanceof b) == true) goto L29;
    L37:
        r107.add(r112);     // Catch: Throwable -> L53
        goto L29
    L32:
        if (r108 == true) goto L29;
        r107.add(r112);     // Catch: Throwable -> L53
        r108 = true;
        goto L37
    L18:
        if (r102.isEmpty() == true) goto L23;
        Iterator<CallAdapter.Factory> r113 = r102.iterator();     // Catch: Throwable -> L53
    L21:
        if (r113.hasNext() == false) goto L23;
        r105.addCallAdapterFactory(r113.next());     // Catch: Throwable -> L53
        goto L21
    L56:
        r103 = new AnonymousClass5();     // Catch: Throwable -> L53
        goto L6
    }

    private static void getOutIp(BaseHttpRequestInfo r100, String[] r101, List<Header> r102, RequestContext r103, Exception r104) {
        String r105 = null;
        if (r102 == null) goto L13;
    L31:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r102.size() <= 0) goto L13;
        Iterator<Header> r106 = r102.iterator();     // Catch: Throwable -> L31
    L8:
        if (r106.hasNext() == false) goto L13;
        Header r107 = r106.next();     // Catch: Throwable -> L31
        if ("x-net-info.remoteaddr".equalsIgnoreCase(r107.getName()) == false) goto L8;
        r105 = r107.getValue();     // Catch: Throwable -> L31
    L13:
        if (StringUtils.isEmpty(r105) == false) goto L17;
        if (r103 == null) goto L17;
        r105 = r103.remoteIp;     // Catch: Throwable -> L31
    L17:
        if (StringUtils.isEmpty(r105) == false) goto L20;
        r105 = getHostAddress(r104);     // Catch: Throwable -> L31
    L20:
        if (StringUtils.isEmpty(r105) == false) goto L22;
        return;
    L22:
        if (r101 != null) goto L24;
    L26:
        if (r100 == null) goto L41;
        r100.remoteIp = r105;     // Catch: Throwable -> L31
        T r108 = r100.reqContext;     // Catch: Throwable -> L31
        if (r108 == 0) goto L42;
        r108.remoteIp = r105;     // Catch: Throwable -> L31
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if (r101.length <= 0) goto L26;
        r101[0] = r105;     // Catch: Throwable -> L31
        goto L26
    }

    public static synchronized Retrofit createRetrofit(String r100, List<Interceptor> r101, Converter.Factory r102, CallAdapter.Factory r103, Client.Provider r104) {
        monitor-enter(RetrofitUtils.class);
        ArrayList r105 = null;
        if (r102 != null) goto L17;
        ArrayList r106 = null;
    L10:
        if (r103 == null) goto L12;
        r105 = new ArrayList();     // Catch: Throwable -> L7
        r105.add(r103);     // Catch: Throwable -> L7
    L12:
        Retrofit r107 = createRetrofit(r101, r106, r105, r104, r100);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r107;
    L7:
        th = move-exception;
        throw th;
    L17:
        r106 = new ArrayList();     // Catch: Throwable -> L7
        r106.add(r102);     // Catch: Throwable -> L7
        goto L10
    }

    public static boolean downloadFile(int r210, final String r211, String r212, String r213, String r214, e<String> r310, String r311, j r312, List<Header> r313, String[] r314, int[] r315) throws Exception {
        boolean r100 = false;
        if (StringUtils.isEmpty(r211) == false) goto L5;
        return false;
    L5:
        Map<String, String> r110 = new LinkedHashMap();
        Pair<String, String> r101 = UrlUtils.parseUrl(r211, r110);
        if (r101 != null) goto L8;
        return false;
    L8:
        String r102 = (String) r101.first;
        String r103 = (String) r101.second;
        INetworkApi r104 = (INetworkApi) createSsService(r102, INetworkApi.class);
        RequestContext r105 = new RequestContext();
        if (r104 == null) goto L112;
        Call<TypedInput> r111 = null;
        List<Header> r112 = null;
        r112 = null;
        final Call<TypedInput> r106 = r104.downloadFile(false, r210, r103, r110, r313, r105);     // Catch: Throwable -> L94
    L92:
        th = th;
    L93:
        InputStream r113 = null;
        r111 = r106;
    L124:
    L101:
        th = move-exception;
        if (r100 == false) goto L129;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L129:
        StreamParser.safeClose(r113);     // Catch: Throwable -> L109
        if (r111 == null) goto L134;
        r111.cancel();     // Catch: Throwable -> L109
        throw th;
    L134:
        throw th;
    L109:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L97:
        if ((th instanceof Exception) == false) goto L100;
        throw th;     // Catch: Throwable -> L101
    L100:
        throw new Exception(th.getMessage(), th.getCause());     // Catch: Throwable -> L101
    L13:
        if (NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext()) == false) goto L122;
        BaseHttpRequestInfo r107 = BaseHttpRequestInfo.createHttpRequestInfo();     // Catch: Throwable -> L92
        NetworkParams.CdnConnectionQualitySamplerHook r108 = NetworkParams.getCdnConnectionQualitySamplerHook();     // Catch: Throwable -> L92
        if (r108 != null) goto L24;
    L27:
        boolean r109 = false;
    L128:
        SsResponse<TypedInput> r114 = r106.execute();     // Catch: Throwable -> L90
        if (r114 != null) goto L113;
        if (r109 == false) goto L126;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L126:
        StreamParser.safeClose(null);     // Catch: Throwable -> L34
        r106.cancel();     // Catch: Throwable -> L34
    L36:
        return false;
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L113:
        Object r115 = r114.raw().getExtraInfo();     // Catch: Exception -> L74 Throwable -> L90
        if ((r115 instanceof BaseHttpRequestInfo) == false) goto L40;
        r107 = (BaseHttpRequestInfo) r115;     // Catch: Exception -> L74 Throwable -> L90
    L40:
        TypedInput r116 = r114.body();     // Catch: Exception -> L74 Throwable -> L90
        if (r116 == null) goto L44;
        r113 = r116.in();     // Catch: Exception -> L74 Throwable -> L90
    L117:
        List<Header> r117 = r114.headers();     // Catch: Exception -> L72 Throwable -> L88
        getOutIp(r107, r314, r117, r105, null);     // Catch: Exception -> L70 Throwable -> L88
        int r118 = r114.code();     // Catch: Exception -> L70 Throwable -> L88
        if (r118 != 200) goto L64;
        if (r116 == null) goto L64;
        long r119 = r116.length();     // Catch: Exception -> L70 Throwable -> L88
        if (r315 != null) goto L52;
    L56:
        boolean r120 = StreamParser.stream2File(r113, r116.length(), new AnonymousClass1(r211, r106), r210, r212, r213, r214, r310, r311, r312);     // Catch: Exception -> L70 Throwable -> L88
        if (r109 == false) goto L115;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L115:
        StreamParser.safeClose(r113);     // Catch: Throwable -> L61
        r106.cancel();     // Catch: Throwable -> L61
    L63:
        return r120;
    L61:
        th = move-exception;
        th.printStackTrace();
        goto L63
    L52:
        if (r315.length <= 0) goto L56;
        r315[0] = 0;     // Catch: Exception -> L70 Throwable -> L88
        if (r119 > SieveCacheKt.NodeLinkMask) goto L56;
        r315[0] = (int) r119;     // Catch: Exception -> L70 Throwable -> L88
    L64:
        if (r118 != 200) goto L69;
        if (r116 != null) goto L69;
        throw new IllegalArgumentException("HTTP TypedInput may not be null");     // Catch: Exception -> L70 Throwable -> L88
    L69:
        throw new HttpResponseException(r118, "get url = " + r211 + " exception");     // Catch: Exception -> L70 Throwable -> L88
    L70:
        e = e;
        r112 = r117;
    L76:
        if (r107 == null) goto L78;
    L82:
        getOutIp(r107, r314, r112, r105, e);     // Catch: Throwable -> L88
        if (r107 == null) goto L87;
        JSONObject r121 = r107.extraInfo;     // Catch: Throwable -> L88
        if (r121 == null) goto L87;
        r121.put(BaseHttpRequestInfo.KEY_EXCEPTION, e.getMessage());     // Catch: Throwable -> L88
    L87:
        throw e;     // Catch: Throwable -> L88
    L78:
        if ((r106 instanceof IRequestInfo) == false) goto L82;
        Object r122 = ((IRequestInfo) r106).getRequestInfo();     // Catch: Throwable -> L88
        if ((r122 instanceof BaseHttpRequestInfo) == false) goto L82;
        r107 = (BaseHttpRequestInfo) r122;     // Catch: Throwable -> L88
    L72:
        e = e;
    L88:
        th = th;
        r111 = r106;
        r100 = r109;
        goto L124
    L44:
        r113 = null;
    L74:
        e = e;
    L90:
        th = th;
        r100 = r109;
        goto L93
    L24:
        if (r108.cdnShouldSampling(r211) == false) goto L27;
        CdnDeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L92
        r109 = true;
        goto L128
    L122:
        StreamParser.safeClose(null);     // Catch: Throwable -> L18
        if (r106 == null) goto L20;
        r106.cancel();     // Catch: Throwable -> L18
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
    L94:
        th = th;
        r113 = null;
        goto L124
    L112:
        return false;
    }
}
