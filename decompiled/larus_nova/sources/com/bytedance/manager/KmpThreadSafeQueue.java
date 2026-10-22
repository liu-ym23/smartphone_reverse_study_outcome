package com.bytedance.manager;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class KmpThreadSafeQueue<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f265471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f265472b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        ReentrantLock r100 = this.f265472b;
        r100.lock();
        ((ArrayList) this.f265471a).clear();     // Catch: Throwable -> L6
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r100.unlock();
        return;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public KmpThreadSafeQueue() {
        this.f265471a = new ArrayList();
        this.f265472b = new ReentrantLock();
    }

    public final void b(Object r100) {
        ReentrantLock r101 = this.f265472b;
        r101.lock();
        ((ArrayList) this.f265471a).add(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0066 -> B:26:0x0069). Please report as a decompilation issue!!! */
    public final Object c(Continuation<? super T> r110) {
        if ((r110 instanceof KmpThreadSafeQueue$take$1) == false) goto L7;
        KmpThreadSafeQueue$take$1 r100 = (KmpThreadSafeQueue$take$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        ResultKt.throwOnFailure(r111);
        KmpThreadSafeQueue<T> r112 = this;
    L27:
        if ((r104 % 1000) == 0) goto L28;
    L15:
        ReentrantLock r105 = r112.f265472b;
        r105.lock();
    L29:
        th = move-exception;
        r105.unlock();
        throw th;
    L17:
        if (((ArrayList) r112.f265471a).isEmpty() == false) goto L19;
        Object r106 = null;
    L20:
        r105.unlock();
        if (r106 == null) goto L23;
        return r106;
    L23:
        r104 = r104 + ((long) 10);
        r100.J$0 = r104;
        r100.label = 1;
        if (DelayKt.delay(10, r100) != r102) goto L27;
        return r102;
    L19:
        r106 = CollectionsKt.removeFirst(r112.f265471a);     // Catch: Throwable -> L29
        goto L20
    L28:
        IKMPLoggerService r107 = lp7.a.f510233a;
        lp7.a.d("KmpThreadSafeQueue", "sleep too long. may be some err happened! totalSleepTime=" + r104);
        goto L15
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r112 = this;
        r104 = 0;
    L7:
        r100 = new KmpThreadSafeQueue$take$1(this, r110);
        goto L8
    }
}
