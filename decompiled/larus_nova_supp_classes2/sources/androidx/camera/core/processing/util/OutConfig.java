package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class OutConfig {
    public OutConfig() {
    }

    public abstract Rect getCropRect();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Size getSize();

    public abstract int getTargets();

    public abstract UUID getUuid();

    public abstract boolean isMirroring();

    public abstract boolean shouldRespectInputCropRect();

    public static OutConfig of(SurfaceEdge r6) {
        return of(r6.getTargets(), r6.getFormat(), r6.getCropRect(), TransformUtils.getRotatedSize(r6.getCropRect(), r6.getRotationDegrees()), r6.getRotationDegrees(), r6.isMirroring());
    }

    public static OutConfig of(int r7, int r8, Rect r9, Size r10, int r11, boolean r12) {
        return of(r7, r8, r9, r10, r11, r12, false);
    }

    public static OutConfig of(int r10, int r11, Rect r12, Size r13, int r14, boolean r15, boolean r16) {
        return new AutoValue_OutConfig(UUID.randomUUID(), r10, r11, r12, r13, r14, r15, r16);
    }
}
