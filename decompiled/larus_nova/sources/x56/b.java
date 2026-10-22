package x56;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f562519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562520b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f562521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f562522b;

        public a(b r100, XBridgeMethod.Callback r101) {
            this.f562521a = r100;
            this.f562522b = r101;
        }

        public final void a(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f562521a.onSuccess(this.f562522b, r103, r101);
        }
    }

    public abstract void e(b66.b r100, a r101, XBridgePlatformType r102);

    public b() {
        this.f562519a = XBridgeMethod.Access.PUBLIC;
        this.f562520b = "x.subscribeEvent";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f562519a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f562520b;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<b66.b> provideParamModel() {
        return b66.b.class;
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
        int r102 = b66.b.f17855c;
        Intrinsics.checkNotNullParameter(r100, "params");
        String r103 = s.f(r100, "eventName", "");
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
    L15:
        b66.b r105 = null;
    L19:
        if (r105 != null) goto L22;
        XCoreBridgeMethod.onFailure$default(this, r101, -3, null, null, 12, null);
        return;
    L22:
        e(r105, new a(this, r101), r110);
        return;
    L9:
        if (r100.hasKey("timestamp") == false) goto L15;
        t r106 = r100.get("timestamp");
        int r107 = b66.b.a.C0272a.f17858a[r106.getType().ordinal()];
        if (r107 != 1) goto L14;
        long r108 = (long) r106.asDouble();
    L18:
        r105 = new b66.b();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r105.f17856a = r103;
        r105.f17857b = r108;
        goto L19
    L14:
        if (r107 != 2) goto L15;
        r108 = r106.asInt();
        goto L18
    L5:
        r104 = false;
        goto L6
    }
}
