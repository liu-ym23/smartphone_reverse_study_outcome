package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_OutConfig extends OutConfig {
    private final Rect getCropRect;
    private final int getFormat;
    private final int getRotationDegrees;
    private final Size getSize;
    private final int getTargets;
    private final UUID getUuid;
    private final boolean isMirroring;
    private final boolean shouldRespectInputCropRect;

    public int hashCode() {
        int r0 = (((((((((((this.getUuid.hashCode() ^ 1000003) * 1000003) ^ this.getTargets) * 1000003) ^ this.getFormat) * 1000003) ^ this.getCropRect.hashCode()) * 1000003) ^ this.getSize.hashCode()) * 1000003) ^ this.getRotationDegrees) * 1000003;
        int r3 = 1231;
        if (this.isMirroring == false) goto L5;
        int r2 = 1231;
    L6:
        int r1 = (r0 ^ r2) * 1000003;
        if (this.shouldRespectInputCropRect == true) goto L11;
        r3 = 1237;
    L11:
        return r1 ^ r3;
    L5:
        r2 = 1237;
        goto L6
    }

    public String toString() {
        return "OutConfig{getUuid=" + this.getUuid + ", getTargets=" + this.getTargets + ", getFormat=" + this.getFormat + ", getCropRect=" + this.getCropRect + ", getSize=" + this.getSize + ", getRotationDegrees=" + this.getRotationDegrees + ", isMirroring=" + this.isMirroring + ", shouldRespectInputCropRect=" + this.shouldRespectInputCropRect + "}";
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public Rect getCropRect() {
        return this.getCropRect;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public int getFormat() {
        return this.getFormat;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public Size getSize() {
        return this.getSize;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public int getTargets() {
        return this.getTargets;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public UUID getUuid() {
        return this.getUuid;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public boolean isMirroring() {
        return this.isMirroring;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public boolean shouldRespectInputCropRect() {
        return this.shouldRespectInputCropRect;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OutConfig) == false) goto L26;
        OutConfig r6 = (OutConfig) r5;
        if (this.getUuid.equals(r6.getUuid()) == true) goto L10;
    L24:
        return false;
    L10:
        if (this.getTargets != r6.getTargets()) goto L24;
        if (this.getFormat != r6.getFormat()) goto L24;
        if (this.getCropRect.equals(r6.getCropRect()) == false) goto L24;
        if (this.getSize.equals(r6.getSize()) == false) goto L24;
        if (this.getRotationDegrees != r6.getRotationDegrees()) goto L24;
        if (this.isMirroring != r6.isMirroring()) goto L24;
        if (this.shouldRespectInputCropRect != r6.shouldRespectInputCropRect()) goto L24;
        return true;
    L26:
        return false;
    }

    public AutoValue_OutConfig(UUID r1, int r2, int r3, Rect r4, Size r5, int r6, boolean r7, boolean r8) {
        if (r1 == null) goto L15;
        this.getUuid = r1;
        this.getTargets = r2;
        this.getFormat = r3;
        if (r4 == null) goto L13;
        this.getCropRect = r4;
        if (r5 == null) goto L11;
        this.getSize = r5;
        this.getRotationDegrees = r6;
        this.isMirroring = r7;
        this.shouldRespectInputCropRect = r8;
        return;
    L11:
        throw new NullPointerException("Null getSize");
    L13:
        throw new NullPointerException("Null getCropRect");
    L15:
        throw new NullPointerException("Null getUuid");
    }
}
