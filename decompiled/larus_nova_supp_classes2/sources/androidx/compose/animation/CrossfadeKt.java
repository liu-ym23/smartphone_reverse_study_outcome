package androidx.compose.animation;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\f2&\u0010\u000b\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CrossfadeKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(final Object r9, Modifier r10, FiniteAnimationSpec r11, final Function3 r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(-160948176);
        if ((r15 & 1) == 0) goto L6;
        int r1 = r14 | 6;
    L16:
        int r3 = r15 & 2;
        if (r3 == 0) goto L20;
        r1 = r1 | 48;
    L26:
        int r4 = r15 & 4;
        if (r4 == 0) goto L30;
        r1 = r1 | 384;
    L37:
        if ((r15 & 8) == 0) goto L40;
        r1 = r1 | 3072;
    L47:
        if ((r1 & 1171) == 1170) goto L49;
        boolean r5 = true;
    L51:
        if (r16.shouldExecute(r5, r1 & 1) == false) goto L63;
        if (r3 == 0) goto L55;
        r10 = Modifier.Companion;
    L55:
        if (r4 == 0) goto L58;
        r11 = AnimationSpecKt.tween$default(0, 0, null, 7, null);
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventStart(-160948176, r1, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:68)");
    L60:
        Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r9, null, r16, (r1 & 8) | (r1 & 14), 2);
        int r7 = ((r1 & 112) | (r1 & 896)) | ((r1 << 3) & 57344);
        Crossfade(r0, r10, r11, null, r12, r16, r7, 4);
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
    L64:
        final Modifier r6 = r10;
        final FiniteAnimationSpec r8 = r11;
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L68;
        r17.updateScope(new AnonymousClass2(r9, r6, r8, r12, r14, r15));
        return;
    L68:
        return;
    L63:
        r16.skipToGroupEnd();
        goto L64
    L49:
        r5 = false;
        goto L51
    L40:
        if ((r14 & 3072) != 0) goto L47;
        if (r16.changedInstance(r12) == false) goto L44;
        int r18 = 2048;
    L45:
        r1 = r1 | r18;
        goto L47
    L44:
        r18 = 1024;
        goto L45
    L30:
        if ((r14 & 384) != 0) goto L37;
        if (r16.changedInstance(r11) == false) goto L34;
        int r19 = 256;
    L35:
        r1 = r1 | r19;
        goto L37
    L34:
        r19 = 128;
        goto L35
    L20:
        if ((r14 & 48) != 0) goto L26;
        if (r16.changed(r10) == false) goto L24;
        int r20 = 32;
    L25:
        r1 = r1 | r20;
        goto L26
    L24:
        r20 = 16;
        goto L25
    L6:
        if ((r14 & 6) == 0) goto L8;
        r1 = r14;
        goto L16
    L8:
        if ((r14 & 8) != 0) goto L10;
        boolean r2 = r16.changed(r9);
    L11:
        if (r2 == false) goto L13;
        int r21 = 4;
    L14:
        r1 = r21 | r14;
        goto L16
    L13:
        r21 = 2;
        goto L14
    L10:
        r2 = r16.changedInstance(r9);
        goto L11
    }

    public static final <T> void Crossfade(final Transition<T> r16, Modifier r17, FiniteAnimationSpec<Float> r18, Function1<? super T, ? extends Object> r19, final Function3<? super T, ? super Composer, ? super Integer, Unit> r20, Composer r21, final int r22, final int r23) {
        Composer r2 = r21.startRestartGroup(-1877370462);
        if ((r23 & RtlSpacingHelper.UNDEFINED) == 0) goto L6;
        int r3 = r22 | 6;
    L13:
        int r7 = r23 & 1;
        if (r7 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r9 = r17;
    L24:
        int r10 = r23 & 2;
        if (r10 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        FiniteAnimationSpec<Float> r11 = r18;
    L35:
        int r12 = r23 & 4;
        if (r12 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function1<? super T, ? extends Object> r13 = r19;
    L47:
        if ((r23 & 8) == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        if ((r3 & 9363) == 9362) goto L59;
        boolean r14 = true;
    L61:
        if (r2.shouldExecute(r14, r3 & 1) == false) goto L140;
        if (r7 == 0) goto L64;
        r9 = Modifier.Companion;
    L64:
        if (r10 == 0) goto L66;
        r11 = AnimationSpecKt.tween$default(0, 0, null, 7, null);
    L66:
        if (r12 == 0) goto L72;
        Object r8 = r2.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L70;
        r8 = CrossfadeKt$Crossfade$3$1.INSTANCE;
        r2.updateRememberedValue(r8);
    L70:
        r13 = (Function1) r8;
    L72:
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventStart(-1877370462, r3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
    L74:
        Object r0 = r2.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        Object r1 = r0;
        if (r0 != r15.getEmpty()) goto L77;
        SnapshotStateList r4 = SnapshotStateKt.mutableStateListOf();
        r4.add(r16.getCurrentState());
        r2.updateRememberedValue(r4);
        r1 = r4;
    L77:
        SnapshotStateList r5 = (SnapshotStateList) r1;
        Object r110 = r2.rememberedValue();
        if (r110 != r15.getEmpty()) goto L80;
        r110 = ScatterMapKt.mutableScatterMapOf();
        r2.updateRememberedValue(r110);
    L80:
        MutableScatterMap r111 = (MutableScatterMap) r110;
        if (Intrinsics.areEqual(r16.getCurrentState(), r16.getTargetState()) == false) goto L99;
        r2.startReplaceGroup(321189832);
        if (r5.size() == 1) goto L85;
    L88:
        r2.startReplaceGroup(321324186);
        if ((r3 & 14) != 4) goto L91;
        boolean r6 = true;
    L92:
        Object r112 = r2.rememberedValue();
        if (r6 == false) goto L95;
    L96:
        r112 = new CrossfadeKt$Crossfade$4$1(r16);
        r2.updateRememberedValue(r112);
    L97:
        CollectionsKt.removeAll(r5, (Function1) r112);
        r111.clear();
        r2.endReplaceGroup();
    L98:
        r2.endReplaceGroup();
    L101:
        if (r111.contains(r16.getTargetState()) == true) goto L117;
        r2.startReplaceGroup(321581083);
        Iterator r24 = r5.iterator();
        int r25 = 0;
    L104:
        if (r24.hasNext() == false) goto L109;
        if (Intrinsics.areEqual(r13.invoke(r24.next()), r13.invoke(r16.getTargetState())) == true) goto L110;
        r25 = r25 + 1;
    L110:
        if (r25 != (-1)) goto L112;
        r5.add(r16.getTargetState());
    L113:
        r111.clear();
        int r26 = r5.size();
        int r27 = 0;
    L114:
        if (r27 >= r26) goto L116;
        Object r113 = ListProtector.get(r5, r27);
        r111.set(r113, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(r16, r11, r113, r20), r2, 54));
        r27 = r27 + 1;
        goto L114
    L116:
        r2.endReplaceGroup();
    L118:
        MeasurePolicy r28 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r29 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r30 = (int) (r29 ^ (r29 >>> 32));
        CompositionLocalMap r31 = r2.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r2, r9);
        ComposeUiNode.Companion r114 = ComposeUiNode.Companion;
        Function0 r115 = r114.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L121;
        ComposablesKt.invalidApplier();
    L121:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L124;
        r2.createNode(r115);
    L125:
        Composer r116 = Updater.constructor-impl(r2);
        Updater.set-impl(r116, r28, r114.getSetMeasurePolicy());
        Updater.set-impl(r116, r31, r114.getSetResolvedCompositionLocals());
        Function2 r33 = r114.getSetCompositeKeyHash();
        if (r116.getInserting() == false) goto L128;
    L129:
        r116.updateRememberedValue(Integer.valueOf(r30));
        r116.apply(Integer.valueOf(r30), r33);
    L130:
        Updater.set-impl(r116, r32, r114.getSetModifier());
        BoxScopeInstance r34 = BoxScopeInstance.INSTANCE;
        r2.startReplaceGroup(-1312707512);
        int r35 = r5.size();
        int r36 = 0;
    L131:
        if (r36 >= r35) goto L137;
        Object r37 = ListProtector.get(r5, r36);
        r2.startMovableGroup(1171574969, r13.invoke(r37));
        Function2 r38 = (Function2) r111.get(r37);
        if (r38 != null) goto L135;
        r2.startReplaceGroup(1959122128);
        r2.endReplaceGroup();
    L136:
        r2.endMovableGroup();
        r36 = r36 + 1;
        goto L131
    L135:
        r2.startReplaceGroup(1171576145);
        r38.invoke(r2, 0);
        r2.endReplaceGroup();
        goto L136
    L137:
        r2.endReplaceGroup();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventEnd();
    L141:
        final FiniteAnimationSpec<Float> r39 = r11;
        final Function1<? super T, ? extends Object> r40 = r13;
        ScopeUpdateScope r41 = r2.endRestartGroup();
        if (r41 == null) goto L151;
        final Modifier r42 = r9;
        r41.updateScope(new AnonymousClass7(r16, r42, r39, r40, r20, r22, r23));
        return;
    L151:
        return;
    L128:
        if (Intrinsics.areEqual(r116.rememberedValue(), Integer.valueOf(r30)) == true) goto L130;
    L124:
        r2.useNode();
        goto L125
    L112:
        r5.set(r25, r16.getTargetState());
        goto L113
    L109:
        r25 = -1;
        goto L110
    L117:
        r2.startReplaceGroup(322323936);
        r2.endReplaceGroup();
        goto L118
    L95:
        if (r112 != r15.getEmpty()) goto L97;
    L91:
        r6 = false;
        goto L92
    L85:
        if (Intrinsics.areEqual(r5.get(0), r16.getTargetState()) == false) goto L88;
        r2.startReplaceGroup(321514464);
        r2.endReplaceGroup();
        goto L98
    L99:
        r2.startReplaceGroup(321520416);
        r2.endReplaceGroup();
        goto L101
    L140:
        r2.skipToGroupEnd();
        goto L141
    L59:
        r14 = false;
        goto L61
    L50:
        if ((r22 & 24576) != 0) goto L57;
        if (r2.changedInstance(r20) == false) goto L54;
        int r117 = 16384;
    L55:
        r3 = r3 | r117;
        goto L57
    L54:
        r117 = 8192;
        goto L55
    L39:
        if ((r22 & 3072) != 0) goto L45;
        r13 = r19;
        if (r2.changedInstance(r13) == false) goto L43;
        int r118 = 2048;
    L44:
        r3 = r3 | r118;
        goto L47
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r22 & 384) != 0) goto L34;
        r11 = r18;
        if (r2.changedInstance(r11) == false) goto L32;
        int r119 = 256;
    L33:
        r3 = r3 | r119;
        goto L35
    L32:
        r119 = 128;
        goto L33
    L17:
        if ((r22 & 48) != 0) goto L23;
        r9 = r17;
        if (r2.changed(r9) == false) goto L21;
        int r120 = 32;
    L22:
        r3 = r3 | r120;
        goto L24
    L21:
        r120 = 16;
        goto L22
    L6:
        if ((r22 & 6) == 0) goto L8;
        r3 = r22;
        goto L13
    L8:
        if (r2.changed(r16) == false) goto L10;
        int r43 = 4;
    L11:
        r3 = r43 | r22;
        goto L13
    L10:
        r43 = 2;
        goto L11
    }

    public static final <T> void Crossfade(final T r16, Modifier r17, FiniteAnimationSpec<Float> r18, String r19, final Function3<? super T, ? super Composer, ? super Integer, Unit> r20, Composer r21, final int r22, final int r23) {
        Composer r2 = r21.startRestartGroup(-513216493);
        if ((r23 & 1) == 0) goto L6;
        int r3 = r22 | 6;
    L16:
        int r4 = r23 & 2;
        if (r4 == 0) goto L20;
        r3 = r3 | 48;
    L26:
        Modifier r5 = r17;
    L27:
        int r7 = r23 & 4;
        if (r7 == 0) goto L31;
        r3 = r3 | 384;
    L37:
        FiniteAnimationSpec<Float> r8 = r18;
    L38:
        int r9 = r23 & 8;
        if (r9 == 0) goto L42;
        r3 = r3 | 3072;
    L48:
        String r10 = r19;
    L50:
        if ((r23 & 16) == 0) goto L53;
        r3 = r3 | 24576;
    L60:
        if ((r3 & 9363) == 9362) goto L62;
        boolean r11 = true;
    L64:
        if (r2.shouldExecute(r11, r3 & 1) == false) goto L81;
        if (r4 == 0) goto L67;
        Modifier r6 = Modifier.Companion;
    L68:
        if (r7 == 0) goto L70;
        FiniteAnimationSpec<Float> r12 = AnimationSpecKt.tween$default(0, 0, null, 7, null);
    L71:
        if (r9 == 0) goto L73;
        String r14 = "Crossfade";
    L75:
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventStart(-513216493, r3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
    L77:
        Transition r13 = androidx.compose.animation.core.TransitionKt.updateTransition(r16, r14, r2, ((r3 & 8) | (r3 & 14)) | ((r3 >> 6) & 112), 0);
        int r15 = ((r3 & 112) | (r3 & 896)) | (r3 & 57344);
        String r24 = r14;
        Crossfade(r13, r6, r12, null, r20, r2, r15, 4);
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventEnd();
    L80:
        r10 = r24;
        final FiniteAnimationSpec<Float> r25 = r12;
    L82:
        ScopeUpdateScope r26 = r2.endRestartGroup();
        if (r26 == null) goto L86;
        final Modifier r27 = r6;
        final String r28 = r10;
        r26.updateScope(new AnonymousClass1(r16, r27, r25, r28, r20, r22, r23));
        return;
    L86:
        return;
    L73:
        r14 = r10;
        goto L75
    L70:
        r12 = r8;
        goto L71
    L67:
        r6 = r5;
        goto L68
    L81:
        r2.skipToGroupEnd();
        r6 = r5;
        r25 = r8;
        goto L82
    L62:
        r11 = false;
        goto L64
    L53:
        if ((r22 & 24576) != 0) goto L60;
        if (r2.changedInstance(r20) == false) goto L57;
        int r110 = 16384;
    L58:
        r3 = r3 | r110;
        goto L60
    L57:
        r110 = 8192;
        goto L58
    L42:
        if ((r22 & 3072) != 0) goto L48;
        r10 = r19;
        if (r2.changed(r10) == false) goto L46;
        int r111 = 2048;
    L47:
        r3 = r3 | r111;
        goto L50
    L46:
        r111 = 1024;
        goto L47
    L31:
        if ((r22 & 384) != 0) goto L37;
        r8 = r18;
        if (r2.changedInstance(r8) == false) goto L35;
        int r29 = 256;
    L36:
        r3 = r3 | r29;
        goto L38
    L35:
        r29 = 128;
        goto L36
    L20:
        if ((r22 & 48) != 0) goto L26;
        r5 = r17;
        if (r2.changed(r5) == false) goto L24;
        int r30 = 32;
    L25:
        r3 = r3 | r30;
        goto L27
    L24:
        r30 = 16;
        goto L25
    L6:
        if ((r22 & 6) == 0) goto L8;
        r3 = r22;
        goto L16
    L8:
        if ((r22 & 8) != 0) goto L10;
        boolean r31 = r2.changed(r16);
    L11:
        if (r31 == false) goto L13;
        int r32 = 4;
    L14:
        r3 = r32 | r22;
        goto L16
    L13:
        r32 = 2;
        goto L14
    L10:
        r31 = r2.changedInstance(r16);
        goto L11
    }
}
