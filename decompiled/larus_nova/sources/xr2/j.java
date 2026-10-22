package xr2;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f564843a;

        public final int hashCode() {
            i r100 = this.f564843a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Added(icon=" + this.f564843a + ")";
        }

        public a(i r100) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            this.f564843a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f564843a, ((a) r100).f564843a) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f564844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f564845b;

        public final int hashCode() {
            i r100 = this.f564844a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Rect r104 = this.f564845b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "InsertionStarted(icon=" + this.f564844a + ", finalPositionOnScreen=" + this.f564845b + ")";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f564844a, r101.f564844a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f564845b, r101.f564845b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public b(i r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "finalPositionOnScreen");
            this.f564844a = r100;
            this.f564845b = r101;
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f564846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f564847b;

        public final int hashCode() {
            i r100 = this.f564846a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Rect r104 = this.f564847b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ReInitBigCardAnim(icon=" + this.f564846a + ", finalPositionOnScreen=" + this.f564847b + ")";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f564846a, r101.f564846a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f564847b, r101.f564847b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public c(i r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "finalPositionOnScreen");
            this.f564846a = r100;
            this.f564847b = r101;
        }
    }

    public j() {
    }
}
