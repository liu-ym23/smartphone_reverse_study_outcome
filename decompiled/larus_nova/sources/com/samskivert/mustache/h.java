package com.samskivert.mustache;

import com.miui.easygo.constant.EasyGoConstant;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f405773d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f405774e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f405775f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f405776g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f405777h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f405778i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f405779j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d[] f405780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.f f405781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<c, e.t> f405782c;

    public static class a implements e.t {
        public a() {
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return h.f405773d;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f405783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f405784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f405785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f405786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f405787e;

        public b(Object r100, b r101, int r102, boolean r103, boolean r104) {
            this.f405783a = r100;
            this.f405784b = r101;
            this.f405785c = r102;
            this.f405786d = r103;
            this.f405787e = r104;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f405788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f405789b;

        public final int hashCode() {
            return (this.f405788a.hashCode() * 31) + this.f405789b.hashCode();
        }

        public final String toString() {
            return this.f405788a.getName() + ":" + this.f405789b;
        }

        public final boolean equals(Object r100) {
            c r101 = (c) r100;
            if (r101.f405788a == this.f405788a) goto L5;
        L7:
            return false;
        L5:
            if (r101.f405789b != this.f405789b) goto L7;
            return true;
        }

        public c(Class<?> r100, String r101) {
            this.f405788a = r100;
            this.f405789b = r101;
        }
    }

    public static abstract class d {
        public d() {
        }

        public abstract void a(h r100, b r101, Writer r102);
    }

    static {
        f405773d = new String("<no fetcher found>");
        f405774e = ".".intern();
        f405775f = "this".intern();
        f405776g = "-first".intern();
        f405777h = "-last".intern();
        f405778i = "-index".intern();
        f405779j = new a();
    }

    public final String b(Object r100) throws MustacheException {
        StringWriter r101 = new StringWriter();
        c(new b(r100, null, 0, false, false), r101);
        return r101.toString();
    }

    public h(d[] r100, e.f r101) {
        this.f405780a = r100;
        this.f405781b = r101;
        ((com.samskivert.mustache.b) r101.f405744j).getClass();
        this.f405782c = new ConcurrentHashMap();
    }

    public final void c(b r100, Writer r101) throws MustacheException {
        d[] r102 = this.f405780a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102[r104].a(this, r100, r101);
        r104 = r104 + 1;
        goto L3
    }

    public final Object e(Object r100, String r101, int r102) {
        if (r100 == null) goto L18;
        c r103 = new c(r100.getClass(), r101);
        e.t r104 = (e.t) ((ConcurrentHashMap) this.f405782c).get(r103);
        if (r104 != null) goto L19;
        e.t r105 = ((com.samskivert.mustache.b) this.f405781b.f405744j).d(r100, r101);
    L10:
        if (r105 != null) goto L21;
        r105 = f405779j;
    L21:
        Object r106 = r105.a(r100, r101);     // Catch: Exception -> L14
        ((ConcurrentHashMap) this.f405782c).put(r103, r105);     // Catch: Exception -> L14
        return r106;
    L14:
        e = move-exception;
        throw new MustacheException.Context("Failure fetching variable '" + r101 + "' on line " + r102, r101, r102, e);
    L19:
        return r104.a(r100, r101);
    L8:
        r105 = ((com.samskivert.mustache.b) this.f405781b.f405744j).d(r100, r103.f405789b);
        goto L10
    L18:
        throw new NullPointerException("Null context for variable '" + r101 + "' on line " + r102);
    }

    public static Object a(String r100, int r101, boolean r102, Object r103) {
        if (r103 != f405773d) goto L9;
        if (r102 == false) goto L8;
        return null;
    L8:
        throw new MustacheException.Context("No method or field with name '" + r100 + "' on line " + r101, r100, r101);
    L9:
        return r103;
    }

    public final Object d(b r100, String r101, int r102, boolean r103) {
        if (r101 != f405776g) goto L7;
        return Boolean.valueOf(r100.f405786d);
    L7:
        if (r101 != f405777h) goto L11;
        return Boolean.valueOf(r100.f405787e);
    L11:
        if (r101 != f405778i) goto L15;
        return Integer.valueOf(r100.f405785c);
    L15:
        if (this.f405781b.f405735a == true) goto L17;
        b r104 = r100;
    L19:
        Object r105 = f405773d;
        if (r104 == null) goto L25;
        Object r106 = e(r104.f405783a, r101, r102);
        if (r106 != r105) goto L23;
        r104 = r104.f405784b;
        goto L19
    L23:
        return r106;
    L25:
        String r107 = f405774e;
        if (r101 == r107) goto L43;
        if (r101.indexOf(r107) == (-1)) goto L43;
        String[] r108 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        Object r109 = d(r100, r108[0].intern(), r102, r103);
        int r110 = 1;
    L31:
        if (r110 >= r108.length) goto L41;
        if (r109 == r105) goto L33;
        if (r109 == null) goto L38;
        r109 = e(r109, r108[r110].intern(), r102);
        r110 = r110 + 1;
    L38:
        return null;
    L33:
        if (r103 == true) goto L38;
        throw new MustacheException.Context("Missing context for compound variable '" + r101 + "' on line " + r102 + ". '" + r108[r110 - 1] + "' was not found.", r101, r102);
    L41:
        return a(r101, r102, r103, r109);
    L43:
        return a(r101, r102, r103, r105);
    L17:
        return a(r101, r102, r103, e(r100.f405783a, r101, r102));
    }
}
