package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.internal.LayoutUtilKt;
import androidx.compose.ui.layout.AlignmentLineKt;
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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\"\u0010\u0019\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\"\u0010\u001a\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\"\u0010\u001c\u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J8\u0010\u001d\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001fH\u0002J<\u0010 \u001a\u00020\u0015*\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u00152\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public static /* synthetic */ int a(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicWidth$lambda$10(r0, r1);
    }

    public static /* synthetic */ int b(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicHeight$lambda$8(r0, r1);
    }

    public static /* synthetic */ int c(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicHeight$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit d(Placeable r0, int r1, int r2, int r3, int r4, Placeable r5, Placeable r6, Placeable r7, Placeable r8, TextFieldMeasurePolicy r9, int r10, int r11, MeasureScope r12, Placeable.PlacementScope r13) {
        return measure_3p2s80s$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ int e(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicWidth$lambda$9(r0, r1);
    }

    private static final int maxIntrinsicHeight$lambda$7(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicHeight(r1);
    }

    private static final int maxIntrinsicWidth$lambda$9(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicWidth(r1);
    }

    private static final int minIntrinsicHeight$lambda$8(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicHeight(r1);
    }

    private static final int minIntrinsicWidth$lambda$10(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicWidth(r1);
    }

    public TextFieldMeasurePolicy(boolean r1, float r2, PaddingValues r3) {
        this.singleLine = r1;
        this.animationProgress = r2;
        this.paddingValues = r3;
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> r17, int r18, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r19) {
        List<? extends IntrinsicMeasurable> r2 = r17;
        int r3 = r2.size();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L53;
        Object r6 = ListProtector.get(r17, r5);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r6), TextFieldImplKt.TextFieldId) == true) goto L6;
        r5 = r5 + 1;
        goto L3
    L6:
        int r7 = ((Number) r19.invoke(r6, Integer.valueOf(r18))).intValue();
        int r4 = r2.size();
        int r8 = 0;
    L7:
        Object r9 = null;
        if (r8 >= r4) goto L13;
        Object r10 = ListProtector.get(r17, r8);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r10), TextFieldImplKt.LabelId) == true) goto L14;
        r8 = r8 + 1;
    L14:
        IntrinsicMeasurable r11 = (IntrinsicMeasurable) r10;
        if (r11 == null) goto L17;
        int r12 = ((Number) r19.invoke(r11, Integer.valueOf(r18))).intValue();
    L18:
        int r13 = r2.size();
        int r14 = 0;
    L19:
        if (r14 >= r13) goto L24;
        Object r15 = ListProtector.get(r17, r14);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r15), TextFieldImplKt.TrailingId) == true) goto L25;
        r14 = r14 + 1;
    L25:
        IntrinsicMeasurable r16 = (IntrinsicMeasurable) r15;
        if (r16 == null) goto L28;
        int r20 = ((Number) r19.invoke(r16, Integer.valueOf(r18))).intValue();
    L29:
        int r21 = r2.size();
        int r22 = 0;
    L30:
        if (r22 >= r21) goto L35;
        Object r110 = ListProtector.get(r17, r22);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r110), TextFieldImplKt.LeadingId) == true) goto L36;
        r22 = r22 + 1;
    L36:
        IntrinsicMeasurable r111 = (IntrinsicMeasurable) r110;
        if (r111 == null) goto L39;
        int r23 = ((Number) r19.invoke(r111, Integer.valueOf(r18))).intValue();
    L40:
        int r24 = r2.size();
        int r25 = 0;
    L41:
        if (r25 >= r24) goto L46;
        Object r112 = ListProtector.get(r17, r25);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r112), TextFieldImplKt.PlaceholderId) == true) goto L44;
        r25 = r25 + 1;
        goto L41
    L44:
        r9 = r112;
    L46:
        IntrinsicMeasurable r26 = (IntrinsicMeasurable) r9;
        if (r26 == null) goto L49;
        int r27 = ((Number) r19.invoke(r26, Integer.valueOf(r18))).intValue();
    L51:
        return TextFieldKt.m2228access$calculateWidthVsPV1Ek(r23, r20, r7, r12, r27, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    L49:
        r27 = 0;
        goto L51
    L39:
        r23 = 0;
        goto L40
    L35:
        r110 = null;
        goto L36
    L28:
        r20 = 0;
        goto L29
    L24:
        r15 = null;
        goto L25
    L17:
        r12 = 0;
        goto L18
    L13:
        r10 = null;
        goto L14
    L53:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new kd());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, List<? extends IntrinsicMeasurable> r2, int r3) {
        return intrinsicWidth(r2, r3, new jd());
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2231measure3p2s80s(final MeasureScope r34, List<? extends Measurable> r35, long r36) {
        List<? extends Measurable> r0 = r35;
        final int r2 = r34.roundToPx-0680j_4(this.paddingValues.mo901calculateTopPaddingD9Ej5fM());
        int r1 = r34.roundToPx-0680j_4(this.paddingValues.mo898calculateBottomPaddingD9Ej5fM());
        final int r12 = r34.roundToPx-0680j_4(TextFieldKt.getTextFieldTopPadding());
        long r3 = Constraints.copy-Zbe2FdA$default(r36, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r5 = r0;
        int r6 = r5.size();
        int r8 = 0;
    L3:
        if (r8 >= r6) goto L8;
        Object r10 = ListProtector.get(r0, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r10), TextFieldImplKt.LeadingId) == true) goto L9;
        r8 = r8 + 1;
    L9:
        Measurable r11 = (Measurable) r10;
        if (r11 == null) goto L12;
        final Placeable r9 = r11.measure-BRTryo0(r3);
    L13:
        int r7 = TextFieldImplKt.widthOrZero(r9) + 0;
        int r13 = r5.size();
        int r14 = 0;
    L14:
        if (r14 >= r13) goto L19;
        Object r15 = ListProtector.get(r0, r14);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r15), TextFieldImplKt.TrailingId) == true) goto L20;
        r14 = r14 + 1;
    L20:
        Measurable r16 = (Measurable) r15;
        if (r16 == null) goto L23;
        final Placeable r17 = r16.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r3, -r7, 0, 2, null));
    L24:
        int r18 = r7 + TextFieldImplKt.widthOrZero(r17);
        int r19 = -r1;
        int r20 = -r18;
        long r4 = ConstraintsKt.offset-NN6Ew-U(r3, r20, r19);
        int r110 = r5.size();
        int r111 = 0;
    L25:
        if (r111 >= r110) goto L30;
        Object r112 = ListProtector.get(r0, r111);
        int r113 = r110;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r112), TextFieldImplKt.LabelId) == true) goto L28;
        r111 = r111 + 1;
        r110 = r113;
        goto L25
    L28:
        Object r114 = r112;
    L31:
        Measurable r115 = (Measurable) r114;
        if (r115 == null) goto L34;
        Placeable r21 = r115.measure-BRTryo0(r4);
    L35:
        if (r21 == null) goto L40;
        int r22 = r21.get(AlignmentLineKt.getLastBaseline());
        if (r22 != Integer.MIN_VALUE) goto L41;
        r22 = r21.getHeight();
    L41:
        final int r116 = Math.max(r22, r2);
        if (r21 == null) goto L44;
        int r23 = (r19 - r12) - r116;
    L45:
        long r24 = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(r36, 0, 0, 0, 0, 11, null), r20, r23);
        int r25 = r5.size();
        int r117 = 0;
    L46:
        if (r117 >= r25) goto L67;
        Measurable r118 = (Measurable) ListProtector.get(r0, r117);
        int r119 = r25;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r118), TextFieldImplKt.TextFieldId) == true) goto L49;
        r117 = r117 + 1;
        r0 = r35;
        r25 = r119;
        goto L46
    L49:
        final Placeable r120 = r118.measure-BRTryo0(r24);
        long r26 = Constraints.copy-Zbe2FdA$default(r24, 0, 0, 0, 0, 14, null);
        int r27 = r5.size();
        int r28 = 0;
    L50:
        if (r28 >= r27) goto L55;
        Object r121 = ListProtector.get(r0, r28);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r121), TextFieldImplKt.PlaceholderId) == true) goto L56;
        r28 = r28 + 1;
        r0 = r35;
    L56:
        Measurable r122 = (Measurable) r121;
        if (r122 == null) goto L59;
        final Placeable r29 = r122.measure-BRTryo0(r26);
    L60:
        final int r123 = TextFieldKt.m2228access$calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(r9), TextFieldImplKt.widthOrZero(r17), r120.getWidth(), TextFieldImplKt.widthOrZero(r21), TextFieldImplKt.widthOrZero(r29), r36);
        int r210 = r120.getHeight();
        if (r21 == null) goto L63;
        boolean r211 = true;
    L64:
        final int r124 = TextFieldKt.m2227access$calculateHeightO3s9Psw(r210, r211, r116, TextFieldImplKt.heightOrZero(r9), TextFieldImplKt.heightOrZero(r17), TextFieldImplKt.heightOrZero(r29), r36, r34.getDensity(), this.paddingValues);
        final Placeable r30 = r21;
        final int r31 = r22;
        return MeasureScope.-CC.layout$default(r34, r123, r124, null, new ld(r30, r2, r31, r123, r124, r120, r29, r9, r17, this, r116, r12, r34), 4, null);
    L63:
        r211 = false;
        goto L64
    L59:
        r29 = null;
        goto L60
    L55:
        r121 = null;
        goto L56
    L67:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L44:
        r23 = (-r2) - r1;
        goto L45
    L40:
        r22 = 0;
        goto L41
    L34:
        r21 = null;
        goto L35
    L30:
        r114 = null;
        goto L31
    L23:
        r17 = null;
        goto L24
    L19:
        r15 = null;
        goto L20
    L12:
        r9 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new hd());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, List<? extends IntrinsicMeasurable> r2, int r3) {
        return intrinsicWidth(r2, r3, new id());
    }

    private final int intrinsicHeight(IntrinsicMeasureScope r18, List<? extends IntrinsicMeasurable> r19, int r20, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r21) {
        List<? extends IntrinsicMeasurable> r2 = r19;
        int r3 = r2.size();
        int r5 = 0;
    L3:
        Object r6 = null;
        if (r5 >= r3) goto L9;
        Object r7 = ListProtector.get(r19, r5);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r7), TextFieldImplKt.LeadingId) == true) goto L10;
        r5 = r5 + 1;
    L10:
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) r7;
        if (r8 == null) goto L13;
        int r9 = LayoutUtilKt.subtractConstraintSafely(r20, r8.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r10 = ((Number) r21.invoke(r8, Integer.valueOf(r20))).intValue();
    L14:
        int r11 = r2.size();
        int r12 = 0;
    L15:
        if (r12 >= r11) goto L20;
        Object r13 = ListProtector.get(r19, r12);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r13), TextFieldImplKt.TrailingId) == true) goto L21;
        r12 = r12 + 1;
    L21:
        IntrinsicMeasurable r14 = (IntrinsicMeasurable) r13;
        if (r14 == null) goto L24;
        r9 = LayoutUtilKt.subtractConstraintSafely(r9, r14.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r15 = ((Number) r21.invoke(r14, Integer.valueOf(r20))).intValue();
    L25:
        int r4 = r2.size();
        int r16 = 0;
    L26:
        if (r16 >= r4) goto L31;
        Object r17 = ListProtector.get(r19, r16);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r17), TextFieldImplKt.LabelId) == true) goto L32;
        r16 = r16 + 1;
    L32:
        IntrinsicMeasurable r22 = (IntrinsicMeasurable) r17;
        if (r22 == null) goto L35;
        int r23 = ((Number) r21.invoke(r22, Integer.valueOf(r9))).intValue();
    L36:
        int r24 = r2.size();
        int r25 = 0;
    L37:
        if (r25 >= r24) goto L56;
        Object r26 = ListProtector.get(r19, r25);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r26), TextFieldImplKt.TextFieldId) == true) goto L40;
        r25 = r25 + 1;
        goto L37
    L40:
        int r27 = ((Number) r21.invoke(r26, Integer.valueOf(r9))).intValue();
        int r28 = r2.size();
        int r29 = 0;
    L41:
        if (r29 >= r28) goto L46;
        Object r30 = ListProtector.get(r19, r29);
        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) r30), TextFieldImplKt.PlaceholderId) == true) goto L44;
        r29 = r29 + 1;
        goto L41
    L44:
        r6 = r30;
    L46:
        IntrinsicMeasurable r31 = (IntrinsicMeasurable) r6;
        if (r31 == null) goto L49;
        int r110 = ((Number) r21.invoke(r31, Integer.valueOf(r9))).intValue();
    L50:
        if (r23 <= 0) goto L52;
        boolean r32 = true;
    L54:
        return TextFieldKt.m2227access$calculateHeightO3s9Psw(r27, r32, r23, r10, r15, r110, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), r18.getDensity(), this.paddingValues);
    L52:
        r32 = false;
        goto L54
    L49:
        r110 = 0;
        goto L50
    L56:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L35:
        r23 = 0;
        goto L36
    L31:
        r17 = null;
        goto L32
    L24:
        r15 = 0;
        goto L25
    L20:
        r13 = null;
        goto L21
    L13:
        r9 = r20;
        r10 = 0;
        goto L14
    L9:
        r7 = null;
        goto L10
    }

    private static final Unit measure_3p2s80s$lambda$6(Placeable r23, int r24, int r25, int r26, int r27, Placeable r28, Placeable r29, Placeable r30, Placeable r31, TextFieldMeasurePolicy r32, int r33, int r34, MeasureScope r35, Placeable.PlacementScope r36) {
        if (r23 == null) goto L5;
        int r9 = RangesKt.coerceAtLeast(r24 - r25, 0);
        TextFieldKt.access$placeWithLabel(r36, r26, r27, r28, r23, r29, r30, r31, r32.singleLine, r9, r33 + r34, r32.animationProgress, r35.getDensity());
    L7:
        return Unit.INSTANCE;
    L5:
        TextFieldKt.access$placeWithoutLabel(r36, r26, r27, r28, r29, r30, r31, r32.singleLine, r35.getDensity(), r32.paddingValues);
        goto L7
    }
}
