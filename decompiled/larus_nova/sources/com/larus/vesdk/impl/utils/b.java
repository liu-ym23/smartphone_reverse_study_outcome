package com.larus.vesdk.impl.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f375614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f375615b;

    public static final class a {
    }

    static {
    }

    public b(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f375614a = r100;
        this.f375615b = LazyKt.lazy(new com.larus.vesdk.impl.utils.a(this));
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

    public final void b(boolean r100) {
        Window r101 = this.f375614a.getWindow();
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r100 == false) goto L5;
        float r103 = 1.0f;
    L6:
        r102.screenBrightness = r103;
        r101.setAttributes(r102);
        if (r100 == false) goto L15;
        ViewParent r104 = ((View) this.f375615b.getValue()).getParent();
        if ((r104 instanceof ViewGroup) == false) goto L11;
        ViewGroup r105 = (ViewGroup) r104;
    L12:
        if (r105 == null) goto L14;
        r105.removeView((View) this.f375615b.getValue());
    L14:
        View r106 = a(this.f375614a.getWindow());
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r106).addView((View) this.f375615b.getValue());
        return;
    L11:
        r105 = null;
        goto L12
    L15:
        View r107 = a(this.f375614a.getWindow());
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r107).removeView((View) this.f375615b.getValue());
        return;
    L5:
        r103 = -1.0f;
        goto L6
    }
}
