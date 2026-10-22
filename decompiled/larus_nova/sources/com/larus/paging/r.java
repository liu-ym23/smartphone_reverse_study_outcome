package com.larus.paging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f363911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f363912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f363913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<T> f363914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f363915e;

    public final void a() {
        if (this.f363915e == false) goto L5;
        return;
    L5:
        ReentrantLock r100 = this.f363913c;
        r100.lock();
    L19:
        th = move-exception;
        r100.unlock();
        throw th;
    L7:
        if (this.f363915e == false) goto L11;
        r100.unlock();
        return;
    L11:
        this.f363915e = true;     // Catch: Throwable -> L19
        List r101 = CollectionsKt.toList(this.f363914d);     // Catch: Throwable -> L19
        ((ArrayList) this.f363914d).clear();     // Catch: Throwable -> L19
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r100.unlock();
        if (r101 == null) goto L18;
        Function1<T, Unit> r103 = this.f363911a;
        Iterator<T> r104 = r101.iterator();
    L16:
        if (r104.hasNext() == false) goto L25;
        r103.invoke(r104.next());
        goto L16
    L25:
        return;
    }

    public final void b(T r100) {
        Function0<Boolean> r101 = this.f363912b;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        a();
    L11:
        if (this.f363915e == false) goto L14;
        this.f363911a.invoke(r100);
        return;
    L14:
        ReentrantLock r104 = this.f363913c;
        r104.lock();
    L23:
        th = move-exception;
        r104.unlock();
        throw th;
    L16:
        if (this.f363915e == false) goto L18;
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r102 = true;
    L19:
        r104.unlock();
        if (r102 == false) goto L27;
        this.f363911a.invoke(r100);
        return;
    L27:
        return;
    L18:
        ((ArrayList) this.f363914d).add(r100);     // Catch: Throwable -> L23
        goto L19
    L5:
        if (r101.invoke().booleanValue() != true) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function1<? super T, Unit> r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "callbackInvoker");
        this.f363911a = r100;
        this.f363912b = r101;
        this.f363913c = new ReentrantLock();
        this.f363914d = new ArrayList();
    }
}
