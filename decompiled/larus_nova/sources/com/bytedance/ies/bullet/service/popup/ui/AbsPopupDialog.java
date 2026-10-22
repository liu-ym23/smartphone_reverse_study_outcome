package com.bytedance.ies.bullet.service.popup.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPopupDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f247981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Boolean> f247982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f247983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f247984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f247985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f247986f;

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.f247984d == false) goto L5;
        return;
    L5:
        this.f247984d = true;
        Function0<Unit> r100 = this.f247985e;
        if (r100 == null) goto L8;
        r100.invoke();
        return;
    L8:
        L0();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Function0<Unit> r100 = this.f247983c;
        if (r100 == null) goto L5;
        r100.invoke();
        return;
    L5:
        super.onBackPressed();
    }

    public final void J0() {
        Window r100 = getWindow();
        if (r100 == null) goto L22;
        r100.clearFlags(1024);
        r100.setSoftInputMode(16);
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r100.clearFlags(2);
        r100.clearFlags(67108864);
        r100.addFlags(Integer.MIN_VALUE);
        r100.setStatusBarColor(0);
        View r101 = r100.findViewById(R.id.content);
        if (r101 == null) goto L11;
        r101.setForeground(null);
    L11:
        View r102 = I0(r100);
        r102.setPadding(0, 0, 0, 0);
        Activity r103 = getOwnerActivity();
        if (r103 == null) goto L18;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L18;
        View r105 = I0(r104);
        if (r105 == null) goto L18;
        r102.setSystemUiVisibility(r105.getSystemUiVisibility());
    L18:
        Activity r106 = getOwnerActivity();
        if (r106 == null) goto L23;
        r100.setNavigationBarColor(r106.getWindow().getNavigationBarColor());
        return;
    L23:
        return;
    L10:
        r100.setStatusBarColor(0);
        goto L11
    }

    public final void L0() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        Window r100 = getWindow();
        if (r100 == null) goto L35;
        r100.setFlags(8, 8);
    L35:
    L29:
        th = move-exception;
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.j("AbsPopupDialog show error: " + th, LogLevel.E, "XPopup");
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L33;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Throwable -> L29
    L11:
        Activity r102 = getOwnerActivity();     // Catch: Throwable -> L29
        if (r102 == null) goto L25;
        Window r103 = r102.getWindow();     // Catch: Throwable -> L29
        if (r103 == null) goto L25;
        View r104 = I0(r103);     // Catch: Throwable -> L29
        if (r104 == null) goto L25;
        int r105 = r104.getSystemUiVisibility();     // Catch: Throwable -> L29
        if (this.f247986f == true) goto L20;
        r105 = r105 ^ 512;     // Catch: Throwable -> L29
    L20:
        Window r106 = getWindow();     // Catch: Throwable -> L29
        if (r106 == null) goto L25;
        View r107 = I0(r106);     // Catch: Throwable -> L29
        if (r107 == null) goto L25;
        r107.setSystemUiVisibility(r105);     // Catch: Throwable -> L29
    L25:
        Window r108 = getWindow();     // Catch: Throwable -> L29
        if (r108 == null) goto L37;
        r108.clearFlags(8);     // Catch: Throwable -> L29
        return;
    L37:
        return;
    L33:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32 Throwable -> L29
    L10:
        DialogLancet.beforeDialogShow(this);     // Catch: Throwable -> L29
        super.show();     // Catch: Throwable -> L29
        DialogLancet.afterDialogShow(this);     // Catch: Throwable -> L29
        goto L11
    }

    public static View I0(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        supportRequestWindowFeature(1);
        super.setContentView(r100);
        r100.setFitsSystemWindows(false);
        J0();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r100) {
        supportRequestWindowFeature(1);
        super.setContentView(r100);
        J0();
    }

    public AbsPopupDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f247986f = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        supportRequestWindowFeature(1);
        super.setContentView(r100, r101);
        J0();
    }
}
