package f0;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f474913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Point f474914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Point f474915c;

    public b(Context r100) {
        this.f474913a = r100;
    }

    public final void a(Camera r100) {
        Camera.Parameters r101 = r100.getParameters();
        Point r102 = this.f474915c;
        r101.setPreviewSize(r102.x, r102.y);
        int r103 = (int) 60000.0f;
        Iterator<int[]> r104 = r100.getParameters().getSupportedPreviewFpsRange().iterator();
        int[] r105 = null;
        int r106 = Integer.MAX_VALUE;
    L3:
        int r107 = 0;
        if (r104.hasNext() == false) goto L8;
        int[] r108 = r104.next();
        int r109 = r103 - r108[0];
        int r110 = r103 - r108[1];
        int r111 = Math.abs(r109);
        int r112 = Math.abs(r110) + r111;
        if (r112 >= r106) goto L3;
        r105 = r108;
        r106 = r112;
        goto L3
    L8:
        if (r105 == null) goto L10;
        r101.setPreviewFpsRange(r105[0], r105[1]);
    L10:
        Camera.CameraInfo r113 = new Camera.CameraInfo();
        Camera.getCameraInfo(0, r113);
        WindowManager r114 = (WindowManager) this.f474913a.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r114 == null) goto L29;
        int r115 = r114.getDefaultDisplay().getRotation();
        if (r115 == 0) goto L25;
        if (r115 != 1) goto L17;
        r107 = 90;
        goto L25
    L17:
        if (r115 != 2) goto L19;
        r107 = 180;
        goto L25
    L19:
        if (r115 != 3) goto L25;
        r107 = 270;
    L25:
        if (r113.facing != 1) goto L27;
        int r116 = (360 - ((r113.orientation + r107) % 360)) % 360;
    L28:
        r107 = r116;
        goto L29
    L27:
        r116 = ((r113.orientation - r107) + 360) % 360;
    L29:
        r100.setDisplayOrientation(r107);
        r100.setParameters(r101);
    }
}
