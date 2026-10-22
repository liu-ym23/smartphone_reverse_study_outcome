package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.xiaomi.push.if, reason: invalid class name */
/* JADX INFO: loaded from: classes41.dex */
public class Cif extends hv {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f464110b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f464111c = 10000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f464112d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f464113e = 10485760;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f464114f = 104857600;

    /* JADX INFO: renamed from: com.xiaomi.push.if$a */
    public static class a extends hv.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hv.a, com.xiaomi.push.ib
        public hz a(ij r100) {
            Cif r101 = new Cif(r100, this.f949a, this.f464094b);
            int r102 = this.f464093a;
            if (r102 == 0) goto L5;
            r101.b(r102);
        L5:
            return r101;
        }

        public a(boolean r100, boolean r101, int r102) {
            super(r100, r101, r102);
        }
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* JADX INFO: renamed from: a */
    public String mo9276a() {
        int r100 = mo9269a();
        if (r100 > f464113e) goto L13;
        if (this.f464099a.b() < r100) goto L11;
        String r101 = new String(this.f464099a.a(), this.f464099a.a_(), r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L8
        this.f464099a.a(r100);     // Catch: UnsupportedEncodingException -> L8
        return r101;
    L9:
        throw new ht("JVM DOES NOT SUPPORT UTF-8");
    L11:
        return a(r100);
    L13:
        throw new ia(3, "Thrift string size " + r100 + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo9277a() {
        int r100 = mo9269a();
        if (r100 > f464114f) goto L11;
        c(r100);
        if (this.f464099a.b() < r100) goto L8;
        ByteBuffer r101 = ByteBuffer.wrap(this.f464099a.a(), this.f464099a.a_(), r100);
        this.f464099a.a(r100);
        return r101;
    L8:
        byte[] r102 = new byte[r100];
        this.f464099a.b(r102, 0, r100);
        return ByteBuffer.wrap(r102);
    L11:
        throw new ia(3, "Thrift binary size " + r100 + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* JADX INFO: renamed from: a */
    public hy mo9273a() {
        byte r100 = a();
        byte r101 = a();
        int r102 = mo9269a();
        if (r102 > f464110b) goto L7;
        return new hy(r100, r101, r102);
    L7:
        throw new ia(3, "Thrift map size " + r102 + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* JADX INFO: renamed from: a */
    public hx mo9272a() {
        byte r100 = a();
        int r101 = mo9269a();
        if (r101 > f464111c) goto L7;
        return new hx(r100, r101);
    L7:
        throw new ia(3, "Thrift list size " + r101 + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* JADX INFO: renamed from: a */
    public id mo9274a() {
        byte r100 = a();
        int r101 = mo9269a();
        if (r101 > f464112d) goto L7;
        return new id(r100, r101);
    L7:
        throw new ia(3, "Thrift set size " + r101 + " out of range!");
    }

    public Cif(ij r100, boolean r101, boolean r102) {
        super(r100, r101, r102);
    }
}
