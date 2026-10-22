package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vg3.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;

    public k(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r6) {
        if (((Boolean) r6).booleanValue() == false) goto L26;
        final d r7 = this.a;
        if (r7.b != null) goto L29;
        vg3.v r0 = (vg3.v) r7.o.getService(vg3.v.class);
        if (r0 == null) goto L30;
        BasePdpRecyclerView r2 = r7.k;
        ProductDetailInfoAdapter r3 = r7.a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L13:
        r7.b = new BaseInfoServiceSnapshotTransitionController(r2, r3, r0, new MainFeedInitializer$enableSnapshotTransition$1(r7));
        r0.J0(true);
        if (r7.c == true) goto L31;
        final e0 r1 = (e0) r7.o.getService(e0.class);
        if (r1 == null) goto L32;
        r7.c = true;
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        SkuRestoreState r5 = r1.g0();
        if (r5 == null) goto L22;
        String r8 = r5.joinedKey();
    L23:
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        r4.element = r8;
        final Function0<Unit> r9 = new MainFeedInitializer$registerSnapshotSkuListeners$invalidateSnapshotsIfSkuChanged$1(r7, r1, r4);
        r1.u(new MainFeedInitializer$registerSnapshotSkuListeners$1(r9));
        r1.f1(new MainFeedInitializer$registerSnapshotSkuListeners$2(r9));
        return;
    L22:
        r8 = null;
        goto L23
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L26:
        this.a.a();
    }
}
