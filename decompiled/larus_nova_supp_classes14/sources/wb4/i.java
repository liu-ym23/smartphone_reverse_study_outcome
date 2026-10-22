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
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.bdturing.livedetect.view.AutoFixTextureView;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public Activity a;
    public final g b;
    public AutoFixTextureView c;
    public PthreadHandlerThreadV2 d;
    public Handler e;
    public String f;
    public int g;
    public Size h;
    public h i;
    public ImageReader j;
    public wb4.b k;
    public wb4.a l;
    public CaptureRequest.Builder m;
    public CameraDevice n;
    public final a o;
    public CameraCaptureSession p;
    public final b q;

    public class a extends CameraDevice.StateCallback {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice r3) {
            super.onClosed(r3);
            e.b().c("onClosed", null);
            int r4 = n.a;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice r3) {
            int r4 = n.a;
            e.b().c("onDisconnected", null);
            this.a.n = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice r21) {
            ArrayList r1 = new ArrayList();
            Object[] r11 = {r21};
            f06.b r13 = new f06.b();
            g06.a r3 = (g06.a) ApiHookConfig.b.get(100200);
            if (r3 == null) goto L5;
            f06.a[] r4 = r3.i;
        L6:
            f06.a[] r10 = r4;
            int r9 = r10.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r6 = r10[r8];
            int r17 = r8;
            int r18 = r9;
            f06.a[] r19 = r10;
            f06.d r5 = r6.preInvoke(100200, "com/bytedance/bdturing/livedetect/camera/TuringCamera2Helper$2", "onOpened", this, r11, "void", r13);     // Catch: Exception -> L25
            if (r5.a == true) goto L12;
            r1.add(r6);     // Catch: Exception -> L25
            goto L14
        L12:
            String r2 = null;
        L17:
            if (r5.a == false) goto L19;
            return;
        L19:
            int r7 = n.a;
            e.b().c("onOpened", r2);
            i r12 = this.a;
            r12.n = r21;
            SurfaceTexture r0 = r12.c.getSurfaceTexture();     // Catch: Exception -> L22
            r0.setDefaultBufferSize(r12.h.getWidth(), r12.h.getHeight());     // Catch: Exception -> L22
            Surface r14 = new Surface(r0);     // Catch: Exception -> L22
            CaptureRequest.Builder r15 = r12.n.createCaptureRequest(1);     // Catch: Exception -> L22
            r12.m = r15;     // Catch: Exception -> L22
            r15.addTarget(r14);     // Catch: Exception -> L22
            r12.m.addTarget(r12.j.getSurface());     // Catch: Exception -> L22
            r12.n.createCaptureSession(Arrays.asList(new Surface[]{r14, r12.j.getSurface()}), r12.q, r12.e);     // Catch: Exception -> L22
            return;
        L22:
            e = move-exception;
            e.printStackTrace();
            r12.d(40004, e);
            return;
        L14:
            r8 = r17 + 1;
            r9 = r18;
            r10 = r19;
            goto L8
        L15:
            r2 = null;
            r5 = new f06.d(false, null);
            goto L17
        L5:
            r4 = ApiHookConfig.d;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice r4, int r5) {
            this.a.n = null;
            e.b().c("onError", null);
            this.a.d(40001, new IllegalStateException("camera onError:error_code=" + r5));
        }
    }

    public class b extends CameraCaptureSession.StateCallback {
        public final /* synthetic */ i a;

        public class a extends CameraCaptureSession.CaptureCallback {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public final void onCaptureFailed(CameraCaptureSession r4, CaptureRequest r5, CaptureFailure r6) {
                e.b().c("onCaptureFailed", "captureFailed: reason=" + r6.getReason() + ":" + r6);
                this.a.a.d(40002, new IllegalStateException("captureFailed: reason=" + r6.getReason() + ":" + r6.toString()));
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public final void onCaptureStarted(CameraCaptureSession r1, CaptureRequest r2, long r3, long r5) {
                g r4 = this.a.a.b;
                if (r4 == null) goto L24;
                monitor-enter(r4);
            L21:
                th = move-exception;
                throw th;
            L6:
                if (r4.c != 0) goto L8;
                r4.d = ((r4.b - r4.a) + 360) % 360;     // Catch: Throwable -> L21
            L19:
                monitor-exit(r4);
                return;
            L8:
                int r6 = r4.a;     // Catch: Throwable -> L21
                if (r6 != 0) goto L11;
            L18:
                r4.d = ((r4.b - r6) + 360) % 360;     // Catch: Throwable -> L21
                goto L19
            L11:
                if (r6 != 90) goto L13;
            L17:
                r4.d = (360 - ((r4.b + r6) % 360)) % 360;     // Catch: Throwable -> L21
                goto L19
            L13:
                if (r6 == 180) goto L18;
                if (r6 == 270) goto L17;
            }
        }

        public b(i r1) {
            this.a = r1;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(CameraCaptureSession r4) {
            e.b().c("onConfigureFailed", "CameraCaptureSession:" + r4);
            this.a.d(40002, new IllegalStateException("camera configureFailed:"));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(CameraCaptureSession r4) {
            i r0 = this.a;
            if (r0.n != null) goto L5;
            return;
        L5:
            r0.p = r4;
            r0.m.set(CaptureRequest.CONTROL_AF_MODE, 4);     // Catch: Exception -> L8
            this.a.m.set(CaptureRequest.CONTROL_AE_MODE, 2);     // Catch: Exception -> L8
            i r5 = this.a;     // Catch: Exception -> L8
            r5.p.setRepeatingRequest(r5.m.build(), new a(this), this.a.e);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            e.printStackTrace();
            this.a.d(40002, e);
        }
    }

    public static class c implements Comparator<Size> {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Size r5, Size r6) {
            Size r7 = r5;
            Size r8 = r6;
            return Long.signum((((long) r7.getWidth()) * ((long) r7.getHeight())) - (((long) r8.getWidth()) * ((long) r8.getHeight())));
        }
    }

    public final void e() {
        CameraManager r0 = (CameraManager) this.a.getSystemService("camera");
        String[] r1 = r0.getCameraIdList();     // Catch: Exception -> L55
        int r2 = r1.length;     // Catch: Exception -> L55
        boolean r3 = false;
        CameraCharacteristics r4 = null;
        int r5 = 0;
    L4:
        if (r5 >= r2) goto L18;
        String r6 = r1[r5];     // Catch: Exception -> L55
        CameraCharacteristics r7 = r0.getCameraCharacteristics(r6);     // Catch: Exception -> L55
        Integer r8 = (Integer) r7.get(CameraCharacteristics.LENS_FACING);     // Catch: Exception -> L55
        if (r8 == null) goto L17;
        if (r8.intValue() != 0) goto L17;
        this.f = r6;     // Catch: Exception -> L55
        g r9 = this.b;     // Catch: Exception -> L55
        int r10 = r8.intValue();     // Catch: Exception -> L55
        monitor-enter(r9);     // Catch: Exception -> L55
        r9.c = r10;     // Catch: Throwable -> L14
        monitor-exit(r9);     // Catch: Exception -> L55
        r4 = r7;
        goto L18
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L55
    L17:
        r5 = r5 + 1;     // Catch: Exception -> L55
        r4 = r7;
    L18:
        if (r4 == null) goto L54;
        StreamConfigurationMap r11 = (StreamConfigurationMap) r4.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Exception -> L55
        if (r11 == null) goto L52;
        int r12 = this.a.getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L55
        int r13 = ((Integer) r4.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();     // Catch: Exception -> L55
        this.g = r13;     // Catch: Exception -> L55
        this.b.a(r13);     // Catch: Exception -> L55
        if (r12 == 0) goto L33;
        if (r12 == 1) goto L28;
        if (r12 == 2) goto L33;
        if (r12 == 3) goto L28;
        int r14 = n.a;     // Catch: Exception -> L55
    L38:
        Point r15 = new Point();     // Catch: Exception -> L55
        this.a.getWindowManager().getDefaultDisplay().getSize(r15);     // Catch: Exception -> L55
        int r16 = r15.x;     // Catch: Exception -> L55
        int r17 = r15.y;     // Catch: Exception -> L55
        int r18 = 480;
        int r19 = 640;
        if (r3 == false) goto L42;
        r18 = 640;
        r19 = 480;
        r16 = r17;
        r17 = r16;
    L42:
        if (r16 <= 1920) goto L45;
        r16 = 1920;
    L45:
        if (r17 <= 1080) goto L47;
        r17 = 1080;
    L47:
        Size r20 = a(r11.getOutputSizes(SurfaceTexture.class), r18, r19, r16, r17);     // Catch: Exception -> L55
        this.h = r20;     // Catch: Exception -> L55
        Objects.toString(r20);     // Catch: Exception -> L55
        int r21 = n.a;     // Catch: Exception -> L55
        if (this.a.getResources().getConfiguration().orientation != 2) goto L50;
        this.c.a(this.h.getWidth(), this.h.getHeight());     // Catch: Exception -> L55
        return;
    L50:
        this.c.a(this.h.getHeight(), this.h.getWidth());     // Catch: Exception -> L55
        return;
    L28:
        int r22 = this.g;     // Catch: Exception -> L55
        if (r22 != 0) goto L31;
    L37:
        r3 = true;
        goto L38
    L31:
        if (r22 != 180) goto L38;
    L33:
        int r23 = this.g;     // Catch: Exception -> L55
        if (r23 == 90) goto L37;
        if (r23 != 270) goto L38;
    L52:
        throw new IllegalStateException("streamCfgMap is null");     // Catch: Exception -> L55
    L54:
        throw new IllegalStateException("front camera is disAvailable");     // Catch: Exception -> L55
    L55:
        e = move-exception;
        d(40002, e);
    }

    public final void f() {
        if (this.c != null) goto L5;
        return;
    L5:
        e.b().a();
        e.b().c("openCameraInner", UploadTypeInf.START);
        this.i.enable();
        CameraManager r0 = (CameraManager) this.a.getSystemService("camera");
        e();     // Catch: Exception -> L26
        this.j = ImageReader.newInstance(this.h.getWidth(), this.h.getHeight(), 35, 2);     // Catch: Exception -> L26
        wb4.b r1 = this.k;     // Catch: Exception -> L26
        if (r1 == null) goto L9;
        r1.c();     // Catch: Exception -> L26
    L9:
        PthreadHandlerThreadV2 r2 = this.d;     // Catch: Exception -> L26
        if (r2 == null) goto L17;
        if (r2 != null) goto L29;
    L13:
        this.d = null;     // Catch: Exception -> L15
        this.e = null;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L26
        goto L17
    L29:
        r2.quit();     // Catch: Exception -> L15
        ThreadMethodProxy.join(this.d);     // Catch: Exception -> L15
    L17:
        PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("BdTuring_Camera_Thread");     // Catch: Exception -> L26
        this.d = r3;     // Catch: Exception -> L26
        ThreadMethodProxy.start(r3);     // Catch: Exception -> L26
        Handler r4 = new Handler(this.d.getLooper());     // Catch: Exception -> L26
        this.e = r4;     // Catch: Exception -> L26
        wb4.b r5 = new wb4.b(this.l, this.b);     // Catch: Exception -> L26
        this.k = r5;     // Catch: Exception -> L26
        this.j.setOnImageAvailableListener(r5, r4);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(this.f) == true) goto L25;
        String r6 = this.f;     // Catch: Exception -> L26
        a r7 = this.o;     // Catch: Exception -> L26
        Handler r8 = this.e;     // Catch: Exception -> L26
        if (fna.g.d() == true) goto L22;
        c(r0, r6, r7, r8);     // Catch: Exception -> L26
    L23:
        e.b().c("openCameraInner", "finish");     // Catch: Exception -> L26
        return;
    L22:
        c(r0, r6, r7, r8);     // Catch: Exception -> L26
        jna.a.b(r6);     // Catch: Exception -> L26
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
        if (this.n != null) goto L5;
        return;
    L5:
        CameraCaptureSession r0 = this.p;     // Catch: Exception -> L29
        if (r0 == null) goto L8;
        r0.close();     // Catch: Exception -> L29
        this.p = null;     // Catch: Exception -> L29
    L8:
        CameraDevice r1 = this.n;     // Catch: Exception -> L29
        if (fna.g.d() == true) goto L11;
        b(r1);     // Catch: Exception -> L29
    L14:
        this.n = null;     // Catch: Exception -> L29
        ImageReader r2 = this.j;     // Catch: Exception -> L29
        if (r2 == null) goto L17;
        r2.close();     // Catch: Exception -> L29
        this.j = null;     // Catch: Exception -> L29
    L17:
        h r3 = this.i;     // Catch: Exception -> L29
        if (r3 == null) goto L32;
        r3.disable();     // Catch: Exception -> L29
    L32:
        PthreadHandlerThreadV2 r4 = this.d;     // Catch: Exception -> L25
        if (r4 == null) goto L23;
        r4.quit();     // Catch: Exception -> L25
        ThreadMethodProxy.join(this.d);     // Catch: Exception -> L25
    L23:
        this.d = null;     // Catch: Exception -> L25
        this.e = null;     // Catch: Exception -> L25
    L27:
        e.b().d();     // Catch: Exception -> L29
        return;
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
        goto L27
    L11:
        b(r1);     // Catch: Exception -> L29
        if ((r1 instanceof CameraDevice) == false) goto L14;
        jna.a.a(r1.getId());     // Catch: Exception -> L29
        goto L14
    }

    public static void b(CameraDevice r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, false);
        return;
    L6:
        r12.close();
        r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, true);
    }

    public i(Activity r2, AutoFixTextureView r3) {
        this.o = new a(this);
        this.q = new b(this);
        this.a = r2;
        this.c = r3;
        this.b = new g();
        h r4 = new h(this, r2);
        this.i = r4;
        r4.enable();
    }

    public final void d(int r4, Exception r5) {
        wb4.a r0 = this.l;
        if (r0 == null) goto L10;
        LiveDetectView r1 = (LiveDetectView) r0;
        if (r1.f == null) goto L11;
        Handler r2 = r1.c;
        if (r2 == null) goto L12;
        r2.post(new com.bytedance.bdturing.livedetect.view.b(r1, r4, r5));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void c(CameraManager r11, String r12, a r13, Handler r14) throws CameraAccessException {
        f06.c r8 = new f06.c();
        Object[] r9 = {r12, r13, r14};
        f06.b r10 = new f06.b();
        if (r8.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, "void", r10).a == false) goto L6;
        r8.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, null, r10, false);
        return;
    L6:
        r11.openCamera(r12, r13, r14);
        r8.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, null, r10, true);
    }

    public static Size a(Size[] r7, int r8, int r9, int r10, int r11) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L18;
        Size r4 = r7[r3];
        r4.getWidth();
        r4.getHeight();
        if (r4.getWidth() > r10) goto L16;
        if (r4.getHeight() > r11) goto L16;
        if (r4.getHeight() != ((r4.getWidth() * r9) / r8)) goto L16;
        if (r4.getWidth() >= r8) goto L13;
    L15:
        r1.add(r4);
        goto L16
    L13:
        if (r4.getHeight() < r9) goto L15;
        r0.add(r4);
    L16:
        r3 = r3 + 1;
        goto L3
    L18:
        if (r0.size() <= 0) goto L21;
        Size r12 = (Size) Collections.min(r0, new c());
    L24:
        Objects.toString(r12);
        int r13 = n.a;
        return r12;
    L21:
        if (r1.size() <= 0) goto L23;
        r12 = (Size) Collections.max(r1, new c());
        goto L24
    L23:
        int r14 = n.a;
        r12 = new Size(r8, r9);
        goto L24
    }
}
