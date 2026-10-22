package com.bytedance.kmp.ec.yata.common.utils;

import com.bytedance.kmp.ec.yata.common.platform.YataPlatformReadWriteLock;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00060\u0003j\u0002`\u0004B\u001b\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u00020\u00112\u001e\u0010\u0017\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\u0012\u0004\u0012\u00020\u00110\u0018H\u0086\bø\u0001\u0000J\u0018\u0010\u001a\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0013J\u001b\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"J\u0015\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001e\u0010$\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/utils/YataConcurrentHashMap;", "K", "V", "Ljava/io/Serializable;", "Lcom/bytedance/kmp/ec/yata/common/platform/YataJavaSerializable;", "map", "", "(Ljava/util/Map;)V", "lock", "Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "getLock", "()Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "getMap$annotations", "()V", "getMap", "()Ljava/util/Map;", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "forEach", "action", "Lkotlin/Function1;", "", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "putAll", "data", "", "remove", "set", "toMap", "toMutableMap", "toString", "", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class YataConcurrentHashMap<K, V> implements Serializable {
    private final YataPlatformReadWriteLock lock;
    private final Map<K, V> map;

    /* JADX WARN: Multi-variable type inference failed */
    public YataConcurrentHashMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "不可以直接使用，必须走封装的API保证线程安全")
    public static /* synthetic */ void getMap$annotations() {
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
        this.map.clear();     // Catch: Throwable -> L15
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
        boolean r101 = this.map.isEmpty();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final Map<K, V> toMap() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        Map<K, V> r101 = MapsKt.toMap(this.map);     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public final Map<K, V> toMutableMap() {
        ReentrantReadWriteLock.ReadLock r100 = this.lock.getLock().readLock();
        r100.lock();
        Map<K, V> r101 = MapsKt.toMutableMap(this.map);     // Catch: Throwable -> L6
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
        String r101 = this.map.toString();     // Catch: Throwable -> L6
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

    public final Map<K, V> getMap() {
        return this.map;
    }

    public YataConcurrentHashMap(Map<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.map = r100;
        this.lock = new YataPlatformReadWriteLock();
    }

    public final boolean containsKey(K r100) {
        ReentrantReadWriteLock.ReadLock r101 = this.lock.getLock().readLock();
        r101.lock();
        boolean r102 = this.map.containsKey(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void forEach(Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ReentrantReadWriteLock.ReadLock r101 = getLock().getLock().readLock();
        r101.lock();
        Iterator<Map.Entry<K, V>> r102 = getMap().entrySet().iterator();     // Catch: Throwable -> L10
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

    public final V get(K r100) {
        ReentrantReadWriteLock.ReadLock r101 = this.lock.getLock().readLock();
        r101.lock();
        V r102 = this.map.get(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void putAll(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
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
        this.map.putAll(r100);     // Catch: Throwable -> L15
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

    public final V remove(K r100) {
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
        V r107 = this.map.remove(r100);     // Catch: Throwable -> L15
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

    public final void put(K r100, V r101) {
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
        this.map.put(r100, r101);     // Catch: Throwable -> L15
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

    public final void set(K r100, V r101) {
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
        this.map.put(r100, r101);     // Catch: Throwable -> L15
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

    public /* synthetic */ YataConcurrentHashMap(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new LinkedHashMap();
    L5:
        this(r100);
    }
}
