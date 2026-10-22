package com.bytedance.kmp.ec.yata.common.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.kmp.ec.yata.common.platform.YataPlatformReadWriteLock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J \u0010\u0017\u001a\u00020\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\bø\u0001\u0000J\u0006\u0010\u001a\u001a\u00020\u000eJ\u0013\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0014\u0010\u001c\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/utils/YataCopyOnWriteSet;", ExifInterface.LONGITUDE_EAST, "Ljava/io/Serializable;", "Lcom/bytedance/kmp/ec/yata/common/platform/YataJavaSerializable;", "()V", "size", "", "getSize", "()I", "snapshotRef", "", "writeLock", "Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", SlcElement.KEY_ELEMENTS, "", "clear", "", "contains", "forEach", "action", "Lkotlin/Function1;", "isEmpty", "remove", "removeAll", "snapshot", "toString", "", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class YataCopyOnWriteSet<E> implements Serializable {
    private volatile Set<? extends E> snapshotRef;
    private final YataPlatformReadWriteLock writeLock;

    public final void clear() {
        ReentrantReadWriteLock r100 = this.writeLock.getLock();
        ReentrantReadWriteLock.ReadLock r101 = r100.readLock();
        int r102 = 0;
        if (r100.getWriteHoldCount() != 0) goto L5;
        int r103 = r100.getReadHoldCount();
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r101.unlock();
        r104 = r104 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r105 = r100.writeLock();
        r105.lock();
        this.snapshotRef = SetsKt.emptySet();     // Catch: Throwable -> L15
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r102 >= r103) goto L13;
        r101.lock();
        r102 = r102 + 1;
        goto L11
    L13:
        r105.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r102 >= r103) goto L18;
        r101.lock();
        r102 = r102 + 1;
        goto L16
    L18:
        r105.unlock();
        throw th;
    L5:
        r103 = 0;
        goto L6
    }

    public final int getSize() {
        return this.snapshotRef.size();
    }

    public final boolean isEmpty() {
        return this.snapshotRef.isEmpty();
    }

    public String toString() {
        return this.snapshotRef.toString();
    }

    public YataCopyOnWriteSet() {
        this.writeLock = new YataPlatformReadWriteLock();
        this.snapshotRef = SetsKt.emptySet();
    }

    public final Set<E> snapshot() {
        return this.snapshotRef;
    }

    public final boolean add(E r100) {
        ReentrantReadWriteLock r101 = this.writeLock.getLock();
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L5;
        int r104 = r101.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
        Set<? extends E> r107 = this.snapshotRef;     // Catch: Throwable -> L18
        if (r107.contains(r100) == false) goto L13;
        boolean r108 = false;
    L14:
        if (r103 >= r104) goto L16;
        r102.lock();
        r103 = r103 + 1;
        goto L14
    L16:
        r106.unlock();
        return r108;
    L13:
        r108 = true;
        LinkedHashSet r109 = new LinkedHashSet(r107.size() + 1);     // Catch: Throwable -> L18
        r109.addAll(r107);     // Catch: Throwable -> L18
        r109.add(r100);     // Catch: Throwable -> L18
        this.snapshotRef = r109;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
    L19:
        if (r103 >= r104) goto L21;
        r102.lock();
        r103 = r103 + 1;
        goto L19
    L21:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public final boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = 0;
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        ReentrantReadWriteLock r102 = this.writeLock.getLock();
        ReentrantReadWriteLock.ReadLock r103 = r102.readLock();
        if (r102.getWriteHoldCount() != 0) goto L8;
        int r104 = r102.getReadHoldCount();
    L9:
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L12;
        r103.unlock();
        r105 = r105 + 1;
        goto L10
    L12:
        ReentrantReadWriteLock.WriteLock r106 = r102.writeLock();
        r106.lock();
        Set<? extends E> r107 = this.snapshotRef;     // Catch: Throwable -> L20
        LinkedHashSet r108 = new LinkedHashSet(r107.size() + r100.size());     // Catch: Throwable -> L20
        r108.addAll(r107);     // Catch: Throwable -> L20
        boolean r109 = r108.addAll(r100);     // Catch: Throwable -> L20
        if (r109 == false) goto L16;
        this.snapshotRef = r108;     // Catch: Throwable -> L20
    L16:
        if (r101 >= r104) goto L18;
        r103.lock();
        r101 = r101 + 1;
        goto L16
    L18:
        r106.unlock();
        return r109;
    L20:
        th = move-exception;
    L21:
        if (r101 >= r104) goto L23;
        r103.lock();
        r101 = r101 + 1;
        goto L21
    L23:
        r106.unlock();
        throw th;
    L8:
        r104 = 0;
        goto L9
    }

    public final boolean contains(E r100) {
        return this.snapshotRef.contains(r100);
    }

    public final void forEach(Function1<? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Iterator<E> r101 = snapshot().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    public final boolean remove(E r100) {
        ReentrantReadWriteLock r101 = this.writeLock.getLock();
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L5;
        int r104 = r101.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
        Set<? extends E> r107 = this.snapshotRef;     // Catch: Throwable -> L25
        if (r107.contains(r100) == true) goto L13;
        boolean r108 = false;
    L21:
        if (r103 >= r104) goto L23;
        r102.lock();
        r103 = r103 + 1;
        goto L21
    L23:
        r106.unlock();
        return r108;
    L13:
        LinkedHashSet r109 = new LinkedHashSet(r107.size());     // Catch: Throwable -> L25
        Iterator<? extends E> r110 = r107.iterator();     // Catch: Throwable -> L25
    L15:
        if (r110.hasNext() == false) goto L19;
        E r111 = r110.next();     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r111, r100) == true) goto L15;
        r109.add(r111);     // Catch: Throwable -> L25
        goto L15
    L19:
        this.snapshotRef = r109;     // Catch: Throwable -> L25
        r108 = true;
    L25:
        th = move-exception;
    L26:
        if (r103 >= r104) goto L28;
        r102.lock();
        r103 = r103 + 1;
        goto L26
    L28:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public final boolean removeAll(Set<? extends E> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        int r100 = 0;
        if (r110.isEmpty() == false) goto L5;
        return false;
    L5:
        ReentrantReadWriteLock r101 = this.writeLock.getLock();
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        if (r101.getWriteHoldCount() != 0) goto L8;
        int r103 = r101.getReadHoldCount();
    L9:
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        r102.unlock();
        r104 = r104 + 1;
        goto L10
    L12:
        ReentrantReadWriteLock.WriteLock r105 = r101.writeLock();
        r105.lock();
        Set<? extends E> r106 = this.snapshotRef;     // Catch: Throwable -> L29
        if (r106.isEmpty() == false) goto L16;
        boolean r107 = false;
    L25:
        if (r100 >= r103) goto L27;
        r102.lock();
        r100 = r100 + 1;
        goto L25
    L27:
        r105.unlock();
        return r107;
    L16:
        LinkedHashSet r108 = new LinkedHashSet(r106.size());     // Catch: Throwable -> L29
        Iterator<? extends E> r109 = r106.iterator();     // Catch: Throwable -> L29
        r107 = false;
    L18:
        if (r109.hasNext() == false) goto L23;
        E r111 = r109.next();     // Catch: Throwable -> L29
        if (r110.contains(r111) == true) goto L21;
        r108.add(r111);     // Catch: Throwable -> L29
        goto L18
    L21:
        r107 = true;
        goto L18
    L23:
        if (r107 == false) goto L25;
        this.snapshotRef = r108;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
    L30:
        if (r100 >= r103) goto L32;
        r102.lock();
        r100 = r100 + 1;
        goto L30
    L32:
        r105.unlock();
        throw th;
    L8:
        r103 = 0;
        goto L9
    }
}
