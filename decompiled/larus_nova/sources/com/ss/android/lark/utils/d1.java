package com.ss.android.lark.utils;

import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewUtils.b f444705a;

    public final void a() {
        ViewUtils.b r100 = this.f444705a;
        if (ViewUtils.isActivityAlive(r100.f444677b) == true) goto L6;
        return;
    L6:
        if (r100.f444678c != null) goto L13;
        com.larksuite.component.ui.dialog.d r101 = new com.larksuite.component.ui.dialog.d(r100.f444677b);
        r101.f284132c.width(1.0f);
        r101.f(1.0f);
        int r102 = r100.c();
        r101.f284132c.rootLayoutRes(r102);
        r101.g(new e1(r100));
        DialogInterface.OnCancelListener r103 = r100.f444682g;
        if (r103 == null) goto L10;
        r101.f284132c.onCancelListener(r103);
    L11:
        LKUIDialog r104 = r100.d(r101).c();
        r100.f444678c = r104;
        r104.setOnDismissListener(new ViewUtils.d(r100));
        goto L13
    L10:
        r101.f284132c.cancelable(false);
    L13:
        if (r100.f444684i == true) goto L23;
        r100.f444684i = true;
        LKUIDialog r105 = r100.f444678c;
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        return;
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

    public d1(ViewUtils.b r100) {
        this.f444705a = r100;
    }
}
