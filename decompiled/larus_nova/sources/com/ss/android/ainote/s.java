package com.ss.android.ainote;

import com.ss.android.lark.pb.entities.ImageCropType;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f407200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f407201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteString f407202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageCropType f407203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f407204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f407205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f407206g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f407200a, r101.f407200a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f407201b, r101.f407201b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f407202c, r101.f407202c) == true) goto L18;
        return false;
    L18:
        if (this.f407203d == r101.f407203d) goto L21;
        return false;
    L21:
        if (this.f407204e == r101.f407204e) goto L24;
        return false;
    L24:
        if (this.f407205f == r101.f407205f) goto L27;
        return false;
    L27:
        if (this.f407206g == r101.f407206g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f407200a.hashCode() * 31) + this.f407201b.hashCode()) * 31) + this.f407202c.hashCode()) * 31) + this.f407203d.hashCode()) * 31) + this.f407204e) * 31) + this.f407205f) * 31) + this.f407206g;
    }

    public final String toString() {
        return "AINoteImageVariant(imageKey=" + this.f407200a + ", fsUnit=" + this.f407201b + ", crypto=" + this.f407202c + ", cropType=" + this.f407203d + ", width=" + this.f407204e + ", height=" + this.f407205f + ", exifOrientation=" + this.f407206g + ')';
    }

    public s(String r100, String r101, ByteString r102, ImageCropType r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        Intrinsics.checkNotNullParameter(r102, "crypto");
        Intrinsics.checkNotNullParameter(r103, "cropType");
        this.f407200a = r100;
        this.f407201b = r101;
        this.f407202c = r102;
        this.f407203d = r103;
        this.f407204e = r104;
        this.f407205f = r105;
        this.f407206g = r106;
    }
}
