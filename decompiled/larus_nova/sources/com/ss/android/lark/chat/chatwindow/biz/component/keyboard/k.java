package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f412098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f412099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Animator f412100c;

    public k(MessageListAnimationContainer r100, d r101, Animator r102) {
        this.f412098a = r100;
        this.f412099b = r101;
        this.f412100c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f412099b.f412081d = false;     // Catch: Throwable -> L4
        this.f412100c.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
