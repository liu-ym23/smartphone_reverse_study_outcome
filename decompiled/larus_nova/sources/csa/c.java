package csa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.RggbChannelVector;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.face.CameraStateDetector;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fna.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final SparseIntArray f465197x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f465198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CameraManager f465199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CameraDevice f465200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Semaphore f465201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f465202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CameraCharacteristics f465203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CameraCaptureSession f465204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CaptureRequest.Builder f465205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageReader f465206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f465207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PthreadHandlerThreadV2 f465208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Surface f465209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Size f465210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Size f465211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f465212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f465213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f465214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public bsa.a.InterfaceC0355a f465215r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public bsa.a.b f465216s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f465217t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CameraFactory$WhiteBalanceType f465218u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f465219v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f465220w;

    public class a extends CameraDevice.StateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f465221a;

        public a(c r100) {
            this.f465221a = r100;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice r100) {
            this.f465221a.f465201d.release();
            rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "close", null)));
            rsa.c.a(new rsa.c.a("on_camera_state_change", CameraStateDetector.CameraState.CLOSED));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice r100) {
            this.f465221a.f465201d.release();
            this.f465221a.k();
            rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "close", null)));
            rsa.c.a(new rsa.c.a("on_camera_state_change", CameraStateDetector.CameraState.DISCONNECTED));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice r210) {
            ArrayList r100 = new ArrayList();
            Integer r101 = 0;
            Object[] r102 = {r210};
            f06.b r110 = new f06.b();
            g06.a r103 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r103 == null) goto L5;
            f06.a[] r104 = r103.f479473i;
        L6:
            f06.a[] r105 = r104;
            int r106 = r105.length;
            int r107 = 0;
        L8:
            if (r107 >= r106) goto L15;
            f06.a r108 = r105[r107];
            JSONObject r111 = null;
            int r211 = r107;
            int r212 = r106;
            f06.a[] r213 = r105;
            Integer r214 = r101;
            Object[] r215 = r102;
            f06.d r109 = r108.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "com/ss/android/bytedcert/camera/legacy/v2/CameraV2Proxy$1", "onOpened", this, r102, "void", r110);     // Catch: Exception -> L54
            if (r109.f474982a == true) goto L12;
            r100.add(r108);     // Catch: Exception -> L54
            goto L14
        L12:
            boolean r112 = false;
        L17:
            if (r109.f474982a == false) goto L19;
            return;
        L19:
            this.f465221a.f465201d.release();
            c r113 = this.f465221a;
            r113.f465200c = r210;
            ArrayList r114 = new ArrayList();
            if (r113.f465209l == null) goto L22;
            CertLog.d("CameraV2Proxy ", "createSession add target mPreviewSurface");
            r114.add(r113.f465209l);
        L22:
            Size r115 = r113.f465211n;
            if (r115 == null) goto L25;
            CertLog.d("CameraV2Proxy ", "createSession add target mPictureImageReader");
            int r116 = 1;
            ImageReader r117 = ImageReader.newInstance(r115.getWidth(), r115.getHeight(), 256, 1);
            r113.f465206i = r117;
            r114.add(r117.getSurface());
        L59:
            CaptureRequest.Builder r118 = r113.f465200c.createCaptureRequest(r116);     // Catch: Exception -> L43
            r113.f465205h = r118;     // Catch: Exception -> L43
            r118.addTarget(r113.f465209l);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.CONTROL_AE_MODE, 2);     // Catch: Exception -> L43
            if (r113.f465217t == false) goto L40;
            CameraFactory$WhiteBalanceType r119 = r113.f465218u;     // Catch: Exception -> L43
            if (r119 == null) goto L40;
            if (r119 == CameraFactory$WhiteBalanceType.AUTO_INCANDESCENT) goto L33;
            Integer r120 = r214;
            RggbChannelVector r121 = c.h(r119);     // Catch: Exception -> L43
            if (r121 == null) goto L39;
            r113.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, r120);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.CONTROL_MODE, 1);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.COLOR_CORRECTION_MODE, r120);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.COLOR_CORRECTION_GAINS, r121);     // Catch: Exception -> L43
        L41:
            r113.f465200c.createCaptureSession(r114, new csa.d(r113), r113.f465207j);     // Catch: Exception -> L43
        L45:
            rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "open_e", r111)));
            rsa.c.a(new rsa.c.a("on_camera_state_change", CameraStateDetector.CameraState.OPENED));
            Integer r122 = (Integer) this.f465221a.f465203f.get(CameraCharacteristics.LENS_FACING);
            if (r122 != null) goto L48;
        L49:
            JSONObject r123 = new JSONObject();
            r123.put("fail_step", "open");     // Catch: Exception -> L53
            r123.put("fail_reason", "camera id(" + r210.getId() + ") not match 1, camera length: " + this.f465221a.f465199b.getCameraIdList().length + ", camera 2 front id:0");     // Catch: Exception -> L53
        L51:
            rsa.c.a(new rsa.c.a("camera_error", r123));
            return;
        L48:
            if (r122.intValue() != 0) goto L49;
            return;
        L39:
            r113.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 1);     // Catch: Exception -> L43
            goto L41
        L33:
            if (r113.n() == false) goto L35;
            r113.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 2);     // Catch: Exception -> L43
            goto L41
        L35:
            CertLog.d("CameraV2Proxy ", "auto_incandescent unsupported on reopen, fallback to BLUE gains");     // Catch: Exception -> L43
            bsa.e.f20353a = r112;     // Catch: Exception -> L43
            RggbChannelVector r124 = c.h(CameraFactory$WhiteBalanceType.BLUE);     // Catch: Exception -> L43
            Integer r125 = r214;
            r113.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, r125);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.CONTROL_MODE, 1);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.COLOR_CORRECTION_MODE, r125);     // Catch: Exception -> L43
            r113.f465205h.set(CaptureRequest.COLOR_CORRECTION_GAINS, r124);     // Catch: Exception -> L43
        L40:
            r113.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 1);     // Catch: Exception -> L43
        L43:
            e = move-exception;
            CertLog.e("CameraV2Proxy ", e.getMessage(), e);
            EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
            goto L45
        L25:
            r116 = 1;
        L14:
            r107 = r211 + 1;
            r106 = r212;
            r105 = r213;
            r101 = r214;
            r102 = r215;
            goto L8
        L15:
            r111 = null;
            r214 = r101;
            r112 = false;
            r109 = new f06.d(false, null);
            goto L17
        L5:
            r104 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice r100, int r101) {
            CertLog.e("CameraV2Proxy ", "Camera Open failed, error: " + r101);
            this.f465221a.f465201d.release();
            this.f465221a.k();
            JSONObject r102 = new JSONObject();
            r102.put("fail_step", "open");     // Catch: Exception -> L6
            r102.put("fail_reason", "error: " + r101);     // Catch: Exception -> L6
        L4:
            rsa.c.a(new rsa.c.a("camera_error", r102));
            rsa.c.a(new rsa.c.a("on_camera_state_change", CameraStateDetector.CameraState.ERROR));
        }
    }

    public class b extends CameraCaptureSession.CaptureCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f465222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f465223b;

        public class a implements ImageReader.OnImageAvailableListener {
            public a() {
            }

            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader r100) {
                CertLog.d("CameraV2Proxy ", "get image data");
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
        }

        public b(c r100) {
            this.f465223b = r100;
            this.f465222a = new a();
        }

        public final void a(CaptureResult r100) {
            int r101 = this.f465223b.f465214q;
            if (r101 != 1) goto L5;
            Integer r102 = (Integer) r100.get(CaptureResult.CONTROL_AF_STATE);
            if (r102 != null) goto L24;
            this.f465223b.b(this.f465222a);
            return;
        L24:
            if (4 != r102.intValue()) goto L26;
        L27:
            Integer r103 = (Integer) r100.get(CaptureResult.CONTROL_AE_STATE);
            if (r103 != null) goto L30;
        L37:
            c r104 = this.f465223b;
            r104.f465214q = 4;
            r104.b(this.f465222a);
            return;
        L30:
            if (r103.intValue() == 2) goto L37;
            c r105 = this.f465223b;
            Handler r106 = r105.f465207j;
            r105.f465205h.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);     // Catch: Exception -> L35
            r105.f465214q = 2;     // Catch: Exception -> L35
            r105.f465204g.capture(r105.f465205h.build(), r105.f465220w, r106);     // Catch: Exception -> L35
            return;
        L35:
            e = move-exception;
            CertLog.e("CameraV2Proxy ", e.getMessage(), e);
            return;
        L26:
            if (5 == r102.intValue()) goto L27;
            return;
        L5:
            if (r101 == 2) goto L13;
            if (r101 != 3) goto L48;
            Integer r107 = (Integer) r100.get(CaptureResult.CONTROL_AE_STATE);
            if (r107 != null) goto L11;
        L12:
            c r108 = this.f465223b;
            r108.f465214q = 4;
            r108.b(this.f465222a);
            return;
        L11:
            if (r107.intValue() != 5) goto L12;
            return;
        L48:
            return;
        L13:
            Integer r109 = (Integer) r100.get(CaptureResult.CONTROL_AE_STATE);
            if (r109 != null) goto L16;
        L19:
            this.f465223b.f465214q = 3;
            return;
        L16:
            if (r109.intValue() == 5) goto L19;
            if (r109.intValue() == 4) goto L19;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
            a(r102);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureProgressed(CameraCaptureSession r100, CaptureRequest r101, CaptureResult r102) {
            a(r102);
        }
    }

    /* JADX INFO: renamed from: csa.c$c, reason: collision with other inner class name */
    public static /* synthetic */ class C5578c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f465224a = null;

        static {
            int[] r100 = new int[CameraFactory$WhiteBalanceType.values().length];
            f465224a = r100;
            r100[CameraFactory$WhiteBalanceType.RED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f465224a[CameraFactory$WhiteBalanceType.GREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f465224a[CameraFactory$WhiteBalanceType.BLUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class d implements Comparator<Size> {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(Size r100, Size r101) {
            Size r102 = r100;
            Size r103 = r101;
            return Long.signum((((long) r102.getWidth()) * ((long) r102.getHeight())) - (((long) r103.getWidth()) * ((long) r103.getHeight())));
        }
    }

    public final synchronized void k() {
        monitor-enter(this);
        CertLog.v("CameraV2Proxy ", "releaseCamera");     // Catch: Throwable -> L36
    L29:
        e = move-exception;
        CertLog.e("CameraV2Proxy ", "Interrupted while releasing camera", e);     // Catch: Throwable -> L27
    L31:
        l();     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L5:
        if (this.f465201d.tryAcquire(2500, TimeUnit.MILLISECONDS) == false) goto L25;
        CameraCaptureSession r100 = this.f465204g;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r100 != null) goto L41;
    L14:
        CameraDevice r101 = this.f465200c;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r101 != null) goto L17;
    L21:
        ImageReader r102 = this.f465206i;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r102 == null) goto L24;
        r102.close();     // Catch: Throwable -> L27 InterruptedException -> L29
        this.f465206i = null;     // Catch: Throwable -> L27 InterruptedException -> L29
    L24:
        this.f465201d.release();     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L31
    L17:
        if (g.d() == true) goto L19;
        f(r101);     // Catch: Throwable -> L27 InterruptedException -> L29
    L20:
        this.f465200c = null;     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L21
    L19:
        f(r101);     // Catch: Throwable -> L27 InterruptedException -> L29
        jna.a.a(r101.getId());     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L20
    L41:
        r100.stopRepeating();     // Catch: Exception -> L11 Throwable -> L27
        this.f465204g.abortCaptures();     // Catch: Exception -> L11 Throwable -> L27
    L13:
        this.f465204g.close();     // Catch: Throwable -> L27 InterruptedException -> L29
        this.f465204g = null;     // Catch: Throwable -> L27 InterruptedException -> L29
    L11:
        e = move-exception;
        CertLog.e("CameraV2Proxy ", "Error stopping capture session", e);     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L13
    L25:
        CertLog.e("CameraV2Proxy ", "Failed to acquire camera lock for release");     // Catch: Throwable -> L27 InterruptedException -> L29
    L27:
        th = move-exception;
        l();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    static {
        SparseIntArray r100 = new SparseIntArray();
        f465197x = r100;
        r100.append(0, 90);
        r100.append(1, 0);
        r100.append(2, 270);
        r100.append(3, 180);
    }

    public final void i() {
        int r100 = ((Activity) this.f465198a).getWindowManager().getDefaultDisplay().getRotation();
        if (r100 != 0) goto L5;
        r100 = 90;
    L15:
        this.f465212o = ((r100 + ((Integer) this.f465203f.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue()) + 270) % 360;
        CertLog.d("CameraV2Proxy ", "mDisplayRotation: " + this.f465212o);
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

    public final void l() {
        CertLog.v("CameraV2Proxy ", "stopBackgroundThread");
        PthreadHandlerThreadV2 r100 = this.f465208k;
        if (r100 == null) goto L20;
        r100.quitSafely();
        ThreadMethodProxy.join(this.f465208k, 5000);     // Catch: Throwable -> L11 Exception -> L13
        PthreadHandlerThreadV2 r101 = this.f465208k;     // Catch: Throwable -> L11 Exception -> L13
        if (r101 != null) goto L8;
    L17:
        this.f465208k = null;
        this.f465207j = null;
        return;
    L8:
        if (ThreadMethodProxy.isAlive(r101) == false) goto L17;
        CertLog.w("CameraV2Proxy ", "Background thread did not terminate within 5 seconds");     // Catch: Throwable -> L11 Exception -> L13
    L13:
        e = move-exception;
        CertLog.e("CameraV2Proxy ", "stopBackgroundThread interrupted", e);     // Catch: Throwable -> L11
        if ((e instanceof InterruptedException) == false) goto L17;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f465208k = null;
        this.f465207j = null;
        throw th;
    }

    public final boolean n() {
        CameraCharacteristics r100 = this.f465203f;
        if (r100 != null) goto L5;
        return false;
    L5:
        int[] r101 = (int[]) r100.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (r101 != null) goto L8;
        return false;
    L8:
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        if (r101[r103] == 2) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    public final void c() {
        if (BytedCertSdkManager.getInstance().isReportDepthCameraInfo() == true) goto L5;
        return;
    L5:
        CameraCharacteristics r100 = this.f465203f;
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
        r102 = Boolean.TRUE.equals(this.f465203f.get(CameraCharacteristics.DEPTH_DEPTH_IS_EXCLUSIVE));
    L20:
        CertLog.d("CameraV2Proxy ", "depth support:{supportDepth=" + r105 + ",supportDepthAndJpeg=" + r102 + i.f25855d);
        bsa.a.InterfaceC0355a r106 = this.f465215r;
        if (r106 == null) goto L26;
        r106.a(r102);
        return;
    L26:
        return;
    L16:
        r105 = false;
        goto L18
    }

    public final void d() {
        Object r100 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_COLLECT_WB_DATA);
        if ((r100 instanceof Boolean) == true) goto L5;
        return;
    L5:
        if (((Boolean) r100).booleanValue() == false) goto L49;
        CameraCharacteristics r101 = this.f465203f;
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
        int[] r107 = (int[]) this.f465203f.get(CameraCharacteristics.COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES);
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
        int[] r111 = (int[]) this.f465203f.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (r111 == null) goto L36;
        int r112 = r111.length;
        int r113 = 0;
    L31:
        if (r113 >= r112) goto L36;
        if (r111[r113] == 0) goto L37;
        r113 = r113 + 1;
    L37:
        CertLog.d("CameraV2Proxy ", "wbSupport: " + r106 + " " + r110 + " " + r103);
        bsa.a.b r114 = this.f465216s;
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

    public final void m() {
        CertLog.v("CameraV2Proxy ", "stopPreview");
        CameraCaptureSession r100 = this.f465204g;
        if (r100 != null) goto L11;
        CertLog.w("CameraV2Proxy ", "stopPreview: mCaptureSession is null");
        return;
    L11:
        r100.stopRepeating();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CertLog.e("CameraV2Proxy ", e.getMessage(), e);
    }

    public c(Context r100) {
        this.f465201d = new Semaphore(1);
        this.f465202e = 1;
        this.f465212o = 0;
        this.f465213p = 0;
        this.f465214q = 0;
        this.f465217t = false;
        this.f465218u = null;
        this.f465219v = new a(this);
        this.f465220w = new b(this);
        this.f465198a = r100;
        this.f465199b = (CameraManager) r100.getSystemService("camera");
        Object r101 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_WB_REOPEN_CAMERA_ON_WB_CHANGE);
        if ((r101 instanceof Boolean) == false) goto L6;
        this.f465217t = ((Boolean) r101).booleanValue();
        return;
    }

    public static void a(c r100) {
        r100.getClass();
        CertLog.v("CameraV2Proxy ", "startPreview");
        if (r100.f465204g == null) goto L11;
        CaptureRequest.Builder r101 = r100.f465205h;
        if (r101 == null) goto L11;
        CaptureRequest r102 = r101.build();     // Catch: Exception -> L9
        r100.f465204g.setRepeatingRequest(r102, r100.f465220w, r100.f465207j);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
        return;
    L11:
        CertLog.w("CameraV2Proxy ", "startPreview: mCaptureSession or mPreviewRequestBuilder is null");
    }

    public static void f(CameraDevice r110) {
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

    public static RggbChannelVector h(CameraFactory$WhiteBalanceType r100) {
        if (r100 != CameraFactory$WhiteBalanceType.NONE) goto L5;
        return null;
    L5:
        Object r101 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_WB_RGB_CHANNEL_MAX_VALUE);
        Object r102 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_WB_RGB_CHANNEL_MIN_VALUE);
        if ((r101 instanceof Number) == false) goto L8;
        float r103 = ((Number) r101).floatValue();
    L10:
        if ((r102 instanceof Number) == false) goto L12;
        float r104 = ((Number) r102).floatValue();
    L13:
        int r105 = C5578c.f465224a[r100.ordinal()];
        boolean r106 = true;
        if (r105 == 1) goto L31;
        if (r105 != 2) goto L18;
        Object r107 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_WB_GREEN_FULL_MODE);
        if ((r107 instanceof Boolean) == true) goto L24;
    L26:
        r106 = false;
    L27:
        if (r106 == false) goto L34;
        return new RggbChannelVector(r104, r103, r103, r104);
    L34:
        return new RggbChannelVector(r104, r103, r104, r104);
    L24:
        if (((Boolean) r107).booleanValue() == false) goto L26;
    L18:
        if (r105 == 3) goto L32;
        return null;
    L32:
        return new RggbChannelVector(r104, r104, r104, r103);
    L31:
        return new RggbChannelVector(r103, r104, r104, r104);
    L12:
        r104 = 0.01f;
        goto L13
    L8:
        r103 = 2.0f;
        goto L10
    }

    public final void b(b.a r100) {
        ImageReader r101 = this.f465206i;
        if (r101 != null) goto L6;
        CertLog.w("CameraV2Proxy ", "captureStillPicture failed! mPictureImageReader is null");
        return;
    L6:
        r101.setOnImageAvailableListener(r100, this.f465207j);
        int r102 = ((Activity) this.f465198a).getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L12
        CaptureRequest.Builder r103 = this.f465200c.createCaptureRequest(2);     // Catch: Exception -> L12
        r103.addTarget(this.f465206i.getSurface());     // Catch: Exception -> L12
        r103.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L12
        r103.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(((f465197x.get(r102) + this.f465213p) + 270) % 360));     // Catch: Exception -> L12
        Rect r104 = (Rect) this.f465205h.get(CaptureRequest.SCALER_CROP_REGION);     // Catch: Exception -> L12
        if (r104 == null) goto L10;
        r103.set(CaptureRequest.SCALER_CROP_REGION, r104);     // Catch: Exception -> L12
    L10:
        m();     // Catch: Exception -> L12
        this.f465204g.abortCaptures();     // Catch: Exception -> L12
        System.currentTimeMillis();     // Catch: Exception -> L12
        this.f465204g.capture(r103.build(), new e(this), this.f465207j);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        CertLog.e("CameraV2Proxy ", e.getMessage(), e);
    }

    public final void j(int r100) {
        this.f465202e = r100;
        CertLog.v("CameraV2Proxy ", "openCamera id is " + this.f465202e);
    L11:
        e = move-exception;
        CertLog.e("CameraV2Proxy ", e.getMessage(), e);
        JSONObject r101 = new JSONObject();
        r101.put("fail_step", "open");     // Catch: Exception -> L17
        r101.put("fail_reason", CertLog.getStackTraceString(e));     // Catch: Exception -> L17
    L14:
        rsa.c.a(new rsa.c.a("camera_error", r101));
    L15:
        rsa.c.a(new rsa.c.a("on_camera_state_change", CameraStateDetector.CameraState.OPENING));
        c();
        d();
        return;
    L4:
        if (this.f465201d.tryAcquire(2500, TimeUnit.MILLISECONDS) == false) goto L10;
        this.f465203f = this.f465199b.getCameraCharacteristics(Integer.toString(this.f465202e));     // Catch: Exception -> L11
        i();     // Catch: Exception -> L11
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "open_s", null)));     // Catch: Exception -> L11
        CameraManager r102 = this.f465199b;     // Catch: Exception -> L11
        String r103 = Integer.toString(this.f465202e);     // Catch: Exception -> L11
        a r104 = this.f465219v;     // Catch: Exception -> L11
        Handler r105 = this.f465207j;     // Catch: Exception -> L11
        if (g.d() == true) goto L8;
        g(r102, r103, r104, r105);     // Catch: Exception -> L11
        goto L15
    L8:
        g(r102, r103, r104, r105);     // Catch: Exception -> L11
        jna.a.b(r103);     // Catch: Exception -> L11
        goto L15
    L10:
        throw new RuntimeException("Time out waiting to lock camera opening.");     // Catch: Exception -> L11
    }

    public static void g(CameraManager r110, String r111, a r112, Handler r113) throws CameraAccessException {
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

    public static Size e(Size[] r110, int r111, int r112, int r113, int r114, Size r115) {
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
        CertLog.d("CameraV2Proxy ", "supportSize: " + Arrays.asList(r110) + " choices[0]: " + r110[0] + " aspectRatio" + r115);
        if (r100.size() <= 0) goto L22;
        return (Size) Collections.min(r100, new d());
    L22:
        if (r101.size() <= 0) goto L26;
        return (Size) Collections.max(r101, new d());
    L26:
        return r110[0];
    }
}
