package kotlinx.coroutines;

import android.util.EventsUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class JobKt {
    public static final CompletableJob Job(Job r1) {
        return new e1(r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext r1) {
        cancel(r1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext r1) {
        cancelChildren(r1, null);
    }

    public static final void ensureActive(CoroutineContext r1) {
        Job r2 = (Job) r1.get(Job.Key);
        if (r2 == null) goto L6;
        ensureActive(r2);
        return;
    }

    public static final Job getJob(CoroutineContext r3) {
        Job r0 = (Job) r3.get(Job.Key);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r3).toString());
    }

    public static final boolean isActive(CoroutineContext r1) {
        Job r2 = (Job) r1.get(Job.Key);
        if (r2 != null) goto L7;
        return true;
    L7:
        return r2.isActive();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final /* synthetic */ Job m200Job(Job r0) {
        return Job(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job r1) {
        cancelChildren(r1, null);
    }

    public static final void ensureActive(Job r1) {
        if (r1.isActive() == false) goto L6;
        return;
    L6:
        throw r1.getCancellationException();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final boolean cancel(CoroutineContext r2, Throwable r3) {
        CoroutineContext.Element r4 = r2.get(Job.Key);
        if ((r4 instanceof JobSupport) == false) goto L5;
        JobSupport r5 = (JobSupport) r4;
    L6:
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r3 != null) goto L10;
        r3 = new JobCancellationException("Job was cancelled", null, r5);
    L10:
        r5.u(r3);
        return true;
    L5:
        r5 = null;
        goto L6
    }

    public static final Object cancelAndJoin(Job r2, Continuation<? super Unit> r3) {
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        Object r4 = r2.join(r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext r5, Throwable r6) {
        Job r7 = (Job) r5.get(Job.Key);
        if (r7 == null) goto L17;
        Iterator<Job> r0 = r7.getChildren().iterator();
    L7:
        if (r0.hasNext() == false) goto L23;
        Job r1 = r0.next();
        if ((r1 instanceof JobSupport) == false) goto L11;
        JobSupport r2 = (JobSupport) r1;
    L12:
        if (r2 == null) goto L7;
        if (r6 != null) goto L15;
        Throwable r3 = new JobCancellationException("Job was cancelled", null, r7);
    L16:
        r2.u(r3);
        goto L7
    L15:
        r3 = r6;
        goto L16
    L11:
        r2 = null;
        goto L12
    L23:
        return;
    }

    public static final void cancelFutureOnCancellation(i<?> r1, Future<?> r2) {
        l.b(r1, new f(r2));
    }

    public static final m0 cancelFutureOnCompletion(Job r6, Future<?> r7) {
        return invokeOnCompletion$default(r6, false, false, new g(r7), 3, null);
    }

    public static final m0 disposeOnCompletion(Job r6, m0 r7) {
        return invokeOnCompletion$default(r6, false, false, new o0(r7), 3, null);
    }

    public static final void cancel(CoroutineContext r1, CancellationException r2) {
        Job r3 = (Job) r1.get(Job.Key);
        if (r3 == null) goto L6;
        r3.cancel(r2);
        return;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(Job r5, Throwable r6) {
        Iterator<Job> r0 = r5.getChildren().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Job r1 = r0.next();
        if ((r1 instanceof JobSupport) == false) goto L8;
        JobSupport r2 = (JobSupport) r1;
    L9:
        if (r2 == null) goto L4;
        if (r6 != null) goto L12;
        Throwable r3 = new JobCancellationException("Job was cancelled", null, r5);
    L13:
        r2.u(r3);
        goto L4
    L12:
        r3 = r6;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public static final void cancelChildren(CoroutineContext r1, CancellationException r2) {
        Job r3 = (Job) r1.get(Job.Key);
        if (r3 == null) goto L10;
        Sequence<Job> r4 = r3.getChildren();
        if (r4 == null) goto L12;
        Iterator<Job> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        r5.next().cancel(r2);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public static final void cancelChildren(Job r1, CancellationException r2) {
        Iterator<Job> r3 = r1.getChildren().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().cancel(r2);
        goto L4
    }

    public static /* synthetic */ CompletableJob Job$default(Job r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return Job(r0);
    }

    public static final void cancel(Job r0, String r1, Throwable r2) {
        r0.cancel(u0.a(r1, r2));
    }

    /* JADX INFO: renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ Job m201Job$default(Job r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return m200Job(r0);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return cancel(r0, r1);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        cancelChildren(r0, r1);
    }

    public static final m0 invokeOnCompletion(Job r1, boolean r2, boolean r3, z0 r4) {
        if ((r1 instanceof JobSupport) == false) goto L6;
        return ((JobSupport) r1).Q(r2, r3, r4);
    L6:
        return r1.invokeOnCompletion(r2, r3, new JobKt__JobKt.invokeOnCompletion.1(r4));
    }

    public static /* synthetic */ void cancel$default(CoroutineContext r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        cancel(r0, r1);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        cancelChildren(r0, r1);
    }

    public static /* synthetic */ void cancelChildren$default(Job r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        cancelChildren(r0, r1);
    }

    public static /* synthetic */ void cancelChildren$default(Job r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        cancelChildren(r0, r1);
    }

    public static /* synthetic */ void cancel$default(Job r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        cancel(r0, r1, r2);
    }

    public static /* synthetic */ m0 invokeOnCompletion$default(Job r0, boolean r1, boolean r2, z0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = true;
    L9:
        return invokeOnCompletion(r0, r1, r2, r3);
    }
}
