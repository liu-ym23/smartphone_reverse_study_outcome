package id;

import com.bytedance.android.chunkstreamprediction.network.i;
import com.bytedance.android.chunkstreamprediction.network.j;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f489286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f489287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f489288c;

    public final void a() throws IOException {
        if (this.f489286a.read() != 13) goto L8;
        if (this.f489286a.read() != 10) goto L8;
        return;
    L8:
        throw new IOException("Chunk data not end with CRLF");
    }

    public final d b() throws IOException {
        this.f489288c.setLength(0);
    L3:
        int r100 = this.f489286a.read();
        if (r100 == (-1)) goto L19;
        if (r100 == 13) goto L8;
        if (Character.digit(r100, 16) == (-1)) goto L17;
        this.f489288c.append((char) r100);
        goto L3
    L17:
        throw new IOException("Chunk header is not hex string");
    L8:
        if (this.f489286a.read() != 10) goto L12;
        int r101 = CastIntegerProtector.parseInt(this.f489288c.toString(), 16);
        this.f489287b.i();
        return new d(r101, this.f489286a);
    L12:
        throw new IOException("Chunk header not end with CRLF");
    L19:
        throw new IOException("Unexpected EOF");
    }

    public e(InputStream r100) {
        this.f489287b = new j();
        this.f489288c = new StringBuilder(10);
        this.f489286a = new BufferedInputStream(r100);
    }
}
