package com.bytedance.ee.bear.templates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f239071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f239072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f239073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f239074d;

    public f() {
        String r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f239071a, r101.f239071a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f239072b, r101.f239072b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f239073c, r101.f239073c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f239074d, r101.f239074d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f239071a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f239072b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f239073c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f239074d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateShowReportParams(templateToken=" + this.f239071a + ", templateName=" + this.f239072b + ", setName=" + this.f239073c + ", templateType=" + this.f239074d + ')';
    }

    public /* synthetic */ f(String r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r102 & 4) == 0) goto L11;
        String r104 = "";
    L13:
        if ((r102 & 8) != 0) goto L16;
        r103 = null;
    L16:
        this(r100, r101, r104, r103);
        return;
    L11:
        r104 = null;
        goto L13
    }

    public f(String r100, String r101, String r102, String r103) {
        this.f239071a = r100;
        this.f239072b = r101;
        this.f239073c = r102;
        this.f239074d = r103;
    }
}
