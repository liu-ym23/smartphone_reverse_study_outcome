package com.ss.android.lark.vote.message.cell;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.ss.android.lark.vote.message.content.VoteOption;
import com.ss.android.lark.vote.message.detail.VotePopupFacade;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteOptionsAdapter f445208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoteOption f445209b;

    public h(VoteOptionsAdapter r100, VoteOption r101) {
        this.f445208a = r100;
        this.f445209b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intent r101 = new Intent(this.f445208a.f445188a, VotePopupFacade.class);
        r101.putExtra("vote.topic", this.f445208a.f445195h);
        r101.putExtra("vote.user.num", this.f445209b.getSelectedNum());
        r101.putExtra("vote.index", this.f445209b.getOptionIndex());
        r101.putExtra("vote.id", this.f445208a.f445190c);
        r101.putExtra("chat.id", this.f445208a.f445191d);
        r101.putExtra("vote.initiator", this.f445208a.f445193f);
        r101.putExtra("vote.topic", this.f445209b.getContent());
        Context r102 = this.f445208a.f445188a;
        if (r102 == null) goto L6;
        r102.startActivity(r101);
        return;
    }
}
