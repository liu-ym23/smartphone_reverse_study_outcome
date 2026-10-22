package com.ss.android.lark.inline.ai.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427487a;

    public c(InlineAIDragView r100) {
        this.f427487a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("InlineAIDragView", "checkKeyboardTask, isKeyboardShowing = " + this.f427487a.f427364k);     // Catch: Throwable -> L4
        this.f427487a.n(false, true, InlineAIDragView.AdjustTopSource.KEYBOARD_CHANGE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
