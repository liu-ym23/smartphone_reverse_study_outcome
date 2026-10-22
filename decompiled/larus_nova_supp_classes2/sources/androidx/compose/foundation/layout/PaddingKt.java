package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"padding", "Landroidx/compose/ui/Modifier;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "all", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "left", "right", "absolutePadding-qDBjuR0", "calculateStartPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PaddingKt {
    public static /* synthetic */ Unit a(float r0, float r1, float r2, float r3, InspectorInfo r4) {
        return absolutePadding_qDBjuR0$lambda$4(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(float r0, InspectorInfo r1) {
        return padding_3ABfNKs$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit c(float r0, float r1, InspectorInfo r2) {
        return padding_VpY3zN4$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(float r0, float r1, float r2, float r3, InspectorInfo r4) {
        return padding_qDBjuR0$lambda$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit e(PaddingValues r0, InspectorInfo r1) {
        return padding$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m953PaddingValues0680j_4(float r7) {
        return new PaddingValuesImpl(r7, r7, r7, r7, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m954PaddingValuesYgX7TsA(float r7, float r8) {
        return new PaddingValuesImpl(r7, r8, r7, r8, null);
    }

    public static final float calculateEndPadding(PaddingValues r1, LayoutDirection r2) {
        if (r2 != LayoutDirection.Ltr) goto L6;
        return r1.mo900calculateRightPaddingu2uoSUM(r2);
    L6:
        return r1.mo899calculateLeftPaddingu2uoSUM(r2);
    }

    public static final float calculateStartPadding(PaddingValues r1, LayoutDirection r2) {
        if (r2 != LayoutDirection.Ltr) goto L6;
        return r1.mo899calculateLeftPaddingu2uoSUM(r2);
    L6:
        return r1.mo900calculateRightPaddingu2uoSUM(r2);
    }

    public static final Modifier padding(Modifier r2, final PaddingValues r3) {
        return r2.then(new PaddingValuesElement(r3, new q1(r3)));
    }

    private static final Unit padding$lambda$3(PaddingValues r1, InspectorInfo r2) {
        r2.setName("padding");
        r2.getProperties().set("paddingValues", r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m960padding3ABfNKs(Modifier r9, final float r10) {
        return r9.then(new PaddingElement(r10, r10, r10, r10, true, new o1(r10), null));
    }

    private static final Unit padding_3ABfNKs$lambda$2(float r1, InspectorInfo r2) {
        r2.setName("padding");
        r2.setValue(Dp.box-impl(r1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m961paddingVpY3zN4(Modifier r9, final float r10, final float r11) {
        return r9.then(new PaddingElement(r10, r11, r10, r11, true, new p1(r10, r11), null));
    }

    private static final Unit padding_VpY3zN4$lambda$1(float r2, float r3, InspectorInfo r4) {
        r4.setName("padding");
        r4.getProperties().set("horizontal", Dp.box-impl(r2));
        r4.getProperties().set("vertical", Dp.box-impl(r3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m955PaddingValuesYgX7TsA$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.constructor-impl(0);
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.constructor-impl(0);
    L9:
        return m954PaddingValuesYgX7TsA(r1, r2);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m956PaddingValuesa9UjIt4(float r7, float r8, float r9, float r10) {
        return new PaddingValuesImpl(r7, r8, r9, r10, null);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m958absolutePaddingqDBjuR0(Modifier r9, final float r10, final float r11, final float r12, final float r13) {
        return r9.then(new PaddingElement(r10, r11, r12, r13, false, new r1(r10, r11, r12, r13), null));
    }

    private static final Unit absolutePadding_qDBjuR0$lambda$4(float r2, float r3, float r4, float r5, InspectorInfo r6) {
        r6.setName("absolutePadding");
        r6.getProperties().set("left", Dp.box-impl(r2));
        r6.getProperties().set("top", Dp.box-impl(r3));
        r6.getProperties().set("right", Dp.box-impl(r4));
        r6.getProperties().set("bottom", Dp.box-impl(r5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m962paddingVpY3zN4$default(Modifier r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = Dp.constructor-impl(0);
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = Dp.constructor-impl(0);
    L9:
        return m961paddingVpY3zN4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m963paddingqDBjuR0(Modifier r9, final float r10, final float r11, final float r12, final float r13) {
        return r9.then(new PaddingElement(r10, r11, r12, r13, true, new n1(r10, r11, r12, r13), null));
    }

    private static final Unit padding_qDBjuR0$lambda$0(float r2, float r3, float r4, float r5, InspectorInfo r6) {
        r6.setName("padding");
        r6.getProperties().set("start", Dp.box-impl(r2));
        r6.getProperties().set("top", Dp.box-impl(r3));
        r6.getProperties().set("end", Dp.box-impl(r4));
        r6.getProperties().set("bottom", Dp.box-impl(r5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m957PaddingValuesa9UjIt4$default(float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Dp.constructor-impl(0);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Dp.constructor-impl(0);
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Dp.constructor-impl(0);
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = Dp.constructor-impl(0);
    L15:
        return m956PaddingValuesa9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m959absolutePaddingqDBjuR0$default(Modifier r1, float r2, float r3, float r4, float r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = Dp.constructor-impl(0);
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = Dp.constructor-impl(0);
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = Dp.constructor-impl(0);
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = Dp.constructor-impl(0);
    L15:
        return m958absolutePaddingqDBjuR0(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m964paddingqDBjuR0$default(Modifier r1, float r2, float r3, float r4, float r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = Dp.constructor-impl(0);
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = Dp.constructor-impl(0);
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = Dp.constructor-impl(0);
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = Dp.constructor-impl(0);
    L15:
        return m963paddingqDBjuR0(r1, r2, r3, r4, r5);
    }
}
