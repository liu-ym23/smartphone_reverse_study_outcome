package ir5;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewAiChangeReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f495455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f495456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f495457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f495458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OfficeDrivePreviewAiChangeReason f495459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f495460g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f495454a, r101.f495454a) == true) goto L12;
        return false;
    L12:
        if (this.f495455b == r101.f495455b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495456c, r101.f495456c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495457d, r101.f495457d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495458e, r101.f495458e) == true) goto L24;
        return false;
    L24:
        if (this.f495459f == r101.f495459f) goto L27;
        return false;
    L27:
        if (this.f495460g == r101.f495460g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495454a.hashCode() * 31;
        long r101 = this.f495455b;
        int r102 = (((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f495456c.hashCode()) * 31) + this.f495457d.hashCode()) * 31) + this.f495458e.hashCode()) * 31) + this.f495459f.hashCode()) * 31;
        if (this.f495460g == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeDrivePreviewAiContext(sessionId=" + this.f495454a + ", sequence=" + this.f495455b + ", fileInfo=" + this.f495456c + ", permissionInfo=" + this.f495457d + ", previewStateInfo=" + this.f495458e + ", changeReason=" + this.f495459f + ", isVCFollowMode=" + this.f495460g + ')';
    }

    public b(String r100, long r101, c r102, g r103, j r104, OfficeDrivePreviewAiChangeReason r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "fileInfo");
        Intrinsics.checkNotNullParameter(r103, "permissionInfo");
        Intrinsics.checkNotNullParameter(r104, "previewStateInfo");
        Intrinsics.checkNotNullParameter(r105, "changeReason");
        this.f495454a = r100;
        this.f495455b = r101;
        this.f495456c = r102;
        this.f495457d = r103;
        this.f495458e = r104;
        this.f495459f = r105;
        this.f495460g = r106;
    }
}
