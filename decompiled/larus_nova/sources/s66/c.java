package s66;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f540817b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f540818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f540819b;

        public a(c r100, XBridgeMethod.Callback r101) {
            this.f540818a = r100;
            this.f540819b = r101;
        }

        public final void a(int r100, String r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            XCoreBridgeMethod.onFailure$default(this.f540818a, this.f540819b, r100, r110, null, 8, null);
        }

        public final void b(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f540818a.onSuccess(this.f540819b, r103, r101);
        }
    }

    public abstract void e(u66.d r100, a r101, XBridgePlatformType r102);

    public c() {
        this.f540816a = "x.removeStorageItem";
        this.f540817b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f540817b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f540816a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<u66.d> provideParamModel() {
        return u66.d.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        int r102 = u66.d.f548934c;
        Intrinsics.checkNotNullParameter(r100, "params");
        String r103 = s.f(r100, "key", "");
        boolean r104 = true;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        u66.d r106 = null;
    L15:
        if (r106 != null) goto L18;
        XCoreBridgeMethod.onFailure$default(this, r101, -3, null, null, 12, null);
        return;
    L18:
        e(r106, new a(this, r101), r110);
        return;
    L8:
        String r107 = s.f(r100, "biz", "");
        u66.d r108 = new u66.d();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r108.f548935a = r103;
        if (r107.length() > 0) goto L12;
        r104 = false;
    L12:
        if (r104 == false) goto L14;
        r108.f548936b = r107;
    L14:
        r106 = r108;
        goto L15
    L5:
        r105 = false;
        goto L6
    }
}
