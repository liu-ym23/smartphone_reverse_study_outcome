package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"AppBarColumn", "", "overflowIndicator", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "maxItemCount", "", "content", "Landroidx/compose/material3/AppBarColumnScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "material3", "scope", "Landroidx/compose/material3/AppBarColumnScopeImpl;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarColumnKt {

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarColumnKt$AppBarColumn$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ AppBarMenuState $menuState;
        final /* synthetic */ Function3<AppBarMenuState, Composer, Integer, Unit> $overflowIndicator;
        final /* synthetic */ AppBarOverflowState $overflowState;
        final /* synthetic */ State<AppBarColumnScopeImpl> $scope$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> r1, AppBarMenuState r2, AppBarOverflowState r3, State<AppBarColumnScopeImpl> r4) {
            this.$overflowIndicator = r1;
            this.$menuState = r2;
            this.$overflowState = r3;
            this.$scope$delegate = r4;
        }

        public static /* synthetic */ Unit a(AppBarMenuState r0) {
            return invoke$lambda$2$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$2$lambda$1$lambda$0(AppBarMenuState r0) {
            r0.dismiss();
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r20, int r21) {
            if ((r21 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r20.shouldExecute(r2, r21 & 1) == true) goto L9;
            r20.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1681423992, r21, -1, "androidx.compose.material3.AppBarColumn.<anonymous> (AppBarColumn.kt:71)");
        L11:
            Function3<AppBarMenuState, Composer, Integer, Unit> r1 = this.$overflowIndicator;
            final AppBarMenuState r13 = this.$menuState;
            final AppBarOverflowState r12 = this.$overflowState;
            final State<AppBarColumnScopeImpl> r11 = this.$scope$delegate;
            Modifier.Companion r3 = Modifier.Companion;
            MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            int r5 = ComposablesKt.getCurrentCompositeKeyHash(r20, 0);
            CompositionLocalMap r6 = r20.getCurrentCompositionLocalMap();
            Modifier r7 = ComposedModifierKt.materializeModifier(r20, r3);
            ComposeUiNode.Companion r8 = ComposeUiNode.Companion;
            Function0 r9 = r8.getConstructor();
            if ((r20.getApplier() instanceof Applier) == true) goto L14;
            ComposablesKt.invalidApplier();
        L14:
            r20.startReusableNode();
            if (r20.getInserting() == false) goto L17;
            r20.createNode(r9);
        L18:
            Composer r10 = Updater.constructor-impl(r20);
            Updater.set-impl(r10, r4, r8.getSetMeasurePolicy());
            Updater.set-impl(r10, r6, r8.getSetResolvedCompositionLocals());
            Function2 r14 = r8.getSetCompositeKeyHash();
            if (r10.getInserting() == false) goto L21;
        L22:
            r10.updateRememberedValue(Integer.valueOf(r5));
            r10.apply(Integer.valueOf(r5), r14);
        L23:
            Updater.set-impl(r10, r7, r8.getSetModifier());
            BoxScopeInstance r15 = BoxScopeInstance.INSTANCE;
            r1.invoke(r13, r20, 6);
            boolean r16 = r13.isExpanded();
            Object r17 = r20.rememberedValue();
            if (r17 != Composer.Companion.getEmpty()) goto L26;
            r17 = new p(r13);
            r20.updateRememberedValue(r17);
        L26:
            AndroidMenu_androidKt.m2292DropdownMenuIlH_yew(r16, (Function0) r17, null, 0, null, null, null, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(703704227, true, new AppBarColumnKt$AppBarColumn$2$1$2(r12, r11, r13), r20, 54), r20, 48, 48, 2044);
            r20.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L21:
            if (Intrinsics.areEqual(r10.rememberedValue(), Integer.valueOf(r5)) == true) goto L23;
        L17:
            r20.useNode();
            goto L18
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    private static final Unit AppBarColumn$lambda$5(Function3 r7, Modifier r8, int r9, Function1 r10, int r11, int r12, Composer r13, int r14) {
        AppBarColumn(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function3 r0, Modifier r1, int r2, Function1 r3, int r4, int r5, Composer r6, int r7) {
        return AppBarColumn$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ AppBarColumnScopeImpl b(State r0) {
        return AppBarColumn$lambda$1$lambda$0(r0);
    }

    private static final AppBarColumnScopeImpl AppBarColumn$lambda$1$lambda$0(State r2) {
        AppBarColumnScopeImpl r0 = new AppBarColumnScopeImpl(new AppBarScopeImpl());
        ((Function1) r2.getValue()).invoke(r0);
        return r0;
    }

    private static final AppBarColumnScopeImpl AppBarColumn$lambda$2(State<AppBarColumnScopeImpl> r0) {
        return (AppBarColumnScopeImpl) r0.getValue();
    }

    public static final /* synthetic */ AppBarColumnScopeImpl access$AppBarColumn$lambda$2(State r0) {
        return AppBarColumn$lambda$2(r0);
    }

    public static final void AppBarColumn(final Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> r16, Modifier r17, int r18, final Function1<? super AppBarColumnScope, Unit> r19, Composer r20, final int r21, final int r22) {
        Composer r2 = r20.startRestartGroup(1484836710);
        if ((r22 & 1) == 0) goto L6;
        int r3 = r21 | 6;
    L13:
        int r7 = r22 & 2;
        if (r7 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r8 = r17;
    L24:
        int r9 = r22 & 4;
        if (r9 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        int r11 = r18;
    L36:
        if ((r22 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r15 = true;
        if ((r3 & 1171) == 1170) goto L48;
        boolean r12 = true;
    L50:
        if (r2.shouldExecute(r12, r3 & 1) == false) goto L102;
        if (r7 == 0) goto L53;
        Modifier r10 = Modifier.Companion;
    L54:
        if (r9 == 0) goto L57;
        r11 = Integer.MAX_VALUE;
    L57:
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventStart(1484836710, r3, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:54)");
    L59:
        final State r0 = SnapshotStateKt.rememberUpdatedState(r19, r2, (r3 >> 9) & 14);
        Object r13 = r2.rememberedValue();
        Composer.Companion r14 = Composer.Companion;
        if (r13 != r14.getEmpty()) goto L62;
        r13 = SnapshotStateKt.derivedStateOf(new n(r0));
        r2.updateRememberedValue(r13);
    L62:
        final State r23 = (State) r13;
        Object r1 = r2.rememberedValue();
        if (r1 != r14.getEmpty()) goto L65;
        r1 = new AppBarMenuState();
        r2.updateRememberedValue(r1);
    L65:
        AppBarMenuState r4 = (AppBarMenuState) r1;
        AppBarOverflowState r110 = AppBarDslKt.rememberAppBarOverflowState(r2, 0);
        boolean r111 = r2.changed(r110);
        if ((r3 & 896) != 256) goto L68;
        boolean r112 = true;
    L69:
        boolean r113 = r111 | r112;
        Object r114 = r2.rememberedValue();
        if (r113 == false) goto L72;
    L73:
        r114 = new OverflowMeasurePolicy(r110, r11, true);
        r2.updateRememberedValue(r114);
    L74:
        OverflowMeasurePolicy r115 = (OverflowMeasurePolicy) r114;
        int r5 = (r3 & 112) | 6;
        Function2 r6 = LayoutKt.combineAsVirtualLayouts(CollectionsKt.listOf(new Function2[]{ComposableLambdaKt.rememberComposableLambda(979489399, true, new AnonymousClass1(r23), r2, 54), ComposableLambdaKt.rememberComposableLambda(1681423992, true, new AnonymousClass2(r16, r4, r110, r23), r2, 54)}));
        if (((r5 & 896) ^ 384) <= 256) goto L79;
        if (r2.changed(r115) == false) goto L79;
    L82:
        Object r24 = r2.rememberedValue();
        if (r15 == false) goto L85;
    L86:
        r24 = MultiContentMeasurePolicyKt.createMeasurePolicy(r115);
        r2.updateRememberedValue(r24);
    L87:
        MeasurePolicy r25 = (MeasurePolicy) r24;
        int r26 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r27 = r2.getCurrentCompositionLocalMap();
        Modifier r28 = ComposedModifierKt.materializeModifier(r2, r10);
        ComposeUiNode.Companion r116 = ComposeUiNode.Companion;
        Function0 r117 = r116.getConstructor();
        int r29 = (((r5 & 112) << 6) & 896) | 6;
        if ((r2.getApplier() instanceof Applier) == true) goto L90;
        ComposablesKt.invalidApplier();
    L90:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L93;
        r2.createNode(r117);
    L94:
        Composer r118 = Updater.constructor-impl(r2);
        Updater.set-impl(r118, r25, r116.getSetMeasurePolicy());
        Updater.set-impl(r118, r27, r116.getSetResolvedCompositionLocals());
        Function2 r30 = r116.getSetCompositeKeyHash();
        if (r118.getInserting() == false) goto L97;
    L98:
        r118.updateRememberedValue(Integer.valueOf(r26));
        r118.apply(Integer.valueOf(r26), r30);
    L99:
        Updater.set-impl(r118, r28, r116.getSetModifier());
        r6.invoke(r2, Integer.valueOf((r29 >> 6) & 14));
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventEnd();
    L103:
        final int r31 = r11;
        ScopeUpdateScope r32 = r2.endRestartGroup();
        if (r32 == null) goto L107;
        final Modifier r33 = r10;
        r32.updateScope(new o(r16, r33, r31, r19, r21, r22));
        return;
    L107:
        return;
    L97:
        if (Intrinsics.areEqual(r118.rememberedValue(), Integer.valueOf(r26)) == true) goto L99;
    L93:
        r2.useNode();
        goto L94
    L85:
        if (r24 != r14.getEmpty()) goto L87;
    L79:
        if ((r5 & 384) == 256) goto L82;
        r15 = false;
        goto L82
    L72:
        if (r114 != r14.getEmpty()) goto L74;
    L68:
        r112 = false;
        goto L69
    L53:
        r10 = r8;
        goto L54
    L102:
        r2.skipToGroupEnd();
        r10 = r8;
        goto L103
    L48:
        r12 = false;
        goto L50
    L39:
        if ((r21 & 3072) != 0) goto L45;
        if (r2.changedInstance(r19) == false) goto L43;
        int r119 = 2048;
    L44:
        r3 = r3 | r119;
        goto L45
    L43:
        r119 = 1024;
        goto L44
    L28:
        if ((r21 & 384) != 0) goto L34;
        r11 = r18;
        if (r2.changed(r11) == false) goto L32;
        int r120 = 256;
    L33:
        r3 = r3 | r120;
        goto L36
    L32:
        r120 = 128;
        goto L33
    L17:
        if ((r21 & 48) != 0) goto L23;
        r8 = r17;
        if (r2.changed(r8) == false) goto L21;
        int r34 = 32;
    L22:
        r3 = r3 | r34;
        goto L24
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r21 & 6) == 0) goto L8;
        r3 = r21;
        goto L13
    L8:
        if (r2.changedInstance(r16) == false) goto L10;
        int r35 = 4;
    L11:
        r3 = r35 | r21;
        goto L13
    L10:
        r35 = 2;
        goto L11
    }
}
