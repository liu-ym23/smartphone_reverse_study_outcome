package okio;

import com.byted.cast.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class u implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f524111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f524112b;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f524111a.close();
    }

    public final String toString() {
        return "source(" + this.f524111a + ')';
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f524112b;
    }

    public u(InputStream r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "timeout");
        this.f524111a = r100;
        this.f524112b = r101;
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (r101 != 0) goto L6;
        return 0;
    L6:
        if (r101 < 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L26;
        this.f524112b.g();     // Catch: AssertionError -> L19
        g0 r103 = r100.writableSegment$okio(1);     // Catch: AssertionError -> L19
        int r104 = this.f524111a.read(r103.f524017a, r103.f524019c, (int) Math.min(r101, 8192 - r103.f524019c));     // Catch: AssertionError -> L19
        if (r104 == (-1)) goto L13;
        r103.f524019c += r104;     // Catch: AssertionError -> L19
        long r105 = r104;
        r100.setSize$okio(r100.size() + r105);     // Catch: AssertionError -> L19
        return r105;
    L13:
        if (r103.f524018b != r103.f524019c) goto L28;
        r100.head = r103.a();     // Catch: AssertionError -> L19
        h0.a(r103);     // Catch: AssertionError -> L19
        return -1;
    L28:
        return -1;
    L19:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == true) goto L23;
        throw e;
    L23:
        throw new IOException(e);
    L26:
        throw new IllegalArgumentException(("byteCount < 0: " + r101).toString());
    L8:
        r102 = false;
        goto L9
    }
}
