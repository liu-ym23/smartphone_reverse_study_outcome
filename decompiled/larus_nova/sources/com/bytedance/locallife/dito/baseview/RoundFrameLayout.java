package com.bytedance.locallife.dito.baseview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.locallife.dito.helper.f;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/dito/baseview/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/locallife/dito/baseview/c;", "", "radiusDp", "", "setRadius", "", "c", "Z", "getEnableAutoBlurIme", "()Z", "setEnableAutoBlurIme", "(Z)V", "enableAutoBlurIme", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class RoundFrameLayout extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundHelper f257298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f257299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f257300c;

    public RoundFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public final void e() {
        this.f257298a.f257314m = false;
    }

    public final boolean getEnableAutoBlurIme() {
        return this.f257300c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f257300c == false) goto L29;
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.getAction() != 1) goto L9;
    L10:
        if (r101 == false) goto L29;
        Context r102 = getContext();
    L12:
        View r103 = null;
        if ((r102 instanceof ContextWrapper) == false) goto L18;
        if ((r102 instanceof Activity) == true) goto L16;
        r102 = ((ContextWrapper) r102).getBaseContext();
        goto L12
    L16:
        Activity r104 = (Activity) r102;
    L19:
        if (r104 == null) goto L22;
        r103 = r104.getCurrentFocus();
    L22:
        if ((r103 instanceof EditText) == false) goto L29;
        Rect r105 = new Rect();
        r103.getGlobalVisibleRect(r105);
        if (r105.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L29;
        r103.clearFocus();
        InputMethodManager r106 = (InputMethodManager) getContext().getSystemService("input_method");
        if (r106 == null) goto L29;
        r106.hideSoftInputFromWindow(getWindowToken(), 0);
        goto L29
    L18:
        r104 = null;
    L9:
        r101 = false;
    L29:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f257298a.f(r100);
        super.draw(r100);
        this.f257298a.a(r100);
    }

    @Override // android.view.View
    public final void offsetTopAndBottom(int r110) {
        super.offsetTopAndBottom(r110);
        f r111 = this.f257299b;
        Object r100 = getTag();
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof BaseDitoModel) == false) goto L5;
        BaseDitoModel r102 = (BaseDitoModel) r100;
    L6:
        int r103 = getTop();
        int r104 = getBottom();
        int r105 = getPaddingTop();
        int r106 = getPaddingBottom();
        ViewGroup.LayoutParams r107 = getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r107 = null;
    L9:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L12;
        int r109 = r108.topMargin;
    L13:
        ViewGroup.LayoutParams r112 = getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r101 = r112;
    L17:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r101;
        if (r113 == null) goto L20;
        int r114 = r113.bottomMargin;
    L21:
        r111.getClass();
        f.a(r102, r103, r104, r105, r106, r109, r114);
        return;
    L20:
        r114 = 0;
        goto L21
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public final void setEnableAutoBlurIme(boolean r100) {
        this.f257300c = r100;
    }

    public void setRadius(int r100) {
        this.f257298a.g(r100);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public void setRadius(List<Float> r100) {
        c.a.a(this, r100);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public final void w(Integer r100, Float r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        RoundHelper r102 = this.f257298a;
        int r103 = r100.intValue();
        float r104 = r101.floatValue();
        r102.f257310i.setColor(r103);
        r102.f257310i.setStrokeWidth(r104);
        r102.f257313l = r104;
        r102.f257314m = true;
        return;
    L7:
        return;
    }

    public RoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RoundHelper r103 = new RoundHelper();
        this.f257298a = r103;
        this.f257299b = new f();
        r103.d(this);
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r104.hasValue(1) == false) goto L5;
        r103.g(r104.getDimensionPixelOffset(1, 0));
    L5:
        r104.recycle();
    }

    public /* synthetic */ RoundFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public final void b(int r100, int r101, int r102, int r103) {
        this.f257298a.h(r100, r101, r103, r102);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r110, int r111) {
        super.onSizeChanged(r100, r101, r110, r111);
        this.f257298a.e(r100, r101);
        f r102 = this.f257299b;
        Object r103 = getTag();
        ViewGroup.LayoutParams r112 = null;
        if ((r103 instanceof BaseDitoModel) == false) goto L5;
        BaseDitoModel r104 = (BaseDitoModel) r103;
    L6:
        int r105 = getTop();
        int r106 = getBottom();
        int r107 = getPaddingTop();
        int r108 = getPaddingBottom();
        ViewGroup.LayoutParams r109 = getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r109 = null;
    L9:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r109;
        if (r113 == null) goto L12;
        int r114 = r113.topMargin;
    L13:
        ViewGroup.LayoutParams r115 = getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r112 = r115;
    L17:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r112;
        if (r116 == null) goto L20;
        int r117 = r116.bottomMargin;
    L21:
        r102.getClass();
        f.a(r104, r105, r106, r107, r108, r114, r117);
        return;
    L20:
        r117 = 0;
        goto L21
    L12:
        r114 = 0;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        super.onLayout(r100, r110, r111, r112, r113);
        f r101 = this.f257299b;
        Object r114 = getTag();
        ViewGroup.LayoutParams r102 = null;
        if ((r114 instanceof BaseDitoModel) == false) goto L5;
        BaseDitoModel r103 = (BaseDitoModel) r114;
    L6:
        int r104 = getPaddingTop();
        int r105 = getPaddingBottom();
        ViewGroup.LayoutParams r115 = getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r115 = null;
    L9:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        if (r116 == null) goto L12;
        int r106 = r116.topMargin;
    L13:
        ViewGroup.LayoutParams r117 = getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r102 = r117;
    L17:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r102;
        if (r107 == null) goto L20;
        int r108 = r107.bottomMargin;
    L21:
        r101.getClass();
        f.a(r103, r111, r113, r104, r105, r106, r108);
        return;
    L20:
        r108 = 0;
        goto L21
    L12:
        r106 = 0;
        goto L13
    L5:
        r103 = null;
        goto L6
    }
}
