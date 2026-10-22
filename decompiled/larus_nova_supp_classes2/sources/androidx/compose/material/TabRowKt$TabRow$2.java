package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt$TabRow$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX WARN: Multi-variable type inference failed */
    public TabRowKt$TabRow$2(Function2<? super Composer, ? super Integer, Unit> r1, Function2<? super Composer, ? super Integer, Unit> r2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r3) {
        this.$tabs = r1;
        this.$divider = r2;
        this.$indicator = r3;
    }

    public static /* synthetic */ Unit a(List r0, SubcomposeMeasureScope r1, Function2 r2, int r3, Constraints r4, int r5, Function3 r6, List r7, int r8, Placeable.PlacementScope r9) {
        return invoke$lambda$8$lambda$7$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ MeasureResult b(Function2 r0, Function2 r1, Function3 r2, SubcomposeMeasureScope r3, Constraints r4) {
        return invoke$lambda$8$lambda$7(r0, r1, r2, r3, r4);
    }

    public final void invoke(Composer r7, int r8) {
        if ((r8 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r7.shouldExecute(r0, r8 & 1) == true) goto L9;
        r7.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-638448612, r8, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:150)");
    L11:
        Modifier r9 = SizeKt.fillMaxWidth$default(Modifier.Companion, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null);
        boolean r1 = (r7.changed(this.$tabs) | r7.changed(this.$divider)) | r7.changed(this.$indicator);
        final Function2<Composer, Integer, Unit> r2 = this.$tabs;
        final Function2<Composer, Integer, Unit> r3 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> r4 = this.$indicator;
        Object r5 = r7.rememberedValue();
        if (r1 == false) goto L14;
    L15:
        r5 = new oc(r2, r3, r4);
        r7.updateRememberedValue(r5);
    L16:
        SubcomposeLayoutKt.SubcomposeLayout(r9, (Function2) r5, r7, 6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r5 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final MeasureResult invoke$lambda$8$lambda$7(Function2 r18, final Function2 r19, final Function3 r20, final SubcomposeMeasureScope r21, final Constraints r22) {
        final int r11 = Constraints.getMaxWidth-impl(r22.unbox-impl());
        List r0 = r21.subcompose(TabSlots.Tabs, r18);
        int r1 = r0.size();
        final int r12 = r11 / r1;
        final ArrayList r13 = new ArrayList(r0.size());
        int r14 = r0.size();
        int r9 = 0;
    L3:
        if (r9 >= r14) goto L6;
        r13.add(((Measurable) ListProtector.get(r0, r9)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22.unbox-impl(), r12, r12, 0, 0, 12, null)));
        r9 = r9 + 1;
        goto L3
    L6:
        if (r13.isEmpty() == false) goto L8;
        Object r3 = null;
    L15:
        Placeable r4 = (Placeable) r3;
        if (r4 == null) goto L18;
        int r15 = r4.getHeight();
    L19:
        final ArrayList r8 = new ArrayList(r1);
        int r16 = 0;
    L20:
        if (r16 >= r1) goto L22;
        r8.add(new TabPosition(Dp.constructor-impl(r21.toDp-u2uoSUM(r12) * r16), r21.toDp-u2uoSUM(r12), null));
        r16 = r16 + 1;
        goto L20
    L22:
        final int r6 = r15;
        return MeasureScope.-CC.layout$default(r21, r11, r15, null, new pc(r13, r21, r19, r12, r22, r6, r20, r8, r11), 4, null);
    L18:
        r15 = 0;
        goto L19
    L8:
        r3 = ListProtector.get(r13, 0);
        int r5 = ((Placeable) r3).getHeight();
        int r7 = CollectionsKt.getLastIndex(r13);
        int r10 = 1;
        if (1 > r7) goto L15;
    L10:
        Object r17 = ListProtector.get(r13, r10);
        int r23 = ((Placeable) r17).getHeight();
        if (r5 >= r23) goto L13;
        r3 = r17;
        r5 = r23;
    L13:
        if (r10 == r7) goto L15;
        r10 = r10 + 1;
        goto L10
    }

    private static final Unit invoke$lambda$8$lambda$7$lambda$6(List r16, SubcomposeMeasureScope r17, Function2 r18, int r19, Constraints r20, int r21, final Function3 r22, final List r23, int r24, Placeable.PlacementScope r25) {
        int r3 = r16.size();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        Placeable.PlacementScope.placeRelative$default(r25, (Placeable) ListProtector.get(r16, r5), r5 * r19, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r5 = r5 + 1;
        goto L3
    L5:
        List r0 = r17.subcompose(TabSlots.Divider, r18);
        int r6 = r0.size();
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L8;
        Placeable r10 = ((Measurable) ListProtector.get(r0, r7)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r20.unbox-impl(), 0, 0, 0, 0, 11, null));
        Placeable.PlacementScope.placeRelative$default(r25, r10, 0, r21 - r10.getHeight(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r7 = r7 + 1;
        goto L6
    L8:
        List r1 = r17.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-220665376, true, new TabRowKt$TabRow$2$1$1$1$3(r22, r23)));
        int r2 = r1.size();
    L9:
        if (r4 >= r2) goto L12;
        Placeable.PlacementScope.placeRelative$default(r25, ((Measurable) ListProtector.get(r1, r4)).measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r24, r21)), 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r4 = r4 + 1;
        goto L9
    L12:
        return Unit.INSTANCE;
    }
}
