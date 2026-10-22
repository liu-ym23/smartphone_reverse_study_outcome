package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492074a = null;
    private volatile /* synthetic */ Object _closeWaitJob;
    private volatile /* synthetic */ int closed;

    static {
        f492074a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeWaitJob");
    }

    public final Object a(Continuation<? super Unit> r100) {
        if (this.closed == 1) goto L5;
    L6:
        Job r101 = (Job) this._closeWaitJob;
        if (r101 != null) goto L21;
        CompletableJob r102 = JobKt.Job$default(null, 1, null);
        AtomicReferenceFieldUpdater r103 = f492074a;
    L11:
        if (r103.compareAndSet(this, null, r102) == true) goto L12;
        if (r103.get(this) == null) goto L11;
        boolean r104 = false;
    L16:
        if (r104 == false) goto L6;
        if (this.closed != 1) goto L20;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L20:
        r101 = r102;
        goto L21
    L12:
        r104 = true;
    L21:
        Object r105 = r101.join(r100);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r105;
    L25:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
