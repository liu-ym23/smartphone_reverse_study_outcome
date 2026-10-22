package io.github.alexzhirkevich.compottie;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.font.FontFamily;
import com.alibaba.gaiax.template.GXTemplateKey;
import io.github.alexzhirkevich.compottie.internal.Animation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes41.dex */
public final class LottieComposition {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f490693k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animation f490694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f490695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState f490696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableFloatState f490697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f490698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Map<String, yrc.b>> f490699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f490700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutexImpl f490701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutexImpl f490702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, FontFamily> f490703j;

    public static final class a {
    }

    public static final class b implements io.github.alexzhirkevich.compottie.internal.animation.expressions.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f490704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f490705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LottieComposition f490706c;

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final int a() {
            return this.f490706c.f490694a.f490757g.size();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final Map<String, dsc.s> c() {
            return (Map) this.f490704a.getValue();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final Map<Integer, dsc.s> d() {
            return (Map) this.f490705b.getValue();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final float getHeight() {
            return this.f490706c.f490694a.f490753c;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final String getName() {
            return this.f490706c.f490694a.f490756f;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final float getStartTime() {
            Animation r100 = this.f490706c.f490694a;
            return r100.f490754d / r100.f490751a;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final float getWidth() {
            return this.f490706c.f490694a.f490752b;
        }

        public b(final LottieComposition r100) {
            this.f490706c = r100;
            this.f490704a = LazyKt.lazy(new m(r100));
            this.f490705b = LazyKt.lazy(new n(r100));
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.g
        public final float[] b(prc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            return fsc.a.f478743c;
        }
    }

    static {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 io.github.alexzhirkevich.compottie.LottieComposition, still in use, count: 2, list:
          (r0v0 io.github.alexzhirkevich.compottie.LottieComposition) from 0x00c0: MOVE (r24v0 io.github.alexzhirkevich.compottie.LottieComposition) = (r0v0 io.github.alexzhirkevich.compottie.LottieComposition) (LINE:192)
          (r0v0 io.github.alexzhirkevich.compottie.LottieComposition) from 0x0073: PHI (r0v8 io.github.alexzhirkevich.compottie.LottieComposition) = 
          (r0v0 io.github.alexzhirkevich.compottie.LottieComposition)
          (r0v11 io.github.alexzhirkevich.compottie.LottieComposition)
         binds: [B:12:0x0062, B:15:0x0079] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final io.github.alexzhirkevich.compottie.LottieComposition a() {
        io.github.alexzhirkevich.compottie.internal.Animation r2 = r26.f490694a;
        float r4 = r2.f490751a;
        float r5 = r2.f490752b;
        float r6 = r2.f490753c;
        float r7 = r2.f490754d;
        float r8 = r2.f490755e;
        java.lang.String r9 = r2.f490756f;
        java.util.List<dsc.s> r3 = r2.f490757g;
        java.util.List<dsc.s> r3 = r3;
        int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, 10);
        java.util.ArrayList r10 = new java.util.ArrayList(r12);
        java.util.Iterator<T> r3 = r3.iterator();
    L3:
        boolean r12 = r3.hasNext();
        if (r12 == false) goto L6;
        java.lang.Object r12 = r3.next();
        dsc.s r12 = (dsc.s) r12;
        dsc.s r12 = r12.deepCopy();
        r10.add(r12);
        goto L3
    L6:
        java.util.List<io.github.alexzhirkevich.compottie.internal.assets.d> r3 = r2.f490758h;
        java.util.List<io.github.alexzhirkevich.compottie.internal.assets.d> r3 = r3;
        int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, 10);
        java.util.ArrayList r12 = new java.util.ArrayList(r13);
        java.util.Iterator<T> r3 = r3.iterator();
    L7:
        boolean r13 = r3.hasNext();
        if (r13 == false) goto L10;
        java.lang.Object r13 = r3.next();
        io.github.alexzhirkevich.compottie.internal.assets.d r13 = (io.github.alexzhirkevich.compottie.internal.assets.d) r13;
        io.github.alexzhirkevich.compottie.internal.assets.d r13 = r13.copy();
        r12.add(r13);
        goto L7
    L10:
        yrc.e r3 = r2.f490759i;
        if (r3 == null) goto L17;
        java.util.List<yrc.l> r3 = r3.f568958a;
        java.util.List<yrc.l> r3 = r3;
        int r15 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, 10);
        java.util.ArrayList r14 = new java.util.ArrayList(r15);
        java.util.Iterator r3 = r3.iterator();
    L13:
        boolean r15 = r3.hasNext();
        if (r15 == false) goto L16;
        java.lang.Object r15 = r3.next();
        yrc.l r15 = (yrc.l) r15;
        r15.getClass();
        java.lang.String r11 = r15.f568972a;
        java.lang.String r1 = r15.f568973b;
        java.util.Iterator r23 = r3;
        java.lang.String r3 = r15.f568974c;
        io.github.alexzhirkevich.compottie.LottieComposition r24 = r0;
        java.lang.String r0 = r15.f568975d;
        java.util.ArrayList r25 = r12;
        yrc.f r12 = r15.f568976e;
        float r15 = r15.f568977f;
        yrc.l r13 = new yrc.l(r11, r1, r3, r0, r12, r15);
        r14.add(r13);
        r3 = r23;
        io.github.alexzhirkevich.compottie.LottieComposition r0 = r24;
        r12 = r25;
        goto L13
    L16:
        io.github.alexzhirkevich.compottie.LottieComposition r24 = r0;
        java.util.ArrayList r25 = r12;
        yrc.e r0 = new yrc.e(r14);
        yrc.e r12 = r0;
    L18:
        java.util.List<yrc.b> r0 = r2.f490760j;
        java.util.List<yrc.b> r0 = r0;
        int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, 10);
        java.util.ArrayList r13 = new java.util.ArrayList(r1);
        java.util.Iterator r0 = r0.iterator();
    L19:
        boolean r1 = r0.hasNext();
        if (r1 == false) goto L26;
        java.lang.Object r1 = r0.next();
        yrc.b r1 = (yrc.b) r1;
        r1.getClass();
        java.lang.String r15 = r1.f568949a;
        java.lang.String r11 = r1.f568950b;
        float r14 = r1.f568951c;
        java.util.Iterator r21 = r0;
        java.lang.String r0 = r1.f568952d;
        yrc.e r22 = r12;
        java.lang.Float r12 = r1.f568953e;
        io.github.alexzhirkevich.compottie.internal.assets.CharacterPath r1 = r1.f568954f;
        if (r1 == null) goto L24;
        io.github.alexzhirkevich.compottie.internal.assets.CharacterPath r1 = r1.copy();
        io.github.alexzhirkevich.compottie.internal.assets.CharacterPath r20 = r1;
    L25:
        yrc.b r3 = new yrc.b(r15, r11, r14, r0, r12, r20);
        r13.add(r3);
        r0 = r21;
        r12 = r22;
        goto L19
    L24:
        r20 = null;
        goto L25
    L26:
        yrc.e r22 = r12;
        java.util.List<bsc.r> r14 = r2.f490761k;
        java.util.Map<java.lang.String, ouc.i> r15 = r2.f490762l;
        java.util.ArrayList r11 = r25;
        io.github.alexzhirkevich.compottie.internal.Animation r0 = new io.github.alexzhirkevich.compottie.internal.Animation(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        io.github.alexzhirkevich.compottie.LottieComposition r1 = new io.github.alexzhirkevich.compottie.LottieComposition(r0);
        return r1;
    L17:
        r24 = r0;
        r25 = r12;
        r12 = null;
        goto L18
    }

    public LottieComposition(Animation r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f490694a = r100;
        Duration.Companion r101 = Duration.Companion;
        this.f490695b = DurationKt.toDuration((int) (((r100.f490755e - r100.f490754d) / r100.f490751a) * 1000000), DurationUnit.MICROSECONDS);
        this.f490696c = SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
        this.f490697d = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
        this.f490698e = new b(this);
        List<yrc.b> r102 = r100.f490760j;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        Object r105 = r104.next();
        String r106 = ((yrc.b) r105).f568950b;
        Object r107 = r103.get(r106);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        r103.put(r106, r107);
    L8:
        ((List) r107).add(r105);
        goto L4
    L9:
        LinkedHashMap r108 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
        Iterator r109 = r103.entrySet().iterator();
    L11:
        if (r109.hasNext() == false) goto L17;
        Map.Entry r110 = (Map.Entry) r109.next();
        Object r111 = r110.getKey();
        Iterable r112 = (Iterable) r110.getValue();
        LinkedHashMap r113 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r112, 10)), 16));
        Iterator r114 = r112.iterator();
    L14:
        if (r114.hasNext() == false) goto L16;
        Object r115 = r114.next();
        r113.put(((yrc.b) r115).f568949a, r115);
        goto L14
    L16:
        r108.put(r111, r113);
        goto L11
    L17:
        this.f490699f = r108;
        this.f490700g = LazyKt.lazy(new l(this));
        this.f490701h = kotlinx.coroutines.sync.b.a();
        this.f490702i = kotlinx.coroutines.sync.b.a();
        this.f490703j = new LinkedHashMap();
        List<bsc.r> r116 = this.f490694a.f490761k;
        LinkedHashMap r117 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r116, 10)), 16));
        Iterator<T> r118 = r116.iterator();
    L19:
        if (r118.hasNext() == false) goto L21;
        Object r119 = r118.next();
        r117.put(((bsc.r) r119).f20439a, r119);
        goto L19
    }

    public final Object b(nrc.d r100, boolean r101, Continuation<? super List<? extends io.github.alexzhirkevich.compottie.internal.assets.d>> r102) {
        if ((r102 instanceof LottieComposition$loadAssets$1) == false) goto L7;
        LottieComposition$loadAssets$1 r103 = (LottieComposition$loadAssets$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        List r108 = (List) r103.L$0;
        ResultKt.throwOnFailure(r105);
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r101 == false) goto L21;
        List<io.github.alexzhirkevich.compottie.internal.assets.d> r109 = this.f490694a.f490758h;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L18:
        if (r111.hasNext() == false) goto L20;
        r110.add(((io.github.alexzhirkevich.compottie.internal.assets.d) r111.next()).copy());
        goto L18
    L20:
        List<io.github.alexzhirkevich.compottie.internal.assets.d> r112 = r110;
    L22:
        LottieComposition$loadAssets$2 r113 = new LottieComposition$loadAssets$2(r112, r100, null);
        r103.L$0 = r112;
        r103.label = 1;
        if (CoroutineScopeKt.coroutineScope(r113, r103) != r106) goto L26;
        return r106;
    L26:
        return r112;
    L21:
        r112 = this.f490694a.f490758h;
    L7:
        r103 = new LottieComposition$loadAssets$1(this, r102);
        goto L8
    }
}
