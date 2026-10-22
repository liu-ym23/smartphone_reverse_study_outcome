package androidx.compose.foundation.text.selection;

import androidx.autofill.HintConstants;
import androidx.collection.SieveCacheKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122'\u0010\u0013\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0000\u001a!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0003¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c²\u0006\n\u0010\u0017\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Offset;", "getUnspecifiedSafeOffsetVectorConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "OffsetDisplacementThreshold", "getOffsetDisplacementThreshold", "()J", "J", "MagnifierSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getMagnifierSpringSpec", "()Landroidx/compose/animation/core/SpringSpec;", "animatedSelectionMagnifier", "Landroidx/compose/ui/Modifier;", "magnifierCenter", "Lkotlin/Function0;", "platformMagnifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animatedCenter", "rememberAnimatedMagnifierPosition", "Landroidx/compose/runtime/State;", "targetCalculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release", "targetValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionMagnifierKt {
    private static final SpringSpec<Offset> MagnifierSpringSpec = null;
    private static final long OffsetDisplacementThreshold = 0;
    private static final AnimationVector2D UnspecifiedAnimationVector2D = null;
    private static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = null;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ Function0<Offset> $magnifierCenter;
        final /* synthetic */ Function1<Function0<Offset>, Modifier> $platformMagnifier;

        public AnonymousClass1(Function0<Offset> r1, Function1<? super Function0<Offset>, ? extends Modifier> r2) {
            this.$magnifierCenter = r1;
            this.$platformMagnifier = r2;
        }

        public static /* synthetic */ Offset a(State r0) {
            return invoke$lambda$2$lambda$1(r0);
        }

        private static final long invoke$lambda$0(State<Offset> r2) {
            return ((Offset) r2.getValue()).unbox-impl();
        }

        private static final Offset invoke$lambda$2$lambda$1(State r2) {
            return Offset.box-impl(invoke$lambda$0(r2));
        }

        public final Modifier invoke(Modifier r3, Composer r4, int r5) {
            r4.startReplaceGroup(759876635);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(759876635, r5, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:64)");
        L5:
            final State r6 = SelectionMagnifierKt.access$rememberAnimatedMagnifierPosition(this.$magnifierCenter, r4, 0);
            Function1<Function0<Offset>, Modifier> r7 = this.$platformMagnifier;
            boolean r0 = r4.changed(r6);
            Object r1 = r4.rememberedValue();
            if (r0 == false) goto L8;
        L9:
            r1 = new m0(r6);
            r4.updateRememberedValue(r1);
        L10:
            Modifier r8 = (Modifier) r7.invoke((Function0) r1);
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            r4.endReplaceGroup();
            return r8;
        L8:
            if (r1 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }
    }

    public static /* synthetic */ AnimationVector2D a(Offset r0) {
        return UnspecifiedSafeOffsetVectorConverter$lambda$0(r0);
    }

    public static /* synthetic */ Offset b(AnimationVector2D r0) {
        return UnspecifiedSafeOffsetVectorConverter$lambda$1(r0);
    }

    static {
        UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
        UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(new k0(), new l0());
        long r0 = Offset.constructor-impl((Float.floatToRawIntBits(0.01f) << 32) | (Float.floatToRawIntBits(0.01f) & 4294967295L));
        OffsetDisplacementThreshold = r0;
        MagnifierSpringSpec = new SpringSpec(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Offset.box-impl(r0), 3, null);
    }

    public static final SpringSpec<Offset> getMagnifierSpringSpec() {
        return MagnifierSpringSpec;
    }

    public static final long getOffsetDisplacementThreshold() {
        return OffsetDisplacementThreshold;
    }

    public static final TwoWayConverter<Offset, AnimationVector2D> getUnspecifiedSafeOffsetVectorConverter() {
        return UnspecifiedSafeOffsetVectorConverter;
    }

    private static final AnimationVector2D UnspecifiedSafeOffsetVectorConverter$lambda$0(Offset r6) {
        if ((r6.unbox-impl() & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return new AnimationVector2D(Float.intBitsToFloat((int) (r6.unbox-impl() >> 32)), Float.intBitsToFloat((int) (r6.unbox-impl() & 4294967295L)));
    L9:
        return UnspecifiedAnimationVector2D;
    L5:
        r0 = false;
        goto L6
    }

    private static final Offset UnspecifiedSafeOffsetVectorConverter$lambda$1(AnimationVector2D r6) {
        float r0 = r6.getV1();
        float r7 = r6.getV2();
        return Offset.box-impl(Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L)));
    }

    public static final /* synthetic */ long access$rememberAnimatedMagnifierPosition$lambda$3(State r2) {
        return rememberAnimatedMagnifierPosition$lambda$3(r2);
    }

    private static final long rememberAnimatedMagnifierPosition$lambda$3(State<Offset> r2) {
        return ((Offset) r2.getValue()).unbox-impl();
    }

    public static final /* synthetic */ State access$rememberAnimatedMagnifierPosition(Function0 r0, Composer r1, int r2) {
        return rememberAnimatedMagnifierPosition(r0, r1, r2);
    }

    public static final Modifier animatedSelectionMagnifier(Modifier r1, Function0<Offset> r2, Function1<? super Function0<Offset>, ? extends Modifier> r3) {
        return ComposedModifierKt.composed$default(r1, null, new AnonymousClass1(r2, r3), 1, null);
    }

    private static final State<Offset> rememberAnimatedMagnifierPosition(Function0<Offset> r9, Composer r10, int r11) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1589795249, r11, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:73)");
    L5:
        Object r12 = r10.rememberedValue();
        Composer.Companion r0 = Composer.Companion;
        if (r12 != r0.getEmpty()) goto L8;
        r12 = SnapshotStateKt.derivedStateOf(r9);
        r10.updateRememberedValue(r12);
    L8:
        State r13 = (State) r12;
        Object r14 = r10.rememberedValue();
        if (r14 != r0.getEmpty()) goto L11;
        r14 = new Animatable(Offset.box-impl(rememberAnimatedMagnifierPosition$lambda$3(r13)), UnspecifiedSafeOffsetVectorConverter, Offset.box-impl(OffsetDisplacementThreshold), null, 8, null);
        r10.updateRememberedValue(r14);
    L11:
        Animatable r15 = (Animatable) r14;
        Unit r1 = Unit.INSTANCE;
        boolean r2 = r10.changedInstance(r15);
        Object r3 = r10.rememberedValue();
        if (r2 == false) goto L14;
    L15:
        r3 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(r13, r15, null);
        r10.updateRememberedValue(r3);
    L16:
        EffectsKt.LaunchedEffect(r1, (Function2) r3, r10, 6);
        State<Offset> r16 = r15.asState();
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventEnd();
    L19:
        return r16;
    L14:
        if (r3 != r0.getEmpty()) goto L16;
        goto L15
    }
}
