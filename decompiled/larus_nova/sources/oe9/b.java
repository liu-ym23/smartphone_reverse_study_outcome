package oe9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f523023a;

    public static final class a<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final oe9.c f523024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f523025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f523026d;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f523024b, r101.f523024b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523025c, r101.f523025c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f523026d, r101.f523026d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f523024b.hashCode() * 31;
            T r101 = this.f523025c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f523026d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Cancel(error=" + this.f523024b + ", body=" + this.f523025c + ", logId=" + this.f523026d + ')';
        }

        @Override // oe9.b
        public final T a() {
            return this.f523025c;
        }

        @Override // oe9.b
        public final oe9.c b() {
            return this.f523024b;
        }

        @Override // oe9.b
        public final String c() {
            return this.f523026d;
        }

        public a(Object r100) {
            oe9.a r101 = new oe9.a(Integer.MIN_VALUE, "Network request has been cancelled.");
            Intrinsics.checkNotNullParameter(r101, "error");
            this.f523024b = r101;
            this.f523025c = null;
            this.f523026d = null;
        }
    }

    /* JADX INFO: renamed from: oe9.b$b, reason: collision with other inner class name */
    public static final class C7042b<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f523027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final oe9.c f523028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final T f523029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f523030e;

        public C7042b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7042b) == true) goto L8;
            return false;
        L8:
            C7042b r101 = (C7042b) r100;
            if (this.f523027b == r101.f523027b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523028c, r101.f523028c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f523029d, r101.f523029d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f523030e, r101.f523030e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f523027b * 31) + this.f523028c.hashCode()) * 31;
            T r101 = this.f523029d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f523030e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "HttpError(httpCode=" + this.f523027b + ", error=" + this.f523028c + ", body=" + this.f523029d + ", logId=" + this.f523030e + ')';
        }

        @Override // oe9.b
        public final T a() {
            return this.f523029d;
        }

        @Override // oe9.b
        public final oe9.c b() {
            return this.f523028c;
        }

        @Override // oe9.b
        public final String c() {
            return this.f523030e;
        }

        public C7042b(int r100, String r101) {
            oe9.a r102 = new oe9.a(-2, "Http failed, http status code " + r100 + '.');
            Intrinsics.checkNotNullParameter(r102, "error");
            this.f523027b = r100;
            this.f523028c = r102;
            this.f523029d = null;
            this.f523030e = r101;
        }
    }

    public static final class c<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final oe9.c f523031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f523032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f523033d;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f523031b, r101.f523031b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523032c, r101.f523032c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f523033d, r101.f523033d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f523031b.hashCode() * 31;
            T r101 = this.f523032c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f523033d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "NetworkUnAvailable(error=" + this.f523031b + ", body=" + this.f523032c + ", logId=" + this.f523033d + ')';
        }

        @Override // oe9.b
        public final T a() {
            return this.f523032c;
        }

        @Override // oe9.b
        public final oe9.c b() {
            return this.f523031b;
        }

        @Override // oe9.b
        public final String c() {
            return this.f523033d;
        }

        public c(Object r100) {
            oe9.a r101 = new oe9.a(-1, "Network unavailable");
            Intrinsics.checkNotNullParameter(r101, "error");
            this.f523031b = r101;
            this.f523032c = null;
            this.f523033d = null;
        }
    }

    public static final class d<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f523034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f523035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final oe9.c f523036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final T f523037e;

        public d() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f523034b, r101.f523034b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523035c, r101.f523035c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f523036d, r101.f523036d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f523037e, r101.f523037e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f523034b;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f523035c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f523036d.hashCode()) * 31;
            T r107 = this.f523037e;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ResolveError(logId=" + this.f523034b + ", json=" + this.f523035c + ", error=" + this.f523036d + ", body=" + this.f523037e + ')';
        }

        @Override // oe9.b
        public final T a() {
            return this.f523037e;
        }

        @Override // oe9.b
        public final oe9.c b() {
            return this.f523036d;
        }

        @Override // oe9.b
        public final String c() {
            return this.f523034b;
        }

        public d(String r100, String r101) {
            oe9.a r102 = new oe9.a(-4, "Resolve failed.");
            Intrinsics.checkNotNullParameter(r102, "error");
            this.f523034b = r100;
            this.f523035c = r101;
            this.f523036d = r102;
            this.f523037e = null;
        }
    }

    public static final class e<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f523038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f523039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final oe9.c f523040d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final T f523041e;

        public e() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f523038b == r101.f523038b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523039c, r101.f523039c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f523040d, r101.f523040d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f523041e, r101.f523041e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f523038b * 31;
            String r101 = this.f523039c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f523040d.hashCode()) * 31;
            T r105 = this.f523041e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ServerError(statusCode=" + this.f523038b + ", logId=" + this.f523039c + ", error=" + this.f523040d + ", body=" + this.f523041e + ')';
        }

        @Override // oe9.b
        public final T a() {
            return this.f523041e;
        }

        @Override // oe9.b
        public final oe9.c b() {
            return this.f523040d;
        }

        @Override // oe9.b
        public final String c() {
            return this.f523039c;
        }

        public e(int r100, String r101) {
            oe9.a r102 = new oe9.a(-3, "Server error, error code " + r100 + '.');
            Intrinsics.checkNotNullParameter(r102, "error");
            this.f523038b = r100;
            this.f523039c = r101;
            this.f523040d = r102;
            this.f523041e = null;
        }
    }

    public static final class f<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f523042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f523043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final oe9.c f523044d;

        public f() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f523042b, r101.f523042b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523043c, r101.f523043c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f523044d, r101.f523044d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f523042b;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f523043c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            oe9.c r107 = this.f523044d;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Success(body=" + this.f523042b + ", logId=" + this.f523043c + ", error=" + this.f523044d + ')';
        }

        @Override // oe9.b
        public final T a() {
            return this.f523042b;
        }

        @Override // oe9.b
        public final oe9.c b() {
            return this.f523044d;
        }

        @Override // oe9.b
        public final String c() {
            return this.f523043c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Object r100, String r101) {
            this.f523042b = r100;
            this.f523043c = r101;
            this.f523044d = null;
        }
    }

    public b() {
    }

    public abstract T a();

    public abstract oe9.c b();

    public abstract String c();
}
