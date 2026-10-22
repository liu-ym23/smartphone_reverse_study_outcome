package r3a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.display.DisplayManager;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.Surface;
import android.view.TextureView;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.component.vlm.camera.camera_state.t;
import com.larus.voicecall.impl.component.vlm.camera.camera_state.u;
import com.larus.voicecall.impl.component.vlm.camera.core.CameraOpenScene;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.vesdk.VECameraCapture;
import com.ss.android.vesdk.VECameraSettings;
import com.ss.android.vesdk.VEDisplaySettings;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESDK;
import com.ss.android.vesdk.VESize;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements k {
    public static final VEDisplaySettings.VEDisplayFitMode N = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public final FloatBuffer F;
    public final FloatBuffer G;
    public final float[] H;
    public final FloatBuffer I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final FloatBuffer f535896J;
    public final FloatBuffer K;
    public final FloatBuffer L;
    public final FloatBuffer M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f535897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f535898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f535899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q3a.o f535900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f535901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f535902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f535903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f535904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f535905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f535906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f535907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f535908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile Boolean f535909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile VECameraCapture f535910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Surface f535911o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextureView f535912p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p3a.c f535913q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f535914r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f535915s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f535916t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f535917u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f535918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f535919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f535920x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f535921y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f535922z;

    public static final class a {
    }

    public static final class b implements VEListener.s {
        public b() {
        }

        @Override // com.ss.android.vesdk.VEListener.s
        public final VESize a(List<? extends VESize> r110) {
            int r100 = 1;
            if (r110.isEmpty() == false) goto L5;
            boolean r101 = true;
        L7:
            if (r101 == true) goto L9;
            VESize r102 = (VESize) ListProtector.get(r110, 0);
            if (r102 == null) goto L13;
            int r103 = Math.abs(1280 - r102.width) + Math.abs(720 - r102.height);
            int r104 = ((ArrayList) r110).size();
        L15:
            if (r100 >= r104) goto L23;
            VESize r105 = (VESize) ListProtector.get(r110, r100);
            if (r105 == null) goto L22;
            int r106 = Math.abs(1280 - r105.width) + Math.abs(720 - r105.height);
            if (r106 >= r103) goto L22;
            r102 = r105;
            r103 = r106;
        L22:
            r100 = r100 + 1;
            goto L15
        L23:
            return r102;
        L13:
            return new VESize(1280, 720);
        L9:
            return new VESize(1280, 720);
        L5:
            r101 = false;
            goto L7
        }
    }

    public static final class c implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f535923a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        }

        public c(f r100) {
            this.f535923a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
            FLogger.f375446a.i("CameraContextImpl", "onSurfaceTextureDestroyed");
            f r101 = this.f535923a;
            r101.f535913q.f527616f = false;
            Surface r102 = r101.f535911o;
            if (r102 == null) goto L5;
            r102.release();
        L5:
            this.f535923a.f535911o = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
            FLogger r103 = FLogger.f375446a;
            r103.i("CameraContextImpl", "onSurfaceTextureAvailable width=" + r101 + " height=" + r102);
            if (this.f535923a.f535910n != null) goto L5;
            this.f535923a.D();
        L5:
            Surface r104 = this.f535923a.f535911o;
            if (r104 == null) goto L8;
            r104.release();
        L8:
            this.f535923a.f535911o = new Surface(r100);
            f r105 = this.f535923a;
            r105.f535913q.f527616f = true;
            q3a.o r106 = r105.f535900d;
            if (r106.f531555c.get() == true) goto L12;
            r103.i("CameraEventDispatcher", "Dispatching surface created");
            r106.c("onSurfaceCreated", new q3a.c());
        L12:
            this.f535923a.B().b(r101, r102, f.N);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
            FLogger r103 = FLogger.f375446a;
            r103.i("CameraContextImpl", "onSurfaceTextureSizeChanged width=" + r101 + " height=" + r102);
            this.f535923a.f535911o = new Surface(r100);
            f r104 = this.f535923a;
            r104.f535913q.f527616f = true;
            u r105 = r104.B();
            Surface r106 = this.f535923a.f535911o;
            if (r106 != null) goto L5;
            r105.getClass();
            r103.e("RealtimeCameraRecorder", "onSurfaceChanged but surface is null");
        L8:
            this.f535923a.B().b(r101, r102, f.N);
            return;
        L5:
            VERecorder r107 = r105.f377905b;
            if (r107 == null) goto L8;
            r107.changeSurface(r106);
            goto L8
        }
    }

    @Override // r3a.k
    public final void a() {
        this.f535909m = null;
    }

    static {
        N = VEDisplaySettings.VEDisplayFitMode.SCALE_MODE_CENTER_CROP;
    }

    public final u B() {
        return (u) this.f535902f.getValue();
    }

    public final boolean D() {
        if (this.f535914r.compareAndSet(false, true) == true) goto L8;
        FLogger.f375446a.i("CameraContextImpl", "initializeCapture already initialized, skip");
        if (this.f535910n == null) goto L22;
        return true;
    L22:
        return false;
    L8:
        FLogger r100 = FLogger.f375446a;
        r100.i("CameraContextImpl", "Initializing camera capture");
        o3.f365784b.c();     // Catch: Exception -> L18
        VESDK.enableRefactorRecorder(true);     // Catch: Exception -> L18
        VESDK.enableNewRecorder(true);     // Catch: Exception -> L18
        this.f535910n = new VECameraCapture();     // Catch: Exception -> L18
        VECameraCapture r101 = this.f535910n;     // Catch: Exception -> L18
        if (r101 == null) goto L13;
        r101.setCameraStateListener(new g(this));     // Catch: Exception -> L18
    L13:
        if (y() == true) goto L16;
        this.f535910n = null;     // Catch: Exception -> L18
        this.f535914r.set(false);     // Catch: Exception -> L18
        r100.e("CameraContextImpl", "Camera capture init failed, reset initialized state");     // Catch: Exception -> L18
        return false;
    L16:
        r100.i("CameraContextImpl", "Camera capture initialized successfully");     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        this.f535910n = null;
        this.f535914r.set(false);
        FLogger.f375446a.e("CameraContextImpl", "Failed to initialize camera capture", e);
        i r102 = new i(1, "Failed to initialize camera capture: " + e.getMessage(), e);
        Intrinsics.checkNotNullParameter(r102, "error");
        this.f535900d.b(r102);
        return false;
    }

    @Override // r3a.k
    public final void h() {
        this.f535913q.f527615e = false;
    }

    @Override // r3a.k
    public final boolean isCameraTorchSupported() {
        VECameraCapture r100 = this.f535910n;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isTorchSupported();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, r3a.e] */
    @Override // r3a.k
    public final boolean k() {
        Intrinsics.checkNotNullParameter("onStateChanged_RealtimeCameraManager", "from");
        if (n() == true) goto L7;
        FLogger.f375446a.e("CameraContextImpl", "Resources not available for preview");
        return false;
    L7:
        if (this.f535913q.f527612b == true) goto L10;
        FLogger.f375446a.e("CameraContextImpl", "Camera is not open, cannot start preview");
        return false;
    L10:
        FLogger r100 = FLogger.f375446a;
        r100.i("CameraContextImpl", "Performing start preview operation. from=[onStateChanged_RealtimeCameraManager]");
        this.f535913q.f527614d = true;     // Catch: Exception -> L19
        u r101 = B();     // Catch: Exception -> L19
        Surface r102 = this.f535911o;     // Catch: Exception -> L19
        final ?? r103 = new e(this);     // Catch: Exception -> L19
        r101.getClass();     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r103, "onResult");     // Catch: Exception -> L19
        if (r102 != null) goto L14;
        r100.e("RealtimeCameraRecorder", "surface is empty!");     // Catch: Exception -> L19
    L17:
        System.currentTimeMillis();     // Catch: Exception -> L19
        r100.i("CameraContextImpl", "Preview started successfully ");     // Catch: Exception -> L19
        return true;
    L14:
        VERecorder r104 = r101.f377905b;     // Catch: Exception -> L19
        if (r104 == null) goto L17;
        r104.startPreviewAsync(r102, new t(r103));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLogger.f375446a.e("CameraContextImpl", "Exception starting preview", e);
        return false;
    }

    @Override // r3a.k
    public final boolean n() {
        if (this.f535915s.get() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f535910n == null) goto L7;
        return true;
    }

    @Override // r3a.k
    public final boolean q() {
        Boolean r100 = this.f535909m;
        if (r100 != null) goto L5;
        z2 r101 = z2.f365865a;
        int r102 = r101.getRealtimeCallCamera2Override();
        if (r102 != 0) goto L9;
        return false;
    L9:
        if (r102 != 1) goto L14;
        return true;
    L14:
        return r101.enableCamera2();
    L5:
        return r100.booleanValue();
    }

    @Override // r3a.k
    public final void s() {
        FLogger r100 = FLogger.f375446a;
        r100.i("CameraContextImpl", "performDestroy");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L47
        o r102 = (o) this.f535901e.getValue();     // Catch: Throwable -> L47
        r102.getClass();     // Catch: Throwable -> L47
        if (z2.f365865a.enableVideoCaptureStartStatusAlignRtc() == false) goto L18;
        r102.d("onContextDestroy");     // Catch: Throwable -> L47
        Object r103 = r102.f535962n;     // Catch: Throwable -> L47
        monitor-enter(r103);     // Catch: Throwable -> L47
        r102.f535964p = 0;     // Catch: Throwable -> L14
        r102.f535965q = false;     // Catch: Throwable -> L14
        r102.f535966r = false;     // Catch: Throwable -> L14
        n r104 = r102.f535967s;     // Catch: Throwable -> L14
        if (r104 == null) goto L11;
        r102.f535961m.removeCallbacks(r104);     // Catch: Throwable -> L14
    L11:
        r102.f535967s = null;     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L47
        goto L18
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L18:
        if (this.f535913q.f527613c == true) goto L20;
    L28:
        this.f535908l.set(true);     // Catch: Throwable -> L47
        if (((Boolean) this.f535903g.getValue()).booleanValue() == false) goto L34;
        h r106 = this.f535906j;     // Catch: Throwable -> L47
        if (r106 == null) goto L33;
        r106.disable();     // Catch: Throwable -> L47
    L33:
        this.f535906j = null;     // Catch: Throwable -> L47
    L34:
        u r107 = B();     // Catch: Throwable -> L47
        u.c r108 = r107.f377913j;     // Catch: Throwable -> L47
        if (r108 == null) goto L39;
        DisplayManager r109 = r107.f377912i;     // Catch: Throwable -> L47
        if (r109 == null) goto L39;
        r109.unregisterDisplayListener(r108);     // Catch: Throwable -> L47
    L39:
        r107.f377913j = null;     // Catch: Throwable -> L47
        r107.f377912i = null;     // Catch: Throwable -> L47
        this.f535915s.set(true);     // Catch: Throwable -> L47
        Surface r110 = this.f535911o;     // Catch: Throwable -> L47
        if (r110 == null) goto L42;
        r110.release();     // Catch: Throwable -> L47
    L42:
        q3a.o r111 = this.f535900d;     // Catch: Throwable -> L47
        if (r111.f531555c.compareAndSet(false, true) == false) goto L45;
        r100.i("CameraEventDispatcher", "Shutting down event dispatcher");     // Catch: Throwable -> L47
        r111.f531553a.clear();     // Catch: Throwable -> L47
        r100.d("CameraEventDispatcher", "Cleared all listeners");     // Catch: Throwable -> L47
        r111.f531554b.shutdown();     // Catch: Throwable -> L47
    L45:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L57;
        FLogger.f375446a.e("CameraContextImpl", "performDestroy err=" + r113);
        return;
    L57:
        return;
    L20:
        if (((Boolean) this.f535904h.getValue()).booleanValue() == false) goto L24;
        VERecorder r114 = B().f377905b;     // Catch: Throwable -> L47
        if (r114 == null) goto L24;
        r114.stopPreview();     // Catch: Throwable -> L47
    L24:
        VECameraCapture r115 = this.f535910n;     // Catch: Throwable -> L47
        if (r115 == null) goto L27;
        r115.destroy();     // Catch: Throwable -> L47
    L27:
        B().c();     // Catch: Throwable -> L47
        r100.i("CameraContextImpl", "destroy recorder from performDestroy");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    public final int C() {
        int r100 = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if (r100 != 1) goto L7;
        return 90;
    L7:
        if (r100 != 2) goto L9;
        return 180;
    L9:
        if (r100 != 3) goto L18;
        return 270;
    L18:
        return 0;
    }

    @Override // r3a.k
    public final void i() {
        B().d(this.f535910n);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "CameraContextImpl_performInitRecorder()");
        FLogger.f375446a.e("CameraContextImpl", "performInitRecorder() failed", th);
    }

    public final boolean y() {
        if (q() == false) goto L5;
        VECameraSettings.CAMERA_TYPE r100 = VECameraSettings.CAMERA_TYPE.TYPE2;
    L6:
        boolean r101 = this.f535898b.f535940d;
        if (r101 == false) goto L9;
        VECameraSettings.CAMERA_FACING_ID r102 = VECameraSettings.CAMERA_FACING_ID.FACING_FRONT;
    L10:
        this.f535913q.f527611a = r101;
        H(r101);
        z2 r103 = z2.f365865a;
        boolean r104 = r103.enableVeCaptureTargetSize();
        boolean r105 = r103.enableVeCaptureRtcSetting();
        m r106 = this.f535898b;
        RangesKt.coerceAtLeast(r106.f535937a, r106.f535938b);
        VECameraSettings.Builder r107 = new VECameraSettings.Builder();
        boolean r108 = true;
        VECameraSettings.Builder r109 = r107.setIsUseNewCameraTypeStrategy(true).setCameraFacing(r102);
        m r110 = this.f535898b;
        r109.setPreviewSize(r110.f535937a, r110.f535938b).setCameraAntiShake(this.f535898b.f535941e).setCameraVideoAntiShake(this.f535898b.f535942f).setEnableFallback(this.f535898b.f535944h).setFps(this.f535898b.f535939c).enablePreviewingFallback(this.f535898b.f535945i).setDefaultZoomRatio(this.f535898b.f535943g).setCameraType(r100);
        if (r105 == false) goto L13;
        r107.setRetryCnt(30).setCamera2RetryCnt(1).setFpsRange(new int[]{7, this.f535898b.f535939c}).enableGyroFocusAndMeter(true);
    L13:
        VECameraSettings r111 = r107.build();
        if (r105 == false) goto L16;
        r111.enableManualReleaseCaptureResult(false);
    L16:
        VECameraCapture r112 = this.f535910n;
        if (r112 == null) goto L19;
        Integer r113 = Integer.valueOf(r112.init(getActivity(), r111));
    L20:
        if (r113 != null) goto L23;
    L25:
        r108 = false;
    L26:
        if (r104 == false) goto L30;
        VECameraCapture r114 = this.f535910n;
        if (r114 == null) goto L30;
        r114.setPreviewSizeListener(new b());
    L30:
        FLogger.f375446a.i("CameraContextImpl", "Camera settings configured, result: " + r113 + ", cameraType: " + r100);
        return r108;
    L23:
        if (r113.intValue() != 0) goto L25;
    L19:
        r113 = null;
        goto L20
    L9:
        r102 = VECameraSettings.CAMERA_FACING_ID.FACING_BACK;
        goto L10
    L5:
        r100 = VECameraSettings.CAMERA_TYPE.TYPE1;
        goto L6
    }

    @Override // r3a.k
    public final m g() {
        return this.f535898b;
    }

    @Override // r3a.k
    public Activity getActivity() {
        return this.f535897a;
    }

    @Override // r3a.k
    public final Fragment getFragment() {
        return this.f535899c;
    }

    @Override // r3a.k
    public final p3a.c j() {
        return this.f535913q;
    }

    @Override // r3a.k
    public final void o() {
        D();
    }

    public static int A(int r100) {
        if (r100 > 0) goto L6;
        return 3553;
    L6:
        if (GLES20.glGetError() != 0) goto L6;
        GLES20.glBindTexture(3553, r100);
        int r101 = GLES20.glGetError();
        GLES20.glBindTexture(3553, 0);
        if (r101 != 0) goto L10;
        return 3553;
    L10:
        GLES20.glBindTexture(36197, r100);
        int r102 = GLES20.glGetError();
        GLES20.glBindTexture(36197, 0);
        if (r102 != 0) goto L13;
        return 36197;
    L13:
        return 3553;
    }

    public static int E(int r100) {
        return ((r100 % 360) + 360) % 360;
    }

    public static Integer v(String r100) {
        Integer r101 = w(35633, "attribute vec4 aPosition;\nattribute vec2 aTexCoord;\nvarying vec2 vTexCoord;\nuniform mat4 uTexMatrix;\nvoid main() {\n    gl_Position = aPosition;\n    vec4 tc = uTexMatrix * vec4(aTexCoord, 0.0, 1.0);\n    vTexCoord = tc.xy;\n}");
        if (r101 == null) goto L17;
        int r102 = r101.intValue();
        Integer r103 = w(35632, r100);
        if (r103 == null) goto L16;
        int r104 = r103.intValue();
        int r105 = GLES20.glCreateProgram();
        if (r105 != 0) goto L10;
        GLES20.glDeleteShader(r102);
        GLES20.glDeleteShader(r104);
        return null;
    L10:
        GLES20.glAttachShader(r105, r102);
        GLES20.glAttachShader(r105, r104);
        GLES20.glLinkProgram(r105);
        int[] r106 = new int[1];
        GLES20.glGetProgramiv(r105, 35714, r106, 0);
        GLES20.glDeleteShader(r102);
        GLES20.glDeleteShader(r104);
        if (r106[0] == 1) goto L15;
        FLogger.f375446a.e("CameraContextImpl", "buildProgram link failed: " + GLES20.glGetProgramInfoLog(r105));
        GLES20.glDeleteProgram(r105);
        return null;
    L15:
        return Integer.valueOf(r105);
    L16:
        GLES20.glDeleteShader(r102);
    L17:
        return null;
    }

    public static FloatBuffer z(float[] r100) {
        FloatBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r101.put(r100);
        r101.position(0);
        return r101;
    }

    public final boolean F(String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        FLogger r100 = FLogger.f375446a;
        r100.i("CameraContextImpl", "Performing stop preview operation. from=[" + r110 + ']');
        this.f535913q.f527614d = false;     // Catch: Exception -> L21
        VECameraCapture r101 = this.f535910n;     // Catch: Exception -> L21
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.stopPreview(true));     // Catch: Exception -> L21
    L7:
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == true) goto L19;
        q3a.o r104 = this.f535900d;     // Catch: Exception -> L21
        if (r102 == null) goto L17;
        int r105 = r102.intValue();     // Catch: Exception -> L21
    L18:
        r104.b(new i(r105, "failed_to_stop_preview, result: " + r102, null));     // Catch: Exception -> L21
        goto L19
    L17:
        r105 = -1;
    L19:
        r100.i("CameraContextImpl", "Preview stopped successfully");     // Catch: Exception -> L21
        return true;
    L10:
        if (r102.intValue() != 0) goto L12;
        r103 = true;
        goto L13
    L6:
        r102 = null;
    L21:
        e = move-exception;
        FLogger.f375446a.e("CameraContextImpl", "Exception stopping preview", e);
        return false;
    }

    public final void H(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 270;
    L5:
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L27
        int r104 = 0;
        if (r100 == false) goto L9;
        int r105 = 1;
    L10:
        int r106 = Camera.getNumberOfCameras();     // Catch: Throwable -> L27
        if (r106 <= 0) goto L24;
        Camera.CameraInfo[] r107 = new Camera.CameraInfo[r106];     // Catch: Throwable -> L27
        int r108 = 0;
    L14:
        if (r108 >= r106) goto L16;
        r107[r108] = new Camera.CameraInfo();     // Catch: Throwable -> L27
        r108 = r108 + 1;     // Catch: Throwable -> L27
        goto L14
    L16:
        int r109 = 0;
    L17:
        if (r109 >= r106) goto L19;
        Camera.getCameraInfo(r109, r107[r109]);     // Catch: Throwable -> L27
        r109 = r109 + 1;     // Catch: Throwable -> L27
    L19:
        if (r104 >= r106) goto L24;
        Camera.CameraInfo r110 = r107[r104];     // Catch: Throwable -> L27
        if (r110.facing == r105) goto L22;
        r104 = r104 + 1;     // Catch: Throwable -> L27
        goto L19
    L22:
        Integer r111 = Integer.valueOf(((r110.orientation % 360) + 360) % 360);     // Catch: Throwable -> L27
    L25:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r112) == true) goto L33;
        r102 = r112;
    L33:
        Integer r113 = (Integer) r102;
        if (r113 == null) goto L36;
        r101 = r113.intValue();
    L36:
        this.f535905i = r101;
        return;
    L24:
        r111 = null;
        goto L25
    L9:
        r105 = 0;
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L4:
        r101 = 90;
        goto L5
    }

    @Override // r3a.k
    public final void b(final boolean r110) {
        Intrinsics.checkNotNullParameter("switchCamera", "from");
        p3a.c r100 = this.f535913q;     // Catch: Exception -> L49
        if (r100.f527612b == true) goto L6;
    L47:
        FLogger.f375446a.i("CameraContextImpl", "performSwitchCamera return directly. isCameraOpen=" + this.f535913q.f527612b + " isPreviewing=" + this.f535913q.f527614d);     // Catch: Exception -> L49
        return;
    L6:
        if (r100.f527614d == false) goto L47;
        if (r110 != (!r100.f527611a)) goto L12;
        FLogger.f375446a.e("CameraContextImpl", "current camera is back=" + r110 + ", do not need to switch it!");     // Catch: Exception -> L49
        return;
    L12:
        VECameraCapture r101 = this.f535910n;     // Catch: Exception -> L49
        if (r101 == null) goto L15;
        r101.cancelFocus();     // Catch: Exception -> L49
    L15:
        FLogger r102 = FLogger.f375446a;     // Catch: Exception -> L49
        r102.e("CameraContextImpl", "cancelFocus exec");     // Catch: Exception -> L49
        if (r110 == false) goto L20;
        VECameraCapture r103 = this.f535910n;     // Catch: Exception -> L49
        if (r103 == null) goto L23;
        Integer r104 = Integer.valueOf(r103.switchCamera(VECameraSettings.CAMERA_FACING_ID.FACING_BACK));     // Catch: Exception -> L49
    L24:
        p3a.c r105 = this.f535913q;     // Catch: Exception -> L49
        if (r110 == true) goto L27;
        boolean r106 = true;
    L28:
        r105.f527611a = r106;     // Catch: Exception -> L49
        H(r106);     // Catch: Exception -> L49
        q3a.o r107 = this.f535900d;     // Catch: Exception -> L49
        if (r104 == null) goto L31;
        final int r108 = r104.intValue();     // Catch: Exception -> L49
    L33:
        if (r107.f531555c.get() == true) goto L36;
        r102.i("CameraEventDispatcher", "Dispatching camera switched: useBack=" + r110);     // Catch: Exception -> L49
        r107.c("onCameraSwitched", new q3a.g(r110, r108));     // Catch: Exception -> L49
    L36:
        String r111 = "Performing switch camera operation. useBack=" + r110 + " from=[switchCamera] result=" + r104;     // Catch: Exception -> L49
        if (r104 != null) goto L40;
    L41:
        q3a.o r109 = this.f535900d;     // Catch: Exception -> L49
        if (r104 == null) goto L44;
        int r112 = r104.intValue();     // Catch: Exception -> L49
    L45:
        r109.b(new i(r112, "failed_to_switch_camera, result: " + r104, null));     // Catch: Exception -> L49
        r102.e("CameraContextImpl", r111);     // Catch: Exception -> L49
        return;
    L44:
        r112 = -1;
        goto L45
    L40:
        if (r104.intValue() != 0) goto L41;
        r102.i("CameraContextImpl", r111);     // Catch: Exception -> L49
        ((o) this.f535901e.getValue()).e(true);     // Catch: Exception -> L49
        return;
    L31:
        r108 = -999;
        goto L33
    L27:
        r106 = false;
    L23:
        r104 = null;
        goto L24
    L20:
        VECameraCapture r113 = this.f535910n;     // Catch: Exception -> L49
        if (r113 == null) goto L23;
        r104 = Integer.valueOf(r113.switchCamera(VECameraSettings.CAMERA_FACING_ID.FACING_FRONT));     // Catch: Exception -> L49
    L49:
        e = move-exception;
        FLogger.f375446a.e("CameraContextImpl", "Exception in switch camera", e);
        if (AppHost.f326268a.isDebug() == false) goto L56;
        throw e;
    }

    @Override // r3a.k
    public final boolean c(boolean r100) {
        VECameraCapture r101 = this.f535910n;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.switchTorch(r100) != 0) goto L7;
        return true;
    }

    @Override // r3a.k
    public final boolean d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        FLogger r100 = FLogger.f375446a;
        r100.i("CameraContextImpl", "Performing close camera operation. from=[" + r110 + ']');
        VECameraCapture r101 = this.f535910n;     // Catch: Exception -> L60
        boolean r102 = true;
        if (r101 != null) goto L6;
    L8:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L33;
        VECameraCapture r104 = this.f535910n;     // Catch: Exception -> L60
        if (r104 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L33;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L26
        VERecorder r107 = B().f377905b;     // Catch: Throwable -> L26
        if (r107 == null) goto L23;
        Pair r108 = TuplesKt.to(Float.valueOf(r107.getPreviewRenderFps()), Float.valueOf(r107.getPreviewAvgRenderFps()));     // Catch: Throwable -> L26
        if (r108 == null) goto L23;
    L24:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L26
    L29:
        if (Result.m9452exceptionOrNullimpl(r109) == null) goto L32;
        r109 = TuplesKt.to(Float.valueOf(-1.0f), Float.valueOf(-1.0f));     // Catch: Exception -> L60
    L32:
        Pair r111 = (Pair) r109;     // Catch: Exception -> L60
    L38:
        final HashMap r112 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("current_fps", r111.getFirst()), TuplesKt.to("average_fps", r111.getSecond())});     // Catch: Exception -> L60
        F("this.performCloseCamera()");     // Catch: Exception -> L60
        this.f535913q.f527612b = false;     // Catch: Exception -> L60
        VECameraCapture r113 = this.f535910n;     // Catch: Exception -> L60
        if (r113 == null) goto L41;
        Integer r114 = Integer.valueOf(r113.close());     // Catch: Exception -> L60
    L42:
        if (r114 != null) goto L45;
    L47:
        r102 = false;
    L48:
        if (r102 == false) goto L54;
        q3a.o r115 = this.f535900d;     // Catch: Exception -> L60
        r115.getClass();     // Catch: Exception -> L60
        Intrinsics.checkNotNullParameter(r112, "captureParams");     // Catch: Exception -> L60
        if (r115.f531555c.get() == true) goto L53;
        FLogger.f375446a.i("CameraEventDispatcher", "Dispatching camera closed");     // Catch: Exception -> L60
        r115.c("onCameraClosed", new q3a.f(r112));     // Catch: Exception -> L60
    L53:
        FLogger.f375446a.i("CameraContextImpl", "Camera closed successfully");     // Catch: Exception -> L60
    L66:
        return r102;
    L54:
        q3a.o r116 = this.f535900d;     // Catch: Exception -> L60
        if (r114 == null) goto L57;
        int r117 = r114.intValue();     // Catch: Exception -> L60
    L58:
        r116.b(new i(r117, "failed_to_close_camera, result: " + r114, null));     // Catch: Exception -> L60
        FLogger.f375446a.e("CameraContextImpl", "Failed to close camera, result: " + r114);     // Catch: Exception -> L60
        goto L66
    L57:
        r117 = -1;
        goto L58
    L45:
        if (r114.intValue() != 0) goto L47;
    L41:
        r114 = null;
    L23:
        r108 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Exception -> L60
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L60
        goto L29
    L14:
        if (r104.getCameraState() != 0) goto L16;
        r105 = true;
    L33:
        StringBuilder r119 = new StringBuilder("getRenderFps failed! cur state is: ");     // Catch: Exception -> L60
        VECameraCapture r120 = this.f535910n;     // Catch: Exception -> L60
        if (r120 == null) goto L36;
        Integer r121 = Integer.valueOf(r120.getCameraState());     // Catch: Exception -> L60
    L37:
        r119.append(r121);     // Catch: Exception -> L60
        r100.e("CameraContextImpl", r119.toString());     // Catch: Exception -> L60
        r111 = new Pair(Float.valueOf(-1.0f), Float.valueOf(-1.0f));     // Catch: Exception -> L60
        goto L38
    L36:
        r121 = null;
        goto L37
    L6:
        if (r101.getCameraState() != 4) goto L8;
        r103 = true;
    L60:
        e = move-exception;
        FLogger.f375446a.e("CameraContextImpl", "Exception closing camera", e);
        return false;
    }

    @Override // r3a.k
    public final void l(VEFrame r410) {
        Intrinsics.checkNotNullParameter(r410, "frame");
        VEFrame.FrameBase r100 = r410.getFrame();
        if ((r100 instanceof VEFrame.TextureFrame) == true) goto L5;
        return;
    L5:
        if (((Boolean) this.f535903g.getValue()).booleanValue() == false) goto L22;
        q3a.o r101 = this.f535900d;
        VEFrame.TextureFrame r102 = (VEFrame.TextureFrame) r100;
        int r110 = this.f535907k;
        if (r410.getTextureTransformMatrix() != null) goto L9;
    L11:
        float[] r111 = this.H;
    L12:
        float[] r210 = r111;
        float[] r112 = new float[16];
        if (this.f535913q.f527611a == false) goto L19;
        float[] r103 = new float[16];
        Matrix.setIdentityM(r103, 0);
        r103[0] = -1.0f;
        r103[12] = 1.0f;
        if (r110 == 90) goto L18;
        if (r110 == 270) goto L18;
        Matrix.multiplyMM(r112, 0, r210, 0, r103, 0);
    L20:
        FLogger.f375446a.i("CameraContextImpl", "push oes frame info: width=" + r410.getWidth() + ", height=" + r410.getHeight() + ", textureId=" + r102.f449899b + ", frame.rotation=" + r410.getRotation() + ", gravitySensorRotation=" + r110);
        r101.e(new j(r102.f449899b, ((long) 1000) * SystemClock.elapsedRealtime(), Arrays.copyOf(r112, r112.length), r110, r102.f449898a, VideoFrameBufferType.GL_TEXTURE_OES));
        return;
    L18:
        Matrix.multiplyMM(r112, 0, r103, 0, r210, 0);
        goto L20
    L19:
        Intrinsics.checkNotNull(r210);
        r112 = r210;
        goto L20
    L9:
        if (r410.getTextureTransformMatrix().length != 16) goto L11;
        r111 = r410.getTextureTransformMatrix();
        goto L12
    L22:
        VEFrame.TextureFrame r104 = (VEFrame.TextureFrame) r100;
        int r113 = r104.f449899b;
        int r114 = C();
        int r105 = r410.getWidth();
        int r115 = r410.getHeight();
        int r116 = Math.min(r105, r115);
        int r117 = Math.max(r105, r115);
        if (r114 != 90) goto L25;
        boolean r106 = true;
    L26:
        if (r114 != 270) goto L28;
        boolean r107 = true;
    L29:
        boolean r108 = this.f535913q.f527611a;
        float[] r109 = r410.getTextureTransformMatrix();
        if (r113 <= 0) goto L46;
        if (r105 <= 0) goto L239;
        if (r115 <= 0) goto L239;
        if (r116 <= 0) goto L239;
        if (r117 <= 0) goto L239;
        int r118 = A(r113);
        if (r108 == true) goto L48;
        if (r106 == true) goto L48;
        if (r107 == true) goto L48;
        if (r118 != 3553) goto L48;
        if (r105 != 720) goto L48;
        if (r115 == 1280) goto L46;
    L48:
        if (r106 == true) goto L149;
        if (r107 == true) goto L149;
        if (r113 <= 0) goto L148;
        if (r105 <= 0) goto L148;
        if (r115 <= 0) goto L148;
        int r119 = A(r113);
        if (r108 == true) goto L64;
        if (r119 != 3553) goto L64;
        if (r105 != 720) goto L64;
        if (r115 == 1280) goto L148;
    L64:
        if (r119 == 36197) goto L67;
        if (r119 != 3553) goto L148;
    L67:
        int r120 = this.f535917u;
        if (r120 != 0) goto L70;
    L75:
        if (r120 == 0) goto L77;
        int r121 = 1;
        int r122 = 0;
        GLES20.glDeleteTextures(1, new int[]{r120}, 0);
        this.f535917u = 0;
    L78:
        int[] r123 = new int[r121];
        GLES20.glGenTextures(r121, r123, r122);
        int r124 = r123[r122];
        this.f535917u = r124;
        this.f535918v = 720;
        this.f535919w = 1280;
        GLES20.glBindTexture(3553, r124);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, 720, 1280, 0, 6408, 5121, null);
        int r125 = 0;
        GLES20.glBindTexture(3553, 0);
    L80:
        if (this.f535916t != 0) goto L83;
        int[] r126 = new int[1];
        GLES20.glGenFramebuffers(1, r126, r125);
        this.f535916t = r126[r125];
    L83:
        if (this.f535916t == 0) goto L148;
        if (this.f535917u == 0) goto L148;
        if (this.f535920x != 0) goto L95;
        Integer r127 = v("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r127 == null) goto L92;
        int r128 = r127.intValue();
    L93:
        this.f535920x = r128;
        goto L95
    L92:
        r128 = 0;
    L95:
        if (this.f535921y != 0) goto L102;
        Integer r129 = v("precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r129 == null) goto L99;
        int r130 = r129.intValue();
    L100:
        this.f535921y = r130;
        goto L102
    L99:
        r130 = 0;
    L102:
        if (r119 != 36197) goto L104;
        boolean r131 = true;
    L105:
        if (r131 == false) goto L107;
        int r132 = this.f535920x;
    L108:
        if (r132 == 0) goto L148;
        int[] r133 = new int[1];
        GLES20.glGetIntegerv(36006, r133, 0);
        VEFrame.TextureFrame r310 = r104;
        int[] r134 = new int[4];
        GLES20.glGetIntegerv(2978, r134, 0);
        GLES20.glBindFramebuffer(36160, this.f535916t);     // Catch: Throwable -> L140
        int r311 = r114;
        boolean r312 = r106;
        boolean r313 = r107;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f535917u, 0);     // Catch: Throwable -> L138
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) goto L137;
        int[] r135 = x(r105, r115);     // Catch: Throwable -> L138
        GLES20.glViewport(r135[0], r135[1], r135[2], r135[3]);     // Catch: Throwable -> L138
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L138
        GLES20.glClear(16384);     // Catch: Throwable -> L138
        int r136 = GLES20.glGetAttribLocation(r132, "aPosition");     // Catch: Throwable -> L138
        int r137 = GLES20.glGetAttribLocation(r132, "aTexCoord");     // Catch: Throwable -> L138
        int r138 = GLES20.glGetUniformLocation(r132, "uTexture");     // Catch: Throwable -> L138
        int r139 = GLES20.glGetUniformLocation(r132, "uTexMatrix");     // Catch: Throwable -> L138
        if (r136 < 0) goto L137;
        if (r137 < 0) goto L137;
        if (r138 < 0) goto L137;
        if (r139 < 0) goto L137;
        GLES20.glUseProgram(r132);     // Catch: Throwable -> L138
        GLES20.glEnableVertexAttribArray(r136);     // Catch: Throwable -> L138
        GLES20.glVertexAttribPointer(r136, 2, 5126, false, 0, this.F);     // Catch: Throwable -> L138
        GLES20.glEnableVertexAttribArray(r137);     // Catch: Throwable -> L138
        GLES20.glVertexAttribPointer(r137, 2, 5126, false, 0, G(false, false, r108));     // Catch: Throwable -> L138
        if (r109 != null) goto L125;
    L127:
        r109 = this.H;     // Catch: Throwable -> L138
    L128:
        GLES20.glUniformMatrix4fv(r139, 1, false, r109, 0);     // Catch: Throwable -> L138
        GLES20.glActiveTexture(33984);     // Catch: Throwable -> L138
        if (r131 == false) goto L131;
        GLES20.glBindTexture(36197, r113);     // Catch: Throwable -> L138
    L132:
        GLES20.glUniform1i(r138, 0);     // Catch: Throwable -> L138
        GLES20.glDrawArrays(5, 0, 4);     // Catch: Throwable -> L138
        GLES20.glFinish();     // Catch: Throwable -> L138
        if (r131 == false) goto L135;
        GLES20.glBindTexture(36197, 0);     // Catch: Throwable -> L138
    L136:
        GLES20.glDisableVertexAttribArray(r136);     // Catch: Throwable -> L138
        GLES20.glDisableVertexAttribArray(r137);     // Catch: Throwable -> L138
        GLES20.glUseProgram(0);     // Catch: Throwable -> L138
        r113 = this.f535917u;     // Catch: Throwable -> L138
        goto L137
    L135:
        GLES20.glBindTexture(3553, 0);     // Catch: Throwable -> L138
        goto L136
    L131:
        GLES20.glBindTexture(3553, r113);     // Catch: Throwable -> L138
        goto L132
    L125:
        if (r109.length != 16) goto L127;
    L137:
        GLES20.glBindFramebuffer(36160, r133[0]);
        int r140 = r134[0];
        int r141 = r134[1];
        int r142 = r134[2];
        int r143 = r134[3];
    L144:
        GLES20.glViewport(r140, r141, r142, r143);
    L193:
        boolean r144 = r312;
        boolean r145 = r313;
    L233:
        int r146 = r113;
    L241:
        int r147 = this.f535905i;
        int r148 = C();
        if (this.f535913q.f527611a == false) goto L244;
        r148 = (360 - r148) % 360;
    L244:
        int r149 = (((r147 + r148) % 360) + 360) % 360;
        if (r144 == false) goto L247;
        int r150 = 90;
    L253:
        int r151 = E(E(-r150));
        if (r151 == 90) goto L258;
        if (r151 == 270) goto L257;
        int r152 = r151;
    L259:
        this.f535900d.e(new j(r146, SystemClock.elapsedRealtime() * ((long) 1000), this.H, r152, r310.f449898a, VideoFrameBufferType.GL_TEXTURE));
        return;
    L257:
        r152 = 90;
        goto L259
    L258:
        r152 = 270;
        goto L259
    L247:
        if (r145 == false) goto L250;
        r150 = 270;
        goto L253
    L250:
        if (r311 != 180) goto L252;
        r150 = 180;
        goto L253
    L252:
        r150 = 0;
    L138:
        th = th;
    L261:
        FLogger.f375446a.e("CameraContextImpl", "ensureTexture2D error", th);     // Catch: Throwable -> L145
        GLES20.glBindFramebuffer(36160, r133[0]);
        r140 = r134[0];
        r141 = r134[1];
        r142 = r134[2];
        r143 = r134[3];
    L145:
        th = move-exception;
        GLES20.glBindFramebuffer(36160, r133[0]);
        GLES20.glViewport(r134[0], r134[1], r134[2], r134[3]);
        throw th;
    L140:
        th = th;
        r312 = r106;
        r313 = r107;
        r311 = r114;
        goto L261
    L107:
        r132 = this.f535921y;
        goto L108
    L104:
        r131 = false;
        goto L105
    L77:
        r121 = 1;
        r122 = 0;
        goto L78
    L70:
        if (this.f535918v != 720) goto L75;
        if (this.f535919w != 1280) goto L75;
        r125 = 0;
    L148:
        r310 = r104;
        r312 = r106;
        r313 = r107;
        r311 = r114;
    L149:
        r310 = r104;
        r312 = r106;
        r313 = r107;
        r311 = r114;
        int r153 = this.A;
        if (r153 != 0) goto L152;
    L157:
        if (r153 == 0) goto L159;
        int r154 = 1;
        int r155 = 0;
        GLES20.glDeleteTextures(1, new int[]{r153}, 0);
        this.A = 0;
    L160:
        int[] r156 = new int[r154];
        GLES20.glGenTextures(r154, r156, r155);
        int r157 = r156[r155];
        this.A = r157;
        this.B = 720;
        this.C = 1280;
        GLES20.glBindTexture(3553, r157);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, 720, 1280, 0, 6408, 5121, null);
        int r158 = 0;
        GLES20.glBindTexture(3553, 0);
    L162:
        if (this.f535922z != 0) goto L165;
        int[] r159 = new int[1];
        GLES20.glGenFramebuffers(1, r159, r158);
        this.f535922z = r159[r158];
    L165:
        if (this.f535922z != 0) goto L167;
    L237:
        r144 = r312;
        r145 = r313;
    L240:
        r146 = r113;
        goto L241
    L167:
        if (this.A == 0) goto L237;
        if (r118 != 36197) goto L172;
        boolean r160 = true;
    L173:
        if (r160 == true) goto L175;
    L181:
        if (r160 == false) goto L183;
    L189:
        if (r160 == false) goto L191;
        int r161 = this.D;
    L192:
        if (r161 == 0) goto L193;
        int[] r162 = new int[1];
        GLES20.glGetIntegerv(36006, r162, 0);
        int[] r163 = new int[4];
        GLES20.glGetIntegerv(2978, r163, 0);
        GLES20.glBindFramebuffer(36160, this.f535922z);     // Catch: Throwable -> L228
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A, 0);     // Catch: Throwable -> L228
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) goto L198;
    L197:
        r144 = r312;
        r145 = r313;
    L227:
        GLES20.glBindFramebuffer(36160, r162[0]);
        int r164 = r163[0];
        int r165 = r163[1];
        int r166 = r163[2];
        int r167 = r163[3];
    L232:
        GLES20.glViewport(r164, r165, r166, r167);
        goto L233
    L198:
        int[] r168 = x(r116, r117);     // Catch: Throwable -> L228
        GLES20.glViewport(r168[0], r168[1], r168[2], r168[3]);     // Catch: Throwable -> L228
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L228
        GLES20.glClear(16384);     // Catch: Throwable -> L228
        int r169 = GLES20.glGetAttribLocation(r161, "aPosition");     // Catch: Throwable -> L228
        int r170 = GLES20.glGetAttribLocation(r161, "aTexCoord");     // Catch: Throwable -> L228
        int r171 = GLES20.glGetUniformLocation(r161, "uTexture");     // Catch: Throwable -> L228
        int r172 = GLES20.glGetUniformLocation(r161, "uTexMatrix");     // Catch: Throwable -> L228
        if (r169 < 0) goto L197;
        if (r170 < 0) goto L197;
        if (r171 < 0) goto L197;
        if (r172 < 0) goto L197;
        GLES20.glUseProgram(r161);     // Catch: Throwable -> L228
        GLES20.glEnableVertexAttribArray(r169);     // Catch: Throwable -> L228
        GLES20.glVertexAttribPointer(r169, 2, 5126, false, 0, this.F);     // Catch: Throwable -> L228
        GLES20.glEnableVertexAttribArray(r170);     // Catch: Throwable -> L228
        r144 = r312;
        r145 = r313;
        GLES20.glVertexAttribPointer(r170, 2, 5126, false, 0, G(r144, r145, r108));     // Catch: Throwable -> L225
        if (r109 != null) goto L209;
    L211:
        r109 = this.H;     // Catch: Throwable -> L225
    L212:
        GLES20.glUniformMatrix4fv(r172, 1, false, r109, 0);     // Catch: Throwable -> L225
        GLES20.glActiveTexture(33984);     // Catch: Throwable -> L225
        if (r160 == false) goto L215;
        GLES20.glBindTexture(36197, r113);     // Catch: Throwable -> L225
    L217:
        if (GLES20.glGetError() != 0) goto L227;
        GLES20.glUniform1i(r171, 0);     // Catch: Throwable -> L225
        GLES20.glDrawArrays(5, 0, 4);     // Catch: Throwable -> L225
        GLES20.glFinish();     // Catch: Throwable -> L225
        if (r160 == false) goto L222;
        GLES20.glBindTexture(36197, 0);     // Catch: Throwable -> L225
    L223:
        GLES20.glDisableVertexAttribArray(r169);     // Catch: Throwable -> L225
        GLES20.glDisableVertexAttribArray(r170);     // Catch: Throwable -> L225
        GLES20.glUseProgram(0);     // Catch: Throwable -> L225
        r113 = this.A;     // Catch: Throwable -> L225
        goto L227
    L222:
        GLES20.glBindTexture(3553, 0);     // Catch: Throwable -> L225
        goto L223
    L215:
        GLES20.glBindTexture(3553, r113);     // Catch: Throwable -> L225
        goto L217
    L209:
        if (r109.length != 16) goto L211;
    L225:
        th = th;
    L265:
        FLogger.f375446a.e("CameraContextImpl", "ensurePortraitTexture2D error", th);     // Catch: Throwable -> L234
        GLES20.glBindFramebuffer(36160, r162[0]);
        r164 = r163[0];
        r165 = r163[1];
        r166 = r163[2];
        r167 = r163[3];
    L234:
        th = move-exception;
        GLES20.glBindFramebuffer(36160, r162[0]);
        GLES20.glViewport(r163[0], r163[1], r163[2], r163[3]);
        throw th;
    L228:
        th = th;
        r144 = r312;
        r145 = r313;
        goto L265
    L191:
        r161 = this.E;
        goto L192
    L183:
        if (this.E != 0) goto L189;
        Integer r173 = v("precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r173 == null) goto L187;
        int r174 = r173.intValue();
    L188:
        this.E = r174;
        goto L189
    L187:
        r174 = 0;
        goto L188
    L175:
        if (this.D != 0) goto L181;
        Integer r175 = v("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r175 == null) goto L179;
        int r176 = r175.intValue();
    L180:
        this.D = r176;
        goto L181
    L179:
        r176 = 0;
        goto L180
    L172:
        r160 = false;
        goto L173
    L159:
        r154 = 1;
        r155 = 0;
        goto L160
    L152:
        if (this.B != 720) goto L157;
        if (this.C != 1280) goto L157;
        r158 = 0;
    L239:
        r310 = r104;
        r144 = r106;
        r145 = r107;
        r311 = r114;
    L46:
        r310 = r104;
        r144 = r106;
        r145 = r107;
        r311 = r114;
        goto L233
    L28:
        r107 = false;
        goto L29
    L25:
        r106 = false;
        goto L26
    }

    @Override // r3a.k
    public final void m(TextureView r100) {
        if (r100 == null) goto L4;
        r100.setSurfaceTextureListener(new c(this));
    L4:
        this.f535912p = r100;
    }

    @Override // r3a.k
    public final void t(final s3a.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        q3a.o r101 = this.f535900d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger.f375446a.i("CameraEventDispatcher", "Dispatching custom event: CameraPushFrameFinishEvent");
        r101.c("onCustomEvent", new q3a.e(r100));
    }

    @Override // r3a.k
    public final void u(float r100) {
        VECameraCapture r101 = this.f535910n;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.zoomV2(r100));
    L6:
        if (r102 != null) goto L9;
    L10:
        q3a.o r103 = this.f535900d;
        if (r102 == null) goto L13;
        int r104 = r102.intValue();
    L14:
        r103.b(new i(r104, "failed_to_zoom_camera, result: " + r102, null));
        FLogger.f375446a.e("CameraContextImpl", "performZoom isZoomIn=$ result=" + r102 + " factory=" + r100);
        return;
    L13:
        r104 = -1;
        goto L14
    L9:
        if (r102.intValue() != 0) goto L10;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static Integer w(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 != 0) goto L5;
        return null;
    L5:
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] == 1) goto L10;
        FLogger.f375446a.e("CameraContextImpl", "compileShader failed: " + GLES20.glGetShaderInfoLog(r102));
        GLES20.glDeleteShader(r102);
        return null;
    L10:
        return Integer.valueOf(r102);
    }

    public static int[] x(int r100, int r101) {
        if (r100 <= 0) goto L9;
        if (r101 <= 0) goto L9;
        float r102 = r100;
        float r103 = r101;
        float r104 = Math.max(720.0f / r102, 1280.0f / r103);
        int r105 = (int) (r102 * r104);
        int r106 = (int) (r103 * r104);
        return new int[]{-((r105 - 720) / 2), -((r106 - 1280) / 2), r105, r106};
    L9:
        return new int[]{0, 0, 720, 1280};
    }

    @Override // r3a.k
    public final void f(float r100, float r101) {
        TextureView r102 = this.f535912p;
        if (r102 == null) goto L13;
        int r103 = r102.getWidth();
        int r104 = r102.getHeight();
        if (r103 == 0) goto L11;
        if (r104 == 0) goto L11;
        Resources r105 = r102.getContext().getResources();
        float r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;
        VECameraCapture r107 = this.f535910n;
        if (r107 == null) goto L14;
        r107.focusAtPoint(r103, r104, r106, (int) r100, (int) r101);
        return;
    L14:
        return;
    L11:
        FLogger.f375446a.w("CameraContextImpl", "performFocus, surfaceView has not been measured.");
        return;
    }

    @Override // r3a.k
    public final boolean p(String r110, CameraOpenScene r111) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Intrinsics.checkNotNullParameter(r111, "scene");
        if (this.f535915s.get() == false) goto L6;
        FLogger.f375446a.w("CameraContextImpl", "Context is cleaned up, cannot open camera");
        return false;
    L6:
        FLogger r100 = FLogger.f375446a;
        r100.i("CameraContextImpl", "Performing open camera operation. from=[" + r110 + "] scene=" + r111);
    L36:
        e = move-exception;
        FLogger.f375446a.e("CameraContextImpl", "Exception opening camera", e);
        return false;
    L8:
        if (this.f535910n != null) goto L10;
        D();     // Catch: Exception -> L36
    L10:
        o r112 = (o) this.f535901e.getValue();     // Catch: Exception -> L36
        boolean r101 = true;
        if (r111 != CameraOpenScene.PRIMARY_START) goto L13;
        boolean r113 = true;
    L14:
        r112.c(r113);     // Catch: Exception -> L36
        VECameraCapture r114 = this.f535910n;     // Catch: Exception -> L36
        if (r114 == null) goto L17;
        Integer r115 = Integer.valueOf(r114.open());     // Catch: Exception -> L36
    L18:
        if (r115 != null) goto L21;
    L22:
        if (r115 != null) goto L25;
    L27:
        r101 = false;
    L28:
        if (r101 == false) goto L30;
        System.currentTimeMillis();     // Catch: Exception -> L36
        r100.i("CameraContextImpl", "exec Camera opened successfully");     // Catch: Exception -> L36
    L40:
        return r101;
    L30:
        q3a.o r102 = this.f535900d;     // Catch: Exception -> L36
        if (r115 == null) goto L33;
        int r103 = r115.intValue();     // Catch: Exception -> L36
    L34:
        r102.b(new i(r103, "failed_to_open_camera, result: " + r115, null));     // Catch: Exception -> L36
        r100.e("CameraContextImpl", "Failed to exec open camera, result: " + r115);     // Catch: Exception -> L36
        goto L40
    L33:
        r103 = -1;
        goto L34
    L25:
        if (r115.intValue() != (-423)) goto L27;
    L21:
        if (r115.intValue() == 0) goto L28;
    L17:
        r115 = null;
        goto L18
    L13:
        r113 = false;
        goto L14
    }

    @Override // r3a.k
    public final boolean r(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        FLogger.f375446a.i("CameraContextImpl", "recreateCaptureForRetry, useCamera2=" + r100 + ", from=" + r101);
        this.f535909m = Boolean.valueOf(r100);     // Catch: Throwable -> L41
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Boolean.valueOf(F("recreateCaptureForRetry_" + r101)));     // Catch: Throwable -> L6
    L8:
        p3a.c r103 = this.f535913q;     // Catch: Throwable -> L41
        r103.f527614d = false;     // Catch: Throwable -> L41
        r103.f527612b = false;     // Catch: Throwable -> L41
        r103.f527615e = false;     // Catch: Throwable -> L41
        VECameraCapture r104 = this.f535910n;     // Catch: Throwable -> L16
        if (r104 == null) goto L13;
        Integer r105 = Integer.valueOf(r104.close());     // Catch: Throwable -> L16
    L14:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L16
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L41
        if (r107 == null) goto L44;
        FLogger.f375446a.e("CameraContextImpl", "close old capture failed when retry", r107);     // Catch: Throwable -> L41
    L44:
        VECameraCapture r108 = this.f535910n;     // Catch: Throwable -> L27
        if (r108 == null) goto L24;
        r108.destroy();     // Catch: Throwable -> L27
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L27
    L29:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);     // Catch: Throwable -> L41
        if (r111 == null) goto L48;
        FLogger.f375446a.e("CameraContextImpl", "destroy old capture failed when retry", r111);     // Catch: Throwable -> L41
    L48:
        B().c();     // Catch: Throwable -> L34
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L41
        if (r113 == null) goto L39;
        FLogger.f375446a.e("CameraContextImpl", "destroy recorder failed when retry", r113);     // Catch: Throwable -> L41
    L39:
        this.f535910n = null;     // Catch: Throwable -> L41
        this.f535914r.set(false);     // Catch: Throwable -> L41
        return D();
    L34:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L41
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L36
    L24:
        r109 = null;
    L27:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L41
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L29
    L13:
        r105 = null;
    L16:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L41
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L18
    L6:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L41
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        FLogger.f375446a.e("CameraContextImpl", "recreateCaptureForRetry failed", th);
        return false;
    }

    public final FloatBuffer G(boolean r100, boolean r101, boolean r102) {
        if (r102 == false) goto L5;
        if (r100 == false) goto L5;
        return this.L;
    L5:
        if (r102 == false) goto L8;
        if (r101 == false) goto L8;
        return this.M;
    L8:
        if (r102 == true) goto L18;
        if (r100 == true) goto L19;
        if (r101 == false) goto L15;
        return this.f535896J;
    L15:
        return this.G;
    L19:
        return this.I;
    L18:
        return this.K;
    }

    @Override // r3a.k
    public final void e(int r100, int r101, VEDisplaySettings.VEDisplayFitMode r102) {
        Intrinsics.checkNotNullParameter(r102, "fitMode");
        if (r100 <= 0) goto L8;
        if (r101 <= 0) goto L9;
        B().b(r100, r101, r102);
        return;
    L9:
        return;
    }

    public f(Activity r100, m r101, Fragment r102, com.larus.voicecall.impl.component.vlm.camera.camera_state.e r103, q3a.o r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "cameraConfig");
        Intrinsics.checkNotNullParameter(r103, "stateManager");
        Intrinsics.checkNotNullParameter(r104, "eventDispatcher");
        this.f535897a = r100;
        this.f535898b = r101;
        this.f535899c = r102;
        this.f535900d = r104;
        Lazy r105 = LazyKt.lazy(new r3a.a(this));
        this.f535901e = r105;
        this.f535902f = LazyKt.lazy(new r3a.b(this));
        Lazy r106 = LazyKt.lazy(new r3a.c(this));
        this.f535903g = r106;
        this.f535904h = LazyKt.lazy(new d());
        if (r101.f535940d == false) goto L5;
        int r107 = 270;
    L6:
        this.f535905i = r107;
        this.f535908l = new AtomicBoolean(false);
        this.f535913q = new p3a.c();
        this.f535914r = new AtomicBoolean(false);
        this.f535915s = new AtomicBoolean(false);
        if (((Boolean) r106.getValue()).booleanValue() == true) goto L9;
    L16:
        r104.a((o) r105.getValue());
        this.F = z(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.G = z(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        this.H = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.I = z(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f});
        this.f535896J = z(new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.K = z(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f});
        this.L = z(new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f});
        this.M = z(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        return;
    L9:
        if (this.f535906j != null) goto L16;
        this.f535907k = C();
        h r108 = new h(this, getActivity().getApplicationContext());
        if (r108.canDetectOrientation() == false) goto L14;
        r108.enable();
    L15:
        this.f535906j = r108;
        goto L16
    L14:
        FLogger.f375446a.w("CameraContextImpl", "gravity orientation listener can not detect orientation");
        goto L15
    L5:
        r107 = 90;
        goto L6
    }
}
