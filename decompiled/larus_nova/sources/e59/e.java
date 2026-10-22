package e59;

import c59.i;
import c59.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471072a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471072a, ((a) r100).f471072a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471072a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ConnectRequest(mac=" + this.f471072a + ')';
        }

        public a(String r100) {
            this.f471072a = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471073a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471073a, ((b) r100).f471073a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471073a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ConnectStateUpdateRequest(mac=" + this.f471073a + ')';
        }

        public b() {
            this.f471073a = "";
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f471074a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471074a, ((c) r100).f471074a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            i r100 = this.f471074a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "RemoveRequest(data=" + this.f471074a + ')';
        }

        public c(i r100) {
            this.f471074a = r100;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d59.b f471076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f471077c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f471075a, r101.f471075a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471076b, r101.f471076b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f471077c, r101.f471077c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471075a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            d59.b r104 = this.f471076b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            o r107 = this.f471077c;
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
            return "ShowUnbindDialog(deviceMac=" + this.f471075a + ", cardContext=" + this.f471076b + ", unbindDialogConfig=" + this.f471077c + ')';
        }

        public d(String r100, d59.b r101, o r102) {
            this.f471075a = r100;
            this.f471076b = r101;
            this.f471077c = r102;
        }
    }

    public e() {
    }
}
