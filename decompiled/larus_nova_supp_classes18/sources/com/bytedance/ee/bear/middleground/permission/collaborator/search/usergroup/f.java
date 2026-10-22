package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ UserGroupAdapter.UserGroupViewHolder a;
    public final /* synthetic */ UserGroupAdapter b;
    public final /* synthetic */ UserGroup c;

    public f(UserGroupAdapter.UserGroupViewHolder r1, UserGroupAdapter r2, UserGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131386067).setChecked(!((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131386067).isChecked());
        boolean r4 = ((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131386067).isChecked();
        if (r4 == false) goto L5;
        this.b.c.add(this.c);
    L6:
        UserGroupAdapter.b r0 = this.b.e;
        if (r0 == null) goto L10;
        r0.h(this.c, r4);
        return;
    L10:
        return;
    L5:
        this.b.c.remove(this.c);
        goto L6
    }
}
