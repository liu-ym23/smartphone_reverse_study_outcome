package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserGroupAdapter.UserGroupViewHolder f233669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserGroupAdapter f233670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserGroup f233671c;

    public f(UserGroupAdapter.UserGroupViewHolder r100, UserGroupAdapter r101, UserGroup r102) {
        this.f233669a = r100;
        this.f233670b = r101;
        this.f233671c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((UDCheckBox) this.f233669a.itemView.findViewById(R.id.share_checkbox)).setChecked(!((UDCheckBox) this.f233669a.itemView.findViewById(R.id.share_checkbox)).isChecked());
        boolean r101 = ((UDCheckBox) this.f233669a.itemView.findViewById(R.id.share_checkbox)).isChecked();
        if (r101 == false) goto L5;
        this.f233670b.f233647c.add(this.f233671c);
    L6:
        UserGroupAdapter.b r102 = this.f233670b.f233649e;
        if (r102 == null) goto L10;
        r102.h(this.f233671c, r101);
        return;
    L10:
        return;
    L5:
        this.f233670b.f233647c.remove(this.f233671c);
        goto L6
    }
}
