package io.github.alexzhirkevich.compottie.internal.animation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.github.alexzhirkevich.compottie.internal.animation.h2;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: loaded from: classes41.dex */
public final class s1<T, K, KF extends h2<? extends K>> implements j2<T, KF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f491151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<KF> f491152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f491153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function4<KF, K, K, Float, T> f491154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<KF> f491155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ClosedFloatingPointRange<Float>> f491156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f491157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f491158h;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Float.valueOf(((h2) r100).getTime()), Float.valueOf(((h2) r101).getTime()));
        }
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.j2
    public final List<KF> c() {
        return this.f491152b;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
    public final Integer getIndex() {
        return this.f491151a;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
    public final T d(final prc.f r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        if (this.f491155e.isEmpty() == true) goto L68;
        Object r100 = null;
        if (r110.f530394d < ((Number) this.f491158h.getValue()).floatValue()) goto L30;
        List<KF> r111 = this.f491155e;
        h2 r112 = (h2) CollectionsKt.getOrNull(r111, CollectionsKt.getLastIndex(r111) - 1);
        h2 r101 = (h2) CollectionsKt.last(this.f491155e);
        Function4<KF, K, K, Float, T> r102 = this.f491154d;
        if (r112 == null) goto L11;
        Object r103 = r112.getStart();
        if (r103 == null) goto L11;
    L12:
        int r104 = u1.f491161a;
        if (r103 == null) goto L28;
        Object r105 = r101.getStart();
        if (r105 != null) goto L22;
        if (r112 == null) goto L18;
        r105 = r112.getEnd();
    L19:
        if (r105 != null) goto L22;
        if (r112 == null) goto L23;
        r100 = r112.getStart();
    L23:
        if (r100 == null) goto L26;
        return r102.invoke((KF) r101, (K) r103, (K) r100, Float.valueOf(1.0f));
    L26:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L18:
        r105 = null;
    L22:
        r100 = r105;
        goto L23
    L28:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L11:
        r103 = r101.getStart();
        goto L12
    L30:
        if (r110.f530394d > ((Number) this.f491157g.getValue()).floatValue()) goto L45;
        h2 r113 = (h2) CollectionsKt.first(this.f491155e);
        Function4<KF, K, K, Float, T> r106 = this.f491154d;
        Object r107 = r113.getStart();
        int r108 = u1.f491161a;
        if (r107 == null) goto L44;
        Object r109 = r113.a();
        if (r109 != null) goto L38;
        h2 r114 = (h2) CollectionsKt.getOrNull(this.f491155e, 1);
        if (r114 == null) goto L39;
        r100 = r114.getStart();
    L39:
        if (r100 == null) goto L42;
        return r106.invoke((KF) r113, (K) r107, (K) r100, Float.valueOf(0.0f));
    L42:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L38:
        r100 = r109;
        goto L39
    L44:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L45:
        int r115 = CollectionsKt.binarySearch$default(this.f491156f, 0, 0, new p1(r110), 3, null);
        if (r115 < 0) goto L48;
        boolean r116 = true;
    L49:
        int r117 = u1.f491161a;
        if (r116 == false) goto L67;
        ClosedFloatingPointRange r118 = (ClosedFloatingPointRange) ListProtector.get(this.f491156f, r115);
        float r119 = (r110.f530394d - ((Number) r118.getStart()).floatValue()) / (((Number) r118.getEndInclusive()).floatValue() - ((Number) r118.getStart()).floatValue());
        h2 r120 = (h2) ListProtector.get(this.f491155e, r115);
        Function4<KF, K, K, Float, T> r121 = this.f491154d;
        Object r122 = r120.getStart();
        if (r122 == null) goto L65;
        Object r123 = r120.a();
        if (r123 != null) goto L58;
        h2 r124 = (h2) CollectionsKt.getOrNull(this.f491155e, r115 + 1);
        if (r124 == null) goto L59;
        r100 = r124.getStart();
    L59:
        if (r100 == null) goto L63;
        return r121.invoke((KF) r120, (K) r122, (K) r100, Float.valueOf(r119));
    L63:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L58:
        r100 = r123;
        goto L59
    L65:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L67:
        throw new IllegalArgumentException("Invalid keyframe".toString());
    L48:
        r116 = false;
        goto L49
    L68:
        return this.f491153c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List<? extends KF extends io.github.alexzhirkevich.compottie.internal.animation.h2<? extends K>>, java.util.List<KF extends io.github.alexzhirkevich.compottie.internal.animation.h2<? extends K>>] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>>] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function4<? super KF extends io.github.alexzhirkevich.compottie.internal.animation.h2<? extends K>, ? super K, ? super K, ? super java.lang.Float, ? extends T>, kotlin.jvm.functions.Function4<KF extends io.github.alexzhirkevich.compottie.internal.animation.h2<? extends K>, K, K, java.lang.Float, T>] */
    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.util.List<? extends KF extends io.github.alexzhirkevich.compottie.internal.animation.h2<? extends K>> to ?? for r3v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:139)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:212)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:73)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:39)
        */
    public s1(java.lang.Integer r2, java.util.List<? extends KF> r3, T r4, kotlin.jvm.functions.Function4<? super KF, ? super K, ? super K, ? super java.lang.Float, ? extends T> r5) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, "keyframes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, "emptyValue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, "map");
        r1.f491151a = r2;
        r1.f491152b = r3;
        r1.f491153c = r4;
        r1.f491154d = r5;
        java.util.List<KF> r2 = kotlin.collections.CollectionsKt.sortedWith((java.lang.Iterable) r3, new io.github.alexzhirkevich.compottie.internal.animation.s1.a());
        if ((kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) ^ true) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        r2 = (java.util.List<KF>) r2;
    L8:
        java.util.List<KF> r2 = r2;
        r1.f491155e = r2;
        java.util.Collection r3 = (java.util.Collection) r3;
        boolean r3 = r3.isEmpty();
        boolean r3 = r3 ^ true;
        if (r3 == false) goto L13;
        java.util.List<KF> r2 = r2;
        int r2 = kotlin.collections.CollectionsKt.getLastIndex(r2);
        ?? r3 = new java.util.ArrayList(r2);
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L14;
        java.util.List<KF> r5 = r1.f491155e;
        java.lang.Object r5 = com.bytedance.mt.protector.impl.collections.ListProtector.get(r5, r4);
        io.github.alexzhirkevich.compottie.internal.animation.h2 r5 = (io.github.alexzhirkevich.compottie.internal.animation.h2) r5;
        float r5 = r5.getTime();
        java.util.List<KF> r0 = r1.f491155e;
        r4 = r4 + 1;
        java.lang.Object r0 = com.bytedance.mt.protector.impl.collections.ListProtector.get(r0, r4);
        io.github.alexzhirkevich.compottie.internal.animation.h2 r0 = (io.github.alexzhirkevich.compottie.internal.animation.h2) r0;
        float r0 = r0.getTime();
        kotlin.ranges.ClosedFloatingPointRange r5 = kotlin.ranges.RangesKt.rangeTo(r5, r0);
        r3.add(r5);
    L14:
        r1.f491156f = r3;
        kotlin.jvm.functions.Function0 r2 = new io.github.alexzhirkevich.compottie.internal.animation.q1(r1);
        kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2);
        r1.f491157g = r2;
        kotlin.jvm.functions.Function0 r2 = new io.github.alexzhirkevich.compottie.internal.animation.r1(r1);
        kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2);
        r1.f491158h = r2;
        return;
    L13:
        r3 = kotlin.collections.CollectionsKt.emptyList();
        goto L14
    }
}
