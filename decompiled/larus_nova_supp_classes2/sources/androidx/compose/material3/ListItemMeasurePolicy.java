package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J(\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J(\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J(\u0010\u0016\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016JV\u0010\u0017\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000f2,\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0002\b\u001cH\u0002JV\u0010\u001d\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000f2,\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0002\b\u001cH\u0002¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "calculateIntrinsicWidth", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicHeight", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicHeight", "maxIntrinsicHeight(I)I", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((IntrinsicMeasurable) r1, ((Number) r2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable r1, int r2) {
            return Integer.valueOf(r1.maxIntrinsicHeight(r2));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C02681 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C02681 INSTANCE = null;

        static {
            INSTANCE = new C02681();
        }

        public C02681() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicWidth", "maxIntrinsicWidth(I)I", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((IntrinsicMeasurable) r1, ((Number) r2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable r1, int r2) {
            return Integer.valueOf(r1.maxIntrinsicWidth(r2));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C02691 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C02691 INSTANCE = null;

        static {
            INSTANCE = new C02691();
        }

        public C02691() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicHeight", "minIntrinsicHeight(I)I", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((IntrinsicMeasurable) r1, ((Number) r2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable r1, int r2) {
            return Integer.valueOf(r1.minIntrinsicHeight(r2));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C02701 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C02701 INSTANCE = null;

        static {
            INSTANCE = new C02701();
        }

        public C02701() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((IntrinsicMeasurable) r1, ((Number) r2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable r1, int r2) {
            return Integer.valueOf(r1.minIntrinsicWidth(r2));
        }
    }

    public ListItemMeasurePolicy() {
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends List<? extends IntrinsicMeasurable>> r3, int r4) {
        return calculateIntrinsicHeight(r2, r3, r4, AnonymousClass1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r2, List<? extends List<? extends IntrinsicMeasurable>> r3, int r4) {
        return calculateIntrinsicWidth(r2, r3, r4, C02681.INSTANCE);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2837measure3p2s80s(MeasureScope r27, List<? extends List<? extends Measurable>> r28, long r29) {
        boolean r1 = false;
        List r2 = (List) ListProtector.get(r28, 0);
        List r4 = (List) ListProtector.get(r28, 1);
        List r6 = (List) ListProtector.get(r28, 2);
        List r7 = (List) ListProtector.get(r28, 3);
        List r0 = (List) ListProtector.get(r28, 4);
        long r8 = Constraints.copy-Zbe2FdA$default(r29, 0, 0, 0, 0, 10, null);
        float r11 = ListItemKt.getListItemStartPadding();
        float r12 = ListItemKt.getListItemEndPadding();
        int r13 = r27.roundToPx-0680j_4(Dp.constructor-impl(r11 + r12));
        Measurable r14 = (Measurable) CollectionsKt.firstOrNull(r7);
        if (r14 == null) goto L5;
        int r15 = r14.minIntrinsicWidth(Constraints.getMaxHeight-impl(r29));
    L6:
        Measurable r16 = (Measurable) CollectionsKt.firstOrNull(r0);
        if (r16 == null) goto L9;
        int r3 = r16.minIntrinsicWidth(Constraints.getMaxHeight-impl(r29));
    L10:
        int r5 = LayoutUtilKt.subtractConstraintSafely(Constraints.getMaxWidth-impl(r8), (r15 + r3) + r13);
        Measurable r17 = (Measurable) CollectionsKt.firstOrNull(r6);
        if (r17 == null) goto L13;
        int r9 = r17.minIntrinsicHeight(r5);
    L14:
        boolean r10 = ListItemKt.access$isSupportingMultilineHeuristic(r27, r9);
        ListItemType.Companion r18 = ListItemType.Companion;
        if (CollectionsKt.firstOrNull(r4) == null) goto L17;
        boolean r19 = true;
    L19:
        if (CollectionsKt.firstOrNull(r6) == null) goto L21;
        r1 = true;
    L21:
        float r20 = ListItemKt.m2833access$verticalPaddingyh95HIg(r18.m2850invokeZLSjz4$material3(r19, r1, r10));
        float r21 = 2;
        long r22 = ConstraintsKt.offset-NN6Ew-U(r8, -r13, -r27.roundToPx-0680j_4(Dp.constructor-impl(r20 * r21)));
        Measurable r23 = (Measurable) CollectionsKt.firstOrNull(r7);
        if (r23 == null) goto L24;
        Placeable r110 = r23.measure-BRTryo0(r22);
    L25:
        int r24 = LayoutUtilKt.getWidthOrZero(r110) + 0;
        Measurable r25 = (Measurable) CollectionsKt.firstOrNull(r0);
        if (r25 == null) goto L28;
        Placeable r26 = r25.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r22, -r24, 0, 2, null));
    L29:
        int r30 = r24 + LayoutUtilKt.getWidthOrZero(r26);
        Measurable r31 = (Measurable) CollectionsKt.firstOrNull(r2);
        if (r31 == null) goto L32;
        Placeable r111 = r31.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r22, -r30, 0, 2, null));
    L33:
        int r32 = LayoutUtilKt.getHeightOrZero(r111) + 0;
        Measurable r33 = (Measurable) CollectionsKt.firstOrNull(r6);
        if (r33 == null) goto L36;
        Placeable r34 = r33.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r22, -r30, -r32));
    L37:
        int r35 = r32 + LayoutUtilKt.getHeightOrZero(r34);
        if (r34 != null) goto L40;
    L42:
        boolean r36 = false;
    L43:
        Measurable r37 = (Measurable) CollectionsKt.firstOrNull(r4);
        if (r37 == null) goto L46;
        Placeable r112 = r37.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r22, -r30, -r35));
    L47:
        if (r112 == null) goto L49;
        boolean r38 = true;
    L50:
        if (r34 == null) goto L52;
        boolean r39 = true;
    L53:
        int r40 = r18.m2850invokeZLSjz4$material3(r38, r39, r36);
        float r41 = ListItemKt.m2833access$verticalPaddingyh95HIg(r40);
        float r42 = Dp.constructor-impl(r21 * r41);
        Placeable r113 = r34;
        return ListItemKt.access$place(r27, ListItemKt.m2832access$calculateWidthyeHjK3Y(r27, LayoutUtilKt.getWidthOrZero(r110), LayoutUtilKt.getWidthOrZero(r26), LayoutUtilKt.getWidthOrZero(r111), LayoutUtilKt.getWidthOrZero(r112), LayoutUtilKt.getWidthOrZero(r34), r13, r29), ListItemKt.m2831access$calculateHeightN4Jib3Y(r27, LayoutUtilKt.getHeightOrZero(r110), LayoutUtilKt.getHeightOrZero(r26), LayoutUtilKt.getHeightOrZero(r111), LayoutUtilKt.getHeightOrZero(r112), LayoutUtilKt.getHeightOrZero(r113), r40, r27.roundToPx-0680j_4(r42), r29), r110, r26, r111, r112, r113, ListItemType.m2842equalsimpl0(r40, r18.m2848getThreeLineAlXitO8()), r27.roundToPx-0680j_4(r11), r27.roundToPx-0680j_4(r12), r27.roundToPx-0680j_4(r41));
    L52:
        r39 = false;
        goto L53
    L49:
        r38 = false;
        goto L50
    L46:
        r112 = null;
        goto L47
    L40:
        if (r34.get(AlignmentLineKt.getFirstBaseline()) == r34.get(AlignmentLineKt.getLastBaseline())) goto L42;
        r36 = true;
        goto L43
    L36:
        r34 = null;
        goto L37
    L32:
        r111 = null;
        goto L33
    L28:
        r26 = null;
        goto L29
    L24:
        r110 = null;
        goto L25
    L17:
        r19 = false;
        goto L19
    L13:
        r9 = 0;
        goto L14
    L9:
        r3 = 0;
        goto L10
    L5:
        r15 = 0;
        goto L6
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r2, List<? extends List<? extends IntrinsicMeasurable>> r3, int r4) {
        return calculateIntrinsicHeight(r2, r3, r4, C02691.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r2, List<? extends List<? extends IntrinsicMeasurable>> r3, int r4) {
        return calculateIntrinsicWidth(r2, r3, r4, C02701.INSTANCE);
    }

    private final int calculateIntrinsicHeight(IntrinsicMeasureScope r20, List<? extends List<? extends IntrinsicMeasurable>> r21, int r22, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r23) {
        boolean r3 = false;
        List r4 = (List) ListProtector.get(r21, 0);
        List r6 = (List) ListProtector.get(r21, 1);
        List r8 = (List) ListProtector.get(r21, 2);
        List r9 = (List) ListProtector.get(r21, 3);
        List r1 = (List) ListProtector.get(r21, 4);
        int r10 = LayoutUtilKt.subtractConstraintSafely(r22, r20.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())));
        IntrinsicMeasurable r11 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r9);
        if (r11 == null) goto L5;
        int r12 = ((Number) r23.invoke(r11, Integer.valueOf(r10))).intValue();
        r10 = LayoutUtilKt.subtractConstraintSafely(r10, r11.maxIntrinsicWidth(Integer.MAX_VALUE));
    L6:
        IntrinsicMeasurable r2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L9;
        int r13 = ((Number) r23.invoke(r2, Integer.valueOf(r10))).intValue();
        r10 = LayoutUtilKt.subtractConstraintSafely(r10, r2.maxIntrinsicWidth(Integer.MAX_VALUE));
    L10:
        IntrinsicMeasurable r5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r6);
        if (r5 == null) goto L13;
        int r7 = ((Number) r23.invoke(r5, Integer.valueOf(r10))).intValue();
    L14:
        IntrinsicMeasurable r14 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r4);
        if (r14 == null) goto L17;
        int r15 = ((Number) r23.invoke(r14, Integer.valueOf(r10))).intValue();
    L18:
        IntrinsicMeasurable r16 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r8);
        if (r16 == null) goto L21;
        int r17 = ((Number) r23.invoke(r16, Integer.valueOf(r10))).intValue();
    L22:
        boolean r18 = ListItemKt.access$isSupportingMultilineHeuristic(r20, r17);
        ListItemType.Companion r19 = ListItemType.Companion;
        if (r7 <= 0) goto L25;
        boolean r110 = true;
    L26:
        if (r17 <= 0) goto L28;
        r3 = true;
    L28:
        int r111 = r19.m2850invokeZLSjz4$material3(r110, r3, r18);
        return ListItemKt.m2831access$calculateHeightN4Jib3Y(r20, r12, r13, r15, r7, r17, r111, r20.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.m2833access$verticalPaddingyh95HIg(r111) * 2)), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    L25:
        r110 = false;
        goto L26
    L21:
        r17 = 0;
        goto L22
    L17:
        r15 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope r17, List<? extends List<? extends IntrinsicMeasurable>> r18, int r19, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r20) {
        List r3 = (List) ListProtector.get(r18, 0);
        List r4 = (List) ListProtector.get(r18, 1);
        List r5 = (List) ListProtector.get(r18, 2);
        List r6 = (List) ListProtector.get(r18, 3);
        List r0 = (List) ListProtector.get(r18, 4);
        IntrinsicMeasurable r7 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L5;
        int r8 = ((Number) r20.invoke(r7, Integer.valueOf(r19))).intValue();
    L6:
        IntrinsicMeasurable r1 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L9;
        int r9 = ((Number) r20.invoke(r1, Integer.valueOf(r19))).intValue();
    L10:
        IntrinsicMeasurable r2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r3);
        if (r2 == null) goto L13;
        int r10 = ((Number) r20.invoke(r2, Integer.valueOf(r19))).intValue();
    L14:
        IntrinsicMeasurable r11 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r4);
        if (r11 == null) goto L17;
        int r12 = ((Number) r20.invoke(r11, Integer.valueOf(r19))).intValue();
    L18:
        IntrinsicMeasurable r13 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r5);
        if (r13 == null) goto L21;
        int r14 = ((Number) r20.invoke(r13, Integer.valueOf(r19))).intValue();
    L23:
        return ListItemKt.m2832access$calculateWidthyeHjK3Y(r17, r8, r9, r10, r12, r14, r17.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    L21:
        r14 = 0;
        goto L23
    L17:
        r12 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }
}
