package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingUploadService {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f434475q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingSession f434476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f434479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f434480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedBlockingQueue<MmRecordingUploadTask> f434481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f434482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<MmRecordingUploadTask> f434483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f434484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f434485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f434486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f434487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f434488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f434489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicInteger f434490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f434491p;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f434492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f434493b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f434492a == r101.f434492a) goto L12;
            return false;
        L12:
            if (this.f434493b == r101.f434493b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f434492a * 31) + this.f434493b;
        }

        public final String toString() {
            return "UploadProgressState(uploadedCount=" + this.f434492a + ", totalCount=" + this.f434493b + ')';
        }

        public b(int r100, int r101) {
            this.f434492a = r100;
            this.f434493b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434494a = null;

        static {
            int[] r100 = new int[MmRecordingUploadResponse.values().length];
            r100[MmRecordingUploadResponse.REACH_MAX_DURATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[MmRecordingUploadResponse.OBJECT_DELETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r100[MmRecordingUploadResponse.UPLOAD_COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[MmRecordingUploadResponse.NOT_LOGGED_IN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[MmRecordingUploadResponse.UNAUTHORIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[MmRecordingUploadResponse.SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r100[MmRecordingUploadResponse.INTERRUPTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r100[MmRecordingUploadResponse.NON_RECORDING_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r100[MmRecordingUploadResponse.TENANT_KEY_DELETED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[MmRecordingUploadResponse.ENCRYPTION_FAILED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r100[MmRecordingUploadResponse.GET_TENANT_KEY_FAILED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r100[MmRecordingUploadResponse.TOS_UPLOAD_FAILED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[MmRecordingUploadResponse.ABASE_FAILED.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r100[MmRecordingUploadResponse.TRANSCODING_FAILED.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r100[MmRecordingUploadResponse.SERVER_DOWN.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            f434494a = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingUploadService f434495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MmRecordingUploadTask f434496b;

        public d(MmRecordingUploadService r100, MmRecordingUploadTask r101) {
            this.f434495a = r100;
            this.f434496b = r101;
        }

        public final void a() {
            LinkedBlockingQueue<MmRecordingUploadTask> r100 = this.f434495a.f434481f;
            MmRecordingUploadTask r101 = this.f434496b;
            boolean r102 = false;
            if ((r100 instanceof Collection) == true) goto L5;
        L7:
            Iterator<MmRecordingUploadTask> r103 = r100.iterator();
        L9:
            if (r103.hasNext() == false) goto L16;
            if (r103.next().f434500b != r101.f434500b) goto L13;
            boolean r104 = true;
        L14:
            if (r104 == false) goto L9;
            boolean r105 = true;
        L17:
            if (r105 == true) goto L41;
            MmRecordingUploadService r106 = this.f434495a;
            Object r107 = r106.f434482g;
            MmRecordingUploadTask r108 = this.f434496b;
            monitor-enter(r107);
            Set<MmRecordingUploadTask> r109 = r106.f434483h;     // Catch: Throwable -> L38
            if ((r109 instanceof Collection) == true) goto L23;
        L25:
            Iterator<T> r110 = r109.iterator();     // Catch: Throwable -> L38
        L26:
            if (r110.hasNext() == false) goto L34;
            if (((MmRecordingUploadTask) r110.next()).f434500b != r108.f434500b) goto L31;
            boolean r111 = true;
        L32:
            if (r111 == false) goto L26;
            boolean r112 = true;
        L35:
            monitor-exit(r107);
            if (r112 == true) goto L41;
        L42:
            if (r102 == false) goto L45;
            lvb.a.h(this.f434495a.f434478c, "[addTask] duplicate segIndex: " + this.f434496b.f434500b + ", skip");
            return;
        L45:
            lvb.a.e(this.f434495a.f434478c, "[addTask] task:" + this.f434496b.f434501c + ", segIndex: " + this.f434496b.f434500b + ", Uploader:" + this.f434495a.hashCode());
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d r113 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434675c;
            String r114 = this.f434495a.f434476a.e();
            MmRecordingUploadTask r115 = this.f434496b;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r114, "recordingId");
            Intrinsics.checkNotNullParameter(r115, "task");
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.b r116 = r113.f434685a.get(r114);
            if (r116 != null) goto L48;
            lvb.a.h("MmRecordingUploadMetrics", "[onUploadTaskAdded] missing upload context, recordingId=" + r114 + ", segIndex=" + r115.f434500b);
        L55:
            MmRecordingUploadService r117 = this.f434495a;
            MmRecordingUploadTask r118 = this.f434496b;
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L58
            r117.f434481f.put(r118);     // Catch: Throwable -> L58
            Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L58
        L60:
            MmRecordingUploadService r121 = this.f434495a;
            MmRecordingUploadTask r122 = this.f434496b;
            if (Result.m9456isSuccessimpl(r120) == false) goto L63;
            Unit r123 = (Unit) r120;
            r121.f434487l.incrementAndGet();
            r121.f().e(r122, r121.l(null));
            r121.g(r122.f434501c, null);
        L63:
            MmRecordingUploadService r124 = this.f434495a;
            BuildersKt.launch$default(r124.f434484i, null, null, new MmRecordingUploadService$processTasks$1(r124, null), 3, null);
            return;
        L58:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L60
        L48:
            r116.f434689d.incrementAndGet();
            AtomicLong r126 = r116.f434691f;
            long r127 = ((long) r115.f434500b) * ((long) r115.f434503e);
            long r128 = r126.get();
        L50:
            if (r127 <= r128) goto L55;
            if (r126.compareAndSet(r128, r127) == true) goto L55;
            r128 = r126.get();
            goto L50
        L31:
            r111 = false;
        L34:
            r112 = false;
            goto L35
        L23:
            if (r109.isEmpty() == false) goto L25;
        L38:
            th = move-exception;
            throw th;
        L41:
            r102 = true;
            goto L42
        L13:
            r104 = false;
        L16:
            r105 = false;
            goto L17
        L5:
            if (r100.isEmpty() == false) goto L7;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void d() {
        if (Intrinsics.areEqual(this.f434476a.g(), com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.f434652c) == true) goto L5;
        return;
    L5:
        if (this.f434481f.isEmpty() == true) goto L7;
        return;
    L7:
        if (i() != 0) goto L18;
        lvb.a.e(this.f434478c, "postProcessing & taskQueue is empty, sync upload completed");
        String r100 = this.f434476a.f434119w.f526985d;
        if (r100.length() <= 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        g(r100, Float.valueOf(1.0f));
    L14:
        this.f434476a.i().J();
        return;
    L11:
        r101 = false;
        goto L12
    }

    public final n f() {
        return (n) this.f434486k.getValue();
    }

    public final b h() {
        int r100 = this.f434489n.get();
        int r101 = this.f434487l.get();
        int r102 = Math.max(this.f434490o.get(), r101 + r100);
        return new b(RangesKt.coerceAtMost(r100 + this.f434488m.get(), r102), r102);
    }

    public final int i() {
        Object r100 = this.f434482g;
        monitor-enter(r100);
        int r101 = this.f434483h.size();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void k() {
        boolean r100 = false;
        if (this.f434491p.compareAndSet(false, true) == true) goto L6;
        lvb.a.e(this.f434478c, "[trackUploadCompleted] skip duplicate");
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d r101 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434675c;
        String r102 = this.f434476a.e();
        Long r103 = (Long) this.f434476a.f434112p.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "recordingId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.b r104 = r101.f434685a.remove(r102);
        if (r104 != null) goto L9;
        lvb.a.h("MmRecordingUploadMetrics", "[trackUploadSuccess] missing upload context, recordingId=" + r102);
    L26:
        n r105 = f();
        o r106 = l(Float.valueOf(1.0f));
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "snapshot");
        r105.b("completed");
        r105.m("completed", r106, "", "");
        return;
    L9:
        int r107 = r104.f434689d.get();
        int r108 = r104.f434690e.get();
        if (r103 == null) goto L12;
        long r109 = r103.longValue();
    L13:
        long r110 = Math.max(r109, r104.f434691f.get());
        if (r108 >= r107) goto L16;
        r100 = true;
    L16:
        lvb.a.e("MmRecordingUploadMetrics", "[trackUploadSuccess] traceId=" + r104.f434686a.getRecordingTraceId() + ", recordingId=" + r104.f434687b + ",totalCount=" + r107 + ", successCount=" + r108 + ", durationMs=" + r110 + ", uploadType=" + r104.f434688c + ", isIncomplete=" + r100);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r111 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        MmRecordingSource r112 = r104.f434686a.getSource();
        if (r112 == null) goto L19;
        String r113 = r112.getValue();
    L20:
        if (r113 != null) goto L22;
        r113 = "";
    L22:
        r111.e("source", r113);
        r111.e("success", "1");
        r111.c("duration", r110);
        r111.b(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r107);
        r111.b("success_count", r108);
        if (r100 == false) goto L25;
        r111.b("error_code", -10002);
    L25:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("minutes_recording_upload_finished", r104.f434686a, r111.a());
        goto L26
    L19:
        r113 = null;
        goto L20
    L12:
        r109 = 0;
        goto L13
    }

    public final void c(MmRecordingUploadTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.f434479d.execute(new d(this, r100));
    }

    public final void e(String r100) {
        lvb.a.e(this.f434478c, "deleteSegment: " + r100);
        BuildersKt.launch$default(this.f434476a.f434117u, null, null, new MmRecordingUploadService$deleteSegment$1(r100, null), 3, null);
    }

    public final o l(Float r100) {
        b r101 = h();
        if (r100 == null) goto L5;
        float r102 = r100.floatValue();
    L13:
        return new o(r101.f434493b, r101.f434492a, this.f434481f.size(), i(), r102);
    L5:
        int r103 = r101.f434493b;
        if (r103 > 0) goto L8;
        r102 = 0.0f;
        goto L13
    L8:
        float r104 = r101.f434492a / r103;
        if (r104 < 1.0f) goto L11;
        r104 = 0.99f;
    L11:
        r102 = r104;
        goto L13
    }

    public MmRecordingUploadService(MmRecordingSession r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingSession");
        Intrinsics.checkNotNullParameter(r101, "userComponentContext");
        this.f434476a = r100;
        this.f434477b = r101;
        this.f434478c = "MmRecordingUploadService" + hashCode();
        this.f434479d = CoreThreadPool.getDefault().newSerialIODensityThreadPool("mm_recording_queue");
        ExecutorService r102 = CoreThreadPool.getDefault().newSerialIODensityThreadPool("mm_recording_upload");
        this.f434480e = r102;
        this.f434481f = new LinkedBlockingQueue(24);
        this.f434482g = new Object();
        this.f434483h = new LinkedHashSet();
        this.f434484i = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r102).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f434485j = LazyKt.lazy(new MmRecordingUploadService$retryPolicy$2(this));
        this.f434486k = LazyKt.lazy(new MmRecordingUploadService$uploadDiagnosisReporter$2(this));
        this.f434487l = new AtomicInteger(0);
        this.f434488m = new AtomicInteger(0);
        this.f434489n = new AtomicInteger(0);
        this.f434490o = new AtomicInteger(0);
        this.f434491p = new AtomicBoolean(false);
    }

    public final void g(String r100, Float r101) {
        b r102 = h();
        if (r101 == null) goto L5;
        float r103 = r101.floatValue();
    L12:
        boolean r104 = this.f434476a.v();
        String r105 = this.f434476a.f434119w.f526985d;
        Intrinsics.checkNotNullParameter(r100, "uploadIdentity");
        Intrinsics.checkNotNullParameter(r105, "objectToken");
        if (r104 == true) goto L16;
        r105 = r100;
    L16:
        lvb.a.e(this.f434478c, "[notifyUploadState] recordingId=" + this.f434476a.e() + ", uploadIdentity=" + r100 + ", progress=" + r103 + ", uploaded=" + r102.f434492a + ", total=" + r102.f434493b + ", currentUploaded=" + this.f434488m.get() + ", currentEnqueued=" + this.f434487l.get() + ", restoredUploaded=" + this.f434489n.get() + ", restoredTotal=" + this.f434490o.get() + ", override=" + r101);
        this.f434477b.A().D(this.f434476a.e(), r105, r103);
        return;
    L5:
        int r106 = r102.f434493b;
        if (r106 > 0) goto L8;
        r103 = 0.0f;
        goto L12
    L8:
        float r107 = r102.f434492a / r106;
        if (r107 < 1.0f) goto L11;
        r107 = 0.99f;
    L11:
        r103 = r107;
        goto L12
    }

    public final void m(MmRecordingUploadTask r110, MmRecordingUploadResponse r111) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d r100 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434675c;
        String r101 = this.f434476a.e();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "recordingId");
        Intrinsics.checkNotNullParameter(r110, "task");
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.b r102 = r100.f434685a.get(r101);
        if (r102 != null) goto L5;
        lvb.a.h("MmRecordingUploadMetrics", "[onUploadTaskSuccess] missing upload context, recordingId=" + r101 + ", segIndex=" + r110.f434500b);
    L6:
        e(r110.f434499a);
        Object r103 = this.f434482g;
        monitor-enter(r103);
        this.f434483h.remove(r110);     // Catch: Throwable -> L12
        monitor-exit(r103);
        this.f434488m.incrementAndGet();
        n r104 = f();
        o r105 = l(null);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        Intrinsics.checkNotNullParameter(r111, "response");
        Intrinsics.checkNotNullParameter(r105, "snapshot");
        n.h(r104, "success", r110, r104.a(r110), r105, r111, null, null, 96);
        g(r110.f434501c, null);
        BuildersKt.launch$default(this.f434484i, null, null, new MmRecordingUploadService$processTasks$1(this, null), 3, null);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r102.f434690e.incrementAndGet();
        goto L6
    }

    public static final Object a(MmRecordingUploadService r100, String r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof MmRecordingUploadService$cleanupLocalUploadArtifacts$1) == false) goto L7;
        MmRecordingUploadService$cleanupLocalUploadArtifacts$1 r102 = (MmRecordingUploadService$cleanupLocalUploadArtifacts$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = true;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L34:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L30:
        MmRecordingStatesSyncService r108 = r100.f434476a.i();
        r102.L$0 = null;
        r102.label = 3;
        if (r108.e(r107, r102) != r104) goto L34;
        return r104;
    L17:
        r101 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L21:
        String r112 = ((ovb.b) r111).f526982a;
        lvb.a.e(r100.f434478c, "cleanupLocalUploadArtifacts: " + r101 + ", meetingId: " + r112);
        if (r112.length() > 0) goto L25;
        r106 = false;
    L25:
        if (r106 == false) goto L34;
        MmRecordFileHelper r109 = MmRecordFileHelper.f434037a;
        String r113 = r100.f434477b.getCurrentUserId();
        r109.getClass();
        String r114 = MmRecordFileHelper.f(r113, r112).getAbsolutePath();
        Intrinsics.checkNotNull(r114);
        r102.L$0 = r112;
        r102.label = 2;
        if (MmRecordFileHelper.b(r114, r102) == r104) goto L36;
        r107 = r112;
        goto L30
    L36:
        return r104;
    L18:
        ResultKt.throwOnFailure(r111);
        MmRecordingSession r115 = r100.f434476a;
        r102.L$0 = r101;
        r102.label = 1;
        r111 = r115.r(r102);
        if (r111 != r104) goto L21;
        return r104;
    L7:
        r102 = new MmRecordingUploadService$cleanupLocalUploadArtifacts$1(r100, r110);
        goto L8
    }

    public static final void b(MmRecordingUploadService r100, MmRecordingUploadTask r110, MmRecordingUploadResponse r111) {
        lvb.a.e(r100.f434478c, "[handleResponse], response:" + r111);
        int[] r101 = c.f434494a;
        switch(r101[r111.ordinal()]) {
            case 1: goto L25;
            case 2: goto L25;
            case 3: goto L25;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            default: goto L48;
        };
    L5:
        r100.f().d(r110, r111, r100.l(null));
        r100.e(r110.f434499a);
        Object r112 = r100.f434482g;
        monitor-enter(r112);
        r100.f434483h.remove(r110);     // Catch: Throwable -> L10
        monitor-exit(r112);
        r100.g(r110.f434501c, null);
        BuildersKt.launch$default(r100.f434484i, null, null, new MmRecordingUploadService$processTasks$1(r100, null), 3, null);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        r100.j(r110, r111, TerminateReason.TENANT_KEY_DELETED);
        return;
    L14:
        n r102 = r100.f();
        TerminateReason r103 = TerminateReason.NON_RECORDING_TYPE;
        r102.g(r110, r111, r103, r100.l(null));
        r100.f434476a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r103));
        return;
    L15:
        r100.m(r110, r111);
        r100.f434476a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.INTERRUPT_RECORD));
        return;
    L16:
        r100.m(r110, r111);
        return;
    L17:
        int r104 = r101[r111.ordinal()];
        if (r104 != 4) goto L20;
        TerminateReason r105 = TerminateReason.NOT_LOGGED_IN;
    L24:
        r100.f().g(r110, r111, r105, r100.l(null));
        r100.f434476a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r105));
        return;
    L20:
        if (r104 == 5) goto L22;
        r105 = TerminateReason.OTHERS;
        goto L24
    L22:
        r105 = TerminateReason.UNAUTHORIZED;
        goto L24
    L25:
        int r106 = r101[r111.ordinal()];
        if (r106 != 1) goto L28;
        TerminateReason r107 = TerminateReason.REACH_MAX_DURATION;
    L35:
        r100.j(r110, r111, r107);
        if (r111 != MmRecordingUploadResponse.REACH_MAX_DURATION) goto L47;
        lvb.a.e(r100.f434478c, "reach_max_duration, sync status");
        return;
    L47:
        return;
    L28:
        if (r106 != 2) goto L30;
        r107 = TerminateReason.OBJECT_DELETED;
        goto L35
    L30:
        if (r106 == 3) goto L32;
        r107 = TerminateReason.OTHERS;
        goto L35
    L32:
        r107 = TerminateReason.UPLOAD_COMPLETED;
        goto L35
    }

    public final void j(MmRecordingUploadTask r100, MmRecordingUploadResponse r110, TerminateReason r111) {
        f().g(r100, r110, r111, l(null));
        BuildersKt.launch$default(this.f434476a.f434117u, null, null, new MmRecordingUploadService$terminateAndCleanupLocalUpload$1(this, r100, r111, null), 3, null);
    }
}
