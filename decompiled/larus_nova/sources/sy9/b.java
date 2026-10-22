package sy9;

import android.graphics.Bitmap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f543895a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f543895a == ((a) r100).f543895a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f543895a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Empty(showFull=" + this.f543895a + ')';
        }

        public a(boolean r100) {
            this.f543895a = r100;
        }
    }

    /* JADX INFO: renamed from: sy9.b$b, reason: collision with other inner class name */
    public static final class C7670b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f543896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f543897b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7670b) == true) goto L8;
            return false;
        L8:
            C7670b r101 = (C7670b) r100;
            if (Intrinsics.areEqual(this.f543896a, r101.f543896a) == true) goto L12;
            return false;
        L12:
            if (this.f543897b == r101.f543897b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Bitmap r100 = this.f543896a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f543897b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Failed(bitmap=" + this.f543896a + ", showFull=" + this.f543897b + ')';
        }

        public C7670b(Bitmap r100, boolean r101) {
            this.f543896a = r100;
            this.f543897b = r101;
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f543898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f543899b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f543898a, r101.f543898a) == true) goto L12;
            return false;
        L12:
            if (this.f543899b == r101.f543899b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Bitmap r100 = this.f543898a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f543899b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Filled(bitmap=" + this.f543898a + ", showFull=" + this.f543899b + ')';
        }

        public c(Bitmap r100, boolean r101) {
            this.f543898a = r100;
            this.f543899b = r101;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f543900a = null;

        static {
            f543900a = new d();
        }

        public d() {
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f543901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f543902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Pair<Integer, Integer> f543903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f543904d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f543901a, r101.f543901a) == true) goto L12;
            return false;
        L12:
            if (this.f543902b == r101.f543902b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f543903c, r101.f543903c) == true) goto L18;
            return false;
        L18:
            if (this.f543904d == r101.f543904d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Bitmap r100 = this.f543901a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            int r104 = 1231;
            if (this.f543902b == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r103 + r105) * 31;
            Pair<Integer, Integer> r107 = this.f543903c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (r106 + r101) * 31;
            if (this.f543904d == true) goto L19;
            r104 = 1237;
        L19:
            return r108 + r104;
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Uploading(bitmap=" + this.f543901a + ", showFull=" + this.f543902b + ", size=" + this.f543903c + ", hideLoading=" + this.f543904d + ')';
        }

        public e(Bitmap r100, boolean r101, Pair<Integer, Integer> r102, boolean r103) {
            this.f543901a = r100;
            this.f543902b = r101;
            this.f543903c = r102;
            this.f543904d = r103;
        }

        public static e a(e r100, boolean r101, boolean r102, int r103) {
            Pair<Integer, Integer> r104 = null;
            if ((r103 & 1) == 0) goto L5;
            Bitmap r105 = r100.f543901a;
        L7:
            if ((r103 & 2) == 0) goto L10;
            r101 = r100.f543902b;
        L10:
            if ((r103 & 4) == 0) goto L13;
            r104 = r100.f543903c;
        L13:
            if ((r103 & 8) == 0) goto L15;
            r102 = r100.f543904d;
        L15:
            r100.getClass();
            return new e(r105, r101, r104, r102);
        L5:
            r105 = null;
            goto L7
        }

        public /* synthetic */ e(Bitmap r100, boolean r101, Pair r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102, false);
        }
    }
}
