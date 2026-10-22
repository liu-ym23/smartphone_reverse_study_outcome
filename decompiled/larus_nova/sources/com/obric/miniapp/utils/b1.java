package com.obric.miniapp.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b1 extends OSheet {
    public boolean G;
    public d1 H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final /* synthetic */ Context f398451J;

    @Override // com.obric.oui.sheet.v2.OSheet, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.G == false) goto L5;
        return;
    L5:
        this.G = true;
        Window r100 = getWindow();
        IBinder r101 = null;
        if (r100 == null) goto L8;
        View r102 = v(r100);
    L9:
        if (r102 == null) goto L11;
        View r103 = r102.findFocus();
    L12:
        Context r104 = this.f398451J;
        if (r103 != null) goto L15;
        View r105 = r102;
    L16:
        if (r105 == null) goto L18;
        r105.clearFocus();
    L18:
        if (r105 == null) goto L20;
        View r106 = r105.getRootView();
    L21:
        if (r106 == null) goto L25;
        View r107 = r106.findFocus();
        if (r107 == null) goto L25;
        r107.clearFocus();
    L25:
        if (r106 == null) goto L27;
        r106.clearFocus();
    L27:
        Object r108 = r104.getSystemService("input_method");
        if ((r108 instanceof InputMethodManager) == false) goto L30;
        InputMethodManager r109 = (InputMethodManager) r108;
    L31:
        if (r105 == null) goto L36;
        IBinder r110 = r105.getWindowToken();
        if (r110 == null) goto L36;
        r101 = r110;
    L38:
        if (r101 == null) goto L41;
        if (r109 == null) goto L41;
        r109.hideSoftInputFromWindow(r101, 0);
    L41:
        if (r103 == null) goto L44;
        r102 = r103;
    L44:
        if (r102 == null) goto L46;
        r102.post(new z0(this));
        return;
    L46:
        e();
        return;
    L36:
        if (r106 == null) goto L38;
        r101 = r106.getWindowToken();
        goto L38
    L30:
        r109 = null;
        goto L31
    L20:
        r106 = null;
        goto L21
    L15:
        r105 = r103;
        goto L16
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.OSheet, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L14;
        r100.setSoftInputMode(49);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static View v(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.I == true) goto L5;
        final d1 r100 = this.H;
        final boolean r101 = false;
        EditText r102 = null;
        if (r100 == null) goto L25;
        if (r110.getActionMasked() == 1) goto L13;
        if (r110.getActionMasked() == 3) goto L13;
    L23:
        r101 = true;
    L47:
        if (r101 == false) goto L50;
        return true;
    L50:
        return super.dispatchTouchEvent(r110);
    L13:
        if (r110.getActionMasked() == 1) goto L15;
    L22:
        this.H = null;
        View r103 = r100.f398463a;
        final Context r104 = this.f398451J;
        r103.post(new y0(r104, r100, r101, this));
        goto L23
    L15:
        if (Math.abs(r110.getRawX() - r100.f398464b) < 24.0f) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L22;
        r101 = true;
        goto L22
    L17:
        if (Math.abs(r110.getRawY() - r100.f398465c) >= 24.0f) goto L19;
        r105 = true;
        goto L20
    L25:
        if (r110.getActionMasked() != 0) goto L47;
        Window r106 = getWindow();
        if (r106 == null) goto L47;
        View r107 = v(r106);
        if (r107 == null) goto L47;
        View r108 = r107.findFocus();
        if ((r108 instanceof EditText) == false) goto L35;
        r102 = (EditText) r108;
    L35:
        EditText r109 = r102;
        if (r109 == null) goto L47;
        Rect r111 = new Rect();
        r109.getGlobalVisibleRect(r111);
        if (r111.contains((int) r110.getRawX(), (int) r110.getRawY()) == true) goto L47;
        View r112 = c1.b(r107, r110.getRawX(), r110.getRawY());
        if (r112 != null) goto L44;
    L46:
        r109.clearFocus();
        r107.requestFocus();
        this.H = new d1(r109, r110.getRawX(), r110.getRawY(), r110.getX(), r110.getY());
        goto L23
    L44:
        if ((r112 instanceof EditText) == true) goto L46;
    L5:
        return super.dispatchTouchEvent(r110);
    }

    public b1(Context r100, int r101) {
        this.f398451J = r100;
        super(r100, r101, false, 28);
    }
}
