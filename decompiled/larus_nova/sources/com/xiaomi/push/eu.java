package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes41.dex */
public class eu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f463504a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte f533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f463505b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f463506a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final d f536a = null;

        static {
            f463506a = new c();
            f536a = new d();
        }

        public static byte[] a(byte[] r100) {
            return a(r100, f536a);
        }

        public static byte[] a(byte[] r100, b r101) {
            if (eu.m9072a(r100) == false) goto L13;
            eu r102 = eu.a(r100);
            if (eu.a(r102) == 0) goto L12;
            if (eu.a(r102) != r101.a()) goto L12;
            return r101.a(eu.m9073a(r102), eu.m9071a(r102));
        L12:
            return eu.m9073a(r102);
        L13:
            return r100;
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] r100, int r101);
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements b {
        public d() {
        }

        @Override // com.xiaomi.push.eu.b
        public byte a() {
            return 2;
        }

        @Override // com.xiaomi.push.eu.b
        public byte[] a(byte[] r100, int r101) {
            GZIPInputStream r102 = null;
            GZIPInputStream r103 = new GZIPInputStream(new ByteArrayInputStream(r100), r101);     // Catch: Throwable -> L10 IOException -> L14
            byte[] r104 = new byte[r101];     // Catch: Throwable -> L7 IOException -> L9
            r103.read(r104);     // Catch: Throwable -> L7 IOException -> L9
            r103.close();     // Catch: IOException -> L18
        L6:
            return r104;
        L9:
            r102 = r103;
        L7:
            th = th;
            r102 = r103;
        L11:
            if (r102 != null) goto L25;
        L13:
            throw th;
        L25:
            r102.close();     // Catch: IOException -> L19
            goto L13
        L10:
            th = th;
        L15:
            if (r102 != null) goto L21;
        L17:
            return r100;
        L21:
            r102.close();     // Catch: IOException -> L20
            goto L17
        }
    }

    static {
        f463504a = new byte[]{80, 85, 83, 72};
    }

    public static eu a(byte[] r100) {
        if (m9072a(r100) == false) goto L7;
        ByteBuffer r101 = ByteBuffer.wrap(r100).order(ByteOrder.BIG_ENDIAN);
        r101.getInt();
        short r102 = r101.getShort();
        byte r103 = r101.get();
        int r104 = r101.getInt();
        byte[] r105 = new byte[r101.getInt()];
        r101.get(r105);
        return a(r102, r103, r104, r105);
    L7:
        return a((byte) 0, r100.length, r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9072a(byte[] r100) {
        byte[] r101 = f463504a;
        return a(r101, r100, r101.length);
    }

    public static /* synthetic */ byte a(eu r100) {
        return r100.f533a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ int m9071a(eu r100) {
        return r100.f534a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ byte[] m9073a(eu r100) {
        return r100.f463505b;
    }

    public eu(byte r100, int r101, byte[] r102) {
        this(1, r100, r101, r102);
    }

    public static boolean a(byte[] r100, byte[] r101, int r102) {
        if (r100.length >= r102) goto L5;
    L15:
        return false;
    L5:
        if (r101.length < r102) goto L15;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (r100[r103] != r101[r103]) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static eu a(byte r100, int r101, byte[] r102) {
        return new eu(r100, r101, r102);
    }

    public eu(short r100, byte r101, int r102, byte[] r103) {
        this.f535a = r100;
        this.f533a = r101;
        this.f534a = r102;
        this.f463505b = r103;
    }

    public static eu a(short r100, byte r101, int r102, byte[] r103) {
        return new eu(r100, r101, r102, r103);
    }
}
