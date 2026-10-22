package is7;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.dtf.face.config.DeviceSetting;

/* JADX INFO: loaded from: classes22.dex */
public interface e {
    PointF colorToDepth(PointF r100);

    Camera getCamera();

    c getCameraParams();

    int getCameraViewRotation();

    int getColorHeight();

    int getColorWidth();

    int getDepthHeight();

    int getDepthWidth();

    int getPreviewHeight();

    int getPreviewWidth();

    Rect getROI();

    void initCamera(Context r100, boolean r101, boolean r102, DeviceSetting r103);

    boolean isMirror();

    void releaseCamera();

    void setCallback(d r100);

    void startCamera();

    void startPreview(SurfaceHolder r100, float r101, int r102, int r103);

    void stopCamera();

    void stopPreview();
}
