package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DepartmentAdapter f233450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VisibleTopUserInDep f233451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DepartmentAdapter.DepTopUserViewHolder f233452c;

    public a(DepartmentAdapter r100, VisibleTopUserInDep r101, DepartmentAdapter.DepTopUserViewHolder r102) {
        this.f233450a = r100;
        this.f233451b = r101;
        this.f233452c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        boolean r101 = !this.f233450a.f233421e.contains(this.f233451b);
        ((UDCheckBox) this.f233452c.itemView.findViewById(R.id.permDepTopUserCheckbox)).setChecked(r101);
        if (r101 == false) goto L5;
        this.f233450a.f233421e.add(this.f233451b);
    L6:
        DepartmentAdapter.b r102 = this.f233450a.f233424h;
        if (r102 == null) goto L10;
        r102.k(this.f233451b, r101);
        return;
    L10:
        return;
    L5:
        this.f233450a.f233421e.remove(this.f233451b);
        goto L6
    }
}
