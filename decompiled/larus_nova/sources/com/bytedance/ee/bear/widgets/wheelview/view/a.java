package com.bytedance.ee.bear.widgets.wheelview.view;

import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import ql5.v;
import rp5.b;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f240456a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView r100 = this.f240456a;     // Catch: Throwable -> L4
        int r101 = WheelView.H0;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        WheelView r102 = this.f240456a;     // Catch: Throwable -> L4
        b r103 = r102.f240432g;     // Catch: Throwable -> L4
        r102.getCurrentItem();     // Catch: Throwable -> L4
        ReminderFragment r104 = ((v) r103).f533808a;     // Catch: Throwable -> L4
        int r105 = ReminderFragment.H0;     // Catch: Throwable -> L4
        r104.pa0(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(WheelView r100) {
        this.f240456a = r100;
    }
}
