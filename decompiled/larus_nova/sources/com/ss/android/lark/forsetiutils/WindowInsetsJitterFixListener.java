package com.ss.android.lark.forsetiutils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/forsetiutils/WindowInsetsJitterFixListener;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "originalListener", "<init>", "(Landroidx/core/view/OnApplyWindowInsetsListener;)V", "state", "Lcom/ss/android/lark/forsetiutils/WindowInsetsJitterFixListener$StateHolder;", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", BaseSwitches.V, "Landroid/view/View;", "insets", "isTopActivityNotEquals", "", "view", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "StateHolder", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowInsetsJitterFixListener implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnApplyWindowInsetsListener f424765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f424766b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WindowInsetsCompat f424767a;

        public a() {
        }
    }

    public WindowInsetsJitterFixListener(OnApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "originalListener");
        this.f424765a = r100;
        this.f424766b = new a();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "insets");
        WindowInsetsCompat r102 = this.f424766b.f424767a;
        boolean r103 = false;
        if (r102 == null) goto L7;
        Insets r104 = r102.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r104 == null) goto L7;
        int r105 = r104.top;
    L8:
        int r106 = r101.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        boolean r107 = r100.hasWindowFocus();
        if (r105 <= 0) goto L30;
        if (r106 != 0) goto L30;
        if (r107 == false) goto L25;
        Context r108 = r100.getContext();
    L14:
        if ((r108 instanceof ContextWrapper) == false) goto L19;
        if ((r108 instanceof Activity) == true) goto L17;
        r108 = ((ContextWrapper) r108).getBaseContext();
        goto L14
    L17:
        Activity r109 = (Activity) r108;
    L20:
        if (r109 != null) goto L22;
    L24:
        if (r103 == false) goto L30;
    L22:
        if (Intrinsics.areEqual(r109, AppLifecycle.a.f408803a.f()) == true) goto L24;
        r103 = true;
        goto L24
    L19:
        r109 = null;
    L25:
        WindowInsetsCompat r110 = this.f424766b.f424767a;
        if (r110 == null) goto L29;
        this.f424765a.onApplyWindowInsets(r100, r110);
    L29:
        return WindowInsetsCompat.CONSUMED;
    L30:
        this.f424766b.f424767a = r101;
        return this.f424765a.onApplyWindowInsets(r100, r101);
    L7:
        r105 = 0;
        goto L8
    }
}
