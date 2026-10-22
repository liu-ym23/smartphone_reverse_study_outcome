package com.xiaomi.push;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes41.dex */
public class eq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f463497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f463498b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    int f515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Cdo.a f516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f518a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f519b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f520b;

    static {
        f463498b = fw.a(5) + "-";
        f463497a = 0;
        f514a = new byte[0];
    }

    public static synchronized String d() {
        monitor-enter(eq.class);
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L7
        r100.append(f463498b);     // Catch: Throwable -> L7
        long r101 = f463497a;     // Catch: Throwable -> L7
        f463497a = 1 + r101;     // Catch: Throwable -> L7
        r100.append(Long.toString(r101));     // Catch: Throwable -> L7
        String r102 = r100.toString();     // Catch: Throwable -> L7
        monitor-exit(eq.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public int a() {
        return this.f516a.c();
    }

    public int b() {
        return this.f516a.f();
    }

    public int c() {
        return (this.f516a.b() + 8) + this.f520b.length;
    }

    public String e() {
        String r100 = this.f516a.m8961e();
        if ("ID_NOT_AVAILABLE".equals(r100) == false) goto L7;
        return null;
    L7:
        if (this.f516a.g() == true) goto L10;
        String r101 = d();
        this.f516a.e(r101);
        return r101;
    L10:
        return r100;
    }

    public String g() {
        if (this.f516a.m8955b() == true) goto L5;
        return null;
    L5:
        return Long.toString(this.f516a.m8949a()) + "@" + this.f516a.m8951a() + HTTP.URL_DEFAULT + this.f516a.m8954b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m9058a() + "; type=" + m9060a() + "; from=" + g() + " ]";
    }

    public eq() {
        this.f518a = 2;
        this.f520b = f514a;
        this.f517a = null;
        this.f519b = System.currentTimeMillis();
        this.f516a = new Cdo.a();
        this.f515a = 1;
    }

    public String f() {
        return this.f517a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9058a() {
        return this.f516a.m8957c();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m9064b() {
        return this.f516a.m8953b();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m9067c() {
        return this.f516a.m8949a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9061a() {
        return this.f516a.j();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m9065b() {
        return this.f516a.m8959d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m9068c() {
        return this.f516a.m8963f();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m9062a() {
        return er.a(this, this.f520b);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9066b() {
        return this.f516a.l();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m9057a() {
        return this.f519b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short m9060a() {
        return this.f518a;
    }

    public static eq a(ByteBuffer r100) {
        ByteBuffer r101 = r100.slice();     // Catch: Exception -> L4
        short r102 = r101.getShort(0);     // Catch: Exception -> L4
        short r103 = r101.getShort(2);     // Catch: Exception -> L4
        int r104 = r101.getInt(4);     // Catch: Exception -> L4
        Cdo.a r105 = new Cdo.a();     // Catch: Exception -> L4
        r105.a(r101.array(), r101.arrayOffset() + 8, r103);     // Catch: Exception -> L4
        byte[] r106 = new byte[r104];     // Catch: Exception -> L4
        r101.position(r103 + 8);     // Catch: Exception -> L4
        r101.get(r106, 0, r104);     // Catch: Exception -> L4
        return new eq(r105, r102, r106);
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("read Blob err :" + e.getMessage());
        throw new IOException("Malformed Input");
    }

    public void b(long r100) {
        this.f516a.b(r100);
    }

    public void c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        int r101 = r100.indexOf("@");
        long r102 = CastLongProtector.parseLong(r100.substring(0, r101));     // Catch: Exception -> L7
        int r103 = r100.indexOf(HTTP.URL_DEFAULT, r101);     // Catch: Exception -> L7
        String r104 = r100.substring(r101 + 1, r103);     // Catch: Exception -> L7
        String r105 = r100.substring(r103 + 1);     // Catch: Exception -> L7
        this.f516a.a(r102);     // Catch: Exception -> L7
        this.f516a.a(r104);     // Catch: Exception -> L7
        this.f516a.b(r105);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Blob parse user err " + e.getMessage());
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m9063a(String r100) {
        if (this.f516a.e() != 1) goto L7;
        return er.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(r100, e()), this.f520b));
    L7:
        if (this.f516a.e() == 0) goto L9;
        com.xiaomi.channel.commonutils.logger.b.m8718a("unknow cipher = " + this.f516a.e());
        return er.a(this, this.f520b);
    L9:
        return er.a(this, this.f520b);
    }

    public void b(String r100) {
        this.f517a = r100;
    }

    public void c(long r100) {
        this.f516a.c(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo9059a(ByteBuffer r100) {
        if (r100 != null) goto L4;
        r100 = ByteBuffer.allocate(c());
    L4:
        r100.putShort(this.f518a);
        r100.putShort((short) this.f516a.a());
        r100.putInt(this.f520b.length);
        int r101 = r100.position();
        this.f516a.m9041a(r100.array(), r100.arrayOffset() + r101, this.f516a.a());
        r100.position(r101 + this.f516a.a());
        r100.put(this.f520b);
        return r100;
    }

    public void a(int r100) {
        this.f516a.a(r100);
    }

    public void a(long r100) {
        this.f516a.a(r100);
    }

    public void a(String r100) {
        this.f516a.e(r100);
    }

    public void a(short r100) {
        this.f518a = r100;
    }

    public static eq a(fn r100, String r101) {
        eq r102 = new eq();
        int r103 = CastIntegerProtector.parseInt(r100.k());     // Catch: Exception -> L5
    L7:
        r102.a(r103);
        r102.a(r100.j());
        r102.c(r100.m());
        r102.b(r100.n());
        r102.a("XMLMSG", null);
        r102.a(r100.mo9099a().getBytes("utf8"), r101);     // Catch: UnsupportedEncodingException -> L13
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r102.a(3);     // Catch: UnsupportedEncodingException -> L13
    L18:
    L15:
        return r102;
    L11:
        r102.a(2);     // Catch: UnsupportedEncodingException -> L13
        r102.a("SECMSG", null);     // Catch: UnsupportedEncodingException -> L13
    L13:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Blob setPayload err： " + e.getMessage());
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Blob parse chid err " + e.getMessage());
        r103 = 1;
        goto L7
    }

    public void a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.f516a.c(r100);
        this.f516a.m8950a();
        if (TextUtils.isEmpty(r101) == true) goto L10;
        this.f516a.d(r101);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("command should not be empty");
    }

    public void a(byte[] r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.f516a.c(1);
        this.f520b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(r101, e()), r100);
        return;
    L5:
        this.f516a.c(0);
        this.f520b = r100;
    }

    public eq(Cdo.a r100, short r101, byte[] r102) {
        this.f518a = 2;
        this.f520b = f514a;
        this.f517a = null;
        this.f519b = System.currentTimeMillis();
        this.f516a = r100;
        this.f518a = r101;
        this.f520b = r102;
        this.f515a = 2;
    }

    public void a(long r100, String r101, String r102) {
        if (r100 == 0) goto L6;
        this.f516a.a(r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.f516a.a(r101);
    L9:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        this.f516a.b(r102);
        return;
    }
}
