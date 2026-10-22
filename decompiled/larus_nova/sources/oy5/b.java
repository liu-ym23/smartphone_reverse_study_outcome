package oy5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ny5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f527128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f527129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f527130c;

    @Override // ny5.a
    public final void finish() {
    }

    @Override // ny5.a
    public final int read() throws IOException {
        byte[] r100 = new byte[1];
        if (read(r100, 0, 1) > 0) goto L6;
        return -1;
    L6:
        return r100[0];
    }

    @Override // ny5.a
    public final void c() throws IOException {
        if (this.f527129b.get() == true) goto L6;
        return;
    L6:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final long length() throws IOException {
        RandomAccessFile r100 = this.f527128a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L6:
        return r100.length();
    }

    @Override // ny5.a
    public final long position() throws IOException {
        if (this.f527129b.get() == true) goto L10;
        RandomAccessFile r100 = this.f527128a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L8:
        return r100.getFilePointer();
    L10:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final void release() {
        if (this.f527129b.getAndSet(true) == false) goto L5;
        return;
    L5:
        RandomAccessFile r100 = this.f527128a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L8:
        ez5.b.a(r100);
    }

    @Override // ny5.a
    public final void b() {
        release();
        a().delete();
    }

    @Override // ny5.a
    public final File a() {
        return this.f527130c;
    }

    public b(File r110) {
        this.f527130c = r110;
        this.f527129b = new AtomicBoolean(false);
        boolean r100 = r110.getParentFile().mkdirs();
        RandomAccessFile r101 = new RandomAccessFile(r110, "rw");     // Catch: Exception -> L5
    L14:
        this.f527128a = r101;
        return;
    L5:
        e = move-exception;
        boolean r102 = this.f527130c.getParentFile().exists();
        RandomAccessFile r103 = this.f527128a;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L9:
        ez5.b.a(r103);
        if ((e instanceof FileNotFoundException) == false) goto L22;
        boolean r104 = this.f527130c.getParentFile().mkdirs();
        boolean r105 = this.f527130c.getParentFile().exists();
        r101 = new RandomAccessFile(this.f527130c, "rw");     // Catch: Exception -> L16
    L16:
        RandomAccessFile r106 = this.f527128a;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L19:
        ez5.b.a(r106);
        throw new IOException("create raf mSwap failed![2 dir mk:" + r104 + ",dir exist:+" + r105 + ", dir mk:" + r100 + ",dir exist:+" + r102 + "] path: " + this.f527130c.getAbsolutePath() + " caused by: " + e.getMessage(), e);
    L22:
        throw new IOException("create raf mSwap failed![1 dir mk:" + r100 + ",dir exist:+" + r102 + "] path: " + this.f527130c.getAbsolutePath() + " caused by: " + e.getMessage(), e);
    }

    @Override // ny5.a
    public final void position(long r100) throws IOException {
        if (this.f527129b.get() == true) goto L13;
        if (r100 >= 0) goto L7;
        r100 = 0;
    L7:
        RandomAccessFile r101 = this.f527128a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");
    L10:
        r101.seek(r100);
        return;
    L13:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // ny5.a
    public final synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.f527129b.get() == true) goto L18;
        int r101 = (int) r100;     // Catch: Throwable -> L19
        if (r101 != r100) goto L16;
        RandomAccessFile r102 = this.f527128a;     // Catch: Throwable -> L19
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");     // Catch: Throwable -> L19
    L12:
        long r103 = r102.skipBytes(r101);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r103;
    L16:
        throw new IOException("too large:" + r100);     // Catch: Throwable -> L19
    L18:
        throw new IOException("released!");     // Catch: Throwable -> L19
    }

    @Override // ny5.a
    public final void write(int r100) throws IOException {
        write(new byte[]{(byte) r100}, 0, 1);
    }

    @Override // ny5.a
    public final void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    @Override // ny5.a
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        if (this.f527129b.get() == true) goto L26;
        if (r102 < 1) goto L23;
        if (r101 >= 0) goto L8;
        return 0;
    L8:
        if (r101 < r100.length) goto L11;
        return 0;
    L11:
        if ((r101 + r102) <= r100.length) goto L13;
        r102 = r100.length - r101;
    L13:
        monitor-enter(this);
        RandomAccessFile r103 = this.f527128a;     // Catch: Throwable -> L20
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");     // Catch: Throwable -> L20
    L17:
        int r104 = r103.read(r100, r101, r102);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r104;
    L20:
        th = move-exception;
        throw th;
    L23:
        return 0;
    L26:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final int write(byte[] r100, int r101, int r102) throws IOException {
        if (this.f527129b.get() == true) goto L28;
        if (r100.length != 0) goto L7;
    L26:
        return 0;
    L7:
        if (r102 < 1) goto L26;
        if (r101 < 0) goto L26;
        if (r101 >= r100.length) goto L26;
        if ((r101 + r102) <= r100.length) goto L16;
        r102 = r100.length - r101;
    L16:
        monitor-enter(this);
        RandomAccessFile r103 = this.f527128a;     // Catch: Throwable -> L23
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRandomAccessFile");     // Catch: Throwable -> L23
    L20:
        r103.write(r100, r101, r102);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r102;
    L23:
        th = move-exception;
        throw th;
    L28:
        throw new IOException("released!");
    }
}
