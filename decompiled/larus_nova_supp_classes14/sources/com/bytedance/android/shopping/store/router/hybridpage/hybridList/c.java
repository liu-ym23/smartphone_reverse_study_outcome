package com.bytedance.android.shopping.store.router.hybridpage.hybridList;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.r0;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements r0 {
    public final /* synthetic */ Function4 a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ km.b c;
    public final /* synthetic */ HybridPageViewModel d;

    public final BaseViewHolder n(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return (BaseViewHolder) this.a.invoke(this.b, r5, this.c, this.d);
    }

    public c(Function4 r1, Fragment r2, km.b r3, HybridPageViewModel r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
