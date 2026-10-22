package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u001a:\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u0015\u001a9\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003¢\u0006\u0002\u0010!\u001a)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010#\"\u000e\u0010$\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000*b\b\u0002\u0010\u0016\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¨\u0006("}, d2 = {"SnackbarHost", "", "hostState", "Landroidx/compose/material/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "snackbar", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarData;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "toMillis", "", "Landroidx/compose/material/SnackbarDuration;", "hasAction", "", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutWithScale", "current", "content", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FadeInFadeOutTransition", "Lkotlin/Function0;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "onAnimationFinish", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

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
        ComposerKt.traceEventStart(2003504988, r10, -1, "androidx.compose.material.animatedScale (SnackbarHost.kt:350)");
    L5:
        Object r0 = r9.rememberedValue();
        Composer.Companion r1 = Composer.Companion;
        if (r0 != r1.getEmpty()) goto L11;
        if (r8 == true) goto L9;
        float r2 = 1.0f;
    L10:
        r0 = AnimatableKt.Animatable$default(r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
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

    private static final void FadeInFadeOutWithScale(final SnackbarData r21, Modifier r22, final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r9 = r24.startRestartGroup(1354335728);
        if ((r26 & 1) == 0) goto L6;
        int r1 = r25 | 6;
    L16:
        int r2 = r26 & 2;
        if (r2 == 0) goto L20;
        r1 = r1 | 48;
    L26:
        Modifier r3 = r22;
    L28:
        if ((r26 & 4) == 0) goto L31;
        r1 = r1 | 384;
    L38:
        if ((r1 & 147) == 146) goto L40;
        boolean r4 = true;
    L42:
        if (r9.shouldExecute(r4, r1 & 1) == false) goto L84;
        if (r2 == 0) goto L45;
        Modifier r12 = Modifier.Companion;
    L47:
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventStart(1354335728, r1, -1, "androidx.compose.material.FadeInFadeOutWithScale (SnackbarHost.kt:245)");
    L49:
        Object r0 = r9.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L52;
        r0 = new FadeInFadeOutState();
        r9.updateRememberedValue(r0);
    L52:
        FadeInFadeOutState r13 = (FadeInFadeOutState) r0;
        String r15 = Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2173getSnackbarPaneTitleUdPEhr4(), r9, 6);
        if (Intrinsics.areEqual(r21, r13.getCurrent()) == true) goto L64;
        r9.startReplaceGroup(141556995);
        r13.setCurrent(r21);
        List r5 = r13.getItems();
        ArrayList r6 = new ArrayList(r5.size());
        int r7 = r5.size();
        int r8 = 0;
    L55:
        if (r8 >= r7) goto L57;
        r6.add((SnackbarData) ((FadeInFadeOutAnimationItem) ListProtector.get(r5, r8)).getKey());
        r8 = r8 + 1;
        goto L55
    L57:
        List r10 = CollectionsKt.toMutableList(r6);
        if (r10.contains(r21) == true) goto L60;
        r10.add(r21);
    L60:
        r13.getItems().clear();
        List r11 = ListUtilsKt.fastFilterNotNull(r10);
        List r14 = r13.getItems();
        int r16 = r11.size();
        int r17 = 0;
    L61:
        if (r17 >= r16) goto L63;
        SnackbarData r18 = (SnackbarData) ListProtector.get(r11, r17);
        int r19 = r17;
        List r20 = r14;
        List r110 = r11;
        r20.add(new FadeInFadeOutAnimationItem(r18, ComposableLambdaKt.rememberComposableLambda(-1032415134, true, new SnackbarHostKt$FadeInFadeOutWithScale$1$1(r18, r21, r10, r13, r15), r9, 54)));
        r17 = r19 + 1;
        r14 = r20;
        r16 = r16;
        r11 = r110;
        r10 = r10;
        goto L61
    L63:
        int r27 = 54;
        r9.endReplaceGroup();
    L65:
        MeasurePolicy r28 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r29 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r30 = r9.getCurrentCompositionLocalMap();
        Modifier r31 = ComposedModifierKt.materializeModifier(r9, r12);
        ComposeUiNode.Companion r32 = ComposeUiNode.Companion;
        Function0 r33 = r32.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L68;
        ComposablesKt.invalidApplier();
    L68:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L71;
        r9.createNode(r33);
    L72:
        Composer r34 = Updater.constructor-impl(r9);
        Updater.set-impl(r34, r28, r32.getSetMeasurePolicy());
        Updater.set-impl(r34, r30, r32.getSetResolvedCompositionLocals());
        Function2 r35 = r32.getSetCompositeKeyHash();
        if (r34.getInserting() == false) goto L75;
    L76:
        r34.updateRememberedValue(Integer.valueOf(r29));
        r34.apply(Integer.valueOf(r29), r35);
    L77:
        Updater.set-impl(r34, r31, r32.getSetModifier());
        BoxScopeInstance r36 = BoxScopeInstance.INSTANCE;
        r13.setScope(ComposablesKt.getCurrentRecomposeScope(r9, 0));
        r9.startReplaceGroup(-1757732554);
        List r37 = r13.getItems();
        int r38 = r37.size();
        int r111 = 0;
    L78:
        if (r111 >= r38) goto L80;
        FadeInFadeOutAnimationItem r39 = (FadeInFadeOutAnimationItem) ListProtector.get(r37, r111);
        final SnackbarData r40 = (SnackbarData) r39.component1();
        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> r41 = r39.component2();
        r9.startMovableGroup(-1515535286, r40);
        r41.invoke(ComposableLambdaKt.rememberComposableLambda(2017516783, true, new SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(r23, r40), r9, r27), r9, 6);
        r9.endMovableGroup();
        r111 = r111 + 1;
        goto L78
    L80:
        r9.endReplaceGroup();
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventEnd();
    L83:
        final Modifier r42 = r12;
    L85:
        ScopeUpdateScope r43 = r9.endRestartGroup();
        if (r43 == null) goto L92;
        r43.updateScope(new ga(r21, r42, r23, r25, r26));
        return;
    L92:
        return;
    L75:
        if (Intrinsics.areEqual(r34.rememberedValue(), Integer.valueOf(r29)) == true) goto L77;
    L71:
        r9.useNode();
        goto L72
    L64:
        r27 = 54;
        r9.startReplaceGroup(95900978);
        r9.endReplaceGroup();
        goto L65
    L45:
        r12 = r3;
        goto L47
    L84:
        r9.skipToGroupEnd();
        r42 = r3;
        goto L85
    L40:
        r4 = false;
        goto L42
    L31:
        if ((r25 & 384) != 0) goto L38;
        if (r9.changedInstance(r23) == false) goto L35;
        int r44 = 256;
    L36:
        r1 = r1 | r44;
        goto L38
    L35:
        r44 = 128;
        goto L36
    L20:
        if ((r25 & 48) != 0) goto L26;
        r3 = r22;
        if (r9.changed(r3) == false) goto L24;
        int r45 = 32;
    L25:
        r1 = r1 | r45;
        goto L28
    L24:
        r45 = 16;
        goto L25
    L6:
        if ((r25 & 6) == 0) goto L8;
        r1 = r25;
        goto L16
    L8:
        if ((r25 & 8) != 0) goto L10;
        boolean r46 = r9.changed(r21);
    L11:
        if (r46 == false) goto L13;
        int r47 = 4;
    L14:
        r1 = r47 | r25;
        goto L16
    L13:
        r47 = 2;
        goto L14
    L10:
        r46 = r9.changedInstance(r21);
        goto L11
    }

    public static final void SnackbarHost(final SnackbarHostState r7, Modifier r8, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(1351125615);
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
        r9 = ComposableSingletons$SnackbarHostKt.INSTANCE.getLambda$1890101041$material();
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(1351125615, r1, -1, "androidx.compose.material.SnackbarHost (SnackbarHost.kt:155)");
    L46:
        SnackbarData r0 = r7.getCurrentSnackbarData();
        AccessibilityManager r5 = (AccessibilityManager) r13.consume(CompositionLocalsKt.getLocalAccessibilityManager());
        boolean r6 = r13.changedInstance(r0) | r13.changedInstance(r5);
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
        r18.updateScope(new fa(r7, r16, r17, r11, r12));
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
        r13 = new ha();
        r10.updateRememberedValue(r13);
    L7:
        r9 = (Function0) r13;
    L8:
        Function0<Unit> r4 = r9;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1016418159, r11, -1, "androidx.compose.material.animatedOpacity (SnackbarHost.kt:340)");
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
        r14 = AnimatableKt.Animatable$default(r20, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        r10.updateRememberedValue(r14);
        goto L18
    L16:
        r20 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L17
    }
}
