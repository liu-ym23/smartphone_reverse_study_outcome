package com.bytedance.locallife.live.goodsshelves.ui;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f260133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Window f260134b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
    L35:
        return false;
    L4:
        if (this.f260133a != null) goto L11;
        View r100 = this.f260134b.getDecorView();     // Catch: Exception -> L35
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L35
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L35
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Exception -> L35
    L10:
        this.f260133a = r100.findViewById(R.id.statusBarBackground);     // Catch: Exception -> L35
    L11:
        View r102 = this.f260133a;     // Catch: Exception -> L35
        if (r102 != null) goto L14;
        return true;
    L14:
        Drawable r103 = null;
        if (r102 == null) goto L17;
        Drawable r104 = r102.getBackground();     // Catch: Exception -> L35
    L18:
        if (r104 == null) goto L30;
        View r105 = this.f260133a;     // Catch: Exception -> L35
        if (r105 == null) goto L22;
        Drawable r106 = r105.getBackground();     // Catch: Exception -> L35
    L24:
        if ((r106 instanceof ColorDrawable) == false) goto L30;
        View r107 = this.f260133a;     // Catch: Exception -> L35
        if (r107 == null) goto L29;
        r103 = r107.getBackground();     // Catch: Exception -> L35
    L29:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");     // Catch: Exception -> L35
        ((ColorDrawable) r103).setColor(0);     // Catch: Exception -> L35
    L34:
        return true;
    L22:
        r106 = null;
    L30:
        View r108 = this.f260133a;     // Catch: Exception -> L35
        if (r108 == null) goto L34;
        r108.setBackground(new ColorDrawable(0));     // Catch: Exception -> L35
        goto L34
    L17:
        r104 = null;
        goto L18
    }

    public i(Window r100) {
        this.f260134b = r100;
    }
}
