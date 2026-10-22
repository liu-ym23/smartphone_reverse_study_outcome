package com.ss.android.ugc.aweme.search.vision.crop.edge;

import android.graphics.RectF;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/crop/edge/EdgeSet;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EdgeSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Edge f453537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Edge f453538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Edge f453539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Edge f453540d;

    public EdgeSet() {
        this.f453537a = new Edge();
        this.f453538b = new Edge();
        this.f453539c = new Edge();
        this.f453540d = new Edge();
    }

    public final float c(Edge r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, "originEdge");
        Intrinsics.checkNotNullParameter(r101, "imageRect");
        float r102 = r100.f453534a;
        if (Intrinsics.areEqual(r100, this.f453537a) == false) goto L6;
        r100.f453534a = r101.left;
    L15:
        return r100.f453534a - r102;
    L6:
        if (Intrinsics.areEqual(r100, this.f453538b) == false) goto L9;
        r100.f453534a = r101.top;
        goto L15
    L9:
        if (Intrinsics.areEqual(r100, this.f453539c) == false) goto L12;
        r100.f453534a = r101.right;
        goto L15
    L12:
        if (Intrinsics.areEqual(r100, this.f453540d) == false) goto L15;
        r100.f453534a = r101.bottom;
        goto L15
    }

    public final boolean b(Edge r100, RectF r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "originEdge");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        if (Intrinsics.areEqual(r100, this.f453537a) == false) goto L8;
        if ((r100.f453534a - r101.left) < r102) goto L19;
    L20:
        return false;
    L19:
        return true;
    L8:
        if (Intrinsics.areEqual(r100, this.f453538b) == false) goto L13;
        if ((r100.f453534a - r101.top) >= r102) goto L20;
    L13:
        if (Intrinsics.areEqual(r100, this.f453539c) == false) goto L18;
        if ((r101.right - r100.f453534a) >= r102) goto L20;
    L18:
        if ((r101.bottom - r100.f453534a) >= r102) goto L20;
        goto L19
    }

    public final void a(Edge r100, float r101, float r102, RectF r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "originEdge");
        Intrinsics.checkNotNullParameter(r103, "imageRect");
        float r105 = Float.POSITIVE_INFINITY;
        if (Intrinsics.areEqual(r100, this.f453537a) == false) goto L17;
        float r106 = r103.left;
        if ((r101 - r106) < r104) goto L15;
        float r107 = this.f453539c.f453534a;
        float r108 = Edge.f453533b;
        float r109 = r107 - r108;
        if (r101 >= r109) goto L12;
        r109 = Float.POSITIVE_INFINITY;
    L12:
        if (((r107 - r101) / 1.0f) > r108) goto L14;
        r105 = r107 - (r108 * 1.0f);
    L14:
        r106 = Math.min(r101, Math.min(r109, r105));
    L15:
        r100.f453534a = r106;
        return;
    L17:
        if (Intrinsics.areEqual(r100, this.f453538b) == false) goto L30;
        float r110 = r103.top;
        if ((r102 - r110) < r104) goto L29;
        float r111 = this.f453540d.f453534a;
        float r112 = Edge.f453533b;
        float r113 = r111 - r112;
        if (r102 >= r113) goto L26;
        r113 = Float.POSITIVE_INFINITY;
    L26:
        if (((r111 - r102) * 1.0f) > r112) goto L28;
        r105 = r111 - (r112 / 1.0f);
    L28:
        r110 = Math.min(r102, Math.min(r113, r105));
    L29:
        r100.f453534a = r110;
        return;
    L30:
        float r114 = Float.NEGATIVE_INFINITY;
        if (Intrinsics.areEqual(r100, this.f453539c) == false) goto L45;
        float r115 = r103.right;
        if ((r115 - r101) < r104) goto L43;
        float r116 = this.f453537a.f453534a;
        float r117 = Edge.f453533b;
        float r118 = r117 + r116;
        if (r101 <= r118) goto L40;
        r118 = Float.NEGATIVE_INFINITY;
    L40:
        if (((r101 - r116) / 1.0f) > r117) goto L42;
        r114 = r116 + (r117 * 1.0f);
    L42:
        r115 = Math.max(r101, Math.max(r118, r114));
    L43:
        r100.f453534a = r115;
        return;
    L45:
        if (Intrinsics.areEqual(r100, this.f453540d) == false) goto L62;
        float r119 = r103.bottom;
        if ((r119 - r102) < r104) goto L57;
        float r120 = this.f453538b.f453534a;
        float r121 = Edge.f453533b;
        float r122 = r121 + r120;
        if (r102 <= r122) goto L54;
        r122 = Float.NEGATIVE_INFINITY;
    L54:
        if (((r102 - r120) * 1.0f) > r121) goto L56;
        r114 = r120 + (r121 / 1.0f);
    L56:
        r119 = Math.max(r102, Math.max(r114, r122));
    L57:
        r100.f453534a = r119;
        return;
    }
}
