package j66;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.NetworkConstant$RequestErrorCode;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import ie5.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import u56.d;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f497515a;

    /* JADX INFO: renamed from: j66.a$a, reason: collision with other inner class name */
    public interface InterfaceC6395a {
        void a(k66.b r100, String r101);

        void b(int r100, String r101, k66.b r102);
    }

    public static final class b implements InterfaceC6395a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f497516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k66.a f497517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ XBridgePlatformType f497518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f497519d;

        @Override // j66.a.InterfaceC6395a
        public final void a(k66.b r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "result");
            Intrinsics.checkNotNullParameter(r111, "msg");
            int r100 = k66.b.f501965c;
            Map<String, Object> r101 = k66.b.a.a(r110);
            if (r101 != null) goto L14;
            a r102 = this.f497516a;
            String r103 = this.f497517b.f501961b;
            if (r103 == null) goto L7;
            String r104 = r103;
        L8:
            String r105 = this.f497517b.f501960a;
            if (r105 == null) goto L11;
            String r106 = r105;
        L12:
            r102.e(r104, r106, -1, -5, "Invalid results", this.f497518c.name());
            XCoreBridgeMethod.onFailure$default(this.f497516a, this.f497519d, -5, null, null, 12, null);
            return;
        L11:
            Intrinsics.throwUninitializedPropertyAccessException("url");
            r106 = null;
            goto L12
        L7:
            Intrinsics.throwUninitializedPropertyAccessException(e.f25671s);
            r104 = null;
            goto L8
        L14:
            this.f497516a.onSuccess(this.f497519d, r101, r111);
        }

        @Override // j66.a.InterfaceC6395a
        public final void b(int r100, String r101, k66.b r110) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = k66.b.f501965c;
            Map<String, Object> r111 = k66.b.a.a(r110);
            if (r111 != null) goto L6;
            XCoreBridgeMethod.onFailure$default(this.f497516a, this.f497519d, r100, r101, null, 8, null);
            return;
        L6:
            this.f497516a.onFailure(this.f497519d, r100, r101, r111);
        }

        public b(a r100, k66.a r101, XBridgePlatformType r102, XBridgeMethod.Callback r103) {
            this.f497516a = r100;
            this.f497517b = r101;
            this.f497518c = r102;
            this.f497519d = r103;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f497520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f497521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f497522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f497523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f497524e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f497525f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f497526g;

        public c(String r100, String r101, Integer r102, int r103, String r104, String r105, a r106) {
            this.f497520a = r100;
            this.f497521b = r101;
            this.f497522c = r102;
            this.f497523d = r103;
            this.f497524e = r104;
            this.f497525f = r105;
            this.f497526g = r106;
        }

        public final void a() {
            String r100 = this.f497520a;
            String r101 = this.f497521b;
            Integer r102 = this.f497522c;
            int r103 = this.f497523d;
            String r104 = this.f497524e;
            String r105 = this.f497525f;
            a r106 = this.f497526g;
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
            Pair[] r108 = new Pair[6];     // Catch: Throwable -> L19
            r108[0] = TuplesKt.to(e.f25671s, r100);     // Catch: Throwable -> L19
            r108[1] = TuplesKt.to("url", r101);     // Catch: Throwable -> L19
            if (r102 == null) goto L6;
            int r109 = r102.intValue();     // Catch: Throwable -> L19
        L7:
            r108[2] = TuplesKt.to("statusCode", Integer.valueOf(r109));     // Catch: Throwable -> L19
            r108[3] = TuplesKt.to("requestErrorCode", Integer.valueOf(r103));     // Catch: Throwable -> L19
            r108[4] = TuplesKt.to("requestErrorMsg", r104);     // Catch: Throwable -> L19
            r108[5] = TuplesKt.to("platform", r105);     // Catch: Throwable -> L19
            Map<String, ? extends Object> r110 = MapsKt.mutableMapOf(r108);     // Catch: Throwable -> L19
            r106.getClass();     // Catch: Throwable -> L19
            r56.c r111 = (r56.c) r106.provideContext(r56.c.class);     // Catch: Throwable -> L19
            Unit r112 = null;
            if (r111 == null) goto L11;
            IHostLogDepend r113 = r111.f536313a;     // Catch: Throwable -> L19
            if (r113 == null) goto L11;
        L15:
            if (r113 == null) goto L17;
            r112 = r113.reportJSBFetchError(r106.getContextProviderFactory(), r110);     // Catch: Throwable -> L19
        L17:
            Result.m9449constructorimpl(r112);     // Catch: Throwable -> L19
            return;
        L11:
            r56.c r114 = r56.c.f536312g;     // Catch: Throwable -> L19
            if (r114 == null) goto L14;
            r113 = r114.f536313a;     // Catch: Throwable -> L19
            goto L15
        L14:
            r113 = null;
            goto L15
        L6:
            r109 = -1;
        L19:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
        this.f497515a = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f497515a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<k66.a> provideParamModel() {
        return k66.a.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<k66.b> provideResultModel() {
        return k66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r210, XBridgeMethod.Callback r211, XBridgePlatformType r212) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Intrinsics.checkNotNullParameter(r212, "type");
        int r100 = k66.a.f501959f;
        Intrinsics.checkNotNullParameter(r210, "data");
        String r101 = s.f(r210, "url", "");
        if (r101.length() != 0) goto L5;
        boolean r110 = true;
    L7:
        if (r110 == true) goto L14;
        String r111 = s.f(r210, e.f25671s, "");
        if (r111.length() != 0) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == true) goto L14;
        t r113 = r210.get(ContainerPosition.BODY);
        XReadableMap r114 = s.e(r210, "params");
        XReadableMap r115 = s.e(r210, "header");
        s.f(r210, "bodyType", "");
        s.b(r210, "addCommonParams", true);
        k66.a r102 = new k66.a();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f501960a = r101;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r102.f501961b = r111;
        r102.f501962c = r113;
        r102.f501963d = r114;
        r102.f501964e = r115;
        k66.a r116 = r102;
    L16:
        if (r116 != null) goto L19;
        e(s.f(r210, e.f25671s, ""), s.f(r210, "url", ""), -1, -3, "Invalid params", r212.name());
        XCoreBridgeMethod.onFailure$default(this, r211, -3, null, null, 12, null);
        return;
    L19:
        b r103 = new b(this, r116, r212, r211);
        me5.a r104 = (me5.a) this;
        Intrinsics.checkNotNullParameter(r116, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r212, "type");
        Object r105 = r116.f501962c;
        String r106 = r116.f501960a;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("url");
        r106 = null;
    L23:
        String r107 = r116.f501961b;
        if (r107 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException(e.f25671s);
        r107 = null;
    L27:
        XReadableMap r108 = r116.f501963d;
        XReadableMap r109 = r116.f501964e;
        int r117 = k.f489487a;
        NetService r118 = (NetService) k.a.a(NetService.class);
        boolean r119 = TextUtils.isEmpty(r106);
        Integer r120 = Integer.valueOf(NetworkConstant$RequestErrorCode.PARAM_ERROR);
        if (r119 == false) goto L31;
        me5.a.f(new Pair(r120, null), "request url is empty", r103);
        tt5.a.k("ccm-lynx: CCMNetRequestMethod", "request url is empty");
    L38:
        boolean r121 = false;
    L40:
        if (r121 == false) goto L133;
        NetService.d r122 = r118.Vc(com.bytedance.ee.bear.lynx.impl.xbridge.method.network.a.f229965a);
        Uri r123 = UriProtector.parse(r106);
        String r124 = r123.getHost();
        NetService.e r125 = new NetService.f(r123.getPath());
        String r126 = r107.toUpperCase();
        if (Intrinsics.areEqual(r126, "GET") == false) goto L46;
        r125.f216906c = 2;
    L49:
        if (TextUtils.isEmpty(r124) == true) goto L51;
        r125.f216904a = r124;
        r125.f216912i = false;
    L51:
        d.f548844a.getClass();
        LinkedHashMap r127 = d.b(r109);
        if (r127.containsKey(e.f25658f) == false) goto L55;
        String r128 = (String) r127.get(e.f25658f);
    L58:
        tt5.a.h("ccm-lynx: CCMNetRequestMethod", "content-type: " + r128);
        if ((!r127.keySet().isEmpty()) == false) goto L61;
        r125.c(r127);
    L61:
        LinkedHashMap r129 = new LinkedHashMap();
        if (r108 == null) goto L79;
        u r130 = r108.keyIterator();
    L65:
        if (r130.hasNextKey() == false) goto L79;
        String r131 = r130.nextKey();
        t r132 = r108.get(r131);
        int r133 = d.a.f548845a[r132.getType().ordinal()];
        XReadableMap r134 = r108;
        if (r133 == 1) goto L77;
        if (r133 != 2) goto L70;
        r129.put(r131, String.valueOf(r132.asBoolean()));
    L78:
        r108 = r134;
        goto L65
    L70:
        if (r133 != 3) goto L72;
        r129.put(r131, String.valueOf(r132.asDouble()));
        goto L78
    L72:
        if (r133 != 4) goto L78;
        r129.put(r131, r132.asString());
        goto L78
    L77:
        r129.put(r131, String.valueOf(r132.asInt()));
    L79:
        Uri r135 = UriProtector.parse(r106);
        Iterator<String> r136 = UriProtector.getQueryParameterNames(r135).iterator();
    L81:
        if (r136.hasNext() == false) goto L83;
        String r137 = r136.next();
        r125.b(r137, UriProtector.getQueryParameter(r135, r137));
        goto L81
    L83:
        Iterator r138 = r129.entrySet().iterator();
    L85:
        if (r138.hasNext() == false) goto L87;
        Map.Entry r139 = (Map.Entry) r138.next();
        r125.b((String) r139.getKey(), (String) r139.getValue());
        goto L85
    L87:
        boolean r140 = r105 instanceof t;
        if (r140 == false) goto L90;
        t r141 = (t) r105;
    L91:
        if (r141 == null) goto L93;
        XReadableType r142 = r141.getType();
    L95:
        if (r142 != XReadableType.Map) goto L101;
        if (r140 == false) goto L98;
        t r143 = (t) r105;
    L99:
        if (r143 == null) goto L102;
        XReadableMap r144 = r143.asMap();
    L103:
        if (r144 == null) goto L118;
        if (r128 == null) goto L108;
        boolean r145 = false;
        if (StringsKt.contains$default(r128, "application/x-www-form-urlencoded", false, 2, null) != true) goto L109;
        r145 = true;
    L109:
        if (r145 == false) goto L117;
        JSONObject r146 = j.d(r144);
        LinkedHashMap r147 = new LinkedHashMap();
        Iterator<String> r148 = r146.keys();
    L112:
        if (r148.hasNext() == false) goto L116;
        String r149 = r148.next();
        String r150 = r146.optString(r149, "");
        if (TextUtils.isEmpty(r150) == true) goto L112;
        Intrinsics.checkNotNull(r149);
        Intrinsics.checkNotNull(r150);
        r147.put(r149, r150);
        goto L112
    L116:
        r125.d(MapsKt.toMap(r147));
        goto L118
    L117:
        r125.f216913j = j.d(r144).toString();
        goto L118
    L108:
        r145 = false;
    L118:
        r122.a(r125).subscribe(new me5.b(r104, r103), new me5.c(r104, r103));
        return;
    L102:
        r144 = null;
        goto L103
    L98:
        r143 = null;
        goto L99
    L101:
        tt5.a.h("ccm-lynx: CCMNetRequestMethod", "body is empty or not map");
        goto L102
    L93:
        r142 = null;
        goto L95
    L90:
        r141 = null;
        goto L91
    L55:
        if (r127.containsKey("Content-Type") == false) goto L57;
        r128 = (String) r127.get("Content-Type");
        goto L58
    L57:
        tt5.a.k("ccm-lynx: CCMNetRequestMethod", "headers not contain Content-Type key");
        r128 = null;
        goto L58
    L46:
        if (Intrinsics.areEqual(r126, "POST") == false) goto L49;
        r125.f216906c = 1;
        goto L49
    L133:
        return;
    L31:
        if (TextUtils.isEmpty(r107) == false) goto L33;
        me5.a.f(new Pair(r120, null), "request method is empty", r103);
        tt5.a.k("ccm-lynx: CCMNetRequestMethod", "request method is empty");
        goto L38
    L33:
        String r151 = r107.toUpperCase();
        if (Intrinsics.areEqual(r151, "GET") == false) goto L36;
    L39:
        r121 = true;
        goto L40
    L36:
        if (Intrinsics.areEqual(r151, "POST") == true) goto L39;
        me5.a.f(new Pair(r120, null), r151 + " request method is not support", r103);
        tt5.a.k("ccm-lynx: CCMNetRequestMethod", r151 + " request method is not support");
        goto L38
    L12:
        r112 = false;
    L14:
        r116 = null;
        goto L16
    L5:
        r110 = false;
        goto L7
    }

    public final void e(String r110, String r111, Integer r112, int r113, String r114, String r115) {
        r56.c r100 = (r56.c) provideContext(r56.c.class);
        r56.c r101 = r56.c.f536312g;
        TTExecutors.getNormalExecutor().execute(new c(r110, r111, r112, r113, r114, r115, this));
    }
}
