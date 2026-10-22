package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0007¢\u0006\u0002\u0010\u000e\u001aI\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0010\u001a\u0002H\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\t2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0002\u0010\u0013\u001a³\u0001\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e28\b\u0002\u0010\u001f\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0 2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070+2\u0006\u0010,\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070-H\u0002\u001aP\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070-2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070 2\u0006\u00100\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002\u001a-\u00101\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020\u00182\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u00102\"*\u00103\u001a\u000204\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u000e\u00109\u001a\u00020:X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"rememberSwipeableState", "Landroidx/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "swipeable", "Landroidx/compose/ui/Modifier;", "state", "anchors", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "thresholds", "Lkotlin/Function2;", "from", "to", "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "findBounds", "", "offset", "", "computeTarget", "lastValue", "velocity", "getOffset", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "SwipeableDeprecation", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwipeableKt {
    private static final String SwipeableDeprecation = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.";

    public static /* synthetic */ SwipeableState a(Object r0, AnimationSpec r1, Function1 r2) {
        return rememberSwipeableState$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ FixedThreshold b(Object r0, Object r1) {
        return swipeable_pPrIpRY$lambda$11(r0, r1);
    }

    public static /* synthetic */ boolean c(Object r0) {
        return rememberSwipeableStateFor$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ DisposableEffectResult d(Object r0, SwipeableState r1, Function1 r2, MutableState r3, DisposableEffectScope r4) {
        return rememberSwipeableStateFor$lambda$10$lambda$9(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean e(Object r0) {
        return rememberSwipeableState$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState r0) {
    }

    private static final boolean rememberSwipeableState$lambda$1$lambda$0(Object r0) {
        return true;
    }

    private static final boolean rememberSwipeableStateFor$lambda$5$lambda$4(Object r0) {
        return true;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(SwipeableState<T> r1) {
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(r1);
    }

    public static final /* synthetic */ List access$findBounds(float r0, Set r1) {
        return findBounds(r0, r1);
    }

    public static final /* synthetic */ Float access$getOffset(Map r0, Object r1) {
        return getOffset(r0, r1);
    }

    private static final List<Float> findBounds(float r13, Set<Float> r14) {
        Set<Float> r15 = r14;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r15.iterator();
    L3:
        boolean r5 = false;
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (((Number) r2).floatValue() > (((double) r13) + 0.001d)) goto L8;
        r5 = true;
    L8:
        if (r5 == false) goto L3;
        r0.add(r2);
        goto L3
    L10:
        Object r3 = null;
        if (r0.isEmpty() == false) goto L13;
        Object r4 = null;
    L21:
        Float r6 = (Float) r4;
        ArrayList r7 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L31;
        Object r8 = r16.next();
        if (((Number) r8).floatValue() < (((double) r13) - 0.001d)) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == false) goto L23;
        r7.add(r8);
        goto L23
    L27:
        r9 = false;
        goto L28
    L31:
        if (r7.isEmpty() == true) goto L42;
        Object r17 = ListProtector.get(r7, 0);
        float r18 = ((Number) r17).floatValue();
        int r10 = CollectionsKt.getLastIndex(r7);
        if (1 > r10) goto L41;
        int r11 = 1;
    L36:
        Object r12 = ListProtector.get(r7, r11);
        float r19 = ((Number) r12).floatValue();
        if (Float.compare(r18, r19) <= 0) goto L39;
        r17 = r12;
        r18 = r19;
    L39:
        if (r11 == r10) goto L41;
        r11 = r11 + 1;
    L41:
        r3 = r17;
    L42:
        Float r20 = (Float) r3;
        if (r6 == null) goto L64;
        if (r20 != null) goto L48;
        return CollectionsKt.listOf(r6);
    L48:
        if (Intrinsics.areEqual(r6, r20) == false) goto L51;
        return CollectionsKt.listOf(r6);
    L51:
        return CollectionsKt.listOf(new Float[]{r6, r20});
    L64:
        return CollectionsKt.listOfNotNull(r20);
    L13:
        r4 = ListProtector.get(r0, 0);
        float r21 = ((Number) r4).floatValue();
        int r22 = CollectionsKt.getLastIndex(r0);
        if (1 > r22) goto L21;
        int r23 = 1;
    L16:
        Object r110 = ListProtector.get(r0, r23);
        float r111 = ((Number) r110).floatValue();
        if (Float.compare(r21, r111) >= 0) goto L19;
        r4 = r110;
        r21 = r111;
    L19:
        if (r23 == r22) goto L21;
        r23 = r23 + 1;
        goto L16
    }

    private static final <T> Float getOffset(Map<Float, ? extends T> r3, T r4) {
        Iterator<T> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        T r0 = r5.next();
        if (Intrinsics.areEqual(((Map.Entry) r0).getValue(), r4) == false) goto L4;
    L9:
        Map.Entry r1 = (Map.Entry) r0;
        if (r1 != null) goto L12;
        return null;
    L12:
        return (Float) r1.getKey();
    L8:
        r0 = null;
        goto L9
    }

    private static final FixedThreshold swipeable_pPrIpRY$lambda$11(Object r1, Object r2) {
        return new FixedThreshold(Dp.constructor-impl(56), null);
    }

    private static final SwipeableState rememberSwipeableState$lambda$3$lambda$2(Object r1, AnimationSpec r2, Function1 r3) {
        return new SwipeableState(r1, r2, r3);
    }

    private static final DisposableEffectResult rememberSwipeableStateFor$lambda$10$lambda$9(Object r0, SwipeableState r1, Function1 r2, MutableState r3, DisposableEffectScope r4) {
        if (Intrinsics.areEqual(r0, r1.getCurrentValue()) == true) goto L6;
        r2.invoke(r1.getCurrentValue());
        r3.setValue(Boolean.valueOf(!((Boolean) r3.getValue()).booleanValue()));
    L6:
        return new SwipeableKt$rememberSwipeableStateFor$lambda$10$lambda$9$$inlined$onDispose$1();
    }

    public static final /* synthetic */ float access$computeTarget(float r0, float r1, Set r2, Function2 r3, float r4, float r5) {
        return computeTarget(r0, r1, r2, r3, r4, r5);
    }

    private static final float computeTarget(float r3, float r4, Set<Float> r5, Function2<? super Float, ? super Float, Float> r6, float r7, float r8) {
        List<Float> r9 = findBounds(r3, r5);
        int r0 = r9.size();
        if (r0 != 0) goto L5;
        return r4;
    L5:
        if (r0 == 1) goto L22;
        float r1 = ((Number) ListProtector.get(r9, 0)).floatValue();
        float r10 = ((Number) ListProtector.get(r9, 1)).floatValue();
        if (r4 > r3) goto L15;
        if (r7 < r8) goto L12;
        return r10;
    L12:
        if (r3 < ((Number) r6.invoke(Float.valueOf(r1), Float.valueOf(r10))).floatValue()) goto L25;
    L24:
        return r10;
    L25:
        return r1;
    L15:
        if (r7 > (-r8)) goto L18;
        return r1;
    L18:
        if (r3 <= ((Number) r6.invoke(Float.valueOf(r10), Float.valueOf(r1))).floatValue()) goto L25;
    L22:
        return ((Number) ListProtector.get(r9, 0)).floatValue();
    }

    @Deprecated(message = SwipeableDeprecation)
    public static final <T> SwipeableState<T> rememberSwipeableState(final T r6, final AnimationSpec<Float> r7, final Function1<? super T, Boolean> r8, Composer r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r7 = SwipeableDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r11 & 4) == 0) goto L12;
        Object r12 = r9.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L10;
        r12 = new hb();
        r9.updateRememberedValue(r12);
    L10:
        r8 = (Function1) r12;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(-1237755169, r10, -1, "androidx.compose.material.rememberSwipeableState (Swipeable.kt:466)");
    L14:
        Object[] r1 = new Object[0];
        Saver<SwipeableState<T>, T> r2 = SwipeableState.Companion.Saver(r7, r8);
        boolean r4 = true;
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changedInstance(r6) == false) goto L19;
    L20:
        boolean r0 = true;
    L22:
        boolean r3 = r0 | r9.changedInstance(r7);
        if (((r10 & 896) ^ 384) <= 256) goto L27;
        if (r9.changed(r8) == false) goto L27;
    L30:
        boolean r13 = r3 | r4;
        Object r5 = r9.rememberedValue();
        if (r13 == false) goto L33;
    L34:
        r5 = new ib(r6, r7, r8);
        r9.updateRememberedValue(r5);
    L35:
        SwipeableState<T> r14 = (SwipeableState) RememberSaveableKt.rememberSaveable(r1, r2, (Function0) r5, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r14;
    L33:
        if (r5 != Composer.Companion.getEmpty()) goto L35;
    L27:
        if ((r10 & 384) == 256) goto L30;
        r4 = false;
    L19:
        if ((r10 & 6) == 4) goto L20;
        r0 = false;
        goto L22
    }

    @Deprecated(message = SwipeableDeprecation)
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(final T r10, final Function1<? super T, Unit> r11, AnimationSpec<Float> r12, Composer r13, int r14, int r15) {
        if ((r15 & 4) == 0) goto L6;
        r12 = SwipeableDefaults.INSTANCE.getAnimationSpec();
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1156387078, r14, -1, "androidx.compose.material.rememberSwipeableStateFor (Swipeable.kt:497)");
    L8:
        Object r16 = r13.rememberedValue();
        Composer.Companion r1 = Composer.Companion;
        if (r16 != r1.getEmpty()) goto L11;
        r16 = new SwipeableState(r10, r12, new fb());
        r13.updateRememberedValue(r16);
    L11:
        final SwipeableState<T> r17 = (SwipeableState) r16;
        Object r18 = r13.rememberedValue();
        if (r18 != r1.getEmpty()) goto L14;
        r18 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r13.updateRememberedValue(r18);
    L14:
        final MutableState r19 = (MutableState) r18;
        Object r2 = r19.getValue();
        int r4 = r14 & 14;
        int r5 = r4 ^ 6;
        boolean r6 = false;
        if (r5 <= 4) goto L19;
        if (r13.changedInstance(r10) == false) goto L19;
    L20:
        boolean r8 = true;
    L22:
        Object r9 = r13.rememberedValue();
        if (r8 == false) goto L25;
    L26:
        r9 = new SwipeableKt$rememberSwipeableStateFor$1$1(r10, r17, null);
        r13.updateRememberedValue(r9);
    L27:
        int r3 = r14 & 8;
        EffectsKt.LaunchedEffect(r10, r2, (Function2) r9, r13, r4 | r3);
        T r7 = r17.getCurrentValue();
        if (r5 <= 4) goto L32;
        if (r13.changedInstance(r10) == false) goto L32;
    L33:
        boolean r0 = true;
    L36:
        if (((r14 & 112) ^ 48) <= 32) goto L40;
        if (r13.changed(r11) == false) goto L40;
    L41:
        r6 = true;
    L42:
        boolean r110 = r0 | r6;
        Object r20 = r13.rememberedValue();
        if (r110 == false) goto L45;
    L46:
        r20 = new gb(r10, r17, r11, r19);
        r13.updateRememberedValue(r20);
    L47:
        EffectsKt.DisposableEffect(r7, (Function1) r20, r13, r3);
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventEnd();
    L50:
        return r17;
    L45:
        if (r20 != r1.getEmpty()) goto L47;
    L40:
        if ((r14 & 48) != 32) goto L42;
    L32:
        if ((r14 & 6) == 4) goto L33;
        r0 = false;
        goto L36
    L25:
        if (r9 != r1.getEmpty()) goto L27;
    L19:
        if ((r14 & 6) == 4) goto L20;
        r8 = false;
        goto L22
    }

    @Deprecated(message = SwipeableDeprecation)
    /* JADX INFO: renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m2184swipeablepPrIpRY(Modifier r12, final SwipeableState<T> r13, final Map<Float, ? extends T> r14, final Orientation r15, final boolean r16, final boolean r17, final MutableInteractionSource r18, final Function2<? super T, ? super T, ? extends ThresholdConfig> r19, final ResistanceConfig r20, final float r21) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L7:
        return ComposedModifierKt.composed(r12, r0, new SwipeableKt$swipeable$3(r14, r13, r20, r19, r21, r15, r16, r18, r17));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: swipeable-pPrIpRY$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2185swipeablepPrIpRY$default(Modifier r16, SwipeableState r17, Map r18, Orientation r19, boolean r20, boolean r21, MutableInteractionSource r22, Function2 r23, ResistanceConfig r24, float r25, int r26, Object r27) {
        if ((r26 & 8) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r26 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r26 & 32) == 0) goto L13;
        MutableInteractionSource r8 = null;
    L15:
        if ((r26 & 64) == 0) goto L17;
        Function2 r9 = new jb();
    L19:
        if ((r26 & 128) == 0) goto L21;
        ResistanceConfig r10 = SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, r18.keySet(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 6, null);
    L23:
        if ((r26 & 256) == 0) goto L25;
        float r11 = SwipeableDefaults.INSTANCE.m2183getVelocityThresholdD9Ej5fM();
    L27:
        return m2184swipeablepPrIpRY(r16, r17, r18, r19, r6, r7, r8, r9, r10, r11);
    L25:
        r11 = r25;
        goto L27
    L21:
        r10 = r24;
        goto L23
    L17:
        r9 = r23;
        goto L19
    L13:
        r8 = r22;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r6 = r20;
        goto L7
    }
}
