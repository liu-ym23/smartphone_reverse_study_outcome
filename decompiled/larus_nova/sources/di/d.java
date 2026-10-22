package di;

import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f468709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f468710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f468711c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f468709a, r101.f468709a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468710b, r101.f468710b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468711c, r101.f468711c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f468709a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        q r104 = this.f468710b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f468711c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECNetDetailInfo(duration=" + this.f468709a + ", timeStamp=" + this.f468710b + ", dimension=" + this.f468711c + ")";
    }

    public d(c r100, q r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "duration");
        Intrinsics.checkNotNullParameter(r101, VideoSurfaceTexture.KEY_TIME);
        Intrinsics.checkNotNullParameter(r102, "dimension");
        this.f468709a = r100;
        this.f468710b = r101;
        this.f468711c = r102;
    }
}
