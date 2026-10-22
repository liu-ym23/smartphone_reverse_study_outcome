package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
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
    public final MeasureResult m2284measure3p2s80s(final MeasureScope r24, List<? extends Measurable> r25, long r26) {
        List<? extends Measurable> r1 = r25;
        final ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        final ArrayList r14 = new ArrayList();
        Ref.IntRef r15 = new Ref.IntRef();
        Ref.IntRef r11 = new Ref.IntRef();
        ArrayList r10 = new ArrayList();
        Ref.IntRef r9 = new Ref.IntRef();
        Ref.IntRef r8 = new Ref.IntRef();
        float r6 = this.$mainAxisSpacing;
        float r7 = this.$crossAxisSpacing;
        int r5 = r1.size();
        int r4 = 0;
    L3:
        if (r4 >= r5) goto L13;
        Placeable r3 = ((Measurable) ListProtector.get(r1, r4)).measure-BRTryo0(r26);
        int r17 = r4;
        int r18 = r5;
        float r0 = r6;
        float r2 = r7;
        Ref.IntRef r19 = r8;
        if (measure_3p2s80s$canAddToCurrentSequence(r10, r9, r24, r6, r26, r3) == true) goto L7;
        Ref.IntRef r20 = r9;
        measure_3p2s80s$startNewSequence(r12, r11, r24, r2, r10, r13, r19, r14, r15, r20);
    L9:
        if ((!r10.isEmpty()) == false) goto L11;
        Ref.IntRef r16 = r20;
        r16.element += r24.roundToPx-0680j_4(r0);
    L12:
        ArrayList r21 = r10;
        r21.add(r3);
        r16.element += r3.getWidth();
        r19.element = Math.max(r19.element, r3.getHeight());
        r4 = r17 + 1;
        r6 = r0;
        r8 = r19;
        r9 = r16;
        r11 = r11;
        r7 = r2;
        r10 = r21;
        r5 = r18;
        r1 = r25;
        goto L3
    L11:
        r16 = r20;
        goto L12
    L7:
        r20 = r9;
        goto L9
    L13:
        Ref.IntRef r22 = r8;
        ArrayList r23 = r10;
        Ref.IntRef r27 = r11;
        Ref.IntRef r110 = r9;
        if ((!r23.isEmpty()) == false) goto L16;
        AlertDialogKt$AlertDialogFlowRow$1$1 r28 = this;
        measure_3p2s80s$startNewSequence(r12, r27, r24, r28.$crossAxisSpacing, r23, r13, r22, r14, r15, r110);
    L17:
        final int r29 = Math.max(r15.element, Constraints.getMinWidth-impl(r26));
        int r30 = Math.max(r27.element, Constraints.getMinHeight-impl(r26));
        final float r31 = r28.$mainAxisSpacing;
        return MeasureScope.-CC.layout$default(r24, r29, r30, null, new g(r12, r24, r31, r29, r14), 4, null);
    L16:
        r28 = this;
        goto L17
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> r0, Ref.IntRef r1, MeasureScope r2, float r3, long r4, Placeable r6) {
        if (r0.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (((r1.element + r2.roundToPx-0680j_4(r3)) + r6.getWidth()) <= Constraints.getMaxWidth-impl(r4)) goto L8;
        return false;
    }

    private static final Unit measure_3p2s80s$lambda$4(List r16, MeasureScope r17, float r18, int r19, List r20, Placeable.PlacementScope r21) {
        int r1 = r16.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L16;
        List r4 = (List) ListProtector.get(r16, r3);
        int r5 = r4.size();
        int[] r9 = new int[r5];
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L11;
        int r7 = ((Placeable) ListProtector.get(r4, r6)).getWidth();
        if (r6 >= CollectionsKt.getLastIndex(r4)) goto L9;
        int r8 = r17.roundToPx-0680j_4(r18);
    L10:
        r9[r6] = r7 + r8;
        r6 = r6 + 1;
        goto L5
    L9:
        r8 = 0;
        goto L10
    L11:
        int[] r10 = new int[r5];
        Arrangement.INSTANCE.getEnd().arrange(r17, r19, r9, r17.getLayoutDirection(), r10);
        int r11 = r4.size();
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        Placeable.PlacementScope.place$default(r21, (Placeable) ListProtector.get(r4, r12), r10[r12], ((Number) ListProtector.get(r20, r3)).intValue(), MenuKt.ClosedAlphaTarget, 4, null);
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
