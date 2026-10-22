package com.samskivert.mustache;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a implements com.samskivert.mustache.e.InterfaceC4697e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f405706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f405707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f405708c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f405709d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f405710e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f405711f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f405712g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f405713h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C4695a f405714i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f405715j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f405716k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f405717l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f405718m = null;

    /* JADX INFO: renamed from: com.samskivert.mustache.a$a, reason: collision with other inner class name */
    public static class C4695a extends o {
        public C4695a() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((short[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Short.valueOf(((short[]) r100)[r101]);
        }
    }

    public static class b extends o {
        public b() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((int[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Integer.valueOf(((int[]) r100)[r101]);
        }
    }

    public static class c extends o {
        public c() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((long[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Long.valueOf(((long[]) r100)[r101]);
        }
    }

    public static class d extends o {
        public d() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((float[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Float.valueOf(((float[]) r100)[r101]);
        }
    }

    public static class e extends o {
        public e() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((double[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Double.valueOf(((double[]) r100)[r101]);
        }
    }

    public class f implements Iterator<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f405719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f405720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f405721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f405722d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f405720b >= this.f405719a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            o r100 = this.f405721c;
            Object r101 = this.f405722d;
            int r102 = this.f405720b;
            this.f405720b = r102 + 1;
            return r100.b(r101, r102);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public f(o r100, Object r101) {
            this.f405721c = r100;
            this.f405722d = r101;
            this.f405719a = r100.c(r101);
        }
    }

    public static class g implements com.samskivert.mustache.e.t {
        public g() {
        }

        public final String toString() {
            return "MAP_FETCHER";
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            Map r102 = (Map) r100;
            if (r102.containsKey(r101) == false) goto L7;
            return r102.get(r101);
        L7:
            if (r101 != "entrySet") goto L11;
            return r102.entrySet();
        L11:
            return com.samskivert.mustache.h.f405773d;
        }
    }

    public static class h implements com.samskivert.mustache.e.t {
        public h() {
        }

        public final String toString() {
            return "LIST_FETCHER";
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return ListProtector.get((List) r100, CastIntegerProtector.parseInt(r101));
        L5:
            return com.samskivert.mustache.h.f405773d;
        L7:
            return com.samskivert.mustache.h.f405773d;
        }
    }

    public static class i implements com.samskivert.mustache.e.t {
        public i() {
        }

        public final String toString() {
            return "ITER_FETCHER";
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            Iterator r102 = (Iterator) r100;     // Catch: NoSuchElementException -> L7 NumberFormatException -> L9
            int r103 = CastIntegerProtector.parseInt(r101);     // Catch: NoSuchElementException -> L7 NumberFormatException -> L9
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            r102.next();     // Catch: NoSuchElementException -> L7 NumberFormatException -> L9
            r104 = r104 + 1;     // Catch: NoSuchElementException -> L7 NumberFormatException -> L9
            goto L3
        L5:
            return r102.next();
        L10:
            return com.samskivert.mustache.h.f405773d;
        L8:
            return com.samskivert.mustache.h.f405773d;
        }
    }

    public static class j implements com.samskivert.mustache.e.t {
        public j() {
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return r100;
        }

        public final String toString() {
            return "THIS_FETCHER";
        }
    }

    public static class k extends o {
        public k() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((Object[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return ((Object[]) r100)[r101];
        }
    }

    public static class l extends o {
        public l() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((boolean[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Boolean.valueOf(((boolean[]) r100)[r101]);
        }
    }

    public static class m extends o {
        public m() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((byte[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Byte.valueOf(((byte[]) r100)[r101]);
        }
    }

    public static class n extends o {
        public n() {
        }

        @Override // com.samskivert.mustache.a.o
        public final int c(Object r100) {
            return ((char[]) r100).length;
        }

        @Override // com.samskivert.mustache.a.o
        public final Object b(Object r100, int r101) {
            return Character.valueOf(((char[]) r100)[r101]);
        }
    }

    public static abstract class o implements com.samskivert.mustache.e.t {
        public o() {
        }

        public abstract Object b(Object r100, int r101);

        public abstract int c(Object r100);

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return b(r100, CastIntegerProtector.parseInt(r101));
        L5:
            return com.samskivert.mustache.h.f405773d;
        L7:
            return com.samskivert.mustache.h.f405773d;
        }
    }

    public a() {
    }

    static {
        f405706a = new g();
        f405707b = new h();
        f405708c = new i();
        f405709d = new j();
        f405710e = new k();
        f405711f = new l();
        f405712g = new m();
        f405713h = new n();
        f405714i = new C4695a();
        f405715j = new b();
        f405716k = new c();
        f405717l = new d();
        f405718m = new e();
    }

    public static o a(Object r100) {
        if ((r100 instanceof Object[]) == false) goto L7;
        return f405710e;
    L7:
        if ((r100 instanceof boolean[]) == false) goto L11;
        return f405711f;
    L11:
        if ((r100 instanceof byte[]) == false) goto L15;
        return f405712g;
    L15:
        if ((r100 instanceof char[]) == false) goto L19;
        return f405713h;
    L19:
        if ((r100 instanceof short[]) == false) goto L23;
        return f405714i;
    L23:
        if ((r100 instanceof int[]) == false) goto L27;
        return f405715j;
    L27:
        if ((r100 instanceof long[]) == false) goto L31;
        return f405716k;
    L31:
        if ((r100 instanceof float[]) == false) goto L35;
        return f405717l;
    L35:
        if ((r100 instanceof double[]) == true) goto L37;
        return null;
    L37:
        return f405718m;
    }

    public final Iterator<?> b(Object r100) {
        if ((r100 instanceof Iterable) == false) goto L7;
        return ((Iterable) r100).iterator();
    L7:
        if ((r100 instanceof Iterator) == false) goto L11;
        return (Iterator) r100;
    L11:
        if (r100.getClass().isArray() == true) goto L13;
        return null;
    L13:
        return new f(a(r100), r100);
    }
}
