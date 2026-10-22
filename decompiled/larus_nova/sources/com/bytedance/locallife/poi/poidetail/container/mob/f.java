package com.bytedance.locallife.poi.poidetail.container.mob;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f263865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f263866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f263867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f263868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f263869e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f263865a, r101.f263865a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f263866b, r101.f263866b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f263867c, r101.f263867c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f263868d, r101.f263868d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f263869e, r101.f263869e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f263865a.hashCode() * 31) + this.f263866b.hashCode()) * 31;
        String r101 = this.f263867c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f263868d.hashCode()) * 31;
        String r105 = this.f263869e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiAutoAnchorTrackContext(source=" + this.f263865a + ", method=" + this.f263866b + ", enterMethod=" + this.f263867c + ", targetNodeTag=" + this.f263868d + ", targetSubViewId=" + this.f263869e + ')';
    }

    public f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("schema", "source");
        Intrinsics.checkNotNullParameter("smooth_top_model", com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "targetNodeTag");
        this.f263865a = "schema";
        this.f263866b = "smooth_top_model";
        this.f263867c = r100;
        this.f263868d = r101;
        this.f263869e = r102;
    }
}
