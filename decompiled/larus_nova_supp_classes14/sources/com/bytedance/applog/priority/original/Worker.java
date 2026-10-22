package com.bytedance.applog.priority.original;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class Worker implements Runnable {
    public static final /* synthetic */ int h = 0;
    public final Model$PriorityName a;
    public final o b;
    public final Lazy c;
    public long d;
    public final y e;
    public List<? extends g> f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b implements z<JSONObject> {
        public final /* synthetic */ Worker a;

        public final Object load() {
            String r0 = this.a.b.getContext().b.f.getHeaderJson();
            if (r0 != null) goto L5;
        L17:
            this.a.b.getContext().c.a("Worker:run", new Worker$run$header$1$load$1(this));
            return null;
        L5:
            if (r0.length() != 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == true) goto L17;
            return new JSONObject(r0);
        L12:
            e = move-exception;
            if (this.a.b.getContext().b.f.isMonitorEnabled() == false) goto L16;
            this.a.b.getContext().b.f.monitorError("priority parse header error", e.toString());
        L16:
            this.a.b.getContext().c.b("Worker:run", e, new Worker$run$header$1$load$2(this));
            return null;
        L7:
            r3 = false;
            goto L8
        }

        public b(Worker r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.priority.original.Worker$run$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$4", f = "Worker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ i<JSONObject> $header;
        final /* synthetic */ long $runTimeSecs;
        final /* synthetic */ List<g> $runs;
        int label;
        final /* synthetic */ Worker this$0;

        /* JADX INFO: renamed from: com.bytedance.applog.priority.original.Worker$run$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$4$1", f = "Worker.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ i<JSONObject> $header;
            final /* synthetic */ long $runTimeSecs;
            final /* synthetic */ List<g> $runs;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ Worker this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(List<? extends g> r1, Worker r2, i<JSONObject> r3, long r4, Continuation<? super AnonymousClass1> r6) {
                this.$runs = r1;
                this.this$0 = r2;
                this.$header = r3;
                this.$runTimeSecs = r4;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
                AnonymousClass1 r7 = new AnonymousClass1(this.$runs, this.this$0, this.$header, this.$runTimeSecs, r10);
                r7.L$0 = r9;
                return r7;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r21) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L8;
                if (r2 != 1) goto L7;
                ResultKt.throwOnFailure(r21);
            L16:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r21);
                CoroutineScope r3 = (CoroutineScope) this.L$0;
                List<g> r4 = this.$runs;
                Worker r12 = this.this$0;
                i<JSONObject> r13 = this.$header;
                long r14 = this.$runTimeSecs;
                ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
                Iterator<T> r16 = r4.iterator();
            L10:
                if (r16.hasNext() == false) goto L12;
                ArrayList r5 = r11;
                r5.add(BuildersKt.async$default(r3, null, null, new Worker$run$4$1$1$1(r12, (g) r16.next(), r13, r14, null), 3, null));
                r11 = r5;
                goto L10
            L12:
                this.label = 1;
                if (AwaitKt.a(r11, this) != r1) goto L16;
                return r1;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Worker r1, List<? extends g> r2, i<JSONObject> r3, long r4, Continuation<? super AnonymousClass4> r6) {
            this.this$0 = r1;
            this.$runs = r2;
            this.$header = r3;
            this.$runTimeSecs = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass4(this.this$0, this.$runs, this.$header, this.$runTimeSecs, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Job> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r11);
            return BuildersKt.launch$default((CoroutineScope) this.this$0.g.getValue(), null, null, new AnonymousClass1(this.$runs, this.this$0, this.$header, this.$runTimeSecs, null), 3, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final void a() {
        this.b.getContext().c.a("Worker:run", new AnonymousClass1(this));
        long r9 = System.currentTimeMillis() / ((long) ECDraweeView.SQUARE);
        if (this.b.getContext().b.f.isNetworkAvailable() == true) goto L6;
        this.b.getContext().c.a("Worker:run", new AnonymousClass2(this));
        return;
    L6:
        i r8 = new i(new b(this));
        List<? extends g> r0 = this.f;
        final ArrayList r7 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (((g) r2).a(r9) == false) goto L8;
        r7.add(r2);
        goto L8
    L12:
        this.b.getContext().c.a("Worker:run", new AnonymousClass3(this, r7));
        BuildersKt.runBlocking$default(null, new AnonymousClass4(this, r7, r8, r9, null), 1, null);
    }

    public final String toString() {
        return "Worker-" + this.a.name();
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

    public final void b(final List<Group> r6) {
        Intrinsics.checkNotNullParameter(r6, "sourceGroups");
        this.b.getContext().c.a("Worker:setGroups", new Worker$setGroups$1(this, r6));
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).destroy();
        goto L4
    L6:
        this.b.getContext().c.a("Worker:setGroups", new Worker$setGroups$3(this));
        this.f = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r1.add(Long.valueOf(((g) r7.next()).b()));
        goto L8
    L10:
        long r3 = CommonKt.i(CollectionsKt.toList(r1));
        this.d = r3;
        this.e.a(r3);
        if (this.f.isEmpty() == false) goto L13;
        this.b.getContext().c.b("Worker:startWorkerTimer", null, new Worker$startWorkerTimer$1(this));
    L13:
        Set<Integer> r8 = this.b.a.a(this.a).d();
        List<? extends g> r2 = this.f;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r4.add(Integer.valueOf(((g) r5.next()).c()));
        goto L15
    L17:
        Set r9 = CollectionsKt.toSet(r4);
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        Object r12 = r11.next();
        if ((!r9.contains(Integer.valueOf(((Number) r12).intValue()))) == false) goto L19;
        r10.add(r12);
        goto L19
    L23:
        final Set r13 = CollectionsKt.toSet(r10);
        if (r13.isEmpty() == false) goto L26;
        this.b.getContext().c.a("Worker:handleMissedGroups", new Worker$handleMissedGroups$1(this));
    L30:
        this.b.getContext().c.a("Worker:setGroups", new Worker$setGroups$5(this));
        return;
    L26:
        this.b.getContext().c.a("Worker:handleMissedGroups", new Worker$handleMissedGroups$2(r13));
        ExecutorService r14 = PThreadExecutorsUtils.newFixedThreadPool(RangesKt.coerceAtMost(r13.size(), 3), new DefaultThreadFactory("iginal/Worker"));
        Iterator r15 = r13.iterator();
    L28:
        if (r15.hasNext() == false) goto L30;
        final int r16 = ((Number) r15.next()).intValue();
        final d r17 = this.b.a.a(this.a);
        r14.submit(new a0(r17, r16, this));
        goto L28
    }

    public Worker(Model$PriorityName r3, o r4, List<Group> r5) {
        Intrinsics.checkNotNullParameter(r3, "priorityName");
        Intrinsics.checkNotNullParameter(r4, "priorityContext");
        Intrinsics.checkNotNullParameter(r5, "sourceGroups");
        this.a = r3;
        this.b = r4;
        this.c = LazyKt.lazy(new Worker$globalSchedulerExecutor$2(this));
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.add(Long.valueOf(((Group) r7.next()).b.c));
        goto L4
    L6:
        this.d = CommonKt.i(CollectionsKt.toList(r6));
        this.e = new y((ScheduledExecutorService) this.c.getValue(), this, this.d);
        this.f = CollectionsKt.emptyList();
        this.g = LazyKt.lazy(new Worker$coroutineScope$2(this));
        b(r5);
    }
}
