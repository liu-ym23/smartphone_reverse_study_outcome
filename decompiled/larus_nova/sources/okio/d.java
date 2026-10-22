package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class d implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f523989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sink f523990b;

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c r100 = this.f523989a;
        Sink r101 = this.f523990b;
        r100.j();
        r101.close();     // Catch: Throwable -> L9 IOException -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9 IOException -> L11
    L5:
        if (r100.k() == true) goto L8;
        return;
    L8:
        throw r100.l(null);
    L9:
        th = move-exception;
        r100.k();
        throw th;
    L11:
        e = move-exception;
        if (r100.k() == true) goto L16;
        throw e;     // Catch: Throwable -> L9
    L16:
        throw r100.l(e);     // Catch: Throwable -> L9
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        c r100 = this.f523989a;
        Sink r101 = this.f523990b;
        r100.j();
        r101.flush();     // Catch: Throwable -> L9 IOException -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9 IOException -> L11
    L5:
        if (r100.k() == true) goto L8;
        return;
    L8:
        throw r100.l(null);
    L9:
        th = move-exception;
        r100.k();
        throw th;
    L11:
        e = move-exception;
        if (r100.k() == true) goto L16;
        throw e;     // Catch: Throwable -> L9
    L16:
        throw r100.l(e);     // Catch: Throwable -> L9
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.f523990b + ')';
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.f523989a;
    }

    public d(i0 r100, a0 r101) {
        this.f523989a = r100;
        this.f523990b = r101;
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        b.b(r100.size(), 0, r101);
    L3:
        long r102 = 0;
        if (r101 <= 0) goto L29;
        g0 r103 = r100.head;
        Intrinsics.checkNotNull(r103);
    L7:
        if (r102 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L12;
        r102 = r102 + ((long) (r103.f524019c - r103.f524018b));
        if (r102 >= r101) goto L10;
        r103 = r103.f524022f;
        Intrinsics.checkNotNull(r103);
        goto L7
    L10:
        r102 = r101;
    L12:
        c r104 = this.f523989a;
        Sink r105 = this.f523990b;
        r104.j();
        r105.write(r100, r102);     // Catch: Throwable -> L19 IOException -> L21
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19 IOException -> L21
    L15:
        if (r104.k() == true) goto L18;
        r101 = r101 - r102;
        goto L3
    L18:
        throw r104.l(null);
    L21:
        e = move-exception;
        if (r104.k() == true) goto L26;
        throw e;     // Catch: Throwable -> L19
    L26:
        throw r104.l(e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r104.k();
        throw th;
    }
}
