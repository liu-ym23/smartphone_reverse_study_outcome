package com.obric.miniapp.lynx;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a6 extends com.lynx.tasm.behavior.ui.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<com.lynx.tasm.behavior.b1> f398034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<UIGroup<?>> f398035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Rect> f398036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f398037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f398038e;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final int getBodyMaxHeightPx() {
        return this.f398037d;
    }

    public final int getContentHeightOverridePx() {
        return this.f398038e;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (super.dispatchTouchEvent(r100) == false) goto L6;
        return true;
    L6:
        Function0<com.lynx.tasm.behavior.b1> r101 = this.f398034a;
        if (r101 == null) goto L29;
        com.lynx.tasm.behavior.b1 r102 = r101.invoke();
        if (r102 == null) goto L29;
        Function0<UIGroup<?>> r103 = this.f398035b;
        if (r103 == null) goto L29;
        UIGroup<?> r104 = r103.invoke();
        if (r104 == null) goto L29;
        float r105 = r100.getX();
        float r106 = r100.getY();
        Function0<Rect> r107 = this.f398036c;
        if (r107 == null) goto L20;
        Rect r108 = r107.invoke();
        if (r108 == null) goto L20;
    L21:
        if (r108 == null) goto L23;
        float r109 = r108.left + r105;
    L24:
        if (r108 == null) goto L26;
        float r110 = r108.top + r106;
    L27:
        r100.setLocation(r109, r110);
        boolean r111 = r102.x(r100, r104);
        r100.setLocation(r105, r106);
        return r111;
    L26:
        r110 = r106;
        goto L27
    L23:
        r109 = r105;
    L20:
        r108 = r104.getBound();
    L29:
        return false;
    }

    public final void setBodyMaxHeightPx(int r100) {
        if (this.f398037d != r100) goto L5;
        return;
    L5:
        this.f398037d = r100;
        requestLayout();
    }

    public final void setContentHeightOverridePx(int r100) {
        if (this.f398038e != r100) goto L5;
        return;
    L5:
        this.f398038e = r100;
        requestLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        int r102 = -1;
        if (r101 >= r100) goto L35;
        View r103 = getChildAt(r101);
        if (r103 == null) goto L34;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 != null) goto L11;
        r104 = new ViewGroup.LayoutParams(-1, -2);
    L11:
        int r105 = r104.width;
        boolean r110 = true;
        if (r105 == (-2)) goto L16;
        if (r105 == 0) goto L16;
        boolean r106 = false;
    L17:
        int r111 = r104.height;
        if (r111 == (-1)) goto L22;
        if (r111 == 0) goto L22;
        r110 = false;
    L22:
        if (r106 == true) goto L26;
        if (r110 == false) goto L34;
    L26:
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        ViewGroup.LayoutParams r112 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r104);
    L29:
        if (r106 == false) goto L31;
        r112.width = -1;
    L31:
        if (r110 == false) goto L33;
        r112.height = -2;
    L33:
        r103.setLayoutParams(r112);
        goto L34
    L28:
        r112 = new ViewGroup.LayoutParams(r104);
    L16:
        r106 = true;
    L34:
        r101 = r101 + 1;
        goto L3
    L35:
        int r107 = View.MeasureSpec.getMode(r210);
        int r108 = View.MeasureSpec.getSize(r210);
        int r109 = View.MeasureSpec.getMode(r211);
        int r113 = View.MeasureSpec.getSize(r211);
        int r114 = this.f398037d;
        if (r114 <= 0) goto L38;
        r102 = RangesKt.coerceAtLeast((r114 - getPaddingTop()) - getPaddingBottom(), 0);
    L43:
        if (r107 == Integer.MIN_VALUE) goto L46;
        if (r107 == 1073741824) goto L46;
        int r115 = r210;
    L47:
        if (r102 < 0) goto L49;
        int r116 = View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
    L51:
        if (getChildCount() != 0) goto L63;
        int r117 = this.f398038e;
        if (r117 <= 0) goto L57;
        if (r102 < 0) goto L56;
        int r118 = RangesKt.coerceAtMost(r117, (r102 + getPaddingTop()) + getPaddingBottom());
    L58:
        if (r107 == Integer.MIN_VALUE) goto L61;
        if (r107 == 1073741824) goto L61;
        r108 = getSuggestedMinimumWidth();
    L61:
        setMeasuredDimension(View.resolveSize(r108, r210), RangesKt.coerceAtLeast(r118, getSuggestedMinimumHeight()));
        FLogger.f375446a.i("MiniAppSheetHostView", "onMeasure host=" + r108 + Permission.EXECUTE + getMeasuredHeight() + ", widthSpec=" + View.MeasureSpec.toString(r210) + ", heightSpec=" + View.MeasureSpec.toString(r211) + ", bodyMaxHeightPx=" + this.f398037d + ", contentHeightOverridePx=" + this.f398038e + ", childCount=0");
        getMeasuredHeight();
        View.MeasureSpec.toString(r210);
        View.MeasureSpec.toString(r211);
        return;
    L56:
        r118 = r117;
        goto L58
    L57:
        r118 = 0;
        goto L58
    L63:
        super.onMeasure(r115, r116);
        int r119 = getSuggestedMinimumWidth();
        int r120 = getSuggestedMinimumHeight();
        int r121 = getChildCount();
        int r122 = 0;
    L64:
        Integer r123 = null;
        if (r122 >= r121) goto L103;
        View r124 = getChildAt(r122);
        if (r124 == null) goto L102;
        if (r124.getVisibility() == 8) goto L102;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        if ((r125 instanceof ViewGroup.MarginLayoutParams) == false) goto L75;
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r125;
    L76:
        if (r126 == null) goto L78;
        Integer r127 = Integer.valueOf(r126.leftMargin);
    L79:
        if (r127 == null) goto L81;
        int r128 = r127.intValue();
    L83:
        if (r126 == null) goto L85;
        Integer r129 = Integer.valueOf(r126.rightMargin);
    L86:
        if (r129 == null) goto L88;
        int r130 = r129.intValue();
    L89:
        int r131 = r128 + r130;
        if (r126 == null) goto L92;
        Integer r132 = Integer.valueOf(r126.topMargin);
    L93:
        if (r132 == null) goto L95;
        int r133 = r132.intValue();
    L96:
        if (r126 == null) goto L98;
        r123 = Integer.valueOf(r126.bottomMargin);
    L98:
        if (r123 == null) goto L100;
        int r134 = r123.intValue();
    L101:
        int r135 = r133 + r134;
        int r136 = Math.max(r119, ((r124.getMeasuredWidth() + r131) + getPaddingLeft()) + getPaddingRight());
        r120 = Math.max(r120, ((r124.getMeasuredHeight() + r135) + getPaddingTop()) + getPaddingBottom());
        r119 = r136;
        goto L102
    L100:
        r134 = 0;
        goto L101
    L95:
        r133 = 0;
        goto L96
    L92:
        r132 = null;
        goto L93
    L88:
        r130 = 0;
        goto L89
    L85:
        r129 = null;
        goto L86
    L81:
        r128 = 0;
        goto L83
    L78:
        r127 = null;
        goto L79
    L75:
        r126 = null;
    L102:
        r122 = r122 + 1;
        r108 = r108;
        goto L64
    L103:
        int r137 = r108;
        int r138 = this.f398038e;
        if (r138 <= 0) goto L106;
        r120 = Math.max(r120, r138);
    L106:
        if (r102 < 0) goto L109;
        r120 = RangesKt.coerceAtMost(r120, (r102 + getPaddingTop()) + getPaddingBottom());
    L109:
        if (r107 != Integer.MIN_VALUE) goto L111;
    L113:
        int r139 = r137;
    L114:
        setMeasuredDimension(View.resolveSize(r139, r210), RangesKt.coerceAtLeast(r120, getSuggestedMinimumHeight()));
        if (getChildCount() <= 0) goto L157;
        StringBuilder r140 = new StringBuilder("childCount=");
        r140.append(getChildCount());
        r140.append(" [");
        int r141 = getChildCount();
        int r142 = 0;
    L117:
        if (r142 >= r141) goto L145;
        if (r142 <= 0) goto L120;
        r140.append("; ");
    L120:
        View r143 = getChildAt(r142);
        r140.append(r142);
        r140.append(":");
        if (r143 == null) goto L123;
        String r144 = r143.getClass().getSimpleName();
    L124:
        r140.append(r144);
        r140.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r143 == null) goto L127;
        Integer r145 = Integer.valueOf(r143.getMeasuredWidth());
    L128:
        r140.append(r145);
        r140.append("x");
        if (r143 == null) goto L131;
        Integer r146 = Integer.valueOf(r143.getMeasuredHeight());
    L132:
        r140.append(r146);
        r140.append(" lp=");
        if (r143 == null) goto L137;
        ViewGroup.LayoutParams r147 = r143.getLayoutParams();
        if (r147 == null) goto L137;
        Integer r148 = Integer.valueOf(r147.width);
    L138:
        r140.append(r148);
        r140.append("x");
        if (r143 == null) goto L143;
        ViewGroup.LayoutParams r149 = r143.getLayoutParams();
        if (r149 == null) goto L143;
        Integer r150 = Integer.valueOf(r149.height);
    L144:
        r140.append(r150);
        r142 = r142 + 1;
    L143:
        r150 = null;
    L137:
        r148 = null;
        goto L138
    L131:
        r146 = null;
        goto L132
    L127:
        r145 = null;
        goto L128
    L123:
        r144 = null;
        goto L124
    L145:
        r140.append("]");
        String r151 = r140.toString();
        FLogger.f375446a.i("MiniAppSheetHostView", "onMeasure host=" + r139 + Permission.EXECUTE + getMeasuredHeight() + ", widthSpec=" + View.MeasureSpec.toString(r210) + ", heightSpec=" + View.MeasureSpec.toString(r211) + ", bodyMaxHeightPx=" + this.f398037d + ", " + r151);
        getMeasuredHeight();
        View.MeasureSpec.toString(r210);
        View.MeasureSpec.toString(r211);
        return;
    L157:
        return;
    L111:
        if (r107 == 1073741824) goto L113;
        r139 = r119;
        goto L114
    L49:
        r116 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L46:
        r115 = View.MeasureSpec.makeMeasureSpec(r108, 1073741824);
        goto L47
    L38:
        if (r109 == 0) goto L43;
        if (r113 == 0) goto L43;
        r102 = RangesKt.coerceAtLeast((r113 - getPaddingTop()) - getPaddingBottom(), 0);
        goto L43
    }

    public a6(Context r100, Function0 r101, c1 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f398034a = r101;
        this.f398035b = r102;
        this.f398036c = r103;
    }
}
