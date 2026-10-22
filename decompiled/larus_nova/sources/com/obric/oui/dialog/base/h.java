package com.obric.oui.dialog.base;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractDialog f400714a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super.handleMessage(r100);
        if (r100.what != 101) goto L30;
        AbstractDialog r101 = this.f400714a;
        r101.getClass();
    L25:
        e = move-exception;
        wma.b.c(r101.f400649c, "recheckInset failed", e);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L8;
        zma.a r102 = zma.a.f572881a;     // Catch: Exception -> L25
        int r103 = zma.a.d(r101.g());     // Catch: Exception -> L25
    L9:
        if (r103 <= 0) goto L11;
        return;
    L11:
        if (r101.f400647a == false) goto L32;
        int r104 = vma.c.f556351a;     // Catch: Exception -> L25
        Object r105 = r101.g().getParent();     // Catch: Exception -> L25
        if (r105 != null) goto L16;
    L18:
        r105 = null;
    L19:
        View r106 = (View) r105;     // Catch: Exception -> L25
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.getHeight() <= r101.g().getHeight()) goto L34;
        r101.g().requestLayout();     // Catch: Exception -> L25
        wma.b.g(r101.f400649c, "recheckInset, requestLayout, parentView.height: " + r106.getHeight() + ", rootView.height: " + r101.g().getHeight());     // Catch: Exception -> L25
        return;
    L34:
        return;
    L16:
        if ((r105 instanceof View) == false) goto L18;
    L32:
        return;
    L8:
        r103 = 0;
        goto L9
    }

    public h(AbstractDialog r100, Looper r101) {
        this.f400714a = r100;
        super(r101);
    }
}
