package com.bytedance.platform.thread;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes21.dex */
public final class MainLooperIdleQueue implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<String> f266621c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<MessageQueue.IdleHandler> f266622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Field f266623b;

    public static class ProxyArrayList extends ArrayList<MessageQueue.IdleHandler> {
        public ProxyArrayList() {
        }

        public boolean add(MessageQueue.IdleHandler r100) {
            if ((r100 instanceof MainLooperIdleQueue) == true) goto L5;
            String r101 = r100.getClass().getName();
            Iterator<String> r102 = MainLooperIdleQueue.f266621c.iterator();
        L11:
            if (r102.hasNext() == false) goto L15;
            if (r101.startsWith(r102.next()) == false) goto L11;
            boolean r103 = true;
        L16:
            if (r103 == true) goto L18;
            MainLooperIdleQueue r104 = a.f266624a;
            monitor-enter(r104);
            ((LinkedList) r104.f266622a).add(r100);     // Catch: Throwable -> L24
            monitor-exit(r104);     // Catch: Throwable -> L24
            return true;
        L24:
            th = move-exception;
            throw th;
        L18:
            return super.add(r100);
        L15:
            r103 = false;
            goto L16
        L5:
            if (contains(r100) == false) goto L7;
            return true;
        L7:
            return super.add(r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r100) {
            if ((r100 instanceof MainLooperIdleQueue) == false) goto L5;
            return true;
        L5:
            ArrayList<String> r101 = MainLooperIdleQueue.f266621c;
            MainLooperIdleQueue r102 = a.f266624a;
            MessageQueue.IdleHandler r103 = (MessageQueue.IdleHandler) r100;
            monitor-enter(r102);
            ((LinkedList) r102.f266622a).remove(r103);     // Catch: Throwable -> L10
            monitor-exit(r102);     // Catch: Throwable -> L10
            return true;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public /* bridge */ /* synthetic */ boolean add(Object r100) {
            return add((MessageQueue.IdleHandler) r100);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MainLooperIdleQueue f266624a = null;

        static {
            f266624a = new MainLooperIdleQueue();
        }
    }

    public final long a() {
        monitor-enter(this);
        Object r100 = this.f266623b.get(Looper.myQueue());     // Catch: Throwable -> L10 IllegalAccessException -> L12
        if (r100 == null) goto L7;
        long r101 = ((Message) r100).getWhen();     // Catch: Throwable -> L10 IllegalAccessException -> L12
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
        return r101;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L10
        return Long.MIN_VALUE;
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        r101 = 0;
        goto L14
    }

    static {
        f266621c = new ArrayList();
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        if (this.f266623b == null) goto L38;
    L9:
        long r100 = a();
        if ((r100 - SystemClock.uptimeMillis()) <= 0) goto L12;
    L13:
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L15:
        if (this.f266622a.isEmpty() == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L35
        return true;
    L18:
        MessageQueue.IdleHandler r101 = (MessageQueue.IdleHandler) ((LinkedList) this.f266622a).poll();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        boolean r102 = r101.queueIdle();
        long r103 = SystemClock.uptimeMillis();
        long r104 = a();
        if (r104 <= 0) goto L24;
        r100 = r104;
    L24:
        if (r100 <= 0) goto L26;
        int r105 = (r103 > r100 ? 1 : (r103 == r100 ? 0 : -1));
    L26:
        if (r102 == false) goto L31;
        monitor-enter(this);
        ((LinkedList) this.f266622a).offer(r101);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L31:
        return true;
    L12:
        if (r100 != Long.MIN_VALUE) goto L31;
    L38:
        this.f266623b = MessageQueue.class.getDeclaredField("mMessages");     // Catch: NoSuchFieldException -> L6
    L8:
        this.f266623b.setAccessible(true);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public MainLooperIdleQueue() {
        this.f266622a = new LinkedList();
        f266621c.add("android");
    }
}
