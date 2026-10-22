package com.bytedance.locallife.biz.monitor.param;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f256746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f256747b;

    public final void a() {
        ((ReentrantReadWriteLock) this.f256747b).writeLock().lock();
        ((ArrayList) this.f256746a).clear();     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256747b).writeLock().unlock();
        return;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256747b).writeLock().unlock();
        throw th;
    }

    public final String toString() {
        ((ReentrantReadWriteLock) this.f256747b).readLock().lock();
        int r100 = ((ArrayList) this.f256746a).size();     // Catch: Throwable -> L12
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L12
        int r102 = this.f256746a.size() - 1;     // Catch: Throwable -> L12
        if (r102 < 0) goto L9;
    L5:
        int r103 = r102 - 1;     // Catch: Throwable -> L12
        d r104 = (d) ((ArrayList) this.f256746a).get(r102);     // Catch: Throwable -> L12
        r101.add(new Pair(r104.f256726a, r104.f256727b));     // Catch: Throwable -> L12
        if (r103 < 0) goto L9;
        r102 = r103;
    L9:
        String r105 = "PageParamPageStack(size=" + r100 + ", elements=" + r101 + ')';     // Catch: Throwable -> L12
        ((ReentrantReadWriteLock) this.f256747b).readLock().unlock();
        return r105;
    L12:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256747b).readLock().unlock();
        throw th;
    }

    public e() {
        this.f256746a = new ArrayList();
        this.f256747b = new ReentrantReadWriteLock();
    }

    public final d b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageSessionId");
        ((ReentrantReadWriteLock) this.f256747b).readLock().lock();
        Iterator<T> r101 = this.f256746a.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L9;
        Object r102 = r101.next();     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(((d) r102).f256727b, r100) == false) goto L5;
    L10:
        d r103 = (d) r102;     // Catch: Throwable -> L13
        ((ReentrantReadWriteLock) this.f256747b).readLock().unlock();
        return r103;
    L9:
        r102 = null;
    L13:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256747b).readLock().unlock();
        throw th;
    }

    public final void c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "pageParams");
        ((ReentrantReadWriteLock) this.f256747b).writeLock().lock();
        ((ArrayList) this.f256746a).add(r100);     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256747b).writeLock().unlock();
        return;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256747b).writeLock().unlock();
        throw th;
    }
}
