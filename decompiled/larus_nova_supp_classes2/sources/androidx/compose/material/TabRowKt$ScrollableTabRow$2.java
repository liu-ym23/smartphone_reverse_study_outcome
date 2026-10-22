package androidx.compose.material;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt$ScrollableTabRow$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX WARN: Multi-variable type inference failed */
    public TabRowKt$ScrollableTabRow$2(float r1, Function2<? super Composer, ? super Integer, Unit> r2, Function2<? super Composer, ? super Integer, Unit> r3, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r4, int r5) {
        this.$edgePadding = r1;
        this.$tabs = r2;
        this.$divider = r3;
        this.$indicator = r4;
        this.$selectedTabIndex = r5;
    }

    public static /* synthetic */ Unit a(int r0, List r1, SubcomposeMeasureScope r2, Function2 r3, ScrollableTabData r4, int r5, Constraints r6, Ref.IntRef r7, Ref.IntRef r8, Function3 r9, Placeable.PlacementScope r10) {
        return invoke$lambda$8$lambda$7$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ MeasureResult b(float r0, Function2 r1, Function2 r2, ScrollableTabData r3, int r4, Function3 r5, SubcomposeMeasureScope r6, Constraints r7) {
        return invoke$lambda$8$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public final void invoke(Composer r19, int r20) {
        if ((r20 & 3) == 2) goto L5;
        boolean r3 = true;
    L7:
        if (r19.shouldExecute(r3, r20 & 1) == true) goto L9;
        r19.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1575164555, r20, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:236)");
    L11:
        ScrollState r10 = ScrollKt.rememberScrollState(0, r19, 0, 1);
        Object r2 = r19.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r2 != r4.getEmpty()) goto L14;
        r2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r19);
        r19.updateRememberedValue(r2);
    L14:
        CoroutineScope r5 = (CoroutineScope) r2;
        boolean r7 = r19.changed(r10) | r19.changed(r5);
        Object r8 = r19.rememberedValue();
        if (r7 == false) goto L17;
    L18:
        r8 = new ScrollableTabData(r10, r5);
        r19.updateRememberedValue(r8);
    L19:
        final ScrollableTabData r6 = (ScrollableTabData) r8;
        Modifier r9 = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), r10, false, null, false, 14, null)));
        boolean r11 = ((((r19.changed(this.$edgePadding) | r19.changed(this.$tabs)) | r19.changed(this.$divider)) | r19.changed(this.$indicator)) | r19.changedInstance(r6)) | r19.changed(this.$selectedTabIndex);
        final float r12 = this.$edgePadding;
        final Function2<Composer, Integer, Unit> r13 = this.$tabs;
        final Function2<Composer, Integer, Unit> r14 = this.$divider;
        final int r15 = this.$selectedTabIndex;
        final Function3<List<TabPosition>, Composer, Integer, Unit> r16 = this.$indicator;
        Object r17 = r19.rememberedValue();
        if (r11 == false) goto L22;
    L23:
        r17 = new mc(r12, r13, r14, r6, r15, r16);
        r19.updateRememberedValue(r17);
    L24:
        SubcomposeLayoutKt.SubcomposeLayout(r9, (Function2) r17, r19, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        return;
    L29:
        return;
    L22:
        if (r17 != r4.getEmpty()) goto L24;
    L17:
        if (r8 != r4.getEmpty()) goto L19;
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final MeasureResult invoke$lambda$8$lambda$7(float r16, Function2 r17, final Function2 r18, final ScrollableTabData r19, final int r20, final Function3 r21, final SubcomposeMeasureScope r22, final Constraints r23) {
        int r3 = r22.roundToPx-0680j_4(TabRowKt.access$getScrollableTabRowMinimumTabWidth$p());
        final int r9 = r22.roundToPx-0680j_4(r16);
        int r5 = 0;
        long r0 = Constraints.copy-Zbe2FdA$default(r23.unbox-impl(), r3, 0, 0, 0, 14, null);
        List r2 = r22.subcompose(TabSlots.Tabs, r17);
        final ArrayList r4 = new ArrayList(r2.size());
        int r6 = r2.size();
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        r4.add(((Measurable) ListProtector.get(r2, r7)).measure-BRTryo0(r0));
        r7 = r7 + 1;
        goto L3
    L5:
        final Ref.IntRef r8 = new Ref.IntRef();
        r8.element = r9 * 2;
        final Ref.IntRef r10 = new Ref.IntRef();
        int r1 = r4.size();
    L6:
        if (r5 >= r1) goto L9;
        Placeable r11 = (Placeable) ListProtector.get(r4, r5);
        r8.element += r11.getWidth();
        r10.element = Math.max(r10.element, r11.getHeight());
        r5 = r5 + 1;
        goto L6
    L9:
        return MeasureScope.-CC.layout$default(r22, r8.element, r10.element, null, new nc(r9, r4, r22, r18, r19, r20, r23, r8, r10, r21), 4, null);
    }

    private static final Unit invoke$lambda$8$lambda$7$lambda$6(int r18, List r19, SubcomposeMeasureScope r20, Function2 r21, ScrollableTabData r22, int r23, Constraints r24, Ref.IntRef r25, Ref.IntRef r26, final Function3 r27, Placeable.PlacementScope r28) {
        final ArrayList r4 = new ArrayList();
        int r5 = r19.size();
        int r6 = 0;
        int r15 = r18;
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L5;
        Placeable r16 = (Placeable) ListProtector.get(r19, r7);
        Placeable.PlacementScope.placeRelative$default(r28, r16, r15, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r4.add(new TabPosition(r20.toDp-u2uoSUM(r15), r20.toDp-u2uoSUM(r16.getWidth()), null));
        r15 = r15 + r16.getWidth();
        r7 = r7 + 1;
        goto L3
    L5:
        List r0 = r20.subcompose(TabSlots.Divider, r21);
        int r8 = r0.size();
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L8;
        Measurable r10 = (Measurable) ListProtector.get(r0, r9);
        long r11 = r24.unbox-impl();
        int r12 = r25.element;
        Placeable r13 = r10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r11, r12, r12, 0, 0, 8, null));
        Placeable.PlacementScope.placeRelative$default(r28, r13, 0, r26.element - r13.getHeight(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r9 = r9 + 1;
        goto L6
    L8:
        List r1 = r20.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-43203918, true, new TabRowKt$ScrollableTabRow$2$1$1$2$3(r27, r4)));
        int r14 = r1.size();
    L9:
        if (r6 >= r14) goto L11;
        Placeable.PlacementScope.placeRelative$default(r28, ((Measurable) ListProtector.get(r1, r6)).measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r25.element, r26.element)), 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r6 = r6 + 1;
        goto L9
    L11:
        r22.onLaidOut(r20, r18, r4, r23);
        return Unit.INSTANCE;
    }
}
