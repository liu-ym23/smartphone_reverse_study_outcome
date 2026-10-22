package okio;

import com.byted.cast.common.Constants;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class e implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f524003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Source f524004b;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c r100 = this.f524003a;
        Source r101 = this.f524004b;
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

    public final String toString() {
        return "AsyncTimeout.source(" + this.f524004b + ')';
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f524003a;
    }

    public e(i0 r100, u r101) {
        this.f524003a = r100;
        this.f524004b = r101;
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        c r102 = this.f524003a;
        Source r103 = this.f524004b;
        r102.j();
        long r104 = r103.read(r100, r101);     // Catch: Throwable -> L9 IOException -> L11
    L5:
        if (r102.k() == true) goto L8;
        return r104;
    L8:
        throw r102.l(null);
    L11:
        e = move-exception;
        if (r102.k() == true) goto L16;
        throw e;     // Catch: Throwable -> L9
    L16:
        throw r102.l(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r102.k();
        throw th;
    }
}
