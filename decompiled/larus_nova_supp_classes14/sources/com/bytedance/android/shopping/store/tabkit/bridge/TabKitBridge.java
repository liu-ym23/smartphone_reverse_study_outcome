package com.bytedance.android.shopping.store.tabkit.bridge;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.model.k;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pd.e;
import pd.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitBridge {
    public final ArrayList<Function1<k, TabKitBaseBridgeMethod>> a;
    public final Lazy b;
    public final f c;
    public b d;
    public final TabKitViewModel e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class TabKitBaseBridgeMethod extends ECBaseBridgeMethod {
        public final k e;

        public TabKitBaseBridgeMethod() {
            this(null);
        }

        public TabKitBaseBridgeMethod(k r1) {
            this.e = r1;
        }
    }

    public static final class a {
    }

    static {
        new ArrayList();
    }

    public TabKitBridge(TabKitViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.e = r2;
        ArrayList<Function1<k, TabKitBaseBridgeMethod>> r3 = new ArrayList();
        this.a = r3;
        this.b = LazyKt.lazy(new TabKitBridge$baseMethodsCreatedV2$2(this));
        boolean r0 = ECServiceManager.a;
        IAdapterService r1 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r1 == null) goto L7;
        e r4 = r1.getIExternaHybridService();
        if (r4 == null) goto L7;
        f r5 = r4.getExternalJsBridgeMethodInjectorAdapter();
    L8:
        this.c = r5;
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$1(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$2(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$3(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$4(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$5(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$6(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$7(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$8(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$9(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$10(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$11(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$12(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$13(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$14(this));
        r3.add(TabKitBridge$1$15.INSTANCE);
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$15(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$16(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$17(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$18(this));
        r3.add(new TabKitBridge$$special$$inlined$apply$lambda$19(this));
        return;
    L7:
        r5 = null;
        goto L8
    }
}
