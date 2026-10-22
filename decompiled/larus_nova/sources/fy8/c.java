package fy8;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f479294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f479295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Intent f479296c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f479294a == r101.f479294a) goto L12;
            return false;
        L12:
            if (this.f479295b == r101.f479295b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f479296c, r101.f479296c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f479294a * 31) + this.f479295b) * 31;
            Intent r101 = this.f479296c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "OnActivityResult(requestCode=" + this.f479294a + ", resultCode=" + this.f479295b + ", data=" + this.f479296c + ')';
        }

        public a(int r100, int r101, Intent r102) {
            this.f479294a = r100;
            this.f479295b = r101;
            this.f479296c = r102;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f479297a = null;

        static {
            f479297a = new b();
        }

        public b() {
        }
    }
}
