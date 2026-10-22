package so6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import yn6.g;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends ro6.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f542729e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, g>>> f542730d;

    public static final class a {

        /* JADX INFO: renamed from: so6.d$a$a, reason: collision with other inner class name */
        public static final class C7634a implements yn6.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WeakReference<IBDXBridgeContext> f542731a;

            public C7634a(WeakReference<IBDXBridgeContext> r100) {
                this.f542731a = r100;
            }

            @Override // yn6.e
            public final void a(String r100, String r101, Object r102, Object r103) {
                Intrinsics.checkNotNullParameter(r100, "domain");
                Intrinsics.checkNotNullParameter(r101, "key");
                LinkedHashMap r104 = new LinkedHashMap();
                r104.put("domain", r100);
                r104.put("key", r101);
                r104.put("value", r102);
                r104.put("pre_value", r103);
                IBDXBridgeContext r105 = this.f542731a.get();
                if (r105 == null) goto L6;
                r105.sendEvent("life_storage_value_update", r104);
                return;
            }
        }

        public static void a(ConcurrentHashMap r100, String r101, String r102, String r103, WeakReference r104) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "domain");
            Intrinsics.checkNotNullParameter(r103, "containerId");
            Intrinsics.checkNotNullParameter(r104, "wrBridgeContext");
            if (r100 == null) goto L11;
            ConcurrentHashMap r105 = (ConcurrentHashMap) r100.get(r102);
            if (r105 == null) goto L11;
            ConcurrentHashMap r106 = (ConcurrentHashMap) r105.get(r101);
            if (r106 == null) goto L11;
            boolean r107 = true;
            if (r106.containsKey(r103) != true) goto L11;
        L12:
            if (r107 == true) goto L26;
            g r108 = new g(new C7634a(r104), (IBDXBridgeContext) r104.get());
            r108.e().incrementAndGet();
            if (r100 != null) goto L16;
            return;
        L16:
            if (r100.containsKey(r102) == true) goto L18;
            r100.put(r102, new ConcurrentHashMap());
        L18:
            ConcurrentHashMap r109 = (ConcurrentHashMap) r100.get(r102);
            if (r109 != null) goto L21;
            return;
        L21:
            if (r109.containsKey(r101) == true) goto L23;
            r109.put(r101, new ConcurrentHashMap());
        L23:
            ConcurrentHashMap r110 = (ConcurrentHashMap) r109.get(r101);
            if (r110 == null) goto L39;
            g r111 = (g) r110.put(r103, r108);
            return;
        L39:
            return;
        L26:
            if (r100 == null) goto L41;
            ConcurrentHashMap r112 = (ConcurrentHashMap) r100.get(r102);
            if (r112 == null) goto L42;
            ConcurrentHashMap r113 = (ConcurrentHashMap) r112.get(r101);
            if (r113 == null) goto L43;
            g r114 = (g) r113.get(r103);
            if (r114 == null) goto L44;
            AtomicInteger r115 = r114.e();
            if (r115 == null) goto L45;
            r115.getAndIncrement();
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L11:
            r107 = false;
            goto L12
        }
    }

    static {
    }

    public d() {
        yn6.c r100 = yn6.a.f568561a;
        this.f542730d = yn6.a.d();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        ro6.d.b r113 = (ro6.d.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getKey();
        String r101 = r113.getDomain();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r102 = r110.getContainerID();
        Boolean r114 = r113.getOnlyDiff();
        if (r114 == null) goto L8;
        boolean r115 = r114.booleanValue();
    L9:
        a.a(this.f542730d, r100, r101, r102, new WeakReference(r110));
        ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, g>>> r116 = this.f542730d;
        if (r116 == null) goto L20;
        ConcurrentHashMap<String, ConcurrentHashMap<String, g>> r117 = r116.get(r101);
        if (r117 == null) goto L20;
        ConcurrentHashMap<String, g> r118 = r117.get(r100);
        if (r118 == null) goto L20;
        g r119 = r118.get(r102);
        if (r119 == null) goto L20;
        WeakReference<yn6.e> r120 = r119.a();
        if (r120 == null) goto L20;
        yn6.e r121 = r120.get();
    L21:
        if (r121 == null) goto L23;
        yn6.c r103 = yn6.a.f568561a;
        yn6.a.h(r100, r121, r101, false, r115);
        ro6.d.c r122 = (ro6.d.c) ne7.e.b(ro6.d.c.class);
        r122.setEventName("life_storage_value_update");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, r122, null, 2, null);
        return;
    L23:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -1, "no xBridge inner storage callback", null, 4, null);
        return;
    L20:
        r121 = null;
        goto L21
    L8:
        r115 = false;
        goto L9
    }
}
