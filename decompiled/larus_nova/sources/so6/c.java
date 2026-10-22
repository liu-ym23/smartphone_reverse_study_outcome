package so6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import yn6.g;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends ro6.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, g>>> f542728d;

    public static final class a {
    }

    static {
    }

    public c() {
        yn6.c r100 = yn6.a.f568561a;
        this.f542728d = yn6.a.d();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        ro6.c.b r113 = (ro6.c.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getDomain();
        String r101 = r110.getContainerID();
        Boolean r114 = r113.getOnlyDiff();
        if (r114 == null) goto L5;
        boolean r115 = r114.booleanValue();
    L6:
        WeakReference r102 = new WeakReference(r110);
        int r116 = d.f542729e;
        d.a.a(this.f542728d, "", r100, r101, r102);
        ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, g>>> r117 = this.f542728d;
        if (r117 == null) goto L17;
        ConcurrentHashMap<String, ConcurrentHashMap<String, g>> r118 = r117.get(r100);
        if (r118 == null) goto L17;
        ConcurrentHashMap<String, g> r119 = r118.get("");
        if (r119 == null) goto L17;
        g r120 = r119.get(r101);
        if (r120 == null) goto L17;
        WeakReference<yn6.e> r121 = r120.a();
        if (r121 == null) goto L17;
        yn6.e r122 = r121.get();
    L18:
        if (r122 == null) goto L20;
        yn6.c r103 = yn6.a.f568561a;
        yn6.a.g(r100, r122, r115);
        ro6.c.InterfaceC7511c r123 = (ro6.c.InterfaceC7511c) ne7.e.b(ro6.c.InterfaceC7511c.class);
        r123.setEventName("life_storage_value_update");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, r123, null, 2, null);
        return;
    L20:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -1, "no xBridge inner storage callback", null, 4, null);
        return;
    L17:
        r122 = null;
        goto L18
    L5:
        r115 = false;
        goto L6
    }
}
