package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListView f442132b;

    public w(ListView r100) {
        this.f442132b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442131a;
        long r102 = System.currentTimeMillis();
        this.f442131a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f442132b.f441862e.handleAction(m7c.g.b.f512405a, null);
    }
}
