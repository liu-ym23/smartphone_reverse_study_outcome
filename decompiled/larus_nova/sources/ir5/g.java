package ir5;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewPermissionState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f495477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeDrivePreviewPermissionState f495478b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f495477a == r101.f495477a) goto L12;
        return false;
    L12:
        if (this.f495478b == r101.f495478b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f495477a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f495478b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeDrivePreviewPermissionInfo(canRead=" + this.f495477a + ", state=" + this.f495478b + ')';
    }

    public g(boolean r100, OfficeDrivePreviewPermissionState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f495477a = r100;
        this.f495478b = r101;
    }
}
