package androidx.compose.animation;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aa\u0010\u0000\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0019\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001am\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001d\u001ak\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010 \u001a\u0091\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010'\u001a9\u0010+\u001a\u00020$\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010,\u001a\u0002H\u001bH\u0003¢\u0006\u0002\u0010-\"\u001e\u0010(\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020$0\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006.²\u0006\u001c\u0010/\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"AnimatedVisibility", "", "visible", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "T", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "transition", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedEnterExitImpl", "shouldDisposeBlock", "Lkotlin/Function2;", "Landroidx/compose/animation/EnterExitState;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exitFinished", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimatedVisibilityKt {
    private static final boolean AnimatedEnterExitImpl$lambda$11(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$9(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> r0) {
        return (Function2) r0.getValue();
    }

    public static final /* synthetic */ Function2 access$AnimatedEnterExitImpl$lambda$9(State r0) {
        return AnimatedEnterExitImpl$lambda$9(r0);
    }

    public static final /* synthetic */ boolean access$getExitFinished(Transition r0) {
        return getExitFinished(r0);
    }

    private static final boolean getExitFinished(Transition<EnterExitState> r2) {
        EnterExitState r0 = r2.getCurrentState();
        EnterExitState r1 = EnterExitState.PostExit;
        if (r0 == r1) goto L5;
    L7:
        return false;
    L5:
        if (r2.getTargetState() != r1) goto L7;
        return true;
    }

    private static final <T> EnterExitState targetEnterExit(Transition<T> r3, Function1<? super T, Boolean> r4, T r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(361571134, r7, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:833)");
    L5:
        r6.startMovableGroup(-422486105, r3);
        if (r3.isSeeking() == false) goto L14;
        r6.startReplaceGroup(-212146657);
        r6.endReplaceGroup();
        if (((Boolean) r4.invoke(r5)).booleanValue() == false) goto L11;
        EnterExitState r8 = EnterExitState.Visible;
    L28:
        r6.endMovableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
    L31:
        return r8;
    L11:
        if (((Boolean) r4.invoke(r3.getCurrentState())).booleanValue() == false) goto L13;
        r8 = EnterExitState.PostExit;
        goto L28
    L13:
        r8 = EnterExitState.PreEnter;
        goto L28
    L14:
        r6.startReplaceGroup(-211872524);
        Object r9 = r6.rememberedValue();
        if (r9 != Composer.Companion.getEmpty()) goto L17;
        r9 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r6.updateRememberedValue(r9);
    L17:
        MutableState r10 = (MutableState) r9;
        if (((Boolean) r4.invoke(r3.getCurrentState())).booleanValue() == false) goto L21;
        r10.setValue(Boolean.TRUE);
    L21:
        if (((Boolean) r4.invoke(r5)).booleanValue() == false) goto L24;
        r8 = EnterExitState.Visible;
    L27:
        r6.endReplaceGroup();
        goto L28
    L24:
        if (((Boolean) r10.getValue()).booleanValue() == false) goto L26;
        r8 = EnterExitState.PostExit;
        goto L27
    L26:
        r8 = EnterExitState.PreEnter;
        goto L27
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> r18, final Function1<? super T, Boolean> r19, final Modifier r20, final EnterTransition r21, final ExitTransition r22, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25) {
        Composer r15 = r24.startRestartGroup(1706321816);
        if ((r25 & 6) == 0) goto L5;
        int r1 = r25;
    L11:
        if ((r25 & 48) != 0) goto L18;
        if (r15.changedInstance(r19) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r25 & 384) != 0) goto L25;
        if (r15.changed(r20) == false) goto L22;
        int r4 = 256;
    L23:
        r1 = r1 | r4;
        goto L25
    L22:
        r4 = 128;
    L25:
        if ((r25 & 3072) != 0) goto L32;
        if (r15.changed(r21) == false) goto L29;
        int r5 = 2048;
    L30:
        r1 = r1 | r5;
        goto L32
    L29:
        r5 = 1024;
    L32:
        if ((r25 & 24576) != 0) goto L39;
        if (r15.changed(r22) == false) goto L36;
        int r6 = 16384;
    L37:
        r1 = r1 | r6;
        goto L39
    L36:
        r6 = 8192;
    L39:
        if ((r25 & 196608) == 0) goto L41;
    L45:
        boolean r7 = false;
        if ((74899 & r1) == 74898) goto L48;
        boolean r8 = true;
    L50:
        if (r15.shouldExecute(r8, r1 & 1) == true) goto L52;
        r15.skipToGroupEnd();
    L73:
        ScopeUpdateScope r9 = r15.endRestartGroup();
        if (r9 == null) goto L77;
        r9.updateScope(new AnonymousClass3(r18, r19, r20, r21, r22, r23, r25));
        return;
    L77:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(1706321816, r1, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:677)");
    L54:
        int r0 = r1 & 112;
        if (r0 != 32) goto L57;
        boolean r10 = true;
    L58:
        int r11 = r1 & 14;
        if (r11 != 4) goto L61;
        r7 = true;
    L61:
        boolean r2 = r10 | r7;
        Object r12 = r15.rememberedValue();
        if (r2 == false) goto L64;
    L65:
        r12 = new AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1(r19, r18);
        r15.updateRememberedValue(r12);
    L66:
        Modifier r13 = LayoutModifierKt.layout(r20, (Function3) r12);
        Object r14 = r15.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L69;
        r14 = AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1.INSTANCE;
        r15.updateRememberedValue(r14);
    L69:
        AnimatedEnterExitImpl(r18, r19, r13, r21, r22, (Function2) r14, null, r23, r15, (((r0 | (196608 | r11)) | (r1 & 7168)) | (57344 & r1)) | ((r1 << 6) & 29360128), 64);
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventEnd();
        goto L73
    L64:
        if (r12 != Composer.Companion.getEmpty()) goto L66;
    L57:
        r10 = false;
        goto L58
    L48:
        r8 = false;
        goto L50
    L41:
        if (r15.changedInstance(r23) == false) goto L43;
        int r16 = 131072;
    L44:
        r1 = r1 | r16;
        goto L45
    L43:
        r16 = 65536;
        goto L44
    L5:
        if (r15.changed(r18) == false) goto L7;
        int r17 = 4;
    L8:
        r1 = r17 | r25;
        goto L11
    L7:
        r17 = 2;
        goto L8
    }

    public static final void AnimatedVisibility(final MutableTransitionState<Boolean> r22, Modifier r23, EnterTransition r24, ExitTransition r25, String r26, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29, final int r30) {
        Composer r2 = r28.startRestartGroup(657024243);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r29 | 6;
    L16:
        int r4 = r30 & 2;
        if (r4 == 0) goto L20;
        r3 = r3 | 48;
    L26:
        Modifier r5 = r23;
    L27:
        int r6 = r30 & 4;
        if (r6 == 0) goto L31;
        r3 = r3 | 384;
    L37:
        EnterTransition r8 = r24;
    L38:
        int r9 = r30 & 8;
        if (r9 == 0) goto L42;
        r3 = r3 | 3072;
    L48:
        ExitTransition r10 = r25;
    L49:
        int r11 = r30 & 16;
        if (r11 == 0) goto L53;
        r3 = r3 | 24576;
    L59:
        String r12 = r26;
    L61:
        if ((r30 & 32) == 0) goto L64;
        r3 = r3 | 196608;
    L71:
        if ((74899 & r3) == 74898) goto L73;
        boolean r13 = true;
    L75:
        if (r2.shouldExecute(r13, r3 & 1) == false) goto L99;
        if (r4 == 0) goto L78;
        Modifier r7 = Modifier.Companion;
    L80:
        if (r6 == 0) goto L82;
        EnterTransition r14 = EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
    L83:
        if (r9 == 0) goto L85;
        ExitTransition r15 = EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
    L86:
        if (r11 == 0) goto L88;
        String r16 = "AnimatedVisibility";
    L90:
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(657024243, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
    L92:
        Transition r17 = androidx.compose.animation.core.TransitionKt.rememberTransition(r22, r16, r2, (MutableTransitionState.$stable | (r3 & 14)) | ((r3 >> 9) & 112), 0);
        Object r0 = r2.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L95;
        r0 = AnimatedVisibilityKt$AnimatedVisibility$7$1.INSTANCE;
        r2.updateRememberedValue(r0);
    L95:
        Function1 r18 = (Function1) r0;
        int r1 = r3 << 3;
        int r19 = ((r1 & 896) | 48) | (r1 & 7168);
        int r20 = ((r1 & 57344) | r19) | (r3 & 458752);
        String r21 = r16;
        AnimatedVisibilityImpl(r17, r18, r7, r14, r15, r27, r2, r20);
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
    L98:
        r10 = r15;
        final String r31 = r21;
        final EnterTransition r32 = r14;
    L100:
        ScopeUpdateScope r33 = r2.endRestartGroup();
        if (r33 == null) goto L104;
        final Modifier r34 = r7;
        final ExitTransition r35 = r10;
        r33.updateScope(new AnonymousClass8(r22, r34, r32, r35, r31, r27, r29, r30));
        return;
    L104:
        return;
    L88:
        r16 = r12;
        goto L90
    L85:
        r15 = r10;
        goto L86
    L82:
        r14 = r8;
        goto L83
    L78:
        r7 = r5;
        goto L80
    L99:
        r2.skipToGroupEnd();
        r7 = r5;
        r32 = r8;
        r31 = r12;
        goto L100
    L73:
        r13 = false;
        goto L75
    L64:
        if ((r29 & 196608) != 0) goto L71;
        if (r2.changedInstance(r27) == false) goto L68;
        int r110 = 131072;
    L69:
        r3 = r3 | r110;
        goto L71
    L68:
        r110 = 65536;
        goto L69
    L53:
        if ((r29 & 24576) != 0) goto L59;
        r12 = r26;
        if (r2.changed(r12) == false) goto L57;
        int r111 = 16384;
    L58:
        r3 = r3 | r111;
        goto L61
    L57:
        r111 = 8192;
        goto L58
    L42:
        if ((r29 & 3072) != 0) goto L48;
        r10 = r25;
        if (r2.changed(r10) == false) goto L46;
        int r112 = 2048;
    L47:
        r3 = r3 | r112;
        goto L49
    L46:
        r112 = 1024;
        goto L47
    L31:
        if ((r29 & 384) != 0) goto L37;
        r8 = r24;
        if (r2.changed(r8) == false) goto L35;
        int r36 = 256;
    L36:
        r3 = r3 | r36;
        goto L38
    L35:
        r36 = 128;
        goto L36
    L20:
        if ((r29 & 48) != 0) goto L26;
        r5 = r23;
        if (r2.changed(r5) == false) goto L24;
        int r37 = 32;
    L25:
        r3 = r3 | r37;
        goto L27
    L24:
        r37 = 16;
        goto L25
    L6:
        if ((r29 & 6) == 0) goto L8;
        r3 = r29;
        goto L16
    L8:
        if ((r29 & 8) != 0) goto L10;
        boolean r38 = r2.changed(r22);
    L11:
        if (r38 == false) goto L13;
        int r39 = 4;
    L14:
        r3 = r39 | r29;
        goto L16
    L13:
        r39 = 2;
        goto L14
    L10:
        r38 = r2.changedInstance(r22);
        goto L11
    }

    public static final void AnimatedVisibility(final boolean r22, Modifier r23, EnterTransition r24, ExitTransition r25, String r26, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(-1448730565);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r29 | 6;
    L13:
        int r4 = r30 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r23;
    L24:
        int r6 = r30 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        EnterTransition r8 = r24;
    L35:
        int r9 = r30 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        ExitTransition r10 = r25;
    L46:
        int r11 = r30 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        String r12 = r26;
    L58:
        if ((r30 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r13 = true;
    L72:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L96;
        if (r4 == 0) goto L75;
        Modifier r7 = Modifier.Companion;
    L77:
        if (r6 == 0) goto L79;
        EnterTransition r14 = EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
    L80:
        if (r9 == 0) goto L82;
        ExitTransition r15 = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null));
    L83:
        if (r11 == 0) goto L85;
        String r16 = "AnimatedVisibility";
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(-1448730565, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
    L89:
        Transition r17 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(r22), r16, r1, (r3 & 14) | ((r3 >> 9) & 112), 0);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L92;
        r0 = AnimatedVisibilityKt$AnimatedVisibility$1$1.INSTANCE;
        r1.updateRememberedValue(r0);
    L92:
        Function1 r18 = (Function1) r0;
        int r2 = r3 << 3;
        int r19 = ((r2 & 896) | 48) | (r2 & 7168);
        int r20 = ((r2 & 57344) | r19) | (r3 & 458752);
        String r21 = r16;
        AnimatedVisibilityImpl(r17, r18, r7, r14, r15, r27, r1, r20);
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
    L95:
        r10 = r15;
        final String r31 = r21;
        final EnterTransition r32 = r14;
    L97:
        ScopeUpdateScope r33 = r1.endRestartGroup();
        if (r33 == null) goto L101;
        final Modifier r34 = r7;
        final ExitTransition r35 = r10;
        r33.updateScope(new AnonymousClass2(r22, r34, r32, r35, r31, r27, r29, r30));
        return;
    L101:
        return;
    L85:
        r16 = r12;
        goto L87
    L82:
        r15 = r10;
        goto L83
    L79:
        r14 = r8;
        goto L80
    L75:
        r7 = r5;
        goto L77
    L96:
        r1.skipToGroupEnd();
        r7 = r5;
        r32 = r8;
        r31 = r12;
        goto L97
    L70:
        r13 = false;
        goto L72
    L61:
        if ((r29 & 196608) != 0) goto L68;
        if (r1.changedInstance(r27) == false) goto L65;
        int r110 = 131072;
    L66:
        r3 = r3 | r110;
        goto L68
    L65:
        r110 = 65536;
        goto L66
    L50:
        if ((r29 & 24576) != 0) goto L56;
        r12 = r26;
        if (r1.changed(r12) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L39:
        if ((r29 & 3072) != 0) goto L45;
        r10 = r25;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L46
    L43:
        r112 = 1024;
        goto L44
    L28:
        if ((r29 & 384) != 0) goto L34;
        r8 = r24;
        if (r1.changed(r8) == false) goto L32;
        int r36 = 256;
    L33:
        r3 = r3 | r36;
        goto L35
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r29 & 48) != 0) goto L23;
        r5 = r23;
        if (r1.changed(r5) == false) goto L21;
        int r37 = 32;
    L22:
        r3 = r3 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r29 & 6) == 0) goto L8;
        r3 = r29;
        goto L13
    L8:
        if (r1.changed(r22) == false) goto L10;
        int r38 = 4;
    L11:
        r3 = r38 | r29;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    public static final <T> void AnimatedVisibility(final Transition<T> r23, final Function1<? super T, Boolean> r24, Modifier r25, EnterTransition r26, ExitTransition r27, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r28, Composer r29, final int r30, final int r31) {
        Composer r1 = r29.startRestartGroup(-1699747442);
        if ((r31 & RtlSpacingHelper.UNDEFINED) == 0) goto L6;
        int r3 = r30 | 6;
    L14:
        if ((r31 & 1) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r31 & 2;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r25;
    L35:
        int r8 = r31 & 4;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        EnterTransition r9 = r26;
    L46:
        int r10 = r31 & 8;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        ExitTransition r11 = r27;
    L58:
        if ((r31 & 16) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r12 = true;
    L72:
        if (r1.shouldExecute(r12, r3 & 1) == false) goto L90;
        if (r5 == 0) goto L75;
        Modifier r7 = Modifier.Companion;
    L77:
        if (r8 == 0) goto L79;
        EnterTransition r16 = EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
    L80:
        if (r10 == 0) goto L82;
        ExitTransition r13 = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null));
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(-1699747442, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
    L86:
        Modifier r14 = r7;
        EnterTransition r15 = r16;
        ExitTransition r17 = r13;
        AnimatedVisibilityImpl(r23, r24, r14, r15, r17, r28, r1, (((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (r3 & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
    L89:
        final Modifier r4 = r7;
        final ExitTransition r18 = r13;
        r9 = r16;
    L91:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L95;
        final EnterTransition r20 = r9;
        r19.updateScope(new AnonymousClass13(r23, r24, r4, r20, r18, r28, r30, r31));
        return;
    L95:
        return;
    L82:
        r13 = r11;
        goto L84
    L79:
        r16 = r9;
        goto L80
    L75:
        r7 = r6;
        goto L77
    L90:
        r1.skipToGroupEnd();
        r4 = r6;
        r18 = r11;
        goto L91
    L70:
        r12 = false;
        goto L72
    L61:
        if ((r30 & 196608) != 0) goto L68;
        if (r1.changedInstance(r28) == false) goto L65;
        int r110 = 131072;
    L66:
        r3 = r3 | r110;
        goto L68
    L65:
        r110 = 65536;
        goto L66
    L50:
        if ((r30 & 24576) != 0) goto L56;
        r11 = r27;
        if (r1.changed(r11) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L39:
        if ((r30 & 3072) != 0) goto L45;
        r9 = r26;
        if (r1.changed(r9) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L46
    L43:
        r112 = 1024;
        goto L44
    L28:
        if ((r30 & 384) != 0) goto L34;
        r6 = r25;
        if (r1.changed(r6) == false) goto L32;
        int r21 = 256;
    L33:
        r3 = r3 | r21;
        goto L35
    L32:
        r21 = 128;
        goto L33
    L17:
        if ((r30 & 48) != 0) goto L24;
        if (r1.changedInstance(r24) == false) goto L21;
        int r22 = 32;
    L22:
        r3 = r3 | r22;
        goto L24
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r3 = r30;
        goto L14
    L8:
        if (r1.changed(r23) == false) goto L10;
        int r32 = 4;
    L11:
        r3 = r32 | r30;
        goto L14
    L10:
        r32 = 2;
        goto L11
    }

    public static final void AnimatedVisibility(final ColumnScope r23, final MutableTransitionState<Boolean> r24, Modifier r25, EnterTransition r26, ExitTransition r27, String r28, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-1238803325);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 48;
    L16:
        int r4 = r32 & 2;
        if (r4 == 0) goto L20;
        r3 = r3 | 384;
    L26:
        Modifier r5 = r25;
    L27:
        int r6 = r32 & 4;
        if (r6 == 0) goto L31;
        r3 = r3 | 3072;
    L37:
        EnterTransition r7 = r26;
    L38:
        int r9 = r32 & 8;
        if (r9 == 0) goto L42;
        r3 = r3 | 24576;
    L48:
        ExitTransition r10 = r27;
    L49:
        int r11 = r32 & 16;
        if (r11 == 0) goto L53;
        r3 = r3 | 196608;
    L59:
        String r12 = r28;
    L61:
        if ((r32 & 32) == 0) goto L64;
        r3 = r3 | 1572864;
    L71:
        if ((599185 & r3) == 599184) goto L73;
        boolean r13 = true;
    L75:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L99;
        if (r4 == 0) goto L78;
        Modifier r8 = Modifier.Companion;
    L80:
        if (r6 == 0) goto L82;
        EnterTransition r14 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null));
    L83:
        if (r9 == 0) goto L85;
        final ExitTransition r15 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null));
    L86:
        if (r11 == 0) goto L88;
        String r16 = "AnimatedVisibility";
    L90:
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(-1238803325, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
    L92:
        int r17 = r3 >> 3;
        Transition r18 = androidx.compose.animation.core.TransitionKt.rememberTransition(r24, r16, r1, (MutableTransitionState.$stable | (r17 & 14)) | ((r3 >> 12) & 112), 0);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L95;
        r0 = AnimatedVisibilityKt$AnimatedVisibility$11$1.INSTANCE;
        r1.updateRememberedValue(r0);
    L95:
        int r19 = ((r3 & 896) | 48) | (r3 & 7168);
        int r110 = ((r3 & 57344) | r19) | (r17 & 458752);
        AnimatedVisibilityImpl(r18, (Function1) r0, r8, r14, r15, r29, r1, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
    L98:
        final Modifier r20 = r8;
        final EnterTransition r21 = r14;
        final String r22 = r16;
    L100:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L104;
        r111.updateScope(new AnonymousClass12(r23, r24, r20, r21, r15, r22, r29, r31, r32));
        return;
    L104:
        return;
    L88:
        r16 = r12;
        goto L90
    L85:
        r15 = r10;
        goto L86
    L82:
        r14 = r7;
        goto L83
    L78:
        r8 = r5;
        goto L80
    L99:
        r1.skipToGroupEnd();
        r20 = r5;
        r21 = r7;
        r15 = r10;
        r22 = r12;
        goto L100
    L73:
        r13 = false;
        goto L75
    L64:
        if ((r31 & 1572864) != 0) goto L71;
        if (r1.changedInstance(r29) == false) goto L68;
        int r112 = 1048576;
    L69:
        r3 = r3 | r112;
        goto L71
    L68:
        r112 = 524288;
        goto L69
    L53:
        if ((196608 & r31) != 0) goto L59;
        r12 = r28;
        if (r1.changed(r12) == false) goto L57;
        int r113 = 131072;
    L58:
        r3 = r3 | r113;
        goto L61
    L57:
        r113 = 65536;
        goto L58
    L42:
        if ((r31 & 24576) != 0) goto L48;
        r10 = r27;
        if (r1.changed(r10) == false) goto L46;
        int r114 = 16384;
    L47:
        r3 = r3 | r114;
        goto L49
    L46:
        r114 = 8192;
        goto L47
    L31:
        if ((r31 & 3072) != 0) goto L37;
        r7 = r26;
        if (r1.changed(r7) == false) goto L35;
        int r33 = 2048;
    L36:
        r3 = r3 | r33;
        goto L38
    L35:
        r33 = 1024;
        goto L36
    L20:
        if ((r31 & 384) != 0) goto L26;
        r5 = r25;
        if (r1.changed(r5) == false) goto L24;
        int r34 = 256;
    L25:
        r3 = r3 | r34;
        goto L27
    L24:
        r34 = 128;
        goto L25
    L6:
        if ((r31 & 48) == 0) goto L8;
        r3 = r31;
        goto L16
    L8:
        if ((r31 & 64) != 0) goto L10;
        boolean r35 = r1.changed(r24);
    L11:
        if (r35 == false) goto L13;
        int r36 = 32;
    L14:
        r3 = r36 | r31;
        goto L16
    L13:
        r36 = 16;
        goto L14
    L10:
        r35 = r1.changedInstance(r24);
        goto L11
    }

    public static final void AnimatedVisibility(final RowScope r23, final MutableTransitionState<Boolean> r24, Modifier r25, EnterTransition r26, ExitTransition r27, String r28, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(1763490971);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 48;
    L16:
        int r4 = r32 & 2;
        if (r4 == 0) goto L20;
        r3 = r3 | 384;
    L26:
        Modifier r5 = r25;
    L27:
        int r6 = r32 & 4;
        if (r6 == 0) goto L31;
        r3 = r3 | 3072;
    L37:
        EnterTransition r7 = r26;
    L38:
        int r9 = r32 & 8;
        if (r9 == 0) goto L42;
        r3 = r3 | 24576;
    L48:
        ExitTransition r10 = r27;
    L49:
        int r11 = r32 & 16;
        if (r11 == 0) goto L53;
        r3 = r3 | 196608;
    L59:
        String r12 = r28;
    L61:
        if ((r32 & 32) == 0) goto L64;
        r3 = r3 | 1572864;
    L71:
        if ((599185 & r3) == 599184) goto L73;
        boolean r13 = true;
    L75:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L99;
        if (r4 == 0) goto L78;
        Modifier r8 = Modifier.Companion;
    L80:
        if (r6 == 0) goto L82;
        EnterTransition r14 = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null));
    L83:
        if (r9 == 0) goto L85;
        final ExitTransition r15 = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null));
    L86:
        if (r11 == 0) goto L88;
        String r16 = "AnimatedVisibility";
    L90:
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(1763490971, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
    L92:
        int r17 = r3 >> 3;
        Transition r18 = androidx.compose.animation.core.TransitionKt.rememberTransition(r24, r16, r1, (MutableTransitionState.$stable | (r17 & 14)) | ((r3 >> 12) & 112), 0);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L95;
        r0 = AnimatedVisibilityKt$AnimatedVisibility$9$1.INSTANCE;
        r1.updateRememberedValue(r0);
    L95:
        int r19 = ((r3 & 896) | 48) | (r3 & 7168);
        int r110 = ((r3 & 57344) | r19) | (r17 & 458752);
        AnimatedVisibilityImpl(r18, (Function1) r0, r8, r14, r15, r29, r1, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
    L98:
        final Modifier r20 = r8;
        final EnterTransition r21 = r14;
        final String r22 = r16;
    L100:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L104;
        r111.updateScope(new AnonymousClass10(r23, r24, r20, r21, r15, r22, r29, r31, r32));
        return;
    L104:
        return;
    L88:
        r16 = r12;
        goto L90
    L85:
        r15 = r10;
        goto L86
    L82:
        r14 = r7;
        goto L83
    L78:
        r8 = r5;
        goto L80
    L99:
        r1.skipToGroupEnd();
        r20 = r5;
        r21 = r7;
        r15 = r10;
        r22 = r12;
        goto L100
    L73:
        r13 = false;
        goto L75
    L64:
        if ((r31 & 1572864) != 0) goto L71;
        if (r1.changedInstance(r29) == false) goto L68;
        int r112 = 1048576;
    L69:
        r3 = r3 | r112;
        goto L71
    L68:
        r112 = 524288;
        goto L69
    L53:
        if ((196608 & r31) != 0) goto L59;
        r12 = r28;
        if (r1.changed(r12) == false) goto L57;
        int r113 = 131072;
    L58:
        r3 = r3 | r113;
        goto L61
    L57:
        r113 = 65536;
        goto L58
    L42:
        if ((r31 & 24576) != 0) goto L48;
        r10 = r27;
        if (r1.changed(r10) == false) goto L46;
        int r114 = 16384;
    L47:
        r3 = r3 | r114;
        goto L49
    L46:
        r114 = 8192;
        goto L47
    L31:
        if ((r31 & 3072) != 0) goto L37;
        r7 = r26;
        if (r1.changed(r7) == false) goto L35;
        int r33 = 2048;
    L36:
        r3 = r3 | r33;
        goto L38
    L35:
        r33 = 1024;
        goto L36
    L20:
        if ((r31 & 384) != 0) goto L26;
        r5 = r25;
        if (r1.changed(r5) == false) goto L24;
        int r34 = 256;
    L25:
        r3 = r3 | r34;
        goto L27
    L24:
        r34 = 128;
        goto L25
    L6:
        if ((r31 & 48) == 0) goto L8;
        r3 = r31;
        goto L16
    L8:
        if ((r31 & 64) != 0) goto L10;
        boolean r35 = r1.changed(r24);
    L11:
        if (r35 == false) goto L13;
        int r36 = 32;
    L14:
        r3 = r36 | r31;
        goto L16
    L13:
        r36 = 16;
        goto L14
    L10:
        r35 = r1.changedInstance(r24);
        goto L11
    }

    public static final void AnimatedVisibility(final ColumnScope r23, final boolean r24, Modifier r25, EnterTransition r26, ExitTransition r27, String r28, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(1799879339);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 48;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 384;
    L23:
        Modifier r5 = r25;
    L24:
        int r6 = r32 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 3072;
    L34:
        EnterTransition r7 = r26;
    L35:
        int r9 = r32 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 24576;
    L45:
        ExitTransition r10 = r27;
    L46:
        int r11 = r32 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 196608;
    L56:
        String r12 = r28;
    L58:
        if ((r32 & 32) == 0) goto L61;
        r3 = r3 | 1572864;
    L68:
        if ((599185 & r3) == 599184) goto L70;
        boolean r13 = true;
    L72:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L96;
        if (r4 == 0) goto L75;
        Modifier r8 = Modifier.Companion;
    L77:
        if (r6 == 0) goto L79;
        EnterTransition r14 = EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
    L80:
        if (r9 == 0) goto L82;
        final ExitTransition r15 = EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
    L83:
        if (r11 == 0) goto L85;
        String r16 = "AnimatedVisibility";
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(1799879339, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
    L89:
        int r17 = r3 >> 3;
        Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(r24), r16, r1, (r17 & 14) | ((r3 >> 12) & 112), 0);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L92;
        r0 = AnimatedVisibilityKt$AnimatedVisibility$5$1.INSTANCE;
        r1.updateRememberedValue(r0);
    L92:
        int r19 = ((r3 & 896) | 48) | (r3 & 7168);
        int r110 = ((r3 & 57344) | r19) | (r17 & 458752);
        AnimatedVisibilityImpl(r18, (Function1) r0, r8, r14, r15, r29, r1, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
    L95:
        final Modifier r20 = r8;
        final EnterTransition r21 = r14;
        final String r22 = r16;
    L97:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L101;
        r111.updateScope(new AnonymousClass6(r23, r24, r20, r21, r15, r22, r29, r31, r32));
        return;
    L101:
        return;
    L85:
        r16 = r12;
        goto L87
    L82:
        r15 = r10;
        goto L83
    L79:
        r14 = r7;
        goto L80
    L75:
        r8 = r5;
        goto L77
    L96:
        r1.skipToGroupEnd();
        r20 = r5;
        r21 = r7;
        r15 = r10;
        r22 = r12;
        goto L97
    L70:
        r13 = false;
        goto L72
    L61:
        if ((r31 & 1572864) != 0) goto L68;
        if (r1.changedInstance(r29) == false) goto L65;
        int r112 = 1048576;
    L66:
        r3 = r3 | r112;
        goto L68
    L65:
        r112 = 524288;
        goto L66
    L50:
        if ((196608 & r31) != 0) goto L56;
        r12 = r28;
        if (r1.changed(r12) == false) goto L54;
        int r113 = 131072;
    L55:
        r3 = r3 | r113;
        goto L58
    L54:
        r113 = 65536;
        goto L55
    L39:
        if ((r31 & 24576) != 0) goto L45;
        r10 = r27;
        if (r1.changed(r10) == false) goto L43;
        int r114 = 16384;
    L44:
        r3 = r3 | r114;
        goto L46
    L43:
        r114 = 8192;
        goto L44
    L28:
        if ((r31 & 3072) != 0) goto L34;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r33 = 2048;
    L33:
        r3 = r3 | r33;
        goto L35
    L32:
        r33 = 1024;
        goto L33
    L17:
        if ((r31 & 384) != 0) goto L23;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r34 = 256;
    L22:
        r3 = r3 | r34;
        goto L24
    L21:
        r34 = 128;
        goto L22
    L6:
        if ((r31 & 48) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r35 = 32;
    L11:
        r3 = r35 | r31;
        goto L13
    L10:
        r35 = 16;
        goto L11
    }

    public static final void AnimatedVisibility(final RowScope r23, final boolean r24, Modifier r25, EnterTransition r26, ExitTransition r27, String r28, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(234057107);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 48;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 384;
    L23:
        Modifier r5 = r25;
    L24:
        int r6 = r32 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 3072;
    L34:
        EnterTransition r7 = r26;
    L35:
        int r9 = r32 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 24576;
    L45:
        ExitTransition r10 = r27;
    L46:
        int r11 = r32 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 196608;
    L56:
        String r12 = r28;
    L58:
        if ((r32 & 32) == 0) goto L61;
        r3 = r3 | 1572864;
    L68:
        if ((599185 & r3) == 599184) goto L70;
        boolean r13 = true;
    L72:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L96;
        if (r4 == 0) goto L75;
        Modifier r8 = Modifier.Companion;
    L77:
        if (r6 == 0) goto L79;
        EnterTransition r14 = EnterExitTransitionKt.fadeIn$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
    L80:
        if (r9 == 0) goto L82;
        final ExitTransition r15 = EnterExitTransitionKt.fadeOut$default(null, MenuKt.ClosedAlphaTarget, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
    L83:
        if (r11 == 0) goto L85;
        String r16 = "AnimatedVisibility";
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(234057107, r3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
    L89:
        int r17 = r3 >> 3;
        Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(r24), r16, r1, (r17 & 14) | ((r3 >> 12) & 112), 0);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L92;
        r0 = AnimatedVisibilityKt$AnimatedVisibility$3$1.INSTANCE;
        r1.updateRememberedValue(r0);
    L92:
        int r19 = ((r3 & 896) | 48) | (r3 & 7168);
        int r110 = ((r3 & 57344) | r19) | (r17 & 458752);
        AnimatedVisibilityImpl(r18, (Function1) r0, r8, r14, r15, r29, r1, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
    L95:
        final Modifier r20 = r8;
        final EnterTransition r21 = r14;
        final String r22 = r16;
    L97:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L101;
        r111.updateScope(new C00864(r23, r24, r20, r21, r15, r22, r29, r31, r32));
        return;
    L101:
        return;
    L85:
        r16 = r12;
        goto L87
    L82:
        r15 = r10;
        goto L83
    L79:
        r14 = r7;
        goto L80
    L75:
        r8 = r5;
        goto L77
    L96:
        r1.skipToGroupEnd();
        r20 = r5;
        r21 = r7;
        r15 = r10;
        r22 = r12;
        goto L97
    L70:
        r13 = false;
        goto L72
    L61:
        if ((r31 & 1572864) != 0) goto L68;
        if (r1.changedInstance(r29) == false) goto L65;
        int r112 = 1048576;
    L66:
        r3 = r3 | r112;
        goto L68
    L65:
        r112 = 524288;
        goto L66
    L50:
        if ((196608 & r31) != 0) goto L56;
        r12 = r28;
        if (r1.changed(r12) == false) goto L54;
        int r113 = 131072;
    L55:
        r3 = r3 | r113;
        goto L58
    L54:
        r113 = 65536;
        goto L55
    L39:
        if ((r31 & 24576) != 0) goto L45;
        r10 = r27;
        if (r1.changed(r10) == false) goto L43;
        int r114 = 16384;
    L44:
        r3 = r3 | r114;
        goto L46
    L43:
        r114 = 8192;
        goto L44
    L28:
        if ((r31 & 3072) != 0) goto L34;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r33 = 2048;
    L33:
        r3 = r3 | r33;
        goto L35
    L32:
        r33 = 1024;
        goto L33
    L17:
        if ((r31 & 384) != 0) goto L23;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r34 = 256;
    L22:
        r3 = r3 | r34;
        goto L24
    L21:
        r34 = 128;
        goto L22
    L6:
        if ((r31 & 48) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r35 = 32;
    L11:
        r3 = r35 | r31;
        goto L13
    L10:
        r35 = 16;
        goto L11
    }

    public static final <T> void AnimatedEnterExitImpl(final Transition<T> r25, final Function1<? super T, Boolean> r26, final Modifier r27, final EnterTransition r28, final ExitTransition r29, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> r30, OnLookaheadMeasured r31, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        OnLookaheadMeasured r0 = r31;
        Composer r15 = r33.startRestartGroup(1912839215);
        if ((r35 & 1) == 0) goto L6;
        int r2 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r35 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r35 & 8) == 0) goto L37;
        r2 = r2 | 3072;
    L44:
        if ((r35 & 16) == 0) goto L47;
        r2 = r2 | 24576;
    L54:
        if ((r35 & 32) == 0) goto L57;
        r2 = r2 | 196608;
    L63:
        int r3 = r35 & 64;
        int r16 = 1572864;
        if (r3 == 0) goto L67;
    L65:
        r2 = r2 | r16;
    L76:
        if ((r35 & 128) == 0) goto L79;
        r2 = r2 | 12582912;
    L85:
        int r4 = r2;
        boolean r23 = true;
        if ((4793491 & r4) == 4793490) goto L88;
        boolean r5 = true;
    L90:
        if (r15.shouldExecute(r5, r4 & 1) == false) goto L193;
        if (r3 == 0) goto L93;
        r0 = null;
    L93:
        OnLookaheadMeasured r13 = r0;
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(1912839215, r4, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:715)");
    L97:
        if (((Boolean) r26.invoke(r25.getTargetState())).booleanValue() == false) goto L99;
    L106:
        r15.startReplaceGroup(-232323267);
        int r1 = r4 & 14;
        int r17 = r1 | 48;
        int r18 = r17 & 14;
        if ((r18 ^ 6) <= 4) goto L111;
        if (r15.changed(r25) == false) goto L111;
    L112:
        boolean r6 = true;
    L114:
        Object r7 = r15.rememberedValue();
        if (r6 == false) goto L117;
    L118:
        r7 = r25.getCurrentState();
        r15.updateRememberedValue(r7);
    L120:
        if (r25.isSeeking() == false) goto L122;
        r7 = r25.getCurrentState();
    L122:
        int r8 = (r17 >> 3) & 112;
        r15.startReplaceGroup(1844425648);
        if (ComposerKt.isTraceInProgress() == false) goto L125;
        ComposerKt.traceEventStart(1844425648, r8, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)");
    L125:
        int r11 = ((r4 & 112) | r1) | ((r8 << 6) & 896);
        EnterExitState r9 = targetEnterExit(r25, r26, r7, r15, r11);
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
    L128:
        r15.endReplaceGroup();
        T r12 = r25.getTargetState();
        r15.startReplaceGroup(1844425648);
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventStart(1844425648, r8, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)");
    L132:
        EnterExitState r10 = targetEnterExit(r25, r26, r12, r15, r11);
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
    L135:
        r15.endReplaceGroup();
        Transition r14 = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(r25, r9, r10, "EnterExitTransition", r15, r18 | ((r17 << 6) & 7168));
        State r19 = SnapshotStateKt.rememberUpdatedState(r30, r15, (r4 >> 15) & 14);
        Object r20 = r30.invoke(r14.getCurrentState(), r14.getTargetState());
        boolean r21 = r15.changed(r14) | r15.changed(r19);
        Object r22 = r15.rememberedValue();
        if (r21 == false) goto L138;
    L139:
        r22 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(r14, r19, null);
        r15.updateRememberedValue(r22);
    L140:
        State r24 = SnapshotStateKt.produceState(r20, (Function2) r22, r15, 0);
        if (getExitFinished(r14) == true) goto L143;
    L146:
        r15.startReplaceGroup(-231293261);
        if (r1 != 4) goto L149;
        boolean r36 = true;
    L150:
        Object r37 = r15.rememberedValue();
        if (r36 == false) goto L153;
    L154:
        r37 = new AnimatedVisibilityScopeImpl(r14);
        r15.updateRememberedValue(r37);
    L155:
        AnimatedVisibilityScopeImpl r38 = (AnimatedVisibilityScopeImpl) r37;
        int r39 = r4 >> 6;
        int r110 = ((r39 & 112) | 24576) | (r39 & 896);
        final OnLookaheadMeasured r40 = r13;
        Composer r41 = r15;
        Modifier r42 = EnterExitTransitionKt.createModifier(r14, r28, r29, null, "Built-in", r41, r110, 4);
        if (r40 == null) goto L171;
        r41.startReplaceGroup(-230873924);
        Modifier.Companion r43 = Modifier.Companion;
        if ((r4 & 3670016) != 1048576) goto L160;
    L165:
        Object r44 = r41.rememberedValue();
        if (r23 == false) goto L168;
    L169:
        r44 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1(r40);
        r41.updateRememberedValue(r44);
    L170:
        Modifier r45 = LayoutModifierKt.layout(r43, (Function3) r44);
        r41.endReplaceGroup();
    L172:
        Modifier r46 = r27.then(r42.then(r45));
        Object r47 = r41.rememberedValue();
        if (r47 != Composer.Companion.getEmpty()) goto L175;
        r47 = new AnimatedEnterExitMeasurePolicy(r38);
        r41.updateRememberedValue(r47);
    L175:
        AnimatedEnterExitMeasurePolicy r48 = (AnimatedEnterExitMeasurePolicy) r47;
        long r111 = ComposablesKt.getCurrentCompositeKeyHashCode(r41, 0);
        int r49 = (int) (r111 ^ (r111 >>> 32));
        CompositionLocalMap r112 = r41.getCurrentCompositionLocalMap();
        Modifier r50 = ComposedModifierKt.materializeModifier(r41, r46);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r114 = r113.getConstructor();
        if ((r41.getApplier() instanceof Applier) == true) goto L178;
        ComposablesKt.invalidApplier();
    L178:
        r41.startReusableNode();
        if (r41.getInserting() == false) goto L181;
        r41.createNode(r114);
    L182:
        Composer r115 = Updater.constructor-impl(r41);
        Updater.set-impl(r115, r48, r113.getSetMeasurePolicy());
        Updater.set-impl(r115, r112, r113.getSetResolvedCompositionLocals());
        Function2 r51 = r113.getSetCompositeKeyHash();
        if (r115.getInserting() == false) goto L185;
    L186:
        r115.updateRememberedValue(Integer.valueOf(r49));
        r115.apply(Integer.valueOf(r49), r51);
    L187:
        Updater.set-impl(r115, r50, r113.getSetModifier());
        r32.invoke(r38, r41, Integer.valueOf((r4 >> 18) & 112));
        r41.endNode();
        r41.endReplaceGroup();
    L188:
        r41.endReplaceGroup();
    L190:
        if (ComposerKt.isTraceInProgress() == false) goto L192;
        ComposerKt.traceEventEnd();
    L192:
        OnLookaheadMeasured r116 = r40;
    L194:
        ScopeUpdateScope r117 = r41.endRestartGroup();
        if (r117 == null) goto L198;
        final OnLookaheadMeasured r52 = r116;
        r117.updateScope(new AnonymousClass4(r25, r26, r27, r28, r29, r30, r52, r32, r34, r35));
        return;
    L198:
        return;
    L185:
        if (Intrinsics.areEqual(r115.rememberedValue(), Integer.valueOf(r49)) == true) goto L187;
    L181:
        r41.useNode();
        goto L182
    L168:
        if (r44 != Composer.Companion.getEmpty()) goto L170;
    L160:
        if ((r4 & 2097152) != 0) goto L162;
    L164:
        r23 = false;
        goto L165
    L162:
        if (r41.changedInstance(r40) == false) goto L164;
    L171:
        r41.startReplaceGroup(-7429769);
        r41.endReplaceGroup();
        r45 = Modifier.Companion;
        goto L172
    L153:
        if (r37 != Composer.Companion.getEmpty()) goto L155;
    L149:
        r36 = false;
        goto L150
    L143:
        if (AnimatedEnterExitImpl$lambda$11(r24) == false) goto L146;
        r15.startReplaceGroup(-230155437);
        r15.endReplaceGroup();
        r40 = r13;
        r41 = r15;
        goto L188
    L138:
        if (r22 != Composer.Companion.getEmpty()) goto L140;
    L117:
        if (r7 != Composer.Companion.getEmpty()) goto L120;
    L111:
        if ((r17 & 6) == 4) goto L112;
        r6 = false;
        goto L114
    L99:
        if (((Boolean) r26.invoke(r25.getCurrentState())).booleanValue() == true) goto L106;
        if (r25.isSeeking() == true) goto L106;
        if (r25.getHasInitialValueAnimations() == true) goto L106;
        r15.startReplaceGroup(-230149485);
        r15.endReplaceGroup();
        r40 = r13;
        r41 = r15;
        goto L190
    L193:
        r41 = r15;
        r41.skipToGroupEnd();
        r116 = r0;
        goto L194
    L88:
        r5 = false;
        goto L90
    L79:
        if ((r34 & 12582912) != 0) goto L85;
        if (r15.changedInstance(r32) == false) goto L83;
        int r53 = 8388608;
    L84:
        r2 = r2 | r53;
        goto L85
    L83:
        r53 = 4194304;
        goto L84
    L67:
        if ((r34 & 1572864) != 0) goto L76;
        if ((r34 & 2097152) != 0) goto L71;
        boolean r118 = r15.changed(r0);
    L72:
        if (r118 == false) goto L74;
        r16 = 1048576;
        goto L65
    L74:
        r16 = 524288;
        goto L65
    L71:
        r118 = r15.changedInstance(r0);
        goto L72
    L57:
        if ((r34 & 196608) != 0) goto L63;
        if (r15.changedInstance(r30) == false) goto L61;
        int r54 = 131072;
    L62:
        r2 = r2 | r54;
        goto L63
    L61:
        r54 = 65536;
        goto L62
    L47:
        if ((r34 & 24576) != 0) goto L54;
        if (r15.changed(r29) == false) goto L51;
        int r55 = 16384;
    L52:
        r2 = r2 | r55;
        goto L54
    L51:
        r55 = 8192;
        goto L52
    L37:
        if ((r34 & 3072) != 0) goto L44;
        if (r15.changed(r28) == false) goto L41;
        int r56 = 2048;
    L42:
        r2 = r2 | r56;
        goto L44
    L41:
        r56 = 1024;
        goto L42
    L27:
        if ((r34 & 384) != 0) goto L34;
        if (r15.changed(r27) == false) goto L31;
        int r57 = 256;
    L32:
        r2 = r2 | r57;
        goto L34
    L31:
        r57 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r15.changedInstance(r26) == false) goto L21;
        int r58 = 32;
    L22:
        r2 = r2 | r58;
        goto L24
    L21:
        r58 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r2 = r34;
        goto L14
    L8:
        if (r15.changed(r25) == false) goto L10;
        int r59 = 4;
    L11:
        r2 = r59 | r34;
        goto L14
    L10:
        r59 = 2;
        goto L11
    }
}
