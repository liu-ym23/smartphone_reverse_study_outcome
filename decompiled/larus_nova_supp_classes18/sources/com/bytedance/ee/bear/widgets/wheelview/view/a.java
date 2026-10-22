package com.bytedance.ee.bear.widgets.wheelview.view;

import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import ql5.v;
import rp5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ WheelView a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView r0 = this.a;     // Catch: Throwable -> L4
        int r1 = WheelView.H0;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        WheelView r2 = this.a;     // Catch: Throwable -> L4
        b r3 = r2.g;     // Catch: Throwable -> L4
        r2.getCurrentItem();     // Catch: Throwable -> L4
        ReminderFragment r4 = ((v) r3).a;     // Catch: Throwable -> L4
        int r5 = ReminderFragment.H0;     // Catch: Throwable -> L4
        r4.pa0(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(WheelView r1) {
        this.a = r1;
    }
}
