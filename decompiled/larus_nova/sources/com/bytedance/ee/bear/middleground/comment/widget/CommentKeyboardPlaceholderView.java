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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class CommentKeyboardPlaceholderView extends FrameLayout implements ocb.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f232279o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f232281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pcb.a f232282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f232283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f232284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f232285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ocb.a f232286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f232287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f232288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f232289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f232290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f232291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f232292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f232293n;

    public interface a {
        void a(int r100, boolean r101);
    }

    public final void d() {
        this.f232289j = null;
        removeCallbacks(this.f232288i);
        pcb.a r100 = this.f232282c;
        if (r100 == null) goto L5;
        r100.a(this.f232286g);
    L5:
        ViewTreeObserver r101 = getViewTreeObserver();
        if (r101.isAlive() == false) goto L9;
        r101.removeOnGlobalLayoutListener(this.f232287h);
        return;
    }

    private pcb.a getKeyboardHeightProvider() {
        if (this.f232282c != null) goto L6;
        this.f232282c = pcb.a.AbstractC7181a.b((Activity) getContext());
    L6:
        return this.f232282c;
    }

    public final void c() {
        tt5.a.h(this.f232280a, "cancelForceKeyboardHeight");
        f(true);
        int r100 = getInitialKeyBoardHeight();
        if (getLayoutParams().height == r100) goto L5;
    L6:
        k(r100, false);
        return;
    L5:
        if (this.f232293n == true) goto L6;
    }

    public final void e() {
        if (this.f232289j == null) goto L14;
        Boolean r100 = h();
        if (r100 == null) goto L7;
        boolean r101 = r100.booleanValue();
    L8:
        if (r101 == true) goto L16;
        Runnable r102 = this.f232289j;
        d();
        if (r102 == null) goto L15;
        r102.run();
        return;
    L15:
        return;
    L16:
        return;
    L7:
        r101 = getKeyboardHeightProvider().isKeyboardShowing();
        goto L8
    }

    public final void g() {
        tt5.a.h(this.f232280a, "forceKeyboardHeight");
        f(false);
        int r100 = getKeyboardFixedHeight();
        if (getLayoutParams().height == r100) goto L5;
    L6:
        k(r100, false);
        return;
    L5:
        if (this.f232293n == true) goto L6;
    }

    private int getFollowKeyboardHeight() {
        if (rcb.b.a(getContext()) == true) goto L5;
        Boolean r100 = h();
        if (Boolean.FALSE.equals(r100) == false) goto L9;
        return 0;
    L9:
        int r101 = getKeyboardHeightProvider().getVisibleKeyboardHeight();
        if (Boolean.TRUE.equals(r100) == false) goto L16;
        if (r101 <= 0) goto L14;
        return r101;
    L14:
        return getKeyboardFixedHeight();
    L16:
        if (getKeyboardHeightProvider().isKeyboardShowing() == true) goto L18;
        return 0;
    L18:
        return r101;
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
        int r100 = 2;
    L6:
        float r101 = getKeyboardHeightProvider().keyBoardRawHeightWithOrientation(r100);
        Resources r102 = getResources();
        if (r100 != 1) goto L9;
        int r103 = R.dimen.comment_keyboard_height_portrait;
    L10:
        float r104 = r102.getDimensionPixelSize(r103);
        if ((0.9f * r104) <= r101) goto L15;
        r101 = r104;
    L15:
        return (int) r101;
    L9:
        r103 = R.dimen.comment_keyboard_height_landscape;
        goto L10
    L5:
        r100 = 1;
        goto L6
    }

    public final Boolean h() {
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.isVisible(WindowInsetsCompat.Type.ime()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h(this.f232280a, "onAttachedToWindow");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.f232290k = hasWindowFocus();
        this.f232291l = false;
        this.f232292m = false;
    L5:
        getKeyboardHeightProvider().c(this);
        postDelayed(this.f232284e, 100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h(this.f232280a, "onDetachedFromWindow");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L6;
        removeCallbacks(this.f232284e);
        removeCallbacks(this.f232285f);
        this.f232291l = false;
        this.f232292m = false;
    L6:
        if (this.f232289j == null) goto L8;
        d();
    L8:
        getKeyboardHeightProvider().a(this);
    }

    public CommentKeyboardPlaceholderView(Context r100) {
        super(r100);
        this.f232280a = "CommentKeyboardPlaceholder#" + Integer.toHexString(hashCode());
        this.f232281b = true;
        this.f232284e = new h(this);
        this.f232285f = new i(this);
        this.f232286g = new j(this);
        this.f232287h = new k(this);
        this.f232288i = new l(this);
        this.f232290k = true;
        this.f232291l = false;
        this.f232292m = false;
        this.f232293n = false;
    }

    public static void a(CommentKeyboardPlaceholderView r100) {
        r100.getClass();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
        return;
    L5:
        if (r100.f232281b == false) goto L30;
        int r101 = r100.getFollowKeyboardHeight();
        boolean r102 = false;
        if (r100.f232292m == false) goto L15;
        if (r101 > 0) goto L15;
        if (Boolean.FALSE.equals(r100.h()) == false) goto L15;
        if (rcb.b.a(r100.getContext()) == true) goto L15;
        boolean r103 = true;
    L16:
        r100.f232292m = false;
        tt5.a.h(r100.f232280a, "syncFollowKeyboardHeight height = " + r101 + ", canDismiss = " + r103);
        if (r100.getLayoutParams().height == r101) goto L19;
        r102 = true;
    L19:
        r100.k(r101, r103);
        if (r102 == true) goto L27;
        if (r103 == false) goto L28;
        a r104 = r100.f232283d;
        if (r104 == null) goto L29;
        r104.a(r101, true);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r103 = false;
        goto L16
    }

    public static /* synthetic */ void b(CommentKeyboardPlaceholderView r100) {
        r100.k(r100.getInitialKeyBoardHeight(), false);
    }

    public final void f(boolean r100) {
        tt5.a.h(this.f232280a, "followKeyboard " + r100);
        this.f232281b = r100;
    }

    public final void j(boolean r100) {
        removeCallbacks(this.f232285f);
        boolean r101 = false;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
    L11:
        this.f232292m = false;
        return;
    L5:
        if (this.f232281b == false) goto L11;
        if (this.f232292m == true) goto L9;
        if (r100 == true) goto L9;
    L10:
        this.f232292m = r101;
        postDelayed(this.f232285f, 100);
        return;
    L9:
        r101 = true;
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        tt5.a.h(this.f232280a, "onConfigurationChanged orientation = " + r100.orientation);
        int r101 = 1;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L13;
        if (getVisibility() != 0) goto L28;
        int r102 = getKeyboardFixedHeight();
        if (rcb.b.a(getContext()) == true) goto L10;
        r101 = r102;
    L10:
        k(r101, false);
        return;
    L28:
        return;
    L13:
        if (this.f232290k == true) goto L18;
        if (this.f232281b == false) goto L18;
        this.f232291l = true;
    L18:
        if (getVisibility() != 0) goto L25;
        if (this.f232281b == false) goto L22;
        int r103 = getFollowKeyboardHeight();
    L23:
        k(r103, false);
        goto L25
    L22:
        r103 = getKeyboardFixedHeight();
    L25:
        if (this.f232290k == false) goto L29;
        j(false);
        return;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        tt5.a.h(this.f232280a, "onWindowFocusChanged hasWindowFocus = " + r100);
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
        return;
    L5:
        this.f232290k = r100;
        if (r100 == false) goto L9;
        j(this.f232291l);
        this.f232291l = false;
        return;
    }

    public void setHostAdjustResize(boolean r100) {
        this.f232293n = r100;
    }

    public void setKeyboardHeightProvider(pcb.a r100) {
        this.f232282c = r100;
    }

    public void setOnHeightChangeListener(a r100) {
        this.f232283d = r100;
    }

    public CommentKeyboardPlaceholderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f232280a = "CommentKeyboardPlaceholder#" + Integer.toHexString(hashCode());
        this.f232281b = true;
        this.f232284e = new h(this);
        this.f232285f = new i(this);
        this.f232286g = new j(this);
        this.f232287h = new k(this);
        this.f232288i = new l(this);
        this.f232290k = true;
        this.f232291l = false;
        this.f232292m = false;
        this.f232293n = false;
    }

    public final void i(Runnable r100, Runnable r101) {
        if (this.f232289j == null) goto L5;
        return;
    L5:
        Boolean r102 = h();
        if (r102 == null) goto L8;
        boolean r103 = r102.booleanValue();
    L9:
        if (r103 == true) goto L12;
        r101.run();
        return;
    L12:
        this.f232289j = r101;
        getKeyboardHeightProvider().c(this.f232286g);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f232287h);
        r100.run();
        post(this.f232288i);
        return;
    L8:
        r103 = getKeyboardHeightProvider().isKeyboardShowing();
        goto L9
    }

    public final void k(int r100, boolean r101) {
        tt5.a.h(this.f232280a, "updateHeight: height = " + r100 + ", canDismiss = " + r101);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102.height == r100) goto L7;
        r102.height = r100;
        requestLayout();
        a r103 = this.f232283d;
        if (r103 == null) goto L7;
        r103.a(r100, r101);
    L7:
        int r104 = 8;
        if (r100 <= 0) goto L10;
        int r105 = 0;
    L12:
        if (this.f232293n == true) goto L14;
    L16:
        r104 = r105;
    L18:
        if (getVisibility() == r104) goto L21;
        setVisibility(r104);
        return;
    L21:
        return;
    L14:
        if (this.f232281b == false) goto L16;
    L10:
        r105 = 8;
        goto L12
    }

    public CommentKeyboardPlaceholderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f232280a = "CommentKeyboardPlaceholder#" + Integer.toHexString(hashCode());
        this.f232281b = true;
        this.f232284e = new h(this);
        this.f232285f = new i(this);
        this.f232286g = new j(this);
        this.f232287h = new k(this);
        this.f232288i = new l(this);
        this.f232290k = true;
        this.f232291l = false;
        this.f232292m = false;
        this.f232293n = false;
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        tt5.a.h(this.f232280a, "onKeyboardHeightChanged keyboard change: " + r101 + ", orientation: " + r102 + ", followKeyboard: " + this.f232281b);
        removeCallbacks(this.f232284e);
        if (this.f232281b == false) goto L6;
        k(r101, true);
        return;
    }
}
