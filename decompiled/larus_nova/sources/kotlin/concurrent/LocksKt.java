package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"read", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocksKt {
    private static final <T> T read(ReentrantReadWriteLock r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        ReentrantReadWriteLock.ReadLock r102 = r100.readLock();
        r102.lock();
        T r103 = r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r102.unlock();
        InlineMarker.finallyEnd(1);
        return r103;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r102.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T withLock(Lock r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        r100.lock();
        T r102 = r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.unlock();
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T write(ReentrantReadWriteLock r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        ReentrantReadWriteLock.ReadLock r102 = r100.readLock();
        int r103 = 0;
        if (r100.getWriteHoldCount() != 0) goto L5;
        int r104 = r100.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r100.writeLock();
        r106.lock();
        T r107 = r101.invoke();     // Catch: Throwable -> L16
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
