package kotlinx.coroutines.flow;

import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<e1> implements MutableSharedFlow<T>, Flow, kotlinx.coroutines.flow.internal.l<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f504809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f504810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BufferOverflow f504811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object[] f504812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f504813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f504814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f504815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f504816l;

    public static final class a implements kotlinx.coroutines.m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SharedFlowImpl<?> f504817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f504818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f504819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Continuation<Unit> f504820d;

        @Override // kotlinx.coroutines.m0
        public final void dispose() {
            SharedFlowImpl<?> r100 = this.f504817a;
            monitor-enter(r100);
        L16:
            th = move-exception;
            throw th;
        L6:
            if (this.f504818b >= r100.l()) goto L9;
            monitor-exit(r100);
            return;
        L9:
            Object[] r101 = r100.f504812h;     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L16
            if (SharedFlowKt.access$getBufferAt(r101, this.f504818b) == this) goto L13;
            monitor-exit(r100);
            return;
        L13:
            SharedFlowKt.access$setBufferAt(r101, this.f504818b, SharedFlowKt.NO_VALUE);     // Catch: Throwable -> L16
            r100.g();     // Catch: Throwable -> L16
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(r100);
        }

        public a(SharedFlowImpl r100, long r101, Object r102, kotlinx.coroutines.j r103) {
            this.f504817a = r100;
            this.f504818b = r101;
            this.f504819c = r102;
            this.f504820d = r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f504821a = null;

        static {
            int[] r100 = new int[BufferOverflow.values().length];
            r100[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f504821a = r100;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        public AnonymousClass1(SharedFlowImpl<T> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.h(this.this$0, null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<?> r101) {
        return h(this, r100, r101);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c[] d() {
        return new e1[2];
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final List<T> getReplayCache() {
        monitor-enter(this);
        int r100 = (int) ((l() + ((long) this.f504815k)) - this.f504813i);     // Catch: Throwable -> L14
        if (r100 != 0) goto L8;
        List<T> r101 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    L8:
        ArrayList r102 = new ArrayList(r100);     // Catch: Throwable -> L14
        Object[] r103 = this.f504812h;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L14
        int r104 = 0;
    L9:
        if (r104 >= r100) goto L12;
        r102.add(SharedFlowKt.access$getBufferAt(r103, this.f504813i + ((long) r104)));     // Catch: Throwable -> L14
        r104 = r104 + 1;
        goto L9
    L12:
        monitor-exit(this);
        return r102;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        monitor-enter(this);
        q(l() + ((long) this.f504815k), this.f504814j, l() + ((long) this.f504815k), (l() + ((long) this.f504815k)) + ((long) this.f504816l));     // Catch: Throwable -> L6
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c c() {
        return new e1();
    }

    public final void g() {
        if (this.f504810f == 0) goto L5;
    L7:
        Object[] r100 = this.f504812h;
        Intrinsics.checkNotNull(r100);
    L9:
        if (this.f504816l <= 0) goto L13;
        if (SharedFlowKt.access$getBufferAt(r100, (l() + ((long) (this.f504815k + this.f504816l))) - 1) != SharedFlowKt.NO_VALUE) goto L16;
        this.f504816l--;
        SharedFlowKt.access$setBufferAt(r100, l() + ((long) (this.f504815k + this.f504816l)), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.f504816l > 1) goto L7;
    }

    public final void i() {
        Object[] r100 = this.f504812h;
        Intrinsics.checkNotNull(r100);
        SharedFlowKt.access$setBufferAt(r100, l(), null);
        this.f504815k--;
        long r101 = l() + 1;
        if (this.f504813i >= r101) goto L6;
        this.f504813i = r101;
    L6:
        if (this.f504814j < r101) goto L8;
        return;
    L8:
        if (this.f504878b == 0) goto L21;
        Object[] r102 = this.f504877a;
        if (r102 == null) goto L21;
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L21;
        Object r105 = r102[r104];
        if (r105 == null) goto L20;
        e1 r106 = (e1) r105;
        long r107 = r106.f504847a;
        if (r107 < 0) goto L20;
        if (r107 >= r101) goto L20;
        r106.f504847a = r101;
    L20:
        r104 = r104 + 1;
    L21:
        this.f504814j = r101;
    }

    public final long l() {
        return Math.min(this.f504814j, this.f504813i);
    }

    public final void j(Object r100) {
        int r101 = this.f504815k + this.f504816l;
        Object[] r102 = this.f504812h;
        if (r102 != null) goto L6;
        r102 = m(null, 0, 2);
    L8:
        SharedFlowKt.access$setBufferAt(r102, l() + ((long) r101), r100);
        return;
    L6:
        if (r101 < r102.length) goto L8;
        r102 = m(r102, r101, r102.length * 2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final Continuation<Unit>[] k(Continuation<Unit>[] r110) {
        int r100 = r110.length;
        if (this.f504878b == 0) goto L21;
        Object[] r101 = this.f504877a;
        if (r101 == null) goto L21;
        int r102 = r101.length;
        int r103 = 0;
        r110 = r110;
    L7:
        if (r103 >= r102) goto L21;
        Object r104 = r101[r103];
        if (r104 == null) goto L19;
        e1 r105 = (e1) r104;
        kotlinx.coroutines.j r106 = r105.f504848b;
        if (r106 == null) goto L19;
        if (o(r105) < 0) goto L19;
        int r107 = r110.length;
        r110 = r110;
        if (r100 < r107) goto L18;
        r110 = Arrays.copyOf(r110, Math.max(2, r110.length * 2));
    L18:
        ((Continuation[]) r110)[r100] = r106;
        r105.f504848b = null;
        r100 = r100 + 1;
    L19:
        r103 = r103 + 1;
        r110 = r110;
    L21:
        return (Continuation[]) r110;
    }

    public final boolean n(T r110) {
        if (this.f504878b != 0) goto L13;
        if (this.f504809e == 0) goto L11;
        j(r110);
        int r100 = this.f504815k + 1;
        this.f504815k = r100;
        if (r100 <= this.f504809e) goto L10;
        i();
    L10:
        this.f504814j = l() + ((long) this.f504815k);
    L11:
        return true;
    L13:
        if (this.f504815k >= this.f504810f) goto L15;
    L24:
        j(r110);
        int r101 = this.f504815k + 1;
        this.f504815k = r101;
        if (r101 <= this.f504810f) goto L27;
        i();
    L27:
        long r102 = l() + ((long) this.f504815k);
        long r103 = this.f504813i;
        if (((int) (r102 - r103)) <= this.f504809e) goto L30;
        q(r103 + 1, this.f504814j, l() + ((long) this.f504815k), (l() + ((long) this.f504815k)) + ((long) this.f504816l));
    L30:
        return true;
    L15:
        if (this.f504814j > this.f504813i) goto L24;
        BufferOverflow r104 = this.f504811g;
        int r105 = b.f504821a[r104.ordinal()];
        if (r105 != 1) goto L19;
        return false;
    L19:
        if (r105 != 2) goto L24;
        return true;
    }

    public final long o(e1 r100) {
        long r101 = r100.f504847a;
        if (r101 >= (l() + ((long) this.f504815k))) goto L6;
        return r101;
    L6:
        if (this.f504810f <= 0) goto L9;
        return -1;
    L9:
        if (r101 <= l()) goto L12;
        return -1;
    L12:
        if (this.f504816l != 0) goto L14;
        return -1;
    L14:
        return r101;
    }

    public final Object p(e1 r100) {
        Continuation<Unit>[] r101 = kotlinx.coroutines.flow.internal.b.f504881a;
        monitor-enter(this);
        long r102 = o(r100);     // Catch: Throwable -> L20
        if (r102 >= 0) goto L7;
        Object r103 = SharedFlowKt.NO_VALUE;     // Catch: Throwable -> L20
    L12:
        monitor-exit(this);
        int r104 = r101.length;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L19;
        Continuation<Unit> r106 = r101[r105];
        if (r106 == null) goto L18;
        Result.Companion r107 = Result.Companion;
        r106.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    L18:
        r105 = r105 + 1;
        goto L14
    L19:
        return r103;
    L7:
        long r108 = r100.f504847a;     // Catch: Throwable -> L20
        Object[] r109 = this.f504812h;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L20
        Object r110 = SharedFlowKt.access$getBufferAt(r109, r102);     // Catch: Throwable -> L20
        if ((r110 instanceof a) == false) goto L10;
        r110 = ((a) r110).f504819c;     // Catch: Throwable -> L20
    L10:
        r100.f504847a = r102 + 1;     // Catch: Throwable -> L20
        Object r111 = r110;
        r101 = r(r108);     // Catch: Throwable -> L20
        r103 = r111;
    L20:
        th = move-exception;
        throw th;
    }

    public final Continuation<Unit>[] r(long r210) {
        long r100 = this.f504814j;
        Continuation<Unit>[] r101 = kotlinx.coroutines.flow.internal.b.f504881a;
        if (r210 <= r100) goto L5;
        return r101;
    L5:
        long r102 = l();
        long r103 = ((long) this.f504815k) + r102;
        if (this.f504810f != 0) goto L11;
        if (this.f504816l <= 0) goto L11;
        r103 = r103 + 1;
    L11:
        if (this.f504878b == 0) goto L25;
        Object[] r104 = this.f504877a;
        if (r104 == null) goto L25;
        int r105 = r104.length;
        int r110 = 0;
    L15:
        if (r110 >= r105) goto L25;
        Object r111 = r104[r110];
        if (r111 == null) goto L23;
        long r112 = ((e1) r111).f504847a;
        if (r112 < 0) goto L23;
        if (r112 >= r103) goto L23;
        r103 = r112;
    L23:
        r110 = r110 + 1;
    L25:
        if (r103 > this.f504814j) goto L27;
        return r101;
    L27:
        long r113 = l() + ((long) this.f504815k);
        if (this.f504878b <= 0) goto L30;
        int r106 = Math.min(this.f504816l, this.f504810f - ((int) (r113 - r103)));
    L31:
        long r114 = ((long) this.f504816l) + r113;
        if (r106 <= 0) goto L45;
        r101 = new Continuation[r106];
        Object[] r107 = this.f504812h;
        Intrinsics.checkNotNull(r107);
        long r108 = r113;
        int r115 = 0;
    L35:
        if (r113 >= r114) goto L43;
        Object r116 = SharedFlowKt.access$getBufferAt(r107, r113);
        long r117 = r103;
        kotlinx.coroutines.internal.b0 r109 = SharedFlowKt.NO_VALUE;
        if (r116 == r109) goto L41;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r118 = (a) r116;
        int r119 = r115 + 1;
        long r120 = r114;
        r101[r115] = r118.f504820d;
        SharedFlowKt.access$setBufferAt(r107, r113, r109);
        SharedFlowKt.access$setBufferAt(r107, r108, r118.f504819c);
        long r121 = 1;
        r108 = r108 + 1;
        if (r119 >= r106) goto L44;
        r115 = r119;
    L42:
        r113 = r113 + r121;
        r103 = r117;
        r114 = r120;
    L44:
        r113 = r108;
    L46:
        Continuation<Unit>[] r122 = r101;
        int r123 = (int) (r113 - r102);
        if (this.f504878b != 0) goto L49;
        long r124 = r113;
    L50:
        long r125 = Math.max(this.f504813i, r113 - ((long) Math.min(this.f504809e, r123)));
        if (this.f504810f == 0) goto L53;
    L57:
        q(r125, r124, r113, r120);
        g();
        if (r122.length != 0) goto L60;
        boolean r126 = true;
    L62:
        if ((!r126) == true) goto L64;
        return r122;
    L64:
        return k(r122);
    L60:
        r126 = false;
        goto L62
    L53:
        if (r125 >= r120) goto L57;
        Object[] r127 = this.f504812h;
        Intrinsics.checkNotNull(r127);
        if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(r127, r125), SharedFlowKt.NO_VALUE) == false) goto L57;
        r113 = r113 + 1;
        r125 = r125 + 1;
        goto L57
    L49:
        r124 = r117;
        goto L50
    L41:
        r120 = r114;
        r121 = 1;
        goto L42
    L43:
        r117 = r103;
        r120 = r114;
        goto L44
    L45:
        r117 = r103;
        r120 = r114;
        goto L46
    L30:
        r106 = this.f504816l;
        goto L31
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(T r100) {
        Continuation<Unit>[] r101 = kotlinx.coroutines.flow.internal.b.f504881a;
        monitor-enter(this);
        int r102 = 0;
        if (n(r100) == false) goto L8;
        r101 = k(r101);     // Catch: Throwable -> L17
        boolean r103 = true;
    L9:
        monitor-exit(this);
        int r104 = r101.length;
    L11:
        if (r102 >= r104) goto L16;
        Continuation<Unit> r105 = r101[r102];
        if (r105 == null) goto L15;
        Result.Companion r106 = Result.Companion;
        r105.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    L15:
        r102 = r102 + 1;
        goto L11
    L16:
        return r103;
    L8:
        r103 = false;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r110, Continuation<? super Unit> r111) {
        if (tryEmit(r110) == true) goto L42;
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r111), 1);
        r100.C();
        Continuation<Unit>[] r101 = kotlinx.coroutines.flow.internal.b.f504881a;
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L8:
        if (n(r110) == false) goto L10;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L35
        r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L35
        Continuation<Unit>[] r113 = k(r101);     // Catch: Throwable -> L35
        a r102 = null;
    L14:
        monitor-exit(this);
        if (r102 == null) goto L17;
        kotlinx.coroutines.l.b(r100, new kotlinx.coroutines.n0(r102));
    L17:
        int r103 = r113.length;
        int r104 = 0;
    L18:
        if (r104 >= r103) goto L23;
        Continuation<Unit> r105 = r113[r104];
        if (r105 == null) goto L22;
        Result.Companion r106 = Result.Companion;
        r105.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    L22:
        r104 = r104 + 1;
        goto L18
    L23:
        Object r114 = r100.B();
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L27:
        if (r114 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        r114 = Unit.INSTANCE;
    L31:
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        return r114;
    L34:
        return Unit.INSTANCE;
    L10:
        a r107 = new a(this, ((long) (this.f504815k + this.f504816l)) + l(), r110, r100);     // Catch: Throwable -> L35
        j(r107);     // Catch: Throwable -> L35
        this.f504816l++;     // Catch: Throwable -> L35
        if (this.f504810f != 0) goto L13;
        r101 = k(r101);     // Catch: Throwable -> L35
    L13:
        r113 = r101;
        r102 = r107;
        goto L14
    L42:
        return Unit.INSTANCE;
    }

    public final Object f(e1 r100, Continuation<? super Unit> r101) {
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (o(r100) >= 0) goto L7;
        r100.f504848b = r102;     // Catch: Throwable -> L18
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L14:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r104;
    L17:
        return Unit.INSTANCE;
    L7:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        r102.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L18
        goto L8
    }

    public SharedFlowImpl(int r100, int r101, BufferOverflow r102) {
        this.f504809e = r100;
        this.f504810f = r101;
        this.f504811g = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ <T> Object h(SharedFlowImpl<T> r100, FlowCollector<? super T> r101, Continuation<?> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L26;
        if (r105 == 1) goto L21;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        Job r106 = (Job) r102.L$3;
        e1 r107 = (e1) r102.L$2;
        FlowCollector r108 = (FlowCollector) r102.L$1;
        SharedFlowImpl<T> r109 = (SharedFlowImpl) r102.L$0;
    L56:
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L19
        FlowCollector r112 = r108;
        Job r113 = r106;
        r100 = r109;
    L34:
        Object r114 = r100.p(r107);     // Catch: Throwable -> L44
        if (r114 == SharedFlowKt.NO_VALUE) goto L36;
        if (r113 == null) goto L41;
        JobKt.ensureActive(r113);     // Catch: Throwable -> L44
    L41:
        r102.L$0 = r100;     // Catch: Throwable -> L44
        r102.L$1 = r112;     // Catch: Throwable -> L44
        r102.L$2 = r107;     // Catch: Throwable -> L44
        r102.L$3 = r113;     // Catch: Throwable -> L44
        r102.label = 3;     // Catch: Throwable -> L44
        if (r112.emit(r114, r102) != r104) goto L34;
        return r104;
    L36:
        r102.L$0 = r100;     // Catch: Throwable -> L44
        r102.L$1 = r112;     // Catch: Throwable -> L44
        r102.L$2 = r107;     // Catch: Throwable -> L44
        r102.L$3 = r113;     // Catch: Throwable -> L44
        r102.label = 2;     // Catch: Throwable -> L44
        if (r100.f(r107, r102) != r104) goto L34;
        return r104;
    L44:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L48:
        r109.e(r107);
        throw th10;
    L19:
        th10 = th;
        goto L48
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r106 = (Job) r102.L$3;
        r107 = (e1) r102.L$2;
        r108 = (FlowCollector) r102.L$1;
        r109 = (SharedFlowImpl) r102.L$0;
        goto L56
    L21:
        r107 = (e1) r102.L$2;
        FlowCollector<? super T> r115 = (FlowCollector) r102.L$1;
        SharedFlowImpl<T> r116 = (SharedFlowImpl) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L24
        FlowCollector<? super T> r117 = r115;
        r100 = r116;
    L52:
        r113 = (Job) r102.getContext().get(Job.Key);     // Catch: Throwable -> L44
        r112 = r117;
    L24:
        th10 = th;
        r109 = r116;
        goto L48
    L26:
        ResultKt.throwOnFailure(r111);
        e1 r118 = r100.b();
    L46:
        th = move-exception;
        r109 = r100;
        th10 = th;
        r107 = r118;
        goto L48
    L28:
        if ((r101 instanceof SubscribedFlowCollector) == false) goto L32;
        r102.L$0 = r100;     // Catch: Throwable -> L46
        r102.L$1 = r101;     // Catch: Throwable -> L46
        r102.L$2 = r118;     // Catch: Throwable -> L46
        r102.label = 1;     // Catch: Throwable -> L46
        if (((SubscribedFlowCollector) r101).a(r102) != r104) goto L32;
        return r104;
    L32:
        r117 = r101;
        r107 = r118;
    L7:
        r102 = new AnonymousClass1(r100, r110);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.l
    public final Flow<T> a(CoroutineContext r100, int r101, BufferOverflow r102) {
        return SharedFlowKt.fuseSharedFlow(this, r100, r101, r102);
    }

    public final Object[] m(Object[] r100, int r101, int r102) {
        int r103 = 0;
        if (r102 <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L15;
        Object[] r105 = new Object[r102];
        this.f504812h = r105;
        if (r100 != null) goto L10;
        return r105;
    L10:
        long r106 = l();
    L11:
        if (r103 >= r101) goto L13;
        long r107 = ((long) r103) + r106;
        SharedFlowKt.access$setBufferAt(r105, r107, SharedFlowKt.access$getBufferAt(r100, r107));
        r103 = r103 + 1;
        goto L11
    L13:
        return r105;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r104 = false;
        goto L6
    }

    public final void q(long r100, long r101, long r110, long r111) {
        long r102 = Math.min(r101, r100);
        long r103 = l();
    L4:
        if (r103 >= r102) goto L6;
        Object[] r104 = this.f504812h;
        Intrinsics.checkNotNull(r104);
        SharedFlowKt.access$setBufferAt(r104, r103, null);
        r103 = r103 + 1;
        goto L4
    L6:
        this.f504813i = r100;
        this.f504814j = r101;
        this.f504815k = (int) (r110 - r102);
        this.f504816l = (int) (r111 - r110);
    }
}
