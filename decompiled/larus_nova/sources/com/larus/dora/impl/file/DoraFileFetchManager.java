package com.larus.dora.impl.file;

import android.os.StatFs;
import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.file.record.DoraFileRecorder;
import com.larus.dora.impl.file.upload.DoraFileUploaderImpl;
import com.larus.dora.impl.file.upload.DoraFileUploaderTrigger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraFileFetchManager {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f335684n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f335685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.dora.impl.file.upload.a f335686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f335687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f335688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f335689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Channel<String> f335690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f335691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f335692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StateFlowImpl f335693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile String f335694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f335695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f335696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Set<String>> f335697m;

    /* JADX INFO: renamed from: com.larus.dora.impl.file.DoraFileFetchManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager$1", f = "DoraFileFetchManager.kt", i = {0, 1, 2, 3, 3, 4, 4, 5}, l = {68, 71, 73, 78, 83, 93}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch", DBDefinition.TASK_ID, "$this$launch", DBDefinition.TASK_ID, "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DoraFileFetchManager this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.file.DoraFileFetchManager$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager$1$1", f = "DoraFileFetchManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C42641 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            public C42641(Continuation<? super C42641> r100) {
                super(2, r100);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                C42641 r102 = new C42641(r101);
                r102.Z$0 = ((Boolean) r100).booleanValue();
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Boolean> r101) {
                return invoke(r100.booleanValue(), r101);
            }

            public final Object invoke(boolean r100, Continuation<? super Boolean> r101) {
                return ((C42641) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                return Boxing.boxBoolean(!this.Z$0);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.file.DoraFileFetchManager$1$2, reason: invalid class name */
        /* JADX INFO: loaded from: classes27.dex */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager$1$2", f = "DoraFileFetchManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
                super(2, r100);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                AnonymousClass2 r102 = new AnonymousClass2(r101);
                r102.Z$0 = ((Boolean) r100).booleanValue();
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Boolean> r101) {
                return invoke(r100.booleanValue(), r101);
            }

            public final Object invoke(boolean r100, Continuation<? super Boolean> r101) {
                return ((AnonymousClass2) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                return Boxing.boxBoolean(!this.Z$0);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(DoraFileFetchManager r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0287 -> B:35:0x0177). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r310) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L16;
                case 1: goto L6;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r310);
        L7:
            AnonymousClass1 r102 = this;
        L36:
            if (CoroutineScopeKt.isActive(r101) == false) goto L70;
            StateFlowImpl r103 = r102.this$0.f335693i;
            C42641 r104 = new C42641(null);
            r102.L$0 = r101;
            r102.label = 2;
            if (kotlinx.coroutines.flow.e.t(r103, r104, r102) != r100) goto L40;
            return r100;
        L40:
            Channel<String> r105 = r102.this$0.f335690f;
            r102.L$0 = r101;
            r102.label = 3;
            Object r106 = r105.receive(r102);
            if (r106 != r100) goto L43;
            return r100;
        L43:
            String r107 = (String) r106;
            if (((Boolean) r102.this$0.f335693i.getValue()).booleanValue() == false) goto L50;
            g49.d.d("DoraFileFetchManager", "worker: paused after receive, waiting to process taskId=" + r107);
            StateFlowImpl r108 = r102.this$0.f335693i;
            AnonymousClass2 r109 = new AnonymousClass2(null);
            r102.L$0 = r101;
            r102.L$1 = r107;
            r102.label = 4;
            if (kotlinx.coroutines.flow.e.t(r108, r109, r102) != r100) goto L48;
            return r100;
        L48:
            CoroutineScope r110 = r101;
            String r111 = r107;
        L49:
            CoroutineScope r112 = r110;
            r107 = r111;
        L51:
            g49.d.d("DoraFileFetchManager", "worker: dequeued taskId=" + r107);
            DoraFileFetchManager r113 = r102.this$0;
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L57
            r102.L$0 = r112;     // Catch: Throwable -> L57
            r102.L$1 = r107;     // Catch: Throwable -> L57
            r102.label = 5;     // Catch: Throwable -> L57
            if (DoraFileFetchManager.a(r113, r107, r102) != r100) goto L55;
            return r100;
        L55:
            Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
        L59:
            DoraFileFetchManager r116 = r102.this$0;
            Throwable r117 = Result.m9452exceptionOrNullimpl(r115);
            if (r117 == null) goto L65;
            g49.d.c("DoraFileFetchManager", "worker: processTask failed for taskId=" + r107, r117);
            int r118 = DoraFileFetchManager.f335684n;
            DoraFileFetchTask r119 = r116.f335685a.b(r107);
            if (r119 == null) goto L65;
            DoraFileFetchTask r120 = DoraFileFetchTask.copy$default(r119, null, null, null, null, null, DoraFileTaskStatus.FAILED, null, null, null, null, null, null, null, null, null, null, null, 131039, null);
            r116.f335685a.d(r120);
            DoraFileRecorder.a(r120);
        L65:
            r102.L$0 = r112;
            r102.L$1 = null;
            r102.label = 6;
            if (DelayKt.delay(1000, r102) != r100) goto L68;
            return r100;
        L68:
            r101 = r112;
        L57:
            th = th;
        L58:
            Result.Companion r121 = Result.Companion;
            r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L59
        L50:
            r112 = r101;
            goto L51
        L70:
            return Unit.INSTANCE;
        L8:
            r107 = (String) this.L$1;
            r112 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r310);     // Catch: Throwable -> L11
            r102 = this;
        L11:
            th = th;
            r102 = this;
            goto L58
        L13:
            r111 = (String) this.L$1;
            r110 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r310);
            r102 = this;
            goto L49
        L14:
            r101 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r310);
            r106 = r310;
            r102 = this;
            goto L43
        L15:
            r101 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r310);
            r102 = this;
            goto L40
        L16:
            ResultKt.throwOnFailure(r310);
            r101 = (CoroutineScope) this.L$0;
            g49.d.d("DoraFileFetchManager", "worker: start restorePendingTasks and task loop");
            DoraFileFetchManager r122 = this.this$0;
            this.L$0 = r101;
            this.label = 1;
            List<DoraFileFetchTask> r123 = r122.f335685a.c();
            g49.d.d("DoraFileFetchManager", "restorePendingTasks: loaded " + r123.size() + " tasks from store");
            Iterator<DoraFileFetchTask> r124 = r123.iterator();
        L18:
            if (r124.hasNext() == false) goto L33;
            DoraFileFetchTask r125 = r124.next();
            DoraFileTaskStatus r126 = r125.getStatus();
            if (r126 != null) goto L22;
            int r127 = -1;
        L24:
            switch(r127) {
                case 1: goto L28;
                case 2: goto L28;
                case 3: goto L28;
                case 4: goto L28;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L26;
                case 8: goto L26;
                default: goto L18;
            };
        L26:
            g49.d.a("DoraFileFetchManager", "restorePendingTasks: skip terminal taskId=" + r125.getId() + ", sn=" + r125.getSn() + ", remotePath=" + r125.getRemotePath() + ", status=" + r125.getStatus());
            goto L18
        L27:
            g49.d.a("DoraFileFetchManager", "restorePendingTasks: keep PAUSED taskId=" + r125.getId() + ", sn=" + r125.getSn() + ", remotePath=" + r125.getRemotePath());
            goto L18
        L28:
            DoraFileFetchTask r128 = DoraFileFetchTask.appendTrigger$default(r125, DoraTaskTrigger.RECOVERY, 0, 2, null);
            r122.f335685a.d(r128);
            DoraFileRecorder.a(r128);
            g49.d.d("DoraFileFetchManager", "restorePendingTasks: enqueue taskId=" + r128.getId() + ", sn=" + r128.getSn() + ", remotePath=" + r128.getRemotePath() + ", status=" + r128.getStatus() + " (RECOVERY)");
            String r129 = r128.getId();
            if (r129 != null) goto L31;
            r129 = "";
        L31:
            r122.g(r129);
            goto L18
        L22:
            r127 = b.f335698a[r126.ordinal()];
            goto L24
        L33:
            if (Unit.INSTANCE != r100) goto L7;
            return r100;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335698a = null;

        static {
            int[] r100 = new int[DoraFileTaskStatus.values().length];
            r100[DoraFileTaskStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[DoraFileTaskStatus.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[DoraFileTaskStatus.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[DoraFileTaskStatus.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[DoraFileTaskStatus.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[DoraFileTaskStatus.PAUSED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[DoraFileTaskStatus.DONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[DoraFileTaskStatus.CANCELED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f335698a = r100;
        }
    }

    static {
    }

    public final void c() {
        g49.d.d("DoraFileFetchManager", "detachDevice: sn=" + this.f335692h);
        Object r100 = this.f335691g;
        monitor-enter(r100);
        this.f335692h = null;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        g49.d.d("DoraFileFetchManager", "attachDevice: sn=" + r100);
        Object r101 = this.f335691g;
        monitor-enter(r101);
        this.f335692h = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void e(DoraFileFetchTask r100) {
        Object r101 = this.f335695k;
        monitor-enter(r101);
        Map<String, Set<String>> r102 = this.f335697m;     // Catch: Throwable -> L20
        String r103 = r100.getSn();     // Catch: Throwable -> L20
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        LinkedHashMap r104 = (LinkedHashMap) r102;     // Catch: Throwable -> L20
        Object r105 = r104.get(r103);     // Catch: Throwable -> L20
        if (r105 != null) goto L10;
        r105 = new LinkedHashSet();     // Catch: Throwable -> L20
        r104.put(r103, r105);     // Catch: Throwable -> L20
    L10:
        Set r106 = (Set) r105;     // Catch: Throwable -> L20
        String r107 = r100.getId();     // Catch: Throwable -> L20
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        if (r106.add(r107) == true) goto L16;
        g49.d.a("DoraFileFetchManager", "parkTask: taskId=" + r100.getId() + " already parked for sn=" + r100.getSn());     // Catch: Throwable -> L20
    L17:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L16:
        g49.d.a("DoraFileFetchManager", "parkTask: park taskId=" + r100.getId() + " for sn=" + r100.getSn());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final void f(String r210) {
        Intrinsics.checkNotNullParameter(r210, DBDefinition.TASK_ID);
        DoraFileFetchTask r100 = this.f335685a.b(r210);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getStatus() != DoraFileTaskStatus.DONE) goto L8;
        return;
    L8:
        if (r100.getStatus() == DoraFileTaskStatus.CANCELED) goto L13;
        u r101 = this.f335688d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r210, DBDefinition.TASK_ID);
        r101.f335756a.put(r210, Boolean.TRUE);
        DoraFileFetchTask r102 = DoraFileFetchTask.copy$default(r100, null, null, null, null, null, DoraFileTaskStatus.PAUSED, null, null, null, null, null, null, null, null, null, null, null, 131039, null);
        this.f335685a.d(r102);
        DoraFileRecorder.a(r102);
        BuildersKt.launch$default(this.f335689e, null, null, new DoraFileFetchManager$pause$1(this, r100, r210, null), 3, null);
        g49.d.d("DoraFileFetchManager", "pause: taskId=" + r210 + ", sn=" + r100.getSn() + ", remotePath=" + r100.getRemotePath() + ", fromStatus=" + r100.getStatus() + " -> PAUSED");
        return;
    }

    public final void g(String r100) {
        Object r101 = this.f335695k;
        monitor-enter(r101);
        boolean r102 = this.f335696l.add(r100);     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        if (r102 == true) goto L9;
        g49.d.a("DoraFileFetchManager", "registerToQueue: taskId=" + r100 + " already in pending queue, skip");
        return;
    L9:
        BuildersKt.launch$default(this.f335689e, null, null, new DoraFileFetchManager$registerToQueue$2(r100, this, null), 3, null);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void h(String r100) {
        Object r101 = this.f335695k;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f335696l.remove(r100) == false) goto L7;
        g49.d.a("DoraFileFetchManager", "removeFromPendingSet: removed taskId=" + r100 + " from pending set");     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }

    public final Object d(DoraFileFetchTask r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof DoraFileFetchManager$doUpload$1) == false) goto L7;
        DoraFileFetchManager$doUpload$1 r102 = (DoraFileFetchManager$doUpload$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (DoraFileFetchTask) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        g49.d.d("DoraFileFetchManager", "doUpload: taskId=" + r100.getId() + " finished");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (new PolarisFileWrapper(r100.getLocalPath()).exists() == true) goto L21;
        g49.d.b("DoraFileFetchManager", "doUpload: " + r100.getLocalPath() + " file not exit");
        i r107 = this.f335685a;
        String r108 = r100.getId();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r107.delete(r108);
        DoraFileRecorder.b(r100);
        return Unit.INSTANCE;
    L21:
        com.larus.dora.impl.file.upload.a r109 = this.f335686b;
        DoraFileUploaderTrigger r110 = DoraFileUploaderTrigger.AFTER_FETCH;
        r102.L$0 = r100;
        r102.label = 1;
        if (r109.a(r100, r110, r102) != r105) goto L24;
        return r105;
    L7:
        r102 = new DoraFileFetchManager$doUpload$1(this, r101);
        goto L8
    }

    public final Object i(h r310, Continuation<? super h> r311) {
        if ((r311 instanceof DoraFileFetchManager$sink$1) == false) goto L7;
        DoraFileFetchManager$sink$1 r100 = (DoraFileFetchManager$sink$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        DoraFileFetchManager r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        int r106 = r100.I$1;
        int r107 = r100.I$0;
        h r108 = (h) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        DoraFileFetchManager r109 = r102;
    L18:
        if (r106 >= r107) goto L44;
        DoraFileTaskStatus r110 = r108.f335745a.getStatus();
        DoraFileTaskStatus r111 = DoraFileTaskStatus.UPLOADING;
        if (r110 == r111) goto L44;
        r100.L$0 = null;
        r100.I$0 = r107;
        r100.I$1 = r106;
        r100.label = 1;
        DoraFileFetchTask r112 = r108.f335745a;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r112.getLocalPath());
        long r114 = 0;
        if (r113.exists() == false) goto L24;
        long r115 = r113.length();
    L25:
        Long r116 = r112.getDownloadedBytes();
        if (r116 == null) goto L28;
        r114 = r116.longValue();
    L28:
        long r117 = Math.max(r115, r114);
        Long r118 = r112.getFileTotalSize();
        if (r118 != null) goto L32;
    L34:
        DoraFileFetchTask r119 = DoraFileFetchTask.copy$default(r112, null, null, null, null, Boxing.boxLong(r117), DoraFileTaskStatus.START, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
        r109.f335685a.d(r119);
        DoraFileRecorder.a(r119);
        g49.d.d("DoraFileFetchManager", "doSink: start fetch file, taskId=" + r119.getId() + ", sn=" + r119.getSn() + ", remotePath=" + r119.getRemotePath() + ", offset=" + r117 + ", retryCount=" + r106);
        Object r120 = DoraFileStreamingSink.f335702a.a(r119, r109.f335685a, r109.f335687c, r109.f335688d, r100);
    L35:
        if (r120 != r104) goto L37;
        return r104;
    L37:
        DoraFileFetchManager$sink$1 r312 = r100;
        DoraFileFetchManager r121 = r109;
        r103 = r120;
        int r122 = r107;
        int r123 = r106;
        Object r124 = r104;
        DoraFileFetchManager$sink$1 r125 = r312;
    L38:
        h r126 = (h) r103;
        int r127 = r123 + 1;
        if (r127 >= r122) goto L43;
        r125.L$0 = r126;
        r125.I$0 = r122;
        r125.I$1 = r127;
        r125.label = 2;
        if (DelayKt.delay(1000, r125) != r124) goto L43;
        return r124;
    L43:
        int r313 = r122;
        r108 = r126;
        r109 = r121;
        r100 = r125;
        r104 = r124;
        r106 = r127;
        r107 = r313;
        goto L18
    L45:
        int r314 = r122;
        r108 = r126;
        r109 = r121;
        r100 = r125;
        r104 = r124;
        r106 = r127;
        r107 = r314;
        goto L18
    L32:
        if (r117 != r118.longValue()) goto L34;
        g49.d.d("DoraFileFetchManager", "doSink: " + r112.getFileName() + " already downloaded");
        DoraFileFetchTask r128 = DoraFileFetchTask.copy$default(r112, null, null, null, null, Boxing.boxLong(r117), r111, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
        r109.f335685a.d(r128);
        DoraFileRecorder.a(r128);
        r120 = new h(r128, DoraFileStreamingSinkReason.DONE);
        goto L35
    L24:
        r115 = 0;
    L44:
        return r108;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r129 = r100.I$1;
        int r130 = r100.I$0;
        ResultKt.throwOnFailure(r103);
        r122 = r130;
        r123 = r129;
        r124 = r104;
        r125 = r100;
        r121 = r102;
        goto L38
    L16:
        ResultKt.throwOnFailure(r103);
        r106 = 0;
        r107 = 3;
        r108 = r310;
    L7:
        r102 = this;
        r100 = new DoraFileFetchManager$sink$1(r102, r311);
        goto L8
    }

    public static final Object a(DoraFileFetchManager r510, String r511, Continuation r512) {
        String r100 = r511;
        r510.getClass();
        String r101 = "processTask: start fetch ";
        if ((r512 instanceof DoraFileFetchManager$processTask$1) == false) goto L7;
        DoraFileFetchManager$processTask$1 r102 = (DoraFileFetchManager$processTask$1) r512;
        String r110 = "processTask: skip for unmatched device, taskId=";
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L8;
        r102.label = r103 - Integer.MIN_VALUE;
    L9:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r111 = r102.label;
        long r210 = 0;
        if (r111 != 0) goto L12;
        ResultKt.throwOnFailure(r104);
        g49.d.d("DoraFileFetchManager", "processTask: ****** enter taskId=" + r100 + " ******");
        r510.f335694j = r100;
        r510.h(r511);     // Catch: Throwable -> L117
        DoraFileFetchTask r106 = r510.f335685a.b(r100);     // Catch: Throwable -> L117
        if (r106 != null) goto L41;
        g49.d.e("DoraFileFetchManager", "processTask: task not found for taskId=" + r100);     // Catch: Throwable -> L117
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r510.f335694j = null;
        StringBuilder r108 = new StringBuilder("processTask: ###### exit taskId=");
    L101:
        Unit r109 = r107;
        r101 = " ######";
    L140:
        r108.append(r100);
        r108.append(r101);
        g49.d.d("DoraFileFetchManager", r108.toString());
        return r109;
    L41:
        g49.d.a("DoraFileFetchManager", "processTask: loaded taskId=" + r106.getId() + ", sn=" + r106.getSn() + ", remotePath=" + r106.getRemotePath() + ", status=" + r106.getStatus());     // Catch: Throwable -> L117
        if (r106.getStatus() != DoraFileTaskStatus.DONE) goto L44;
    L125:
        r101 = " ######";
        g49.d.a("DoraFileFetchManager", "processTask: task already in terminal status=" + r106.getStatus() + ", taskId=" + r106.getId());     // Catch: Throwable -> L142
        PolarisFileWrapper r112 = new PolarisFileWrapper(r106.getLocalPath());     // Catch: Throwable -> L135
        if (r112.exists() == false) goto L130;
        r112.delete();     // Catch: Throwable -> L135
    L130:
        i r113 = r510.f335685a;     // Catch: Throwable -> L135
        String r114 = r106.getId();     // Catch: Throwable -> L135
        if (r114 != null) goto L133;
        r114 = "";
    L133:
        r113.delete(r114);     // Catch: Throwable -> L135
        DoraFileRecorder.b(r106);     // Catch: Throwable -> L135
    L137:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L142
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
    L139:
        r109 = r115;
        goto L140
    L135:
        th = move-exception;
        g49.d.c("DoraFileFetchManager", "processTask: taskId=" + r106.getId() + ", task down or canceled, delete file exception", th);     // Catch: Throwable -> L142
        goto L137
    L44:
        if (r106.getStatus() == DoraFileTaskStatus.CANCELED) goto L125;
        if (r106.getStatus() != DoraFileTaskStatus.UPLOADING) goto L54;
        g49.d.d("DoraFileFetchManager", "processTask: resume upload only for taskId=" + r106.getId());     // Catch: Throwable -> L117
        r102.L$0 = r100;     // Catch: Throwable -> L117
        r102.label = 1;     // Catch: Throwable -> L117
        if (r510.d(r106, r102) == r105) goto L154;
    L51:
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
        goto L101
    L154:
        return r105;
    L54:
        if (r106.getStatus() != DoraFileTaskStatus.PAUSED) goto L57;
        g49.d.a("DoraFileFetchManager", "processTask: task is PAUSED, skip execution taskId=" + r106.getId());     // Catch: Throwable -> L117
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
        goto L101
    L57:
        String r116 = r510.f335692h;     // Catch: Throwable -> L117
        if (r116 != null) goto L60;
    L119:
        r101 = " ######";
        g49.d.d("DoraFileFetchManager", r110 + r106.getId() + ", taskSn=" + r106.getSn() + ", currentDeviceSn=" + r116);     // Catch: Throwable -> L142
        DoraFileTaskStatus r117 = r106.getStatus();     // Catch: Throwable -> L142
        DoraFileTaskStatus r118 = DoraFileTaskStatus.PENDING;     // Catch: Throwable -> L142
        if (r117 == r118) goto L123;
        r106 = DoraFileFetchTask.copy$default(r106, null, null, null, null, null, r118, null, null, null, null, null, null, null, null, null, null, null, 131039, null);     // Catch: Throwable -> L142
        r510.f335685a.d(r106);     // Catch: Throwable -> L142
        DoraFileRecorder.a(r106);     // Catch: Throwable -> L142
    L123:
        r510.e(r106);     // Catch: Throwable -> L142
        r115 = Unit.INSTANCE;     // Catch: Throwable -> L142
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
        goto L139
    L60:
        if (Intrinsics.areEqual(r116, r106.getSn()) == false) goto L119;
        long r119 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L117
        File r120 = AppHost.f326268a.getApplication().getFilesDir();     // Catch: Throwable -> L117
        Intrinsics.checkNotNullParameter(r120, "<this>");     // Catch: Throwable -> L117
    L65:
        if (new StatFs(r120.getPath()).getAvailableBytes() > 524288000) goto L70;
        boolean r121 = false;
    L71:
        if (r121 == true) goto L74;
        g49.d.b("DoraFileFetchManager", "processTask: no enough space");     // Catch: Throwable -> L117
        com.larus.dora.impl.file.a r122 = f.f335741a;     // Catch: Throwable -> L117
        f.a(r106, DoraFileStreamingSinkReason.NO_ENOUGH_SPACE, SystemClock.elapsedRealtime() - r119);     // Catch: Throwable -> L117
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
        goto L101
    L74:
        g49.d.d("DoraFileFetchManager", "processTask: start fetch " + r106.getFileName());     // Catch: Throwable -> L117
        Long r123 = r106.getDownloadedBytes();     // Catch: Throwable -> L117
        if (r123 == null) goto L77;
        long r124 = r123.longValue();     // Catch: Throwable -> L117
    L78:
        h r125 = new h(r106, DoraFileStreamingSinkReason.START);     // Catch: Throwable -> L117
        r102.L$0 = r100;     // Catch: Throwable -> L117
        r102.J$0 = r119;     // Catch: Throwable -> L117
        r102.J$1 = r124;     // Catch: Throwable -> L117
        r102.label = 2;     // Catch: Throwable -> L117
        r104 = r510.i(r125, r102);     // Catch: Throwable -> L117
        if (r104 == r105) goto L155;
        long r126 = r124;
    L82:
        h r127 = (h) r104;     // Catch: Throwable -> L117
        DoraFileFetchTask r128 = r127.f335745a;     // Catch: Throwable -> L117
        StringBuilder r129 = new StringBuilder("processTask: fetch ");     // Catch: Throwable -> L117
        r129.append(r128.getFileName());     // Catch: Throwable -> L117
        r129.append(" done, taskId=");     // Catch: Throwable -> L117
        r129.append(r128.getId());     // Catch: Throwable -> L117
        r129.append(", status=");     // Catch: Throwable -> L117
        r129.append(r128.getStatus());     // Catch: Throwable -> L117
        r129.append(", fetchSize=");     // Catch: Throwable -> L117
        Long r130 = r128.getDownloadedBytes();     // Catch: Throwable -> L117
        if (r130 == null) goto L85;
        r210 = r130.longValue();     // Catch: Throwable -> L117
    L85:
        r129.append(r210 - r126);     // Catch: Throwable -> L117
        g49.d.d("DoraFileFetchManager", r129.toString());     // Catch: Throwable -> L117
        if (r128.getStatus() == DoraFileTaskStatus.UPLOADING) goto L89;
        com.larus.dora.impl.file.a r131 = f.f335741a;     // Catch: Throwable -> L117
        f.a(r128, r127.f335746b, SystemClock.elapsedRealtime() - r119);     // Catch: Throwable -> L117
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
        goto L101
    L89:
        String r132 = r128.getLocalPath();     // Catch: Throwable -> L117
        if (r132 != null) goto L92;
        r132 = "";
    L92:
        PolarisFileWrapper r133 = new PolarisFileWrapper(r132);     // Catch: Throwable -> L117
        long r134 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L117
        String r135 = c.a(r133);     // Catch: Throwable -> L117
        g49.d.d("DoraFileFetchManager", "processTask: fileMd5=" + r135 + ", cost:" + (SystemClock.elapsedRealtime() - r134));     // Catch: Throwable -> L117
        boolean r136 = true;
        if (StringsKt.equals(r128.getFileMd5(), r135, true) == true) goto L102;
        g49.d.b("DoraFileFetchManager", "processTask: " + r128.getId() + " check md5 failed");     // Catch: Throwable -> L117
        r133.delete();     // Catch: Throwable -> L97
        r510.f335685a.delete(r100);     // Catch: Throwable -> L97
        DoraFileRecorder.b(r128);     // Catch: Throwable -> L97
    L99:
        com.larus.dora.impl.file.a r137 = f.f335741a;     // Catch: Throwable -> L117
        f.a(r128, DoraFileStreamingSinkReason.MD5_CHECK_FAILED, SystemClock.elapsedRealtime() - r119);     // Catch: Throwable -> L117
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r510.f335694j = null;
        r108 = new StringBuilder("processTask: ###### exit taskId=");
        goto L101
    L97:
        th = move-exception;
        g49.d.c("DoraFileFetchManager", "processTask: taskId=" + r128.getId() + ", delete file exception", th);     // Catch: Throwable -> L117
        goto L99
    L102:
        com.larus.dora.impl.file.a r138 = f.f335741a;     // Catch: Throwable -> L117
        f.a(r128, DoraFileStreamingSinkReason.DONE, SystemClock.elapsedRealtime() - r119);     // Catch: Throwable -> L117
        g49.d.d("DoraFileFetchManager", "processTask: start  fileReceivedAck");     // Catch: Throwable -> L117
        v r139 = r510.f335687c;     // Catch: Throwable -> L117
        String r140 = r128.getFileName();     // Catch: Throwable -> L117
        if (r140 != null) goto L105;
        r140 = "";
    L105:
        r102.L$0 = r100;     // Catch: Throwable -> L117
        r102.L$1 = r128;     // Catch: Throwable -> L117
        r102.label = 3;     // Catch: Throwable -> L117
        r104 = r139.b(r140, 3, r102);     // Catch: Throwable -> L117
        if (r104 == r105) goto L156;
    L108:
        boolean r141 = ((Boolean) r104).booleanValue();     // Catch: Throwable -> L117
        StringBuilder r142 = new StringBuilder("processTask: fileReceivedAck=");     // Catch: Throwable -> L117
        if (r141 == true) goto L112;
        r136 = false;
    L112:
        r142.append(r136);     // Catch: Throwable -> L117
        g49.d.d("DoraFileFetchManager", r142.toString());     // Catch: Throwable -> L117
        g49.d.d("DoraFileFetchManager", "processTask: start upload " + r128.getFileName());     // Catch: Throwable -> L117
        r102.L$0 = r100;     // Catch: Throwable -> L117
        r102.L$1 = r128;     // Catch: Throwable -> L117
        r102.label = 4;     // Catch: Throwable -> L117
        if (r510.d(r128, r102) == r105) goto L157;
    L115:
        g49.d.d("DoraFileFetchManager", "processTask: upload " + r128.getFileName() + " end");     // Catch: Throwable -> L117
        r510.f335694j = null;
        g49.d.d("DoraFileFetchManager", "processTask: ###### exit taskId=" + r100 + " ######");
        return Unit.INSTANCE;
    L157:
        return r105;
    L156:
        return r105;
    L155:
        return r105;
    L77:
        r124 = 0;
    L70:
        r121 = true;
    L68:
        th = move-exception;
        g49.d.c("DoraFile", "hasEnoughSpace: EXCEPTION", th);     // Catch: Throwable -> L117
    L142:
        th = th;
    L143:
        r510.f335694j = null;
        g49.d.d("DoraFileFetchManager", "processTask: ###### exit taskId=" + r100 + r101);
        throw th;
    L12:
        if (r111 != 1) goto L14;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L117
        goto L51
    L14:
        if (r111 != 2) goto L145;
        r126 = r102.J$1;
        r119 = r102.J$0;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L117
        goto L82
    L145:
        if (r111 != 3) goto L18;
        DoraFileFetchTask r143 = (DoraFileFetchTask) r102.L$1;
        String r144 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L27
        r136 = true;
        r128 = r143;
        r100 = r144;
        goto L108
    L18:
        if (r111 != 4) goto L23;
        DoraFileFetchTask r145 = (DoraFileFetchTask) r102.L$1;
        String r146 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L27
        r128 = r145;
        r100 = r146;
        goto L115
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L27:
        th = th;
        r100 = "processTask: start fetch ";
    L29:
        r101 = " ######";
    L117:
        th = th;
    L8:
        r102 = new DoraFileFetchManager$processTask$1(r510, r512);
        goto L9
    L7:
        r110 = "processTask: skip for unmatched device, taskId=";
        goto L8
    }

    public DoraFileFetchManager(j r100, DoraFileUploaderImpl r101, DoraFileRemoteStreamer r102, u r110) {
        Intrinsics.checkNotNullParameter(r100, "taskStore");
        Intrinsics.checkNotNullParameter(r101, "uploader");
        Intrinsics.checkNotNullParameter(r102, "remoteStreamer");
        Intrinsics.checkNotNullParameter(r110, "pauseController");
        this.f335685a = r100;
        this.f335686b = r101;
        this.f335687c = r102;
        this.f335688d = r110;
        CoroutineScope r103 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f335689e = r103;
        this.f335690f = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f335691g = new Object();
        this.f335693i = j1.a(Boolean.FALSE);
        this.f335695k = new Object();
        this.f335696l = new LinkedHashSet();
        this.f335697m = new LinkedHashMap();
        BuildersKt.launch$default(r103, null, null, new AnonymousClass1(this, null), 3, null);
    }
}
