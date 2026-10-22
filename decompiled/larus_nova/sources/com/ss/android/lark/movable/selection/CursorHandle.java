package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0014J \u0010 \u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u000f\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\u001aH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\bJ\u0010\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/ss/android/lark/movable/selection/CursorHandle;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/ss/android/lark/movable/selection/IHandle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "handleType", "Lcom/ss/android/lark/movable/selection/HandleType;", "handleColor", "", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/movable/selection/HandleType;I)V", "caretInfo", "Lcom/bytedance/lark/lark_markdown_render_android/FfiCaret;", "isGhost", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "handleStyle", "Lcom/ss/android/lark/movable/selection/HandleStyle;", "getHandleStyle", "()Lcom/ss/android/lark/movable/selection/HandleStyle;", "setHandleStyle", "(Lcom/ss/android/lark/movable/selection/HandleStyle;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updatePositionAndSize", "offset", "Landroid/graphics/Point;", "containerOffset", "getCaretId", "Lkotlin/UInt;", "getCaretId-pVg5ArA", "()I", "onCleared", "setIsGhost", "getVisibleInsets", "Landroid/graphics/Rect;", "setHandleColor", "color", "dpToPx", "dp", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CursorHandle extends AppCompatImageView implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandleType f432715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FfiCaret f432716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f432717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HandleStyle f432718d;

    @Override // com.ss.android.lark.movable.selection.d
    public View getView() {
        return this;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void onCleared() {
        this.f432716b = null;
    }

    @Override // com.ss.android.lark.movable.selection.d
    /* JADX INFO: renamed from: getCaretId-pVg5ArA, reason: not valid java name */
    public int mo8647getCaretIdpVg5ArA() {
        FfiCaret r100 = this.f432716b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.m8379getUuidpVg5ArA();
    }

    @Override // com.ss.android.lark.movable.selection.d
    public Rect getVisibleInsets() {
        return new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    public HandleStyle getHandleStyle() {
        return this.f432718d;
    }

    public final int j(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f432717c == false) goto L5;
        return;
    L5:
        super.onDraw(r100);
    }

    public final void setHandleColor(int r100) {
        Drawable r101 = getDrawable();
        if (r101 == null) goto L7;
        Drawable r102 = r101.mutate();
        if (r102 == null) goto L7;
        r102.setTint(r100);
    L7:
        setImageDrawable(r101);
    }

    public void setHandleStyle(HandleStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f432718d = r100;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public void setIsGhost(boolean r100) {
        this.f432717c = r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        Drawable r102 = getDrawable();
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getIntrinsicWidth();
    L6:
        int r105 = (r104 + getPaddingLeft()) + getPaddingRight();
        if (r102 == null) goto L9;
        r103 = r102.getIntrinsicHeight();
    L9:
        setMeasuredDimension(r105, (r103 + getPaddingTop()) + getPaddingBottom());
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public CursorHandle(Context r100, HandleType r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "handleType");
        super(r100);
        this.f432715a = r101;
        this.f432718d = HandleStyle.NORMAL;
        HandleType r103 = HandleType.START;
        if (r101 != r103) goto L5;
        int r104 = R.drawable.movable_selection_handle_left;
    L6:
        Drawable r105 = ContextCompat.getDrawable(r100, r104);
        if (r105 == null) goto L11;
        Drawable r106 = r105.mutate();
        if (r106 == null) goto L11;
        r106.setTint(r102);
    L11:
        setImageDrawable(r105);
        int r107 = j(2);
        int r108 = j(10);
        int r109 = j(4);
        int r110 = j(12);
        if (r101 != r103) goto L14;
        setPadding(r108, r109, r107, r110);
    L15:
        setHasTransientState(true);
        return;
    L14:
        setPadding(r107, r109, r108, r110);
        goto L15
    L5:
        r104 = R.drawable.movable_selection_handle_right;
        goto L6
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void g(FfiCaret r100, Point r101, Point r102) {
        Intrinsics.checkNotNullParameter(r100, "caretInfo");
        Intrinsics.checkNotNullParameter(r101, "offset");
        Intrinsics.checkNotNullParameter(r102, "containerOffset");
        this.f432716b = r100;
        if (getMeasuredWidth() != 0) goto L5;
    L6:
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L7:
        float r103 = r100.getX();
        float r104 = r100.getY() + (r100.getHeight() / 2.0f);
        if (this.f432715a != HandleType.START) goto L10;
        int r105 = getMeasuredWidth() - getPaddingRight();
    L11:
        float r106 = getPaddingTop();
        setX(((r103 - r105) - r101.x) + r102.x);
        setY(((r104 - r106) - r101.y) + r102.y);
        ViewGroup.LayoutParams r107 = getLayoutParams();
        if (r107 == null) goto L16;
        r107.width = getMeasuredWidth();
        r107.height = getMeasuredHeight();
        setLayoutParams(r107);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L10:
        r105 = getPaddingLeft();
        goto L11
    L5:
        if (getMeasuredHeight() != 0) goto L7;
        goto L6
    }
}
