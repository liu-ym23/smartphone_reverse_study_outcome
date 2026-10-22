package com.larus.bot.impl.feature.edit.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.common_ui.utils.ViewExtKt;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import fv8.b;
import fv8.c;
import fv8.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001'B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0014J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0014J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012J\b\u0010&\u001a\u00020\u0012H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bot/impl/feature/edit/view/BotEditScrollView;", "Landroid/widget/ScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchEnabled", "", "getTouchEnabled", "()Z", "setTouchEnabled", "(Z)V", "inTouch", "touchScrolled", "imeAnimationEnd", "extraMargin", "", "onAttachedToWindow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "computeScrollDeltaToGetChildRectOnScreen", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onScrollChanged", "l", "t", "oldl", "oldt", "setExtraImeBottomMargin", "marginPx", "getNavigationHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f319307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f319308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f319309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f319310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f319311e;

    public static final class a {
    }

    static {
    }

    private final int getNavigationHeight() {
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this);
        if (r100 == null) goto L8;
        Insets r101 = r100.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.bottom;
    L8:
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewExtKt.m(this, new b(this), new c(this), new d(this));
    }

    public final boolean getTouchEnabled() {
        return this.f319307a;
    }

    public BotEditScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static void a(BotEditScrollView r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L13;
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L8:
        if (r102 == null) goto L10;
        r102.bottomMargin = r100.getNavigationHeight();
    L10:
        r100.setLayoutParams(r101);
        return;
    L7:
        r102 = null;
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.widget.ScrollView
    public final int computeScrollDeltaToGetChildRectOnScreen(Rect r100) {
        if (r100 == null) goto L4;
        int r101 = r100.bottom;
    L6:
        if (r101 <= ((getScrollY() + getHeight()) - this.f319311e)) goto L10;
        return super.computeScrollDeltaToGetChildRectOnScreen(r100) + this.f319311e;
    L10:
        return super.computeScrollDeltaToGetChildRectOnScreen(r100);
    L4:
        r101 = 0;
        goto L6
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f319307a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f319307a == true) goto L5;
        return false;
    L5:
        boolean r101 = true;
        if (this.f319308b == true) goto L8;
        this.f319308b = true;
        this.f319309c = false;
    L8:
        boolean r102 = super.onTouchEvent(r100);
        if (r100 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L21;
        if (r100 != null) goto L17;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == true) goto L21;
    L25:
        if (r100 != null) goto L27;
    L29:
        r101 = false;
    L30:
        if (r101 == true) goto L32;
    L34:
        return r102;
    L32:
        if (getChildCount() <= 0) goto L34;
        Object r105 = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r105).hideSoftInputFromWindow(getWindowToken(), 0);
        goto L34
    L27:
        if (r100.getActionMasked() != 2) goto L29;
    L17:
        if (r100.getActionMasked() != 3) goto L19;
        r104 = true;
    L21:
        this.f319308b = false;
        if (this.f319309c == true) goto L24;
        ViewExtKt.g(this);
    L24:
        this.f319309c = false;
        goto L25
    L11:
        if (r100.getActionMasked() != 1) goto L13;
        r103 = true;
        goto L14
    }

    public final void setExtraImeBottomMargin(int r100) {
        this.f319311e += r100;
    }

    public final void setTouchEnabled(boolean r100) {
        this.f319307a = r100;
    }

    public BotEditScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f319307a = true;
        this.f319311e = c7.b(32);
    }

    public static Unit b(BotEditScrollView r100, Insets r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L19;
        ViewGroup.MarginLayoutParams r103 = null;
        if (ViewExtKt.h(r100) == true) goto L12;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r103 = (ViewGroup.MarginLayoutParams) r102;
    L9:
        if (r103 == null) goto L16;
        r103.bottomMargin = r100.getNavigationHeight();
    L16:
        r100.setLayoutParams(r102);
        return Unit.INSTANCE;
    L12:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r103 = (ViewGroup.MarginLayoutParams) r102;
    L14:
        if (r103 == null) goto L16;
        r103.bottomMargin = r101.bottom;
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        if (r103 == null) goto L8;
        int r104 = r103.bottomMargin;
    L10:
        if (this.f319310d == true) goto L12;
        return;
    L12:
        if (ViewExtKt.h(this) == false) goto L14;
        return;
    L14:
        if (r104 == getNavigationHeight()) goto L19;
        post(new fv8.a(this));
        return;
    L19:
        return;
    L8:
        r104 = getNavigationHeight();
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (this.f319308b == false) goto L6;
        this.f319309c = true;
        return;
    }
}
