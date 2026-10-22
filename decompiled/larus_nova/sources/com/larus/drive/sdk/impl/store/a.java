package com.larus.drive.sdk.impl.store;

import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrivePreviewOpenRequest f341980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f341981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f341982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f341983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f341984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f341985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f341986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f341987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f341988i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f341980a, r101.f341980a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f341981b, r101.f341981b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f341982c, r101.f341982c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f341983d, r101.f341983d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f341984e, r101.f341984e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f341985f, r101.f341985f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f341986g, r101.f341986g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f341987h, r101.f341987h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f341988i, r101.f341988i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f341980a.hashCode() * 31) + this.f341981b.hashCode()) * 31;
        String r101 = this.f341982c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f341983d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f341984e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f341985f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f341986g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f341987h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f341988i;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiFilePreviewSession(request=" + this.f341980a + ", resourceUri=" + this.f341981b + ", resourceId=" + this.f341982c + ", directShareUrl=" + this.f341983d + ", fileName=" + this.f341984e + ", fileType=" + this.f341985f + ", sourceConversationId=" + this.f341986g + ", sourceBotId=" + this.f341987h + ", sourceMessageId=" + this.f341988i + ')';
    }

    public a(DrivePreviewOpenRequest r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "resourceUri");
        this.f341980a = r100;
        this.f341981b = r101;
        this.f341982c = r102;
        this.f341983d = r103;
        this.f341984e = r104;
        this.f341985f = r105;
        this.f341986g = r106;
        this.f341987h = r107;
        this.f341988i = r110;
    }
}
