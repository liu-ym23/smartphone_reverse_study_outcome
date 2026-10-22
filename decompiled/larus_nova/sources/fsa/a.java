package fsa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.RggbChannelVector;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Size;
import android.view.Surface;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.dialog.controller.base.ICameraController;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fna.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public class a extends esa.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CameraManager f478694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CameraDevice f478695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Semaphore f478696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CameraCharacteristics f478697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CameraCaptureSession f478698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Surface f478699o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Size f478700p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Size f478701q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f478702r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CaptureRequest.Builder f478703s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageReader f478704t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Handler f478705u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PthreadHandlerThreadV2 f478706v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public bsa.a.InterfaceC0355a f478707w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public bsa.a.b f478708x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f478709y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C5947a f478710z;

    /* JADX INFO: renamed from: fsa.a$a, reason: collision with other inner class name */
    public class C5947a extends CameraDevice.StateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f478711a;

        public C5947a(a r100) {
            this.f478711a = r100;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice r100) {
            this.f478711a.f478696l.release();
            a.k(this.f478711a);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice r210) {
            ArrayList r110 = new ArrayList();
            Object[] r111 = {r210};
            f06.b r112 = new f06.b();
            g06.a r100 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r100 == null) goto L5;
            f06.a[] r101 = r100.f479473i;
        L6:
            f06.a[] r102 = r101;
            int r103 = r102.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r102[r104];
            int r113 = r104;
            int r114 = r103;
            f06.a[] r211 = r102;
            f06.d r106 = r105.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "com/ss/android/bytedcert/camera/refactor/v2/SystemCameraV2$1", "onOpened", this, r111, "void", r112);     // Catch: Exception -> L35
            if (r106.f474982a == true) goto L17;
            r110.add(r105);     // Catch: Exception -> L35
        L17:
            if (r106.f474982a == false) goto L19;
            return;
        L19:
            this.f478711a.f478696l.release();
            a r107 = this.f478711a;
            r107.f478695k = r210;
            ArrayList r108 = new ArrayList();
            if (r107.f478699o == null) goto L29;
            CertLog.d("CameraDevice", "camera v2 createSession add target mPreviewSurface");
            r108.add(r107.f478699o);
            Size r109 = r107.f478700p;
            if (r109 == null) goto L24;
            CertLog.d("CameraDevice", "camera v2 createSession add target mPictureImageReader");
            int r115 = 1;
            ImageReader r116 = ImageReader.newInstance(r109.getWidth(), r109.getHeight(), 256, 1);
            r107.f478704t = r116;
            r108.add(r116.getSurface());
        L36:
            CaptureRequest.Builder r117 = r107.f478695k.createCaptureRequest(r115);     // Catch: Exception -> L27
            r107.f478703s = r117;     // Catch: Exception -> L27
            r117.addTarget(r107.f478699o);     // Catch: Exception -> L27
            r107.f478703s.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L27
            r107.f478703s.set(CaptureRequest.CONTROL_AE_MODE, 2);     // Catch: Exception -> L27
            r107.f478703s.set(CaptureRequest.CONTROL_AWB_MODE, 1);     // Catch: Exception -> L27
            r107.f478695k.createCaptureSession(r108, new fsa.b(r107), r107.f478705u);     // Catch: Exception -> L27
        L30:
            dsa.a.InterfaceC5706a r118 = this.f478711a.f473799h;
            if (r118 == null) goto L33;
            ((bsa.b.a) r118).a(true);
        L33:
            this.f478711a.f(CameraParam.TYPE_SYSTEM_CAMERA);
            return;
        L27:
            e = move-exception;
            CertLog.e("CameraDevice", e.getMessage(), e);
            EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
            goto L30
        L24:
            r115 = 1;
            goto L36
        L29:
            CertLog.e("CameraDevice", "camera v2 createSession failed: mPreviewSurface is null");
        L14:
            r104 = r113 + 1;
            r103 = r114;
            r102 = r211;
            goto L8
        L15:
            r106 = new f06.d(false, null);
            goto L17
        L5:
            r101 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice r100, int r101) {
            CertLog.e("CameraDevice", "camera v2 open failed, error: " + r101);
            this.f478711a.f478696l.release();
            a.k(this.f478711a);
        }
    }

    public class b extends CameraCaptureSession.CaptureCallback {
        public b() {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICameraController f478712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f478713b;

        @Override // java.lang.Runnable
        public final void run() {
            bsa.b.j(((bsa.b.a) this.f478713b.f473799h).f20349a);     // Catch: Throwable -> L4
            this.f478713b.r();     // Catch: Throwable -> L4
            BytedCertManager.getInstance().postEventMessage(this.f478712a.getCertInfo().f526573g, EventConstant.MSSecEvent.CAMERA_PREVIEW);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(a r100, boolean r101, ICameraController r102) {
            this.f478713b = r100;
            this.f478712a = r102;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f478714a = null;

        static {
            int[] r100 = new int[CameraFactory$WhiteBalanceType.values().length];
            f478714a = r100;
            r100[CameraFactory$WhiteBalanceType.RED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f478714a[CameraFactory$WhiteBalanceType.GREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f478714a[CameraFactory$WhiteBalanceType.BLUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class e implements Comparator<Size> {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Size r100, Size r101) {
            Size r102 = r100;
            Size r103 = r101;
            return Long.signum((((long) r102.getWidth()) * ((long) r102.getHeight())) - (((long) r103.getWidth()) * ((long) r103.getHeight())));
        }
    }

    private synchronized void h() {
        monitor-enter(this);
        CertLog.v("CameraDevice", "camera v2 releaseCamera");     // Catch: Throwable -> L40
    L29:
        e = move-exception;
        CertLog.e("CameraDevice", "camera v2 Interrupted while releasing camera", e);     // Catch: Throwable -> L27
    L35:
        s();     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L5:
        if (this.f478696l.tryAcquire(2500, TimeUnit.MILLISECONDS) == false) goto L32;
        CameraCaptureSession r100 = this.f478698n;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r100 != null) goto L45;
    L14:
        CameraDevice r101 = this.f478695k;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r101 != null) goto L17;
    L21:
        ImageReader r102 = this.f478704t;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r102 == null) goto L24;
        r102.close();     // Catch: Throwable -> L27 InterruptedException -> L29
        this.f478704t = null;     // Catch: Throwable -> L27 InterruptedException -> L29
    L24:
        Surface r103 = this.f478699o;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r103 == null) goto L31;
        r103.release();     // Catch: Throwable -> L27 InterruptedException -> L29
        this.f478699o = null;     // Catch: Throwable -> L27 InterruptedException -> L29
    L31:
        this.f478696l.release();     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L35
    L17:
        if (g.d() == true) goto L19;
        o(r101);     // Catch: Throwable -> L27 InterruptedException -> L29
    L20:
        this.f478695k = null;     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L21
    L19:
        o(r101);     // Catch: Throwable -> L27 InterruptedException -> L29
        jna.a.a(r101.getId());     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L20
    L45:
        r100.stopRepeating();     // Catch: Exception -> L11 Throwable -> L27
        this.f478698n.abortCaptures();     // Catch: Exception -> L11 Throwable -> L27
    L13:
        this.f478698n.close();     // Catch: Throwable -> L27 InterruptedException -> L29
        this.f478698n = null;     // Catch: Throwable -> L27 InterruptedException -> L29
    L11:
        e = move-exception;
        CertLog.e("CameraDevice", "camera v2 Error stopping capture session", e);     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L13
    L32:
        CertLog.e("CameraDevice", "camera v2 Failed to acquire camera lock for release");     // Catch: Throwable -> L27 InterruptedException -> L29
    L40:
        th = move-exception;
        throw th;
    L27:
        th = move-exception;
        s();     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    }

    public final void q() {
        int r100 = ((Activity) this.f473792a).getWindowManager().getDefaultDisplay().getRotation();
        if (r100 != 0) goto L5;
        r100 = 90;
    L15:
        CertLog.d("CameraDevice", "camera v2 mDisplayRotation: " + (((r100 + ((Integer) this.f478697m.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue()) + 270) % 360));
        return;
    L5:
        if (r100 != 1) goto L7;
        r100 = 0;
        goto L15
    L7:
        if (r100 != 2) goto L9;
        r100 = 270;
        goto L15
    L9:
        if (r100 != 3) goto L15;
        r100 = 180;
        goto L15
    }

    public final void r() {
        CertLog.i("CameraDevice", "openCamera: use camera v2");
    L14:
        e = move-exception;
        CertLog.e("CameraDevice", e.getMessage(), e);
        EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
        return;
    L4:
        if (this.f478696l.tryAcquire(2500, TimeUnit.MILLISECONDS) == false) goto L13;
        boolean r100 = this.f473794c;     // Catch: Exception -> L14
        this.f478697m = this.f478694j.getCameraCharacteristics(Integer.toString(r100 ? 1 : 0));     // Catch: Exception -> L14
        l();     // Catch: Exception -> L14
        m();     // Catch: Exception -> L14
        q();     // Catch: Exception -> L14
        if (this.f473800i == true) goto L8;
        this.f473798g = CameraParam.TYPE_SYSTEM_CAMERA;     // Catch: Exception -> L14
    L8:
        this.f473797f = System.currentTimeMillis();     // Catch: Exception -> L14
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "open_s", null)));     // Catch: Exception -> L14
        CameraManager r101 = this.f478694j;     // Catch: Exception -> L14
        String r102 = Integer.toString(r100 ? 1 : 0);     // Catch: Exception -> L14
        C5947a r103 = this.f478710z;     // Catch: Exception -> L14
        Handler r104 = this.f478705u;     // Catch: Exception -> L14
        if (g.d() == true) goto L11;
        p(r101, r102, r103, r104);     // Catch: Exception -> L14
        return;
    L11:
        p(r101, r102, r103, r104);     // Catch: Exception -> L14
        jna.a.b(r102);     // Catch: Exception -> L14
        return;
    L13:
        throw new RuntimeException("Time out waiting to lock camera opening.");     // Catch: Exception -> L14
    }

    public final void s() {
        CertLog.v("CameraDevice", "camera v2 stopBackgroundThread");
        PthreadHandlerThreadV2 r100 = this.f478706v;
        if (r100 == null) goto L20;
        r100.quitSafely();
        ThreadMethodProxy.join(this.f478706v, 5000);     // Catch: Throwable -> L11 Exception -> L13
        PthreadHandlerThreadV2 r101 = this.f478706v;     // Catch: Throwable -> L11 Exception -> L13
        if (r101 != null) goto L8;
    L17:
        this.f478706v = null;
        this.f478705u = null;
        return;
    L8:
        if (ThreadMethodProxy.isAlive(r101) == false) goto L17;
        CertLog.w("CameraDevice", "camera v2 background thread did not terminate within 5 seconds");     // Catch: Throwable -> L11 Exception -> L13
    L11:
        th = move-exception;
        this.f478706v = null;
        this.f478705u = null;
        throw th;
    L13:
        e = move-exception;
        CertLog.e("CameraDevice", "camera v2 stopBackgroundThread interrupted", e);     // Catch: Throwable -> L11
        if ((e instanceof InterruptedException) == false) goto L17;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L11
        goto L17
    }

    public static boolean t() {
        Object r100 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.FORCE_CAMERA_V1);
        if ((r100 instanceof Boolean) == true) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) r100).booleanValue() == false) goto L8;
        return false;
    }

    @Override // dsa.a
    public void close() {
        if (t() == false) goto L5;
        h();
        return;
    L5:
        h();
    }

    @Override // esa.a, dsa.a
    public boolean e() {
        if (t() == false) goto L7;
        return this.f473794c;
    L7:
        return super.e();
    }

    @Override // esa.a, dsa.a
    public int getOrientation() {
        if (t() == false) goto L7;
        return this.f478702r;
    L7:
        return super.getOrientation();
    }

    @Override // esa.a
    public final void j() {
        if (t() == false) goto L12;
        CertLog.v("CameraDevice", "camera v2 stopPreview");
        CameraCaptureSession r100 = this.f478698n;
        if (r100 != null) goto L14;
        CertLog.w("CameraDevice", "camera v2 stopPreview: mCaptureSession is null");
        return;
    L14:
        r100.stopRepeating();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        CertLog.e("CameraDevice", e.getMessage(), e);
        return;
    L12:
        super.j();
    }

    public final void l() {
        if (BytedCertSdkManager.getInstance().isReportDepthCameraInfo() == true) goto L5;
        return;
    L5:
        CameraCharacteristics r100 = this.f478697m;
        if (r100 != null) goto L8;
        return;
    L8:
        int[] r101 = (int[]) r100.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean r102 = false;
        if (r101 == null) goto L16;
        int r103 = r101.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L16;
        if (r101[r104] == 8) goto L14;
        r104 = r104 + 1;
        goto L11
    L14:
        boolean r105 = true;
    L18:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        r102 = Boolean.TRUE.equals(this.f478697m.get(CameraCharacteristics.DEPTH_DEPTH_IS_EXCLUSIVE));
    L20:
        CertLog.d("CameraDevice", "camera v2 depth support:{supportDepth=" + r105 + ",supportDepthAndJpeg=" + r102 + i.f25855d);
        bsa.a.InterfaceC0355a r106 = this.f478707w;
        if (r106 == null) goto L26;
        r106.a(r102);
        return;
    L26:
        return;
    L16:
        r105 = false;
        goto L18
    }

    public final void m() {
        Object r100 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_COLLECT_WB_DATA);
        if ((r100 instanceof Boolean) == true) goto L5;
        return;
    L5:
        if (((Boolean) r100).booleanValue() == false) goto L49;
        CameraCharacteristics r101 = this.f478697m;
        if (r101 != null) goto L10;
        return;
    L10:
        int[] r102 = (int[]) r101.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean r103 = true;
        if (r102 == null) goto L18;
        int r104 = r102.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L18;
        if (r102[r105] == 2) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        boolean r106 = true;
    L19:
        int[] r107 = (int[]) this.f478697m.get(CameraCharacteristics.COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES);
        if (r107 == null) goto L27;
        int r108 = r107.length;
        int r109 = 0;
    L22:
        if (r109 >= r108) goto L27;
        if (r107[r109] == 0) goto L25;
        r109 = r109 + 1;
        goto L22
    L25:
        boolean r110 = true;
    L28:
        int[] r111 = (int[]) this.f478697m.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (r111 == null) goto L36;
        int r112 = r111.length;
        int r113 = 0;
    L31:
        if (r113 >= r112) goto L36;
        if (r111[r113] == 0) goto L37;
        r113 = r113 + 1;
    L37:
        CertLog.d("CameraDevice", "camera v2 wbSupport: " + r106 + " " + r110 + " " + r103);
        bsa.a.b r114 = this.f478708x;
        if (r114 == null) goto L48;
        r114.a(r106, r110, r103);
        return;
    L48:
        return;
    L36:
        r103 = false;
    L27:
        r110 = false;
    L18:
        r106 = false;
        goto L19
    }

    public static /* synthetic */ void k(a r100) {
        r100.h();
    }

    public static void o(CameraDevice r110) {
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

    public a(Context r100, boolean r101) {
        super(r100, r101);
        this.f478696l = new Semaphore(1);
        this.f478702r = 0;
        if (t() == false) goto L5;
        this.f478694j = (CameraManager) r100.getSystemService("camera");
        this.f478710z = new C5947a(this);
        this.f478709y = new b();
        return;
    L5:
        this.f478694j = null;
        this.f478710z = null;
        this.f478709y = null;
    }

    @Override // esa.a, dsa.a
    public void b(String r100, Object r110) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (t() == true) goto L8;
        super.b(r100, r110);
        return;
    L8:
        switch(r100.hashCode()) {
            case -652857284: goto L23;
            case 470714107: goto L19;
            case 1410811807: goto L15;
            case 1432307344: goto L11;
            default: goto L26;
        };
    L26:
        byte r101 = -1;
    L27:
        if (r101 == 0) goto L76;
        if (r101 == 1) goto L38;
        if (r101 == 2) goto L35;
        if (r101 != 3) goto L91;
        this.f473794c = !this.f473794c;
        CertLog.d("CameraDevice", "camera v2 switchCamera: facing: " + this.f473794c);
        h();
        r();
        return;
    L91:
        return;
    L35:
        if ((r110 instanceof bsa.a.InterfaceC0355a) == false) goto L86;
        this.f478707w = (bsa.a.InterfaceC0355a) r110;
        return;
    L86:
        return;
    L38:
        if ((r110 instanceof CameraFactory$WhiteBalanceType) == false) goto L88;
        CameraFactory$WhiteBalanceType r111 = (CameraFactory$WhiteBalanceType) r110;
        Object r102 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_WB_RGB_CHANNEL_MAX_VALUE);     // Catch: Exception -> L80
        Object r103 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_WB_RGB_CHANNEL_MIN_VALUE);     // Catch: Exception -> L80
        if ((r102 instanceof Number) == false) goto L43;
        float r104 = ((Number) r102).floatValue();     // Catch: Exception -> L80
    L45:
        if ((r103 instanceof Number) == false) goto L47;
        float r105 = ((Number) r103).floatValue();     // Catch: Exception -> L80
    L48:
        int r106 = d.f478714a[r111.ordinal()];     // Catch: Exception -> L80
        if (r106 == 1) goto L55;
        if (r106 == 2) goto L54;
        if (r106 == 3) goto L53;
        RggbChannelVector r107 = null;
    L57:
        if (r111 != CameraFactory$WhiteBalanceType.AUTO_INCANDESCENT) goto L70;
        int[] r112 = (int[]) this.f478697m.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);     // Catch: Exception -> L80
        if (r112 == null) goto L66;
        int r108 = r112.length;     // Catch: Exception -> L80
        int r109 = 0;
    L61:
        if (r109 >= r108) goto L66;
        if (r112[r109] == 2) goto L64;
        r109 = r109 + 1;     // Catch: Exception -> L80
        goto L61
    L64:
        boolean r113 = true;
    L67:
        if (r113 == false) goto L69;
        this.f478703s.set(CaptureRequest.CONTROL_AWB_MODE, 2);     // Catch: Exception -> L80
    L73:
        this.f478698n.setRepeatingRequest(this.f478703s.build(), this.f478709y, this.f478705u);     // Catch: Exception -> L80
        return;
    L69:
        CertLog.d("CameraDevice", "camera v2 auto_incandescent unsupported, fallback to BLUE gains");     // Catch: Exception -> L80
        bsa.e.f20353a = false;     // Catch: Exception -> L80
        RggbChannelVector r114 = new RggbChannelVector(r105, r105, r105, r104);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.CONTROL_AWB_MODE, 0);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.CONTROL_MODE, 1);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.COLOR_CORRECTION_MODE, 0);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.COLOR_CORRECTION_GAINS, r114);     // Catch: Exception -> L80
    L66:
        r113 = false;
        goto L67
    L70:
        if (r107 != null) goto L72;
        CaptureRequest.Builder r115 = this.f478695k.createCaptureRequest(1);     // Catch: Exception -> L80
        this.f478703s = r115;     // Catch: Exception -> L80
        r115.addTarget(this.f478699o);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.CONTROL_AE_MODE, 2);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.CONTROL_AWB_MODE, 1);     // Catch: Exception -> L80
        goto L73
    L72:
        this.f478703s.set(CaptureRequest.CONTROL_AWB_MODE, 0);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.CONTROL_MODE, 1);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.COLOR_CORRECTION_MODE, 0);     // Catch: Exception -> L80
        this.f478703s.set(CaptureRequest.COLOR_CORRECTION_GAINS, r107);     // Catch: Exception -> L80
        goto L73
    L53:
        r107 = new RggbChannelVector(r105, r105, r105, r104);     // Catch: Exception -> L80
        goto L57
    L54:
        r107 = new RggbChannelVector(r105, r104, r105, r105);     // Catch: Exception -> L80
        goto L57
    L55:
        r107 = new RggbChannelVector(r104, r105, r105, r105);     // Catch: Exception -> L80
        goto L57
    L47:
        r105 = 0.01f;
        goto L48
    L43:
        r104 = 2.0f;
    L93:
        return;
    L88:
        return;
    L76:
        if ((r110 instanceof bsa.a.b) == false) goto L89;
        this.f478708x = (bsa.a.b) r110;
        return;
    L89:
        return;
    L11:
        if (r100.equals("switch_camera") == false) goto L26;
        r101 = 3;
        goto L27
    L15:
        if (r100.equals("depth_detect") == false) goto L26;
        r101 = 2;
        goto L27
    L19:
        if (r100.equals("switch_white_balance") == false) goto L26;
        r101 = 1;
        goto L27
    L23:
        if (r100.equals("white_balance_detect") == false) goto L26;
        r101 = 0;
        goto L27
    }

    @Override // esa.a, dsa.a
    public void a(Context r100, boolean r101, dsa.a.InterfaceC5706a r102) {
        if (t() == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        this.f473794c = r101;
        j();
        this.f473799h = r102;
        ICameraController r103 = ((bsa.b.a) r102).f20349a.f20330h;
        if (r103 == null) goto L9;
        r103.setTimestamp("face_camera_setup", EventConstant.Key.FACE_DETECT_TIMESTAMP);
    L9:
        if (r103 != null) goto L11;
    L13:
        ((bsa.b.a) this.f473799h).b();
        return;
    L11:
        if (r103.getCameraStartType() != 1) goto L13;
        GLSurfaceView r104 = ((bsa.b.a) this.f473799h).f20349a.f20329g;
        r104.queueEvent(new c(this, r101, r103));
        r104.forceLayout();
        r104.requestRender();
    }

    @Override // esa.a, dsa.a
    public void c(SurfaceTexture r110, int r210, int r211) {
        if (t() == true) goto L7;
        super.c(r110, r210, r211);
        return;
    L7:
        if (r110 != null) goto L11;
        CertLog.e("CameraDevice", "camera v2 setPreviewSurface failed: surfaceTexture is null");
        return;
    L11:
        if (this.f478706v != null) goto L13;
    L14:
        CertLog.v("CameraDevice", "camera v2 startBackgroundThread");
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("CameraBackground");
        this.f478706v = r100;
        ThreadMethodProxy.start(r100);
        this.f478705u = new Handler(this.f478706v.getLooper());
    L78:
        this.f478697m = this.f478694j.getCameraCharacteristics(Integer.toString(this.f473794c ? 1 : 0));     // Catch: Throwable -> L54
        l();     // Catch: Throwable -> L54
        m();     // Catch: Throwable -> L54
        StreamConfigurationMap r101 = (StreamConfigurationMap) this.f478697m.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Throwable -> L54
        Size[] r102 = r101.getOutputSizes(256);     // Catch: Throwable -> L54
        Size[] r111 = r101.getOutputSizes(SurfaceTexture.class);     // Catch: Throwable -> L54
        Size r103 = (Size) Collections.max(Arrays.asList(r102), new e());     // Catch: Throwable -> L54
        int r104 = ((Activity) this.f473792a).getWindowManager().getDefaultDisplay().getRotation();     // Catch: Throwable -> L54
        int r112 = ((Integer) this.f478697m.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();     // Catch: Throwable -> L54
        this.f478702r = r112;     // Catch: Throwable -> L54
        boolean r113 = true;
        if (r104 == 0) goto L28;
        if (r104 != 1) goto L19;
    L23:
        if (r112 != 0) goto L25;
    L33:
        Point r105 = new Point();     // Catch: Throwable -> L54
        ((Activity) this.f473792a).getWindowManager().getDefaultDisplay().getSize(r105);     // Catch: Throwable -> L54
        int r106 = r105.x;     // Catch: Throwable -> L54
        int r107 = r105.y;     // Catch: Throwable -> L54
        if (r113 == false) goto L36;
        int r114 = r210;
        int r115 = r211;
        r106 = r107;
        r107 = r106;
    L37:
        if (r106 <= 0) goto L39;
        int r116 = 0;
    L40:
        if (r107 <= 0) goto L42;
        int r117 = 0;
    L44:
        if (Arrays.asList(r111).contains(new Size(r210, r211)) == true) goto L46;
        this.f478701q = n(r111, r115, r114, r116, r117, r103);     // Catch: Throwable -> L54
    L47:
        this.f478700p = r103;     // Catch: Throwable -> L54
        CertLog.d("CameraDevice", "camera v2 pictureSize: " + this.f478700p + " previewSize: " + this.f478701q + " sensorOrientation" + this.f478702r);     // Catch: Throwable -> L54
        if (this.f478701q != null) goto L52;
        CertLog.e("CameraDevice", "camera v2 pictureSize is null");
        this.f478701q = new Size(r210, r211);
    L52:
        if (this.f478700p != null) goto L63;
        CertLog.e("CameraDevice", "camera v2 pictureSize is null");
        Size r108 = new Size(r210, r211);
    L62:
        this.f478700p = r108;
    L63:
        r110.setDefaultBufferSize(this.f478701q.getWidth(), this.f478701q.getHeight());
        Surface r109 = this.f478699o;
        if (r109 == null) goto L66;
        r109.release();
        this.f478699o = null;
    L66:
        this.f478699o = new Surface(r110);
        return;
    L46:
        this.f478701q = new Size(r210, r211);     // Catch: Throwable -> L54
        goto L47
    L42:
        r117 = r107;
        goto L44
    L39:
        r116 = r106;
        goto L40
    L36:
        r115 = r210;
        r114 = r211;
        goto L37
    L25:
        if (r112 == 180) goto L33;
    L32:
        r113 = false;
        goto L33
    L19:
        if (r104 == 2) goto L28;
        if (r104 == 3) goto L23;
        CertLog.w("CameraDevice", "camera v2 Display rotation is invalid: " + r104);     // Catch: Throwable -> L54
    L28:
        if (r112 == 90) goto L33;
        if (r112 != 270) goto L32;
    L54:
        th = move-exception;
        CertLog.e("CameraDevice", th.getMessage(), th);     // Catch: Throwable -> L68
        EventLogUtils.onExceptionEvent(th, ErrorConstant.checkClientException(th));     // Catch: Throwable -> L68
        if (this.f478701q != null) goto L60;
        CertLog.e("CameraDevice", "camera v2 pictureSize is null");
        this.f478701q = new Size(r210, r211);
    L60:
        if (this.f478700p != null) goto L63;
        CertLog.e("CameraDevice", "camera v2 pictureSize is null");
        r108 = new Size(r210, r211);
    L68:
        th = move-exception;
        if (this.f478701q != null) goto L73;
        CertLog.e("CameraDevice", "camera v2 pictureSize is null");
        this.f478701q = new Size(r210, r211);
    L73:
        if (this.f478700p != null) goto L75;
        CertLog.e("CameraDevice", "camera v2 pictureSize is null");
        this.f478700p = new Size(r210, r211);
    L75:
        throw th;
    L13:
        if (this.f478705u != null) goto L78;
        goto L14
    }

    public static void p(CameraManager r110, String r111, C5947a r112, Handler r113) throws CameraAccessException {
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

    public static Size n(Size[] r110, int r111, int r112, int r113, int r114, Size r115) {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        int r102 = r115.getWidth();
        int r103 = r115.getHeight();
        int r104 = r110.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L17;
        Size r106 = r110[r105];
        if (r106.getWidth() > r113) goto L16;
        if (r106.getHeight() > r114) goto L16;
        if (r106.getHeight() != ((r106.getWidth() * r103) / r102)) goto L16;
        if (r106.getWidth() >= r111) goto L13;
    L15:
        r101.add(r106);
        goto L16
    L13:
        if (r106.getHeight() < r112) goto L15;
        r100.add(r106);
    L16:
        r105 = r105 + 1;
        goto L3
    L17:
        CertLog.d("CameraDevice", "camera v2 supportSize: " + Arrays.asList(r110) + " choices[0]: " + r110[0] + " aspectRatio" + r115);
        if (r100.isEmpty() == true) goto L22;
        return (Size) Collections.min(r100, new e());
    L22:
        if (r101.isEmpty() == true) goto L26;
        return (Size) Collections.max(r101, new e());
    L26:
        return r110[0];
    }
}
