package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.widget.PopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterSectionView f442028a;

    public g(FilterSectionView r100) {
        this.f442028a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PopupWindow r100 = this.f442028a.f441844f;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);     // Catch: Throwable -> L7
        r100.dismiss();     // Catch: Throwable -> L7
    L5:
        this.f442028a.f441848j = null;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
