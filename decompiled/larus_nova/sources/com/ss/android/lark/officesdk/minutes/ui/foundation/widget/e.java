package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.animation.TranslateAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmSummaryLoadingTextView f435752a;

    public e(MmSummaryLoadingTextView r100) {
        this.f435752a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmSummaryLoadingTextView r100 = this.f435752a;     // Catch: Throwable -> L10
        if (r100.f435718e == true) goto L5;
        return;
    L5:
        if (r100.isAttachedToWindow() == false) goto L17;
        MmSummaryLoadingTextView r101 = this.f435752a;     // Catch: Throwable -> L10
        TranslateAnimation r102 = r101.f435716c;     // Catch: Throwable -> L10
        if (r102 == null) goto L18;
        r101.f435715b.startAnimation(r102);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
