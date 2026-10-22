package com.bytedance.navigation.kmp.capability.sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.navigation.kmp.capability.sensor.eskf.EskfDeviceHeadingSensor;
import com.bytedance.navigation.kmp.capability.sensor.overlay.HeadingSource;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import d37.i;
import defpackage.m;
import faceverify.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes21.dex */
public final class FallbackDeviceHeadingSensor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<EskfDeviceHeadingSensor> f265783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<z27.b> f265784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<b37.d> f265785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Long, Continuation<? super b37.d>, Object> f265786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Long> f265787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Long, Runnable, Unit> f265788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Runnable, Unit> f265789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile State f265790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile com.bytedance.navigation.kmp.listener.b f265791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b37.d f265792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EskfDeviceHeadingSensor f265793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public z27.b f265794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d37.e f265795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f265796n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f265797o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CoroutineScope f265798p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g f265799q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f265800r;

    /* JADX INFO: renamed from: com.bytedance.navigation.kmp.capability.sensor.FallbackDeviceHeadingSensor$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<EskfDeviceHeadingSensor> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, EskfDeviceHeadingSensor.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EskfDeviceHeadingSensor invoke() {
            return new EskfDeviceHeadingSensor();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ EskfDeviceHeadingSensor invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.navigation.kmp.capability.sensor.FallbackDeviceHeadingSensor$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<z27.b> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0, z27.b.class, "<init>", "<init>()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final z27.b invoke2() {
            return new z27.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ z27.b invoke() {
            return invoke2();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.navigation.kmp.capability.sensor.FallbackDeviceHeadingSensor$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/navigation/kmp/data/LocationInfo;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.navigation.kmp.capability.sensor.FallbackDeviceHeadingSensor$4", f = "FallbackDeviceHeadingSensor.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass4 extends SuspendLambda implements Function2<Long, Continuation<? super b37.d>, Object> {
        /* synthetic */ long J$0;
        int label;

        public AnonymousClass4(Continuation<? super AnonymousClass4> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass4 r102 = new AnonymousClass4(r101);
            r102.J$0 = ((Number) r100).longValue();
            return r102;
        }

        public final Object invoke(long r100, Continuation<? super b37.d> r101) {
            return ((AnonymousClass4) create(Long.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long r100, Continuation<? super b37.d> r101) {
            return invoke(r100.longValue(), r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            long r103 = this.J$0;
            d37.h r104 = d37.h.f466748a;
            this.label = 1;
            r100 = r104.b(r103, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/navigation/kmp/capability/sensor/FallbackDeviceHeadingSensor$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "BOOTSTRAP_ROTV", "USING_ESKF", "DEGRADED_ROTV", "bdnavigation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BOOTSTRAP_ROTV = null;
        public static final State DEGRADED_ROTV = null;
        public static final State IDLE = null;
        public static final State USING_ESKF = null;

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("BOOTSTRAP_ROTV", 1);
            BOOTSTRAP_ROTV = r101;
            State r102 = new State("USING_ESKF", 2);
            USING_ESKF = r102;
            State r103 = new State("DEGRADED_ROTV", 3);
            DEGRADED_ROTV = r103;
            State[] r104 = {r100, r101, r102, r103};
            $VALUES = r104;
            $ENTRIES = EnumEntriesKt.enumEntries(r104);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [com.bytedance.navigation.kmp.capability.sensor.e] */
    public FallbackDeviceHeadingSensor(Object r100) {
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r102 = AnonymousClass2.INSTANCE;
        Function0<b37.d> r103 = new com.bytedance.navigation.kmp.capability.sensor.a();
        AnonymousClass4 r104 = new AnonymousClass4(null);
        Function0<Long> r105 = new b();
        Intrinsics.checkNotNullParameter(r101, "eskfFactory");
        Intrinsics.checkNotNullParameter(r102, "rotvFactory");
        Intrinsics.checkNotNullParameter(r103, "getLastKnown");
        Intrinsics.checkNotNullParameter(r104, "singleShot");
        Intrinsics.checkNotNullParameter(r105, "nowMs");
        this.f265783a = r101;
        this.f265784b = r102;
        this.f265785c = r103;
        this.f265786d = r104;
        this.f265787e = r105;
        this.f265788f = null;
        this.f265789g = null;
        this.f265790h = State.IDLE;
        this.f265795m = new d37.e();
        this.f265796n = LazyKt.lazy(new d());
        this.f265797o = new e(this);
        this.f265798p = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f265799q = new g(this);
        this.f265800r = new f(this);
    }

    public final void a(State r100) {
        if (this.f265790h != r100) goto L5;
        return;
    L5:
        this.f265790h = r100;
        y27.b r101 = y27.b.f565719a;     // Catch: Throwable -> L22
        int r102 = h.f265826a[r100.ordinal()];     // Catch: Throwable -> L22
        if (r102 != 1) goto L9;
        HeadingSource r103 = HeadingSource.IDLE;     // Catch: Throwable -> L22
    L20:
        r101.update(r103);     // Catch: Throwable -> L22
        return;
    L9:
        if (r102 != 2) goto L11;
        r103 = HeadingSource.ROTV_BOOTSTRAP;     // Catch: Throwable -> L22
        goto L20
    L11:
        if (r102 != 3) goto L13;
        r103 = HeadingSource.ESKF;     // Catch: Throwable -> L22
        goto L20
    L13:
        if (r102 != 4) goto L16;
        r103 = HeadingSource.ROTV_DEGRADED;     // Catch: Throwable -> L22
        goto L20
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L22
    }

    public final boolean b(c37.b r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        State r100 = this.f265790h;
        State r101 = State.IDLE;
        boolean r102 = false;
        if (r100 != r101) goto L5;
        this.f265795m = new d37.e();
        z27.b r103 = this.f265784b.invoke();
        r103.f569794e = this.f265799q;
        Intrinsics.checkNotNullParameter(r110, "params");     // Catch: Throwable -> L28
        if (r103.f569795f == false) goto L13;
    L12:
        boolean r104 = true;
    L32:
        if (r104 == true) goto L35;
        i r111 = i.f466749a;
        i.c("FallbackHeadingSensor start: RotV start failed");
        return false;
    L35:
        this.f265794l = r103;
        int r105 = w27.e.f558039a;     // Catch: Throwable -> L40
        e37.f r106 = w27.f.f558040a;     // Catch: Throwable -> L40
        if (r106 == null) goto L41;
        Boolean r107 = r106.e();     // Catch: Throwable -> L40
    L42:
        if (r107 == null) goto L44;
        boolean r108 = r107.booleanValue();
    L45:
        if (r108 == true) goto L50;
        i r112 = i.f466749a;
        i.g("FallbackHeadingSensor start: ESKF disabled by settings(eskf_enable=false), staying on RotV");
        a(State.DEGRADED_ROTV);
        b37.d r113 = this.f265792j;
        if (r113 == null) goto L49;
        r103.b(r113);
    L49:
        return true;
    L50:
        EskfDeviceHeadingSensor r109 = this.f265783a.invoke();
        r109.f265808e = this.f265800r;
        r109.f265815l = new c(this);
        r102 = r109.d(r110);     // Catch: Throwable -> L53
    L54:
        if (r102 == true) goto L59;
        i r114 = i.f466749a;
        i.g("FallbackHeadingSensor start: ESKF start failed, staying on RotV");
        a(State.DEGRADED_ROTV);
        b37.d r115 = this.f265792j;
        if (r115 == null) goto L58;
        r103.b(r115);
    L58:
        return true;
    L59:
        this.f265793k = r109;
        BuildersKt.launch$default(this.f265798p, null, null, new FallbackDeviceHeadingSensor$resolveInitAccuracyAsync$1(this, r109, null), 3, null);
        a(State.BOOTSTRAP_ROTV);
        e r116 = this.f265797o;
        Function2<Long, Runnable, Unit> r117 = this.f265788f;
        if (r117 == null) goto L62;
        r117.invoke(2000L, r116);
    L63:
        return true;
    L62:
        ((Handler) this.f265796n.getValue()).postDelayed(r116, 2000);
        goto L63
    L44:
        r108 = false;
    L41:
        r107 = null;
        goto L42
    L13:
        Object r118 = m.f511444a.getContext().getSystemService(w.BLOB_ELEM_TYPE_SENSOR);     // Catch: Throwable -> L28
        if ((r118 instanceof SensorManager) == false) goto L16;
        SensorManager r119 = (SensorManager) r118;     // Catch: Throwable -> L28
    L17:
        if (r119 != null) goto L19;
        i.c("RotvHeadingSensor start: no SensorManager");     // Catch: Throwable -> L28
        goto L31
    L19:
        Sensor r120 = r119.getDefaultSensor(11);     // Catch: Throwable -> L28
        if (r120 != null) goto L22;
        i.c("RotvHeadingSensor start: TYPE_ROTATION_VECTOR not available");     // Catch: Throwable -> L28
        goto L31
    L22:
        PthreadHandlerThreadV2 r121 = new PthreadHandlerThreadV2("BDNav-Heading-RotV");     // Catch: Throwable -> L28
        ThreadMethodProxy.start(r121);     // Catch: Throwable -> L28
        Handler r122 = new Handler(r121.getLooper());     // Catch: Throwable -> L28
        z27.c r123 = new z27.c(r103);     // Catch: Throwable -> L28
        if (fna.g.d() == true) goto L25;
        Boolean r124 = Boolean.valueOf(r119.registerListener(r123, r120, 20000, r122));     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L28
        boolean r125 = r124.booleanValue();     // Catch: Throwable -> L28
    L26:
        if (r125 == true) goto L29;
        z27.b.a(r119, r123);     // Catch: Throwable -> L28
        r121.quitSafely();     // Catch: Throwable -> L28
        goto L31
    L29:
        r103.f569792c = r119;     // Catch: Throwable -> L28
        r103.f569790a = r121;     // Catch: Throwable -> L28
        r103.f569791b = r122;     // Catch: Throwable -> L28
        r103.f569793d = r123;     // Catch: Throwable -> L28
        r103.f569796g = r110.f22283a;     // Catch: Throwable -> L28
        r103.f569795f = true;     // Catch: Throwable -> L28
        goto L12
    L25:
        Boolean r126 = Boolean.valueOf(r119.registerListener(r123, r120, 20000, r122));     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L28
        boolean r127 = r126.booleanValue();     // Catch: Throwable -> L28
        ona.b.a(new ona.a(r123.hashCode(), Integer.valueOf(r120.hashCode())));     // Catch: Throwable -> L28
        r125 = r127;
        goto L26
    L16:
        r119 = null;
    L31:
        r104 = false;
        goto L32
    L5:
        if (this.f265790h != r101) goto L69;
        return false;
    L69:
        return true;
    }
}
