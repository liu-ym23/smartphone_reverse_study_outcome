package gvc;

import androidx.collection.SieveCacheKt;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class p implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f482983g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSink f482984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f482985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Buffer f482986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f482987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f482988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b.C6072b f482989f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
        this.f482988e = true;     // Catch: Throwable -> L7
        this.f482984a.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L9;
        this.f482984a.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L10
    }

    static {
        f482983g = Logger.getLogger(c.class.getName());
    }

    public final synchronized void a(s r100) throws IOException {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L32;
        int r101 = this.f482987d;     // Catch: Throwable -> L33
        int r102 = r100.f482998a;     // Catch: Throwable -> L33
        if ((r102 & 32) == 0) goto L8;
        r101 = r100.f482999b[5];     // Catch: Throwable -> L33
    L8:
        this.f482987d = r101;     // Catch: Throwable -> L33
        if ((r102 & 2) == 0) goto L11;
        int r103 = r100.f482999b[1];     // Catch: Throwable -> L33
    L13:
        if (r103 == (-1)) goto L28;
        b.C6072b r104 = this.f482989f;     // Catch: Throwable -> L33
        if ((r102 & 2) == 0) goto L17;
        int r105 = r100.f482999b[1];     // Catch: Throwable -> L33
    L18:
        r104.getClass();     // Catch: Throwable -> L33
        int r106 = Math.min(r105, 16384);     // Catch: Throwable -> L33
        int r107 = r104.f482866d;     // Catch: Throwable -> L33
        if (r107 == r106) goto L28;
        if (r106 >= r107) goto L23;
        r104.f482864b = Math.min(r104.f482864b, r106);     // Catch: Throwable -> L33
    L23:
        r104.f482865c = true;     // Catch: Throwable -> L33
        r104.f482866d = r106;     // Catch: Throwable -> L33
        int r108 = r104.f482870h;     // Catch: Throwable -> L33
        if (r106 >= r108) goto L28;
        if (r106 != 0) goto L27;
        Arrays.fill(r104.f482867e, null);     // Catch: Throwable -> L33
        r104.f482868f = r104.f482867e.length - 1;     // Catch: Throwable -> L33
        r104.f482869g = 0;     // Catch: Throwable -> L33
        r104.f482870h = 0;     // Catch: Throwable -> L33
        goto L28
    L27:
        r104.a(r108 - r106);     // Catch: Throwable -> L33
        goto L28
    L17:
        r105 = -1;
    L28:
        c(0, 0, (byte) 4, (byte) 1);     // Catch: Throwable -> L33
        this.f482984a.flush();     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L11:
        r103 = -1;
        goto L13
    L32:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L33
    }

    public final synchronized void h(s r100) throws IOException {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L26;
        c(0, Integer.bitCount(r100.f482998a) * 6, (byte) 4, (byte) 0);     // Catch: Throwable -> L27
        int r101 = 0;
    L7:
        if (r101 >= 10) goto L22;
        boolean r102 = true;
        if (((1 << r101) & r100.f482998a) != 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L21;
        if (r101 != 4) goto L17;
        int r103 = 3;
    L20:
        this.f482984a.writeShort(r103);     // Catch: Throwable -> L27
        this.f482984a.writeInt(r100.f482999b[r101]);     // Catch: Throwable -> L27
        goto L21
    L17:
        if (r101 != 7) goto L19;
        r103 = 4;
        goto L20
    L19:
        r103 = r101;
    L21:
        r101 = r101 + 1;     // Catch: Throwable -> L27
        goto L7
    L22:
        this.f482984a.flush();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L26:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L27
    }

    public p(BufferedSink r100, boolean r101) {
        this.f482984a = r100;
        this.f482985b = r101;
        Buffer r102 = new Buffer();
        this.f482986c = r102;
        this.f482989f = new b.C6072b(r102);
        this.f482987d = 16384;
    }

    public final synchronized void g(int r100, ErrorCode r101) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L13;
        if (r101.httpCode == (-1)) goto L11;
        c(r100, 4, (byte) 3, (byte) 0);     // Catch: Throwable -> L14
        this.f482984a.writeInt(r101.httpCode);     // Catch: Throwable -> L14
        this.f482984a.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L14
    L13:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L14
    }

    public final synchronized void j(int r100, long r101) throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L15;
        if (r101 != 0) goto L8;
    L12:
        Object[] r102 = {Long.valueOf(r101)};     // Catch: Throwable -> L16
        ByteString r103 = c.f482871a;     // Catch: Throwable -> L16
        throw new IllegalArgumentException(cvc.c.l("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", r102));     // Catch: Throwable -> L16
    L8:
        if (r101 > SieveCacheKt.NodeLinkMask) goto L12;
        c(r100, 4, (byte) 8, (byte) 0);     // Catch: Throwable -> L16
        this.f482984a.writeInt((int) r101);     // Catch: Throwable -> L16
        this.f482984a.flush();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L15:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L16
    }

    public final void k(int r100, long r101) throws IOException {
    L3:
        if (r101 <= 0) goto L9;
        int r102 = (int) Math.min(this.f482987d, r101);
        long r103 = r102;
        r101 = r101 - r103;
        if (r101 != 0) goto L7;
        byte r104 = 4;
    L8:
        c(r100, r102, (byte) 9, r104);
        this.f482984a.write(this.f482986c, r103);
        goto L3
    L7:
        r104 = 0;
        goto L8
    }

    public final synchronized void d(int r100, ErrorCode r101, byte[] r102) throws IOException {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L16;
        if (r101.httpCode == (-1)) goto L13;
        c(0, r102.length + 8, (byte) 7, (byte) 0);     // Catch: Throwable -> L17
        this.f482984a.writeInt(r100);     // Catch: Throwable -> L17
        this.f482984a.writeInt(r101.httpCode);     // Catch: Throwable -> L17
        if (r102.length <= 0) goto L10;
        this.f482984a.write(r102);     // Catch: Throwable -> L17
    L10:
        this.f482984a.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        ByteString r103 = c.f482871a;     // Catch: Throwable -> L17
        throw new IllegalArgumentException(cvc.c.l("errorCode.httpCode == -1", new Object[0]));     // Catch: Throwable -> L17
    L16:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L17
    }

    public final void e(boolean r100, int r101, List<a> r102) throws IOException {
        if (this.f482988e == true) goto L15;
        this.f482989f.d(r102);
        long r103 = this.f482986c.size();
        int r104 = (int) Math.min(this.f482987d, r103);
        long r105 = r104;
        if (r103 != r105) goto L7;
        byte r106 = 4;
    L8:
        if (r100 == false) goto L10;
        r106 = (byte) (r106 | 1);
    L10:
        c(r101, r104, (byte) 1, r106);
        this.f482984a.write(this.f482986c, r105);
        if (r103 <= r105) goto L16;
        k(r101, r103 - r105);
        return;
    L16:
        return;
    L7:
        r106 = 0;
        goto L8
    L15:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }

    public final synchronized void f(boolean r100, int r101, int r102) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L13;
        if (r100 == false) goto L8;
        byte r103 = 1;
    L9:
        c(0, 8, (byte) 6, r103);     // Catch: Throwable -> L14
        this.f482984a.writeInt(r101);     // Catch: Throwable -> L14
        this.f482984a.writeInt(r102);     // Catch: Throwable -> L14
        this.f482984a.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r103 = 0;
        goto L9
    L13:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L14
    }

    public final synchronized void i(boolean r100, int r101, List r102) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L9;
        e(r100, r101, r102);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L10
    }

    public final synchronized void b(boolean r100, int r101, Buffer r102, int r103) throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f482988e == true) goto L15;
        if (r100 == false) goto L8;
        byte r104 = (byte) 1;     // Catch: Throwable -> L16
    L9:
        c(r101, r103, (byte) 0, r104);     // Catch: Throwable -> L16
        if (r103 <= 0) goto L12;
        this.f482984a.write(r102, r103);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r104 = 0;
        goto L9
    L15:
        throw new IOException(PTYSocketStateCallback.CLOSED);     // Catch: Throwable -> L16
    }

    public final void c(int r100, int r101, byte r102, byte r103) throws IOException {
        Logger r104 = f482983g;
        if (r104.isLoggable(Level.FINE) == false) goto L5;
        r104.fine(c.a(false, r100, r101, r102, r103));
    L5:
        int r105 = this.f482987d;
        if (r101 <= r105) goto L8;
        Object[] r106 = {Integer.valueOf(r105), Integer.valueOf(r101)};
        ByteString r107 = c.f482871a;
        throw new IllegalArgumentException(cvc.c.l("FRAME_SIZE_ERROR length > %d: %d", r106));
    L8:
        if ((Integer.MIN_VALUE & r100) != 0) goto L11;
        BufferedSink r108 = this.f482984a;
        r108.writeByte((r101 >>> 16) & 255);
        r108.writeByte((r101 >>> 8) & 255);
        r108.writeByte(r101 & 255);
        this.f482984a.writeByte(r102 & UByte.MAX_VALUE);
        this.f482984a.writeByte(r103 & UByte.MAX_VALUE);
        this.f482984a.writeInt(r100 & Integer.MAX_VALUE);
        return;
    L11:
        Object[] r109 = {Integer.valueOf(r100)};
        ByteString r110 = c.f482871a;
        throw new IllegalArgumentException(cvc.c.l("reserved bit set: %s", r109));
    }
}
