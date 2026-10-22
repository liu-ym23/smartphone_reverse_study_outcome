package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427044a;

    public a(CreationAIDragView r100) {
        this.f427044a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("CreationAIDragView", "checkKeyboardTask, isKeyboardShowing = " + this.f427044a.f426934l);     // Catch: Throwable -> L4
        this.f427044a.t(false, true, CreationAIDragView.AdjustTopSource.KEYBOARD_CHANGE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
