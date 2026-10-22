package m0a;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class j<T> {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f511536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f511537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f511538c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f511536a == r101.f511536a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f511537b, r101.f511537b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f511538c, r101.f511538c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f511536a * 31;
            String r101 = this.f511537b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f511538c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(code=" + this.f511536a + ", message=" + this.f511537b + ", throwable=" + this.f511538c + ')';
        }

        public a(int r100, String r101, Throwable r102) {
            this.f511536a = r100;
            this.f511537b = r101;
            this.f511538c = r102;
        }
    }

    public static final class b<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f511539a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f511539a, ((b) r100).f511539a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f511539a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f511539a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Unit r100) {
            this.f511539a = r100;
        }
    }

    public j() {
    }
}
