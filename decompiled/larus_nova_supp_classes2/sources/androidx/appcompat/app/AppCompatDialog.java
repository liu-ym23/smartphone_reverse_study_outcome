package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDialog extends Dialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public static /* synthetic */ void access$000(Dialog r0) {
        super.dismiss();
    }

    public void onSupportActionModeFinished(ActionMode r1) {
    }

    public void onSupportActionModeStarted(ActionMode r1) {
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r1) {
        return null;
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        INVOKESPECIAL_androidx_appcompat_app_AppCompatDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        getDelegate().onDestroy();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public AppCompatDialog(Context r2) {
        this(r2, 0);
    }

    public static void INVOKESPECIAL_androidx_appcompat_app_AppCompatDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        access$000(r3);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r3) {
        View r0 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow());
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, r0, this, r3);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int r2) {
        return (T) getDelegate().findViewById(r2);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r2) {
        getDelegate().installViewFactory();
        super.onCreate(r2);
        getDelegate().onCreate(r2);
    }

    @Override // android.app.Dialog
    public void setContentView(int r2) {
        getDelegate().setContentView(r2);
    }

    @Override // android.app.Dialog
    public void setTitle(int r3) {
        super.setTitle(r3);
        getDelegate().setTitle(getContext().getString(r3));
    }

    boolean superDispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    public boolean supportRequestWindowFeature(int r2) {
        return getDelegate().requestWindowFeature(r2);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2) {
        getDelegate().setContentView(r2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r2) {
        super.setTitle(r2);
        getDelegate().setTitle(r2);
    }

    public AppCompatDialog(Context r2, int r3) {
        super(r2, getThemeResId(r2, r3));
        this.mKeyDispatcher = new AnonymousClass1(this);
        AppCompatDelegate r0 = getDelegate();
        r0.setTheme(getThemeResId(r2, r3));
        r0.onCreate(null);
    }

    private static int getThemeResId(Context r2, int r3) {
        if (r3 != 0) goto L5;
        TypedValue r4 = new TypedValue();
        r2.getTheme().resolveAttribute(2130969753, r4, true);
        return r4.resourceId;
    L5:
        return r3;
    }

    @Override // android.app.Dialog
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        getDelegate().addContentView(r2, r3);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        getDelegate().setContentView(r2, r3);
    }

    public AppCompatDialog(Context r1, boolean r2, DialogInterface.OnCancelListener r3) {
        super(r1, r2, r3);
        this.mKeyDispatcher = new AnonymousClass1(this);
    }
}
