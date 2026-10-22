package com.bytedance.kmp.ec.yata.common.platform;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformReadWriteLock;", "Ljava/io/Serializable;", "()V", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "withReadLock", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withWriteLock", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class YataPlatformReadWriteLock implements Serializable {
    private final ReentrantReadWriteLock lock;

    public YataPlatformReadWriteLock() {
        this.lock = new ReentrantReadWriteLock();
    }

    public final ReentrantReadWriteLock getLock() {
        return this.lock;
    }

    public final <T> T withReadLock(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ReentrantReadWriteLock.ReadLock r101 = getLock().readLock();
        r101.lock();
        T r102 = r100.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r101.unlock();
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r101.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final <T> T withWriteLock(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ReentrantReadWriteLock r101 = getLock();
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
        T r107 = r100.invoke();     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
    L12:
        if (r103 >= r104) goto L14;
        r102.lock();
        r103 = r103 + 1;
        goto L12
    L14:
        r106.unlock();
        InlineMarker.finallyEnd(1);
        return r107;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
    L18:
        if (r103 >= r104) goto L20;
        r102.lock();
        r103 = r103 + 1;
        goto L18
    L20:
        r106.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r104 = 0;
        goto L6
    }
}
