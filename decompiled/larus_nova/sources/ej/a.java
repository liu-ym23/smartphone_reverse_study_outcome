package ej;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f472831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f472832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f472833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f472834g;

    public a() {
        this(null, null, null, 0, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f472828a, r101.f472828a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f472829b, r101.f472829b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f472830c, r101.f472830c) == true) goto L12;
        return false;
    L12:
        if (this.f472831d == r101.f472831d) goto L14;
        return false;
    L14:
        if (this.f472832e == r101.f472832e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f472833f, r101.f472833f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f472834g, r101.f472834g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f472828a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f472829b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f472830c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f472831d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f472832e;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        Integer r114 = this.f472833f;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f472834g;
        if (r117 == null) goto L22;
        r101 = r117.hashCode();
    L22:
        return r116 + r101;
    L17:
        r115 = 0;
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
        return "CalendarData(eventId=" + this.f472828a + ", title=" + this.f472829b + ", description=" + this.f472830c + ", startTime=" + this.f472831d + ", endTime=" + this.f472832e + ", alarmMinutes=" + this.f472833f + ", url=" + this.f472834g + ")";
    }

    public /* synthetic */ a(String r110, String r111, String r112, long r113, long r114, int r210) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = 0;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = 0;
    L22:
        this(r100, r101, r102, r103, r104, null, null);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(String r100, String r101, String r102, long r103, long r104, Integer r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
        this.f472828a = r100;
        this.f472829b = r101;
        this.f472830c = r102;
        this.f472831d = r103;
        this.f472832e = r104;
        this.f472833f = r105;
        this.f472834g = r110;
    }
}
