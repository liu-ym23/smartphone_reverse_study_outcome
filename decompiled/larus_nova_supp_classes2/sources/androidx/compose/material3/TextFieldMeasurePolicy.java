package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.ui.Alignment;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\"\u0010\u001e\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\"\u0010\u001f\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010 \u001a\u00020\u001aH\u0016J\"\u0010!\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010 \u001a\u00020\u001aH\u0016J8\u0010\"\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010 \u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0$H\u0002J<\u0010%\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u001d\u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0$H\u0002JO\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010/Jk\u00100\u001a\u00020\u001a*\u0002012\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020;H\u0002¢\u0006\u0004\b<\u0010=J \u0001\u0010>\u001a\u00020?*\u00020@2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010C2\b\u0010G\u001a\u0004\u0018\u00010C2\b\u0010H\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010C2\u0006\u0010J\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010C2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020;2\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020PH\u0002Jp\u0010Q\u001a\u00020?*\u00020@2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010C2\b\u0010G\u001a\u0004\u0018\u00010C2\b\u0010H\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010C2\u0006\u0010J\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010C2\u0006\u0010S\u001a\u00020;H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006T"}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "minimizedLabelHalfHeight", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "calculateHeight", "Landroidx/compose/ui/unit/Density;", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelAbove", "", "calculateHeight-mKXJcVc", "(Landroidx/compose/ui/unit/Density;IIIIIIIIJZF)I", "placeWithLabel", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelStartY", "labelEndY", "textPosition", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeWithoutLabel", "textPlaceable", "density", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final TextFieldLabelPosition labelPosition;
    private final FloatProducer labelProgress;
    private final float minimizedLabelHalfHeight;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public /* synthetic */ TextFieldMeasurePolicy(boolean r1, TextFieldLabelPosition r2, FloatProducer r3, PaddingValues r4, float r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ int a(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicHeight$lambda$10(r0, r1);
    }

    public static /* synthetic */ int b(IntrinsicMeasurable r0, int r1) {
        return maxIntrinsicWidth$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit c(Ref.ObjectRef r1, boolean r2, TextFieldMeasurePolicy r3, int r4, int r5, MeasureScope r6, int r7, int r8, Placeable r9, Placeable r10, Placeable r11, Placeable r12, Placeable r13, Placeable r14, Placeable r15, Placeable r16, float r17, Placeable.PlacementScope r18) {
        return measure_3p2s80s$lambda$9(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ int d(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicWidth$lambda$13(r0, r1);
    }

    public static /* synthetic */ int e(IntrinsicMeasurable r0, int r1) {
        return minIntrinsicHeight$lambda$11(r0, r1);
    }

    private static final int maxIntrinsicHeight$lambda$10(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicHeight(r1);
    }

    private static final int maxIntrinsicWidth$lambda$12(IntrinsicMeasurable r0, int r1) {
        return r0.maxIntrinsicWidth(r1);
    }

    private static final int minIntrinsicHeight$lambda$11(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicHeight(r1);
    }

    private static final int minIntrinsicWidth$lambda$13(IntrinsicMeasurable r0, int r1) {
        return r0.minIntrinsicWidth(r1);
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> r20, int r21, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r22) {
        List<? extends IntrinsicMeasurable> r2 = r20;
        int r3 = r2.size();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L75;
        Object r6 = ListProtector.get(r20, r5);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r6), TextFieldImplKt.TextFieldId) == true) goto L6;
        r5 = r5 + 1;
        goto L3
    L6:
        int r10 = ((Number) r22.invoke(r6, Integer.valueOf(r21))).intValue();
        int r4 = r2.size();
        int r7 = 0;
    L7:
        Object r8 = null;
        if (r7 >= r4) goto L13;
        Object r9 = ListProtector.get(r20, r7);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r9), TextFieldImplKt.LabelId) == true) goto L14;
        r7 = r7 + 1;
    L14:
        IntrinsicMeasurable r11 = (IntrinsicMeasurable) r9;
        if (r11 == null) goto L17;
        int r12 = ((Number) r22.invoke(r11, Integer.valueOf(r21))).intValue();
    L18:
        int r13 = r2.size();
        int r14 = 0;
    L19:
        if (r14 >= r13) goto L24;
        Object r15 = ListProtector.get(r20, r14);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r15), TextFieldImplKt.TrailingId) == true) goto L25;
        r14 = r14 + 1;
    L25:
        IntrinsicMeasurable r16 = (IntrinsicMeasurable) r15;
        if (r16 == null) goto L28;
        int r17 = ((Number) r22.invoke(r16, Integer.valueOf(r21))).intValue();
    L29:
        int r18 = r2.size();
        int r19 = 0;
    L30:
        if (r19 >= r18) goto L35;
        Object r23 = ListProtector.get(r20, r19);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r23), "Prefix") == true) goto L36;
        r19 = r19 + 1;
    L36:
        IntrinsicMeasurable r24 = (IntrinsicMeasurable) r23;
        if (r24 == null) goto L39;
        int r25 = ((Number) r22.invoke(r24, Integer.valueOf(r21))).intValue();
    L40:
        int r26 = r2.size();
        int r27 = 0;
    L41:
        if (r27 >= r26) goto L46;
        Object r28 = ListProtector.get(r20, r27);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r28), "Suffix") == true) goto L47;
        r27 = r27 + 1;
    L47:
        IntrinsicMeasurable r29 = (IntrinsicMeasurable) r28;
        if (r29 == null) goto L50;
        int r30 = ((Number) r22.invoke(r29, Integer.valueOf(r21))).intValue();
    L51:
        int r31 = r2.size();
        int r32 = 0;
    L52:
        if (r32 >= r31) goto L57;
        Object r110 = ListProtector.get(r20, r32);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r110), TextFieldImplKt.LeadingId) == true) goto L58;
        r32 = r32 + 1;
    L58:
        IntrinsicMeasurable r111 = (IntrinsicMeasurable) r110;
        if (r111 == null) goto L61;
        int r33 = ((Number) r22.invoke(r111, Integer.valueOf(r21))).intValue();
    L62:
        int r34 = r2.size();
        int r35 = 0;
    L63:
        if (r35 >= r34) goto L68;
        Object r112 = ListProtector.get(r20, r35);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r112), TextFieldImplKt.PlaceholderId) == true) goto L66;
        r35 = r35 + 1;
        goto L63
    L66:
        r8 = r112;
    L68:
        IntrinsicMeasurable r36 = (IntrinsicMeasurable) r8;
        if (r36 == null) goto L71;
        int r113 = ((Number) r22.invoke(r36, Integer.valueOf(r21))).intValue();
    L73:
        return m3358calculateWidthyeHjK3Y(r33, r17, r25, r30, r10, r12, r113, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    L71:
        r113 = 0;
        goto L73
    L61:
        r33 = 0;
        goto L62
    L57:
        r110 = null;
        goto L58
    L50:
        r30 = 0;
        goto L51
    L46:
        r28 = null;
        goto L47
    L39:
        r25 = 0;
        goto L40
    L35:
        r23 = null;
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

    public int maxIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new tt());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, List<? extends IntrinsicMeasurable> r2, int r3) {
        return intrinsicWidth(r2, r3, new st());
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3359measure3p2s80s(final MeasureScope r52, List<? extends Measurable> r53, long r54) {
        List<? extends Measurable> r13 = r53;
        final float r17 = this.labelProgress.invoke();
        final int r16 = r52.roundToPx-0680j_4(this.paddingValues.mo901calculateTopPaddingD9Ej5fM());
        int r0 = r52.roundToPx-0680j_4(this.paddingValues.mo898calculateBottomPaddingD9Ej5fM());
        long r10 = Constraints.copy-Zbe2FdA$default(r54, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> r26 = r13;
        int r1 = r26.size();
        int r2 = 0;
    L3:
        Placeable r27 = null;
        if (r2 >= r1) goto L9;
        Object r3 = ListProtector.get(r13, r2);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r3), TextFieldImplKt.LeadingId) == true) goto L10;
        r2 = r2 + 1;
    L10:
        Measurable r4 = (Measurable) r3;
        if (r4 == null) goto L13;
        Placeable r28 = r4.measure-BRTryo0(r10);
    L14:
        int r5 = LayoutUtilKt.getWidthOrZero(r28) + 0;
        int r6 = Math.max(0, LayoutUtilKt.getHeightOrZero(r28));
        int r7 = r26.size();
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L20;
        Object r9 = ListProtector.get(r13, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r9), TextFieldImplKt.TrailingId) == true) goto L21;
        r8 = r8 + 1;
    L21:
        Measurable r11 = (Measurable) r9;
        if (r11 == null) goto L24;
        Placeable r29 = r11.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r10, -r5, 0, 2, null));
    L25:
        int r12 = r5 + LayoutUtilKt.getWidthOrZero(r29);
        int r14 = Math.max(r6, LayoutUtilKt.getHeightOrZero(r29));
        int r15 = r26.size();
        int r18 = 0;
    L26:
        if (r18 >= r15) goto L31;
        Object r19 = ListProtector.get(r13, r18);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r19), "Prefix") == true) goto L32;
        r18 = r18 + 1;
    L32:
        Measurable r20 = (Measurable) r19;
        if (r20 == null) goto L35;
        Placeable r30 = r20.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r10, -r12, 0, 2, null));
    L36:
        int r21 = r12 + LayoutUtilKt.getWidthOrZero(r30);
        int r22 = Math.max(r14, LayoutUtilKt.getHeightOrZero(r30));
        int r23 = r26.size();
        int r24 = 0;
    L37:
        if (r24 >= r23) goto L42;
        Object r25 = ListProtector.get(r13, r24);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r25), "Suffix") == true) goto L43;
        r24 = r24 + 1;
    L43:
        Measurable r31 = (Measurable) r25;
        if (r31 == null) goto L46;
        Placeable r32 = r31.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r10, -r21, 0, 2, null));
    L47:
        int r33 = r21 + LayoutUtilKt.getWidthOrZero(r32);
        int r34 = Math.max(r22, LayoutUtilKt.getHeightOrZero(r32));
        boolean r35 = this.labelPosition instanceof TextFieldLabelPosition.Above;
        int r36 = r26.size();
        int r37 = 0;
    L48:
        if (r37 >= r36) goto L53;
        Object r38 = ListProtector.get(r13, r37);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r38), TextFieldImplKt.LabelId) == true) goto L54;
        r37 = r37 + 1;
    L54:
        Measurable r39 = (Measurable) r38;
        final Ref.ObjectRef r40 = new Ref.ObjectRef();
        if (r35 == true) goto L61;
        long r41 = ConstraintsKt.offset-NN6Ew-U(r10, -r33, -r0);
        if (r39 == null) goto L59;
        Placeable r42 = r39.measure-BRTryo0(r41);
    L60:
        r40.element = r42;
        int r210 = 0;
    L65:
        int r43 = r26.size();
        int r44 = 0;
    L66:
        if (r44 >= r43) goto L71;
        Object r45 = ListProtector.get(r13, r44);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r45), "Supporting") == true) goto L72;
        r44 = r44 + 1;
    L72:
        Measurable r110 = (Measurable) r45;
        if (r110 == null) goto L75;
        int r46 = r110.minIntrinsicHeight(Constraints.getMinWidth-impl(r54));
    L76:
        int r47 = r16 + (LayoutUtilKt.getHeightOrZero((Placeable) r40.element) + r210);
        boolean r111 = r35;
        long r48 = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(r54, 0, 0, 0, 0, 11, null), -r33, ((-r47) - r0) - r46);
        int r49 = r26.size();
        int r50 = 0;
    L78:
        if (r50 >= r49) goto L123;
        Measurable r51 = (Measurable) ListProtector.get(r13, r50);
        int r112 = r49;
        Measurable r211 = r39;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r51), TextFieldImplKt.TextFieldId) == true) goto L81;
        r50 = r50 + 1;
        r39 = r211;
        r111 = r111;
        r13 = r13;
        r49 = r112;
        goto L78
    L81:
        final Placeable r410 = r51.measure-BRTryo0(r48);
        long r55 = Constraints.copy-Zbe2FdA$default(r48, 0, 0, 0, 0, 14, null);
        int r56 = r26.size();
        int r57 = 0;
    L82:
        if (r57 >= r56) goto L87;
        Object r58 = ListProtector.get(r13, r57);
        int r113 = r56;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r58), TextFieldImplKt.PlaceholderId) == true) goto L88;
        r57 = r57 + 1;
        r56 = r113;
    L88:
        Measurable r59 = (Measurable) r58;
        if (r59 == null) goto L91;
        Placeable r310 = r59.measure-BRTryo0(r55);
    L92:
        int r60 = Math.max(r34, (Math.max(LayoutUtilKt.getHeightOrZero(r410), LayoutUtilKt.getHeightOrZero(r310)) + r47) + r0);
        final boolean r311 = r111;
        final int r61 = m3358calculateWidthyeHjK3Y(LayoutUtilKt.getWidthOrZero(r28), LayoutUtilKt.getWidthOrZero(r29), LayoutUtilKt.getWidthOrZero(r30), LayoutUtilKt.getWidthOrZero(r32), r410.getWidth(), LayoutUtilKt.getWidthOrZero((Placeable) r40.element), LayoutUtilKt.getWidthOrZero(r310), r54);
        if (r311 == false) goto L99;
        long r62 = Constraints.copy-Zbe2FdA$default(r10, 0, r61, 0, r210, 5, null);
        if (r211 == null) goto L97;
        Placeable r63 = r211.measure-BRTryo0(r62);
    L98:
        r40.element = r63;
        goto L99
    L97:
        r63 = null;
    L99:
        long r64 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(r10, 0, -r60, 1, null), 0, r61, 0, 0, 9, null);
        if (r110 == null) goto L102;
        r27 = r110.measure-BRTryo0(r64);
    L102:
        int r114 = LayoutUtilKt.getHeightOrZero(r27);
        final int r115 = m3357calculateHeightmKXJcVc(r52, r410.getHeight(), LayoutUtilKt.getHeightOrZero((Placeable) r40.element), LayoutUtilKt.getHeightOrZero(r28), LayoutUtilKt.getHeightOrZero(r29), LayoutUtilKt.getHeightOrZero(r30), LayoutUtilKt.getHeightOrZero(r32), LayoutUtilKt.getHeightOrZero(r310), LayoutUtilKt.getHeightOrZero(r27), r54, r311, r17);
        int r65 = r115 - r114;
        if (r311 == false) goto L105;
        int r116 = LayoutUtilKt.getHeightOrZero((Placeable) r40.element);
    L106:
        final int r66 = r65 - r116;
        int r67 = r26.size();
        int r117 = 0;
    L107:
        if (r117 >= r67) goto L120;
        Measurable r68 = (Measurable) ListProtector.get(r53, r117);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r68), "Container") == true) goto L111;
        r117 = r117 + 1;
        goto L107
    L111:
        if (r61 == Integer.MAX_VALUE) goto L113;
        int r118 = r61;
    L114:
        if (r66 == Integer.MAX_VALUE) goto L116;
        int r69 = r66;
    L117:
        final Placeable r119 = r68.measure-BRTryo0(ConstraintsKt.Constraints(r118, r61, r69, r66));
        final Placeable r120 = r310;
        final Placeable r121 = r28;
        final Placeable r122 = r29;
        final Placeable r123 = r30;
        final Placeable r124 = r32;
        final Placeable r125 = r27;
        return MeasureScope.-CC.layout$default(r52, r61, r115, null, new qt(r40, r311, this, r66, r16, r52, r61, r115, r410, r120, r121, r122, r123, r124, r119, r125, r17), 4, null);
    L116:
        r69 = 0;
        goto L117
    L113:
        r118 = 0;
        goto L114
    L120:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L105:
        r116 = 0;
        goto L106
    L91:
        r310 = null;
        goto L92
    L87:
        r58 = null;
        goto L88
    L123:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L75:
        r46 = 0;
        goto L76
    L71:
        r45 = null;
        goto L72
    L59:
        r42 = null;
        goto L60
    L61:
        if (r39 == null) goto L63;
        int r70 = r39.minIntrinsicHeight(Constraints.getMinWidth-impl(r54));
    L64:
        r210 = r70;
        goto L65
    L63:
        r70 = 0;
        goto L64
    L53:
        r38 = null;
        goto L54
    L46:
        r32 = null;
        goto L47
    L42:
        r25 = null;
        goto L43
    L35:
        r30 = null;
        goto L36
    L31:
        r19 = null;
        goto L32
    L24:
        r29 = null;
        goto L25
    L20:
        r9 = null;
        goto L21
    L13:
        r28 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends IntrinsicMeasurable> r3, int r4) {
        return intrinsicHeight(r2, r3, r4, new rt());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, List<? extends IntrinsicMeasurable> r2, int r3) {
        return intrinsicWidth(r2, r3, new pt());
    }

    private final int intrinsicHeight(IntrinsicMeasureScope r25, List<? extends IntrinsicMeasurable> r26, int r27, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r28) {
        List<? extends IntrinsicMeasurable> r2 = r26;
        int r3 = r2.size();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        Object r7 = ListProtector.get(r26, r5);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r7), TextFieldImplKt.LeadingId) == true) goto L9;
        r5 = r5 + 1;
    L9:
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) r7;
        if (r8 == null) goto L12;
        int r6 = LayoutUtilKt.subtractConstraintSafely(r27, r8.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r9 = ((Number) r28.invoke(r8, Integer.valueOf(r27))).intValue();
    L13:
        int r10 = r2.size();
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L19;
        Object r12 = ListProtector.get(r26, r11);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r12), TextFieldImplKt.TrailingId) == true) goto L20;
        r11 = r11 + 1;
    L20:
        IntrinsicMeasurable r13 = (IntrinsicMeasurable) r12;
        if (r13 == null) goto L23;
        int r14 = LayoutUtilKt.subtractConstraintSafely(r6, r13.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r15 = ((Number) r28.invoke(r13, Integer.valueOf(r27))).intValue();
        int r16 = r14;
        int r17 = r15;
    L24:
        int r18 = r2.size();
        int r19 = 0;
    L25:
        if (r19 >= r18) goto L30;
        Object r110 = ListProtector.get(r26, r19);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r110), TextFieldImplKt.LabelId) == true) goto L31;
        r19 = r19 + 1;
    L31:
        IntrinsicMeasurable r111 = (IntrinsicMeasurable) r110;
        if (r111 == null) goto L34;
        int r112 = ((Number) r28.invoke(r111, Integer.valueOf(r16))).intValue();
    L35:
        int r113 = r2.size();
        int r114 = 0;
    L36:
        if (r114 >= r113) goto L41;
        Object r115 = ListProtector.get(r26, r114);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r115), "Prefix") == true) goto L42;
        r114 = r114 + 1;
    L42:
        IntrinsicMeasurable r116 = (IntrinsicMeasurable) r115;
        if (r116 == null) goto L45;
        int r4 = ((Number) r28.invoke(r116, Integer.valueOf(r16))).intValue();
        int r20 = LayoutUtilKt.subtractConstraintSafely(r16, r116.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r21 = r4;
        int r22 = r20;
    L46:
        int r117 = r2.size();
        int r118 = 0;
    L47:
        if (r118 >= r117) goto L52;
        Object r119 = ListProtector.get(r26, r118);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r119), "Suffix") == true) goto L53;
        r118 = r118 + 1;
    L53:
        IntrinsicMeasurable r120 = (IntrinsicMeasurable) r119;
        if (r120 == null) goto L56;
        int r23 = ((Number) r28.invoke(r120, Integer.valueOf(r22))).intValue();
        r22 = LayoutUtilKt.subtractConstraintSafely(r22, r120.maxIntrinsicWidth(Integer.MAX_VALUE));
        int r121 = r23;
    L57:
        int r24 = r2.size();
        int r29 = 0;
    L58:
        if (r29 >= r24) goto L86;
        Object r122 = ListProtector.get(r26, r29);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r122), TextFieldImplKt.TextFieldId) == true) goto L61;
        r29 = r29 + 1;
        goto L58
    L61:
        int r30 = ((Number) r28.invoke(r122, Integer.valueOf(r22))).intValue();
        int r31 = r2.size();
        int r123 = 0;
    L62:
        if (r123 >= r31) goto L67;
        Object r124 = ListProtector.get(r26, r123);
        int r125 = r31;
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r124), TextFieldImplKt.PlaceholderId) == true) goto L68;
        r123 = r123 + 1;
        r31 = r125;
    L68:
        IntrinsicMeasurable r126 = (IntrinsicMeasurable) r124;
        if (r126 == null) goto L71;
        int r127 = ((Number) r28.invoke(r126, Integer.valueOf(r22))).intValue();
    L72:
        int r32 = r2.size();
        int r33 = 0;
    L73:
        if (r33 >= r32) goto L78;
        Object r34 = ListProtector.get(r26, r33);
        if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((IntrinsicMeasurable) r34), "Supporting") == true) goto L79;
        r33 = r33 + 1;
    L79:
        IntrinsicMeasurable r35 = (IntrinsicMeasurable) r34;
        if (r35 == null) goto L82;
        int r128 = ((Number) r28.invoke(r35, Integer.valueOf(r27))).intValue();
    L83:
        int r36 = r112;
        int r37 = r9;
        int r38 = r21;
        int r39 = r121;
        int r40 = r127;
        int r41 = r128;
        return m3357calculateHeightmKXJcVc(r25, r30, r36, r37, r17, r38, r39, r40, r41, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.labelPosition instanceof TextFieldLabelPosition.Above, this.labelProgress.invoke());
    L82:
        r128 = 0;
        goto L83
    L78:
        r34 = null;
        goto L79
    L71:
        r127 = 0;
        goto L72
    L67:
        r124 = null;
        goto L68
    L86:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L56:
        r121 = 0;
        goto L57
    L52:
        r119 = null;
        goto L53
    L45:
        r22 = r16;
        r21 = 0;
        goto L46
    L41:
        r115 = null;
        goto L42
    L34:
        r112 = 0;
        goto L35
    L30:
        r110 = null;
        goto L31
    L23:
        r16 = r6;
        r17 = 0;
        goto L24
    L19:
        r12 = null;
        goto L20
    L12:
        r6 = r27;
        r9 = 0;
        goto L13
    L8:
        r7 = null;
        goto L9
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(TextFieldMeasurePolicy r0, int r1, int r2, Placeable r3) {
        if (r0.singleLine == true) goto L5;
        return r2;
    L5:
        return Alignment.Companion.getCenterVertically().align(r3.getHeight(), r1);
    }

    private TextFieldMeasurePolicy(boolean r1, TextFieldLabelPosition r2, FloatProducer r3, PaddingValues r4, float r5) {
        this.singleLine = r1;
        this.labelPosition = r2;
        this.labelProgress = r3;
        this.paddingValues = r4;
        this.minimizedLabelHalfHeight = r5;
    }

    /* JADX INFO: renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    private final int m3358calculateWidthyeHjK3Y(int r1, int r2, int r3, int r4, int r5, int r6, int r7, long r8) {
        int r9 = r3 + r4;
        return ConstraintsKt.constrainWidth-K40F9xA(r8, (r1 + Math.max(r5 + r9, Math.max(r7 + r9, r6))) + r2);
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    private final int m3357calculateHeightmKXJcVc(Density r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, long r21, boolean r23, float r24) {
        int r2 = r14;
        int r4 = r12.roundToPx-0680j_4(Dp.constructor-impl(this.paddingValues.mo901calculateTopPaddingD9Ej5fM() + this.paddingValues.mo898calculateBottomPaddingD9Ej5fM()));
        int[] r5 = new int[4];
        r5[0] = r19;
        boolean r7 = true;
        r5[1] = r17;
        r5[2] = r18;
        if (r23 == false) goto L5;
        int r9 = 0;
    L6:
        r5[3] = r9;
        int r6 = ComparisonsKt.maxOf(r13, r5);
        if (r2 > 0) goto L10;
        r7 = false;
    L10:
        if (r7 == false) goto L13;
        if (r23 == true) goto L13;
        int r1 = Math.max(r12.roundToPx-0680j_4(Dp.constructor-impl(this.minimizedLabelHalfHeight * 2)), MathHelpersKt.lerp(0, r14, MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier().transform(r24)));
    L14:
        int r8 = (r4 + r1) + r6;
        if (r23 == true) goto L19;
        r2 = 0;
    L19:
        return ConstraintsKt.constrainHeight-K40F9xA(r21, (r2 + Math.max(r15, Math.max(r16, r8))) + r20);
    L13:
        r1 = 0;
        goto L14
    L5:
        r9 = MathHelpersKt.lerp(r14, 0, r24);
        goto L6
    }

    private final void placeWithoutLabel(Placeable.PlacementScope r21, int r22, int r23, Placeable r24, Placeable r25, Placeable r26, Placeable r27, Placeable r28, Placeable r29, Placeable r30, Placeable r31, float r32) {
        Placeable.PlacementScope.place-70tqf50$default(r21, r30, IntOffset.Companion.getZero-nOcc-ac(), MenuKt.ClosedAlphaTarget, 2, null);
        int r11 = r23 - LayoutUtilKt.getHeightOrZero(r31);
        int r12 = MathKt.roundToInt(this.paddingValues.mo901calculateTopPaddingD9Ej5fM() * r32);
        if (r26 == null) goto L5;
        Placeable.PlacementScope.placeRelative$default(r21, r26, 0, Alignment.Companion.getCenterVertically().align(r26.getHeight(), r11), MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        if (r28 == null) goto L7;
        Placeable.PlacementScope.placeRelative$default(r21, r28, LayoutUtilKt.getWidthOrZero(r26), placeWithoutLabel$calculateVerticalPosition(this, r11, r12, r28), MenuKt.ClosedAlphaTarget, 4, null);
    L7:
        int r3 = LayoutUtilKt.getWidthOrZero(r26) + LayoutUtilKt.getWidthOrZero(r28);
        Placeable.PlacementScope.placeRelative$default(r21, r24, r3, placeWithoutLabel$calculateVerticalPosition(this, r11, r12, r24), MenuKt.ClosedAlphaTarget, 4, null);
        if (r25 == null) goto L10;
        Placeable.PlacementScope.placeRelative$default(r21, r25, r3, placeWithoutLabel$calculateVerticalPosition(this, r11, r12, r25), MenuKt.ClosedAlphaTarget, 4, null);
    L10:
        if (r29 == null) goto L12;
        Placeable.PlacementScope.placeRelative$default(r21, r29, (r22 - LayoutUtilKt.getWidthOrZero(r27)) - r29.getWidth(), placeWithoutLabel$calculateVerticalPosition(this, r11, r12, r29), MenuKt.ClosedAlphaTarget, 4, null);
    L12:
        if (r27 == null) goto L14;
        Placeable.PlacementScope.placeRelative$default(r21, r27, r22 - r27.getWidth(), Alignment.Companion.getCenterVertically().align(r27.getHeight(), r11), MenuKt.ClosedAlphaTarget, 4, null);
    L14:
        if (r31 == null) goto L17;
        Placeable.PlacementScope.placeRelative$default(r21, r31, 0, r11, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    }

    private static final Unit measure_3p2s80s$lambda$9(Ref.ObjectRef r19, boolean r20, TextFieldMeasurePolicy r21, int r22, int r23, MeasureScope r24, int r25, int r26, Placeable r27, Placeable r28, Placeable r29, Placeable r30, Placeable r31, Placeable r32, Placeable r33, Placeable r34, float r35, Placeable.PlacementScope r36) {
        if (r19.element == null) goto L20;
        int r2 = 0;
        if (r20 == false) goto L8;
        int r13 = 0;
    L12:
        if (r20 == false) goto L14;
        int r14 = 0;
    L15:
        Object r0 = r19.element;
        Placeable r5 = (Placeable) r0;
        if (r20 == true) goto L19;
        r2 = ((Placeable) r0).getHeight();
    L19:
        r21.placeWithLabel(r36, r25, r26, r27, r5, r28, r29, r30, r31, r32, r33, r34, r13, r14, r20, r35, r23 + r2, r24.getLayoutDirection());
    L22:
        return Unit.INSTANCE;
    L14:
        r14 = r23;
        goto L15
    L8:
        if (r21.singleLine == false) goto L10;
        int r3 = Alignment.Companion.getCenterVertically().align(((Placeable) r19.element).getHeight(), r22);
    L11:
        r13 = r3;
        goto L12
    L10:
        r3 = r23 + r24.roundToPx-0680j_4(r21.minimizedLabelHalfHeight);
        goto L11
    L20:
        r21.placeWithoutLabel(r36, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r24.getDensity());
        goto L22
    }

    private final void placeWithLabel(Placeable.PlacementScope r22, int r23, int r24, Placeable r25, Placeable r26, Placeable r27, Placeable r28, Placeable r29, Placeable r30, Placeable r31, Placeable r32, Placeable r33, int r34, int r35, boolean r36, float r37, int r38, LayoutDirection r39) {
        int r4 = 0;
        if (r36 == false) goto L5;
        int r5 = r26.getHeight();
    L6:
        Placeable.PlacementScope.place$default(r22, r32, 0, r5, MenuKt.ClosedAlphaTarget, 4, null);
        int r6 = r24 - LayoutUtilKt.getHeightOrZero(r33);
        if (r36 == false) goto L9;
        r4 = r26.getHeight();
    L9:
        int r7 = r6 - r4;
        if (r28 == null) goto L12;
        Placeable.PlacementScope.placeRelative$default(r22, r28, 0, r5 + Alignment.Companion.getCenterVertically().align(r28.getHeight(), r7), MenuKt.ClosedAlphaTarget, 4, null);
    L12:
        int r10 = MathHelpersKt.lerp(r34, r35, r37);
        if (r36 == false) goto L16;
        Placeable.PlacementScope.place$default(r22, r26, androidx.compose.material3.internal.TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(r26.getWidth(), r23, r39), r10, MenuKt.ClosedAlphaTarget, 4, null);
    L20:
        if (r30 == null) goto L22;
        Placeable.PlacementScope.placeRelative$default(r22, r30, LayoutUtilKt.getWidthOrZero(r28), r5 + r38, MenuKt.ClosedAlphaTarget, 4, null);
    L22:
        int r2 = LayoutUtilKt.getWidthOrZero(r28) + LayoutUtilKt.getWidthOrZero(r30);
        int r3 = r5 + r38;
        Placeable.PlacementScope.placeRelative$default(r22, r25, r2, r3, MenuKt.ClosedAlphaTarget, 4, null);
        if (r27 == null) goto L25;
        Placeable.PlacementScope.placeRelative$default(r22, r27, r2, r3, MenuKt.ClosedAlphaTarget, 4, null);
    L25:
        if (r31 == null) goto L27;
        Placeable.PlacementScope.placeRelative$default(r22, r31, (r23 - LayoutUtilKt.getWidthOrZero(r29)) - r31.getWidth(), r3, MenuKt.ClosedAlphaTarget, 4, null);
    L27:
        if (r29 == null) goto L29;
        Placeable.PlacementScope.placeRelative$default(r22, r29, r23 - r29.getWidth(), r5 + Alignment.Companion.getCenterVertically().align(r29.getHeight(), r7), MenuKt.ClosedAlphaTarget, 4, null);
    L29:
        if (r33 == null) goto L32;
        Placeable.PlacementScope.placeRelative$default(r22, r33, 0, r5 + r7, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L32:
        return;
    L16:
        if (r39 != LayoutDirection.Ltr) goto L18;
        int r8 = LayoutUtilKt.getWidthOrZero(r28);
    L19:
        Placeable.PlacementScope.place$default(r22, r26, MathHelpersKt.lerp(androidx.compose.material3.internal.TextFieldImplKt.getExpandedAlignment(this.labelPosition).align(r26.getWidth(), (r23 - LayoutUtilKt.getWidthOrZero(r28)) - LayoutUtilKt.getWidthOrZero(r29), r39) + r8, androidx.compose.material3.internal.TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(r26.getWidth(), (r23 - LayoutUtilKt.getWidthOrZero(r28)) - LayoutUtilKt.getWidthOrZero(r29), r39) + r8, r37), r10, MenuKt.ClosedAlphaTarget, 4, null);
        goto L20
    L18:
        r8 = LayoutUtilKt.getWidthOrZero(r29);
        goto L19
    L5:
        r5 = 0;
        goto L6
    }
}
