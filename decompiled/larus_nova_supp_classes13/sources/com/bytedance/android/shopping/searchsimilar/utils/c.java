package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.shopping.searchsimilar.view.SearchSimilarAuthorizationDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ SearchSimilarAuthorizationDialog a;

    public c(SearchSimilarAuthorizationDialog r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchSimilarAuthorizationDialog r0 = this.a;     // Catch: Throwable -> L9
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r0);     // Catch: Throwable -> L9
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14 Throwable -> L9
    L7:
        DialogLancet.beforeDialogShow(r0);     // Catch: Throwable -> L9
        r0.show();     // Catch: Throwable -> L9
        DialogLancet.afterDialogShow(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
