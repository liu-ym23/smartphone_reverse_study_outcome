package hda;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f484692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f484693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f484694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484695e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f484691a, r101.f484691a) == true) goto L12;
        return false;
    L12:
        if (this.f484692b == r101.f484692b) goto L15;
        return false;
    L15:
        if (this.f484693c == r101.f484693c) goto L18;
        return false;
    L18:
        if (this.f484694d == r101.f484694d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f484691a.hashCode() * 31;
        if (this.f484692b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f484693c) * 31) + this.f484694d;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MemoryReviewImageRequest(uriText=" + this.f484691a + ", preferFullSize=" + this.f484692b + ", targetWidthPx=" + this.f484693c + ", targetHeightPx=" + this.f484694d + ')';
    }

    public i0(String r100, boolean r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "uriText");
        this.f484691a = r100;
        this.f484692b = r101;
        this.f484693c = r102;
        this.f484694d = r103;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append('@');
        if (r101 == false) goto L5;
        String r105 = "full";
    L6:
        r104.append(r105);
        r104.append(':');
        r104.append(r102);
        r104.append(Permission.EXECUTE);
        r104.append(r103);
        this.f484695e = r104.toString();
        return;
    L5:
        r105 = "thumb";
        goto L6
    }
}
