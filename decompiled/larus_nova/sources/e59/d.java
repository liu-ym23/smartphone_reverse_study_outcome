package e59;

import c59.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d59.b f471070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f471071c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f471069a, r101.f471069a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471070b, r101.f471070b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f471071c, r101.f471071c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471069a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            d59.b r104 = this.f471070b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            o r107 = this.f471071c;
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
            return "ShowUnbindConfirm(deviceMac=" + this.f471069a + ", cardContext=" + this.f471070b + ", dialogConfig=" + this.f471071c + ')';
        }

        public a(String r100, d59.b r101, o r102) {
            this.f471069a = r100;
            this.f471070b = r101;
            this.f471071c = r102;
        }
    }

    public d() {
    }
}
