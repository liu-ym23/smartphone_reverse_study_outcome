package com.bytedance.widget;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* JADX INFO: loaded from: classes22.dex */
public class Widget_LifecycleAdapter implements GeneratedAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Widget f272657a;

    public Widget_LifecycleAdapter(Widget r100) {
        this.f272657a = r100;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public final void callMethods(LifecycleOwner r100, Lifecycle.Event r101, boolean r102, MethodCallsLogger r103) {
        if (r103 == null) goto L5;
        boolean r104 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        if (r101 != Lifecycle.Event.ON_CREATE) goto L16;
        if (r104 == true) goto L12;
    L13:
        this.f272657a.create$widget_release();
        return;
    L12:
        if (r103.approveCall("create$widget_release", 1) == true) goto L13;
        return;
    L16:
        if (r101 != Lifecycle.Event.ON_START) goto L23;
        if (r104 == true) goto L19;
    L20:
        this.f272657a.start$widget_release();
        return;
    L19:
        if (r103.approveCall("start$widget_release", 1) == true) goto L20;
        return;
    L23:
        if (r101 != Lifecycle.Event.ON_RESUME) goto L30;
        if (r104 == true) goto L26;
    L27:
        this.f272657a.resume$widget_release();
        return;
    L26:
        if (r103.approveCall("resume$widget_release", 1) == true) goto L27;
        return;
    L30:
        if (r101 != Lifecycle.Event.ON_PAUSE) goto L37;
        if (r104 == true) goto L33;
    L34:
        this.f272657a.pause$widget_release();
        return;
    L33:
        if (r103.approveCall("pause$widget_release", 1) == true) goto L34;
        return;
    L37:
        if (r101 != Lifecycle.Event.ON_STOP) goto L44;
        if (r104 == true) goto L40;
    L41:
        this.f272657a.stop$widget_release();
        return;
    L40:
        if (r103.approveCall("stop$widget_release", 1) == true) goto L41;
        return;
    L44:
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L55;
        if (r104 == true) goto L47;
    L48:
        this.f272657a.destroy$widget_release();
        return;
    L47:
        if (r103.approveCall("destroy$widget_release", 1) == true) goto L48;
        return;
    L55:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
