package com.bytedance.platform.godzilla.anr.sp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import o57.a;
import o57.c;

/* JADX INFO: loaded from: classes21.dex */
public class LinkedListProxyForWorks<E> extends LinkedList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f266613a = null;
    private LinkedList<Runnable> mRealList;

    static {
        f266613a = new Object();
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L10;
        Handler r100 = c.f522102a;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.hasMessages(1) == true) goto L21;
        Message r101 = Message.obtain(c.f522102a);
        r101.what = 1;
        new Handler().post(new a(r101));
        return;
    L21:
        return;
    L10:
        Object r102 = f266613a;
        monitor-enter(r102);
        this.mRealList.clear();     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList
    public Object clone() {
        super.clone();
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
        Object r100 = f266613a;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList(this.mRealList);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L11:
        th = move-exception;
        throw th;
    L5:
        return new LinkedList();
    }

    public LinkedListProxyForWorks(LinkedList<Runnable> r100) {
        this.mRealList = r100;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r100) {
        Object r101 = f266613a;
        monitor-enter(r101);
        boolean r102 = this.mRealList.add((Runnable) r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }
}
