package m5a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FlutterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f512171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f512172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f512173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlutterView f512174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DialogInterface.OnKeyListener f512175e;

    public final void c() {
        if (this.f512172b == true) goto L5;
        return;
    L5:
        Window r100 = getWindow();
        if (isShowing() == false) goto L11;
        if (r100 == null) goto L12;
        this.f512172b = false;
        r100.clearFlags(8);
        h.f512176e.c();
        return;
    L12:
        return;
    }

    public final void d() {
        Activity r100 = getOwnerActivity();
        if (r100 != null) goto L5;
        r100 = t5a.b.getActivity(getContext());
    L5:
        if (r100 != null) goto L7;
        Window r101 = null;
    L8:
        Window r102 = getWindow();
        if (r101 == null) goto L18;
        if (r102 == null) goto L20;
        View r103 = a(r101);
        View r104 = a(r102);
        if (r103 == null) goto L19;
        if (r104 == null) goto L21;
        r104.setSystemUiVisibility(r103.getSystemUiVisibility());
        r102.setStatusBarColor(r101.getStatusBarColor());
        r102.setNavigationBarColor(r101.getNavigationBarColor());
        return;
    L21:
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L7:
        r101 = r100.getWindow();
        goto L8
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Context r100 = getContext();
        boolean r101 = true;
        if ((r100 instanceof Activity) == false) goto L11;
        Activity r102 = (Activity) r100;
        if (r102.isFinishing() == false) goto L8;
        byte r103 = -1;
    L12:
        if (r103 < 0) goto L15;
        r101 = false;
    L15:
        if (r101 == true) goto L33;
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L19;
    L21:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L24 Exception -> L26
    L30:
        DialogLancet.afterDialogDismiss(this);
        return;
    L24:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
        if (r105 == null) goto L30;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
        goto L30
    L19:
        if (Looper.myLooper() == r104.getLooper()) goto L21;
        r104.post(DialogLancet.createDismissRunnable(this));
        return;
    L33:
        return;
    L8:
        if (r102.isDestroyed() == false) goto L10;
        r103 = -2;
        goto L12
    L10:
        r103 = 0;
        goto L12
    L11:
        r103 = 1;
        goto L12
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f512171a.e();
    }

    @Override // android.app.Dialog
    public final void show() {
        Context r100 = getContext();
        boolean r101 = true;
        if ((r100 instanceof Activity) == false) goto L11;
        Activity r102 = (Activity) r100;
        if (r102.isFinishing() == false) goto L8;
        byte r103 = -1;
    L12:
        if (r103 >= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        return;
    L17:
        Window r105 = getWindow();
        if (r105 != null) goto L20;
        boolean r106 = false;
    L25:
        if (r105 == null) goto L28;
        if (r106 == true) goto L28;
    L29:
        this.f512172b = r101;
        d();
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(this);
    L34:
        Window r107 = getWindow();
        if (r107 == null) goto L37;
        r107.setLayout(-1, -1);
        r107.setBackgroundDrawable(new ColorDrawable(0));
    L37:
        d();
        return;
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L33:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    L28:
        r101 = false;
        goto L29
    L20:
        if ((r105.getAttributes().flags & 8) != 8) goto L22;
        r106 = true;
    L23:
        r105.clearFlags(131072);
        r105.setFlags(8, 8);
        goto L25
    L22:
        r106 = false;
        goto L23
    L14:
        r104 = false;
        goto L15
    L8:
        if (r102.isDestroyed() == false) goto L10;
        r103 = -2;
        goto L12
    L10:
        r103 = 0;
        goto L12
    L11:
        r103 = 1;
        goto L12
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void b(final View r100) {
        if (this.f512172b == true) goto L5;
        return;
    L5:
        Window r101 = getWindow();
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = a(r101);
        if (r100 != null) goto L12;
        r100 = r102;
    L12:
        if (r100 != null) goto L15;
        c();
        return;
    L15:
        r100.postOnAnimation(new e(this, r100));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100.getAction() != 0) goto L8;
        if (r100.getRepeatCount() != 0) goto L8;
        this.f512171a.getKeyDispatcherState().startTracking(r100, this);
    L10:
        DialogInterface.OnKeyListener r101 = this.f512175e;
        if (r101 == null) goto L14;
        r101.onKey(this, r100.getKeyCode(), r100);
    L14:
        if (r100.getKeyCode() == 97) goto L40;
        if (r100.getKeyCode() == 96) goto L40;
        if (r100.getKeyCode() == 99) goto L40;
        if (r100.getKeyCode() == 100) goto L40;
        if (r100.getKeyCode() == 109) goto L40;
        if (r100.getKeyCode() == 108) goto L40;
        if (r100.getKeyCode() == 160) goto L40;
        FlutterView r102 = this.f512174d;
        if (r102 == null) goto L35;
        if (r102.getAndroidKeyProcessor() == null) goto L35;
        if (this.f512174d.getAndroidKeyProcessor().a(r100) == false) goto L35;
        return true;
    L35:
        if (super.dispatchKeyEvent(r100) == true) goto L42;
        return false;
    L42:
        return true;
    L40:
        return super.dispatchKeyEvent(r100);
    L8:
        if (r100.getAction() != 1) goto L10;
        this.f512171a.getKeyDispatcherState().handleUpEvent(r100);
        goto L10
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == false) goto L6;
        this.f512171a.e();
        return;
    }

    @Override // android.app.Dialog
    public final void setOnKeyListener(DialogInterface.OnKeyListener r100) {
        super.setOnKeyListener(r100);
        this.f512175e = r100;
    }

    public g(Context r100, q r101, FlutterView r102) {
        super(r100, R.array.appease_text);
        this.f512173c = 1;
        this.f512175e = null;
        this.f512171a = r101;
        this.f512174d = r102;
        Activity r103 = t5a.b.getActivity(r100);
        if (r103 == null) goto L6;
        setOwnerActivity(r103);
        return;
    }
}
