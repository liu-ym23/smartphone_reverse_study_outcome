package com.larus.dora.impl.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.file.record.DoraFileRecorder;
import com.larus.dora.impl.file.upload.DoraFileUploaderImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraLogFileTransferCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraLogFileTransferCoordinator f335719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f335720b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f335721c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f335722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f335723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f335724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f335725g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DoraFileRemoteStreamer f335726h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j f335727i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DoraFileUploaderImpl f335728j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DoraFileFetchManager f335729k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Boolean f335730l;

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335731a = null;

        static {
            int[] r100 = new int[DoraFileType.values().length];
            r100[DoraFileType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DoraFileType.CRASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DoraFileType.PERFORMANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DoraFileType.LOG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f335731a = r100;
        }
    }

    public DoraLogFileTransferCoordinator() {
    }

    static {
        f335719a = new DoraLogFileTransferCoordinator();
        f335720b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f335721c = kotlinx.coroutines.sync.b.a();
        f335722d = true;
        f335723e = true;
        f335725g = LazyKt.lazy(new n());
        DoraFileRemoteStreamer r100 = new DoraFileRemoteStreamer();
        f335726h = r100;
        j r101 = new j();
        f335727i = r101;
        DoraFileUploaderImpl r102 = new DoraFileUploaderImpl(r101);
        f335728j = r102;
        f335729k = new DoraFileFetchManager(new j(), r102, r100, new u());
    }

    public static final void a() {
        Job r100 = f335724f;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        f335724f = null;
        DoraFileFetchManager r101 = f335729k;
        r101.getClass();
        g49.d.d("DoraFileFetchManager", "pauseQueueAndCurrentTask: enter");
        r101.f335693i.setValue(Boolean.TRUE);
        String r102 = r101.f335694j;
        if (r102 == null) goto L19;
        g49.d.d("DoraFileFetchManager", "pauseQueueAndCurrentTask: pausing current task id=".concat(r102));
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        r101.f(r102);     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        g49.d.c("DoraFileFetchManager", "pauseQueueAndCurrentTask: pause failed id=".concat(r102), r105);
    L15:
        Result.m9448boximpl(r104);
        return;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void c(String r100) {
        Job r101 = f335724f;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        f335724f = BuildersKt.launch$default(f335720b, null, null, new DoraLogFileTransferCoordinator$scheduleIdleResume$1(r100, null), 3, null);
    }

    public static PolarisFileWrapper f(DoraFileType r100) {
        File r101 = AppHost.f326268a.getApplication().getFilesDir();
        int r102 = a.f335731a[r100.ordinal()];
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L18;
        if (r102 != 4) goto L12;
        return new PolarisFileWrapper(r101, "DoraSDK/G/android/log");
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return new PolarisFileWrapper(r101, "DoraSDK/G/android/performance");
    L19:
        return new PolarisFileWrapper(r101, "DoraSDK/G/android/crash");
    L16:
        return new PolarisFileWrapper(r101, "DoraSDK/G/android/files");
    }

    public static void g(List r100) {
        Intrinsics.checkNotNullParameter(r100, "typeList");
        BuildersKt.launch$default(f335720b, null, null, new DoraLogFileTransferCoordinator$handleCloudSlardarCmd$1(r100, null), 3, null);
    }

    public static final Object b(DoraLogFileTransferCoordinator r110, String r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1) == false) goto L7;
        DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1 r100 = (DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        Iterator r116 = (Iterator) r100.L$2;
        r112 = (String) r100.L$1;
        String r103 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
        String r117 = r103;
    L50:
        if (r116.hasNext() == false) goto L55;
        Map.Entry r104 = (Map.Entry) r116.next();
        String r105 = (String) r104.getKey();
        int[] r106 = CollectionsKt.toIntArray((Set) r104.getValue());
        g49.d.d("DoraLogFileTransferCoordinator", "reconcilePendingTasksLocked: refresh file list before resume, sn=" + r117 + ", fetchFrom=" + r105 + ", types=" + Arrays.toString(r106));
        DoraLogFileTransferCoordinator r107 = f335719a;
        r100.L$0 = r117;
        r100.L$1 = r112;
        r100.L$2 = r116;
        r100.label = 1;
        if (r107.e(r105, r117, r112, r106, r100) != r115) goto L50;
        return r115;
    L55:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        LinkedHashMap r118 = new LinkedHashMap();
        Iterator<T> r108 = f335727i.c().iterator();
    L16:
        if (r108.hasNext() == false) goto L46;
        DoraFileFetchTask r109 = (DoraFileFetchTask) r108.next();
        if (Intrinsics.areEqual(r109.getSn(), r111) == false) goto L16;
        if (r109.getStatus() == DoraFileTaskStatus.PENDING) goto L30;
        if (r109.getStatus() == DoraFileTaskStatus.START) goto L30;
        if (r109.getStatus() == DoraFileTaskStatus.RUNNING) goto L30;
        if (r109.getStatus() == DoraFileTaskStatus.FAILED) goto L30;
        if (r109.getStatus() != DoraFileTaskStatus.PAUSED) goto L16;
    L30:
        DoraFileType r119 = r109.getFileType();
        if (r119 == null) goto L16;
        if (r119 == DoraFileType.UNKNOWN) goto L16;
        String r120 = r109.getFetchFrom();
        if (r120 != null) goto L39;
        r120 = "";
    L39:
        if (StringsKt.isBlank(r120) == false) goto L41;
        r120 = "ar1Notify";
    L41:
        Object r121 = r118.get(r120);
        if (r121 != null) goto L44;
        r121 = new LinkedHashSet();
        r118.put(r120, r121);
    L44:
        ((Set) r121).add(Boxing.boxInt(r119.getCode()));
        goto L16
    L46:
        if (r118.isEmpty() == false) goto L48;
        g49.d.d("DoraLogFileTransferCoordinator", "reconcilePendingTasksLocked: no pending tasks for sn=" + r111);
        return Unit.INSTANCE;
    L48:
        r116 = r118.entrySet().iterator();
        r117 = r111;
    L7:
        r100 = new DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1(r110, r113);
        goto L8
    }

    public static void d(String r110, String r111, int[] r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "sn");
        Intrinsics.checkNotNullParameter(r111, "firmwareVersion");
        Intrinsics.checkNotNullParameter(r112, "types");
        Intrinsics.checkNotNullParameter(r113, "fetchFrom");
        BuildersKt.launch$default(f335720b, null, null, new DoraLogFileTransferCoordinator$enqueueFileFetchTask$1(r113, r110, r111, r112, null), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c5 -> B:27:0x00cf). Please report as a decompilation issue!!! */
    public final Object e(String r510, String r511, String r512, int[] r513, Continuation<? super Unit> r514) {
        int[] r100 = r513;
        if ((r514 instanceof DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1) == false) goto L7;
        DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1 r101 = (DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1) r514;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 1;
        String r107 = "DoraLogFileTransferCoordinator";
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r108 = r101.I$1;
        int r109 = r101.I$0;
        Collection r110 = (Collection) r101.L$5;
        List r111 = (List) r101.L$4;
        int[] r112 = (int[]) r101.L$3;
        String r113 = (String) r101.L$2;
        String r114 = (String) r101.L$1;
        String r115 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r116 = r108;
        r100 = r112;
        List r117 = r111;
        String r118 = ", types=";
        Object r119 = r104;
        DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1 r120 = r101;
        String r121 = r113;
    L27:
        CollectionsKt.addAll(r110, (Iterable) r103);
        int r122 = r116;
        String r123 = r115;
        r106 = 1;
        String r124 = r107;
        int r125 = r109 + 1;
        String r126 = r114;
    L22:
        if (r125 >= r122) goto L29;
        int r127 = r100[r125];
        List r128 = r117;
        DoraFileRemoteStreamer r129 = f335726h;
        r120.L$0 = r123;
        r120.L$1 = r126;
        r120.L$2 = r121;
        r120.L$3 = r100;
        r120.L$4 = r117;
        r120.L$5 = r128;
        r120.I$0 = r125;
        r120.I$1 = r122;
        r120.label = r106;
        Object r130 = r129.d(r127, "bt", r123, r120);
        if (r130 != r119) goto L26;
        return r119;
    L26:
        String r515 = r124;
        r115 = r123;
        r103 = r130;
        r116 = r122;
        r110 = r128;
        r114 = r126;
        r109 = r125;
        r107 = r515;
        goto L27
    L29:
        if (r117.isEmpty() == false) goto L32;
        g49.d.e(r124, "enqueueFileFetchTaskLocked: no files returned for sn=" + r126 + r118 + Arrays.toString(r100));
        return Unit.INSTANCE;
    L32:
        ArrayList r131 = new ArrayList(r100.length);
        int r132 = r100.length;
        int r133 = 0;
    L33:
        if (r133 >= r132) goto L35;
        int r134 = r100[r133];
        DoraFileType.a r135 = DoraFileType.Companion;
        Integer r136 = Boxing.boxInt(r134);
        r135.getClass();
        r131.add(f(DoraFileType.a.a(r136)));
        r133 = r133 + 1;
        goto L33
    L35:
        final DoraFileFetchManager r137 = f335729k;
        r137.getClass();
        String r138 = "sn";
        Intrinsics.checkNotNullParameter(r126, "sn");
        Intrinsics.checkNotNullParameter(r117, "fileList");
        Intrinsics.checkNotNullParameter(r131, "dirList");
        Iterator<T> r139 = r137.f335685a.c().iterator();
    L36:
        String r140 = "DoraFileFetchManager";
        String r141 = "";
        if (r139.hasNext() == false) goto L76;
        DoraFileFetchTask r142 = (DoraFileFetchTask) r139.next();
        if (Intrinsics.areEqual(r142.getSn(), r126) == false) goto L36;
        List r143 = r117;
        if ((r143 instanceof Collection) == true) goto L43;
    L45:
        Iterator r144 = r143.iterator();
    L47:
        if (r144.hasNext() == false) goto L51;
        if (Intrinsics.areEqual(((l) r144.next()).c(), r142.getFileName()) == false) goto L47;
        boolean r145 = false;
    L52:
        if (r145 == false) goto L36;
        if (r142.getStatus() == DoraFileTaskStatus.UPLOADING) goto L36;
        final String r146 = r142.getFileName();     // Catch: Throwable -> L74
        File r147 = null;
        if (r146 != null) goto L58;
    L64:
        if (r147 != null) goto L66;
    L68:
        i r148 = r137.f335685a;     // Catch: Throwable -> L74
        String r149 = r142.getId();     // Catch: Throwable -> L74
        if (r149 == null) goto L72;
        r141 = r149;
    L72:
        r148.delete(r141);     // Catch: Throwable -> L74
        DoraFileRecorder.b(r142);     // Catch: Throwable -> L74
        g49.d.d("DoraFileFetchManager", "cleanupTaskAndFile: sn=" + r126 + ", path=" + r142.getFileName());     // Catch: Throwable -> L74
        goto L36
    L66:
        if (r147.exists() == false) goto L68;
        r147.delete();     // Catch: Throwable -> L74
        goto L68
    L58:
        if ((!StringsKt.isBlank(r146)) == true) goto L61;
        r146 = null;
    L61:
        if (r146 == null) goto L64;
        r147 = (File) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r131), new d(r137, r146)));     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        g49.d.c("DoraFileFetchManager", "cleanupTaskAndFile: ERROR 1", th);
    L51:
        r145 = true;
        goto L52
    L43:
        if (r143.isEmpty() == false) goto L45;
    L76:
        Iterator r150 = r131.iterator();
    L77:
        long r310 = 0;
        if (r150.hasNext() == false) goto L114;
        File r151 = (File) r150.next();
        if (r151.exists() == false) goto L77;
        if (r151.isDirectory() == false) goto L77;
        File[] r152 = r151.listFiles();     // Catch: Throwable -> L112
        if (r152 == null) goto L77;
        ArrayList r153 = new ArrayList();     // Catch: Throwable -> L112
        int r154 = r152.length;     // Catch: Throwable -> L112
        int r155 = 0;
    L88:
        if (r155 >= r154) goto L93;
        File r156 = r152[r155];     // Catch: Throwable -> L112
        if (r156.isFile() == false) goto L92;
        r153.add(r156);     // Catch: Throwable -> L112
    L92:
        r155 = r155 + 1;     // Catch: Throwable -> L112
        goto L88
    L93:
        List r157 = CollectionsKt.sortedWith(r153, new e());     // Catch: Throwable -> L112
        if (r157 == null) goto L77;
        Iterator r158 = r157.iterator();     // Catch: Throwable -> L112
    L97:
        if (r158.hasNext() == false) goto L99;
        r310 = r310 + ((File) r158.next()).length();     // Catch: Throwable -> L112
        goto L97
    L99:
        Iterator r159 = r157.iterator();     // Catch: Throwable -> L112
    L101:
        if (r159.hasNext() == false) goto L77;
        File r160 = (File) r159.next();     // Catch: Throwable -> L112
        if (r310 <= 314572800) goto L77;
        long r161 = r160.length();     // Catch: Throwable -> L112
        if (r160.delete() == false) goto L107;
        r310 = r310 - r161;     // Catch: Throwable -> L112
    L107:
        DoraFileFetchTask r162 = r137.f335685a.b(r160.getName());     // Catch: Throwable -> L112
        if (r162 == null) goto L110;
        DoraFileRecorder.b(r162);     // Catch: Throwable -> L112
    L110:
        r137.f335685a.delete(r160.getName());     // Catch: Throwable -> L112
        g49.d.d("DoraFileFetchManager", "cleanupTaskAndFile: fileName=" + r160.getName());     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        g49.d.c("DoraFileFetchManager", "cleanupTaskAndFile: ERROR 2", th);
        goto L77
    L114:
        Iterator r163 = r117.iterator();
    L116:
        if (r163.hasNext() == false) goto L182;
        l r164 = (l) r163.next();
        DoraFileType.a r165 = DoraFileType.Companion;
        Integer r166 = r164.getType();
        r165.getClass();
        DoraFileType r167 = DoraFileType.a.a(r166);
        String r168 = r164.c();
        if (r168 != null) goto L120;
        String r169 = r141;
    L121:
        String r170 = r164.b();
        if (r170 != null) goto L124;
        r170 = r141;
    L124:
        Long r171 = r164.a();
        if (r171 == null) goto L127;
        long r172 = r171.longValue();
    L128:
        long r173 = System.currentTimeMillis();
        if (r172 <= (r173 - 31536000000L)) goto L132;
        r173 = r172;
    L132:
        Long r174 = r164.d();
        if (r174 == null) goto L135;
        long r175 = r174.longValue();
    L136:
        String r176 = r124;
        b r177 = new b(r123, r167, r169, r170, r173, r175);
        DoraFileFetchManager r178 = f335729k;
        String r179 = r164.c();
        if (r179 != null) goto L139;
        String r180 = r141;
    L140:
        PolarisFileWrapper r181 = f(DoraFileType.a.a(r164.getType()));
        DoraTaskTrigger r182 = DoraTaskTrigger.COMMAND_ARRIVED;
        r178.getClass();
        Intrinsics.checkNotNullParameter(r180, "remotePath");
        Intrinsics.checkNotNullParameter(r181, "localFileDir");
        Intrinsics.checkNotNullParameter(r126, r138);
        Intrinsics.checkNotNullParameter(r121, "firmwareVersion");
        Intrinsics.checkNotNullParameter(r182, "trigger");
        Intrinsics.checkNotNullParameter(r177, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r123, "fetchFrom");
        Intrinsics.checkNotNullParameter("bt", "transportType");
        Iterator r516 = r163;
        StringBuilder r183 = new StringBuilder("enqueue: remotePath=");
        r183.append(r180);
        r183.append(", sn=");
        r183.append(r126);
        String r517 = r138;
        r183.append(", trigger=");
        r183.append(r182);
        g49.d.d(r140, r183.toString());
        String r518 = r141;
        DoraFileFetchTask r184 = r178.f335685a.e(r177.f335736d);
        if (r184 == null) goto L145;
        g49.d.d(r140, "enqueue: task with same fileName=" + r177.f335736d + " already pending, reuse taskId=" + r184.getId());
        String r185 = r184.getId();
        if (r185 == null) goto L169;
    L170:
        String r186 = r185;
        String r187 = r140;
    L180:
        g49.d.d(r176, "enqueueFileFetchTaskLocked: enqueued taskId=" + r186 + ", sn=" + r126 + ", file=" + r164);
        r163 = r516;
        r138 = r517;
        r141 = r518;
        r124 = r176;
        r140 = r187;
    L169:
        r185 = r518;
        goto L170
    L145:
        DoraFileFetchTask r311 = r178.f335685a.a(r126, r180);
        if (r311 == null) goto L171;
        String r188 = r180;
        String r519 = "bt";
        if (r311.getStatus() == DoraFileTaskStatus.DONE) goto L173;
        if (r311.getStatus() == DoraFileTaskStatus.CANCELED) goto L173;
        g49.d.d(r140, "enqueue: reuse existing taskId=" + r311.getId() + ", sn=" + r311.getSn() + ", remotePath=" + r311.getRemotePath() + ", status=" + r311.getStatus());
        DoraFileTaskStatus r189 = r311.getStatus();
        if (r189 != null) goto L154;
        int r190 = -1;
    L156:
        if (r190 != 1) goto L158;
        DoraFileFetchTask r191 = r311;
    L159:
        DoraFileFetchTask r192 = DoraFileFetchTask.appendTrigger$default(r191, r182, 0, 2, null);
        r178.f335685a.d(r192);
        DoraFileRecorder.a(r192);
        g49.d.d(r140, "enqueue: reused taskId=" + r192.getId() + ", sn=" + r192.getSn() + ", remotePath=" + r192.getRemotePath() + ", status=" + r192.getStatus() + ", trigger=" + r182);
        r185 = r192.getId();
        if (r185 != null) goto L162;
    L165:
        boolean r193 = true;
    L166:
        if (r193 == true) goto L168;
        r178.g(r185);
    L168:
        if (r185 != null) goto L170;
    L162:
        if (r185.length() == 0) goto L165;
        r193 = false;
        goto L166
    L158:
        r191 = DoraFileFetchTask.copy$default(r311, null, null, null, null, null, DoraFileTaskStatus.PENDING, null, null, null, null, null, null, null, null, null, null, null, 131039, null);
        goto L159
    L154:
        r190 = DoraFileFetchManager.b.f335698a[r189.ordinal()];
    L173:
        if (r181.exists() == true) goto L175;
        r181.mkdirs();
    L175:
        PolarisFileWrapper r194 = new PolarisFileWrapper(r181, r177.f335736d);
        if (r194.exists() == false) goto L178;
        long r312 = r194.length();
    L179:
        String r195 = r177.f335736d;
        String r210 = "ts=" + System.currentTimeMillis() + ':' + r182.name();
        DoraFileTaskStatus r196 = DoraFileTaskStatus.PENDING;
        DoraFileType r197 = r177.f335735c;
        String r198 = r177.f335736d;
        String r199 = r177.f335737e;
        long r1100 = r177.f335738f;
        long r200 = r177.f335739g;
        String r1101 = r126;
        String r201 = r188;
        r186 = r195;
        DoraFileFetchTask r1102 = new DoraFileFetchTask(r195, r1101, r201, r194.getAbsolutePath(), Long.valueOf(r312), r196, r182, r182, r210, r197, r198, r199, Long.valueOf(r1100), Long.valueOf(r200), r121, r519, r123);
        r178.f335685a.d(r1102);
        DoraFileRecorder.a(r1102);
        r187 = r140;
        g49.d.d(r187, "enqueue: new taskId=" + r186 + ", sn=" + r126 + ", remotePath=" + r201 + ", localPath=" + r194.getAbsolutePath() + ", offset=" + r312 + ", status=" + r1102.getStatus() + ", trigger=" + r182);
        r178.g(r186);
        goto L180
    L178:
        r312 = 0;
        goto L179
    L171:
        r188 = r180;
        r519 = "bt";
        goto L173
    L139:
        r180 = r179;
        goto L140
    L135:
        r175 = 0;
        goto L136
    L127:
        r172 = 0;
        goto L128
    L120:
        r169 = r168;
        goto L121
    L182:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r100.length != 0) goto L17;
        boolean r202 = true;
    L18:
        if (r202 == false) goto L21;
        g49.d.e("DoraLogFileTransferCoordinator", "enqueueFileFetchTaskLocked: types is empty, ignore");
        return Unit.INSTANCE;
    L21:
        StringBuilder r203 = new StringBuilder("enqueueFileFetchTaskLocked: getFileList, sn=");
        r126 = r511;
        r203.append(r126);
        r203.append(", types=");
        r203.append(Arrays.toString(r513));
        g49.d.d("DoraLogFileTransferCoordinator", r203.toString());
        ArrayList r204 = new ArrayList();
        r122 = r100.length;
        r117 = r204;
        r118 = ", types=";
        r124 = "DoraLogFileTransferCoordinator";
        r125 = 0;
        r123 = r510;
        r119 = r104;
        r120 = r101;
        r121 = r512;
        goto L22
    L17:
        r202 = false;
    L7:
        r101 = new DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1(this, r514);
        goto L8
    }
}
