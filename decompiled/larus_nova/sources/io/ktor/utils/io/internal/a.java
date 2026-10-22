package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492065a = null;
    private volatile /* synthetic */ Object suspension;

    static {
        f492065a = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "suspension");
    }

    public a() {
        this.suspension = null;
    }

    public final Object a(Continuation r100) {
        if ((r100 instanceof AwaitingSlot$trySuspend$1) == false) goto L7;
        AwaitingSlot$trySuspend$1 r101 = (AwaitingSlot$trySuspend$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r106 = r101.I$0;
        ResultKt.throwOnFailure(r103);
    L23:
        if (r106 != 0) goto L27;
        r105 = false;
    L27:
        return Boxing.boxBoolean(r105);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        CompletableJob r107 = JobKt.Job$default(null, 1, null);
        AtomicReferenceFieldUpdater r108 = f492065a;
    L16:
        if (r108.compareAndSet(this, null, r107) == true) goto L17;
        if (r108.get(this) == null) goto L16;
        boolean r109 = false;
    L21:
        if (r109 == true) goto L28;
        r106 = 0;
        goto L23
    L28:
        throw null;
    L17:
        r109 = true;
    L7:
        r101 = new AwaitingSlot$trySuspend$1(this, r100);
        goto L8
    }
}
