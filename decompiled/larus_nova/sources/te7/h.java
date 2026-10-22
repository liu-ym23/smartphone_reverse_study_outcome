package te7;

import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.sdk.xbridge.cn.runtime.api.IHostNetworkRuntimeApi;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.bytedance.sdk.xbridge.cn.runtime.network.RequestMethod;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f545610a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f545611a = null;

        static {
            int[] r100 = new int[RequestMethod.values().length];
            r100[RequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[RequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[RequestMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[RequestMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[RequestMethod.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f545611a = r100;
        }
    }

    static {
        f545610a = new h();
    }

    public h() {
    }

    public static Triple a(se7.c r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Pair<String, String> r102 = UrlUtils.parseUrl(new UrlBuilder(r100.f541605a).build(), r101);
        return new Triple((String) r102.first, (String) r102.second, r101);
    }

    public static List b(se7.c r100) {
        ArrayList r101 = new ArrayList();
        LinkedHashMap<String, String> r102 = r100.f541606b;
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        r101.add(new Header(r104.getKey(), r104.getValue()));
    L8:
        String r105 = r100.f541610f;
        if (r105 == null) goto L11;
        r101.add(new Header("Content-Type", r105));
    L11:
        return r101;
    }

    public static int c(String r110) {
        if (r110 != null) goto L13;
        return 0;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        int r101 = StringsKt.lastIndexOf$default(r110, "InternalErrorCode=", 0, false, 4, null);     // Catch: Throwable -> L7
        return CastIntegerProtector.parseInt(r110.substring(r101 + 18, StringsKt.indexOf$default(r110, ',', r101, false, 4, null)));
    L7:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == false) goto L12;
        r111 = 0;
    L12:
        return ((Number) r111).intValue();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.bytedance.retrofit2.mime.TypedByteArray] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.bytedance.retrofit2.mime.MultipartTypedOutput] */
    public static TypedOutput d(se7.c r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        LinkedHashMap<String, File> r102 = r100.f541614j;
        if (r102 != null) goto L5;
    L20:
        byte[] r103 = r100.f541609e;
        if (r103 == null) goto L24;
        r101.element = new TypedByteArray(r100.f541610f, r103, new String[0]);
    L24:
        return (TypedOutput) r101.element;
    L5:
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L20;
        ?? r104 = new MultipartTypedOutput();
        Map<String, String> r105 = r100.f541608d;
        if (r105 == null) goto L15;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        Map.Entry<String, String> r107 = r106.next();
        r104.addPart(r107.getKey(), new TypedString(r107.getValue()));
    L15:
        Iterator<Map.Entry<String, File>> r108 = r102.entrySet().iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        Map.Entry<String, File> r109 = r108.next();
        String r110 = r109.getKey();
        File r111 = r109.getValue();
        h r112 = f545610a;
        String r113 = r111.getPath();
        r112.getClass();
        r104.addPart(r110, new TypedFile(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(r113)), r111));
        goto L17
    L19:
        r101.element = r104;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.ref.WeakReference] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v22, types: [T, java.lang.String] */
    public static i e(RequestMethod r210, se7.c r211, IHostNetworkDepend r212) {
        Intrinsics.checkNotNullParameter(r210, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r211, "request");
        Intrinsics.checkNotNullParameter(r212, "hostNetworkDepend");
        LinkedHashMap r100 = new LinkedHashMap();
        Ref.IntRef r101 = new Ref.IntRef();
        r101.element = -1;
        Ref.IntRef r110 = new Ref.IntRef();
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = "";
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        Triple r112 = a(r211);     // Catch: Throwable -> L56
        String r113 = (String) r112.getFirst();     // Catch: Throwable -> L56
        String r114 = (String) r112.getSecond();     // Catch: Throwable -> L56
        LinkedHashMap r115 = (LinkedHashMap) r112.getThird();     // Catch: Throwable -> L56
        List<Header> r213 = b(r211);     // Catch: Throwable -> L56
        RequestContext r116 = new RequestContext();     // Catch: Throwable -> L56
        r116.timeout_connect = r211.f541611g;     // Catch: Throwable -> L56
        r116.timeout_read = r211.f541612h;     // Catch: Throwable -> L56
        r116.timeout_write = r211.f541613i;     // Catch: Throwable -> L56
        r116.force_handle_response = !r211.f541607c;     // Catch: Throwable -> L56
        LinkedHashMap r117 = new LinkedHashMap();     // Catch: Throwable -> L56
        r117.put("isCustomizedCookie", Boolean.valueOf(r211.f541615k));     // Catch: Throwable -> L56
        r117.put("needAddCommonParams", Boolean.valueOf(r211.f541607c));     // Catch: Throwable -> L56
        Unit r214 = null;
        if ((r212 instanceof com.bytedance.sdk.xbridge.cn.runtime.depend.f) == false) goto L8;
        XIRetrofit r105 = ((com.bytedance.sdk.xbridge.cn.runtime.depend.f) r212).createRetrofit(r113, false, r117);     // Catch: Throwable -> L56
        if (r105 == null) goto L11;
        IHostNetworkRuntimeApi r106 = (IHostNetworkRuntimeApi) r105.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L56
    L12:
        int r107 = a.f545611a[r210.ordinal()];     // Catch: Throwable -> L56
        if (r107 != 1) goto L15;
        int r108 = 0;
        if (r106 == null) goto L28;
        Call<TypedInput> r109 = r106.doGetForStream(r211.f541607c, -1, r114, r115, r213, r116);     // Catch: Throwable -> L56
    L29:
        if (r109 == null) goto L53;
        r101.element = r108;     // Catch: Throwable -> L56
        r111.element = new WeakReference(r109);     // Catch: Throwable -> L56
        SsResponse<TypedInput> r118 = r109.execute();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        if (r118 == null) goto L53;
        r101.element = r118.code();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        TypedInput r119 = r118.body();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        if (r119 == null) goto L37;
        T r120 = r119.in();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
    L38:
        r102.element = r120;     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        List<Header> r121 = r118.headers();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        if (r121 == null) goto L53;
        Iterator<Header> r122 = r121.iterator();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
    L42:
        if (r122.hasNext() == false) goto L47;
        Header r123 = r122.next();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        String r124 = r123.getName();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        String r125 = r123.getValue();     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        if (r125 != null) goto L46;
        r125 = "";
    L46:
        r100.put(r124, r125);     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
        goto L42
    L47:
        Unit r126 = Unit.INSTANCE;     // Catch: CronetIOException -> L49 HttpResponseException -> L51 Throwable -> L56
    L48:
        r214 = r126;
        goto L53
    L37:
        r120 = 0;
    L49:
        e = move-exception;
        r103.element = e.getClass().toString() + ':' + e.getMessage() + ",-1";     // Catch: Throwable -> L56
        r101.element = e.getStatusCode();     // Catch: Throwable -> L56
        h r127 = f545610a;     // Catch: Throwable -> L56
        String r128 = e.getMessage();     // Catch: Throwable -> L56
        r127.getClass();     // Catch: Throwable -> L56
        r110.element = c(r128);     // Catch: Throwable -> L56
        r104.element = e;     // Catch: Throwable -> L56
        r126 = Unit.INSTANCE;     // Catch: Throwable -> L56
    L51:
        e = move-exception;
        r103.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L56
        r101.element = e.getStatusCode();     // Catch: Throwable -> L56
        h r129 = f545610a;     // Catch: Throwable -> L56
        String r130 = e.getMessage();     // Catch: Throwable -> L56
        r129.getClass();     // Catch: Throwable -> L56
        r110.element = c(r130);     // Catch: Throwable -> L56
        r104.element = e;     // Catch: Throwable -> L56
        r126 = Unit.INSTANCE;     // Catch: Throwable -> L56
    L53:
        if (r214 != null) goto L59;
        ?? r131 = "call is null, method is " + r210.name();     // Catch: Throwable -> L56
        r103.element = r131;     // Catch: Throwable -> L56
        Logger.d("HostNetworkDependImpl", r131);     // Catch: Throwable -> L56
    L59:
        return new i(r100, r101, r102, r103, r104, r110, r111);
    L28:
        r109 = null;
        goto L29
    L15:
        if (r107 != 2) goto L17;
        r108 = 0;
        TypedOutput r215 = d(r211);     // Catch: Throwable -> L56
        if (r215 == null) goto L28;
        if (r106 == null) goto L28;
        r109 = r106.doPostForStream(r211.f541607c, -1, r114, r115, r213, r215, r116);     // Catch: Throwable -> L56
        goto L29
    L17:
        if (r107 == 5) goto L19;
    L18:
        r108 = 0;
        goto L28
    L19:
        if (r106 == null) goto L18;
        r108 = 0;
        r109 = r106.downloadFile(r211.f541607c, -1, r114, r115, r213, r116);     // Catch: Throwable -> L56
    L11:
        r106 = null;
        goto L12
    L8:
        XIRetrofit r132 = r212.createRetrofit(r113, false);     // Catch: Throwable -> L56
        if (r132 == null) goto L11;
        r106 = (IHostNetworkRuntimeApi) r132.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        r103.element = "request for string cause exception";
        r104.element = th;
        Logger.e("HostNetworkDependImpl", (String) r103.element, th);
        goto L59
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException, com.bytedance.retrofit2.ttnet.TTNetExceptionStorage, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v38, types: [T, com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException, java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r11v1, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r11v16, types: [T] */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlin.jvm.internal.Ref$IntRef] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v22, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static j f(RequestMethod r210, se7.c r310, IHostNetworkDepend r311) {
        Object r100 = OkHttpEventListener.X_TT_TRACE_ID;
        ?? r101 = NetResponse.HEADER_KEY_LOG_ID;
        Intrinsics.checkNotNullParameter(r210, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r310, "request");
        Intrinsics.checkNotNullParameter(r311, "hostNetworkDepend");
        LinkedHashMap r102 = new LinkedHashMap();
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = -1;
        Ref.IntRef r110 = new Ref.IntRef();
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = "";
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        Triple r113 = a(r310);     // Catch: Throwable -> L150
        String r114 = (String) r113.getFirst();     // Catch: Throwable -> L150
        String r115 = (String) r113.getSecond();     // Catch: Throwable -> L150
        LinkedHashMap r116 = (LinkedHashMap) r113.getThird();     // Catch: Throwable -> L150
        List<Header> r211 = b(r310);     // Catch: Throwable -> L150
        RequestContext r105 = new RequestContext();     // Catch: Throwable -> L150
        r105.timeout_connect = r310.f541611g;     // Catch: Throwable -> L148
        r105.timeout_read = r310.f541612h;     // Catch: Throwable -> L148
        r105.timeout_write = r310.f541613i;     // Catch: Throwable -> L148
        r105.force_handle_response = !r310.f541607c;     // Catch: Throwable -> L148
        LinkedHashMap r117 = new LinkedHashMap();     // Catch: Throwable -> L148
        r117.put("isCustomizedCookie", Boolean.valueOf(r310.f541615k));     // Catch: Throwable -> L145
        r117.put("needAddCommonParams", Boolean.valueOf(r310.f541607c));     // Catch: Throwable -> L145
        boolean r118 = false;
        Object r212 = null;
        if ((r311 instanceof com.bytedance.sdk.xbridge.cn.runtime.depend.f) == false) goto L12;
        XIRetrofit r106 = ((com.bytedance.sdk.xbridge.cn.runtime.depend.f) r311).createRetrofit(r114, false, r117);     // Catch: Throwable -> L145
        if (r106 == null) goto L15;
        IHostNetworkRuntimeApi r107 = (IHostNetworkRuntimeApi) r106.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L145
    L16:
        int r108 = a.f545611a[r210.ordinal()];     // Catch: Throwable -> L145
        if (r108 != 1) goto L19;
        if (r107 == null) goto L53;
        Call<String> r109 = r107.doGetForString(r310.f541607c, r310.f541616l, r115, r116, r211, r105);     // Catch: Throwable -> L145
    L166:
        if (r109 == null) goto L135;
        r103.element = 0;     // Catch: Throwable -> L145
        SsResponse<String> r119 = r109.execute();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        if (r119 == null) goto L135;
        r103.element = r119.code();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        String r120 = r119.body();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        ?? r121 = r120;
        if (r120 != null) goto L65;
        int r122 = d.f545588a;     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        TypedInput r123 = r119.errorBody();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        if (r123 != null) goto L64;
        r123 = r119.raw().getBody();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
    L64:
        r121 = d.a(r123);     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
    L65:
        r104.element = r121;     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        List<Header> r124 = r119.headers();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        if (r124 == null) goto L135;
        Iterator<Header> r125 = r124.iterator();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
    L69:
        if (r125.hasNext() == false) goto L87;
        Header r126 = r125.next();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        if (r310.f541615k == false) goto L83;
        if (Intrinsics.areEqual(r126.getName(), "set-cookie") == true) goto L77;
        if (Intrinsics.areEqual(r126.getName(), "Set-Cookie") == false) goto L83;
    L77:
        if (r102.containsKey(r126.getName()) == true) goto L78;
        String r127 = r126.getName();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        String r128 = r126.getValue();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        if (r128 != null) goto L82;
        r128 = "";
    L82:
        r102.put(r127, r128);     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        goto L69
    L78:
        String r129 = r126.getName();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        r102.put(r129, ((String) r102.get(r129)) + ", " + r126.getValue());     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
    L83:
        String r130 = r126.getName();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        String r131 = r126.getValue();     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        if (r131 != null) goto L86;
        r131 = "";
    L86:
        r102.put(r130, r131);     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        goto L69
    L87:
        r212 = Unit.INSTANCE;     // Catch: CronetIOException -> L89 NetworkNotAvailabeException -> L130 HttpResponseException -> L133 Throwable -> L145
        goto L135
    L130:
        e = move-exception;
        Object r132 = r110;
        Ref.ObjectRef r133 = r112;
        r111.element = e.getClass().toString() + ':' + e.getMessage() + ",-1001";     // Catch: Throwable -> L143
        r103.element = -1001;     // Catch: Throwable -> L143
        r133.element = e;     // Catch: Throwable -> L143
        Unit r134 = Unit.INSTANCE;     // Catch: Throwable -> L143
        Ref.ObjectRef r135 = r133;
    L132:
        r212 = r134;
        r100 = r132;
        r101 = r135;
    L136:
        if (r212 != null) goto L154;
        ?? r136 = "call is null, method is " + r210.name();     // Catch: Throwable -> L143
        r111.element = r136;     // Catch: Throwable -> L143
        String r137 = "HostNetworkDependImpl";
        Logger.d(r137, r136);     // Catch: Throwable -> L141
    L141:
        th = th;
    L152:
        r111.element = "request for string cause exception";
        r101.element = th;
        Logger.e(r137, (String) r111.element, th);
    L154:
        return new j(r102, r103, r104, r111, r101, r100);
    L89:
        e = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L118
        Object r139 = e.infoObj;     // Catch: Throwable -> L118
        if ((r139 instanceof HttpRequestInfo) == false) goto L94;
        HttpRequestInfo r140 = (HttpRequestInfo) r139;     // Catch: Throwable -> L118
    L95:
        if (r140 == null) goto L116;
        String r141 = r140.responseHeaders;     // Catch: Throwable -> L118
        if (r141 == null) goto L116;
        JSONObject r142 = new JSONObject(r141);     // Catch: Throwable -> L118
        String r143 = r142.optString(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L118
        if (r143 == "") goto L101;
        boolean r144 = true;
    L102:
        if (r144 == true) goto L105;
        r143 = null;
    L105:
        if (r143 == null) goto L107;
        r102.put(NetResponse.HEADER_KEY_LOG_ID, r143);     // Catch: Throwable -> L118
    L107:
        String r145 = r142.optString(OkHttpEventListener.X_TT_TRACE_ID);     // Catch: Throwable -> L118
        if (r145 == "") goto L110;
        r118 = true;
    L110:
        if (r118 == true) goto L113;
        r145 = null;
    L113:
        if (r145 == null) goto L115;
        r102.put(OkHttpEventListener.X_TT_TRACE_ID, r145);     // Catch: Throwable -> L118
    L115:
        r212 = r142;
        goto L116
    L101:
        r144 = false;
    L116:
        Result.m9449constructorimpl(r212);     // Catch: Throwable -> L118
    L120:
        r111.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L145
        h r146 = f545610a;     // Catch: Throwable -> L145
        String r147 = e.getMessage();     // Catch: Throwable -> L145
        r146.getClass();     // Catch: Throwable -> L128
        int r148 = c(r147);     // Catch: Throwable -> L128
        Ref.IntRef r149 = r110;
        r149.element = r148;     // Catch: Throwable -> L126
        r103.element = e.getStatusCode();     // Catch: Throwable -> L126
        Ref.ObjectRef r150 = r112;
        r150.element = e;     // Catch: Throwable -> L143
        r134 = Unit.INSTANCE;     // Catch: Throwable -> L143
        r132 = r149;
        r135 = r150;
    L126:
        th = move-exception;
        th = th;
        r100 = r149;
    L147:
        r101 = r112;
    L144:
        r137 = "HostNetworkDependImpl";
    L128:
        th = move-exception;
        r100 = r110;
        th = th;
        goto L147
    L94:
        r140 = null;
    L118:
        th = move-exception;
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L145
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L145
    L133:
        e = move-exception;
        Ref.IntRef r152 = r110;
        Ref.ObjectRef r153 = r112;
        r111.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L143
        h r154 = f545610a;     // Catch: Throwable -> L143
        String r155 = e.getMessage();     // Catch: Throwable -> L143
        r154.getClass();     // Catch: Throwable -> L143
        r152.element = c(r155);     // Catch: Throwable -> L143
        r103.element = e.getStatusCode();     // Catch: Throwable -> L143
        r153.element = e;     // Catch: Throwable -> L143
        r134 = Unit.INSTANCE;     // Catch: Throwable -> L143
        r132 = r152;
        r135 = r153;
    L135:
        r100 = r110;
        r101 = r112;
    L143:
        th = th;
    L53:
        r109 = null;
        goto L166
    L19:
        if (r108 != 2) goto L21;
        TypedOutput r213 = d(r310);     // Catch: Throwable -> L145
        if (r213 == null) goto L49;
        if (r107 == null) goto L45;
        Call<String> r156 = r107.doPostForString(r310.f541607c, r310.f541616l, r115, r116, r211, r213, r105);     // Catch: Throwable -> L145
    L46:
        if (r156 == null) goto L49;
        r109 = r156;
        goto L166
    L45:
        r156 = null;
    L49:
        if (r107 == null) goto L53;
        r109 = r107.doPostForString(r310.f541607c, r310.f541616l, r115, r116, r211, r310.f541608d, r105);     // Catch: Throwable -> L145
        goto L166
    L21:
        if (r108 != 3) goto L23;
        TypedOutput r214 = d(r310);     // Catch: Throwable -> L145
        if (r107 == null) goto L53;
        r109 = r107.doPutForString(r310.f541607c, r310.f541616l, r115, r211, r214, r105);     // Catch: Throwable -> L145
        goto L166
    L23:
        if (r108 != 4) goto L53;
        Map<String, Map<Class<?>, Object>> r157 = x26.a.f562251a;     // Catch: Throwable -> L145
        w26.g r158 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L145
        if (r158 == null) goto L32;
        w26.e r159 = (w26.e) r158.n0(w26.e.class);     // Catch: Throwable -> L145
        if (r159 == null) goto L32;
        Boolean r160 = r159.U();     // Catch: Throwable -> L145
        if (r160 == null) goto L32;
        boolean r161 = r160.booleanValue();     // Catch: Throwable -> L145
    L33:
        if (r161 == false) goto L36;
        if (r107 == null) goto L53;
        r109 = r107.doDeleteForStringWithQuery(r310.f541607c, r310.f541616l, r115, r116, r211, r105);     // Catch: Throwable -> L145
        goto L166
    L36:
        if (r107 == null) goto L53;
        r109 = r107.doDeleteForString(r310.f541607c, r310.f541616l, r115, r211, r105);     // Catch: Throwable -> L145
    L32:
        r161 = true;
    L15:
        r107 = null;
        goto L16
    L12:
        XIRetrofit r162 = r311.createRetrofit(r114, false);     // Catch: Throwable -> L145
        if (r162 == null) goto L15;
        r107 = (IHostNetworkRuntimeApi) r162.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L145
    L145:
        th = move-exception;
        r100 = r110;
        th = th;
    L148:
        th = th;
        r137 = "HostNetworkDependImpl";
        r100 = r110;
        r101 = r112;
    L150:
        th = th;
        r137 = "HostNetworkDependImpl";
        r101 = r112;
        r100 = r110;
        goto L152
    }
}
