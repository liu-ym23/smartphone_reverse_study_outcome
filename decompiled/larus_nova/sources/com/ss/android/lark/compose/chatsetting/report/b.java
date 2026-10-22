package com.ss.android.lark.compose.chatsetting.report;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f417517a;

    public b(View r100) {
        this.f417517a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f417517a;     // Catch: Throwable -> L4
        r100.setTranslationY(r100.getMeasuredHeight());     // Catch: Throwable -> L4
        r100.animate().translationY(0.0f).setDuration(200).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
