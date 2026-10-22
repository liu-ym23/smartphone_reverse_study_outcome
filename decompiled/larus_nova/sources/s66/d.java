package s66;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u66.e;

/* JADX INFO: loaded from: classes19.dex */
public abstract class d extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f540821b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f540822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f540823b;

        public a(d r100, XBridgeMethod.Callback r101) {
            this.f540822a = r100;
            this.f540823b = r101;
        }

        public final void a(int r100, String r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            XCoreBridgeMethod.onFailure$default(this.f540822a, this.f540823b, r100, r110, null, 8, null);
        }

        public final void b(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f540822a.onSuccess(this.f540823b, r103, r101);
        }
    }

    public abstract void e(e r100, a r101, XBridgePlatformType r102);

    public d() {
        this.f540820a = "x.setStorageItem";
        this.f540821b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f540821b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f540820a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<e> provideParamModel() {
        return e.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = e.f548937d;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = s.f(r110, "key", "");
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        e r104 = null;
        if (r103 == false) goto L10;
    L21:
        if (r104 != null) goto L24;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L24:
        e(r104, new a(this, r111), r112);
        return;
    L10:
        if (r110.isNull("data") == false) goto L12;
        t r105 = null;
    L13:
        if (r105 == null) goto L21;
        String r106 = s.f(r110, "biz", "");
        r104 = new e();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r104.f548938a = r101;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f548939b = r105;
        if (r106.length() > 0) goto L19;
        r102 = false;
    L19:
        if (r102 == false) goto L21;
        r104.f548940c = r106;
        goto L21
    L12:
        r105 = r110.get("data");
        goto L13
    L5:
        r103 = false;
        goto L6
    }
}
