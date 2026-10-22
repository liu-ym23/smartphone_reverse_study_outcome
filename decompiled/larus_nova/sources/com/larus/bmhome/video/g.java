package com.larus.bmhome.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GroupType f315323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f315324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f315325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f315326e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f315322a, r101.f315322a) == true) goto L12;
        return false;
    L12:
        if (this.f315323b == r101.f315323b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f315324c, r101.f315324c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f315325d, r101.f315325d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f315326e, r101.f315326e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f315322a.hashCode() * 31) + this.f315323b.hashCode()) * 31;
        String r101 = this.f315324c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f315325d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f315326e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendVideoMobParams(itemId=" + this.f315322a + ", groupType=" + this.f315323b + ", reqId=" + this.f315324c + ", imprIndex=" + this.f315325d + ", recChannelId=" + this.f315326e + ')';
    }

    public /* synthetic */ g(String r100, String r101, String r102) {
        this(r100, GroupType.Video, r101, null, r102);
    }

    public g(String r100, GroupType r101, String r102, Integer r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "groupType");
        this.f315322a = r100;
        this.f315323b = r101;
        this.f315324c = r102;
        this.f315325d = r103;
        this.f315326e = r104;
    }
}
