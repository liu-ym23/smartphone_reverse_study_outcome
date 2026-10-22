package com.bytedance.android.shopping.jedi;

import android.view.View;
import com.bytedance.android.ec.core.jedi.PullUpLoadMoreHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LoadMoreRecyclerViewAdapter.LoadMoreViewHolder a;

    public a(LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function0<Unit> r3 = this.a.c.r;
        if (r3 == null) goto L5;
        Intrinsics.checkNotNull(r3);
        r3.invoke();
    L5:
        PullUpLoadMoreHelper r4 = this.a.a;
        if (r4 == null) goto L10;
        if (r4 == null) goto L11;
        r4.a = false;
        return;
    L11:
        return;
    }
}
