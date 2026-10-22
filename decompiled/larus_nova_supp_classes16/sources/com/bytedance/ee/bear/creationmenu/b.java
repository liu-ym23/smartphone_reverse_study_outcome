package com.bytedance.ee.bear.creationmenu;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ CreationMenuItemAdapter b;
    public final /* synthetic */ CreationMenuItemAdapter.ViewHolder c;

    public b(a r1, CreationMenuItemAdapter r2, CreationMenuItemAdapter.ViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        a r4 = this.a;
        if (r4 == null) goto L8;
        Function2<? super a, ? super View, Unit> r0 = this.b.c;
        if (r0 == null) goto L9;
        r0.invoke(r4, ((RecyclerView.ViewHolder) this.c).itemView);
        return;
    L9:
        return;
    }
}
