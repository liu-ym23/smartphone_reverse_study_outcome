package zi9;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f572269b;

    /* JADX INFO: renamed from: zi9.a$a, reason: collision with other inner class name */
    public static final class C8464a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f572270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f572271b;

        public C8464a(a r100, XBridgeMethod.Callback r101) {
            this.f572270a = r100;
            this.f572271b = r101;
        }

        public final void a(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = d.f572276a;
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r103 = new LinkedHashMap();
            this.f572270a.onSuccess(this.f572271b, r103, r101);
        }
    }

    public a() {
        this.f572268a = "x.setStorageItem";
        this.f572269b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f572269b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f572268a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = c.f572273c;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = s.f(r110, "key", "");
        boolean r113 = false;
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        c r114 = null;
        if (r102 == false) goto L10;
    L16:
        if (r114 != null) goto L19;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L19:
        C8464a r103 = new C8464a(this, r111);
        Intrinsics.checkNotNullParameter(r114, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        Context r104 = (Context) ((b) this).provideContext(Context.class);
        if (r104 != null) goto L22;
        Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
        XCoreBridgeMethod.onFailure$default(this, r111, 0, "Context not provided in host", null, 8, null);
        return;
    L22:
        String r105 = r114.f572274a;
        t r106 = r114.f572275b;
        XReadableType r107 = r106.getType();
        dj9.a r108 = new dj9.a(r104);
        switch(b.a.f572272a[r107.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            default: goto L31;
        };
    L25:
        r113 = r108.e(r105, r106.asMap());
        goto L31
    L26:
        r113 = r108.e(r105, r106.asArray());
        goto L31
    L27:
        r113 = r108.e(r105, Double.valueOf(r106.asDouble()));
        goto L31
    L28:
        r113 = r108.e(r105, r106.asString());
        goto L31
    L29:
        r113 = r108.e(r105, Integer.valueOf(r106.asInt()));
        goto L31
    L30:
        r113 = r108.e(r105, Boolean.valueOf(r106.asBoolean()));
    L31:
        if (r113 == false) goto L33;
        r103.a(new d(), "");
        return;
    L33:
        Intrinsics.checkNotNullParameter("Illegal value type", "msg");
        XCoreBridgeMethod.onFailure$default(this, r111, -3, "Illegal value type", null, 8, null);
        return;
    L10:
        if (r110.isNull("data") == false) goto L12;
        t r109 = null;
    L13:
        if (r109 == null) goto L16;
        r114 = new c(r101, r109);
        goto L16
    L12:
        r109 = r110.get("data");
        goto L13
    L5:
        r102 = false;
        goto L6
    }
}
