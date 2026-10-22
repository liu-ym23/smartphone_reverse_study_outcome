package dl1;

import android.content.Context;
import android.os.Bundle;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoModel f469100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f469101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f469102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Resolution f469103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f469104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f469105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f469106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bundle f469107i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L24;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f469099a, r101.f469099a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f469100b, r101.f469100b) == true) goto L10;
        return false;
    L10:
        if (this.f469101c == r101.f469101c) goto L12;
        return false;
    L12:
        if (this.f469102d == r101.f469102d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f469103e, r101.f469103e) == true) goto L16;
        return false;
    L16:
        if (this.f469104f == r101.f469104f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469105g, r101.f469105g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f469106h, r101.f469106h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f469107i, r101.f469107i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f469099a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VideoModel r104 = this.f469100b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f469101c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f469102d;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Resolution r111 = this.f469103e;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (((r110 + r112) * 31) + this.f469104f) * 31;
        Long r114 = this.f469105g;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        Context r117 = this.f469106h;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        Bundle r120 = this.f469107i;
        if (r120 == null) goto L26;
        r101 = r120.hashCode();
    L26:
        return r119 + r101;
    L21:
        r118 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplayPreloadItem(vid=" + this.f469099a + ", videoModel=" + this.f469100b + ", preloadSize=" + this.f469101c + ", PreloadMillisecond=" + this.f469102d + ", resolution=" + this.f469103e + ", scene=" + this.f469104f + ", episodeId=" + this.f469105g + ", context=" + this.f469106h + ", bundle=" + this.f469107i + ")";
    }

    public final Context getContext() {
        return this.f469106h;
    }

    public i(String r100, VideoModel r101, long r102, long r103, Resolution r104, int r105, Long r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r104, "resolution");
        this.f469099a = r100;
        this.f469100b = r101;
        this.f469101c = r102;
        this.f469102d = r103;
        this.f469103e = r104;
        this.f469104f = r105;
        this.f469105g = r110;
        this.f469106h = null;
        this.f469107i = r111;
    }
}
