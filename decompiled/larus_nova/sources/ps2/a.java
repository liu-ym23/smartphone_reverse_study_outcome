package ps2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530413a = 0;

    /* JADX INFO: renamed from: ps2.a$a, reason: collision with other inner class name */
    public static final class C7232a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f530414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f530415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f530416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f530417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f530418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f530419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f530420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f530421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f530422i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f530423j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Boolean f530424k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f530425l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f530426m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f530427n;

        public C7232a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7232a) == false) goto L34;
            C7232a r101 = (C7232a) r100;
            if (Intrinsics.areEqual(this.f530414a, r101.f530414a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f530415b, r101.f530415b) == true) goto L10;
            return false;
        L10:
            if (this.f530416c == r101.f530416c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f530417d, r101.f530417d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f530418e, r101.f530418e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f530419f, r101.f530419f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f530420g, r101.f530420g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f530421h, r101.f530421h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f530422i, r101.f530422i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f530423j, r101.f530423j) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.f530424k, r101.f530424k) == true) goto L28;
            return false;
        L28:
            if (this.f530425l == r101.f530425l) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f530426m, r101.f530426m) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.f530427n, r101.f530427n) == true) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        public final int hashCode() {
            Boolean r100 = this.f530414a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.f530415b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            long r107 = this.f530416c;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            Boolean r109 = this.f530417d;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            Boolean r112 = this.f530418e;
            if (r112 == null) goto L17;
            int r113 = r112.hashCode();
        L18:
            int r114 = (r111 + r113) * 31;
            Boolean r115 = this.f530419f;
            if (r115 == null) goto L21;
            int r116 = r115.hashCode();
        L22:
            int r117 = (r114 + r116) * 31;
            Boolean r118 = this.f530420g;
            if (r118 == null) goto L25;
            int r119 = r118.hashCode();
        L26:
            int r120 = (r117 + r119) * 31;
            Boolean r121 = this.f530421h;
            if (r121 == null) goto L29;
            int r122 = r121.hashCode();
        L30:
            int r123 = (r120 + r122) * 31;
            Boolean r124 = this.f530422i;
            if (r124 == null) goto L33;
            int r125 = r124.hashCode();
        L34:
            int r126 = (r123 + r125) * 31;
            String r127 = this.f530423j;
            if (r127 == null) goto L37;
            int r128 = r127.hashCode();
        L38:
            int r129 = (r126 + r128) * 31;
            Boolean r130 = this.f530424k;
            if (r130 == null) goto L41;
            int r131 = r130.hashCode();
        L42:
            int r132 = (r129 + r131) * 31;
            long r133 = this.f530425l;
            int r134 = (r132 + ((int) (r133 ^ (r133 >>> 32)))) * 31;
            String r135 = this.f530426m;
            if (r135 == null) goto L45;
            int r136 = r135.hashCode();
        L46:
            int r137 = (r134 + r136) * 31;
            String r138 = this.f530427n;
            if (r138 == null) goto L50;
            r101 = r138.hashCode();
        L50:
            return r137 + r101;
        L45:
            r136 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveRoomNodeMonitor(isFirstRoom=" + this.f530414a + ", isOnCreateSuccess=" + this.f530415b + ", startRoomStartTime=" + this.f530416c + ", startRoomSuccess=" + this.f530417d + ", playWidgetLoadSuccess=" + this.f530418e + ", enterRoomPreApiSuccess=" + this.f530419f + ", enterRoomApiSuccess=" + this.f530420g + ", firstFrameSuccess=" + this.f530421h + ", componentLoadSuccess=" + this.f530422i + ", lastWidgetLevel=" + this.f530423j + ", stopRoomSuccess=" + this.f530424k + ", stopRoomTime=" + this.f530425l + ", enterMethod=" + this.f530426m + ", enterFromMerge=" + this.f530427n + ")";
        }

        public C7232a(int r100) {
            Boolean r101 = Boolean.FALSE;
            this.f530414a = r101;
            this.f530415b = r101;
            this.f530416c = 0;
            this.f530417d = r101;
            this.f530418e = r101;
            this.f530419f = r101;
            this.f530420g = r101;
            this.f530421h = r101;
            this.f530422i = r101;
            this.f530423j = "";
            this.f530424k = r101;
            this.f530425l = 0;
            this.f530426m = "";
            this.f530427n = "";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f530428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f530429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f530430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f530431d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f530432e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f530433f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L18;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f530428a, r101.f530428a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f530429b, r101.f530429b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f530430c, r101.f530430c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f530431d, r101.f530431d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f530432e, r101.f530432e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f530433f, r101.f530433f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            Boolean r100 = this.f530428a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.f530429b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.f530430c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f530431d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f530432e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f530433f;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveSessionNodeMonitor(isNewInstanceSuccess=" + this.f530428a + ", isOnCreateSuccess=" + this.f530429b + ", firstStartRoomSuccess=" + this.f530430c + ", firstStartRoomFailureRec=" + this.f530431d + ", enterMethod=" + this.f530432e + ", enterFromMerge=" + this.f530433f + ")";
        }

        public b(Boolean r100, Boolean r101, Boolean r102, String r103, String r104) {
            this.f530428a = r100;
            this.f530429b = r101;
            this.f530430c = r102;
            this.f530431d = "";
            this.f530432e = r103;
            this.f530433f = r104;
        }
    }

    static {
    }
}
