package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.shopping.slice.SlcScaleProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b implements k {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final a f8() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final FragmentManager getFragmentManager() {
        return this.a.getContainerAbility().g7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final SlcScaleProvider l8() {
        return new SlcScaleProvider();
    }

    public b(com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
