package com.bytedance.ee.bear.contract;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f217091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f217092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f217094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Document f217095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0.b f217096f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (this.f217091a == r101.f217091a) goto L12;
        return false;
    L12:
        if (this.f217092b == r101.f217092b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217093c, r101.f217093c) == true) goto L18;
        return false;
    L18:
        if (this.f217094d == r101.f217094d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f217095e, r101.f217095e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217096f, r101.f217096f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f217091a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f217092b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f217093c;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        if (this.f217094d == true) goto L18;
        r100 = 1237;
    L18:
        int r109 = (r108 + r100) * 31;
        Document r110 = this.f217095e;
        if (r110 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r109 + r111) * 31;
        c0.b r113 = this.f217096f;
        if (r113 == null) goto L27;
        r106 = r113.hashCode();
    L27:
        return r112 + r106;
    L21:
        r111 = r110.hashCode();
        goto L22
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ManualOfflineDownloadConfig(shouldMobileNetworkConfirm=" + this.f217091a + ", isGrid=" + this.f217092b + ", module=" + this.f217093c + ", isNeedReport=" + this.f217094d + ", document=" + this.f217095e + ", callback=" + this.f217096f + ')';
    }

    public j0(boolean r100, boolean r101, String r102, boolean r103, Document r104, c0.b r105) {
        this.f217091a = r100;
        this.f217092b = r101;
        this.f217093c = r102;
        this.f217094d = r103;
        this.f217095e = r104;
        this.f217096f = r105;
    }
}
