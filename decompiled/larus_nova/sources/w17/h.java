package w17;

import com.bytedance.memory.shrink.BaseType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f557933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w17.b f557934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f557935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteArrayOutputStream f557936e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f557937a = null;

        static {
            int[] r100 = new int[BaseType.values().length];
            f557937a = r100;
            r100[BaseType.OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f557937a[BaseType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f557937a[BaseType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f557937a[BaseType.CHAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f557937a[BaseType.SHORT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f557937a[BaseType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f557937a[BaseType.INT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f557937a[BaseType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f557937a[BaseType.LONG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f557938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f557939b;

        @Override // w17.d
        public final void a() {
            this.f557939b.f557933b.write(this.f557938a);     // Catch: Throwable -> L4
            h r100 = this.f557939b;     // Catch: Throwable -> L4
            r100.f557933b.write(r100.f557936e.toByteArray());     // Catch: Throwable -> L4
            this.f557939b.f557936e.reset();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void f(e r100) {
            this.f557939b.f557936e.write(3);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void g(e r100) {
            this.f557939b.f557936e.write(2);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void h(e r100) {
            this.f557939b.f557936e.write(142);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void i(e r100) {
            this.f557939b.f557936e.write(4);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void l(e r100) {
            this.f557939b.f557936e.write(6);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void m(e r100) {
            this.f557939b.f557936e.write(8);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        public b(h r100, int r101) {
            this.f557939b = r100;
            this.f557938a = r101;
        }

        @Override // w17.d
        public final void b(int r100, e r101) {
            this.f557939b.f557936e.write(r100);     // Catch: Throwable -> L6
            this.f557939b.f557936e.write(r101.f557929a);     // Catch: Throwable -> L6
            if (r100 != 1) goto L11;
            h r102 = this.f557939b;     // Catch: Throwable -> L6
            i.h(r102.f557936e, r102.f557935d);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void d(int r100, e r101) {
            this.f557939b.f557936e.write(254);     // Catch: Throwable -> L4
            i.i(this.f557939b.f557936e, r100);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r101.f557929a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        public final byte[] o(e r100, byte[] r101) {
            if (this.f557939b.f557934c != null) goto L5;
            return r101;
        L5:
            ByteArrayInputStream r102 = new ByteArrayInputStream(r101);
            ByteArrayOutputStream r103 = new ByteArrayOutputStream();
            w17.a r104 = this.f557939b.f557934c.f557918b.get(r100);
        L6:
            if (r104 == null) goto L21;
            int r105 = 0;
            if (r104.f557915a.equals(this.f557939b.f557934c.f557922f) == true) goto L12;
            c[] r106 = r104.f557917c;     // Catch: IOException -> L17
            int r107 = r106.length;     // Catch: IOException -> L17
        L10:
            if (r105 >= r107) goto L16;
            n(r102, r103, BaseType.getType(r106[r105].f557926a));     // Catch: IOException -> L17
            r105 = r105 + 1;     // Catch: IOException -> L17
        L16:
            r104 = this.f557939b.f557934c.f557918b.get(r104.f557916b);
            goto L6
        L12:
            c[] r108 = r104.f557917c;     // Catch: IOException -> L17
            int r109 = r108.length;     // Catch: IOException -> L17
            int r110 = 0;
        L13:
            if (r110 >= r109) goto L15;
            i.m(r103, i.f(r102, BaseType.getType(r108[r110].f557926a), this.f557939b.f557935d));     // Catch: IOException -> L17
            r110 = r110 + 1;     // Catch: IOException -> L17
            goto L13
        L15:
            r17.c.b("find a activity skip erase " + r104.f557915a, new Object[0]);     // Catch: IOException -> L17
        L17:
            e = move-exception;
            throw new RuntimeException(e);
        L21:
            return r103.toByteArray();
        }

        @Override // w17.d
        public final void e(e r100, e r101, byte[] r102) {
            this.f557939b.f557936e.write(33);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r101.f557929a);     // Catch: Throwable -> L4
            i.i(this.f557939b.f557936e, r102.length);     // Catch: Throwable -> L4
            byte[] r103 = o(r101, r102);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r103);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        public final void n(ByteArrayInputStream r100, ByteArrayOutputStream r101, BaseType r102) throws IOException {
            switch(a.f557937a[r102.ordinal()]) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L5;
                case 9: goto L5;
                default: goto L15;
            };
        L5:
            i.b(r100);
            i.j(r101, 0);
            return;
        L6:
            i.a(r100);
            i.i(r101, 0);
            return;
        L7:
            i.c(r100);
            i.k(r101, 0);
            return;
        L8:
            r100.read();
            r101.write(0);
            return;
        L9:
            r101.write(i.e(r100, this.f557939b.f557935d).f557929a);
            return;
        }

        @Override // w17.d
        public final void j(e r100, int r101, e r102, byte[] r103) {
            this.f557939b.f557936e.write(34);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L4
            i.i(this.f557939b.f557936e, r101);     // Catch: Throwable -> L4
            this.f557939b.f557936e.write(r102.f557929a);     // Catch: Throwable -> L4
            h r104 = this.f557939b;     // Catch: Throwable -> L4
            int r105 = r101 * r104.f557935d;     // Catch: Throwable -> L4
            r104.f557936e.write(r103, 0, r105);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void k(int r100, e r101, int r102, int r103) {
            this.f557939b.f557936e.write(r100);     // Catch: Throwable -> L8
            this.f557939b.f557936e.write(r101.f557929a);     // Catch: Throwable -> L8
            i.i(this.f557939b.f557936e, r102);     // Catch: Throwable -> L8
            this.f557939b.f557936e.write(r103);     // Catch: Throwable -> L8
            BaseType r104 = BaseType.getType(r103);     // Catch: Throwable -> L8
            if (r104 != BaseType.CHAR) goto L5;
            return;
        L5:
            if (r104 == BaseType.BYTE) goto L14;
            i.h(this.f557939b.f557936e, r102 * BaseType.getType(r103).getSize(this.f557939b.f557935d));     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L8:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // w17.d
        public final void c(e r100, int r101, e r102, e r103, int r104, c[] r105, c[] r106) {
            this.f557939b.f557936e.write(32);     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r100.f557929a);     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r102.f557929a);     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r103.f557929a);     // Catch: Throwable -> L14
            h r107 = this.f557939b;     // Catch: Throwable -> L14
            i.h(r107.f557936e, r107.f557935d << 1);     // Catch: Throwable -> L14
            i.k(this.f557939b.f557936e, r104);     // Catch: Throwable -> L14
            int r108 = 0;
            i.k(this.f557939b.f557936e, 0);     // Catch: Throwable -> L14
            i.k(this.f557939b.f557936e, r105.length);     // Catch: Throwable -> L14
            int r109 = r105.length;     // Catch: Throwable -> L14
            int r110 = 0;
        L3:
            if (r110 >= r109) goto L9;
            c r111 = r105[r110];     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r111.f557927b.f557929a);     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r111.f557926a);     // Catch: Throwable -> L14
            h r112 = this.f557939b;     // Catch: Throwable -> L14
            if (r112.f557934c == null) goto L7;
            i.l(r112.f557936e, r111.f557928c);     // Catch: Throwable -> L14
        L8:
            r110 = r110 + 1;     // Catch: Throwable -> L14
            goto L3
        L7:
            i.m(r112.f557936e, r111.f557928c);     // Catch: Throwable -> L14
            goto L8
        L9:
            i.k(this.f557939b.f557936e, r106.length);     // Catch: Throwable -> L14
            int r113 = r106.length;     // Catch: Throwable -> L14
        L10:
            if (r108 >= r113) goto L13;
            c r114 = r106[r108];     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r114.f557927b.f557929a);     // Catch: Throwable -> L14
            this.f557939b.f557936e.write(r114.f557926a);     // Catch: Throwable -> L14
            r108 = r108 + 1;
            goto L10
        L13:
            return;
        L14:
            th = move-exception;
            throw new RuntimeException(th);
        }
    }

    @Override // w17.g
    public final void e(e r100, e r101, e r102, e r103, int r104, int r105, int r106, long r107) {
    }

    @Override // w17.g
    public final void f(int r100, int r101, e[] r102, int r103, long r104) {
    }

    @Override // w17.g
    public final void a() {
        this.f557933b.flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public h(OutputStream r100, w17.b r101) {
        super(null);
        this.f557935d = 0;
        this.f557936e = new ByteArrayOutputStream();
        this.f557933b = r100;
        this.f557934c = r101;
    }

    @Override // w17.g
    public final void b(String r100, int r101, long r102) {
        this.f557935d = r101;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // w17.g
    public final d c(int r100, int r101, long r102) {
        return new b(this, r100);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // w17.g
    public final void g(e r100, String r101, int r102, long r103) {
        this.f557933b.write(1);     // Catch: Throwable -> L4
        i.k(this.f557933b, (int) r103);     // Catch: Throwable -> L4
        this.f557933b.write(r100.f557929a);     // Catch: Throwable -> L4
        OutputStream r104 = this.f557933b;     // Catch: Throwable -> L4
        byte[] r105 = r101.getBytes(Charset.forName("UTF-8"));     // Catch: Throwable -> L4
        r104.write(r105, 0, r105.length);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // w17.g
    public final void h(int r100, int r101, long r102, byte[] r103) {
        if (r100 == 44) goto L10;
        return;
    L10:
        this.f557933b.write(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // w17.g
    public final void d(int r100, e r101, int r102, e r103, int r104, long r105) {
        this.f557933b.write(2);     // Catch: Throwable -> L4
        this.f557933b.write(r101.f557929a);     // Catch: Throwable -> L4
        this.f557933b.write(r103.f557929a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
