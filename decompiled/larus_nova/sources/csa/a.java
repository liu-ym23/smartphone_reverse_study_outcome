package csa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.RggbChannelVector;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Size;
import android.view.Surface;
import bsa.g;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.camera.common.gl.GlUtil;
import com.ss.android.bytedcert.camera.common.gl.STGLRenderer;
import com.ss.android.bytedcert.dialog.controller.base.ICameraController;
import com.ss.android.bytedcert.face.CameraStateDetector;
import com.ss.android.bytedcert.face.f;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.utils.Accelerometer;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends bsa.a {
    public List<Size> A;
    public Size B;
    public int C;
    public boolean D;
    public final boolean E;
    public final g F;
    public final C5577a G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final csa.c f465191y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f465192z;

    /* JADX INFO: renamed from: csa.a$a, reason: collision with other inner class name */
    public class C5577a implements SurfaceTexture.OnFrameAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f465193a;

        public C5577a(a r100) {
            this.f465193a = r100;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public final void onFrameAvailable(SurfaceTexture r100) {
            a r101 = this.f465193a;
            if (r101.f20339q == true) goto L6;
            r101.f20329g.requestRender();
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f465194a;

        @Override // java.lang.Runnable
        public final void run() {
            a.j(this.f465194a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f465194a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f465195a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f465195a;     // Catch: Throwable -> L12
            r100.f20337o = null;     // Catch: Throwable -> L12
            int r101 = r100.f20323a;     // Catch: Throwable -> L12
            if (r101 == (-1)) goto L5;
            GLES20.glDeleteTextures(1, new int[]{r101}, 0);     // Catch: Throwable -> L12
        L5:
            r100.f20323a = -1;     // Catch: Throwable -> L12
            int[] r102 = r100.f20338p;     // Catch: Throwable -> L12
            if (r102 == null) goto L8;
            GLES20.glDeleteTextures(1, r102, 0);     // Catch: Throwable -> L12
            r100.f20338p = null;     // Catch: Throwable -> L12
        L8:
            STGLRenderer r103 = this.f465195a.f20336n;     // Catch: Throwable -> L12
            if (r103 == null) goto L15;
            r103.e();     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public c(a r100) {
            this.f465195a = r100;
        }
    }

    @Override // bsa.a
    public final void a() {
        this.D = false;
        this.f20329g.queueEvent(new c(this));
        this.f20329g.onPause();
        this.f20341s = true;
        this.f465191y.k();
    }

    @Override // bsa.a
    public final void i() {
        this.f20341s = false;
        this.f465191y.m();
        if (this.f465191y.f465200c != null) goto L36;
        ICameraController r100 = this.f20330h;
        if (r100 == null) goto L7;
        r100.setTimestamp("face_camera_setup", EventConstant.Key.FACE_DETECT_TIMESTAMP);
    L7:
        csa.c r101 = this.f465191y;
        r101.getClass();
        String[] r102 = r101.f465199b.getCameraIdList();     // Catch: Exception -> L12
        if (r102 == null) goto L14;
        int r103 = r102.length;     // Catch: Exception -> L12
    L15:
        if (r103 != 1) goto L17;
        this.f465192z = 1;
    L17:
        ArrayList r104 = new ArrayList();
        this.A = r104;
        CameraCharacteristics r105 = this.f465191y.f465203f;
        if (r105 == null) goto L20;
        Size[] r106 = ((StreamConfigurationMap) r105.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class);
    L21:
        r104.addAll(Arrays.asList(r106));
        Size r107 = new Size(1280, 720);
        ICameraController r108 = this.f20330h;
        if (r108 == null) goto L31;
        if (r108.getLiveInfo() == null) goto L31;
        if ("video".equals(this.f20330h.getLiveInfo().f407582g) == false) goto L31;
        if (this.A.contains(r107) == false) goto L31;
        this.B = r107;
    L31:
        if (this.f20332j == false) goto L36;
        Size r109 = this.f465191y.f465210m;
        if (r109 == null) goto L35;
        this.A.add(r109);
        this.B = r109;
        CertLog.e("CameraDisplayV2 ", "previewSize full " + r109);
        goto L36
    L35:
        this.B = r107;
        goto L36
    L20:
        r106 = new Size[0];
    L14:
        r103 = 0;
    L12:
        e = move-exception;
        e.printStackTrace();
    L36:
        ICameraController r110 = this.f20330h;
        if (r110 != null) goto L39;
    L41:
        int r111 = this.f20340r;
        csa.c r112 = this.f465191y;
        if (r112.f465200c != null) goto L44;
    L51:
        CertLog.d("CameraDisplayV2 ", "camera device " + this.f465191y.f465200c);
    L52:
        this.C = 0;
        return;
    L44:
        if (this.f20339q == true) goto L51;
        if (this.f20341s == true) goto L51;
        if (this.f20336n == null) goto L51;
        this.f20340r = r111;
        this.f20339q = true;
        r112.m();
        this.f20329g.queueEvent(new csa.b(this));
        goto L52
    L39:
        if (r110.getCameraStartType() != 1) goto L41;
        this.f20329g.queueEvent(new b(this));
        this.f20329g.forceLayout();
        this.f20329g.requestRender();
        goto L52
    }

    public static void j(a r210) {
        if (r210.f20323a != (-1)) goto L6;
        r210.f20323a = com.ss.android.bytedcert.camera.common.gl.d.a();
        SurfaceTexture r100 = new SurfaceTexture(r210.f20323a);
        r210.f20335m = r100;
        r100.setOnFrameAvailableListener(r210.G);
    L6:
        if (r210.B != null) goto L8;
        r210.B = new Size(640, 480);
    L8:
        csa.c r101 = r210.f465191y;
        r101.f465202e = r210.f465192z;
        int r102 = r210.B.getWidth();
        int r103 = r210.B.getHeight();
        if (r101.f465208k != null) goto L11;
    L12:
        CertLog.v("CameraV2Proxy ", "startBackgroundThread");
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2("CameraBackground");
        r101.f465208k = r104;
        ThreadMethodProxy.start(r104);
        r101.f465207j = new Handler(r101.f465208k.getLooper());
    L13:
        boolean r105 = true;
        r101.f465203f = r101.f465199b.getCameraCharacteristics(Integer.toString(r101.f465202e));     // Catch: Throwable -> L46
        r101.c();     // Catch: Throwable -> L46
        r101.d();     // Catch: Throwable -> L46
        StreamConfigurationMap r110 = (StreamConfigurationMap) r101.f465203f.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Throwable -> L46
        Size[] r111 = r110.getOutputSizes(256);     // Catch: Throwable -> L46
        Size[] r112 = r110.getOutputSizes(SurfaceTexture.class);     // Catch: Throwable -> L46
        Size r113 = (Size) Collections.max(Arrays.asList(r111), new csa.c.d());     // Catch: Throwable -> L46
        int r114 = ((Activity) r101.f465198a).getWindowManager().getDefaultDisplay().getRotation();     // Catch: Throwable -> L46
        int r115 = ((Integer) r101.f465203f.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();     // Catch: Throwable -> L46
        r101.f465213p = r115;     // Catch: Throwable -> L46
        if (r114 == 0) goto L27;
        if (r114 != 1) goto L18;
    L22:
        if (r115 != 0) goto L24;
    L32:
        boolean r106 = true;
    L33:
        Point r116 = new Point();     // Catch: Throwable -> L46
        ((Activity) r101.f465198a).getWindowManager().getDefaultDisplay().getSize(r116);     // Catch: Throwable -> L46
        int r117 = r116.x;     // Catch: Throwable -> L46
        int r118 = r116.y;     // Catch: Throwable -> L46
        if (r106 == false) goto L36;
        int r119 = r102;
        int r120 = r103;
        r117 = r118;
        r118 = r117;
    L37:
        if (r117 <= 0) goto L39;
        int r121 = 0;
    L40:
        if (r118 <= 0) goto L42;
        int r122 = 0;
    L44:
        if (Arrays.asList(r112).contains(new Size(r102, r103)) == true) goto L48;
        r101.f465210m = csa.c.e(r112, r120, r119, r121, r122, r113);     // Catch: Throwable -> L46
    L49:
        r101.f465211n = r113;     // Catch: Throwable -> L46
        CertLog.d("CameraV2Proxy ", "pictureSize: " + r101.f465211n + " previewSize: " + r101.f465210m + " sensorOrientation" + r101.f465213p);     // Catch: Throwable -> L46
        if (r101.f465210m != null) goto L54;
        CertLog.e("CameraV2Proxy ", "pictureSize is null");
        r101.f465210m = new Size(r102, r103);
    L54:
        if (r101.f465211n != null) goto L64;
        CertLog.e("CameraV2Proxy ", "mPictureSize is null");
        Size r107 = new Size(r102, r103);
    L63:
        r101.f465211n = r107;
    L64:
        r210.f20324b = Math.min(r210.B.getWidth(), r210.B.getHeight());
        r210.f20325c = Math.max(r210.B.getWidth(), r210.B.getHeight());
        csa.c r108 = r210.f465191y;
        SurfaceTexture r109 = r210.f20335m;
        r109.setDefaultBufferSize(r108.f465210m.getWidth(), r108.f465210m.getHeight());
        r108.f465209l = new Surface(r109);
        csa.c r123 = r210.f465191y;
        if (r123.f465202e == 1) goto L68;
        r105 = false;
    L68:
        r210.f20336n.a(r123.f465213p, r105);
        r210.k("setUpCamera");
        csa.c r124 = r210.f465191y;
        r124.j(r124.f465202e);
        CertLog.d("CameraDisplayV2 ", " height " + r210.f20325c + " width " + r210.f20324b + " isFlip " + r105);
        BytedCertManager.getInstance().postEventMessage(r210.f20330h.getCertInfo().f526573g, EventConstant.MSSecEvent.CAMERA_PREVIEW);
        return;
    L48:
        r101.f465210m = new Size(r102, r103);     // Catch: Throwable -> L46
        goto L49
    L42:
        r122 = r118;
        goto L44
    L39:
        r121 = r117;
        goto L40
    L36:
        r120 = r102;
        r119 = r103;
        goto L37
    L24:
        if (r115 == 180) goto L32;
    L31:
        r106 = false;
        goto L33
    L18:
        if (r114 == 2) goto L27;
        if (r114 == 3) goto L22;
        CertLog.e("CameraV2Proxy ", "Display rotation is invalid: " + r114);     // Catch: Throwable -> L46
    L27:
        if (r115 == 90) goto L32;
        if (r115 != 270) goto L31;
    L46:
        th = move-exception;
        CertLog.e("CameraV2Proxy ", th.getMessage(), th);     // Catch: Throwable -> L70
        EventLogUtils.onExceptionEvent(th, ErrorConstant.checkClientException(th));     // Catch: Throwable -> L70
        if (r101.f465210m != null) goto L61;
        CertLog.e("CameraV2Proxy ", "pictureSize is null");
        r101.f465210m = new Size(r102, r103);
    L61:
        if (r101.f465211n != null) goto L64;
        CertLog.e("CameraV2Proxy ", "mPictureSize is null");
        r107 = new Size(r102, r103);
    L70:
        th = move-exception;
        if (r101.f465210m != null) goto L75;
        CertLog.e("CameraV2Proxy ", "pictureSize is null");
        r101.f465210m = new Size(r102, r103);
    L75:
        if (r101.f465211n != null) goto L77;
        CertLog.e("CameraV2Proxy ", "mPictureSize is null");
        r101.f465211n = new Size(r102, r103);
    L77:
        throw th;
    L11:
        if (r101.f465207j != null) goto L13;
        goto L12
    }

    @Override // bsa.a
    public final void c(com.ss.android.bytedcert.face.e r100) {
        this.f465191y.f465215r = r100;
    }

    @Override // bsa.a
    public final void e(f r100) {
        this.f465191y.f465216s = r100;
    }

    @Override // bsa.a
    public final void g(CameraFactory$WhiteBalanceType r100) {
        csa.c r101 = this.f465191y;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f465217t == false) goto L34;
        r101.f465218u = r100;     // Catch: Exception -> L9
        r101.k();     // Catch: Exception -> L9
        r101.j(r101.f465202e);     // Catch: Exception -> L9
    L23:
        String r102 = null;
    L27:
        if (TextUtils.isEmpty(r102) == true) goto L36;
        lsa.a r103 = this.f20342t;
        if (r103 == null) goto L37;
        r103.h(r102);
        return;
    L37:
        return;
    L36:
        return;
    L9:
        e = move-exception;
        r102 = CertLog.getStackTraceString(e);
        goto L27
    L34:
    L24:
        e = move-exception;
        r102 = CertLog.getStackTraceString(e);
        goto L27
    L12:
        if (r100 == CameraFactory$WhiteBalanceType.AUTO_INCANDESCENT) goto L15;
        RggbChannelVector r104 = csa.c.h(r100);     // Catch: Exception -> L24
        if (r104 != null) goto L21;
        CaptureRequest.Builder r105 = r101.f465200c.createCaptureRequest(1);     // Catch: Exception -> L24
        r101.f465205h = r105;     // Catch: Exception -> L24
        r105.addTarget(r101.f465209l);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_AE_MODE, 2);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 1);     // Catch: Exception -> L24
    L22:
        CaptureRequest r106 = r101.f465205h.build();     // Catch: Exception -> L24
        r101.f465204g.setRepeatingRequest(r106, r101.f465220w, r101.f465207j);     // Catch: Exception -> L24
        goto L23
    L21:
        r101.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 0);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_MODE, 1);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.COLOR_CORRECTION_MODE, 0);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.COLOR_CORRECTION_GAINS, r104);     // Catch: Exception -> L24
        goto L22
    L15:
        if (r101.n() == false) goto L17;
        CertLog.i("CameraV2Proxy ", "auto_incandescent supported，use it");     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 2);     // Catch: Exception -> L24
        goto L22
    L17:
        CertLog.i("CameraV2Proxy ", "auto_incandescent unsupported, fallback to BLUE gains");     // Catch: Exception -> L24
        bsa.e.f20353a = false;     // Catch: Exception -> L24
        RggbChannelVector r107 = csa.c.h(CameraFactory$WhiteBalanceType.BLUE);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_AWB_MODE, 0);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.CONTROL_MODE, 1);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.COLOR_CORRECTION_MODE, 0);     // Catch: Exception -> L24
        r101.f465205h.set(CaptureRequest.COLOR_CORRECTION_GAINS, r107);     // Catch: Exception -> L24
        goto L22
    }

    public final void k(String r100) {
        STGLRenderer r101 = this.f20336n;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.D == true) goto L10;
        CertLog.d("CameraDisplayV2 ", "skip init renderer, surface not ready, source=".concat(r100));
        return;
    L10:
        if (this.f20326d > 0) goto L12;
    L24:
        CertLog.d("CameraDisplayV2 ", "skip init renderer, invalid size, source=" + r100 + ", surface=" + this.f20326d + "x" + this.f20327e + ", image=" + this.f20324b + "x" + this.f20325c);
        return;
    L12:
        if (this.f20327e <= 0) goto L24;
        int r102 = this.f20324b;
        if (r102 <= 0) goto L24;
        int r103 = this.f20325c;
        if (r103 <= 0) goto L24;
        if (this.f20334l <= 0) goto L21;
        boolean r104 = true;
    L22:
        r101.f(r104, r102, r103);
        this.f20336n.d(this.f20326d, this.f20327e, this.f20324b, this.f20325c);
        System.currentTimeMillis();
        CertLog.i("CameraDisplayV2 ", "init renderer, source=".concat(r100));
        return;
    L21:
        r104 = false;
        goto L22
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r210) {
        a r100 = this;
        ICameraController r101 = r100.f20330h;
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r100.f20341s = r103;
        if (r100.f20339q == true) goto L165;
        if (r103 == false) goto L13;
        return;
    L13:
        if (r100.f20336n != null) goto L16;
        return;
    L16:
        if (r100.f465191y.f465200c != null) goto L19;
        return;
    L19:
        if (r100.f20337o != null) goto L22;
        r100.f20337o = ByteBuffer.allocate((r100.f20325c * r100.f20324b) * 4);
    L22:
        if (r100.f20338p != null) goto L24;
        int[] r104 = new int[1];
        r100.f20338p = r104;
        GlUtil.b(r100.f20324b, r100.f20325c, r104);
    L24:
        r100.f20335m.updateTexImage();
        System.currentTimeMillis();
        if (r100.f20332j == false) goto L27;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    L28:
        GLES20.glClear(16640);
        r100.f20337o.rewind();
        if (r100.E == false) goto L118;
        int r110 = r100.f20323a;
        r110 = r100.f20336n.i(r110, r100.f20337o);     // Catch: GlUtil.GlException -> L33
    L38:
        if (r100.f20342t != null) goto L40;
    L53:
        g r105 = r100.F;
        if (r105 == null) goto L110;
        byte[] r111 = r100.f20337o.array();
        int r112 = r100.f20324b;
        int r113 = r100.f20325c;
        int r114 = r100.C;
        if (r105.f20354a == false) goto L110;
        if (r114 != 0) goto L61;
        r105.f20358e = false;
        r105.f20359f = false;
    L61:
        if (r105.f20358e == false) goto L66;
        if (r105.f20359f == true) goto L110;
    L66:
        if (r114 < 20) goto L110;
        if ((r114 % r105.f20355b) != 0) goto L110;
        if (r111 != null) goto L72;
    L109:
        String r115 = "glUseProgram fail msg=";
        String r116 = "CameraDisplayV2 ";
        int r211 = r110;
        CertLog.w("FrameDetectHelper", "Invalid RGBA buffer for frame detection");
    L111:
        r100 = this;
        GLES20.glViewport(0, 0, r100.f20326d, r100.f20327e);
        r100.f20336n.h(r211, r100.f20334l);     // Catch: GlUtil.GlException -> L114
    L136:
        if (r100.C != 0) goto L138;
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "frame_1", null)));
        rsa.c.a(new rsa.c.a("on_camera_state_change", CameraStateDetector.CameraState.FIRST_FRAME));
    L138:
        r100.C++;
        return;
    L114:
        e = move-exception;
        CertLog.i(r116, r115 + e.getMessage());
        JSONObject r106 = new JSONObject();
        r106.put("fail_step", "frame_loop");     // Catch: Exception -> L142
        r106.put("fail_reason", CertLog.getStackTraceString(e));     // Catch: Exception -> L142
    L117:
        rsa.c.a(new rsa.c.a("camera_error", r106));
        goto L136
    L72:
        if (r111.length != ((r112 * r113) * 4)) goto L109;
        float r107 = r105.f20356c / 100.0f;
        int r117 = (int) ((1.0f - r107) * 255.0f);
        int r108 = (int) (r107 * 255.0f);
        r115 = "glUseProgram fail msg=";
        r116 = "CameraDisplayV2 ";
        int r109 = 0;
        int r118 = 0;
        int r119 = 0;
    L75:
        if (r102 >= r113) goto L93;
        int r212 = r113;
        int r120 = 0;
    L77:
        if (r120 >= r112) goto L91;
        int r213 = ((r102 * r112) + r120) * 4;
        int r214 = r112;
        int r121 = r213 + 2;
        int r215 = r110;
        if (r121 >= r111.length) goto L92;
        int r122 = r111[r213] & UByte.MAX_VALUE;
        int r123 = r111[r213 + 1] & UByte.MAX_VALUE;
        int r124 = r111[r121] & UByte.MAX_VALUE;
        if (r122 >= r117) goto L86;
        if (r123 >= r117) goto L86;
        if (r124 >= r117) goto L86;
        r118 = r118 + 1;
    L90:
        r119 = r119 + 1;
        r120 = r120 + 10;
        r112 = r214;
        r110 = r215;
    L86:
        if (r122 <= r108) goto L90;
        if (r123 <= r108) goto L90;
        if (r124 <= r108) goto L90;
        r109 = r109 + 1;
    L92:
        r102 = r102 + 10;
        r113 = r212;
        r112 = r214;
        r110 = r215;
        goto L75
    L91:
        r215 = r110;
        r214 = r112;
        goto L92
    L93:
        r211 = r110;
        if (r119 <= 0) goto L111;
        float r125 = r118;
        float r126 = r119;
        float r127 = r109 / r126;
        float r128 = (r125 / r126) * 100.0f;
        float r129 = r105.f20357d;
        if (r128 > r129) goto L98;
    L102:
        float r130 = r127 * 100.0f;
        if (r130 <= r129) goto L111;
        if (r105.f20359f == true) goto L111;
        r105.f20359f = true;
        JSONObject r131 = new JSONObject();
        r131.put("fail_step", "frame_loop");     // Catch: Exception -> L141
        r131.put("fail_reason", "white frame with ratio:" + r130);     // Catch: Exception -> L141
    L108:
        rsa.c.a(new rsa.c.a("camera_error", r131));
        goto L111
    L98:
        if (r105.f20358e == true) goto L102;
        r105.f20358e = true;
        JSONObject r132 = new JSONObject();
        r132.put("fail_step", "frame_loop");     // Catch: Exception -> L140
        r132.put("fail_reason", "black frame with ratio:" + r128);     // Catch: Exception -> L140
    L101:
        rsa.c.a(new rsa.c.a("camera_error", r132));
    L110:
        r115 = "glUseProgram fail msg=";
        r116 = "CameraDisplayV2 ";
        r211 = r110;
        goto L111
    L40:
        if (r100.f20343u != null) goto L42;
    L45:
        int r133 = r100.f20324b;
        r100.f20344v = r133;
        int r134 = r100.f20325c;
        r100.f20345w = r134;
        r100.f20343u = new byte[(r133 * r134) * 4];
    L47:
        if (Accelerometer.f407643d != null) goto L49;
        Accelerometer.f407643d = Accelerometer.CLOCKWISE_ANGLE.Deg90;
    L49:
        int r135 = Accelerometer.f407643d.getValue();
        int r136 = r135 - 1;
        if (r136 >= 0) goto L52;
        r136 = r135 ^ 3;
    L52:
        r100.f20342t.a(r100.f20337o.array(), r136, null, r100.f20344v, r100.f20345w);
        goto L53
    L42:
        if (r100.f20345w != r100.f20325c) goto L45;
        if (r100.f20344v == r100.f20324b) goto L47;
    L33:
        e = move-exception;
        CertLog.i("CameraDisplayV2 ", "glUseProgram fail msg=" + e.getMessage());
        JSONObject r137 = new JSONObject();
        r137.put("fail_step", "frame_loop");     // Catch: Exception -> L143
        r137.put("fail_reason", CertLog.getStackTraceString(e));     // Catch: Exception -> L143
    L36:
        rsa.c.a(new rsa.c.a("camera_error", r137));
        goto L38
    L118:
        int r138 = r100.f20336n.i(r100.f20323a, r100.f20337o);
        if (r100.f20342t != null) goto L121;
    L134:
        GLES20.glViewport(0, 0, r100.f20326d, r100.f20327e);
        r100.f20336n.h(r138, r100.f20334l);
        goto L136
    L121:
        if (r100.f20343u != null) goto L123;
    L126:
        int r139 = r100.f20324b;
        r100.f20344v = r139;
        int r140 = r100.f20325c;
        r100.f20345w = r140;
        r100.f20343u = new byte[(r139 * r140) * 4];
    L128:
        if (Accelerometer.f407643d != null) goto L130;
        Accelerometer.f407643d = Accelerometer.CLOCKWISE_ANGLE.Deg90;
    L130:
        int r141 = Accelerometer.f407643d.getValue();
        int r142 = r141 - 1;
        if (r142 >= 0) goto L133;
        r142 = r141 ^ 3;
    L133:
        r100.f20342t.a(r100.f20337o.array(), r142, null, r100.f20344v, r100.f20345w);
        goto L134
    L123:
        if (r100.f20345w != r100.f20325c) goto L126;
        if (r100.f20344v == r100.f20324b) goto L128;
    L27:
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        goto L28
    L165:
        return;
    L5:
        if (r101.isGLPause() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        if (this.f20341s == false) goto L5;
        return;
    L5:
        this.D = false;
        STGLRenderer r102 = this.f20336n;
        if (r102 == null) goto L11;
        r102.f407278i = false;
        r102.f407280k = 0;
        r102.f407281l = 0;
        r102.f407282m = null;
        r102.f407283n = null;
        Iterator<HashMap<String, Integer>> r103 = r102.f407279j.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        HashMap<String, Integer> r104 = r103.next();
        r104.put("program", 0);
        r104.put("position", -1);
        r104.put("inputImageTexture", -1);
        r104.put("inputTextureCoordinate", -1);
        r104.put("uMVPMatrix", -1);
        r104.put("uSTMatrix", -1);
        r104.put("intensity", -1);
    L11:
        GLES20.glEnable(3024);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(2929);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
        if (this.f20341s == false) goto L5;
        return;
    L5:
        if (this.f20336n == null) goto L13;
        this.f20326d = r101;
        this.f20327e = r102;
        GLES20.glViewport(0, 0, r101, r102);
        if (this.f20333k == false) goto L10;
        STGLRenderer r103 = this.f20336n;
        r103.f407275f = 0;
        int r104 = this.f20324b;
        float r105 = ((r104 - 360) * 0.5f) / r104;
        int r106 = this.f20325c;
        float r107 = ((r106 - 360) * 0.5f) / r106;
        r103.k(r105, r107, 1.0f - r105, 1.0f - r107);
        this.f20336n.j();
    L10:
        this.f20336n.d(this.f20326d, this.f20327e, this.f20324b, this.f20325c);
        this.D = true;
        k("onSurfaceChanged");
        return;
    }

    public a(Context r100, ICameraController r101, bsa.f r102, GLSurfaceView r103, boolean r104, boolean r105) {
        super(r100, r101, r102, r103, r104, r105);
        this.f465192z = 1;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.G = new C5577a(this);
        this.f465191y = new csa.c(r100);
        Object r106 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.GL_ERROR_DETECT_ENABLED);
        if ((r106 instanceof Boolean) == false) goto L5;
        this.E = ((Boolean) r106).booleanValue();
    L5:
        Object r107 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.FRAME_DETECT_CONFIG);
        if ((r107 instanceof JSONObject) == false) goto L9;
        this.F = new g((JSONObject) r107);
        return;
    }
}
