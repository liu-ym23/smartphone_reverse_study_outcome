package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, d2 = {"SelectionContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DisableSelection", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionContainerKt {
    private static final Unit DisableSelection$lambda$6(Function2 r0, int r1, Composer r2, int r3) {
        DisableSelection(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SelectionContainer$lambda$15(Modifier r7, Selection r8, Function1 r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        SelectionContainer(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit SelectionContainer$lambda$5(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        SelectionContainer(r0, r1, r4, RecomposeScopeImplKt.updateChangedFlags(r2 | 1), r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, int r1, Composer r2, int r3) {
        return DisableSelection$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ SelectionRegistrarImpl b() {
        return SelectionContainer$lambda$8$lambda$7();
    }

    public static /* synthetic */ DisposableEffectResult c(SelectionManager r0, DisposableEffectScope r1) {
        return SelectionContainer$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ Unit d(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        return SelectionContainer$lambda$5(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit e(CoroutineScope r0, Clipboard r1, AnnotatedString r2) {
        return SelectionContainer$lambda$11$lambda$10(r0, r1, r2);
    }

    public static /* synthetic */ Unit f(MutableState r0, Selection r1) {
        return SelectionContainer$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit g(Modifier r0, Selection r1, Function1 r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return SelectionContainer$lambda$15(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final SelectionRegistrarImpl SelectionContainer$lambda$8$lambda$7() {
        return new SelectionRegistrarImpl();
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> r0) {
        return (Selection) r0.getValue();
    }

    private static final DisposableEffectResult SelectionContainer$lambda$14$lambda$13(final SelectionManager r0, DisposableEffectScope r1) {
        return new SelectionContainerKt$SelectionContainer$lambda$14$lambda$13$$inlined$onDispose$1(r0);
    }

    private static final void SelectionContainer$lambda$2(MutableState<Selection> r0, Selection r1) {
        r0.setValue(r1);
    }

    private static final Unit SelectionContainer$lambda$4$lambda$3(MutableState r0, Selection r1) {
        SelectionContainer$lambda$2(r0, r1);
        return Unit.INSTANCE;
    }

    public static final void DisableSelection(final Function2<? super Composer, ? super Integer, Unit> r4, Composer r5, final int r6) {
        Composer r7 = r5.startRestartGroup(-1162635549);
        if ((r6 & 6) == 0) goto L5;
        int r1 = r6;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r7.shouldExecute(r2, r1 & 1) == true) goto L17;
        r7.skipToGroupEnd();
    L23:
        ScopeUpdateScope r8 = r7.endRestartGroup();
        if (r8 == null) goto L27;
        r8.updateScope(new y(r4, r6));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1162635549, r1, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:71)");
    L19:
        int r3 = (r1 << 3) & 112;
        CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), r4, r7, r3 | ProvidedValue.$stable);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r7.changedInstance(r4) == false) goto L7;
        int r9 = 4;
    L8:
        r1 = r9 | r6;
        goto L11
    L7:
        r9 = 2;
        goto L8
    }

    private static final Unit SelectionContainer$lambda$11$lambda$10(CoroutineScope r6, Clipboard r7, AnnotatedString r8) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new SelectionContainerKt$SelectionContainer$3$1$1(r7, r8, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final void SelectionContainer(final Modifier r8, final Function2<? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(1949207773);
        int r1 = r12 & 1;
        if (r1 == 0) goto L6;
        int r3 = r11 | 6;
    L14:
        if ((r12 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r3 & 19) == 18) goto L26;
        boolean r4 = true;
    L28:
        if (r13.shouldExecute(r4, r3 & 1) == false) goto L43;
        if (r1 == 0) goto L32;
        r8 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(1949207773, r3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:54)");
    L34:
        Object r0 = r13.rememberedValue();
        Composer.Companion r2 = Composer.Companion;
        if (r0 != r2.getEmpty()) goto L37;
        r0 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r13.updateRememberedValue(r0);
    L37:
        final MutableState r5 = (MutableState) r0;
        Selection r6 = SelectionContainer$lambda$1(r5);
        Object r7 = r13.rememberedValue();
        if (r7 != r2.getEmpty()) goto L40;
        r7 = new w(r5);
        r13.updateRememberedValue(r7);
    L40:
        int r14 = ((r3 & 14) | 384) | ((r3 << 6) & 7168);
        Modifier r15 = r8;
        SelectionContainer(r15, r6, (Function1) r7, r9, r13, r14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventEnd();
    L44:
        ScopeUpdateScope r16 = r13.endRestartGroup();
        if (r16 == null) goto L48;
        r16.updateScope(new x(r8, r9, r11, r12));
        return;
    L48:
        return;
    L43:
        r13.skipToGroupEnd();
        goto L44
    L26:
        r4 = false;
        goto L28
    L17:
        if ((r11 & 48) != 0) goto L24;
        if (r13.changedInstance(r9) == false) goto L21;
        int r17 = 32;
    L22:
        r3 = r3 | r17;
        goto L24
    L21:
        r17 = 16;
        goto L22
    L6:
        if ((r11 & 6) == 0) goto L8;
        r3 = r11;
        goto L14
    L8:
        if (r13.changed(r8) == false) goto L10;
        int r18 = 4;
    L11:
        r3 = r18 | r11;
        goto L14
    L10:
        r18 = 2;
        goto L11
    }

    public static final void SelectionContainer(Modifier r9, final Selection r10, final Function1<? super Selection, Unit> r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(-917932944);
        int r1 = r15 & 1;
        if (r1 == 0) goto L6;
        int r2 = r14 | 6;
    L14:
        if ((r15 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r15 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r15 & 8) == 0) goto L37;
        r2 = r2 | 3072;
    L44:
        if ((r2 & 1171) == 1170) goto L46;
        boolean r3 = true;
    L48:
        if (r16.shouldExecute(r3, r2 & 1) == false) goto L80;
        if (r1 == 0) goto L52;
        r9 = Modifier.Companion;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-917932944, r2, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:91)");
    L54:
        Object[] r0 = new Object[0];
        Saver<SelectionRegistrarImpl, Long> r4 = SelectionRegistrarImpl.Companion.getSaver();
        Object r5 = r16.rememberedValue();
        Composer.Companion r6 = Composer.Companion;
        if (r5 != r6.getEmpty()) goto L57;
        r5 = new s();
        r16.updateRememberedValue(r5);
    L57:
        final SelectionRegistrarImpl r7 = (SelectionRegistrarImpl) RememberSaveableKt.rememberSaveable(r0, r4, (Function0) r5, r16, 384);
        Object r8 = r16.rememberedValue();
        if (r8 != r6.getEmpty()) goto L60;
        r8 = new SelectionManager(r7);
        r16.updateRememberedValue(r8);
    L60:
        final SelectionManager r17 = (SelectionManager) r8;
        final Clipboard r18 = (Clipboard) r16.consume(CompositionLocalsKt.getLocalClipboard());
        Object r19 = r16.rememberedValue();
        if (r19 != r6.getEmpty()) goto L63;
        r19 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r16);
        r16.updateRememberedValue(r19);
    L63:
        final CoroutineScope r20 = (CoroutineScope) r19;
        r17.setHapticFeedBack((HapticFeedback) r16.consume(CompositionLocalsKt.getLocalHapticFeedback()));
        boolean r21 = r16.changed(r20) | r16.changed(r18);
        Object r22 = r16.rememberedValue();
        if (r21 == false) goto L66;
    L67:
        r22 = new t(r20, r18);
        r16.updateRememberedValue(r22);
    L68:
        r17.setOnCopyHandler((Function1) r22);
        r17.setTextToolbar((TextToolbar) r16.consume(CompositionLocalsKt.getLocalTextToolbar()));
        r17.setOnSelectionChange(r11);
        r17.setSelection(r10);
        if (ComposeFoundationFlags.isSmartSelectionEnabled == false) goto L71;
        r16.startReplaceGroup(-82306500);
        r17.setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.StaticText, null, r16, 54));
        r17.setCoroutineScope$foundation_release(r20);
        r16.endReplaceGroup();
    L72:
        SimpleLayoutKt.SimpleLayout(r9.then(r17.getModifier()), ComposableLambdaKt.rememberComposableLambda(-1799563674, true, new AnonymousClass4(r17, r7, r12), r16, 54), r16, 48, 0);
        boolean r23 = r16.changedInstance(r17);
        Object r24 = r16.rememberedValue();
        if (r23 == false) goto L75;
    L76:
        r24 = new u(r17);
        r16.updateRememberedValue(r24);
    L77:
        EffectsKt.DisposableEffect(r17, (Function1) r24, r16, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventEnd();
    L81:
        final Modifier r25 = r9;
        ScopeUpdateScope r26 = r16.endRestartGroup();
        if (r26 == null) goto L85;
        r26.updateScope(new v(r25, r10, r11, r12, r14, r15));
        return;
    L85:
        return;
    L75:
        if (r24 != r6.getEmpty()) goto L77;
    L71:
        r16.startReplaceGroup(-82131598);
        r16.endReplaceGroup();
        goto L72
    L66:
        if (r22 != r6.getEmpty()) goto L68;
    L80:
        r16.skipToGroupEnd();
        goto L81
    L46:
        r3 = false;
        goto L48
    L37:
        if ((r14 & 3072) != 0) goto L44;
        if (r16.changedInstance(r12) == false) goto L41;
        int r27 = 2048;
    L42:
        r2 = r2 | r27;
        goto L44
    L41:
        r27 = 1024;
        goto L42
    L27:
        if ((r14 & 384) != 0) goto L34;
        if (r16.changedInstance(r11) == false) goto L31;
        int r28 = 256;
    L32:
        r2 = r2 | r28;
        goto L34
    L31:
        r28 = 128;
        goto L32
    L17:
        if ((r14 & 48) != 0) goto L24;
        if (r16.changed(r10) == false) goto L21;
        int r29 = 32;
    L22:
        r2 = r2 | r29;
        goto L24
    L21:
        r29 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r2 = r14;
        goto L14
    L8:
        if (r16.changed(r9) == false) goto L10;
        int r30 = 4;
    L11:
        r2 = r30 | r14;
        goto L14
    L10:
        r30 = 2;
        goto L11
    }
}
