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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020#*\u00020$2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010&\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/compose/material3/TopIconOrIconOnlyMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "hasLabel", "", "indicatorAnimationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "topIconItemVerticalPadding", "<init>", "(ZLkotlin/jvm/functions/Function0;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHasLabel", "()Z", "getIndicatorAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getIndicatorToLabelVerticalPadding-D9Ej5fM", "getTopIconItemVerticalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {
    private final boolean hasLabel;
    private final Function0<Float> indicatorAnimationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorToLabelVerticalPadding;
    private final float indicatorVerticalPadding;
    private final float topIconItemVerticalPadding;

    public /* synthetic */ TopIconOrIconOnlyMeasurePolicy(boolean r1, Function0 r2, float r3, float r4, float r5, float r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final boolean getHasLabel() {
        return this.hasLabel;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* JADX INFO: renamed from: getIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3594getIndicatorHorizontalPaddingD9Ej5fM() {
        return this.indicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3595getIndicatorToLabelVerticalPaddingD9Ej5fM() {
        return this.indicatorToLabelVerticalPadding;
    }

    /* JADX INFO: renamed from: getIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3596getIndicatorVerticalPaddingD9Ej5fM() {
        return this.indicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getTopIconItemVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m3597getTopIconItemVerticalPaddingD9Ej5fM() {
        return this.topIconItemVerticalPadding;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r8, List<? extends IntrinsicMeasurable> r9, int r10) {
        List<? extends IntrinsicMeasurable> r0 = r9;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L19;
        IntrinsicMeasurable r4 = (IntrinsicMeasurable) ListProtector.get(r9, r3);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(r4), "icon") == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        int r5 = r4.maxIntrinsicHeight(r10);
        int r6 = r0.size();
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L12;
        Object r11 = ListProtector.get(r9, r7);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r11), "label") == true) goto L13;
        r7 = r7 + 1;
    L13:
        IntrinsicMeasurable r12 = (IntrinsicMeasurable) r11;
        if (r12 == null) goto L16;
        r2 = r12.maxIntrinsicHeight(r10);
    L16:
        float r13 = 2;
        return (r5 + r2) + r8.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(this.topIconItemVerticalPadding * r13) + Dp.constructor-impl(this.indicatorVerticalPadding * r13)) + this.indicatorToLabelVerticalPadding));
    L12:
        r11 = null;
        goto L13
    L19:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3598measure3p2s80s(MeasureScope r19, List<? extends Measurable> r20, long r21) {
        float r3 = ((Number) this.indicatorAnimationProgress.invoke()).floatValue();
        long r12 = Constraints.copy-Zbe2FdA$default(r21, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r4 = r20;
        int r5 = r4.size();
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L34;
        Measurable r9 = (Measurable) ListProtector.get(r20, r7);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r9), "icon") == true) goto L7;
        r7 = r7 + 1;
        goto L4
    L7:
        float r8 = 2;
        Placeable r6 = r9.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r12, -r19.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorHorizontalPadding * r8)), -r19.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorVerticalPadding * r8))));
        int r10 = r6.getWidth() + r19.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorHorizontalPadding * r8));
        int r11 = r6.getHeight() + r19.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorVerticalPadding * r8));
        int r13 = MathKt.roundToInt(r10 * r3);
        int r14 = r4.size();
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L31;
        Measurable r16 = (Measurable) ListProtector.get(r20, r15);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r16), "indicatorRipple") == true) goto L11;
        r15 = r15 + 1;
        goto L8
    L11:
        Placeable r17 = r16.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r12, Constraints.Companion.fixed-JhjzzOo(r10, r11)));
        int r18 = r4.size();
        int r22 = 0;
    L12:
        if (r22 >= r18) goto L28;
        Measurable r110 = (Measurable) ListProtector.get(r20, r22);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r110), "indicator") == true) goto L15;
        r22 = r22 + 1;
        goto L12
    L15:
        Placeable r23 = r110.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r12, Constraints.Companion.fixed-JhjzzOo(r13, r11)));
        if (this.hasLabel == false) goto L26;
        int r24 = r4.size();
        int r25 = 0;
    L18:
        if (r25 >= r24) goto L23;
        Measurable r26 = (Measurable) ListProtector.get(r20, r25);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r26), "label") == true) goto L44;
        r25 = r25 + 1;
        goto L18
    L44:
        return NavigationItemKt.m2941access$placeLabelAndTopIconqoqLrGI(r19, r26.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r12, 0, -(r23.getHeight() + r19.roundToPx-0680j_4(this.indicatorToLabelVerticalPadding)), 1, null)), r6, r17, r23, r21, this.indicatorToLabelVerticalPadding, this.indicatorVerticalPadding, this.topIconItemVerticalPadding);
    L23:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L26:
        return NavigationItemKt.m2939access$placeIconX9ElhV4(r19, r6, r17, r23, r21);
    L28:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L31:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L34:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private TopIconOrIconOnlyMeasurePolicy(boolean r1, Function0<Float> r2, float r3, float r4, float r5, float r6) {
        this.hasLabel = r1;
        this.indicatorAnimationProgress = r2;
        this.indicatorHorizontalPadding = r3;
        this.indicatorVerticalPadding = r4;
        this.indicatorToLabelVerticalPadding = r5;
        this.topIconItemVerticalPadding = r6;
    }
}
