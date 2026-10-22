package com.bytedance.android.window.shop.holder.factory;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.r0;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements r0 {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ fo.b c;

    public final BaseViewHolder n(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return (BaseViewHolder) this.a.invoke(this.b, this.c);
    }

    public e(Function2 r1, Fragment r2, fo.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
