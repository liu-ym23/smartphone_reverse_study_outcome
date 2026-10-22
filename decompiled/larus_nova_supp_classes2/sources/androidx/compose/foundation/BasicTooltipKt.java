package androidx.compose.foundation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000f\u001a:\u0010\u0010\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0011\u001a@\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a+\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a&\u0010!\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¨\u0006\""}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", "enabled", "anchorSemantics", "label", "", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BasicTooltipState;", "BasicTooltipState", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTooltipKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$TooltipPopup$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ String $tooltipDescription;

        public AnonymousClass2(String r1, Function2<? super Composer, ? super Integer, Unit> r2) {
            this.$tooltipDescription = r1;
            this.$content = r2;
        }

        public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(String r1, SemanticsPropertyReceiver r2) {
            SemanticsPropertiesKt.setLiveRegion-hR3wRGc(r2, LiveRegionMode.Companion.getAssertive-0phEisY());
            SemanticsPropertiesKt.setPaneTitle(r2, r1);
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
            ComposerKt.traceEventStart(916917707, r10, -1, "androidx.compose.foundation.TooltipPopup.<anonymous> (BasicTooltip.kt:144)");
        L11:
            Modifier.Companion r11 = Modifier.Companion;
            boolean r1 = r9.changed(this.$tooltipDescription);
            final String r2 = this.$tooltipDescription;
            Object r4 = r9.rememberedValue();
            if (r1 == false) goto L14;
        L15:
            r4 = new u(r2);
            r9.updateRememberedValue(r4);
        L16:
            Modifier r12 = SemanticsModifierKt.semantics$default(r11, false, (Function1) r4, 1, null);
            Function2<Composer, Integer, Unit> r3 = this.$content;
            MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
            int r7 = (int) (r6 ^ (r6 >>> 32));
            CompositionLocalMap r8 = r9.getCurrentCompositionLocalMap();
            Modifier r13 = ComposedModifierKt.materializeModifier(r9, r12);
            ComposeUiNode.Companion r14 = ComposeUiNode.Companion;
            Function0 r15 = r14.getConstructor();
            if ((r9.getApplier() instanceof Applier) == true) goto L19;
            ComposablesKt.invalidApplier();
        L19:
            r9.startReusableNode();
            if (r9.getInserting() == false) goto L22;
            r9.createNode(r15);
        L23:
            Composer r16 = Updater.constructor-impl(r9);
            Updater.set-impl(r16, r5, r14.getSetMeasurePolicy());
            Updater.set-impl(r16, r8, r14.getSetResolvedCompositionLocals());
            Function2 r17 = r14.getSetCompositeKeyHash();
            if (r16.getInserting() == false) goto L26;
        L27:
            r16.updateRememberedValue(Integer.valueOf(r7));
            r16.apply(Integer.valueOf(r7), r17);
        L28:
            Updater.set-impl(r16, r13, r14.getSetModifier());
            BoxScopeInstance r18 = BoxScopeInstance.INSTANCE;
            r3.invoke(r9, 0);
            r9.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L33;
            ComposerKt.traceEventEnd();
            return;
        L33:
            return;
        L26:
            if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r7)) == true) goto L28;
        L22:
            r9.useNode();
            goto L23
        L14:
            if (r4 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r0 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    private static final Unit BasicTooltipBox$lambda$4(PopupPositionProvider r11, Function2 r12, BasicTooltipState r13, Modifier r14, boolean r15, boolean r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        BasicTooltipBox(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit TooltipPopup$lambda$9(PopupPositionProvider r7, BasicTooltipState r8, CoroutineScope r9, boolean r10, Function2 r11, int r12, Composer r13, int r14) {
        TooltipPopup(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit WrappedAnchor$lambda$6(boolean r7, BasicTooltipState r8, Modifier r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        WrappedAnchor(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DisposableEffectResult a(BasicTooltipState r0, DisposableEffectScope r1) {
        return BasicTooltipBox$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ boolean b(CoroutineScope r0, BasicTooltipState r1) {
        return anchorSemantics$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit c(boolean r0, BasicTooltipState r1, Modifier r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return WrappedAnchor$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit d(String r0, CoroutineScope r1, BasicTooltipState r2, SemanticsPropertyReceiver r3) {
        return anchorSemantics$lambda$11(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(BasicTooltipState r0, CoroutineScope r1) {
        return TooltipPopup$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit f(PopupPositionProvider r0, Function2 r1, BasicTooltipState r2, Modifier r3, boolean r4, boolean r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return BasicTooltipBox$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit g(PopupPositionProvider r0, BasicTooltipState r1, CoroutineScope r2, boolean r3, Function2 r4, int r5, Composer r6, int r7) {
        return TooltipPopup$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final DisposableEffectResult BasicTooltipBox$lambda$3$lambda$2(final BasicTooltipState r0, DisposableEffectScope r1) {
        return new BasicTooltipKt$BasicTooltipBox$lambda$3$lambda$2$$inlined$onDispose$1(r0);
    }

    private static final Unit TooltipPopup$lambda$8$lambda$7(BasicTooltipState r7, CoroutineScope r8) {
        if (r7.isVisible() == false) goto L6;
        BuildersKt.launch$default(r8, null, null, new BasicTooltipKt$TooltipPopup$1$1$1(r7, null), 3, null);
    L6:
        return Unit.INSTANCE;
    }

    private static final boolean anchorSemantics$lambda$11$lambda$10(CoroutineScope r6, BasicTooltipState r7) {
        BuildersKt.launch$default(r6, null, null, new BasicTooltipKt$anchorSemantics$1$1$1(r7, null), 3, null);
        return true;
    }

    public static final BasicTooltipState BasicTooltipState(boolean r1, boolean r2, MutatorMutex r3) {
        return new BasicTooltipStateImpl(r1, r2, r3);
    }

    private static final Modifier handleGestures(Modifier r0, boolean r1, final BasicTooltipState r2) {
        if (r1 == true) goto L4;
        return r0;
    L4:
        return SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(r0, r2, new AnonymousClass1(r2)), r2, new C01252(r2));
    }

    private static final Unit anchorSemantics$lambda$11(String r1, final CoroutineScope r2, final BasicTooltipState r3, SemanticsPropertyReceiver r4) {
        SemanticsPropertiesKt.onLongClick(r4, r1, new n(r2, r3));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ BasicTooltipState BasicTooltipState$default(boolean r0, boolean r1, MutatorMutex r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = false;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = true;
    L9:
        if ((r3 & 4) == 0) goto L12;
        r2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
    L12:
        return BasicTooltipState(r0, r1, r2);
    }

    private static final Modifier anchorSemantics(Modifier r0, final String r1, boolean r2, final BasicTooltipState r3, final CoroutineScope r4) {
        if (r2 == true) goto L4;
        return r0;
    L4:
        return SemanticsModifierKt.semantics(r0, true, new q(r1, r4, r3));
    }

    public static final BasicTooltipState rememberBasicTooltipState(boolean r4, boolean r5, MutatorMutex r6, Composer r7, int r8, int r9) {
        boolean r1 = false;
        if ((r9 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = true;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r6 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventStart(1123859613, r8, -1, "androidx.compose.foundation.rememberBasicTooltipState (BasicTooltip.kt:245)");
    L15:
        if (((r8 & 112) ^ 48) <= 32) goto L19;
        if (r7.changed(r5) == false) goto L19;
    L20:
        boolean r10 = true;
    L23:
        if (((r8 & 896) ^ 384) <= 256) goto L27;
        if (r7.changed(r6) == false) goto L27;
    L28:
        r1 = true;
    L29:
        boolean r11 = r10 | r1;
        Object r12 = r7.rememberedValue();
        if (r11 == false) goto L32;
    L33:
        r12 = new BasicTooltipStateImpl(r4, r5, r6);
        r7.updateRememberedValue(r12);
    L34:
        BasicTooltipStateImpl r13 = (BasicTooltipStateImpl) r12;
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r13;
    L32:
        if (r12 != Composer.Companion.getEmpty()) goto L34;
    L27:
        if ((r8 & 384) != 256) goto L29;
    L19:
        if ((r8 & 48) == 32) goto L20;
        r10 = false;
        goto L23
    }

    private static final void TooltipPopup(final PopupPositionProvider r19, final BasicTooltipState r20, final CoroutineScope r21, final boolean r22, final Function2<? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25) {
        Composer r1 = r24.startRestartGroup(-1882542163);
        if ((r25 & 6) == 0) goto L5;
        int r7 = r25;
    L11:
        if ((r25 & 48) != 0) goto L18;
        if (r1.changed(r20) == false) goto L15;
        int r8 = 32;
    L16:
        r7 = r7 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r25 & 384) != 0) goto L25;
        if (r1.changedInstance(r21) == false) goto L22;
        int r9 = 256;
    L23:
        r7 = r7 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r25 & 3072) != 0) goto L33;
        if (r1.changed(r22) == false) goto L29;
        int r10 = 2048;
    L30:
        r7 = r7 | r10;
        goto L33
    L29:
        r10 = 1024;
    L33:
        if ((r25 & 24576) == 0) goto L35;
    L39:
        boolean r12 = false;
        if ((r7 & 9363) == 9362) goto L42;
        boolean r11 = true;
    L44:
        if (r1.shouldExecute(r11, r7 & 1) == true) goto L46;
        r1.skipToGroupEnd();
    L60:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L64;
        r13.updateScope(new t(r19, r20, r21, r22, r23, r25));
        return;
    L64:
        return;
    L46:
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventStart(-1882542163, r7, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.kt:133)");
    L48:
        String r0 = BasicTooltipStrings.INSTANCE.description(r1, 6);
        if ((r7 & 112) != 32) goto L51;
        r12 = true;
    L51:
        boolean r14 = r1.changedInstance(r21) | r12;
        Object r15 = r1.rememberedValue();
        if (r14 == false) goto L54;
    L55:
        r15 = new s(r20, r21);
        r1.updateRememberedValue(r15);
    L56:
        AndroidPopup_androidKt.Popup(r19, (Function0) r15, new PopupProperties(r22, false, false, false, 14, null), ComposableLambdaKt.rememberComposableLambda(916917707, true, new AnonymousClass2(r0, r23), r1, 54), r1, (r7 & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
        goto L60
    L54:
        if (r15 != Composer.Companion.getEmpty()) goto L56;
    L42:
        r11 = false;
        goto L44
    L35:
        if (r1.changedInstance(r23) == false) goto L37;
        int r16 = 16384;
    L38:
        r7 = r7 | r16;
        goto L39
    L37:
        r16 = 8192;
        goto L38
    L5:
        if (r1.changed(r19) == false) goto L7;
        int r17 = 4;
    L8:
        r7 = r17 | r25;
        goto L11
    L7:
        r17 = 2;
        goto L8
    }

    private static final void WrappedAnchor(final boolean r8, final BasicTooltipState r9, Modifier r10, final Function2<? super Composer, ? super Integer, Unit> r11, Composer r12, final int r13, final int r14) {
        Composer r15 = r12.startRestartGroup(1381511093);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L14:
        if ((r14 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r14 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r14 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r1 & 1171) == 1170) goto L46;
        boolean r4 = true;
    L48:
        if (r15.shouldExecute(r4, r1 & 1) == false) goto L72;
        if (r2 == 0) goto L52;
        r10 = Modifier.Companion;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(1381511093, r1, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.kt:112)");
    L54:
        Object r0 = r15.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L57;
        r0 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r15);
        r15.updateRememberedValue(r0);
    L57:
        String r3 = BasicTooltipStrings.INSTANCE.label(r15, 6);
        Modifier r5 = handleGestures(r10, r8, r9);
        Modifier r6 = anchorSemantics(r5, r3, r8, r9, (CoroutineScope) r0);
        MeasurePolicy r7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r17 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r18 = r15.getCurrentCompositionLocalMap();
        Modifier r19 = ComposedModifierKt.materializeModifier(r15, r6);
        ComposeUiNode.Companion r20 = ComposeUiNode.Companion;
        Function0 r21 = r20.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L60;
        ComposablesKt.invalidApplier();
    L60:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L63;
        r15.createNode(r21);
    L64:
        Composer r22 = Updater.constructor-impl(r15);
        Updater.set-impl(r22, r7, r20.getSetMeasurePolicy());
        Updater.set-impl(r22, r18, r20.getSetResolvedCompositionLocals());
        Function2 r23 = r20.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L67;
    L68:
        r22.updateRememberedValue(Integer.valueOf(r17));
        r22.apply(Integer.valueOf(r17), r23);
    L69:
        Updater.set-impl(r22, r19, r20.getSetModifier());
        BoxScopeInstance r24 = BoxScopeInstance.INSTANCE;
        r11.invoke(r15, Integer.valueOf((r1 >> 9) & 14));
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventEnd();
    L73:
        final Modifier r25 = r10;
        ScopeUpdateScope r110 = r15.endRestartGroup();
        if (r110 == null) goto L77;
        r110.updateScope(new m(r8, r9, r25, r11, r13, r14));
        return;
    L77:
        return;
    L67:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r17)) == true) goto L69;
    L63:
        r15.useNode();
        goto L64
    L72:
        r15.skipToGroupEnd();
        goto L73
    L46:
        r4 = false;
        goto L48
    L37:
        if ((r13 & 3072) != 0) goto L44;
        if (r15.changedInstance(r11) == false) goto L41;
        int r26 = 2048;
    L42:
        r1 = r1 | r26;
        goto L44
    L41:
        r26 = 1024;
        goto L42
    L27:
        if ((r13 & 384) != 0) goto L34;
        if (r15.changed(r10) == false) goto L31;
        int r27 = 256;
    L32:
        r1 = r1 | r27;
        goto L34
    L31:
        r27 = 128;
        goto L32
    L17:
        if ((r13 & 48) != 0) goto L23;
        if (r15.changed(r9) == false) goto L21;
        int r28 = 32;
    L22:
        r1 = r1 | r28;
        goto L23
    L21:
        r28 = 16;
        goto L22
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L14
    L8:
        if (r15.changed(r8) == false) goto L10;
        int r29 = 4;
    L11:
        r1 = r29 | r13;
        goto L14
    L10:
        r29 = 2;
        goto L11
    }

    public static final void BasicTooltipBox(final PopupPositionProvider r20, final Function2<? super Composer, ? super Integer, Unit> r21, final BasicTooltipState r22, Modifier r23, boolean r24, boolean r25, final Function2<? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r9 = r27.startRestartGroup(196062260);
        if ((r29 & 1) == 0) goto L6;
        int r1 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r29 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r29 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        final Modifier r4 = r23;
    L44:
        int r5 = r29 & 16;
        if (r5 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        boolean r6 = r24;
    L55:
        int r13 = r29 & 32;
        if (r13 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        boolean r14 = r25;
    L67:
        if ((r29 & 64) == 0) goto L70;
        r1 = r1 | 1572864;
    L78:
        if ((r1 & 599187) == 599186) goto L80;
        boolean r3 = true;
    L82:
        if (r9.shouldExecute(r3, r1 & 1) == false) goto L126;
        if (r2 == 0) goto L85;
        Modifier r12 = Modifier.Companion;
    L86:
        if (r5 == 0) goto L88;
        boolean r19 = true;
    L89:
        if (r13 == 0) goto L92;
        r14 = true;
    L92:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(196062260, r1, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.kt:81)");
    L94:
        Object r7 = r9.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r7 != r15.getEmpty()) goto L97;
        r7 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r9);
        r9.updateRememberedValue(r7);
    L97:
        CoroutineScope r8 = (CoroutineScope) r7;
        Modifier.Companion r10 = Modifier.Companion;
        MeasurePolicy r11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r17 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r18 = r9.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r9, r10);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r0 = r110.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L100;
        ComposablesKt.invalidApplier();
    L100:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L103;
        r9.createNode(r0);
    L104:
        Composer r31 = Updater.constructor-impl(r9);
        Updater.set-impl(r31, r11, r110.getSetMeasurePolicy());
        Updater.set-impl(r31, r18, r110.getSetResolvedCompositionLocals());
        Function2 r32 = r110.getSetCompositeKeyHash();
        if (r31.getInserting() == false) goto L107;
    L108:
        r31.updateRememberedValue(Integer.valueOf(r17));
        r31.apply(Integer.valueOf(r17), r32);
    L109:
        Updater.set-impl(r31, r30, r110.getSetModifier());
        BoxScopeInstance r33 = BoxScopeInstance.INSTANCE;
        if (r22.isVisible() == false) goto L112;
        r9.startReplaceGroup(1833353604);
        int r34 = r1 >> 3;
        int r35 = (((r1 & 14) | (r34 & 112)) | (r34 & 7168)) | ((r1 << 9) & 57344);
        int r36 = r1;
        TooltipPopup(r20, r22, r8, r19, r21, r9, r35);
        r9.endReplaceGroup();
    L113:
        int r37 = r36 >> 3;
        int r38 = ((((r36 >> 15) & 14) | (r37 & 112)) | (r37 & 896)) | ((r36 >> 9) & 7168);
        WrappedAnchor(r14, r22, r12, r26, r9, r38, 0);
        r9.endNode();
        if ((r36 & 896) != 256) goto L116;
        boolean r39 = true;
    L117:
        Object r40 = r9.rememberedValue();
        if (r39 == false) goto L120;
    L121:
        r40 = new o(r22);
        r9.updateRememberedValue(r40);
    L122:
        EffectsKt.DisposableEffect(r22, (Function1) r40, r9, (r36 >> 6) & 14);
        if (ComposerKt.isTraceInProgress() == false) goto L125;
        ComposerKt.traceEventEnd();
    L125:
        r4 = r12;
        final boolean r41 = r14;
        final boolean r42 = r19;
    L127:
        ScopeUpdateScope r111 = r9.endRestartGroup();
        if (r111 == null) goto L131;
        r111.updateScope(new p(r20, r21, r22, r4, r42, r41, r26, r28, r29));
        return;
    L131:
        return;
    L120:
        if (r40 != r15.getEmpty()) goto L122;
    L116:
        r39 = false;
        goto L117
    L112:
        r36 = r1;
        r9.startReplaceGroup(1833584244);
        r9.endReplaceGroup();
        goto L113
    L107:
        if (Intrinsics.areEqual(r31.rememberedValue(), Integer.valueOf(r17)) == true) goto L109;
    L103:
        r9.useNode();
        goto L104
    L88:
        r19 = r6;
        goto L89
    L85:
        r12 = r4;
        goto L86
    L126:
        r9.skipToGroupEnd();
        r42 = r6;
        r41 = r14;
        goto L127
    L80:
        r3 = false;
        goto L82
    L70:
        if ((r28 & 1572864) != 0) goto L78;
        if (r9.changedInstance(r26) == false) goto L74;
        int r112 = 1048576;
    L75:
        r1 = r1 | r112;
        goto L78
    L74:
        r112 = 524288;
        goto L75
    L59:
        if ((196608 & r28) != 0) goto L65;
        r14 = r25;
        if (r9.changed(r14) == false) goto L63;
        int r113 = 131072;
    L64:
        r1 = r1 | r113;
        goto L67
    L63:
        r113 = 65536;
        goto L64
    L48:
        if ((r28 & 24576) != 0) goto L54;
        r6 = r24;
        if (r9.changed(r6) == false) goto L52;
        int r114 = 16384;
    L53:
        r1 = r1 | r114;
        goto L55
    L52:
        r114 = 8192;
        goto L53
    L37:
        if ((r28 & 3072) != 0) goto L43;
        r4 = r23;
        if (r9.changed(r4) == false) goto L41;
        int r43 = 2048;
    L42:
        r1 = r1 | r43;
        goto L44
    L41:
        r43 = 1024;
        goto L42
    L27:
        if ((r28 & 384) != 0) goto L33;
        if (r9.changed(r22) == false) goto L31;
        int r44 = 256;
    L32:
        r1 = r1 | r44;
        goto L33
    L31:
        r44 = 128;
        goto L32
    L17:
        if ((r28 & 48) != 0) goto L24;
        if (r9.changedInstance(r21) == false) goto L21;
        int r45 = 32;
    L22:
        r1 = r1 | r45;
        goto L24
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r1 = r28;
        goto L14
    L8:
        if (r9.changed(r20) == false) goto L10;
        int r46 = 4;
    L11:
        r1 = r46 | r28;
        goto L14
    L10:
        r46 = 2;
        goto L11
    }
}
