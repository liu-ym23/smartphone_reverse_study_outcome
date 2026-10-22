package com.bytedance.kmp.ec.yata.common.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.kmp.ec.yata.common.platform.YataPlatformReadWriteLock;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003B\u001f\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\u0013\u0010\u0018\u001a\u00020\u00132\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/utils/YataSyncMutableList;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lcom/bytedance/kmp/ec/yata/common/platform/YataJavaSerializable;", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "lock", "Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "add", "", "element", "(Ljava/lang/Object;)V", "index", "", "(ILjava/lang/Object;)V", "clear", "contains", "", "(Ljava/lang/Object;)Z", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "isEmpty", "remove", "removeAt", "removeAtOrNull", "size", "toList", "", "toString", "", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class YataSyncMutableList<T> implements Serializable {
    private final ArrayList<T> list;
    private final YataPlatformReadWriteLock lock;

    /* JADX WARN: Multi-variable type inference failed */
    public YataSyncMutableList() {
        this(null, 1, 0 == true ? 1 : 0);
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
        this.list.clear();     // Catch: Throwable -> L15
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

    public final boolean isEmpty() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        boolean r101 = this.list.isEmpty();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final int size() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        int r101 = this.list.size();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final List<T> toList() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        ArrayList r101 = new ArrayList(this.list);     // Catch: Throwable -> L6
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
        String r101 = this.list.toString();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public YataSyncMutableList(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.list = r100;
        this.lock = new YataPlatformReadWriteLock();
    }

    public final void add(T r100) {
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
        this.list.add(r100);     // Catch: Throwable -> L15
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

    public final boolean contains(T r100) {
        ReentrantReadWriteLock.ReadLock r101 = this.lock.getLock().readLock();
        r101.lock();
        boolean r102 = this.list.contains(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final T get(int r100) {
        ReentrantReadWriteLock.ReadLock r101 = this.lock.getLock().readLock();
        r101.lock();
        T r102 = this.list.get(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final boolean remove(T r100) {
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
        boolean r107 = this.list.remove(r100);     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return r107;
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

    public final T removeAt(int r100) {
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
        T r107 = this.list.remove(r100);     // Catch: Throwable -> L15
    L11:
        if (r103 >= r104) goto L13;
        r102.lock();
        r103 = r103 + 1;
        goto L11
    L13:
        r106.unlock();
        return r107;
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

    public final T removeAtOrNull(int r100) {
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
        if (r100 >= 0) goto L29;
    L16:
        boolean r107 = false;
    L17:
        if (r107 == false) goto L24;
        T r108 = this.list.remove(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
    L20:
        if (r103 >= r104) goto L22;
        r102.lock();
        r103 = r103 + 1;
        goto L20
    L22:
        r106.unlock();
        throw th;
    L25:
        if (r103 >= r104) goto L27;
        r102.lock();
        r103 = r103 + 1;
        goto L25
    L27:
        r106.unlock();
        return r108;
    L24:
        r108 = null;
        goto L25
    L29:
        if (r100 >= this.list.size()) goto L16;
        r107 = true;
        goto L17
    L5:
        r104 = 0;
        goto L6
    }

    public final void add(int r100, T r101) {
        ReentrantReadWriteLock r102 = this.lock.getLock();
        ReentrantReadWriteLock.ReadLock r103 = r102.readLock();
        int r104 = 0;
        if (r102.getWriteHoldCount() != 0) goto L5;
        int r105 = r102.getReadHoldCount();
    L6:
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r103.unlock();
        r106 = r106 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r107 = r102.writeLock();
        r107.lock();
        this.list.add(r100, r101);     // Catch: Throwable -> L15
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r104 >= r105) goto L13;
        r103.lock();
        r104 = r104 + 1;
        goto L11
    L13:
        r107.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r104 >= r105) goto L18;
        r103.lock();
        r104 = r104 + 1;
        goto L16
    L18:
        r107.unlock();
        throw th;
    L5:
        r105 = 0;
        goto L6
    }

    public /* synthetic */ YataSyncMutableList(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
