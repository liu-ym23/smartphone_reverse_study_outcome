package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ef5.y f231554a;

    public u(ef5.y r100) {
        this.f231554a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f231554a.f472517a.c("InputCommentClickMentionAddin");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
