package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskContainerListFragment f442355b;

    public a(TaskContainerListFragment r100) {
        this.f442355b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442354a;
        long r102 = System.currentTimeMillis();
        this.f442354a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        zab.a.a(this.f442355b);
    }
}
