package com.bytedance.commerce.base.view;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f202931d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewTreeObserver f202932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f202933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f202934c;

    /* JADX INFO: renamed from: com.bytedance.commerce.base.view.a$a, reason: collision with other inner class name */
    public static final class C2949a {
    }

    static {
    }

    public final void a() {
        if (this.f202932a.isAlive() != true) goto L5;
        this.f202932a.removeOnPreDrawListener(this);
    L6:
        this.f202933b.removeOnAttachStateChangeListener(this);
        return;
    L5:
        this.f202933b.getViewTreeObserver().removeOnPreDrawListener(this);
        goto L6
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        a();
        this.f202934c.invoke();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f202932a = r100.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        a();
    }

    public a(View r100, Function0 r101) {
        this.f202933b = r100;
        this.f202934c = r101;
        this.f202932a = r100.getViewTreeObserver();
    }
}
