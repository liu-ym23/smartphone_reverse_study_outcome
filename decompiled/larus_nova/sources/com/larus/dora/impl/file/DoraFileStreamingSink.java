package com.larus.dora.impl.file;

import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.file.record.DoraFileRecorder;
import com.larus.dora.impl.frameassembler.DoraIncompleteReason;
import com.larus.dora.impl.util.b0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraFileStreamingSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraFileStreamingSink f335702a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f335703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f335704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OutputStream f335705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f335706d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f335703a, r101.f335703a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f335704b, r101.f335704b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f335705c, r101.f335705c) == true) goto L18;
            return false;
        L18:
            if (this.f335706d == r101.f335706d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f335703a.hashCode() * 31) + this.f335704b.hashCode()) * 31) + this.f335705c.hashCode()) * 31;
            long r101 = this.f335706d;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "StreamState(taskId=" + this.f335703a + ", file=" + this.f335704b + ", stream=" + this.f335705c + ", startTimeMs=" + this.f335706d + ')';
        }

        public a(String r100, PolarisFileWrapper r101, PolarisFileOutputStreamWrapper r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "file");
            Intrinsics.checkNotNullParameter(r102, "stream");
            this.f335703a = r100;
            this.f335704b = r101;
            this.f335705c = r102;
            this.f335706d = r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335707a = null;

        static {
            int[] r100 = new int[DoraFileTaskStatus.values().length];
            r100[DoraFileTaskStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DoraFileTaskStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DoraFileTaskStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DoraFileTaskStatus.CANCELED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DoraFileTaskStatus.DONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f335707a = r100;
        }
    }

    public static final class c implements com.larus.dora.impl.frameassembler.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Job f335708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraFileFetchTask f335709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f335710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<Long, a> f335711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ u f335712e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<h> f335713f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v f335714g;

        @Override // com.larus.dora.impl.frameassembler.j
        public final PolarisFileOutputStreamWrapper a(com.larus.dora.impl.frameassembler.h r310) throws IOException {
            Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
            Job.DefaultImpls.cancel$default(this.f335708a, null, 1, null);
            long r100 = r310.f335840a.f335846a;
            String r101 = this.f335709b.getLocalPath();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
            File r103 = r102.getParentFile();
            if (r103 != null) goto L8;
        L10:
            long r104 = 0;
            if (r102.exists() == false) goto L13;
            long r110 = r102.length();
        L14:
            Long r105 = this.f335709b.getDownloadedBytes();
            if (r105 == null) goto L17;
            r104 = r105.longValue();
        L17:
            long r106 = Math.max(r110, r104);
            PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r102, true);
            long r111 = System.currentTimeMillis();
            DoraFileFetchTask r108 = DoraFileFetchTask.copy$default(this.f335709b, null, null, null, null, Long.valueOf(r106), DoraFileTaskStatus.RUNNING, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.f335710c.d(r108);
            DoraFileRecorder.a(r108);
            g49.d.d("DoraFileStreamingSink", "openStream: dataId=" + r100 + ", taskId=" + r108.getId() + ", sn=" + r108.getSn() + ", remotePath=" + r108.getRemotePath() + ", localPath=" + r108.getLocalPath() + ", startOffset=" + r106);
            Long r109 = Long.valueOf(r100);
            ConcurrentHashMap<Long, a> r112 = this.f335711d;
            String r113 = r108.getId();
            if (r113 != null) goto L20;
            String r114 = "";
        L21:
            r112.put(r109, new a(r114, r102, r107, r111));
            return r107;
        L20:
            r114 = r113;
            goto L21
        L13:
            r110 = 0;
            goto L14
        L8:
            if (r103.exists() == true) goto L10;
            r103.mkdirs();
            goto L10
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void b(com.larus.dora.impl.frameassembler.h r210, OutputStream r211) throws IOException {
            Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r211, "stream");
            long r100 = r210.f335840a.f335846a;
            a r101 = this.f335711d.remove(Long.valueOf(r100));
            r211.close();     // Catch: IOException -> L5
        L6:
            if (r101 != null) goto L8;
            return;
        L8:
            long r102 = r101.f335704b.length();
            DoraFileFetchTask r103 = DoraFileFetchTask.copy$default(this.f335709b, null, null, null, null, Long.valueOf(r102), DoraFileTaskStatus.UPLOADING, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.f335710c.d(r103);
            DoraFileRecorder.a(r103);
            g49.d.d("DoraFileStreamingSink", "onCompleted: switch to UPLOADING, taskId=" + r103.getId() + ", dataId=" + r100 + ", finalLen=" + r102);
            this.f335713f.complete(new h(r103, DoraFileStreamingSinkReason.DONE));
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void c(com.larus.dora.impl.frameassembler.h r210, OutputStream r211, Throwable r310) throws IOException {
            Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r211, "stream");
            Intrinsics.checkNotNullParameter(r310, "error");
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFileStreamingSink$sink$consumer$1$onError$1(this.f335714g, this.f335709b, null), 3, null);
            long r100 = r210.f335840a.f335846a;
            a r101 = this.f335711d.remove(Long.valueOf(r100));
            r211.close();     // Catch: IOException -> L5
        L6:
            if (r101 != null) goto L8;
            return;
        L8:
            long r102 = r101.f335704b.length();
            DoraFileFetchTask r103 = DoraFileFetchTask.copy$default(this.f335709b, null, null, null, null, Long.valueOf(r102), DoraFileTaskStatus.FAILED, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.f335710c.d(r103);
            DoraFileRecorder.a(r103);
            g49.d.c("DoraFileStreamingSink", "onError: mark FAILED, taskId=" + r103.getId() + ", dataId=" + r100 + ", len=" + r102, r310);
            this.f335713f.complete(new h(r103, DoraFileStreamingSinkReason.ERROR));
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void e(com.larus.dora.impl.frameassembler.h r410, OutputStream r411, DoraIncompleteReason r510) throws IOException {
            Intrinsics.checkNotNullParameter(r410, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r411, "stream");
            Intrinsics.checkNotNullParameter(r510, "reason");
            if (r510 != DoraIncompleteReason.SEQ_MISMATCH) goto L5;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFileStreamingSink$sink$consumer$1$onIncomplete$1(this.f335714g, this.f335709b, null), 3, null);
        L5:
            long r100 = r410.f335840a.f335846a;
            a r101 = this.f335711d.remove(Long.valueOf(r100));
            r411.close();     // Catch: IOException -> L8
        L9:
            if (r101 != null) goto L11;
            return;
        L11:
            long r102 = r101.f335704b.length();
            DoraFileFetchTask r210 = DoraFileFetchTask.copy$default(this.f335709b, null, null, null, null, Long.valueOf(r102), null, null, null, null, null, null, null, null, null, null, null, null, 131055, null);
            if (r510 != DoraIncompleteReason.TIMEOUT) goto L19;
            u r103 = this.f335712e;
            String r104 = this.f335709b.getId();
            if (r104 != null) goto L16;
            r104 = "";
        L16:
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, DBDefinition.TASK_ID);
            if (Intrinsics.areEqual(r103.f335756a.get(r104), Boolean.TRUE) == false) goto L19;
            DoraFileTaskStatus r105 = DoraFileTaskStatus.PAUSED;
        L20:
            DoraFileFetchTask r106 = DoraFileFetchTask.copy$default(r210, null, null, null, null, null, r105, null, null, null, null, null, null, null, null, null, null, null, 131039, null);
            this.f335710c.d(r106);
            DoraFileRecorder.a(r106);
            g49.d.d("DoraFileStreamingSink", "onIncomplete: finalStatus=" + r105 + ", taskId=" + r106.getId() + ", dataId=" + r100 + ", len=" + r102 + ", reason=" + r510);
            CompletableDeferred<h> r107 = this.f335713f;
            if (r106.getStatus() != DoraFileTaskStatus.PAUSED) goto L23;
            DoraFileStreamingSinkReason r108 = DoraFileStreamingSinkReason.PAUSED;
        L24:
            r107.complete(new h(r106, r108));
            return;
        L23:
            r108 = DoraFileStreamingSinkReason.INCOMPLETED;
        L19:
            r105 = DoraFileTaskStatus.FAILED;
            goto L20
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void d(com.larus.dora.impl.frameassembler.h r310, OutputStream r311, byte[] r312, int r313) throws IOException {
            Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r311, "stream");
            Intrinsics.checkNotNullParameter(r312, MonitorConstants.CHUNK);
            long r100 = r310.f335840a.f335846a;
            a r101 = this.f335711d.get(Long.valueOf(r100));
            if (r101 != null) goto L5;
            return;
        L5:
            u r102 = this.f335712e;
            String r103 = r101.f335703a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, DBDefinition.TASK_ID);
            if (Intrinsics.areEqual(r102.f335756a.get(r103), Boolean.TRUE) == false) goto L15;
            g49.d.a("DoraFileStreamingSink", "onChunk: taskId=" + r101.f335703a + ", dataId=" + r100 + " is PAUSED, drop chunk seq=" + r313 + ", len=" + r312.length);
            CompletableDeferred<h> r104 = this.f335713f;
            i r105 = this.f335710c;
            String r106 = this.f335709b.getId();
            if (r106 != null) goto L10;
            r106 = "";
        L10:
            DoraFileFetchTask r107 = r105.b(r106);
            if (r107 != null) goto L13;
            r107 = this.f335709b;
        L13:
            r104.complete(new h(r107, DoraFileStreamingSinkReason.PAUSED));
            return;
        L15:
            r311.write(r312);
            r311.flush();
            DoraFileFetchTask r108 = DoraFileFetchTask.copy$default(this.f335709b, null, null, null, null, Long.valueOf(r101.f335704b.length()), DoraFileTaskStatus.RUNNING, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.f335710c.d(r108);
            DoraFileRecorder.a(r108);
            g49.d.a("DoraFileStreamingSink", "onChunk: wrote len=" + r312.length + ", seq=" + r313 + ", taskId=" + r108.getId() + ", dataId=" + r100 + ", downloadedBytes=" + r108.getDownloadedBytes());
        }

        public c(Job r100, DoraFileFetchTask r101, i r102, ConcurrentHashMap<Long, a> r103, u r104, CompletableDeferred<h> r105, v r106) {
            this.f335708a = r100;
            this.f335709b = r101;
            this.f335710c = r102;
            this.f335711d = r103;
            this.f335712e = r104;
            this.f335713f = r105;
            this.f335714g = r106;
        }
    }

    static {
        f335702a = new DoraFileStreamingSink();
    }

    public DoraFileStreamingSink() {
    }

    public static void b(int r100, long r101, String r102) {
        g49.d.d("DoraFileStreamingSink", "id: " + r100 + ", " + r102 + ", cost: " + (SystemClock.elapsedRealtime() - r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [vj4.b] */
    /* JADX WARN: Type inference failed for: r1v2, types: [vj4.b] */
    /* JADX WARN: Type inference failed for: r4v10, types: [vj4.d] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [vj4.d] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.dora.impl.frameassembler.d] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.larus.dora.impl.frameassembler.d] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object a(DoraFileFetchTask r210, i r211, v r212, u r213, Continuation<? super h> r310) {
        if ((r310 instanceof DoraFileStreamingSink$sink$1) == false) goto L7;
        DoraFileStreamingSink$sink$1 r100 = (DoraFileStreamingSink$sink$1) r310;
        int r101 = r100.label;
        ?? r102 = -2147483648(0xffffffff80000000, float:-0.0);
        ?? r103 = r101 & Integer.MIN_VALUE;
        if (r103 == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraFileStreamingSink$sink$1 r110 = r100;
        Object r104 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        long r106 = r110.J$0;
        int r107 = r110.I$0;
        vj4.d r108 = (vj4.d) r110.L$1;
        com.larus.dora.impl.frameassembler.d r109 = (com.larus.dora.impl.frameassembler.d) r110.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        r102 = r108;
        r103 = r109;
    L55:
        h r112 = (h) r104;     // Catch: Throwable -> L15
        b(r107, r106, "result=" + r112);     // Catch: Throwable -> L15
        vj4.b.a.f555417a.c(r102);
        r103.shutdown();
        return r112;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r106 = r110.J$0;
        r107 = r110.I$0;
        vj4.d r113 = (vj4.d) r110.L$2;
        com.larus.dora.impl.frameassembler.d r114 = (com.larus.dora.impl.frameassembler.d) r110.L$1;
        CompletableDeferred r115 = (CompletableDeferred) r110.L$0;
        ResultKt.throwOnFailure(r104);
        vj4.d r116 = r113;
        com.larus.dora.impl.frameassembler.d r117 = r114;
    L51:
        b(r107, r106, "start remote streaming, ret=" + ((Number) r104).intValue());
        r110.L$0 = r117;     // Catch: Throwable -> L15
        r110.L$1 = r116;     // Catch: Throwable -> L15
        r110.L$2 = null;     // Catch: Throwable -> L15
        r110.I$0 = r107;     // Catch: Throwable -> L15
        r110.J$0 = r106;     // Catch: Throwable -> L15
        r110.label = 2;     // Catch: Throwable -> L15
        r104 = r115.await(r110);     // Catch: Throwable -> L15
        r102 = r116;
        r103 = r117;
        if (r104 != r111) goto L55;
        return r111;
    L20:
        ResultKt.throwOnFailure(r104);
        g49.d.d("DoraFileStreamingSink", "sink start, task=" + r210);
        DoraFileTaskStatus r118 = r210.getStatus();
        if (r118 != null) goto L23;
        int r119 = -1;
    L24:
        if (r119 == 1) goto L64;
        if (r119 == 2) goto L64;
        if (r119 == 3) goto L64;
        if (r119 == 4) goto L64;
        if (r119 == 5) goto L64;
        ConcurrentHashMap r120 = new ConcurrentHashMap();
        k49.a r121 = k49.a.f501767a;
        monitor-enter(r121);
        b0.f338123a.getClass();     // Catch: Throwable -> L60
        int r122 = b0.j().getInt("key_data_id", 0);     // Catch: Throwable -> L60
        if (r122 != Integer.MAX_VALUE) goto L37;
        int r123 = 0;
    L38:
        b0.j().storeInt("key_data_id", r123);     // Catch: Throwable -> L60
        monitor-exit(r121);
        long r124 = SystemClock.elapsedRealtime();
        CompletableDeferred r125 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        final int r214 = r123;
        c r126 = new c(BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new DoraFileStreamingSink$sink$firstFrameTimeoutJob$1(r210, r211, r125, null), 3, null), r210, r211, r120, r213, r125, r212);
        int r127 = com.larus.dora.impl.frameassembler.e.f335807m;
        com.larus.dora.impl.frameassembler.e.a r128 = new com.larus.dora.impl.frameassembler.e.a();
        r128.f335820a = 10000;
        r128.f335831l = true;
        final com.larus.dora.impl.frameassembler.k r129 = new com.larus.dora.impl.frameassembler.k(new com.larus.dora.impl.frameassembler.e(r128), r126);
        vj4.d r130 = new g(r214, r129);
        ((CopyOnWriteArraySet) vj4.b.a.f555417a.f555414a).add(r130);
        b(r214, r124, "start remote streaming");
        long r131 = r214;
        String r132 = r210.getFileName();
        if (r132 != null) goto L43;
        r132 = "";
    L43:
        String r215 = r132;
        Long r133 = r210.getDownloadedBytes();
        if (r133 == null) goto L46;
        long r134 = r133.longValue();
    L47:
        r110.L$0 = r125;
        r110.L$1 = r129;
        r110.L$2 = r130;
        r110.I$0 = r214;
        r110.J$0 = r124;
        r110.label = 1;
        Object r135 = r212.c(r131, r215, r134);
        if (r135 != r111) goto L50;
        return r111;
    L50:
        r115 = r125;
        r117 = r129;
        r104 = r135;
        r107 = r214;
        r116 = r130;
        r106 = r124;
        goto L51
    L46:
        r134 = 0;
        goto L47
    L37:
        r123 = r122 + 1;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    L64:
        return new h(r210, DoraFileStreamingSinkReason.DONE);
    L23:
        r119 = b.f335707a[r118.ordinal()];
    L15:
        th = move-exception;
        vj4.b.a.f555417a.c(r102);
        r103.shutdown();
        throw th;
    L7:
        r100 = new DoraFileStreamingSink$sink$1(this, r310);
        goto L8
    }
}
