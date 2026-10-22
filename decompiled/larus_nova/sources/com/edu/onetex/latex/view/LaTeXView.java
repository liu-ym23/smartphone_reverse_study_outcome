package com.edu.onetex.latex.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zs7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/edu/onetex/latex/view/LaTeXView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2, "Lcom/edu/onetex/latex/graphic/Graphics2D;", "getG2", "()Lcom/edu/onetex/latex/graphic/Graphics2D;", "teXIcon", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "getTeXIcon", "()Lcom/edu/onetex/latex/icon/LaTeXIcon;", "setTeXIcon", "(Lcom/edu/onetex/latex/icon/LaTeXIcon;)V", "bindTexIcon", "", "enableOnDraw", "measureHeight", "measureWidth", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onetex_release"}, k = 1, mv = {1, 4, 2})
public class LaTeXView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final Paint bgPaint;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    private final Graphics2D f273705g2;
    private LaTeXIcon teXIcon;

    public LaTeXView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public LaTeXView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void enableOnDraw() {
        setWillNotDraw(false);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r100 = this._$_findViewCache;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public View _$_findCachedViewById(int r100) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r101 = (View) this._$_findViewCache.get(Integer.valueOf(r100));
        if (r101 != null) goto L9;
        View r102 = findViewById(r100);
        this._$_findViewCache.put(Integer.valueOf(r100), r102);
        return r102;
    L9:
        return r101;
    }

    private final int measureHeight() {
        LaTeXIcon r100 = this.teXIcon;
        if (r100 == null) goto L5;
        int r101 = r100.getHeight();
    L7:
        return (r101 + getPaddingTop()) + getPaddingBottom();
    L5:
        r101 = 0;
        goto L7
    }

    private final int measureWidth() {
        LaTeXIcon r100 = this.teXIcon;
        if (r100 == null) goto L20;
        LaTeXParam r101 = r100.getLatexParam();
        if (r101 == null) goto L20;
        a r102 = r101.getTexWidthSize();
        if (r102 == null) goto L20;
        int r103 = r102.f573489c;
        if (r103 != 0) goto L11;
        float r104 = r102.f573488b;
    L22:
        return (int) r104;
    L11:
        if (r103 != 1) goto L13;
        float r105 = r102.f573488b;
        float r106 = r102.f573487a;
    L17:
        r104 = 0.5f + (r105 * r106);
        goto L22
    L13:
        if (r103 == 2) goto L15;
        r104 = r102.f573488b;
        goto L22
    L15:
        r105 = r102.f573488b;
        r106 = r102.f573487a;
    L20:
        return 0;
    }

    public final Paint getBgPaint() {
        return this.bgPaint;
    }

    public final Graphics2D getG2() {
        return this.f273705g2;
    }

    public final LaTeXIcon getTeXIcon() {
        return this.teXIcon;
    }

    public final void bindTexIcon(LaTeXIcon r110) {
        Intrinsics.checkNotNullParameter(r110, "teXIcon");
        this.teXIcon = r110;
        List<ILaTeXView> r100 = r110.getITeXViewList();
        this.f273705g2.setCustomViewList(r100);
        removeAllViews();
        if (r110.getCustomViewList().isEmpty() == true) goto L5;
    L11:
        List<View> r111 = r110.getCustomViewList();
        if ((!r111.isEmpty()) == true) goto L14;
    L24:
        requestLayout();
        return;
    L14:
        if (r111.size() != r100.size()) goto L24;
        int r101 = r111.size();
        int r102 = 0;
    L16:
        if (r102 >= r101) goto L24;
        View r103 = (View) ListProtector.get(r111, r102);
        ILaTeXView r104 = (ILaTeXView) ListProtector.get(r100, r102);
        ViewGroup.LayoutParams r105 = new ViewGroup.LayoutParams((int) r104.getViewWidth(), (int) r104.getViewHeight());
        ViewParent r106 = r103.getParent();
        if ((r106 instanceof ViewGroup) == true) goto L20;
        r106 = null;
    L20:
        ViewGroup r107 = (ViewGroup) r106;
        if (r107 == null) goto L23;
        r107.removeView(r103);
    L23:
        addView(r103, r105);
        r103.setVisibility(8);
        r102 = r102 + 1;
        goto L16
    L5:
        if ((!r100.isEmpty()) == false) goto L11;
        LinkedList r108 = new LinkedList();
        Iterator<T> r109 = r100.iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        r108.add(((ILaTeXView) r109.next()).getAndroidView(getContext()));
        goto L8
    L10:
        r110.setCustomViewList(r108);
        goto L11
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        LaTeXIcon r100 = this.teXIcon;
        if (r100 == null) goto L9;
        r110.save();
        if (r100.getLatexParam().getBackgroundColor() == 0) goto L7;
        this.bgPaint.setColor(r100.getLatexParam().getBackgroundColor());
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.bgPaint);
    L7:
        this.f273705g2.setCanvas(r110);
        r100.setForeground(r100.getLatexParam().getForegroundColor());
        r100.paintIcon(this.f273705g2, 0, 0);
        r110.restore();
        return;
    }

    public final void setTeXIcon(LaTeXIcon r100) {
        this.teXIcon = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(measureWidth(), measureHeight());
    }

    public LaTeXView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f273705g2 = new Graphics2D(r100, null, 2, null);
        this.bgPaint = new Paint(1);
        enableOnDraw();
    }

    public /* synthetic */ LaTeXView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
