package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioKBPlugin f429937a;

    public f(AudioKBPlugin r100, MotionEvent r101) {
        this.f429937a = r100;
    }

    public final void a() {
        this.f429937a.J().e(null);
        throw null;
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
}
