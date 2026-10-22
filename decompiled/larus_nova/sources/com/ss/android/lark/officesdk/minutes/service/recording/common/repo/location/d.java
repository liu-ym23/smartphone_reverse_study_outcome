package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkLocation f434999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final POIInfo f435001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f435002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f435003e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f434999a, r101.f434999a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435000b, r101.f435000b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435001c, r101.f435001c) == true) goto L18;
        return false;
    L18:
        if (this.f435002d == r101.f435002d) goto L21;
        return false;
    L21:
        if (this.f435003e == r101.f435003e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        LarkLocation r100 = this.f434999a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f435000b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        POIInfo r107 = this.f435001c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        int r109 = 1231;
        if (this.f435002d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.f435003e == true) goto L23;
        r109 = 1237;
    L23:
        return r111 + r109;
    L17:
        r110 = 1237;
        goto L18
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingLocationEntity(mmLocation=" + this.f434999a + ", mmPOIAddress=" + this.f435000b + ", poiInfo=" + this.f435001c + ", hasMapSnapshotSuccess=" + this.f435002d + ", hasLocationUploaded=" + this.f435003e + ')';
    }

    public /* synthetic */ d(int r100) {
        this(null, null, null, false, false);
    }

    public d(LarkLocation r100, String r101, POIInfo r102, boolean r103, boolean r104) {
        this.f434999a = r100;
        this.f435000b = r101;
        this.f435001c = r102;
        this.f435002d = r103;
        this.f435003e = r104;
    }

    public static d a(d r100, LarkLocation r101, String r102, POIInfo r103, boolean r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f434999a;
    L5:
        LarkLocation r104 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f435000b;
    L8:
        String r105 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f435001c;
    L11:
        POIInfo r106 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f435002d;
    L14:
        boolean r107 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f435003e;
    L17:
        r100.getClass();
        return new d(r104, r105, r106, r107, r111);
    }
}
