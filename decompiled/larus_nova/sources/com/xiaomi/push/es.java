package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes41.dex */
class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ev f463500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ex f521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private InputStream f522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ByteBuffer f523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Adler32 f524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f463501b;

    private void c() {
        boolean r100 = false;
        this.f525a = false;
        eq r101 = m9069a();
        if ("CONN".equals(r101.m9058a()) == false) goto L11;
        Cdo.f r102 = Cdo.f.a(r101.m9062a());
        if (r102.m9000a() == false) goto L8;
        this.f521a.a(r102.m8999a());
        r100 = true;
    L8:
        if (r102.c() == false) goto L10;
        Cdo.b r103 = r102.m8998a();
        eq r104 = new eq();
        r104.a(BridgeSyncType.SYNC, "CONF");
        r104.a(r103.m9042a(), null);
        this.f521a.a(r104);
    L10:
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] CONN: host = " + r102.m9001b());
    L11:
        if (r100 == false) goto L40;
        this.f526a = this.f521a.m9076a();
    L14:
        if (this.f525a == true) goto L39;
        eq r105 = m9069a();
        long r106 = System.currentTimeMillis();
        this.f521a.c();
        short r107 = r105.m9060a();
        if (r107 != 1) goto L18;
        this.f521a.a(r105);
        goto L14
    L18:
        if (r107 != 2) goto L19;
        if ("SECMSG".equals(r105.m9058a()) == false) goto L37;
        if (r105.a() == 2) goto L32;
        if (r105.a() != 3) goto L37;
    L32:
        if (TextUtils.isEmpty(r105.m9065b()) == false) goto L37;
        fn r108 = this.f463500a.a(r105.m9063a(com.xiaomi.push.service.am.a().a(Integer.valueOf(r105.a()).toString(), r105.g()).f464222h), this.f521a);     // Catch: Exception -> L35
        r108.f582a = r106;     // Catch: Exception -> L35
        this.f521a.b(r108);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] Parse packet from Blob chid=" + r105.a() + "; Id=" + r105.e() + " failure:" + e.getMessage());
    L37:
        this.f521a.a(r105);
        goto L14
    L19:
        if (r107 != 3) goto L20;
        this.f521a.b(this.f463500a.a(r105.m9062a(), this.f521a));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] Parse packet from Blob chid=" + r105.a() + "; Id=" + r105.e() + " failure:" + e.getMessage());
        goto L14
    L20:
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] unknow blob type " + r105.m9060a());
        goto L14
    L39:
        return;
    L40:
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
    }

    public void b() {
        this.f525a = true;
    }

    private ByteBuffer a() {
        this.f523a.clear();
        a(this.f523a, 8);
        short r100 = this.f523a.getShort(0);
        short r101 = this.f523a.getShort(2);
        if (r100 != (-15618)) goto L28;
        if (r101 != 5) goto L28;
        int r102 = this.f523a.getInt(4);
        int r103 = this.f523a.position();
        if (r102 > 32768) goto L26;
        if ((r102 + 4) <= this.f523a.remaining()) goto L12;
        ByteBuffer r104 = ByteBuffer.allocate(r102 + 2048);
        r104.put(this.f523a.array(), 0, this.f523a.arrayOffset() + this.f523a.position());
        this.f523a = r104;
    L16:
        a(this.f523a, r102);
        this.f463501b.clear();
        a(this.f463501b, 4);
        this.f463501b.position(0);
        int r105 = this.f463501b.getInt();
        this.f524a.reset();
        this.f524a.update(this.f523a.array(), 0, this.f523a.position());
        if (r105 != ((int) this.f524a.getValue())) goto L23;
        byte[] r106 = this.f526a;
        if (r106 == null) goto L22;
        com.xiaomi.push.service.ar.a(r106, this.f523a.array(), true, r103, r102);
    L22:
        return this.f523a;
    L23:
        com.xiaomi.channel.commonutils.logger.b.m8718a("CRC = " + ((int) this.f524a.getValue()) + " and " + r105);
        throw new IOException("Corrupted Blob bad CRC");
    L12:
        if (this.f523a.capacity() <= 4096) goto L16;
        if (r102 >= 2048) goto L16;
        ByteBuffer r107 = ByteBuffer.allocate(2048);
        r107.put(this.f523a.array(), 0, this.f523a.arrayOffset() + this.f523a.position());
        this.f523a = r107;
        goto L16
    L26:
        throw new IOException("Blob size too large");
    L28:
        throw new IOException("Malformed Input");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public eq m9069a() {
        ByteBuffer r100 = a();     // Catch: IOException -> L12
        int r101 = r100.position();     // Catch: IOException -> L12
        r100.flip();     // Catch: IOException -> L10
        r100.position(8);     // Catch: IOException -> L10
        if (r101 != 8) goto L7;
        eq r102 = new ew();     // Catch: IOException -> L10
    L8:
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + r102.m9058a() + ";chid=" + r102.a() + ";len=" + r101 + com.alipay.sdk.m.u.i.f25855d);     // Catch: IOException -> L10
        return r102;
    L7:
        r102 = eq.a(r100.slice());     // Catch: IOException -> L10
    L10:
        e = e;
    L14:
        if (r101 != 0) goto L16;
        r101 = this.f523a.position();
    L16:
        StringBuilder r103 = new StringBuilder("[Slim] read Blob [");
        byte[] r104 = this.f523a.array();
        if (r101 <= 128) goto L19;
        r101 = 128;
    L19:
        r103.append(aa.a(r104, 0, r101));
        r103.append("] Err:");
        r103.append(e.getMessage());
        com.xiaomi.channel.commonutils.logger.b.m8718a(r103.toString());
        throw e;
    L12:
        e = e;
        r101 = 0;
        goto L14
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9070a() {
        c();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        if (this.f525a == false) goto L8;
        return;
    L8:
        throw e;
    }

    public es(InputStream r100, ex r101) {
        this.f523a = ByteBuffer.allocate(2048);
        this.f463501b = ByteBuffer.allocate(4);
        this.f524a = new Adler32();
        this.f522a = new BufferedInputStream(r100);
        this.f521a = r101;
        this.f463500a = new ev();
    }

    private void a(ByteBuffer r100, int r101) {
        int r102 = r100.position();
    L3:
        int r103 = this.f522a.read(r100.array(), r102, r101);
        if (r103 == (-1)) goto L10;
        r101 = r101 - r103;
        r102 = r102 + r103;
        if (r101 > 0) goto L3;
        r100.position(r102);
        return;
    L10:
        throw new EOFException();
    }
}
