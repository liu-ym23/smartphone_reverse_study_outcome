package com.ss.android.lark.feed.shared.page.binder2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedCommonViewHolder f421368a;

    public j(FeedCommonViewHolder r100) {
        this.f421368a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f421368a.f276058e = 0.0f;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
