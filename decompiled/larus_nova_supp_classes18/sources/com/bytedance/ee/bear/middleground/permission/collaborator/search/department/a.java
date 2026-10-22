package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ DepartmentAdapter a;
    public final /* synthetic */ VisibleTopUserInDep b;
    public final /* synthetic */ DepartmentAdapter.DepTopUserViewHolder c;

    public a(DepartmentAdapter r1, VisibleTopUserInDep r2, DepartmentAdapter.DepTopUserViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        boolean r4 = !this.a.e.contains(this.b);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131382117).setChecked(r4);
        if (r4 == false) goto L5;
        this.a.e.add(this.b);
    L6:
        DepartmentAdapter.b r0 = this.a.h;
        if (r0 == null) goto L10;
        r0.k(this.b, r4);
        return;
    L10:
        return;
    L5:
        this.a.e.remove(this.b);
        goto L6
    }
}
