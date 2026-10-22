package androidx.compose.foundation.text.contextmenu.internal;

import android.view.View;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a@\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000b\u001a3\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u008a\u008e\u0002"}, d2 = {"ProvidePlatformTextContextMenuToolbar", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "callbackInjector", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "platformTextContextMenuToolbarProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "coordinatesProvider", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "foundation_release", "layoutCoordinates"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextContextMenuToolbarProvider_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider_androidKt$ProvidePlatformTextContextMenuToolbar$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ MutableState<LayoutCoordinates> $layoutCoordinates$delegate;
        final /* synthetic */ Modifier $modifier;

        public AnonymousClass2(Modifier r1, MutableState<LayoutCoordinates> r2, Function2<? super Composer, ? super Integer, Unit> r3) {
            this.$modifier = r1;
            this.$layoutCoordinates$delegate = r2;
            this.$content = r3;
        }

        public static /* synthetic */ Unit a(MutableState r0, LayoutCoordinates r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(MutableState r0, LayoutCoordinates r1) {
            AndroidTextContextMenuToolbarProvider_androidKt.access$ProvidePlatformTextContextMenuToolbar$lambda$3(r0, r1);
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
            ComposerKt.traceEventStart(-291176396, r10, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvidePlatformTextContextMenuToolbar.<anonymous> (AndroidTextContextMenuToolbarProvider.android.kt:97)");
        L11:
            Modifier r11 = this.$modifier;
            final MutableState<LayoutCoordinates> r1 = this.$layoutCoordinates$delegate;
            Object r2 = r9.rememberedValue();
            if (r2 != Composer.Companion.getEmpty()) goto L14;
            r2 = new p(r1);
            r9.updateRememberedValue(r2);
        L14:
            Modifier r12 = OnGloballyPositionedModifierKt.onGloballyPositioned(r11, (Function1) r2);
            Function2<Composer, Integer, Unit> r3 = this.$content;
            MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            long r5 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
            int r6 = (int) (r5 ^ (r5 >>> 32));
            CompositionLocalMap r7 = r9.getCurrentCompositionLocalMap();
            Modifier r13 = ComposedModifierKt.materializeModifier(r9, r12);
            ComposeUiNode.Companion r8 = ComposeUiNode.Companion;
            Function0 r14 = r8.getConstructor();
            if ((r9.getApplier() instanceof Applier) == true) goto L17;
            ComposablesKt.invalidApplier();
        L17:
            r9.startReusableNode();
            if (r9.getInserting() == false) goto L20;
            r9.createNode(r14);
        L21:
            Composer r15 = Updater.constructor-impl(r9);
            Updater.set-impl(r15, r4, r8.getSetMeasurePolicy());
            Updater.set-impl(r15, r7, r8.getSetResolvedCompositionLocals());
            Function2 r16 = r8.getSetCompositeKeyHash();
            if (r15.getInserting() == false) goto L24;
        L25:
            r15.updateRememberedValue(Integer.valueOf(r6));
            r15.apply(Integer.valueOf(r6), r16);
        L26:
            Updater.set-impl(r15, r13, r8.getSetModifier());
            BoxScopeInstance r17 = BoxScopeInstance.INSTANCE;
            r3.invoke(r9, 0);
            r9.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L24:
            if (Intrinsics.areEqual(r15.rememberedValue(), Integer.valueOf(r6)) == true) goto L26;
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

    private static final Unit ProvidePlatformTextContextMenuToolbar$lambda$0(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        ProvidePlatformTextContextMenuToolbar(r0, r1, r4, RecomposeScopeImplKt.updateChangedFlags(r2 | 1), r3);
        return Unit.INSTANCE;
    }

    private static final Unit ProvidePlatformTextContextMenuToolbar$lambda$6(Modifier r6, Function1 r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        ProvidePlatformTextContextMenuToolbar(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, Function1 r1, Function2 r2, int r3, int r4, Composer r5, int r6) {
        return ProvidePlatformTextContextMenuToolbar$lambda$6(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ DisposableEffectResult b(AndroidTextContextMenuToolbarProvider r0, DisposableEffectScope r1) {
        return platformTextContextMenuToolbarProvider$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit c(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        return ProvidePlatformTextContextMenuToolbar$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ LayoutCoordinates d(MutableState r0) {
        return ProvidePlatformTextContextMenuToolbar$lambda$5$lambda$4(r0);
    }

    private static final LayoutCoordinates ProvidePlatformTextContextMenuToolbar$lambda$2(MutableState<LayoutCoordinates> r0) {
        return (LayoutCoordinates) r0.getValue();
    }

    private static final LayoutCoordinates ProvidePlatformTextContextMenuToolbar$lambda$5$lambda$4(MutableState r0) {
        LayoutCoordinates r1 = ProvidePlatformTextContextMenuToolbar$lambda$2(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    private static final void ProvidePlatformTextContextMenuToolbar$lambda$3(MutableState<LayoutCoordinates> r0, LayoutCoordinates r1) {
        r0.setValue(r1);
    }

    public static final /* synthetic */ void access$ProvidePlatformTextContextMenuToolbar$lambda$3(MutableState r0, LayoutCoordinates r1) {
        ProvidePlatformTextContextMenuToolbar$lambda$3(r0, r1);
    }

    private static final DisposableEffectResult platformTextContextMenuToolbarProvider$lambda$10$lambda$9(final AndroidTextContextMenuToolbarProvider r0, DisposableEffectScope r1) {
        r0.start();
        return new AndroidTextContextMenuToolbarProvider_androidKt$platformTextContextMenuToolbarProvider$lambda$10$lambda$9$$inlined$onDispose$1(r0);
    }

    public static final void ProvidePlatformTextContextMenuToolbar(final Modifier r7, final Function2<? super Composer, ? super Integer, Unit> r8, Composer r9, final int r10, final int r11) {
        Composer r12 = r9.startRestartGroup(2064964257);
        int r1 = r11 & 1;
        if (r1 == 0) goto L6;
        int r2 = r10 | 6;
    L14:
        if ((r11 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r2 & 19) == 18) goto L26;
        boolean r3 = true;
    L28:
        if (r12.shouldExecute(r3, r2 & 1) == false) goto L37;
        if (r1 == 0) goto L32;
        r7 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(2064964257, r2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvidePlatformTextContextMenuToolbar (AndroidTextContextMenuToolbarProvider.android.kt:66)");
    L34:
        int r5 = ((r2 & 14) | 48) | ((r2 << 3) & 896);
        ProvidePlatformTextContextMenuToolbar(r7, null, r8, r12, r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L42;
        r13.updateScope(new l(r7, r8, r10, r11));
        return;
    L42:
        return;
    L37:
        r12.skipToGroupEnd();
        goto L38
    L26:
        r3 = false;
        goto L28
    L17:
        if ((r10 & 48) != 0) goto L24;
        if (r12.changedInstance(r8) == false) goto L21;
        int r4 = 32;
    L22:
        r2 = r2 | r4;
        goto L24
    L21:
        r4 = 16;
        goto L22
    L6:
        if ((r10 & 6) == 0) goto L8;
        r2 = r10;
        goto L14
    L8:
        if (r12.changed(r7) == false) goto L10;
        int r6 = 4;
    L11:
        r2 = r6 | r10;
        goto L14
    L10:
        r6 = 2;
        goto L11
    }

    public static final TextContextMenuProvider platformTextContextMenuToolbarProvider(Function0<? extends LayoutCoordinates> r2, Function1<? super TextActionModeCallback, ? extends TextActionModeCallback> r3, Composer r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(549805508, r5, -1, "androidx.compose.foundation.text.contextmenu.internal.platformTextContextMenuToolbarProvider (AndroidTextContextMenuToolbarProvider.android.kt:110)");
    L8:
        View r7 = (View) r4.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r8 = r4.changed(r7);
        Object r0 = r4.rememberedValue();
        if (r8 == false) goto L11;
    L12:
        r0 = new AndroidTextContextMenuToolbarProvider(r7, r3, r2);
        r4.updateRememberedValue(r0);
    L13:
        final AndroidTextContextMenuToolbarProvider r1 = (AndroidTextContextMenuToolbarProvider) r0;
        boolean r9 = r4.changedInstance(r1);
        Object r10 = r4.rememberedValue();
        if (r9 == false) goto L16;
    L17:
        r10 = new m(r1);
        r4.updateRememberedValue(r10);
    L18:
        EffectsKt.DisposableEffect(r1, (Function1) r10, r4, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        return r1;
    L16:
        if (r10 != Composer.Companion.getEmpty()) goto L18;
    L11:
        if (r0 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }

    public static final void ProvidePlatformTextContextMenuToolbar(Modifier r7, final Function1<? super TextActionModeCallback, ? extends TextActionModeCallback> r8, final Function2<? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(771959668);
        int r1 = r12 & 1;
        if (r1 == 0) goto L6;
        int r2 = r11 | 6;
    L14:
        if ((r12 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r12 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r2 & 147) == 146) goto L36;
        boolean r3 = true;
    L38:
        if (r13.shouldExecute(r3, r2 & 1) == false) goto L53;
        if (r1 == 0) goto L42;
        r7 = Modifier.Companion;
    L42:
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventStart(771959668, r2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvidePlatformTextContextMenuToolbar (AndroidTextContextMenuToolbarProvider.android.kt:83)");
    L44:
        Object r0 = r13.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r0 != r4.getEmpty()) goto L47;
        r0 = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        r13.updateRememberedValue(r0);
    L47:
        final MutableState r5 = (MutableState) r0;
        Object r6 = r13.rememberedValue();
        if (r6 != r4.getEmpty()) goto L50;
        r6 = new n(r5);
        r13.updateRememberedValue(r6);
    L50:
        TextContextMenuProvider r14 = platformTextContextMenuToolbarProvider((Function0) r6, r8, r13, (r2 & 112) | 6, 0);
        CompositionLocalKt.CompositionLocalProvider(TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider().provides(r14), ComposableLambdaKt.rememberComposableLambda(-291176396, true, new AnonymousClass2(r7, r5, r9), r13, 54), r13, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventEnd();
    L54:
        final Modifier r15 = r7;
        ScopeUpdateScope r16 = r13.endRestartGroup();
        if (r16 == null) goto L58;
        r16.updateScope(new o(r15, r8, r9, r11, r12));
        return;
    L58:
        return;
    L53:
        r13.skipToGroupEnd();
        goto L54
    L36:
        r3 = false;
        goto L38
    L27:
        if ((r11 & 384) != 0) goto L34;
        if (r13.changedInstance(r9) == false) goto L31;
        int r17 = 256;
    L32:
        r2 = r2 | r17;
        goto L34
    L31:
        r17 = 128;
        goto L32
    L17:
        if ((r11 & 48) != 0) goto L24;
        if (r13.changedInstance(r8) == false) goto L21;
        int r18 = 32;
    L22:
        r2 = r2 | r18;
        goto L24
    L21:
        r18 = 16;
        goto L22
    L6:
        if ((r11 & 6) == 0) goto L8;
        r2 = r11;
        goto L14
    L8:
        if (r13.changed(r7) == false) goto L10;
        int r19 = 4;
    L11:
        r2 = r19 | r11;
        goto L14
    L10:
        r19 = 2;
        goto L11
    }
}
