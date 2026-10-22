package h68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: h68.a$a, reason: collision with other inner class name */
    public static final class C6106a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f483923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f483924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f483925c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6106a) == true) goto L8;
            return false;
        L8:
            C6106a r101 = (C6106a) r100;
            if (this.f483923a == r101.f483923a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f483924b, r101.f483924b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f483925c, r101.f483925c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f483923a * 31;
            String r101 = this.f483924b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f483925c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(errorCode=" + this.f483923a + ", errorMsg=" + this.f483924b + ", throwable=" + this.f483925c + ')';
        }

        public C6106a(int r100, String r101, Throwable r102) {
            this.f483923a = r100;
            this.f483924b = r101;
            this.f483925c = r102;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f483926a;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f483926a, ((b) r100).f483926a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f483926a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(readSize=" + this.f483926a + ')';
        }

        public b(Integer r100) {
            this.f483926a = r100;
        }
    }

    public a() {
    }
}
