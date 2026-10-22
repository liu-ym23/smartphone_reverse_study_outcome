package ql2;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ d a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.d().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        d r0 = this.a;
        r0.e = r0.d().getWidth();
        d r1 = this.a;
        r1.f = r1.d().getHeight();
        this.a.getClass();
        d r2 = this.a;
        boolean r3 = false;
        r2.n = false;
        PopupWindow r4 = r2.a;
        if (r4 != null) goto L5;
    L7:
        if (r3 == false) goto L23;
        d r5 = this.a;
        if (r5.o == false) goto L24;
        int r6 = r5.e;
        int r8 = r5.f;
        View r9 = r5.i;
        int r7 = r5.j;
        int r10 = r5.k;
        int r11 = r5.l;
        int r12 = r5.m;
        if (r5.a == null) goto L26;
        int r13 = d.b(r9, r10, r6, r11);
        int r14 = d.c(r9, r7, r8, r12);
        PopupWindow r15 = r5.a;
        if ((r15 instanceof PopupWindow) == false) goto L19;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r15) == false) goto L19;
        r15.update(r9, r13, r14, r6, r8);
        return;
    L19:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r15, r9, r13, r14, r6, r8) == true) goto L27;
        r15.update(r9, r13, r14, r6, r8);
        return;
    L27:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (r4.isShowing() == false) goto L7;
        r3 = true;
        goto L7
    }

    public c(d r1) {
        this.a = r1;
    }
}
