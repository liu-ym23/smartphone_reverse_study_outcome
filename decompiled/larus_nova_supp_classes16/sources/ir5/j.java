package ir5;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public final OfficeDrivePreviewState a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof j) == true) goto L9;
        return false;
    L9:
        if (this.a == ((j) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "OfficeDrivePreviewStateInfo(state=" + this.a + ')';
    }

    public j(OfficeDrivePreviewState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
    }
}
