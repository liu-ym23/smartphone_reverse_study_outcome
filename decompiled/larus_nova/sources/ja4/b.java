package ja4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.bytedance.bdp.bdpbase.util.o;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f497851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f497853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f497854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f497855e;

    public void a() {
    }

    public abstract V c();

    public final void b() {
        f r100 = this.f497853c;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r100);
    L17:
        a();
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L7;
        r101.post(DialogLancet.createDismissRunnable(r100));
        goto L17
    }

    public final void d() {
        Activity r100 = this.f497851a;
        if (r100 == null) goto L8;
        InputMethodManager r101 = (InputMethodManager) r100.getApplication().getSystemService("input_method");
        View r102 = r100.getCurrentFocus();
        if (r102 == null) goto L8;
        r101.hideSoftInputFromWindow(r102.getWindowToken(), 0);
    L8:
        if (this.f497855e == true) goto L10;
    L18:
        View r103 = c();
        this.f497854d.removeAllViews();
        this.f497854d.addView(r103);
        this.f497855e = true;
        f r104 = this.f497853c;
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r104);
    L23:
        com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.d.Q = true;
        return;
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L22:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L23
    L10:
        if (this.f497851a.isFinishing() == true) goto L18;
        f r105 = this.f497853c;
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r105);
    L16:
        com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.d.Q = true;
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L15:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        goto L16
    }

    public Context getContext() {
        return this.f497853c.getContext();
    }

    public b(Activity r100) {
        this.f497855e = false;
        this.f497851a = r100;
        Resources r101 = r100.getResources();
        int r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels;
        this.f497852b = r102;
        int r103 = (int) o.a(r100, 280.0f);
        FrameLayout r104 = new FrameLayout(r100);
        this.f497854d = r104;
        r104.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f497854d.setFocusable(true);
        this.f497854d.setFocusableInTouchMode(true);
        f r105 = new f(r100, r102, r103, this.f497854d);
        this.f497853c = r105;
        r105.setCanceledOnTouchOutside(true);
        this.f497853c.setCancelable(true);
        this.f497853c.setOnKeyListener(this);
        this.f497853c.setOnDismissListener(this);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        b();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r102.getAction() == 0) goto L5;
        return false;
    L5:
        if (r101 != 4) goto L10;
        b();
        return false;
    L10:
        return false;
    }
}
