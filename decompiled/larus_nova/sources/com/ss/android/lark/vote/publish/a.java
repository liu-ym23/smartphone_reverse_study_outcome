package com.ss.android.lark.vote.publish;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteFragment f445290a;

    public a(VoteFragment r100) {
        this.f445290a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f445290a.finish();
    }
}
