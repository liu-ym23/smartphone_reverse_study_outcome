package com.bytedance.ee.bear.middleground.comment.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentKeyboardPlaceholderView extends FrameLayout implements ocb.a {
    public static final /* synthetic */ int o = 0;
    public final String a;
    public boolean b;
    public pcb.a c;
    public a d;
    public final Runnable e;
    public final Runnable f;
    public final ocb.a g;
    public final ViewTreeObserver.OnGlobalLayoutListener h;
    public final Runnable i;
    public Runnable j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    public interface a {
        void a(int r1, boolean r2);
    }

    public final void d() {
        this.j = null;
        removeCallbacks(this.i);
        pcb.a r0 = this.c;
        if (r0 == null) goto L5;
        r0.a(this.g);
    L5:
        ViewTreeObserver r1 = getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        r1.removeOnGlobalLayoutListener(this.h);
        return;
    }

    private pcb.a getKeyboardHeightProvider() {
        if (this.c != null) goto L6;
        this.c = pcb.a.a.b((Activity) getContext());
    L6:
        return this.c;
    }

    public final void c() {
        tt5.a.h(this.a, "cancelForceKeyboardHeight");
        f(true);
        int r0 = getInitialKeyBoardHeight();
        if (getLayoutParams().height == r0) goto L5;
    L6:
        k(r0, false);
        return;
    L5:
        if (this.n == true) goto L6;
    }

    public final void e() {
        if (this.j == null) goto L14;
        Boolean r0 = h();
        if (r0 == null) goto L7;
        boolean r1 = r0.booleanValue();
    L8:
        if (r1 == true) goto L16;
        Runnable r2 = this.j;
        d();
        if (r2 == null) goto L15;
        r2.run();
        return;
    L15:
        return;
    L16:
        return;
    L7:
        r1 = getKeyboardHeightProvider().isKeyboardShowing();
        goto L8
    }

    public final void g() {
        tt5.a.h(this.a, "forceKeyboardHeight");
        f(false);
        int r1 = getKeyboardFixedHeight();
        if (getLayoutParams().height == r1) goto L5;
    L6:
        k(r1, false);
        return;
    L5:
        if (this.n == true) goto L6;
    }

    private int getFollowKeyboardHeight() {
        if (rcb.b.a(getContext()) == true) goto L5;
        Boolean r0 = h();
        if (Boolean.FALSE.equals(r0) == false) goto L9;
        return 0;
    L9:
        int r1 = getKeyboardHeightProvider().getVisibleKeyboardHeight();
        if (Boolean.TRUE.equals(r0) == false) goto L16;
        if (r1 <= 0) goto L14;
        return r1;
    L14:
        return getKeyboardFixedHeight();
    L16:
        if (getKeyboardHeightProvider().isKeyboardShowing() == true) goto L18;
        return 0;
    L18:
        return r1;
    L5:
        return getKeyboardHeightProvider().isKeyboardShowing() ? 1 : 0;
    }

    private int getInitialKeyBoardHeight() {
        if (rcb.b.a(getContext()) == true) goto L10;
        if (rcb.f.b() == true) goto L10;
        return getKeyboardFixedHeight();
    L10:
        if (getKeyboardHeightProvider().isKeyboardShowing() == true) goto L14;
        return 0;
    L14:
        return getKeyboardHeightProvider().getVisibleKeyboardHeight();
    }

    public int getKeyboardFixedHeight() {
        if (com.bytedance.ee.util.ui.n.C(getContext()) == false) goto L5;
        int r0 = 2;
    L6:
        float r2 = getKeyboardHeightProvider().keyBoardRawHeightWithOrientation(r0);
        Resources r3 = getResources();
        if (r0 != 1) goto L9;
        int r1 = 2131165647;
    L10:
        float r4 = r3.getDimensionPixelSize(r1);
        if ((0.9f * r4) <= r2) goto L15;
        r2 = r4;
    L15:
        return (int) r2;
    L9:
        r1 = 2131165646;
        goto L10
    L5:
        r0 = 1;
        goto L6
    }

    public final Boolean h() {
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.isVisible(WindowInsetsCompat.Type.ime()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h(this.a, "onAttachedToWindow");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.k = hasWindowFocus();
        this.l = false;
        this.m = false;
    L5:
        getKeyboardHeightProvider().c(this);
        postDelayed(this.e, 100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h(this.a, "onDetachedFromWindow");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L6;
        removeCallbacks(this.e);
        removeCallbacks(this.f);
        this.l = false;
        this.m = false;
    L6:
        if (this.j == null) goto L8;
        d();
    L8:
        getKeyboardHeightProvider().a(this);
    }

    public CommentKeyboardPlaceholderView(Context r2) {
        super(r2);
        this.a = "CommentKeyboardPlaceholder#" + Integer.toHexString(hashCode());
        this.b = true;
        this.e = new h(this);
        this.f = new i(this);
        this.g = new j(this);
        this.h = new k(this);
        this.i = new l(this);
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
    }

    public static void a(CommentKeyboardPlaceholderView r7) {
        r7.getClass();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
        return;
    L5:
        if (r7.b == false) goto L30;
        int r0 = r7.getFollowKeyboardHeight();
        boolean r2 = false;
        if (r7.m == false) goto L15;
        if (r0 > 0) goto L15;
        if (Boolean.FALSE.equals(r7.h()) == false) goto L15;
        if (rcb.b.a(r7.getContext()) == true) goto L15;
        boolean r1 = true;
    L16:
        r7.m = false;
        tt5.a.h(r7.a, "syncFollowKeyboardHeight height = " + r0 + ", canDismiss = " + r1);
        if (r7.getLayoutParams().height == r0) goto L19;
        r2 = true;
    L19:
        r7.k(r0, r1);
        if (r2 == true) goto L27;
        if (r1 == false) goto L28;
        a r8 = r7.d;
        if (r8 == null) goto L29;
        r8.a(r0, true);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r1 = false;
        goto L16
    }

    public static /* synthetic */ void b(CommentKeyboardPlaceholderView r2) {
        r2.k(r2.getInitialKeyBoardHeight(), false);
    }

    public final void f(boolean r4) {
        tt5.a.h(this.a, "followKeyboard " + r4);
        this.b = r4;
    }

    public final void j(boolean r3) {
        removeCallbacks(this.f);
        boolean r1 = false;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
    L11:
        this.m = false;
        return;
    L5:
        if (this.b == false) goto L11;
        if (this.m == true) goto L9;
        if (r3 == true) goto L9;
    L10:
        this.m = r1;
        postDelayed(this.f, 100);
        return;
    L9:
        r1 = true;
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        tt5.a.h(this.a, "onConfigurationChanged orientation = " + r4.orientation);
        int r0 = 1;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L13;
        if (getVisibility() != 0) goto L28;
        int r5 = getKeyboardFixedHeight();
        if (rcb.b.a(getContext()) == true) goto L10;
        r0 = r5;
    L10:
        k(r0, false);
        return;
    L28:
        return;
    L13:
        if (this.k == true) goto L18;
        if (this.b == false) goto L18;
        this.l = true;
    L18:
        if (getVisibility() != 0) goto L25;
        if (this.b == false) goto L22;
        int r6 = getFollowKeyboardHeight();
    L23:
        k(r6, false);
        goto L25
    L22:
        r6 = getKeyboardFixedHeight();
    L25:
        if (this.k == false) goto L29;
        j(false);
        return;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r4) {
        super.onWindowFocusChanged(r4);
        tt5.a.h(this.a, "onWindowFocusChanged hasWindowFocus = " + r4);
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
        return;
    L5:
        this.k = r4;
        if (r4 == false) goto L9;
        j(this.l);
        this.l = false;
        return;
    }

    public void setHostAdjustResize(boolean r1) {
        this.n = r1;
    }

    public void setKeyboardHeightProvider(pcb.a r1) {
        this.c = r1;
    }

    public void setOnHeightChangeListener(a r1) {
        this.d = r1;
    }

    public CommentKeyboardPlaceholderView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = "CommentKeyboardPlaceholder#" + Integer.toHexString(hashCode());
        this.b = true;
        this.e = new h(this);
        this.f = new i(this);
        this.g = new j(this);
        this.h = new k(this);
        this.i = new l(this);
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
    }

    public final void i(Runnable r2, Runnable r3) {
        if (this.j == null) goto L5;
        return;
    L5:
        Boolean r0 = h();
        if (r0 == null) goto L8;
        boolean r1 = r0.booleanValue();
    L9:
        if (r1 == true) goto L12;
        r3.run();
        return;
    L12:
        this.j = r3;
        getKeyboardHeightProvider().c(this.g);
        getViewTreeObserver().addOnGlobalLayoutListener(this.h);
        r2.run();
        post(this.i);
        return;
    L8:
        r1 = getKeyboardHeightProvider().isKeyboardShowing();
        goto L9
    }

    public final void k(int r4, boolean r5) {
        tt5.a.h(this.a, "updateHeight: height = " + r4 + ", canDismiss = " + r5);
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0.height == r4) goto L7;
        r0.height = r4;
        requestLayout();
        a r1 = this.d;
        if (r1 == null) goto L7;
        r1.a(r4, r5);
    L7:
        int r6 = 8;
        if (r4 <= 0) goto L10;
        int r7 = 0;
    L12:
        if (this.n == true) goto L14;
    L16:
        r6 = r7;
    L18:
        if (getVisibility() == r6) goto L21;
        setVisibility(r6);
        return;
    L21:
        return;
    L14:
        if (this.b == false) goto L16;
    L10:
        r7 = 8;
        goto L12
    }

    public CommentKeyboardPlaceholderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = "CommentKeyboardPlaceholder#" + Integer.toHexString(hashCode());
        this.b = true;
        this.e = new h(this);
        this.f = new i(this);
        this.g = new j(this);
        this.h = new k(this);
        this.i = new l(this);
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
    }

    public final void onKeyboardHeightChanged(pcb.a r3, int r4, int r5) {
        tt5.a.h(this.a, "onKeyboardHeightChanged keyboard change: " + r4 + ", orientation: " + r5 + ", followKeyboard: " + this.b);
        removeCallbacks(this.e);
        if (this.b == false) goto L6;
        k(r4, true);
        return;
    }
}
