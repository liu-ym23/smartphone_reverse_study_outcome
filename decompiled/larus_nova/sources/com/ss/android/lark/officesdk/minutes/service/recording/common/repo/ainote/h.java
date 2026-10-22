package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteString f434849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f434850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f434851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f434852g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f434846a, r101.f434846a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434847b, r101.f434847b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434848c, r101.f434848c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434849d, r101.f434849d) == true) goto L21;
        return false;
    L21:
        if (this.f434850e == r101.f434850e) goto L24;
        return false;
    L24:
        if (this.f434851f == r101.f434851f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f434852g, r101.f434852g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f434846a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f434847b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f434848c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((((((((r106 + r101) * 31) + this.f434849d.hashCode()) * 31) + this.f434850e) * 31) + this.f434851f) * 31) + this.f434852g.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAINotePreviewImageSource(localUri=" + this.f434846a + ", imageKey=" + this.f434847b + ", fsUnit=" + this.f434848c + ", crypto=" + this.f434849d + ", width=" + this.f434850e + ", height=" + this.f434851f + ", sourceType=" + this.f434852g + ')';
    }

    public h(String r100, String r101, String r102, ByteString r103, int r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r103, "crypto");
        Intrinsics.checkNotNullParameter(r106, "sourceType");
        this.f434846a = r100;
        this.f434847b = r101;
        this.f434848c = r102;
        this.f434849d = r103;
        this.f434850e = r104;
        this.f434851f = r105;
        this.f434852g = r106;
    }
}
