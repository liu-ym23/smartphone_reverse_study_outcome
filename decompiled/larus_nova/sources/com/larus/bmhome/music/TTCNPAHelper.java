package com.larus.bmhome.music;

import com.larus.platform.service.k3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class TTCNPAHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TTCNPAHelper f312711a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f312712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CompletableDeferred<Unit> f312713c;

    public TTCNPAHelper() {
    }

    static {
        f312711a = new TTCNPAHelper();
        f312712b = kotlinx.coroutines.sync.b.a();
    }

    public final Object a(Continuation<? super Unit> r110) {
        if ((r110 instanceof TTCNPAHelper$initTTCNPA$1) == false) goto L7;
        TTCNPAHelper$initTTCNPA$1 r100 = (TTCNPAHelper$initTTCNPA$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L31:
        final CompletableDeferred<Unit> r112 = f312713c;     // Catch: Throwable -> L28
        if (r112 != null) goto L23;
        r112 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L28
        f312713c = r112;     // Catch: Throwable -> L28
        k3.f365757a.a("001191110102MACQD9K64010000", "", new a(), new b(r112));     // Catch: Throwable -> L28
    L23:
        r104.unlock(null);
        r100.L$0 = null;
        r100.label = 2;
        if (r112.await(r100) != r102) goto L27;
        return r102;
    L28:
        th = move-exception;
        r104.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r111);
        r104 = f312712b;
        r100.L$0 = r104;
        r100.label = 1;
        if (r104.a(null, r100) != r102) goto L31;
        return r102;
    L7:
        r100 = new TTCNPAHelper$initTTCNPA$1(this, r110);
        goto L8
    }
}
