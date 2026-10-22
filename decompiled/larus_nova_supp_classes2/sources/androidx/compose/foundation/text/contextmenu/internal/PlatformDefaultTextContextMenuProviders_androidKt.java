package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\f\u0010\u000b\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002"}, d2 = {"ProvideDefaultPlatformTextContextMenuProviders", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ProvideBothDefaultProviders", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlatformDefaultTextContextMenuProviders_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.internal.PlatformDefaultTextContextMenuProviders_androidKt$ProvideBothDefaultProviders$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ BasicTextContextMenuProvider $dropdownProvider;
        final /* synthetic */ MutableState<LayoutCoordinates> $layoutCoordinates$delegate;
        final /* synthetic */ Function0<LayoutCoordinates> $layoutCoordinatesBlock;
        final /* synthetic */ Modifier $modifier;

        public AnonymousClass1(Modifier r1, MutableState<LayoutCoordinates> r2, Function2<? super Composer, ? super Integer, Unit> r3, BasicTextContextMenuProvider r4, Function0<? extends LayoutCoordinates> r5) {
            this.$modifier = r1;
            this.$layoutCoordinates$delegate = r2;
            this.$content = r3;
            this.$dropdownProvider = r4;
            this.$layoutCoordinatesBlock = r5;
        }

        public static /* synthetic */ Unit a(MutableState r0, LayoutCoordinates r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(MutableState r0, LayoutCoordinates r1) {
            PlatformDefaultTextContextMenuProviders_androidKt.access$ProvideBothDefaultProviders$lambda$4(r0, r1);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r11, int r12) {
            if ((r12 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r11.shouldExecute(r0, r12 & 1) == true) goto L9;
            r11.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1070596993, r12, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideBothDefaultProviders.<anonymous> (PlatformDefaultTextContextMenuProviders.android.kt:76)");
        L11:
            Modifier r13 = this.$modifier;
            final MutableState<LayoutCoordinates> r1 = this.$layoutCoordinates$delegate;
            Object r2 = r11.rememberedValue();
            if (r2 != Composer.Companion.getEmpty()) goto L14;
            r2 = new d0(r1);
            r11.updateRememberedValue(r2);
        L14:
            Modifier r14 = OnGloballyPositionedModifierKt.onGloballyPositioned(r13, (Function1) r2);
            Function2<Composer, Integer, Unit> r3 = this.$content;
            BasicTextContextMenuProvider r4 = this.$dropdownProvider;
            Function0<LayoutCoordinates> r5 = this.$layoutCoordinatesBlock;
            MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            long r7 = ComposablesKt.getCurrentCompositeKeyHashCode(r11, 0);
            int r8 = (int) (r7 ^ (r7 >>> 32));
            CompositionLocalMap r9 = r11.getCurrentCompositionLocalMap();
            Modifier r15 = ComposedModifierKt.materializeModifier(r11, r14);
            ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
            Function0 r16 = r10.getConstructor();
            if ((r11.getApplier() instanceof Applier) == true) goto L17;
            ComposablesKt.invalidApplier();
        L17:
            r11.startReusableNode();
            if (r11.getInserting() == false) goto L20;
            r11.createNode(r16);
        L21:
            Composer r17 = Updater.constructor-impl(r11);
            Updater.set-impl(r17, r6, r10.getSetMeasurePolicy());
            Updater.set-impl(r17, r9, r10.getSetResolvedCompositionLocals());
            Function2 r18 = r10.getSetCompositeKeyHash();
            if (r17.getInserting() == false) goto L24;
        L25:
            r17.updateRememberedValue(Integer.valueOf(r8));
            r17.apply(Integer.valueOf(r8), r18);
        L26:
            Updater.set-impl(r17, r15, r10.getSetModifier());
            BoxScopeInstance r19 = BoxScopeInstance.INSTANCE;
            r3.invoke(r11, 0);
            r4.ContextMenu(r5, r11, 6);
            r11.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L24:
            if (Intrinsics.areEqual(r17.rememberedValue(), Integer.valueOf(r8)) == true) goto L26;
        L20:
            r11.useNode();
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

    private static final Unit ProvideBothDefaultProviders$lambda$7(Modifier r0, Function2 r1, int r2, Composer r3, int r4) {
        ProvideBothDefaultProviders(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ProvideDefaultPlatformTextContextMenuProviders$lambda$1(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        ProvideDefaultPlatformTextContextMenuProviders(r0, r1, r4, RecomposeScopeImplKt.updateChangedFlags(r2 | 1), r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        return ProvideDefaultPlatformTextContextMenuProviders$lambda$1(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ LayoutCoordinates b(MutableState r0) {
        return ProvideBothDefaultProviders$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit c(Modifier r0, Function2 r1, int r2, Composer r3, int r4) {
        return ProvideBothDefaultProviders$lambda$7(r0, r1, r2, r3, r4);
    }

    private static final LayoutCoordinates ProvideBothDefaultProviders$lambda$3(MutableState<LayoutCoordinates> r0) {
        return (LayoutCoordinates) r0.getValue();
    }

    private static final LayoutCoordinates ProvideBothDefaultProviders$lambda$6$lambda$5(MutableState r0) {
        LayoutCoordinates r1 = ProvideBothDefaultProviders$lambda$3(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    private static final void ProvideBothDefaultProviders$lambda$4(MutableState<LayoutCoordinates> r0, LayoutCoordinates r1) {
        r0.setValue(r1);
    }

    public static final /* synthetic */ void access$ProvideBothDefaultProviders$lambda$4(MutableState r0, LayoutCoordinates r1) {
        ProvideBothDefaultProviders$lambda$4(r0, r1);
    }

    private static final void ProvideBothDefaultProviders(final Modifier r15, final Function2<? super Composer, ? super Integer, Unit> r16, Composer r17, final int r18) {
        Composer r9 = r17.startRestartGroup(790527681);
        if ((r18 & 6) == 0) goto L5;
        int r1 = r18;
    L11:
        if ((r18 & 48) != 0) goto L18;
        if (r9.changedInstance(r16) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r4 = true;
    L22:
        if (r9.shouldExecute(r4, r1 & 1) == true) goto L24;
        r9.skipToGroupEnd();
    L36:
        ScopeUpdateScope r0 = r9.endRestartGroup();
        if (r0 == null) goto L40;
        r0.updateScope(new b0(r15, r16, r18));
        return;
    L40:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(790527681, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideBothDefaultProviders (PlatformDefaultTextContextMenuProviders.android.kt:58)");
    L26:
        Object r2 = r9.rememberedValue();
        Composer.Companion r5 = Composer.Companion;
        if (r2 != r5.getEmpty()) goto L29;
        r2 = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        r9.updateRememberedValue(r2);
    L29:
        final MutableState r6 = (MutableState) r2;
        Object r7 = r9.rememberedValue();
        if (r7 != r5.getEmpty()) goto L32;
        r7 = new a0(r6);
        r9.updateRememberedValue(r7);
    L32:
        Function0 r11 = (Function0) r7;
        BasicTextContextMenuProvider r12 = DefaultTextContextMenuDropdownProvider_androidKt.defaultTextContextMenuDropdown(r9, 0);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider().provides(AndroidTextContextMenuToolbarProvider_androidKt.platformTextContextMenuToolbarProvider(r11, null, r9, 6, 2)), TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider().provides(r12)}, ComposableLambdaKt.rememberComposableLambda(1070596993, true, new AnonymousClass1(r15, r6, r16, r12, r11), r9, 54), r9, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
        goto L36
    L20:
        r4 = false;
        goto L22
    L5:
        if (r9.changed(r15) == false) goto L7;
        int r8 = 4;
    L8:
        r1 = r8 | r18;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }

    public static final void ProvideDefaultPlatformTextContextMenuProviders(final Modifier r8, final Function2<? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(155925518);
        int r1 = r12 & 1;
        if (r1 == 0) goto L6;
        int r2 = r11 | 6;
    L14:
        if ((r12 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r2 & 19) == 18) goto L26;
        boolean r3 = true;
    L28:
        if (r13.shouldExecute(r3, r2 & 1) == false) goto L65;
        if (r1 == 0) goto L32;
        r8 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventStart(155925518, r2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultPlatformTextContextMenuProviders (PlatformDefaultTextContextMenuProviders.android.kt:37)");
    L35:
        if (r13.consume(TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider()) == null) goto L37;
        boolean r0 = true;
    L39:
        if (r13.consume(TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider()) == null) goto L41;
        boolean r4 = true;
    L42:
        if (r0 == false) goto L57;
        if (r4 == false) goto L57;
        r13.startReplaceGroup(-1977156178);
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r7 = (int) ((r6 >>> 32) ^ r6);
        CompositionLocalMap r14 = r13.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r13, r8);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L47;
        ComposablesKt.invalidApplier();
    L47:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L50;
        r13.createNode(r17);
    L51:
        Composer r18 = Updater.constructor-impl(r13);
        Updater.set-impl(r18, r5, r16.getSetMeasurePolicy());
        Updater.set-impl(r18, r14, r16.getSetResolvedCompositionLocals());
        Function2 r19 = r16.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L54;
    L55:
        r18.updateRememberedValue(Integer.valueOf(r7));
        r18.apply(Integer.valueOf(r7), r19);
    L56:
        Updater.set-impl(r18, r15, r16.getSetModifier());
        BoxScopeInstance r20 = BoxScopeInstance.INSTANCE;
        r9.invoke(r13, Integer.valueOf((r2 >> 3) & 14));
        r13.endNode();
        r13.endReplaceGroup();
    L63:
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        ScopeUpdateScope r110 = r13.endRestartGroup();
        if (r110 == null) goto L70;
        r110.updateScope(new c0(r8, r9, r11, r12));
        return;
    L70:
        return;
    L54:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r7)) == true) goto L56;
    L50:
        r13.useNode();
    L57:
        if (r0 == false) goto L59;
        r13.startReplaceGroup(-1976965962);
        AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar(r8, r9, r13, (r2 & 14) | (r2 & 112), 0);
        r13.endReplaceGroup();
        goto L63
    L59:
        if (r4 == false) goto L61;
        r13.startReplaceGroup(-1976815178);
        DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(r8, r9, r13, (r2 & 14) | (r2 & 112));
        r13.endReplaceGroup();
        goto L63
    L61:
        r13.startReplaceGroup(-1976684761);
        ProvideBothDefaultProviders(r8, r9, r13, (r2 & 14) | (r2 & 112));
        r13.endReplaceGroup();
        goto L63
    L41:
        r4 = false;
        goto L42
    L37:
        r0 = false;
        goto L39
    L65:
        r13.skipToGroupEnd();
        goto L66
    L26:
        r3 = false;
        goto L28
    L17:
        if ((r11 & 48) != 0) goto L24;
        if (r13.changedInstance(r9) == false) goto L21;
        int r21 = 32;
    L22:
        r2 = r2 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r11 & 6) == 0) goto L8;
        r2 = r11;
        goto L14
    L8:
        if (r13.changed(r8) == false) goto L10;
        int r22 = 4;
    L11:
        r2 = r22 | r11;
        goto L14
    L10:
        r22 = 2;
        goto L11
    }
}
