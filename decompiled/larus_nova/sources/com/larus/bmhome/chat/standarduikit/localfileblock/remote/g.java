package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f309468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f309471e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f309467a, r101.f309467a) == true) goto L12;
        return false;
    L12:
        if (this.f309468b == r101.f309468b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309469c, r101.f309469c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309470d, r101.f309470d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309471e, r101.f309471e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f309467a.hashCode() * 31) + this.f309468b) * 31) + this.f309469c.hashCode()) * 31;
        String r101 = this.f309470d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f309471e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PcRemoteFileRequest(sourceDeviceId=" + this.f309467a + ", sourceAppId=" + this.f309468b + ", filePath=" + this.f309469c + ", fileName=" + this.f309470d + ", fileType=" + this.f309471e + ')';
    }

    public final void b() {
        if (StringsKt.isBlank(this.f309467a) == true) goto L10;
        if (this.f309468b <= 0) goto L10;
        if (StringsKt.isBlank(this.f309469c) == true) goto L10;
        return;
    L10:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_REQUEST, null, 2, null);
    }

    public static boolean a(String r100) {
        int r101 = r100.length();
        if (1 <= r101) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L45;
        int r103 = 0;
    L11:
        if (r103 >= r100.length()) goto L39;
        char r104 = r100.charAt(r103);
        if ('a' <= r104) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L20;
    L35:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L37;
        r103 = r103 + 1;
        goto L11
    L37:
        boolean r107 = false;
    L40:
        if (r107 == false) goto L46;
        return true;
    L46:
        return false;
    L20:
        if ('A' <= r104) goto L22;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == true) goto L35;
        if ('0' <= r104) goto L29;
    L31:
        boolean r109 = false;
    L32:
        if (r109 == true) goto L35;
        r106 = false;
        goto L36
    L29:
        if (r104 >= ':') goto L31;
        r109 = true;
        goto L32
    L22:
        if (r104 >= '[') goto L24;
        r108 = true;
        goto L25
    L15:
        if (r104 >= '{') goto L17;
        r105 = true;
        goto L18
    L39:
        r107 = true;
        goto L40
    L45:
        return false;
    L5:
        if (r101 >= 21) goto L7;
        r102 = true;
        goto L8
    }

    public g(String r100, int r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "sourceDeviceId");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        this.f309467a = r100;
        this.f309468b = r101;
        this.f309469c = r102;
        this.f309470d = r103;
        this.f309471e = r104;
    }
}
