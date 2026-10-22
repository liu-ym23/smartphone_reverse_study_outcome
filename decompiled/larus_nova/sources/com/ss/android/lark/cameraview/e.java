package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.camera_export.CameraFG;
import com.ss.android.lark.camera_export.CameraMonitor;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.camera_export.CameraResolution;
import com.ss.android.lark.camera_export.CameraSettings;
import com.ss.android.lark.cameraexport.CameraLaunchMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.vesdk.VEAudioCapture;
import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.VEAudioEncodeSettings;
import com.ss.android.vesdk.VECameraCapture;
import com.ss.android.vesdk.VECameraSettings;
import com.ss.android.vesdk.VECommonCallback;
import com.ss.android.vesdk.VEDisplaySettings;
import com.ss.android.vesdk.VEEditor;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VEPreviewSettings;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESDK;
import com.ss.android.vesdk.VESize;
import com.ss.android.vesdk.VEVideoEncodeSettings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile e f410943w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f410944x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f410945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f410946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c1 f410947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0b.c f410948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CameraParam f410949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f410950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f410951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f410952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f410953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f410954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f410955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f410956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SensorManager f410957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VECameraCapture f410958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VERecorder f410959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public VEAudioCapture f410960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f410961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f410962r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f410963s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public z0 f410964t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f410965u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f410966v;

    public class a implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f410967a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
        }

        public a(e r100) {
            this.f410967a = r100;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r110) {
            if (1 == r110.sensor.getType()) goto L5;
            return;
        L5:
            float[] r100 = r110.values;
            int r101 = 270;
            int r102 = 180;
            if (this.f410967a.f() == false) goto L17;
            float r103 = r100[0];
            float r104 = r100[1];
            int r105 = this.f410967a.f410953i;
            double r106 = r103;
            double r107 = r104;
            if (Math.hypot(r106, r107) < 4.0d) goto L31;
            double r108 = (360.0d - Math.toDegrees(Math.atan2(r106, r107))) % 360.0d;
            if (r108 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            r108 = r108 + 360.0d;
        L13:
            long r109 = Math.round(r108 / 90.0d) * 90;
            if (Math.abs(r108 - r109) > 35.0d) goto L31;
            r105 = (int) (r109 % 360);
        L31:
            e r111 = this.f410967a;
            if (r111.f410953i == r105) goto L67;
            r111.f410953i = r105;
            Log.i("CameraInterface", "onSensorChanged, angle = " + this.f410967a.f410953i);
            e r112 = this.f410967a;
            ImageView r113 = r112.f410945a;
            if (r113 == null) goto L69;
            int r114 = r112.f410955k;
            int r115 = r112.f410953i;
            if (r114 != r115) goto L39;
            return;
        L39:
            if (r114 == 0) goto L58;
            if (r114 == 90) goto L53;
            if (r114 == 180) goto L49;
            if (r114 != 270) goto L60;
            if (r115 == 0) goto L48;
            if (r115 != 180) goto L48;
            r101 = 180;
            r102 = 90;
        L65:
            float r116 = r102;
            float r117 = r101;
            ObjectAnimator r118 = ObjectAnimator.ofFloat(r113, "rotation", new float[]{r116, r117});
            ObjectAnimator r119 = ObjectAnimator.ofFloat(r112.f410946b, "rotation", new float[]{r116, r117});
            AnimatorSet r120 = new AnimatorSet();
            r120.playTogether(new Animator[]{r118, r119});
            r120.setDuration(500);
            r120.start();
            r112.f410955k = r112.f410953i;
            return;
        L48:
            r102 = 90;
        L61:
            r101 = 0;
        L60:
            r102 = 0;
            goto L61
        L49:
            if (r115 == 90) goto L65;
            if (r115 != 270) goto L61;
            r101 = 90;
            goto L65
        L53:
            if (r115 == 0) goto L57;
            if (r115 != 180) goto L57;
            r101 = -180;
            r102 = -90;
        L57:
            r102 = -90;
            goto L61
        L58:
            if (r115 == 90) goto L63;
            if (r115 != 270) goto L60;
            int r121 = 90;
        L64:
            r101 = r121;
            r102 = 0;
            goto L65
        L63:
            r121 = -90;
            goto L64
        L69:
            return;
        L67:
            return;
        L17:
            float r122 = r100[0];
            float r123 = r100[1];
            if (Math.abs(r122) <= Math.abs(r123)) goto L26;
            if (r122 <= 4.0f) goto L23;
            r105 = 270;
            goto L31
        L23:
            if (r122 >= (-4.0f)) goto L27;
            r105 = 90;
        L27:
            r105 = 0;
            goto L31
        L26:
            if (r123 > 7.0f) goto L27;
            if (r123 >= (-7.0f)) goto L27;
            r105 = 180;
            goto L31
        }
    }

    public class b implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CameraParam f410968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f410969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VESize f410970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VEVideoEncodeSettings f410971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f410972e;

        public class a implements VEListener.VECallListener {
            @Override // com.ss.android.vesdk.VEListener.VECallListener
            public final void onDone(int r100) {
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.cameraview.e$b$b, reason: collision with other inner class name */
        public class C4777b implements VEListener.VECallListener {
            @Override // com.ss.android.vesdk.VEListener.VECallListener
            public final void onDone(int r100) {
            }

            public C4777b() {
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            VECameraCapture r101 = this.f410972e.f410958n;
            if (r101 == null) goto L6;
            r101.open(f0b.a.f475017b);
        L6:
            if (this.f410972e.f410959o == null) goto L12;
            if (this.f410968a.isNewVeCamera() == false) goto L10;
            VEDisplaySettings r102 = new VEDisplaySettings.Builder().setDisplayRotation(0).build();
            this.f410972e.f410959o.setDisplaySettings(r102);
        L10:
            this.f410972e.f410959o.startPreviewAsync(null, new a());
            this.f410972e.f410959o.changeSurface(r100.getSurface());
        L12:
            if (this.f410972e.f() == false) goto L15;
            e r103 = this.f410972e;
            r103.f410947c = new c1((FragmentActivity) this.f410969b);
            this.f410972e.d(this.f410969b);
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            VECameraCapture r101 = this.f410972e.f410958n;
            if (r101 == null) goto L5;
            r101.close();
        L5:
            VERecorder r102 = this.f410972e.f410959o;
            if (r102 == null) goto L9;
            r102.stopPreviewAsync(new C4777b());
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            VERecorder r104 = this.f410972e.f410959o;
            if (r104 == null) goto L26;
            r104.changeSurface(r100.getSurface());
            if (this.f410972e.f() == false) goto L27;
            int r105 = this.f410972e.f410947c.f410877b;
            FragmentActivity r106 = (FragmentActivity) this.f410969b;
            Intrinsics.checkNotNullParameter(r106, "activity");
            int r107 = r106.getWindowManager().getDefaultDisplay().getRotation();
            if (r107 == 0) goto L17;
            if (r107 != 1) goto L10;
            int r108 = 90;
        L18:
            CameraFG.getEnableAdaptPadAndFoldable();
            int r109 = (360 - (((r108 - r105) + 360) % 360)) % 360;
            if (r109 == 90) goto L23;
            if (r109 == 270) goto L23;
            VESize r110 = this.f410970c;
        L24:
            VEDisplaySettings r111 = new VEDisplaySettings.Builder().setRenderSize(r110).setDisplayRotation(r109).build();
            this.f410972e.f410959o.setDisplaySettings(r111);
            VEVideoEncodeSettings r112 = new VEVideoEncodeSettings.Builder(1, this.f410971d).setRotate(r109).build();
            this.f410972e.f410959o.changeVideoEncodeSettings(r112);
            e r113 = this.f410972e;
            r113.f410961q = r110.width;
            r113.f410962r = r110.height;
            return;
        L23:
            VESize r114 = this.f410970c;
            r110 = new VESize(r114.height, r114.width);
            goto L24
        L10:
            if (r107 != 2) goto L12;
            r108 = 180;
            goto L18
        L12:
            if (r107 != 3) goto L17;
            r108 = 270;
        L17:
            r108 = 0;
            goto L18
        L27:
            return;
        }

        public b(e r100, CameraParam r101, Context r102, VESize r103, VEVideoEncodeSettings r104) {
            this.f410972e = r100;
            this.f410968a = r101;
            this.f410969b = r102;
            this.f410970c = r103;
            this.f410971d = r104;
        }
    }

    public class c implements VECommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f410973a;

        @Override // com.ss.android.vesdk.VECommonCallback
        public final /* synthetic */ void onCallBackForTrack(int r100, int r101, float r102, long r103) {
            VECommonCallback.CC.$default$onCallBackForTrack(this, r100, r101, r102, r103);
        }

        public c(e r100) {
            this.f410973a = r100;
        }

        @Override // com.ss.android.vesdk.VECommonCallback
        public final void onCallback(int r100, int r101, float r102, String r103) {
            if (r100 != 1000) goto L22;
            Log.i("CameraInterface", "onInfo, render created start preview");
            e r104 = this.f410973a;
            VERecorder r105 = r104.f410959o;
            if (r105 == null) goto L33;
            r105.startCameraPreview(r104.f410958n);
            Bundle r106 = this.f410973a.f410958n.getCameraAllFeatures(LarkContext.getApplication());
            int r107 = f0b.d.f475022a;
            ArrayList r108 = new ArrayList();
            if (r106 != null) goto L30;
            Serializable r109 = null;
        L12:
            List r110 = (List) r109;     // Catch: Exception -> L9
            if (r110 == null) goto L20;
            Iterator r111 = r110.iterator();     // Catch: Exception -> L9
        L15:
            if (r111.hasNext() == false) goto L20;
            TEFrameSizei r112 = (TEFrameSizei) r111.next();     // Catch: Exception -> L9
            r108.add(new Pair(Integer.valueOf(r112.width), Integer.valueOf(r112.height)));     // Catch: Exception -> L9
        L9:
            e = move-exception;
            Log.e("VECameraUtils", "getCameraSupportPreviewSizes:" + e);
        L20:
            CameraMonitor.reportCameraSupportPreviewSizes(r108);
            return;
        L30:
            r109 = r106.getSerializable(TECameraSettings.Features.SUPPORT_PREVIEW_SIZES);     // Catch: Exception -> L9
            goto L12
        L33:
            return;
        L22:
            if (r100 != 1001) goto L27;
            Log.i("CameraInterface", "onInfo, render destroyed stop preview");
            VECameraCapture r113 = this.f410973a.f410958n;
            if (r113 == null) goto L35;
            r113.stopPreview();
            return;
        L35:
            return;
        L27:
            if (r100 != VEInfo.TE_INFO_PREVIEW_FIRST_FRAME_SCREEN) goto L37;
            CameraLaunchMonitor.onOpenCameraEnd(CameraParam.TYPE_VE_CAMERA);
            return;
        }
    }

    public interface d {
        void a();
    }

    /* JADX INFO: renamed from: com.ss.android.lark.cameraview.e$e, reason: collision with other inner class name */
    public interface InterfaceC4778e {
    }

    public interface f {
        void a(Bitmap r100);
    }

    public final void b() {
        if (this.f410959o != null) goto L5;
    L7:
        boolean r100 = true;
        if (this.f410958n == null) goto L10;
        boolean r101 = true;
    L12:
        if (this.f410959o == null) goto L14;
        boolean r102 = true;
    L16:
        if (this.f410960p != null) goto L19;
        r100 = false;
    L19:
        Log.i("CameraInterface", "destroyVECamera, needCloseCamera: " + r101 + ", needDestroyRecorder: " + r102 + ", needReleaseAudio: " + r100);
        if (r101 == false) goto L22;
        this.f410958n.close(this.f410963s);
        this.f410958n.destroy();
    L22:
        if (r102 == false) goto L24;
        Log.i("CameraInterface", "destroyVECamera");
        this.f410959o.onDestroy();
    L24:
        if (r100 == false) goto L26;
        this.f410960p.stop();
        this.f410960p.release();
    L26:
        VESDK.enableRefactorRecorder(false);
        this.f410947c = null;
        this.f410958n = null;
        this.f410959o = null;
        this.f410960p = null;
        this.f410948d = null;
        this.f410945a = null;
        this.f410946b = null;
        return;
    L14:
        r102 = false;
        goto L16
    L10:
        r101 = false;
        goto L12
    L5:
        if (this.f410958n == null) goto L7;
        Log.i("CameraInterface", "do StopPreview");
        this.f410958n.stopPreview();
        goto L7
    }

    public final void c() {
        if (this.f410959o == null) goto L6;
        Log.i("CameraInterface", "do StartPreview");
        this.f410959o.startCameraPreview(this.f410958n);
        return;
    }

    public e() {
        this.f410950f = -1;
        this.f410951g = -1;
        this.f410952h = -1;
        int r100 = 0;
        this.f410953i = 0;
        this.f410954j = 90;
        this.f410955k = 0;
        this.f410957m = null;
        this.f410963s = true;
        this.f410965u = null;
        this.f410966v = new a(this);
        Camera.CameraInfo r101 = new Camera.CameraInfo();
        int r102 = Camera.getNumberOfCameras();
    L3:
        if (r100 >= r102) goto L14;
        Camera.getCameraInfo(r100, r101);     // Catch: RuntimeException -> L11
        int r103 = r101.facing;
        if (r103 == 0) goto L10;
        if (r103 != 1) goto L13;
        this.f410952h = r103;
    L13:
        r100 = r100 + 1;
        goto L3
    L10:
        this.f410951g = r103;
    L11:
        e = move-exception;
        Log.e("CameraInterface", "custom_error=lark_crash_camera_get_info_guarded, cameraId=" + r100 + ", cameraNum=" + r102 + ", manufacturer=" + Build.MANUFACTURER + ", model=" + Build.MODEL + ", sdk=" + Build.VERSION.SDK_INT, e);
        goto L13
    L14:
        this.f410950f = this.f410951g;
    }

    public final boolean f() {
        if (CameraFG.getEnableAdaptPadAndFoldable() == false) goto L9;
        CameraParam r100 = this.f410949e;
        if (r100 == null) goto L9;
        if (r100.isNewVeCamera() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final void d(Context r100) {
        int r101 = f0b.b.f475020a;
        f0b.b r102 = f0b.b.C5846b.f475021a;
        int r103 = this.f410950f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Camera.CameraInfo r104 = new Camera.CameraInfo();
        Camera.getCameraInfo(r103, r104);     // Catch: Exception -> L5
    L7:
        Object r105 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.WindowManager");
        int r106 = ((WindowManager) r105).getDefaultDisplay().getRotation();
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L11;
        int r107 = 90;
    L20:
        if (r104.facing != 1) goto L22;
        int r108 = (360 - ((r104.orientation + r107) % 360)) % 360;
    L23:
        this.f410954j = r108;
        return;
    L22:
        r108 = ((r104.orientation - r107) + 360) % 360;
        goto L23
    L11:
        if (r106 != 2) goto L13;
        r107 = 180;
        goto L20
    L13:
        if (r106 != 3) goto L18;
        r107 = 270;
    L18:
        r107 = 0;
    L5:
        e = move-exception;
        Log.e("JCameraView", e.getMessage());
        goto L7
    }

    public final void g(Context r100) {
        if (this.f410957m != null) goto L10;
        this.f410957m = (SensorManager) r100.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);
    L10:
        int r101 = tf7.a.f545762a;     // Catch: SensitiveAPIException -> L7
        this.f410957m.registerListener(this.f410966v, tf7.a.a(this.f410957m, 1, f0b.a.f475016a), 3);     // Catch: SensitiveAPIException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("CameraInterface", "registerSensorManager error, e:" + e);
    }

    public final void h(Context r100) {
        if (this.f410957m != null) goto L5;
        this.f410957m = (SensorManager) r100.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);
    L5:
        SensorManager r101 = this.f410957m;
        a r102 = this.f410966v;
        if (fna.g.d() == true) goto L8;
        r101.unregisterListener(r102);
    L13:
        this.f410957m = null;
        return;
    L8:
        r101.unregisterListener(r102);
        if (r102 == null) goto L11;
        int r103 = r102.hashCode();
    L12:
        ona.b.c(new ona.a(r103, null));
        goto L13
    L11:
        r103 = 0;
        goto L12
    }

    public static void a(final e r100, Bitmap r110, final f r111) {
        final Bitmap r112 = Bitmap.createBitmap(r110, 0, 0, r110.getWidth(), r110.getHeight(), r100.f410964t.b(r100.f410956l - 90), true);
        CoreThreadPool.getDefault().getUIExecutor().execute(new com.ss.android.lark.cameraview.d(r100, r111, r112));
    }

    public final void e(Context r110, SurfaceView r111, CameraParam r112) {
        if (this.f410959o == null) goto L5;
        return;
    L5:
        this.f410949e = r112;
        Log.i("CameraInterface", "initVECamera");
        if (f410944x == true) goto L10;
        VESDK.setAssetManagerEnable(true);
        VideoTools.checkToInitSDK();
        VESDK.setEnableStickerAmazing(true);
        VEEditor.setOptConfig(8718368);
        VEEditor.setEnableEffectTransition(true);
        VEEditor.setEnableEffectCanvas(true);
        f410944x = true;
    L10:
        if (com.ss.android.lark.utils.i0.a(r110) == false) goto L12;
        z0 r100 = w0.f411051a;
    L13:
        this.f410964t = r100;
        this.f410947c = new c1((FragmentActivity) r110);
        VESDK.enableRefactorRecorder(true);
        VESDK.enableNewRecorder(true);
        CameraResolution r101 = CameraSettings.getCameraResolution(this.f410949e.getUseHDShoot(), this.f410949e.getUse1080P(), this.f410949e.isNewVeCamera());
        int r102 = 0;
        int[] r103 = {r101.getWidth(), r101.getHeight()};
        c1 r104 = this.f410947c;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "previewSize");
        int r105 = r104.f410876a;
        if (r105 == 90) goto L17;
        if (r105 == 270) goto L17;
        VESize r106 = new VESize(r103[0], r103[1]);
    L18:
        VESize r107 = r106;
        this.f410961q = r107.width;
        this.f410962r = r107.height;
        Log.i("CameraInterface", "picWidth:" + this.f410961q + ", picHeight:" + this.f410962r);
        if (r112.isFrontCamera() == false) goto L23;
        int r108 = this.f410952h;
        if (r108 == (-1)) goto L23;
        this.f410950f = r108;
    L23:
        VECameraSettings.Builder r109 = new VECameraSettings.Builder().setCameraType(VECameraSettings.CAMERA_TYPE.TYPE1);
        if (r112.isFrontCamera() == false) goto L26;
        VECameraSettings.CAMERA_FACING_ID r113 = VECameraSettings.CAMERA_FACING_ID.FACING_FRONT;
    L27:
        VECameraSettings.Builder r114 = r109.setCameraFacing(r113).setPreviewSize(r103[0], r103[1]).setCameraAntiShake(true).setIsUseNewCameraTypeStrategy(true).setMaxWidth(this.f410961q).setUseMaxWidthTakePicture(true);
        int r115 = this.f410947c.f410876a;
        if (r115 == 90) goto L31;
        if (r115 == 270) goto L31;
        String r116 = "portrait";
    L32:
        VECameraSettings r117 = r114.setSceneMode(r116).build();
        VEVideoEncodeSettings r118 = new VEVideoEncodeSettings.Builder(1).setVideoRes(r107.width, r107.height).setSupportHwEnc(true).enableRecordingMp4(true).build();
        VEAudioEncodeSettings r119 = new VEAudioEncodeSettings.Builder().Build();
        VEPreviewSettings r120 = new VEPreviewSettings.Builder().setRenderSize(r107).setAsyncDetection(true).disableEffectInternalSetting(true).enable3buffer(true).blockRenderExit(true).enableEffectRT(true).build();
        this.f410958n = new VECameraCapture();
        this.f410958n.init(r110.getApplicationContext(), r117);
        this.f410958n.open(f0b.a.f475017b);
        ViewGroup.LayoutParams r121 = r111.getLayoutParams();
        int r122 = this.f410947c.f410876a;
        if (r122 == 90) goto L36;
        if (r122 == 270) goto L36;
        int r123 = 0;
    L37:
        r121.width = r123;
        if (r122 == 90) goto L41;
        if (r122 == 270) goto L41;
        r102 = -1;
    L41:
        r121.height = r102;
        r111.setLayoutParams(r121);
        this.f410959o = new VERecorder(f0b.c.a(), r110.getApplicationContext());
        r111.getHolder().addCallback(new b(this, r112, r110, r107, r118));
        this.f410959o.setCommonCallback(new c(this));
        int r124 = this.f410959o.init(null, r118, r119, r120);     // Catch: Exception -> L48
        this.f410959o.enableRecordingMp4(true);     // Catch: Exception -> L48
        if (r124 == 0) goto L56;
        Log.e("CameraInterface", "init record error, ret:" + r124);     // Catch: Exception -> L48
        d0b.c r125 = this.f410948d;     // Catch: Exception -> L48
        if (r125 == null) goto L50;
        r125.onError();     // Catch: Exception -> L48
        return;
    L50:
        return;
    L56:
        if (r112.getMode().equals(CameraParam.MODE_ONLY_PHOTO) == false) goto L58;
        return;
    L58:
        if (CameraFG.isCameraAudioDecouple() == true) goto L60;
        return;
    L60:
        if (this.f410959o == null) goto L69;
        Log.i("CameraInterface", "initAudioCapture");
        this.f410960p = new VEAudioCapture();
        this.f410959o.enableNewAudioCapture(true);
        this.f410960p.addCaptureListener(this.f410959o.getAudioConsumer());
        this.f410960p.init(new VEAudioCaptureSettings.Builder().setAudioDataStore(1).build());
        this.f410960p.start(f0b.a.f475019d);
        return;
    L69:
        return;
    L48:
        e = move-exception;
        d0b.c r126 = this.f410948d;
        if (r126 == null) goto L54;
        r126.onError();
    L54:
        Log.e("CameraInterface", e.getLocalizedMessage());
        e.printStackTrace();
    L36:
        r123 = -1;
    L31:
        r116 = "landscape";
        goto L32
    L26:
        r113 = VECameraSettings.CAMERA_FACING_ID.FACING_BACK;
    L17:
        r106 = new VESize(r103[1], r103[0]);
        goto L18
    L12:
        r100 = com.ss.android.lark.cameraview.a.f410856a;
        goto L13
    }
}
