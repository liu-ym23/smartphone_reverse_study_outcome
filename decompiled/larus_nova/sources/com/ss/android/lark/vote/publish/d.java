package com.ss.android.lark.vote.publish;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteFragment f445293a;

    public d(VoteFragment r100) {
        this.f445293a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VoteFragment r101 = this.f445293a;
        r101.f445273o = !r101.f445273o;
    }
}
