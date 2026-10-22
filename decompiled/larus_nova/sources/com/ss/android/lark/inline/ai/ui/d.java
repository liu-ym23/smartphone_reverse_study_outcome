package com.ss.android.lark.inline.ai.ui;

import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427490a;

    public final void a() {
        Log.i("InlineAIDragView", "checkShowRunnable, needStartShowWhenKeyboardShow = " + this.f427490a.O);
        InlineAIDragView r100 = this.f427490a;
        if (r100.O == true) goto L5;
        return;
    L5:
        KeyboardUtils.showKeyboard(r100.f427354a);
        this.f427490a.f427355b.postDelayed(this, 200);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(InlineAIDragView r100) {
        this.f427490a = r100;
    }
}
