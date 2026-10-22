package qsa;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;
import com.ss.android.bytedcert.view.camera.MyPreview;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends usa.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OCRTakePhotoActivity f534705d;

    @Override // usa.d
    public final void a() {
        MyPreview r100 = this.f534705d.f407624e;
        if (r100 == null) goto L25;
        wsa.a r101 = r100.f407807b;
        r101.getClass();
        int r102 = wsa.a.f561109e;
        if (r102 != 1) goto L7;
        wsa.a.f561109e = 0;
    L9:
        Camera r103 = r101.f561110a;
        if (r103 != null) goto L12;
    L18:
        wsa.a r104 = r100.f407807b;
        SurfaceHolder r105 = r100.getHolder();
        r104.getClass();
        Camera r106 = r104.f561110a;     // Catch: Throwable -> L23
        if (r106 == null) goto L25;
        r106.setPreviewDisplay(r105);     // Catch: Throwable -> L23
        r104.f561110a.startPreview();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    L12:
        if (r101.f561112c == null) goto L18;
        r103.stopPreview();
        Camera r107 = r101.f561110a;
        f06.c r108 = new f06.c();
        Object[] r109 = new Object[0];
        f06.b r110 = new f06.b();
        if (r108.b(100101, "android/hardware/Camera", "release", r107, r109, "void", r110).f474982a == false) goto L16;
        r108.a(100101, "android/hardware/Camera", "release", r107, r109, null, r110, false);
    L17:
        r101.f561110a = null;
        Camera.Size r111 = r101.f561112c;
        r101.b(r111.width, r111.height);
        goto L18
    L16:
        r107.release();
        r108.a(100101, "android/hardware/Camera", "release", r107, r109, null, r110, true);
        goto L17
    L7:
        if (r102 != 0) goto L9;
        wsa.a.f561109e = 1;
    L25:
        this.f534705d.F1();
    }

    public i(OCRTakePhotoActivity r100) {
        this.f534705d = r100;
    }
}
