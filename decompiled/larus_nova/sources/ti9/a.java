package ti9;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f546272b;

    /* JADX INFO: renamed from: ti9.a$a, reason: collision with other inner class name */
    public static final class C7732a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f546273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f546274b;

        public final void a() {
            Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
            XCoreBridgeMethod.onFailure$default(this.f546273a, this.f546274b, 0, "Context not provided in host", null, 8, null);
        }

        public C7732a(a r100, XBridgeMethod.Callback r101) {
            this.f546273a = r100;
            this.f546274b = r101;
        }

        public final void b(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = d.f546277b;
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r103 = new LinkedHashMap();
            Object r104 = r100.f546278a;
            if (r104 == null) goto L5;
            r103.put("data", r104);
        L5:
            this.f546273a.onSuccess(this.f546274b, r103, r101);
        }
    }

    public a() {
        this.f546271a = "x.getStorageItem";
        this.f546272b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f546272b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f546271a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = c.f546275b;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r113 = s.f(r110, "key", "");
        if (r113.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        c r114 = null;
    L9:
        if (r114 != null) goto L12;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L12:
        C7732a r102 = new C7732a(this, r111);
        Intrinsics.checkNotNullParameter(r114, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        Context r115 = (Context) ((b) this).provideContext(Context.class);
        if (r115 != null) goto L15;
        r102.a();
        return;
    L15:
        String r116 = r114.f546276a;
        Object r117 = new dj9.a(r115).d(r116);
        d r118 = new d();
        r118.f546278a = r117;
        r102.b(r118, "");
        return;
    L8:
        r114 = new c(r113);
        goto L9
    L5:
        r101 = false;
        goto L6
    }
}
