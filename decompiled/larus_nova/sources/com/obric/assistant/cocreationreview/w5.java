package com.obric.assistant.cocreationreview;

import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f387772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f387773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a5 f387774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f387775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<d> f387776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f387777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f387778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<c> f387779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z4 f387780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f387781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<b5> f387782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f387783m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w5) == true) goto L8;
        return false;
    L8:
        w5 r101 = (w5) r100;
        if (Intrinsics.areEqual(this.f387771a, r101.f387771a) == true) goto L12;
        return false;
    L12:
        if (this.f387772b == r101.f387772b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387773c, r101.f387773c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387774d, r101.f387774d) == true) goto L21;
        return false;
    L21:
        if (this.f387775e == r101.f387775e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387776f, r101.f387776f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387777g, r101.f387777g) == true) goto L30;
        return false;
    L30:
        if (this.f387778h == r101.f387778h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387779i, r101.f387779i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387780j, r101.f387780j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387781k, r101.f387781k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f387782l, r101.f387782l) == true) goto L45;
        return false;
    L45:
        if (this.f387783m == r101.f387783m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f387771a.hashCode() * 31) + this.f387772b) * 31) + this.f387773c.hashCode()) * 31) + this.f387774d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f387775e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f387776f.hashCode()) * 31) + this.f387777g.hashCode()) * 31;
        if (this.f387778h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((((((r103 + r104) * 31) + this.f387779i.hashCode()) * 31) + this.f387780j.hashCode()) * 31) + this.f387781k.hashCode()) * 31) + this.f387782l.hashCode()) * 31;
        if (this.f387783m == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UsageCardTemplate(recordId=" + this.f387771a + ", backgroundStackCount=" + this.f387772b + ", title=" + this.f387773c + ", feedback=" + this.f387774d + ", readOnly=" + this.f387775e + ", headerTags=" + this.f387776f + ", domainContent=" + this.f387777g + ", domainContentOpensDetail=" + this.f387778h + ", footTags=" + this.f387779i + ", detailView=" + this.f387780j + ", feedbackState=" + this.f387781k + ", feedbackMedia=" + this.f387782l + ", showsFeedbackValue=" + this.f387783m + ')';
    }

    public w5(String r100, int r101, e r102, a5 r103, boolean r104, List<d> r105, View r106, boolean r107, List<c> r110, z4 r111, b r112, List<b5> r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "feedback");
        Intrinsics.checkNotNullParameter(r105, "headerTags");
        Intrinsics.checkNotNullParameter(r106, "domainContent");
        Intrinsics.checkNotNullParameter(r110, "footTags");
        Intrinsics.checkNotNullParameter(r111, "detailView");
        Intrinsics.checkNotNullParameter(r112, "feedbackState");
        Intrinsics.checkNotNullParameter(r113, "feedbackMedia");
        this.f387771a = r100;
        this.f387772b = r101;
        this.f387773c = r102;
        this.f387774d = r103;
        this.f387775e = r104;
        this.f387776f = r105;
        this.f387777g = r106;
        this.f387778h = r107;
        this.f387779i = r110;
        this.f387780j = r111;
        this.f387781k = r112;
        this.f387782l = r113;
        this.f387783m = r114;
    }
}
