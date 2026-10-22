package com.lynx.tasm.behavior;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes32.dex */
public final class p implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.e f382163a;

    public p(n.e r100) {
        this.f382163a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View r100, View r101) {
        n.e r102 = this.f382163a;
        n.d r103 = r102.i(r100);
        n.d r104 = r102.i(r101);
        if (r103 == null) goto L5;
        r102.r(r103.f382128a.get());
    L5:
        if (r104 == null) goto L7;
        r102.b(r104);
        return;
    L7:
        if (r103 == null) goto L33;
        Object r105 = r103.f382128a.get();
        n.d r106 = r102.j();
        if (r106 != null) goto L11;
    L30:
        r102.r(r105);
        return;
    L11:
        if (r106.b(r105) == false) goto L30;
        r102.q(null);
        r102.r(r105);
        if (r102.f382141i > 0) goto L34;
        boolean r107 = false;
        if (r102.f382143k == false) goto L17;
    L29:
        r102.l(r107);
        return;
    L17:
        if (Build.VERSION.SDK_INT >= 30) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == true) goto L24;
    L26:
        boolean r109 = false;
    L27:
        if (r109 == true) goto L29;
        r107 = true;
        goto L29
    L24:
        if (r102.f382146n == 0) goto L26;
        r109 = true;
        goto L27
    L19:
        if (r102.f382139g == null) goto L21;
        r108 = true;
        goto L22
    L34:
        return;
    }
}
