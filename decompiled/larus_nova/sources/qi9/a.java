package qi9;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostRouterDepend;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533202a;

    /* JADX INFO: renamed from: qi9.a$a, reason: collision with other inner class name */
    public static final class C7332a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f533203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f533204b;

        public C7332a(a r100, XBridgeMethod.Callback r101) {
            this.f533203a = r100;
            this.f533204b = r101;
        }

        public final void a(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f533203a.onSuccess(this.f533204b, r103, r101);
        }
    }

    public a() {
        this.f533202a = "x.close";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f533202a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<c> provideParamModel() {
        return c.class;
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
        int r100 = c.f533205d;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = s.f(r110, "containerID", "");
        boolean r102 = false;
        boolean r103 = s.b(r110, GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, false);
        v r113 = s.a(r110, "containerIDs");
        c r104 = new c();
        if (r101.length() <= 0) goto L5;
        r102 = true;
    L5:
        if (r102 == false) goto L7;
        r104.f533206a = r101;
    L7:
        IHostRouterDepend r105 = null;
        if (r113 == null) goto L15;
        List<Object> r114 = r113.toList();
        if (r114 == null) goto L15;
        List<Object> r115 = r114;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r116 = r115.iterator();
    L13:
        if (r116.hasNext() == false) goto L16;
        r106.add(String.valueOf(r116.next()));
    L16:
        r104.f533207b = r106;
        r104.f533208c = r103;
        C7332a r117 = new C7332a(this, r111);
        b r118 = (b) this;
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r117, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r107 = r104.f533206a;
        List<String> r108 = r104.f533207b;
        boolean r109 = r104.f533208c;
        if (r108 != null) goto L19;
    L33:
        r56.c r119 = (r56.c) r118.provideContext(r56.c.class);
        if (r119 == null) goto L39;
        IHostRouterDepend r120 = r119.f536316d;
        if (r120 == null) goto L39;
        r105 = r120;
    L42:
        if (r105 == null) goto L44;
        r105.closeView(r118.getContextProviderFactory(), r112, r107, r109);
    L44:
        r117.a(new i66.b(), "");
        return;
    L39:
        r56.c r121 = r56.c.f536312g;
        if (r121 == null) goto L42;
        r105 = r121.f536316d;
        goto L42
    L19:
        if ((!r108.isEmpty()) == false) goto L33;
        Iterator<T> r122 = r108.iterator();
    L22:
        if (r122.hasNext() == false) goto L44;
        String r123 = (String) r122.next();
        r56.c r124 = (r56.c) r118.provideContext(r56.c.class);
        if (r124 == null) goto L27;
        IHostRouterDepend r125 = r124.f536316d;
        if (r125 == null) goto L27;
    L31:
        if (r125 == null) goto L22;
        r125.closeView(r118.getContextProviderFactory(), r112, r123, r109);
    L27:
        r56.c r126 = r56.c.f536312g;
        if (r126 == null) goto L30;
        r125 = r126.f536316d;
        goto L31
    L30:
        r125 = null;
    L15:
        r106 = null;
        goto L16
    }
}
