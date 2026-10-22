package com.ss.android.ugc.aweme.search.vision.crop;

import android.graphics.PointF;
import android.graphics.RectF;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/crop/CirclePoint;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CirclePoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f453480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f453481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f453482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f453483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f453484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f453485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f453486g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CirclePoint) == false) goto L20;
        CirclePoint r101 = (CirclePoint) r100;
        if (this.f453480a == r101.f453480a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f453481b, r101.f453481b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f453482c, r101.f453482c) == true) goto L12;
        return false;
    L12:
        if (this.f453483d == r101.f453483d) goto L14;
        return false;
    L14:
        if (this.f453484e == r101.f453484e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f453485f, r101.f453485f) == true) goto L18;
        return false;
    L18:
        if (this.f453486g == r101.f453486g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = this.f453480a * 31;
        RectF r101 = this.f453481b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        PointF r105 = this.f453482c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f453483d;
        ?? r109 = 1;
        ?? r110 = r108;
        if (r108 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r107 + r110) * 31;
        boolean r112 = this.f453484e;
        ?? r113 = r112;
        if (r112 == false) goto L16;
        r113 = 1;
    L16:
        int r114 = (r111 + r113) * 31;
        RectF r115 = this.f453485f;
        if (r115 == null) goto L19;
        r102 = r115.hashCode();
    L19:
        int r116 = (r114 + r102) * 31;
        boolean r117 = this.f453486g;
        if (r117 == true) goto L24;
        r109 = r117;
    L24:
        return r116 + r109;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CirclePoint(index=" + this.f453480a + ", rect=" + this.f453481b + ", centralPoint=" + this.f453482c + ", isShow=" + this.f453483d + ", isExpand=" + this.f453484e + ", clickRectF=" + this.f453485f + ", isVirtual=" + this.f453486g + ")";
    }

    public CirclePoint(int r100, RectF r101, boolean r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        RectF r102 = null;
        if ((r112 & 4) == 0) goto L8;
        float r103 = 2;
        PointF r104 = new PointF(r101.left + (r101.width() / r103), r101.top + (r101.height() / r103));
    L10:
        if ((r112 & 8) == 0) goto L13;
        r110 = true;
    L13:
        if ((r112 & 32) == 0) goto L16;
        r102 = new RectF();
    L16:
        if ((r112 & 64) == 0) goto L18;
        r111 = false;
    L18:
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r104, "centralPoint");
        Intrinsics.checkNotNullParameter(r102, "clickRectF");
        this.f453480a = r100;
        this.f453481b = r101;
        this.f453482c = r104;
        this.f453483d = r110;
        this.f453484e = false;
        this.f453485f = r102;
        this.f453486g = r111;
        return;
    L8:
        r104 = null;
        goto L10
    }
}
