package xi9;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.ies.xbridge.v;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f563970b;

    /* JADX INFO: renamed from: xi9.a$a, reason: collision with other inner class name */
    public static final class C8243a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f563971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f563972b;

        public final void a() {
            Intrinsics.checkNotNullParameter("applog depend is null", "msg");
            XCoreBridgeMethod.onFailure$default(this.f563971a, this.f563972b, 0, "applog depend is null", null, 8, null);
        }

        public C8243a(a r100, XBridgeMethod.Callback r101) {
            this.f563971a = r100;
            this.f563972b = r101;
        }

        public final void b(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = d.f563977a;
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r103 = new LinkedHashMap();
            this.f563971a.onSuccess(this.f563972b, r103, r101);
        }
    }

    public a() {
        this.f563969a = "x.reportAppLog";
        this.f563970b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f563970b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f563969a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = c.f563974c;
        Intrinsics.checkNotNullParameter(r110, "map");
        String r101 = s.f(r110, "eventName", "");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        XReadableMap r113 = s.e(r110, "params");
        if (r113 == null) goto L10;
        c r114 = new c(r101, r113);
    L12:
        if (r114 != null) goto L15;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L15:
        C8243a r103 = new C8243a(this, r111);
        Intrinsics.checkNotNullParameter(r114, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r115 = r114.f563975a;
        XReadableMap r116 = r114.f563976b;
        u r117 = r116.keyIterator();
        LinkedHashMap r104 = new LinkedHashMap();
    L17:
        if (r117.hasNextKey() == false) goto L31;
        String r105 = r117.nextKey();
        t r106 = r116.get(r105);
        XReadableType r107 = r106.getType();
        switch(b.a.f563973a[r107.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L24;
            case 6: goto L21;
            default: goto L20;
        };
    L21:
        v r108 = r106.asArray();
        if (r108 == null) goto L17;
        String r109 = (String) r104.put(r105, j.c(r108).toString());
        goto L17
    L24:
        XReadableMap r118 = r106.asMap();
        if (r118 == null) goto L17;
        String r119 = (String) r104.put(r105, j.d(r118).toString());
        goto L17
    L27:
        r104.put(r105, r106.asString());
        goto L17
    L28:
        r104.put(r105, String.valueOf(r106.asDouble()));
        goto L17
    L29:
        r104.put(r105, String.valueOf(r106.asInt()));
        goto L17
    L30:
        r104.put(r105, String.valueOf(r106.asBoolean()));
        goto L17
    L20:
        Unit r120 = Unit.INSTANCE;
        goto L17
    L31:
        IAppLog r121 = BDLiveSdk.appLog();
        if (r121 == null) goto L34;
        r121.log(r115, r104);
        r103.b(new d(), "");
        return;
    L34:
        r103.a();
        return;
    L10:
        r114 = null;
        goto L12
    L5:
        r102 = false;
        goto L6
    }
}
