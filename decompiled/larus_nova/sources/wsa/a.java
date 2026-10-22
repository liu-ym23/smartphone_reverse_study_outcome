package wsa;

import android.hardware.Camera;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.bytedcert.view.camera.MyPreview;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import com.ss.android.cert.manager.utils.CertLog;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f561108d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f561109e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f561110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Camera.CameraInfo f561111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Camera.Size f561112c;

    static {
        f561108d = new a();
        f561109e = 0;
    }

    public a() {
        this.f561110a = null;
        this.f561111b = new Camera.CameraInfo();
        this.f561112c = null;
    }

    public static void a(Camera r210, MyPreview.a r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {null, null, null, r211};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100107);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        d r107 = r106.preInvoke(100107, "android/hardware/Camera", "takePicture", r210, r101, "void", r110);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r210.takePicture(null, null, null, r211);
        return;
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void b(int r100, int r101) {
        int r102 = 0;
    L4:
        if (r102 >= 3) goto L24;
        ICertCompliance r103 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L10
        if (r103 == null) goto L9;
        this.f561110a = r103.openCamera(f561109e);     // Catch: Exception -> L10
        c(r100, r101);     // Catch: Exception -> L10
        Camera.getCameraInfo(f561109e, this.f561111b);     // Catch: Exception -> L10
        this.f561110a.setDisplayOrientation(90);     // Catch: Exception -> L10
        return;
    L9:
        throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Thread.sleep(100);     // Catch: Throwable -> L14
    L16:
        e.printStackTrace();
        r102 = r102 + 1;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public final void c(int r210, int r211) {
        Camera r100 = this.f561110a;
        if (r100 != null) goto L5;
        return;
    L5:
        Camera.Parameters r101 = r100.getParameters();
        r101.getSupportedPreviewSizes();
        Camera r102 = this.f561110a;
        if (r102 == null) goto L34;
        List<Camera.Size> r103 = r102.getParameters().getSupportedPreviewSizes();
        double r104 = ((double) r211) / ((double) r210);
        if (r103 != null) goto L11;
        Camera.Size r110 = null;
    L30:
        if (r110 != null) goto L42;
        Camera r105 = this.f561110a;
        if (r105 == null) goto L34;
        float r106 = r210 / r211;
        Iterator<Camera.Size> r107 = r105.getParameters().getSupportedPreviewSizes().iterator();
        Camera.Size r108 = null;
        float r109 = Float.MAX_VALUE;
    L37:
        if (r107.hasNext() == false) goto L41;
        Camera.Size r111 = r107.next();
        float r112 = (r111.height / r111.width) - r106;
        if (Math.abs(r112) >= r109) goto L37;
        r109 = Math.abs(r112);
        r108 = r111;
        goto L37
    L41:
        r110 = r108;
    L42:
        this.f561112c = r110;
        if (r110 == null) goto L74;
        List<String> r113 = r101.getSupportedFocusModes();
        if (r113.contains("continuous-picture") == false) goto L48;
        r101.setFocusMode("continuous-picture");
    L53:
        Camera.Size r114 = this.f561112c;
        r101.setPreviewSize(r114.width, r114.height);
        Camera.Size r115 = this.f561112c;
        Camera r116 = this.f561110a;
        if (r116 != null) goto L56;
        Camera.Size r117 = null;
    L71:
        if (r117 == null) goto L73;
        r101.setPictureSize(r117.width, r117.height);
    L73:
        this.f561110a.setParameters(r101);
        CertLog.d("CameraDevice", "set opt size");
        return;
    L56:
        List<Camera.Size> r118 = r116.getParameters().getSupportedPictureSizes();
        float r119 = r115.height / r115.width;
        Iterator<Camera.Size> r120 = r118.iterator();
        r117 = null;
        float r121 = Float.MAX_VALUE;
    L58:
        if (r120.hasNext() == false) goto L71;
        Camera.Size r122 = r120.next();
        int r123 = r122.width;
        if (r123 >= 400) goto L64;
        if (r122.height < 400) goto L58;
    L64:
        if (r123 <= 1600) goto L68;
        if (r122.height > 1600) goto L58;
    L68:
        float r124 = (r122.height / r123) - r119;
        if (Math.abs(r124) >= r121) goto L58;
        r121 = Math.abs(r124);
        r117 = r122;
        goto L58
    L48:
        if (r113.contains("auto") == false) goto L51;
        r101.setFocusMode("auto");
        goto L53
    L51:
        if (r113.contains("infinity") == false) goto L53;
        r101.setFocusMode("infinity");
        goto L53
    L74:
        r101.setPreviewSize(1280, 720);
        r101.setPictureSize(1280, 720);
        CertLog.d("CameraDevice", "720 1280");
        return;
    L11:
        Iterator<Camera.Size> r125 = r103.iterator();
        r110 = null;
        double r126 = Double.MAX_VALUE;
    L13:
        if (r125.hasNext() == false) goto L21;
        Camera.Size r127 = r125.next();
        CertLog.d("Camera.Size", r127.width + "," + r127.height);
        double r128 = ((double) r127.width) / ((double) r127.height);
        if (Math.abs(r128 - r104) > 0.2d) goto L13;
        if (Math.abs(r127.height - r211) >= r126) goto L20;
        r126 = Math.abs(r127.height - r211);
        r110 = r127;
    L20:
        CertLog.d("Camera radio", " width " + r127.width + " height " + r127.height + " ratio " + r128 + " targetRadio " + r104 + " minDiff " + r126);
        goto L13
    L21:
        if (r110 != null) goto L28;
        Iterator<Camera.Size> r129 = r103.iterator();
        double r130 = Double.MAX_VALUE;
    L24:
        if (r129.hasNext() == false) goto L28;
        Camera.Size r131 = r129.next();
        if (Math.abs(r131.height - r211) >= r130) goto L24;
        r130 = Math.abs(r131.height - r211);
        r110 = r131;
    L28:
        if (r110 == null) goto L30;
        CertLog.d("Camera Device", "width = " + r110.width + " height = " + r110.height + " w = " + r210 + " h = " + r211);
    L34:
        r110 = null;
        goto L42
    }
}
