package com.ss.android.lark.vote.message.cell;

import android.view.View;
import com.ss.android.lark.vote.message.content.VoteOption;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteOption f445210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoteOptionsAdapter.ViewHolder f445211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VoteOptionsAdapter f445212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f445213d;

    public i(VoteOption r100, VoteOptionsAdapter.ViewHolder r101, VoteOptionsAdapter r102, int r103) {
        this.f445210a = r100;
        this.f445211b = r101;
        this.f445212c = r102;
        this.f445213d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VoteOption r101 = this.f445210a;
        r101.setSelected(!r101.isSelected());
        this.f445211b.T3().setChecked(this.f445210a.isSelected());
        if (this.f445210a.isSelected() == false) goto L14;
        VoteOptionsAdapter r102 = this.f445212c;
        if (r102.f445189b != 1) goto L14;
        int r103 = r102.getItems().size();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L14;
        if (r104 == this.f445213d) goto L13;
        if (this.f445212c.getItem(r104).isSelected() == false) goto L13;
        this.f445212c.getItem(r104).setSelected(false);
    L13:
        r104 = r104 + 1;
    L14:
        VoteOptionsAdapter r105 = this.f445212c;
        r105.f445197j.setValue(Boolean.valueOf(!r105.A2().isEmpty()));
        this.f445212c.notifyDataSetChanged();
    }
}
