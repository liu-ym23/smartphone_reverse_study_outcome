package s66;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f540809b;

    /* JADX INFO: renamed from: s66.a$a, reason: collision with other inner class name */
    public static final class C7573a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f540810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f540811b;

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            XCoreBridgeMethod.onFailure$default(this.f540810a, this.f540811b, 0, r100, null, 8, null);
        }

        public C7573a(a r100, XBridgeMethod.Callback r101) {
            this.f540810a = r100;
            this.f540811b = r101;
        }

        public final void b(u66.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = u66.a.f548927b;
            Intrinsics.checkNotNullParameter(r100, "data");
            if (r100.f548928a != null) goto L5;
            LinkedHashMap r103 = null;
        L9:
            if (r103 != null) goto L12;
            XCoreBridgeMethod.onFailure$default(this.f540810a, this.f540811b, -5, null, null, 12, null);
            return;
        L12:
            this.f540810a.onSuccess(this.f540811b, r103, r101);
            return;
        L5:
            LinkedHashMap r104 = new LinkedHashMap();
            List<String> r105 = r100.f548928a;
            if (r105 == null) goto L8;
            r104.put("keys", r105);
        L8:
            r103 = r104;
            goto L9
        }
    }

    public abstract void e(com.bytedance.ies.xbridge.model.params.b r100, C7573a r101, XBridgePlatformType r102);

    public a() {
        this.f540808a = "x.getStorageInfo";
        this.f540809b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f540809b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f540808a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<com.bytedance.ies.xbridge.model.params.b> provideParamModel() {
        return com.bytedance.ies.xbridge.model.params.b.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<u66.a> provideResultModel() {
        return u66.a.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = com.bytedance.ies.xbridge.model.params.b.f249508a;
        Intrinsics.checkNotNullParameter(r100, "params");
        e(new com.bytedance.ies.xbridge.model.params.b(), new C7573a(this, r101), r102);
    }
}
