package androidx.compose.foundation.text.contextmenu.provider;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032V\u0010\u0005\u001aR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0012\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032V\u0010\u0005\u001aR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0015\u001ae\u0010\u0016\u001a\u00020\u00172V\u0010\u0005\u001aR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018¨\u0006\u0019²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"ProvideBasicTextContextMenu", "", "providableCompositionLocal", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "contextMenu", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "session", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "dataProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "anchorLayoutCoordinates", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/ProvidableCompositionLocal;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "basicTextContextMenuProvider", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "(Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "foundation_release", "layoutCoordinates"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTextContextMenuProviderKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ MutableState<LayoutCoordinates> $layoutCoordinates$delegate;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ BasicTextContextMenuProvider $provider;

        public AnonymousClass2(Modifier r1, MutableState<LayoutCoordinates> r2, Function2<? super Composer, ? super Integer, Unit> r3, BasicTextContextMenuProvider r4) {
            this.$modifier = r1;
            this.$layoutCoordinates$delegate = r2;
            this.$content = r3;
            this.$provider = r4;
        }

        public static /* synthetic */ LayoutCoordinates a(MutableState r0) {
            return invoke$lambda$4$lambda$3$lambda$2(r0);
        }

        public static /* synthetic */ Unit b(MutableState r0, LayoutCoordinates r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final LayoutCoordinates invoke$lambda$4$lambda$3$lambda$2(MutableState r0) {
            LayoutCoordinates r1 = BasicTextContextMenuProviderKt.access$ProvideBasicTextContextMenu$lambda$2(r0);
            if (r1 == null) goto L5;
            return r1;
        L5:
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
            throw new KotlinNothingValueException();
        }

        private static final Unit invoke$lambda$1$lambda$0(MutableState r0, LayoutCoordinates r1) {
            BasicTextContextMenuProviderKt.access$ProvideBasicTextContextMenu$lambda$3(r0, r1);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r12, int r13) {
            if ((r13 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r12.shouldExecute(r0, r13 & 1) == true) goto L9;
            r12.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(274270255, r13, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu.<anonymous> (BasicTextContextMenuProvider.kt:87)");
        L11:
            Modifier r14 = this.$modifier;
            final MutableState<LayoutCoordinates> r1 = this.$layoutCoordinates$delegate;
            Object r2 = r12.rememberedValue();
            Composer.Companion r4 = Composer.Companion;
            if (r2 != r4.getEmpty()) goto L14;
            r2 = new f(r1);
            r12.updateRememberedValue(r2);
        L14:
            Modifier r15 = OnGloballyPositionedModifierKt.onGloballyPositioned(r14, (Function1) r2);
            Function2<Composer, Integer, Unit> r3 = this.$content;
            BasicTextContextMenuProvider r5 = this.$provider;
            final MutableState<LayoutCoordinates> r6 = this.$layoutCoordinates$delegate;
            MeasurePolicy r7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            long r8 = ComposablesKt.getCurrentCompositeKeyHashCode(r12, 0);
            int r9 = (int) (r8 ^ (r8 >>> 32));
            CompositionLocalMap r10 = r12.getCurrentCompositionLocalMap();
            Modifier r16 = ComposedModifierKt.materializeModifier(r12, r15);
            ComposeUiNode.Companion r11 = ComposeUiNode.Companion;
            Function0 r17 = r11.getConstructor();
            if ((r12.getApplier() instanceof Applier) == true) goto L17;
            ComposablesKt.invalidApplier();
        L17:
            r12.startReusableNode();
            if (r12.getInserting() == false) goto L20;
            r12.createNode(r17);
        L21:
            Composer r18 = Updater.constructor-impl(r12);
            Updater.set-impl(r18, r7, r11.getSetMeasurePolicy());
            Updater.set-impl(r18, r10, r11.getSetResolvedCompositionLocals());
            Function2 r19 = r11.getSetCompositeKeyHash();
            if (r18.getInserting() == false) goto L24;
        L25:
            r18.updateRememberedValue(Integer.valueOf(r9));
            r18.apply(Integer.valueOf(r9), r19);
        L26:
            Updater.set-impl(r18, r16, r11.getSetModifier());
            BoxScopeInstance r110 = BoxScopeInstance.INSTANCE;
            r3.invoke(r12, 0);
            Object r111 = r12.rememberedValue();
            if (r111 != r4.getEmpty()) goto L29;
            r111 = new g(r6);
            r12.updateRememberedValue(r111);
        L29:
            r5.ContextMenu((Function0) r111, r12, 6);
            r12.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L34;
            ComposerKt.traceEventEnd();
            return;
        L34:
            return;
        L24:
            if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r9)) == true) goto L26;
        L20:
            r12.useNode();
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

    private static final Unit ProvideBasicTextContextMenu$lambda$0(ProvidableCompositionLocal r0, Function5 r1, Function2 r2, int r3, Composer r4, int r5) {
        ProvideBasicTextContextMenu(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ProvideBasicTextContextMenu$lambda$4(Modifier r6, ProvidableCompositionLocal r7, Function5 r8, Function2 r9, int r10, Composer r11, int r12) {
        ProvideBasicTextContextMenu(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DisposableEffectResult a(BasicTextContextMenuProvider r0, DisposableEffectScope r1) {
        return basicTextContextMenuProvider$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit b(ProvidableCompositionLocal r0, Function5 r1, Function2 r2, int r3, Composer r4, int r5) {
        return ProvideBasicTextContextMenu$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(Modifier r0, ProvidableCompositionLocal r1, Function5 r2, Function2 r3, int r4, Composer r5, int r6) {
        return ProvideBasicTextContextMenu$lambda$4(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final LayoutCoordinates ProvideBasicTextContextMenu$lambda$2(MutableState<LayoutCoordinates> r0) {
        return (LayoutCoordinates) r0.getValue();
    }

    public static final /* synthetic */ LayoutCoordinates access$ProvideBasicTextContextMenu$lambda$2(MutableState r0) {
        return ProvideBasicTextContextMenu$lambda$2(r0);
    }

    private static final void ProvideBasicTextContextMenu$lambda$3(MutableState<LayoutCoordinates> r0, LayoutCoordinates r1) {
        r0.setValue(r1);
    }

    public static final /* synthetic */ void access$ProvideBasicTextContextMenu$lambda$3(MutableState r0, LayoutCoordinates r1) {
        ProvideBasicTextContextMenu$lambda$3(r0, r1);
    }

    private static final DisposableEffectResult basicTextContextMenuProvider$lambda$8$lambda$7(final BasicTextContextMenuProvider r0, DisposableEffectScope r1) {
        return new BasicTextContextMenuProviderKt$basicTextContextMenuProvider$lambda$8$lambda$7$$inlined$onDispose$1(r0);
    }

    public static final BasicTextContextMenuProvider basicTextContextMenuProvider(Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(100861460, r5, -1, "androidx.compose.foundation.text.contextmenu.provider.basicTextContextMenuProvider (BasicTextContextMenuProvider.kt:106)");
    L6:
        if (((r5 & 14) ^ 6) <= 4) goto L10;
        if (r4.changed(r3) == false) goto L10;
    L11:
        boolean r6 = true;
    L13:
        Object r0 = r4.rememberedValue();
        if (r6 == false) goto L16;
    L17:
        r0 = new BasicTextContextMenuProvider(r3);
        r4.updateRememberedValue(r0);
    L18:
        final BasicTextContextMenuProvider r1 = (BasicTextContextMenuProvider) r0;
        boolean r7 = r4.changed(r1);
        Object r8 = r4.rememberedValue();
        if (r7 == false) goto L21;
    L22:
        r8 = new d(r1);
        r4.updateRememberedValue(r8);
    L23:
        EffectsKt.DisposableEffect(r1, (Function1) r8, r4, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
    L26:
        return r1;
    L21:
        if (r8 != Composer.Companion.getEmpty()) goto L23;
    L16:
        if (r0 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r5 & 6) == 4) goto L11;
        r6 = false;
        goto L13
    }

    public static final void ProvideBasicTextContextMenu(final ProvidableCompositionLocal<TextContextMenuProvider> r7, final Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> r8, final Function2<? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(2072681886);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r11 & 48) != 0) goto L18;
        if (r12.changedInstance(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r11 & 384) != 0) goto L25;
        if (r12.changedInstance(r9) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r12.shouldExecute(r4, r1 & 1) == true) goto L31;
        r12.skipToGroupEnd();
    L37:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L41;
        r13.updateScope(new e(r7, r8, r9, r11));
        return;
    L41:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(2072681886, r1, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu (BasicTextContextMenuProvider.kt:64)");
    L33:
        int r5 = r1 << 3;
        ProvideBasicTextContextMenu(Modifier.Companion, r7, r8, r9, r12, (((r5 & 112) | 6) | (r5 & 896)) | (r5 & 7168));
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        goto L37
    L27:
        r4 = false;
        goto L29
    L5:
        if (r12.changed(r7) == false) goto L7;
        int r6 = 4;
    L8:
        r1 = r6 | r11;
        goto L11
    L7:
        r6 = 2;
        goto L8
    }

    public static final void ProvideBasicTextContextMenu(final Modifier r7, final ProvidableCompositionLocal<TextContextMenuProvider> r8, final Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-714464401);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changed(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changedInstance(r9) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r12 & 3072) != 0) goto L32;
        if (r13.changedInstance(r10) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r1 & 1171) == 1170) goto L34;
        boolean r5 = true;
    L36:
        if (r13.shouldExecute(r5, r1 & 1) == true) goto L38;
        r13.skipToGroupEnd();
    L47:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L51;
        r14.updateScope(new c(r7, r8, r9, r10, r12));
        return;
    L51:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-714464401, r1, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu (BasicTextContextMenuProvider.kt:80)");
    L40:
        Object r0 = r13.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L43;
        r0 = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        r13.updateRememberedValue(r0);
    L43:
        BasicTextContextMenuProvider r6 = basicTextContextMenuProvider(r9, r13, (r1 >> 6) & 14);
        CompositionLocalKt.CompositionLocalProvider(r8.provides(r6), ComposableLambdaKt.rememberComposableLambda(274270255, true, new AnonymousClass2(r7, (MutableState) r0, r10, r6), r13, 54), r13, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventEnd();
        goto L47
    L34:
        r5 = false;
        goto L36
    L5:
        if (r13.changed(r7) == false) goto L7;
        int r15 = 4;
    L8:
        r1 = r15 | r12;
        goto L11
    L7:
        r15 = 2;
        goto L8
    }
}
