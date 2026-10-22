package com.bytedance.ee.bear.templates.center;

import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f238919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f238920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f238921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f238922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f238923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f238924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f238925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f238926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f238927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CreateSelectResult f238928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f238929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f238930l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f238919a, r101.f238919a) == true) goto L12;
        return false;
    L12:
        if (this.f238920b == r101.f238920b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f238921c, r101.f238921c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f238922d, r101.f238922d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f238923e, r101.f238923e) == true) goto L24;
        return false;
    L24:
        if (this.f238924f == r101.f238924f) goto L27;
        return false;
    L27:
        if (this.f238925g == r101.f238925g) goto L30;
        return false;
    L30:
        if (this.f238926h == r101.f238926h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f238927i, r101.f238927i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f238928j, r101.f238928j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f238929k, r101.f238929k) == true) goto L42;
        return false;
    L42:
        if (this.f238930l == r101.f238930l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f238919a.hashCode() * 31;
        long r101 = this.f238920b;
        int r102 = (((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f238921c.hashCode()) * 31) + this.f238922d.hashCode()) * 31) + this.f238923e.hashCode()) * 31) + this.f238924f) * 31;
        int r103 = 1231;
        if (this.f238925g == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f238926h == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((((((r105 + r106) * 31) + this.f238927i.hashCode()) * 31) + this.f238928j.hashCode()) * 31) + this.f238929k.hashCode()) * 31;
        if (this.f238930l == true) goto L15;
        r103 = 1237;
    L15:
        return r107 + r103;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "TemplateCenterFragmentParams(openTemplateCenter=" + this.f238919a + ", categoryId=" + this.f238920b + ", enterSource=" + this.f238921c + ", parentToken=" + this.f238922d + ", module=" + this.f238923e + ", filterType=" + this.f238924f + ", fixedFilter=" + this.f238925g + ", isSpaceV2=" + this.f238926h + ", templateSource=" + this.f238927i + ", createSelectResult=" + this.f238928j + ", spaceId=" + this.f238929k + ", createBlank=" + this.f238930l + ')';
    }

    public d(String r100, long r101, String r102, String r103, String r104, int r105, boolean r106, boolean r110, String r111, CreateSelectResult r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "openTemplateCenter");
        Intrinsics.checkNotNullParameter(r102, "enterSource");
        Intrinsics.checkNotNullParameter(r103, "parentToken");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r111, "templateSource");
        Intrinsics.checkNotNullParameter(r112, "createSelectResult");
        Intrinsics.checkNotNullParameter(r113, "spaceId");
        this.f238919a = r100;
        this.f238920b = r101;
        this.f238921c = r102;
        this.f238922d = r103;
        this.f238923e = r104;
        this.f238924f = r105;
        this.f238925g = r106;
        this.f238926h = r110;
        this.f238927i = r111;
        this.f238928j = r112;
        this.f238929k = r113;
        this.f238930l = r114;
    }
}
