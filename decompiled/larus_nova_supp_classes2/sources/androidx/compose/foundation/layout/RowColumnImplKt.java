package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aF\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0082\b\u001ae\u0010\u001d\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0082\b\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0013\u001a\u00020\f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "isRelative", "intrinsicMainAxisSize", "", "children", "", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisAvailable", "mainAxisSpacing", "intrinsicCrossAxisSize", "crossAxisSize", "mainAxisAvailable", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RowColumnImplKt {
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getCrossAxisAlignment();
    }

    public static final boolean getFill(RowColumnParentData r0) {
        if (r0 != null) goto L6;
        return true;
    L6:
        return r0.getFill();
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable r1) {
        Object r2 = r1.getParentData();
        if ((r2 instanceof RowColumnParentData) == true) goto L7;
        return null;
    L7:
        return (RowColumnParentData) r2;
    }

    public static final float getWeight(RowColumnParentData r0) {
        if (r0 != null) goto L6;
        return MenuKt.ClosedAlphaTarget;
    L6:
        return r0.getWeight();
    }

    public static final boolean isRelative(RowColumnParentData r0) {
        CrossAxisAlignment r1 = getCrossAxisAlignment(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isRelative$foundation_layout();
    }

    public static final RowColumnParentData getRowColumnParentData(Placeable r1) {
        Object r2 = r1.getParentData();
        if ((r2 instanceof RowColumnParentData) == true) goto L7;
        return null;
    L7:
        return (RowColumnParentData) r2;
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> r11, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r12, int r13, int r14) {
        if (r11.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r0 = r11.size();
        int r3 = 0;
        int r4 = 0;
        float r5 = MenuKt.ClosedAlphaTarget;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r3 >= r0) goto L19;
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) ListProtector.get(r11, r3);
        float r9 = getWeight(getRowColumnParentData(r8));
        int r10 = ((Number) r12.invoke(r8, Integer.valueOf(r13))).intValue();
        if (r9 == MenuKt.ClosedAlphaTarget) goto L12;
        r7 = false;
    L12:
        if (r7 == false) goto L15;
        r6 = r6 + r10;
    L17:
        r3 = r3 + 1;
        goto L6
    L15:
        if (r9 <= MenuKt.ClosedAlphaTarget) goto L17;
        r5 = r5 + r9;
        r4 = Math.max(r4, Math.round(r10 / r9));
        goto L17
    L19:
        return (Math.round(r4 * r5) + r6) + ((r11.size() - 1) * r14);
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> r16, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r17, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r18, int r19, int r20) {
        int r4 = 0;
        if (r16.isEmpty() == false) goto L5;
        return 0;
    L5:
        boolean r5 = true;
        int r3 = Math.min((r16.size() - 1) * r20, r19);
        List<? extends IntrinsicMeasurable> r6 = r16;
        int r7 = r6.size();
        int r9 = 0;
        float r10 = MenuKt.ClosedAlphaTarget;
        int r11 = 0;
    L7:
        if (r9 >= r7) goto L22;
        IntrinsicMeasurable r13 = (IntrinsicMeasurable) ListProtector.get(r16, r9);
        float r14 = getWeight(getRowColumnParentData(r13));
        if (r14 != MenuKt.ClosedAlphaTarget) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L18;
        if (r19 != Integer.MAX_VALUE) goto L15;
        int r110 = Integer.MAX_VALUE;
    L16:
        int r12 = Math.min(((Number) r17.invoke(r13, Integer.MAX_VALUE)).intValue(), r110);
        r3 = r3 + r12;
        r11 = Math.max(r11, ((Number) r18.invoke(r13, Integer.valueOf(r12))).intValue());
    L20:
        r9 = r9 + 1;
        goto L7
    L15:
        r110 = r19 - r3;
        goto L16
    L18:
        if (r14 <= MenuKt.ClosedAlphaTarget) goto L20;
        r10 = r10 + r14;
        goto L20
    L11:
        r15 = false;
        goto L12
    L22:
        if (r10 == MenuKt.ClosedAlphaTarget) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L27;
        int r2 = 0;
    L30:
        int r8 = r6.size();
    L31:
        if (r4 >= r8) goto L39;
        IntrinsicMeasurable r21 = (IntrinsicMeasurable) ListProtector.get(r16, r4);
        float r22 = getWeight(getRowColumnParentData(r21));
        if (r22 <= MenuKt.ClosedAlphaTarget) goto L38;
        if (r2 == Integer.MAX_VALUE) goto L36;
        int r23 = Math.round(r2 * r22);
    L37:
        r11 = Math.max(r11, ((Number) r18.invoke(r21, Integer.valueOf(r23))).intValue());
        goto L38
    L36:
        r23 = Integer.MAX_VALUE;
    L38:
        r4 = r4 + 1;
        goto L31
    L39:
        return r11;
    L27:
        if (r19 != Integer.MAX_VALUE) goto L29;
        r2 = Integer.MAX_VALUE;
        goto L30
    L29:
        r2 = Math.round(Math.max(r19 - r3, 0) / r10);
        goto L30
    }
}
