package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ DepartmentAdapter.DepViewHolder a;
    public final /* synthetic */ DepartmentAdapter b;
    public final /* synthetic */ VisibleDepartment c;
    public final /* synthetic */ boolean d;

    public b(DepartmentAdapter.DepViewHolder r1, DepartmentAdapter r2, VisibleDepartment r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131382106).setChecked(!((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131382106).isChecked());
        boolean r6 = ((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131382106).isChecked();
        if (r6 == false) goto L5;
        this.b.d.add(this.c);
    L6:
        DepartmentAdapter.DepViewHolder r0 = this.a;
        boolean r1 = this.d;
        VisibleDepartment r2 = this.c;
        int r3 = DepartmentAdapter.DepViewHolder.b;
        r0.T3(r6, r1, r2);
        DepartmentAdapter.b r4 = this.b.h;
        if (r4 == null) goto L10;
        r4.D(this.c, r6);
        return;
    L10:
        return;
    L5:
        this.b.d.remove(this.c);
        goto L6
    }
}
