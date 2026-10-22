package jv7;

import androidx.collection.SieveCacheKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import javax.annotation.Nonnull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MappedByteBuffer f500569d;

    public static class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f500570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f500571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f500572c;

        @Override // java.io.InputStream
        public final int available() throws IOException {
            return this.f500571b - this.f500572c;
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            int r100 = this.f500572c;
            if (r100 < this.f500571b) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            return -1;
        L9:
            this.f500570a.position(r100);
            this.f500572c++;
            return this.f500570a.get() & UByte.MAX_VALUE;
        L5:
            r101 = false;
            goto L6
        }

        @Override // java.io.InputStream
        public final long skip(long r100) throws IOException {
            if (r100 > 0) goto L5;
            return 0;
        L5:
            int r101 = this.f500571b;
            int r102 = this.f500572c;
            long r103 = r101 - r102;
            if (r100 <= r103) goto L9;
            this.f500572c = r101;
            return r103;
        L9:
            this.f500572c = r102 + ((int) r100);
            return r100;
        }

        public a(ByteBuffer r100, int r101, int r102) {
            this.f500570a = r100;
            this.f500572c = r101;
            this.f500571b = r101 + r102;
        }

        @Override // java.io.InputStream
        public final int read(@Nonnull byte[] r100, int r101, int r102) throws IOException {
            int r103 = this.f500572c;
            if (r103 < this.f500571b) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L9;
            return -1;
        L9:
            this.f500570a.position(r103);
            int r105 = this.f500571b - this.f500572c;
            if (r102 <= r105) goto L12;
            r102 = r105;
        L12:
            this.f500570a.get(r100, r101, r102);
            this.f500572c += r102;
            return r102;
        L5:
            r104 = false;
            goto L6
        }
    }

    @Override // jv7.b
    public final ByteBuffer a() {
        return this.f500569d.asReadOnlyBuffer();
    }

    @Override // jv7.d, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        if (e.b() == true) goto L9;
    L6:
        this.f500569d = null;
        System.gc();
        System.runFinalization();
        return;
    L9:
        e.c(this.f500569d);     // Catch: ReflectiveOperationException -> L8
    }

    public f(File r100) throws IOException {
        super(r100, false);
        if (this.f500561b > SieveCacheKt.NodeLinkMask) goto L17;
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");
        this.f500569d = r101.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, (int) this.f500561b);     // Catch: Throwable -> L8
        r101.close();
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw new IllegalArgumentException("MappedByteSource only supports file sizes up to Integer.MAX_VALUE.");
    }

    public static d f(File r100) throws IOException {
        if (r100.length() >= SieveCacheKt.NodeLinkMask) goto L7;
        return new f(r100);
    L7:
        return new g(r100);
    }

    @Override // jv7.b
    public final InputStream d(long r100, long r101) throws IOException {
        if ((r100 + r101) > this.f500561b) goto L7;
        return new a(this.f500569d.slice().asReadOnlyBuffer(), (int) r100, (int) r101);
    L7:
        throw new IllegalArgumentException("Specified offset and length would read out of the bounds of the mapped byte buffer.");
    }
}
