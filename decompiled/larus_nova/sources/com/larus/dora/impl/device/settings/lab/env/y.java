package com.larus.dora.impl.device.settings.lab.env;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface y {

    public static final class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334706a = null;

        static {
            f334706a = new a();
        }

        public a() {
        }
    }

    public static final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f334708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f334709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f334710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f334711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f334712f;

        public final boolean equals(Object r100) {
            return false;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f334707a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f334708b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (((((r102 + r103) * 31) + this.f334709c.hashCode()) * 31) + this.f334710d.hashCode()) * 31;
            if (this.f334711e == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f334712f == true) goto L19;
            r100 = 1237;
        L19:
            return r106 + r100;
        L13:
            r105 = 1237;
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(envObserveEnable=" + this.f334707a + ", timeEnable=" + this.f334708b + ", startTime=" + this.f334709c + ", endTime=" + this.f334710d + ", lightEnable=" + this.f334711e + ", updateSuccess=" + this.f334712f + ')';
        }

        public b(boolean r100, boolean r101, String r102, String r103, boolean r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r102, DyPayConstant.KEY_START_TIME);
            Intrinsics.checkNotNullParameter(r103, "endTime");
            this.f334707a = r100;
            this.f334708b = r101;
            this.f334709c = r102;
            this.f334710d = r103;
            this.f334711e = r104;
            this.f334712f = r105;
        }

        public static b a(b r100, boolean r101, boolean r102, String r110, String r111, boolean r112, boolean r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            r101 = r100.f334707a;
        L5:
            boolean r103 = r101;
            if ((r114 & 2) == 0) goto L8;
            r102 = r100.f334708b;
        L8:
            boolean r104 = r102;
            if ((r114 & 4) == 0) goto L11;
            r110 = r100.f334709c;
        L11:
            String r105 = r110;
            if ((r114 & 8) == 0) goto L14;
            r111 = r100.f334710d;
        L14:
            String r106 = r111;
            if ((r114 & 16) == 0) goto L17;
            r112 = r100.f334711e;
        L17:
            boolean r107 = r112;
            if ((r114 & 32) == 0) goto L20;
            r113 = r100.f334712f;
        L20:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r105, DyPayConstant.KEY_START_TIME);
            Intrinsics.checkNotNullParameter(r106, "endTime");
            return new b(r103, r104, r105, r106, r107, r113);
        }
    }
}
