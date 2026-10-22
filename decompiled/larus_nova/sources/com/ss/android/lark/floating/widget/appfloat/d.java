package com.ss.android.lark.floating.widget.appfloat;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vfb.a f421941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wfb.e f421942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f421943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f421944d;

    public interface a {
        void a();

        void onConfigurationChanged(Configuration r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f421941a.getClass();
        wfb.a r100 = this.f421941a.B;
        if (r100 == null) goto L10;
        wfb.a.C8107a r101 = r100.a();
        if (r101 == null) goto L11;
        Function0<Unit> r102 = r101.f559498b;
        if (r102 == null) goto L12;
        r102.invoke();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final a getLayoutListener() {
        return this.f421943c;
    }

    public final wfb.e getTouchListener() {
        return this.f421942b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent r100) {
        if (this.f421941a.f554617l == false) goto L19;
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L19;
        if (r100.getKeyCode() != 4) goto L19;
        c r102 = c.f421938a;
        String r103 = this.f421941a.f554609d;
        if (r103 != null) goto L15;
        r103 = "default";
    L15:
        int r104 = xfb.f.f563557a;
        AppFloatManager r105 = c.a(r103);
        if (r105 == null) goto L19;
        ((WindowManager.LayoutParams) r105.e().f421955a).flags = 40;
        r105.f().updateViewLayout(r105.f421879e, r105.e().f421955a);
        Unit r106 = Unit.INSTANCE;
        goto L19
    L6:
        if (r100.getAction() != 0) goto L8;
        r101 = true;
    L19:
        return super.dispatchKeyEventPreIme(r100);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        a r101 = this.f421943c;
        if (r101 == null) goto L6;
        r101.onConfigurationChanged(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L7;
        wfb.e r101 = this.f421942b;
        if (r101 == null) goto L7;
        r101.onTouch(r100);
    L7:
        if (this.f421941a.f554614i == false) goto L9;
    L12:
        return true;
    L9:
        if (super.onInterceptTouchEvent(r100) == true) goto L12;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L7;
        wfb.e r101 = this.f421942b;
        if (r101 == null) goto L7;
        r101.onTouch(r100);
    L7:
        if (this.f421941a.f554614i == false) goto L9;
    L12:
        return true;
    L9:
        if (super.onTouchEvent(r100) == true) goto L12;
        return false;
    }

    public final void setLayoutListener(a r100) {
        this.f421943c = r100;
    }

    public final void setTouchListener(wfb.e r100) {
        this.f421942b = r100;
    }

    public d(Context r100, vfb.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100, null, 0);
        this.f421941a = r101;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f421944d == true) goto L8;
        this.f421944d = true;
        a r105 = this.f421943c;
        if (r105 == null) goto L9;
        r105.a();
        return;
    L9:
        return;
    }
}
