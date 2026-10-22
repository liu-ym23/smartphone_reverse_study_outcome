package com.ss.android.lark.chat.core.model;

import android.os.Looper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.ExceptionsKt;
import x4b.e;
import x4b.f;
import x4b.g;
import x4b.h;

/* JADX INFO: loaded from: classes35.dex */
public class ObservableMappedArrayList<K, T> extends ArrayList<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient d.a f414751a;
    private a mAccessTracker;
    private b<K, T> mItemKey;
    private Map<K, Integer> mPositionMap;
    private ReentrantReadWriteLock mReadWriteLock;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f414752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f414753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f414754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f414755d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f414756e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f414757f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f414758g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f414759h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f414760i;

        public final void a() {
            if (this.f414755d == true) goto L6;
            return;
        L6:
            if (ThreadMethodProxy.currentThread() == this.f414753b) goto L8;
            return;
        L8:
            if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != this.f414753b) goto L17;
            long r100 = System.nanoTime() - this.f414754c;
            this.f414756e += r100;
            this.f414757f++;
            if (r100 <= this.f414759h) goto L13;
            this.f414759h = r100;
            this.f414758g = this.f414752a;
        L13:
            if ((System.currentTimeMillis() - this.f414760i) <= 30000) goto L18;
            Log.w("ObservableList", String.format("avg: %.3fms, count: %d, max: %.3fms, scense: %s", new Object[]{Float.valueOf(((this.f414756e / ((long) this.f414757f)) * 1.0f) / 1000000.0f), Integer.valueOf(this.f414757f), Float.valueOf((this.f414759h * 1.0f) / 1000000.0f), this.f414758g}));
            this.f414756e = 0;
            this.f414757f = 0;
            this.f414758g = null;
            this.f414759h = 0;
            this.f414760i = System.currentTimeMillis();
            return;
        L18:
            return;
        }

        public a(boolean r100) {
            this.f414756e = 0;
            this.f414757f = 0;
            this.f414755d = r100;
        }
    }

    public interface b<K, T> {
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void acquireReadAccess() {
        if (this.mReadWriteLock == null) goto L10;
        Log.d("ObservableList", "acquireReadAccess: thread: " + ThreadMethodProxy.currentThread().getName() + " stack: " + ExceptionsKt.stackTraceToString(new Exception()));
        a r100 = this.mAccessTracker;
        if (r100.f414755d == false) goto L8;
        r100.f414754c = System.nanoTime();
        r100.f414752a = "acquireReadAccess";
        r100.f414753b = ThreadMethodProxy.currentThread();
    L8:
        this.mReadWriteLock.readLock().lock();
        return;
    }

    public void beginUpdate() {
        ReentrantReadWriteLock r100 = this.mReadWriteLock;
        if (r100 == null) goto L5;
        r100.writeLock().lock();
    L5:
        d.a r101 = this.f414751a;
        if (r101 == null) goto L9;
        ((com.ss.android.lark.chat.core.model.b) r101).e();
        return;
    }

    public void finishUpdate() {
        d.a r100 = this.f414751a;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        ((com.ss.android.lark.chat.core.model.b) r100).f();     // Catch: Throwable -> L9
    L5:
        ReentrantReadWriteLock r101 = this.mReadWriteLock;
        if (r101 == null) goto L16;
        r101.writeLock().unlock();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        ReentrantReadWriteLock r102 = this.mReadWriteLock;
        if (r102 == null) goto L13;
        r102.writeLock().unlock();
    L13:
        throw th;
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void releaseReadAccess() {
        if (this.mReadWriteLock == null) goto L6;
        Log.d("ObservableList", "releaseReadAccess: thread: " + ThreadMethodProxy.currentThread().getName() + " stack: " + ExceptionsKt.stackTraceToString(new Exception()));
        this.mReadWriteLock.readLock().unlock();
        this.mAccessTracker.a();
        return;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r100 = size();
        super.clear();
        this.mPositionMap.clear();
        if (r100 == 0) goto L6;
        f(0, r100);
        return;
    }

    public ObservableMappedArrayList(b<K, T> r100) {
        this(r100, false, false);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T r100) {
        super.add(r100);
        int r101 = size() - 1;
        Map<K, Integer> r102 = this.mPositionMap;
        Object r103 = ((BasePageStore.b) this.mItemKey).a(r100);
        K r104 = (K) r103;
        r102.put(r104, Integer.valueOf(r101));
        d.a r105 = this.f414751a;
        if (r105 == null) goto L5;
        ((com.ss.android.lark.chat.core.model.b) r105).d(this, r101, 1);
    L5:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> r100) {
        int r101 = size();
        boolean r102 = super.addAll(r100);
        if (r102 == false) goto L11;
        int r103 = r101;
    L6:
        if (r103 >= size()) goto L8;
        Map<K, Integer> r104 = this.mPositionMap;
        b<K, T> r105 = this.mItemKey;
        BasePageStore.b r106 = (BasePageStore.b) r105;
        Object r107 = r106.a(get(r103));
        K r108 = (K) r107;
        r104.put(r108, Integer.valueOf(r103));
        r103 = r103 + 1;
        goto L6
    L8:
        int r109 = size() - r101;
        d.a r110 = this.f414751a;
        if (r110 == null) goto L11;
        ((com.ss.android.lark.chat.core.model.b) r110).d(this, r101, r109);
    L11:
        return r102;
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void addOnListUpdateCallback(d.a r100) {
        this.f414751a = r100;
    }

    public boolean containsKey(final K... r100) {
        return ((Boolean) g("containsKey", new h(this, r100))).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsValue(T r100) {
        return containsKey(new Object[]{((BasePageStore.b) this.mItemKey).a(r100)});
    }

    public T getItemByKey(final K... r100) {
        return (T) g("getItemByKey", new f(this, r100));
    }

    public int getItemPosByKey(final K... r100) {
        return ((Integer) g("getItemPosByKey", new e(this, r100))).intValue();
    }

    public List<T> getItemsByKey(final Collection<K> r100) {
        final ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L9;
        return (List) g("getItemsByKey", new g(this, r100, r101));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int r100) {
        T r101 = (T) super.remove(r100);
        this.mPositionMap.remove(((BasePageStore.b) this.mItemKey).a(r101));
        if (this.mPositionMap.size() == size()) goto L5;
        this.mPositionMap.clear();
        int r102 = 0;
    L7:
        if (r102 >= size()) goto L9;
        Map<K, Integer> r103 = this.mPositionMap;
        b<K, T> r104 = this.mItemKey;
        BasePageStore.b r105 = (BasePageStore.b) r104;
        Object r106 = r105.a(get(r102));
        K r107 = (K) r106;
        r103.put(r107, Integer.valueOf(r102));
        r102 = r102 + 1;
        goto L7
    L9:
        f(r100, 1);
        return r101;
    L5:
        r102 = r100;
        goto L7
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void removeOnListUpdateCallback(d.a r100) {
        this.f414751a = null;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        int r101 = indexOf(r100);
        if (r101 < 0) goto L6;
        remove(r101);
        return true;
    L6:
        return false;
    }

    public static /* synthetic */ Integer c(ObservableMappedArrayList r100, Object[] r101) {
        r100.getClass();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r101[r103];
        if (r104 == null) goto L10;
        if (r100.mPositionMap.containsKey(r104) == false) goto L10;
        int r105 = r100.mPositionMap.get(r104).intValue();
    L13:
        return Integer.valueOf(r105);
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        r105 = -1;
        goto L13
    }

    public static /* synthetic */ Object d(ObservableMappedArrayList r100, Object[] r101) {
        r100.getClass();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r101[r103];
        if (r104 == null) goto L10;
        if (r100.mPositionMap.containsKey(r104) == false) goto L10;
        return r100.get(r100.mPositionMap.get(r104).intValue());
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return null;
    }

    public static /* synthetic */ Boolean e(ObservableMappedArrayList r100, Object[] r101) {
        r100.getClass();
        int r102 = r101.length;
        boolean r103 = false;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        Object r105 = r101[r104];
        if (r105 == null) goto L10;
        if (r100.mPositionMap.containsKey(r105) == false) goto L10;
        r103 = true;
    L10:
        r104 = r104 + 1;
    L12:
        return Boolean.valueOf(r103);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int r100, T r101) {
        super.add(r100, r101);
        int r102 = r100;
    L4:
        if (r102 >= size()) goto L6;
        Map<K, Integer> r103 = this.mPositionMap;
        b<K, T> r104 = this.mItemKey;
        BasePageStore.b r105 = (BasePageStore.b) r104;
        Object r106 = r105.a(get(r102));
        K r107 = (K) r106;
        r103.put(r107, Integer.valueOf(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        d.a r108 = this.f414751a;
        if (r108 == null) goto L11;
        ((com.ss.android.lark.chat.core.model.b) r108).d(this, r100, 1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends T> r101) {
        boolean r102 = super.addAll(r100, r101);
        if (r102 == false) goto L11;
        int r103 = r100;
    L6:
        if (r103 >= size()) goto L8;
        Map<K, Integer> r104 = this.mPositionMap;
        b<K, T> r105 = this.mItemKey;
        BasePageStore.b r106 = (BasePageStore.b) r105;
        Object r107 = r106.a(get(r103));
        K r108 = (K) r107;
        r104.put(r108, Integer.valueOf(r103));
        r103 = r103 + 1;
        goto L6
    L8:
        int r109 = r101.size();
        d.a r110 = this.f414751a;
        if (r110 == null) goto L11;
        ((com.ss.android.lark.chat.core.model.b) r110).d(this, r100, r109);
    L11:
        return r102;
    }

    public final void f(int r100, int r101) {
        d.a r102 = this.f414751a;
        if (r102 == null) goto L15;
        com.ss.android.lark.chat.core.model.b r103 = (com.ss.android.lark.chat.core.model.b) r102;
        r103.a();
        r103.f414772e = true;
        int r104 = 0;
    L5:
        if (r104 >= r101) goto L7;
        ListProtector.remove(r103.f414770c, r100);
        r104 = r104 + 1;
        goto L5
    L7:
        List<com.ss.android.lark.chat.core.model.b.a<T>> r105 = r103.f414774g;
        if (r105 != null) goto L10;
        return;
    L10:
        if (r105.isEmpty() == true) goto L19;
        Iterator<com.ss.android.lark.chat.core.model.b.a<T>> r106 = r103.f414774g.iterator();
    L13:
        if (r106.hasNext() == false) goto L20;
        r106.next().a(r103.f414770c, r100, r101);
        goto L13
    L20:
        return;
    L19:
        return;
    }

    public final <R> R g(String r100, Callable<R> r101) {
        if (this.mReadWriteLock == null) goto L23;
        Log.d("ObservableList", "threadSafeAccess: thread: " + ThreadMethodProxy.currentThread().getName() + " stack: " + ExceptionsKt.stackTraceToString(new Exception()));
        a r102 = this.mAccessTracker;
        if (r102.f414755d == false) goto L8;
        r102.f414754c = System.nanoTime();
        r102.f414752a = r100;
        r102.f414753b = ThreadMethodProxy.currentThread();
    L8:
        this.mReadWriteLock.readLock().lock();
    L23:
        R r103 = r101.call();     // Catch: Throwable -> L14 Exception -> L16
        ReentrantReadWriteLock r104 = this.mReadWriteLock;
        if (r104 == null) goto L13;
        r104.readLock().unlock();
        this.mAccessTracker.a();
    L13:
        return r103;
    L14:
        th = move-exception;
        ReentrantReadWriteLock r105 = this.mReadWriteLock;
        if (r105 == null) goto L22;
        r105.readLock().unlock();
        this.mAccessTracker.a();
    L22:
        throw th;
    L16:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L14
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r100, int r101) {
        Iterator<T> r102 = subList(r100, r101).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        T r103 = r102.next();
        this.mPositionMap.remove(((BasePageStore.b) this.mItemKey).a(r103));
        goto L4
    L6:
        super.removeRange(r100, r101);
        int r104 = r100;
    L8:
        if (r104 >= size()) goto L10;
        Map<K, Integer> r105 = this.mPositionMap;
        b<K, T> r106 = this.mItemKey;
        BasePageStore.b r107 = (BasePageStore.b) r106;
        Object r108 = r107.a(get(r104));
        K r109 = (K) r108;
        r105.put(r109, Integer.valueOf(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        f(r100, r101 - r100);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int r100, T r101) {
        T r102 = (T) super.set(r100, r101);
        this.mPositionMap.remove(((BasePageStore.b) this.mItemKey).a(r102));
        Map<K, Integer> r103 = this.mPositionMap;
        Object r104 = ((BasePageStore.b) this.mItemKey).a(r101);
        K r105 = (K) r104;
        r103.put(r105, Integer.valueOf(r100));
        d.a r106 = this.f414751a;
        if (r106 == null) goto L12;
        com.ss.android.lark.chat.core.model.b r107 = (com.ss.android.lark.chat.core.model.b) r106;
        r107.a();
        r107.f414772e = true;
        int r108 = r100 + 0;
        ListProtector.set(r107.f414770c, r108, r107.f414768a.b(get(r108)));
        List<com.ss.android.lark.chat.core.model.b.a<T>> r109 = r107.f414774g;
        if (r109 == null) goto L12;
        if (r109.isEmpty() == true) goto L12;
        Iterator<com.ss.android.lark.chat.core.model.b.a<T>> r110 = r107.f414774g.iterator();
    L10:
        if (r110.hasNext() == false) goto L12;
        r110.next().c(r107.f414770c, r100);
    L12:
        return r102;
    }

    public ObservableMappedArrayList(b<K, T> r100, boolean r101, boolean r102) {
        this.mPositionMap = new HashMap();
        this.mItemKey = r100;
        if (r101 == false) goto L5;
        this.mReadWriteLock = new ReentrantReadWriteLock(true);
    L5:
        this.mAccessTracker = new a(r102);
    }

    public static /* synthetic */ void a(ObservableMappedArrayList r100, Collection r101, List r102) {
        r100.getClass();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (r100.mPositionMap.containsKey(r104) == false) goto L4;
        r102.add(r100.get(r100.mPositionMap.get(r104).intValue()));
        goto L4
    }
}
