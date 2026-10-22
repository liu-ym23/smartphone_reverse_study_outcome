package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class UseTorchAsFlash {
    private final boolean mHasUseTorchAsFlashQuirk;

    public boolean shouldUseTorchAsFlash() {
        return this.mHasUseTorchAsFlashQuirk;
    }

    public UseTorchAsFlash(Quirks r2) {
        this.mHasUseTorchAsFlashQuirk = r2.contains(UseTorchAsFlashQuirk.class);
    }
}
