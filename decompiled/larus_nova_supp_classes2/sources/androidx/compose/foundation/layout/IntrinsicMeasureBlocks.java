package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u000e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u000f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u0010\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u0011\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u0012\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", "", "<init>", "()V", "HorizontalMinWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableHeight", "mainAxisSpacing", "VerticalMinWidth", "HorizontalMinHeight", "availableWidth", "VerticalMinHeight", "HorizontalMaxWidth", "VerticalMaxWidth", "HorizontalMaxHeight", "VerticalMaxHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntrinsicMeasureBlocks {
    public static final int $stable = 0;
    public static final IntrinsicMeasureBlocks INSTANCE = null;

    static {
        INSTANCE = new IntrinsicMeasureBlocks();
    }

    private IntrinsicMeasureBlocks() {
    }

    public final int HorizontalMaxHeight(List<? extends IntrinsicMeasurable> r13, int r14, int r15) {
        int r1 = 0;
        if (r13.isEmpty() == true) goto L48;
        boolean r2 = true;
        int r16 = Math.min((r13.size() - 1) * r15, r14);
        List<? extends IntrinsicMeasurable> r0 = r13;
        int r3 = r0.size();
        int r5 = 0;
        float r6 = MenuKt.ClosedAlphaTarget;
        int r7 = 0;
    L7:
        if (r5 >= r3) goto L22;
        IntrinsicMeasurable r9 = (IntrinsicMeasurable) ListProtector.get(r13, r5);
        float r10 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r9));
        if (r10 != MenuKt.ClosedAlphaTarget) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L18;
        if (r14 != Integer.MAX_VALUE) goto L15;
        int r12 = Integer.MAX_VALUE;
    L16:
        int r8 = Math.min(r9.maxIntrinsicWidth(Integer.MAX_VALUE), r12);
        r16 = r16 + r8;
        r7 = Math.max(r7, r9.maxIntrinsicHeight(r8));
    L20:
        r5 = r5 + 1;
        goto L7
    L15:
        r12 = r14 - r16;
        goto L16
    L18:
        if (r10 <= MenuKt.ClosedAlphaTarget) goto L20;
        r6 = r6 + r10;
        goto L20
    L11:
        r11 = false;
        goto L12
    L22:
        if (r6 == MenuKt.ClosedAlphaTarget) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        int r17 = 0;
    L30:
        int r18 = r0.size();
    L31:
        if (r1 >= r18) goto L40;
        IntrinsicMeasurable r4 = (IntrinsicMeasurable) ListProtector.get(r13, r1);
        float r19 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r4));
        if (r19 <= MenuKt.ClosedAlphaTarget) goto L38;
        if (r17 == Integer.MAX_VALUE) goto L36;
        int r20 = Math.round(r17 * r19);
    L37:
        r7 = Math.max(r7, r4.maxIntrinsicHeight(r20));
        goto L38
    L36:
        r20 = Integer.MAX_VALUE;
    L38:
        r1 = r1 + 1;
        goto L31
    L40:
        return r7;
    L27:
        if (r14 != Integer.MAX_VALUE) goto L29;
        r17 = Integer.MAX_VALUE;
        goto L30
    L29:
        r17 = Math.round(Math.max(r14 - r16, 0) / r6);
        goto L30
    L48:
        return 0;
    }

    public final int HorizontalMaxWidth(List<? extends IntrinsicMeasurable> r12, int r13, int r14) {
        if (r12.isEmpty() == true) goto L24;
        int r0 = r12.size();
        int r3 = 0;
        int r4 = 0;
        float r5 = MenuKt.ClosedAlphaTarget;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r3 >= r0) goto L19;
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) ListProtector.get(r12, r3);
        float r9 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r8));
        int r10 = r8.maxIntrinsicWidth(r13);
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
        return (Math.round(r4 * r5) + r6) + ((r12.size() - 1) * r14);
    L24:
        return 0;
    }

    public final int HorizontalMinHeight(List<? extends IntrinsicMeasurable> r13, int r14, int r15) {
        int r1 = 0;
        if (r13.isEmpty() == true) goto L48;
        boolean r2 = true;
        int r16 = Math.min((r13.size() - 1) * r15, r14);
        List<? extends IntrinsicMeasurable> r0 = r13;
        int r3 = r0.size();
        int r5 = 0;
        float r6 = MenuKt.ClosedAlphaTarget;
        int r7 = 0;
    L7:
        if (r5 >= r3) goto L22;
        IntrinsicMeasurable r9 = (IntrinsicMeasurable) ListProtector.get(r13, r5);
        float r10 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r9));
        if (r10 != MenuKt.ClosedAlphaTarget) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L18;
        if (r14 != Integer.MAX_VALUE) goto L15;
        int r12 = Integer.MAX_VALUE;
    L16:
        int r8 = Math.min(r9.maxIntrinsicWidth(Integer.MAX_VALUE), r12);
        r16 = r16 + r8;
        r7 = Math.max(r7, r9.minIntrinsicHeight(r8));
    L20:
        r5 = r5 + 1;
        goto L7
    L15:
        r12 = r14 - r16;
        goto L16
    L18:
        if (r10 <= MenuKt.ClosedAlphaTarget) goto L20;
        r6 = r6 + r10;
        goto L20
    L11:
        r11 = false;
        goto L12
    L22:
        if (r6 == MenuKt.ClosedAlphaTarget) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        int r17 = 0;
    L30:
        int r18 = r0.size();
    L31:
        if (r1 >= r18) goto L40;
        IntrinsicMeasurable r4 = (IntrinsicMeasurable) ListProtector.get(r13, r1);
        float r19 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r4));
        if (r19 <= MenuKt.ClosedAlphaTarget) goto L38;
        if (r17 == Integer.MAX_VALUE) goto L36;
        int r20 = Math.round(r17 * r19);
    L37:
        r7 = Math.max(r7, r4.minIntrinsicHeight(r20));
        goto L38
    L36:
        r20 = Integer.MAX_VALUE;
    L38:
        r1 = r1 + 1;
        goto L31
    L40:
        return r7;
    L27:
        if (r14 != Integer.MAX_VALUE) goto L29;
        r17 = Integer.MAX_VALUE;
        goto L30
    L29:
        r17 = Math.round(Math.max(r14 - r16, 0) / r6);
        goto L30
    L48:
        return 0;
    }

    public final int HorizontalMinWidth(List<? extends IntrinsicMeasurable> r12, int r13, int r14) {
        if (r12.isEmpty() == true) goto L24;
        int r0 = r12.size();
        int r3 = 0;
        int r4 = 0;
        float r5 = MenuKt.ClosedAlphaTarget;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r3 >= r0) goto L19;
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) ListProtector.get(r12, r3);
        float r9 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r8));
        int r10 = r8.minIntrinsicWidth(r13);
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
        return (Math.round(r4 * r5) + r6) + ((r12.size() - 1) * r14);
    L24:
        return 0;
    }

    public final int VerticalMaxHeight(List<? extends IntrinsicMeasurable> r12, int r13, int r14) {
        if (r12.isEmpty() == true) goto L24;
        int r0 = r12.size();
        int r3 = 0;
        int r4 = 0;
        float r5 = MenuKt.ClosedAlphaTarget;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r3 >= r0) goto L19;
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) ListProtector.get(r12, r3);
        float r9 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r8));
        int r10 = r8.maxIntrinsicHeight(r13);
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
        return (Math.round(r4 * r5) + r6) + ((r12.size() - 1) * r14);
    L24:
        return 0;
    }

    public final int VerticalMaxWidth(List<? extends IntrinsicMeasurable> r13, int r14, int r15) {
        int r1 = 0;
        if (r13.isEmpty() == true) goto L48;
        boolean r2 = true;
        int r16 = Math.min((r13.size() - 1) * r15, r14);
        List<? extends IntrinsicMeasurable> r0 = r13;
        int r3 = r0.size();
        int r5 = 0;
        float r6 = MenuKt.ClosedAlphaTarget;
        int r7 = 0;
    L7:
        if (r5 >= r3) goto L22;
        IntrinsicMeasurable r9 = (IntrinsicMeasurable) ListProtector.get(r13, r5);
        float r10 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r9));
        if (r10 != MenuKt.ClosedAlphaTarget) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L18;
        if (r14 != Integer.MAX_VALUE) goto L15;
        int r12 = Integer.MAX_VALUE;
    L16:
        int r8 = Math.min(r9.maxIntrinsicHeight(Integer.MAX_VALUE), r12);
        r16 = r16 + r8;
        r7 = Math.max(r7, r9.maxIntrinsicWidth(r8));
    L20:
        r5 = r5 + 1;
        goto L7
    L15:
        r12 = r14 - r16;
        goto L16
    L18:
        if (r10 <= MenuKt.ClosedAlphaTarget) goto L20;
        r6 = r6 + r10;
        goto L20
    L11:
        r11 = false;
        goto L12
    L22:
        if (r6 == MenuKt.ClosedAlphaTarget) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        int r17 = 0;
    L30:
        int r18 = r0.size();
    L31:
        if (r1 >= r18) goto L40;
        IntrinsicMeasurable r4 = (IntrinsicMeasurable) ListProtector.get(r13, r1);
        float r19 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r4));
        if (r19 <= MenuKt.ClosedAlphaTarget) goto L38;
        if (r17 == Integer.MAX_VALUE) goto L36;
        int r20 = Math.round(r17 * r19);
    L37:
        r7 = Math.max(r7, r4.maxIntrinsicWidth(r20));
        goto L38
    L36:
        r20 = Integer.MAX_VALUE;
    L38:
        r1 = r1 + 1;
        goto L31
    L40:
        return r7;
    L27:
        if (r14 != Integer.MAX_VALUE) goto L29;
        r17 = Integer.MAX_VALUE;
        goto L30
    L29:
        r17 = Math.round(Math.max(r14 - r16, 0) / r6);
        goto L30
    L48:
        return 0;
    }

    public final int VerticalMinHeight(List<? extends IntrinsicMeasurable> r12, int r13, int r14) {
        if (r12.isEmpty() == true) goto L24;
        int r0 = r12.size();
        int r3 = 0;
        int r4 = 0;
        float r5 = MenuKt.ClosedAlphaTarget;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r3 >= r0) goto L19;
        IntrinsicMeasurable r8 = (IntrinsicMeasurable) ListProtector.get(r12, r3);
        float r9 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r8));
        int r10 = r8.minIntrinsicHeight(r13);
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
        return (Math.round(r4 * r5) + r6) + ((r12.size() - 1) * r14);
    L24:
        return 0;
    }

    public final int VerticalMinWidth(List<? extends IntrinsicMeasurable> r13, int r14, int r15) {
        int r1 = 0;
        if (r13.isEmpty() == true) goto L48;
        boolean r2 = true;
        int r16 = Math.min((r13.size() - 1) * r15, r14);
        List<? extends IntrinsicMeasurable> r0 = r13;
        int r3 = r0.size();
        int r5 = 0;
        float r6 = MenuKt.ClosedAlphaTarget;
        int r7 = 0;
    L7:
        if (r5 >= r3) goto L22;
        IntrinsicMeasurable r9 = (IntrinsicMeasurable) ListProtector.get(r13, r5);
        float r10 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r9));
        if (r10 != MenuKt.ClosedAlphaTarget) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L18;
        if (r14 != Integer.MAX_VALUE) goto L15;
        int r12 = Integer.MAX_VALUE;
    L16:
        int r8 = Math.min(r9.maxIntrinsicHeight(Integer.MAX_VALUE), r12);
        r16 = r16 + r8;
        r7 = Math.max(r7, r9.minIntrinsicWidth(r8));
    L20:
        r5 = r5 + 1;
        goto L7
    L15:
        r12 = r14 - r16;
        goto L16
    L18:
        if (r10 <= MenuKt.ClosedAlphaTarget) goto L20;
        r6 = r6 + r10;
        goto L20
    L11:
        r11 = false;
        goto L12
    L22:
        if (r6 == MenuKt.ClosedAlphaTarget) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        int r17 = 0;
    L30:
        int r18 = r0.size();
    L31:
        if (r1 >= r18) goto L40;
        IntrinsicMeasurable r4 = (IntrinsicMeasurable) ListProtector.get(r13, r1);
        float r19 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r4));
        if (r19 <= MenuKt.ClosedAlphaTarget) goto L38;
        if (r17 == Integer.MAX_VALUE) goto L36;
        int r20 = Math.round(r17 * r19);
    L37:
        r7 = Math.max(r7, r4.minIntrinsicWidth(r20));
        goto L38
    L36:
        r20 = Integer.MAX_VALUE;
    L38:
        r1 = r1 + 1;
        goto L31
    L40:
        return r7;
    L27:
        if (r14 != Integer.MAX_VALUE) goto L29;
        r17 = Integer.MAX_VALUE;
        goto L30
    L29:
        r17 = Math.round(Math.max(r14 - r16, 0) / r6);
        goto L30
    L48:
        return 0;
    }
}
