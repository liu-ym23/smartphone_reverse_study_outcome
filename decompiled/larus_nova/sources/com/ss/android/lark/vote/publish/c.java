package com.ss.android.lark.vote.publish;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteFragment f445292a;

    public c(VoteFragment r100) {
        this.f445292a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VoteFragment r101 = this.f445292a;
        r101.f445272n = !r101.f445272n;
    }
}
