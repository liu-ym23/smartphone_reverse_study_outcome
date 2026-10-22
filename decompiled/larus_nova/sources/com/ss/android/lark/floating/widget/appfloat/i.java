package com.ss.android.lark.floating.widget.appfloat;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements WindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowManager f421956a;

    @Override // android.view.WindowManager
    @Deprecated(message = "Deprecated in Java")
    public final Display getDefaultDisplay() {
        return this.f421956a.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public final void removeViewImmediate(View r100) {
        this.f421956a.removeViewImmediate(r100);
    }

    public i(WindowManager r100) {
        Intrinsics.checkNotNullParameter(r100, "windowManager");
        this.f421956a = r100;
    }

    @Override // android.view.ViewManager
    public final void removeView(View r100) {
        this.f421956a.removeView(r100);
    }

    @Override // android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if ((r101 instanceof WindowManagerLayoutParamsInternal) == false) goto L7;
        WindowManager r102 = this.f421956a;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r100, r101);
        r102.addView(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException();
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View r100, ViewGroup.LayoutParams r101) {
        if ((r101 instanceof WindowManagerLayoutParamsInternal) == false) goto L13;
        if (r100 == null) goto L8;
        boolean r102 = true;
        if (r100.isAttachedToWindow() != true) goto L8;
    L9:
        if (r102 == false) goto L14;
        this.f421956a.updateViewLayout(r100, r101);
        return;
    L14:
        return;
    L8:
        r102 = false;
        goto L9
    L13:
        throw new IllegalArgumentException();
    }
}
