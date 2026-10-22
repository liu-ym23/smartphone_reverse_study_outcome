package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f241846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f241847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f241848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TreeNode f241849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WikiRelation f241850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f241851h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f241844a, r101.f241844a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f241845b, r101.f241845b) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.f241846c, r101.f241846c) == 0) goto L18;
        return false;
    L18:
        if (this.f241847d == r101.f241847d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f241848e, r101.f241848e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f241849f, r101.f241849f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f241850g, r101.f241850g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f241851h, r101.f241851h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f241844a.hashCode() * 31) + this.f241845b.hashCode()) * 31;
        long r101 = Double.doubleToLongBits(this.f241846c);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f241847d == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f241848e;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        TreeNode r109 = this.f241849f;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        WikiRelation r112 = this.f241850g;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f241851h;
        if (r115 == null) goto L23;
        r106 = r115.hashCode();
    L23:
        return r114 + r106;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "MovToNodeBean(srcToken=" + this.f241844a + ", destToken=" + this.f241845b + ", newSortId=" + this.f241846c + ", forceExpand=" + this.f241847d + ", expandToToken=" + this.f241848e + ", spareNode=" + this.f241849f + ", spareRelation=" + this.f241850g + ", destSpaceId=" + this.f241851h + ')';
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.c
    public final String getSpaceId() {
        return this.f241851h;
    }

    public f(String r100, String r101, double r102, boolean r103, String r104, TreeNode r105, WikiRelation r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "srcToken");
        Intrinsics.checkNotNullParameter(r101, "destToken");
        this.f241844a = r100;
        this.f241845b = r101;
        this.f241846c = r102;
        this.f241847d = r103;
        this.f241848e = r104;
        this.f241849f = r105;
        this.f241850g = r106;
        this.f241851h = r110;
    }
}
