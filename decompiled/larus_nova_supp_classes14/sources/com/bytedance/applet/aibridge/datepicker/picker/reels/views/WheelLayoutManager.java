package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.UploadTypeInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kv3.f;
import kv3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060,R\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J$\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\n\u0010+\u001a\u00060,R\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\tH\u0016J\u0014\u00104\u001a\u00020*2\n\u0010+\u001a\u00060,R\u00020-H\u0002J \u00105\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00103\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0006\u00109\u001a\u00020\tJ\u000e\u0010:\u001a\u00020\t2\u0006\u00103\u001a\u00020\tJ\u0006\u0010;\u001a\u00020\tJ \u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\tH\u0002J\u000e\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\tJ\u000e\u0010D\u001a\u00020*2\u0006\u0010C\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\u0014¨\u0006E"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cameraDistancePx", "", "defaultStartColor", "", "getDefaultStartColor", "()I", "defaultStartColor$delegate", "Lkotlin/Lazy;", "defaultEndColor", "getDefaultEndColor", "defaultEndColor$delegate", "selectedColor", "getSelectedColor", "setSelectedColor", "(I)V", "normalColor", "getNormalColor", "setNormalColor", "itemAngle", "quarterCount", "degToRad", "itemHeightPx", "scrollOffsetPx", "radiusPx", "isCyclic", "", "()Z", "setCyclic", "(Z)V", "headTailPaddingItems", "getHeadTailPaddingItems", "setHeadTailPaddingItems", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollVertically", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "scrollToPosition", "position", "layoutVisibleChildren", "applyTransform", "child", "Landroid/view/View;", "scrollItems", "computeSnapDeltaToNearestCenter", "computeDeltaToCenterAtPosition", "getNearestCenterAdapterIndex", "lerp", UploadTypeInf.START, "end", "t", "calculateRadius", "itemHeight", "setSelectedTextColor", "color", "setNormalTextColor", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WheelLayoutManager extends RecyclerView.LayoutManager {
    public final float a;
    public final Lazy b;
    public final Lazy c;
    public int d;
    public int e;
    public final float f;
    public final int g;
    public final float h;
    public int i;
    public float j;
    public float k;
    public boolean l;
    public int m;

    public final boolean canScrollVertically() {
        return true;
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public WheelLayoutManager(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Resources r0 = Resources.getSystem();
        this.a = TypedValue.applyDimension(1, 8000.0f, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
        Lazy r1 = LazyKt.lazy(new f(r4));
        this.b = r1;
        Lazy r5 = LazyKt.lazy(new g(r4));
        this.c = r5;
        this.d = ((Number) r1.getValue()).intValue();
        this.e = ((Number) r5.getValue()).intValue();
        this.f = 30.0f;
        this.g = 3;
        this.h = 0.017453292f;
    }

    public final void p(RecyclerView.Recycler r17) {
        detachAndScrapAttachedViews(r17);
        int r0 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (this.i == 0) goto L21;
        float r7 = 2.0f;
        float r8 = getPaddingTop() + (r0 / 2.0f);
        float r9 = this.j / this.i;
        float r2 = 1;
        int r1 = RangesKt.coerceAtLeast((int) Math.floor((r9 - this.g) - r2), 0);
        int r11 = RangesKt.coerceAtMost((int) Math.ceil((this.g + r9) + r2), getItemCount() - 1);
        if (r1 > r11) goto L20;
        int r12 = r1;
    L10:
        View r14 = r17.getViewForPosition(r12);
        addView(r14);
        measureChildWithMargins(r14, 0, 0);
        int r3 = getDecoratedMeasuredWidth(r14);
        int r4 = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r3) / 2) + getPaddingLeft();
        int r5 = MathKt.roundToInt(r8 - (this.i / r7));
        layoutDecorated(r14, r4, r5, r4 + r3, r5 + this.i);
        float r6 = r12 - r9;
        float r10 = RangesKt.coerceIn(this.f * r6, -90.0f, 90.0f);
        float r13 = this.h * r10;
        float r15 = RangesKt.coerceIn(Math.abs(r10) / 90.0f, 0.0f, 1.0f);
        float r16 = RangesKt.coerceIn(Math.abs(r6), 0.0f, 1.0f);
        float r18 = ((-0.19999999f) * r15) + 1.0f;
        r14.setPivotX(r14.getWidth() / r7);
        r14.setPivotY(r14.getHeight() / r7);
        r14.setRotationX(r10);
        r14.setScaleX(r18);
        r14.setScaleY(r18);
        double r19 = r13;
        float r110 = r8;
        r14.setTranslationY(((float) Math.sin(r19)) * this.k);
        float r20 = (float) Math.cos(r19);
        float r21 = this.k;
        r14.setTranslationZ((r20 * r21) - r21);
        r14.setCameraDistance(this.a);
        if ((r14 instanceof TextView) == false) goto L15;
        TextView r22 = (TextView) r14;
        r22.setTextColor(ColorUtils.blendARGB(this.d, this.e, r16));
        int r23 = MathKt.roundToInt((r16 * (-150.0f)) + 450.0f);
        if (Build.VERSION.SDK_INT < 28) goto L15;
        r22.setTypeface(Typeface.create(Typeface.DEFAULT, r23, false));
    L15:
        r14.setAlpha(1.0f + (r15 * (-0.8f)));
        if (r12 == r11) goto L22;
        r12 = r12 + 1;
        r8 = r110;
        r7 = 2.0f;
        goto L10
    L22:
        return;
    L20:
        return;
    }

    public final void scrollToPosition(int r4) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        if (this.i != 0) goto L8;
        return;
    L8:
        if (this.l == false) goto L10;
        int r5 = RangesKt.coerceIn(r4, 0, getItemCount() - 1);
    L11:
        this.j = r5 * this.i;
        requestLayout();
        return;
    L10:
        int r0 = this.m;
        r5 = RangesKt.coerceIn(r4, r0, RangesKt.coerceAtLeast((getItemCount() - this.m) - 1, r0));
        goto L11
    }

    public final void onLayoutChildren(RecyclerView.Recycler r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r4, "recycler");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (getItemCount() != 0) goto L7;
        detachAndScrapAttachedViews(r4);
        this.j = 0.0f;
        return;
    L7:
        if (this.i != 0) goto L9;
        View r0 = r4.getViewForPosition(0);
        addView(r0);
        measureChildWithMargins(r0, 0, 0);
        int r6 = getDecoratedMeasuredHeight(r0);
        this.i = r6;
        this.k = r6 / ((float) Math.tan(this.f * this.h));
        detachAndScrapView(r0, r4);
    L9:
        p(r4);
    }

    public final int scrollVerticallyBy(int r4, RecyclerView.Recycler r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r5, "recycler");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (getChildCount() == 0) goto L16;
        if (r4 == 0) goto L16;
        if (this.i == 0) goto L16;
        if (getItemCount() == 0) goto L16;
        float r7 = RangesKt.coerceAtLeast(getItemCount() - 1, 0) * this.i;
        if (this.l == false) goto L13;
        Pair r8 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(r7));
    L14:
        float r9 = RangesKt.coerceIn(this.j + r4, ((Number) r8.component1()).floatValue(), ((Number) r8.component2()).floatValue());
        float r10 = r9 - this.j;
        this.j = r9;
        p(r5);
        return MathKt.roundToInt(r10);
    L13:
        int r11 = this.m;
        int r0 = RangesKt.coerceAtLeast((getItemCount() - this.m) - 1, r11);
        int r1 = this.i;
        r8 = TuplesKt.to(Float.valueOf(r11 * r1), Float.valueOf(r0 * r1));
    L16:
        return 0;
    }
}
