package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    private int getRelativeCameraOrientation(boolean r3) {
        int r0 = this.mDisplay.getRotation();     // Catch: Exception -> L6
        int r1 = this.mCameraInfo.getSensorRotationDegrees(r0);     // Catch: Exception -> L6
        if (r3 == false) goto L10;
        return (360 - r1) % 360;
    L10:
        return r1;
    L6:
        return 0;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    public PointF convertPoint(float r9, float r10) {
        float r0 = this.mWidth;
        float r1 = this.mHeight;
        if (this.mCameraInfo.getLensFacing() != 0) goto L5;
        boolean r2 = true;
    L6:
        int r3 = getRelativeCameraOrientation(r2);
        if (r3 == 90) goto L11;
        if (r3 == 270) goto L11;
        r10 = r9;
        r9 = r10;
        r1 = r0;
        r0 = r1;
    L11:
        if (r3 != 90) goto L13;
    L18:
        r9 = r0 - r9;
    L19:
        if (r2 == false) goto L22;
        r10 = r1 - r10;
    L22:
        return new PointF(r10 / r1, r9 / r0);
    L13:
        if (r3 == 180) goto L17;
        if (r3 != 270) goto L19;
        r10 = r1 - r10;
        goto L19
    L17:
        r10 = r1 - r10;
        goto L18
    L5:
        r2 = false;
        goto L6
    }

    public DisplayOrientedMeteringPointFactory(Display r1, CameraInfo r2, float r3, float r4) {
        this.mWidth = r3;
        this.mHeight = r4;
        this.mDisplay = r1;
        this.mCameraInfo = r2;
    }
}
