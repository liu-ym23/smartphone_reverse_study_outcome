package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.Alignment;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001a\u00020\u001eH\u0016J\"\u0010\"\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001a\u00020\u001eH\u0016J\"\u0010#\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001a\u00020\u001eH\u0016J\"\u0010%\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001a\u00020\u001eH\u0016J<\u0010&\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001a\u00020\u001e2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0(H\u0002J<\u0010)\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001a\u00020\u001e2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0(H\u0002J[\u0010*\u001a\u00020\u001e*\u00020+2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105Jk\u00106\u001a\u00020\u001e*\u00020+2\u0006\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010\n\u001a\u000203H\u0002¢\u0006\u0004\b@\u0010AJ\u009a\u0001\u0010B\u001a\u00020\u0005*\u00020C2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010H\u001a\u0004\u0018\u00010F2\b\u0010I\u001a\u0004\u0018\u00010F2\u0006\u0010J\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010F2\b\u0010L\u001a\u0004\u0018\u00010F2\u0006\u0010M\u001a\u00020F2\b\u0010N\u001a\u0004\u0018\u00010F2\u0006\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020Q2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010\n\u001a\u0002032\u0006\u0010R\u001a\u000203H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006S"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "horizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "calculateWidth", "Landroidx/compose/ui/unit/Density;", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "", "calculateWidth-IzADHW4", "(Landroidx/compose/ui/unit/Density;IIIIIIIJF)I", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "isLabelAbove", "calculateHeight-mKXJcVc", "(Landroidx/compose/ui/unit/Density;IIIIIIIIJZF)I", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "iconPadding", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float horizontalIconPadding;
    private final TextFieldLabelPosition labelPosition;
    private final FloatProducer labelProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public /* synthetic */ OutlinedTextFieldMeasurePolicy(Function1 r1, boolean r2, TextFieldLabelPosition r3, FloatProducer r4, PaddingValues r5, float r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ int a(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicWidth$lambda$15(r0, r1);
    }

    public static /* synthetic */ int b(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicHeight$lambda$13(r0, r1);
    }

    public static /* synthetic */ int c(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicHeight$lambda$12(r0, r1);
    }

    public static /* synthetic */ int d(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicWidth$lambda$14(r0, r1);
    }

    public static /* synthetic */ Unit e(OutlinedTextFieldMeasurePolicy r0, int r1, int r2, Placeable r3, Placeable r4, Placeable r5, Placeable r6, Placeable r7, Ref.ObjectRef r8, Placeable r9, Placeable r10, Placeable r11, MeasureScope r12, boolean r13, float r14, Placeable.PlacementScope r15) {
        return measure_3p2s80s$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    private static final int maxIntrinsicHeight$lambda$12(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicHeight(r1);
    }

    private static final int maxIntrinsicWidth$lambda$14(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicWidth(r1);
    }

    private static final int minIntrinsicHeight$lambda$13(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicHeight(r1);
    }

    private static final int minIntrinsicWidth$lambda$15(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicWidth(r1);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new ij());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicWidth(r2, r3, r4, new fj());
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2979measure3p2s80s(final MeasureScope r52, List<? extends Measurable> r53, long r54) {
        float r12 = this.labelProgress.invoke();
        int r0 = r52.roundToPx-0680j_4(this.paddingValues.mo898calculateBottomPaddingD9Ej5fM());
        long r9 = Constraints.copy-Zbe2FdA$default(r54, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r24 = r53;
        int r1 = r24.size();
        int r2 = 0;
    L3:
        Placeable r25 = null;
        if (r2 >= r1) goto L9;
        Object r3 = ListProtector.get(r53, r2);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r3), TextFieldImplKt.LeadingId) == true) goto L10;
        r2 = r2 + 1;
    L10:
        Measurable r4 = (Measurable) r3;
        if (r4 == null) goto L13;
        Placeable r26 = r4.measure-BRTryo0(r9);
    L14:
        int r5 = LayoutUtilKt.getWidthOrZero(r26) + 0;
        int r6 = Math.max(0, LayoutUtilKt.getHeightOrZero(r26));
        int r7 = r24.size();
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L20;
        Object r10 = ListProtector.get(r53, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r10), TextFieldImplKt.TrailingId) == true) goto L21;
        r8 = r8 + 1;
    L21:
        Measurable r11 = (Measurable) r10;
        if (r11 == null) goto L24;
        Placeable r27 = r11.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r9, -r5, 0, 2, null));
    L25:
        int r13 = r5 + LayoutUtilKt.getWidthOrZero(r27);
        int r14 = Math.max(r6, LayoutUtilKt.getHeightOrZero(r27));
        int r15 = r24.size();
        int r16 = 0;
    L26:
        if (r16 >= r15) goto L31;
        Object r17 = ListProtector.get(r53, r16);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r17), "Prefix") == true) goto L32;
        r16 = r16 + 1;
    L32:
        Measurable r18 = (Measurable) r17;
        if (r18 == null) goto L35;
        Placeable r28 = r18.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r9, -r13, 0, 2, null));
    L36:
        int r19 = r13 + LayoutUtilKt.getWidthOrZero(r28);
        int r20 = Math.max(r14, LayoutUtilKt.getHeightOrZero(r28));
        int r21 = r24.size();
        int r22 = 0;
    L37:
        if (r22 >= r21) goto L42;
        Object r23 = ListProtector.get(r53, r22);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r23), "Suffix") == true) goto L43;
        r22 = r22 + 1;
    L43:
        Measurable r29 = (Measurable) r23;
        if (r29 == null) goto L46;
        Placeable r210 = r29.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r9, -r19, 0, 2, null));
    L47:
        int r30 = r19 + LayoutUtilKt.getWidthOrZero(r210);
        int r31 = Math.max(r20, LayoutUtilKt.getHeightOrZero(r210));
        final boolean r32 = this.labelPosition instanceof TextFieldLabelPosition.Above;
        int r33 = r24.size();
        int r34 = 0;
    L48:
        if (r34 >= r33) goto L53;
        Object r35 = ListProtector.get(r53, r34);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r35), TextFieldImplKt.LabelId) == true) goto L54;
        r34 = r34 + 1;
    L54:
        Measurable r36 = (Measurable) r35;
        final Ref.ObjectRef r37 = new Ref.ObjectRef();
        if (r32 == true) goto L65;
        int r38 = r52.roundToPx-0680j_4(this.paddingValues.mo899calculateLeftPaddingu2uoSUM(r52.getLayoutDirection())) + r52.roundToPx-0680j_4(this.paddingValues.mo900calculateRightPaddingu2uoSUM(r52.getLayoutDirection()));
        long r39 = ConstraintsKt.offset-NN6Ew-U(r9, -MathHelpersKt.lerp(r30 + r38, r38, r12), -r0);
        if (r36 == null) goto L59;
        Placeable r40 = r36.measure-BRTryo0(r39);
    L60:
        r37.element = r40;
        if (r40 == null) goto L63;
        float r41 = r40.getWidth();
        float r42 = r40.getHeight();
        long r43 = Size.constructor-impl((Float.floatToRawIntBits(r41) << 32) | (Float.floatToRawIntBits(r42) & 4294967295L));
    L64:
        this.onLabelMeasured.invoke(Size.box-impl(r43));
        int r211 = 0;
    L70:
        int r44 = r24.size();
        int r45 = 0;
    L71:
        if (r45 >= r44) goto L76;
        Object r46 = ListProtector.get(r53, r45);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r46), "Supporting") == true) goto L77;
        r45 = r45 + 1;
    L77:
        Measurable r110 = (Measurable) r46;
        if (r110 == null) goto L80;
        int r47 = r110.minIntrinsicHeight(Constraints.getMinWidth-impl(r54));
    L81:
        if (r32 == false) goto L83;
        int r48 = r52.roundToPx-0680j_4(this.paddingValues.mo901calculateTopPaddingD9Ej5fM());
    L84:
        Measurable r111 = r36;
        long r49 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(r54, -r30, (((-r0) - r48) - r211) - r47), 0, 0, 0, 0, 11, null);
        int r50 = r24.size();
        int r51 = 0;
    L86:
        if (r51 >= r50) goto L136;
        Measurable r55 = (Measurable) ListProtector.get(r53, r51);
        int r112 = r50;
        long r113 = r9;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r55), TextFieldImplKt.TextFieldId) == true) goto L89;
        r51 = r51 + 1;
        r50 = r112;
        r9 = r113;
        r111 = r111;
        goto L86
    L89:
        final Placeable r310 = r55.measure-BRTryo0(r49);
        long r56 = Constraints.copy-Zbe2FdA$default(r49, 0, 0, 0, 0, 14, null);
        int r57 = r24.size();
        int r58 = 0;
    L90:
        if (r58 >= r57) goto L95;
        Object r59 = ListProtector.get(r53, r58);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r59), TextFieldImplKt.PlaceholderId) == true) goto L96;
        r58 = r58 + 1;
    L96:
        Measurable r60 = (Measurable) r59;
        if (r60 == null) goto L99;
        Placeable r311 = r60.measure-BRTryo0(r56);
    L100:
        int r61 = Math.max(r31, (Math.max(LayoutUtilKt.getHeightOrZero(r310), LayoutUtilKt.getHeightOrZero(r311)) + r48) + r0);
        Measurable r114 = r111;
        final int r115 = m2978calculateWidthIzADHW4(r52, LayoutUtilKt.getWidthOrZero(r26), LayoutUtilKt.getWidthOrZero(r27), LayoutUtilKt.getWidthOrZero(r28), LayoutUtilKt.getWidthOrZero(r210), r310.getWidth(), LayoutUtilKt.getWidthOrZero((Placeable) r37.element), LayoutUtilKt.getWidthOrZero(r311), r54, r12);
        if (r32 == false) goto L112;
        long r62 = Constraints.copy-Zbe2FdA$default(r113, 0, r115, 0, r211, 5, null);
        if (r114 == null) goto L105;
        Placeable r63 = r114.measure-BRTryo0(r62);
    L106:
        r37.element = r63;
        if (r63 == null) goto L109;
        float r64 = r63.getWidth();
        float r65 = r63.getHeight();
        long r66 = Size.constructor-impl((Float.floatToRawIntBits(r64) << 32) | (Float.floatToRawIntBits(r65) & 4294967295L));
    L110:
        this.onLabelMeasured.invoke(Size.box-impl(r66));
        goto L112
    L109:
        r66 = Size.Companion.getZero-NH-jbRc();
        goto L110
    L105:
        r63 = null;
    L112:
        long r67 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(r113, 0, -r61, 1, null), 0, r115, 0, 0, 9, null);
        if (r110 == null) goto L115;
        r25 = r110.measure-BRTryo0(r67);
    L115:
        int r116 = LayoutUtilKt.getHeightOrZero(r25);
        final float r117 = r12;
        final int r118 = m2977calculateHeightmKXJcVc(r52, LayoutUtilKt.getHeightOrZero(r26), LayoutUtilKt.getHeightOrZero(r27), LayoutUtilKt.getHeightOrZero(r28), LayoutUtilKt.getHeightOrZero(r210), r310.getHeight(), LayoutUtilKt.getHeightOrZero((Placeable) r37.element), LayoutUtilKt.getHeightOrZero(r311), LayoutUtilKt.getHeightOrZero(r25), r54, r32, r117);
        int r68 = r118 - r116;
        if (r32 == false) goto L118;
        int r119 = LayoutUtilKt.getHeightOrZero((Placeable) r37.element);
    L119:
        int r120 = r68 - r119;
        int r69 = r24.size();
        int r70 = 0;
    L120:
        if (r70 >= r69) goto L133;
        Measurable r71 = (Measurable) ListProtector.get(r53, r70);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r71), "Container") == true) goto L124;
        r70 = r70 + 1;
        goto L120
    L124:
        if (r115 == Integer.MAX_VALUE) goto L126;
        int r72 = r115;
    L127:
        if (r120 == Integer.MAX_VALUE) goto L129;
        int r73 = r120;
    L130:
        final Placeable r121 = r71.measure-BRTryo0(ConstraintsKt.Constraints(r72, r115, r73, r120));
        final Placeable r74 = r26;
        final Placeable r75 = r27;
        final Placeable r76 = r28;
        final Placeable r77 = r210;
        final Placeable r122 = r311;
        final Placeable r123 = r25;
        return MeasureScope.-CC.layout$default(r52, r115, r118, null, new hj(this, r118, r115, r74, r75, r76, r77, r310, r37, r122, r121, r123, r52, r32, r117), 4, null);
    L129:
        r73 = 0;
        goto L130
    L126:
        r72 = 0;
        goto L127
    L133:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L118:
        r119 = 0;
        goto L119
    L99:
        r311 = null;
        goto L100
    L95:
        r59 = null;
        goto L96
    L136:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L83:
        r48 = Math.max(LayoutUtilKt.getHeightOrZero((Placeable) r37.element) / 2, r52.roundToPx-0680j_4(this.paddingValues.mo901calculateTopPaddingD9Ej5fM()));
        goto L84
    L80:
        r47 = 0;
        goto L81
    L76:
        r46 = null;
        goto L77
    L63:
        r43 = Size.Companion.getZero-NH-jbRc();
        goto L64
    L59:
        r40 = null;
        goto L60
    L65:
        r12 = r12;
        if (r36 == null) goto L68;
        int r78 = r36.minIntrinsicHeight(Constraints.getMinWidth-impl(r54));
    L69:
        r211 = r78;
        goto L70
    L68:
        r78 = 0;
        goto L69
    L53:
        r35 = null;
        goto L54
    L46:
        r210 = null;
        goto L47
    L42:
        r23 = null;
        goto L43
    L35:
        r28 = null;
        goto L36
    L31:
        r17 = null;
        goto L32
    L24:
        r27 = null;
        goto L25
    L20:
        r10 = null;
        goto L21
    L13:
        r26 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new gj());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicWidth(r2, r3, r4, new jj());
    }

    private final int intrinsicHeight(IntrinsicMeasureScope r25, List<? extends IntrinsicMeasurable> r26, int r27, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r28) {
        float r13 = this.labelProgress.invoke();
        List<? extends IntrinsicMeasurable> r3 = r26;
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L8;
        Object r8 = ListProtector.get(r26, r6);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r8), TextFieldImplKt.LeadingId) == true) goto L9;
        r6 = r6 + 1;
    L9:
        IntrinsicMeasurable r9 = (IntrinsicMeasurable) r8;
        if (r9 == null) goto L12;
        int r7 = LayoutUtilKt.subtractConstraintSafely(r27, r9.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r10 = ((Number) r28.invoke(r9, Integer.valueOf(r27))).intValue();
    L13:
        int r11 = r3.size();
        int r12 = 0;
    L14:
        if (r12 >= r11) goto L19;
        Object r14 = ListProtector.get(r26, r12);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r14), TextFieldImplKt.TrailingId) == true) goto L20;
        r12 = r12 + 1;
    L20:
        IntrinsicMeasurable r15 = (IntrinsicMeasurable) r14;
        if (r15 == null) goto L23;
        r7 = LayoutUtilKt.subtractConstraintSafely(r7, r15.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r16 = ((Number) r28.invoke(r15, Integer.valueOf(r27))).intValue();
    L24:
        int r17 = r3.size();
        int r18 = 0;
    L25:
        if (r18 >= r17) goto L30;
        Object r19 = ListProtector.get(r26, r18);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r19), TextFieldImplKt.LabelId) == true) goto L31;
        r18 = r18 + 1;
    L31:
        IntrinsicMeasurable r110 = (IntrinsicMeasurable) r19;
        if (r110 == null) goto L34;
        int r111 = ((Number) r28.invoke(r110, Integer.valueOf(MathHelpersKt.lerp(r7, r27, r13)))).intValue();
    L35:
        int r5 = r3.size();
        int r112 = 0;
    L36:
        if (r112 >= r5) goto L41;
        Object r113 = ListProtector.get(r26, r112);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r113), "Prefix") == true) goto L42;
        r112 = r112 + 1;
    L42:
        IntrinsicMeasurable r114 = (IntrinsicMeasurable) r113;
        if (r114 == null) goto L45;
        int r20 = ((Number) r28.invoke(r114, Integer.valueOf(r7))).intValue();
        r7 = LayoutUtilKt.subtractConstraintSafely(r7, r114.maxIntrinsicWidth(Integer.MAX_VALUE));
    L46:
        int r21 = r3.size();
        int r115 = 0;
    L47:
        if (r115 >= r21) goto L52;
        Object r116 = ListProtector.get(r26, r115);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r116), "Suffix") == true) goto L53;
        r115 = r115 + 1;
    L53:
        IntrinsicMeasurable r117 = (IntrinsicMeasurable) r116;
        if (r117 == null) goto L56;
        int r22 = ((Number) r28.invoke(r117, Integer.valueOf(r7))).intValue();
        int r23 = LayoutUtilKt.subtractConstraintSafely(r7, r117.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r24 = r22;
        int r29 = r23;
    L57:
        int r30 = r3.size();
        int r118 = 0;
    L58:
        if (r118 >= r30) goto L86;
        Object r119 = ListProtector.get(r26, r118);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r119), TextFieldImplKt.TextFieldId) == true) goto L61;
        r118 = r118 + 1;
        goto L58
    L61:
        int r31 = ((Number) r28.invoke(r119, Integer.valueOf(r29))).intValue();
        int r1 = r3.size();
        int r120 = 0;
    L62:
        if (r120 >= r1) goto L67;
        Object r121 = ListProtector.get(r26, r120);
        int r122 = r1;
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r121), TextFieldImplKt.PlaceholderId) == true) goto L68;
        r120 = r120 + 1;
        r1 = r122;
    L68:
        IntrinsicMeasurable r123 = (IntrinsicMeasurable) r121;
        if (r123 == null) goto L71;
        int r124 = ((Number) r28.invoke(r123, Integer.valueOf(r29))).intValue();
    L72:
        int r2 = r3.size();
        int r32 = 0;
    L73:
        if (r32 >= r2) goto L78;
        Object r33 = ListProtector.get(r26, r32);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r33), "Supporting") == true) goto L76;
        r32 = r32 + 1;
        goto L73
    L76:
        Object r125 = r33;
    L79:
        IntrinsicMeasurable r0 = (IntrinsicMeasurable) r125;
        if (r0 == null) goto L82;
        int r126 = ((Number) r28.invoke(r0, Integer.valueOf(r27))).intValue();
    L83:
        int r34 = r10;
        int r35 = r16;
        int r36 = r20;
        int r37 = r24;
        int r38 = r111;
        int r39 = r124;
        int r40 = r126;
        return m2977calculateHeightmKXJcVc(r25, r34, r35, r36, r37, r31, r38, r39, r40, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.labelPosition instanceof TextFieldLabelPosition.Above, r13);
    L82:
        r126 = 0;
        goto L83
    L78:
        r125 = null;
        goto L79
    L71:
        r124 = 0;
        goto L72
    L67:
        r121 = null;
        goto L68
    L86:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L56:
        r29 = r7;
        r24 = 0;
        goto L57
    L52:
        r116 = null;
        goto L53
    L45:
        r20 = 0;
        goto L46
    L41:
        r113 = null;
        goto L42
    L34:
        r111 = 0;
        goto L35
    L30:
        r19 = null;
        goto L31
    L23:
        r16 = 0;
        goto L24
    L19:
        r14 = null;
        goto L20
    L12:
        r7 = r27;
        r10 = 0;
        goto L13
    L8:
        r8 = null;
        goto L9
    }

    private final int intrinsicWidth(IntrinsicMeasureScope r18, List<? extends IntrinsicMeasurable> r19, int r20, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r21) {
        List<? extends IntrinsicMeasurable> r2 = r19;
        int r3 = r2.size();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L75;
        Object r6 = ListProtector.get(r19, r5);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r6), TextFieldImplKt.TextFieldId) == true) goto L6;
        r5 = r5 + 1;
        goto L3
    L6:
        int r11 = ((Number) r21.invoke(r6, Integer.valueOf(r20))).intValue();
        int r4 = r2.size();
        int r7 = 0;
    L7:
        Object r8 = null;
        if (r7 >= r4) goto L13;
        Object r9 = ListProtector.get(r19, r7);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r9), TextFieldImplKt.LabelId) == true) goto L14;
        r7 = r7 + 1;
    L14:
        IntrinsicMeasurable r10 = (IntrinsicMeasurable) r9;
        if (r10 == null) goto L17;
        int r12 = ((Number) r21.invoke(r10, Integer.valueOf(r20))).intValue();
    L18:
        int r13 = r2.size();
        int r14 = 0;
    L19:
        if (r14 >= r13) goto L24;
        Object r15 = ListProtector.get(r19, r14);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r15), TextFieldImplKt.TrailingId) == true) goto L25;
        r14 = r14 + 1;
    L25:
        IntrinsicMeasurable r16 = (IntrinsicMeasurable) r15;
        if (r16 == null) goto L28;
        int r17 = ((Number) r21.invoke(r16, Integer.valueOf(r20))).intValue();
    L29:
        int r22 = r2.size();
        int r23 = 0;
    L30:
        if (r23 >= r22) goto L35;
        Object r24 = ListProtector.get(r19, r23);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r24), TextFieldImplKt.LeadingId) == true) goto L36;
        r23 = r23 + 1;
    L36:
        IntrinsicMeasurable r25 = (IntrinsicMeasurable) r24;
        if (r25 == null) goto L39;
        int r26 = ((Number) r21.invoke(r25, Integer.valueOf(r20))).intValue();
    L40:
        int r27 = r2.size();
        int r28 = 0;
    L41:
        if (r28 >= r27) goto L46;
        Object r29 = ListProtector.get(r19, r28);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r29), "Prefix") == true) goto L47;
        r28 = r28 + 1;
    L47:
        IntrinsicMeasurable r30 = (IntrinsicMeasurable) r29;
        if (r30 == null) goto L50;
        int r31 = ((Number) r21.invoke(r30, Integer.valueOf(r20))).intValue();
    L51:
        int r32 = r2.size();
        int r33 = 0;
    L52:
        if (r33 >= r32) goto L57;
        Object r110 = ListProtector.get(r19, r33);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r110), "Suffix") == true) goto L58;
        r33 = r33 + 1;
    L58:
        IntrinsicMeasurable r111 = (IntrinsicMeasurable) r110;
        if (r111 == null) goto L61;
        int r112 = ((Number) r21.invoke(r111, Integer.valueOf(r20))).intValue();
    L62:
        int r34 = r2.size();
        int r35 = 0;
    L63:
        if (r35 >= r34) goto L68;
        Object r36 = ListProtector.get(r19, r35);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r36), TextFieldImplKt.PlaceholderId) == true) goto L66;
        r35 = r35 + 1;
        goto L63
    L66:
        r8 = r36;
    L68:
        IntrinsicMeasurable r37 = (IntrinsicMeasurable) r8;
        if (r37 == null) goto L71;
        int r113 = ((Number) r21.invoke(r37, Integer.valueOf(r20))).intValue();
    L73:
        return m2978calculateWidthIzADHW4(r18, r26, r17, r31, r112, r11, r12, r113, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.labelProgress.invoke());
    L71:
        r113 = 0;
        goto L73
    L61:
        r112 = 0;
        goto L62
    L57:
        r110 = null;
        goto L58
    L50:
        r31 = 0;
        goto L51
    L46:
        r29 = null;
        goto L47
    L39:
        r26 = 0;
        goto L40
    L35:
        r24 = null;
        goto L36
    L28:
        r17 = 0;
        goto L29
    L24:
        r15 = null;
        goto L25
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = null;
        goto L14
    L75:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> r1, boolean r2, TextFieldLabelPosition r3, FloatProducer r4, PaddingValues r5, float r6) {
        this.onLabelMeasured = r1;
        this.singleLine = r2;
        this.labelPosition = r3;
        this.labelProgress = r4;
        this.paddingValues = r5;
        this.horizontalIconPadding = r6;
    }

    private static final int place$calculateVerticalPosition(int r1, OutlinedTextFieldMeasurePolicy r2, int r3, int r4, Placeable r5, Placeable r6) {
        if (r2.singleLine == false) goto L5;
        r4 = Alignment.Companion.getCenterVertically().align(r6.getHeight(), r3);
    L5:
        int r7 = r1 + r4;
        if ((r2.labelPosition instanceof TextFieldLabelPosition.Above) == false) goto L9;
        return r7;
    L9:
        return Math.max(r7, LayoutUtilKt.getHeightOrZero(r5) / 2);
    }

    /* JADX INFO: renamed from: calculateWidth-IzADHW4, reason: not valid java name */
    private final int m2978calculateWidthIzADHW4(Density r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9, float r11) {
        int r10 = r4 + r5;
        int r12 = (r2 + Math.max(r6 + r10, Math.max(r8 + r10, MathHelpersKt.lerp(r7, 0, r11)))) + r3;
        PaddingValues r13 = this.paddingValues;
        LayoutDirection r14 = LayoutDirection.Ltr;
        return ConstraintsKt.constrainWidth-K40F9xA(r9, Math.max(r12, MathKt.roundToInt((r7 + r1.toPx-0680j_4(Dp.constructor-impl(r13.mo899calculateLeftPaddingu2uoSUM(r14) + this.paddingValues.mo900calculateRightPaddingu2uoSUM(r14)))) * r11)));
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    private final int m2977calculateHeightmKXJcVc(Density r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, long r12, boolean r14, float r15) {
        int[] r0 = new int[4];
        r0[0] = r10;
        r0[1] = r6;
        r0[2] = r7;
        if (r14 == false) goto L5;
        int r13 = 0;
    L6:
        r0[3] = r13;
        int r16 = ComparisonsKt.maxOf(r8, r0);
        float r17 = r3.toPx-0680j_4(this.paddingValues.mo901calculateTopPaddingD9Ej5fM());
        if (r14 == true) goto L10;
        r17 = MathHelpersKt.lerp(r17, Math.max(r17, r9 / 2.0f), r15);
    L10:
        float r18 = (r17 + r16) + r3.toPx-0680j_4(this.paddingValues.mo898calculateBottomPaddingD9Ej5fM());
        if (r14 == true) goto L15;
        r9 = 0;
    L15:
        return ConstraintsKt.constrainHeight-K40F9xA(r12, (r9 + Math.max(r4, Math.max(r5, MathKt.roundToInt(r18)))) + r11);
    L5:
        r13 = MathHelpersKt.lerp(r9, 0, r15);
        goto L6
    }

    private static final Unit measure_3p2s80s$lambda$11(OutlinedTextFieldMeasurePolicy r19, int r20, int r21, Placeable r22, Placeable r23, Placeable r24, Placeable r25, Placeable r26, Ref.ObjectRef r27, Placeable r28, Placeable r29, Placeable r30, MeasureScope r31, boolean r32, float r33, Placeable.PlacementScope r34) {
        r19.place(r34, r20, r21, r22, r23, r24, r25, r26, (Placeable) r27.element, r28, r29, r30, r31.getDensity(), r31.getLayoutDirection(), r32, r33, r31.toPx-0680j_4(r19.horizontalIconPadding));
        return Unit.INSTANCE;
    }

    private final void place(Placeable.PlacementScope r25, int r26, int r27, Placeable r28, Placeable r29, Placeable r30, Placeable r31, Placeable r32, Placeable r33, Placeable r34, Placeable r35, Placeable r36, float r37, LayoutDirection r38, boolean r39, float r40, float r41) {
        int r2 = 0;
        if (r39 == false) goto L5;
        int r15 = LayoutUtilKt.getHeightOrZero(r33);
    L6:
        Placeable.PlacementScope.place$default(r25, r35, 0, r15, MenuKt.ClosedAlphaTarget, 4, null);
        int r3 = r26 - LayoutUtilKt.getHeightOrZero(r36);
        if (r39 == false) goto L9;
        int r4 = LayoutUtilKt.getHeightOrZero(r33);
    L10:
        int r5 = r3 - r4;
        int r16 = MathKt.roundToInt(this.paddingValues.mo901calculateTopPaddingD9Ej5fM() * r37);
        if (r28 == null) goto L13;
        Placeable.PlacementScope.placeRelative$default(r25, r28, 0, r15 + Alignment.Companion.getCenterVertically().align(r28.getHeight(), r5), MenuKt.ClosedAlphaTarget, 4, null);
    L13:
        if (r33 == null) goto L41;
        if (r39 == false) goto L17;
        int r6 = 0;
    L20:
        if (r39 == true) goto L23;
        r2 = -(r33.getHeight() / 2);
    L23:
        int r20 = MathHelpersKt.lerp(r6, r2, r40);
        if (r39 == false) goto L26;
        Placeable.PlacementScope.place$default(r25, r33, androidx.compose.material3.internal.TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(r33.getWidth(), r27, r38), r20, MenuKt.ClosedAlphaTarget, 4, null);
        goto L41
    L26:
        float r7 = PaddingKt.calculateStartPadding(this.paddingValues, r38) * r37;
        float r8 = PaddingKt.calculateEndPadding(this.paddingValues, r38) * r37;
        if (r28 != null) goto L29;
        float r9 = r7;
    L30:
        if (r29 != null) goto L32;
        float r10 = r8;
    L33:
        LayoutDirection r11 = LayoutDirection.Ltr;
        if (r38 != r11) goto L36;
        float r12 = r7;
    L37:
        if (r38 != r11) goto L39;
        float r13 = r9;
    L40:
        Placeable.PlacementScope.place$default(r25, r33, MathKt.roundToInt(MathHelpersKt.lerp(androidx.compose.material3.internal.TextFieldImplKt.getExpandedAlignment(this.labelPosition).align(r33.getWidth(), r27 - MathKt.roundToInt(r9 + r10), r38) + r13, androidx.compose.material3.internal.TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(r33.getWidth(), r27 - MathKt.roundToInt(r7 + r8), r38) + r12, r40)), r20, MenuKt.ClosedAlphaTarget, 4, null);
        goto L41
    L39:
        r13 = r10;
        goto L40
    L36:
        r12 = r8;
        goto L37
    L32:
        r10 = r29.getWidth() + RangesKt.coerceAtLeast(r8 - r41, MenuKt.ClosedAlphaTarget);
        goto L33
    L29:
        r9 = r28.getWidth() + RangesKt.coerceAtLeast(r7 - r41, MenuKt.ClosedAlphaTarget);
        goto L30
    L17:
        if (this.singleLine == false) goto L19;
        r6 = Alignment.Companion.getCenterVertically().align(r33.getHeight(), r5);
        goto L20
    L19:
        r6 = r16;
    L41:
        if (r30 == null) goto L43;
        int r14 = LayoutUtilKt.getWidthOrZero(r28);
        int r17 = place$calculateVerticalPosition(r15, this, r5, r16, r33, r30);
        r5 = r5;
        Placeable.PlacementScope.placeRelative$default(r25, r30, r14, r17, MenuKt.ClosedAlphaTarget, 4, null);
    L43:
        int r18 = LayoutUtilKt.getWidthOrZero(r28) + LayoutUtilKt.getWidthOrZero(r30);
        int r19 = place$calculateVerticalPosition(r15, this, r5, r16, r33, r32);
        int r21 = r5;
        Placeable.PlacementScope.placeRelative$default(r25, r32, r18, r19, MenuKt.ClosedAlphaTarget, 4, null);
        if (r34 == null) goto L46;
        int r110 = place$calculateVerticalPosition(r15, this, r21, r16, r33, r34);
        r21 = r21;
        Placeable.PlacementScope.placeRelative$default(r25, r34, r18, r110, MenuKt.ClosedAlphaTarget, 4, null);
    L46:
        if (r31 == null) goto L49;
        Placeable.PlacementScope.placeRelative$default(r25, r31, (r27 - LayoutUtilKt.getWidthOrZero(r29)) - r31.getWidth(), place$calculateVerticalPosition(r15, this, r21, r16, r33, r31), MenuKt.ClosedAlphaTarget, 4, null);
    L49:
        if (r29 == null) goto L51;
        Placeable.PlacementScope.placeRelative$default(r25, r29, r27 - r29.getWidth(), r15 + Alignment.Companion.getCenterVertically().align(r29.getHeight(), r21), MenuKt.ClosedAlphaTarget, 4, null);
    L51:
        if (r36 == null) goto L54;
        Placeable.PlacementScope.placeRelative$default(r25, r36, 0, r15 + r21, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L54:
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r15 = 0;
        goto L6
    }
}
