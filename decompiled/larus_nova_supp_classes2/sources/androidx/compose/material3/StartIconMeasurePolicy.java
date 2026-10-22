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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00162\u0006\u0010 \u001a\u00020\u001dH\u0016J\"\u0010!\u001a\u00020\u001d*\u00020\u001e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00162\u0006\u0010\"\u001a\u00020\u001dH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006#"}, d2 = {"Landroidx/compose/material3/StartIconMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "indicatorAnimationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "startIconToLabelHorizontalPadding", "<init>", "(Lkotlin/jvm/functions/Function0;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndicatorAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicHeight", "width", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StartIconMeasurePolicy implements MeasurePolicy {
    private final Function0<Float> indicatorAnimationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;

    public /* synthetic */ StartIconMeasurePolicy(Function0 r1, float r2, float r3, float r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* JADX INFO: renamed from: getIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3201getIndicatorHorizontalPaddingD9Ej5fM() {
        return this.indicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3202getIndicatorVerticalPaddingD9Ej5fM() {
        return this.indicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3203getStartIconToLabelHorizontalPaddingD9Ej5fM() {
        return this.startIconToLabelHorizontalPadding;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r9, List<? extends IntrinsicMeasurable> r10, int r11) {
        List<? extends IntrinsicMeasurable> r0 = r10;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L17;
        IntrinsicMeasurable r5 = (IntrinsicMeasurable) ListProtector.get(r10, r3);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r5), "icon") == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        int r4 = r5.maxIntrinsicHeight(r11);
        int r6 = r0.size();
    L8:
        if (r2 >= r6) goto L14;
        IntrinsicMeasurable r7 = (IntrinsicMeasurable) ListProtector.get(r10, r2);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r7), "label") == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        int r12 = r7.maxIntrinsicHeight(r11);
        return Math.max(r4, r12) + r9.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorVerticalPadding * 2));
    L14:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L17:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r9, List<? extends IntrinsicMeasurable> r10, int r11) {
        List<? extends IntrinsicMeasurable> r0 = r10;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L17;
        IntrinsicMeasurable r5 = (IntrinsicMeasurable) ListProtector.get(r10, r3);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r5), "icon") == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        int r4 = r5.maxIntrinsicWidth(r11);
        int r6 = r0.size();
    L8:
        if (r2 >= r6) goto L14;
        IntrinsicMeasurable r7 = (IntrinsicMeasurable) ListProtector.get(r10, r2);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r7), "label") == true) goto L12;
        r2 = r2 + 1;
        goto L8
    L12:
        return (r4 + r7.maxIntrinsicWidth(r11)) + r9.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(this.indicatorHorizontalPadding * 2) + this.startIconToLabelHorizontalPadding));
    L14:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L17:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3204measure3p2s80s(MeasureScope r19, List<? extends Measurable> r20, long r21) {
        float r3 = ((Number) this.indicatorAnimationProgress.invoke()).floatValue();
        long r4 = Constraints.copy-Zbe2FdA$default(r21, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r6 = r20;
        int r7 = r6.size();
        int r9 = 0;
    L4:
        if (r9 >= r7) goto L31;
        Measurable r11 = (Measurable) ListProtector.get(r20, r9);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r11), "icon") == true) goto L7;
        r9 = r9 + 1;
        goto L4
    L7:
        Placeable r8 = r11.measure-BRTryo0(r4);
        int r10 = r6.size();
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L28;
        Measurable r15 = (Measurable) ListProtector.get(r20, r12);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r15), "label") == true) goto L11;
        r12 = r12 + 1;
        r19 = r19;
        goto L8
    L11:
        Placeable r13 = r15.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r4, -(r8.getWidth() + r19.roundToPx-0680j_4(this.startIconToLabelHorizontalPadding)), 0, 2, null));
        float r14 = 2;
        int r16 = (r8.getWidth() + r13.getWidth()) + r19.roundToPx-0680j_4(Dp.constructor-impl(this.startIconToLabelHorizontalPadding + Dp.constructor-impl(this.indicatorHorizontalPadding * r14)));
        int r17 = Math.max(r8.getHeight(), r13.getHeight()) + r19.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorVerticalPadding * r14));
        int r5 = MathKt.roundToInt(r16 * r3);
        int r18 = r6.size();
        int r110 = 0;
    L12:
        if (r110 >= r18) goto L25;
        Measurable r111 = (Measurable) ListProtector.get(r20, r110);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r111), "indicatorRipple") == true) goto L15;
        r110 = r110 + 1;
        goto L12
    L15:
        Placeable r22 = r111.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r4, Constraints.Companion.fixed-JhjzzOo(r16, r17)));
        int r1 = r6.size();
        int r23 = 0;
    L16:
        if (r23 >= r1) goto L22;
        Measurable r112 = (Measurable) ListProtector.get(r20, r23);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r112), "indicator") == true) goto L20;
        r23 = r23 + 1;
        goto L16
    L20:
        return NavigationItemKt.m2940access$placeLabelAndStartIconnru01g4(r19, r13, r8, r22, r112.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r4, Constraints.Companion.fixed-JhjzzOo(r5, r17))), r21, this.startIconToLabelHorizontalPadding);
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

    private StartIconMeasurePolicy(Function0<Float> r1, float r2, float r3, float r4) {
        this.indicatorAnimationProgress = r1;
        this.indicatorHorizontalPadding = r2;
        this.indicatorVerticalPadding = r3;
        this.startIconToLabelHorizontalPadding = r4;
    }
}
