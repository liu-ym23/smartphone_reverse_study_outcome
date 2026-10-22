package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt$ScrollableTabRowWithSubcomposeImpl$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX WARN: Multi-variable type inference failed */
    public TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(ScrollState r1, float r2, Function2<? super Composer, ? super Integer, Unit> r3, Function2<? super Composer, ? super Integer, Unit> r4, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r5, int r6) {
        this.$scrollState = r1;
        this.$edgePadding = r2;
        this.$tabs = r3;
        this.$divider = r4;
        this.$indicator = r5;
        this.$selectedTabIndex = r6;
    }

    public static /* synthetic */ Unit a(int r0, List r1, SubcomposeMeasureScope r2, Function2 r3, ScrollableTabData r4, int r5, List r6, Constraints r7, int r8, int r9, Function3 r10, Placeable.PlacementScope r11) {
        return invoke$lambda$9$lambda$8$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ MeasureResult b(float r0, Function2 r1, Function2 r2, ScrollableTabData r3, int r4, Function3 r5, SubcomposeMeasureScope r6, Constraints r7) {
        return invoke$lambda$9$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public final void invoke(Composer r24, int r25) {
        if ((r25 & 3) == 2) goto L5;
        boolean r3 = true;
    L7:
        if (r24.shouldExecute(r3, r25 & 1) == true) goto L9;
        r24.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(2077251399, r25, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:836)");
    L11:
        Object r2 = r24.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r2 != r4.getEmpty()) goto L14;
        r2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r24);
        r24.updateRememberedValue(r2);
    L14:
        CoroutineScope r5 = (CoroutineScope) r2;
        FiniteAnimationSpec r7 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r24, 6);
        boolean r8 = r24.changed(this.$scrollState) | r24.changed(r5);
        ScrollState r9 = this.$scrollState;
        Object r10 = r24.rememberedValue();
        if (r8 == false) goto L17;
    L18:
        r10 = new ScrollableTabData(r9, r5, r7);
        r24.updateRememberedValue(r10);
    L19:
        final ScrollableTabData r15 = (ScrollableTabData) r10;
        Modifier r6 = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), this.$scrollState, false, null, false, 14, null)));
        boolean r11 = ((((r24.changed(this.$edgePadding) | r24.changed(this.$tabs)) | r24.changed(this.$divider)) | r24.changed(this.$indicator)) | r24.changedInstance(r15)) | r24.changed(this.$selectedTabIndex);
        final float r12 = this.$edgePadding;
        final Function2<Composer, Integer, Unit> r13 = this.$tabs;
        final Function2<Composer, Integer, Unit> r14 = this.$divider;
        final int r16 = this.$selectedTabIndex;
        final Function3<List<TabPosition>, Composer, Integer, Unit> r17 = this.$indicator;
        Object r18 = r24.rememberedValue();
        if (r11 == false) goto L22;
    L23:
        r18 = new zs(r12, r13, r14, r15, r16, r17);
        r24.updateRememberedValue(r18);
    L24:
        SubcomposeLayoutKt.SubcomposeLayout(r6, (Function2) r18, r24, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        return;
    L29:
        return;
    L22:
        if (r18 != r4.getEmpty()) goto L24;
    L17:
        if (r10 != r4.getEmpty()) goto L19;
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final MeasureResult invoke$lambda$9$lambda$8(float r17, Function2 r18, final Function2 r19, final ScrollableTabData r20, final int r21, final Function3 r22, final SubcomposeMeasureScope r23, final Constraints r24) {
        int r3 = r23.roundToPx-0680j_4(TabRowDefaults.INSTANCE.m3260getScrollableTabRowMinTabWidthD9Ej5fM());
        final int r9 = r23.roundToPx-0680j_4(r17);
        List r0 = r23.subcompose(TabSlots.Tabs, r18);
        int r10 = 0;
        Integer r1 = 0;
        List r11 = r0;
        int r2 = r11.size();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1 = Integer.valueOf(Math.max(r1.intValue(), ((Measurable) ListProtector.get(r0, r4)).maxIntrinsicHeight(Integer.MAX_VALUE)));
        r4 = r4 + 1;
        goto L3
    L5:
        final int r13 = r1.intValue();
        long r5 = Constraints.copy-Zbe2FdA$default(r24.unbox-impl(), r3, 0, r13, r13, 2, null);
        final ArrayList r6 = new ArrayList();
        final ArrayList r7 = new ArrayList();
        int r8 = r11.size();
        int r12 = 0;
    L6:
        if (r12 >= r8) goto L8;
        Measurable r14 = (Measurable) ListProtector.get(r0, r12);
        Placeable r15 = r14.measure-BRTryo0(r5);
        float r16 = Dp.constructor-impl(r23.toDp-u2uoSUM(Math.min(r14.maxIntrinsicWidth(r15.getHeight()), r15.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
        r6.add(r15);
        r7.add(Dp.box-impl(r16));
        r12 = r12 + 1;
        goto L6
    L8:
        Integer r25 = Integer.valueOf(r9 * 2);
        int r26 = r6.size();
    L9:
        if (r10 >= r26) goto L11;
        r25 = Integer.valueOf(r25.intValue() + ((Placeable) ListProtector.get(r6, r10)).getWidth());
        r10 = r10 + 1;
        goto L9
    L11:
        final int r110 = r25.intValue();
        return MeasureScope.-CC.layout$default(r23, r110, r13, null, new ys(r9, r6, r23, r19, r20, r21, r7, r24, r110, r13, r22), 4, null);
    }

    private static final Unit invoke$lambda$9$lambda$8$lambda$7(int r18, List r19, SubcomposeMeasureScope r20, Function2 r21, ScrollableTabData r22, int r23, List r24, Constraints r25, int r26, int r27, final Function3 r28, Placeable.PlacementScope r29) {
        final ArrayList r3 = new ArrayList();
        int r4 = r19.size();
        int r5 = 0;
        int r14 = r18;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        Placeable r15 = (Placeable) ListProtector.get(r19, r6);
        Placeable.PlacementScope.placeRelative$default(r29, r15, r14, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r3.add(new TabPosition(r20.toDp-u2uoSUM(r14), r20.toDp-u2uoSUM(r15.getWidth()), ((Dp) ListProtector.get(r24, r6)).unbox-impl(), null));
        r14 = r14 + r15.getWidth();
        r6 = r6 + 1;
        goto L3
    L5:
        List r0 = r20.subcompose(TabSlots.Divider, r21);
        int r7 = r0.size();
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L8;
        Placeable r11 = ((Measurable) ListProtector.get(r0, r8)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r25.unbox-impl(), r26, r26, 0, 0, 8, null));
        Placeable.PlacementScope.placeRelative$default(r29, r11, 0, r27 - r11.getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        r8 = r8 + 1;
        goto L6
    L8:
        List r1 = r20.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(2125766411, true, new TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1$2$3(r28, r3)));
        int r9 = r1.size();
    L9:
        if (r5 >= r9) goto L11;
        Placeable.PlacementScope.placeRelative$default(r29, ((Measurable) ListProtector.get(r1, r5)).measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r26, r27)), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r5 = r5 + 1;
        goto L9
    L11:
        r22.onLaidOut(r20, r18, r3, r23);
        return Unit.INSTANCE;
    }
}
