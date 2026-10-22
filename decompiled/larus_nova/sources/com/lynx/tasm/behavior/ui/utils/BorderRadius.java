package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public final class BorderRadius {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f383118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f383119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a[] f383120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f383121d;

    public static final enum Location extends Enum<Location> {
        public static final Location BOTTOM_LEFT = null;
        public static final Location BOTTOM_RIGHT = null;
        public static final Location TOP_LEFT = null;
        public static final Location TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Location[] f383122a = null;

        static {
            Location r100 = new Location("TOP_LEFT", 0);
            TOP_LEFT = r100;
            Location r101 = new Location("TOP_RIGHT", 1);
            TOP_RIGHT = r101;
            Location r102 = new Location("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r102;
            Location r103 = new Location("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r103;
            f383122a = new Location[]{r100, r101, r102, r103};
        }

        public static Location[] values() {
            return (Location[]) f383122a.clone();
        }

        public static Location valueOf(String r100) {
            return (Location) r27.a.a(Location.class, r100);
        }

        public Location(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f383123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f383124b;

        public a() {
        }

        public final boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            a r101 = (a) r100;
            if (Objects.equals(this.f383123a, r101.f383123a) == true) goto L8;
            return false;
        L8:
            if (Objects.equals(this.f383124b, r101.f383124b) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public static a a(ReadableArray r100, int r101) {
            a r102 = new a();
            r102.f383123a = new j(r100.getDynamic(r101), r100.getInt(r101 + 1));
            r102.f383124b = new j(r100.getDynamic(r101 + 2), r100.getInt(r101 + 3));
            return r102;
        }
    }

    public final float[] a() {
        float[] r100 = this.f383121d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        float[] r101 = new float[8];
        int r102 = 0;
        if (this.f383120c != null) goto L10;
        int r103 = 0;
    L8:
        if (r103 >= 8) goto L20;
        r101[r103] = 0.0f;
        r103 = r103 + 1;
    L20:
        this.f383121d = r101;
        if (com.lynx.tasm.utils.b.a(this.f383118a, 0.0f) == true) goto L51;
        if (com.lynx.tasm.utils.b.a(this.f383119b, 0.0f) == true) goto L51;
        float[] r104 = this.f383121d;
        float r105 = r104[0] + r104[2];
        float r106 = this.f383118a;
        if (r105 <= r106) goto L30;
        float r107 = r106 / r105;
        if (r107 >= 1.0f) goto L30;
    L31:
        float r108 = r104[4] + r104[6];
        if (r108 <= r106) goto L36;
        float r109 = r106 / r108;
        if (r109 >= r107) goto L36;
        r107 = r109;
    L36:
        float r110 = r104[1] + r104[7];
        float r111 = this.f383119b;
        if (r110 <= r111) goto L41;
        float r112 = r111 / r110;
        if (r112 >= r107) goto L41;
        r107 = r112;
    L41:
        float r113 = r104[3] + r104[5];
        if (r113 <= r111) goto L47;
        float r114 = r111 / r113;
        if (r114 >= r107) goto L47;
        r107 = r114;
    L47:
        if (r107 >= 1.0f) goto L51;
    L48:
        if (r102 >= 8) goto L51;
        r104[r102] = r104[r102] * r107;
        r102 = r102 + 1;
    L30:
        r107 = 1.0f;
    L51:
        return this.f383121d;
    L10:
        int r115 = 0;
    L11:
        if (r115 >= 4) goto L20;
        a r116 = this.f383120c[r115];
        int r117 = r115 * 2;
        int r118 = r117 + 1;
        if (r116 == null) goto L18;
        j r119 = r116.f383123a;
        if (r119 == null) goto L18;
        r101[r117] = r119.b(this.f383118a);
        r101[r118] = r116.f383124b.b(this.f383119b);
    L19:
        r115 = r115 + 1;
    L18:
        r101[r118] = 0.0f;
        r101[r117] = 0.0f;
        goto L19
    }

    public final boolean b() {
        a[] r100 = this.f383120c;
        if (r100 == null) goto L27;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L27;
        a r103 = r100[r102];
        if (r103 == null) goto L26;
        j r104 = r103.f383123a;
        if (r104 == null) goto L26;
        if (r104.f383146a != 2) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L25;
        j r106 = r103.f383124b;
        if (r106.f383146a != 2) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L26;
    L21:
        if (r106.f383147b != 0.0f) goto L23;
        r107 = true;
    L25:
        return true;
    L14:
        if (r104.f383147b != 0.0f) goto L16;
        r105 = true;
    L26:
        r102 = r102 + 1;
    L27:
        return false;
    }

    public BorderRadius() {
        this.f383118a = 0.0f;
        this.f383119b = 0.0f;
    }

    public final boolean c(int r100, a r101) {
        if (r100 >= 0) goto L4;
        return false;
    L4:
        if (r100 < 4) goto L7;
        return false;
    L7:
        if (this.f383120c != null) goto L10;
        this.f383120c = new a[4];
    L10:
        if (r101.equals(this.f383120c[r100]) == true) goto L15;
        this.f383120c[r100] = r101;
        return true;
    L15:
        return false;
    }

    public final boolean d(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
    L7:
        r100 = 0.0f;
    L9:
        if (r101 >= 0.0f) goto L11;
    L13:
        r101 = 0.0f;
    L15:
        if (com.lynx.tasm.utils.b.a(r100, this.f383118a) == true) goto L17;
    L23:
        this.f383118a = r100;
        this.f383119b = r101;
        this.f383121d = null;
        return true;
    L17:
        if (com.lynx.tasm.utils.b.a(r101, this.f383119b) == false) goto L23;
        if (this.f383121d == null) goto L25;
        return false;
    L25:
        return true;
    L11:
        if (y6a.l.a(r101) == true) goto L13;
    L5:
        if (y6a.l.a(r100) == true) goto L7;
        goto L7
    }
}
