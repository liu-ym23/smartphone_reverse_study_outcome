package com.bytedance.ee.bear.more;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f234634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f234636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f234638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f234639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f234640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f234641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f234642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f234643k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f234633a, r101.f234633a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234634b, r101.f234634b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234635c, r101.f234635c) == true) goto L18;
        return false;
    L18:
        if (this.f234636d == r101.f234636d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234637e, r101.f234637e) == true) goto L24;
        return false;
    L24:
        if (this.f234638f == r101.f234638f) goto L27;
        return false;
    L27:
        if (this.f234639g == r101.f234639g) goto L30;
        return false;
    L30:
        if (this.f234640h == r101.f234640h) goto L33;
        return false;
    L33:
        if (this.f234641i == r101.f234641i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f234642j, r101.f234642j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f234643k, r101.f234643k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f234633a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bundle r104 = this.f234634b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f234635c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f234636d) * 31;
        String r110 = this.f234637e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.f234638f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f234639g == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f234640h == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f234641i == true) goto L34;
        r113 = 1237;
    L34:
        int r120 = (r119 + r113) * 31;
        String r121 = this.f234642j;
        if (r121 != null) goto L37;
        int r122 = 0;
    L38:
        int r123 = (r120 + r122) * 31;
        Map<String, Object> r124 = this.f234643k;
        if (r124 == null) goto L43;
        r101 = r124.hashCode();
    L43:
        return r123 + r101;
    L37:
        r122 = r121.hashCode();
        goto L38
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "MoreSubMenuViewBean(event=" + this.f234633a + ", bundle=" + this.f234634b + ", objToken=" + this.f234635c + ", type=" + this.f234636d + ", subType=" + this.f234637e + ", isWiki=" + this.f234638f + ", isAtVc=" + this.f234639g + ", isOwner=" + this.f234640h + ", isVersion=" + this.f234641i + ", userPermisson=" + this.f234642j + ", extraParams=" + this.f234643k + ')';
    }

    public final int getType() {
        return this.f234636d;
    }

    public /* synthetic */ l(String r110, Bundle r111, String r112, int r113, String r114, boolean r115, boolean r116, boolean r210, boolean r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, null);
    }

    public l(String r100, Bundle r101, String r102, int r103, String r104, boolean r105, boolean r106, boolean r107, boolean r108, String r110, Map<String, ? extends Object> r111) {
        this.f234633a = r100;
        this.f234634b = r101;
        this.f234635c = r102;
        this.f234636d = r103;
        this.f234637e = r104;
        this.f234638f = r105;
        this.f234639g = r106;
        this.f234640h = r107;
        this.f234641i = r108;
        this.f234642j = r110;
        this.f234643k = r111;
    }
}
