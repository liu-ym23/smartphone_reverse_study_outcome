package com.bytedance.android.shopping.card_list.slice.widgets;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ CounterView a;

    public g(CounterView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.a.s;     // Catch: Throwable -> L4
        r0.setFocusable(true);     // Catch: Throwable -> L4
        r0.requestFocus();     // Catch: Throwable -> L4
        r0.setImportantForAccessibility(1);     // Catch: Throwable -> L4
        r0.performAccessibilityAction(64, null);     // Catch: Throwable -> L4
        r0.sendAccessibilityEvent(32768);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
