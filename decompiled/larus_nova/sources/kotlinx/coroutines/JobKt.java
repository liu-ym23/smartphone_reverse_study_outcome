package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class JobKt {
    public static final CompletableJob Job(Job r100) {
        return new e1(r100);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext r100) {
        cancel(r100, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext r100) {
        cancelChildren(r100, null);
    }

    public static final void ensureActive(CoroutineContext r100) {
        Job r101 = (Job) r100.get(Job.Key);
        if (r101 == null) goto L6;
        ensureActive(r101);
        return;
    }

    public static final Job getJob(CoroutineContext r100) {
        Job r101 = (Job) r100.get(Job.Key);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r100).toString());
    }

    public static final boolean isActive(CoroutineContext r100) {
        Job r101 = (Job) r100.get(Job.Key);
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.isActive();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final /* synthetic */ Job m10958Job(Job r100) {
        return Job(r100);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job r100) {
        cancelChildren(r100, null);
    }

    public static final void ensureActive(Job r100) {
        if (r100.isActive() == false) goto L6;
        return;
    L6:
        throw r100.getCancellationException();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final boolean cancel(CoroutineContext r100, Throwable r101) {
        CoroutineContext.Element r102 = r100.get(Job.Key);
        if ((r102 instanceof JobSupport) == false) goto L5;
        JobSupport r103 = (JobSupport) r102;
    L6:
        if (r103 != null) goto L8;
        return false;
    L8:
        if (r101 != null) goto L10;
        r101 = new JobCancellationException("Job was cancelled", null, r103);
    L10:
        r103.u(r101);
        return true;
    L5:
        r103 = null;
        goto L6
    }

    public static final Object cancelAndJoin(Job r100, Continuation<? super Unit> r101) {
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        Object r102 = r100.join(r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext r100, Throwable r101) {
        Job r102 = (Job) r100.get(Job.Key);
        if (r102 == null) goto L17;
        Iterator<Job> r103 = r102.getChildren().iterator();
    L7:
        if (r103.hasNext() == false) goto L23;
        Job r104 = r103.next();
        if ((r104 instanceof JobSupport) == false) goto L11;
        JobSupport r105 = (JobSupport) r104;
    L12:
        if (r105 == null) goto L7;
        if (r101 != null) goto L15;
        Throwable r106 = new JobCancellationException("Job was cancelled", null, r102);
    L16:
        r105.u(r106);
        goto L7
    L15:
        r106 = r101;
        goto L16
    L11:
        r105 = null;
        goto L12
    L23:
        return;
    }

    public static final void cancelFutureOnCancellation(i<?> r100, Future<?> r101) {
        l.b(r100, new f(r101));
    }

    public static final m0 cancelFutureOnCompletion(Job r100, Future<?> r101) {
        return invokeOnCompletion$default(r100, false, false, new g(r101), 3, null);
    }

    public static final m0 disposeOnCompletion(Job r100, m0 r101) {
        return invokeOnCompletion$default(r100, false, false, new o0(r101), 3, null);
    }

    public static final void cancel(CoroutineContext r100, CancellationException r101) {
        Job r102 = (Job) r100.get(Job.Key);
        if (r102 == null) goto L6;
        r102.cancel(r101);
        return;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(Job r100, Throwable r101) {
        Iterator<Job> r102 = r100.getChildren().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        Job r103 = r102.next();
        if ((r103 instanceof JobSupport) == false) goto L8;
        JobSupport r104 = (JobSupport) r103;
    L9:
        if (r104 == null) goto L4;
        if (r101 != null) goto L12;
        Throwable r105 = new JobCancellationException("Job was cancelled", null, r100);
    L13:
        r104.u(r105);
        goto L4
    L12:
        r105 = r101;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    public static final void cancelChildren(CoroutineContext r100, CancellationException r101) {
        Job r102 = (Job) r100.get(Job.Key);
        if (r102 == null) goto L10;
        Sequence<Job> r103 = r102.getChildren();
        if (r103 == null) goto L12;
        Iterator<Job> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        r104.next().cancel(r101);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public static final void cancelChildren(Job r100, CancellationException r101) {
        Iterator<Job> r102 = r100.getChildren().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().cancel(r101);
        goto L4
    }

    public static /* synthetic */ CompletableJob Job$default(Job r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return Job(r100);
    }

    public static final void cancel(Job r100, String r101, Throwable r102) {
        r100.cancel(u0.a(r101, r102));
    }

    /* JADX INFO: renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ Job m10959Job$default(Job r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return m10958Job(r100);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext r100, Throwable r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return cancel(r100, r101);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r100, Throwable r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cancelChildren(r100, r101);
    }

    public static final m0 invokeOnCompletion(Job r100, boolean r101, boolean r102, z0 r103) {
        if ((r100 instanceof JobSupport) == false) goto L6;
        return ((JobSupport) r100).Q(r101, r102, r103);
    L6:
        return r100.invokeOnCompletion(r101, r102, new JobKt__JobKt$invokeOnCompletion$1(r103));
    }

    public static /* synthetic */ void cancel$default(CoroutineContext r100, CancellationException r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cancel(r100, r101);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r100, CancellationException r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cancelChildren(r100, r101);
    }

    public static /* synthetic */ void cancelChildren$default(Job r100, Throwable r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cancelChildren(r100, r101);
    }

    public static /* synthetic */ void cancelChildren$default(Job r100, CancellationException r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cancelChildren(r100, r101);
    }

    public static /* synthetic */ void cancel$default(Job r100, String r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        cancel(r100, r101, r102);
    }

    public static /* synthetic */ m0 invokeOnCompletion$default(Job r100, boolean r101, boolean r102, z0 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = true;
    L9:
        return invokeOnCompletion(r100, r101, r102, r103);
    }
}
