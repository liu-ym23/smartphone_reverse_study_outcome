package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {TextFieldImplKt.LabelId, "", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPersistent", "", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HandleInteractions", "enabled", "state", "Landroidx/compose/material3/TooltipState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LabelKt {
    private static final Unit HandleInteractions$lambda$7(boolean r0, TooltipState r1, MutableInteractionSource r2, int r3, Composer r4, int r5) {
        HandleInteractions(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Label$lambda$5(Function3 r9, Modifier r10, MutableInteractionSource r11, boolean r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        Label(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ LayoutCoordinates a(Ref.ObjectRef r0) {
        return Label$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Unit b(boolean r0, TooltipState r1, MutableInteractionSource r2, int r3, Composer r4, int r5) {
        return HandleInteractions$lambda$7(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(Function3 r0, Modifier r1, MutableInteractionSource r2, boolean r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return Label$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    private static final LayoutCoordinates Label$lambda$4$lambda$3(Ref.ObjectRef r0) {
        return (LayoutCoordinates) ((MutableState) r0.element).getValue();
    }

    private static final void HandleInteractions(final boolean r8, final TooltipState r9, final MutableInteractionSource r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-627258109);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L21;
        if ((r12 & 64) != 0) goto L15;
        boolean r2 = r13.changed(r9);
    L16:
        if (r2 == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
        goto L19
    L15:
        r2 = r13.changedInstance(r9);
    L21:
        if ((r12 & 384) == 0) goto L23;
    L27:
        boolean r6 = false;
        if ((r1 & 147) == 146) goto L30;
        boolean r4 = true;
    L32:
        if (r13.shouldExecute(r4, r1 & 1) == true) goto L34;
        r13.skipToGroupEnd();
    L59:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L63;
        r14.updateScope(new fd(r8, r9, r10, r12));
        return;
    L63:
        return;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(-627258109, r1, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
    L36:
        if (r8 == false) goto L54;
        r13.startReplaceGroup(756598818);
        if ((r1 & 896) != 256) goto L40;
        boolean r0 = true;
    L42:
        if ((r1 & 112) != 32) goto L44;
    L47:
        r6 = true;
    L48:
        boolean r5 = r0 | r6;
        Object r7 = r13.rememberedValue();
        if (r5 == false) goto L51;
    L52:
        r7 = new LabelKt$HandleInteractions$1$1(r10, r9, null);
        r13.updateRememberedValue(r7);
    L53:
        EffectsKt.LaunchedEffect(r10, (Function2) r7, r13, (r1 >> 6) & 14);
        r13.endReplaceGroup();
    L56:
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
        goto L59
    L51:
        if (r7 != Composer.Companion.getEmpty()) goto L53;
    L44:
        if ((r1 & 64) == 0) goto L48;
        if (r13.changedInstance(r9) == false) goto L48;
    L40:
        r0 = false;
        goto L42
    L54:
        r13.startReplaceGroup(757210975);
        r13.endReplaceGroup();
        goto L56
    L30:
        r4 = false;
        goto L32
    L23:
        if (r13.changed(r10) == false) goto L25;
        int r15 = 256;
    L26:
        r1 = r1 | r15;
        goto L27
    L25:
        r15 = 128;
        goto L26
    L5:
        if (r13.changed(r8) == false) goto L7;
        int r16 = 4;
    L8:
        r1 = r16 | r12;
        goto L11
    L7:
        r16 = 2;
        goto L8
    }

    public static final void Label(final Function3<? super TooltipScope, ? super Composer, ? super Integer, Unit> r22, Modifier r23, MutableInteractionSource r24, boolean r25, final Function2<? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r2 = r27.startRestartGroup(-458575864);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L13:
        int r7 = r29 & 2;
        if (r7 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r8 = r23;
    L24:
        int r9 = r29 & 4;
        if (r9 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        MutableInteractionSource r10 = r24;
    L35:
        int r11 = r29 & 8;
        if (r11 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r12 = r25;
    L47:
        if ((r29 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        if ((r3 & 9363) == 9362) goto L59;
        boolean r13 = true;
    L61:
        if (r2.shouldExecute(r13, r3 & 1) == false) goto L98;
        if (r7 == 0) goto L64;
        Modifier r19 = Modifier.Companion;
    L66:
        if (r9 == 0) goto L68;
        MutableInteractionSource r20 = null;
    L69:
        if (r11 == 0) goto L71;
        boolean r21 = false;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(-458575864, r3, -1, "androidx.compose.material3.Label (Label.kt:69)");
    L75:
        if (r20 != null) goto L80;
        r2.startReplaceGroup(857748595);
        Object r0 = r2.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L79;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r2.updateRememberedValue(r0);
    L79:
        MutableInteractionSource r1 = (MutableInteractionSource) r0;
        r2.endReplaceGroup();
    L81:
        PopupPositionProvider r14 = TooltipDefaults.INSTANCE.m3549rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.Companion.m3535getAbovelOKsHw4(), MenuKt.ClosedAlphaTarget, r2, 390, 2);
        if (r21 == false) goto L87;
        r2.startReplaceGroup(857995293);
        Object r15 = r2.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L86;
        r15 = new LabelStateImpl(false, false, 3, null);
        r2.updateRememberedValue(r15);
    L86:
        TooltipState r16 = (LabelStateImpl) r15;
        r2.endReplaceGroup();
    L88:
        TooltipState r17 = r16;
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        Object r30 = r2.rememberedValue();
        Composer.Companion r31 = Composer.Companion;
        if (r30 != r31.getEmpty()) goto L91;
        r30 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r2.updateRememberedValue(r30);
    L91:
        r18.element = (MutableState) r30;
        Object r32 = r2.rememberedValue();
        if (r32 != r31.getEmpty()) goto L94;
        r32 = new TooltipScopeImpl(new gd(r18), r14);
        r2.updateRememberedValue(r32);
    L94:
        final TooltipScopeImpl r33 = (TooltipScopeImpl) r32;
        Modifier r110 = r19;
        BasicTooltipKt.BasicTooltipBox(r14, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new AnonymousClass1(r22, r33), r2, 54), r17, r110, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new LabelKt$Label$wrappedContent$1(r18, r26), r2, 54), r2, ((r3 << 6) & 7168) | 102432816, 144);
        HandleInteractions(!r21, r17, r1, r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        r8 = r19;
        final MutableInteractionSource r4 = r20;
        final boolean r5 = r21;
    L99:
        ScopeUpdateScope r34 = r2.endRestartGroup();
        if (r34 == null) goto L103;
        final Modifier r6 = r8;
        r34.updateScope(new hd(r22, r6, r4, r5, r26, r28, r29));
        return;
    L103:
        return;
    L87:
        r2.startReplaceGroup(1690246656);
        r16 = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), r2, 0, 3);
        r2.endReplaceGroup();
        goto L88
    L80:
        r2.startReplaceGroup(1690236644);
        r2.endReplaceGroup();
        r1 = r20;
        goto L81
    L71:
        r21 = r12;
        goto L73
    L68:
        r20 = r10;
        goto L69
    L64:
        r19 = r8;
        goto L66
    L98:
        r2.skipToGroupEnd();
        r4 = r10;
        r5 = r12;
        goto L99
    L59:
        r13 = false;
        goto L61
    L50:
        if ((r28 & 24576) != 0) goto L57;
        if (r2.changedInstance(r26) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
        goto L57
    L54:
        r111 = 8192;
        goto L55
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r12 = r25;
        if (r2.changed(r12) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L47
    L43:
        r112 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L34;
        r10 = r24;
        if (r2.changed(r10) == false) goto L32;
        int r113 = 256;
    L33:
        r3 = r3 | r113;
        goto L35
    L32:
        r113 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r8 = r23;
        if (r2.changed(r8) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L24
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L13
    L8:
        if (r2.changedInstance(r22) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r28;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }
}
