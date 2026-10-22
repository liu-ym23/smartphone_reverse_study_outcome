package mo0;

import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageTag f514577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseControllerListener<ImageInfo> f514578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f514579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f514580d;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f514577a, r101.f514577a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f514578b, r101.f514578b) == true) goto L12;
        return false;
    L12:
        if (this.f514579c == r101.f514579c) goto L14;
        return false;
    L14:
        if (this.f514580d == r101.f514580d) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        ImageTag r100 = this.f514577a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + 0) * 31;
        BaseControllerListener<ImageInfo> r104 = this.f514578b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f514579c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f514580d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageLoadConfig(tag=" + this.f514577a + ", scaleConfig=null, controllerListener=" + this.f514578b + ", removeControllerListenerAfterPlayOnce=" + this.f514579c + ", enableFrameMonitor=" + this.f514580d + ")";
    }

    public b(ImageTag r100, BaseControllerListener r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f514577a = r100;
        this.f514578b = r101;
        this.f514579c = r102;
        this.f514580d = r103;
    }
}
