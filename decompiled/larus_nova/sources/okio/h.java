package okio;

import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class h implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSource f524024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cipher f524025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f524026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Buffer f524027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f524028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f524029f;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f524029f = true;
        this.f524024a.close();
    }

    private final void update() {
        g0 r100 = this.f524024a.getBuffer().head;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.f524019c - r100.f524018b;
        int r102 = this.f524025b.getOutputSize(r101);
    L4:
        if (r102 <= 8192) goto L10;
        int r103 = this.f524026c;
        if (r101 <= r103) goto L7;
        r101 = r101 - r103;
        r102 = this.f524025b.getOutputSize(r101);
        goto L4
    L7:
        this.f524028e = true;
        this.f524027d.write(this.f524025b.doFinal(this.f524024a.readByteArray()));
        return;
    L10:
        g0 r104 = this.f524027d.writableSegment$okio(r102);
        int r105 = this.f524025b.update(r100.f524017a, r100.f524018b, r101, r104.f524017a, r104.f524018b);
        this.f524024a.skip(r101);
        r104.f524019c += r105;
        Buffer r106 = this.f524027d;
        r106.setSize$okio(r106.size() + ((long) r105));
        if (r104.f524018b != r104.f524019c) goto L16;
        this.f524027d.head = r104.a();
        h0.a(r104);
        return;
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f524024a.timeout();
    }

    public h(BufferedSource r100, Cipher r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "cipher");
        this.f524024a = r100;
        this.f524025b = r101;
        int r102 = r101.getBlockSize();
        this.f524026c = r102;
        this.f524027d = new Buffer();
        if (r102 <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Block cipher required " + r101).toString());
    L5:
        r103 = false;
        goto L6
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L29;
        if ((!this.f524029f) == false) goto L27;
        if (r101 != 0) goto L12;
        return 0;
    L12:
        if (this.f524027d.size() != 0) goto L25;
        if (this.f524028e == true) goto L25;
        if (this.f524024a.exhausted() == true) goto L17;
        update();
        goto L12
    L17:
        this.f524028e = true;
        int r103 = this.f524025b.getOutputSize(0);
        if (r103 == 0) goto L25;
        g0 r104 = this.f524027d.writableSegment$okio(r103);
        int r105 = this.f524025b.doFinal(r104.f524017a, r104.f524018b);
        r104.f524019c += r105;
        Buffer r106 = this.f524027d;
        r106.setSize$okio(r106.size() + ((long) r105));
        if (r104.f524018b != r104.f524019c) goto L25;
        this.f524027d.head = r104.a();
        h0.a(r104);
    L25:
        return this.f524027d.read(r100, r101);
    L27:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    L29:
        throw new IllegalArgumentException(("byteCount < 0: " + r101).toString());
    L5:
        r102 = false;
        goto L6
    }
}
