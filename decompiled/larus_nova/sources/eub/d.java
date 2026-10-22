package eub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f474145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f474146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f474147f;

    public d() {
        this(null, null, null, 0, 0, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f474142a, r101.f474142a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474143b, r101.f474143b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474144c, r101.f474144c) == true) goto L18;
        return false;
    L18:
        if (this.f474145d == r101.f474145d) goto L21;
        return false;
    L21:
        if (this.f474146e == r101.f474146e) goto L24;
        return false;
    L24:
        if (this.f474147f == r101.f474147f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f474142a.hashCode() * 31) + this.f474143b.hashCode()) * 31) + this.f474144c.hashCode()) * 31;
        long r101 = this.f474145d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f474146e;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f474147f;
    }

    public final String toString() {
        return "MmMinutesFileUploadFileParam(localPath=" + this.f474142a + ", uriStr=" + this.f474143b + ", fileName=" + this.f474144c + ", fileSizeBytes=" + this.f474145d + ", fileDurationMs=" + this.f474146e + ", fileIndexInMinutes=" + this.f474147f + ')';
    }

    public final String b() {
        return this.f474144c;
    }

    public final long c() {
        return this.f474145d;
    }

    public final String d() {
        return this.f474142a;
    }

    public final String e() {
        return this.f474143b;
    }

    public static d a(d r110, String r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r111 = r110.f474142a;
    L5:
        String r100 = r111;
        if ((r113 & 2) == 0) goto L8;
        String r101 = r110.f474143b;
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r102 = r110.f474144c;
    L13:
        long r103 = 0;
        if ((r113 & 8) == 0) goto L16;
        long r104 = r110.f474145d;
    L18:
        if ((r113 & 16) == 0) goto L20;
        r103 = r110.f474146e;
    L20:
        long r105 = r103;
        if ((r113 & 32) == 0) goto L23;
        r112 = r110.f474147f;
    L23:
        Intrinsics.checkNotNullParameter(r100, "localPath");
        Intrinsics.checkNotNullParameter(r101, "uriStr");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        return new d(r100, r101, r102, r104, r105, r112);
    L16:
        r104 = 0;
        goto L18
    L12:
        r102 = null;
        goto L13
    L8:
        r101 = null;
        goto L10
    }

    public d(String r100, String r101, String r102, long r103, long r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "localPath");
        Intrinsics.checkNotNullParameter(r101, "uriStr");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        this.f474142a = r100;
        this.f474143b = r101;
        this.f474144c = r102;
        this.f474145d = r103;
        this.f474146e = r104;
        this.f474147f = r105;
    }

    public /* synthetic */ d(String r100, String r110, String r111, long r112, long r113, int r114, int r115) {
        String r101 = "";
        if ((r115 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r115 & 4) != 0) goto L14;
        r101 = r111;
    L14:
        long r104 = 0;
        if ((r115 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r115 & 16) != 0) goto L23;
        r104 = r113;
    L23:
        if ((r115 & 32) == 0) goto L25;
        int r106 = 1;
    L26:
        this(r102, r103, r101, r105, r104, r106);
        return;
    L25:
        r106 = r114;
        goto L26
    L17:
        r105 = r112;
        goto L19
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
