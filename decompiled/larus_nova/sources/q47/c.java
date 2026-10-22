package q47;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f531646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f531647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f531648c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q47.a f531649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f531650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f531651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f531652d;

        public final void a() throws IOException {
            if (this.f531651c.get() == false) goto L5;
            return;
        L5:
            int r100 = this.f531649a.a();
            InputStream r101 = this.f531650b;
            monitor-enter(r101);
        L22:
            th = move-exception;
            throw th;
        L8:
            if (r100 >= this.f531649a.a()) goto L11;
            monitor-exit(r101);     // Catch: Throwable -> L22
            return;
        L11:
            int r102 = this.f531650b.available();     // Catch: Throwable -> L22
            if (r102 >= 2) goto L14;
            r102 = 1024;
        L14:
            byte[] r103 = new byte[Math.min(r102, 1024)];     // Catch: Throwable -> L22
        L15:
            int r104 = this.f531650b.read(r103);     // Catch: Throwable -> L22
            if (r104 == (-1)) goto L17;
            this.f531649a.b(r103, r104);     // Catch: Throwable -> L22
            if (r104 == 0) goto L15;
        L20:
            monitor-exit(r101);     // Catch: Throwable -> L22
            return;
        L17:
            this.f531651c.set(true);     // Catch: Throwable -> L22
            goto L20
        }

        public a(InputStream r100) {
            this.f531649a = new q47.a();
            this.f531650b = r100;
            this.f531651c = new AtomicBoolean(false);
            this.f531652d = new AtomicInteger(0);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    public final c a() {
        a r100 = this.f531646a;
        r100.f531652d.incrementAndGet();
        return new c(r100);
    }

    @Override // java.io.InputStream
    public final int available() {
        return Math.max(this.f531646a.f531649a.a() - this.f531647b, 2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a r100 = this.f531646a;
        if (r100.f531652d.decrementAndGet() > 0) goto L14;
        r100.f531650b.close();
        q47.a r101 = r100.f531649a;
        int r102 = r101.a();
        if (r102 < 0) goto L13;
        r101.f531634a.lock();
        r101.f531636c.a(r102);     // Catch: Throwable -> L9
        r101.f531634a.unlock();
        return;
    L9:
        th = move-exception;
        r101.f531634a.unlock();
        throw th;
    L13:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f531646a.f531652d.get() > 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L32;
        if (this.f531647b < this.f531646a.f531649a.a()) goto L11;
        this.f531646a.a();
    L11:
        if (this.f531646a.f531651c.get() == true) goto L13;
    L16:
        q47.a r101 = this.f531646a.f531649a;
        int r102 = this.f531647b;
        this.f531647b = r102 + 1;
        if (r102 < 0) goto L29;
        r101.f531635b.lock();
        b r103 = r101.f531636c.c(r102);     // Catch: Throwable -> L26
        if (r103.hasNext() == false) goto L25;
        q47.a.C7277a r104 = (q47.a.C7277a) r103.next();     // Catch: Throwable -> L26
        byte r105 = r104.f531637a[r102 - r104.f531638b];     // Catch: Throwable -> L26
        r101.f531635b.unlock();
        return r105 & UByte.MAX_VALUE;
    L25:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r101.f531635b.unlock();
        throw th;
    L29:
        r101.getClass();
        throw new IndexOutOfBoundsException();
    L13:
        if (this.f531647b < this.f531646a.f531649a.a()) goto L16;
        return -1;
    L32:
        throw new IOException();
    L5:
        r100 = false;
        goto L6
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f531647b = this.f531648c;
    }

    public c(InputStream r100) {
        a r101 = new a(r100);
        r101.f531652d.incrementAndGet();
        this(r101);
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        this.f531648c = this.f531647b;
    }

    public c(a r100) {
        this.f531647b = 0;
        this.f531648c = 0;
        this.f531646a = r100;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r110, int r111, int r112) throws IOException {
        r110.getClass();
        if (r111 < 0) goto L50;
        if (r112 < 0) goto L50;
        if (r112 > (r110.length - r111)) goto L50;
        if (this.f531646a.f531652d.get() > 0) goto L10;
        boolean r100 = true;
    L11:
        if (r100 == true) goto L48;
        int r113 = Math.min(r110.length - r111, r112);
        int r101 = 0;
    L13:
        if (r101 >= r113) goto L46;
        if (this.f531647b < this.f531646a.f531649a.a()) goto L23;
        if (r101 > 0) goto L17;
        if (this.f531646a.f531651c.get() == true) goto L20;
        this.f531646a.a();
        goto L23
    L20:
        return -1;
    L17:
        return r101;
    L23:
        q47.a r102 = this.f531646a.f531649a;
        int r103 = this.f531647b;
        int r104 = r111 + r101;
        int r105 = r113 - r101;
        r102.getClass();
        if (r103 < 0) goto L45;
        if (r105 < 0) goto L45;
        if (r104 > r110.length) goto L45;
        if (r105 > (r110.length - r104)) goto L45;
        int r106 = Math.min(r105, r110.length - r104);
        r102.f531635b.lock();
        b r107 = r102.f531636c.c(r103);     // Catch: Throwable -> L41
        int r108 = 0;
    L32:
        if (r108 >= r106) goto L40;
        if (r107.hasNext() == false) goto L40;
        q47.a.C7277a r109 = (q47.a.C7277a) r107.next();     // Catch: Throwable -> L41
        int r114 = r109.f531639c;     // Catch: Throwable -> L41
        int r115 = r103 - r109.f531638b;     // Catch: Throwable -> L41
        int r116 = r114 - r115;     // Catch: Throwable -> L41
        int r117 = r116 + r108;     // Catch: Throwable -> L41
        if (r117 <= r106) goto L37;
        int r118 = r106 - r108;     // Catch: Throwable -> L41
        System.arraycopy(r109.f531637a, r115, r110, r108 + r104, r118);     // Catch: Throwable -> L41
        r103 = r103 + r118;
        r108 = r106;
        goto L32
    L37:
        System.arraycopy(r109.f531637a, r115, r110, r108 + r104, r116);     // Catch: Throwable -> L41
        r103 = r103 + r116;     // Catch: Throwable -> L41
        r108 = r117;
    L40:
        r102.f531635b.unlock();
        r101 = r101 + r108;
        this.f531647b += r108;
    L41:
        th = move-exception;
        r102.f531635b.unlock();
        throw th;
    L45:
        throw new IndexOutOfBoundsException();
    L46:
        return r101;
    L48:
        throw new IOException();
    L10:
        r100 = false;
    L50:
        throw new IndexOutOfBoundsException();
    }
}
