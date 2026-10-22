package androidx.compose.animation;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.material3.MenuKt;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a\u0015\u0010!\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0087\u0004\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010)\"\u0010\u0010&\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006*"}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "UnspecifiedSize", "J", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimatedContentKt {
    private static final long UnspecifiedSize = 0;

    static {
        long r0 = RtlSpacingHelper.UNDEFINED;
        UnspecifiedSize = IntSize.constructor-impl((r0 & 4294967295L) | (r0 << 32));
    }

    public static final /* synthetic */ long access$getUnspecifiedSize$p() {
        return UnspecifiedSize;
    }

    public static final SizeTransform SizeTransform(boolean r1, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> r2) {
        return new SizeTransformImpl(r1, r2);
    }

    public static final ContentTransform togetherWith(EnterTransition r8, ExitTransition r9) {
        return new ContentTransform(r8, r9, MenuKt.ClosedAlphaTarget, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition r8, ExitTransition r9) {
        return new ContentTransform(r8, r9, MenuKt.ClosedAlphaTarget, null, 12, null);
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean r0, Function2 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r0 = true;
    L6:
        if ((r2 & 2) == 0) goto L9;
        r1 = AnonymousClass1.INSTANCE;
    L9:
        return SizeTransform(r0, r1);
    }

    public static final <S> void AnimatedContent(final Transition<S> r20, Modifier r21, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r22, Alignment r23, Function1<? super S, ? extends Object> r24, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> r25, Composer r26, final int r27, final int r28) {
        Composer r9 = r26.startRestartGroup(511725103);
        if ((r28 & RtlSpacingHelper.UNDEFINED) == 0) goto L6;
        int r1 = r27 | 6;
    L13:
        int r3 = r28 & 1;
        if (r3 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        Modifier r4 = r21;
    L24:
        int r5 = r28 & 2;
        if (r5 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r6 = r22;
    L35:
        int r11 = r28 & 4;
        if (r11 == 0) goto L39;
        r1 = r1 | 3072;
    L45:
        Alignment r12 = r23;
    L46:
        int r13 = r28 & 8;
        if (r13 == 0) goto L50;
        r1 = r1 | 24576;
    L56:
        Function1<? super S, ? extends Object> r14 = r24;
    L58:
        if ((r28 & 16) == 0) goto L61;
        r1 = r1 | 196608;
    L69:
        if ((r1 & 74899) == 74898) goto L71;
        boolean r2 = true;
    L73:
        if (r9.shouldExecute(r2, r1 & 1) == false) goto L193;
        if (r3 == 0) goto L76;
        Modifier r10 = Modifier.Companion;
    L77:
        if (r5 == 0) goto L82;
        Object r7 = r9.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L81;
        r7 = AnimatedContentKt$AnimatedContent$4$1.INSTANCE;
        r9.updateRememberedValue(r7);
    L81:
        r6 = (Function1) r7;
    L82:
        if (r11 == 0) goto L84;
        r12 = Alignment.Companion.getTopStart();
    L84:
        if (r13 == 0) goto L90;
        Object r8 = r9.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L88;
        r8 = AnimatedContentKt$AnimatedContent$5$1.INSTANCE;
        r9.updateRememberedValue(r8);
    L88:
        r14 = (Function1) r8;
    L90:
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(511725103, r1, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:773)");
    L92:
        LayoutDirection r15 = (LayoutDirection) r9.consume(CompositionLocalsKt.getLocalLayoutDirection());
        int r16 = r1 & 14;
        if (r16 != 4) goto L95;
        boolean r17 = true;
    L96:
        Object r18 = r9.rememberedValue();
        if (r17 == false) goto L99;
    L100:
        r18 = new AnimatedContentTransitionScopeImpl(r20, r12, r15);
        r9.updateRememberedValue(r18);
    L101:
        final AnimatedContentTransitionScopeImpl r19 = (AnimatedContentTransitionScopeImpl) r18;
        if (r16 != 4) goto L104;
        boolean r29 = true;
    L105:
        Object r30 = r9.rememberedValue();
        if (r29 == false) goto L108;
    L109:
        r30 = SnapshotStateKt.mutableStateListOf(new Object[]{r20.getCurrentState()});
        r9.updateRememberedValue(r30);
    L110:
        final SnapshotStateList r110 = (SnapshotStateList) r30;
        if (r16 != 4) goto L113;
        boolean r31 = true;
    L114:
        Object r32 = r9.rememberedValue();
        if (r31 == false) goto L117;
    L118:
        r32 = ScatterMapKt.mutableScatterMapOf();
        r9.updateRememberedValue(r32);
    L119:
        MutableScatterMap r33 = (MutableScatterMap) r32;
        if (r110.contains(r20.getCurrentState()) == true) goto L123;
        r110.clear();
        r110.add(r20.getCurrentState());
    L123:
        if (Intrinsics.areEqual(r20.getCurrentState(), r20.getTargetState()) == false) goto L136;
        if (r110.size() == 1) goto L127;
    L128:
        r110.clear();
        r110.add(r20.getCurrentState());
    L130:
        if (r33.getSize() == 1) goto L132;
    L133:
        r33.clear();
    L134:
        r19.setContentAlignment(r12);
        r19.setLayoutDirection$animation(r15);
        goto L136
    L132:
        if (r33.containsKey(r20.getCurrentState()) == false) goto L134;
    L127:
        if (Intrinsics.areEqual(r110.get(0), r20.getCurrentState()) == true) goto L130;
    L136:
        if (Intrinsics.areEqual(r20.getCurrentState(), r20.getTargetState()) == true) goto L151;
        if (r110.contains(r20.getTargetState()) == true) goto L151;
        Iterator r34 = r110.iterator();
        int r35 = 0;
    L141:
        if (r34.hasNext() == false) goto L146;
        if (Intrinsics.areEqual(r14.invoke(r34.next()), r14.invoke(r20.getTargetState())) == true) goto L147;
        r35 = r35 + 1;
    L147:
        if (r35 != (-1)) goto L149;
        r110.add(r20.getTargetState());
        goto L151
    L149:
        r110.set(r35, r20.getTargetState());
        Unit r0 = Unit.INSTANCE;
        goto L151
    L146:
        r35 = -1;
    L151:
        if (r33.containsKey(r20.getTargetState()) == true) goto L153;
    L156:
        r9.startReplaceGroup(1966468977);
        r33.clear();
        int r36 = r110.size();
        int r37 = 0;
    L157:
        if (r37 >= r36) goto L159;
        final Object r38 = ListProtector.get(r110, r37);
        int r111 = r37;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r39 = r6;
        MutableScatterMap r112 = r33;
        r112.set(r38, ComposableLambdaKt.rememberComposableLambda(-23915175, true, new AnimatedContentKt$AnimatedContent$6$1(r20, r38, r39, r19, r110, r25), r9, 54));
        r37 = r111 + 1;
        r33 = r112;
        r36 = r36;
        r6 = r6;
        goto L157
    L159:
        MutableScatterMap r40 = r33;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r113 = r6;
        r9.endReplaceGroup();
    L160:
        Transition.Segment<S> r41 = r20.getSegment();
        boolean r42 = r9.changed(r41) | r9.changed(r19);
        Object r43 = r9.rememberedValue();
        if (r42 == false) goto L163;
    L166:
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r44 = r113;
        r43 = (ContentTransform) r44.invoke(r19);
        r9.updateRememberedValue(r43);
    L167:
        Modifier r45 = r10.then(r19.createSizeAnimationModifier$animation((ContentTransform) r43, r9, 0));
        Object r46 = r9.rememberedValue();
        if (r46 != Composer.Companion.getEmpty()) goto L170;
        r46 = new AnimatedContentMeasurePolicy(r19);
        r9.updateRememberedValue(r46);
    L170:
        AnimatedContentMeasurePolicy r47 = (AnimatedContentMeasurePolicy) r46;
        long r48 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r49 = (int) (r48 ^ (r48 >>> 32));
        CompositionLocalMap r50 = r9.getCurrentCompositionLocalMap();
        Modifier r51 = ComposedModifierKt.materializeModifier(r9, r45);
        ComposeUiNode.Companion r52 = ComposeUiNode.Companion;
        Function0 r53 = r52.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L173;
        ComposablesKt.invalidApplier();
    L173:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L176;
        r9.createNode(r53);
    L177:
        Composer r54 = Updater.constructor-impl(r9);
        Updater.set-impl(r54, r47, r52.getSetMeasurePolicy());
        Updater.set-impl(r54, r50, r52.getSetResolvedCompositionLocals());
        Function2 r55 = r52.getSetCompositeKeyHash();
        if (r54.getInserting() == false) goto L180;
    L181:
        r54.updateRememberedValue(Integer.valueOf(r49));
        r54.apply(Integer.valueOf(r49), r55);
    L182:
        Updater.set-impl(r54, r51, r52.getSetModifier());
        r9.startReplaceGroup(-860173498);
        int r56 = r110.size();
        int r57 = 0;
    L183:
        if (r57 >= r56) goto L189;
        Object r58 = ListProtector.get(r110, r57);
        r9.startMovableGroup(-2026002954, r14.invoke(r58));
        Function2 r59 = (Function2) r40.get(r58);
        if (r59 != null) goto L187;
        r9.startReplaceGroup(1618454323);
        r9.endReplaceGroup();
    L188:
        r9.endMovableGroup();
        r57 = r57 + 1;
        goto L183
    L187:
        r9.startReplaceGroup(-2026001778);
        r59.invoke(r9, 0);
        r9.endReplaceGroup();
        Unit r60 = Unit.INSTANCE;
        goto L188
    L189:
        r9.endReplaceGroup();
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L192;
        ComposerKt.traceEventEnd();
    L192:
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r61 = r44;
        final Modifier r62 = r10;
    L194:
        final Alignment r63 = r12;
        final Function1<? super S, ? extends Object> r64 = r14;
        ScopeUpdateScope r65 = r9.endRestartGroup();
        if (r65 == null) goto L204;
        r65.updateScope(new AnonymousClass9(r20, r62, r61, r63, r64, r25, r27, r28));
        return;
    L204:
        return;
    L180:
        if (Intrinsics.areEqual(r54.rememberedValue(), Integer.valueOf(r49)) == true) goto L182;
    L176:
        r9.useNode();
        goto L177
    L163:
        if (r43 == Composer.Companion.getEmpty()) goto L166;
        r44 = r113;
        goto L167
    L153:
        if (r33.containsKey(r20.getCurrentState()) == false) goto L156;
        r9.startReplaceGroup(1969054067);
        r9.endReplaceGroup();
        r40 = r33;
        r113 = r6;
        goto L160
    L117:
        if (r32 != Composer.Companion.getEmpty()) goto L119;
    L113:
        r31 = false;
        goto L114
    L108:
        if (r30 != Composer.Companion.getEmpty()) goto L110;
    L104:
        r29 = false;
        goto L105
    L99:
        if (r18 != Composer.Companion.getEmpty()) goto L101;
    L95:
        r17 = false;
        goto L96
    L76:
        r10 = r4;
        goto L77
    L193:
        r9.skipToGroupEnd();
        r62 = r4;
        r61 = r6;
        goto L194
    L71:
        r2 = false;
        goto L73
    L61:
        if ((r27 & 196608) != 0) goto L69;
        if (r9.changedInstance(r25) == false) goto L65;
        int r114 = 131072;
    L66:
        r1 = r1 | r114;
        goto L69
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r27 & 24576) != 0) goto L56;
        r14 = r24;
        if (r9.changedInstance(r14) == false) goto L54;
        int r115 = 16384;
    L55:
        r1 = r1 | r115;
        goto L58
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r27 & 3072) != 0) goto L45;
        r12 = r23;
        if (r9.changed(r12) == false) goto L43;
        int r116 = 2048;
    L44:
        r1 = r1 | r116;
        goto L46
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r27 & 384) != 0) goto L34;
        r6 = r22;
        if (r9.changedInstance(r6) == false) goto L32;
        int r117 = 256;
    L33:
        r1 = r1 | r117;
        goto L35
    L32:
        r117 = 128;
        goto L33
    L17:
        if ((r27 & 48) != 0) goto L23;
        r4 = r21;
        if (r9.changed(r4) == false) goto L21;
        int r66 = 32;
    L22:
        r1 = r1 | r66;
        goto L24
    L21:
        r66 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r1 = r27;
        goto L13
    L8:
        if (r9.changed(r20) == false) goto L10;
        int r67 = 4;
    L11:
        r1 = r67 | r27;
        goto L13
    L10:
        r67 = 2;
        goto L11
    }

    public static final <S> void AnimatedContent(final S r19, Modifier r20, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r21, Alignment r22, String r23, Function1<? super S, ? extends Object> r24, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> r25, Composer r26, final int r27, final int r28) {
        Composer r2 = r26.startRestartGroup(1501828832);
        if ((r28 & 1) == 0) goto L6;
        int r3 = r27 | 6;
    L16:
        int r4 = r28 & 2;
        if (r4 == 0) goto L20;
        r3 = r3 | 48;
    L27:
        int r6 = r28 & 4;
        if (r6 == 0) goto L31;
        r3 = r3 | 384;
    L38:
        int r9 = r28 & 8;
        if (r9 == 0) goto L42;
        r3 = r3 | 3072;
    L48:
        Alignment r10 = r22;
    L49:
        int r11 = r28 & 16;
        if (r11 == 0) goto L53;
        r3 = r3 | 24576;
    L59:
        String r12 = r23;
    L60:
        int r13 = r28 & 32;
        if (r13 == 0) goto L64;
        r3 = r3 | 196608;
    L70:
        Function1<? super S, ? extends Object> r14 = r24;
    L72:
        if ((r28 & 64) == 0) goto L75;
        r3 = r3 | 1572864;
    L83:
        if ((r3 & 599187) == 599186) goto L85;
        boolean r0 = true;
    L87:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L116;
        if (r4 == 0) goto L90;
        Modifier r1 = Modifier.Companion;
    L91:
        if (r6 == 0) goto L96;
        Object r5 = r2.rememberedValue();
        if (r5 != Composer.Companion.getEmpty()) goto L95;
        r5 = AnimatedContentKt$AnimatedContent$1$1.INSTANCE;
        r2.updateRememberedValue(r5);
    L95:
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r7 = (Function1) r5;
    L97:
        if (r9 == 0) goto L99;
        Alignment r8 = Alignment.Companion.getTopStart();
    L100:
        if (r11 == 0) goto L102;
        String r15 = "AnimatedContent";
    L103:
        if (r13 == 0) goto L108;
        Object r16 = r2.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L107;
        r16 = AnimatedContentKt$AnimatedContent$2$1.INSTANCE;
        r2.updateRememberedValue(r16);
    L107:
        Function1<? super S, ? extends Object> r18 = (Function1) r16;
    L110:
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(1501828832, r3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
    L112:
        Transition r17 = androidx.compose.animation.core.TransitionKt.updateTransition(r19, r15, r2, ((r3 & 8) | (r3 & 14)) | ((r3 >> 9) & 112), 0);
        int r29 = ((r3 & 112) | (r3 & 896)) | (r3 & 7168);
        int r30 = r3 >> 3;
        int r110 = (r29 | (57344 & r30)) | (r30 & 458752);
        AnimatedContent(r17, r1, r7, r8, r18, r25, r2, r110, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
    L115:
        Modifier r31 = r1;
        r10 = r8;
        final String r32 = r15;
        final Function1<? super S, ? extends Object> r33 = r18;
    L117:
        ScopeUpdateScope r111 = r2.endRestartGroup();
        if (r111 == null) goto L121;
        final Modifier r34 = r31;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> r35 = r7;
        final Alignment r36 = r10;
        r111.updateScope(new AnonymousClass3(r19, r34, r35, r36, r32, r33, r25, r27, r28));
        return;
    L121:
        return;
    L108:
        r18 = r14;
        goto L110
    L102:
        r15 = r12;
        goto L103
    L99:
        r8 = r10;
        goto L100
    L96:
        r7 = r21;
        goto L97
    L90:
        r1 = r20;
        goto L91
    L116:
        r2.skipToGroupEnd();
        r31 = r20;
        r7 = r21;
        r32 = r12;
        r33 = r14;
        goto L117
    L85:
        r0 = false;
        goto L87
    L75:
        if ((r27 & 1572864) != 0) goto L83;
        if (r2.changedInstance(r25) == false) goto L79;
        int r112 = 1048576;
    L80:
        r3 = r3 | r112;
        goto L83
    L79:
        r112 = 524288;
        goto L80
    L64:
        if ((196608 & r27) != 0) goto L70;
        r14 = r24;
        if (r2.changedInstance(r14) == false) goto L68;
        int r113 = 131072;
    L69:
        r3 = r3 | r113;
        goto L72
    L68:
        r113 = 65536;
        goto L69
    L53:
        if ((r27 & 24576) != 0) goto L59;
        r12 = r23;
        if (r2.changed(r12) == false) goto L57;
        int r114 = 16384;
    L58:
        r3 = r3 | r114;
        goto L60
    L57:
        r114 = 8192;
        goto L58
    L42:
        if ((r27 & 3072) != 0) goto L48;
        r10 = r22;
        if (r2.changed(r10) == false) goto L46;
        int r115 = 2048;
    L47:
        r3 = r3 | r115;
        goto L49
    L46:
        r115 = 1024;
        goto L47
    L31:
        if ((r27 & 384) != 0) goto L38;
        if (r2.changedInstance(r21) == false) goto L35;
        int r37 = 256;
    L36:
        r3 = r3 | r37;
        goto L38
    L35:
        r37 = 128;
        goto L36
    L20:
        if ((r27 & 48) != 0) goto L27;
        if (r2.changed(r20) == false) goto L24;
        int r38 = 32;
    L25:
        r3 = r3 | r38;
        goto L27
    L24:
        r38 = 16;
        goto L25
    L6:
        if ((r27 & 6) == 0) goto L8;
        r3 = r27;
        goto L16
    L8:
        if ((r27 & 8) != 0) goto L10;
        boolean r39 = r2.changed(r19);
    L11:
        if (r39 == false) goto L13;
        int r40 = 4;
    L14:
        r3 = r40 | r27;
        goto L16
    L13:
        r40 = 2;
        goto L14
    L10:
        r39 = r2.changedInstance(r19);
        goto L11
    }
}
