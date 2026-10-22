package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.i0;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m {
    public static final /* synthetic */ int s = 0;
    public MoreVideoComponent m;
    public LivingIconComponent n;
    public BackToTopEntryComponent o;
    public ShopFloatEntryComponent p;
    public QuestionnaireEntranceComponent q;
    public AbsComponent<?, ?> r;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.a.class, w.class, i0.class, vg3.l.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        Z1(vg3.a.class, new NAPendentLayerComponent$tryLoadChildComponent$1(this, null));
    }

    public m() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        com.bytedance.android.shopping.prepurchase.business.pdp.view.k r4 = new com.bytedance.android.shopping.prepurchase.business.pdp.view.k(r2.getContext());
        r4.setId(2131380592);
        return r4;
    }
}
