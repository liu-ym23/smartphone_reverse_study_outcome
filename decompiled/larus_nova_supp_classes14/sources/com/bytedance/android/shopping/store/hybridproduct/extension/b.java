package com.bytedance.android.shopping.store.hybridproduct.extension;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.r0;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements r0 {
    public final /* synthetic */ Function5 a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ km.b c;
    public final /* synthetic */ ECShopHybridProductViewModel d;
    public final /* synthetic */ ECStoreViewModel e;

    public final BaseViewHolder n(ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        return (BaseViewHolder) this.a.invoke(this.b, r8, this.c, this.d, this.e);
    }

    public b(Function5 r1, Fragment r2, km.b r3, ECShopHybridProductViewModel r4, ECStoreViewModel r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
