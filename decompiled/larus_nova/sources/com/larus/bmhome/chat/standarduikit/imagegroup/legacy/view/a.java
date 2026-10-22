package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f309198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f309199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f309200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f309201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f309202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Map<String, Object>> f309203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bc8.b f309204g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309198a, r101.f309198a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309199b, r101.f309199b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309200c, r101.f309200c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f309201d, r101.f309201d) == 0) goto L21;
        return false;
    L21:
        if (this.f309202e == r101.f309202e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309203f, r101.f309203f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309204g, r101.f309204g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f309198a.hashCode() * 31) + this.f309199b.hashCode()) * 31) + this.f309200c.hashCode()) * 31) + Float.floatToIntBits(this.f309201d)) * 31) + this.f309202e) * 31;
        Function0<Map<String, Object>> r101 = this.f309203f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        bc8.b r105 = this.f309204g;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageGroupLegacyInput(sizeData=" + this.f309198a + ", imagesData=" + this.f309199b + ", imageTraceData=" + this.f309200c + ", radius=" + this.f309201d + ", showImageLimit=" + this.f309202e + ", eventExtra=" + this.f309203f + ", blockActionCallback=" + this.f309204g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(y r100, x r101, w r102, float r103, int r104, Function0<? extends Map<String, ? extends Object>> r105, bc8.b r106) {
        Intrinsics.checkNotNullParameter(r100, "sizeData");
        Intrinsics.checkNotNullParameter(r101, "imagesData");
        Intrinsics.checkNotNullParameter(r102, "imageTraceData");
        this.f309198a = r100;
        this.f309199b = r101;
        this.f309200c = r102;
        this.f309201d = r103;
        this.f309202e = r104;
        this.f309203f = r105;
        this.f309204g = r106;
    }
}
