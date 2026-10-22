package com.larus.dora.impl.ota.g2;

import androidx.core.app.NotificationCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidG2OtaRuntime implements d4, q4, r4 {
    private static final a Companion = null;
    public static final int PACKAGE_DELETE_ATTEMPTS = 3;
    public static final long PACKAGE_DELETE_RETRY_MS = 1000;
    public static final String TAG = "G2OtaRuntime";
    private final Map<e, Long> cancelledThrough;
    private final Map<e, Long> cancelledUploadThrough;
    private final Function0<Long> clock;
    private final Map<e, Long> disconnectedUploadThrough;
    private final Object downloadLock;
    private final o downloader;
    private final ConcurrentHashMap<c, b> downloads;
    private final p latest;
    private Set<d5> leasedPackages;
    private final Object packageLock;
    private final ConcurrentHashMap<c, k4.b> prepared;
    private final CoroutineScope scope;
    private final k4 storage;
    private final o4 telemetry;
    private final p4 transport;
    private final Object uploadLock;
    private volatile Function3<? super e, ? super String, ? super Long, ? extends FailureReason> uploadStartGate;
    private final s4 wifiController;

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return invoke();
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {
        private volatile int downloadId;
        private volatile long lastBytes;
        private volatile int lastPercent;
        private volatile BlockReason pauseReason;

        public final int a() {
            return this.downloadId;
        }

        public final long b() {
            return this.lastBytes;
        }

        public final int c() {
            return this.lastPercent;
        }

        public final BlockReason d() {
            return this.pauseReason;
        }

        public b(long r100) {
            this.pauseReason = BlockReason.NONE;
            this.lastBytes = r100;
            this.lastPercent = -1;
        }

        public final void e(int r100) {
            this.downloadId = r100;
        }

        public final void f(long r100) {
            this.lastBytes = r100;
        }

        public final void g(int r100) {
            this.lastPercent = r100;
        }

        public final void h(BlockReason r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.pauseReason = r100;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class c {
        private final e device;
        private final long operationId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.device.hashCode() * 31;
            long r101 = this.operationId;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "OperationKey(device=" + this.device + ", operationId=" + this.operationId + ')';
        }

        public c(e r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.device = r100;
            this.operationId = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d implements p4.a {
        final /* synthetic */ q.m $effect;
        final /* synthetic */ Function1<s, Unit> $emit;
        final /* synthetic */ AndroidG2OtaRuntime $this_runCatching;

        @Override // com.larus.dora.impl.ota.g2.p4.a
        public final FailureReason a() {
            return (FailureReason) AndroidG2OtaRuntime.h(this.$this_runCatching).invoke(this.$effect.a(), this.$effect.c(), Long.valueOf(this.$effect.b()));
        }

        @Override // com.larus.dora.impl.ota.g2.p4.a
        public final void c(int r110) {
            this.$emit.invoke(new s.l0(this.$effect.a(), this.$effect.c(), this.$effect.b(), r110, ((Number) AndroidG2OtaRuntime.d(this.$this_runCatching).invoke()).longValue()));
        }

        @Override // com.larus.dora.impl.ota.g2.p4.a
        public final void b(boolean r110, FailureReason r111) {
            Intrinsics.checkNotNullParameter(r111, "reason");
            this.$emit.invoke(new s.k0(this.$effect.a(), this.$effect.c(), this.$effect.b(), r110, r111, ((Number) AndroidG2OtaRuntime.d(this.$this_runCatching).invoke()).longValue()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(AndroidG2OtaRuntime r100, q.m r101, Function1<? super s, Unit> r102) {
            this.$this_runCatching = r100;
            this.$effect = r101;
            this.$emit = r102;
        }
    }

    static {
        Companion = new a();
    }

    public static final /* synthetic */ Function0 d(AndroidG2OtaRuntime r100) {
        return r100.clock;
    }

    public static final /* synthetic */ ConcurrentHashMap e(AndroidG2OtaRuntime r100) {
        return r100.downloads;
    }

    public static final /* synthetic */ CoroutineScope f(AndroidG2OtaRuntime r100) {
        return r100.scope;
    }

    public static final /* synthetic */ k4 g(AndroidG2OtaRuntime r100) {
        return r100.storage;
    }

    public static final /* synthetic */ Function3 h(AndroidG2OtaRuntime r100) {
        return r100.uploadStartGate;
    }

    @Override // com.larus.dora.impl.ota.g2.r4
    public final void a(Function3<? super e, ? super String, ? super Long, ? extends FailureReason> r100) {
        Intrinsics.checkNotNullParameter(r100, "gate");
        this.uploadStartGate = r100;
    }

    @Override // com.larus.dora.impl.ota.g2.q4
    public final void c(b5 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Object r101 = this.packageLock;
        monitor-enter(r101);
        Set r102 = SetsKt.createSetBuilder();     // Catch: Throwable -> L28
        Iterator<T> r103 = r100.c().values().iterator();     // Catch: Throwable -> L28
    L6:
        if (r103.hasNext() == false) goto L20;
        f r104 = (f) r103.next();     // Catch: Throwable -> L28
        e5 r105 = r104.l().h();     // Catch: Throwable -> L28
        if (r105 == null) goto L6;
        d5 r106 = r105.h();     // Catch: Throwable -> L28
        if (r106 == null) goto L6;
        if (r104.l().f() == PackagePhase.CLEANING) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L18;
        r106 = null;
    L18:
        if (r106 == null) goto L6;
        r102.add(r106);     // Catch: Throwable -> L28
        goto L6
    L14:
        r107 = false;
        goto L15
    L20:
        t4 r108 = r100.h();     // Catch: Throwable -> L28
        if (r108 == null) goto L25;
        d5 r109 = r108.g();     // Catch: Throwable -> L28
        if (r109 == null) goto L25;
        r102.add(r109);     // Catch: Throwable -> L28
    L25:
        this.leasedPackages = SetsKt.build(r102);     // Catch: Throwable -> L28
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r101);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public static void n(q r100, Throwable r101) {
        g49.d.b("G2OtaRuntime", "effect failed type=" + j0.e(r100) + " error=" + r101.getClass().getSimpleName());
    }

    public final boolean m(e r100, long r101) {
        Object r102 = this.uploadLock;
        monitor-enter(r102);
        Long r103 = this.cancelledUploadThrough.get(r100);     // Catch: Throwable -> L15
        if (r103 == null) goto L8;
        long r104 = r103.longValue();     // Catch: Throwable -> L15
    L10:
        if (r104 < r101) goto L12;
        boolean r105 = true;
    L13:
        monitor-exit(r102);
        return r105;
    L12:
        r105 = false;
        goto L13
    L8:
        r104 = 0;
    L15:
        th = move-exception;
        throw th;
    }

    public final void o(q.h r110, Function1<? super s, Unit> r111) {
        Object r100 = this.downloadLock;
        monitor-enter(r100);
        Map<e, Long> r101 = this.cancelledThrough;     // Catch: Throwable -> L22
        e r102 = r110.a();     // Catch: Throwable -> L22
        Long r103 = this.cancelledThrough.get(r110.a());     // Catch: Throwable -> L22
        if (r103 == null) goto L7;
        long r104 = r103.longValue();     // Catch: Throwable -> L22
    L8:
        r101.put(r102, Long.valueOf(Math.max(r104, r110.b())));     // Catch: Throwable -> L22
        b r105 = this.downloads.get(new c(r110.a(), r110.b()));     // Catch: Throwable -> L22
        if (r105 != null) goto L11;
        this.prepared.remove(new c(r110.a(), r110.b()));     // Catch: Throwable -> L22
        r111.invoke(new s.g(r110.a(), r110.b(), r110.c(), this.clock.invoke().longValue()));     // Catch: Throwable -> L22
    L19:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r100);
        return;
    L11:
        r105.h(r110.c());     // Catch: Throwable -> L22
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        this.downloader.pause(r105.a());     // Catch: Throwable -> L14
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L22
        if (r109 == null) goto L19;
        this.downloads.remove(new c(r110.a(), r110.b()), r105);     // Catch: Throwable -> L22
        n(r110, r109);     // Catch: Throwable -> L22
        k(this, r110.a(), r110.b(), FailureReason.DOWNLOAD_FAILED, r111);     // Catch: Throwable -> L22
        goto L19
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L22
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
        goto L16
    L7:
        r104 = 0;
    L22:
        th = move-exception;
        throw th;
    }

    public final void p(q.i r110, Function1<? super s, Unit> r111) {
        c r100 = new c(r110.a(), r110.b());
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(this.storage.i(r110.c()));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        n(r110, r103);
    L11:
        if (Result.m9452exceptionOrNullimpl(r102) != null) goto L43;
        k4.c r104 = (k4.c) r102;
        if ((r104 instanceof k4.c.d) == false) goto L32;
        Object r105 = this.downloadLock;
        monitor-enter(r105);
        long r106 = r110.b();     // Catch: Throwable -> L28
        Long r107 = this.cancelledThrough.get(r110.a());     // Catch: Throwable -> L28
        if (r107 == null) goto L20;
        long r108 = r107.longValue();     // Catch: Throwable -> L28
    L22:
        if (r106 > r108) goto L25;
        monitor-exit(r105);
        return;
    L25:
        this.prepared.put(r100, ((k4.c.d) r104).a());     // Catch: Throwable -> L28
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r105);
        r111.invoke(new s.h(r110.a(), r110.b(), this.clock.invoke().longValue(), ((k4.c.d) r104).a().b()));
        return;
    L20:
        r108 = 0;
    L28:
        th = move-exception;
        throw th;
    L32:
        if (Intrinsics.areEqual(r104, k4.c.b.INSTANCE) == false) goto L35;
        k(this, r110.a(), r110.b(), FailureReason.STORAGE_INSUFFICIENT, r111);
        return;
    L35:
        if (Intrinsics.areEqual(r104, k4.c.a.INSTANCE) == false) goto L37;
    L41:
        k(this, r110.a(), r110.b(), FailureReason.DOWNLOAD_FAILED, r111);
        return;
    L37:
        if (Intrinsics.areEqual(r104, k4.c.C4276c.INSTANCE) == true) goto L41;
        throw new NoWhenBranchMatchedException();
    L43:
        k(this, r110.a(), r110.b(), FailureReason.DOWNLOAD_FAILED, r111);
        return;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void q(q.l r100, Function1<? super s, Unit> r101) {
        Object r102 = this.downloadLock;
        monitor-enter(r102);
        long r103 = r100.c();     // Catch: Throwable -> L15
        Long r104 = this.cancelledThrough.get(r100.a());     // Catch: Throwable -> L15
        if (r104 == null) goto L7;
        long r105 = r104.longValue();     // Catch: Throwable -> L15
    L9:
        if (r103 > r105) goto L11;
        this.prepared.remove(new c(r100.a(), r100.c()));     // Catch: Throwable -> L15
    L12:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r102);
        return;
    L11:
        r(r100, r101);     // Catch: Throwable -> L15
        goto L12
    L7:
        r105 = 0;
    L15:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime$startLocked$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r(final q.l r110, final Function1<? super s, Unit> r111) {
        final c r100 = new c(r110.a(), r110.c());
        k4.b r101 = this.prepared.remove(r100);
        if (r101 != null) goto L5;
        r101 = this.storage.j(r110.d());
    L5:
        if (r101 != null) goto L8;
        k(this, r110.a(), r110.c(), FailureReason.DOWNLOAD_FAILED, r111);
        return;
    L8:
        final b r112 = new b(r101.b());
        this.downloads.put(r100, r112);
        r112.e(this.downloader.c(r110.d(), r101, r110.b(), new AndroidG2OtaRuntime$startLocked$1(this, r100, r112, r110, r111)));
        g49.d.d("G2OtaRuntime", "download started operation=" + r110.c() + " id=" + r112.a() + " resumeBytes=" + r101.b());
        return;
    L12:
        th = move-exception;
        this.downloads.remove(r100, r112);
        g49.d.b("G2OtaRuntime", "download start failed operation=" + r110.c() + " error=" + th.getClass().getSimpleName());
        k(this, r110.a(), r110.c(), FailureReason.DOWNLOAD_FAILED, r111);
    }

    public final void s(q.m r210, Function1<? super s, Unit> r211) {
        k4 r100 = this.storage;
        e5 r101 = r210.d();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "spec");
        k4.b r102 = r100.j(r101);
        if (r102 == null) goto L5;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102.a(), r102.c());
    L6:
        if (r103 != null) goto L8;
    L31:
        r211.invoke(new s.k0(r210.a(), r210.c(), r210.b(), false, FailureReason.DOWNLOAD_MD5_FAILED, this.clock.invoke().longValue()));
        return;
    L8:
        if (this.storage.l(r210.d()) == false) goto L31;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
        Object r105 = this.uploadLock;     // Catch: Throwable -> L25
        monitor-enter(r105);     // Catch: Throwable -> L25
        Long r106 = this.cancelledUploadThrough.get(r210.a());     // Catch: Throwable -> L22
        if (r106 == null) goto L15;
        long r107 = r106.longValue();     // Catch: Throwable -> L22
    L17:
        if (r107 >= r210.b()) goto L20;
        this.transport.d(r210.a(), r210.c(), r210.b(), r210.d(), r103.getAbsolutePath(), new d(this, r210, r211));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r105);     // Catch: Throwable -> L25
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L36;
        n(r210, r109);
        r211.invoke(new s.k0(r210.a(), r210.c(), r210.b(), false, FailureReason.TRANSFER_FAILED, this.clock.invoke().longValue()));
        return;
    L36:
        return;
    L15:
        r107 = 0;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:201:0x04bb -> B:207:0x04e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x04d3 -> B:206:0x04dd). Please report as a decompilation issue!!! */
    @Override // com.larus.dora.impl.ota.g2.d4
    public final Object b(q r210, Function1<? super s, Unit> r211, Continuation<? super Unit> r212) {
        q r100 = r210;
        Function1<? super s, Unit> r101 = r211;
        if ((r212 instanceof AndroidG2OtaRuntime$execute$1) == false) goto L7;
        AndroidG2OtaRuntime$execute$1 r102 = (AndroidG2OtaRuntime$execute$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r102.label) {
            case 0: goto L34;
            case 1: goto L29;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        String r106 = (String) r102.L$2;
        r101 = (Function1) r102.L$1;
        q r107 = (q) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        String r108 = r106;
        r100 = r107;
    L218:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L220
    L223:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L227;
        n(r100, r110);
    L227:
        if (Result.m9452exceptionOrNullimpl(r109) != null) goto L233;
        Unit r111 = (Unit) r109;
        if (((q.k) r100).a() == false) goto L236;
        if (r108 == null) goto L236;
        r101.invoke(new s.i0(r108, this.clock.invoke().longValue()));
    L236:
        Unit r112 = Unit.INSTANCE;
    L238:
        return Unit.INSTANCE;
    L233:
        if (((q.k) r100).a() == false) goto L236;
        if (r108 == null) goto L236;
        r101.invoke(new s.h0(r108, this.clock.invoke().longValue()));
    L220:
        Throwable th10 = th;
        r107 = r100;
        r106 = r108;
    L222:
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r108 = r106;
        r100 = r107;
    L15:
        th10 = th;
        goto L222
    L17:
        int r114 = r102.I$0;
        Ref.BooleanRef r115 = (Ref.BooleanRef) r102.L$3;
        Ref.BooleanRef r116 = (Ref.BooleanRef) r102.L$2;
        Function1<? super s, Unit> r117 = (Function1) r102.L$1;
        q r118 = (q) r102.L$0;
        ResultKt.throwOnFailure(r104);
        AndroidG2OtaRuntime r119 = this;
    L206:
        AndroidG2OtaRuntime$execute$1 r213 = r102;
        int r120 = r114;
        r100 = r118;
        Ref.BooleanRef r121 = r116;
        Ref.BooleanRef r122 = r115;
        r101 = r117;
        Object r123 = r105;
        AndroidG2OtaRuntime$execute$1 r124 = r213;
    L207:
        r120 = r120 + 1;
    L164:
        if (r120 >= 4) goto L211;
        Object r125 = r119.packageLock;
        monitor-enter(r125);
        if (r119.leasedPackages.contains(((q.e) r100).d().h()) == false) goto L171;
        boolean r126 = true;
    L196:
        monitor-exit(r125);
        if (r126 == false) goto L200;
        StringBuilder r127 = new StringBuilder("delete skipped leased package device=");
        q.e r128 = (q.e) r100;
        r127.append(j0.d(r128.c()));
        r127.append(" effect=");
        r127.append(r128.b());
        g49.d.d("G2OtaRuntime", r127.toString());
        goto L211
    L200:
        if (r121.element == true) goto L211;
        if (r120 >= 3) goto L207;
        r124.L$0 = r100;
        r124.L$1 = r101;
        r124.L$2 = r121;
        r124.L$3 = r122;
        r124.I$0 = r120;
        r124.label = 5;
        if (DelayKt.delay(1000, r124) != r123) goto L205;
        return r123;
    L205:
        Ref.BooleanRef r214 = r121;
        r118 = r100;
        r114 = r120;
        r102 = r124;
        r105 = r123;
        r117 = r101;
        r115 = r122;
        r116 = r214;
        goto L206
    L171:
        if (r122.element == true) goto L243;
        Integer r129 = ((q.e) r100).a();     // Catch: Throwable -> L208
        if (r129 == null) goto L183;
        int r130 = r129.intValue();     // Catch: Throwable -> L208
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L177
        r119.downloader.b(r130);     // Catch: Throwable -> L177
        Object r132 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L177
    L179:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);     // Catch: Throwable -> L208
        if (r133 == null) goto L182;
        n(r100, r133);     // Catch: Throwable -> L208
    L182:
        Result.m9448boximpl(r132);     // Catch: Throwable -> L208
        goto L183
    L177:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L208
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L208
    L183:
        r122.element = true;     // Catch: Throwable -> L208
    L243:
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L186
        Object r136 = Result.m9449constructorimpl(Boxing.boxBoolean(r119.storage.delete(((q.e) r100).d())));     // Catch: Throwable -> L186
    L188:
        Throwable r137 = Result.m9452exceptionOrNullimpl(r136);     // Catch: Throwable -> L208
        if (r137 == null) goto L191;
        n(r100, r137);     // Catch: Throwable -> L208
    L191:
        Boolean r138 = Boxing.boxBoolean(false);     // Catch: Throwable -> L208
        if (Result.m9455isFailureimpl(r136) == false) goto L194;
        r136 = r138;
    L194:
        r121.element = ((Boolean) r136).booleanValue();     // Catch: Throwable -> L208
        r126 = false;
        goto L196
    L186:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L208
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L208
    L208:
        th = move-exception;
        throw th;
    L211:
        q.e r140 = (q.e) r100;
        r101.invoke(new s.p(r140.c(), r140.b(), r121.element, r119.clock.invoke().longValue()));
        Unit r141 = Unit.INSTANCE;
        goto L238
    L18:
        Function1<? super s, Unit> r142 = (Function1) r102.L$1;
        q r143 = (q) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
        r101 = r142;
        r100 = r143;
    L146:
        Object r144 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L148
        Function1<? super s, Unit> r145 = r101;
    L151:
        Throwable r146 = Result.m9452exceptionOrNullimpl(r144);
        if (r146 == null) goto L154;
        n(r100, r146);
    L154:
        q.n r147 = (q.n) r100;
        if (this.transport.c(r147.a(), r147.c()) == false) goto L157;
        l(r147.a(), r147.c(), r147.b(), r145);
    L157:
        Unit r148 = Unit.INSTANCE;
    L148:
        Throwable th11 = th;
        Function1<? super s, Unit> r215 = r101;
        r143 = r100;
        r142 = r215;
    L150:
        Result.Companion r149 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th11));
        r145 = r142;
        r100 = r143;
    L21:
        th11 = th;
        goto L150
    L23:
        ResultKt.throwOnFailure(r104);
    L129:
        return Unit.INSTANCE;
    L24:
        OtaMode r150 = (OtaMode) r102.L$4;
        String r151 = (String) r102.L$3;
        e r152 = (e) r102.L$2;
        Function1<? super s, Unit> r153 = (Function1) r102.L$1;
        q r154 = (q) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L27
        OtaMode r155 = r150;
        String r156 = r151;
        r100 = r154;
        r101 = r153;
    L245:
        Object r157 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r104).booleanValue()));     // Catch: Throwable -> L87
    L92:
        e r158 = r152;
        String r159 = r156;
        OtaMode r160 = r155;
        Throwable r161 = Result.m9452exceptionOrNullimpl(r157);
        if (r161 == null) goto L95;
        n(r100, r161);
        Unit r162 = Unit.INSTANCE;
    L95:
        Boolean r163 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r157) == false) goto L98;
        r157 = r163;
    L98:
        r101.invoke(new s.q(r158, r159, r160, ((Boolean) r157).booleanValue(), this.clock.invoke().longValue()));
        Unit r164 = Unit.INSTANCE;
    L87:
        th = th;
    L91:
        Result.Companion r165 = Result.Companion;
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        th = th;
        r155 = r150;
        r156 = r151;
        r100 = r154;
        r101 = r153;
        goto L91
    L29:
        Function1<? super s, Unit> r166 = (Function1) r102.L$1;
        q r167 = (q) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L32
        r101 = r166;
        r100 = r167;
    L42:
        Object r168 = Result.m9449constructorimpl((x4) r104);     // Catch: Throwable -> L44
    L47:
        Throwable r169 = Result.m9452exceptionOrNullimpl(r168);
        if (r169 == null) goto L51;
        n(r100, r169);
    L51:
        if (Result.m9452exceptionOrNullimpl(r168) == null) goto L54;
        r168 = new x4.b(FailureReason.VERSION_CHECK_FAILED);
    L54:
        q.b r170 = (q.b) r100;
        e r171 = r170.a();
        long r172 = r170.b();
        r101.invoke(new s.r(r171, r172, (x4) r168, this.clock.invoke().longValue()));
        Unit r173 = Unit.INSTANCE;
    L44:
        Throwable th12 = th;
        Function1<? super s, Unit> r216 = r101;
        r167 = r100;
        r166 = r216;
    L46:
        Result.Companion r174 = Result.Companion;
        r168 = Result.m9449constructorimpl(ResultKt.createFailure(th12));
        q r217 = r167;
        r101 = r166;
        r100 = r217;
    L32:
        th12 = th;
        goto L46
    L34:
        ResultKt.throwOnFailure(r104);
        if ((r100 instanceof q.f) == false) goto L38;
        r101.invoke(((q.f) r100).a());
        Unit r175 = Unit.INSTANCE;
        goto L238
    L38:
        if ((r100 instanceof q.b) == false) goto L56;
        Result.Companion r176 = Result.Companion;     // Catch: Throwable -> L44
        r102.L$0 = r100;     // Catch: Throwable -> L44
        r102.L$1 = r101;     // Catch: Throwable -> L44
        r102.label = 1;     // Catch: Throwable -> L44
        r104 = this.latest.a((q.b) r100, r102);     // Catch: Throwable -> L44
        if (r104 != r105) goto L42;
        return r105;
    L56:
        if ((r100 instanceof q.i) == false) goto L59;
        p((q.i) r100, r101);
        Unit r177 = Unit.INSTANCE;
        goto L238
    L59:
        if ((r100 instanceof q.l) == false) goto L62;
        q((q.l) r100, r101);
        Unit r178 = Unit.INSTANCE;
        goto L238
    L62:
        if ((r100 instanceof q.h) == false) goto L65;
        o((q.h) r100, r101);
        Unit r179 = Unit.INSTANCE;
        goto L238
    L65:
        if ((r100 instanceof q.a) == false) goto L79;
        q.a r180 = (q.a) r100;
        e r181 = r180.b();
        long r182 = r180.c();
        long r183 = r180.a();
        Result.Companion r184 = Result.Companion;     // Catch: Throwable -> L69
        Object r185 = Result.m9449constructorimpl(Boxing.boxBoolean(this.storage.e(((q.a) r100).d(), ((q.a) r100).a())));     // Catch: Throwable -> L69
    L71:
        Throwable r186 = Result.m9452exceptionOrNullimpl(r185);
        if (r186 == null) goto L74;
        n(r100, r186);
        Unit r187 = Unit.INSTANCE;
    L74:
        Boolean r188 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r185) == false) goto L77;
        r185 = r188;
    L77:
        r101.invoke(new s.j(r181, r182, r183, ((Boolean) r185).booleanValue(), this.clock.invoke().longValue()));
        Unit r189 = Unit.INSTANCE;
    L69:
        th = move-exception;
        Result.Companion r190 = Result.Companion;
        r185 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L71
    L79:
        if ((r100 instanceof q.d) == false) goto L100;
        q.d r191 = (q.d) r100;
        e r192 = r191.a();
        r156 = r191.c();
        r155 = r191.b();
        Result.Companion r193 = Result.Companion;     // Catch: Throwable -> L89
        p4 r194 = this.transport;     // Catch: Throwable -> L89
        e r195 = ((q.d) r100).a();     // Catch: Throwable -> L89
        String r196 = ((q.d) r100).c();     // Catch: Throwable -> L89
        OtaMode r197 = ((q.d) r100).b();     // Catch: Throwable -> L89
        r102.L$0 = r100;     // Catch: Throwable -> L89
        r102.L$1 = r101;     // Catch: Throwable -> L89
        r102.L$2 = r192;     // Catch: Throwable -> L89
        r102.L$3 = r156;     // Catch: Throwable -> L89
        r102.L$4 = r155;     // Catch: Throwable -> L89
        r102.label = 2;     // Catch: Throwable -> L89
        r104 = r194.e(r195, r196, r197);     // Catch: Throwable -> L89
        if (r104 != r105) goto L84;
        return r105;
    L84:
        r152 = r192;
    L89:
        th = th;
        r152 = r192;
        goto L91
    L100:
        if ((r100 instanceof q.g) == false) goto L114;
        q.g r198 = (q.g) r100;
        e r199 = r198.a();
        String r1100 = r198.c();
        long r1101 = r198.b();
        Result.Companion r200 = Result.Companion;     // Catch: Throwable -> L104
        Object r201 = Result.m9449constructorimpl(Boxing.boxBoolean(this.wifiController.b(((q.g) r100).c())));     // Catch: Throwable -> L104
    L106:
        Throwable r202 = Result.m9452exceptionOrNullimpl(r201);
        if (r202 == null) goto L109;
        n(r100, r202);
        Unit r203 = Unit.INSTANCE;
    L109:
        Boolean r204 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r201) == false) goto L112;
        r201 = r204;
    L112:
        r101.invoke(new s.o0(r199, r1100, r1101, ((Boolean) r201).booleanValue(), this.clock.invoke().longValue()));
        Unit r205 = Unit.INSTANCE;
    L104:
        th = move-exception;
        Result.Companion r206 = Result.Companion;
        r201 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L106
    L114:
        if ((r100 instanceof q.j) == false) goto L124;
        Result.Companion r207 = Result.Companion;     // Catch: Throwable -> L117
        this.wifiController.a(((q.j) r100).a());     // Catch: Throwable -> L117
        Object r208 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L117
    L119:
        Throwable r209 = Result.m9452exceptionOrNullimpl(r208);
        if (r209 == null) goto L122;
        n(r100, r209);
    L122:
        Result.m9448boximpl(r208);
    L117:
        th = move-exception;
        Result.Companion r218 = Result.Companion;
        r208 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L119
    L124:
        if ((r100 instanceof q.c) == false) goto L131;
        r102.label = 3;
        if (i((q.c) r100, r101, r102) != r105) goto L129;
        return r105;
    L131:
        if ((r100 instanceof q.m) == false) goto L134;
        s((q.m) r100, r101);
        Unit r219 = Unit.INSTANCE;
        goto L238
    L134:
        if ((r100 instanceof q.n) == false) goto L162;
        Object r220 = this.uploadLock;
        monitor-enter(r220);
        Map<e, Long> r221 = this.cancelledUploadThrough;     // Catch: Throwable -> L158
        e r222 = ((q.n) r100).a();     // Catch: Throwable -> L158
        Long r223 = this.cancelledUploadThrough.get(((q.n) r100).a());     // Catch: Throwable -> L158
        if (r223 == null) goto L140;
        long r224 = r223.longValue();     // Catch: Throwable -> L158
    L141:
        r221.put(r222, Boxing.boxLong(Math.max(r224, ((q.n) r100).b())));     // Catch: Throwable -> L158
        Unit r225 = Unit.INSTANCE;     // Catch: Throwable -> L158
        monitor-exit(r220);
        Result.Companion r226 = Result.Companion;     // Catch: Throwable -> L148
        p4 r227 = this.transport;     // Catch: Throwable -> L148
        e r228 = ((q.n) r100).a();     // Catch: Throwable -> L148
        String r1102 = ((q.n) r100).c();     // Catch: Throwable -> L148
        long r1103 = ((q.n) r100).b();     // Catch: Throwable -> L148
        FailureReason r1104 = ((q.n) r100).d();     // Catch: Throwable -> L148
        r102.L$0 = r100;     // Catch: Throwable -> L148
        r102.L$1 = r101;     // Catch: Throwable -> L148
        r102.label = 4;     // Catch: Throwable -> L148
        if (r227.a(r228, r1102, r1103, r1104) != r105) goto L146;
        return r105;
    L140:
        r224 = 0;
    L158:
        th = move-exception;
        throw th;
    L162:
        if ((r100 instanceof q.e) == false) goto L213;
        Ref.BooleanRef r229 = new Ref.BooleanRef();
        r122 = new Ref.BooleanRef();
        r121 = r229;
        r123 = r105;
        r119 = this;
        r124 = r102;
        r120 = 1;
        goto L164
    L213:
        if ((r100 instanceof q.k) == false) goto L240;
        r108 = ((q.k) r100).b().b().get("event_id");
        Result.Companion r230 = Result.Companion;     // Catch: Throwable -> L220
        o4 r231 = this.telemetry;     // Catch: Throwable -> L220
        p5 r232 = ((q.k) r100).b();     // Catch: Throwable -> L220
        r102.L$0 = r100;     // Catch: Throwable -> L220
        r102.L$1 = r101;     // Catch: Throwable -> L220
        r102.L$2 = r108;     // Catch: Throwable -> L220
        r102.label = 6;     // Catch: Throwable -> L220
        if (r231.a(r232) != r105) goto L218;
        return r105;
    L240:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r102 = new AndroidG2OtaRuntime$execute$1(this, r212);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.dora.impl.ota.g2.p4] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.dora.impl.ota.g2.a] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.dora.impl.ota.g2.q$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.dora.impl.ota.g2.q, com.larus.dora.impl.ota.g2.q$c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.dora.impl.ota.g2.q, com.larus.dora.impl.ota.g2.q$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object i(q.c r210, Function1<? super s, Unit> r211, Continuation<? super Unit> r212) {
        final ?? r100 = r210;
        final ?? r101 = r211;
        if ((r212 instanceof AndroidG2OtaRuntime$connect$1) == false) goto L7;
        AndroidG2OtaRuntime$connect$1 r102 = (AndroidG2OtaRuntime$connect$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L24;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        Function1 r107 = (Function1) r102.L$1;
        q.c r108 = (q.c) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        r100 = r107;
        r101 = r108;
    L46:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        ?? r110 = r100;
        ?? r111 = r101;
    L49:
        ?? r112 = r110;
        Throwable r113 = Result.m9452exceptionOrNullimpl(r109);
        if (r113 == null) goto L53;
        n(r111, r113);
    L53:
        if (this.transport.c(r111.a(), r111.d()) == false) goto L56;
        l(r111.a(), r111.d(), r111.c(), r112);
    L56:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Function1 r114 = (Function1) r102.L$1;
        q.c r115 = (q.c) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
        r101 = r114;
        r100 = r115;
    L31:
        Object r116 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r104).booleanValue()));     // Catch: Throwable -> L33
        ?? r117 = r100;
        ?? r118 = r101;
    L35:
        ?? r213 = r118;
        ?? r119 = r117;
        ?? r120 = r213;
        Throwable r121 = Result.m9452exceptionOrNullimpl(r116);
        if (r121 == null) goto L38;
        n(r119, r121);
    L38:
        Boolean r122 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r116) == false) goto L41;
        r116 = r122;
    L41:
        boolean r123 = ((Boolean) r116).booleanValue();
        if (m(r119.a(), r119.c()) == false) goto L57;
        p4 r124 = this.transport;     // Catch: Throwable -> L15
        e r125 = r119.a();     // Catch: Throwable -> L15
        String r126 = r119.d();     // Catch: Throwable -> L15
        long r127 = r119.c();     // Catch: Throwable -> L15
        FailureReason r128 = FailureReason.UNKNOWN;     // Catch: Throwable -> L15
        r102.L$0 = r119;     // Catch: Throwable -> L15
        r102.L$1 = r120;     // Catch: Throwable -> L15
        r102.label = 2;     // Catch: Throwable -> L15
        r100 = r120;
        r101 = r119;
        if (r124.a(r125, r126, r127, r128) != r105) goto L46;
        return r105;
    L57:
        r120.invoke(new s.c0(r119.a(), r119.d(), r119.c(), r123, this.clock.invoke().longValue()));
        return Unit.INSTANCE;
    L33:
        Throwable th10 = th;
    L34:
        Result.Companion r129 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r117 = r100;
        r118 = r101;
    L22:
        th10 = th;
        r101 = r114;
        r100 = r115;
        goto L34
    L24:
        ResultKt.throwOnFailure(r104);
        if (m(r210.a(), r210.c()) == true) goto L27;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L33
        ?? r131 = this.transport;     // Catch: Throwable -> L33
        e r132 = r210.a();     // Catch: Throwable -> L33
        String r133 = r210.d();     // Catch: Throwable -> L33
        long r134 = r210.c();     // Catch: Throwable -> L33
        OtaMode r135 = r210.b();     // Catch: Throwable -> L33
        ?? r136 = new com.larus.dora.impl.ota.g2.a(this, r100, r101);     // Catch: Throwable -> L33
        r102.L$0 = r100;     // Catch: Throwable -> L33
        r102.L$1 = r101;     // Catch: Throwable -> L33
        r102.label = 1;     // Catch: Throwable -> L33
        r104 = r131.b(r132, r133, r134, r135, r136, r102);     // Catch: Throwable -> L33
        r100 = r100;
        r101 = r101;
        if (r104 != r105) goto L31;
        return r105;
    L27:
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r110 = r100;
        r111 = r101;
    L7:
        r102 = new AndroidG2OtaRuntime$connect$1(this, r212);
        goto L8
    }

    public final void l(e r110, String r111, long r112, Function1<? super s, Unit> r113) {
        Object r100 = this.uploadLock;
        monitor-enter(r100);
        Long r101 = this.disconnectedUploadThrough.get(r110);     // Catch: Throwable -> L17
        if (r101 == null) goto L7;
        long r102 = r101.longValue();     // Catch: Throwable -> L17
    L9:
        if (r102 < r112) goto L11;
        boolean r103 = false;
    L13:
        monitor-exit(r100);
        if (r103 == false) goto L22;
        r113.invoke(new s.d0(r110, r111, r112, this.clock.invoke().longValue()));
        return;
    L22:
        return;
    L11:
        Long r104 = Long.valueOf(r112);     // Catch: Throwable -> L17
        this.disconnectedUploadThrough.put(r110, r104);     // Catch: Throwable -> L17
        r103 = true;
        goto L13
    L7:
        r102 = 0;
    L17:
        th = move-exception;
        throw th;
    }

    public AndroidG2OtaRuntime(k4 r100, DoraG2LatestSource r101, l5 r102, i r103, m4 r104) {
        com.larus.dora.impl.ota.g2.c r105 = new com.larus.dora.impl.ota.g2.c();
        AnonymousClass1 r106 = AnonymousClass1.INSTANCE;
        CoroutineScope r107 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "latest");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.DOWNLOAD_TABLE_NAME);
        Intrinsics.checkNotNullParameter(r103, NotificationCompat.CATEGORY_TRANSPORT);
        Intrinsics.checkNotNullParameter(r104, "telemetry");
        Intrinsics.checkNotNullParameter(r105, "wifiController");
        Intrinsics.checkNotNullParameter(r106, "clock");
        Intrinsics.checkNotNullParameter(r107, "scope");
        this.storage = r100;
        this.latest = r101;
        this.downloader = r102;
        this.transport = r103;
        this.telemetry = r104;
        this.wifiController = r105;
        this.clock = r106;
        this.scope = r107;
        this.downloadLock = new Object();
        this.uploadLock = new Object();
        this.packageLock = new Object();
        this.prepared = new ConcurrentHashMap();
        this.downloads = new ConcurrentHashMap();
        this.cancelledThrough = new LinkedHashMap();
        this.cancelledUploadThrough = new LinkedHashMap();
        this.disconnectedUploadThrough = new LinkedHashMap();
        this.uploadStartGate = new com.larus.dora.impl.ota.g2.b();
        this.leasedPackages = SetsKt.emptySet();
    }

    public static /* synthetic */ void k(AndroidG2OtaRuntime r100, e r101, long r102, FailureReason r110, Function1 r111) {
        r100.j(r101, r102, r110, r111, null);
    }

    public final void j(e r110, long r111, FailureReason r112, Function1<? super s, Unit> r113, Integer r114) {
        r113.invoke(new s.f(r110, r111, r112, this.clock.invoke().longValue(), r114));
    }
}
