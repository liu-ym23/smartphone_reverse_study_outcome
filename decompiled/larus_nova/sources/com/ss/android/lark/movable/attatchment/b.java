package com.ss.android.lark.movable.attatchment;

import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f432625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f432626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f432627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f432628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f432629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f432630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f432631g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f432625a == r101.f432625a) goto L12;
        return false;
    L12:
        if (this.f432626b == r101.f432626b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f432627c, r101.f432627c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f432628d, r101.f432628d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f432629e, r101.f432629e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f432630f, r101.f432630f) == 0) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f432631g, r101.f432631g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f432625a * 31) + this.f432626b) * 31) + Float.floatToIntBits(this.f432627c)) * 31) + Float.floatToIntBits(this.f432628d)) * 31) + Float.floatToIntBits(this.f432629e)) * 31) + Float.floatToIntBits(this.f432630f)) * 31) + this.f432631g.hashCode();
    }

    public final String toString() {
        return "AttachmentInfo(typeId=" + this.f432625a + ", viewId=" + this.f432626b + ", x=" + this.f432627c + ", y=" + this.f432628d + ", width=" + this.f432629e + ", height=" + this.f432630f + ", property=" + this.f432631g + ')';
    }

    public b(int r100, int r101, float r102, float r103, float r104, float r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r106, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f432625a = r100;
        this.f432626b = r101;
        this.f432627c = r102;
        this.f432628d = r103;
        this.f432629e = r104;
        this.f432630f = r105;
        this.f432631g = r106;
    }
}
