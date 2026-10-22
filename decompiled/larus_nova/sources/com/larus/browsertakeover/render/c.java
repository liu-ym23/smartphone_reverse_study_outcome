package com.larus.browsertakeover.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f319537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f319538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f319539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f319540d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f319541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f319542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f319543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f319544d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f319541a, r101.f319541a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f319542b, r101.f319542b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f319543c, r101.f319543c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f319544d, r101.f319544d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f319541a) * 31) + Float.floatToIntBits(this.f319542b)) * 31) + Float.floatToIntBits(this.f319543c)) * 31) + Float.floatToIntBits(this.f319544d);
        }

        public final String toString() {
            return "Bounds(left=" + this.f319541a + ", top=" + this.f319542b + ", right=" + this.f319543c + ", bottom=" + this.f319544d + ')';
        }

        public final a a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "other");
            float r101 = Math.max(this.f319541a, r100.f319541a);
            float r102 = Math.max(this.f319542b, r100.f319542b);
            float r103 = Math.min(this.f319543c, r100.f319543c);
            float r104 = Math.min(this.f319544d, r100.f319544d);
            a r105 = new a(r101, r102, r103, r104);
            boolean r106 = true;
            if (Float.isInfinite(r101) == false) goto L5;
        L7:
            boolean r107 = false;
        L8:
            if (r107 == true) goto L10;
        L35:
            r106 = false;
        L36:
            if (r106 == true) goto L40;
            return null;
        L40:
            return r105;
        L10:
            if (Float.isInfinite(r102) == false) goto L12;
        L14:
            boolean r108 = false;
        L15:
            if (r108 == false) goto L35;
            if (Float.isInfinite(r103) == false) goto L19;
        L21:
            boolean r109 = false;
        L22:
            if (r109 == false) goto L35;
            if (Float.isInfinite(r104) == false) goto L26;
        L28:
            boolean r110 = false;
        L29:
            if (r110 == false) goto L35;
            if (r101 >= r103) goto L35;
            if (r102 >= r104) goto L35;
        L26:
            if (Float.isNaN(r104) == true) goto L28;
            r110 = true;
            goto L29
        L19:
            if (Float.isNaN(r103) == true) goto L21;
            r109 = true;
            goto L22
        L12:
            if (Float.isNaN(r102) == true) goto L14;
            r108 = true;
            goto L15
        L5:
            if (Float.isNaN(r101) == true) goto L7;
            r107 = true;
            goto L8
        }

        public a(float r100, float r101, float r102, float r103) {
            this.f319541a = r100;
            this.f319542b = r101;
            this.f319543c = r102;
            this.f319544d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f319545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f319546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f319547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f319548d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f319549e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f319550f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f319545a, r101.f319545a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f319546b, r101.f319546b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f319547c, r101.f319547c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f319548d, r101.f319548d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f319549e, r101.f319549e) == 0) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f319550f, r101.f319550f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f319545a.hashCode() * 31) + Float.floatToIntBits(this.f319546b)) * 31) + Float.floatToIntBits(this.f319547c)) * 31) + Float.floatToIntBits(this.f319548d)) * 31) + Float.floatToIntBits(this.f319549e)) * 31;
            a r101 = this.f319550f;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Mapping(bounds=" + this.f319545a + ", deviceWidth=" + this.f319546b + ", deviceHeight=" + this.f319547c + ", offsetTop=" + this.f319548d + ", scale=" + this.f319549e + ", clipBounds=" + this.f319550f + ')';
        }

        public final b a(float r110, float r111, float r112) {
            boolean r100 = true;
            if (Float.isInfinite(r110) == false) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L10;
        L26:
            r100 = false;
        L27:
            if (r100 == false) goto L31;
            a r102 = this.f319545a;
            float r103 = r102.f319541a;
            float r104 = r102.f319542b;
            a r105 = new a(r103 + r111, r104 + r112, (r111 + r103) + ((r102.f319543c - r103) * r110), (r112 + r104) + ((r102.f319544d - r104) * r110));
            float r106 = this.f319549e * r110;
            float r107 = this.f319546b;
            float r108 = this.f319547c;
            float r109 = this.f319548d;
            a r113 = this.f319550f;
            Intrinsics.checkNotNullParameter(r105, "bounds");
            return new b(r105, r107, r108, r109, r106, r113);
        L31:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L10:
            if (r110 < 1.0f) goto L26;
            if (Float.isInfinite(r111) == false) goto L14;
        L16:
            boolean r114 = false;
        L17:
            if (r114 == false) goto L26;
            if (Float.isInfinite(r112) == false) goto L21;
        L23:
            boolean r115 = false;
        L24:
            if (r115 == false) goto L26;
        L21:
            if (Float.isNaN(r112) == true) goto L23;
            r115 = true;
            goto L24
        L14:
            if (Float.isNaN(r111) == true) goto L16;
            r114 = true;
            goto L17
        L5:
            if (Float.isNaN(r110) == true) goto L7;
            r101 = true;
            goto L8
        }

        public b(a r100, float r101, float r102, float r103, float r104, a r105) {
            Intrinsics.checkNotNullParameter(r100, "bounds");
            this.f319545a = r100;
            this.f319546b = r101;
            this.f319547c = r102;
            this.f319548d = r103;
            this.f319549e = r104;
            this.f319550f = r105;
        }
    }

    public c() {
    }

    public final b a(int r110, int r111, float r112, float r113, float r114) {
        if (r110 <= 0) goto L56;
        if (r111 <= 0) goto L56;
        boolean r100 = true;
        if (Float.isInfinite(r112) == false) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L56;
        if (Float.isInfinite(r113) == false) goto L15;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == false) goto L56;
        if (Float.isInfinite(r114) == false) goto L22;
    L24:
        r100 = false;
    L25:
        if (r100 == false) goto L56;
        if (r112 <= 0.0f) goto L56;
        if (r113 <= 0.0f) goto L56;
        if (r114 < 0.0f) goto L56;
        if (r114 >= r113) goto L56;
        float r103 = r110;
        a r104 = new a(0.0f, 0.0f, r103, r111);
        if (this.f319537a == false) goto L45;
        a r105 = this.f319538b;
        if (r105 == null) goto L45;
        if (r105 == null) goto L44;
        a r106 = r105.a(r104);
        if (r106 == null) goto L44;
        a r107 = r106;
    L47:
        if (this.f319537a == true) goto L49;
    L53:
        int r108 = r111;
    L54:
        float r109 = r108;
        float r115 = Math.min((r103 - 0.0f) / r112, (r109 - 0.0f) / r113);
        float r116 = r112 * r115;
        float r117 = r113 * r115;
        float r118 = ((r103 + 0.0f) - r116) / 2.0f;
        float r119 = ((0.0f + r109) - r117) / 2.0f;
        return new b(new a(r118, r119, r116 + r118, r117 + r119), r112, r113, r114, r115, r107);
    L49:
        if (this.f319539c != r110) goto L53;
        r108 = this.f319540d;
        if (r108 <= 0) goto L53;
    L44:
        return null;
    L45:
        r107 = null;
        goto L47
    L22:
        if (Float.isNaN(r114) == true) goto L24;
    L15:
        if (Float.isNaN(r113) == true) goto L17;
        r102 = true;
        goto L18
    L8:
        if (Float.isNaN(r112) == true) goto L10;
        r101 = true;
    L56:
        return null;
    }
}
