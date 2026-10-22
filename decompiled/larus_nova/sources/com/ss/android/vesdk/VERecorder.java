package com.ss.android.vesdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bef.effectsdk.message.MessageCenter;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.medialib.model.EnigmaResult;
import com.ss.android.medialib.presenter.IStickerRequestCallback;
import com.ss.android.medialib.presenter.ITEVideoController;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.model.VERenderContext;
import com.ss.android.ttve.model.VETrackParams;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraConfigKey;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.vesdk.algorithm.VEAlgorithmRuntimeParamKey;
import com.ss.android.vesdk.algorithm.VEBachAlgorithmParam;
import com.ss.android.vesdk.algorithm.VEFaceBeautifyDetectExtParam;
import com.ss.android.vesdk.algorithm.VEFaceBeautyDetectExtParam;
import com.ss.android.vesdk.algorithm.VEFaceDetectExtParam;
import com.ss.android.vesdk.algorithm.VEHDRNetDetectExtParam;
import com.ss.android.vesdk.algorithm.VEHandDetectExtParam;
import com.ss.android.vesdk.audio.VEAudioCaptureListener;
import com.ss.android.vesdk.camera.ICameraCapture;
import com.ss.android.vesdk.camera.ICameraPreview;
import com.ss.android.vesdk.clipparam.VEClipTimelineParam;
import com.ss.android.vesdk.effect.IEffect;
import com.ss.android.vesdk.faceinfo.VEFaceAttributeInfo;
import com.ss.android.vesdk.faceinfo.VEFaceDetectInfo;
import com.ss.android.vesdk.faceinfo.VESkeletonInfo;
import com.ss.android.vesdk.filterparam.VEEffectFilterParam;
import com.ss.android.vesdk.lens.VEAdaptiveSharpenParams;
import com.ss.android.vesdk.lens.VEBaseRecorderLensParams;
import com.ss.android.vesdk.lens.VELumaDetectParams;
import com.ss.android.vesdk.lens.VEModelDownload;
import com.ss.android.vesdk.lens.VEOneKeyProcessParams;
import com.ss.android.vesdk.lens.VETaintSceneDetectParams;
import com.ss.android.vesdk.listener.VERetCallback;
import com.ss.android.vesdk.model.BefTextLayout;
import com.ss.android.vesdk.model.BefTextLayoutResult;
import com.ss.android.vesdk.model.VEPrePlayParams;
import com.ss.android.vesdk.model.VERecordPerformanceData;
import com.ss.android.vesdk.runtime.VEMapBufferInfo;
import com.ss.android.vesdk.runtime.VERecorderResManager;
import com.ss.android.vesdk.runtime.VERuntime;
import com.ss.android.vesdk.utils.VEScreenUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VERecorder {
    public static final int CAMERA_TRACK_INDEX = 0;
    public static final int MIC_TRACK_INDEX = 0;
    public static final int RECORD_MODE_CO_RECORD = 2;
    public static final int RECORD_MODE_FAST_RECORD = 0;
    public static final int RECORD_MODE_MULTI_RECORD = 1;
    public static final int RECORD_MODE_NOW = 3;
    public static final int RECORD_TRACK_INDEX = 1;
    private static final String TAG = "VERecorder";
    public static final int VEFASTCV_ALG_LANCZOS = 0;
    private int mFaceBeautifyDetectIndex;
    private VEModelDownload.IModelDownload mModelDownload;
    protected com.ss.android.vesdk.p mRecorder;
    protected VERecorderResManager mResManager;
    private VERuntime mVERuntime;

    public interface DetectListener {
        public static final int DETECT_TYPE_FACE = 0;
        public static final int DETECT_TYPE_HAND = 1;

        void onResult(int r100, int r101);
    }

    public static class FrameConfig {
        public static final int TYPE_EFFECT_CAPTURE_IMAGE = 1;
        public static final int TYPE_NONE = 0;
        public String key;
        public int type;

        public FrameConfig() {
        }
    }

    public interface IBitmapShotScreenCallback {
        void onShotScreen(Bitmap r100, int r101);
    }

    public interface IShotScreenCallback {
        void onShotScreen(int r100);
    }

    public interface IShotScreenOnInfoCallback {
        void onInfo(HashMap<String, String> r100);
    }

    public interface IVEFrameShotScreenCallback {
        void onShotScreen(VEFrame r100, int r101);
    }

    public interface OnARTextBitmapCallback {
        BefTextLayoutResult onBefTextLayoutResult(String r100, BefTextLayout r101);
    }

    public interface OnARTextCallback {
        void onContentResult(String[] r100);

        void onLimitCountResult(int r100);
    }

    public interface OnFrameAvailableListener {
        public static final int FORMAT_I420 = 1;
        public static final int FORMAT_NV21 = 3;
        public static final int FORMAT_TEXTURE_2D = 10;
        public static final int FORMAT_TEXTURE_OES = 11;

        void OnFrameAvailable(EGLContext r100, int r101, int r102, int r103, int r104, long r105);

        boolean shouldFrameRendered();
    }

    public interface OnFrameAvailableListenerExt {

        public static class Config {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f455638a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f455639b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public VEFrame.ETEPixelFormat f455640c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ReqFrameStage f455641d;

            public static final enum ReqFrameStage extends Enum<ReqFrameStage> {
                public static final ReqFrameStage REQUEST_FRAME_STAGE_CAMERA_INPUT = null;
                public static final ReqFrameStage REQUEST_FRAME_STAGE_RENDERED = null;
                public static final ReqFrameStage REQUEST_FRAME_STAGE_SOURCE = null;

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ ReqFrameStage[] f455642a = null;

                static {
                    ReqFrameStage r100 = new ReqFrameStage("REQUEST_FRAME_STAGE_SOURCE", 0);
                    REQUEST_FRAME_STAGE_SOURCE = r100;
                    ReqFrameStage r101 = new ReqFrameStage("REQUEST_FRAME_STAGE_RENDERED", 1);
                    REQUEST_FRAME_STAGE_RENDERED = r101;
                    ReqFrameStage r102 = new ReqFrameStage("REQUEST_FRAME_STAGE_CAMERA_INPUT", 2);
                    REQUEST_FRAME_STAGE_CAMERA_INPUT = r102;
                    f455642a = new ReqFrameStage[]{r100, r101, r102};
                }

                public static ReqFrameStage[] values() {
                    return (ReqFrameStage[]) f455642a.clone();
                }

                public static ReqFrameStage valueOf(String r100) {
                    return (ReqFrameStage) r27.a.a(ReqFrameStage.class, r100);
                }

                public ReqFrameStage(String r100, int r101) {
                    super(r100, r101);
                }
            }

            public Config() {
                this.f455638a = 0;
                this.f455639b = 0;
                this.f455640c = VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8;
                this.f455641d = ReqFrameStage.REQUEST_FRAME_STAGE_SOURCE;
            }
        }

        void OnFrameAvailable(VEFrame r100);

        Config config();
    }

    public interface OnFrameAvailableListenerNew {
        public static final int FORMAT_I420 = 1;
        public static final int FORMAT_NV21 = 3;
        public static final int FORMAT_TEXTURE_2D = 10;
        public static final int FORMAT_TEXTURE_OES = 11;

        void OnFrameAvailable(EGLContext r100, int r101, int r102, int r103, int r104, long r105, long r106);

        boolean shouldFrameRendered();
    }

    public interface VECameraZoomListener {
        boolean enableSmooth();

        void onChange(int r100, float r101, boolean r102);

        void onZoomSupport(int r100, boolean r101, boolean r102, float r103, List<Integer> r104);
    }

    public interface VECherEffectParamCallback {
        void onCherEffect(String[] r100, double[] r101, boolean[] r102);
    }

    public interface VEEffectAlgorithmCallback {
        public static final int BODY = 16;
        public static final int FACE_DETECT = 1;
        public static final int FACE_TRACK = 32;
        public static final int HAIR = 4;
        public static final int JOINT = 64;
        public static final int MATTING = 2;
        public static final int SLAM = 8;

        void onResult(SparseArray<Long> r100, float r101);
    }

    public interface VEFaceInfoCallback {
        public static final int EYEBROW = 2;
        public static final int EYEINFO = 1;
        public static final int IRIS = 8;
        public static final int LIP = 4;

        void onResult(VEFaceAttributeInfo r100, VEFaceDetectInfo r101);
    }

    public static final enum VEMirrorMode extends Enum<VEMirrorMode> {
        public static final VEMirrorMode NO_MIRROR = null;
        public static final VEMirrorMode X_MIRROR = null;
        public static final VEMirrorMode Y_MIRROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEMirrorMode[] f455643a = null;

        static {
            VEMirrorMode r100 = new VEMirrorMode("NO_MIRROR", 0);
            NO_MIRROR = r100;
            VEMirrorMode r101 = new VEMirrorMode("X_MIRROR", 1);
            X_MIRROR = r101;
            VEMirrorMode r102 = new VEMirrorMode("Y_MIRROR", 2);
            Y_MIRROR = r102;
            f455643a = new VEMirrorMode[]{r100, r101, r102};
        }

        public static VEMirrorMode[] values() {
            return (VEMirrorMode[]) f455643a.clone();
        }

        public static VEMirrorMode valueOf(String r100) {
            return (VEMirrorMode) r27.a.a(VEMirrorMode.class, r100);
        }

        public VEMirrorMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface VERecorderLensCallback {
        void onError(int r100, int r101, String r102);

        void onInfo(int r100, int r101, int r102, String r103);

        void onSuccess(int r100, float r101, int r102);
    }

    public static final enum VERotation extends Enum<VERotation> {
        public static final VERotation Rotation_0 = null;
        public static final VERotation Rotation_180 = null;
        public static final VERotation Rotation_270 = null;
        public static final VERotation Rotation_90 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VERotation[] f455644a = null;

        static {
            VERotation r100 = new VERotation("Rotation_0", 0);
            Rotation_0 = r100;
            VERotation r101 = new VERotation("Rotation_90", 1);
            Rotation_90 = r101;
            VERotation r102 = new VERotation("Rotation_180", 2);
            Rotation_180 = r102;
            VERotation r103 = new VERotation("Rotation_270", 3);
            Rotation_270 = r103;
            f455644a = new VERotation[]{r100, r101, r102, r103};
        }

        public static VERotation[] values() {
            return (VERotation[]) f455644a.clone();
        }

        public static VERotation valueOf(String r100) {
            return (VERotation) r27.a.a(VERotation.class, r100);
        }

        public VERotation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface VESATZoomListener {
        void onChange(int r100, float r101);
    }

    public interface VESkeletonDetectCallback {
        void onResult(VESkeletonInfo r100);
    }

    public interface VESlamDetectListener {
        void onSlam(boolean r100);
    }

    public class a implements IShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEShotScreenSettings f455645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f455646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IShotScreenCallback f455647c;

        @Override // com.ss.android.vesdk.VERecorder.IShotScreenCallback
        public final void onShotScreen(int r100) {
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L16
            String r102 = "vesdk_event_recorder_shot_screen";
            if (this.f455645a.getTargetResolution() == null) goto L6;
            r101.put("width", this.f455645a.getTargetResolution().width);     // Catch: JSONException -> L16
            r101.put("height", this.f455645a.getTargetResolution().height);     // Catch: JSONException -> L16
        L6:
            r101.put("resultCode", r100);     // Catch: JSONException -> L16
            if (this.f455645a.isTakePicture() == false) goto L9;
            r102 = "vesdk_event_recorder_take_picture";
        L9:
            long r103 = System.currentTimeMillis() - this.f455646b;     // Catch: JSONException -> L16
            r101.put("is_effect", this.f455645a.isNeedEffect());     // Catch: JSONException -> L16
            r101.put("duration", r103);     // Catch: JSONException -> L16
            VELogUtil.i(VERecorder.TAG, "VESDK_COST shotScreen0 cost=" + r103);     // Catch: JSONException -> L16
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L13;
            com.ss.android.ttve.monitor.c.a(r102, r101, "business");     // Catch: JSONException -> L16
        L18:
            HashMap<String, String> r104 = new HashMap();
            r104.put("capture_mode", String.valueOf(this.f455645a.isTakePicture()));
            r104.put("enable_effect", String.valueOf(this.f455645a.isNeedEffect()));
            r104.put("camera_photo_size", this.f455645a.getTargetResolution().toString());
            r104.put("total_cost", String.valueOf(System.currentTimeMillis() - this.f455646b));
            r104.put("error_code", String.valueOf(r100));
            IShotScreenCallback r105 = this.f455647c;
            if (r105 == null) goto L22;
            r105.onShotScreen(r100);
        L22:
            if (this.f455645a.getOnInfoCallback() == null) goto L26;
            this.f455645a.getOnInfoCallback().onInfo(r104);
            return;
        L26:
            return;
        L13:
            com.ss.android.ttve.monitor.c.b(r102, r101, "business", false, true);     // Catch: JSONException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            goto L18
        }

        public a(VEShotScreenSettings r100, long r101, IShotScreenCallback r102) {
            this.f455645a = r100;
            this.f455646b = r101;
            this.f455647c = r102;
        }
    }

    public interface a0 {
    }

    public class b implements IBitmapShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEShotScreenSettings f455648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f455649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IBitmapShotScreenCallback f455650c;

        @Override // com.ss.android.vesdk.VERecorder.IBitmapShotScreenCallback
        public final void onShotScreen(Bitmap r100, int r101) {
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L16
            String r103 = "vesdk_event_recorder_shot_screen";
            if (this.f455648a.getTargetResolution() == null) goto L6;
            r102.put("width", this.f455648a.getTargetResolution().width);     // Catch: JSONException -> L16
            r102.put("height", this.f455648a.getTargetResolution().height);     // Catch: JSONException -> L16
        L6:
            r102.put("resultCode", r101);     // Catch: JSONException -> L16
            if (this.f455648a.isTakePicture() == false) goto L9;
            r103 = "vesdk_event_recorder_take_picture";
        L9:
            long r104 = System.currentTimeMillis() - this.f455649b;     // Catch: JSONException -> L16
            r102.put("is_effect", this.f455648a.isNeedEffect());     // Catch: JSONException -> L16
            r102.put("duration", r104);     // Catch: JSONException -> L16
            VELogUtil.i(VERecorder.TAG, "VESDK_COST shotScreen1 cost=" + r104);     // Catch: JSONException -> L16
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L13;
            com.ss.android.ttve.monitor.c.a(r103, r102, "business");     // Catch: JSONException -> L16
        L18:
            HashMap<String, String> r105 = new HashMap();
            r105.put("capture_mode", String.valueOf(this.f455648a.isTakePicture()));
            r105.put("enable_effect", String.valueOf(this.f455648a.isNeedEffect()));
            r105.put("camera_photo_size", this.f455648a.getTargetResolution().toString());
            r105.put("total_cost", String.valueOf(System.currentTimeMillis() - this.f455649b));
            r105.put("error_code", String.valueOf(r101));
            IBitmapShotScreenCallback r106 = this.f455650c;
            if (r106 == null) goto L22;
            r106.onShotScreen(r100, r101);
        L22:
            if (this.f455648a.getOnInfoCallback() == null) goto L26;
            this.f455648a.getOnInfoCallback().onInfo(r105);
            return;
        L26:
            return;
        L13:
            com.ss.android.ttve.monitor.c.b(r103, r102, "business", false, true);     // Catch: JSONException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            goto L18
        }

        public b(VEShotScreenSettings r100, long r101, IBitmapShotScreenCallback r102) {
            this.f455648a = r100;
            this.f455649b = r101;
            this.f455650c = r102;
        }
    }

    public interface b0 {
    }

    public class c implements IVEFrameShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEShotScreenSettings f455651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f455652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IVEFrameShotScreenCallback f455653c;

        @Override // com.ss.android.vesdk.VERecorder.IVEFrameShotScreenCallback
        public final void onShotScreen(VEFrame r100, int r101) {
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L16
            String r103 = "vesdk_event_recorder_shot_screen";
            if (this.f455651a.getTargetResolution() == null) goto L6;
            r102.put("width", this.f455651a.getTargetResolution().width);     // Catch: JSONException -> L16
            r102.put("height", this.f455651a.getTargetResolution().height);     // Catch: JSONException -> L16
        L6:
            r102.put("resultCode", r101);     // Catch: JSONException -> L16
            if (this.f455651a.isTakePicture() == false) goto L9;
            r103 = "vesdk_event_recorder_take_picture";
        L9:
            long r104 = System.currentTimeMillis() - this.f455652b;     // Catch: JSONException -> L16
            r102.put("is_effect", this.f455651a.isNeedEffect());     // Catch: JSONException -> L16
            r102.put("duration", r104);     // Catch: JSONException -> L16
            VELogUtil.i(VERecorder.TAG, "VESDK_COST shotScreen2 cost=" + r104);     // Catch: JSONException -> L16
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L13;
            com.ss.android.ttve.monitor.c.a(r103, r102, "business");     // Catch: JSONException -> L16
        L18:
            HashMap<String, String> r105 = new HashMap();
            r105.put("capture_mode", String.valueOf(this.f455651a.isTakePicture()));
            r105.put("enable_effect", String.valueOf(this.f455651a.isNeedEffect()));
            r105.put("camera_photo_size", this.f455651a.getTargetResolution().toString());
            r105.put("total_cost", String.valueOf(System.currentTimeMillis() - this.f455652b));
            r105.put("error_code", String.valueOf(r101));
            IVEFrameShotScreenCallback r106 = this.f455653c;
            if (r106 == null) goto L22;
            r106.onShotScreen(r100, r101);
        L22:
            if (this.f455651a.getOnInfoCallback() == null) goto L26;
            this.f455651a.getOnInfoCallback().onInfo(r105);
            return;
        L26:
            return;
        L13:
            com.ss.android.ttve.monitor.c.b(r103, r102, "business", false, true);     // Catch: JSONException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            goto L18
        }

        public c(VEShotScreenSettings r100, long r101, IVEFrameShotScreenCallback r102) {
            this.f455651a = r100;
            this.f455652b = r101;
            this.f455653c = r102;
        }
    }

    public interface c0 {
    }

    public class d implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f455654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f455655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f455656c;

        @Override // com.ss.android.vesdk.VERecorder.v
        public final void a(int r100, int r101) {
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L9
            r102.put("width", this.f455655b);     // Catch: JSONException -> L9
            r102.put("height", this.f455656c);     // Catch: JSONException -> L9
            r102.put("tag", "capture");     // Catch: JSONException -> L9
            r102.put("resultCode", r101);     // Catch: JSONException -> L9
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L6;
            com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_shot_screen", r102, "business");     // Catch: JSONException -> L9
        L15:
        L11:
            v r103 = this.f455654a;
            if (r103 == null) goto L18;
            r103.a(r100, r101);
            return;
        L18:
            return;
        L6:
            com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_shot_screen", r102, "business", false, true);     // Catch: JSONException -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L11
        }

        @Override // com.ss.android.vesdk.VERecorder.v
        public final void b(int r100, int r101) {
            v r102 = this.f455654a;
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }

        @Override // com.ss.android.vesdk.VERecorder.v
        public final void c(Bitmap r100, VEFrame r101) {
            v r102 = this.f455654a;
            if (r102 == null) goto L6;
            r102.c(r100, r101);
            return;
        }

        public d(v r100, int r101, int r102) {
            this.f455654a = r100;
            this.f455655b = r101;
            this.f455656c = r102;
        }
    }

    public interface d0 {
    }

    public class e implements VEListener.VECallListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEListener.VECallListener f455657a;

        public e(VEListener.VECallListener r100) {
            this.f455657a = r100;
        }

        @Override // com.ss.android.vesdk.VEListener.VECallListener
        public final void onDone(int r100) {
            VEListener.VECallListener r101 = this.f455657a;
            if (r101 == null) goto L10;
            r101.onDone(r100);
        L10:
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
            r102.put("resultCode", r100);     // Catch: JSONException -> L7
            com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_start_preview_async", r102, "business");     // Catch: JSONException -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public interface e0 {
    }

    public class f implements jic.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f455658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VERecorder f455659b;

        public class a implements VEListener.VECallListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f455660a;

            public a(f r100) {
                this.f455660a = r100;
            }

            @Override // com.ss.android.vesdk.VEListener.VECallListener
            public final void onDone(int r100) {
                com.ss.android.ttve.monitor.i.f(0, "te_record_preview_radio_switch_time", System.currentTimeMillis() - this.f455660a.f455658a);
            }
        }

        @Override // jic.f
        public final void a(Surface r100) {
        }

        @Override // jic.f
        public final void c(Surface r100) {
        }

        public f(VERecorder r100, long r101) {
            this.f455659b = r100;
            this.f455658a = r101;
        }

        @Override // jic.f
        public final void b(Surface r100, int r101, int r102, int r103) {
            this.f455659b.mRecorder.startPreviewAsync(r100, new a(this));
            this.f455659b.mRecorder.getRenderView().f499273d.e(this);
        }
    }

    public interface f0 {
    }

    public class g implements VEListener.VECallListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f455661a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f455662a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f455662a.f455661a.requestLayout();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(g r100) {
                this.f455662a = r100;
            }
        }

        public g(View r100) {
            this.f455661a = r100;
        }

        @Override // com.ss.android.vesdk.VEListener.VECallListener
        public final void onDone(int r100) {
            this.f455661a.post(new a(this));
        }
    }

    public interface g0 {
    }

    public class h implements VEListener.VECameraStateExtListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEListener.VECameraStateListener f455663a;

        @Override // com.ss.android.vesdk.VEListener.VECameraStateExtListener
        public final void onError(int r100, String r101) {
        }

        @Override // com.ss.android.vesdk.VEListener.VECameraStateExtListener
        public final void onInfo(int r100, int r101, String r102) {
        }

        @Override // com.ss.android.vesdk.VEListener.VECameraStateExtListener
        public final /* synthetic */ void onInfoForTrack(int r100, int r101, String r102, long r103) {
            VEListener.VECameraStateExtListener.CC.$default$onInfoForTrack(this, r100, r101, r102, r103);
        }

        @Override // com.ss.android.vesdk.VEListener.VECameraStateListener
        public final void cameraOpenSuccess() {
            VEListener.VECameraStateListener r100 = this.f455663a;
            if (r100 == null) goto L6;
            r100.cameraOpenSuccess();
            return;
        }

        public h(VEListener.VECameraStateListener r100) {
            this.f455663a = r100;
        }

        @Override // com.ss.android.vesdk.VEListener.VECameraStateListener
        public final void cameraOpenFailed(int r100) {
            VEListener.VECameraStateListener r101 = this.f455663a;
            if (r101 == null) goto L6;
            r101.cameraOpenFailed(r100);
            return;
        }
    }

    public interface h0 {
    }

    public class i implements OnFrameAvailableListenerExt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnFrameAvailableListener f455664a;

        @Override // com.ss.android.vesdk.VERecorder.OnFrameAvailableListenerExt
        public final OnFrameAvailableListenerExt.Config config() {
            OnFrameAvailableListenerExt.Config r100 = new OnFrameAvailableListenerExt.Config();
            r100.f455640c = VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8;
            OnFrameAvailableListener r101 = this.f455664a;
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            r100.f455641d = OnFrameAvailableListenerExt.Config.ReqFrameStage.REQUEST_FRAME_STAGE_RENDERED;
        L11:
            return r100;
        L10:
            r100.f455641d = OnFrameAvailableListenerExt.Config.ReqFrameStage.REQUEST_FRAME_STAGE_CAMERA_INPUT;
            goto L11
        L5:
            if (r101.shouldFrameRendered() == false) goto L7;
            r102 = true;
            goto L8
        }

        public i(OnFrameAvailableListener r100) {
            this.f455664a = r100;
        }

        @Override // com.ss.android.vesdk.VERecorder.OnFrameAvailableListenerExt
        public final void OnFrameAvailable(VEFrame r110) {
            if (this.f455664a != null) goto L5;
            return;
        L5:
            if (r110 != null) goto L7;
        L9:
            if (r110 != null) goto L11;
        L13:
            this.f455664a.OnFrameAvailable(null, 0, 10, 0, 0, 0);
            return;
        L11:
            if (r110.getFormat() != VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_OES) goto L13;
            VEFrame.TextureFrame r100 = (VEFrame.TextureFrame) r110.getFrame();
            this.f455664a.OnFrameAvailable(r100.getContext(), r100.f449899b, 11, r110.getWidth(), r110.getHeight(), r110.getTimeStamp());
            return;
        L7:
            if (r110.getFormat() != VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8) goto L9;
            VEFrame.TextureFrame r101 = (VEFrame.TextureFrame) r110.getFrame();
            this.f455664a.OnFrameAvailable(r101.getContext(), r101.f449899b, 10, r110.getWidth(), r110.getHeight(), r110.getTimeStamp());
        }
    }

    public class j implements OnFrameAvailableListenerExt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnFrameAvailableListenerNew f455665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VERecorder f455666b;

        @Override // com.ss.android.vesdk.VERecorder.OnFrameAvailableListenerExt
        public final OnFrameAvailableListenerExt.Config config() {
            OnFrameAvailableListenerExt.Config r100 = new OnFrameAvailableListenerExt.Config();
            r100.f455640c = VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8;
            OnFrameAvailableListenerNew r101 = this.f455665a;
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            r100.f455641d = OnFrameAvailableListenerExt.Config.ReqFrameStage.REQUEST_FRAME_STAGE_RENDERED;
        L11:
            return r100;
        L10:
            r100.f455641d = OnFrameAvailableListenerExt.Config.ReqFrameStage.REQUEST_FRAME_STAGE_CAMERA_INPUT;
            goto L11
        L5:
            if (r101.shouldFrameRendered() == false) goto L7;
            r102 = true;
            goto L8
        }

        @Override // com.ss.android.vesdk.VERecorder.OnFrameAvailableListenerExt
        public final void OnFrameAvailable(VEFrame r210) {
            if (this.f455665a != null) goto L5;
            return;
        L5:
            long r100 = 0;
            if (r210 != null) goto L8;
        L13:
            if (r210 != null) goto L15;
        L20:
            this.f455665a.OnFrameAvailable(null, 0, 10, 0, 0, 0, 0);
            return;
        L15:
            if (r210.getFormat() != VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_OES) goto L20;
            VEFrame.TextureFrame r101 = (VEFrame.TextureFrame) r210.getFrame();
            OnFrameAvailableListenerNew r102 = this.f455665a;
            EGLContext r103 = r101.getContext();
            int r104 = r101.f449899b;
            int r105 = r210.getWidth();
            int r106 = r210.getHeight();
            long r110 = r210.getTimeStamp();
            com.ss.android.vesdk.p r107 = this.f455666b.mRecorder;
            if (r107 == null) goto L19;
            r100 = r107.getSegmentFrameTimeUS();
        L19:
            r102.OnFrameAvailable(r103, r104, 11, r105, r106, r110, r100);
            return;
        L8:
            if (r210.getFormat() != VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8) goto L13;
            VEFrame.TextureFrame r108 = (VEFrame.TextureFrame) r210.getFrame();
            OnFrameAvailableListenerNew r109 = this.f455665a;
            EGLContext r111 = r108.getContext();
            int r112 = r108.f449899b;
            int r113 = r210.getWidth();
            int r114 = r210.getHeight();
            long r115 = r210.getTimeStamp();
            com.ss.android.vesdk.p r116 = this.f455666b.mRecorder;
            if (r116 == null) goto L12;
            r100 = r116.getSegmentFrameTimeUS();
        L12:
            r109.OnFrameAvailable(r111, r112, 10, r113, r114, r115, r100);
        }

        public j(VERecorder r100, OnFrameAvailableListenerNew r101) {
            this.f455666b = r100;
            this.f455665a = r101;
        }
    }

    public class k implements VEGetFrameSettings.IGetFrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEGetFrameSettings f455667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f455668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VEGetFrameSettings.IGetFrameCallback f455669c;

        @Override // com.ss.android.vesdk.VEGetFrameSettings.IGetFrameCallback
        public final void onResult(VEFrame r100, int r101) {
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L12
            if (this.f455667a.getTargetResolution() == null) goto L6;
            r102.put("width", this.f455667a.getTargetResolution().width);     // Catch: JSONException -> L12
            r102.put("height", this.f455667a.getTargetResolution().height);     // Catch: JSONException -> L12
        L6:
            if (this.f455667a.getGetFrameType().equals(VEGetFrameSettings.VEGetFrameType.NORMAL_GET_FRAME_MODE) == false) goto L8;
        L9:
            r102.put("is_effect", this.f455667a.getEffectType().equals(VEGetFrameSettings.VEGetFrameEffectType.NO_EFFECT));     // Catch: JSONException -> L12
            r102.put("duration", System.currentTimeMillis() - this.f455668b);     // Catch: JSONException -> L12
        L10:
            r102.put("resultCode", r101);     // Catch: JSONException -> L12
            com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_shot_screen", r102, "business");     // Catch: JSONException -> L12
        L14:
            this.f455669c.onResult(r100, r101);
            return;
        L8:
            if (this.f455667a.getGetFrameType().equals(VEGetFrameSettings.VEGetFrameType.HD_GET_FRAME_MODE) == false) goto L10;
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public k(VEGetFrameSettings r100, long r101, VEGetFrameSettings.IGetFrameCallback r102) {
            this.f455667a = r100;
            this.f455668b = r101;
            this.f455669c = r102;
        }

        @Override // com.ss.android.vesdk.VEGetFrameSettings.IGetFrameCallback
        public final void onResult(int[] r100, int r101, int r102) {
            HashMap<String, String> r103 = new HashMap();
            r103.put("capture_mode", String.valueOf(this.f455667a.getGetFrameType().ordinal()));
            r103.put("enable_effect", String.valueOf(this.f455667a.getEffectType().ordinal()));
            r103.put("camera_photo_size", this.f455667a.getTargetResolution().toString());
            r103.put("total_cost", String.valueOf(System.currentTimeMillis() - this.f455668b));
            this.f455669c.onResult(r100, r101, r102);
            if (this.f455667a.getGetFrameOnInfoCallback() == null) goto L6;
            this.f455667a.getGetFrameOnInfoCallback().onInfo(r103);
            return;
        }
    }

    public class l implements VEModelDownload.VEModelDownloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VETaintSceneDetectParams f455670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VERecorderLensCallback f455671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VERecorder f455672c;

        @Override // com.ss.android.vesdk.lens.VEModelDownload.VEModelDownloadCallback
        public final void onError(String r100) {
            VELogUtil.e(VERecorder.TAG, "get model path failure!");
        }

        @Override // com.ss.android.vesdk.lens.VEModelDownload.VEModelDownloadCallback
        public final void onSuccess(String r100) {
            VETaintSceneDetectParams r101 = this.f455670a;
            r101.modelPath = r100;
            this.f455672c.mRecorder.setLensParams(r101, this.f455671b);
        }

        public l(VERecorder r100, VETaintSceneDetectParams r101, VERecorderLensCallback r102) {
            this.f455672c = r100;
            this.f455670a = r101;
            this.f455671b = r102;
        }
    }

    public static /* synthetic */ class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f455673a = null;

        static {
            int[] r100 = new int[VEPreviewRadio.values().length];
            f455673a = r100;
            r100[VEPreviewRadio.RADIO_9_16.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f455673a[VEPreviewRadio.RADIO_3_4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f455673a[VEPreviewRadio.RADIO_1_1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f455673a[VEPreviewRadio.RADIO_ROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f455673a[VEPreviewRadio.RADIO_FULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class n implements VEListener.VECallListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f455674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VEListener.VECallListener f455675b;

        @Override // com.ss.android.vesdk.VEListener.VECallListener
        public final void onDone(int r100) {
            JSONObject r101 = new JSONObject();
            r101.put("rate", this.f455674a);     // Catch: JSONException -> L10
            r101.put("resultCode", r100);     // Catch: JSONException -> L10
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
            com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_start_record_async", r101, "business");     // Catch: JSONException -> L10
        L16:
        L12:
            VEListener.VECallListener r102 = this.f455675b;
            if (r102 == null) goto L19;
            r102.onDone(r100);
            return;
        L19:
            return;
        L7:
            com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_start_record_async", r101, "business", false, true);     // Catch: JSONException -> L10
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        }

        public n(float r100, VEListener.VECallListener r101) {
            this.f455674a = r100;
            this.f455675b = r101;
        }
    }

    public class o implements VEListener.VECallListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEListener.VECallListener f455676a;

        public o(VEListener.VECallListener r100) {
            this.f455676a = r100;
        }

        @Override // com.ss.android.vesdk.VEListener.VECallListener
        public final void onDone(int r100) {
            JSONObject r101 = new JSONObject();
            r101.put("resultCode", r100);     // Catch: JSONException -> L10
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
            com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_record_finish", r101, "business");     // Catch: JSONException -> L10
        L16:
        L12:
            VEListener.VECallListener r102 = this.f455676a;
            if (r102 == null) goto L19;
            r102.onDone(r100);
            return;
        L19:
            return;
        L7:
            com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_record_finish", r101, "business", false, true);     // Catch: JSONException -> L10
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        }
    }

    public class p implements VEListener.VECallListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f455677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f455678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f455679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f455680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ VEListener.VEConcatListener f455681e;

        @Override // com.ss.android.vesdk.VEListener.VECallListener
        public final void onDone(int r100) {
            if (VEFileUtils.exists(this.f455677a) == false) goto L5;
        L12:
            VEListener.VEConcatListener r101 = this.f455681e;
            if (r101 == null) goto L16;
            r101.onDone(r100, this.f455677a, this.f455679c);
            return;
        L16:
            return;
        L5:
            if (VEFileUtils.exists(this.f455678b) == false) goto L12;
            VEFileUtils.renameFile(this.f455678b, this.f455677a);
            if (VEFileUtils.exists(this.f455679c) == false) goto L9;
        L11:
            TELogUtils.i(VERecorder.TAG, "Concat failed. Restore concat file.");
            goto L12
        L9:
            if (VEFileUtils.exists(this.f455680d) == false) goto L11;
            VEFileUtils.renameFile(this.f455680d, this.f455679c);
            goto L11
        }

        public p(String r100, String r101, String r102, String r103, VEListener.VEConcatListener r104) {
            this.f455677a = r100;
            this.f455678b = r101;
            this.f455679c = r102;
            this.f455680d = r103;
            this.f455681e = r104;
        }
    }

    public class q implements IShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f455682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f455683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f455684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f455685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f455686e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IShotScreenCallback f455687f;

        @Override // com.ss.android.vesdk.VERecorder.IShotScreenCallback
        public final void onShotScreen(int r100) {
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L12
            String r102 = "vesdk_event_recorder_shot_screen";
            r101.put("width", this.f455682a);     // Catch: JSONException -> L12
            r101.put("height", this.f455683b);     // Catch: JSONException -> L12
            r101.put("resultCode", r100);     // Catch: JSONException -> L12
            if (this.f455684c == false) goto L5;
            r102 = "vesdk_event_recorder_take_picture";
        L5:
            r101.put("is_effect", this.f455685d);     // Catch: JSONException -> L12
            r101.put("duration", System.currentTimeMillis() - this.f455686e);     // Catch: JSONException -> L12
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L9;
            com.ss.android.ttve.monitor.c.a(r102, r101, "business");     // Catch: JSONException -> L12
        L16:
        L14:
            this.f455687f.onShotScreen(r100);
            return;
        L9:
            com.ss.android.ttve.monitor.c.b(r102, r101, "business", false, true);     // Catch: JSONException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public q(int r100, int r101, boolean r102, boolean r103, long r104, IShotScreenCallback r105) {
            this.f455682a = r100;
            this.f455683b = r101;
            this.f455684c = r102;
            this.f455685d = r103;
            this.f455686e = r104;
            this.f455687f = r105;
        }
    }

    public class r implements IShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f455688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f455689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f455690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f455691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f455692e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IShotScreenCallback f455693f;

        @Override // com.ss.android.vesdk.VERecorder.IShotScreenCallback
        public final void onShotScreen(int r100) {
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L12
            String r102 = "vesdk_event_recorder_shot_screen";
            r101.put("width", this.f455688a);     // Catch: JSONException -> L12
            r101.put("height", this.f455689b);     // Catch: JSONException -> L12
            r101.put("resultCode", r100);     // Catch: JSONException -> L12
            if (this.f455690c == false) goto L5;
            r102 = "vesdk_event_recorder_take_picture";
        L5:
            r101.put("is_effect", this.f455691d);     // Catch: JSONException -> L12
            r101.put("duration", System.currentTimeMillis() - this.f455692e);     // Catch: JSONException -> L12
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L9;
            com.ss.android.ttve.monitor.c.a(r102, r101, "business");     // Catch: JSONException -> L12
        L16:
        L14:
            this.f455693f.onShotScreen(r100);
            return;
        L9:
            com.ss.android.ttve.monitor.c.b(r102, r101, "business", false, true);     // Catch: JSONException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public r(int r100, int r101, boolean r102, boolean r103, long r104, IShotScreenCallback r105) {
            this.f455688a = r100;
            this.f455689b = r101;
            this.f455690c = r102;
            this.f455691d = r103;
            this.f455692e = r104;
            this.f455693f = r105;
        }
    }

    public class s implements IBitmapShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f455694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f455695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f455696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f455697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f455698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IBitmapShotScreenCallback f455699f;

        @Override // com.ss.android.vesdk.VERecorder.IBitmapShotScreenCallback
        public final void onShotScreen(Bitmap r100, int r101) {
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L12
            String r103 = "vesdk_event_recorder_shot_screen";
            r102.put("width", this.f455694a);     // Catch: JSONException -> L12
            r102.put("height", this.f455695b);     // Catch: JSONException -> L12
            r102.put("resultCode", r101);     // Catch: JSONException -> L12
            if (this.f455696c == false) goto L5;
            r103 = "vesdk_event_recorder_take_picture";
        L5:
            r102.put("is_effect", this.f455697d);     // Catch: JSONException -> L12
            r102.put("duration", System.currentTimeMillis() - this.f455698e);     // Catch: JSONException -> L12
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L9;
            com.ss.android.ttve.monitor.c.a(r103, r102, "business");     // Catch: JSONException -> L12
        L16:
        L14:
            this.f455699f.onShotScreen(r100, r101);
            return;
        L9:
            com.ss.android.ttve.monitor.c.b(r103, r102, "business", false, true);     // Catch: JSONException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public s(int r100, int r101, boolean r102, boolean r103, long r104, IBitmapShotScreenCallback r105) {
            this.f455694a = r100;
            this.f455695b = r101;
            this.f455696c = r102;
            this.f455697d = r103;
            this.f455698e = r104;
            this.f455699f = r105;
        }
    }

    public class t implements IBitmapShotScreenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f455700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f455701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f455702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f455703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f455704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IBitmapShotScreenCallback f455705f;

        @Override // com.ss.android.vesdk.VERecorder.IBitmapShotScreenCallback
        public final void onShotScreen(Bitmap r100, int r101) {
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
            String r103 = "vesdk_event_recorder_shot_screen";
            r102.put("width", this.f455700a);     // Catch: JSONException -> L7
            r102.put("height", this.f455701b);     // Catch: JSONException -> L7
            r102.put("resultCode", r101);     // Catch: JSONException -> L7
            if (this.f455702c == false) goto L5;
            r103 = "vesdk_event_recorder_take_picture";
        L5:
            r102.put("is_effect", this.f455703d);     // Catch: JSONException -> L7
            r102.put("duration", System.currentTimeMillis() - this.f455704e);     // Catch: JSONException -> L7
            com.ss.android.ttve.monitor.c.a(r103, r102, "business");     // Catch: JSONException -> L7
        L9:
            this.f455705f.onShotScreen(r100, r101);
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }

        public t(int r100, int r101, boolean r102, boolean r103, long r104, IBitmapShotScreenCallback r105) {
            this.f455700a = r100;
            this.f455701b = r101;
            this.f455702c = r102;
            this.f455703d = r103;
            this.f455704e = r104;
            this.f455705f = r105;
        }
    }

    public interface u {
    }

    public interface v {
        void a(int r100, int r101);

        void b(int r100, int r101);

        void c(Bitmap r100, VEFrame r101);
    }

    public interface w {
    }

    public interface x {
    }

    public interface y {
    }

    public interface z {
    }

    public int clearDisplay(int r100) {
        return 0;
    }

    public String[] concat() throws VEException {
        return concat(0, "", "");
    }

    public long getAECDelayTimeInMS() {
        return 0;
    }

    public void setFollowingShotListener(VEListener.m r100) {
    }

    public void startAudioRecorder() {
        startAudioRecorder(null);
    }

    public void stopAudioRecorder() {
        stopAudioRecorder(null);
    }

    public void updateDuetLayout(VEDuetLayout r100) {
    }

    public void changeCamera() {
        this.mRecorder.changeCamera();
    }

    public void clearAllFrags() throws VEException {
        this.mRecorder.clearAllFrags();
    }

    public void clearLandMarkDetectListener() {
        this.mRecorder.clearLandMarkDetectListener();
    }

    public void clearRecorderStateListener() {
        this.mRecorder.clearRecorderStateListener();
    }

    public void clearSticker() {
        this.mRecorder.clearSticker();
    }

    public void customInitEffect() {
        this.mRecorder.customInitEffect();
    }

    public void deleteLastFrag() throws VEException {
        this.mRecorder.deleteLastFrag();
    }

    public ICameraCapture detachCameraCapture() {
        return this.mRecorder.detachCameraCapture();
    }

    public void downExposureCompensation() {
        this.mRecorder.downExposureCompensation();
    }

    public float[] getAECSuggestVolume() {
        return this.mRecorder.getAECSuggestVolume();
    }

    public VEAudioCapture getAudioCapture() {
        return this.mRecorder.getAudioCapture();
    }

    public VEAudioCaptureListener getAudioConsumer() {
        return this.mRecorder.getAudioConsumer();
    }

    public m0 getAudioPlayGlitchInfo() {
        return this.mRecorder.getAudioPlayGlitchInfo();
    }

    public int getBGMTrackIndex() {
        VELogUtil.d(TAG, "bgm index is " + this.mRecorder.getBGMTrackIndex());
        return this.mRecorder.getBGMTrackIndex();
    }

    public TECameraBase.ExposureCompensationInfo getCameraECInfo() {
        return this.mRecorder.getCameraECInfo();
    }

    public VECameraSettings.CAMERA_FACING_ID getCameraFacing() {
        return this.mRecorder.getCameraFacing();
    }

    public float getCameraFps() {
        return this.mRecorder.getCameraFps();
    }

    public VECameraFrameTime getCameraFrameTime() {
        return this.mRecorder.getCameraFrameTime();
    }

    public float getCameraOpenPreviewFirstNFrameIntervalsAverageMS() {
        return this.mRecorder.getCameraOpenPreviewFirstNFrameIntervalsAverageMS();
    }

    public String getComposerNodePaths() {
        return this.mRecorder.getComposerNodePaths();
    }

    public VERecordMode getCurRecordMode() {
        return this.mRecorder.getCurRecordMode();
    }

    public VERenderContext getCurVERenderContext() {
        return this.mRecorder.getCurVERenderContext();
    }

    public ICameraCapture getCurrentCameraCapture() {
        return this.mRecorder.getCurrentCameraCapture();
    }

    public VEDisplaySettings getDisplaySettings() {
        return this.mRecorder.getDisplaySettings();
    }

    public IEffect getEffect() {
        return this.mRecorder.getEffect();
    }

    public com.ss.android.vesdk.f0 getEffectFrameCostStatistics() {
        return this.mRecorder.getEffectFrameCostStatistics();
    }

    public long getEffectHandler() {
        return this.mRecorder.getEffectHandler();
    }

    public com.ss.android.vesdk.h0 getEffectStickerLagInfo() {
        return this.mRecorder.getEffectStickerLagInfo();
    }

    public long getEndFrameTime() {
        return this.mRecorder.getEndFrameTime();
    }

    public EnigmaResult getEnigmaResult() {
        return this.mRecorder.getEnigmaResult();
    }

    public VEMapBufferInfo getIntermediatePathFromEffect() {
        VELogUtil.i(TAG, "get intermediate path from effect");
        return this.mRecorder.getMapBuffer();
    }

    public efc.a getInternalRecorder() {
        return this.mRecorder.getInternalRecorder();
    }

    public VERecordPerformanceData getLastPerformanceData() {
        return this.mRecorder.getLastPerformanceData();
    }

    public int getLastRecordFrameNum() {
        return this.mRecorder.getLastRecordFrameNum();
    }

    public float getMaxZoom() {
        return this.mRecorder.getMaxZoom();
    }

    public int getMicState() {
        com.ss.android.vesdk.p r100 = this.mRecorder;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMicState();
    }

    public com.ss.android.vesdk.e getMotionPhotoControl() {
        return this.mRecorder.getMotionPhotoControl();
    }

    public long getPrePlayTimeStamp() {
        return this.mRecorder.getPrePlayTimeStamp();
    }

    public float getPreviewAvgRenderFps() {
        return this.mRecorder.getPreviewAvgRenderFps();
    }

    public float getPreviewDropFps() {
        return this.mRecorder.getPreviewDropFps();
    }

    public float getPreviewFirstNFrameIntervalsAverageMS() {
        return this.mRecorder.getPreviewFirstNFrameIntervalsAverageMS();
    }

    public int getPreviewLagCount() {
        return this.mRecorder.getPreviewLagCount();
    }

    public int getPreviewLagMaxDuration() {
        return this.mRecorder.getPreviewLagMaxDuration();
    }

    public int getPreviewLagTotalDuration() {
        return this.mRecorder.getPreviewLagTotalDuration();
    }

    public VEPreviewRadio getPreviewRadio() {
        return this.mRecorder.getPreviewRadio();
    }

    public float getPreviewRenderFps() {
        return this.mRecorder.getPreviewRenderFps();
    }

    public int[] getPreviewRenderRect() {
        return this.mRecorder.getPreviewRenderRect();
    }

    public int getPreviewSeriousLagCount() {
        return this.mRecorder.getPreviewSeriousLagCount();
    }

    public int getPreviewSubLagCount() {
        return this.mRecorder.getPreviewSubLagCount();
    }

    public float getPreviewSubRenderFps() {
        return this.mRecorder.getPreviewSubRenderFps();
    }

    public int[] getReactRegionInRecordVideoPixel() {
        return this.mRecorder.getReactRegionInRecordVideoPixel();
    }

    public int[] getReactRegionInViewPixel() {
        return this.mRecorder.getReactRegionInViewPixel();
    }

    public int[] getReactionPosMarginInViewPixel() {
        return this.mRecorder.getReactionPosMarginInViewPixel();
    }

    public float getReactionWindowRotation() {
        return this.mRecorder.getReactionWindowRotation();
    }

    public long getRealSegmentFrameTimeUS() {
        return this.mRecorder.getRealSegmentFrameTimeUS();
    }

    public float getRecordAvgRenderFps() {
        return this.mRecorder.getRecordAvgRenderFps();
    }

    public int getRecordCount() {
        return this.mRecorder.getRecordCount();
    }

    public u0 getRecordDraft() {
        return this.mRecorder.getRecordDraft();
    }

    public float getRecordFirstNFrameIntervalsAverageMS() {
        return this.mRecorder.getRecordFirstNFrameIntervalsAverageMS();
    }

    public int getRecordLagCount() {
        return this.mRecorder.getRecordLagCount();
    }

    public int getRecordLagMaxDuration() {
        return this.mRecorder.getRecordLagMaxDuration();
    }

    public int getRecordLagTotalDuration() {
        return this.mRecorder.getRecordLagTotalDuration();
    }

    public double getRecordPreviewFpsEnd() {
        return this.mRecorder.getRecordPreviewFpsEnd();
    }

    public double getRecordPreviewFpsStart() {
        return this.mRecorder.getRecordPreviewFpsStart();
    }

    public float getRecordRenderDropFps() {
        return this.mRecorder.getRecordRenderDropFps();
    }

    public float getRecordRenderFps() {
        return this.mRecorder.getRecordRenderFps();
    }

    public com.ss.android.vesdk.f getRecordScanControl() {
        return this.mRecorder.getRecordScanControl();
    }

    public int getRecordSeriousLagCount() {
        return this.mRecorder.getRecordSeriousLagCount();
    }

    public int getRecordStatus() {
        return this.mRecorder.getRecordStatus();
    }

    public float getRecordWriteFps() {
        return this.mRecorder.getRecordWriteFps();
    }

    public String[] getRecordedVideoPaths() {
        return this.mRecorder.getRecordedVideoPaths();
    }

    public com.ss.android.vesdk.c getRecorderModelControl() {
        this.mRecorder.getRecorderModelControl();
        return null;
    }

    public com.ss.android.vesdk.d getRecorderPrePlayControl() {
        this.mRecorder.getRecorderPrePlayControl();
        return null;
    }

    public double getRenderEffectTime() {
        return this.mRecorder.getRenderEffectTime();
    }

    public double getRenderFrameTime() {
        return this.mRecorder.getRenderFrameTime();
    }

    public jic.e getRenderView() {
        return this.mRecorder.getRenderView();
    }

    public long getSegmentAudioLength() {
        return this.mRecorder.getSegmentAudioUS();
    }

    public long getSegmentAudioPlayBackTimestamp() {
        return this.mRecorder.getSegmentAudioPlayBackTimestamp();
    }

    public long getSegmentFrameTimeUS() {
        return this.mRecorder.getSegmentFrameTimeUS();
    }

    public int getSlamFaceCount() {
        return this.mRecorder.getSlamFaceCount();
    }

    public Object getStyleAudioProxy() {
        return this.mRecorder.getStyleAudioProxy();
    }

    public Object getStyleProxy() {
        return this.mRecorder.getStyleProxy();
    }

    public VEAudioCaptureSettings getSuggestionSettingsForKaraoke() {
        return this.mRecorder.getSuggestionSettingsForKaraoke();
    }

    public ITEVideoController getVideoController() {
        return this.mRecorder.getVideoController();
    }

    public VEVideoEncodeSettings getVideoEncodeSettings() {
        return this.mRecorder.getVideoEncodeSettings();
    }

    public boolean isSupportedExposureCompensation() {
        return this.mRecorder.isSupportedExposureCompensation();
    }

    public void onDestroy() {
        VELogUtil.w(TAG, "onDestroy...");
        com.ss.android.vesdk.p r100 = this.mRecorder;
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        VERecorderResManager r101 = this.mResManager;
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    public void onPause() {
        VELogUtil.w(TAG, "onPause...");
        this.mRecorder.onPause();
    }

    public void onResume() {
        VELogUtil.w(TAG, "onResume...");
        this.mRecorder.onResume();
    }

    public void pauseMediaRecord() {
        this.mRecorder.pauseMediaRecord();
    }

    public int pausePrePlay() {
        return this.mRecorder.pausePrePlay();
    }

    public int pauseRender() {
        return this.mRecorder.pauseRender();
    }

    public boolean previewDuetVideo() {
        return this.mRecorder.previewDuetVideo();
    }

    public float queryShaderStep() {
        return this.mRecorder.queryShaderStep();
    }

    public int queryZoomAbility() {
        return this.mRecorder.queryZoomAbility();
    }

    public void releaseGPUResources() {
        this.mRecorder.releaseGPUResources();
    }

    public void resetCameraFrameTime() {
        this.mRecorder.resetCameraFrameTime();
    }

    public void resetEffectFrameCostStatistics() {
        this.mRecorder.resetEffectFrameCostStatistics();
    }

    public void resumeMediaRecord() {
        this.mRecorder.resumeMediaRecord();
    }

    public void setFocusWithFaceDetect() {
        this.mRecorder.setFocusWithFaceDetect();
    }

    public void startCameraPreview() {
        this.mRecorder.startCameraPreview();
    }

    public int startFollowingShotPreview() {
        return this.mRecorder.startFollowingShotPreview();
    }

    public int startRender() {
        return this.mRecorder.startRender();
    }

    public void stopCameraPreview() {
        this.mRecorder.stopCameraPreview();
    }

    public void stopFollowingShotPreview() {
        this.mRecorder.stopFollowingShotPreview();
    }

    public void stopPreview() {
        this.mRecorder.stopPreview();
    }

    public int stopPreviewParallel() {
        return this.mRecorder.stopPreviewParallel();
    }

    public int stopRecord() {
        int r100 = this.mRecorder.stopRecord();
        JSONObject r101 = new JSONObject();
        r101.put("resultCode", r100);     // Catch: JSONException -> L10
        if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_record_finish", r101, "business");     // Catch: JSONException -> L10
    L13:
    L12:
        return r100;
    L7:
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_record_finish", r101, "business", false, true);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public void stopZoom() {
        this.mRecorder.stopZoom();
    }

    public void unRegSkeletonDetectCallback() {
        this.mRecorder.unRegSkeletonDetectCallback();
    }

    public void unRegSmartBeautyCallback() {
        this.mRecorder.unRegSmartBeautyCallback();
    }

    public void unregEffectAlgorithmCallback() {
        this.mRecorder.unregEffectAlgorithmCallback();
    }

    public void unregFaceInfoCallback() {
        this.mRecorder.unRegFaceInfoCallback();
    }

    public void unregHandDetecCallback() {
        this.mRecorder.unRegHandDetectCallback();
    }

    public void unregSceneDetectCallback() {
        this.mRecorder.unregSceneDetectCallback();
    }

    public void upExposureCompensation() {
        this.mRecorder.upExposureCompensation();
    }

    public void updateCameraOrientation() {
        this.mRecorder.updateCameraOrientation();
    }

    public void updateVideoDecodeChainByTimeline() {
        this.mRecorder.updateVideoDecodeChainByTimeline();
    }

    public VERecorderResManager getResManager() {
        return this.mResManager;
    }

    public void addCommonCallback(VECommonCallback r100) {
        this.mRecorder.addCommonCallback(r100);
    }

    public void addDataSource(VEDataSource r100) {
        this.mRecorder.addDataSource(r100);
    }

    public void addLandMarkDetectListener(VELandMarkDetectListener r100) {
        this.mRecorder.addLandMarkDetectListener(r100);
    }

    public void addRecorderStateListener(VEListener.VERecorderStateExtListener r100) {
        this.mRecorder.addRecorderStateListener(r100);
    }

    public void addSlamDetectListener(VESlamDetectListener r100) {
        this.mRecorder.addSlamDetectListener(r100);
    }

    public void attachCameraCapture(ICameraCapture r100) {
        this.mRecorder.attachCameraCapture(r100);
    }

    public void attachCameraSettings(VECameraSettings r100) {
        this.mRecorder.attachCameraSettings(r100);
    }

    public void capture(com.ss.android.vesdk.y r100) {
        boolean r101 = VEConfigCenter.getInstance().getValue(TECameraConfigKey.KEY_ENABLE_CAMERA_CAPTURE_STREAM, true).booleanValue();
        ICameraCapture r102 = getCurrentCameraCapture();
        if (r102 != null) goto L5;
        if (r101 == true) goto L12;
        this.mRecorder.getPreviewRenderRect();
        throw null;
    L12:
        throw null;
    L5:
        if (r102.getFlashMode() == VECameraSettings.CAMERA_FLASH_MODE.CAMERA_FLASH_OFF) goto L11;
        VECameraSettings.CAMERA_FLASH_MODE r103 = VECameraSettings.CAMERA_FLASH_MODE.CAMERA_FLASH_TORCH;
        throw null;
    L11:
        throw null;
    }

    public void changeCamera(VECameraSettings.CAMERA_FACING_ID r100) {
        this.mRecorder.changeCamera(r100);
    }

    public boolean changePreviewSize(VESize r100) {
        return this.mRecorder.changePreviewSize(r100);
    }

    public void changeRecordContentType(VEPreviewSettings.VERecordContentType r100) {
        this.mRecorder.changeRecordContentType(r100);
    }

    public void changeRecordMode(VERecordMode r100) {
        this.mRecorder.changeRecordMode(r100);
    }

    public int changeRenderSize(VESize r100) {
        return this.mRecorder.changeRenderSize(r100);
    }

    public void changeSurface(Surface r100) {
        this.mRecorder.changeSurface(r100);
    }

    public void changeVideoEncodeSettings(VEVideoEncodeSettings r100) {
        this.mRecorder.changeVideoEncodeSettings(r100);
    }

    public void chooseAreaFromRatio34(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 > 0.25f) goto L10;
        this.mRecorder.chooseAreaFromRatio34(r100);
        return;
    }

    public void chooseSlamFace(int r100) {
        this.mRecorder.chooseSlamFace(r100);
    }

    public void concatAsync(VEListener.VEConcatListener r100) {
        concatAsync(0, "", "", r100);
    }

    public void configStyleResourceFinder(AssetManager r100) {
        this.mRecorder.configStyleResourceFinder(r100);
    }

    public int deleteFrag(int r100) {
        return this.mRecorder.deleteFrag(r100);
    }

    public void deleteLastFrag(VEListener.VECallListener r100) {
        this.mRecorder.deleteLastFrag(r100);
    }

    public void disableRender(boolean r100) {
        this.mRecorder.disableRender(r100);
    }

    public boolean drawEffectToBitmap(Bitmap r100) {
        if (r100.getConfig() != Bitmap.Config.ARGB_8888) goto L7;
        return this.mRecorder.drawEffectToBitmap(r100);
    L7:
        throw new IllegalArgumentException("bitmap must be ARGB_8888 format");
    }

    public void enable34To916RatioForEffectRender(boolean r100) {
        this.mRecorder.enable34To916RatioForEffectRender(r100);
    }

    public void enableAudio(boolean r100) {
        this.mRecorder.enableAudio(r100);
    }

    public void enableAudioPlayGlitchMetrics(boolean r100) {
        this.mRecorder.enableAudioPlayGlitchMetrics(r100);
    }

    public void enableAudioPlayerFromVE(boolean r100) {
        this.mRecorder.enableAudioPlayerFromVE(r100);
    }

    public void enableAudioRecorder(boolean r100) {
        VELogUtil.i(TAG, "enableAudioRecorder: " + r100);
        enableAudioRecorder(r100, null);
    }

    public void enableDuetMicRecord(boolean r100) {
        this.mRecorder.enableDuetMicRecord(r100);
    }

    public void enableEffect(boolean r100) {
        this.mRecorder.enableEffect(r100);
    }

    public void enableEffectAmazing(boolean r100) {
        this.mRecorder.enableEffectAmazing(r100);
    }

    public void enableFaceBeautifyDetect(int r100) {
        this.mRecorder.enableFaceBeautifyDetect(r100);
        this.mFaceBeautifyDetectIndex = r100;
    }

    public void enableFaceExtInfo(int r100) {
        this.mRecorder.enableFaceExtInfo(r100);
    }

    public void enableFirstFrameBypassEffectFrame(boolean r100) {
        this.mRecorder.enableFirstFrameBypassEffectFrame(r100);
    }

    public void enableFollowingShotWindowLoopPlayWhenRecord(boolean r100) {
        this.mRecorder.enableFollowingShotWindowLoopPlayWhenRecord(r100);
    }

    public void enableGetPropTrack(boolean r100) {
        this.mRecorder.enableGetPropTrack(r100);
    }

    public void enableNewAudioCapture(boolean r100) {
        this.mRecorder.enableNewAudioCapture(r100);
    }

    public void enablePBO(boolean r100) {
        this.mRecorder.enablePBO(r100);
    }

    public void enablePictureTestMode(boolean r100) {
        this.mRecorder.enablePictureTestMode(r100, false);
    }

    public void enablePreviewPureColorFakeFrame(boolean r100) {
        this.mRecorder.enablePreviewPureColorFakeFrame(r100);
    }

    public void enableRecordBGMToMp4(boolean r100) {
        this.mRecorder.enableRecordBGMToMp4(r100);
    }

    public void enableRecordFlip(boolean r100) {
        this.mRecorder.enableRecordFlip(r100);
    }

    public void enableRecordingMp4(boolean r100) {
        VELogUtil.i(TAG, "enableRecordingMp4... enable: " + r100);
        this.mRecorder.enableRecordingMp4(r100);
    }

    public void enableSceneRecognition(boolean r100) {
        VELogUtil.i(TAG, "enableSceneRecognition:" + r100);
        this.mRecorder.enableSceneRecognition(r100);
    }

    public void enableSkeletonDetect(boolean r100) {
        this.mRecorder.enableSkeletonDetect(r100);
    }

    public void enableSmartBeauty(boolean r100) {
        this.mRecorder.enableSmartBeauty(r100);
    }

    public void enableStickerRecognition(boolean r100) {
        VELogUtil.i(TAG, "enableExpressDetect:" + r100);
        this.mRecorder.enableStickerRecognition(r100);
    }

    public void enableTimestampCallback(boolean r100) {
        this.mRecorder.enableTimestampCallback(r100);
    }

    public void enableVolumeDetect(boolean r100) {
        this.mRecorder.enableVolumeDetect(r100);
    }

    public void enableWaterMark(boolean r100) {
        this.mRecorder.enableWaterMark(r100);
    }

    public int exportResource(String r100) {
        return this.mRecorder.exportResource(r100);
    }

    public boolean fetchDistortionInfo(z r100) {
        return this.mRecorder.fetchDistortionInfo(r100);
    }

    public int getDuetAVTrackIndex(int r100) {
        return this.mRecorder.getDuetAVTrackIndex(r100);
    }

    public String getEffectETData(int r100) {
        return this.mRecorder.getEffectETData(r100);
    }

    public HashMap<String, Object> getEventTraceByScene(String r100) {
        if (VEConfigCenter.getInstance().getValue("veabtest_new_event_trace", false).booleanValue() == true) goto L5;
        return null;
    L5:
        return this.mRecorder.getEventTraceByScene(r100);
    }

    public float getFilterIntensity(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return -1.0f;
    L7:
        return this.mRecorder.getFilterIntensity(r100);
    }

    public VEFrame getFrameByConfig(FrameConfig r100) {
        return this.mRecorder.getFrameByConfig(r100);
    }

    public int getPreviewFrame(VEGetFrameSettings r100) {
        long r101 = System.currentTimeMillis();
        VEGetFrameSettings.Builder r102 = new VEGetFrameSettings.Builder(r100);
        VEGetFrameSettings.IGetFrameCallback r103 = r100.getGetFrameCallback();
        if (r103 == null) goto L6;
        r102.setGetFrameCallback(new k(r100, r101, r103));
    L6:
        if (r100.getGetOriginFrameCallback() == null) goto L10;
        return this.mRecorder.getPreviewFrameWithOrigin(r100);
    L10:
        return this.mRecorder.getPreviewFrame(r100);
    }

    public String getResourceMultiViewTag(String r100) {
        return this.mRecorder.getResourceMultiViewTag(r100);
    }

    public void handleEffectAudioPlay(boolean r100) {
        this.mRecorder.handleEffectAudioPlay(r100);
    }

    public void initDebugSettings(VEDebugSettings r100) {
        VELogUtil.i(TAG, r100.toString());
        r100.init();
        this.mRecorder.setDebugSettings(r100);
    }

    public void initDuet(VEDuetSettings r100) {
        this.mRecorder.initDuet(r100);
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (com.ss.android.ttve.monitor.i.f449943c == true) goto L12;
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_init_duet", new JSONObject(r100.toString()), "business");     // Catch: JSONException -> L7
        return;
    }

    public void initFaceBeautifyDetectExtParam(VEFaceBeautifyDetectExtParam r100) {
        this.mRecorder.initFaceBeautifyDetectExtParam(r100);
    }

    public void initFaceBeautyDetectExtParam(VEFaceBeautyDetectExtParam r100) {
        this.mRecorder.initFaceBeautyDetectExtParam(r100);
    }

    public void initFaceDetectExtParam(VEFaceDetectExtParam r100) {
        this.mRecorder.initFaceDetectExtParam(r100);
    }

    public void initHDRNetDetectExtParam(VEHDRNetDetectExtParam r100) {
        this.mRecorder.initHDRNetDetectExtParam(r100);
    }

    public void initHandDetectExtParam(VEHandDetectExtParam r100) {
        this.mRecorder.initHandDetectExtParam(r100);
    }

    public void initReact(VEReactSettings r100) {
        this.mRecorder.initReact(r100);
    }

    public boolean isGestureRegistered(VEGestureEvent r100) {
        return this.mRecorder.isGestureRegistered(r100);
    }

    public boolean isSupportWideAngle(VECameraSettings.CAMERA_TYPE r100) {
        return this.mRecorder.isSupportWideAngle(r100);
    }

    public int loadDraft(u0 r100) {
        return this.mRecorder.loadDraft(r100);
    }

    public void pauseEffectAudio(boolean r100) {
        this.mRecorder.pauseEffectAudio(r100);
    }

    public void pauseRenderAsync(VEListener.VECallListener r100) {
        this.mRecorder.pauseRenderAsync(r100);
    }

    public void pauseSlamAudio(boolean r100) {
        pauseEffectAudio(r100);
    }

    public void preventTextureRender(boolean r100) {
        this.mRecorder.preventTextureRender(r100);
    }

    public void recoverCherEffect(VECherEffectParam r100) {
        this.mRecorder.recoverCherEffect(r100);
    }

    public void regEffectAlgorithmCallback(VEEffectAlgorithmCallback r100) {
        this.mRecorder.regEffectAlgorithmCallback(r100);
    }

    public void regFaceInfoCallback(VEFaceInfoCallback r100) {
        this.mRecorder.regFaceInfoCallback(r100);
    }

    public void regSceneDetectCallback(e0 r100) {
        this.mRecorder.regSceneDetectCallback(r100);
    }

    public void regSkeletonDetectCallback(VESkeletonDetectCallback r100) {
        this.mRecorder.regSkeletonDetectCallback(r100);
    }

    public void regSmartBeautyCallback(h0 r100) {
        this.mRecorder.regSmartBeautyCallback(r100);
    }

    public void registerCherEffectParamCallback(VECherEffectParamCallback r100) {
        this.mRecorder.registerCherEffectParamCallback(r100);
    }

    public void releaseGPUResourcesAsync(VEListener.VECallListener r100) {
        this.mRecorder.releaseGPUResourcesAsync(r100);
    }

    public void removeCommonCallback(VECommonCallback r100) {
        this.mRecorder.removeCommonCallback(r100);
    }

    public void removeFaceInfoCallback(VEFaceInfoCallback r100) {
        this.mRecorder.removeFaceInfoCallback(r100);
    }

    public void removeLandMarkDetectListener(VELandMarkDetectListener r100) {
        this.mRecorder.removeLandMarkDetectListener(r100);
    }

    public void removeRecorderStateListener(VEListener.VERecorderStateExtListener r100) {
        this.mRecorder.removeRecorderStateListener(r100);
    }

    public void removeSlamDetectListener(VESlamDetectListener r100) {
        this.mRecorder.removeSlamDetectListener(r100);
    }

    public void renderFrame(String r100) {
        this.mRecorder.renderFrame(r100);
    }

    public void resetEffectETData(int r100) {
        this.mRecorder.resetEffectETData(r100);
    }

    public int resetResManager(VERecorderResManager r100) {
        int r101 = this.mRecorder.changeResManager(r100);
        if (r101 != 0) goto L5;
        this.mResManager = r100;
    L5:
        return r101;
    }

    public float rotateReactionWindow(float r100) {
        return this.mRecorder.rotateReactionWindow(r100);
    }

    public void runTask(Runnable r100) {
        this.mRecorder.runTask(r100);
    }

    public int[] scaleReactionWindow(float r100) {
        return this.mRecorder.scaleReactionWindow(r100);
    }

    public int setAgeMakeupState(boolean r100) {
        return this.mRecorder.setAgeMakeupState(r100);
    }

    public void setAudioCaptureListener(VEAudioCaptureListener r100) {
        this.mRecorder.setAudioCaptureListener(r100);
    }

    public void setAudioDevice(boolean r100) {
        this.mRecorder.setAudioDevice(r100);
    }

    public void setAudioRecordStateCallback(VEListener.e r100) {
        this.mRecorder.setAudioRecordStateCallback(r100);
    }

    public void setAudioRecorderStateListener(VEListener.g r100) {
        this.mRecorder.setAudioRecorderStateListener(r100);
    }

    public void setAudioVolumeDetectCallback(VEListener.f r100) {
        this.mRecorder.setAudioRecordVolumeDetectCallback(r100);
    }

    public void setBgmMute(boolean r100) {
        this.mRecorder.setBgmMute(r100);
    }

    public void setCameraClose(boolean r100) {
        this.mRecorder.setCameraClose(r100);
    }

    public void setCameraFirstFrameOptimize(boolean r100) {
        this.mRecorder.setCameraFirstFrameOptimize(r100);
    }

    public void setCameraStateListener(VEListener.VECameraStateListener r100) {
        if (r100 != null) goto L4;
        this.mRecorder.setCameraStateListener(null);
    L4:
        this.mRecorder.setCameraStateListener(new h(r100));
    }

    public void setCameraZoomListener(VECameraZoomListener r100) {
        this.mRecorder.setCameraZoomListener(r100);
    }

    public void setCaptureMirror(VEMirrorMode r100) {
        this.mRecorder.setCaptureMirror(r100.ordinal());
    }

    public void setClientState(int r100) {
        this.mRecorder.setClientState(r100);
    }

    public void setCommonCallback(VECommonCallback r100) {
        this.mRecorder.setCommonCallback(r100);
    }

    public int setComposerResourcePath(String r100) {
        return this.mRecorder.setComposerResourcePath(r100);
    }

    public void setDLEEnable(boolean r100) {
        this.mRecorder.setDLEEnable(r100);
    }

    public void setDetectInterval(int r100) {
        this.mRecorder.setDetectInterval(r100);
    }

    public void setDeviceRotation(int r100) {
        if (r100 != 1) goto L5;
        int r101 = 90;
    L12:
        this.mRecorder.setDeviceRotation(r101);
        return;
    L5:
        if (r100 != 2) goto L7;
        r101 = 180;
        goto L12
    L7:
        if (r100 == 3) goto L9;
        r101 = 0;
        goto L12
    L9:
        r101 = 270;
        goto L12
    }

    public void setDisplayBlendFrameParam(com.ss.android.vesdk.model.c r100) {
        this.mRecorder.setDisplayBlendFrameParam(r100);
    }

    public void setDisplayParamsListener(hic.b r100) {
        this.mRecorder.setDisplayParamsListener(r100);
    }

    public int setDisplaySettings(VEDisplaySettings r100) {
        return this.mRecorder.setDisplaySettings(r100);
    }

    public void setDropFrame(int r100) {
        this.mRecorder.setDropFrame(r100);
    }

    public void setDuetVideoCompleteCallback(Runnable r100) {
        this.mRecorder.setDuetVideoCompleteCallback(r100);
    }

    public boolean setEffectAudioManagerCallback(u r100) {
        return this.mRecorder.setEffectAudioManagerCallback(r100);
    }

    public void setEffectBgmEnable(boolean r100) {
        this.mRecorder.setEffectBgmEnable(r100);
    }

    public int setEffectMaxMemoryCache(int r100) {
        VELogUtil.w(TAG, "setEffectMaxMemoryCache size:" + r100);
        if (r100 >= 0) goto L6;
        return -100;
    L6:
        int r101 = this.mRecorder.setEffectMaxMemoryCache(r100);
        if (r101 == 0) goto L9;
        VELogUtil.e(TAG, "setEffectMaxMemoryCache failed, ret = " + r101);
    L9:
        return r101;
    }

    public void setEffectMessageListener(MessageCenter.Listener r100) {
        this.mRecorder.setEffectMessageListener(r100);
    }

    public void setEffectSlamEnable(boolean r100) {
        this.mRecorder.setEffectSlamEnable(r100);
    }

    public int setEnableAEC(boolean r100) {
        return setEnableAEC(r100, null);
    }

    public void setEnableDuetV2(boolean r100) {
        this.mRecorder.setEnableDuetV2(r100);
    }

    public int setEnableEarBack(boolean r100) {
        return this.mRecorder.setEnableEarBack(r100);
    }

    public void setExposureCompensation(int r100) {
        this.mRecorder.setExposureCompensation(r100);
    }

    public boolean setExtPreviewDataSurface(Surface r100) {
        VELogUtil.i(TAG, "setExtPreviewDataSurface " + r100);
        return this.mRecorder.setExtPreviewDataSurface(r100);
    }

    public int setFaceMakeUp(String r100) {
        VELogUtil.i(TAG, "setFaceMakeUp: " + r100);
        int r101 = this.mRecorder.setFaceMakeUp(r100);
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
        r102.put("strResPath", r100);     // Catch: JSONException -> L5
        r102.put("resultCode", r101);     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_face_make_up", r102, "business");     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int setFilter(String r100) {
        return setFilter(r100, 0.0f, true);
    }

    public void setFocus(VEFocusSettings r100) {
        this.mRecorder.setFocus(r100);
    }

    public void setFocusWithFaceDetect(VEFocusSettings r100) {
        this.mRecorder.setFocusWithFaceDetect(r100);
    }

    public void setFollowShotDisplayDegree(int r100) {
        this.mRecorder.setFollowShotDisplayDegree(r100);
    }

    public void setForceAlgorithmEnableCount(int r100) {
        this.mRecorder.setForceAlgorithmEnableCount(r100);
    }

    public void setForceAlgorithmExecuteCount(int r100) {
        this.mRecorder.setForceAlgorithmExecuteCount(r100);
    }

    public void setFrameEffectCallback(a0 r100) {
        this.mRecorder.setFrameEffectCallback(r100);
    }

    public void setHandDetectLowpowerEnable(boolean r100) {
        this.mRecorder.setHandDetectLowpowerEnable(r100);
    }

    public void setImageExposure(float r100) {
        this.mRecorder.setImageExposure(r100);
    }

    public void setLargeMattingModelEnable(boolean r100) {
        this.mRecorder.setLargeMattingModelEnable(r100);
    }

    public int setMaleMakeupState(boolean r100) {
        return this.mRecorder.setMaleMakeupState(r100);
    }

    public int setModelDownloadInterface(VEModelDownload.IModelDownload r100) {
        this.mModelDownload = r100;
        return 0;
    }

    public int setMultiCamMode(VEMulticamMode r100) {
        return this.mRecorder.setMultiCamMode(r100);
    }

    public int setMultiCamModeAsync(VEMulticamMode r100) {
        return this.mRecorder.setMultiCamModeAsync(r100);
    }

    public void setMusicNodes(String r100) {
        this.mRecorder.setMusicNodes(r100);
    }

    public void setOnErrorListener(VECommonCallback r100) {
        this.mRecorder.setOnErrorListener(r100);
    }

    public void setOnFrameAvailableListener(OnFrameAvailableListener r100) {
        if (r100 != null) goto L4;
        i r101 = null;
    L5:
        setOnFrameAvailableListenerExt(r101);
        return;
    L4:
        r101 = new i(r100);
        goto L5
    }

    public void setOnFrameAvailableListenerExt(OnFrameAvailableListenerExt r100) {
        this.mRecorder.setOnFrameAvailableListenerExt(r100);
    }

    public void setOnInfoListener(VECommonCallback r100) {
        this.mRecorder.setOnInfoListener(r100);
    }

    public void setOnPictureTakenProxyListener(x r100) {
        this.mRecorder.setOnPictureTakenProxyListener(r100);
    }

    public void setOnPreviewDataCallbackListener(y r100) {
        VELogUtil.i(TAG, "setOnPreviewDataCallbackListener " + r100);
        this.mRecorder.setOnPreviewDataCallbackListener(r100);
    }

    public void setPaddingBottomInRatio34(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 > 0.25f) goto L10;
        this.mRecorder.setPaddingBottomInRatio34(r100);
        return;
    }

    public void setPreSavePcmSize(int r100) {
        this.mRecorder.setPreSavePcmSize(r100);
    }

    public void setPreviewDuetVideoPaused(boolean r100) {
        this.mRecorder.setPreviewDuetVideoPaused(r100);
    }

    public void setPreviewRadioListener(d0 r100) {
        this.mRecorder.setPreviewRadioListener(r100);
    }

    public void setPreviewRotation(int r100) {
        com.ss.android.vesdk.p r101 = this.mRecorder;
        r101.setPreviewRotation(r100 % 360);
    }

    public void setRecordMaxDuration(long r100) {
        setRecordMaxDurationUS(r100 * 1000);
    }

    public void setRecordMaxDurationUS(long r100) {
        this.mRecorder.setRecordMaxDuration(r100);
    }

    public void setRecordMode(int r100) {
        this.mRecorder.setRecordMode(r100);
    }

    public int setRecordPrepareTime(long r100) {
        return this.mRecorder.setRecordPrepareTime(r100);
    }

    public void setRecorderPreviewListener(VEListener.w r100) {
        this.mRecorder.setRecorderPreviewListener(r100);
    }

    public void setRecorderStateListener(VEListener.VERecorderStateListener r100) {
        this.mRecorder.setRecorderStateListener(r100);
    }

    public int setReshapeIntensityDict(Map<Integer, Float> r100) {
        return this.mRecorder.setReshapeIntensityDict(r100);
    }

    public int setReshapeResource(String r100) {
        return this.mRecorder.setReshapeResource(r100);
    }

    public void setSATZoomLisntener(VESATZoomListener r100) {
        this.mRecorder.setSATZoomListener(r100);
    }

    public void setScanListener(hic.c r100) {
        this.mRecorder.setScanListener(r100, null);
    }

    public void setShaderZoomListender(f0 r100) {
        this.mRecorder.setShaderZoomListener(r100);
    }

    public boolean setSharedTextureStatus(boolean r100) {
        fic.a r101 = new fic.a();
        r101.c("iesve_verecorder_use_sharedtexture", r100 + "");
        r101.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r101);
        return this.mRecorder.setSharedTextureStatus(r100);
    }

    public int setSkinTone(String r100) {
        int r101 = this.mRecorder.setSkinTone(r100);
        if (com.ss.android.ttve.monitor.i.f449943c == false) goto L9;
    L8:
        return r101;
    L9:
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L6
        r102.put("skinToneResPath", r100);     // Catch: JSONException -> L6
        r102.put("resultCode", String.valueOf(r101));     // Catch: JSONException -> L6
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_skintone", r102, "business");     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public int setSkinToneIntensity(float r100) {
        int r101 = this.mRecorder.setSkinToneIntensity(r100);
        if (com.ss.android.ttve.monitor.i.f449943c == true) goto L9;
        JSONObject r102 = new JSONObject();
        r102.put("intensity", r100);     // Catch: JSONException -> L7
        r102.put("resultCode", r101);     // Catch: JSONException -> L7
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_skintone_intensity", r102, "business");     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r101;
    }

    public int setSlamFace(Bitmap r100) {
        return this.mRecorder.setSlamFace(r100);
    }

    public void setSpeed(float r100) {
        this.mRecorder.setSpeed(r100);
    }

    public void setStickerRequestCallback(IStickerRequestCallback r100) {
        this.mRecorder.setStickerRequestCallback(r100);
    }

    public void setSubSurface(Surface r100) {
        this.mRecorder.setSubSurface(r100, -1, -1);
    }

    public void setSwapDuetRegion(boolean r100) {
        this.mRecorder.setSwapDuetRegion(r100);
    }

    public void setSwapReactionRegion(boolean r100) {
        this.mRecorder.setSwapReactionRegion(r100);
    }

    public void setTorch(boolean r100) {
        this.mRecorder.switchTorch(r100);
    }

    public void setUseMultiPreviewRatio(boolean r100) {
        this.mRecorder.setUseMultiPreviewRatio(r100);
    }

    public void setVideoBgSpeed(double r100) {
        this.mRecorder.setVideoBgSpeed(r100);
    }

    public void setVideoEncodeRotation(VERotation r100) {
        this.mRecorder.setVideoEncodeRotation(r100.ordinal() * 90);
    }

    public void setVoiceActivityDetection(VEListener.y r100) {
        this.mRecorder.setVoiceActivityDetectCallback(r100);
    }

    public void setVolume(VEVolumeParam r100) {
        this.mRecorder.setVolume(r100);
    }

    public void setWaterMark(VEWatermarkParam r100) {
        r100.rotation %= 360;
        this.mRecorder.setWaterMark(r100);
    }

    public void shotScreen(VEShotScreenSettings r100) {
        long r101 = System.currentTimeMillis();
        pgc.a.a("ve_use_camera", 1);
        VEShotScreenSettings.Builder r102 = new VEShotScreenSettings.Builder(r100);
        IShotScreenCallback r103 = r100.getScreenCallback();
        if (r103 == null) goto L5;
        r102.setShotScreenCallback(new a(r100, r101, r103));
    L5:
        IBitmapShotScreenCallback r104 = r100.getBitmapCallback();
        if (r104 == null) goto L8;
        r102.setBitmapCallback(new b(r100, r101, r104));
    L8:
        if (r103 != null) goto L13;
        if (r104 != null) goto L13;
        if (r100.getFrameCallback() == null) goto L13;
        r102.setFrameCallback(new c(r100, r101, r100.getFrameCallback()));
    L13:
        this.mRecorder.shotScreen(r100);
    }

    public int slamGetTextLimitCount(OnARTextCallback r100) {
        return this.mRecorder.slamGetTextLimitCount(r100);
    }

    public int slamGetTextParagraphContent(OnARTextCallback r100) {
        return this.mRecorder.slamGetTextParagraphContent(r100);
    }

    public int slamNotifyHideKeyBoard(boolean r100) {
        return this.mRecorder.slamNotifyHideKeyBoard(r100);
    }

    public int slamSetLanguage(String r100) {
        return this.mRecorder.slamSetLanguage(r100);
    }

    public int slamSetTextBitmapCallback(OnARTextBitmapCallback r100) {
        return this.mRecorder.slamGetTextBitmap(r100);
    }

    public void startAudioRecorder(Object r100) {
        this.mRecorder.startAudioRecorder(r100);
    }

    public void startCameraPreview(ICameraPreview r100) {
        this.mRecorder.startCameraPreview(r100);
    }

    public int startPrePlay(VEPrePlayParams r100) {
        return this.mRecorder.startPrePlay(r100);
    }

    public void startPreview(Surface r100) {
        this.mRecorder.startPreview(r100);
    }

    public int startRecord(float r100) {
        return startRecord("", "", r100);
    }

    public void startRenderAsync(VEListener.VECallListener r100) {
        this.mRecorder.startRenderAsync(r100);
    }

    public void startShaderZoom(float r100) {
        this.mRecorder.startShaderZoom(r100);
    }

    public void startZoom(float r100) {
        this.mRecorder.startZoom(r100);
    }

    public void stopAudioRecorder(Object r100) {
        this.mRecorder.stopAudioRecorder(r100);
    }

    public void stopFollowShowRender(boolean r100) {
        this.mRecorder.stopFollowShowRender(r100);
    }

    public void stopMediaRecord(ICameraCapture r100) {
        this.mRecorder.stopMediaRecord(r100);
    }

    public int stopPrePlay(VEListener.VECallListener r100) {
        com.ss.android.vesdk.model.d r101 = new com.ss.android.vesdk.model.d();
        r101.f455873a = false;
        return stopPrePlay(r100, r101);
    }

    public int stopPreview(boolean r100) {
        return this.mRecorder.stopPreview(r100);
    }

    public void stopPreviewAsync(VEListener.VECallListener r100) {
        this.mRecorder.stopPreviewAsync(r100);
    }

    public int stopRecord(VEListener.VECallListener r100) {
        int r101 = this.mRecorder.stopRecord(r100);
        JSONObject r102 = new JSONObject();
        r102.put("resultCode", r101);     // Catch: JSONException -> L10
        if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_record_finish", r102, "business");     // Catch: JSONException -> L10
    L13:
    L12:
        return r101;
    L7:
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_record_finish", r102, "business", false, true);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public void stopRecordAsync(VEListener.VECallListener r100) {
        o r101 = new o(r100);
        this.mRecorder.stopRecordAsync(r101);
    }

    public void stopRender(boolean r100) {
        this.mRecorder.stopRender(r100);
    }

    public float superResolutionTargetWidthFromCameraWidth(float r100) {
        if (Math.abs(r100 - 720.0f) >= 1.0E-6d) goto L6;
        return 1080.0f;
    L6:
        return 0.0f;
    }

    public boolean swapMainAndPipRenderTarget(boolean r100) {
        return this.mRecorder.swapMainAndPipRenderTarget(r100);
    }

    public int switchCameraMode(int r100) {
        return this.mRecorder.switchCameraMode(r100);
    }

    public int switchEffect(VEEffectFilterParam r100) {
        return this.mRecorder.switchEffect(r100);
    }

    public void switchFlashMode(VECameraSettings.CAMERA_FLASH_MODE r100) {
        this.mRecorder.switchFlashMode(r100);
    }

    public void useMusic(boolean r100) {
        this.mRecorder.useMusic(r100);
    }

    public void setCameraStateListener(VEListener.VECameraStateExtListener r100) {
        this.mRecorder.setCameraStateListener(r100);
    }

    public void setCaptureMirror(boolean r100) {
        this.mRecorder.setCaptureMirror(r100);
    }

    public void setDeviceRotation(float[] r100) {
        this.mRecorder.setDeviceRotation(r100);
    }

    public void setOnFrameAvailableListener(OnFrameAvailableListenerNew r100) {
        if (r100 != null) goto L4;
        j r101 = null;
    L5:
        setOnFrameAvailableListenerExt(r101);
        return;
    L4:
        r101 = new j(this, r100);
        goto L5
    }

    public int stopRecord(boolean r100) {
        int r101 = this.mRecorder.stopRecord(r100);
        JSONObject r102 = new JSONObject();
        r102.put("resultCode", r101);     // Catch: JSONException -> L10
        if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_record_finish", r102, "business");     // Catch: JSONException -> L10
    L13:
    L12:
        return r101;
    L7:
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_record_finish", r102, "business", false, true);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public int switchEffect(String r100) {
        return switchEffect(r100, 0, 0, false);
    }

    public VERecorder(VERecorderResManager r100, Context r101) {
        this(r100, r101, null);
    }

    public boolean addMetadata(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        return this.mRecorder.addMetadata(r100, r101);
    }

    public int addTrack(int r100, VETrackParams r101) {
        return this.mRecorder.addTrack(r100, r101);
    }

    public int animateImagePathsToPreview(List<String> r100, List<String> r101) {
        return this.mRecorder.animateImagePathsToPreview(r100, r101);
    }

    public int animateImageToPreview(String r100, String r101) {
        return animateImageToPreview(r100, r101, false);
    }

    public int animateImagesToPreview(List<String> r100, List<VEFrame> r101) {
        return animateImagesToPreview(r100, r101, false);
    }

    public int appendComposerNodes(String[] r100, int r101) {
        return this.mRecorder.appendComposerNodes(r100, r101);
    }

    public void changeDuetVideo(String r100, String r101) {
        this.mRecorder.changeDuetVideo(r100, r101);
    }

    public void changeSurface(Surface r100, VERetCallback r101) {
        this.mRecorder.changeSurface(r100, r101);
    }

    public void changeVideoOutputSize(int r100, int r101) {
        this.mRecorder.changeVideoOutputSize(r100, r101);
    }

    public int[] checkComposerNodeExclusion(String r100, String r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        return this.mRecorder.checkComposerNodeExclusion(r100, r101);
    L8:
        return new int[]{-1, 0};
    }

    public int[] checkComposerNodeExclusionSync(String r100, String r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        return this.mRecorder.checkComposerNodeExclusionSync(r100, r101);
    L8:
        return new int[]{-1, 0};
    }

    public int[][] checkComposerNodesExclusionSync(String[] r100, String[] r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        return this.mRecorder.checkComposerNodesExclusionSync(r100, r101);
    L8:
        return new int[][]{new int[]{-1, 0}};
    }

    public void enableAudioRecorder(boolean r100, Object r101) {
        this.mRecorder.enableAudioRecorder(r100, r101);
    }

    public void enableBachScan(boolean r100, VEBachAlgorithmParam r101) {
        this.mRecorder.enableBachScan(r100, r101);
    }

    public int enableEffectSuperResolution(boolean r100, boolean r101) {
        VELogUtil.i(TAG, "enableEffectSuperResolution... enable: " + r100);
        return this.mRecorder.enableEffectSuperResolution(r100, r101);
    }

    public void enableFastCVProcess(int r100, boolean r101) {
        this.mRecorder.enableFastCVProcess(r100, r101);
    }

    public void enableLensProcess(int r100, boolean r101) {
        if (r101 == false) goto L4;
        long r102 = 1;
    L5:
        pgc.a.a("te_lens_adaptive_sharpen", r102);
        this.mRecorder.enableLensProcess(r100, r101);
        return;
    L4:
        r102 = 0;
        goto L5
    }

    public void enablePictureTestMode(boolean r100, boolean r101) {
        this.mRecorder.enablePictureTestMode(r100, r101);
    }

    public void enableScan(boolean r100, long r101) {
        this.mRecorder.enableScan(r100, r101);
    }

    public float getComposerNodeValue(String r100, String r101) {
        return this.mRecorder.getComposerNodeValue(r100, r101);
    }

    public com.ss.android.vesdk.p getTERecorder(Context r100, jic.e r110) {
        VERecorderResManager r101 = this.mResManager;
        VEConfigCenter.ValuePkt r102 = VEConfigCenter.getInstance().getValue("ve_use_titan_recorder_engine");
        if (r102 == null) goto L12;
        if (r102.getValue() == null) goto L12;
        if ((r102.getValue() instanceof Boolean) == false) goto L12;
        if (((Boolean) r102.getValue()).booleanValue() == false) goto L12;
        VELogUtil.i("TERecordFactory", "create TERecorder because of KEY_USE_TITAN_RECORDER_ENGINE");
        com.ss.android.ttve.monitor.i.f(0, "te_record_instance_type", 1);
        VERuntime.getInstance().enableRefactorRecorder(true);
        return new TERecorder(r100, r101, r110);
    L12:
        if (VERuntime.getInstance().isEnableRefactorRecorder() == false) goto L14;
        com.ss.android.ttve.monitor.i.f(0, "te_record_instance_type", 1);
        VELogUtil.i("TERecordFactory", "create TERecorder because of isEnableRefactorRecorder");
        return new TERecorder(r100, r101, r110);
    L14:
        return null;
    }

    public void handleEffectAudio(boolean r100, long r101) {
        this.mRecorder.handleEffectAudio(r100, r101);
    }

    public int pausePlayTrack(int r100, int r101) {
        return this.mRecorder.pausePlayTrack(r100, r101);
    }

    public boolean posInReactionRegion(int r100, int r101) {
        return this.mRecorder.posInReactionRegion(r100, r101);
    }

    public void preloadEffectWithFakeFrame(int r100, boolean r101) {
        this.mRecorder.preloadEffectWithFakeFrame(r100, r101);
    }

    public boolean processTouchEvent(VETouchPointer r100, int r101) {
        if (r100.getEvent() == null) goto L8;
        if (r101 >= 0) goto L7;
        return false;
    L7:
        return this.mRecorder.processTouchEvent(r100, r101);
    L8:
        return false;
    }

    public void regHandDetectCallback(int[] r100, c0 r101) {
        this.mRecorder.regHandDetectCallback(r100, r101);
    }

    public int reloadComposerNodes(String[] r100, int r101) {
        return this.mRecorder.reloadComposerNodes(r100, r101);
    }

    public int removeComposerNodes(String[] r100, int r101) {
        return this.mRecorder.removeComposerNodes(r100, r101);
    }

    public int removeTrack(int r100, int r101) {
        return this.mRecorder.removeTrack(r100, r101);
    }

    public void renderFrame(VEFrame r100, VEGetFrameSettings r101) {
        this.mRecorder.renderFrame(r100, r101);
    }

    public void setAlgorithmChangeMsgEnable(int r100, boolean r101) {
        this.mRecorder.setAlgorithmChangeMsgEnable(r100, r101);
    }

    public int setAlgorithmPreConfig(int r100, int r101) {
        return this.mRecorder.setAlgorithmPreConfig(r100, r101);
    }

    public int setBeautyFace(int r100, String r101) {
        fic.a r102 = new fic.a();
        r102.b("iesve_verecorder_set_beauty_algorithm", r100);
        r102.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r102);
        int r103 = this.mRecorder.setBeautyFace(r100, r101);
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L5
        r104.put("beautyFaceType", String.valueOf(r100));     // Catch: JSONException -> L5
        r104.put("strBeautyFaceRes", r101);     // Catch: JSONException -> L5
        r104.put("resultCode", r103);     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_beauty_face", r104, "business");     // Catch: JSONException -> L5
    L7:
        return r103;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int setBeautyFaceIntensity(float r100, float r101) {
        fic.a r102 = new fic.a();
        r102.a("iesve_verecorder_set_beauty_level", r100);
        r102.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r102);
        int r103 = this.mRecorder.setBeautyFaceIntensity(r100, r101);
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L5
        r104.put("fSmoothIntensity", String.valueOf(r100));     // Catch: JSONException -> L5
        r104.put("fBrightenIntensity", String.valueOf(r100));     // Catch: JSONException -> L5
        r104.put("resultCode", r103);     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_beauty_face_intensity", r104, "business");     // Catch: JSONException -> L5
    L7:
        return r103;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int setBeautyIntensity(int r100, float r101) {
        fic.a r102 = new fic.a();
        r102.a("iesve_verecorder_" + VEBeautyParam.a(r100) + "_level", r101);
        r102.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r102);
        return this.mRecorder.setBeautyIntensity(r100, r101);
    }

    public void setCaptureRenderWidth(int r100, int r101) {
        this.mRecorder.setCaptureRenderWidth(r100, r101);
    }

    public int setComposerMode(int r100, int r101) {
        return this.mRecorder.setComposerMode(r100, r101);
    }

    public int setComposerNodes(String[] r100, int r101) {
        return this.mRecorder.setComposerNodes(r100, r101);
    }

    public void setCustomVideoBg(String r100, String r101) {
        this.mRecorder.setCustomVideoBg(r100, r101);
    }

    public void setDetectListener(DetectListener r100, int r101) {
        com.ss.android.vesdk.p r102 = this.mRecorder;
        if (r102 == null) goto L6;
        r102.setDetectListener(r100, r101);
        return;
    }

    public void setDeviceRotation(float[] r100, double r101) {
        this.mRecorder.setDeviceRotation(r100, r101);
    }

    public int setEnableAEC(boolean r100, String r101) {
        return this.mRecorder.setEnableAEC(r100, r101);
    }

    public int setEnableLoudness(boolean r100, int r101) {
        return this.mRecorder.setEnableLoudness(r100, r101);
    }

    public int setFilter(String r100, float r101) {
        return setFilter(r100, r101, false);
    }

    public int setFilterNew(String r100, float r101) {
        fic.a r102 = new fic.a();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        String[] r103 = r100.split(File.separator);
        if (r103.length <= 0) goto L7;
        String r104 = r103[r103.length - 1];
    L8:
        float r105 = Math.min(1.0f, Math.max(r101, 0.0f));
        if (r105 >= 0.0f) goto L11;
        r105 = -1.0f;
    L11:
        r102.c("iesve_verecorder_set_filter_click_idfilter_id", r104);
        r102.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r102);
        int r106 = this.mRecorder.setFilterNew(r100, r105);
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L14
        r107.put("filterId", r104);     // Catch: JSONException -> L14
        r107.put("intensity", String.valueOf(r105));     // Catch: JSONException -> L14
        r107.put("tag", "setFilterNew");     // Catch: JSONException -> L14
        r107.put("resultCode", r106);     // Catch: JSONException -> L14
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_single_filter", r107, "business");     // Catch: JSONException -> L14
    L16:
        return r106;
    L14:
        e = move-exception;
        e.printStackTrace();
    L7:
        r104 = "";
        goto L8
    }

    public void setFocus(float r100, float r101) {
        this.mRecorder.setFocus(r100, r101);
    }

    public void setLensParams(VEBaseRecorderLensParams r100, VERecorderLensCallback r101) {
        int r102 = r100.algorithmFlag;
        if (r102 != 15) goto L5;
    L54:
        this.mRecorder.setLensParams((VELumaDetectParams) r100, r101);
        return;
    L5:
        if (r102 != 21) goto L7;
        VETaintSceneDetectParams r103 = (VETaintSceneDetectParams) r100;
        VEModelDownload.IModelDownload r104 = this.mModelDownload;
        if (r104 != null) goto L53;
        return;
    L53:
        r104.downloadModel(VEModelDownload.MODELNAME_TAINT_SCENE_DETECT, "TaintSceneDetectModel", new l(this, r103, r101));
        return;
    L7:
        if (r102 != 24) goto L9;
        VEAdaptiveSharpenParams r105 = (VEAdaptiveSharpenParams) r100;
        VEConfigCenter.ValuePkt r106 = VEConfigCenter.getInstance().getValue("ve_asf_amount");
        if (r106 != null) goto L17;
    L21:
        VEConfigCenter.ValuePkt r107 = VEConfigCenter.getInstance().getValue("ve_asf_over_ratio");
        if (r107 != null) goto L24;
    L28:
        VEConfigCenter.ValuePkt r108 = VEConfigCenter.getInstance().getValue("ve_asf_gpu_power_level");
        if (r108 != null) goto L31;
    L35:
        VEConfigCenter.ValuePkt r109 = VEConfigCenter.getInstance().getValue("ve_asf_init_delay_frame_cnt");
        if (r109 != null) goto L38;
    L42:
        VEConfigCenter.ValuePkt r110 = VEConfigCenter.getInstance().getValue("ve_asf_process_delay_frame_cnt");
        if (r110 != null) goto L45;
    L49:
        this.mRecorder.setLensParams(r100, r101);
        return;
    L45:
        if (r110.getValue() == null) goto L49;
        if ((r110.getValue() instanceof Integer) == false) goto L49;
        r105.processDelayFrameCnt = ((Integer) r110.getValue()).intValue();
        goto L49
    L38:
        if (r109.getValue() == null) goto L42;
        if ((r109.getValue() instanceof Integer) == false) goto L42;
        r105.initDelayFrameCnt = ((Integer) r109.getValue()).intValue();
        VELogUtil.i(TAG, "initDelayFrameCnt: " + r109.getValue());
        goto L42
    L31:
        if (r108.getValue() == null) goto L35;
        if ((r108.getValue() instanceof Integer) == false) goto L35;
        r105.powerLevelPara = ((Integer) r108.getValue()).intValue();
        VELogUtil.i(TAG, "powerLevelPara: " + r108.getValue());
        goto L35
    L24:
        if (r107.getValue() == null) goto L28;
        if ((r107.getValue() instanceof Float) == false) goto L28;
        r105.overRatio = ((Float) r107.getValue()).floatValue();
        goto L28
    L17:
        if (r106.getValue() == null) goto L21;
        if ((r106.getValue() instanceof Float) == false) goto L21;
        r105.amount = ((Float) r106.getValue()).floatValue();
        goto L21
    L9:
        if (r102 == 27) goto L54;
        if (r102 == 28) goto L13;
        this.mRecorder.setLensParams(r100, r101);
        return;
    L13:
        this.mRecorder.setLensParams((VEOneKeyProcessParams) r100, r101);
    }

    public void setReactionBorderParam(int r100, int r101) {
        this.mRecorder.setReactionBorderParam(r100, r101);
    }

    public boolean setReactionMaskImagePath(String r100, boolean r101) {
        return this.mRecorder.setReactionMaskImagePath(r100, r101);
    }

    public void setRenderCacheString(String r100, String r101) {
        this.mRecorder.setRenderCacheString(r100, r101);
    }

    public void setRenderCacheTexture(String r100, String r101) {
        this.mRecorder.setRenderCacheTexture(r100, r101);
    }

    public int setReshapeIntensity(int r100, float r101) {
        return this.mRecorder.setReshapeIntensity(r100, r101);
    }

    public int setReshapeParam(String r100, Map<Integer, Float> r101) {
        return this.mRecorder.setReshapeParam(r100, r101);
    }

    public void setSafeArea(int r100, VESafeAreaParams[] r101) {
        this.mRecorder.setSafeArea(r100, r101);
    }

    public int slamProcessDoubleClickEvent(float r100, float r101) {
        return this.mRecorder.slamProcessDoubleClickEvent(r100, r101);
    }

    public int slamProcessIngestOri(double[] r100, double r101) {
        return this.mRecorder.slamProcessIngestOri(r100, r101);
    }

    public int slamProcessRotationEvent(float r100, float r101) {
        return this.mRecorder.slamProcessRotationEvent(r100, r101);
    }

    public int slamProcessScaleEvent(float r100, float r101) {
        return this.mRecorder.slamProcessScaleEvent(r100, r101);
    }

    public int slamProcessTouchEvent(float r100, float r101) {
        return processTouchEvent(r100, r101);
    }

    public void startCameraPreview(ICameraPreview r100, boolean r101) {
        this.mRecorder.startCameraPreview(r100, r101);
    }

    public void startFluencyTracking(String r100, boolean r101) {
        this.mRecorder.startFluencyTracking(r100, r101);
    }

    public void startMediaRecord(String r100, ICameraCapture r101) throws IOException {
        this.mRecorder.startMediaRecord(r100, r101);
    }

    public int startPlayTrack(int r100, int r101) {
        return this.mRecorder.startPlayTrack(r100, r101, false);
    }

    public void startPreviewAsync(Surface r100, VEListener.VECallListener r101) {
        e r102 = new e(r101);
        this.mRecorder.startPreviewAsync(r100, r102);
    }

    public int startRecord(String r100, float r101) {
        VELogUtil.i(TAG, "startRecord in mp4 mode...");
        int r102 = this.mRecorder.startRecord(r100, r101);
        JSONObject r103 = new JSONObject();
        r103.put("rate", r101);     // Catch: JSONException -> L10
        r103.put("resultCode", r102);     // Catch: JSONException -> L10
        if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_start_record_async", r103, "business");     // Catch: JSONException -> L10
    L13:
    L12:
        return r102;
    L7:
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_start_record_async", r103, "business", false, true);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public void startRecordAsync(float r100, VEListener.VECallListener r101) {
        n r102 = new n(r100, r101);
        this.mRecorder.startRecordAsync(r100, r102);
    }

    public void stopFluencyTracking(String r100, FluencyTrackingCallback r101) {
        this.mRecorder.stopFluencyTracking(r100, r101);
    }

    public int stopPrePlay(VEListener.VECallListener r100, com.ss.android.vesdk.model.d r101) {
        return this.mRecorder.stopPrePlay(r100, r101);
    }

    public void stopPreviewAsync(VEListener.VECallListener r100, boolean r101) {
        this.mRecorder.stopPreviewAsync(r100, r101);
    }

    public boolean suspendGestureRecognizer(VEGestureEvent r100, boolean r101) {
        return this.mRecorder.suspendGestureRecognizer(r100, r101);
    }

    public void switchSingleOrDualCamera(ICameraCapture r100, boolean r101) {
        this.mRecorder.switchSingleOrDualCamera(r100, r101);
    }

    public void updateAlgorithmRuntimeParam(VEAlgorithmRuntimeParamKey r100, float r101) {
        this.mRecorder.updateAlgorithmRuntimeParam(r100.getValue(), r101);
    }

    public VERecorder(String r100, Context r101) throws VEException {
        this(r100, r101, null);
    }

    public int processTouchEvent(float r100, float r101) {
        return this.mRecorder.processTouchEvent(r100, r101);
    }

    public VERecorder(String r100, Context r101, jic.e r102) throws VEException {
        this.mModelDownload = null;
        this.mFaceBeautifyDetectIndex = -1;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.mResManager = new com.ss.android.vesdk.runtime.b(r100);
        this.mVERuntime = VERuntime.getInstance();
        this.mRecorder = getTERecorder(r101, r102);
        return;
    L7:
        throw new VEException(-100, "workSpace is null");
    }

    private int setFilter(String r100, float r101, boolean r102) {
        fic.a r103 = new fic.a();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        String[] r104 = r100.split(File.separator);
        if (r104.length <= 0) goto L7;
        String r105 = r104[r104.length - 1];
    L8:
        float r106 = Math.min(1.0f, Math.max(r101, 0.0f));
        r103.c("iesve_verecorder_set_filter_click_idfilter_id", r105);
        r103.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r103);
        int r107 = this.mRecorder.setFilter(r100, r106, r102);
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L11
        r108.put("filterId", r105);     // Catch: JSONException -> L11
        r108.put("intensity", String.valueOf(r106));     // Catch: JSONException -> L11
        r108.put("tag", "setFilter");     // Catch: JSONException -> L11
        r108.put("resultCode", r107);     // Catch: JSONException -> L11
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_single_filter", r108, "business");     // Catch: JSONException -> L11
    L13:
        return r107;
    L11:
        e = move-exception;
        e.printStackTrace();
    L7:
        r105 = "";
        goto L8
    }

    public void addSticker(Bitmap r100, int r101, int r102) {
        this.mRecorder.addSticker(r100, r101, r102);
    }

    public int animateImageToPreview(String r100, String r101, boolean r102) {
        if (r101 != null) goto L6;
        VELogUtil.e(TAG, "Illegal argument. imagePath can't be null. Consider using empty string to cancel.");
        return -100;
    L6:
        return this.mRecorder.animateImageToPreview(r100, r101, r102);
    }

    public int animateImagesToPreview(List<String> r100, List<VEFrame> r101, boolean r102) {
        return this.mRecorder.animateImagesToPreview(r100, r101, r102);
    }

    public int appendComposerNodesWithTag(String[] r100, int r101, String[] r102) {
        VEEffectParams r103 = new VEEffectParams();
        r103.TYPE = VEEffectParams.EFFECT_TYPE_APPEND_COMPOSER_WITH_TAG;
        r103.intValueOne = r101;
        r103.stringArrayOne = new ArrayList(Arrays.asList(r100));
        r103.stringArrayTwo = new ArrayList(Arrays.asList(r102));
        VELogUtil.w(TAG, "appendComposerNodes...");
        if (r103.stringArrayOne.size() == r101) goto L5;
    L9:
        VELogUtil.e(TAG, "Nodes size=" + r103.stringArrayOne.size() + ", tags size=" + r103.stringArrayTwo.size() + ", but nodeNum=" + r101);
        return -100;
    L5:
        if (r103.stringArrayTwo.size() != r101) goto L9;
        return this.mRecorder.setVEEffectParams(r103);
    }

    public void changeSurface(Surface r100, int r101, int r102) {
        this.mRecorder.changeSurface(r100, r101, r102);
    }

    public void changeSurfaceSync(Surface r100, int r101, int r102) {
        this.mRecorder.changeSurfaceSync(r100, r101, r102);
    }

    public int[] checkComposerNodeExclusion(String r100, String r101, String r102) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        if (r102 == null) goto L9;
        return this.mRecorder.checkComposerNodeExclusion(r100, r101, r102);
    L9:
        return new int[]{-1, 0};
    }

    public String[] concat(int r100, String r101, String r102) throws VEException {
        return concat(r100, r101, r102, -1);
    }

    public boolean getSmallWindowSnapshot(int r100, int r101, g0 r102) {
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L7;
        return this.mRecorder.getSmallWindowSnapshot(r100, r101, r102);
    L7:
        throw new IllegalArgumentException("invalid width or height...");
    }

    public int initFollowingShotWindow(String r100, long r101, long r110) {
        return this.mRecorder.initFollowingShotWindow(r100, r101, r110);
    }

    public int preloadResources(long r100, long r110, long r111) {
        return this.mRecorder.preloadResources(r100, r110, r111);
    }

    public int reloadComposerNodesWithTag(String[] r100, int r101, String[] r102) {
        VEEffectParams r103 = new VEEffectParams();
        r103.TYPE = VEEffectParams.EFFECT_TYPE_RELOAD_COMPOSER_WITH_TAG;
        r103.intValueOne = r101;
        r103.stringArrayOne = new ArrayList(Arrays.asList(r100));
        r103.stringArrayTwo = new ArrayList(Arrays.asList(r102));
        VELogUtil.w(TAG, "reloadComposerNodes...");
        if (r103.stringArrayOne.size() == r101) goto L5;
    L9:
        VELogUtil.e(TAG, "Nodes size=" + r103.stringArrayOne.size() + ", tags size=" + r103.stringArrayTwo.size() + ", but nodeNum=" + r101);
        return -100;
    L5:
        if (r103.stringArrayTwo.size() != r101) goto L9;
        return this.mRecorder.setVEEffectParams(r103);
    }

    public void renderFrame(Bitmap r100, int r101, int r102) {
        this.mRecorder.renderFrame(r100, r101, r102, false, null);
    }

    public int seekTrack(int r100, int r101, long r102) {
        return this.mRecorder.seekTrack(r100, r101, r102);
    }

    public void setCaptureResize(boolean r100, int[] r101, int[] r102) {
        this.mRecorder.setCaptureResize(r100, r101, r102);
    }

    public int setComposerNodesWithTag(String[] r100, int r101, String[] r102) {
        VEEffectParams r103 = new VEEffectParams();
        r103.TYPE = VEEffectParams.EFFECT_TYPE_SET_COMPOSER_WITH_TAG;
        r103.intValueOne = r101;
        r103.stringArrayOne = new ArrayList(Arrays.asList(r100));
        r103.stringArrayTwo = new ArrayList(Arrays.asList(r102));
        VELogUtil.w(TAG, "setComposerNodesWithTag...");
        if (r103.stringArrayOne.size() == r101) goto L5;
    L20:
        VELogUtil.e(TAG, "Nodes size=" + r103.stringArrayOne.size() + ", tags size=" + r103.stringArrayTwo.size() + ", but nodeNum=" + r101);
        return -100;
    L5:
        if (r103.stringArrayTwo.size() != r101) goto L20;
        int r104 = this.mRecorder.setVEEffectParams(r103);
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L17
        String r106 = null;
        if (r100 == null) goto L11;
        String r107 = Arrays.toString(r100);     // Catch: JSONException -> L17
    L12:
        r105.put("path", r107);     // Catch: JSONException -> L17
        if (r102 == null) goto L15;
        r106 = Arrays.toString(r102);     // Catch: JSONException -> L17
    L15:
        r105.put("nodeTag", r106);     // Catch: JSONException -> L17
        r105.put("nodeValue", String.valueOf(r101));     // Catch: JSONException -> L17
        r105.put("resultCode", String.valueOf(r104));     // Catch: JSONException -> L17
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_composer", r105, "business", false, true);     // Catch: JSONException -> L17
    L19:
        return r104;
    L11:
        r107 = null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public void setCustomVideoBg(String r100, String r101, String r102) {
        this.mRecorder.setCustomVideoBg(r100, r101, r102);
    }

    public void setExternalFaceMakeupOpacity(String r100, float r101, float r102) {
        VELogUtil.i(TAG, "setExternalFaceMakeupOpacity: path " + r100 + ", male " + r101 + ", female " + r102);
        this.mRecorder.setExternalFaceMakeupOpacity(r100, r101, r102);
    }

    public int setFaceMakeUp(String r100, float r101, float r102) {
        fic.a r103 = new fic.a();
        r103.a("iesve_verecorder_set_lipstick_and_blusher_level", r101);
        r103.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r103);
        int r104 = this.mRecorder.setFaceMakeUp(r100, r101, r102);
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L5
        r105.put("strResPath", r100);     // Catch: JSONException -> L5
        r105.put("fLipstickIntensity", String.valueOf(r101));     // Catch: JSONException -> L5
        r105.put("fBlusherIntensity", String.valueOf(r101));     // Catch: JSONException -> L5
        r105.put("resultCode", r104);     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_face_make_up_intensity", r105, "business");     // Catch: JSONException -> L5
    L7:
        return r104;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int setFaceReshape(String r100, float r101, float r102) {
        fic.a r103 = new fic.a();
        r103.a("iesve_verecorder_set_bigeyes_smallface_level", r101);
        r103.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r103);
        int r104 = this.mRecorder.setFaceReshape(r100, r101, r102);
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L5
        r105.put("strResPath", r100);     // Catch: JSONException -> L5
        r105.put("fEyeIntensity", String.valueOf(r101));     // Catch: JSONException -> L5
        r105.put("fCheekIntensity", String.valueOf(r102));     // Catch: JSONException -> L5
        r105.put("resultCode", r104);     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_face_reshape", r105, "business");     // Catch: JSONException -> L5
    L7:
        return r104;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int setLandscape(int r100, int r101, int r102) {
        return this.mRecorder.setLandscape(r100, r101, r102);
    }

    public void setMockPreviewSettings(Bitmap r100, int r101, int r102) {
        this.mRecorder.setMockPreviewSettings(r100, r101, r102);
    }

    public void setSubSurface(Surface r100, int r101, int r102) {
        this.mRecorder.setSubSurface(r100, r101, r102);
    }

    public int startPlayTrack(int r100, int r101, boolean r102) {
        return this.mRecorder.startPlayTrack(r100, r101, r102);
    }

    public int startRecord(String r100, String r101, float r102) {
        VELogUtil.i(TAG, "startRecord (this@" + System.identityHashCode(this) + "), timestamp=" + System.currentTimeMillis());
        int r103 = this.mRecorder.startRecord(r100, r101, r102);
        JSONObject r104 = new JSONObject();
        r104.put("rate", r102);     // Catch: JSONException -> L10
        r104.put("resultCode", r103);     // Catch: JSONException -> L10
        if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == true) goto L7;
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_start_record_async", r104, "business");     // Catch: JSONException -> L10
    L13:
    L12:
        return r103;
    L7:
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_start_record_async", r104, "business", false, true);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public int updateClipsTimelineParam(int r100, int r101, Map<Integer, VEClipTimelineParam> r102) {
        return this.mRecorder.updateClipsTimelineParam(r100, r101, r102);
    }

    public int updateComposerNode(String r100, String r101, float r102) {
        int r103 = this.mRecorder.updateComposerNode(r100, r101, r102);
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L5
        r104.put("path", r100);     // Catch: JSONException -> L5
        r104.put("nodeTag", r101);     // Catch: JSONException -> L5
        r104.put("nodeValue", String.valueOf(r102));     // Catch: JSONException -> L5
        r104.put("resultCode", String.valueOf(r103));     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.b("vesdk_event_recorder_composer", r104, "business", false, true);     // Catch: JSONException -> L5
    L7:
        return r103;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void updateRotation(float r100, float r101, float r102) {
        this.mRecorder.updateRotation(r100, r101, r102);
    }

    public int updateTrack(int r100, int r101, VETrackParams r102) {
        return this.mRecorder.updateTrack(r100, r101, r102);
    }

    public VERecorder(VERecorderResManager r100, Context r101, jic.e r102) {
        this.mModelDownload = null;
        this.mFaceBeautifyDetectIndex = -1;
        this.mResManager = r100;
        this.mVERuntime = VERuntime.getInstance();
        this.mRecorder = getTERecorder(r101, r102);
    }

    public void setFilter(String r100, String r101, float r102) {
        fic.a r103 = new fic.a();
        String r104 = "";
        if (TextUtils.isEmpty(r100) == true) goto L7;
        String[] r105 = r100.split(File.separator);
        if (r105.length <= 0) goto L7;
        String r106 = r105[r105.length - 1];
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        String[] r107 = r101.split(File.separator);
        if (r107.length <= 0) goto L13;
        r104 = r107[r107.length - 1];
    L13:
        r103.c("iesve_verecorder_set_filter_slide_left_id", r106);
        r103.c("iesve_verecorder_set_filter_slide_right_id", r104);
        r103.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r103);
        this.mRecorder.setFilter(r100, r101, r102);
        return;
    L7:
        r106 = "";
        goto L9
    }

    public VERecorder(String r100, Activity r101, SurfaceView r102) throws VEException {
        this(r100, r101, new jic.c(r102));
    }

    public VERecorder(String r100, Activity r101, TextureView r102) throws VEException {
        this(r100, r101, new jic.d(r102));
    }

    public VERecorder(String r100, Context r101, SurfaceView r102) throws VEException {
        this(r100, r101, new jic.c(r102));
    }

    public VERecorder(String r100, Context r101, TextureView r102) throws VEException {
        this(r100, r101, new jic.d(r102));
    }

    public int alignTo(int r100, int r101, int r102, int r103) {
        return this.mRecorder.alignTo(r100, r101, r102, r103);
    }

    public void clearDisplayColor(int r100, int r101, int r102, int r103) {
        this.mRecorder.clearDisplayColor(r100, r101, r102, r103);
    }

    public String[] concat(int r110, String r111, String r112, int r113) throws VEException {
        this.mResManager.genConcatSegmentVideoPath();
        this.mResManager.genConcatSegmentAudioPath();
        String r100 = this.mResManager.getConcatSegmentVideoPath();
        String r101 = this.mResManager.getConcatSegmentAudioPath();
        VEFileUtils.deleteFile(r100);
        VEFileUtils.deleteFile(r101);
        if (getCurRecordMode() != VERecordMode.DUET) goto L7;
        String r102 = this.mRecorder.getDuetAudioPath();
        if (r102 == null) goto L8;
        r101 = r102;
    L8:
        String r103 = r101;
        int r114 = this.mRecorder.concat(r100, r103, r110, r111, r112, r113);
        if (r114 < 0) goto L13;
        return new String[]{r100, r103};
    L13:
        throw new VEException(r114, "concat failed: " + r114);
    L7:
        getCurRecordMode();
        goto L8
    }

    public void concatAsync(int r100, String r101, String r102, VEListener.VEConcatListener r110) {
        concatAsync(r100, r101, r102, r110, -1);
    }

    public int init(VECameraSettings r100, VEVideoEncodeSettings r110, VEAudioEncodeSettings r111, VEPreviewSettings r112) throws VEException {
        return this.mRecorder.init(r100, r110, r111, r112, this.mResManager.getSegmentDirPath(), this.mVERuntime.getEnv().a());
    L5:
        e = move-exception;
        throw new VEException(-1, "init failed: VESDK need to be init: " + Log.getStackTraceString(e));
    }

    public void notifyFollowShotSurfaceChanged(Surface r100, int r101, int r102, boolean r103) {
        this.mRecorder.notifyFollowShotSurfaceChanged(r100, r101, r102, r103);
    }

    public void notifySurfaceChanged(int r100, int r101, int r102, boolean r103) {
        this.mRecorder.notifySurfaceChanged(r100, r101, r102, r103);
    }

    public int replaceComposerNodes(String[] r100, int r101, String[] r102, int r103) {
        return this.mRecorder.replaceComposerNodes(r100, r101, r102, r103);
    }

    public void sendEffectMsg(int r100, long r101, long r110, String r111) {
        this.mRecorder.sendEffectMsg(r100, r101, r110, r111);
    }

    public void setBackground(int r100, int r101, int r102, int r103) {
        this.mRecorder.setBackground(r100, r101, r102, r103);
    }

    public void setFocus(float r100, float r101, int r102, int r103) {
        this.mRecorder.setFocus(r100, r101, r102, r103);
    }

    public void setFollowingShotWindowsBackground(int r100, int r101, int r102, int r103) {
        if (r100 >= 0) goto L4;
    L11:
        VELogUtil.e(TAG, "setFollowingShotWindowsBackground invalid param.");
    L12:
        this.mRecorder.setFollowingShotWindowsBackground(r100, r101, r102, r103);
        return;
    L4:
        if (r100 > 255) goto L11;
        if (r101 < 0) goto L11;
        if (r101 > 255) goto L11;
        if (r102 < 0) goto L11;
        if (r102 > 255) goto L11;
        if (r103 < 0) goto L11;
        if (r103 <= 255) goto L12;
        goto L11
    }

    public void setReactPosMarginInVideoRecordPixel(int r100, int r101, int r102, int r103) {
        this.mRecorder.setReactPosMarginInVideoRecordPixel(r100, r101, r102, r103);
    }

    public int setRecordBGM(String r100, int r101, int r110, int r111) {
        return this.mRecorder.setRecordBGM(r100, r101, r110, r111);
    }

    public void setScanArea(float r100, float r101, float r102, float r103) {
        this.mRecorder.setScanArea(r100, r101, r102, r103);
    }

    public int slamDeviceConfig(boolean r100, boolean r101, boolean r102, boolean r103) {
        return this.mRecorder.slamDeviceConfig(r100, r101, r102, r103);
    }

    public int slamProcessIngestAcc(double r110, double r111, double r112, double r113) {
        return this.mRecorder.slamProcessIngestAcc(r110, r111, r112, r113);
    }

    public int slamProcessIngestGra(double r110, double r111, double r112, double r113) {
        return this.mRecorder.slamProcessIngestGra(r110, r111, r112, r113);
    }

    public int slamProcessIngestGyr(double r110, double r111, double r112, double r113) {
        return this.mRecorder.slamProcessIngestGyr(r110, r111, r112, r113);
    }

    public int slamProcessTouchEventByType(int r100, float r101, float r102, int r103) {
        return this.mRecorder.slamProcessTouchEventByType(r100, r101, r102, r103);
    }

    public int slamSetInputText(String r100, int r101, int r102, String r103) {
        return this.mRecorder.slamSetInputText(r100, r101, r102, r103);
    }

    public int switchEffect(String r100, int r101, int r102, boolean r103) {
        return switchEffectWithTag(r100, r101, r102, "");
    }

    public int switchEffectWithTag(String r100, int r101, int r102, String r103) {
        VEEffectFilterParam r104 = new VEEffectFilterParam();
        r104.effectPath = r100;
        r104.stickerId = r101;
        r104.reqId = r102;
        r104.stickerTag = r103;
        return switchEffect(r104);
    }

    public int tryRestore(List<VETimeSpeedModel> r100, String r101, int r102, int r103) {
        return this.mRecorder.tryRestore(r100, r101, r102, r103);
    }

    public int updateMultiComposerNodes(int r100, String[] r101, String[] r102, float[] r103) {
        if (r100 != 0) goto L4;
        return -100;
    L4:
        if (r101.length == r102.length) goto L6;
        return -100;
    L6:
        if (r102.length == r103.length) goto L9;
        return -100;
    L9:
        return this.mRecorder.updateMultiComposerNodes(r100, r101, r102, r103);
    }

    public void useAudioGraphOutput(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.mRecorder.useAudioGraphOutput(r100, r101, r102, r103);
    }

    public int init(ICameraCapture r100, VEVideoEncodeSettings r101, VEAudioEncodeSettings r102, VEPreviewSettings r110) {
        return init(r100, r101, r102, r110, false);
    }

    public boolean addPipRenderTarget(Surface r100, int r101, int r102, Bitmap r110, boolean r111) {
        return this.mRecorder.addPipRenderTarget(r100, r101, r102, r110, r111);
    }

    public void capture(int r100, boolean r101, boolean r102, w r110, v r111) {
        this.mRecorder.capture(r100, r101, r102, r110, r111);
    }

    public void clearDisplayColor(int r100, int r101, int r102, int r110, int r111) {
        this.mRecorder.clearDisplayColor(r100, r101, r102, r110, r111);
    }

    public void concatAsync(int r110, String r111, String r112, VEListener.VEConcatListener r113, int r114) {
        this.mResManager.genConcatSegmentVideoPath();     // Catch: VEException -> L9
        this.mResManager.genConcatSegmentAudioPath();     // Catch: VEException -> L9
        String r100 = this.mResManager.getConcatSegmentVideoPath();
        String r101 = this.mResManager.getConcatSegmentAudioPath();
        String r102 = r100 + DefaultDiskStorage.FileType.TEMP;
        String r103 = r101 + DefaultDiskStorage.FileType.TEMP;
        VEFileUtils.deleteFile(r102);
        VEFileUtils.deleteFile(r103);
        VEFileUtils.renameFile(r100, r102);
        VEFileUtils.renameFile(r101, r103);
        if (getCurRecordMode() == VERecordMode.DUET) goto L7;
        getCurRecordMode();
    L7:
        this.mRecorder.concatAsync(r100, r101, r110, r111, r112, new p(r100, r102, r101, r103, r113), r114);
        return;
    L9:
        e = move-exception;
        TELogUtils.e(TAG, "No need to concat because: " + e.getMsgDes());
        if (r113 == null) goto L16;
        r113.onDone(-108, "", "");
        return;
    }

    public int init(ICameraCapture r110, VEVideoEncodeSettings r111, VEAudioEncodeSettings r112, VEPreviewSettings r113, boolean r114) {
        y0.a("VECamera-VERecorder-init");
        long r100 = System.currentTimeMillis();
        int r115 = -1;
        int r101 = this.mRecorder.init(r110, r111, r112, r113, this.mResManager.getSegmentDirPath(), this.mVERuntime.getEnv().a(), r114);     // Catch: Throwable -> L11 JSONException -> L13 NullPointerException -> L17
    L9:
        e = e;
        r115 = r101;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L11
        y0.b();
        return r115;
    L5:
        if (com.ss.android.ttve.monitor.i.f449943c == true) goto L7;
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L9 Throwable -> L11 NullPointerException -> L17
        r102.put("duration", System.currentTimeMillis() - r100);     // Catch: JSONException -> L9 Throwable -> L11 NullPointerException -> L17
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_init", r102, "performance");     // Catch: JSONException -> L9 Throwable -> L11 NullPointerException -> L17
    L7:
        y0.b();
        return r101;
    L13:
        e = e;
    L17:
        e = move-exception;
        throw new VEException(-1, "init failed: VESDK need to be init: " + Log.getStackTraceString(e));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        y0.b();
        throw th;
    }

    public void renderFrame(Bitmap r100, int r101, int r102, boolean r110, b0 r111) {
        this.mRecorder.renderFrame(r100, r101, r102, r110, r111);
    }

    public int replaceComposerNodesWithTag(String[] r100, int r101, String[] r102, int r103, String[] r104) {
        VEEffectParams r105 = new VEEffectParams();
        r105.TYPE = VEEffectParams.EFFECT_TYPE_REPLACE_COMPOSER_WITH_TAG;
        r105.intValueOne = r101;
        r105.intValueTwo = r103;
        r105.stringArrayOne = new ArrayList(Arrays.asList(r100));
        r105.stringArrayTwo = new ArrayList(Arrays.asList(r102));
        r105.stringArrayThree = new ArrayList(Arrays.asList(r104));
        VELogUtil.w(TAG, "replaceComposerNodes...");
        return this.mRecorder.setVEEffectParams(r105);
    }

    public void setFilterNew(String r110, String r111, float r112, float r113, float r114) {
        fic.a r100 = new fic.a();
        String r101 = "";
        if (TextUtils.isEmpty(r110) == true) goto L8;
        String[] r102 = r110.split(File.separator);
        if (r102.length <= 0) goto L8;
        String r103 = r102[r102.length - 1];
    L10:
        if (TextUtils.isEmpty(r111) == true) goto L15;
        String[] r104 = r111.split(File.separator);
        if (r104.length <= 0) goto L15;
        r101 = r104[r104.length - 1];
    L15:
        float r105 = 1.0f;
        if (r113 <= 1.0f) goto L18;
        float r106 = 1.0f;
    L20:
        if (r114 > 1.0f) goto L24;
        r105 = r114;
    L24:
        if (r106 >= 0.0f) goto L26;
        float r115 = -1.0f;
    L28:
        if (r105 >= 0.0f) goto L30;
        float r107 = -1.0f;
    L31:
        r100.c("iesve_verecorder_set_filter_slide_left_id", r103);
        r100.c("iesve_verecorder_set_filter_slide_right_id", r101);
        r100.b("old", 1);
        com.ss.android.ttve.monitor.g.b(r100);
        this.mRecorder.setFilterNew(r110, r111, r112, r115, r107);
        return;
    L30:
        r107 = r105;
        goto L31
    L26:
        r115 = r106;
        goto L28
    L18:
        r106 = r113;
    L8:
        r103 = "";
        goto L10
    }

    public int slamProcessPanEvent(float r100, float r101, float r102, float r110, float r111) {
        return this.mRecorder.slamProcessPanEvent(r100, r101, r102, r110, r111);
    }

    public int switchEffectWithTag(String r100, int r101, int r102, boolean r103, String r104) {
        VEEffectFilterParam r105 = new VEEffectFilterParam();
        r105.effectPath = r100;
        r105.stickerId = r101;
        r105.reqId = r102;
        r105.stickerTag = r104;
        r105.needReload = r103;
        r105.isSyncLoadResource = true;
        return switchEffect(r105);
    }

    public int tryRestore(String r100, int r101, int r102, int r110, int r111) {
        return this.mRecorder.tryRestore(r100, r101, r102, r110, r111);
    }

    public void tryRestoreAsync(List<VETimeSpeedModel> r100, String r101, int r102, int r110, VEListener.VECallListener r111) {
        this.mRecorder.tryRestoreAsync(r100, r101, r102, r110, r111);
    }

    public int[] updateReactionRegion(int r100, int r101, int r102, int r110, float r111) {
        return this.mRecorder.updateReactionRegion(r100, r101, r102, r110, r111);
    }

    public int init(VECameraSettings r110, VEVideoEncodeSettings r111, VEAudioEncodeSettings r112, VEPreviewSettings r113, boolean r114) throws VEException {
        return this.mRecorder.init(r110, r111, r112, r113, this.mResManager.getSegmentDirPath(), this.mVERuntime.getEnv().a(), r114);
    L5:
        e = move-exception;
        throw new VEException(-1, "init failed: VESDK need to be init: " + Log.getStackTraceString(e));
    }

    public int init(VECameraSettings r100, VEVideoEncodeSettings r101, VEAudioEncodeSettings r102, int r110, int r111) throws VEException {
        return this.mRecorder.init(r100, r101, r102, this.mResManager.getSegmentDirPath(), this.mVERuntime.getEnv().a());
    L5:
        e = move-exception;
        throw new VEException(-1, "init failed: VESDK need to be init: " + Log.getStackTraceString(e));
    }

    public void renderFrame(VEFrame r100, int r101, int r102, VERotation r103, boolean r104, b0 r105) {
        this.mRecorder.renderFrame(r100, r101, r102, r105);
    }

    public void setPreviewRatio(VEPreviewRadio r210, VESize r211, VESize r212, VESize r213, int r214, Context r215) {
        VEPreviewRadio r100 = r210;
        long r101 = System.currentTimeMillis();
        int r102 = VEScreenUtils.getScreenWidth(r215);
        int r103 = VEScreenUtils.getScreenHeight(r215);
        if (VERuntime.getInstance().isEnableRefactorRecorder() == false) goto L6;
        this.mRecorder.setPreviewRatio(r210.ordinal(), 0.0f, r211, r212);
        return;
    L6:
        if (r213 == null) goto L11;
        if (r100 != VEPreviewRadio.RADIO_FULL) goto L11;
        r102 = r213.width;
        r103 = r213.height;
    L11:
        if ((r102 * 16) != (r103 * 9)) goto L18;
        VEPreviewRadio r104 = VEPreviewRadio.RADIO_FULL;
        if (r100 != r104) goto L16;
        r100 = VEPreviewRadio.RADIO_9_16;
    L16:
        if (this.mRecorder.mPreviewRadioMode != r104.ordinal()) goto L18;
        this.mRecorder.mPreviewRadioMode = VEPreviewRadio.RADIO_9_16.ordinal();
    L18:
        int r105 = r100.ordinal();
        com.ss.android.vesdk.p r110 = this.mRecorder;
        if (r105 == r110.mPreviewRadioMode) goto L21;
    L29:
        if (r212 == null) goto L31;
        VESize r106 = r212;
    L32:
        int r111 = this.mRecorder.mPreviewRadioMode;
        VEPreviewRadio r112 = VEPreviewRadio.RADIO_9_16;
        if (r111 == r112.ordinal()) goto L41;
        if (r100 == r112) goto L41;
        int r113 = this.mRecorder.mPreviewRadioMode;
        VEPreviewRadio r114 = VEPreviewRadio.RADIO_FULL;
        if (r113 == r114.ordinal()) goto L41;
        if (r100 == r114) goto L41;
        boolean r115 = false;
    L43:
        if ((r214 & 4) == 0) goto L52;
        int r116 = this.mRecorder.mPreviewRadioMode;
        VEPreviewRadio r117 = VEPreviewRadio.RADIO_FULL;
        if (r116 != r117.ordinal()) goto L49;
        if (r100 != r112) goto L49;
    L51:
        r115 = false;
    L49:
        if (this.mRecorder.mPreviewRadioMode != r112.ordinal()) goto L52;
        if (r100 == r117) goto L51;
    L52:
        com.ss.android.vesdk.p r118 = this.mRecorder;
        if (r118.mRenderViewSizeChanged == false) goto L56;
        r115 = false;
    L56:
        if ((r118.getRenderView() instanceof jic.c) == false) goto L59;
        View r119 = ((jic.c) this.mRecorder.getRenderView()).f499267e;
    L61:
        int r120 = m.f455673a[r100.ordinal()];
        boolean r121 = r115;
        if (r120 == 1) goto L85;
        VEPreviewRadio r122 = r112;
        if (r120 == 2) goto L79;
        if (r120 == 3) goto L79;
        if (r120 == 4) goto L79;
        if (r120 == 5) goto L71;
        float r123 = 1.0f;
    L96:
        if (r212 == null) goto L98;
    L110:
        com.ss.android.vesdk.p r107 = this.mRecorder;
        if (r107.mCameraSettings != null) goto L113;
        r121 = false;
    L113:
        if (r121 == false) goto L119;
        if ((r214 & 2) == 0) goto L117;
        r107.forceFirstFrameHasEffect(true);
    L117:
        this.mRecorder.setPreviewRatio(r100.ordinal(), r123, r211, r106);
        jic.e r108 = this.mRecorder.getRenderView();
        r108.f499273d.a(new f(this, r101));
        this.mRecorder.stopPreviewAsync(new g(r119));
    L133:
        this.mRecorder.mPreviewRadioMode = r100.ordinal();
        return;
    L119:
        if (r107.mPreviewRadioMode != r122.ordinal()) goto L123;
        if (r100 != VEPreviewRadio.RADIO_FULL) goto L123;
    L128:
        r119.requestLayout();
    L129:
        com.ss.android.vesdk.p r109 = this.mRecorder;
        if (r109.mRenderViewSizeChanged == true) goto L132;
        r109.setPreviewRatio(r100.ordinal(), 0.0f, null, r106);
    L132:
        this.mRecorder.mRenderViewSizeChanged = false;
    L123:
        if (this.mRecorder.mPreviewRadioMode != VEPreviewRadio.RADIO_FULL.ordinal()) goto L127;
        if (r100 == r122) goto L128;
    L127:
        if (this.mRecorder.mRenderViewSizeChanged == false) goto L129;
    L98:
        if (r100 != VEPreviewRadio.RADIO_1_1) goto L100;
    L101:
        r106.height = r106.width;
    L103:
        if ((r214 & 1) == 0) goto L110;
        int r124 = r106.width;
        int r125 = 720;
        if (r124 < 720) goto L110;
        float r126 = (r106.height * 1.0f) / r124;
        if (this.mRecorder.getRenderView().f499270a >= 720) goto L109;
        r125 = this.mRecorder.getRenderView().f499270a;
    L109:
        r106.width = r125;
        r106.height = (int) (r125 * r126);
        goto L110
    L100:
        if (r100 != VEPreviewRadio.RADIO_ROUND) goto L103;
    L71:
        r123 = (r102 * 1.0f) / r103;
        r119.getLayoutParams().width = r102;
        if (r213 != null) goto L78;
        ViewGroup.LayoutParams r127 = r119.getLayoutParams();
        if (r213 == null) goto L76;
        int r128 = r213.height;
    L77:
        r127.height = r128;
        goto L96
    L76:
        r128 = -1;
        goto L77
    L78:
        r119.getLayoutParams().height = r103;
    L79:
        if (r211 != null) goto L81;
    L84:
        r119.getLayoutParams().width = r102;
        r119.getLayoutParams().height = (int) ((r102 / 3.0f) * 4.0f);
        r123 = 0.75f;
        goto L96
    L81:
        if ((r211.width * 4) == (r211.height * 3)) goto L84;
        VELogUtil.e(TAG, "previewSize is not fit with PREVIEW_RADIO!");
        return;
    L85:
        r122 = r112;
        if (r211 != null) goto L88;
    L91:
        r119.getLayoutParams().width = r102;
        if ((r214 & 8) == 0) goto L94;
        r119.getLayoutParams().height = -1;
    L95:
        r123 = 0.5625f;
        goto L96
    L94:
        r119.getLayoutParams().height = (int) ((r102 / 9.0f) * 16.0f);
        goto L95
    L88:
        if ((r211.width * 16) == (r211.height * 9)) goto L91;
        VELogUtil.e(TAG, "previewSize is not fit with PREVIEW_RADIO!");
        return;
    L59:
        if ((this.mRecorder.getRenderView() instanceof jic.d) == false) goto L136;
        r119 = ((jic.d) this.mRecorder.getRenderView()).f499268e;
        goto L61
    L136:
        throw new AndroidRuntimeException("renderView not support!");
    L41:
        r115 = true;
        goto L43
    L31:
        r106 = new VESize(r211.width, r211.height);
        goto L32
    L21:
        if (r110.mCameraSettings == null) goto L29;
        if (r213 == null) goto L28;
        VESize r129 = r110.mRenderViewSize;
        if (r129 != null) goto L26;
        return;
    L26:
        if (r213.equals(r129) == true) goto L138;
        com.ss.android.vesdk.p r130 = this.mRecorder;
        r130.mRenderViewSize = r213;
        r130.mRenderViewSizeChanged = true;
        VELogUtil.i(TAG, "setPreviewRatio: View size will be changed to " + r213.toString());
        goto L29
    L138:
        return;
    }

    public void shotScreen(int r110, int r111, boolean r112, boolean r113, IBitmapShotScreenCallback r114, boolean r115) {
        long r100 = System.currentTimeMillis();
        pgc.a.a("ve_use_camera", 1);
        s r116 = new s(r110, r111, r115, r113, r100, r114);
        this.mRecorder.shotScreen(r110, r111, r112, r113, r116);
    }

    public int switchEffectWithTagSync(String r100, int r101, int r102, String r103, String[] r104, float[] r105) {
        VEEffectFilterParam r106 = new VEEffectFilterParam();
        r106.effectPath = r100;
        r106.stickerId = r101;
        r106.reqId = r102;
        r106.stickerTag = r103;
        r106.composerTags = r104;
        r106.composerValues = r105;
        r106.isSyncLoadResource = true;
        return switchEffect(r106);
    }

    public void capture(int r100, int r110, int r111, boolean r112, boolean r113, w r114, v r115) {
        d r101 = new d(r115, r100, r110);
        this.mRecorder.capture(r100, r110, r111, r112, r113, r114, r101);
    }

    public void shotScreen(int r110, int r111, boolean r112, IBitmapShotScreenCallback r113, boolean r114, IVEFrameShotScreenCallback r115, boolean r116) {
        shotScreen(r110, r111, r112, r113, r114, r115, r116, true);
    }

    public int slamDeviceConfig(boolean r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105, String r106) {
        return slamDeviceConfig(r102, r103, r104, r105);
    }

    public void shotScreen(String r210, int r211, int r212, boolean r213, boolean r214, Bitmap.CompressFormat r215, IShotScreenCallback r216, boolean r217) {
        pgc.a.a("ve_use_camera", 1);
        q r110 = new q(r211, r212, r217, r214, System.currentTimeMillis(), r216);
        this.mRecorder.shotScreen(r210, r211, r212, r213, r214, r215, r110, false);
    }

    public void shotScreen(int r110, int r111, boolean r112, IBitmapShotScreenCallback r113, boolean r114, IVEFrameShotScreenCallback r115, boolean r116, boolean r117) {
        System.currentTimeMillis();
        shotScreen(r110, r111, r112, r113, r114, r115, r116, r117, true);
    }

    public void shotScreen(int r110, int r111, boolean r112, IBitmapShotScreenCallback r210, boolean r211, IVEFrameShotScreenCallback r212, boolean r213, boolean r214, boolean r215) {
        t r113 = new t(r110, r111, r213, r112, System.currentTimeMillis(), r210);
        this.mRecorder.shotScreen(r110, r111, r112, r113, r211, r212, r214, r215);
    }

    public void shotScreen(String r110, int r111, int r112, boolean r210, boolean r211, Bitmap.CompressFormat r212, IShotScreenCallback r213, boolean r214, boolean r215) {
        r r113 = new r(r111, r112, r215, r211, System.currentTimeMillis(), r213);
        this.mRecorder.shotScreen(r110, r111, r112, r210, r211, r212, r113, r214);
    }
}
