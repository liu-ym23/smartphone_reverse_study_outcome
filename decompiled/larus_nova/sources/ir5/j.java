package ir5;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeDrivePreviewState f495487a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (this.f495487a == ((j) r100).f495487a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f495487a.hashCode();
    }

    public final String toString() {
        return "OfficeDrivePreviewStateInfo(state=" + this.f495487a + ')';
    }

    public j(OfficeDrivePreviewState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f495487a = r100;
    }
}
