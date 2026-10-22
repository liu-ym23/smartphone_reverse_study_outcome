package dh4;

import androidx.collection.SieveCacheKt;
import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends dh4.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f468593d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f468594e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f468595f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C5670b f468596g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f468597h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f468598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f468599c;

    public static abstract class a<A> {
        public a() {
        }

        public abstract void b(A r100, int r101, char[] r102, int r103, int r104);

        public abstract int c(A r100);

        public final void a(b r110, A r111) {
            int r100 = c(r111);
            char[] r101 = r110.f468598b;
            int r112 = r100;
            int r102 = r110.f468599c;
            int r103 = 0;
        L3:
            int r113 = r112 + r102;
            if (r113 < r101.length) goto L9;
            int r114 = r101.length - r102;
            b(r111, r103, r101, r102, r114);
            d r104 = r110.f468592a;
            char[] r105 = r110.f468598b;
            r104.d(r105, r105.length);
            if (r102 == 0) goto L8;
            r110.f468599c = 0;
            r102 = 0;
        L8:
            r103 = r103 + r114;
            r112 = r112 - r114;
            goto L3
        L9:
            if (r112 <= 0) goto L15;
            b(r111, r103, r101, r102, r112);
            r110.f468599c = r113;
            return;
        }
    }

    /* JADX INFO: renamed from: dh4.b$b, reason: collision with other inner class name */
    public static class C5670b extends a<char[]> {
        public C5670b() {
        }

        @Override // dh4.b.a
        public final int c(char[] r100) {
            return r100.length;
        }

        @Override // dh4.b.a
        public final void b(char[] r100, int r101, char[] r102, int r103, int r104) {
            System.arraycopy(r100, r101, r102, r103, r104);
        }
    }

    public static class c extends a<String> {
        public c() {
        }

        @Override // dh4.b.a
        public final int c(String r100) {
            return r100.length();
        }

        @Override // dh4.b.a
        public final void b(String r100, int r101, char[] r102, int r103, int r104) {
            r100.getChars(r101, r104 + r101, r102, r103);
        }
    }

    static {
        f468593d = new char[]{'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        f468594e = new char[]{'-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8'};
        f468595f = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        f468596g = new C5670b();
        f468597h = new c();
    }

    @Override // dh4.a
    public final void f() {
        int r100 = this.f468599c;
        if (r100 <= 0) goto L5;
        this.f468592a.d(this.f468598b, r100);
        this.f468599c = 0;
    L5:
        this.f468592a.flush();
        this.f468592a.release();
    }

    public b(String r100) {
        int r101 = 1024;
        char[] r102 = new char[1024];     // Catch: Throwable -> L5
    L6:
        this.f468598b = r102;
        this.f468599c = 0;
        long r103 = NativeBridge.b0(r100, r101);
        if (r103 == 0) goto L9;
        d r104 = new g(r103);
    L10:
        if (r104 != null) goto L13;
        r104 = new e(r100);
    L13:
        this.f468592a = r104;
        return;
    L9:
        r104 = null;
    L5:
        r101 = 128;
        r102 = new char[128];
        goto L6
    }

    @Override // dh4.a
    public final void a(char r100) {
        g(r100);
    }

    @Override // dh4.a
    public final void b(int r100) {
        if (r100 != Integer.MIN_VALUE) goto L5;
        e(f468593d);
        return;
    L5:
        if (r100 >= 0) goto L8;
        r100 = -r100;
        g('-');
    L8:
        if (r100 >= 100) goto L12;
        if (r100 >= 10) goto L11;
        g((char) (r100 + 48));
        return;
    L11:
        int r101 = r100 / 10;
        int r102 = r100 - (r101 * 10);
        g((char) (r101 + 48));
        g((char) (r102 + 48));
        return;
    L12:
        int r103 = 0;
    L13:
        if (r103 >= 10) goto L17;
        int r104 = f468595f[r103];
        r103 = r103 + 1;
        if (r100 > r104) goto L13;
    L18:
        int r105 = this.f468599c;
        int r106 = r105 + r103;
        char[] r107 = this.f468598b;
        if (r106 < r107.length) goto L21;
        this.f468592a.d(r107, r105);
        this.f468599c = 0;
    L21:
        int r108 = this.f468599c + r103;
        this.f468599c = r108;
        h(r100, this.f468598b, r108);
        return;
    L17:
        r103 = 11;
        goto L18
    }

    @Override // dh4.a
    public final void c(long r110) {
        if (r110 != Long.MIN_VALUE) goto L6;
        e(f468594e);
        return;
    L6:
        if (r110 >= 0) goto L9;
        r110 = -r110;
        g('-');
    L9:
        if (r110 < 100) goto L11;
        int r100 = 1;
        long r101 = 10;
    L16:
        if (r100 >= 19) goto L21;
        if (r110 < r101) goto L22;
        r101 = r101 * 10;
        r100 = r100 + 1;
    L22:
        int r102 = this.f468599c;
        int r103 = r102 + r100;
        char[] r104 = this.f468598b;
        if (r103 < r104.length) goto L25;
        this.f468592a.d(r104, r102);
        this.f468599c = 0;
    L25:
        int r105 = this.f468599c + r100;
        this.f468599c = r105;
        char[] r106 = this.f468598b;
    L27:
        if (r110 <= SieveCacheKt.NodeLinkMask) goto L29;
        long r107 = r110 / 100;
        int r111 = (int) (r110 - (((r107 << 6) + (r107 << 5)) + (r107 << 2)));
        int r112 = r111 / 10;
        int r108 = r105 - 1;
        r106[r108] = (char) ((r111 - (r112 * 10)) + 48);
        r105 = r108 - 1;
        r106[r105] = (char) (r112 + 48);
        r110 = r107;
        goto L27
    L29:
        h((int) r110, r106, r105);
        return;
    L21:
        r100 = 19;
        goto L22
    L11:
        if (r110 >= 10) goto L13;
        g((char) (r110 + 48));
        return;
    L13:
        long r109 = r110 / 10;
        g((char) (r109 + 48));
        g((char) ((r110 - (10 * r109)) + 48));
    }

    @Override // dh4.a
    public final void d(String r100) {
        f468597h.a(this, r100);
    }

    @Override // dh4.a
    public final void e(char[] r100) {
        f468596g.a(this, r100);
    }

    public final void g(char r100) {
        char[] r101 = this.f468598b;
        int r102 = this.f468599c;
        r101[r102] = r100;
        int r103 = r102 + 1;
        this.f468599c = r103;
        if (r103 != r101.length) goto L6;
        this.f468592a.d(r101, r101.length);
        this.f468599c = 0;
        return;
    }

    public static void h(int r100, char[] r101, int r102) {
    L3:
        if (r100 < 65536) goto L5;
        int r103 = r100 / 100;
        int r104 = r100 - (((r103 << 6) + (r103 << 5)) + (r103 << 2));
        int r105 = r104 / 10;
        int r106 = r102 - 1;
        r101[r106] = (char) ((r104 - (r105 * 10)) + 48);
        r102 = r106 - 1;
        r101[r102] = (char) (r105 + 48);
        r100 = r103;
    L5:
        if (r100 == 0) goto L7;
        int r107 = (52429 * r100) >>> 19;
        r102 = r102 - 1;
        r101[r102] = (char) ((r100 - ((r107 << 3) + (r107 << 1))) + 48);
        r100 = r107;
        goto L5
    }
}
