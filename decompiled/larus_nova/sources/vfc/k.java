package vfc;

import android.animation.ValueAnimator;
import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f554651a;

    public final void a() {
        o r100 = this.f554651a;
        if (o.a(r100.f554656a) == true) goto L6;
        return;
    L6:
        if (r100.f554657b != null) goto L9;
        com.larksuite.component.ui.dialog.d r101 = new com.larksuite.component.ui.dialog.d(r100.f554656a);
        r101.f284132c.width(1.0f);
        r101.f(1.0f);
        r101.f284132c.rootLayoutRes(R.layout.ocr_loading_dialog);
        r101.g(new l(r100));
        r101.f284132c.cancelable(false);
        r100.f554657b = r101.c();
    L9:
        if (r100.f554659d == true) goto L23;
        r100.f554659d = true;
        LKUIDialog r102 = r100.f554657b;
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r102);
    L15:
        LKUIDialog r103 = r100.f554657b;
        if (r100.f554658c != null) goto L18;
        r100.f554658c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(3000);
    L18:
        View r104 = r103.findViewById(R.id.scanningIv);
        r104.post(new j(r100, r104));
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L14:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L15
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

    public k(o r100) {
        this.f554651a = r100;
    }
}
