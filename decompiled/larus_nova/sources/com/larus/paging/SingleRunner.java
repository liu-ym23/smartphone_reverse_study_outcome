package com.larus.paging;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class SingleRunner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f363738b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Holder f363739a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Lcom/larus/paging/SingleRunner;", "(Lcom/larus/paging/SingleRunner;)V", "getRunner", "()Lcom/larus/paging/SingleRunner;", "paging-common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CancelIsolatedRunnerException extends CancellationException {
        private final SingleRunner runner;

        public final SingleRunner getRunner() {
            return this.runner;
        }

        public CancelIsolatedRunnerException(SingleRunner r100) {
            Intrinsics.checkNotNullParameter(r100, "runner");
            this.runner = r100;
        }
    }

    public static final class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SingleRunner f363740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f363741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MutexImpl f363742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Job f363743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f363744e;

        public Holder(SingleRunner r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "singleRunner");
            this.f363740a = r100;
            this.f363741b = r101;
            this.f363742c = kotlinx.coroutines.sync.b.a();
        }

        public final Object a(Job r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof SingleRunner$Holder$onFinish$1) == false) goto L7;
            SingleRunner$Holder$onFinish$1 r102 = (SingleRunner$Holder$onFinish$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$2;
            Job r108 = (Job) r102.L$1;
            Holder r109 = (Holder) r102.L$0;
            ResultKt.throwOnFailure(r104);
            kotlinx.coroutines.sync.a r110 = r107;
            r100 = r108;
        L27:
        L24:
            th = move-exception;
            r110.unlock(null);
            throw th;
        L19:
            if (r100 != r109.f363743d) goto L21;
            r109.f363743d = null;     // Catch: Throwable -> L24
        L21:
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L24
            r110.unlock(null);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            r110 = this.f363742c;
            r102.L$0 = this;
            r102.L$1 = r100;
            r102.L$2 = r110;
            r102.label = 1;
            if (r110.a(null, r102) != r105) goto L17;
            return r105;
        L17:
            r109 = this;
        L7:
            r102 = new SingleRunner$Holder$onFinish$1(this, r101);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final Object b(int r110, Job r111, Continuation<? super Boolean> r112) {
            if ((r112 instanceof SingleRunner$Holder$tryEnqueue$1) == false) goto L7;
            SingleRunner$Holder$tryEnqueue$1 r100 = (SingleRunner$Holder$tryEnqueue$1) r112;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r113 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            boolean r104 = true;
            if (r103 == 0) goto L18;
            if (r103 == 1) goto L17;
            if (r103 != 2) goto L16;
            r110 = r100.I$0;
            kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$2;
            Job r105 = (Job) r100.L$1;
            Holder r106 = (Holder) r100.L$0;
            ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L45
            ?? r107 = r105;
            kotlinx.coroutines.sync.a r115 = r114;
        L40:
            Holder r108 = r106;
            ?? r109 = r107;
        L41:
            r108.f363743d = r109;     // Catch: Throwable -> L45
            r108.f363744e = r110;     // Catch: Throwable -> L45
            r111 = r115;
        L42:
            Boolean r116 = Boxing.boxBoolean(r104);     // Catch: Throwable -> L45
            r111.unlock(null);
            return r116;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            r110 = r100.I$0;
            kotlinx.coroutines.sync.a r117 = (kotlinx.coroutines.sync.a) r100.L$2;
            Job r118 = (Job) r100.L$1;
            r108 = (Holder) r100.L$0;
            ResultKt.throwOnFailure(r113);
            r109 = r118;
            r115 = r117;
        L22:
            Job r119 = r108.f363743d;     // Catch: Throwable -> L45
            if (r119 != null) goto L25;
        L33:
            if (r119 == null) goto L35;
            r119.cancel(new CancelIsolatedRunnerException(r108.f363740a));     // Catch: Throwable -> L45
        L35:
            if (r119 == null) goto L41;
            r100.L$0 = r108;     // Catch: Throwable -> L45
            r100.L$1 = r109;     // Catch: Throwable -> L45
            r100.L$2 = r115;     // Catch: Throwable -> L45
            r100.I$0 = r110;     // Catch: Throwable -> L45
            r100.label = 2;     // Catch: Throwable -> L45
            if (r119.join(r100) != r102) goto L39;
            return r102;
        L39:
            r107 = r109;
            r106 = r108;
            r115 = r115;
            goto L40
        L25:
            if (r119.isActive() == false) goto L33;
            int r120 = r108.f363744e;     // Catch: Throwable -> L45
            if (r120 < r110) goto L33;
            if (r120 == r110) goto L30;
        L32:
            r104 = false;
            r111 = r115;
            goto L42
        L30:
            if (r108.f363741b == false) goto L32;
        L18:
            ResultKt.throwOnFailure(r113);
            MutexImpl r121 = this.f363742c;
            r100.L$0 = this;
            r100.L$1 = r111;
            r100.L$2 = r121;
            r100.I$0 = r110;
            r100.label = 1;
            if (r121.a(null, r100) != r102) goto L21;
            return r102;
        L21:
            r108 = this;
            r109 = r111;
            r115 = r121;
        L45:
            th = move-exception;
            r111.unlock(null);
            throw th;
        L7:
            r100 = new SingleRunner$Holder$tryEnqueue$1(this, r112);
            goto L8
        }
    }

    public static final class a {
    }

    static {
    }

    public SingleRunner() {
        this(true);
    }

    public SingleRunner(boolean r100) {
        this.f363739a = new Holder(this, r100);
    }

    public final Object a(int r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof SingleRunner$runInIsolation$1) == false) goto L7;
        SingleRunner$runInIsolation$1 r103 = (SingleRunner$runInIsolation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        SingleRunner r108 = (SingleRunner) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: CancelIsolatedRunnerException -> L14
    L27:
        return Unit.INSTANCE;
    L14:
        CancelIsolatedRunnerException e100 = e;
    L25:
        if (e100.getRunner() == r108) goto L27;
        throw e100;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        SingleRunner$runInIsolation$2 r109 = new SingleRunner$runInIsolation$2(this, r100, r101, null);     // Catch: CancelIsolatedRunnerException -> L22
        r103.L$0 = this;     // Catch: CancelIsolatedRunnerException -> L22
        r103.label = 1;     // Catch: CancelIsolatedRunnerException -> L22
        if (CoroutineScopeKt.coroutineScope(r109, r103) != r106) goto L27;
        return r106;
    L22:
        e = move-exception;
        e100 = e;
        r108 = this;
    L7:
        r103 = new SingleRunner$runInIsolation$1(this, r102);
        goto L8
    }
}
