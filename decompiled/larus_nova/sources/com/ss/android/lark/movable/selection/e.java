package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends View implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandleType f432787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f432788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f432789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f432790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FfiCaret f432791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f432792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HandleStyle f432793g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.movable.selection.d
    public View getView() {
        return this;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void onCleared() {
        this.f432791e = null;
    }

    @Override // com.ss.android.lark.movable.selection.d
    /* JADX INFO: renamed from: getCaretId-pVg5ArA */
    public int mo8647getCaretIdpVg5ArA() {
        FfiCaret r100 = this.f432791e;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.m8379getUuidpVg5ArA();
    }

    @Override // com.ss.android.lark.movable.selection.d
    public Rect getVisibleInsets() {
        return new Rect(getView().getPaddingStart(), getView().getPaddingTop(), getView().getPaddingEnd(), getView().getPaddingBottom());
    }

    public HandleStyle getHandleStyle() {
        return this.f432793g;
    }

    public final float a(int r100) {
        Resources r101 = getResources();
        return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f432792f == false) goto L5;
        return;
    L5:
        super.onDraw(r110);
        float r100 = getWidth();
        float r101 = getHeight();
        float r102 = a(2);
        float r103 = this.f432789c;
        float r104 = (r100 - r103) / 2.0f;
        r110.drawRoundRect(r104, getPaddingTop(), r104 + r103, r101 - getPaddingBottom(), r102, r102, this.f432788b);
        float r105 = r100 / 2.0f;
        if (this.f432787a != HandleType.START) goto L8;
        float r106 = this.f432790d + getPaddingTop();
    L9:
        r110.drawCircle(r105, r106, this.f432790d, this.f432788b);
        return;
    L8:
        r106 = (r101 - this.f432790d) - getPaddingBottom();
        goto L9
    }

    public void setHandleStyle(HandleStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f432793g = r100;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public void setIsGhost(boolean r100) {
        this.f432792f = r100;
    }

    public e(Context r100, HandleType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "handleType");
        super(r100);
        this.f432787a = r101;
        Paint r102 = new Paint(1);
        r102.setColor(UIUtils.getColor(r100, R.color.primary_fill_default));
        r102.setStyle(Paint.Style.FILL);
        this.f432788b = r102;
        this.f432789c = a(2);
        this.f432790d = a(10) / 2;
        this.f432793g = HandleStyle.LINE;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension((int) (((this.f432790d * 2) + getPaddingStart()) + getPaddingEnd()), (View.MeasureSpec.getSize(r101) + getPaddingTop()) + getPaddingBottom());
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void g(FfiCaret r100, Point r101, Point r102) {
        Intrinsics.checkNotNullParameter(r100, "caretInfo");
        Intrinsics.checkNotNullParameter(r101, "offset");
        Intrinsics.checkNotNullParameter(r102, "containerOffset");
        this.f432791e = r100;
        setX((((r100.getX() - this.f432790d) - getPaddingStart()) - r101.x) + r102.x);
        if (r100.getDirection() == false) goto L5;
        float r103 = (r100.getY() - getPaddingTop()) - r101.y;
        int r104 = r102.y;
    L6:
        setY(r103 + r104);
        ViewGroup.LayoutParams r105 = getLayoutParams();
        if (r105 == null) goto L11;
        r105.height = (int) (r100.getHeight() + (this.f432790d * 2));
        setLayoutParams(r105);
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        r103 = ((r100.getY() - (this.f432790d * 2)) - getPaddingTop()) - r101.y;
        r104 = r102.y;
        goto L6
    }
}
