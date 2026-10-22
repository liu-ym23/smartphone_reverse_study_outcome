package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public BottomSheetBehavior<View> a;
    public boolean b;
    public float c;
    public int d;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> e;
    public final vg3.u f;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e g;

    public e(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2, vg3.u r3, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerAbility");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.d = -1;
    }
}
