package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0001\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "<init>", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;)V", "periodicBias", "", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;F)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframesWithSplineSpecConfig", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeyframesWithSplineSpec<T> implements DurationBasedAnimationSpec<T> {
    public static final int $stable = 0;
    private final KeyframesWithSplineSpecConfig<T> config;
    private float periodicBias;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "<init>", "()V", "createEntityFor", "value", "createEntityFor$animation_core", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class KeyframesWithSplineSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframesSpec.KeyframeEntity<T>> {
        public static final int $stable = 8;

        public KeyframesWithSplineSpecConfig() {
            super(null);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public KeyframesSpec.KeyframeEntity<T> createEntityFor$animation_core(T r8) {
            return new KeyframesSpec.KeyframeEntity(r8, null, 0, 6, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public /* bridge */ /* synthetic */ KeyframeBaseEntity createEntityFor$animation_core(Object r1) {
            return createEntityFor$animation_core(r1);
        }
    }

    public final KeyframesWithSplineSpecConfig<T> getConfig() {
        return this.config;
    }

    public KeyframesWithSplineSpec(KeyframesWithSplineSpecConfig<T> r1) {
        this.config = r1;
        this.periodicBias = Float.NaN;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(TwoWayConverter<T, V> r21) {
        MutableIntObjectMap<KeyframesSpec.KeyframeEntity<T>> r1 = this.config.getKeyframes$animation_core();
        MutableIntList r3 = new MutableIntList(r1.getSize() + 2);
        MutableIntObjectMap r4 = new MutableIntObjectMap(r1.getSize());
        int[] r2 = r1.keys;
        Object[] r5 = r1.values;
        long[] r6 = r1.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L24;
        int r9 = 0;
    L5:
        long r10 = r6[r9];
        if (((((~r10) << 7) & r10) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L20;
        int r12 = 8 - ((~(r9 - r7)) >>> 31);
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L17;
        if ((255 & r10) >= 128) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L16;
        int r16 = (r9 << 3) + r14;
        int r8 = r2[r16];
        KeyframesSpec.KeyframeEntity r17 = (KeyframesSpec.KeyframeEntity) r5[r16];
        r3.add(r8);
        r4.set(r8, new Pair(r21.getConvertToVector().invoke(r17.getValue$animation_core()), r17.getEasing$animation_core()));
    L16:
        r10 = r10 >> 8;
        r14 = r14 + 1;
        r2 = r2;
        r5 = r5;
        goto L8
    L12:
        r15 = false;
        goto L13
    L17:
        int[] r18 = r2;
        Object[] r19 = r5;
        if (r12 != 8) goto L24;
    L21:
        if (r9 == r7) goto L24;
        r9 = r9 + 1;
        r2 = r18;
        r5 = r19;
        goto L5
    L20:
        r18 = r2;
        r19 = r5;
    L24:
        if (r1.containsKey(0) == true) goto L27;
        r3.add(0, 0);
    L27:
        if (r1.containsKey(this.config.getDurationMillis()) == true) goto L29;
        r3.add(this.config.getDurationMillis());
    L29:
        r3.sort();
        return new VectorizedMonoSplineKeyframesSpec(r3, r4, this.config.getDurationMillis(), this.config.getDelayMillis(), this.periodicBias);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r1) {
        return vectorize(r1);
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedFiniteAnimationSpec vectorize(TwoWayConverter r1) {
        return vectorize(r1);
    }

    public KeyframesWithSplineSpec(KeyframesWithSplineSpecConfig<T> r1, float r2) {
        this(r1);
        this.periodicBias = r2;
    }
}
