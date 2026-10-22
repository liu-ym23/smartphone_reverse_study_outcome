package kvc;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f506344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedSource f506345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f506346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f506347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f506348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f506349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f506350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f506351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Buffer f506352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Buffer f506353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f506354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Buffer.a f506355l;

    public interface a {
    }

    public final void a() throws IOException {
        long r100 = this.f506349f;
        if (r100 <= 0) goto L8;
        this.f506345b.readFully(this.f506352i, r100);
        if (this.f506344a == true) goto L8;
        this.f506352i.readAndWriteUnsafe(this.f506355l);
        this.f506355l.b(0);
        c.b(this.f506355l, this.f506354k);
        this.f506355l.close();
    L8:
        switch(this.f506348e) {
            case 8: goto L31;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        ((kvc.a) this.f506346c).f(this.f506352i.readByteString());
        return;
    L12:
        a r101 = this.f506346c;
        ByteString r102 = this.f506352i.readByteString();
        kvc.a r103 = (kvc.a) r101;
        monitor-enter(r103);
    L28:
        th = move-exception;
        throw th;
    L15:
        if (r103.f506328s == false) goto L17;
    L26:
        monitor-exit(r103);
        return;
    L17:
        if (r103.f506324o == true) goto L19;
    L21:
        r103.f506321l.add(r102);     // Catch: Throwable -> L28
        PThreadScheduledThreadPoolExecutor r104 = r103.f506319j;     // Catch: Throwable -> L28
        if (r104 == null) goto L24;
        r104.execute(r103.f506316g);     // Catch: Throwable -> L28
    L24:
        monitor-exit(r103);
        return;
    L19:
        if (r103.f506322m.isEmpty() == false) goto L21;
    L31:
        long r105 = this.f506352i.size();
        if (r105 == 1) goto L44;
        if (r105 == 0) goto L40;
        short r106 = this.f506352i.readShort();
        String r107 = this.f506352i.readUtf8();
        String r108 = c.a(r106);
        if (r108 != null) goto L39;
    L41:
        ((kvc.a) this.f506346c).e(r106, r107);
        this.f506347d = true;
        return;
    L39:
        throw new ProtocolException(r108);
    L40:
        r107 = "";
        r106 = 1005;
        goto L41
    L44:
        throw new ProtocolException("Malformed close payload length of 1.");
    L10:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f506348e));
    }

    public final void b() throws IOException {
        if (this.f506347d == true) goto L73;
        long r100 = this.f506345b.timeout().i();
        this.f506345b.timeout().c();
        int r101 = this.f506345b.readByte() & UByte.MAX_VALUE;
        this.f506345b.timeout().h(r100, TimeUnit.NANOSECONDS);
        this.f506348e = r101 & 15;
        boolean r102 = true;
        if ((r101 & 128) == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f506350g = r103;
        if ((r101 & 8) == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f506351h = r104;
        if (r104 == false) goto L21;
        if (r103 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r101 & 64) == 0) goto L23;
        boolean r105 = true;
    L25:
        if ((r101 & 32) == 0) goto L27;
        boolean r106 = true;
    L29:
        if ((r101 & 16) == 0) goto L31;
        boolean r107 = true;
    L32:
        if (r105 == true) goto L68;
        if (r106 == true) goto L68;
        if (r107 == true) goto L68;
        int r108 = this.f506345b.readByte() & UByte.MAX_VALUE;
        if ((r108 & 128) != 0) goto L40;
        r102 = false;
    L40:
        if (r102 == this.f506344a) goto L42;
        long r109 = r108 & 127;
        this.f506349f = r109;
        if (r109 != 126) goto L51;
        this.f506349f = ((long) this.f506345b.readShort()) & 65535;
    L58:
        if (this.f506351h == true) goto L60;
    L64:
        if (r102 == false) goto L76;
        this.f506345b.readFully(this.f506354k);
        return;
    L76:
        return;
    L60:
        if (this.f506349f <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r109 != 127) goto L58;
        long r110 = this.f506345b.readLong();
        this.f506349f = r110;
        if (r110 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f506349f) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (this.f506344a == false) goto L44;
        String r111 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r111);
    L44:
        r111 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r107 = false;
        goto L32
    L27:
        r106 = false;
        goto L29
    L23:
        r105 = false;
        goto L25
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
    L69:
        th = move-exception;
        this.f506345b.timeout().h(r100, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }

    public d(boolean r100, BufferedSource r101, kvc.a r102) {
        this.f506352i = new Buffer();
        this.f506353j = new Buffer();
        if (r101 == null) goto L18;
        if (r102 == null) goto L16;
        this.f506344a = r100;
        this.f506345b = r101;
        this.f506346c = r102;
        Buffer.a r103 = null;
        if (r100 == false) goto L8;
        byte[] r104 = null;
    L9:
        this.f506354k = r104;
        if (r100 == true) goto L13;
        r103 = new Buffer.a();
    L13:
        this.f506355l = r103;
        return;
    L8:
        r104 = new byte[4];
        goto L9
    L16:
        throw new NullPointerException("frameCallback == null");
    L18:
        throw new NullPointerException("source == null");
    }
}
