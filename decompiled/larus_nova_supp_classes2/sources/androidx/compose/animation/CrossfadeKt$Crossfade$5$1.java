package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class CrossfadeKt$Crossfade$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function3<T, Composer, Integer, Unit> $content;
    final /* synthetic */ T $stateForContent;
    final /* synthetic */ Transition<T> $this_Crossfade;

    /* JADX WARN: Multi-variable type inference failed */
    public CrossfadeKt$Crossfade$5$1(Transition<T> r1, FiniteAnimationSpec<Float> r2, T r3, Function3<? super T, ? super Composer, ? super Integer, Unit> r4) {
        this.$this_Crossfade = r1;
        this.$animationSpec = r2;
        this.$stateForContent = r3;
        this.$content = r4;
        super(2);
    }

    public static final /* synthetic */ float access$invoke$lambda$1(State r0) {
        return invoke$lambda$1(r0);
    }

    private static final float invoke$lambda$1(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    public final void invoke(Composer r18, int r19) {
        if ((r19 & 3) == 2) goto L5;
        boolean r3 = true;
    L7:
        if (r18.shouldExecute(r3, r19 & 1) == true) goto L9;
        r18.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-934471669, r19, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous> (Crossfade.kt:125)");
    L11:
        final Transition<T> r2 = this.$this_Crossfade;
        final FiniteAnimationSpec<Float> r6 = this.$animationSpec;
        Function3<Transition.Segment<T>, Composer, Integer, FiniteAnimationSpec<Float>> r4 = new CrossfadeKt$Crossfade$5$1$alpha$2(r6);
        T r7 = this.$stateForContent;
        TwoWayConverter<Float, AnimationVector1D> r8 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        if (r2.isSeeking() == true) goto L32;
        r18.startReplaceGroup(1666599280);
        if (r18.changed(r2) == true) goto L16;
        boolean r9 = false;
    L17:
        Object r12 = r18.rememberedValue();
        if (r9 == false) goto L20;
    L21:
        Snapshot.Companion r10 = Snapshot.Companion;
        Snapshot r13 = r10.getCurrentThreadSnapshot();
        if (r13 == null) goto L24;
        Function1 r14 = r13.getReadObserver();
    L25:
        Snapshot r15 = r10.makeCurrentNonObservable(r13);
        Object r16 = r2.getCurrentState();     // Catch: Throwable -> L29
        r10.restoreNonObservable(r13, r15, r14);
        r18.updateRememberedValue(r16);
        r12 = r16;
    L28:
        r18.endReplaceGroup();
    L33:
        r18.startReplaceGroup(1378811975);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(1378811975, 0, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:127)");
    L37:
        if (Intrinsics.areEqual(r12, r7) == false) goto L39;
        float r17 = 1.0f;
    L41:
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
    L43:
        r18.endReplaceGroup();
        Float r110 = Float.valueOf(r17);
        if (r18.changed(r2) == true) goto L46;
        boolean r111 = false;
    L47:
        Object r5 = r18.rememberedValue();
        if (r111 == false) goto L50;
    L51:
        r5 = SnapshotStateKt.derivedStateOf(new CrossfadeKt$Crossfade$5$1$invoke$$inlined$animateFloat$1(r2));
        r18.updateRememberedValue(r5);
    L52:
        Object r11 = ((State) r5).getValue();
        r18.startReplaceGroup(1378811975);
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(1378811975, 0, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:127)");
    L56:
        if (Intrinsics.areEqual(r11, r7) == false) goto L58;
        float r112 = 1.0f;
    L60:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
    L62:
        r18.endReplaceGroup();
        Float r20 = Float.valueOf(r112);
        if (r18.changed(r2) == true) goto L65;
        boolean r21 = false;
    L66:
        Object r22 = r18.rememberedValue();
        if (r21 == false) goto L69;
    L70:
        r22 = SnapshotStateKt.derivedStateOf(new CrossfadeKt$Crossfade$5$1$invoke$$inlined$animateFloat$2(r2));
        r18.updateRememberedValue(r22);
    L71:
        final State r23 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r2, r110, r20, (FiniteAnimationSpec) r4.invoke(((State) r22).getValue(), r18, 0), r8, "FloatAnimation", r18, 0);
        Modifier.Companion r24 = Modifier.Companion;
        boolean r25 = r18.changed(r23);
        Object r26 = r18.rememberedValue();
        if (r25 == false) goto L74;
    L75:
        r26 = new CrossfadeKt$Crossfade$5$1$1$1(r23);
        r18.updateRememberedValue(r26);
    L76:
        Modifier r27 = GraphicsLayerModifierKt.graphicsLayer(r24, (Function1) r26);
        Function3<T, Composer, Integer, Unit> r28 = this.$content;
        T r29 = this.$stateForContent;
        MeasurePolicy r30 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r31 = ComposablesKt.getCurrentCompositeKeyHashCode(r18, 0);
        int r32 = (int) (r31 ^ (r31 >>> 32));
        CompositionLocalMap r33 = r18.getCurrentCompositionLocalMap();
        Modifier r34 = ComposedModifierKt.materializeModifier(r18, r27);
        ComposeUiNode.Companion r35 = ComposeUiNode.Companion;
        Function0 r36 = r35.getConstructor();
        if ((r18.getApplier() instanceof Applier) == true) goto L79;
        ComposablesKt.invalidApplier();
    L79:
        r18.startReusableNode();
        if (r18.getInserting() == false) goto L82;
        r18.createNode(r36);
    L83:
        Composer r37 = Updater.constructor-impl(r18);
        Updater.set-impl(r37, r30, r35.getSetMeasurePolicy());
        Updater.set-impl(r37, r33, r35.getSetResolvedCompositionLocals());
        Function2 r38 = r35.getSetCompositeKeyHash();
        if (r37.getInserting() == false) goto L86;
    L87:
        r37.updateRememberedValue(Integer.valueOf(r32));
        r37.apply(Integer.valueOf(r32), r38);
    L88:
        Updater.set-impl(r37, r34, r35.getSetModifier());
        BoxScopeInstance r39 = BoxScopeInstance.INSTANCE;
        r28.invoke(r29, r18, 0);
        r18.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
        return;
    L95:
        return;
    L86:
        if (Intrinsics.areEqual(r37.rememberedValue(), Integer.valueOf(r32)) == true) goto L88;
    L82:
        r18.useNode();
        goto L83
    L74:
        if (r26 != Composer.Companion.getEmpty()) goto L76;
    L69:
        if (r22 != Composer.Companion.getEmpty()) goto L71;
    L65:
        r21 = true;
        goto L66
    L58:
        r112 = MenuKt.ClosedAlphaTarget;
        goto L60
    L50:
        if (r5 != Composer.Companion.getEmpty()) goto L52;
    L46:
        r111 = true;
        goto L47
    L39:
        r17 = MenuKt.ClosedAlphaTarget;
    L29:
        th = move-exception;
        r10.restoreNonObservable(r13, r15, r14);
        throw th;
    L24:
        r14 = null;
        goto L25
    L20:
        if (r12 != Composer.Companion.getEmpty()) goto L28;
    L16:
        r9 = true;
        goto L17
    L32:
        r18.startReplaceGroup(1666853325);
        r18.endReplaceGroup();
        r12 = r2.getCurrentState();
        goto L33
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
