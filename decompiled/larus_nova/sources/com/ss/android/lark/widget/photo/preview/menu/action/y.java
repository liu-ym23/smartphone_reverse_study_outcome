package com.ss.android.lark.widget.photo.preview.menu.action;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f446929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f446930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f446931c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f446931c.b(this.f446929a, this.f446930b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public y(w r100, String r101, String r102) {
        this.f446931c = r100;
        this.f446929a = r101;
        this.f446930b = r102;
    }
}
