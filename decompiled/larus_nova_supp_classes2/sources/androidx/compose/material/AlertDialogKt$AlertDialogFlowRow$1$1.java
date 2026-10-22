package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogFlowRow$1$1 implements MeasurePolicy {
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    public AlertDialogKt$AlertDialogFlowRow$1$1(float r1, float r2) {
        this.$mainAxisSpacing = r1;
        this.$crossAxisSpacing = r2;
    }

    public static /* synthetic */ Unit a(List r0, MeasureScope r1, float r2, int r3, List r4, Placeable.PlacementScope r5) {
        return measure_3p2s80s$lambda$4(r0, r1, r2, r3, r4, r5);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
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

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m1917measure3p2s80s(final MeasureScope r27, List<? extends Measurable> r28, long r29) {
        List<? extends Measurable> r1 = r28;
        final ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        final ArrayList r14 = new ArrayList();
        Ref.IntRef r15 = new Ref.IntRef();
        Ref.IntRef r11 = new Ref.IntRef();
        ArrayList r10 = new ArrayList();
        Ref.IntRef r9 = new Ref.IntRef();
        Ref.IntRef r8 = new Ref.IntRef();
        long r6 = ConstraintsKt.Constraints$default(0, Constraints.getMaxWidth-impl(r29), 0, 0, 13, null);
        float r5 = this.$mainAxisSpacing;
        float r4 = this.$crossAxisSpacing;
        int r3 = r1.size();
        int r2 = 0;
    L3:
        if (r2 >= r3) goto L13;
        Placeable r7 = ((Measurable) ListProtector.get(r1, r2)).measure-BRTryo0(r6);
        int r16 = r2;
        int r17 = r3;
        float r18 = r4;
        float r19 = r5;
        long r20 = r6;
        Ref.IntRef r22 = r8;
        if (measure_3p2s80s$canAddToCurrentSequence(r10, r9, r27, r5, r29, r7) == true) goto L7;
        Ref.IntRef r23 = r9;
        measure_3p2s80s$startNewSequence(r12, r11, r27, r18, r10, r13, r22, r14, r15, r23);
    L9:
        if ((!r10.isEmpty()) == false) goto L11;
        Ref.IntRef r110 = r23;
        float r21 = r19;
        r110.element += r27.roundToPx-0680j_4(r21);
    L12:
        ArrayList r24 = r10;
        r24.add(r7);
        r110.element += r7.getWidth();
        r22.element = Math.max(r22.element, r7.getHeight());
        r2 = r16 + 1;
        r1 = r28;
        r8 = r22;
        r9 = r110;
        r4 = r18;
        r6 = r20;
        r11 = r11;
        r10 = r24;
        r5 = r21;
        r3 = r17;
        goto L3
    L11:
        r21 = r19;
        r110 = r23;
        goto L12
    L7:
        r23 = r9;
        goto L9
    L13:
        Ref.IntRef r25 = r8;
        ArrayList r26 = r10;
        Ref.IntRef r210 = r11;
        Ref.IntRef r111 = r9;
        if ((!r26.isEmpty()) == false) goto L17;
        measure_3p2s80s$startNewSequence(r12, r210, r27, this.$crossAxisSpacing, r26, r13, r25, r14, r15, r111);
    L17:
        if (Constraints.getMaxWidth-impl(r29) == Integer.MAX_VALUE) goto L19;
        int r30 = Constraints.getMaxWidth-impl(r29);
    L20:
        final int r31 = r30;
        int r32 = Math.max(r210.element, Constraints.getMinHeight-impl(r29));
        final float r33 = this.$mainAxisSpacing;
        return MeasureScope.-CC.layout$default(r27, r31, r32, null, new e(r12, r27, r33, r31, r14), 4, null);
    L19:
        r30 = Math.max(r15.element, Constraints.getMinWidth-impl(r29));
        goto L20
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> r0, Ref.IntRef r1, MeasureScope r2, float r3, long r4, Placeable r6) {
        if (r0.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (((r1.element + r2.roundToPx-0680j_4(r3)) + r6.getWidth()) <= Constraints.getMaxWidth-impl(r4)) goto L8;
        return false;
    }

    private static final Unit measure_3p2s80s$lambda$4(List r18, MeasureScope r19, float r20, int r21, List r22, Placeable.PlacementScope r23) {
        int r1 = r18.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L16;
        List r4 = (List) ListProtector.get(r18, r3);
        int r5 = r4.size();
        int[] r6 = new int[r5];
        int r7 = 0;
    L5:
        if (r7 >= r5) goto L11;
        int r8 = ((Placeable) ListProtector.get(r4, r7)).getWidth();
        if (r7 >= CollectionsKt.getLastIndex(r4)) goto L9;
        int r9 = r19.roundToPx-0680j_4(r20);
    L10:
        r6[r7] = r8 + r9;
        r7 = r7 + 1;
        goto L5
    L9:
        r9 = 0;
        goto L10
    L11:
        int[] r10 = new int[r5];
        Arrangement.INSTANCE.getBottom().arrange(r19, r21, r6, r10);
        int r11 = r4.size();
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        Placeable.PlacementScope.place$default(r23, (Placeable) ListProtector.get(r4, r12), r10[r12], ((Number) ListProtector.get(r22, r3)).intValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r12 = r12 + 1;
        goto L12
    L14:
        r3 = r3 + 1;
        goto L3
    L16:
        return Unit.INSTANCE;
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> r1, Ref.IntRef r2, MeasureScope r3, float r4, List<Placeable> r5, List<Integer> r6, Ref.IntRef r7, List<Integer> r8, Ref.IntRef r9, Ref.IntRef r10) {
        if ((!r1.isEmpty()) == false) goto L5;
        r2.element += r3.roundToPx-0680j_4(r4);
    L5:
        ListProtector.add(r1, 0, CollectionsKt.toList(r5));
        r6.add(Integer.valueOf(r7.element));
        r8.add(Integer.valueOf(r2.element));
        r2.element += r7.element;
        r9.element = Math.max(r9.element, r10.element);
        r5.clear();
        r10.element = 0;
        r7.element = 0;
    }
}
