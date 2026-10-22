package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final n f461830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f461831b = null;

    /* JADX INFO: renamed from: com.tencent.open.utils.b$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Properties f461832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte[] f461833b;

        public String toString() {
            return "ApkExternalInfo [p=" + this.f461832a + ", otherData=" + Arrays.toString(this.f461833b) + "]";
        }

        private a() {
            this.f461832a = new Properties();
        }

        public /* synthetic */ a(AnonymousClass1 r100) {
            this();
        }

        public void a(byte[] r100) throws IOException {
            if (r100 != null) goto L4;
            return;
        L4:
            ByteBuffer r101 = ByteBuffer.wrap(r100);
            int r102 = b.a().a().length;
            byte[] r103 = new byte[r102];
            r101.get(r103);
            if (b.a().equals(new o(r103)) == false) goto L17;
            if ((r100.length - r102) > 2) goto L9;
            return;
        L9:
            byte[] r104 = new byte[2];
            r101.get(r104);
            int r105 = new o(r104).b();
            if (((r100.length - r102) - 2) >= r105) goto L12;
            return;
        L12:
            byte[] r106 = new byte[r105];
            r101.get(r106);
            this.f461832a.load(new ByteArrayInputStream(r106));
            int r107 = ((r100.length - r102) - r105) - 2;
            if (r107 <= 0) goto L18;
            byte[] r108 = new byte[r107];
            this.f461833b = r108;
            r101.get(r108);
            return;
        L18:
            return;
        L17:
            throw new ProtocolException("unknow protocl [" + Arrays.toString(r100) + "]");
        }
    }

    static {
        f461830a = new n(101010256);
        f461831b = new o(38651);
    }

    public static /* synthetic */ o a() {
        return f461831b;
    }

    private static byte[] a(RandomAccessFile r100) throws IOException {
        long r101 = r100.length() - 22;
        r100.seek(r101);
        byte[] r102 = f461830a.a();
        int r103 = r100.read();
    L3:
        boolean r104 = false;
        if (r103 == (-1)) goto L15;
        if (r103 != r102[0]) goto L14;
        r104 = true;
        if (r100.read() != r102[1]) goto L14;
        if (r100.read() != r102[2]) goto L14;
        if (r100.read() == r102[3]) goto L15;
    L14:
        r101 = r101 - 1;
        r100.seek(r101);
        r103 = r100.read();
    L15:
        if (r104 == false) goto L23;
        r100.seek((r101 + 16) + 4);
        byte[] r105 = new byte[2];
        r100.readFully(r105);
        int r106 = new o(r105).b();
        if (r106 != 0) goto L20;
        return null;
    L20:
        byte[] r107 = new byte[r106];
        r100.read(r107);
        return r107;
    L23:
        throw new ZipException("archive is not a ZIP archive");
    }

    public static String a(File r100) throws IOException {
        return a(r100, "channelNo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(File r100, String r101) throws IOException {
        RandomAccessFile r102 = null;
        Object[] r103 = 0;
        RandomAccessFile r104 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L13
        byte[] r105 = a(r104);     // Catch: Throwable -> L11
        if (r105 != null) goto L8;
        r104.close();
        return null;
    L8:
        a r106 = new a(r103 == true ? 1 : 0);     // Catch: Throwable -> L11
        r106.a(r105);     // Catch: Throwable -> L11
        String r107 = r106.f461832a.getProperty(r101);     // Catch: Throwable -> L11
        r104.close();
        return r107;
    L11:
        th = th;
        r102 = r104;
    L14:
        if (r102 == null) goto L16;
        r102.close();
    L16:
        throw th;
    L13:
        th = th;
        goto L14
    }
}
