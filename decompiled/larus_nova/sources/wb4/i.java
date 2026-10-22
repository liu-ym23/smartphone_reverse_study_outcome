package wb4;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Size;
import android.view.Surface;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.bdturing.livedetect.view.AutoFixTextureView;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f558957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f558958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AutoFixTextureView f558959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PthreadHandlerThreadV2 f558960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f558961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f558962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f558963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Size f558964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f558965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageReader f558966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public wb4.b f558967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public wb4.a f558968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CaptureRequest.Builder f558969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CameraDevice f558970n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f558971o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CameraCaptureSession f558972p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f558973q;

    public class a extends CameraDevice.StateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f558974a;

        public a(i r100) {
            this.f558974a = r100;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice r100) {
            super.onClosed(r100);
            e.b().c("onClosed", null);
            int r101 = n.f532367a;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice r100) {
            int r101 = n.f532367a;
            e.b().c("onDisconnected", null);
            this.f558974a.f558970n = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice r210) {
            ArrayList r100 = new ArrayList();
            Object[] r110 = {r210};
            f06.b r111 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r112 = r102;
            int r103 = r112.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r112[r104];
            int r113 = r104;
            int r114 = r103;
            f06.a[] r115 = r112;
            f06.d r106 = r105.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "com/bytedance/bdturing/livedetect/camera/TuringCamera2Helper$2", "onOpened", this, r110, "void", r111);     // Catch: Exception -> L25
            if (r106.f474982a == true) goto L12;
            r100.add(r105);     // Catch: Exception -> L25
            goto L14
        L12:
            String r107 = null;
        L17:
            if (r106.f474982a == false) goto L19;
            return;
        L19:
            int r108 = n.f532367a;
            e.b().c("onOpened", r107);
            i r109 = this.f558974a;
            r109.f558970n = r210;
            SurfaceTexture r116 = r109.f558959c.getSurfaceTexture();     // Catch: Exception -> L22
            r116.setDefaultBufferSize(r109.f558964h.getWidth(), r109.f558964h.getHeight());     // Catch: Exception -> L22
            Surface r117 = new Surface(r116);     // Catch: Exception -> L22
            CaptureRequest.Builder r118 = r109.f558970n.createCaptureRequest(1);     // Catch: Exception -> L22
            r109.f558969m = r118;     // Catch: Exception -> L22
            r118.addTarget(r117);     // Catch: Exception -> L22
            r109.f558969m.addTarget(r109.f558966j.getSurface());     // Catch: Exception -> L22
            r109.f558970n.createCaptureSession(Arrays.asList(new Surface[]{r117, r109.f558966j.getSurface()}), r109.f558973q, r109.f558961e);     // Catch: Exception -> L22
            return;
        L22:
            e = move-exception;
            e.printStackTrace();
            r109.d(40004, e);
            return;
        L14:
            r104 = r113 + 1;
            r103 = r114;
            r112 = r115;
            goto L8
        L15:
            r107 = null;
            r106 = new f06.d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice r100, int r101) {
            this.f558974a.f558970n = null;
            e.b().c(LynxVideoManagerLite.EVENT_ON_ERROR, null);
            this.f558974a.d(40001, new IllegalStateException("camera onError:error_code=" + r101));
        }
    }

    public class b extends CameraCaptureSession.StateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f558975a;

        public class a extends CameraCaptureSession.CaptureCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f558976a;

            public a(b r100) {
                this.f558976a = r100;
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public final void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
                e.b().c("onCaptureFailed", "captureFailed: reason=" + r102.getReason() + ":" + r102);
                this.f558976a.f558975a.d(40002, new IllegalStateException("captureFailed: reason=" + r102.getReason() + ":" + r102.toString()));
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public final void onCaptureStarted(CameraCaptureSession r100, CaptureRequest r101, long r102, long r103) {
                g r104 = this.f558976a.f558975a.f558958b;
                if (r104 == null) goto L24;
                monitor-enter(r104);
            L21:
                th = move-exception;
                throw th;
            L6:
                if (r104.f558953c != 0) goto L8;
                r104.f558954d = ((r104.f558952b - r104.f558951a) + 360) % 360;     // Catch: Throwable -> L21
            L19:
                monitor-exit(r104);
                return;
            L8:
                int r105 = r104.f558951a;     // Catch: Throwable -> L21
                if (r105 != 0) goto L11;
            L18:
                r104.f558954d = ((r104.f558952b - r105) + 360) % 360;     // Catch: Throwable -> L21
                goto L19
            L11:
                if (r105 != 90) goto L13;
            L17:
                r104.f558954d = (360 - ((r104.f558952b + r105) % 360)) % 360;     // Catch: Throwable -> L21
                goto L19
            L13:
                if (r105 == 180) goto L18;
                if (r105 == 270) goto L17;
            }
        }

        public b(i r100) {
            this.f558975a = r100;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(CameraCaptureSession r100) {
            e.b().c("onConfigureFailed", "CameraCaptureSession:" + r100);
            this.f558975a.d(40002, new IllegalStateException("camera configureFailed:"));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(CameraCaptureSession r100) {
            i r101 = this.f558975a;
            if (r101.f558970n != null) goto L5;
            return;
        L5:
            r101.f558972p = r100;
            r101.f558969m.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L8
            this.f558975a.f558969m.set(CaptureRequest.CONTROL_AE_MODE, 2);     // Catch: Exception -> L8
            i r102 = this.f558975a;     // Catch: Exception -> L8
            r102.f558972p.setRepeatingRequest(r102.f558969m.build(), new a(this), this.f558975a.f558961e);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            e.printStackTrace();
            this.f558975a.d(40002, e);
        }
    }

    public static class c implements Comparator<Size> {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Size r100, Size r101) {
            Size r102 = r100;
            Size r103 = r101;
            return Long.signum((((long) r102.getWidth()) * ((long) r102.getHeight())) - (((long) r103.getWidth()) * ((long) r103.getHeight())));
        }
    }

    public final void e() {
        CameraManager r100 = (CameraManager) this.f558957a.getSystemService("camera");
        String[] r101 = r100.getCameraIdList();     // Catch: Exception -> L55
        int r102 = r101.length;     // Catch: Exception -> L55
        boolean r103 = false;
        CameraCharacteristics r104 = null;
        int r105 = 0;
    L4:
        if (r105 >= r102) goto L18;
        String r106 = r101[r105];     // Catch: Exception -> L55
        CameraCharacteristics r107 = r100.getCameraCharacteristics(r106);     // Catch: Exception -> L55
        Integer r108 = (Integer) r107.get(CameraCharacteristics.LENS_FACING);     // Catch: Exception -> L55
        if (r108 == null) goto L17;
        if (r108.intValue() != 0) goto L17;
        this.f558962f = r106;     // Catch: Exception -> L55
        g r109 = this.f558958b;     // Catch: Exception -> L55
        int r110 = r108.intValue();     // Catch: Exception -> L55
        monitor-enter(r109);     // Catch: Exception -> L55
        r109.f558953c = r110;     // Catch: Throwable -> L14
        monitor-exit(r109);     // Catch: Exception -> L55
        r104 = r107;
        goto L18
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L55
    L17:
        r105 = r105 + 1;     // Catch: Exception -> L55
        r104 = r107;
    L18:
        if (r104 == null) goto L54;
        StreamConfigurationMap r111 = (StreamConfigurationMap) r104.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Exception -> L55
        if (r111 == null) goto L52;
        int r112 = this.f558957a.getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L55
        int r113 = ((Integer) r104.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();     // Catch: Exception -> L55
        this.f558963g = r113;     // Catch: Exception -> L55
        this.f558958b.a(r113);     // Catch: Exception -> L55
        if (r112 == 0) goto L33;
        if (r112 == 1) goto L28;
        if (r112 == 2) goto L33;
        if (r112 == 3) goto L28;
        int r114 = n.f532367a;     // Catch: Exception -> L55
    L38:
        Point r115 = new Point();     // Catch: Exception -> L55
        this.f558957a.getWindowManager().getDefaultDisplay().getSize(r115);     // Catch: Exception -> L55
        int r116 = r115.x;     // Catch: Exception -> L55
        int r117 = r115.y;     // Catch: Exception -> L55
        int r118 = 480;
        int r119 = 640;
        if (r103 == false) goto L42;
        r118 = 640;
        r119 = 480;
        r116 = r117;
        r117 = r116;
    L42:
        if (r116 <= 1920) goto L45;
        r116 = TECameraUtils.CAPTURE_NORMAL;
    L45:
        if (r117 <= 1080) goto L47;
        r117 = 1080;
    L47:
        Size r120 = a(r111.getOutputSizes(SurfaceTexture.class), r118, r119, r116, r117);     // Catch: Exception -> L55
        this.f558964h = r120;     // Catch: Exception -> L55
        Objects.toString(r120);     // Catch: Exception -> L55
        int r121 = n.f532367a;     // Catch: Exception -> L55
        if (this.f558957a.getResources().getConfiguration().orientation != 2) goto L50;
        this.f558959c.a(this.f558964h.getWidth(), this.f558964h.getHeight());     // Catch: Exception -> L55
        return;
    L50:
        this.f558959c.a(this.f558964h.getHeight(), this.f558964h.getWidth());     // Catch: Exception -> L55
        return;
    L28:
        int r122 = this.f558963g;     // Catch: Exception -> L55
        if (r122 != 0) goto L31;
    L37:
        r103 = true;
        goto L38
    L31:
        if (r122 != 180) goto L38;
    L33:
        int r123 = this.f558963g;     // Catch: Exception -> L55
        if (r123 == 90) goto L37;
        if (r123 != 270) goto L38;
    L52:
        throw new IllegalStateException("streamCfgMap is null");     // Catch: Exception -> L55
    L54:
        throw new IllegalStateException("front camera is disAvailable");     // Catch: Exception -> L55
    L55:
        e = move-exception;
        d(40002, e);
    }

    public final void f() {
        if (this.f558959c != null) goto L5;
        return;
    L5:
        e.b().a();
        e.b().c("openCameraInner", "start");
        this.f558965i.enable();
        CameraManager r100 = (CameraManager) this.f558957a.getSystemService("camera");
        e();     // Catch: Exception -> L26
        this.f558966j = ImageReader.newInstance(this.f558964h.getWidth(), this.f558964h.getHeight(), 35, 2);     // Catch: Exception -> L26
        wb4.b r101 = this.f558967k;     // Catch: Exception -> L26
        if (r101 == null) goto L9;
        r101.c();     // Catch: Exception -> L26
    L9:
        PthreadHandlerThreadV2 r102 = this.f558960d;     // Catch: Exception -> L26
        if (r102 == null) goto L17;
        if (r102 != null) goto L29;
    L13:
        this.f558960d = null;     // Catch: Exception -> L15
        this.f558961e = null;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L26
        goto L17
    L29:
        r102.quit();     // Catch: Exception -> L15
        ThreadMethodProxy.join(this.f558960d);     // Catch: Exception -> L15
    L17:
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("BdTuring_Camera_Thread");     // Catch: Exception -> L26
        this.f558960d = r103;     // Catch: Exception -> L26
        ThreadMethodProxy.start(r103);     // Catch: Exception -> L26
        Handler r104 = new Handler(this.f558960d.getLooper());     // Catch: Exception -> L26
        this.f558961e = r104;     // Catch: Exception -> L26
        wb4.b r105 = new wb4.b(this.f558968l, this.f558958b);     // Catch: Exception -> L26
        this.f558967k = r105;     // Catch: Exception -> L26
        this.f558966j.setOnImageAvailableListener(r105, r104);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(this.f558962f) == true) goto L25;
        String r106 = this.f558962f;     // Catch: Exception -> L26
        a r107 = this.f558971o;     // Catch: Exception -> L26
        Handler r108 = this.f558961e;     // Catch: Exception -> L26
        if (fna.g.d() == true) goto L22;
        c(r100, r106, r107, r108);     // Catch: Exception -> L26
    L23:
        e.b().c("openCameraInner", VideoEventOneOutSync.END_TYPE_FINISH);     // Catch: Exception -> L26
        return;
    L22:
        c(r100, r106, r107, r108);     // Catch: Exception -> L26
        jna.a.b(r106);     // Catch: Exception -> L26
        goto L23
    L25:
        throw new IllegalStateException("no available camera");     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        d(40000, e);
    }

    public final void g() {
    L29:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f558970n != null) goto L5;
        return;
    L5:
        CameraCaptureSession r100 = this.f558972p;     // Catch: Exception -> L29
        if (r100 == null) goto L8;
        r100.close();     // Catch: Exception -> L29
        this.f558972p = null;     // Catch: Exception -> L29
    L8:
        CameraDevice r101 = this.f558970n;     // Catch: Exception -> L29
        if (fna.g.d() == true) goto L11;
        b(r101);     // Catch: Exception -> L29
    L14:
        this.f558970n = null;     // Catch: Exception -> L29
        ImageReader r102 = this.f558966j;     // Catch: Exception -> L29
        if (r102 == null) goto L17;
        r102.close();     // Catch: Exception -> L29
        this.f558966j = null;     // Catch: Exception -> L29
    L17:
        h r103 = this.f558965i;     // Catch: Exception -> L29
        if (r103 == null) goto L32;
        r103.disable();     // Catch: Exception -> L29
    L32:
        PthreadHandlerThreadV2 r104 = this.f558960d;     // Catch: Exception -> L25
        if (r104 == null) goto L23;
        r104.quit();     // Catch: Exception -> L25
        ThreadMethodProxy.join(this.f558960d);     // Catch: Exception -> L25
    L23:
        this.f558960d = null;     // Catch: Exception -> L25
        this.f558961e = null;     // Catch: Exception -> L25
    L27:
        e.b().d();     // Catch: Exception -> L29
        return;
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
        goto L27
    L11:
        b(r101);     // Catch: Exception -> L29
        if ((r101 instanceof CameraDevice) == false) goto L14;
        jna.a.a(r101.getId());     // Catch: Exception -> L29
        goto L14
    }

    public static void b(CameraDevice r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, false);
        return;
    L6:
        r110.close();
        r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, true);
    }

    public i(Activity r100, AutoFixTextureView r101) {
        this.f558971o = new a(this);
        this.f558973q = new b(this);
        this.f558957a = r100;
        this.f558959c = r101;
        this.f558958b = new g();
        h r102 = new h(this, r100);
        this.f558965i = r102;
        r102.enable();
    }

    public final void d(int r100, Exception r101) {
        wb4.a r102 = this.f558968l;
        if (r102 == null) goto L10;
        LiveDetectView r103 = (LiveDetectView) r102;
        if (r103.f201971f == null) goto L11;
        Handler r104 = r103.f201968c;
        if (r104 == null) goto L12;
        r104.post(new com.bytedance.bdturing.livedetect.view.b(r103, r100, r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void c(CameraManager r110, String r111, a r112, Handler r113) throws CameraAccessException {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113};
        f06.b r114 = new f06.b();
        if (r100.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, "void", r114).f474982a == false) goto L6;
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, false);
        return;
    L6:
        r110.openCamera(r111, r112, r113);
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, true);
    }

    public static Size a(Size[] r100, int r101, int r102, int r110, int r111) {
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        int r105 = r100.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L18;
        Size r107 = r100[r106];
        r107.getWidth();
        r107.getHeight();
        if (r107.getWidth() > r110) goto L16;
        if (r107.getHeight() > r111) goto L16;
        if (r107.getHeight() != ((r107.getWidth() * r102) / r101)) goto L16;
        if (r107.getWidth() >= r101) goto L13;
    L15:
        r104.add(r107);
        goto L16
    L13:
        if (r107.getHeight() < r102) goto L15;
        r103.add(r107);
    L16:
        r106 = r106 + 1;
        goto L3
    L18:
        if (r103.size() <= 0) goto L21;
        Size r108 = (Size) Collections.min(r103, new c());
    L24:
        Objects.toString(r108);
        int r109 = n.f532367a;
        return r108;
    L21:
        if (r104.size() <= 0) goto L23;
        r108 = (Size) Collections.max(r104, new c());
        goto L24
    L23:
        int r112 = n.f532367a;
        r108 = new Size(r101, r102);
        goto L24
    }
}
