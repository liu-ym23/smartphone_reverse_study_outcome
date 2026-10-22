package vz1;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.ImageType;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageType f557691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f557692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f557693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f557694d;

    public i() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f557691a, r101.f557691a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f557692b, r101.f557692b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f557693c, r101.f557693c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f557694d, r101.f557694d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ImageType r100 = this.f557691a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        k r104 = this.f557692b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f557693c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Bitmap r110 = this.f557694d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShowImageInfo(type=" + this.f557691a + ", model=" + this.f557692b + ", dynamicImageModel=" + this.f557693c + ", bitMap=" + this.f557694d + ")";
    }

    public final ImageType getType() {
        return this.f557691a;
    }

    public i(ImageType r100, k r101, k r102, Bitmap r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = ImageType.ImageModel;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f557691a = r100;
        this.f557692b = r101;
        this.f557693c = r102;
        this.f557694d = r103;
    }
}
