package ir5;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewAiChangeReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final String a;
    public final long b;
    public final c c;
    public final g d;
    public final j e;
    public final OfficeDrivePreviewAiChangeReason f;
    public final boolean g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L5;
        int r3 = 1231;
    L7:
        return r2 + r3;
    L5:
        r3 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeDrivePreviewAiContext(sessionId=" + this.a + ", sequence=" + this.b + ", fileInfo=" + this.c + ", permissionInfo=" + this.d + ", previewStateInfo=" + this.e + ", changeReason=" + this.f + ", isVCFollowMode=" + this.g + ')';
    }

    public b(String r2, long r3, c r5, g r6, j r7, OfficeDrivePreviewAiChangeReason r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "fileInfo");
        Intrinsics.checkNotNullParameter(r6, "permissionInfo");
        Intrinsics.checkNotNullParameter(r7, "previewStateInfo");
        Intrinsics.checkNotNullParameter(r8, "changeReason");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
