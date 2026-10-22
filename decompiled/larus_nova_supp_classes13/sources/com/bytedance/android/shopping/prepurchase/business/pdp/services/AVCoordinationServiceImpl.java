package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AVCoordinationServiceImpl implements vg3.a {
    public final Lazy a;
    public final Lazy b;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> c;

    public final AnchorV4PlayerStateManager p() {
        return (AnchorV4PlayerStateManager) this.a.getValue();
    }

    @Override // vg3.a
    public final l53.b v() {
        return (l53.b) this.b.getValue();
    }

    @Override // vg3.a
    public final AnchorV4PlayerStateManager e() {
        return p();
    }

    public AVCoordinationServiceImpl(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.a = LazyKt.lazy(new AVCoordinationServiceImpl$playerStateManager$2(this));
        this.b = LazyKt.lazy(new AVCoordinationServiceImpl$collisionNegotiator$2(this));
    }
}
