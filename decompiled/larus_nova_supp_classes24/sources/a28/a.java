package a28;

import cvc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    /* JADX INFO: renamed from: a28.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        public String a;
        public String b;
        public long c;
        public String d;
        public String e;
        public boolean f;
        public boolean g;
        public boolean h;

        public C0001a() {
            this.c = 253402300799999L;
            this.e = "/";
        }

        public final void a(String r3) {
            if (r3 == null) goto L10;
            String r0 = c.c(r3);
            if (r0 == null) goto L8;
            this.d = r0;
            this.h = false;
            return;
        L8:
            throw new IllegalArgumentException("unexpected domain: ".concat(r3));
        L10:
            throw new NullPointerException("domain == null");
        }

        public final void b(long r4) {
            if (r4 > 0) goto L6;
            r4 = Long.MIN_VALUE;
        L6:
            if (r4 <= 253402300799999L) goto L8;
            r4 = 253402300799999L;
        L8:
            this.c = r4;
        }

        public final void c(String r2) {
            if (r2 == null) goto L10;
            if (r2.trim().equals(r2) == false) goto L8;
            this.a = r2;
            return;
        L8:
            throw new IllegalArgumentException("name is not trimmed");
        L10:
            throw new NullPointerException("name == null");
        }

        public final void d(String r2) {
            if (r2.startsWith("/") == false) goto L7;
            this.e = r2;
            return;
        L7:
            throw new IllegalArgumentException("path must start with '/'");
        }

        public final void e(String r2) {
            if (r2 == null) goto L10;
            if (r2.trim().equals(r2) == false) goto L8;
            this.b = r2;
            return;
        L8:
            throw new IllegalArgumentException("value is not trimmed");
        L10:
            throw new NullPointerException("value == null");
        }
    }

    public a(C0001a r4) {
        String r0 = r4.a;
        if (r0 == null) goto L15;
        String r1 = r4.b;
        if (r1 == null) goto L13;
        String r2 = r4.d;
        if (r2 == null) goto L11;
        this.a = r0;
        this.b = r1;
        this.c = r4.c;
        this.d = r2;
        this.e = r4.e;
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        return;
    L11:
        throw new NullPointerException("builder.domain == null");
    L13:
        throw new NullPointerException("builder.value == null");
    L15:
        throw new NullPointerException("builder.name == null");
    }
}
