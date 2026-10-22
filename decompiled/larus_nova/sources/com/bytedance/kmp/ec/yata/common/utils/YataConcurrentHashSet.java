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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003B\u0015\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0006\u0010\u001a\u001a\u00020\u0014J\u0013\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\u00142\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140 H\u0086\bø\u0001\u0000J\u0006\u0010!\u001a\u00020\u001cJ\u0013\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010#\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000$J\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000$J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/utils/YataConcurrentHashSet;", ExifInterface.LONGITUDE_EAST, "Ljava/io/Serializable;", "Lcom/bytedance/kmp/ec/yata/common/platform/YataJavaSerializable;", "set", "", "(Ljava/util/Set;)V", "lock", "Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "getLock", "()Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "getSet$annotations", "()V", "getSet", "()Ljava/util/Set;", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "clear", "contains", "", "(Ljava/lang/Object;)Z", "forEach", "action", "Lkotlin/Function1;", "isEmpty", "remove", "removeAll", "", "toMutableSet", "toSet", "toString", "", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class YataConcurrentHashSet<E> implements Serializable {
    private final YataPlatformReadWriteLock lock;
    private final Set<E> set;

    /* JADX WARN: Multi-variable type inference failed */
    public YataConcurrentHashSet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "不可以直接使用，必须走封装的API")
    public static /* synthetic */ void getSet$annotations() {
    }

    public final void clear() {
        ReentrantReadWriteLock r100 = this.lock.getLock();
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
        this.set.clear();     // Catch: Throwable -> L15
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
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        int r101 = this.set.size();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final boolean isEmpty() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        boolean r101 = this.set.isEmpty();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final Set<E> toMutableSet() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        Set<E> r101 = CollectionsKt.toMutableSet(this.set);     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final Set<E> toSet() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        Set<E> r101 = CollectionsKt.toSet(this.set);     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public String toString() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        String r101 = this.set.toString();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final YataPlatformReadWriteLock getLock() {
        return this.lock;
    }

    public final Set<E> getSet() {
        return this.set;
    }

    public YataConcurrentHashSet(Set<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "set");
        this.set = r100;
        this.lock = new YataPlatformReadWriteLock();
    }

    public final void add(E r100) {
        ReentrantReadWriteLock r101 = this.lock.getLock();
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
        this.set.add(r100);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r103 >= r104) goto L18;
        r102.lock();
        r103 = r103 + 1;
        goto L16
    L18:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public final void addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        ReentrantReadWriteLock r101 = this.lock.getLock();
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
        this.set.addAll(r100);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r103 >= r104) goto L18;
        r102.lock();
        r103 = r103 + 1;
        goto L16
    L18:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public final boolean contains(E r100) {
        ReentrantReadWriteLock.ReadLock r101 = this.lock.getLock().readLock();
        r101.lock();
        boolean r102 = this.set.contains(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void forEach(Function1<? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ReentrantReadWriteLock.ReadLock r101 = getLock().getLock().readLock();
        r101.lock();
        Iterator<E> r102 = getSet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        r100.invoke(r102.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r101.unlock();
        InlineMarker.finallyEnd(1);
        return;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r101.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void remove(E r100) {
        ReentrantReadWriteLock r101 = this.lock.getLock();
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
        this.set.remove(r100);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r103 >= r104) goto L18;
        r102.lock();
        r103 = r103 + 1;
        goto L16
    L18:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public final void removeAll(Set<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        ReentrantReadWriteLock r101 = this.lock.getLock();
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
        this.set.removeAll(r100);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r103 >= r104) goto L18;
        r102.lock();
        r103 = r103 + 1;
        goto L16
    L18:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public /* synthetic */ YataConcurrentHashSet(Set r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new LinkedHashSet();
    L5:
        this(r100);
    }
}
