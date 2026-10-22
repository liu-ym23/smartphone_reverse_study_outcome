package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PanelBottomDialog f411509a;

    public d(PanelBottomDialog r100) {
        this.f411509a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        PanelBottomDialog r103 = this.f411509a;
        r103.f411488w = r101.getRawY();
        this.f411509a.f411489x = false;
    L47:
        return true;
    L5:
        if (r102 != 1) goto L7;
        float r104 = r101.getRawY();
        PanelBottomDialog r105 = this.f411509a;
        float r106 = r104 - r105.f411488w;
        if (r105.f411489x == true) goto L29;
    L36:
        View r107 = r105.f411487v;
        if (r107 == null) goto L45;
        ViewPropertyAnimator r108 = r107.animate();
        if (r108 == null) goto L45;
        ViewPropertyAnimator r109 = r108.translationY(0.0f);
        if (r109 == null) goto L45;
        ViewPropertyAnimator r110 = r109.setDuration(200);
        if (r110 == null) goto L45;
        r110.start();
    L45:
        this.f411509a.f411489x = false;
        goto L47
    L29:
        if (r106 <= 100.0f) goto L36;
        r105.dismiss();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r111 = DialogFragmentLancet.sLastShowStack;
        if (r111 == null) goto L45;
        com.bytedance.crash.d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L45
    L7:
        if (r102 != 2) goto L9;
        float r112 = r101.getRawY();
        PanelBottomDialog r113 = this.f411509a;
        float r114 = r112 - r113.f411488w;
        if (r114 <= 10.0f) goto L47;
        r113.f411489x = true;
        View r115 = r113.f411487v;
        if (r115 == null) goto L47;
        r115.setTranslationY(r114);
        goto L47
    L9:
        if (r102 != 3) goto L47;
        View r116 = this.f411509a.f411487v;
        if (r116 == null) goto L20;
        ViewPropertyAnimator r117 = r116.animate();
        if (r117 == null) goto L20;
        ViewPropertyAnimator r118 = r117.translationY(0.0f);
        if (r118 == null) goto L20;
        ViewPropertyAnimator r119 = r118.setDuration(200);
        if (r119 == null) goto L20;
        r119.start();
    L20:
        this.f411509a.f411489x = false;
        goto L47
    }
}
