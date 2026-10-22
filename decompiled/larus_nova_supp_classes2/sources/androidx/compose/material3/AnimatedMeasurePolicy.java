package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010!\u001a\u00020\"*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\"\u0010+\u001a\u00020,*\u00020-2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020,H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/AnimatedMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionProgress", "Lkotlin/Function0;", "", "indicatorAnimationProgress", "topIconIndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "startIconToLabelHorizontalPadding", "itemHorizontalPadding", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIconPosition--xw1Ddg", "()I", "I", "getIconPositionProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorAnimationProgress", "getTopIconIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getTopIconIndicatorVerticalPadding-D9Ej5fM", "getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM", "getStartIconIndicatorHorizontalPadding-D9Ej5fM", "getStartIconIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "getItemHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimatedMeasurePolicy implements MeasurePolicy {
    private final int iconPosition;
    private final Function0<Float> iconPositionProgress;
    private final Function0<Float> indicatorAnimationProgress;
    private final float itemHorizontalPadding;
    private final float startIconIndicatorHorizontalPadding;
    private final float startIconIndicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;
    private final float topIconIndicatorHorizontalPadding;
    private final float topIconIndicatorToLabelVerticalPadding;
    private final float topIconIndicatorVerticalPadding;

    public /* synthetic */ AnimatedMeasurePolicy(int r1, Function0 r2, Function0 r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    /* JADX INFO: renamed from: getIconPosition--xw1Ddg, reason: not valid java name */
    public final int m2293getIconPositionxw1Ddg() {
        return this.iconPosition;
    }

    public final Function0<Float> getIconPositionProgress() {
        return this.iconPositionProgress;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* JADX INFO: renamed from: getItemHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2294getItemHorizontalPaddingD9Ej5fM() {
        return this.itemHorizontalPadding;
    }

    /* JADX INFO: renamed from: getStartIconIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2295getStartIconIndicatorHorizontalPaddingD9Ej5fM() {
        return this.startIconIndicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getStartIconIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2296getStartIconIndicatorVerticalPaddingD9Ej5fM() {
        return this.startIconIndicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2297getStartIconToLabelHorizontalPaddingD9Ej5fM() {
        return this.startIconToLabelHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2298getTopIconIndicatorHorizontalPaddingD9Ej5fM() {
        return this.topIconIndicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2299getTopIconIndicatorToLabelVerticalPaddingD9Ej5fM() {
        return this.topIconIndicatorToLabelVerticalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m2300getTopIconIndicatorVerticalPaddingD9Ej5fM() {
        return this.topIconIndicatorVerticalPadding;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r9, List<? extends IntrinsicMeasurable> r10, int r11) {
        List<? extends IntrinsicMeasurable> r0 = r10;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L21;
        IntrinsicMeasurable r5 = (IntrinsicMeasurable) ListProtector.get(r10, r3);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r5), "icon") == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        int r4 = r5.maxIntrinsicWidth(r11);
        int r6 = r0.size();
    L8:
        if (r2 >= r6) goto L18;
        IntrinsicMeasurable r7 = (IntrinsicMeasurable) ListProtector.get(r10, r2);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r7), "label") == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        int r12 = r7.maxIntrinsicWidth(r11);
        if (NavigationItemIconPosition.m2927equalsimpl0(this.iconPosition, NavigationItemIconPosition.Companion.m2932getTopxw1Ddg()) == false) goto L16;
        float r8 = 2;
        return Math.max(r12, r4 + r9.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(this.topIconIndicatorHorizontalPadding * r8) + Dp.constructor-impl(this.itemHorizontalPadding * r8))));
    L16:
        return (r4 + r12) + r9.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(this.startIconIndicatorHorizontalPadding * 2) + this.startIconToLabelHorizontalPadding) + this.itemHorizontalPadding));
    L18:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L21:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2301measure3p2s80s(MeasureScope r21, List<? extends Measurable> r22, long r23) {
        float r3 = ((Number) this.indicatorAnimationProgress.invoke()).floatValue();
        float r4 = ((Number) this.iconPositionProgress.invoke()).floatValue();
        long r9 = Constraints.copy-Zbe2FdA$default(r23, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r5 = r22;
        int r6 = r5.size();
        int r8 = 0;
    L4:
        if (r8 >= r6) goto L31;
        Measurable r12 = (Measurable) ListProtector.get(r22, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r12), "icon") == true) goto L7;
        r8 = r8 + 1;
        goto L4
    L7:
        Placeable r7 = r12.measure-BRTryo0(r9);
        int r10 = r5.size();
        int r13 = 0;
    L8:
        if (r13 >= r10) goto L28;
        Measurable r14 = (Measurable) ListProtector.get(r22, r13);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r14), "label") == true) goto L11;
        r13 = r13 + 1;
        r21 = r21;
        goto L8
    L11:
        Placeable r11 = r14.measure-BRTryo0(r9);
        float r15 = 2;
        int r16 = r7.getWidth() + r21.roundToPx-0680j_4(Dp.constructor-impl(this.topIconIndicatorHorizontalPadding * r15));
        int r17 = r7.getHeight() + r21.roundToPx-0680j_4(Dp.constructor-impl(this.topIconIndicatorVerticalPadding * r15));
        int r18 = (r7.getWidth() + r11.getWidth()) + r21.roundToPx-0680j_4(Dp.constructor-impl(this.startIconToLabelHorizontalPadding + Dp.constructor-impl(this.startIconIndicatorHorizontalPadding * r15)));
        int r19 = Math.max(r7.getHeight(), r11.getHeight()) + r21.roundToPx-0680j_4(Dp.constructor-impl(this.startIconIndicatorVerticalPadding * r15));
        int r110 = MathHelpersKt.lerp(r16, r18, r4);
        int r20 = MathKt.roundToInt(r110 * r3);
        int r24 = MathHelpersKt.lerp(r17, r19, r4);
        int r25 = r5.size();
        int r111 = 0;
    L12:
        if (r111 >= r25) goto L25;
        Measurable r112 = (Measurable) ListProtector.get(r22, r111);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r112), "indicatorRipple") == true) goto L15;
        r111 = r111 + 1;
        goto L12
    L15:
        Placeable r113 = r112.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r9, Constraints.Companion.fixed-JhjzzOo(r110, r24)));
        int r1 = r5.size();
        int r26 = 0;
    L16:
        if (r26 >= r1) goto L22;
        Measurable r27 = (Measurable) ListProtector.get(r22, r26);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r27), "indicator") == true) goto L20;
        r26 = r26 + 1;
        goto L16
    L20:
        return NavigationItemKt.m2938access$placeAnimatedLabelAndIcon2QYhCQ8(r21, this.iconPosition, this.iconPositionProgress, r11, r7, r113, r27.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r9, Constraints.Companion.fixed-JhjzzOo(r20, r24))), r16, r9, this.topIconIndicatorToLabelVerticalPadding, this.topIconIndicatorVerticalPadding, this.topIconIndicatorHorizontalPadding, this.startIconIndicatorHorizontalPadding, this.startIconIndicatorVerticalPadding, this.startIconToLabelHorizontalPadding, this.itemHorizontalPadding);
    L22:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L25:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L28:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L31:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private AnimatedMeasurePolicy(int r1, Function0<Float> r2, Function0<Float> r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
        this.iconPosition = r1;
        this.iconPositionProgress = r2;
        this.indicatorAnimationProgress = r3;
        this.topIconIndicatorHorizontalPadding = r4;
        this.topIconIndicatorVerticalPadding = r5;
        this.topIconIndicatorToLabelVerticalPadding = r6;
        this.startIconIndicatorHorizontalPadding = r7;
        this.startIconIndicatorVerticalPadding = r8;
        this.startIconToLabelHorizontalPadding = r9;
        this.itemHorizontalPadding = r10;
    }
}
