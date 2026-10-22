package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.http.request.HttpParams;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpRequestBody;
import com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements com.ss.android.lark.security.compliance.infra.network.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f440465a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440466a = null;

        static {
            int[] r100 = new int[HttpMethod.values().length];
            r100[HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[HttpMethod.PATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[HttpMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f440466a = r100;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.e f440467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g f440468b;

        public c(com.ss.android.lark.security.compliance.infra.network.e r100, com.ss.android.lark.security.compliance.infra.network.g r101) {
            this.f440467a = r100;
            this.f440468b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            s r111 = (s) r110;
            Intrinsics.checkNotNullParameter(r111, "it");
            if ((r111 instanceof x) == false) goto L13;
            ScsLogger.d("RustFetcher", "queryBlockAction success.");
            x r112 = (x) r111;
            UserSendHttpResponse r100 = (UserSendHttpResponse) r112.f253935c;
            v4c.b r101 = new v4c.b(r100.status_code.intValue(), new String(r100.body.toByteArray(), Charsets.UTF_8));
            List<HttpHeader> r102 = r100.headers.headers;
            LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
            Iterator<T> r104 = r102.iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            HttpHeader r105 = (HttpHeader) r104.next();
            Pair r106 = TuplesKt.to(r105.name, r105.value);
            r103.put(r106.getFirst(), r106.getSecond());
            goto L6
        L8:
            r101.f553229c = r103;
            String r107 = (String) r103.get("set-cookie");
            if (r107 == null) goto L11;
            com.ss.android.lark.security.compliance.infra.network.g r108 = this.f440468b;
            int r109 = com.ss.android.lark.security.compliance.infra.network.b.f440441a;
            com.ss.android.lark.security.compliance.infra.network.b.b(r108.getUrl(), r107);
        L11:
            this.f440467a.b(r101);
            return Single.just(r112.f253935c);
        L13:
            if ((r111 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L31;
            com.bytedance.lark.rustclient.api.c r113 = (com.bytedance.lark.rustclient.api.c) r111;
            p r114 = r113.f253907c;
            LarkError r115 = r114.f253922b;
            Integer r116 = null;
            if (r115 == null) goto L19;
            LarkError.ErrorDetails r117 = r115.details;
            if (r117 == null) goto L19;
            String r118 = r117.x_tt_logid;
        L20:
            if (r115 == null) goto L22;
            r116 = r115.code;
        L22:
            String r119 = r114.c();
            int r120 = ScsLogger.f440428a;
            ScsLogger.d("RustFetcher", "queryBlockAction error. logId is " + r118 + ", code is " + r116 + ", message is " + r119);
            LarkError r121 = r113.f253907c.f253922b;
            if (r121 == null) goto L27;
            Integer r122 = r121.code;
            if (r122 == null) goto L27;
            int r123 = r122.intValue();
        L28:
            this.f440467a.a(new NetworkErrorResult(r123, r119, r118, 0, 8, null));
            return Single.error(r113.f253907c.b());
        L27:
            r123 = -1;
        L19:
            r118 = null;
            goto L20
        L31:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f440469a = null;

        static {
            f440469a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UserSendHttpResponse r101 = (UserSendHttpResponse) r100;
            ScsLogger.d("RustFetcher", "success");
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f440470a = null;

        static {
            f440470a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = ScsLogger.f440428a;
            ScsLogger.c("RustFetcher", "error, message = " + r101.getMessage() + ", stackTrace = " + r101.getStackTrace());
        }
    }

    static {
    }

    public g(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f440465a = r100;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.f
    public final void a(com.ss.android.lark.security.compliance.infra.network.g r110, com.ss.android.lark.security.compliance.infra.network.e r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Object r100 = null;
        if (TextUtils.isEmpty(r110.getPath()) == false) goto L5;
        r110.canLog();
        ScsLogger.d("RustFetcher", "url is empty");
        UserSendHttpRequest.Builder r101 = null;
    L83:
        if (r101 != null) goto L86;
        r111.a(new NetworkErrorResult(-8, "builder is null", null, 0, 12, null));
        return;
    L86:
        this.f440465a.h(new com.bytedance.lark.rustclient.api.d(r101, UserSendHttpResponse.ADAPTER, Command.USER_SEND_HTTP, null, null, null, null, 248)).a().singleOrError().flatMap(new c(r111, r110)).subscribe(d.f440469a, e.f440470a);
        return;
    L5:
        UserSendHttpRequest.Builder r102 = new UserSendHttpRequest.Builder();
        r102.url(r110.getUrl());
        LinkedHashMap<String, String> r103 = r110.getHeaders().headersMap;
        ArrayList r104 = new ArrayList(r103.size());
        Iterator<Map.Entry<String, String>> r105 = r103.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, String> r106 = r105.next();
        r104.add(new HttpHeader(r106.getKey(), r106.getValue()));
        goto L7
    L9:
        List r107 = CollectionsKt.toMutableList(r104);
        String r108 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getDeviceId();
        Application r109 = LarkContext.getApplication();
        String r112 = r109.getPackageName();
        String r113 = ApkUtil.getAppVersionName(r109);     // Catch: Exception -> L13
        if (r113 == null) goto L14;
    L15:
        StringBuilder r114 = new StringBuilder(128);
        if (TextUtils.isEmpty(r108) == true) goto L18;
        r114.append("device_id=");
        r114.append(Uri.encode(r108));
        r114.append(i.f25853b);
    L18:
        String r115 = RomUtils.c();
        String r116 = Build.MODEL.trim();
        String r117 = RomUtils.d();
        String r118 = PackageChannelManager.getBuildPackageChannel(r109);
        if (TextUtils.isEmpty(r115) == true) goto L22;
        r114.append("device_name=");
        r114.append(Uri.encode(r115));
        r114.append(i.f25853b);
    L22:
        if (TextUtils.isEmpty(r117) == true) goto L25;
        r114.append("device_os=");
        r114.append(Uri.encode(r117));
        r114.append(i.f25853b);
    L25:
        if (TextUtils.isEmpty(r116) == true) goto L28;
        r114.append("device_model=");
        r114.append(Uri.encode(r116));
        r114.append(i.f25853b);
    L28:
        if (TextUtils.isEmpty(r112) == true) goto L31;
        r114.append("package_name=");
        r114.append(Uri.encode(r112));
        r114.append(i.f25853b);
    L31:
        if (TextUtils.isEmpty(r113) == true) goto L34;
        r114.append("lark_version=");
        r114.append(Uri.encode(r113));
        r114.append(i.f25853b);
    L34:
        if (r112 == null) goto L39;
        if (StringsKt.contains$default(r112, ".lite", false, 2, null) == false) goto L39;
        r118 = "saas_lite";
    L39:
        if (TextUtils.isEmpty(r118) == true) goto L41;
        r114.append("channel=");
        r114.append(r118);
        r114.append(i.f25853b);
    L41:
        r107.add(new HttpHeader("X-Device-Info", r114.toString()));
        if (r110.a() == false) goto L54;
        String r119 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getForegroundUserSession();
        r107.add(new HttpHeader("Suite-Session-Key", r119));
        Iterator r120 = r107.iterator();
    L45:
        if (r120.hasNext() == false) goto L49;
        Object r121 = r120.next();
        if (Intrinsics.areEqual(((HttpHeader) r121).name, BaseHttpRequestInfo.KEY_COOKIE) == false) goto L45;
        r100 = r121;
    L49:
        if (r100 != null) goto L54;
        int r122 = com.ss.android.lark.security.compliance.infra.network.b.f440441a;
        String r123 = com.ss.android.lark.security.compliance.infra.network.b.a(r110.getHost());
        if (r123 == null) goto L53;
        r107.add(new HttpHeader(BaseHttpRequestInfo.KEY_COOKIE, "session=" + r119 + "; sl_session=" + r123));
        goto L54
    L53:
        r107.add(new HttpHeader(BaseHttpRequestInfo.KEY_COOKIE, "session=" + r119));
    L54:
        r102.headers(new HttpHeaderMap(r107));
        int r124 = b.f440466a[r110.getMethod().ordinal()];
        if (r124 != 1) goto L57;
        r102.method(com.bytedance.lark.pb.tool.v1.HttpMethod.GET);
    L82:
        r101 = r102;
        goto L83
    L57:
        if (r124 == 2) goto L74;
        if (r124 != 3) goto L61;
        r102.method(com.bytedance.lark.pb.tool.v1.HttpMethod.PATCH);
        goto L82
    L61:
        if (r124 == 4) goto L63;
        Unit r125 = Unit.INSTANCE;
        goto L82
    L63:
        JSONObject r126 = r110.getRequestBody();
        String r127 = SliceInitService.DEFAULT_SWITCH;
        if (r126 != null) goto L91;
    L67:
        HttpRequestBody r128 = new HttpRequestBody(HttpParams.RAW_TYPE_JSON, r127);
        if (TextUtils.isEmpty(r128.getContent()) == true) goto L70;
        r102.body(ByteString.a.e(ByteString.Companion, r128.getContent().getBytes(Charsets.UTF_8)));
    L71:
        r102.method(com.bytedance.lark.pb.tool.v1.HttpMethod.DELETE);
        goto L82
    L70:
        r110.canLog();
        ScsLogger.e("RustFetcher", "delete body is null or getContent is empty");
        goto L71
    L91:
        r127 = JSON.toJSONString(r126);     // Catch: Throwable -> L88
        goto L67
    L74:
        if (Intrinsics.areEqual(r110.getMimeType(), "application/x-protobuf") == false) goto L76;
        r102.body(ByteString.a.e(ByteString.Companion, r110.b()));
    L80:
        r102.method(com.bytedance.lark.pb.tool.v1.HttpMethod.POST);
        goto L82
    L76:
        HttpRequestBody r129 = new HttpRequestBody(HttpParams.RAW_TYPE_JSON, r110.getRequestBody().toString());
        if (TextUtils.isEmpty(r129.getContent()) == true) goto L79;
        r102.body(ByteString.a.e(ByteString.Companion, r129.getContent().getBytes(Charsets.UTF_8)));
        goto L80
    L79:
        r110.canLog();
        ScsLogger.e("RustFetcher", "post body is null or getContent is empty");
        Unit r130 = Unit.INSTANCE;
    L14:
        r113 = "";
    L13:
        int r131 = ScsLogger.f440428a;
        ScsLogger.c("RustFetcher", "get lark version error");
        goto L14
    }
}
