package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000f\u0010B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0001\u0010\u000b*\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "<init>", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframesSpecConfig", "KeyframeEntity", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {
    public static final int $stable = 0;
    private final KeyframesSpecConfig<T> config;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "T", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "value", "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArcMode--9T-Mq4$animation_core", "()I", "setArcMode-Rur9ykg$animation_core", "(I)V", "I", "equals", "", "other", "", "hashCode", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class KeyframeEntity<T> extends KeyframeBaseEntity<T> {
        public static final int $stable = 8;
        private int arcMode;

        public /* synthetic */ KeyframeEntity(Object r1, Easing r2, int r3, DefaultConstructorMarker r4) {
            this(r1, r2, r3);
        }

        public int hashCode() {
            T r0 = getValue$animation_core();
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (((r1 * 31) + ArcMode.m257hashCodeimpl(this.arcMode)) * 31) + getEasing$animation_core().hashCode();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: getArcMode--9T-Mq4$animation_core, reason: not valid java name */
        public final int m265getArcMode9TMq4$animation_core() {
            return this.arcMode;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof KeyframeEntity) == true) goto L8;
            return false;
        L8:
            KeyframeEntity r6 = (KeyframeEntity) r5;
            if (Intrinsics.areEqual(r6.getValue$animation_core(), getValue$animation_core()) == true) goto L11;
        L15:
            return false;
        L11:
            if (Intrinsics.areEqual(r6.getEasing$animation_core(), getEasing$animation_core()) == false) goto L15;
            if (ArcMode.m256equalsimpl0(r6.arcMode, this.arcMode) == false) goto L15;
            return true;
        }

        /* JADX INFO: renamed from: setArcMode-Rur9ykg$animation_core, reason: not valid java name */
        public final void m266setArcModeRur9ykg$animation_core(int r1) {
            this.arcMode = r1;
        }

        private KeyframeEntity(T r2, Easing r3, int r4) {
            super(r2, r3, null);
            this.arcMode = r4;
        }

        public /* synthetic */ KeyframeEntity(Object r1, Easing r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = EasingKt.getLinearEasing();
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = ArcMode.Companion.m262getArcLinear9TMq4();
        L8:
            this(r1, r2, r3, null);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0096\u0004¢\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0096\u0004¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0087\u0004J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0004¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "<init>", "()V", "createEntityFor", "value", "createEntityFor$animation_core", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "at", "timeStamp", "", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "with", "", "easing", "Landroidx/compose/animation/core/Easing;", "using", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "using-ngzHuyU", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class KeyframesSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframeEntity<T>> {
        public static final int $stable = 8;

        public KeyframesSpecConfig() {
            super(null);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public KeyframeEntity<T> createEntityFor$animation_core(T r8) {
            return new KeyframeEntity(r8, null, 0, 6, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public /* bridge */ /* synthetic */ KeyframeBaseEntity createEntityFor$animation_core(Object r1) {
            return createEntityFor$animation_core(r1);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public KeyframeEntity<T> at(T r8, int r9) {
            KeyframeEntity<T> r6 = new KeyframeEntity(r8, null, 0, 6, null);
            getKeyframes$animation_core().set(r9, r6);
            return r6;
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public KeyframeEntity<T> atFraction(T r2, float r3) {
            return at(r2, Math.round(getDurationMillis() * r3));
        }

        /* JADX INFO: renamed from: using-ngzHuyU, reason: not valid java name */
        public final KeyframeEntity<T> m267usingngzHuyU(KeyframeEntity<T> r1, int r2) {
            r1.m266setArcModeRur9ykg$animation_core(r2);
            return r1;
        }

        @Deprecated(message = "Use version that returns an instance of the entity so it can be re-used in other keyframe builders.", replaceWith = @ReplaceWith(expression = "this using easing", imports = {}))
        public final void with(KeyframeEntity<T> r1, Easing r2) {
            r1.setEasing$animation_core(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public /* bridge */ /* synthetic */ KeyframeBaseEntity at(Object r1, int r2) {
            return at(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public /* bridge */ /* synthetic */ KeyframeBaseEntity atFraction(Object r1, float r2) {
            return atFraction(r1, r2);
        }
    }

    public final KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    public KeyframesSpec(KeyframesSpecConfig<T> r1) {
        this.config = r1;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(TwoWayConverter<T, V> r21) {
        MutableIntList r2 = new MutableIntList(this.config.getKeyframes$animation_core().getSize() + 2);
        MutableIntObjectMap r3 = new MutableIntObjectMap(this.config.getKeyframes$animation_core().getSize());
        MutableIntObjectMap<KeyframeEntity<T>> r1 = this.config.getKeyframes$animation_core();
        int[] r4 = r1.keys;
        Object[] r5 = r1.values;
        long[] r6 = r1.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L24;
        int r8 = 0;
    L5:
        long r9 = r6[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L20;
        int r11 = 8 - ((~(r8 - r7)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L17;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L16;
        int r15 = (r8 << 3) + r13;
        int r16 = r4[r15];
        KeyframeEntity r17 = (KeyframeEntity) r5[r15];
        r2.add(r16);
        r3.set(r16, new VectorizedKeyframeSpecElementInfo((AnimationVector) r21.getConvertToVector().invoke(r17.getValue$animation_core()), r17.getEasing$animation_core(), r17.m265getArcMode9TMq4$animation_core(), null));
    L16:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        r6 = r6;
        r4 = r4;
        goto L8
    L12:
        r14 = false;
        goto L13
    L17:
        long[] r18 = r6;
        int[] r19 = r4;
        if (r11 != 8) goto L24;
    L21:
        if (r8 == r7) goto L24;
        r8 = r8 + 1;
        r6 = r18;
        r4 = r19;
        goto L5
    L20:
        r18 = r6;
        r19 = r4;
    L24:
        if (this.config.getKeyframes$animation_core().containsKey(0) == true) goto L27;
        r2.add(0, 0);
    L27:
        if (this.config.getKeyframes$animation_core().containsKey(this.config.getDurationMillis()) == true) goto L29;
        r2.add(this.config.getDurationMillis());
    L29:
        r2.sort();
        return new VectorizedKeyframesSpec(r2, r3, this.config.getDurationMillis(), this.config.getDelayMillis(), EasingKt.getLinearEasing(), ArcMode.Companion.m262getArcLinear9TMq4(), null);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r1) {
        return vectorize(r1);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter r1) {
        return vectorize(r1);
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedFiniteAnimationSpec vectorize(TwoWayConverter r1) {
        return vectorize(r1);
    }
}
