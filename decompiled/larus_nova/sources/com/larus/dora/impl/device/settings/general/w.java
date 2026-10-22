package com.larus.dora.impl.device.settings.general;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface w {

    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334351a = null;

        static {
            f334351a = new a();
        }

        public a() {
        }
    }

    public static final class b implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraDevice f334353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f334354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f334355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f334356e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f334352a == r101.f334352a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f334353b, r101.f334353b) == true) goto L15;
            return false;
        L15:
            if (this.f334354c == r101.f334354c) goto L18;
            return false;
        L18:
            if (this.f334355d == r101.f334355d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f334356e, r101.f334356e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f334352a * 31) + this.f334353b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f334354c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f334355d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            String r105 = this.f334356e;
            if (r105 != null) goto L13;
            int r106 = 0;
        L15:
            return r104 + r106;
        L13:
            r106 = r105.hashCode();
            goto L15
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "Success(id=" + this.f334352a + ", device=" + this.f334353b + ", isMultiDeviceLinked=" + this.f334354c + ", autoWearSensorEnable=" + this.f334355d + ", newVersion=" + this.f334356e + ')';
        }

        public b(int r100, DoraDevice r101, boolean r102, boolean r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "device");
            this.f334352a = r100;
            this.f334353b = r101;
            this.f334354c = r102;
            this.f334355d = r103;
            this.f334356e = r104;
        }

        public static b a(b r100, int r101, boolean r102, boolean r103, String r110, int r111) {
            if ((r111 & 1) == 0) goto L5;
            r101 = r100.f334352a;
        L5:
            int r104 = r101;
            if ((r111 & 2) == 0) goto L8;
            DoraDevice r105 = r100.f334353b;
        L9:
            DoraDevice r106 = r105;
            if ((r111 & 4) == 0) goto L12;
            r102 = r100.f334354c;
        L12:
            boolean r107 = r102;
            if ((r111 & 8) == 0) goto L15;
            r103 = r100.f334355d;
        L15:
            boolean r108 = r103;
            if ((r111 & 16) == 0) goto L18;
            r110 = r100.f334356e;
        L18:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r106, "device");
            return new b(r104, r106, r107, r108, r110);
        L8:
            r105 = null;
            goto L9
        }
    }
}
