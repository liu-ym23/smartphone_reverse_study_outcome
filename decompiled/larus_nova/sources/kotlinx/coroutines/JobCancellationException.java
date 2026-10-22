package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JobCancellationException extends CancellationException implements x<JobCancellationException> {

    /* JADX INFO: renamed from: job, reason: collision with root package name */
    public final transient Job f504598job;

    @Override // kotlinx.coroutines.x
    public JobCancellationException createCopy() {
        return null;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f504598job;
    }

    @Override // kotlinx.coroutines.x
    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return createCopy();
    }

    public int hashCode() {
        String r100 = getMessage();
        Intrinsics.checkNotNull(r100);
        int r101 = ((r100.hashCode() * 31) + this.f504598job.hashCode()) * 31;
        Throwable r102 = getCause();
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r100 instanceof JobCancellationException) == false) goto L12;
        JobCancellationException r101 = (JobCancellationException) r100;
        if (Intrinsics.areEqual(r101.getMessage(), getMessage()) == false) goto L12;
        if (Intrinsics.areEqual(r101.f504598job, this.f504598job) == false) goto L12;
        if (Intrinsics.areEqual(r101.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    public JobCancellationException(String r100, Throwable r101, Job r102) {
        super(r100);
        this.f504598job = r102;
        if (r101 == null) goto L6;
        initCause(r101);
        return;
    }
}
