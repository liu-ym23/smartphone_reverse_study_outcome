package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DepartmentAdapter.DepViewHolder f233453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DepartmentAdapter f233454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VisibleDepartment f233455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f233456d;

    public b(DepartmentAdapter.DepViewHolder r100, DepartmentAdapter r101, VisibleDepartment r102, boolean r103) {
        this.f233453a = r100;
        this.f233454b = r101;
        this.f233455c = r102;
        this.f233456d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((UDCheckBox) this.f233453a.itemView.findViewById(R.id.permDepCheckbox)).setChecked(!((UDCheckBox) this.f233453a.itemView.findViewById(R.id.permDepCheckbox)).isChecked());
        boolean r101 = ((UDCheckBox) this.f233453a.itemView.findViewById(R.id.permDepCheckbox)).isChecked();
        if (r101 == false) goto L5;
        this.f233454b.f233420d.add(this.f233455c);
    L6:
        DepartmentAdapter.DepViewHolder r102 = this.f233453a;
        boolean r103 = this.f233456d;
        VisibleDepartment r104 = this.f233455c;
        int r105 = DepartmentAdapter.DepViewHolder.f233426b;
        r102.T3(r101, r103, r104);
        DepartmentAdapter.b r106 = this.f233454b.f233424h;
        if (r106 == null) goto L10;
        r106.D(this.f233455c, r101);
        return;
    L10:
        return;
    L5:
        this.f233454b.f233420d.remove(this.f233455c);
        goto L6
    }
}
