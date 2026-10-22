package okio;

import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class c0 implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSource f523983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Buffer f523984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g0 f523985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f523986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f523987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f523988f;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f523987e = true;
    }

    @Override // okio.Source
    public final j0 timeout() {
        return this.f523983a.timeout();
    }

    public c0(BufferedSource r100) {
        Intrinsics.checkNotNullParameter(r100, "upstream");
        this.f523983a = r100;
        Buffer r101 = r100.getBuffer();
        this.f523984b = r101;
        g0 r102 = r101.head;
        this.f523985c = r102;
        if (r102 == null) goto L5;
        int r103 = r102.f524018b;
    L6:
        this.f523986d = r103;
        return;
    L5:
        r103 = -1;
        goto L6
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        boolean r101 = false;
        if (r110 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L35;
        if ((!this.f523987e) == false) goto L33;
        g0 r103 = this.f523985c;
        if (r103 == null) goto L15;
        g0 r104 = this.f523984b.head;
        if (r103 != r104) goto L16;
        int r105 = this.f523986d;
        Intrinsics.checkNotNull(r104);
        if (r105 == r104.f524018b) goto L15;
    L16:
        if (r101 == false) goto L31;
        if (r110 != 0) goto L20;
        return 0;
    L20:
        if (this.f523983a.request(this.f523988f + 1) == true) goto L24;
        return -1;
    L24:
        if (this.f523985c != null) goto L28;
        g0 r106 = this.f523984b.head;
        if (r106 == null) goto L28;
        this.f523985c = r106;
        Intrinsics.checkNotNull(r106);
        this.f523986d = r106.f524018b;
    L28:
        long r111 = Math.min(r110, this.f523984b.size() - this.f523988f);
        this.f523984b.copyTo(r100, this.f523988f, r111);
        this.f523988f += r111;
        return r111;
    L31:
        throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
    L15:
        r101 = true;
        goto L16
    L33:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
    L35:
        throw new IllegalArgumentException(("byteCount < 0: " + r110).toString());
    L5:
        r102 = false;
        goto L6
    }
}
