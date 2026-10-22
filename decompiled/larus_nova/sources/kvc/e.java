package kvc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.j0;

/* JADX INFO: loaded from: classes42.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f506356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f506357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSink f506358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Buffer f506359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f506360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Buffer f506361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f506362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f506363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f506364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Buffer.a f506365j;

    public final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f506366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f506367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f506368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f506369d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f506370e;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f506369d == true) goto L7;
            e r100 = this.f506370e;
            r100.b(this.f506366a, r100.f506361f.size(), this.f506368c, true);
            this.f506369d = true;
            this.f506370e.f506363h = false;
            return;
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            if (this.f506369d == true) goto L7;
            e r100 = this.f506370e;
            r100.b(this.f506366a, r100.f506361f.size(), this.f506368c, false);
            this.f506368c = false;
            return;
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        @Override // okio.Sink
        public final j0 timeout() {
            return this.f506370e.f506358c.timeout();
        }

        public a(e r100) {
            this.f506370e = r100;
        }

        @Override // okio.Sink
        public final void write(Buffer r100, long r101) throws IOException {
            if (this.f506369d == true) goto L18;
            this.f506370e.f506361f.write(r100, r101);
            if (this.f506368c == true) goto L7;
        L11:
            boolean r102 = false;
        L12:
            long r103 = this.f506370e.f506361f.completeSegmentByteCount();
            if (r103 <= 0) goto L19;
            if (r102 == true) goto L20;
            this.f506370e.b(this.f506366a, r103, this.f506368c, false);
            this.f506368c = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.f506367b == (-1)) goto L11;
            if (this.f506370e.f506361f.size() <= (this.f506367b - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r102 = true;
            goto L12
        L18:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }
    }

    public final void a(int r100, ByteString r101) throws IOException {
        if (this.f506360e == true) goto L17;
        int r102 = r101.size();
        if (r102 > 125) goto L15;
        this.f506359d.writeByte(r100 | 128);
        if (this.f506356a == false) goto L11;
        this.f506359d.writeByte(r102 | 128);
        this.f506357b.nextBytes(this.f506364i);
        this.f506359d.write(this.f506364i);
        if (r102 <= 0) goto L12;
        long r103 = this.f506359d.size();
        this.f506359d.write(r101);
        this.f506359d.readAndWriteUnsafe(this.f506365j);
        this.f506365j.b(r103);
        c.b(this.f506365j, this.f506364i);
        this.f506365j.close();
    L12:
        this.f506358c.flush();
        return;
    L11:
        this.f506359d.writeByte(r102);
        this.f506359d.write(r101);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }

    public e(boolean r100, BufferedSink r101, Random r102) {
        this.f506361f = new Buffer();
        this.f506362g = new a(this);
        if (r101 == null) goto L17;
        if (r102 == null) goto L15;
        this.f506356a = r100;
        this.f506358c = r101;
        this.f506359d = r101.buffer();
        this.f506357b = r102;
        Buffer.a r103 = null;
        if (r100 == false) goto L8;
        byte[] r104 = new byte[4];
    L9:
        this.f506364i = r104;
        if (r100 == false) goto L12;
        r103 = new Buffer.a();
    L12:
        this.f506365j = r103;
        return;
    L8:
        r104 = null;
        goto L9
    L15:
        throw new NullPointerException("random == null");
    L17:
        throw new NullPointerException("sink == null");
    }

    public final void b(int r100, long r101, boolean r102, boolean r103) throws IOException {
        if (this.f506360e == true) goto L29;
        int r104 = 0;
        if (r102 == true) goto L8;
        r100 = 0;
    L8:
        if (r103 == false) goto L10;
        r100 = r100 | 128;
    L10:
        this.f506359d.writeByte(r100);
        if (this.f506356a == false) goto L14;
        r104 = 128;
    L14:
        if (r101 > 125) goto L17;
        Buffer r105 = this.f506359d;
        r105.writeByte(((int) r101) | r104);
    L21:
        if (this.f506356a == false) goto L25;
        this.f506357b.nextBytes(this.f506364i);
        this.f506359d.write(this.f506364i);
        if (r101 <= 0) goto L26;
        long r106 = this.f506359d.size();
        this.f506359d.write(this.f506361f, r101);
        this.f506359d.readAndWriteUnsafe(this.f506365j);
        this.f506365j.b(r106);
        c.b(this.f506365j, this.f506364i);
        this.f506365j.close();
    L26:
        this.f506358c.emit();
        return;
    L25:
        this.f506359d.write(this.f506361f, r101);
        goto L26
    L17:
        if (r101 > 65535) goto L19;
        Buffer r107 = this.f506359d;
        r107.writeByte(r104 | 126);
        this.f506359d.writeShort((int) r101);
        goto L21
    L19:
        Buffer r108 = this.f506359d;
        r108.writeByte(r104 | 127);
        this.f506359d.writeLong(r101);
        goto L21
    L29:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }
}
