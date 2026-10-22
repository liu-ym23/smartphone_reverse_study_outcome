package org.jetbrains.compose.resources;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes42.dex */
public final class AsyncCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutexImpl f525827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<K, Deferred<V>> f525828b;

    public AsyncCache() {
        this.f525827a = kotlinx.coroutines.sync.b.a();
        this.f525828b = new LinkedHashMap();
        List<AsyncCache<?, ?>> r100 = o.f525845a;
        Intrinsics.checkNotNullParameter(this, "cache");
        ((ArrayList) o.f525845a).add(this);
    }

    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof AsyncCache$clear$1) == false) goto L7;
        AsyncCache$clear$1 r101 = (AsyncCache$clear$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        ((LinkedHashMap) this.f525828b).clear();     // Catch: Throwable -> L21
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r106.unlock(null);
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        MutexImpl r108 = this.f525827a;
        r101.L$0 = r108;
        r101.label = 1;
        if (r108.a(null, r101) != r104) goto L17;
        return r104;
    L17:
        r106 = r108;
    L7:
        r101 = new AsyncCache$clear$1(this, r100);
        goto L8
    }
}
