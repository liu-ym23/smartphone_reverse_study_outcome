package oy5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements ny5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f527131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RandomAccessFile f527132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f527133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f527134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f527135e;

    @Override // ny5.a
    public final void finish() {
    }

    @Override // ny5.a
    public final int read() throws IOException {
        byte[] r100 = new byte[1];
        if (read(r100, 0, 1) != 0) goto L6;
        return -1;
    L6:
        return r100[0];
    }

    @Override // ny5.a
    public final void c() throws IOException {
        if (this.f527133c.get() == true) goto L6;
        return;
    L6:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final long position() throws IOException {
        if (this.f527133c.get() == true) goto L7;
        return this.f527131a;
    L7:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final void release() {
        if (this.f527133c.getAndSet(true) == false) goto L5;
        return;
    L5:
        ez5.b.a(this.f527132b);
    }

    @Override // ny5.a
    public final void b() {
        release();
        a().delete();
    }

    @Override // ny5.a
    public final File a() {
        return this.f527135e;
    }

    @Override // ny5.a
    public final long length() {
        return this.f527134d;
    }

    @Override // ny5.a
    public final void position(long r100) throws IOException {
        if (this.f527133c.get() == true) goto L16;
        long r101 = 0;
        if (r100 >= 0) goto L7;
    L6:
        r100 = r101;
    L10:
        this.f527131a = r100;
        RandomAccessFile r102 = this.f527132b;
        if (r102 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r102.seek(this.f527131a);
        return;
    L7:
        r101 = this.f527134d;
        if (r100 <= r101) goto L10;
    L16:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // ny5.a
    public final synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.f527133c.get() == true) goto L21;
        int r101 = (int) r100;     // Catch: Throwable -> L22
        if (r101 != r100) goto L19;
        RandomAccessFile r102 = this.f527132b;     // Catch: Throwable -> L22
        if (r102 != null) goto L11;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L11:
        int r103 = r102.skipBytes(r101);     // Catch: Throwable -> L22
        RandomAccessFile r104 = this.f527132b;     // Catch: Throwable -> L22
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L14:
        this.f527131a = r104.getFilePointer();     // Catch: Throwable -> L22
        long r105 = r103;
        monitor-exit(this);
        return r105;
    L19:
        throw new IOException("too large:" + r100);     // Catch: Throwable -> L22
    L21:
        throw new IOException("released!");     // Catch: Throwable -> L22
    }

    @Override // ny5.a
    public final void write(int r100) throws IOException {
        write(new byte[]{(byte) r100}, 0, 1);
    }

    @Override // ny5.a
    public final void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public c(long r110, File r111) {
        this.f527134d = r110;
        this.f527135e = r111;
        this.f527133c = new AtomicBoolean(false);
        boolean r100 = r111.getParentFile().mkdirs();
        RandomAccessFile r101 = new RandomAccessFile(r111, "rw");     // Catch: Exception -> L5
        r101.setLength(r110);     // Catch: Exception -> L5
        this.f527132b = r101;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        boolean r112 = this.f527135e.getParentFile().exists();
        if ((e instanceof FileNotFoundException) == false) goto L14;
        boolean r113 = this.f527135e.getParentFile().mkdirs();
        boolean r102 = this.f527135e.getParentFile().exists();
        RandomAccessFile r103 = new RandomAccessFile(this.f527135e, "rw");     // Catch: Exception -> L11
        r103.setLength(this.f527134d);     // Catch: Exception -> L11
        this.f527132b = r103;     // Catch: Exception -> L11
        return;
    L11:
        ez5.b.a(this.f527132b);
        throw new IOException("create raf swap failed[2 dir mk:" + r113 + ",dir exist:+" + r102 + ", dir mk:" + r100 + ",dir exist:+" + r112 + "]! path: " + this.f527135e.getAbsolutePath() + " caused by: " + e.getMessage(), e);
    L14:
        throw new IOException("create raf swap failed[1 dir mk:" + r100 + ",dir exist:+" + r112 + "]! path: " + this.f527135e.getAbsolutePath() + " caused by: " + e.getMessage(), e);
    }

    @Override // ny5.a
    public final int read(byte[] r100, int r110, int r111) throws IOException {
        if (this.f527133c.get() == true) goto L38;
        if (r111 < 1) goto L35;
        if (r110 >= 0) goto L8;
        return 0;
    L8:
        if (r110 < r100.length) goto L11;
        return 0;
    L11:
        if ((r110 + r111) <= r100.length) goto L13;
        r111 = r100.length - r110;
    L13:
        monitor-enter(this);
        long r101 = this.f527131a;     // Catch: Throwable -> L32
        long r102 = this.f527134d;     // Catch: Throwable -> L32
        if (r101 != r102) goto L20;
        monitor-exit(this);
        return -1;
    L20:
        if ((((long) r111) + r101) <= r102) goto L22;
        r111 = (int) (r102 - r101);
    L22:
        RandomAccessFile r103 = this.f527132b;     // Catch: Throwable -> L32
        if (r103 != null) goto L25;
        Intrinsics.throwNpe();     // Catch: Throwable -> L32
    L25:
        int r104 = r103.read(r100, r110, r111);     // Catch: Throwable -> L32
        if (r104 != (-1)) goto L29;
        monitor-exit(this);
        return -1;
    L29:
        this.f527131a += (long) r104;     // Catch: Throwable -> L32
        monitor-exit(this);
        return r104;
    L32:
        th = move-exception;
        throw th;
    L35:
        return 0;
    L38:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final int write(byte[] r100, int r101, int r110) throws IOException {
        if (this.f527133c.get() == true) goto L36;
        if (r100.length != 0) goto L7;
    L34:
        return 0;
    L7:
        if (r110 < 1) goto L34;
        if (r101 < 0) goto L34;
        if (r101 >= r100.length) goto L34;
        if ((r101 + r110) <= r100.length) goto L16;
        r110 = r100.length - r101;
    L16:
        monitor-enter(this);
        long r102 = this.f527131a;     // Catch: Throwable -> L31
        long r103 = this.f527134d;     // Catch: Throwable -> L31
        if (r102 != r103) goto L23;
        monitor-exit(this);
        return 0;
    L23:
        if ((((long) r110) + r102) <= r103) goto L25;
        r110 = (int) (r103 - r102);
    L25:
        RandomAccessFile r104 = this.f527132b;     // Catch: Throwable -> L31
        if (r104 != null) goto L28;
        Intrinsics.throwNpe();     // Catch: Throwable -> L31
    L28:
        r104.write(r100, r101, r110);     // Catch: Throwable -> L31
        this.f527131a += (long) r110;     // Catch: Throwable -> L31
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(this);
        return r110;
    L31:
        th = move-exception;
        throw th;
    L36:
        throw new IOException("released!");
    }
}
