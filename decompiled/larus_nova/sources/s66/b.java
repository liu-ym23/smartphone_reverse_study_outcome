package s66;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f540813b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f540814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f540815b;

        public final void a() {
            Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
            XCoreBridgeMethod.onFailure$default(this.f540814a, this.f540815b, 0, "Context not provided in host", null, 8, null);
        }

        public a(b r100, XBridgeMethod.Callback r101) {
            this.f540814a = r100;
            this.f540815b = r101;
        }

        public final void b(u66.c r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = u66.c.f548932b;
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r103 = new LinkedHashMap();
            Object r104 = r100.f548933a;
            if (r104 == null) goto L5;
            r103.put("data", r104);
        L5:
            this.f540814a.onSuccess(this.f540815b, r103, r101);
        }
    }

    public abstract void e(u66.b r100, a r101, XBridgePlatformType r102);

    public b() {
        this.f540812a = "x.getStorageItem";
        this.f540813b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f540813b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f540812a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<u66.b> provideParamModel() {
        return u66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<u66.c> provideResultModel() {
        return u66.c.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        int r102 = u66.b.f548929c;
        Intrinsics.checkNotNullParameter(r100, "params");
        String r103 = s.f(r100, "key", "");
        boolean r104 = true;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        u66.b r106 = null;
    L15:
        if (r106 != null) goto L18;
        XCoreBridgeMethod.onFailure$default(this, r101, -3, null, null, 12, null);
        return;
    L18:
        e(r106, new a(this, r101), r110);
        return;
    L8:
        String r107 = s.f(r100, "biz", "");
        u66.b r108 = new u66.b();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r108.f548930a = r103;
        if (r107.length() > 0) goto L12;
        r104 = false;
    L12:
        if (r104 == false) goto L14;
        r108.f548931b = r107;
    L14:
        r106 = r108;
        goto L15
    L5:
        r105 = false;
        goto L6
    }
}
