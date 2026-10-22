package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultNavigationRailOverride;", "Landroidx/compose/material3/NavigationRailOverride;", "<init>", "()V", "NavigationRail", "", "Landroidx/compose/material3/NavigationRailOverrideScope;", "(Landroidx/compose/material3/NavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultNavigationRailOverride implements NavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultNavigationRailOverride INSTANCE = null;

    /* JADX INFO: renamed from: androidx.compose.material3.DefaultNavigationRailOverride$NavigationRail$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ NavigationRailOverrideScope $this_NavigationRail;

        public AnonymousClass1(NavigationRailOverrideScope r1) {
            this.$this_NavigationRail = r1;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r1) {
            SemanticsPropertiesKt.setTraversalGroup(r1, true);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r9, int r10) {
            if ((r10 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r9.shouldExecute(r0, r10 & 1) == true) goto L9;
            r9.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-1027527987, r10, -1, "androidx.compose.material3.DefaultNavigationRailOverride.NavigationRail.<anonymous> (NavigationRail.kt:149)");
        L11:
            Modifier.Companion r11 = Modifier.Companion;
            Modifier r1 = SelectableGroupKt.selectableGroup(PaddingKt.m962paddingVpY3zN4$default(SizeKt.m1021widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(r11, MenuKt.ClosedAlphaTarget, 1, null), this.$this_NavigationRail.getWindowInsets()), NavigationRailCollapsedTokens.INSTANCE.getNarrowContainerWidth-D9Ej5fM(), MenuKt.ClosedAlphaTarget, 2, null), MenuKt.ClosedAlphaTarget, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
            Object r3 = r9.rememberedValue();
            if (r3 != Composer.Companion.getEmpty()) goto L14;
            r3 = new m8();
            r9.updateRememberedValue(r3);
        L14:
            Modifier r2 = SemanticsModifierKt.semantics$default(r1, false, (Function1) r3, 1, null);
            Alignment.Horizontal r4 = Alignment.Companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical r5 = Arrangement.INSTANCE.m806spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
            NavigationRailOverrideScope r6 = this.$this_NavigationRail;
            MeasurePolicy r7 = ColumnKt.columnMeasurePolicy(r5, r4, r9, 54);
            int r8 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
            CompositionLocalMap r12 = r9.getCurrentCompositionLocalMap();
            Modifier r13 = ComposedModifierKt.materializeModifier(r9, r2);
            ComposeUiNode.Companion r14 = ComposeUiNode.Companion;
            Function0 r15 = r14.getConstructor();
            if ((r9.getApplier() instanceof Applier) == true) goto L17;
            ComposablesKt.invalidApplier();
        L17:
            r9.startReusableNode();
            if (r9.getInserting() == false) goto L20;
            r9.createNode(r15);
        L21:
            Composer r16 = Updater.constructor-impl(r9);
            Updater.set-impl(r16, r7, r14.getSetMeasurePolicy());
            Updater.set-impl(r16, r12, r14.getSetResolvedCompositionLocals());
            Function2 r17 = r14.getSetCompositeKeyHash();
            if (r16.getInserting() == false) goto L24;
        L25:
            r16.updateRememberedValue(Integer.valueOf(r8));
            r16.apply(Integer.valueOf(r8), r17);
        L26:
            Updater.set-impl(r16, r13, r14.getSetModifier());
            ColumnScopeInstance r18 = ColumnScopeInstance.INSTANCE;
            Function3<ColumnScope, Composer, Integer, Unit> r19 = r6.getHeader();
            if (r19 == null) goto L29;
            r9.startReplaceGroup(-548298554);
            r19.invoke(r18, r9, 6);
            SpacerKt.Spacer(SizeKt.m1000height3ABfNKs(r11, NavigationRailKt.access$getNavigationRailHeaderPadding$p()), r9, 6);
            r9.endReplaceGroup();
        L30:
            r6.getContent().invoke(r18, r9, 6);
            r9.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L35;
            ComposerKt.traceEventEnd();
            return;
        L35:
            return;
        L29:
            r9.startReplaceGroup(-548182273);
            r9.endReplaceGroup();
            goto L30
        L24:
            if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r8)) == true) goto L26;
        L20:
            r9.useNode();
            goto L21
        L5:
            r0 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new DefaultNavigationRailOverride();
    }

    private DefaultNavigationRailOverride() {
    }

    private static final Unit NavigationRail$lambda$0(DefaultNavigationRailOverride r0, NavigationRailOverrideScope r1, int r2, Composer r3, int r4) {
        r0.NavigationRail(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DefaultNavigationRailOverride r0, NavigationRailOverrideScope r1, int r2, Composer r3, int r4) {
        return NavigationRail$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.material3.NavigationRailOverride
    public void NavigationRail(final NavigationRailOverrideScope r18, Composer r19, final int r20) {
        Composer r15 = r19.startRestartGroup(-433653496);
        if ((r20 & 6) == 0) goto L5;
        int r3 = r20;
    L11:
        if ((r3 & 3) == 2) goto L13;
        boolean r4 = true;
    L15:
        if (r15.shouldExecute(r4, r3 & 1) == true) goto L17;
        Composer r2 = r15;
        r2.skipToGroupEnd();
    L23:
        ScopeUpdateScope r5 = r2.endRestartGroup();
        if (r5 == null) goto L27;
        r5.updateScope(new l8(this, r18, r20));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-433653496, r3, -1, "androidx.compose.material3.DefaultNavigationRailOverride.NavigationRail (NavigationRail.kt:147)");
    L19:
        long r7 = r18.m2966getContainerColor0d7_KjU();
        long r9 = r18.m2967getContentColor0d7_KjU();
        r2 = r15;
        SurfaceKt.m3213SurfaceT9BRK9s(r18.getModifier(), null, r7, r9, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(-1027527987, true, new AnonymousClass1(r18), r15, 54), r15, 12582912, 114);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r4 = false;
        goto L15
    L5:
        if (r15.changed(r18) == false) goto L7;
        int r6 = 4;
    L8:
        r3 = r6 | r20;
        goto L11
    L7:
        r6 = 2;
        goto L8
    }
}
