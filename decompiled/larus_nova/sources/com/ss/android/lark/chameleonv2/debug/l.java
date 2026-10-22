package com.ss.android.lark.chameleonv2.debug;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f411396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f411397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f411398c;

    public l(f r100, Context r101, String r102) {
        this.f411396a = r100;
        this.f411397b = r101;
        this.f411398c = r102;
    }

    public final void a() {
        f r100 = this.f411396a;
        w0b.a r101 = r100.f411385a;
        if (r101 != null) goto L30;
        r100.f411385a = new w0b.a(this.f411397b, this.f411398c);
        w0b.a r102 = this.f411396a.f411385a;
        if (r102 == null) goto L9;
        Dialog r103 = r102.f557830d;
        if (r103 == null) goto L9;
        r103.setCancelable(false);
    L9:
        w0b.a r104 = this.f411396a.f411385a;
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.f557831e == true) goto L41;
        Dialog r105 = r104.f557830d;
        if (r105 != null) goto L16;
    L20:
        LoadingView r106 = r104.f557828b;
        if (r106 == null) goto L29;
        ValueAnimator r107 = r106.f411421g;
        if (r107 == null) goto L25;
        r106.clearAnimation();
        r107.setRepeatCount(1);
        r107.cancel();
        r107.end();
    L25:
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.setDuration(1000);
        r108.setInterpolator(new LinearInterpolator());
        r108.setRepeatCount(-1);
        r108.setRepeatMode(1);
        r108.addUpdateListener(new w0b.b(r106));
        r108.addListener(new w0b.c());
        if (r108.isRunning() == true) goto L28;
        r108.start();
    L28:
        r106.f411421g = r108;
    L29:
        r104.f557831e = true;
        return;
    L16:
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r105);
        goto L20
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L19:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        goto L20
    L41:
        return;
    L30:
        String r109 = this.f411398c + '%';
        Intrinsics.checkNotNullParameter(r109, "msg");
        if (r101.f557831e == false) goto L35;
        TextView r110 = r101.f557829c;
        if (r110 == null) goto L35;
        r110.setText(r109);
    L35:
        r101.f557827a = r109;
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
}
