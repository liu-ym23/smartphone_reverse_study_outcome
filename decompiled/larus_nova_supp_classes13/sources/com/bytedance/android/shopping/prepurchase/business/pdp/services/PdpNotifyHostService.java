package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpNotifyHostService extends b0 {
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(vg3.a.class);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        vg3.a r0 = (vg3.a) N1(vg3.a.class);
        if (r0 == null) goto L7;
        AnchorV4PlayerStateManager r1 = r0.e();
        if (r1 == null) goto L7;
        r1.e = null;
    L7:
        vg3.a r2 = (vg3.a) N1(vg3.a.class);
        if (r2 == null) goto L12;
        AnchorV4PlayerStateManager r3 = r2.e();
        if (r3 == null) goto L12;
        r3.f = null;
    L12:
        super.U1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        vg3.a r0 = (vg3.a) N1(vg3.a.class);
        if (r0 == null) goto L7;
        AnchorV4PlayerStateManager r1 = r0.e();
        if (r1 == null) goto L7;
        r1.e = PdpNotifyHostService$onAttach$1.INSTANCE;
    L7:
        vg3.a r2 = (vg3.a) N1(vg3.a.class);
        if (r2 == null) goto L13;
        AnchorV4PlayerStateManager r3 = r2.e();
        if (r3 == null) goto L14;
        r3.f = PdpNotifyHostService$onAttach$2.INSTANCE;
        return;
    L14:
        return;
    }

    public PdpNotifyHostService() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
    }
}
