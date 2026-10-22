package com.bytedance.gkfs.storage.io;

import com.bytedance.gkfs.UtilsKt;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public final class CombinedChunkInputStream extends InputStream {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f245329g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f245331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f245332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f245333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Pair<b, Long>> f245334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f245335f;

    public static final class Companion {
        public static CombinedChunkInputStream a(final com.bytedance.gkfs.storage.a r100, final b r101) {
            return new CombinedChunkInputStream(r100.f245304b, new CombinedChunkInputStream$Companion$create$1(r101, r100), CombinedChunkInputStream$Companion$create$2.INSTANCE);
        }
    }

    static {
    }

    @Override // java.io.InputStream
    public final int read() {
        boolean r100 = true;
        byte[] r101 = new byte[1];
        Integer r102 = Integer.valueOf(read(r101, 0, 1));
        if (r102.intValue() != (-1)) goto L6;
        r100 = false;
    L6:
        if (r100 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L12;
        r102.intValue();
        return r101[0] & UByte.MAX_VALUE;
    L12:
        return -1;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f245333d - this.f245331b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f245332c.compareAndSet(false, true) == true) goto L13;
    L11:
        super.close();
        return;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L6
        this.f245335f.invoke();     // Catch: Throwable -> L6
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L11;
        r102.printStackTrace();
    L6:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void finalize() {
        if (this.f245332c.compareAndSet(false, true) == false) goto L14;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L6
        this.f245335f.invoke();     // Catch: Throwable -> L6
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L15;
        r102.printStackTrace();
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombinedChunkInputStream(int r100, Function0<? extends Pair<? extends b, Long>> r101, Function0<Unit> r102) {
        this.f245333d = r100;
        this.f245334e = r101;
        this.f245335f = r102;
        this.f245330a = LazyKt.lazy(new CombinedChunkInputStream$readInfo$2(this));
        this.f245332c = new AtomicBoolean(false);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r110, int r111, int r210) {
        r110.getClass();
        if (r111 < 0) goto L50;
        if (r210 < 0) goto L50;
        if (r210 > (r110.length - r111)) goto L50;
        if (r210 != 0) goto L10;
        return 0;
    L10:
        int r100 = this.f245333d - this.f245331b;
        if (r100 > 0) goto L14;
        return -1;
    L14:
        int r101 = Math.min(r210, r100);
        b r112 = (b) ((Pair) this.f245330a.getValue()).getFirst();
        long r102 = ((long) this.f245331b) + ((Number) ((Pair) this.f245330a.getValue()).getSecond()).longValue();
        if (r112.f245355c.get() == true) goto L48;
        if (r111 < 0) goto L46;
        if (r101 < 0) goto L46;
        if (r101 > (r110.length - r111)) goto L46;
        if (r101 == 0) goto L30;
        ReentrantReadWriteLock.ReadLock r103 = r112.f245354b.readLock();
        r103.lock();
        long r104 = r112.f245353a;     // Catch: Throwable -> L42
        r103.unlock();
        long r113 = r104 - r102;
        if (r113 <= 0) goto L27;
        r112.f(r102, r110, r111, Math.min(r101, (int) r113));
        b.a.a(b.f245352n, r112);
        goto L30
    L27:
        if (UtilsKt.d() == false) goto L30;
        com.bytedance.gkfs.c.b(r112.f245356d, "GkFSBlockBuffer", "no available bytes from " + r102 + " of block " + r112.f245357e.f245185a + " can be read, writePos=" + r104, 0, false, 12);
    L42:
        th = move-exception;
        r103.unlock();
        throw th;
    L30:
        int r105 = this.f245331b + r101;
        this.f245331b = r105;
        if ((this.f245333d - r105) <= 0) goto L33;
    L41:
        return r101;
    L33:
        if (this.f245332c.compareAndSet(false, true) == false) goto L41;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L36
        this.f245335f.invoke();     // Catch: Throwable -> L36
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L41;
        r108.printStackTrace();
    L36:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L46:
        throw new IndexOutOfBoundsException();
    L48:
        throw new IOException("buffer " + r112.f245357e.f245185a + " closed");
    L50:
        throw new IndexOutOfBoundsException();
    }
}
