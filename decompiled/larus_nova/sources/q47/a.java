package q47;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock.WriteLock f531634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f531635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f531636c;

    /* JADX INFO: renamed from: q47.a$a, reason: collision with other inner class name */
    public static final class C7277a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f531637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f531638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f531639c;

        public C7277a(byte[] r100, int r101, int r102) {
            this.f531637a = r100;
            this.f531638b = r101;
            this.f531639c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C7277a[] f531640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f531641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f531642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f531643d;

        public b() {
            this.f531640a = new C7277a[8192];
            this.f531641b = 0;
            this.f531642c = 0;
            this.f531643d = 0;
        }

        public final void a(int r100) {
            if (r100 < this.f531643d) goto L5;
            int r101 = this.f531642c;
        L6:
            if (r101 >= 0) goto L8;
            return;
        L8:
            int r102 = this.f531641b;
            int r103 = r102 + r101;
            C7277a[] r104 = this.f531640a;
            if (r103 >= r104.length) goto L11;
            Arrays.fill(r104, r102, r103, null);
            this.f531641b += r101;
        L12:
            this.f531642c -= r101;
            return;
        L11:
            int r105 = r101 - (r104.length - r102);
            Arrays.fill(r104, r102, r104.length, null);
            Arrays.fill(this.f531640a, 0, r105, null);
            this.f531641b = r105;
            goto L12
        L5:
            r101 = b(r100);
            goto L6
        }

        public final int b(int r100) {
            int r101 = this.f531642c - 1;
            int r102 = 0;
        L3:
            if (r102 > r101) goto L11;
            int r103 = ((r101 - r102) / 2) + r102;
            int r104 = this.f531641b + r103;
            C7277a[] r105 = this.f531640a;
            C7277a r106 = r105[r104 % r105.length];
            int r107 = r106.f531638b;
            if (r100 < r107) goto L6;
            if (r100 < (r107 + r106.f531639c)) goto L10;
            r102 = r103 + 1;
            goto L3
        L10:
            return r103;
        L6:
            r101 = r103 - 1;
            goto L3
        L11:
            return -1;
        }

        public final q47.b c(int r100) throws IOException {
            C7277a r101 = this.f531640a[this.f531641b];
            if (r101 == null) goto L5;
        L6:
            if (r101 == null) goto L13;
            if (r100 >= r101.f531638b) goto L13;
        L11:
            throw new IOException("Attempt to read the cache which has been cleared; Only clear the cache when it will not be read anymore!");
        L13:
            return new q47.b(this, r100);
        L5:
            if (r100 < this.f531643d) goto L11;
            goto L6
        }

        public final void d(byte[] r100, int r101) {
            int r102 = this.f531642c;
            C7277a[] r103 = this.f531640a;
            if (r102 < r103.length) goto L6;
            C7277a[] r104 = new C7277a[r103.length * 2];
            int r105 = this.f531641b;
            System.arraycopy(r103, r105, r104, 0, r103.length - r105);
            C7277a[] r106 = this.f531640a;
            int r107 = r106.length;
            int r108 = this.f531641b;
            System.arraycopy(r106, 0, r104, r107 - r108, r108);
            this.f531640a = r104;
            this.f531641b = 0;
        L6:
            int r109 = this.f531641b;
            int r110 = this.f531642c;
            C7277a[] r111 = this.f531640a;
            int r112 = (r109 + r110) % r111.length;
            int r113 = this.f531643d;
            r111[r112] = new C7277a(r100, r113, r101);
            this.f531643d = r113 + r101;
            this.f531642c = r110 + 1;
        }
    }

    public final int a() {
        this.f531635b.lock();
        int r100 = this.f531636c.f531643d;     // Catch: Throwable -> L6
        this.f531635b.unlock();
        return r100;
    L6:
        th = move-exception;
        this.f531635b.unlock();
        throw th;
    }

    public a() {
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        this.f531634a = r100.writeLock();
        this.f531635b = r100.readLock();
        this.f531636c = new b();
    }

    public final void b(byte[] r100, int r101) {
        if (r101 < 0) goto L18;
        if (r101 > r100.length) goto L18;
        if (r100.length == 0) goto L16;
        if (r101 == 0) goto L21;
        this.f531634a.lock();
        this.f531636c.d(r100, r101);     // Catch: Throwable -> L13
        this.f531634a.unlock();
        return;
    L13:
        th = move-exception;
        this.f531634a.unlock();
        throw th;
    L21:
        return;
    L16:
        return;
    L18:
        throw new IndexOutOfBoundsException();
    }
}
