package com.bytedance.ee.bear.templates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f239066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f239067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f239068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f239069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sbb.e f239070e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f239066a, r101.f239066a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f239067b, r101.f239067b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f239068c, r101.f239068c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f239069d, r101.f239069d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f239070e, r101.f239070e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f239066a.hashCode() * 31;
        String r101 = this.f239067b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f239068c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f239069d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        sbb.e r111 = this.f239070e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "TemplateClickReportParams(type=" + this.f239066a + ", searchKey=" + this.f239067b + ", subPosition=" + this.f239068c + ", subTemplateSort=" + this.f239069d + ", currentFilterDocumentType=" + this.f239070e + ')';
    }

    public final String getType() {
        return this.f239066a;
    }

    public e(String r100, Integer r101, String r102, sbb.e r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 16) == 0) goto L14;
        r103 = null;
    L14:
        Intrinsics.checkNotNullParameter("preview_click", "type");
        this.f239066a = "preview_click";
        this.f239067b = r100;
        this.f239068c = r101;
        this.f239069d = r102;
        this.f239070e = r103;
    }
}
