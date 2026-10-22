package w38;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class b<T> {

    public static final class a<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C8063b f558180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f558181b;

        public a() {
            throw null;
        }

        public final int hashCode() {
            int r100 = this.f558180a.hashCode() * 31;
            T r101 = this.f558181b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.f558180a + ", body=" + this.f558181b + ')';
        }

        @Override // w38.b
        public final c a() {
            return this.f558180a;
        }

        public a(C8063b r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f558180a = r100;
            this.f558181b = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f558180a, r101.f558180a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f558181b, r101.f558181b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    /* JADX INFO: renamed from: w38.b$b, reason: collision with other inner class name */
    public static final class C8063b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f558182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f558183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f558184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f558185d;

        public C8063b() {
            throw null;
        }

        public final int hashCode() {
            int r100 = this.f558182a * 31;
            String r101 = this.f558183b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f558184c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Map<String, String> r108 = this.f558185d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "FlowError(code=" + this.f558182a + ", tips=" + this.f558183b + ", exception=" + this.f558184c + ", ext=" + this.f558185d + ')';
        }

        @Override // w38.b.c
        public final int getCode() {
            return this.f558182a;
        }

        @Override // w38.b.c
        public final Throwable getException() {
            return this.f558184c;
        }

        @Override // w38.b.c
        public final String getTips() {
            return this.f558183b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8063b) == true) goto L8;
            return false;
        L8:
            C8063b r101 = (C8063b) r100;
            if (this.f558182a == r101.f558182a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f558183b, r101.f558183b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f558184c, r101.f558184c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f558185d, r101.f558185d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public C8063b(int r100, String r101, Throwable r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this.f558182a = r100;
            this.f558183b = r101;
            this.f558184c = r102;
            this.f558185d = null;
        }
    }

    public interface c {
        int getCode();

        Throwable getException();

        String getTips();
    }

    public static final class d<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f558186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f558187b;

        public d() {
            throw null;
        }

        public final int hashCode() {
            T r100 = this.f558186a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f558187b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(body=" + this.f558186a + ", error=" + this.f558187b + ')';
        }

        @Override // w38.b
        public final c a() {
            return this.f558187b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object r100) {
            C8063b r101 = new C8063b(0, "OK", null, 12);
            Intrinsics.checkNotNullParameter(r101, "error");
            this.f558186a = r100;
            this.f558187b = r101;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f558186a, r101.f558186a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f558187b, r101.f558187b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public b() {
    }

    public abstract c a();
}
