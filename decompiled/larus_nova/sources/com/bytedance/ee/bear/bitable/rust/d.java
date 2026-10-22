package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitableCacheBlockType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f215269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f215270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f215271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f215272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableCacheBlockType f215273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f215274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f215275g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f215269a, r101.f215269a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f215270b, r101.f215270b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f215271c, r101.f215271c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f215272d, r101.f215272d) == true) goto L21;
        return false;
    L21:
        if (this.f215273e == r101.f215273e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f215274f, r101.f215274f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f215275g, r101.f215275g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f215269a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f215270b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f215271c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f215272d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f215273e.hashCode()) * 31;
        String r113 = this.f215274f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f215275g;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
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
        return "BitableCacheResource(blockId=" + this.f215269a + ", viewId=" + this.f215270b + ", clientVars=" + this.f215271c + ", mainPage=" + this.f215272d + ", blockType=" + this.f215273e + ", recordData=" + this.f215274f + ", addRecordPage=" + this.f215275g + ')';
    }

    public d(String r100, String r101, String r102, String r103, BitableCacheBlockType r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r104, "blockType");
        this.f215269a = r100;
        this.f215270b = r101;
        this.f215271c = r102;
        this.f215272d = r103;
        this.f215273e = r104;
        this.f215274f = r105;
        this.f215275g = r106;
    }
}
