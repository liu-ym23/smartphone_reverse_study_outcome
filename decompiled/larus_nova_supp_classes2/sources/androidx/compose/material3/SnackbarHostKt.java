package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u001a:\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u0015\u001a9\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003¢\u0006\u0002\u0010!\u001a)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010#*b\b\u0002\u0010\u0016\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¨\u0006$"}, d2 = {"SnackbarHost", "", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "snackbar", "Lkotlin/Function1;", "Landroidx/compose/material3/SnackbarData;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutWithScale", "current", "content", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FadeInFadeOutTransition", "Lkotlin/Function0;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "onAnimationFinish", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SnackbarDuration.values().length];
            r0[SnackbarDuration.Indefinite.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SnackbarDuration.Long.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SnackbarDuration.Short.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit FadeInFadeOutWithScale$lambda$7(SnackbarData r6, Modifier r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        FadeInFadeOutWithScale(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit SnackbarHost$lambda$1(SnackbarHostState r6, Modifier r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        SnackbarHost(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a() {
        return animatedOpacity$lambda$9$lambda$8();
    }

    public static /* synthetic */ Unit b(SnackbarData r0, Modifier r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return FadeInFadeOutWithScale$lambda$7(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit c(SnackbarHostState r0, Modifier r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return SnackbarHost$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final Unit animatedOpacity$lambda$9$lambda$8() {
        return Unit.INSTANCE;
    }

    public static final long toMillis(SnackbarDuration r8, boolean r9, AccessibilityManager r10) {
        int r11 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r11 != 1) goto L5;
        long r0 = Long.MAX_VALUE;
    L13:
        long r3 = r0;
        if (r10 != null) goto L17;
        return r3;
    L17:
        return r10.calculateRecommendedTimeoutMillis(r3, true, true, r9);
    L5:
        if (r11 != 2) goto L7;
        r0 = 10000;
        goto L13
    L7:
        if (r11 != 3) goto L10;
        r0 = 4000;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ State access$animatedScale(AnimationSpec r0, boolean r1, Composer r2, int r3) {
        return animatedScale(r0, r1, r2, r3);
    }

    private static final State<Float> animatedScale(AnimationSpec<Float> r7, boolean r8, Composer r9, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1966809761, r10, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:415)");
    L5:
        Object r0 = r9.rememberedValue();
        Composer.Companion r1 = Composer.Companion;
        if (r0 != r1.getEmpty()) goto L11;
        if (r8 == true) goto L9;
        float r2 = 1.0f;
    L10:
        r0 = AnimatableKt.Animatable$default(r2, MenuKt.ClosedAlphaTarget, 2, null);
        r9.updateRememberedValue(r0);
        goto L11
    L9:
        r2 = 0.8f;
    L11:
        Animatable r3 = (Animatable) r0;
        Boolean r4 = Boolean.valueOf(r8);
        boolean r5 = r9.changedInstance(r3);
        if (((r10 & 112) ^ 48) <= 32) goto L16;
        if (r9.changed(r8) == false) goto L16;
    L17:
        boolean r6 = true;
    L19:
        boolean r11 = (r5 | r6) | r9.changedInstance(r7);
        Object r12 = r9.rememberedValue();
        if (r11 == false) goto L22;
    L23:
        r12 = new SnackbarHostKt$animatedScale$1$1(r3, r8, r7, null);
        r9.updateRememberedValue(r12);
    L24:
        EffectsKt.LaunchedEffect(r4, (Function2) r12, r9, (r10 >> 3) & 14);
        State<Float> r13 = r3.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventEnd();
    L27:
        return r13;
    L22:
        if (r12 != r1.getEmpty()) goto L24;
    L16:
        if ((r10 & 48) == 32) goto L17;
        r6 = false;
        goto L19
    }

    private static final void FadeInFadeOutWithScale(final SnackbarData r16, Modifier r17, final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20, final int r21) {
        Composer r2 = r19.startRestartGroup(-977568115);
        if ((r21 & 1) == 0) goto L6;
        int r5 = r20 | 6;
    L13:
        int r6 = r21 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Modifier r7 = r17;
    L25:
        if ((r21 & 4) == 0) goto L28;
        r5 = r5 | 384;
    L35:
        if ((r5 & 147) == 146) goto L37;
        boolean r8 = true;
    L39:
        if (r2.shouldExecute(r8, r5 & 1) == false) goto L80;
        if (r6 == 0) goto L42;
        Modifier r9 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-977568115, r5, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:326)");
    L46:
        String r0 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911757), r2, 0);
        Object r10 = r2.rememberedValue();
        if (r10 != Composer.Companion.getEmpty()) goto L49;
        r10 = new FadeInFadeOutState();
        r2.updateRememberedValue(r10);
    L49:
        FadeInFadeOutState r11 = (FadeInFadeOutState) r10;
        if (Intrinsics.areEqual(r16, r11.getCurrent()) == true) goto L61;
        r2.startReplaceGroup(1154891761);
        r11.setCurrent(r16);
        List r12 = r11.getItems();
        ArrayList r13 = new ArrayList(r12.size());
        int r14 = r12.size();
        int r15 = 0;
    L52:
        if (r15 >= r14) goto L54;
        r13.add((SnackbarData) ((FadeInFadeOutAnimationItem) ListProtector.get(r12, r15)).getKey());
        r15 = r15 + 1;
        goto L52
    L54:
        List r22 = CollectionsKt.toMutableList(r13);
        if (r22.contains(r16) == true) goto L57;
        r22.add(r16);
    L57:
        r11.getItems().clear();
        List r23 = ListUtilsKt.fastFilterNotNull(r22);
        List r24 = r11.getItems();
        int r110 = r23.size();
        int r111 = 0;
    L58:
        if (r111 >= r110) goto L60;
        SnackbarData r112 = (SnackbarData) ListProtector.get(r23, r111);
        String r113 = r0;
        r24.add(new FadeInFadeOutAnimationItem(r112, ComposableLambdaKt.rememberComposableLambda(-1952400805, true, new SnackbarHostKt$FadeInFadeOutWithScale$1$1(r112, r16, r11, r0), r2, 54)));
        r111 = r111 + 1;
        r0 = r113;
        goto L58
    L60:
        r2.endReplaceGroup();
    L62:
        MeasurePolicy r1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r25 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r26 = r2.getCurrentCompositionLocalMap();
        Modifier r114 = ComposedModifierKt.materializeModifier(r2, r9);
        ComposeUiNode.Companion r115 = ComposeUiNode.Companion;
        Function0 r116 = r115.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L65;
        ComposablesKt.invalidApplier();
    L65:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L68;
        r2.createNode(r116);
    L69:
        Composer r117 = Updater.constructor-impl(r2);
        Updater.set-impl(r117, r1, r115.getSetMeasurePolicy());
        Updater.set-impl(r117, r26, r115.getSetResolvedCompositionLocals());
        Function2 r3 = r115.getSetCompositeKeyHash();
        if (r117.getInserting() == false) goto L72;
    L73:
        r117.updateRememberedValue(Integer.valueOf(r25));
        r117.apply(Integer.valueOf(r25), r3);
    L74:
        Updater.set-impl(r117, r114, r115.getSetModifier());
        BoxScopeInstance r4 = BoxScopeInstance.INSTANCE;
        r11.setScope(ComposablesKt.getCurrentRecomposeScope(r2, 0));
        r2.startReplaceGroup(-1888182177);
        List r27 = r11.getItems();
        int r28 = r27.size();
        int r118 = 0;
    L75:
        if (r118 >= r28) goto L77;
        FadeInFadeOutAnimationItem r29 = (FadeInFadeOutAnimationItem) ListProtector.get(r27, r118);
        final SnackbarData r30 = (SnackbarData) r29.component1();
        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> r31 = r29.component2();
        r2.startMovableGroup(1325010085, r30);
        r31.invoke(ComposableLambdaKt.rememberComposableLambda(-1893791890, true, new SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(r18, r30), r2, 54), r2, 6);
        r2.endMovableGroup();
        r118 = r118 + 1;
        goto L75
    L77:
        r2.endReplaceGroup();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventEnd();
    L81:
        ScopeUpdateScope r32 = r2.endRestartGroup();
        if (r32 == null) goto L88;
        final Modifier r33 = r9;
        r32.updateScope(new rq(r16, r33, r18, r20, r21));
        return;
    L88:
        return;
    L72:
        if (Intrinsics.areEqual(r117.rememberedValue(), Integer.valueOf(r25)) == true) goto L74;
    L68:
        r2.useNode();
        goto L69
    L61:
        r2.startReplaceGroup(1443908949);
        r2.endReplaceGroup();
        goto L62
    L42:
        r9 = r7;
        goto L44
    L80:
        r2.skipToGroupEnd();
        r9 = r7;
        goto L81
    L37:
        r8 = false;
        goto L39
    L28:
        if ((r20 & 384) != 0) goto L35;
        if (r2.changedInstance(r18) == false) goto L32;
        int r34 = 256;
    L33:
        r5 = r5 | r34;
        goto L35
    L32:
        r34 = 128;
        goto L33
    L17:
        if ((r20 & 48) != 0) goto L23;
        r7 = r17;
        if (r2.changed(r7) == false) goto L21;
        int r35 = 32;
    L22:
        r5 = r5 | r35;
        goto L25
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r20 & 6) == 0) goto L8;
        r5 = r20;
        goto L13
    L8:
        if (r2.changed(r16) == false) goto L10;
        int r36 = 4;
    L11:
        r5 = r36 | r20;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    public static final void SnackbarHost(final SnackbarHostState r7, Modifier r8, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(-1077081618);
        if ((r12 & 1) == 0) goto L6;
        int r1 = r11 | 6;
    L13:
        int r2 = r12 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r12 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r1 & 147) == 146) goto L36;
        boolean r4 = true;
    L38:
        if (r13.shouldExecute(r4, r1 & 1) == false) goto L54;
        if (r2 == 0) goto L41;
        r8 = Modifier.Companion;
    L41:
        if (r3 == 0) goto L44;
        r9 = ComposableSingletons$SnackbarHostKt.INSTANCE.m2539getLambda$1548712596$material3();
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-1077081618, r1, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:220)");
    L46:
        SnackbarData r0 = r7.getCurrentSnackbarData();
        AccessibilityManager r5 = (AccessibilityManager) r13.consume(CompositionLocalsKt.getLocalAccessibilityManager());
        boolean r6 = r13.changed(r0) | r13.changedInstance(r5);
        Object r14 = r13.rememberedValue();
        if (r6 == false) goto L49;
    L50:
        r14 = new SnackbarHostKt$SnackbarHost$1$1(r0, r5, null);
        r13.updateRememberedValue(r14);
    L51:
        EffectsKt.LaunchedEffect(r0, (Function2) r14, r13, 0);
        int r15 = (r1 & 112) | (r1 & 896);
        FadeInFadeOutWithScale(r7.getCurrentSnackbarData(), r8, r9, r13, r15, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventEnd();
    L55:
        final Modifier r16 = r8;
        final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> r17 = r9;
        ScopeUpdateScope r18 = r13.endRestartGroup();
        if (r18 == null) goto L59;
        r18.updateScope(new sq(r7, r16, r17, r11, r12));
        return;
    L59:
        return;
    L49:
        if (r14 != Composer.Companion.getEmpty()) goto L51;
    L54:
        r13.skipToGroupEnd();
        goto L55
    L36:
        r4 = false;
        goto L38
    L27:
        if ((r11 & 384) != 0) goto L34;
        if (r13.changedInstance(r9) == false) goto L31;
        int r19 = 256;
    L32:
        r1 = r1 | r19;
        goto L34
    L31:
        r19 = 128;
        goto L32
    L17:
        if ((r11 & 48) != 0) goto L23;
        if (r13.changed(r8) == false) goto L21;
        int r20 = 32;
    L22:
        r1 = r1 | r20;
        goto L23
    L21:
        r20 = 16;
        goto L22
    L6:
        if ((r11 & 6) == 0) goto L8;
        r1 = r11;
        goto L13
    L8:
        if (r13.changed(r7) == false) goto L10;
        int r21 = 4;
    L11:
        r1 = r21 | r11;
        goto L13
    L10:
        r21 = 2;
        goto L11
    }

    public static final /* synthetic */ State access$animatedOpacity(AnimationSpec r0, boolean r1, Function0 r2, Composer r3, int r4, int r5) {
        return animatedOpacity(r0, r1, r2, r3, r4, r5);
    }

    private static final State<Float> animatedOpacity(AnimationSpec<Float> r7, boolean r8, Function0<Unit> r9, Composer r10, int r11, int r12) {
        if ((r12 & 4) == 0) goto L8;
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L7;
        r13 = new qq();
        r10.updateRememberedValue(r13);
    L7:
        r9 = (Function0) r13;
    L8:
        Function0<Unit> r4 = r9;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1431889134, r11, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:405)");
    L11:
        Object r14 = r10.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r14 == r15.getEmpty()) goto L14;
    L18:
        Animatable r16 = (Animatable) r14;
        Boolean r6 = Boolean.valueOf(r8);
        boolean r0 = r10.changedInstance(r16);
        boolean r2 = false;
        if (((r11 & 112) ^ 48) <= 32) goto L23;
        if (r10.changed(r8) == false) goto L23;
    L24:
        boolean r1 = true;
    L26:
        boolean r3 = (r0 | r1) | r10.changedInstance(r7);
        if (((r11 & 896) ^ 384) <= 256) goto L31;
        if (r10.changed(r4) == false) goto L31;
    L32:
        r2 = true;
    L33:
        boolean r5 = r3 | r2;
        Object r17 = r10.rememberedValue();
        if (r5 == false) goto L36;
    L37:
        SnackbarHostKt$animatedOpacity$2$1 r18 = new SnackbarHostKt$animatedOpacity$2$1(r16, r8, r7, r4, null);
        r10.updateRememberedValue(r18);
        r17 = r18;
    L38:
        EffectsKt.LaunchedEffect(r6, (Function2) r17, r10, (r11 >> 3) & 14);
        State<Float> r19 = r16.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
    L41:
        return r19;
    L36:
        if (r17 != r15.getEmpty()) goto L38;
    L31:
        if ((r11 & 384) != 256) goto L33;
    L23:
        if ((r11 & 48) == 32) goto L24;
        r1 = false;
        goto L26
    L14:
        if (r8 == true) goto L16;
        float r20 = 1.0f;
    L17:
        r14 = AnimatableKt.Animatable$default(r20, MenuKt.ClosedAlphaTarget, 2, null);
        r10.updateRememberedValue(r14);
        goto L18
    L16:
        r20 = MenuKt.ClosedAlphaTarget;
        goto L17
    }
}
