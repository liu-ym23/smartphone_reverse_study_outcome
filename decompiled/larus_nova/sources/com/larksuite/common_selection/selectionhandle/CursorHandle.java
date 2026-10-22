package com.larksuite.common_selection.selectionhandle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.common_selection.SelectionContainer;
import com.larksuite.common_selection.o;
import com.larksuite.common_selection.t;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly7.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larksuite/common_selection/selectionhandle/CursorHandle;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/larksuite/common_selection/selectionhandle/ISelectionHandle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "handleType", "Lcom/larksuite/common_selection/selectionhandle/SelectionHandleType;", "<init>", "(Landroid/content/Context;Lcom/larksuite/common_selection/selectionhandle/SelectionHandleType;)V", "handleColor", "", "containerLocation", "", "isGhost", "", "setHandleColor", "", "color", "dpToPx", "dp", "getView", "Landroid/view/View;", "updateSize", "point", "Lcom/larksuite/common_selection/SelectionPoint;", "strategyRegistry", "Lcom/larksuite/common_selection/SelectionStrategyRegistry;", "position", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "screenPoint", "Landroid/graphics/Point;", "angle", "", "getLogicalTouchPoint", "rawX", "rawY", "getOffsetForMagnifier", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setIsGhost", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CursorHandle extends AppCompatImageView implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectionHandleType f282924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f282925b;

    @Override // ly7.c
    public final void e(o r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "point");
        Intrinsics.checkNotNullParameter(r101, "strategyRegistry");
    }

    @Override // ly7.c
    public View getView() {
        return this;
    }

    @Override // ly7.c
    public float getOffsetForMagnifier() {
        return getHeight() * 0.4f;
    }

    public final int j(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f282925b == false) goto L5;
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

    public void setIsGhost(boolean r100) {
        this.f282925b = r100;
    }

    public CursorHandle(Context r100, SelectionHandleType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "handleType");
        super(r100);
        this.f282924a = r101;
        if (r101 != SelectionHandleType.START) goto L5;
        int r102 = R.drawable.text_select_handle_left;
    L6:
        Drawable r103 = ContextCompat.getDrawable(r100, r102);
        if (r103 == null) goto L11;
        Drawable r104 = r103.mutate();
        if (r104 == null) goto L11;
        r104.setTint(FakePickerAvatarCreator.BLUE);
    L11:
        setImageDrawable(r103);
        setPadding(j(5), j(5), 0, j(10));
        setLayerType(2, null);
        setHasTransientState(true);
        return;
    L5:
        r102 = R.drawable.text_select_handle_right;
        goto L6
    }

    @Override // ly7.c
    public final Point h(float r100, float r101) {
        float r102 = r101 - (getHeight() * 0.75f);
        float r103 = getWidth() * 0.2f;
        if (this.f282924a != SelectionHandleType.START) goto L5;
        float r104 = (r100 + (getWidth() / 2.0f)) - r103;
    L7:
        return new Point((int) r104, (int) r102);
    L5:
        r104 = (r100 - (getWidth() / 2.0f)) + r103;
        goto L7
    }

    @Override // ly7.c
    public final void k(SelectionContainer r100, Point r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "screenPoint");
        int r103 = r101.x;
        int r104 = r101.y;
        if (getMeasuredWidth() != 0) goto L5;
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L5:
        setRotation(r102);
        int r105 = getMeasuredWidth();
        double r106 = Math.toRadians(r102);
        float r107 = r105 * 0.2f;
        if (this.f282924a != SelectionHandleType.START) goto L8;
        setPivotX(r105 - getPaddingRight());
        setPivotY(getPaddingTop());
        float r108 = r103 - getPivotX();
        float r109 = r104 - getPivotY();
        float r110 = ((float) Math.cos(r106)) * r107;
        float r111 = r107 * ((float) Math.sin(r106));
        setX(r108 + r110);
        setY(r109 + r111);
        return;
    L8:
        setPivotX(getPaddingLeft());
        setPivotY(getPaddingTop());
        float r112 = r103 - getPivotX();
        float r113 = r104 - getPivotY();
        float r114 = -r107;
        float r115 = ((float) Math.cos(r106)) * r114;
        float r116 = r114 * ((float) Math.sin(r106));
        setX(r112 + r115);
        setY(r113 + r116);
    }
}
