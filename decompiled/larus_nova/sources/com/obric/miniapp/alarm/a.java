package com.obric.miniapp.alarm;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f397419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f397420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f397421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f397422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f397423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w f397424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f397425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f397426k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f397427l;

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.a$a, reason: collision with other inner class name */
    public static final class C4656a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f397416a, r101.f397416a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397417b, r101.f397417b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397418c, r101.f397418c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397419d, r101.f397419d) == true) goto L21;
        return false;
    L21:
        if (this.f397420e == r101.f397420e) goto L24;
        return false;
    L24:
        if (this.f397421f == r101.f397421f) goto L27;
        return false;
    L27:
        if (this.f397422g == r101.f397422g) goto L30;
        return false;
    L30:
        if (this.f397423h == r101.f397423h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f397424i, r101.f397424i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f397425j, r101.f397425j) == true) goto L39;
        return false;
    L39:
        if (this.f397426k == r101.f397426k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f397427l, r101.f397427l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f397416a.hashCode() * 31) + this.f397417b.hashCode()) * 31) + this.f397418c.hashCode()) * 31) + this.f397419d.hashCode()) * 31;
        long r101 = this.f397420e;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f397421f) * 31) + this.f397422g) * 31;
        int r103 = 1231;
        if (this.f397423h == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (((((r102 + r104) * 31) + this.f397424i.hashCode()) * 31) + this.f397425j.hashCode()) * 31;
        if (this.f397426k == true) goto L11;
        r103 = 1237;
    L11:
        return ((r105 + r103) * 31) + this.f397427l.hashCode();
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "Alarm(id=" + this.f397416a + ", title=" + this.f397417b + ", content=" + this.f397418c + ", triggerTime=" + this.f397419d + ", intervalMinutes=" + this.f397420e + ", repeatCount=" + this.f397421f + ", currentRepeatCount=" + this.f397422g + ", isActive=" + this.f397423h + ", createdAt=" + this.f397424i + ", extraInfo=" + this.f397425j + ", useSystemClock=" + this.f397426k + ", token=" + this.f397427l + ')';
    }

    public /* synthetic */ a(String r110, String r111, String r210, w r211, long r212, int r213, w r214, Map r215, boolean r216, String r217, int r218) {
        if ((r218 & 16) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r218 & 32) == 0) goto L9;
        int r112 = 0;
    L11:
        if ((r218 & 128) == 0) goto L13;
        boolean r113 = true;
    L15:
        if ((r218 & 512) == 0) goto L17;
        Map r114 = new LinkedHashMap();
    L19:
        if ((r218 & 1024) == 0) goto L21;
        boolean r115 = false;
    L22:
        this(r110, r111, r210, r211, r100, r112, 0, r113, r214, r114, r115, r217);
        return;
    L21:
        r115 = r216;
        goto L22
    L17:
        r114 = r215;
        goto L19
    L13:
        r113 = false;
        goto L15
    L9:
        r112 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    public static a a(a r110, String r111, String r112, String r210, w r211, long r212, int r213, Map r214, boolean r215, String r216, int r217) {
        if ((r217 & 1) == 0) goto L5;
        String r100 = r110.f397416a;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r101 = r110.f397417b;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r102 = r110.f397418c;
    L15:
        if ((r217 & 8) == 0) goto L17;
        w r103 = r110.f397419d;
    L19:
        if ((r217 & 16) == 0) goto L21;
        long r104 = r110.f397420e;
    L23:
        if ((r217 & 32) == 0) goto L25;
        int r113 = r110.f397421f;
    L27:
        if ((r217 & 64) == 0) goto L29;
        int r114 = r110.f397422g;
    L31:
        if ((r217 & 128) == 0) goto L33;
        boolean r115 = r110.f397423h;
    L35:
        if ((r217 & 256) == 0) goto L37;
        w r105 = r110.f397424i;
    L38:
        w r116 = r105;
        if ((r217 & 512) == 0) goto L41;
        Map r117 = r110.f397425j;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        boolean r118 = r110.f397426k;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        String r106 = r110.f397427l;
    L50:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "triggerTime");
        Intrinsics.checkNotNullParameter(r116, "createdAt");
        Intrinsics.checkNotNullParameter(r117, "extraInfo");
        Intrinsics.checkNotNullParameter(r106, "token");
        return new a(r100, r101, r102, r103, r104, r113, r114, r115, r116, r117, r118, r106);
    L49:
        r106 = r216;
        goto L50
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r105 = null;
        goto L38
    L33:
        r115 = false;
        goto L35
    L29:
        r114 = 0;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public a(String r100, String r101, String r102, w r103, long r104, int r105, int r106, boolean r110, w r111, Map<String, String> r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "triggerTime");
        Intrinsics.checkNotNullParameter(r111, "createdAt");
        Intrinsics.checkNotNullParameter(r112, "extraInfo");
        Intrinsics.checkNotNullParameter(r114, "token");
        this.f397416a = r100;
        this.f397417b = r101;
        this.f397418c = r102;
        this.f397419d = r103;
        this.f397420e = r104;
        this.f397421f = r105;
        this.f397422g = r106;
        this.f397423h = r110;
        this.f397424i = r111;
        this.f397425j = r112;
        this.f397426k = r113;
        this.f397427l = r114;
    }
}
