package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0006\n\u0002\u0010)\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 0*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u00010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u001e\u0010\u0013\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0003¢\u0006\u0002\u0010\rJ\u001f\u0010\u0014\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u0010H\u0096\u0001J9\u0010\u0015\u001a\u00020\u00062.\u0010\u0016\u001a*\u0012\u000e\b\u0000\u0012\n \f*\u0004\u0018\u00018\u00008\u0000 \f*\u0014\u0012\u000e\b\u0000\u0012\n \f*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00170\u0017H\u0096\u0001JA\u0010\u0015\u001a\u00020\u00062.\u0010\u0016\u001a*\u0012\u000e\b\u0000\u0012\n \f*\u0004\u0018\u00018\u00008\u0000 \f*\u0014\u0012\u000e\b\u0000\u0012\n \f*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00170\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0096\u0001J\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0002\b\u001bJ\t\u0010\u001c\u001a\u00020\nH\u0096\u0001J\u0017\u0010\u001d\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u001eH\u0096\u0003J\u001e\u0010\u001f\u001a\u00020\n2\u000e\u0010\u0016\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\rJ6\u0010\u001f\u001a\u00020\n2\u000e\u0010\u0016\u001a\n \f*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u0018\u001a\u00020 2\u000e\u0010!\u001a\n \f*\u0004\u0018\u00010\"0\"H\u0096\u0001¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0097\u0001¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0097\u0001¢\u0006\u0002\u0010\u0019J!\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010*J\t\u0010+\u001a\u00020\u0006H\u0096\u0001J\u0016\u0010,\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0019J\u001e\u0010,\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\rJ\u001f\u0010-\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u0010H\u0096\u0001J\u001f\u0010.\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u0010H\u0096\u0001J\u000f\u0010/\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u00061"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/BlockingQueueProxy;", "E", "Ljava/util/concurrent/BlockingQueue;", "mDelegate", "(Ljava/util/concurrent/BlockingQueue;)V", "size", XmlPullParser.NO_NAMESPACE, "getSize", "()I", "add", XmlPullParser.NO_NAMESPACE, "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", XmlPullParser.NO_NAMESPACE, "clear", XmlPullParser.NO_NAMESPACE, "contains", "containsAll", "drainTo", "p0", XmlPullParser.NO_NAMESPACE, "p1", "()Ljava/lang/Object;", "getDelegate", "getDelegate$threadpool_plugin_base_release", "isEmpty", "iterator", XmlPullParser.NO_NAMESPACE, "offer", XmlPullParser.NO_NAMESPACE, "p2", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/Object;JLjava/util/concurrent/TimeUnit;)Z", "peek", "poll", "timeout", "unit", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;)V", "remainingCapacity", "remove", "removeAll", "retainAll", "take", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final class BlockingQueueProxy<E> implements BlockingQueue<E> {
    public static final Companion Companion = null;
    private final BlockingQueue<E> mDelegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0001\u0010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/BlockingQueueProxy$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "proxy", "Ljava/util/concurrent/BlockingQueue;", "E", "delegate", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final <E> BlockingQueue<E> proxy(BlockingQueue<E> r2) {
            if (r2 != null) goto L4;
        L8:
            return r2;
        L4:
            if ((r2 instanceof BlockingQueueProxy) == true) goto L8;
            return new BlockingQueueProxy(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BlockingQueueProxy(BlockingQueue<E> r1) {
        this.mDelegate = r1;
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(E r2) {
        return this.mDelegate.add(r2);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> r2) {
        return this.mDelegate.addAll(r2);
    }

    @Override // java.util.Collection
    public void clear() {
        this.mDelegate.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object r2) {
        return this.mDelegate.contains(r2);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r2) {
        return this.mDelegate.containsAll(r2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r2) {
        return this.mDelegate.drainTo(r2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r2, int r3) {
        return this.mDelegate.drainTo(r2, r3);
    }

    @Override // java.util.Queue
    public E element() {
        return this.mDelegate.element();
    }

    public final BlockingQueue<E> getDelegate$threadpool_plugin_base_release() {
        BlockingQueue<E> r0 = this.mDelegate;
        if ((r0 instanceof BlockingQueueProxy) == true) goto L5;
        return r0;
    L5:
        return ((BlockingQueueProxy) r0).getDelegate$threadpool_plugin_base_release();
    }

    public int getSize() {
        return this.mDelegate.size();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.mDelegate.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(E r2) {
        return this.mDelegate.offer(r2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E r2, long r3, TimeUnit r5) {
        return this.mDelegate.offer(r2, r3, r5);
    }

    @Override // java.util.Queue
    public E peek() {
        return this.mDelegate.peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return this.mDelegate.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long r2, TimeUnit r4) {
        if (SuperThreadPool.INSTANCE.getEnableBlockFetchTask() == true) goto L7;
        return poll();
    L7:
        return this.mDelegate.poll(r2, r4);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E r2) {
        this.mDelegate.put(r2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.mDelegate.remainingCapacity();
    }

    @Override // java.util.Queue
    public E remove() {
        return this.mDelegate.remove();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object r2) {
        return this.mDelegate.remove(r2);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> r2) {
        return this.mDelegate.removeAll(r2);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> r2) {
        return this.mDelegate.retainAll(r2);
    }

    @Override // java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() {
        if (SuperThreadPool.INSTANCE.getEnableBlockFetchTask() == true) goto L7;
        return poll();
    L7:
        return this.mDelegate.take();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) CollectionToArray.toArray(this, r1);
    }
}
