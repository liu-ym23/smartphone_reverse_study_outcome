package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.internal.LayoutUtilKt;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\"\u0010\u001d\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\"\u0010\u001e\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\"\u0010 \u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J<\u0010!\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001f\u001a\u00020\u00192\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0002J<\u0010$\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u00192\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/material/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public static /* synthetic */ int a(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicHeight$lambda$8(r0, r1);
    }

    public static /* synthetic */ int b(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicWidth$lambda$10(r0, r1);
    }

    public static /* synthetic */ int c(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicHeight$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit d(int r0, int r1, Placeable r2, Placeable r3, Placeable r4, Placeable r5, Placeable r6, Placeable r7, OutlinedTextFieldMeasurePolicy r8, MeasureScope r9, Placeable.PlacementScope r10) {
        return measure_3p2s80s$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ int e(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicWidth$lambda$11(r0, r1);
    }

    private static final int maxIntrinsicHeight$lambda$8(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicHeight(r1);
    }

    private static final int maxIntrinsicWidth$lambda$10(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicWidth(r1);
    }

    private static final int minIntrinsicHeight$lambda$9(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicHeight(r1);
    }

    private static final int minIntrinsicWidth$lambda$11(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicWidth(r1);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new s7());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicWidth(r2, r3, r4, new t7());
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2118measure3p2s80s(final MeasureScope r34, List<? extends Measurable> r35, long r36) {
        int r1 = r34.roundToPx-0680j_4(this.paddingValues.mo898calculateBottomPaddingD9Ej5fM());
        long r2 = Constraints.copy-Zbe2FdA$default(r36, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r4 = r35;
        int r5 = r4.size();
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L8;
        Object r9 = ListProtector.get(r35, r7);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r9), TextFieldImplKt.LeadingId) == true) goto L9;
        r7 = r7 + 1;
    L9:
        Measurable r10 = (Measurable) r9;
        if (r10 == null) goto L12;
        Placeable r6 = r10.measure-BRTryo0(r2);
    L13:
        int r8 = TextFieldImplKt.widthOrZero(r6) + 0;
        int r11 = r4.size();
        int r12 = 0;
    L14:
        if (r12 >= r11) goto L19;
        Object r13 = ListProtector.get(r35, r12);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r13), TextFieldImplKt.TrailingId) == true) goto L20;
        r12 = r12 + 1;
    L20:
        Measurable r14 = (Measurable) r13;
        if (r14 == null) goto L23;
        Placeable r15 = r14.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r2, -r8, 0, 2, null));
    L24:
        int r16 = r8 + TextFieldImplKt.widthOrZero(r15);
        int r17 = r34.roundToPx-0680j_4(this.paddingValues.mo899calculateLeftPaddingu2uoSUM(r34.getLayoutDirection())) + r34.roundToPx-0680j_4(this.paddingValues.mo900calculateRightPaddingu2uoSUM(r34.getLayoutDirection()));
        int r18 = -r16;
        int r3 = -r1;
        long r19 = ConstraintsKt.offset-NN6Ew-U(r2, MathHelpersKt.lerp(r18 - r17, -r17, this.animationProgress), r3);
        int r110 = r4.size();
        int r111 = 0;
    L25:
        if (r111 >= r110) goto L30;
        Object r112 = ListProtector.get(r35, r111);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r112), TextFieldImplKt.LabelId) == true) goto L31;
        r111 = r111 + 1;
    L31:
        Measurable r113 = (Measurable) r112;
        if (r113 == null) goto L34;
        final Placeable r20 = r113.measure-BRTryo0(r19);
    L35:
        if (r20 == null) goto L37;
        float r21 = r20.getWidth();
        float r22 = r20.getHeight();
        long r114 = Float.floatToRawIntBits(r21);
        long r23 = Size.constructor-impl((((long) Float.floatToRawIntBits(r22)) & 4294967295L) | (r114 << 32));
    L38:
        this.onLabelMeasured.invoke(Size.box-impl(r23));
        long r115 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(r36, r18, r3 - Math.max(TextFieldImplKt.heightOrZero(r20) / 2, r34.roundToPx-0680j_4(this.paddingValues.mo901calculateTopPaddingD9Ej5fM()))), 0, 0, 0, 0, 11, null);
        int r24 = r4.size();
        int r25 = 0;
    L40:
        if (r25 >= r24) goto L71;
        Measurable r116 = (Measurable) ListProtector.get(r35, r25);
        int r117 = r24;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r116), TextFieldImplKt.TextFieldId) == true) goto L43;
        r25 = r25 + 1;
        r24 = r117;
        goto L40
    L43:
        final Placeable r26 = r116.measure-BRTryo0(r115);
        long r118 = Constraints.copy-Zbe2FdA$default(r115, 0, 0, 0, 0, 14, null);
        int r27 = r4.size();
        int r28 = 0;
    L44:
        if (r28 >= r27) goto L49;
        Object r119 = ListProtector.get(r35, r28);
        int r120 = r27;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r119), TextFieldImplKt.PlaceholderId) == true) goto L50;
        r28 = r28 + 1;
        r27 = r120;
    L50:
        Measurable r121 = (Measurable) r119;
        if (r121 == null) goto L53;
        Placeable r29 = r121.measure-BRTryo0(r118);
    L54:
        final int r122 = OutlinedTextFieldKt.m2114access$calculateWidthO3s9Psw(TextFieldImplKt.widthOrZero(r6), TextFieldImplKt.widthOrZero(r15), r26.getWidth(), TextFieldImplKt.widthOrZero(r20), TextFieldImplKt.widthOrZero(r29), this.animationProgress, r36, r34.getDensity(), this.paddingValues);
        final int r123 = OutlinedTextFieldKt.m2113access$calculateHeightO3s9Psw(TextFieldImplKt.heightOrZero(r6), TextFieldImplKt.heightOrZero(r15), r26.getHeight(), TextFieldImplKt.heightOrZero(r20), TextFieldImplKt.heightOrZero(r29), this.animationProgress, r36, r34.getDensity(), this.paddingValues);
        int r30 = r4.size();
        int r31 = 0;
    L55:
        if (r31 >= r30) goto L68;
        Measurable r32 = (Measurable) ListProtector.get(r35, r31);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r32), OutlinedTextFieldKt.BorderId) == true) goto L59;
        r31 = r31 + 1;
        goto L55
    L59:
        if (r122 == Integer.MAX_VALUE) goto L61;
        int r33 = r122;
    L62:
        if (r123 == Integer.MAX_VALUE) goto L64;
        int r0 = r123;
    L65:
        final Placeable r124 = r32.measure-BRTryo0(ConstraintsKt.Constraints(r33, r122, r0, r123));
        final Placeable r37 = r6;
        final Placeable r38 = r15;
        final Placeable r39 = r29;
        return MeasureScope.-CC.layout$default(r34, r122, r123, null, new r7(r123, r122, r37, r38, r26, r20, r39, r124, this, r34), 4, null);
    L64:
        r0 = 0;
        goto L65
    L61:
        r33 = 0;
        goto L62
    L68:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L53:
        r29 = null;
        goto L54
    L49:
        r119 = null;
        goto L50
    L71:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L37:
        r23 = Size.Companion.getZero-NH-jbRc();
        goto L38
    L34:
        r20 = null;
        goto L35
    L30:
        r112 = null;
        goto L31
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L12:
        r6 = null;
        goto L13
    L8:
        r9 = null;
        goto L9
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new v7());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicWidth(r2, r3, r4, new u7());
    }

    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> r1, boolean r2, float r3, PaddingValues r4) {
        this.onLabelMeasured = r1;
        this.singleLine = r2;
        this.animationProgress = r3;
        this.paddingValues = r4;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope r20, List<? extends IntrinsicMeasurable> r21, int r22, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r23) {
        List<? extends IntrinsicMeasurable> r4 = r21;
        int r5 = r4.size();
        int r7 = 0;
    L3:
        Object r8 = null;
        if (r7 >= r5) goto L9;
        Object r9 = ListProtector.get(r21, r7);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r9), TextFieldImplKt.LeadingId) == true) goto L10;
        r7 = r7 + 1;
    L10:
        IntrinsicMeasurable r10 = (IntrinsicMeasurable) r9;
        if (r10 == null) goto L13;
        int r11 = LayoutUtilKt.subtractConstraintSafely(r22, r10.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r12 = ((Number) r23.invoke(r10, Integer.valueOf(r22))).intValue();
    L14:
        int r13 = r4.size();
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L20;
        Object r15 = ListProtector.get(r21, r14);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r15), TextFieldImplKt.TrailingId) == true) goto L21;
        r14 = r14 + 1;
    L21:
        IntrinsicMeasurable r16 = (IntrinsicMeasurable) r15;
        if (r16 == null) goto L24;
        r11 = LayoutUtilKt.subtractConstraintSafely(r11, r16.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r17 = ((Number) r23.invoke(r16, Integer.valueOf(r22))).intValue();
    L25:
        int r6 = r4.size();
        int r18 = 0;
    L26:
        if (r18 >= r6) goto L31;
        Object r19 = ListProtector.get(r21, r18);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r19), TextFieldImplKt.LabelId) == true) goto L32;
        r18 = r18 + 1;
    L32:
        IntrinsicMeasurable r110 = (IntrinsicMeasurable) r19;
        if (r110 == null) goto L35;
        int r111 = ((Number) r23.invoke(r110, Integer.valueOf(MathHelpersKt.lerp(r11, r22, this.animationProgress)))).intValue();
    L36:
        int r2 = r4.size();
        int r24 = 0;
    L37:
        if (r24 >= r2) goto L53;
        Object r112 = ListProtector.get(r21, r24);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r112), TextFieldImplKt.TextFieldId) == true) goto L40;
        r24 = r24 + 1;
        goto L37
    L40:
        int r113 = ((Number) r23.invoke(r112, Integer.valueOf(r11))).intValue();
        int r3 = r4.size();
        int r25 = 0;
    L41:
        if (r25 >= r3) goto L46;
        Object r26 = ListProtector.get(r21, r25);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r26), TextFieldImplKt.PlaceholderId) == true) goto L44;
        r25 = r25 + 1;
        goto L41
    L44:
        r8 = r26;
    L46:
        IntrinsicMeasurable r27 = (IntrinsicMeasurable) r8;
        if (r27 == null) goto L49;
        int r114 = ((Number) r23.invoke(r27, Integer.valueOf(r11))).intValue();
    L51:
        return OutlinedTextFieldKt.m2113access$calculateHeightO3s9Psw(r12, r17, r113, r111, r114, this.animationProgress, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), r20.getDensity(), this.paddingValues);
    L49:
        r114 = 0;
        goto L51
    L53:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L35:
        r111 = 0;
        goto L36
    L31:
        r19 = null;
        goto L32
    L24:
        r17 = 0;
        goto L25
    L20:
        r15 = null;
        goto L21
    L13:
        r11 = r22;
        r12 = 0;
        goto L14
    L9:
        r9 = null;
        goto L10
    }

    private final int intrinsicWidth(IntrinsicMeasureScope r19, List<? extends IntrinsicMeasurable> r20, int r21, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r22) {
        List<? extends IntrinsicMeasurable> r3 = r20;
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L53;
        Object r7 = ListProtector.get(r20, r6);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r7), TextFieldImplKt.TextFieldId) == true) goto L6;
        r6 = r6 + 1;
        goto L3
    L6:
        int r8 = ((Number) r22.invoke(r7, Integer.valueOf(r21))).intValue();
        int r5 = r3.size();
        int r9 = 0;
    L7:
        Object r10 = null;
        if (r9 >= r5) goto L13;
        Object r11 = ListProtector.get(r20, r9);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r11), TextFieldImplKt.LabelId) == true) goto L14;
        r9 = r9 + 1;
    L14:
        IntrinsicMeasurable r12 = (IntrinsicMeasurable) r11;
        if (r12 == null) goto L17;
        int r13 = ((Number) r22.invoke(r12, Integer.valueOf(r21))).intValue();
    L18:
        int r14 = r3.size();
        int r15 = 0;
    L19:
        if (r15 >= r14) goto L24;
        Object r16 = ListProtector.get(r20, r15);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r16), TextFieldImplKt.TrailingId) == true) goto L25;
        r15 = r15 + 1;
    L25:
        IntrinsicMeasurable r17 = (IntrinsicMeasurable) r16;
        if (r17 == null) goto L28;
        int r18 = ((Number) r22.invoke(r17, Integer.valueOf(r21))).intValue();
    L29:
        int r23 = r3.size();
        int r110 = 0;
    L30:
        if (r110 >= r23) goto L35;
        Object r111 = ListProtector.get(r20, r110);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r111), TextFieldImplKt.LeadingId) == true) goto L36;
        r110 = r110 + 1;
    L36:
        IntrinsicMeasurable r112 = (IntrinsicMeasurable) r111;
        if (r112 == null) goto L39;
        int r24 = ((Number) r22.invoke(r112, Integer.valueOf(r21))).intValue();
    L40:
        int r25 = r3.size();
        int r113 = 0;
    L41:
        if (r113 >= r25) goto L46;
        Object r114 = ListProtector.get(r20, r113);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r114), TextFieldImplKt.PlaceholderId) == true) goto L44;
        r113 = r113 + 1;
        goto L41
    L44:
        r10 = r114;
    L46:
        IntrinsicMeasurable r26 = (IntrinsicMeasurable) r10;
        if (r26 == null) goto L49;
        int r115 = ((Number) r22.invoke(r26, Integer.valueOf(r21))).intValue();
    L51:
        return OutlinedTextFieldKt.m2114access$calculateWidthO3s9Psw(r24, r18, r8, r13, r115, this.animationProgress, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), r19.getDensity(), this.paddingValues);
    L49:
        r115 = 0;
        goto L51
    L39:
        r24 = 0;
        goto L40
    L35:
        r111 = null;
        goto L36
    L28:
        r18 = 0;
        goto L29
    L24:
        r16 = null;
        goto L25
    L17:
        r13 = 0;
        goto L18
    L13:
        r11 = null;
        goto L14
    L53:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$7(int r14, int r15, Placeable r16, Placeable r17, Placeable r18, Placeable r19, Placeable r20, Placeable r21, OutlinedTextFieldMeasurePolicy r22, MeasureScope r23, Placeable.PlacementScope r24) {
        OutlinedTextFieldKt.access$place(r24, r14, r15, r16, r17, r18, r19, r20, r21, r22.animationProgress, r22.singleLine, r23.getDensity(), r23.getLayoutDirection(), r22.paddingValues);
        return Unit.INSTANCE;
    }
}
