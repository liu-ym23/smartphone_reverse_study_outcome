package com.ss.android.vesdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.camera.core.processing.util.GLUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.ttve.common.TETrackIndexManager;
import com.ss.android.ttve.mediacodec.TEAvcEncoder;
import com.ss.android.ttve.mediacodec.TEMediaCodecDecoder;
import com.ss.android.ttve.model.MVInfoBean;
import com.ss.android.ttve.model.MVResourceBean;
import com.ss.android.ttve.model.VEAudioTrackIndex;
import com.ss.android.ttve.model.VEMVAudioAlgorithmResult;
import com.ss.android.ttve.nativePort.NativeCallbacks;
import com.ss.android.ttve.nativePort.TEInterface;
import com.ss.android.ttve.nativePort.TEReverseCallback;
import com.ss.android.ttve.nativePort.TEVideoUtils;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.vesdk.algorithm.VEAlgorithmRuntimeParamKey;
import com.ss.android.vesdk.clipparam.VEAICutOutClipParam;
import com.ss.android.vesdk.clipparam.VEAlgorithmPath;
import com.ss.android.vesdk.clipparam.VEClipAlgorithmParam;
import com.ss.android.vesdk.clipparam.VEClipAuxiliaryParam;
import com.ss.android.vesdk.clipparam.VEClipParam;
import com.ss.android.vesdk.clipparam.VEClipSourceParam;
import com.ss.android.vesdk.clipparam.VEClipTimelineParam;
import com.ss.android.vesdk.clipparam.VEClipVideoFileInfoParam;
import com.ss.android.vesdk.clipparam.VECommonClipParam;
import com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam;
import com.ss.android.vesdk.filterparam.VEBaseFilterParam;
import com.ss.android.vesdk.filterparam.VECanvasFilterParam;
import com.ss.android.vesdk.filterparam.VEEffectFilterParam;
import com.ss.android.vesdk.filterparam.VERepeatFilterParam;
import com.ss.android.vesdk.filterparam.VESlowMotionFilterParam;
import com.ss.android.vesdk.filterparam.VEStickerPinAreaParam;
import com.ss.android.vesdk.filterparam.VETransitionFilterParam;
import com.ss.android.vesdk.filterparam.VEVideoTransformFilterParam;
import com.ss.android.vesdk.jni.TEAudioEffectInterface;
import com.ss.android.vesdk.runtime.VEEditorResManager;
import com.ss.android.vesdk.runtime.VEPublishSettingManager;
import com.ss.android.vesdk.runtime.VERuntime;
import com.ss.android.vesdk.settings.VEVideoCompileEncodeSettings;
import com.ss.android.vesdk.settings.VEVideoSWEncodeSettings;
import com.ss.android.vesdk.utils.BitmapLoader;
import com.ss.android.vesdk.utils.DigestUtils;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VEEditor implements SurfaceTexture.OnFrameAvailableListener {
    public static final int EDITORMODE_CROP = 0;
    public static final int EDITORMODE_EDITOR = 1;
    public static final int EDITORMODE_RECORD_EDITOR = 2;
    public static final int EDITORMODE_UNKNOWN = -1;
    private static final int ENGINE_PREPARE_FOR_COMPILE = 1;
    private static final int ENGINE_PREPARE_FOR_COMPILE_WITHWATERMARK = 2;
    protected static final int ENGINE_PREPARE_FOR_ONLYAUDIO_PLAYBACK = 3;
    protected static final int ENGINE_PREPARE_FOR_PLAYBACK = 0;
    public static final int IMAGE_RESIZE_ALGOR_BIBLINEAR = 0;
    public static final int IMAGE_RESIZE_ALGOR_LANCZOS = 215;
    public static final int IMAGE_RESIZE_MODE_ASPECT_FILL = 1;
    public static final int IMAGE_RESIZE_MODE_ASPECT_FIT = 3;
    public static final int IMAGE_RESIZE_MODE_ASPECT_NONE = 0;
    public static final int IMAGE_RESIZE_MODE_ASPECT_WIDTH = 2;
    public static final int IMAGE_RESIZE_MODE_CENTER_ZOOM = 5;
    public static final int IMAGE_RESIZE_MODE_CENTER_ZOOM_AND_ASPECTWIDTH = 7;
    public static final int IMAGE_RESIZE_MODE_FREE_MODE = 4;
    public static final int IMAGE_RESIZE_MODE_FREE_MODE_ROT = 6;
    public static final int PAGEMODE_COMPILE_CROP = 1;
    public static final int PAGEMODE_COMPILE_DOWNLOAD = 2;
    public static final int PAGEMODE_COMPILE_DOWNLOAD_SHARED = 3;
    public static final int PAGEMODE_COMPILE_IM = 12;
    public static final int PAGEMODE_COMPILE_PUBLISH = 0;
    public static final int PAGEMODE_COMPILE_UNKNOWN = -1;
    public static final int PAGEMODE_EDIRTOR_SAVE_LOCAL = 10;
    public static final int PAGEMODE_PREVIEW_EDITOR = 100;
    public static final int PAGEMODE_PREVIEW_IMPORT_PREVIEW = 103;
    public static final int PAGEMODE_PREVIEW_PUBLISH_PREVIEW = 101;
    public static final int PAGEMODE_PREVIEW_PUBLISH_SELECT_COVER = 102;
    public static final int PAGEMODE_WATERMARK = 11;
    public static final int PAUSE_COMPILE = 1;
    public static final int PAUSE_PLAYBACK = 0;
    public static final int PROBE_MODE_HW = 2;
    public static final int PROBE_MODE_NONE = 0;
    public static final int PROBE_MODE_SW = 1;
    public static final int PROBE_MODE_SW_HW = 3;
    private static final String TAG = "VEEditor";
    private static final int TESeekTo_IFrame = 2;
    public static final int TETrackDurationType_Fixed = 0;
    public static final int TETrackDurationType_FollowMax = 1;
    public static final int TETrackDurationType_FollowMin = 2;
    public static final int TETrackIndex_Default = -1;
    private static final int TETrackProperty_BGM = 1;
    private static final int TETrackProperty_OriginalSound = 0;
    public static final int TETrackType_Audio = 1;
    public static final int TETrackType_GlobalEffect = 2;
    public static final int TETrackType_Video = 0;
    private static int genReverseCount = 0;
    private static final Object mCompileProbeLock = null;
    private static volatile boolean mCompileProbeRunning = false;
    private static Map<String, Pair<Long, String>> mFileInfoCacheMap = null;
    private static volatile boolean mSAutoPrepare = true;
    long editor_time;
    private volatile VEListener.VEEditorAsyncReleaseEngineUnitResourceListener mAsyncReleaseEngineListener;
    private volatile VEListener.d mAudioDisplayListener;
    private boolean mAutoPrepare;
    private boolean mBCompileHighQualityGif;
    private boolean mBReversePlay;
    private int mBackGroundColor;
    private ogc.a mBusinessManager;
    private boolean mCancelReverse;
    private int mCanvasWrapFilterIndex;
    private volatile VEListener.VEEditorCompileListener mCompileListener;
    private String mCompileType;
    private int mConcatVideoErrorForInvalidCodecs;
    private final String mConcatVideoPath;
    private Bitmap mCurrentBmp;
    private int mEditorMode;
    private NativeCallbacks.c mEncoderDataCallback;
    private VEListener.VEEncoderListener mEncoderListener;
    private boolean mFirstFrameDrawed;
    private volatile VEListener.VEFirstFrameListener mFirstFrameListener;
    private boolean mFirstTimeSurfaceCreate;
    private NativeCallbacks.d mGetCompileFirstFrameCallback;
    private VEListener.a mGetCompileFirstFrameListener;
    private NativeCallbacks.e mGetImageCallback;
    private VEListener.VEGetImageListener mGetImageListener;
    private NativeCallbacks.e mGetSeekFrameCallback;
    private VEListener.VEGetImageListener mGetSeekFrameListener;
    private int mInPoint;
    private int mInitDisplayHeight;
    private int mInitDisplayWidth;
    private VESize mInitSize;
    private boolean mInitSuccess;
    private AtomicBoolean mIsDestroying;
    private volatile VEListener.o mKeyFrameListener;
    private Map<Integer, String> mKeyFrameMap;
    private int mMasterTrackIndex;
    private NativeCallbacks.h mMattingCallback;
    private volatile VEListener.q mMattingListener;
    private t mMessageHandler;
    private NativeCallbacks.i mOpenGLCallback;
    private int mOutPoint;
    private String mOutputFile;
    private int mPageMode;
    private float mPlayFps;
    private boolean mReDrawSurface;
    private boolean mReDrawSurfaceOnce;
    private VERecordData mRecordData;
    private VEEditorResManager mResManager;
    private boolean mReverseDone;
    private volatile VEListener.VEEditorSeekListener mSeekListener;
    private Surface mSurface;
    private SurfaceHolder.Callback2 mSurfaceCallback;
    private volatile VEListener.x mSurfaceCreatedDoneListener;
    private int mSurfaceHeight;
    private SurfaceTexture mSurfaceTexture;
    private SurfaceView mSurfaceView;
    private int mSurfaceWidth;
    private com.ss.android.ttve.monitor.j mTEMonitorFilterMgr;
    private com.ss.android.ttve.common.a mTeCommonErrorCallback;
    private com.ss.android.ttve.common.a mTeCommonInfoCallback;
    private final TextureView.SurfaceTextureListener mTextureListener;
    private TextureView mTextureView;
    private TETrackIndexManager mTrackIndexManager;
    private String mUsageType;
    private VECommonCallback mUserCommonErrorCallback;
    private VECommonCallback mUserCommonInfoCallback;
    private int mVideoBackGroundColor;
    private TEInterface mVideoEditor;
    private VIDEO_GRAVITY mVideoGravity;
    private VIDEO_RATIO mVideoOutRes;
    private volatile VEListener.VEVideoOutputListener mVideoOutputListener;
    private VIDEO_SCALETYPE mVideoScaletype;
    private dic.a mWrapperAudioExtend;
    private dic.b mWrapperBingo;
    private dic.c mWrapperFilter;
    private dic.d mWrapperMV;
    private dic.e mWrapperSequence;
    private dic.f mWrapperSticker;
    private Boolean mbSeparateAV;
    private int miCacheHitCount;
    private int miCacheMissCount;
    private int miFrameCount;
    private NativeCallbacks.f mkeyFrameCallback;
    private long mlCompileStartTime;
    private long mlCurTimeMS;
    private long mlFirstFrameWithoutSurfaceTimeMS;
    private long mlFirstPlayTimeMS;
    private long mlFirstSeekTimeMS;
    private long mlInitTimeMS;
    private long mlLastSeekTimeMS;
    private long mlLastTimeMS;
    long model_sequence_time;
    private q mp4ToGIFConverter;
    private float rotate;
    private float scaleH;
    private float scaleW;
    private VETimelineParams veTimelineParams;
    private String waterMarkFile;
    private double waterMarkHeight;
    private double waterMarkOffsetX;
    private double waterMarkOffsetY;
    private double waterMarkWidth;

    public static final enum GET_FRAMES_FLAGS extends Enum<GET_FRAMES_FLAGS> {
        private static final /* synthetic */ GET_FRAMES_FLAGS[] $VALUES = null;
        public static final GET_FRAMES_FLAGS GET_FRAMES_MODE_NOEFFECT = null;
        public static final GET_FRAMES_FLAGS GET_FRAMES_MODE_NOEFFECT_SCORE = null;
        public static final GET_FRAMES_FLAGS GET_FRAMES_MODE_NORMAL = null;
        public static final GET_FRAMES_FLAGS GET_FRAMES_MODE_NORMAL_SCORE = null;
        public static final GET_FRAMES_FLAGS GET_FRAMES_MODE_ORIGINAL = null;
        public static final GET_FRAMES_FLAGS GET_FRAMES_MODE_ORIGINAL_SCORE = null;
        private int mValue;

        private static /* synthetic */ GET_FRAMES_FLAGS[] $values() {
            return new GET_FRAMES_FLAGS[]{GET_FRAMES_MODE_NORMAL, GET_FRAMES_MODE_NOEFFECT, GET_FRAMES_MODE_ORIGINAL, GET_FRAMES_MODE_NORMAL_SCORE, GET_FRAMES_MODE_NOEFFECT_SCORE, GET_FRAMES_MODE_ORIGINAL_SCORE};
        }

        static {
            GET_FRAMES_MODE_NORMAL = new GET_FRAMES_FLAGS("GET_FRAMES_MODE_NORMAL", 0, 1);
            GET_FRAMES_MODE_NOEFFECT = new GET_FRAMES_FLAGS("GET_FRAMES_MODE_NOEFFECT", 1, 2);
            GET_FRAMES_MODE_ORIGINAL = new GET_FRAMES_FLAGS("GET_FRAMES_MODE_ORIGINAL", 2, 4);
            GET_FRAMES_MODE_NORMAL_SCORE = new GET_FRAMES_FLAGS("GET_FRAMES_MODE_NORMAL_SCORE", 3, 9);
            GET_FRAMES_MODE_NOEFFECT_SCORE = new GET_FRAMES_FLAGS("GET_FRAMES_MODE_NOEFFECT_SCORE", 4, 10);
            GET_FRAMES_MODE_ORIGINAL_SCORE = new GET_FRAMES_FLAGS("GET_FRAMES_MODE_ORIGINAL_SCORE", 5, 12);
            $VALUES = $values();
        }

        public static GET_FRAMES_FLAGS[] values() {
            return (GET_FRAMES_FLAGS[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static GET_FRAMES_FLAGS valueOf(String r100) {
            return (GET_FRAMES_FLAGS) r27.a.a(GET_FRAMES_FLAGS.class, r100);
        }

        private GET_FRAMES_FLAGS(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static final enum PREVIEW_SCALE_MODE extends Enum<PREVIEW_SCALE_MODE> {
        public static final PREVIEW_SCALE_MODE SCALE_MODE_CENTER_CROP = null;
        public static final PREVIEW_SCALE_MODE SCALE_MODE_CENTER_INSIDE = null;
        public static final PREVIEW_SCALE_MODE SCALE_MODE_FIT_FULL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PREVIEW_SCALE_MODE[] f455539a = null;

        static {
            PREVIEW_SCALE_MODE r100 = new PREVIEW_SCALE_MODE("SCALE_MODE_CENTER_CROP", 0);
            SCALE_MODE_CENTER_CROP = r100;
            PREVIEW_SCALE_MODE r101 = new PREVIEW_SCALE_MODE("SCALE_MODE_CENTER_INSIDE", 1);
            SCALE_MODE_CENTER_INSIDE = r101;
            PREVIEW_SCALE_MODE r102 = new PREVIEW_SCALE_MODE("SCALE_MODE_FIT_FULL", 2);
            SCALE_MODE_FIT_FULL = r102;
            f455539a = new PREVIEW_SCALE_MODE[]{r100, r101, r102};
        }

        public static PREVIEW_SCALE_MODE[] values() {
            return (PREVIEW_SCALE_MODE[]) f455539a.clone();
        }

        public static PREVIEW_SCALE_MODE valueOf(String r100) {
            return (PREVIEW_SCALE_MODE) r27.a.a(PREVIEW_SCALE_MODE.class, r100);
        }

        public PREVIEW_SCALE_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SCALE_MODE extends Enum<SCALE_MODE> {
        private static final /* synthetic */ SCALE_MODE[] $VALUES = null;
        public static final SCALE_MODE SCALE_MODE_CANVAS = null;
        public static final SCALE_MODE SCALE_MODE_CENTER_CROP = null;
        public static final SCALE_MODE SCALE_MODE_CENTER_INSIDE = null;
        public static final SCALE_MODE SCALE_MODE_CENTER_INSIDE_WITH_2DENGINE = null;
        public static final SCALE_MODE SCALE_MODE_FIT_END_WITH_2DENGINE = null;
        public static final SCALE_MODE SCALE_MODE_FIT_START_WITH_2DENGINE = null;

        private static /* synthetic */ SCALE_MODE[] $values() {
            return new SCALE_MODE[]{SCALE_MODE_CENTER_INSIDE, SCALE_MODE_CENTER_CROP, SCALE_MODE_CENTER_INSIDE_WITH_2DENGINE, SCALE_MODE_FIT_START_WITH_2DENGINE, SCALE_MODE_FIT_END_WITH_2DENGINE, SCALE_MODE_CANVAS};
        }

        static {
            SCALE_MODE_CENTER_INSIDE = new SCALE_MODE("SCALE_MODE_CENTER_INSIDE", 0);
            SCALE_MODE_CENTER_CROP = new SCALE_MODE("SCALE_MODE_CENTER_CROP", 1);
            SCALE_MODE_CENTER_INSIDE_WITH_2DENGINE = new SCALE_MODE("SCALE_MODE_CENTER_INSIDE_WITH_2DENGINE", 2);
            SCALE_MODE_FIT_START_WITH_2DENGINE = new SCALE_MODE("SCALE_MODE_FIT_START_WITH_2DENGINE", 3);
            SCALE_MODE_FIT_END_WITH_2DENGINE = new SCALE_MODE("SCALE_MODE_FIT_END_WITH_2DENGINE", 4);
            SCALE_MODE_CANVAS = new SCALE_MODE("SCALE_MODE_CANVAS", 5);
            $VALUES = $values();
        }

        public static SCALE_MODE[] values() {
            return (SCALE_MODE[]) $VALUES.clone();
        }

        public static SCALE_MODE valueOf(String r100) {
            return (SCALE_MODE) r27.a.a(SCALE_MODE.class, r100);
        }

        private SCALE_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SEEK_MODE extends Enum<SEEK_MODE> {
        private static final /* synthetic */ SEEK_MODE[] $VALUES = null;
        public static final SEEK_MODE EDITOR_REFRESH_MODE = null;
        public static final SEEK_MODE EDITOR_REFRESH_MODE_FOECE = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_Forward = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_Accurate = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_Accurate_Clear = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_Clear = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_Forward = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_UpdateIn = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_UpdateInOut = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_UpdateOut = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LAST_Without_EffectAndSticker = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_LastSeek = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_OnGoing = null;
        public static final SEEK_MODE EDITOR_SEEK_FLAG_ToIframe = null;
        private int mValue;

        private static /* synthetic */ SEEK_MODE[] $values() {
            return new SEEK_MODE[]{EDITOR_SEEK_FLAG_OnGoing, EDITOR_SEEK_FLAG_LastSeek, EDITOR_SEEK_FLAG_ToIframe, EDITOR_SEEK_FLAG_LAST_UpdateIn, EDITOR_SEEK_FLAG_LAST_UpdateOut, EDITOR_SEEK_FLAG_LAST_UpdateInOut, EDITOR_SEEK_FLAG_Forward, EDITOR_SEEK_FLAG_LAST_Forward, EDITOR_SEEK_FLAG_LAST_Clear, EDITOR_SEEK_FLAG_LAST_Accurate, EDITOR_SEEK_FLAG_LAST_Accurate_Clear, EDITOR_REFRESH_MODE, EDITOR_SEEK_FLAG_LAST_Without_EffectAndSticker, EDITOR_REFRESH_MODE_FOECE};
        }

        static {
            EDITOR_SEEK_FLAG_OnGoing = new SEEK_MODE("EDITOR_SEEK_FLAG_OnGoing", 0, 0);
            SEEK_MODE r100 = new SEEK_MODE("EDITOR_SEEK_FLAG_LastSeek", 1, 1);
            EDITOR_SEEK_FLAG_LastSeek = r100;
            EDITOR_SEEK_FLAG_ToIframe = new SEEK_MODE("EDITOR_SEEK_FLAG_ToIframe", 2, 2);
            EDITOR_SEEK_FLAG_LAST_UpdateIn = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_UpdateIn", 3, r100.getValue() | 4);
            EDITOR_SEEK_FLAG_LAST_UpdateOut = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_UpdateOut", 4, r100.getValue() | 8);
            EDITOR_SEEK_FLAG_LAST_UpdateInOut = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_UpdateInOut", 5, r100.getValue() | 16);
            SEEK_MODE r101 = new SEEK_MODE("EDITOR_SEEK_FLAG_Forward", 6, 128);
            EDITOR_SEEK_FLAG_Forward = r101;
            EDITOR_SEEK_FLAG_LAST_Forward = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_Forward", 7, r101.getValue() | r100.getValue());
            EDITOR_SEEK_FLAG_LAST_Clear = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_Clear", 8, r100.getValue() | 256);
            EDITOR_SEEK_FLAG_LAST_Accurate = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_Accurate", 9, r100.getValue() | 640);
            EDITOR_SEEK_FLAG_LAST_Accurate_Clear = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_Accurate_Clear", 10, r100.getValue() | MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT);
            EDITOR_REFRESH_MODE = new SEEK_MODE("EDITOR_REFRESH_MODE", 11, 1024);
            EDITOR_SEEK_FLAG_LAST_Without_EffectAndSticker = new SEEK_MODE("EDITOR_SEEK_FLAG_LAST_Without_EffectAndSticker", 12, 24577);
            EDITOR_REFRESH_MODE_FOECE = new SEEK_MODE("EDITOR_REFRESH_MODE_FOECE", 13, 536870912);
            $VALUES = $values();
        }

        public static SEEK_MODE[] values() {
            return (SEEK_MODE[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static SEEK_MODE valueOf(String r100) {
            return (SEEK_MODE) r27.a.a(SEEK_MODE.class, r100);
        }

        private SEEK_MODE(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static final enum SET_RANGE_MODE extends Enum<SET_RANGE_MODE> {
        private static final /* synthetic */ SET_RANGE_MODE[] $VALUES = null;
        public static final SET_RANGE_MODE EDITOR_TIMERANGE_FLAG_AFTER_SPEED = null;
        public static final SET_RANGE_MODE EDITOR_TIMERANGE_FLAG_BEFORE_SPEED = null;
        private int mValue;

        private static /* synthetic */ SET_RANGE_MODE[] $values() {
            return new SET_RANGE_MODE[]{EDITOR_TIMERANGE_FLAG_BEFORE_SPEED, EDITOR_TIMERANGE_FLAG_AFTER_SPEED};
        }

        static {
            EDITOR_TIMERANGE_FLAG_BEFORE_SPEED = new SET_RANGE_MODE("EDITOR_TIMERANGE_FLAG_BEFORE_SPEED", 0, 0);
            EDITOR_TIMERANGE_FLAG_AFTER_SPEED = new SET_RANGE_MODE("EDITOR_TIMERANGE_FLAG_AFTER_SPEED", 1, 1);
            $VALUES = $values();
        }

        public static SET_RANGE_MODE[] values() {
            return (SET_RANGE_MODE[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static SET_RANGE_MODE valueOf(String r100) {
            return (SET_RANGE_MODE) r27.a.a(SET_RANGE_MODE.class, r100);
        }

        private SET_RANGE_MODE(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static final enum TIME_MODE extends Enum<TIME_MODE> {
        private static final /* synthetic */ TIME_MODE[] $VALUES = null;
        public static final TIME_MODE EDITOR_NORMAl_MODE = null;
        public static final TIME_MODE EDITOR_SLOMO_MODE = null;

        private static /* synthetic */ TIME_MODE[] $values() {
            return new TIME_MODE[]{EDITOR_NORMAl_MODE, EDITOR_SLOMO_MODE};
        }

        static {
            EDITOR_NORMAl_MODE = new TIME_MODE("EDITOR_NORMAl_MODE", 0);
            EDITOR_SLOMO_MODE = new TIME_MODE("EDITOR_SLOMO_MODE", 1);
            $VALUES = $values();
        }

        public static TIME_MODE[] values() {
            return (TIME_MODE[]) $VALUES.clone();
        }

        public static TIME_MODE valueOf(String r100) {
            return (TIME_MODE) r27.a.a(TIME_MODE.class, r100);
        }

        private TIME_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEGetCompileFirstFrameType extends Enum<VEGetCompileFirstFrameType> {
        public static final VEGetCompileFirstFrameType GET_COMPILE_FIRST_FRAME_TYPE_BITMAP = null;
        public static final VEGetCompileFirstFrameType GET_COMPILE_FIRST_FRAME_TYPE_DATA = null;
        public static final VEGetCompileFirstFrameType GET_COMPILE_FIRST_FRAME_TYPE_VEBITMAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEGetCompileFirstFrameType[] f455540a = null;

        static {
            VEGetCompileFirstFrameType r100 = new VEGetCompileFirstFrameType("GET_COMPILE_FIRST_FRAME_TYPE_VEBITMAP", 0);
            GET_COMPILE_FIRST_FRAME_TYPE_VEBITMAP = r100;
            VEGetCompileFirstFrameType r101 = new VEGetCompileFirstFrameType("GET_COMPILE_FIRST_FRAME_TYPE_BITMAP", 1);
            GET_COMPILE_FIRST_FRAME_TYPE_BITMAP = r101;
            VEGetCompileFirstFrameType r102 = new VEGetCompileFirstFrameType("GET_COMPILE_FIRST_FRAME_TYPE_DATA", 2);
            GET_COMPILE_FIRST_FRAME_TYPE_DATA = r102;
            f455540a = new VEGetCompileFirstFrameType[]{r100, r101, r102};
        }

        public static VEGetCompileFirstFrameType[] values() {
            return (VEGetCompileFirstFrameType[]) f455540a.clone();
        }

        public static VEGetCompileFirstFrameType valueOf(String r100) {
            return (VEGetCompileFirstFrameType) r27.a.a(VEGetCompileFirstFrameType.class, r100);
        }

        public VEGetCompileFirstFrameType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEState extends Enum<VEState> {
        private static final /* synthetic */ VEState[] $VALUES = null;
        public static final VEState ANY = null;
        public static final VEState COMPLETED = null;
        public static final VEState ERROR = null;
        public static final VEState IDLE = null;
        public static final VEState INITIALIZED = null;
        public static final VEState NOTHING = null;
        public static final VEState PAUSED = null;
        public static final VEState PREPARED = null;
        public static final VEState SEEKING = null;
        public static final VEState STARTED = null;
        public static final VEState STOPPED = null;
        private int mValue;

        private static /* synthetic */ VEState[] $values() {
            return new VEState[]{ANY, ERROR, NOTHING, IDLE, INITIALIZED, PREPARED, STARTED, PAUSED, SEEKING, STOPPED, COMPLETED};
        }

        static {
            ANY = new VEState("ANY", 0, 65535);
            ERROR = new VEState("ERROR", 1, 0);
            NOTHING = new VEState("NOTHING", 2, 1048576);
            IDLE = new VEState("IDLE", 3, 1);
            INITIALIZED = new VEState("INITIALIZED", 4, 2);
            PREPARED = new VEState("PREPARED", 5, 4);
            STARTED = new VEState("STARTED", 6, 8);
            PAUSED = new VEState("PAUSED", 7, 16);
            SEEKING = new VEState("SEEKING", 8, 32);
            STOPPED = new VEState("STOPPED", 9, 64);
            COMPLETED = new VEState("COMPLETED", 10, 128);
            $VALUES = $values();
        }

        public static VEState[] values() {
            return (VEState[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static VEState valueOf(int r100) {
            if (r100 == 0) goto L46;
            if (r100 == 1) goto L44;
            if (r100 == 2) goto L42;
            if (r100 == 4) goto L40;
            if (r100 == 8) goto L38;
            if (r100 == 16) goto L36;
            if (r100 == 32) goto L34;
            if (r100 == 64) goto L32;
            if (r100 == 128) goto L30;
            if (r100 == 65535) goto L28;
            if (r100 == 1048576) goto L26;
            return null;
        L26:
            return NOTHING;
        L28:
            return ANY;
        L30:
            return COMPLETED;
        L32:
            return STOPPED;
        L34:
            return SEEKING;
        L36:
            return PAUSED;
        L38:
            return STARTED;
        L40:
            return PREPARED;
        L42:
            return INITIALIZED;
        L44:
            return IDLE;
        L46:
            return ERROR;
        }

        public static VEState valueOf(String r100) {
            return (VEState) r27.a.a(VEState.class, r100);
        }

        private VEState(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static final enum VIDEO_GRAVITY extends Enum<VIDEO_GRAVITY> {
        private static final /* synthetic */ VIDEO_GRAVITY[] $VALUES = null;
        public static final VIDEO_GRAVITY ALIGN_PARENT_BOTTOM = null;
        public static final VIDEO_GRAVITY ALIGN_PARENT_LEFT = null;
        public static final VIDEO_GRAVITY ALIGN_PARENT_RIGHT = null;
        public static final VIDEO_GRAVITY ALIGN_PARENT_TOP = null;
        public static final VIDEO_GRAVITY CENTER_HORIZONTAL = null;
        public static final VIDEO_GRAVITY CENTER_IN_PARENT = null;
        public static final VIDEO_GRAVITY CENTER_VERTICAL = null;

        private static /* synthetic */ VIDEO_GRAVITY[] $values() {
            return new VIDEO_GRAVITY[]{ALIGN_PARENT_LEFT, ALIGN_PARENT_TOP, ALIGN_PARENT_RIGHT, ALIGN_PARENT_BOTTOM, CENTER_IN_PARENT, CENTER_HORIZONTAL, CENTER_VERTICAL};
        }

        static {
            ALIGN_PARENT_LEFT = new VIDEO_GRAVITY("ALIGN_PARENT_LEFT", 0);
            ALIGN_PARENT_TOP = new VIDEO_GRAVITY("ALIGN_PARENT_TOP", 1);
            ALIGN_PARENT_RIGHT = new VIDEO_GRAVITY("ALIGN_PARENT_RIGHT", 2);
            ALIGN_PARENT_BOTTOM = new VIDEO_GRAVITY("ALIGN_PARENT_BOTTOM", 3);
            CENTER_IN_PARENT = new VIDEO_GRAVITY("CENTER_IN_PARENT", 4);
            CENTER_HORIZONTAL = new VIDEO_GRAVITY("CENTER_HORIZONTAL", 5);
            CENTER_VERTICAL = new VIDEO_GRAVITY("CENTER_VERTICAL", 6);
            $VALUES = $values();
        }

        public static VIDEO_GRAVITY[] values() {
            return (VIDEO_GRAVITY[]) $VALUES.clone();
        }

        public static VIDEO_GRAVITY valueOf(String r100) {
            return (VIDEO_GRAVITY) r27.a.a(VIDEO_GRAVITY.class, r100);
        }

        private VIDEO_GRAVITY(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VIDEO_RATIO extends Enum<VIDEO_RATIO> {
        private static final /* synthetic */ VIDEO_RATIO[] $VALUES = null;
        public static final VIDEO_RATIO VIDEO_OUT_RATIO_16_9 = null;
        public static final VIDEO_RATIO VIDEO_OUT_RATIO_1_1 = null;
        public static final VIDEO_RATIO VIDEO_OUT_RATIO_3_4 = null;
        public static final VIDEO_RATIO VIDEO_OUT_RATIO_4_3 = null;
        public static final VIDEO_RATIO VIDEO_OUT_RATIO_9_16 = null;
        public static final VIDEO_RATIO VIDEO_OUT_RATIO_ORIGINAL = null;

        private static /* synthetic */ VIDEO_RATIO[] $values() {
            return new VIDEO_RATIO[]{VIDEO_OUT_RATIO_1_1, VIDEO_OUT_RATIO_4_3, VIDEO_OUT_RATIO_3_4, VIDEO_OUT_RATIO_16_9, VIDEO_OUT_RATIO_9_16, VIDEO_OUT_RATIO_ORIGINAL};
        }

        static {
            VIDEO_OUT_RATIO_1_1 = new VIDEO_RATIO("VIDEO_OUT_RATIO_1_1", 0);
            VIDEO_OUT_RATIO_4_3 = new VIDEO_RATIO("VIDEO_OUT_RATIO_4_3", 1);
            VIDEO_OUT_RATIO_3_4 = new VIDEO_RATIO("VIDEO_OUT_RATIO_3_4", 2);
            VIDEO_OUT_RATIO_16_9 = new VIDEO_RATIO("VIDEO_OUT_RATIO_16_9", 3);
            VIDEO_OUT_RATIO_9_16 = new VIDEO_RATIO("VIDEO_OUT_RATIO_9_16", 4);
            VIDEO_OUT_RATIO_ORIGINAL = new VIDEO_RATIO("VIDEO_OUT_RATIO_ORIGINAL", 5);
            $VALUES = $values();
        }

        public static VIDEO_RATIO[] values() {
            return (VIDEO_RATIO[]) $VALUES.clone();
        }

        public static VIDEO_RATIO valueOf(String r100) {
            return (VIDEO_RATIO) r27.a.a(VIDEO_RATIO.class, r100);
        }

        private VIDEO_RATIO(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VIDEO_SCALETYPE extends Enum<VIDEO_SCALETYPE> {
        private static final /* synthetic */ VIDEO_SCALETYPE[] $VALUES = null;
        public static final VIDEO_SCALETYPE CENTER = null;
        public static final VIDEO_SCALETYPE CENTER_CROP = null;
        public static final VIDEO_SCALETYPE CENTER_INSIDE = null;
        public static final VIDEO_SCALETYPE FIT_CENTER = null;
        public static final VIDEO_SCALETYPE FIT_END = null;
        public static final VIDEO_SCALETYPE FIT_START = null;
        public static final VIDEO_SCALETYPE FIT_XY = null;
        public static final VIDEO_SCALETYPE MATRIX = null;

        private static /* synthetic */ VIDEO_SCALETYPE[] $values() {
            return new VIDEO_SCALETYPE[]{MATRIX, FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_CROP, CENTER_INSIDE};
        }

        static {
            MATRIX = new VIDEO_SCALETYPE("MATRIX", 0);
            FIT_XY = new VIDEO_SCALETYPE("FIT_XY", 1);
            FIT_START = new VIDEO_SCALETYPE("FIT_START", 2);
            FIT_CENTER = new VIDEO_SCALETYPE("FIT_CENTER", 3);
            FIT_END = new VIDEO_SCALETYPE("FIT_END", 4);
            CENTER = new VIDEO_SCALETYPE("CENTER", 5);
            CENTER_CROP = new VIDEO_SCALETYPE("CENTER_CROP", 6);
            CENTER_INSIDE = new VIDEO_SCALETYPE("CENTER_INSIDE", 7);
            $VALUES = $values();
        }

        public static VIDEO_SCALETYPE[] values() {
            return (VIDEO_SCALETYPE[]) $VALUES.clone();
        }

        public static VIDEO_SCALETYPE valueOf(String r100) {
            return (VIDEO_SCALETYPE) r27.a.a(VIDEO_SCALETYPE.class, r100);
        }

        private VIDEO_SCALETYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Video_Rotation extends Enum<Video_Rotation> {
        public static final Video_Rotation VideoRotation_0 = null;
        public static final Video_Rotation VideoRotation_180 = null;
        public static final Video_Rotation VideoRotation_270 = null;
        public static final Video_Rotation VideoRotation_90 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Video_Rotation[] f455541a = null;

        static {
            Video_Rotation r100 = new Video_Rotation("VideoRotation_0", 0);
            VideoRotation_0 = r100;
            Video_Rotation r101 = new Video_Rotation("VideoRotation_90", 1);
            VideoRotation_90 = r101;
            Video_Rotation r102 = new Video_Rotation("VideoRotation_180", 2);
            VideoRotation_180 = r102;
            Video_Rotation r103 = new Video_Rotation("VideoRotation_270", 3);
            VideoRotation_270 = r103;
            f455541a = new Video_Rotation[]{r100, r101, r102, r103};
        }

        public static Video_Rotation[] values() {
            return (Video_Rotation[]) f455541a.clone();
        }

        public static Video_Rotation valueOf(String r100) {
            return (Video_Rotation) r27.a.a(Video_Rotation.class, r100);
        }

        public Video_Rotation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements NativeCallbacks.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455542a;

        public a(VEEditor r100) {
            this.f455542a = r100;
        }
    }

    public class b implements NativeCallbacks.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455543a;

        public b(VEEditor r100) {
            this.f455543a = r100;
        }
    }

    public class c implements VECommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f455545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f455546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f455547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TEReverseCallback f455548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f455549f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ VEEditorResManager f455550g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ VEListener.VEEditorGenReverseListener f455551h;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f455552a;

            public final void a() {
                this.f455552a.f455544a.destroy();
                c r100 = this.f455552a;
                VEEditorResManager r101 = r100.f455550g;
                r101.mVideoPaths = new String[]{r100.f455546c};
                if (r100.f455545b == false) goto L5;
                r101.mReverseAudioPaths = new String[]{r100.f455549f};
            L5:
                r101.mReverseVideoPath = new String[]{r100.f455547d};
                r101.mReverseDone = true;
                VELogUtil.i(VEEditor.TAG, "reverse compileDone: needSeparateAudioPath = " + this.f455552a.f455545b);
                VELogUtil.i(VEEditor.TAG, "reverse compileDone: mOriginalSoundTrackType = " + this.f455552a.f455550g.mOriginalSoundTrackType);
                VEListener.VEEditorGenReverseListener r102 = this.f455552a.f455551h;
                if (r102 == null) goto L9;
                r102.onReverseDone(0);
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r100) {
                this.f455552a = r100;
            }
        }

        @Override // com.ss.android.vesdk.VECommonCallback
        public final /* synthetic */ void onCallBackForTrack(int r100, int r101, float r102, long r103) {
            VECommonCallback.CC.$default$onCallBackForTrack(this, r100, r101, r102, r103);
        }

        @Override // com.ss.android.vesdk.VECommonCallback
        public final void onCallback(int r100, int r101, float r102, String r103) {
            if (r100 == 4103) goto L9;
            if (r100 != 4105) goto L18;
            this.f455548e.onProgressChanged(((double) r102) * 0.5d);
            return;
        L18:
            return;
        L9:
            if (this.f455544a.isValid() == true) goto L11;
            return;
        L11:
            if (this.f455545b == false) goto L13;
            TEVideoUtils.reverseAllIVideo(this.f455546c, this.f455547d, this.f455548e);
        L14:
            ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "k/VEEditor$12"));
            return;
        L13:
            TEVideoUtils.reverseAllIVideoAndMuxAudio(this.f455546c, this.f455549f, this.f455547d, this.f455548e);
            goto L14
        }

        public c(VEEditor r100, boolean r101, String r102, String r103, TEReverseCallback r104, String r105, VEEditorResManager r106, VEListener.VEEditorGenReverseListener r107) {
            this.f455544a = r100;
            this.f455545b = r101;
            this.f455546c = r102;
            this.f455547d = r103;
            this.f455548e = r104;
            this.f455549f = r105;
            this.f455550g = r106;
            this.f455551h = r107;
        }
    }

    public class d implements VECommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VEListener.VEEditorGenReverseListener f455554b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f455555a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f455555a.f455553a.destroy();     // Catch: Throwable -> L6
                VEListener.VEEditorGenReverseListener r100 = this.f455555a.f455554b;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.onReverseDone(-1);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public a(d r100) {
                this.f455555a = r100;
            }
        }

        @Override // com.ss.android.vesdk.VECommonCallback
        public final /* synthetic */ void onCallBackForTrack(int r100, int r101, float r102, long r103) {
            VECommonCallback.CC.$default$onCallBackForTrack(this, r100, r101, r102, r103);
        }

        public d(VEEditor r100, VEListener.VEEditorGenReverseListener r101) {
            this.f455553a = r100;
            this.f455554b = r101;
        }

        @Override // com.ss.android.vesdk.VECommonCallback
        public final void onCallback(int r100, int r101, float r102, String r103) {
            ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "k/VEEditor$13"));
        }
    }

    public class e implements TEVideoUtils.CompileProbeListener2 {
        @Override // com.ss.android.ttve.nativePort.TEVideoUtils.CompileProbeListener2
        public final void onCompileProbeResult2(int r100, int r101, float r102, float r103, int r104, int r105, int r106, int r107, float r108) {
        }

        public e(VEVideoEncodeSettings r100, int r101) {
        }
    }

    public class f implements TEVideoUtils.CompileProbeListener {
        @Override // com.ss.android.ttve.nativePort.TEVideoUtils.CompileProbeListener
        public final void onCompileProbeResult(int r100, int r101, float r102, int r103, int r104, int r105, int r106, float r107) {
        }

        public f(int r100, VEVideoEncodeSettings r101) {
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f455556a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f455557b = null;

        static {
            int[] r100 = new int[VEVideoEncodeSettings.COMPILE_TYPE.values().length];
            f455557b = r100;
            r100[VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_MP4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L36:
            f455557b[VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_GIF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L44:
            f455557b[VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_HIGH_GIF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L56:
            f455557b[VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_TRANSPARENT_GIF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L40:
            f455557b[VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_JPEG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L46:
            f455557b[VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_PNG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r101 = new int[SCALE_MODE.values().length];
            f455556a = r101;
            r101[SCALE_MODE.SCALE_MODE_CENTER_CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L50:
            f455556a[SCALE_MODE.SCALE_MODE_CENTER_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            f455556a[SCALE_MODE.SCALE_MODE_CENTER_INSIDE_WITH_2DENGINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L42:
            f455556a[SCALE_MODE.SCALE_MODE_CANVAS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L52:
            f455556a[SCALE_MODE.SCALE_MODE_FIT_START_WITH_2DENGINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L34:
            f455556a[SCALE_MODE.SCALE_MODE_FIT_END_WITH_2DENGINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public class h implements com.ss.android.ttve.common.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455558a;

        @Override // com.ss.android.ttve.common.a
        public final /* synthetic */ void a(int r100, int r101, float r102, long r103) {
        }

        public h(VEEditor r100) {
            this.f455558a = r100;
        }

        @Override // com.ss.android.ttve.common.a
        public final void onCallback(int r100, int r101, float r110, String r111) {
            if (r100 == 4101) goto L84;
            if (r100 == 4103) goto L73;
            if (r100 == 4105) goto L65;
            if (r100 == 4129) goto L62;
            if (r100 != 4157) goto L13;
            VEEditor.access$1100(this.f455558a);
            return;
        L13:
            if (r100 == 4371) goto L58;
            if (r100 == 4133) goto L53;
            if (r100 != 4134) goto L19;
            VEEditor.access$902(this.f455558a, r110);
            return;
        L19:
            if (r100 == 4144) goto L46;
            if (r100 == 4145) goto L40;
            if (r100 == 4160) goto L35;
            if (r100 == 4161) goto L30;
            if (VEEditor.access$100(this.f455558a) == null) goto L95;
            VELogUtil.d(VEEditor.TAG, "TECommonCallback type:" + r100);
            VEEditor.access$100(this.f455558a).onCallback(r100, r101, r110, r111);
            return;
        L95:
            return;
        L30:
            if (VEEditor.access$000(this.f455558a) == true) goto L32;
            return;
        L32:
            if (VEEditor.access$200(this.f455558a) == null) goto L98;
            VEEditor.access$200(this.f455558a).f455584m = r101;
            return;
        L98:
            return;
        L35:
            if (VEEditor.access$000(this.f455558a) == true) goto L37;
            return;
        L37:
            if (VEEditor.access$200(this.f455558a) == null) goto L101;
            VEEditor.access$200(this.f455558a).f455583l = r101;
            return;
        L101:
            return;
        L40:
            if (VEEditor.access$1000(this.f455558a) == null) goto L43;
            VEEditor.access$1000(this.f455558a).onReleaseEngineUnitResourceError(r101);
            return;
        L43:
            if (VEEditor.access$100(this.f455558a) == null) goto L104;
            VELogUtil.i(VEEditor.TAG, "TECommonCallback type:" + r100);
            VEEditor.access$100(this.f455558a).onCallback(r100, r101, r110, r111);
            return;
        L104:
            return;
        L46:
            if (VEEditor.access$1000(this.f455558a) == null) goto L49;
            VEEditor.access$1000(this.f455558a).onReleaseEngineUnitResourceSuccess();
            return;
        L49:
            if (VEEditor.access$100(this.f455558a) == null) goto L107;
            VELogUtil.i(VEEditor.TAG, "TECommonCallback type:" + r100);
            VEEditor.access$100(this.f455558a).onCallback(r100, r101, r110, r111);
            return;
        L107:
            return;
        L53:
            if (VEEditor.access$700(this.f455558a) != null) goto L55;
            return;
        L55:
            if (VEEditor.access$400(this.f455558a) == null) goto L111;
            Message r102 = new Message();
            r102.what = 4133;
            r102.arg1 = r101;
            r102.arg2 = (int) r110;
            VEEditor.access$400(this.f455558a).sendMessage(r102);
            return;
        L111:
            return;
        L58:
            if (VEEditor.access$1200(this.f455558a) == null) goto L113;
            VEEditor.access$3100(((p) VEEditor.access$1200(this.f455558a)).f455571a);
            return;
        L113:
            return;
        L62:
            if (VEEditor.access$800(this.f455558a) != 0) goto L116;
            VEEditor.access$802(this.f455558a, System.currentTimeMillis());
            VELogUtil.i(VEEditor.TAG, "TECommonCallback TE_INFO_FIRST_FRAME_WITHOUT_SURFACE");
            return;
        L116:
            return;
        L65:
            if (VEEditor.access$300(this.f455558a) == null) goto L70;
            if (VEEditor.access$400(this.f455558a) == null) goto L70;
            Message r103 = new Message();
            r103.what = r100;
            r103.obj = Float.valueOf(r110);
            VEEditor.access$400(this.f455558a).sendMessage(r103);
            return;
        L70:
            if (VEEditor.access$100(this.f455558a) == null) goto L119;
            VEEditor.access$100(this.f455558a).onCallback(r100, r101, r110, r111);
            return;
        L119:
            return;
        L73:
            if (VEEditor.access$000(this.f455558a) == false) goto L76;
            VEEditor.access$200(this.f455558a).f455575d = VEEditor.access$100(this.f455558a);
            ThreadMethodProxy.start(new PthreadThreadV2(VEEditor.access$200(this.f455558a), "dk/VEEditor$1"));
            VEEditor.access$002(this.f455558a, false);
            return;
        L76:
            if (VEEditor.access$300(this.f455558a) == null) goto L81;
            if (VEEditor.access$400(this.f455558a) == null) goto L81;
            VELogUtil.w(VEEditor.TAG, "mCompileListener TE_INFO_COMPILE_DONE");
            Message r104 = new Message();
            r104.what = 4103;
            r104.arg1 = r101;
            r104.obj = r111;
            VEEditor.access$400(this.f455558a).sendMessage(r104);
            return;
        L81:
            if (VEEditor.access$100(this.f455558a) == null) goto L123;
            VELogUtil.w(VEEditor.TAG, "TECommonCallback TE_INFO_COMPILE_DONE");
            VEEditor.access$100(this.f455558a).onCallback(r100, r101, r110, r111);
            return;
        L123:
            return;
        L84:
            if (VEEditor.access$500(this.f455558a) <= 0) goto L87;
            System.currentTimeMillis();
            VEEditor.access$500(this.f455558a);
        L87:
            if (VEEditor.access$600(this.f455558a) == null) goto L92;
            if (VEEditor.access$400(this.f455558a) == null) goto L92;
            VELogUtil.w(VEEditor.TAG, "mSeekListener TE_INFO_SEEK_DONE");
            VEEditor.access$400(this.f455558a).sendEmptyMessage(4101);
            return;
        L92:
            if (VEEditor.access$100(this.f455558a) == null) goto L126;
            VELogUtil.w(VEEditor.TAG, "TECommonCallback TE_INFO_SEEK_DONE");
            VEEditor.access$100(this.f455558a).onCallback(r100, r101, r110, r111);
            return;
        }
    }

    public class i implements com.ss.android.ttve.common.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455559a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f455560a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f455561b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ float f455562c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f455563d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ i f455564e;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (VEEditor.access$300(this.f455564e.f455559a) == null) goto L9;
                VEEditor.access$300(this.f455564e.f455559a).onCompileError(this.f455560a, this.f455561b, this.f455562c, this.f455563d);     // Catch: Throwable -> L6
                return;
            }

            public a(i r100, int r101, int r102, float r103, String r104) {
                this.f455564e = r100;
                this.f455560a = r101;
                this.f455561b = r102;
                this.f455562c = r103;
                this.f455563d = r104;
            }
        }

        @Override // com.ss.android.ttve.common.a
        public final /* synthetic */ void a(int r100, int r101, float r102, long r103) {
        }

        public i(VEEditor r100) {
            this.f455559a = r100;
        }

        @Override // com.ss.android.ttve.common.a
        public final void onCallback(int r100, int r110, float r111, String r112) {
            this.f455559a.onMonitorError();
            if (VEEditor.access$1300(this.f455559a) == null) goto L6;
            VEEditor.access$1300(this.f455559a).onCallback(r100, r110, r111, r112);
        L6:
            if (VEEditor.access$300(this.f455559a) != null) goto L8;
            return;
        L8:
            if (VEEditor.access$400(this.f455559a) == null) goto L12;
            VEEditor.access$400(this.f455559a).post(new a(this, r100, r110, r111, r112));
            return;
        }
    }

    public class j implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455565a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        }

        public j(VEEditor r100) {
            this.f455565a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            this.f455565a.onSurfaceDestroyed();
            if (VEEditor.access$1600(this.f455565a) == null) goto L7;
            VEEditor.access$1600(this.f455565a).release();
            return true;
        L7:
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            if (VEEditor.access$1500(this.f455565a) != r100) goto L5;
            VEEditor r103 = this.f455565a;
            r103.onSurfaceCreated(VEEditor.access$1600(r103));
        L6:
            VEEditor.access$1502(this.f455565a, r100);
            return;
        L5:
            VEEditor.access$1602(this.f455565a, new Surface(r100));
            VEEditor r104 = this.f455565a;
            r104.onSurfaceCreated(VEEditor.access$1600(r104));
            goto L6
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            VEEditor.access$1702(this.f455565a, r101);
            VEEditor.access$1802(this.f455565a, r102);
            this.f455565a.updateInitDisplaySize();
        }
    }

    public class k implements SurfaceHolder.Callback2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455566a;

        public k(VEEditor r100) {
            this.f455566a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            Surface r101 = r100.getSurface();
            this.f455566a.onSurfaceCreated(r101);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            if (VEEditor.access$1900(this.f455566a).get() == false) goto L6;
            VELogUtil.w(VEEditor.TAG, "surfaceDestroyed, is destroying, just return");
            return;
        L6:
            this.f455566a.onSurfaceDestroyed();
        }

        @Override // android.view.SurfaceHolder.Callback2
        public final void surfaceRedrawNeeded(SurfaceHolder r100) {
            VELogUtil.d(VEEditor.TAG, "surfaceRedrawNeeded...");
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            VELogUtil.d(VEEditor.TAG, String.format(Locale.US, "surfaceChanged: pixel format [%d], size [%d, %d]", new Object[]{Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)}));
            this.f455566a.onSurfaceChanged(r102, r103);
        }
    }

    public class l implements NativeCallbacks.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455567a;

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.i
        public final void d(int r100) {
        }

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.i
        public final void e(double r100) {
        }

        public l(VEEditor r100) {
            this.f455567a = r100;
        }

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.i
        public final void a(int r100) {
            VELogUtil.d(VEEditor.TAG, "onOpenGLDestroy: ret = " + r100);
        }

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.i
        public final void c(int r100) {
            VELogUtil.d(VEEditor.TAG, "onOpenGLCreate: ret = " + r100);
        }

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.i
        public final void b(int r110, double r111) {
            VELogUtil.v(VEEditor.TAG, "onOpenGLDrawing: tex = " + r110 + " timeStamp = " + r111);
            if (VEEditor.access$2000(this.f455567a) == true) goto L24;
            VEEditor.access$2002(this.f455567a, true);
            long r100 = System.currentTimeMillis();
            if (VEEditor.access$800(this.f455567a) <= 0) goto L7;
            long r101 = VEEditor.access$800(this.f455567a);
        L9:
            if (VEEditor.access$2100(this.f455567a) <= 0) goto L11;
            long r102 = VEEditor.access$2100(this.f455567a);
        L13:
            if (r102 != 0) goto L15;
        L16:
            VELogUtil.e(VEEditor.TAG, "onOpenGLDrawAfter time report error, mlFirstPlayTimeMS = " + VEEditor.access$2100(this.f455567a) + ", mlFirstSeekTimeMS = " + VEEditor.access$2200(this.f455567a) + ", mlInitTimeMS = " + VEEditor.access$2300(this.f455567a));
            r102 = VEEditor.access$2300(this.f455567a);
        L33:
            JSONObject r112 = new JSONObject();     // Catch: JSONException -> L19
            r112.put("time_init", r102 - VEEditor.access$2300(this.f455567a));     // Catch: JSONException -> L19
            r112.put("time_seek", r101 - r102);     // Catch: JSONException -> L19
            r112.put("time_waiting_surface", r100 - r101);     // Catch: JSONException -> L19
            r112.put("time_total", r100 - VEEditor.access$2300(this.f455567a));     // Catch: JSONException -> L19
            r112.put("usage_type", VEEditor.access$2400(this.f455567a));     // Catch: JSONException -> L19
            com.ss.android.ttve.monitor.c.a("vesdk_event_editor_first_frame_draw", r112, "performance");     // Catch: JSONException -> L19
            VELogUtil.i(VEEditor.TAG, "first frame draw cost:" + r112.toString());     // Catch: JSONException -> L19
        L21:
            com.ss.android.ttve.monitor.i.f(1, "te_edit_first_frame_time", r100 - VEEditor.access$2300(this.f455567a));
            if (VEEditor.access$2500(this.f455567a) == null) goto L24;
            VEEditor.access$2500(this.f455567a).onRendered();
        L19:
            e = move-exception;
            VELogUtil.e(VEEditor.TAG, "report first frame json err " + e);
            goto L21
        L15:
            if (r102 >= VEEditor.access$2300(this.f455567a)) goto L33;
        L11:
            r102 = VEEditor.access$2200(this.f455567a);
            goto L13
        L7:
            r101 = r100;
        L24:
            VEEditor.access$2604(this.f455567a);
            if (VEEditor.access$2600(this.f455567a) != 30) goto L35;
            VEEditor.access$2702(this.f455567a, System.currentTimeMillis());
            if (VEEditor.access$2800(this.f455567a) == VEEditor.access$2700(this.f455567a)) goto L36;
            float r113 = 30000.0f / (VEEditor.access$2700(this.f455567a) - VEEditor.access$2800(this.f455567a));
            if (VERuntimeConfig.f455710b == false) goto L31;
            VELogUtil.i(VEEditor.TAG, "Render FPS = " + r113);
        L31:
            VEEditor r114 = this.f455567a;
            VEEditor.access$2802(r114, VEEditor.access$2700(r114));
            VEEditor.access$2602(this.f455567a, 0);
            return;
        L36:
            return;
        }
    }

    public class m implements NativeCallbacks.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455568a;

        public m(VEEditor r100) {
            this.f455568a = r100;
        }
    }

    public class n implements NativeCallbacks.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455569a;

        public n(VEEditor r100) {
            this.f455569a = r100;
        }

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.e
        public final int a(byte[] r100, int r101, int r110, int r111, float r112) {
            if (VEEditor.access$1400(this.f455569a) != null) goto L6;
            return -100;
        L6:
            if (r100 != null) goto L12;
            if (VEEditor.access$400(this.f455569a) == null) goto L12;
            Message r102 = new Message();
            r102.what = 4117;
            VEEditor.access$400(this.f455569a).sendMessage(r102);
            return 0;
        L12:
            return VEEditor.access$1400(this.f455569a).onGetImageData(r100, r101, r110, r111, r112);
        }
    }

    public class o implements NativeCallbacks.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455570a;

        public o(VEEditor r100) {
            this.f455570a = r100;
        }

        @Override // com.ss.android.ttve.nativePort.NativeCallbacks.e
        public final int a(byte[] r100, int r101, int r110, int r111, float r112) {
            if (VEEditor.access$3000(this.f455570a) != null) goto L6;
            return -100;
        L6:
            if (r100 != null) goto L10;
            return -1;
        L10:
            return VEEditor.access$3000(this.f455570a).onGetImageData(r100, r101, r110, r111, r112);
        }
    }

    public class p implements NativeCallbacks.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455571a;

        public p(VEEditor r100) {
            this.f455571a = r100;
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f455572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f455573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f455574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public VECommonCallback f455575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f455576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f455577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f455578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f455579h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f455580i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f455581j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f455582k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f455583l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f455584m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f455585n;

        public final void a() {
            if (TextUtils.isEmpty(this.f455573b) == false) goto L5;
        L39:
            VECommonCallback r100 = this.f455575d;
            if (r100 == null) goto L44;
            r100.onCallback(4103, -205, 0.0f, "File is empty or running");
            return;
        L44:
            return;
        L5:
            if (TextUtils.isEmpty(this.f455574c) == true) goto L39;
            if (this.f455576e == true) goto L39;
            this.f455576e = true;
            if (this.f455582k == false) goto L12;
            String r101 = String.format(Locale.US, "ffmpeg -f rawvideo -s %dx%d -pix_fmt rgba -y -i %s -vf palettegen=reserve_transparent=on %s", new Object[]{Integer.valueOf(this.f455583l), Integer.valueOf(this.f455584m), this.f455573b, this.f455572a});
        L13:
            int r102 = TEVideoUtils.executeFFmpegCommand(r101, null);
            if (r102 == 0) goto L20;
            this.f455576e = false;
            VECommonCallback r103 = this.f455575d;
            if (r103 == null) goto L43;
            r103.onCallback(4103, r102, 0.0f, "ffmpeg gen palette");
            return;
        L43:
            return;
        L20:
            if (this.f455582k == false) goto L22;
            String r104 = String.format(Locale.US, "ffmpeg -f rawvideo -s %dx%d -pix_fmt rgba -r %d -y -i %s -i %s -lavfi paletteuse=dither=bayer %s", new Object[]{Integer.valueOf(this.f455583l), Integer.valueOf(this.f455584m), Integer.valueOf(this.f455585n), this.f455573b, this.f455572a, this.f455574c});
        L26:
            int r105 = TEVideoUtils.executeFFmpegCommand(r104, null);
            VECommonCallback r106 = this.f455575d;
            if (r106 == null) goto L30;
            r106.onCallback(4103, r105, 0.0f, "ffmepg convert to gif");
        L30:
            if (this.f455582k == true) goto L32;
        L37:
            this.f455576e = false;
            return;
        L32:
            if (new PolarisFileWrapper(this.f455573b).delete() == false) goto L35;
            VELogUtil.i(VEEditor.TAG, "clear raw data:" + this.f455573b);
        L35:
            if (new PolarisFileWrapper(this.f455572a).delete() == false) goto L37;
            VELogUtil.i(VEEditor.TAG, "clear palette:" + this.f455572a);
            goto L37
        L22:
            String r107 = this.f455577f;
            if (r107 == null) goto L25;
            r104 = String.format(Locale.US, "ffmpeg -y -i %s -i %s -i %s -filter_complex [2:v]scale=w=%d:h=%d[o0];[0:v][o0]overlay=x=%d-w/2:y=%d-h/2[o1];[o1][1:v]paletteuse -f gif %s", new Object[]{this.f455573b, this.f455572a, r107, Integer.valueOf(this.f455578g), Integer.valueOf(this.f455579h), Integer.valueOf(this.f455580i), Integer.valueOf(this.f455581j), this.f455574c});
            goto L26
        L25:
            r104 = String.format(Locale.US, "ffmpeg -y -i %s -i %s -lavfi paletteuse -f gif %s", new Object[]{this.f455573b, this.f455572a, this.f455574c});
            goto L26
        L12:
            r101 = String.format("ffmpeg -y -i %s -vf palettegen %s", new Object[]{this.f455573b, this.f455572a});
            goto L13
        }

        public q() {
            this.f455576e = false;
            this.f455577f = null;
            this.f455578g = 50;
            this.f455579h = 50;
            this.f455580i = 100;
            this.f455581j = 100;
            this.f455582k = false;
            this.f455583l = 0;
            this.f455584m = 0;
            this.f455585n = -1;
            this.f455572a = null;
            this.f455573b = null;
            this.f455574c = null;
            this.f455575d = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public final void b(String r100) {
            this.f455574c = r100;
            if (TextUtils.isEmpty(r100) == false) goto L6;
            this.f455572a = null;
            return;
        L6:
            StringBuilder r101 = new StringBuilder();
            String r102 = this.f455574c;
            r101.append(r102.substring(0, r102.lastIndexOf(".")));
            r101.append(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
            this.f455572a = r101.toString();
        }
    }

    public interface r {
    }

    public interface s {
    }

    public class t extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEEditor f455586a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            int r100 = r110.what;
            if (r100 == 4101) goto L37;
            if (r100 == 4103) goto L26;
            if (r100 == 4105) goto L23;
            if (r100 == 4117) goto L20;
            if (r100 == 4133) goto L17;
            if (r100 != 4157) goto L50;
            VEEditor.access$1100(this.f455586a);
            return;
        L50:
            return;
        L17:
            if (VEEditor.access$700(this.f455586a) == null) goto L41;
            VEEditor.access$700(this.f455586a).onRefresh(r110.arg1, r110.arg2);
            return;
        L41:
            return;
        L20:
            if (VEEditor.access$1400(this.f455586a) == null) goto L43;
            VEEditor.access$1400(this.f455586a).onGetImageData(null, -1, -1, -1, 0.0f);
            VEEditor.access$1402(this.f455586a, null);
            return;
        L43:
            return;
        L23:
            if (VEEditor.access$300(this.f455586a) == null) goto L45;
            VEEditor.access$300(this.f455586a).onCompileProgress(((Float) r110.obj).floatValue());
            return;
        L45:
            return;
        L26:
            if (VEEditor.access$300(this.f455586a) != null) goto L28;
            return;
        L28:
            if (r110.arg1 >= 0) goto L34;
            VEListener.VEEditorCompileListener r101 = VEEditor.access$300(this.f455586a);
            int r102 = r110.arg1;
            Object r111 = r110.obj;
            if (r111 != null) goto L32;
            String r112 = "";
        L33:
            r101.onCompileError(r102, r102, 0.0f, r112);
        L35:
            VEEditor.access$302(this.f455586a, null);
            return;
        L32:
            r112 = r111.toString();
            goto L33
        L34:
            VEEditor.access$300(this.f455586a).onCompileDone();
            goto L35
        L37:
            if (VEEditor.access$600(this.f455586a) == null) goto L49;
            VEEditor.access$600(this.f455586a).onSeekDone(0);
            VEEditor.access$602(this.f455586a, null);
            return;
        }

        public t(VEEditor r100, Looper r101) {
            this.f455586a = r100;
            super(r101);
        }
    }

    private int addSticker(Bitmap r100, VESize r101, int r102, int r103) {
        return 0;
    }

    private int addWaterMark(Bitmap[] r100, int r101, VESize r102, int r103, int r104) {
        return 0;
    }

    private void createWrapperInvokers() {
        this.mWrapperMV = (dic.d) o0.e("com.ss.android.vesdk.VEMVInvoker", new Class[]{VEEditor.class}, new Object[]{this});
        this.mWrapperBingo = (dic.b) o0.e("com.ss.android.vesdk.VEBingoInvoker", new Class[]{VEEditor.class}, new Object[]{this});
        this.mWrapperSticker = (dic.f) o0.e("com.ss.android.vesdk.VEStickerInvoker", new Class[]{VEEditor.class}, new Object[]{this});
        this.mWrapperFilter = new k0(this);
        this.mWrapperSequence = new w0(this);
        this.mWrapperAudioExtend = new com.ss.android.vesdk.t(this);
        if (this.mWrapperSticker != null) goto L6;
        VELogUtil.e(TAG, "VEStickerInvoker is NULL");
        return;
    }

    public static void enableAVSync2(boolean r100) {
    }

    private void onMonitorCompile(int r100) {
    }

    public int cancelGetVideoFrames() {
        monitor-enter(this);
        VELogUtil.w(TAG, "cancelGetVideoFrames...");     // Catch: Throwable -> L6
        int r100 = this.mVideoEditor.cancelGetImages();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void clearFileInfoCache() {
        monitor-enter(this);
        mFileInfoCacheMap.clear();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int deleteWaterMark(int r100) {
        return 0;
    }

    public int doLensOneKeyHdrDetect() {
        monitor-enter(this);
        int r100 = this.mVideoEditor.doLensOneKeyHdrDetect();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public String dumpSequence() {
        monitor-enter(this);
        String r100 = this.mVideoEditor.dumpSequence();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int getDuration() {
        monitor-enter(this);
        int r100 = this.mVideoEditor.getDuration();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public VEState getState() {
        monitor-enter(this);
        TEInterface r100 = this.mVideoEditor;     // Catch: Throwable -> L16
        if (r100 != null) goto L8;
        VELogUtil.w(TAG, "video editor is created yet");     // Catch: Throwable -> L16
        VEState r101 = VEState.IDLE;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r101;
    L8:
        int r102 = r100.getCurState();     // Catch: Throwable -> L16
        if (r102 >= 0) goto L13;
        VELogUtil.w(TAG, "native video editor is not inited, already released or releasing");     // Catch: Throwable -> L16
        VEState r103 = VEState.IDLE;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L13:
        VEState r104 = VEState.valueOf(r102);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r104;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean isUseFilterProcess() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitSuccess == false) goto L14;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L15
        return false;
    L10:
        this.mVideoEditor.genEditorStatus();     // Catch: Throwable -> L15
        boolean r100 = VEPublishSettingManager.b().d();     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r100;
    L14:
        throw new VEException(-105, "Make sure the initialization is successful before calling!!!");     // Catch: Throwable -> L15
    }

    public boolean isValid() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoEditor.getNativeHandler() == 0) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    L6:
        r100 = false;
        goto L7
    }

    public int pause() {
        monitor-enter(this);
        int r100 = pause(false);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public int pauseSync() {
        monitor-enter(this);
        VELogUtil.i(TAG, "pauseSync...");     // Catch: Throwable -> L6
        int r100 = this.mVideoEditor.pauseSync();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int refreshCurrentFrame() {
        monitor-enter(this);
        VELogUtil.d(TAG, "refreshCurrentFrame...");     // Catch: Throwable -> L6
        int r100 = this.mVideoEditor.refreshCurrentFrame(0);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void releaseEngineUnitResourceAsync() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoEditor == null) goto L6;
        VELogUtil.w(TAG, "onRelease Async... ");     // Catch: Throwable -> L8
        this.mAsyncReleaseEngineListener = null;     // Catch: Throwable -> L8
        this.mVideoEditor.stop();     // Catch: Throwable -> L8
        this.mVideoEditor.releaseEngineAsync();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void releaseResource() {
        monitor-enter(this);
        this.mInitSuccess = false;     // Catch: Throwable -> L29
        VELogUtil.w(TAG, "onReleaseResource... ");     // Catch: Throwable -> L29
        if (this.mVideoEditor.getNativeHandler() != 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L9:
        if (this.mPageMode != 1) goto L11;
        com.ss.android.ttve.monitor.i.j(3);     // Catch: Throwable -> L29
    L11:
        this.mVideoEditor.releasePreviewSurface();     // Catch: Throwable -> L29
        SurfaceView r100 = this.mSurfaceView;     // Catch: Throwable -> L29
        if (r100 == null) goto L14;
        r100.getHolder().removeCallback(this.mSurfaceCallback);     // Catch: Throwable -> L29
    L19:
        this.mSurfaceView = null;     // Catch: Throwable -> L29
        this.mTextureView = null;     // Catch: Throwable -> L29
        TEInterface r101 = this.mVideoEditor;     // Catch: Throwable -> L29
        if (r101 == null) goto L22;
        r101.setOpenGLListeners(null);     // Catch: Throwable -> L29
        this.mVideoEditor.setInfoListener(null);     // Catch: Throwable -> L29
        this.mVideoEditor.setErrorListener(null);     // Catch: Throwable -> L29
        VELogUtil.w(TAG, "onReleaseResource... setNativeHandler 0");     // Catch: Throwable -> L29
        this.mVideoEditor.setNativeHandler(0);     // Catch: Throwable -> L29
        clearNativeFromInvokers();     // Catch: Throwable -> L29
    L22:
        this.mResManager = null;     // Catch: Throwable -> L29
        Bitmap r102 = this.mCurrentBmp;     // Catch: Throwable -> L29
        if (r102 != null) goto L25;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L25:
        if (r102.isRecycled() == true) goto L27;
        this.mCurrentBmp.recycle();     // Catch: Throwable -> L29
        this.mCurrentBmp = null;     // Catch: Throwable -> L29
        goto L27
    L14:
        TextureView r103 = this.mTextureView;     // Catch: Throwable -> L29
        if (r103 == null) goto L19;
        if (r103.getSurfaceTextureListener() != this.mTextureListener) goto L19;
        this.mTextureView.setSurfaceTextureListener(null);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public int reverseFilter() {
        return reverseFilter(0, 0);
    }

    public void setAudioDisplayListener(VEListener.d r100) {
    }

    public int setInfoStickerEditMode(boolean r100) {
        return -1;
    }

    public void setSurfaceCreatedDoneLister(VEListener.x r100) {
    }

    public void stop() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoEditor == null) goto L6;
        VELogUtil.w(TAG, "stop... ");     // Catch: Throwable -> L8
        this.mVideoEditor.stop();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public boolean testSerialization() {
        return false;
    }

    static {
        mFileInfoCacheMap = new HashMap();
        mCompileProbeLock = new Object();
        mCompileProbeRunning = false;
        genReverseCount = 0;
    }

    private void addCopyright() {
        String r100 = DigestUtils.generateMd5Checkcode(Build.MODEL.toLowerCase());
        VELogUtil.w(TAG, "addCopyright... ");
        this.mVideoEditor.addMetaData("copyright", r100);
    }

    private void clearNativeFromInvokers() {
        VELogUtil.w(TAG, "clearNativeFromInvokers... ");
        dic.d r100 = this.mWrapperMV;
        if (r100 == null) goto L5;
        r100.z();
    L5:
        dic.b r101 = this.mWrapperBingo;
        if (r101 == null) goto L8;
        r101.q();
    L8:
        dic.f r102 = this.mWrapperSticker;
        if (r102 == null) goto L11;
        r102.i();
    L11:
        dic.c r103 = this.mWrapperFilter;
        if (r103 == null) goto L15;
        ((k0) r103).f455861c.clearNative();
        return;
    }

    public int addInfoStickerWithBuffer() {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to addInfoStickerWithBuffer, is destroying, just return");
        return 0;
    L6:
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L11;
        VELogUtil.e(TAG, "addInfoStickerWithBuffer STICKER IS NOT SUPPORT !!!");
        return -901;
    L11:
        return r100.s();
    }

    public int begin2DBrush() {
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "begin2DBrush STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r100.m0();
    }

    public int cancelAudioExtendToFile() {
        com.ss.android.vesdk.t r100 = (com.ss.android.vesdk.t) this.mWrapperAudioExtend;
        r100.getClass();
        VELogUtil.w("VEEditor_VESmartBGMInvoker", "cancelAudioExtendToFile");
        return r100.f455933a.cancelAudioExtendToFile();
    }

    public int cancelReverseVideo() {
        if (this.mResManager.mReverseDone == false) goto L6;
        return -105;
    L6:
        monitor-enter(this);
        this.mCancelReverse = true;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return 0;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean checkMateData() {
        String r100 = getMetadata("copyright");
        String r101 = Build.MODEL.toLowerCase();
        VELogUtil.w(TAG, "checkMatedata... ");
        return DigestUtils.checkInfoByMd5(r101, r100);
    }

    public void destroy() {
        this.mIsDestroying.set(true);
        VELogUtil.w(TAG, "destroy... set destroying true");
        monitor-enter(this);
        this.mInitSuccess = false;     // Catch: Throwable -> L31
        VELogUtil.w(TAG, "onDestroy... ");     // Catch: Throwable -> L31
        cancelCompileProbe();     // Catch: Throwable -> L31
        if (this.mVideoEditor.getNativeHandler() != 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L9:
        this.mVideoEditor.stop();     // Catch: Throwable -> L31
        if (this.mPageMode != 1) goto L12;
        com.ss.android.ttve.monitor.i.j(3);     // Catch: Throwable -> L31
    L12:
        SurfaceView r100 = this.mSurfaceView;     // Catch: Throwable -> L31
        if (r100 == null) goto L15;
        r100.getHolder().removeCallback(this.mSurfaceCallback);     // Catch: Throwable -> L31
    L20:
        this.mSurfaceView = null;     // Catch: Throwable -> L31
        this.mTextureView = null;     // Catch: Throwable -> L31
        this.mSurfaceTexture = null;     // Catch: Throwable -> L31
        TEInterface r101 = this.mVideoEditor;     // Catch: Throwable -> L31
        if (r101 == null) goto L23;
        r101.setOpenGLListeners(null);     // Catch: Throwable -> L31
        this.mVideoEditor.setInfoListener(null);     // Catch: Throwable -> L31
        this.mVideoEditor.setErrorListener(null);     // Catch: Throwable -> L31
        this.mVideoEditor.destroyEngine();     // Catch: Throwable -> L31
        clearNativeFromInvokers();     // Catch: Throwable -> L31
    L23:
        this.mResManager = null;     // Catch: Throwable -> L31
        Bitmap r102 = this.mCurrentBmp;     // Catch: Throwable -> L31
        if (r102 != null) goto L26;
    L28:
        this.mIsDestroying.set(false);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L26:
        if (r102.isRecycled() == true) goto L28;
        this.mCurrentBmp.recycle();     // Catch: Throwable -> L31
        this.mCurrentBmp = null;     // Catch: Throwable -> L31
        goto L28
    L15:
        TextureView r103 = this.mTextureView;     // Catch: Throwable -> L31
        if (r103 == null) goto L20;
        if (r103.getSurfaceTextureListener() != this.mTextureListener) goto L20;
        this.mTextureView.setSurfaceTextureListener(null);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public void disableAlgorithmReplay() {
        this.mVideoEditor.setAlgorithmReplay(0, null);
    }

    public int excAICutOutTask() {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r101 = r100.f455859a;
        monitor-enter(r101);
        VELogUtil.i("VEEditor_VEFilterInvoker", "excAICutOutTask... ");     // Catch: Throwable -> L7
        int r102 = r100.f455860b.excAICutOutTask();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public int faceCoverClearCache() {
        return this.mVideoEditor.faceCoverClearCache();
    }

    public int faceCoverRestoreAll() {
        return this.mVideoEditor.faceCoverRestoreAll();
    }

    public int flushSeekCmd() {
        monitor-enter(this);
        VELogUtil.i(TAG, "flushSeekCmd... ");     // Catch: Throwable -> L9
        int r100 = this.mVideoEditor.flushSeekCmd();     // Catch: Throwable -> L9
        if (r100 >= 0) goto L7;
        VELogUtil.e(TAG, "flush error the ret: " + r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    public int genRandomSolve() {
        return this.mWrapperBingo.e();
    }

    public int genReverseVideo() throws VEException {
        VELogUtil.w(TAG, "genReverseVideo");
        String[] r100 = this.mResManager.mVideoPaths;
        if (r100 != null) goto L5;
    L17:
        VELogUtil.e(TAG, "genReverseVideo error:invalid videoPaths");
        return -100;
    L5:
        if (r100.length <= 0) goto L17;
        cancelCompileProbe();
        long r101 = System.currentTimeMillis();
        VEEditorResManager r102 = this.mResManager;
        String[] r103 = r102.mVideoPaths;
        r102.mReverseVideoPath = new String[r103.length];
        if (r103.length <= 0) goto L15;
        r102.genReverseVideoPath("0");
        String r104 = this.mResManager.mVideoPaths[0];
        if (this.mCancelReverse == false) goto L14;
        VELogUtil.w(TAG, "genReverseVideo fail: cancel reverse");
        this.mCancelReverse = false;
        return -1;
    L14:
        throw new VEException(-1, "reverse mResManager.mVideoPaths[i] failed: -1");
    L15:
        r102.mReverseDone = true;
        com.ss.android.ttve.monitor.i.f(1, "te_edit_reverse_time", System.currentTimeMillis() - r101);
        return 0;
    }

    public int genSmartCutting() {
        return this.mWrapperBingo.m();
    }

    public int get2DBrushStrokeCount() {
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get2DBrushStrokeCount STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r100.j();
    }

    public ArrayList<VEAudioTrackIndex> getAllAudioTracks() {
        VELogUtil.w(TAG, "getAllAudioTracks...");
        return (ArrayList) this.mVideoEditor.getAllAudioTracks();
    }

    public List<VEClipVideoFileInfoParam> getAllVideoFileInfos() {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        List<VEClipVideoFileInfoParam> r102 = r100.f455941b.getAllVideoFileInfos();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public List<VEClipAlgorithmParam> getAllVideoRangeData() {
        return this.mWrapperBingo.o();
    }

    public com.ss.android.ttve.model.c getCurColorFilter() {
        return ((k0) this.mWrapperFilter).f455867i;
    }

    public int getCurPosition() {
        return this.mVideoEditor.getCurPosition();
    }

    public Bitmap getCurrDisplayImage() {
        VELogUtil.i(TAG, "getCurrDisplayImage...");
        return getCurrDisplayImage(-1);
    }

    public synchronized Bitmap getCurrTransparentImage() {
        monitor-enter(this);
        VELogUtil.i(TAG, "getCurrTransparentImage in.");     // Catch: Throwable -> L33
        VESize r100 = getVideoResolution();     // Catch: Throwable -> L33
        int r101 = r100.width;     // Catch: Throwable -> L33
        Bitmap r102 = null;
        if (r101 == 0) goto L31;
        int r103 = r100.height;     // Catch: Throwable -> L33
        if (r103 == 0) goto L31;
        if ((r101 % 2) != 1) goto L13;
        r101 = r101 + 1;     // Catch: Throwable -> L33
    L13:
        if ((r103 % 2) != 1) goto L36;
        r103 = r103 + 1;
    L36:
        Bitmap r104 = Bitmap.createBitmap(r101, r103, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L27 Throwable -> L33
        int r105 = this.mVideoEditor.getTransparentImage(r104);     // Catch: Throwable -> L33
        if (r105 == 0) goto L23;
        VELogUtil.e(TAG, "getCurrTransparentImage failed " + r105);     // Catch: Throwable -> L33
        if (r104 != null) goto L21;
    L24:
        VELogUtil.i(TAG, "getCurrTransparentImage done.");     // Catch: Throwable -> L33
        monitor-exit(this);
        return r102;
    L21:
        if (r104.isRecycled() == true) goto L24;
        r104.recycle();     // Catch: Throwable -> L33
        goto L24
    L23:
        r102 = r104;
        goto L24
    L27:
        e = move-exception;
        VELogUtil.e(TAG, "getCurrTransparentImage createBitmap failed " + e.getMessage());     // Catch: Throwable -> L33
        return null;
    L31:
        monitor-exit(this);
        return null;
    L33:
        th = move-exception;
        throw th;
    }

    public long getHandler() {
        VELogUtil.w(TAG, "getHandler... " + this.mVideoEditor.getNativeHandler());
        return this.mVideoEditor.getNativeHandler();
    }

    public VESize getInitSize() {
        VESize r100 = new VESize(this.mInitDisplayWidth, this.mInitDisplayHeight);
        VELogUtil.d(TAG, "getInitSize... initWidth:" + r100.width + ", initHeight:" + r100.height);
        return r100;
    }

    public int getMVBackgroundAudioRid() {
        dic.d r100 = this.mWrapperMV;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r100.q();
    }

    public int getMVBackgroundAudioTrackIndex() {
        dic.d r100 = this.mWrapperMV;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r100.l();
    }

    public MVInfoBean getMVInfo() {
        dic.d r100 = this.mWrapperMV;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return null;
    L7:
        return r100.A();
    }

    public int getMVKaraokeAudioTrackIndex() {
        dic.d r100 = this.mWrapperMV;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r100.B();
    }

    public VEMVAudioInfo getMVOriginalBackgroundAudio() {
        dic.d r100 = this.mWrapperMV;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return null;
    L7:
        return r100.u();
    }

    public int getMusicSRTEffectFilterIndex() {
        return ((k0) this.mWrapperFilter).f455866h;
    }

    public long getPCMDeliverHandle() {
        return this.mVideoEditor.getPCMDeliverHandle();
    }

    public float getProjectMattingProgress() {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r101 = r100.f455859a;
        monitor-enter(r101);
        VELogUtil.i("VEEditor_VEFilterInvoker", "getProjectMattingProgress... ");     // Catch: Throwable -> L7
        float r102 = r100.f455860b.getProjectMattingProgress();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public Bitmap getReDrawBmp() {
        VELogUtil.i(TAG, "getReDrawBmp...");
        Bitmap r100 = this.mCurrentBmp;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isRecycled() == false) goto L7;
        return null;
    L7:
        return Bitmap.createBitmap(this.mCurrentBmp);
    }

    public String[] getReverseAudioPaths() {
        VEEditorResManager r100 = this.mResManager;
        if (r100.mReverseDone == true) goto L5;
        return null;
    L5:
        return r100.mReverseAudioPaths;
    }

    public String[] getReverseVideoPaths() {
        VEEditorResManager r100 = this.mResManager;
        if (r100.mReverseDone == true) goto L5;
        return null;
    L5:
        return r100.mReverseVideoPath;
    }

    public int getRuntimeGLVersion() {
        int r100 = this.mVideoEditor.getRuntimeGLVersion();
        VELogUtil.i(TAG, "getRuntimeGLVersion " + r100);
        return r100;
    }

    public String getSequenceUniqueKey() {
        return ((w0) this.mWrapperSequence).f455941b.getSequenceUniqueKey();
    }

    public VEMVAlgorithmConfig getServerAlgorithmConfig() {
        dic.d r100 = this.mWrapperMV;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return null;
    L7:
        return r100.f();
    }

    public int getTextLimitCount() {
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "getTextLimitCount STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r100.z();
    }

    public String[] getVideoPaths() {
        return this.mResManager.mVideoPaths;
    }

    public VESize getVideoResolution() {
        VESize r100 = this.mInitSize;
        VESize r101 = new VESize(r100.width, r100.height);
        VELogUtil.i(TAG, "getVideoResolution... width:" + r101.width + ", height:" + r101.height);
        return r101;
    }

    public int initAudioExtendToFile() {
        com.ss.android.vesdk.t r100 = (com.ss.android.vesdk.t) this.mWrapperAudioExtend;
        r100.getClass();
        VELogUtil.i("VEEditor_VESmartBGMInvoker", "initAudioExtendToFile");
        int r101 = r100.f455933a.initAudioExtendToFile();
        if (r101 == 0) goto L5;
        VELogUtil.e("VEEditor_VESmartBGMInvoker", "initAudioExtendToFile failed, ret = " + r101);
    L5:
        return r101;
    }

    public int initBingoAlgorithm() {
        return this.mWrapperBingo.j();
    }

    public void initColorAndHDRFilter() {
        ((k0) this.mWrapperFilter).f();
    }

    public int initColorFilter() {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "initColorFilter...");
        int r101 = r100.f455860b.addFilters(new int[]{0}, new String[]{"color filter"}, new int[]{0}, new int[]{r100.f455859a.getOutPoint()}, new int[]{0}, new int[]{7}, new int[]{1})[0];
        r100.f455862d = r101;
        return r101;
    }

    public int initFilters() {
        ((k0) this.mWrapperFilter).f();
        return 0;
    }

    public void invalidate() {
        this.mVideoEditor.setDisplayState(-1.0f, -1.0f, -1.0f, -1.0f, -80000, -80000, 1);
    }

    public boolean is2DBrushEmpty() {
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "is2DBrushEmpty STICKER IS NOT SUPPORT !!!");
        return false;
    L7:
        return r100.q0();
    }

    public boolean isAudioExtendToFileProcessing() {
        com.ss.android.vesdk.t r100 = (com.ss.android.vesdk.t) this.mWrapperAudioExtend;
        r100.getClass();
        VELogUtil.w("VEEditor_VESmartBGMInvoker", "isAudioExtendToFileProcessing");
        return r100.f455933a.isAudioExtendToFileProcessing();
    }

    public int isCompileEncode() {
        return this.mVideoEditor.isCompileEncode();
    }

    public int isWatermarkCompileEncode() {
        return this.mVideoEditor.isWatermarkCompileEncode();
    }

    public void onMonitorError() {
        com.ss.android.ttve.monitor.j r100 = this.mTEMonitorFilterMgr;
        monitor-enter(r100);
        boolean r101 = ((HashMap) r100.f449944a).isEmpty();     // Catch: Throwable -> L22
        monitor-exit(r100);
        long r102 = 0;
        if (r101 == false) goto L9;
        long r103 = 0;
    L10:
        com.ss.android.ttve.monitor.i.f(1, "te_composition_effect_add", r103);
        if (r101 == true) goto L13;
        com.ss.android.ttve.monitor.i.g(1, "te_composition_effect_json", this.mTEMonitorFilterMgr.d(0));
    L13:
        boolean r104 = this.mTEMonitorFilterMgr.b();
        if (r104 == true) goto L17;
        r102 = 1;
    L17:
        com.ss.android.ttve.monitor.i.f(1, "te_composition_info_sticker_add", r102);
        if (r104 == true) goto L20;
        com.ss.android.ttve.monitor.i.g(1, "te_composition_info_sticker_json", this.mTEMonitorFilterMgr.d(1));
    L20:
        this.mTEMonitorFilterMgr.c();
        com.ss.android.ttve.monitor.i.g(1, "iesve_veeditor_composition_finish_file", this.mCompileType);
        com.ss.android.ttve.monitor.i.g(1, "iesve_veeditor_composition_finish_result", "fail");
        com.ss.android.ttve.monitor.i.g(1, "iesve_veeditor_composition_finish_reason", "");
        com.ss.android.ttve.monitor.i.j(1);
        return;
    L9:
        r103 = 1;
    L22:
        th = move-exception;
        throw th;
    }

    public void onSurfaceDestroyed() {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to releasePreviewSurface, is destroying, just return");
        return;
    L6:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsDestroying.get() == false) goto L12;
        VELogUtil.w(TAG, "no need to releasePreviewSurface, just lock return");     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L12:
        VELogUtil.w(TAG, "surfaceDestroyed...");     // Catch: Throwable -> L15
        this.mVideoEditor.releasePreviewSurface();     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    public int play() {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to play, is destroying, just return");
        return 0;
    L6:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsDestroying.get() == false) goto L12;
        VELogUtil.w(TAG, "no need to play, is destroying, just lock return");     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return 0;
    L12:
        VELogUtil.w(TAG, "play...");     // Catch: Throwable -> L18
        this.miFrameCount = 0;     // Catch: Throwable -> L18
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L18
        this.mlLastTimeMS = r100;     // Catch: Throwable -> L18
        if (this.mlFirstPlayTimeMS != 0) goto L15;
        this.mlFirstPlayTimeMS = r100;     // Catch: Throwable -> L18
    L15:
        int r101 = this.mVideoEditor.start();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r101;
    }

    public void releaseEngine() {
        this.mIsDestroying.set(true);
        VELogUtil.w(TAG, "releaseEngine... set destroying true");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mVideoEditor == null) goto L7;
        VELogUtil.w(TAG, "releaseEngine... ");     // Catch: Throwable -> L10
        this.mVideoEditor.stop();     // Catch: Throwable -> L10
        this.mVideoEditor.releaseEngine();     // Catch: Throwable -> L10
    L7:
        this.mIsDestroying.set(false);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public int removeAllVideoSound() {
        return this.mWrapperBingo.f();
    }

    public int removeEffectListener() {
        this.mVideoEditor.removeEffectCallback();
        return 0;
    }

    public int removeMessageCenterListener() {
        return this.mVideoEditor.removeMessageCenterListener();
    }

    public void resetTrackIndexManager() {
        this.mTrackIndexManager.d();
    }

    public int restoreAllVideoSound() {
        return this.mWrapperBingo.i();
    }

    public VEEditorModel save() {
        throw new VEException(-200, "Deprecated, no longer supported!");
    }

    public void startEffectMonitor() {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r101 = r100.f455859a;
        monitor-enter(r101);
        r100.f455860b.startEffectMonitor();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopEffectMonitor() {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r101 = r100.f455859a;
        monitor-enter(r101);
        r100.f455860b.stopEffectMonitor();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int stopStickerAnimationPreview() {
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "stopStickerAnimationPreview STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r100.X();
    }

    public int undo2DBrush() {
        dic.f r100 = this.mWrapperSticker;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "undo2DBrush STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r100.L();
    }

    public int uninitAudioExtendToFile() {
        com.ss.android.vesdk.t r100 = (com.ss.android.vesdk.t) this.mWrapperAudioExtend;
        r100.getClass();
        VELogUtil.w("VEEditor_VESmartBGMInvoker", "uninitAudioExtendToFile");
        return r100.f455933a.uninitAudioExtendToFile();
    }

    public int updateAlgorithmFromNormal() {
        return this.mWrapperBingo.a();
    }

    public void updateFilters() {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        VELogUtil.e("VEEditor_VEFilterInvoker", "updateFilters");
        int r101 = r100.f455860b.getDuration();
        int r102 = r100.f455862d;
        if (r102 <= (-1)) goto L5;
        r100.f455860b.adjustFilterInOut(r102, 0, r101);
    L5:
        int r103 = r100.f455863e;
        if (r103 <= (-1)) goto L8;
        r100.f455860b.adjustFilterInOut(r103, 0, r101);
    L8:
        int r104 = r100.f455864f;
        if (r104 <= (-1)) goto L12;
        r100.f455860b.adjustFilterInOut(r104, 0, r101);
        return;
    }

    public void updateInitDisplaySize() {
        VESize r100 = this.mInitSize;
        int r101 = r100.width;
        int r102 = r100.height;
        float r103 = r101 / r102;
        int r104 = this.mSurfaceWidth;
        int r105 = this.mSurfaceHeight;
        if (r103 <= (r104 / r105)) goto L5;
        this.mInitDisplayWidth = r104;
        this.mInitDisplayHeight = (int) (r104 / (r101 / r102));
    L6:
        VELogUtil.i(TAG, "updateInitDisplaySize... mInitDisplayWidth:" + this.mInitDisplayWidth + ", mInitDisplayHeight:" + this.mInitDisplayHeight);
        return;
    L5:
        this.mInitDisplayHeight = r105;
        this.mInitDisplayWidth = (int) (r105 / (r102 / r101));
        goto L6
    }

    public int prepare() {
        VELogUtil.w(TAG, "init start---> init end  VE cost: " + (this.editor_time + this.model_sequence_time));
        VELogUtil.i(TAG, "init start---> init end  VE sequence cost: " + this.model_sequence_time);
        VELogUtil.i(TAG, "init start---> init end  VE editor cost: " + this.editor_time);
        long r100 = System.currentTimeMillis();
        monitor-enter(this);
        VELogUtil.w(TAG, "prepare...");     // Catch: Throwable -> L15
        setVideoBackgroudColor(this.mVideoBackGroundColor);     // Catch: Throwable -> L15
        this.mVideoEditor.setEnableRemuxVideo(false);     // Catch: Throwable -> L15
        this.mVideoEditor.setUsrRotate(0);     // Catch: Throwable -> L15
        int r101 = this.mVideoEditor.prepareEngine(0);     // Catch: Throwable -> L15
        if (r101 == 0) goto L7;
        VELogUtil.e(TAG, "prepare() prepareEngine failed: result: " + r101);     // Catch: Throwable -> L15
        onMonitorError();     // Catch: Throwable -> L15
    L7:
        int[] r102 = this.mVideoEditor.getInitResolution();     // Catch: Throwable -> L15
        VESize r103 = this.mInitSize;     // Catch: Throwable -> L15
        r103.width = r102[0];     // Catch: Throwable -> L15
        r103.height = r102[1];     // Catch: Throwable -> L15
        if (this.mSurfaceWidth > 0) goto L10;
    L12:
        setBackgroundColor(this.mBackGroundColor);     // Catch: Throwable -> L15
        VELogUtil.w(TAG, "prepare... cost " + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r101;
    L10:
        if (this.mSurfaceHeight <= 0) goto L12;
        updateInitDisplaySize();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public int prepareOnlyAudio() {
        monitor-enter(this);
        VELogUtil.w(TAG, "prepareOnlyAudio...");     // Catch: Throwable -> L9
        this.mVideoEditor.setEnableRemuxVideo(false);     // Catch: Throwable -> L9
        this.mVideoEditor.setUsrRotate(0);     // Catch: Throwable -> L9
        int r100 = this.mVideoEditor.prepareEngine(3);     // Catch: Throwable -> L9
        if (r100 == 0) goto L7;
        VELogUtil.e(TAG, "prepareOnlyAudio() prepareEngine failed: result: " + r100);     // Catch: Throwable -> L9
        onMonitorError();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    public VEEditorModel saveModel() {
        VELogUtil.i(TAG, "saveModel...");
        if (this.mInitSuccess == false) goto L6;
        VEEditorModel r100 = new VEEditorModel();
        r100.reverseDone = this.mResManager.mReverseDone;
        r100.videoOutRes = this.mVideoOutRes;
        r100.videoGravity = this.mVideoGravity;
        r100.videoScaleType = this.mVideoScaletype;
        r100.separateAV = this.mbSeparateAV.booleanValue();
        r100.masterTrackIndex = this.mMasterTrackIndex;
        r100.hostTrackIndex = this.mVideoEditor.getHostTrackIndex();
        dic.c r101 = this.mWrapperFilter;
        r100.audioEffectFilterIndex = ((k0) r101).f455865g;
        r100.colorFilterIndex = ((k0) r101).f455862d;
        r100.effectHDRFilterIndex = ((k0) r101).f455863e;
        r100.mLensHDRFilterIndex = ((k0) r101).f455864f;
        VEEditorResManager r102 = this.mResManager;
        r100.videoPaths = r102.mVideoPaths;
        r100.audioPaths = r102.mAudioPaths;
        r100.transitions = r102.mTransitions;
        r100.backgroundColor = this.mBackGroundColor;
        r100.videoBackgroundColor = this.mVideoBackGroundColor;
        return r100;
    L6:
        VELogUtil.e(TAG, "saveModel error, editor is not init...");
        return null;
    }

    public static void cancelCompileProbe() {
        TEVideoUtils.nativeCancelCompileProbe();
    }

    public ogc.a getBusinessManager() {
        return this.mBusinessManager;
    }

    public int getCanvasWrapFilterIndex() {
        return this.mCanvasWrapFilterIndex;
    }

    public VESize getFieldInitSize() {
        return this.mInitSize;
    }

    public TEInterface getInternalNativeEditor() {
        return this.mVideoEditor;
    }

    public long getLastTimeMS() {
        return this.mlLastTimeMS;
    }

    public int getMasterTrackIndex() {
        return this.mMasterTrackIndex;
    }

    public int getOutPoint() {
        return this.mOutPoint;
    }

    public float getPlayFps() {
        return this.mPlayFps;
    }

    public VEEditorResManager getResManager() {
        return this.mResManager;
    }

    public Boolean getSeparateAV() {
        return this.mbSeparateAV;
    }

    public int getSurfaceHeight() {
        return this.mSurfaceHeight;
    }

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    public int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    public com.ss.android.ttve.monitor.j getTEMonitorFilterMgr() {
        return this.mTEMonitorFilterMgr;
    }

    public TETrackIndexManager getTrackIndexManager() {
        return this.mTrackIndexManager;
    }

    public VEEditor(String r100) throws VEException {
        this.mInitSize = new VESize(-1, -1);
        this.mCompileType = "mp4";
        this.mMessageHandler = new t(this, Looper.getMainLooper());
        this.mSeekListener = null;
        this.mCompileListener = null;
        this.mFirstFrameListener = null;
        this.mVideoOutputListener = null;
        this.mAsyncReleaseEngineListener = null;
        this.mUserCommonInfoCallback = null;
        this.mUserCommonErrorCallback = null;
        this.mTrackIndexManager = new TETrackIndexManager();
        this.mBusinessManager = new ogc.a();
        this.mAutoPrepare = true;
        this.mUsageType = "unknown";
        this.mRecordData = null;
        this.mConcatVideoPath = "/concatShootVideo";
        this.mKeyFrameMap = new HashMap();
        this.mIsDestroying = new AtomicBoolean(false);
        this.mConcatVideoErrorForInvalidCodecs = -1;
        this.mTeCommonInfoCallback = new h(this);
        this.mTeCommonErrorCallback = new i(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInitDisplayWidth = 0;
        this.mInitDisplayHeight = 0;
        this.mbSeparateAV = Boolean.FALSE;
        this.mMasterTrackIndex = 0;
        this.miFrameCount = 0;
        this.mlCurTimeMS = 0;
        this.mlLastTimeMS = 0;
        this.mlInitTimeMS = 0;
        this.mlFirstSeekTimeMS = 0;
        this.mlFirstPlayTimeMS = 0;
        this.mlLastSeekTimeMS = 0;
        this.mlFirstFrameWithoutSurfaceTimeMS = 0;
        this.mFirstFrameDrawed = false;
        this.miCacheHitCount = 0;
        this.miCacheMissCount = 0;
        this.mInPoint = 0;
        this.mOutPoint = -1;
        this.mVideoGravity = VIDEO_GRAVITY.ALIGN_PARENT_BOTTOM;
        this.mVideoScaletype = VIDEO_SCALETYPE.CENTER;
        this.mInitSuccess = false;
        this.mReverseDone = false;
        this.mCancelReverse = false;
        this.mCanvasWrapFilterIndex = -1;
        this.mOutputFile = null;
        this.mlCompileStartTime = 0;
        this.mBReversePlay = false;
        this.mBCompileHighQualityGif = false;
        this.mp4ToGIFConverter = null;
        this.mEncoderListener = null;
        this.mGetImageListener = null;
        this.mGetSeekFrameListener = null;
        this.mTEMonitorFilterMgr = new com.ss.android.ttve.monitor.j();
        this.mReDrawSurface = false;
        this.mFirstTimeSurfaceCreate = true;
        this.mReDrawSurfaceOnce = false;
        this.mCurrentBmp = null;
        this.rotate = 0.0f;
        this.scaleW = 1.0f;
        this.scaleH = 1.0f;
        this.mPageMode = -1;
        this.mEditorMode = -1;
        this.mBackGroundColor = -16777216;
        this.mVideoBackGroundColor = -16777216;
        this.model_sequence_time = 0;
        this.editor_time = 0;
        this.mPlayFps = 0.0f;
        this.mTextureListener = new j(this);
        this.mSurfaceCallback = new k(this);
        this.mOpenGLCallback = new l(this);
        this.mEncoderDataCallback = new m(this);
        this.mGetImageCallback = new n(this);
        this.mGetSeekFrameCallback = new o(this);
        this.mGetCompileFirstFrameCallback = new p(this);
        this.mMattingCallback = new a(this);
        this.mkeyFrameCallback = new b(this);
        y0.a("VEEditor-offscreen");
        if (TextUtils.isEmpty(r100) == true) goto L7;
        VELogUtil.i(TAG, "VEEditor offscreen");
        this.mVideoEditor = TEInterface.createEngine();
        this.mResManager = new VEEditorResManager(r100);
        this.mVideoEditor.setOpenGLListeners(this.mOpenGLCallback);
        this.mVideoEditor.setInfoListener(this.mTeCommonInfoCallback);
        this.mVideoEditor.setErrorListener(this.mTeCommonErrorCallback);
        com.ss.android.ttve.monitor.g.b(null);
        enableEffectAmazing(false);
        createWrapperInvokers();
        y0.b();
        return;
    L7:
        throw new VEException(-100, "workspace is: " + r100);
    }

    public static /* synthetic */ boolean access$000(VEEditor r100) {
        return r100.mBCompileHighQualityGif;
    }

    public static /* synthetic */ VECommonCallback access$100(VEEditor r100) {
        return r100.mUserCommonInfoCallback;
    }

    public static /* synthetic */ VEListener.VEEditorAsyncReleaseEngineUnitResourceListener access$1000(VEEditor r100) {
        return r100.mAsyncReleaseEngineListener;
    }

    public static /* synthetic */ VEListener.d access$1100(VEEditor r100) {
        r100.getClass();
        return null;
    }

    public static /* synthetic */ NativeCallbacks.d access$1200(VEEditor r100) {
        return r100.mGetCompileFirstFrameCallback;
    }

    public static /* synthetic */ VECommonCallback access$1300(VEEditor r100) {
        return r100.mUserCommonErrorCallback;
    }

    public static /* synthetic */ VEListener.VEGetImageListener access$1400(VEEditor r100) {
        return r100.mGetImageListener;
    }

    public static /* synthetic */ SurfaceTexture access$1500(VEEditor r100) {
        return r100.mSurfaceTexture;
    }

    public static /* synthetic */ Surface access$1600(VEEditor r100) {
        return r100.mSurface;
    }

    public static /* synthetic */ AtomicBoolean access$1900(VEEditor r100) {
        return r100.mIsDestroying;
    }

    public static /* synthetic */ q access$200(VEEditor r100) {
        return r100.mp4ToGIFConverter;
    }

    public static /* synthetic */ boolean access$2000(VEEditor r100) {
        return r100.mFirstFrameDrawed;
    }

    public static /* synthetic */ long access$2100(VEEditor r100) {
        return r100.mlFirstPlayTimeMS;
    }

    public static /* synthetic */ long access$2200(VEEditor r100) {
        return r100.mlFirstSeekTimeMS;
    }

    public static /* synthetic */ long access$2300(VEEditor r100) {
        return r100.mlInitTimeMS;
    }

    public static /* synthetic */ String access$2400(VEEditor r100) {
        return r100.mUsageType;
    }

    public static /* synthetic */ VEListener.VEFirstFrameListener access$2500(VEEditor r100) {
        return r100.mFirstFrameListener;
    }

    public static /* synthetic */ int access$2600(VEEditor r100) {
        return r100.miFrameCount;
    }

    public static /* synthetic */ int access$2604(VEEditor r100) {
        int r101 = r100.miFrameCount + 1;
        r100.miFrameCount = r101;
        return r101;
    }

    public static /* synthetic */ long access$2700(VEEditor r100) {
        return r100.mlCurTimeMS;
    }

    public static /* synthetic */ long access$2800(VEEditor r100) {
        return r100.mlLastTimeMS;
    }

    public static /* synthetic */ VEListener.VEEncoderListener access$2900(VEEditor r100) {
        return r100.mEncoderListener;
    }

    public static /* synthetic */ VEListener.VEEditorCompileListener access$300(VEEditor r100) {
        return r100.mCompileListener;
    }

    public static /* synthetic */ VEListener.VEGetImageListener access$3000(VEEditor r100) {
        return r100.mGetSeekFrameListener;
    }

    public static /* synthetic */ VEListener.a access$3100(VEEditor r100) {
        r100.getClass();
        return null;
    }

    public static /* synthetic */ VEListener.q access$3200(VEEditor r100) {
        r100.getClass();
        return null;
    }

    public static /* synthetic */ VEListener.o access$3300(VEEditor r100) {
        r100.getClass();
        return null;
    }

    public static /* synthetic */ Map access$3400(VEEditor r100) {
        return r100.mKeyFrameMap;
    }

    public static /* synthetic */ t access$400(VEEditor r100) {
        return r100.mMessageHandler;
    }

    public static /* synthetic */ long access$500(VEEditor r100) {
        return r100.mlLastSeekTimeMS;
    }

    public static /* synthetic */ VEListener.VEEditorSeekListener access$600(VEEditor r100) {
        return r100.mSeekListener;
    }

    public static /* synthetic */ VEListener.VEVideoOutputListener access$700(VEEditor r100) {
        return r100.mVideoOutputListener;
    }

    public static /* synthetic */ long access$800(VEEditor r100) {
        return r100.mlFirstFrameWithoutSurfaceTimeMS;
    }

    private String addFileInfoCache(String r100) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L6;
        String r101 = this.mVideoEditor.addFileInfoCache(r100);     // Catch: Throwable -> L24
        if (r101 == null) goto L22;
        if (r101.equals("") == true) goto L22;
        long r102 = new PolarisFileWrapper(r100).lastModified();     // Catch: Throwable -> L24
        if (r102 == 0) goto L16;
        Pair<Long, String> r103 = new Pair(Long.valueOf(r102), r101);     // Catch: Throwable -> L24
        mFileInfoCacheMap.put(r100, r103);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return r101;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L24
        return "";
    L22:
        monitor-exit(this);     // Catch: Throwable -> L24
        return "";
    L6:
        monitor-exit(this);     // Catch: Throwable -> L24
        return "";
    }

    private boolean concatShootVideo(VEVideoEncodeSettings r110) {
        if (this.mRecordData == null) goto L68;
        VEEditorResManager r100 = this.mResManager;
        if (r100 == null) goto L68;
        String r101 = r100.getWorkspace();
        if (r101.isEmpty() == false) goto L11;
        VELogUtil.e(TAG, "workSpace is empty ");
        return false;
    L11:
        String r102 = r101 + "/concatShootVideo" + System.currentTimeMillis();
        VELogUtil.d(TAG, "concatVideoPath = " + r102);
        List<VERecordData.VERecordSegmentData> r103 = this.mRecordData.getSegmentData();
        if (r103 != null) goto L14;
    L67:
        return false;
    L14:
        if (r103.size() <= 1) goto L67;
        VELogUtil.d(TAG, "listRecordSegmentData size() = " + r103.size());
        int r104 = r103.size();
        String[] r105 = new String[r104];
        long[] r106 = new long[r103.size()];
        int r107 = 0;
    L17:
        if (r107 >= r103.size()) goto L20;
        VERecordData.VERecordSegmentData r111 = (VERecordData.VERecordSegmentData) ListProtector.get(r103, r107);
        r105[r107] = r111.mVideo;
        r106[r107] = r111.mVideoLength;
        r107 = r107 + 1;
        goto L17
    L20:
        if (isEnableRemuxVideo(r110) == false) goto L67;
        if (r110.isEnableRemuxVideoForShoot() == false) goto L67;
        if (this.mRecordData.isSegmentOriginLenth() == false) goto L67;
        int r112 = 0;
        String r113 = null;
    L27:
        if (r112 >= r104) goto L53;
        String r108 = r105[r112];
        MediaExtractor r114 = new MediaExtractor();
        r114.setDataSource(r108);     // Catch: Exception -> L43
        int r109 = 0;
        String r115 = null;
    L72:
        if (r109 >= r114.getTrackCount()) goto L39;
        String r116 = r114.getTrackFormat(r109).getString("mime");     // Catch: Exception -> L41
        if (r116 == null) goto L38;
        if (r116.startsWith("video/") == false) goto L38;
        r115 = r116;
    L38:
        r109 = r109 + 1;     // Catch: Exception -> L41
        goto L72
    L39:
        r114.release();     // Catch: Exception -> L41
    L46:
        if (r113 != null) goto L48;
        r113 = r115;
    L48:
        if (r113 == null) goto L52;
        if (r113.equals(r115) == false) goto L52;
        r112 = r112 + 1;
    L52:
        VELogUtil.e("VEConcatHelper", "isCodecsValid false mime= " + r115 + " lastMime " + r113);
        boolean r117 = false;
    L54:
        if (r117 == true) goto L57;
        VELogUtil.e(TAG, "isCodecsValid false ");
        this.mConcatVideoErrorForInvalidCodecs = 1025;
        return false;
    L57:
        boolean r118 = _concatShootVideo(r102, r105, r106);
        VELogUtil.e(TAG, "_concatShootVideo ret = " + r118);
        if (r118 == false) goto L67;
        if (VEFileUtils.exists(r102) == false) goto L67;
        this.mVideoEditor.stop();
        if (this.mVideoEditor.updateTrackClips(0, 0, new String[]{r102}) == 0) goto L65;
        VELogUtil.e(TAG, "updateTrackClips failed, ret = " + r118);
        return false;
    L65:
        this.mVideoEditor.createTimeline();
        return true;
    L41:
        e = e;
    L45:
        e.printStackTrace();
    L43:
        e = e;
        r115 = null;
        goto L45
    L53:
        VELogUtil.i("VEConcatHelper", "isCodecsValid");
        r117 = true;
    L68:
        VELogUtil.e(TAG, "concatShootVideo mRecordData or mResManager is empty ");
        return false;
    }

    public static int enableDisplayP3ReEncode(boolean r100) {
        return TEInterface.enableDisplayP3ReEncode(r100);
    }

    public static int enableDisplayP3Render(boolean r100) {
        return TEInterface.enableDisplayP3Render(r100);
    }

    public static int enableFirstFrameOpt(boolean r100) {
        return TEInterface.enableFirstFrameOpt(r100);
    }

    public static int enableHighSpeed(boolean r100) {
        VELogUtil.i(TAG, "enableHighSpeed " + r100);
        return TEInterface.enableHighSpeed(r100);
    }

    public static int enableMultiThreadDecode(boolean r100) {
        VELogUtil.i(TAG, "enableMultiThreadDecode " + r100);
        return TEInterface.enableMultiThreadDecode(r100);
    }

    public static int enableOptPlayBackDropFrame(boolean r100) {
        VELogUtil.i(TAG, "enableOptPlayBackDropFrame " + r100);
        return TEInterface.enableOptPlayBackDropFrame(r100);
    }

    public static int enableSeekAndPreloadOpt(boolean r100) {
        VELogUtil.i(TAG, "enableSeekAndPreloadOpt " + r100);
        return TEInterface.enableSeekAndPreloadOpt(r100);
    }

    private String getFileInfoCache(String r110) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r110) == false) goto L9;
        VELogUtil.i(TAG, "file info cache miss: " + r110);     // Catch: Throwable -> L36
        this.miCacheMissCount = this.miCacheMissCount + 1;     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return "";
    L9:
        Pair<Long, String> r100 = mFileInfoCacheMap.get(r110);     // Catch: Throwable -> L36
        if (r100 != null) goto L18;
        VELogUtil.i(TAG, "file info cache miss: " + r110);     // Catch: Throwable -> L36
        this.miCacheMissCount = this.miCacheMissCount + 1;     // Catch: Throwable -> L36
        String r101 = addFileInfoCache(r110);     // Catch: Throwable -> L36
        if (r101.equals("") == false) goto L16;
        VELogUtil.e(TAG, "add file info cache for " + r110 + " failed");     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return "";
    L16:
        monitor-exit(this);     // Catch: Throwable -> L36
        return r101;
    L18:
        long r102 = new PolarisFileWrapper(r110).lastModified();     // Catch: Throwable -> L36
        if (r102 != 0) goto L24;
        mFileInfoCacheMap.remove(r110);     // Catch: Throwable -> L36
        VELogUtil.i(TAG, "file info cache miss: " + r110);     // Catch: Throwable -> L36
        this.miCacheMissCount = this.miCacheMissCount + 1;     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return "";
    L24:
        if (r102 <= ((Long) r100.first).longValue()) goto L33;
        mFileInfoCacheMap.remove(r110);     // Catch: Throwable -> L36
        String r103 = addFileInfoCache(r110);     // Catch: Throwable -> L36
        if (r103.equals("") == false) goto L30;
        VELogUtil.i(TAG, "file info cache miss: " + r110);     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return "";
    L30:
        VELogUtil.i(TAG, "update file info cache for " + r110);     // Catch: Throwable -> L36
        this.miCacheMissCount = this.miCacheMissCount + 1;     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return r103;
    L33:
        VELogUtil.i(TAG, "file info cache hit: " + r110);     // Catch: Throwable -> L36
        this.miCacheHitCount = this.miCacheHitCount + 1;     // Catch: Throwable -> L36
        String r111 = (String) r100.second;     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        return r111;
    }

    public static com.ss.android.ttve.model.f getMVInfoStatic(String r100) {
        VELogUtil.w(TAG, "getMVInfoStatic...");
        return new com.ss.android.ttve.model.f(((MVInfoBean) TEInterface.getMVInfoStatic(r100)).resources);
    }

    public static void openEditorFpsLog(boolean r100) {
        VELogUtil.i(TAG, "openEditorFpsLog " + r100);
        VERuntimeConfig.f455710b = r100;
        TEInterface.openEditorFpsLog(r100);
    }

    public static void setAutoPrepareStatic(boolean r100) {
        VELogUtil.i(TAG, "setAutoPrepare... " + r100);
        mSAutoPrepare = r100;
    }

    private void setBitrateOptions(VEVideoEncodeSettings r100) {
        this.mVideoEditor.setCompileSoftwareEncodeOptions(r100.getSwCRF(), r100.getSwMaxRate(), r100.getSwPreset(), r100.getSwQP());
        this.mVideoEditor.setCompileHardwareEncodeOptions(r100.getBps());
        this.mVideoEditor.setCompileCommonEncodeOptions(r100.getBitrateMode().ordinal(), r100.getEncodeProfile());
    }

    public static int setEnableEffectCanvas(boolean r100) {
        VELogUtil.i(TAG, "setEnableEffectCanvas: " + r100);
        return TEInterface.setEnableEffectCanvas(r100);
    }

    public static int setEnableEffectTransition(boolean r100) {
        VELogUtil.i(TAG, "setEnableEffectTransition: " + r100);
        return TEInterface.setEnableEffectTransition(r100);
    }

    public static int setEnableRefaComposer(boolean r100) {
        VELogUtil.i(TAG, "setEnableRefaComposer: " + r100);
        return TEInterface.setEnableRefaComposer(r100);
    }

    public static int setForceDropFrameWithoutAudio(boolean r100) {
        VELogUtil.i(TAG, "setForceDropFrameWithoutAudio: " + r100);
        return TEInterface.setForceDropFrameWithoutAudio(r100);
    }

    public static void setHWEncodeParam(TEAvcEncoder.d r100) {
        TEAvcEncoder.setEncodeParams(r100);
    }

    public static int setInfoStickerTransEnable(boolean r100) {
        VELogUtil.w(TAG, "setInfoStickerTransEnable enable:" + r100);
        return TEInterface.setInfoStickerTransEnable(r100);
    }

    public static void setLensOneKeyHdrMaxCacheSize(int r100) {
        TEInterface.setLensOneKeyHdrMaxCacheSize(r100);
    }

    public static int setMaxAudioReaderLimits(int r100) {
        VELogUtil.i(TAG, "setMaxAudioReaderLimits... " + r100);
        return TEInterface.setMaxAudioReaderCount(r100);
    }

    public static int setMaxImageBufferCount(int r100) {
        VELogUtil.i(TAG, "setMaxImageBufferCount: " + r100);
        return TEInterface.setImageBufferLimit(r100, TECameraUtils.CAPTURE_NORMAL, TECameraUtils.CAPTURE_NORMAL);
    }

    public static int setMaxSoftWareReaderCount(int r100) {
        VELogUtil.i(TAG, "setMaxSoftWareReaderCount... " + r100);
        return TEInterface.setMaxSoftWareVideoReaderCount(r100, -1, -1, -1);
    }

    public static int setOptConfig(int r100) {
        VELogUtil.i(TAG, "setOptConfig... " + r100);
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
        r101.put("config", r100);     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_opt_config", r101, "performance");     // Catch: JSONException -> L5
    L7:
        boolean r102 = false;
        if (VEConfigCenter.getInstance().getValue("crossplat_glbase_fbo", false).booleanValue() == false) goto L11;
        r100 = r100 | 2097152;
    L11:
        if (VEConfigCenter.getInstance().getValue("use_byte264", false).booleanValue() == false) goto L14;
        r100 = r100 | 33554432;
    L14:
        if (VEConfigCenter.getInstance().getValue("color_space", false).booleanValue() == false) goto L17;
        r100 = r100 | 536870912;
    L17:
        if (VEConfigCenter.getInstance().getValue("ve_enable_render_encode_resolution_align4", false).booleanValue() == true) goto L19;
    L21:
        boolean r103 = VERuntimeConfig.f455709a;
        if ((r100 & 8) != 8) goto L24;
        boolean r104 = true;
    L25:
        VERuntimeConfig.f455709a = r104;
        if ((r100 & 8192) != 8192) goto L28;
        boolean r105 = true;
    L29:
        VERuntimeConfig.f455711c = r105;
        if ((r100 & 16777216) != 16777216) goto L32;
        r102 = true;
    L32:
        VERuntimeConfig.f455712d = r102;
        VELogUtil.i("VERuntimeConfig", "setConfig, sUseSingleGLThread = " + VERuntimeConfig.f455709a + ", sSeekTimeCostOpt = " + VERuntimeConfig.f455711c + ", sOutResolutionBase4 = " + VERuntimeConfig.f455712d);
        return TEInterface.setEnableOpt(r100);
    L28:
        r105 = false;
        goto L29
    L24:
        r104 = false;
        goto L25
    L19:
        if (Build.VERSION.SDK_INT < 24) goto L21;
        VELogUtil.i(TAG, "enableRenderEncodeAlign4: true");
        r100 = r100 | 16777216;
        TEAvcEncoder.setEncodeResolutionAlign(4);
    L5:
        e = move-exception;
        VELogUtil.e(TAG, "report optConfig json err " + e);
        goto L7
    }

    public static void setSmartCodecPath(List<String> r100) {
        TEAvcEncoder.setSmartCodecPath(r100);
    }

    public int addEmojiSticker(String r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "addEmojiSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.N();
    }

    public int addTextSticker(String r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "addTextSticker1, STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.f();
    }

    public int addVidoeClipWithAlgorithm(String[] r100) {
        return this.mWrapperBingo.d();
    }

    public int appendComposerNodes(String[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "appendComposerNodes");     // Catch: Throwable -> L11
        int r103 = r101.f455860b.appendComposerNodes(r100);     // Catch: Throwable -> L11
        if (r103 == 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "appendComposerNodes failed, ret = " + r103);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
    L10:
        return r103;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int beginInfoStickerPin(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "beginInfoStickerPin STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.E();
    }

    public int cancelGenVideoFrame(int r100) {
        return this.mWrapperBingo.r();
    }

    public int cancelInfoStickerPin(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "cancelInfoStickerPin STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.Y();
    }

    public int checkScoresFile(String r100) {
        return this.mWrapperBingo.k();
    }

    public void clearDisplay(int r100) {
        VELogUtil.i(TAG, "clearDisplay... color:" + r100);
        this.mVideoEditor.clearDisplay(r100);
    }

    public int deleteAICutOutClipParam(int r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.i("VEEditor_VEFilterInvoker", "deleteAICutOutClipParam... " + r100);     // Catch: Throwable -> L7
        int r103 = r101.f455860b.deleteAICutOutClipParam(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public int deleteAudioFilters(int[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "deleteAudioFilter..." + r100[0]);     // Catch: Throwable -> L7
        int r103 = r101.f455860b.removeFilter(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public int deleteAudioTrack(int r100) {
        return deleteAudioTrack(r100, false);
    }

    public int deleteExternalVideoTrack(int r100) {
        w0 r101 = (w0) this.mWrapperSequence;
        VEEditor r102 = r101.f455940a;
        monitor-enter(r102);
        VELogUtil.i("VEEditor_VESequenceInvoker", "deleteExternalVideoTrack... trackIndex:" + r100);     // Catch: Throwable -> L15
        if (r100 >= 0) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L15
        return -100;
    L8:
        r101.f455941b.stop();     // Catch: Throwable -> L15
        int r103 = r101.f455940a.getTrackIndexManager().b(2, r100);     // Catch: Throwable -> L15
        r101.f455940a.getTrackIndexManager().c(2, r100);     // Catch: Throwable -> L15
        int r104 = r101.f455941b.deleteExternalVideoTrack(r103);     // Catch: Throwable -> L15
        TEInterface r105 = r101.f455941b;     // Catch: Throwable -> L15
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L15
        int r106 = r101.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L15
        if (r106 == 0) goto L13;
        VELogUtil.e("VEEditor_VESequenceInvoker", "deleteExternalVideoTrack Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return r106;
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L15
        return r104;
    L15:
        th = move-exception;
        throw th;
    }

    public int deleteFilterEffects(int[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        r101.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "deleteFilterEffects...");
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        int r104 = r100[r103];
        com.ss.android.ttve.monitor.j r105 = r101.f455859a.getTEMonitorFilterMgr();
        monitor-enter(r105);
        Map<Integer, com.ss.android.ttve.monitor.j.a> r106 = r105.f449944a;     // Catch: Throwable -> L9
        HashMap r107 = (HashMap) r106;     // Catch: Throwable -> L9
        r107.remove(Integer.valueOf(r104));     // Catch: Throwable -> L9
        monitor-exit(r105);
        r103 = r103 + 1;
    L9:
        th = move-exception;
        throw th;
    L13:
        return r101.f455860b.removeFilter(r100);
    }

    public int deleteFilters(int[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.i("VEEditor_VEFilterInvoker", "deleteFilters...");     // Catch: Throwable -> L7
        int r103 = r101.f455860b.removeFilter(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public int deleteRepeatEffect(int r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "deleteRepeatEffect... " + r100);     // Catch: Throwable -> L22
        if (r101.f455860b.getCurState() == (-20000)) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        int r104 = r101.f455860b.stop();     // Catch: Throwable -> L22
    L11:
        if (r104 != 0) goto L13;
    L17:
        int r105 = r101.f455860b.removeFilter(new int[]{r100});     // Catch: Throwable -> L22
        r101.f455859a.getTEMonitorFilterMgr().getClass();     // Catch: Throwable -> L22
        if (r103 == false) goto L20;
        r101.f455860b.createTimeline();     // Catch: Throwable -> L22
        r101.f455860b.prepareEngine(0);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r102);     // Catch: Throwable -> L22
        return r105;
    L13:
        if (r104 == (-101)) goto L17;
        VELogUtil.i("VEEditor_VEFilterInvoker", "pauseSync failed, ret " + r104);     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        return -1;
    L10:
        r104 = 0;
        goto L11
    L7:
        r103 = false;
    L22:
        th = move-exception;
        throw th;
    }

    public int deleteSlowEffect(int r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "deleteSlowEffect... " + r100);     // Catch: Throwable -> L23
        if (r101.f455860b.getCurState() == (-20000)) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        int r104 = r101.f455860b.stop();     // Catch: Throwable -> L23
    L11:
        if (r104 != 0) goto L13;
    L17:
        int r105 = r101.f455860b.removeFilter(new int[]{r100});     // Catch: Throwable -> L23
        if (r103 == false) goto L20;
        r101.f455860b.createTimeline();     // Catch: Throwable -> L23
        r101.f455860b.prepareEngine(0);     // Catch: Throwable -> L23
    L20:
        r101.f455859a.getTEMonitorFilterMgr().getClass();     // Catch: Throwable -> L23
        monitor-exit(r102);     // Catch: Throwable -> L23
        return r105;
    L13:
        if (r104 == (-101)) goto L17;
        VELogUtil.w("VEEditor_VEFilterInvoker", "pauseSync failed, ret " + r104);     // Catch: Throwable -> L23
        monitor-exit(r102);     // Catch: Throwable -> L23
        return -1;
    L10:
        r104 = 0;
        goto L11
    L7:
        r103 = false;
    L23:
        th = move-exception;
        throw th;
    }

    public int deleteSticker(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "deleteSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.i0();
    }

    public int deleteTimeEffect(int r110) {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r101 = r100.f455859a;
        monitor-enter(r101);
        VELogUtil.e("VETimeEffectManager", "TimeEffect deleteTimeEffect...  filterIndexes: " + r110 + " audioFilterIndex:" + r100.f455868j.f455899a.f455914e);     // Catch: Throwable -> L73
        StringBuilder r102 = new StringBuilder("deleteTimeEffect before getDuration =");     // Catch: Throwable -> L73
        r102.append(r100.f455860b.getDuration());     // Catch: Throwable -> L73
        VELogUtil.e("VETimeEffectManager", r102.toString());     // Catch: Throwable -> L73
        int r103 = -1;
        if (r110 >= 0) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L73
    L72:
        return r103;
    L9:
        if (r100.f455860b.getCurState() == (-20000)) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        int r105 = r100.f455860b.stop();     // Catch: Throwable -> L73
    L15:
        if (r105 != 0) goto L17;
    L21:
        int r111 = r100.f455860b.removeFilter(new int[]{r110});     // Catch: Throwable -> L73
        if (r100.f455859a.getResManager().mOriginalSoundTrackType != 1) goto L26;
        int r106 = r100.f455868j.f455899a.f455914e;     // Catch: Throwable -> L73
        if (r106 < 0) goto L26;
        r111 = r100.f455860b.removeFilter(new int[]{r106});     // Catch: Throwable -> L73
    L26:
        r103 = r111;
        r100.f455859a.getResManager().mTimeMode = TIME_MODE.EDITOR_NORMAl_MODE.ordinal();     // Catch: Throwable -> L73
        if (r100.f455868j.f() != 0) goto L29;
        boolean r112 = false;
    L30:
        if (r112 == false) goto L67;
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L73
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L73
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L73
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L73
        r100.f455868j.d(r113, r107, r108, r109);     // Catch: Throwable -> L73
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect deleteVideoClip begin");     // Catch: Throwable -> L73
        Iterator r114 = r113.iterator();     // Catch: Throwable -> L73
    L33:
        if (r114.hasNext() == false) goto L38;
        VEClipParam r115 = (VEClipParam) r114.next();     // Catch: Throwable -> L73
        int r116 = r100.f455860b.deleteClip(0, r100.f455859a.getMasterTrackIndex(), r115.clipIndex);     // Catch: Throwable -> L73
        if (r116 >= 0) goto L37;
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect deleteVideoClip failed, ret = " + r116);     // Catch: Throwable -> L73
    L37:
        VELogUtil.d("VETimeEffectManager", "deleteTimeEffect deleteVideoClip =" + r115.toString());     // Catch: Throwable -> L73
        goto L33
    L38:
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect deleteVideoClip end");     // Catch: Throwable -> L73
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateVideoClip begin");     // Catch: Throwable -> L73
        VEClipTimelineParam[] r117 = new VEClipTimelineParam[r107.size()];     // Catch: Throwable -> L73
        int[] r118 = new int[r107.size()];     // Catch: Throwable -> L73
        int r119 = 0;
    L40:
        if (r119 >= r107.size()) goto L42;
        VEClipTimelineParam r120 = new VEClipTimelineParam();     // Catch: Throwable -> L73
        r117[r119] = r120;     // Catch: Throwable -> L73
        r120.trimIn = ((VEClipParam) r107.get(r119)).trimIn;     // Catch: Throwable -> L73
        r117[r119].trimOut = ((VEClipParam) r107.get(r119)).trimOut;     // Catch: Throwable -> L73
        r117[r119].speed = ((VEClipParam) r107.get(r119)).speed;     // Catch: Throwable -> L73
        r118[r119] = ((VEClipParam) r107.get(r119)).clipIndex;     // Catch: Throwable -> L73
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateVideoClip =" + ((VEClipParam) r107.get(r119)).toString());     // Catch: Throwable -> L73
        r119 = r119 + 1;     // Catch: Throwable -> L73
        goto L40
    L42:
        int r121 = r100.f455860b.updateClipsTimelineParam(0, r100.f455859a.getMasterTrackIndex(), r118, r117);     // Catch: Throwable -> L73
        if (r121 >= 0) goto L45;
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateClipsTimelineParam failed, ret = " + r121);     // Catch: Throwable -> L73
    L45:
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateVideoClip end");     // Catch: Throwable -> L73
        if (r100.f455859a.getResManager().mOriginalSoundTrackType == 1) goto L48;
    L66:
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect after getDuration =" + r100.f455860b.getDuration());     // Catch: Throwable -> L73
    L68:
        TEInterface r122 = r100.f455860b;     // Catch: Throwable -> L73
        r122.setTimeRange(0, r122.getDuration(), 1);     // Catch: Throwable -> L73
        r100.f455859a.getTEMonitorFilterMgr().getClass();     // Catch: Throwable -> L73
        if (r104 == false) goto L71;
        r100.f455860b.createTimeline();     // Catch: Throwable -> L73
        r100.f455860b.prepareEngine(0);     // Catch: Throwable -> L73
    L71:
        monitor-exit(r101);     // Catch: Throwable -> L73
        goto L72
    L48:
        if (r108.size() <= 0) goto L50;
    L51:
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect deleteAuidoClip begin");     // Catch: Throwable -> L73
        Iterator r123 = r108.iterator();     // Catch: Throwable -> L73
    L53:
        if (r123.hasNext() == false) goto L58;
        VEClipParam r124 = (VEClipParam) r123.next();     // Catch: Throwable -> L73
        int r125 = r100.f455860b.deleteClip(1, r100.f455859a.getResManager().mOriginalSoundTrackIndex, r124.clipIndex);     // Catch: Throwable -> L73
        if (r125 >= 0) goto L57;
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect deleteAuidoClip failed, ret = " + r125);     // Catch: Throwable -> L73
    L57:
        VELogUtil.d("VETimeEffectManager", "deleteTimeEffect deleteAuidoClip =" + r124.toString());     // Catch: Throwable -> L73
        goto L53
    L58:
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect deleteAuidoClip end");     // Catch: Throwable -> L73
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateAudioClip begin");     // Catch: Throwable -> L73
        VEClipTimelineParam[] r126 = new VEClipTimelineParam[r109.size()];     // Catch: Throwable -> L73
        int[] r127 = new int[r109.size()];     // Catch: Throwable -> L73
        int r128 = 0;
    L60:
        if (r128 >= r109.size()) goto L62;
        VEClipTimelineParam r129 = new VEClipTimelineParam();     // Catch: Throwable -> L73
        r126[r128] = r129;     // Catch: Throwable -> L73
        r129.trimIn = ((VEClipParam) r109.get(r128)).trimIn;     // Catch: Throwable -> L73
        r126[r128].trimOut = ((VEClipParam) r109.get(r128)).trimOut;     // Catch: Throwable -> L73
        r126[r128].speed = ((VEClipParam) r109.get(r128)).speed;     // Catch: Throwable -> L73
        r127[r128] = ((VEClipParam) r109.get(r128)).clipIndex;     // Catch: Throwable -> L73
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateAudioClip =" + ((VEClipParam) r109.get(r128)).toString());     // Catch: Throwable -> L73
        r128 = r128 + 1;     // Catch: Throwable -> L73
        goto L60
    L62:
        int r130 = r100.f455860b.updateClipsTimelineParam(1, r100.f455859a.getResManager().mOriginalSoundTrackIndex, r118, r126);     // Catch: Throwable -> L73
        if (r130 >= 0) goto L65;
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateClipsTimelineParam failed, ret = " + r130);     // Catch: Throwable -> L73
    L65:
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect updateAudioClip end");     // Catch: Throwable -> L73
        goto L66
    L50:
        if (r109.size() <= 0) goto L66;
    L67:
        r100.f455868j.g();     // Catch: Throwable -> L73
        goto L68
    L29:
        r112 = true;
        goto L30
    L17:
        if (r105 == (-101)) goto L21;
        VELogUtil.i("VEEditor_VEFilterInvoker", "pauseSync failed, ret " + r105);     // Catch: Throwable -> L73
        monitor-exit(r101);     // Catch: Throwable -> L73
        goto L72
    L14:
        r105 = 0;
        goto L15
    L11:
        r104 = false;
    L73:
        th = move-exception;
        throw th;
    }

    public int deleteVideoClipWithAlgorithm(int r100) {
        return this.mWrapperBingo.s();
    }

    public void dumpSequence(String r100) {
        monitor-enter(this);
        this.mVideoEditor.dumpSequence(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int enableEffect(boolean r100) {
        VELogUtil.w(TAG, "enableEffect... enable = " + r100);
        int r101 = this.mVideoEditor.enableEffect(r100);
        if (r101 == 0) goto L5;
        VELogUtil.e(TAG, "enableEffect failed, ret = " + r101);
    L5:
        return r101;
    }

    public int enableEffectAmazing(boolean r100) {
        monitor-enter(this);
        int r101 = this.mVideoEditor.enableEffectAmazing(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public void enableFaceDetect(boolean r100) {
        monitor-enter(this);
        this.mVideoEditor.enableFaceDetect(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void enableGenderDetect(boolean r100) {
        monitor-enter(this);
        this.mVideoEditor.enableGenderDetect(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void enableHDRSetting(boolean r100) {
        ((k0) this.mWrapperFilter).f455860b.enableHDRSetting(r100);
    }

    public int enableHighSpeedForSingle(boolean r100) {
        return this.mVideoEditor.enableHighSpeedForSingle(r100);
    }

    public int enableImageEditor(boolean r100) {
        VELogUtil.w(TAG, "enableImageEditor");
        int r101 = this.mVideoEditor.enableImageEditor(r100);
        if (r101 == 0) goto L5;
        VELogUtil.e(TAG, "enableImageEditor failed, ret = " + r101);
    L5:
        return r101;
    }

    public int enableReversePlay(boolean r210) {
        monitor-enter(this);
        VELogUtil.w(TAG, "enableReversePlay:" + r210);     // Catch: Throwable -> L51
        VEEditorResManager r100 = this.mResManager;     // Catch: Throwable -> L51
        if (r100.mReverseDone == true) goto L10;
        VELogUtil.e(TAG, "enableReversePlay error: reverse video is not ready!");     // Catch: Throwable -> L51
        monitor-exit(this);     // Catch: Throwable -> L51
        return -100;
    L10:
        String[] r101 = r100.mReverseVideoPath;     // Catch: Throwable -> L51
        if (r101 != null) goto L13;
    L47:
        VELogUtil.e(TAG, "enableReversePlay error: reverse video path is invalid!");     // Catch: Throwable -> L51
        monitor-exit(this);     // Catch: Throwable -> L51
        return -105;
    L13:
        if (r101.length <= 0) goto L47;
        cancelCompileProbe();     // Catch: Throwable -> L51
        long r110 = this.mVideoEditor.getDurationUs();     // Catch: Throwable -> L51
        this.mVideoEditor.stop();     // Catch: Throwable -> L51
        if (r210 == false) goto L18;
        String[] r102 = this.mResManager.mReverseVideoPath;     // Catch: Throwable -> L51
    L19:
        int r103 = this.mVideoEditor.updateTrackClips(0, 0, r102);     // Catch: Throwable -> L51
        if (r103 == 0) goto L24;
        VELogUtil.e(TAG, "updateTrackClips failed, ret = " + r103);     // Catch: Throwable -> L51
        monitor-exit(this);     // Catch: Throwable -> L51
        return r103;
    L24:
        StringBuilder r104 = new StringBuilder("enableReversePlay: mReverseAudioPaths == null: ");     // Catch: Throwable -> L51
        if (this.mResManager.mReverseAudioPaths != null) goto L27;
        boolean r105 = true;
    L28:
        r104.append(r105);     // Catch: Throwable -> L51
        VELogUtil.i(TAG, r104.toString());     // Catch: Throwable -> L51
        VELogUtil.i(TAG, "enableReversePlay: mOriginalSoundTrackType = " + this.mResManager.mOriginalSoundTrackType);     // Catch: Throwable -> L51
        VEEditorResManager r106 = this.mResManager;     // Catch: Throwable -> L51
        String[] r107 = r106.mReverseAudioPaths;     // Catch: Throwable -> L51
        if (r107 != null) goto L31;
    L33:
        TEInterface r108 = this.mVideoEditor;     // Catch: Throwable -> L51
        if (r210 == this.mBReversePlay) goto L36;
        boolean r111 = true;
    L37:
        r108.updateTrackFilterDuration(0, 0, r111, r110);     // Catch: Throwable -> L51
        this.mVideoEditor.createTimeline();     // Catch: Throwable -> L51
        int r109 = this.mVideoEditor.prepareEngine(0);     // Catch: Throwable -> L51
        if (r109 == 0) goto L42;
        VELogUtil.e(TAG, "enableReversePlay() prepareEngine failed: result: " + r109);     // Catch: Throwable -> L51
        monitor-exit(this);     // Catch: Throwable -> L51
        return r109;
    L42:
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L51
        seek(0, SEEK_MODE.EDITOR_SEEK_FLAG_LastSeek);     // Catch: Throwable -> L51
        this.mBReversePlay = r210;     // Catch: Throwable -> L51
        if (r210 == false) goto L45;
        fic.a r112 = new fic.a();     // Catch: Throwable -> L51
        r112.c("iesve_veeditor_time_effect_id", "reverse");     // Catch: Throwable -> L51
        com.ss.android.ttve.monitor.g.b(r112);     // Catch: Throwable -> L51
        this.mTEMonitorFilterMgr.getClass();     // Catch: Throwable -> L51
    L45:
        monitor-exit(this);     // Catch: Throwable -> L51
        return 0;
    L36:
        r111 = false;
        goto L37
    L31:
        if (r106.mOriginalSoundTrackType == 1) goto L33;
        TEInterface r113 = this.mVideoEditor;     // Catch: Throwable -> L51
        int r114 = r113.addAudioTrack(r107[0], 0, r113.getDuration(), 0, this.mVideoEditor.getDuration(), false);     // Catch: Throwable -> L51
        this.mResManager.mOriginalSoundTrackIndex = this.mTrackIndexManager.a(1, r114);     // Catch: Throwable -> L51
        VEEditorResManager r115 = this.mResManager;     // Catch: Throwable -> L51
        r115.mOriginalSoundTrackType = 1;     // Catch: Throwable -> L51
        r115.mReverseAudioDone = true;     // Catch: Throwable -> L51
        VELogUtil.w(TAG, "enableReversePlay: add org audio track index = " + this.mResManager.mOriginalSoundTrackIndex + " mOriginalSoundTrackType = " + this.mResManager.mOriginalSoundTrackType);     // Catch: Throwable -> L51
        goto L33
    L27:
        r105 = false;
        goto L28
    L18:
        r102 = this.mResManager.mVideoPaths;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    public synchronized void enableSimpleProcessor(boolean r100) {
        monitor-enter(this);
        VELogUtil.i(TAG, "enableSimpleProcessor: " + String.valueOf(r100));     // Catch: Throwable -> L7
        this.mVideoEditor.enableSimpleProcessor(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void enableWatermarkMetadata(boolean r100) {
        VELogUtil.w(TAG, "enableWatermarkMetadata:" + r100);
        this.mVideoEditor.enableWatermarkMetadata(r100);
    }

    public int end2DBrush(String r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "end2DBrush STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.t();
    }

    public int expandTimeline(int r100) {
        w0 r101 = (w0) this.mWrapperSequence;
        r101.getClass();
        VELogUtil.w("VEEditor_VESequenceInvoker", "expandTimeline: " + r100);
        return r101.f455941b.expandTimeline(r100);
    }

    public int faceCoverSetDir(String r100) {
        return this.mVideoEditor.faceCoverSetDir(r100);
    }

    public String[] getAllFileInfoCacheList(String[] r100) {
        monitor-enter(this);
        int r101 = r100.length;     // Catch: Throwable -> L14
        int r102 = 0;
        this.miCacheHitCount = 0;     // Catch: Throwable -> L14
        this.miCacheMissCount = 0;     // Catch: Throwable -> L14
        String[] r103 = new String[r101];     // Catch: Throwable -> L14
    L4:
        if (r102 >= r101) goto L12;
        String r104 = getFileInfoCache(r100[r102]);     // Catch: Throwable -> L14
        if (r104 != null) goto L8;
    L10:
        r103[r102] = "";     // Catch: Throwable -> L14
    L11:
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L4
    L8:
        if (r104.isEmpty() == true) goto L10;
        r103[r102] = r104;     // Catch: Throwable -> L14
        goto L11
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return r103;
    L14:
        th = move-exception;
        throw th;
    }

    public float getClipMattingProgress(int r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.i("VEEditor_VEFilterInvoker", "getClipMattingProgress... " + r100);     // Catch: Throwable -> L7
        float r103 = r101.f455860b.getClipMattingProgress(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public float getColorFilterIntensity(String r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -1.0f;
    L6:
        return r101.f455860b.getColorFilterIntensity(r100);
    }

    public Bitmap getCurrDisplayImage(int r100) {
        return getCurrDisplayImage(r100, VEQualityScoreType.VQScoreNone, "");
    }

    public float[] getInfoStickerBoundingBox(int r100) throws VEException {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerBoundingBox STICKER IS NOT SUPPORT !!!");
        return null;
    L7:
        return r101.J();
    }

    public float[] getInfoStickerBoundingBoxWithoutRotate(int r100) throws VEException {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerBoundingBoxWithoutRotate STICKER IS NOT SUPPORT !!!");
        return null;
    L7:
        return r101.o();
    }

    public int getInfoStickerPinState(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerPinState STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.w();
    }

    public float getInfoStickerRotate(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerRotate STICKER IS NOT SUPPORT !!!");
        return -901.0f;
    L7:
        return r101.C();
    }

    public float getInfoStickerScale(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerScale STICKER IS NOT SUPPORT !!!");
        return -901.0f;
    L7:
        return r101.M();
    }

    public String getInfoStickerTemplateParams(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerTemplateParams STICKER IS NOT SUPPORT !!!");
        return null;
    L7:
        return r101.r();
    }

    public boolean getInfoStickerVisible(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerVisible STICKER IS NOT SUPPORT !!!");
        return false;
    L7:
        return r101.b();
    }

    public String getInfostickertemplateParams(String r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getInfostickertemplateParams STICKER IS NOT SUPPORT !!!");
        return null;
    L7:
        return r101.B();
    }

    public Map<Integer, List<MVResourceBean>> getMVUserVideoInfo(String r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return null;
    L7:
        return r101.n();
    }

    public String getMetadata(String r100) {
        monitor-enter(this);
        VELogUtil.w(TAG, "getMetadata...");     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r100) == true) goto L6;
        String r101 = this.mVideoEditor.getMetaData(r100);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r101;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L11
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    public int getRemuxErrorCode(VEVideoEncodeSettings r110) throws VEException {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitSuccess == false) goto L24;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L25
        return -1;
    L11:
        if ((-1) != r110.getEnableRemuxVideoRes()) goto L20;
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("remux_video_res");     // Catch: Throwable -> L25
        if (r100 != null) goto L15;
    L19:
        VELogUtil.i("VESDK", "getRemuxErrorCode::No remux video resolution config");     // Catch: Throwable -> L25
        goto L20
    L15:
        if (r100.getValue() == null) goto L19;
        if ((r100.getValue() instanceof Integer) == false) goto L19;
        int r101 = ((Integer) r100.getValue()).intValue();     // Catch: Throwable -> L25
        r110.setEnableRemuxVideoRes(r101);     // Catch: Throwable -> L25
        VELogUtil.i("VESDK", "getRemuxErrorCode::remuxVideoRes = " + r101);     // Catch: Throwable -> L25
    L20:
        this.mVideoEditor.genEditorStatus();     // Catch: Throwable -> L25
        VEPublishSettingManager.b().e(r110, VERuntime.getInstance().getNativeContext());     // Catch: Throwable -> L25
        VELogUtil.w(TAG, "VideoEncodeSettings = " + VEPublishSettingManager.b().f().toString());     // Catch: Throwable -> L25
        int r111 = VEPublishSettingManager.b().a();     // Catch: Throwable -> L25
        VELogUtil.w(TAG, "before synthesis report remux error code = " + r111);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return r111;
    L24:
        throw new VEException(-105, "Make sure the initialization is successful before calling!!!");     // Catch: Throwable -> L25
    }

    public boolean getStickerIsDynamic(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getStickerIsDynamic fail !!!");
        return false;
    L7:
        return r101.b0();
    }

    public int getTextContent(s r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "getTextContent STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.getTextContent();
    }

    public long getVideoClipEndTime(int r100) {
        w0 r101 = (w0) this.mWrapperSequence;
        r101.f455940a.getBusinessManager().getClass();
        return r101.f455941b.getClipSequenceOut(0, 0, r100);
    }

    public int initMV(VEMVParams r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r101.c();
    }

    public int initWithCanvas(VEEditorSettings r310) throws VEException {
        monitor-enter(this);
        VECanvasFilterParam[] r100 = r310.getCanvasFilterParams();     // Catch: Throwable -> L88
        String[] r101 = r310.getVideoFilePaths();     // Catch: Throwable -> L88
        Bitmap[] r102 = r310.getImages();     // Catch: Throwable -> L88
        int[] r110 = r310.getVTrimIn();     // Catch: Throwable -> L88
        int[] r111 = r310.getVTrimOut();     // Catch: Throwable -> L88
        VETransitionFilterParam[] r103 = r310.getVTransitionFilterParam();     // Catch: Throwable -> L88
        VESize[] r112 = r310.getSizes();     // Catch: Throwable -> L88
        String[] r104 = r310.getVideoFileInfos();     // Catch: Throwable -> L88
        VIDEO_RATIO r113 = r310.getVideoOutRes();     // Catch: Throwable -> L88
        String[] r114 = r310.getAudioFilePaths();     // Catch: Throwable -> L88
        String[] r115 = r310.getAudioFileInfos();     // Catch: Throwable -> L88
        int[] r116 = r310.getATrimIn();     // Catch: Throwable -> L88
        int[] r117 = r310.getATrimOut();     // Catch: Throwable -> L88
        float[] r210 = r310.getSpeed();     // Catch: Throwable -> L88
        if (r102 == null) goto L7;
        int r105 = r102.length;     // Catch: Throwable -> L88
        int r106 = r102.length;     // Catch: Throwable -> L88
    L11:
        if (r105 != 0) goto L15;
        VELogUtil.e(TAG, "initWithCanvas invalid canvasFilterParam inputFileNum");     // Catch: Throwable -> L88
        monitor-exit(this);     // Catch: Throwable -> L88
        return -100;
    L15:
        if (r100 != null) goto L17;
    L85:
        VELogUtil.e(TAG, "initWithCanvas invalid canvasFilterParam!");     // Catch: Throwable -> L88
        monitor-exit(this);     // Catch: Throwable -> L88
        return -100;
    L17:
        if (r100.length == 0) goto L85;
        VECanvasFilterParam r118 = r100[0];     // Catch: Throwable -> L88
        if (r118.height <= 0) goto L85;
        if (r118.width <= 0) goto L85;
        if (r105 == r110.length) goto L26;
    L82:
        VELogUtil.e(TAG, "initWithCanvas invalid param, inputFileNum.length: " + r105 + ", vTrimIn.length: " + r110.length + ", vTrimOut.length: " + r111.length);     // Catch: Throwable -> L88
        monitor-exit(this);     // Catch: Throwable -> L88
        return -100;
    L26:
        if (r105 != r111.length) goto L82;
        if (r112 != null) goto L30;
    L34:
        int r107 = 0;
    L36:
        if (r107 >= r110.length) goto L45;
        int r108 = r111[r107];     // Catch: Throwable -> L88
        if (r108 < 0) goto L44;
        if (r108 > r110[r107]) goto L44;
        VELogUtil.e(TAG, "initWithCanvas invalid param vTrimIn[" + r107 + "]=" + r110[r107] + ", vTrimOut[" + r107 + "]=" + r111[r107]);     // Catch: Throwable -> L88
        monitor-exit(this);     // Catch: Throwable -> L88
        return -100;
    L44:
        r107 = r107 + 1;     // Catch: Throwable -> L88
        goto L36
    L45:
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L88
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L88
        long r119 = System.currentTimeMillis();     // Catch: Throwable -> L88
        this.mlInitTimeMS = r119;     // Catch: Throwable -> L88
        this.mlLastTimeMS = r119;     // Catch: Throwable -> L88
        VELogUtil.i(TAG, "initWithCanvasAndInfos...");     // Catch: Throwable -> L88
        if (r103 != null) goto L48;
    L54:
        String[] r109 = null;
        int[] r120 = null;
        int[] r211 = null;
    L55:
        TEInterface r121 = this.mVideoEditor;     // Catch: Throwable -> L88
        if (r106 <= 0) goto L58;
        String[] r122 = null;
    L59:
        int r123 = r105;
        int r124 = r121.initVideoEditorWithCanvas(r122, r102, r105, r104, r110, r111, r114, r115, r116, r117, r109, r120, r211, null, r210, VIDEO_RATIO.VIDEO_OUT_RATIO_ORIGINAL.ordinal(), r112);     // Catch: Throwable -> L88
        if (r124 == 0) goto L64;
        VELogUtil.e(TAG, "initVideoEditorWithCanvas, ret = " + r124);     // Catch: Throwable -> L88
        onMonitorError();     // Catch: Throwable -> L88
        this.mInitSuccess = false;     // Catch: Throwable -> L88
        monitor-exit(this);     // Catch: Throwable -> L88
        return r124;
    L64:
        this.mInitSuccess = true;     // Catch: Throwable -> L88
        this.mReverseDone = false;     // Catch: Throwable -> L88
        this.mVideoOutRes = r113;     // Catch: Throwable -> L88
        VEEditorResManager r125 = this.mResManager;     // Catch: Throwable -> L88
        r125.mAudioPaths = r114;     // Catch: Throwable -> L88
        r125.mVideoPaths = r101;     // Catch: Throwable -> L88
        r125.mTransitions = r109;     // Catch: Throwable -> L88
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L88
        if (r114 != null) goto L67;
    L69:
        boolean r126 = false;
    L70:
        this.mbSeparateAV = Boolean.valueOf(r126);     // Catch: Throwable -> L88
        this.mMasterTrackIndex = 0;     // Catch: Throwable -> L88
        this.mVideoEditor.setTrackDurationType(0, 0, 1);     // Catch: Throwable -> L88
        setScaleMode(SCALE_MODE.SCALE_MODE_CANVAS);     // Catch: Throwable -> L88
        VECanvasFilterParam r127 = r100[0];     // Catch: Throwable -> L88
        setWidthHeight(r127.width, r127.height);     // Catch: Throwable -> L88
        this.mBusinessManager.f523232a = 1;     // Catch: Throwable -> L88
        int r128 = this.mVideoEditor.addFilters(new int[]{0}, new String[]{"canvas wrap"}, new int[]{0}, new int[]{this.mOutPoint}, new int[]{0}, new int[]{15}, new int[]{1})[0];     // Catch: NullPointerException -> L80 Throwable -> L88
        this.mCanvasWrapFilterIndex = r128;     // Catch: NullPointerException -> L80 Throwable -> L88
        updateTrackClipFilter(-1, r128, r100[0]);     // Catch: NullPointerException -> L80 Throwable -> L88
        int r129 = 0;
    L72:
        if (r129 >= r123) goto L74;
        updateTrackClipFilter(r129, this.mCanvasWrapFilterIndex, r100[r129]);     // Catch: NullPointerException -> L80 Throwable -> L88
        r129 = r129 + 1;     // Catch: NullPointerException -> L80 Throwable -> L88
        goto L72
    L74:
        VEVideoTransformFilterParam r130 = new VEVideoTransformFilterParam();     // Catch: NullPointerException -> L80 Throwable -> L88
        int r131 = 0;
    L75:
        if (r131 >= r123) goto L78;
        updateTrackClipFilter(r131, this.mCanvasWrapFilterIndex, r130);     // Catch: NullPointerException -> L80 Throwable -> L88
        r131 = r131 + 1;
        goto L75
        goto L81
    L78:
        monitor-exit(this);     // Catch: Throwable -> L88
        return r124;
    L81:
        throw new VEException(-1, "init failed: VESDK need to be init");     // Catch: Throwable -> L88
    L67:
        if (r114.length == 0) goto L69;
        r126 = true;
        goto L70
    L58:
        r122 = r101;
        goto L59
    L48:
        if (r103.length <= 0) goto L54;
        String[] r132 = new String[r103.length];     // Catch: Throwable -> L88
        int[] r133 = new int[r103.length];     // Catch: Throwable -> L88
        int[] r134 = new int[r103.length];     // Catch: Throwable -> L88
        int r135 = 0;
    L51:
        if (r135 >= r103.length) goto L53;
        r132[r135] = r103[r135].transName;     // Catch: Throwable -> L88
        VETransitionFilterParam r136 = r103[r135];     // Catch: Throwable -> L88
        r133[r135] = r136.tranType;     // Catch: Throwable -> L88
        r134[r135] = r136.tranDuration;     // Catch: Throwable -> L88
        r135 = r135 + 1;     // Catch: Throwable -> L88
        r103 = r103;
        goto L51
    L53:
        r109 = r132;
        r120 = r133;
        r211 = r134;
        goto L55
    L30:
        if (r105 == r112.length) goto L34;
        VELogUtil.e(TAG, "initWithCanvas invalid param, inputFileNum.length: " + r105 + ", sizes.length: " + r112.length);     // Catch: Throwable -> L88
        monitor-exit(this);     // Catch: Throwable -> L88
        return -100;
    L7:
        if (r101 == null) goto L9;
        r105 = r101.length;     // Catch: Throwable -> L88
        r106 = 0;
        goto L11
    L9:
        r106 = 0;
        r105 = 0;
    L88:
        th = move-exception;
        throw th;
    }

    public boolean isEnableRemuxVideo(VEVideoEncodeSettings r100) throws VEException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitSuccess == false) goto L14;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L15
        return false;
    L10:
        this.mVideoEditor.genEditorStatus();     // Catch: Throwable -> L15
        long r101 = VERuntime.getInstance().getNativeContext();     // Catch: Throwable -> L15
        VEPublishSettingManager.b().e(r100, r101);     // Catch: Throwable -> L15
        boolean r102 = VEPublishSettingManager.b().c();     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r102;
    L14:
        throw new VEException(-105, "Make sure the initialization is successful before calling!!!");     // Catch: Throwable -> L15
    }

    public boolean[] isFileInfoCacheExist(String[] r100) {
        monitor-enter(this);
        int r101 = r100.length;     // Catch: Throwable -> L13
        boolean[] r102 = new boolean[r101];     // Catch: Throwable -> L13
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L11;
        String r104 = r100[r103];     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        if (r104.isEmpty() == true) goto L10;
        r102[r103] = true;     // Catch: Throwable -> L13
    L10:
        r103 = r103 + 1;     // Catch: Throwable -> L13
        goto L4
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean isGestureRegistered(VEGestureEvent r100) {
        return this.mVideoEditor.isGestureRegistered(r100);
    }

    public boolean isInfoStickerAnimatable(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "isInfoStickerAnimatable STICKER IS NOT SUPPORT !!!");
        return false;
    L7:
        return r101.o0();
    }

    public int lockSeekVideoClip(int r100) {
        VELogUtil.i(TAG, "lockSeekVideoClip " + r100);
        return this.mVideoEditor.lockSeekVideoClip(r100);
    }

    public int mapOriginalPositionToTimeEffectPosition(int r100) {
        com.ss.android.vesdk.runtime.e r101 = ((k0) this.mWrapperFilter).f455868j;
        int r102 = r101.f();
        if (r102 != 1) goto L8;
        VERepeatFilterParam r103 = (VERepeatFilterParam) r101.f455899a.f455915f;
        int r104 = r103.seqIn;
        int r105 = r103.repeatDuration;
        if (r100 < (r104 + r105)) goto L8;
        int r106 = (r105 * (r103.repeatTime - 1)) + r100;
    L10:
        if (r102 != 2) goto L19;
        VESlowMotionFilterParam r107 = (VESlowMotionFilterParam) r101.f455899a.f455915f;
        int r108 = r107.seqIn;
        int r109 = r107.slowMotionDuration;
        int r110 = r108 + r109;
        if (r100 < r108) goto L22;
        if (r100 < r108) goto L17;
        if (r100 >= r110) goto L17;
        return ((int) ((r100 - r108) / r107.slowMotionSpeed)) + r108;
    L17:
        float r111 = r109;
        return r100 + ((int) ((r111 / r107.slowMotionSpeed) - r111));
    L22:
        return r100;
    L19:
        return r106;
    L8:
        r106 = r100;
        goto L10
    }

    public int mapTimeEffectDurationToOriginalDuration(int r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        com.ss.android.vesdk.runtime.e r103 = r101.f455868j;     // Catch: Throwable -> L12
        int r104 = r103.f();     // Catch: Throwable -> L12
        if (r104 != 1) goto L8;
        VERepeatFilterParam r105 = (VERepeatFilterParam) r103.f455899a.f455915f;     // Catch: Throwable -> L12
        r100 = r100 - (r105.repeatDuration * (r105.repeatTime - 1));     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return r100;
    L8:
        if (r104 != 2) goto L10;
        VESlowMotionFilterParam r106 = (VESlowMotionFilterParam) r103.f455899a.f455915f;     // Catch: Throwable -> L12
        int r107 = r106.slowMotionDuration;     // Catch: Throwable -> L12
        r100 = r100 - (((int) (r107 / r106.slowMotionSpeed)) - r107);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public int mapTimeEffectPositionToOriginalPosition(int r100) {
        com.ss.android.vesdk.runtime.e r101 = ((k0) this.mWrapperFilter).f455868j;
        int r102 = r101.f();
        if (r102 != 1) goto L11;
        VERepeatFilterParam r103 = (VERepeatFilterParam) r101.f455899a.f455915f;
        int r104 = r103.seqIn;
        int r105 = r103.repeatDuration;
        int r106 = r103.repeatTime;
        int r107 = (r105 * r106) + r104;
        if (r100 < r104) goto L11;
        if (r100 < r104) goto L10;
        if (r100 >= r107) goto L10;
        int r108 = ((r100 - r104) % r105) + r104;
    L13:
        if (r102 != 2) goto L22;
        VESlowMotionFilterParam r109 = (VESlowMotionFilterParam) r101.f455899a.f455915f;
        int r110 = r109.seqIn;
        float r111 = r109.slowMotionDuration;
        float r112 = r109.slowMotionSpeed;
        float r113 = r111 / r112;
        int r114 = (int) (r110 + r113);
        if (r100 < r110) goto L25;
        if (r100 < r110) goto L24;
        if (r100 >= r114) goto L24;
        return ((int) ((r100 - r110) * r112)) + r110;
    L24:
        return r100 - ((int) (r113 - r111));
    L25:
        return r100;
    L22:
        return r108;
    L10:
        r108 = r100 - (r105 * (r106 - 1));
    L11:
        r108 = r100;
        goto L13
    }

    public int notifyHideKeyBoard(boolean r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "notifyHideKeyBoard STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.n();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r100) {
        VELogUtil.v(TAG, "onFrameAvailable...");
    }

    public void onSurfaceCreated(Surface r110) {
        y0.a("VEEditor-onSurfaceCreated.");
        VELogUtil.w(TAG, "surfaceCreated...");
        this.mFirstTimeSurfaceCreate = false;
        if (this.mReDrawSurface == true) goto L5;
    L18:
        this.mVideoEditor.setPreviewSurface(r110);
        y0.b();
        return;
    L5:
        if (this.mCurrentBmp == null) goto L18;
        Canvas r100 = r110.lockCanvas(null);
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        int r103 = this.mCurrentBmp.getWidth();
        int r104 = this.mCurrentBmp.getHeight();
        VELogUtil.i(TAG, "width " + r101 + " height " + r102 + " image width " + r103 + " image height " + r104);
        float r105 = (float) r101;
        float r106 = (float) r102;
        float r107 = ((float) r103) / ((float) r104);
        if (r107 <= (r105 / r106)) goto L9;
        int r108 = (r102 - ((int) (r105 / r107))) / 2;
        Rect r109 = new Rect(0, r108, r101, r102 - r108);
    L10:
        r100.drawBitmap(this.mCurrentBmp, null, r109, null);
        r110.unlockCanvasAndPost(r100);
        if (this.mReDrawSurfaceOnce == false) goto L18;
        Bitmap r111 = this.mCurrentBmp;
        if (r111 != null) goto L15;
    L17:
        this.mReDrawSurfaceOnce = false;
        goto L18
    L15:
        if (r111.isRecycled() == true) goto L17;
        this.mCurrentBmp.recycle();
        this.mCurrentBmp = null;
        goto L17
    L9:
        int r112 = (r101 - ((int) (r106 * r107))) / 2;
        r109 = new Rect(r112, 0, r101 - r112, r102);
        goto L10
    }

    public int pause(boolean r100) {
        monitor-enter(this);
        VELogUtil.w(TAG, "pause... refreshFrame:" + r100);     // Catch: Throwable -> L9
        int r101 = this.mVideoEditor.pause(0);     // Catch: Throwable -> L9
        if (r100 == false) goto L7;
        r101 = refreshCurrentFrame();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public int pauseEffectAudio(boolean r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "pauseEffectAudio STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.S();
    }

    public int pauseInfoStickerAnimation(boolean r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "pauseInfoStickerAnimation STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.V();
    }

    public int prepareWithCallback(int r100) {
        if (this.mAutoPrepare == true) goto L5;
    L27:
        return 0;
    L5:
        if (mSAutoPrepare == false) goto L27;
        setVideoBackgroudColor(this.mVideoBackGroundColor);
        if (this.mUserCommonInfoCallback == null) goto L25;
        VEState r101 = VEState.ERROR;
        r101 = getState();     // Catch: Exception -> L22
        int r102 = getCurPosition();     // Catch: Exception -> L22
        this.mVideoEditor.setEnableRemuxVideo(false);
        this.mVideoEditor.setUsrRotate(0);
        int r103 = this.mVideoEditor.prepareEngine(r100);
        if (r103 == 0) goto L15;
        VELogUtil.e(TAG, "prepareEngine error: " + r103);
        this.mUserCommonInfoCallback.onCallback(4120, r101.ordinal(), (float) r102, null);
        return r103;
    L15:
        int[] r104 = this.mVideoEditor.getInitResolution();
        VESize r105 = this.mInitSize;
        r105.width = r104[0];
        r105.height = r104[1];
        if (this.mSurfaceWidth > 0) goto L18;
    L20:
        this.mUserCommonInfoCallback.onCallback(4120, r101.ordinal(), r102, null);
        return 0;
    L18:
        if (this.mSurfaceHeight <= 0) goto L20;
        updateInitDisplaySize();
    L22:
        e = move-exception;
        VELogUtil.e(TAG, "prepareWithCallback error: " + e);
        this.mUserCommonInfoCallback.onCallback(4120, r101.ordinal(), (float) 0, null);
        return -1;
    L25:
        this.mVideoEditor.setEnableRemuxVideo(false);
        this.mVideoEditor.setUsrRotate(0);
        return this.mVideoEditor.prepareEngine(r100);
    }

    public int pushImageToBuffer(String r100) {
        VELogUtil.i(TAG, "pushImageToBuffer: " + r100);
        if (r100 != null) goto L5;
    L9:
        VELogUtil.e(TAG, "pushImageToBuffer: filePath invalid!");
        return -100;
    L5:
        if (r100.isEmpty() == true) goto L9;
        return this.mVideoEditor.pushImageToBuffer(r100);
    }

    public int refreshCurrentFrameWithMode(int r100) {
        monitor-enter(this);
        VELogUtil.d(TAG, "refreshCurrentFrameWithMode...mode:" + r100);     // Catch: Throwable -> L7
        int r101 = this.mVideoEditor.refreshCurrentFrame(r100);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public int refreshWithCallback(VEListener.VEEditorSeekListener r100) {
        monitor-enter(this);
        VELogUtil.i(TAG, "refresh with cb... ");     // Catch: Throwable -> L6
        this.mSeekListener = r100;     // Catch: Throwable -> L6
        int r101 = this.mVideoEditor.refreshCurrentFrame(SEEK_MODE.EDITOR_SEEK_FLAG_LastSeek.getValue());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public void releaseEngineUnitResourceAsync(VEListener.VEEditorAsyncReleaseEngineUnitResourceListener r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoEditor == null) goto L6;
        VELogUtil.w(TAG, "onRelease Async... ");     // Catch: Throwable -> L8
        this.mAsyncReleaseEngineListener = r100;     // Catch: Throwable -> L8
        this.mVideoEditor.stop();     // Catch: Throwable -> L8
        this.mVideoEditor.releaseEngineAsync();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public int reloadComposerNodes(String[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "reloadComposerNodes");     // Catch: Throwable -> L11
        int r103 = r101.f455860b.reloadComposerNodes(r100);     // Catch: Throwable -> L11
        if (r103 == 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "reloadComposerNodes failed, ret = " + r103);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
    L10:
        return r103;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int removeComposerNodes(String[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "removeComposerNodes");     // Catch: Throwable -> L11
        int r103 = r101.f455860b.removeComposerNodes(r100);     // Catch: Throwable -> L11
        if (r103 == 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "removeComposerNodes failed, ret = " + r103);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
    L10:
        return r103;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int removeInfoSticker(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "removeInfoSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.e();
    }

    public int removeMusic(int r100) {
        return this.mWrapperBingo.t();
    }

    public int removeSegmentVolume(int r100) {
        w0 r101 = (w0) this.mWrapperSequence;
        if (r100 >= 0) goto L6;
        r101.getClass();
        return -100;
    L6:
        return r101.f455941b.removeFilter(new int[]{r100});
    }

    public boolean restore(VEEditorModel r100) {
        throw new VEException(-200, "Deprecated, no longer supported!");
    }

    public int set2DBrushCanvasAlpha(float r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "set2DBrushCanvasAlpha STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.w0();
    }

    public int set2DBrushColor(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "set2DBrushColor STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.u();
    }

    public int set2DBrushSize(float r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "set2DBrushSize STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.z0();
    }

    public int setAgeMakeupState(boolean r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        r101.getClass();
        VELogUtil.w("VEEditor_VEFilterInvoker", "setAgeMakeupState:" + r100);
        int r102 = r101.f455860b.setAgeMakeupState(r100);
        if (r102 == 0) goto L5;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setAgeMakeupState failed, ret = " + r102);
    L5:
        return r102;
    }

    public void setAlgorithmReplayModePlay(String r100) {
        this.mVideoEditor.setAlgorithmReplay(2, r100);
    }

    public void setAlgorithmReplayModeSave(String r100) {
        this.mVideoEditor.setAlgorithmReplay(1, r100);
    }

    public void setAutoPrepare(boolean r100) {
        VELogUtil.i(TAG, "setAutoPrepare... " + r100);
        this.mAutoPrepare = r100;
    }

    public void setBackgroundColor(int r100) {
        VELogUtil.i(TAG, "setBackgroundColor... color:" + r100);
        this.mBackGroundColor = r100;
        this.mVideoEditor.setBackGroundColor(r100);
    }

    public int setClientState(int r100) {
        VELogUtil.w(TAG, "setClientState");
        int r101 = this.mVideoEditor.setClientState(r100);
        if (r101 == 0) goto L5;
        VELogUtil.e(TAG, "setClientState failed, ret = " + r101);
    L5:
        return r101;
    }

    public int setColorFilter(String r100) {
        return ((k0) this.mWrapperFilter).h(r100, 0.0f, true, false);
    }

    public void setCompileDumpFilePath(String r100) {
        this.mVideoEditor.setCompileDumpFilePath(r100);
    }

    public void setCompileListener(VEListener.VEEditorCompileListener r100) {
        this.mCompileListener = r100;
    }

    public int setComposerNodes(String[] r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.w("VEEditor_VEFilterInvoker", "setComposerNodes");     // Catch: Throwable -> L11
        int r103 = r101.f455860b.setComposerNodes(r100);     // Catch: Throwable -> L11
        if (r103 == 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setComposerNodes failed, ret = " + r103);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
    L10:
        return r103;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int setDestroyVersion(boolean r100) {
        return this.mVideoEditor.setDestroyVersion(r100);
    }

    public int setDeviceRotation(float[] r100) {
        return setDeviceRotation(r100, -1.0d);
    }

    public synchronized void setDldEnabled(boolean r100) {
        monitor-enter(this);
        ((k0) this.mWrapperFilter).f455860b.setDldEnabled(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setDldThrVal(int r100) {
        monitor-enter(this);
        ((k0) this.mWrapperFilter).f455860b.setDldThrVal(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setDleEnabled(boolean r100) {
        monitor-enter(this);
        if (r100 == true) goto L11;
    L5:
        ((k0) this.mWrapperFilter).f455860b.setDleEnabled(r100);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        VELogUtil.e(TAG, "compileProbe setDleEnabled enabled = false");     // Catch: Throwable -> L8
        cancelCompileProbe();     // Catch: Throwable -> L8
        goto L5
    }

    public synchronized void setDleEnabledPreview(boolean r100) {
        monitor-enter(this);
        if (r100 == true) goto L11;
    L5:
        ((k0) this.mWrapperFilter).f455860b.setDleEnabledPreview(r100);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        VELogUtil.e(TAG, "compileProbe setDleEnabledPreview enabled = false");     // Catch: Throwable -> L8
        cancelCompileProbe();     // Catch: Throwable -> L8
        goto L5
    }

    public void setEditorMode(int r100) {
        this.mEditorMode = r100;
        VELogUtil.w(TAG, "setEditorMode: " + r100);
    }

    public void setEditorUsageType(String r100) {
        VELogUtil.i(TAG, "setEditorUsageType... " + r100);
        this.mUsageType = r100;
    }

    public int setEffectBgmEnable(boolean r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "setEffectBgmEnable STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.U();
    }

    public int setEffectHDRFilter(String r100) {
        VELogUtil.e(TAG, "EFFECT HDR IS NOT SUPPORT!!!");
        return -1;
    }

    public int setEffectListener(VEListener.VEEditorEffectListener r100) {
        this.mVideoEditor.setEffectCallback(r100);
        return 0;
    }

    public int setEffectMaxMemoryCache(int r100) {
        VELogUtil.w(TAG, "setEffectMaxMemoryCache size:" + r100);
        if (r100 >= 0) goto L6;
        return -100;
    L6:
        int r101 = this.mVideoEditor.setEffectMaxMemoryCache(r100);
        if (r101 == 0) goto L9;
        VELogUtil.e(TAG, "setEffectMaxMemoryCache failed, ret = " + r101);
    L9:
        return r101;
    }

    public void setEnableMultipleAudioFilter(boolean r100) {
        ((k0) this.mWrapperFilter).f455860b.setEnableMultipleAudioFilter(r100);
    }

    public void setExpandLastFrame(boolean r100) {
        VELogUtil.i(TAG, "setExpandLastFrame...");
        this.mVideoEditor.setExpandLastFrame(r100);
    }

    public void setFirstFrameListener(VEListener.VEFirstFrameListener r100) {
        this.mFirstFrameListener = r100;
    }

    public void setForceDetectForFirstFrameByClip(boolean r100) {
        this.mVideoEditor.setForceDetectForFirstFrameByClip(r100);
    }

    public void setHeightWidthRatio(float r100) {
        VELogUtil.i(TAG, "setHeightWidthRatio... ratio:" + r100);
        this.mVideoEditor.setHeightWidthRatio(r100);
    }

    public int setInfoStickerBufferCallback(VEListener.VEInfoStickerBufferListener r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerBufferCallback STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.e0();
    }

    public int setInfoStickerCallSync(boolean r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerCallSync STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.Q();
    }

    public int setInfoStickerRestoreMode(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerRestoreMode STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.F();
    }

    public void setInitSuccess(boolean r100) {
        this.mInitSuccess = r100;
    }

    public void setInitTimeMS(long r100) {
        this.mlInitTimeMS = r100;
    }

    public int setInterimScoresToFile(String r100) {
        return this.mWrapperBingo.h();
    }

    public int setLanguage(String r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "setLanguage STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.P();
    }

    public void setLastTimeMS(long r100) {
        this.mlLastTimeMS = r100;
    }

    public int setLensHDRFilter(String r100) {
        return ((k0) this.mWrapperFilter).k(r100, 1.0d);
    }

    public void setListenerForMV(VEListener.VEMVInitListener r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L6;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return;
    L6:
        r101.j();
    }

    public void setLoopPlay(boolean r100) {
        VELogUtil.i(TAG, "setLoopPlay");
        this.mVideoEditor.setLooping(r100);
    }

    public int setMVAudioBeatAlgorithmResult(VEMVAudioAlgorithmResult r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r101.o();
    }

    public int setMVDataJson(String r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r101.p();
    }

    public int setMaleMakeupState(boolean r100) {
        k0 r101 = (k0) this.mWrapperFilter;
        r101.getClass();
        VELogUtil.w("VEEditor_VEFilterInvoker", "setMaleMakeupState:" + r100);
        int r102 = r101.f455860b.setMaleMakeupState(r100);
        if (r102 == 0) goto L5;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setMaleMakeupState failed, ret = " + r102);
    L5:
        return r102;
    }

    public void setMasterTrackIndex(int r100) {
        this.mMasterTrackIndex = r100;
    }

    public int setMessageCenterListener(VEListener.VEMessageCenterListener r100) {
        return this.mVideoEditor.setMessageCenterListener(r100);
    }

    public void setMessageHandlerLooper(Looper r100) {
        if (r100 == null) goto L4;
        this.mMessageHandler = new t(this, r100);
        return;
    L4:
        this.mMessageHandler.removeCallbacksAndMessages(null);
        this.mMessageHandler = null;
    }

    public void setMultiComposer(boolean r100) {
        this.mVideoEditor.setMultiComposer(r100);
    }

    public int setMusicCropRatio(int r100) {
        return this.mWrapperBingo.g();
    }

    public void setMusicSRTEffectFilterIndex(int r100) {
        ((k0) this.mWrapperFilter).f455866h = r100;
    }

    public int setMusicSrtEffect(VEMusicSRTEffectParam r100) {
        return ((k0) this.mWrapperFilter).l(r100, false);
    }

    public void setOnErrorListener(VECommonCallback r100) {
        this.mUserCommonErrorCallback = r100;
        VELogUtil.i(TAG, "setOnErrorListener...");
    }

    public void setOnInfoListener(VECommonCallback r100) {
        VELogUtil.i(TAG, "setOnInfoListener...");
        this.mUserCommonInfoCallback = r100;
    }

    public synchronized void setPageMode(int r100) {
        monitor-enter(this);
        this.mPageMode = r100;     // Catch: Throwable -> L7
        VELogUtil.w(TAG, "setPageMode: " + r100);     // Catch: Throwable -> L7
        this.mVideoEditor.setPageMode(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int setPreviewFps(int r100) {
        VELogUtil.i(TAG, "setPreviewFps = " + r100);
        this.mVideoEditor.setPreviewFps(r100);
        return 0;
    }

    public int setPreviewScaleMode(PREVIEW_SCALE_MODE r100) {
        VELogUtil.w(TAG, "setPreviewScaleMode");
        int r101 = this.mVideoEditor.setPreviewScaleMode(r100.ordinal());
        if (r101 == 0) goto L5;
        VELogUtil.e(TAG, "setPreviewScaleMode failed, ret = " + r101);
    L5:
        return r101;
    }

    public void setPreviewSurfaceBitmap(Bitmap r100) {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to setPreviewSurfaceBitmap, is destroying, just return");
        return;
    L6:
        VELogUtil.i(TAG, "setPreviewSurfaceBitmap...");
        this.mVideoEditor.setPreviewSurfaceBitmap(r100, true);
    }

    public void setReDrawBmp(Bitmap r100) {
        VELogUtil.i(TAG, "setReDrawBmp...");
        if (this.mFirstTimeSurfaceCreate == true) goto L5;
        return;
    L5:
        Bitmap r101 = this.mCurrentBmp;
        if (r101 != null) goto L8;
    L10:
        this.mCurrentBmp = Bitmap.createBitmap(r100);
        this.mReDrawSurface = true;
        this.mReDrawSurfaceOnce = true;
        return;
    L8:
        if (r101.isRecycled() == true) goto L10;
        this.mCurrentBmp.recycle();
        goto L10
    }

    public int setReverseVideoPaths(String[] r100) {
        VELogUtil.w(TAG, "setReverseVideoPaths");
        if (r100 != null) goto L5;
    L12:
        VELogUtil.e(TAG, "setReverseVideoPaths error, reverseVideoPaths is null");
        return -100;
    L5:
        if (r100.length <= 0) goto L12;
        VEEditorResManager r101 = this.mResManager;
        if (r101 == null) goto L14;
        r101.mReverseVideoPath = r100;
        r101.mReverseDone = true;
        return 0;
    L14:
        return 0;
    }

    public int setScaleMode(SCALE_MODE r100) {
        if (this.mIsDestroying.get() == false) goto L7;
        VELogUtil.w(TAG, "set scale mode failed,is destroying, just return");
        return 0;
    L7:
        return setScaleMode(r100, 0.0f, 0.0f);
    }

    public void setSeparateAV(Boolean r100) {
        this.mbSeparateAV = r100;
    }

    public int setSpeedRatio(float r100) {
        VELogUtil.i(TAG, "setSpeedRatio = " + r100);
        this.mVideoEditor.setSpeedRatio(r100);
        return 0;
    }

    public synchronized int setSpeedRatioAndUpdate(float r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDestroying.get() == false) goto L9;
        VELogUtil.w(TAG, "no need to setSpeedRatioAndUpdate, is destroying, just return");     // Catch: Throwable -> L15
        monitor-exit(this);
        return 0;
    L9:
        VELogUtil.w(TAG, "setSpeedRatioAndUpdate = " + r100);     // Catch: Throwable -> L15
        this.mVideoEditor.stop();     // Catch: Throwable -> L15
        if (r100 <= 3.0f) goto L12;
        r100 = 3.0f;
    L12:
        this.mVideoEditor.setSpeedRatio(r100);     // Catch: Throwable -> L15
        this.mVideoEditor.createTimeline();     // Catch: Throwable -> L15
        int r101 = this.mVideoEditor.prepareEngine(0);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r101;
    }

    public void setSurfaceReDraw(boolean r100) {
        VELogUtil.i(TAG, "setSurfaceReDraw...");
        this.mReDrawSurface = r100;
        if (r100 == true) goto L6;
        this.mCurrentBmp = null;
        return;
    }

    public int setTextBitmapCallback(r r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "setTextBitmapCallback STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.l();
    }

    public void setUseLargeMattingModel(boolean r100) {
        monitor-enter(this);
        this.mVideoEditor.setUseLargeMattingModel(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setVEEncoderListener(VEListener.VEEncoderListener r100) {
        this.mEncoderListener = r100;
    }

    public void setVideoBackgroudColor(int r100) {
        VELogUtil.i(TAG, "setVideoBackgroudColor... color:" + r100);
        this.mVideoBackGroundColor = r100;
        this.mVideoEditor.setVideoBackGroundColor(r100);
    }

    public void setVideoOutRes(VIDEO_RATIO r100) {
        this.mVideoOutRes = r100;
    }

    public void setVideoOutputListener(VEListener.VEVideoOutputListener r100) {
        this.mVideoOutputListener = r100;
        if (this.mVideoOutputListener == null) goto L6;
        TEInterface.openOutputCallback(true);
        return;
    }

    public void setVideoPaths(String[] r100) {
        VELogUtil.w(TAG, "setVideoPaths");
        this.mResManager.mVideoPaths = r100;
    }

    public void setmKeyFrameListener(VEListener.o r100) {
        if (r100 == null) goto L5;
        this.mVideoEditor.setKeyFrameCallback(this.mkeyFrameCallback);
        return;
    }

    public void setmMattingListener(VEListener.q r100) {
        if (r100 == null) goto L5;
        this.mVideoEditor.setMattingCallback(this.mMattingCallback);
        return;
    }

    public int stopInfoStickerPin(int r100) {
        dic.f r101 = this.mWrapperSticker;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "stopInfoStickerPin STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r101.p0();
    }

    public int updateCanvasResolutionParam(VECanvasFilterParam r100) {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to play, is destroying, just return");
        return 0;
    L6:
        w0 r101 = (w0) this.mWrapperSequence;
        VEEditor r102 = r101.f455940a;
        monitor-enter(r102);
        VELogUtil.i("VEEditor_VESequenceInvoker", "updateCanvasResolutionParam " + r100.width + ", " + r100.height);     // Catch: Throwable -> L19
        int r103 = r101.f455941b.updateCanvasResolution(r100.width, r100.height);     // Catch: Throwable -> L19
        int[] r104 = r101.f455941b.getInitResolution();     // Catch: Throwable -> L19
        r101.f455940a.getFieldInitSize().width = r104[0];     // Catch: Throwable -> L19
        r101.f455940a.getFieldInitSize().height = r104[1];     // Catch: Throwable -> L19
        if (r101.f455940a.getSurfaceWidth() > 0) goto L11;
    L22:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("sourceType", r100.sourceType);     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("color", r100.color);     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("radius", r100.radius);     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("imagePath", r100.imagePath);     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("height", r100.height);     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("width", r100.width);     // Catch: JSONException -> L15 Throwable -> L19
        r105.put("resultCode", r103);     // Catch: JSONException -> L15 Throwable -> L19
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_canvas", r105, "business");     // Catch: JSONException -> L15 Throwable -> L19
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return r103;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L11:
        if (r101.f455940a.getSurfaceHeight() <= 0) goto L22;
        r101.f455940a.updateInitDisplaySize();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public void updateMVFilterInternal(int r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.x() == false) goto L9;
        this.mWrapperMV.h();
        return;
    }

    public void updateMVFiltersInternal(int[] r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.x() == false) goto L11;
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        int r104 = r100[r103];
        this.mWrapperMV.h();
        r103 = r103 + 1;
        goto L7
    L12:
        return;
    }

    public int updateMVResources(VEMVParams r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r101.m();
    }

    public int updateMVResourcesRecreateEngine(VEMVParams r100) {
        dic.d r101 = this.mWrapperMV;
        if (r101 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r101.i();
    }

    public int updateSceneFileOrder(VETimelineParams r100) {
        w0 r101 = (w0) this.mWrapperSequence;
        VEEditor r102 = r101.f455940a;
        monitor-enter(r102);
        r101.f455941b.stop();     // Catch: Throwable -> L21
        int r103 = r101.f455941b.updateSceneFileOrder(r100);     // Catch: Throwable -> L21
        if (r103 >= 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateSceneFileOrder failed, ret = " + r103);     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r103;
    L9:
        r101.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L21
        r101.f455941b.createTimeline();     // Catch: Throwable -> L21
        if (r101.f455940a.getBusinessManager().f523232a != 1) goto L12;
        TEInterface r104 = r101.f455941b;     // Catch: Throwable -> L21
        r104.setTimeRange(0, r104.getDuration(), 1);     // Catch: Throwable -> L21
    L13:
        int r105 = r101.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L21
        if (r105 == 0) goto L18;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r105);     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r105;
    L18:
        monitor-exit(r102);     // Catch: Throwable -> L21
        return 0;
    L12:
        r101.f455941b.setTimeRange(0, r103, 0);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public int updateSceneTime(VETimelineParams r110) {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        VELogUtil.w("VEEditor_VESequenceInvoker", "updateSceneTime... " + r110.toString());
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        r100.f455941b.stop();     // Catch: Throwable -> L26
        int r102 = r100.f455941b.updateSenceTime(r110);     // Catch: Throwable -> L26
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L12 Throwable -> L26
        if (r102 < 0) goto L9;
        int r104 = 0;
    L10:
        r103.put("resultCode", String.valueOf(r104));     // Catch: JSONException -> L12 Throwable -> L26
        r103.put("sceneTime", r110.toString());     // Catch: JSONException -> L12 Throwable -> L26
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_update_scene_time", r103, "business");     // Catch: JSONException -> L12 Throwable -> L26
    L14:
        if (r102 >= 0) goto L18;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateSceneTime failed, ret = " + r102);     // Catch: Throwable -> L26
        monitor-exit(r101);     // Catch: Throwable -> L26
        return r102;
    L18:
        r100.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L26
        r100.f455940a.updateFilters();     // Catch: Throwable -> L26
        r100.f455941b.setTimeRange(0, r102, 0);     // Catch: Throwable -> L26
        int r105 = r100.f455941b.prepareEngine(0);     // Catch: Throwable -> L26
        if (r105 == 0) goto L23;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r105);     // Catch: Throwable -> L26
        monitor-exit(r101);     // Catch: Throwable -> L26
        return r105;
    L23:
        monitor-exit(r101);     // Catch: Throwable -> L26
        return 0;
    L9:
        r104 = r102;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public int pause(int r100) {
        monitor-enter(this);
        if (r100 != 0) goto L7;
        int r101 = pause();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r101;
    L7:
        int r102 = this.mVideoEditor.pause(1);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public int setPreviewScaleMode(int r100) {
        VELogUtil.w(TAG, "setPreviewScaleMode");
        int r101 = this.mVideoEditor.setPreviewScaleMode(r100);
        if (r101 == 0) goto L5;
        VELogUtil.e(TAG, "setPreviewScaleMode failed, ret = " + r101);
    L5:
        return r101;
    }

    public VEEditor(String r100, VEUserConfig r101) throws VEException {
        this.mInitSize = new VESize(-1, -1);
        this.mCompileType = "mp4";
        this.mMessageHandler = new t(this, Looper.getMainLooper());
        this.mSeekListener = null;
        this.mCompileListener = null;
        this.mFirstFrameListener = null;
        this.mVideoOutputListener = null;
        this.mAsyncReleaseEngineListener = null;
        this.mUserCommonInfoCallback = null;
        this.mUserCommonErrorCallback = null;
        this.mTrackIndexManager = new TETrackIndexManager();
        this.mBusinessManager = new ogc.a();
        this.mAutoPrepare = true;
        this.mUsageType = "unknown";
        this.mRecordData = null;
        this.mConcatVideoPath = "/concatShootVideo";
        this.mKeyFrameMap = new HashMap();
        this.mIsDestroying = new AtomicBoolean(false);
        this.mConcatVideoErrorForInvalidCodecs = -1;
        this.mTeCommonInfoCallback = new h(this);
        this.mTeCommonErrorCallback = new i(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInitDisplayWidth = 0;
        this.mInitDisplayHeight = 0;
        this.mbSeparateAV = Boolean.FALSE;
        this.mMasterTrackIndex = 0;
        this.miFrameCount = 0;
        this.mlCurTimeMS = 0;
        this.mlLastTimeMS = 0;
        this.mlInitTimeMS = 0;
        this.mlFirstSeekTimeMS = 0;
        this.mlFirstPlayTimeMS = 0;
        this.mlLastSeekTimeMS = 0;
        this.mlFirstFrameWithoutSurfaceTimeMS = 0;
        this.mFirstFrameDrawed = false;
        this.miCacheHitCount = 0;
        this.miCacheMissCount = 0;
        this.mInPoint = 0;
        this.mOutPoint = -1;
        this.mVideoGravity = VIDEO_GRAVITY.ALIGN_PARENT_BOTTOM;
        this.mVideoScaletype = VIDEO_SCALETYPE.CENTER;
        this.mInitSuccess = false;
        this.mReverseDone = false;
        this.mCancelReverse = false;
        this.mCanvasWrapFilterIndex = -1;
        this.mOutputFile = null;
        this.mlCompileStartTime = 0;
        this.mBReversePlay = false;
        this.mBCompileHighQualityGif = false;
        this.mp4ToGIFConverter = null;
        this.mEncoderListener = null;
        this.mGetImageListener = null;
        this.mGetSeekFrameListener = null;
        this.mTEMonitorFilterMgr = new com.ss.android.ttve.monitor.j();
        this.mReDrawSurface = false;
        this.mFirstTimeSurfaceCreate = true;
        this.mReDrawSurfaceOnce = false;
        this.mCurrentBmp = null;
        this.rotate = 0.0f;
        this.scaleW = 1.0f;
        this.scaleH = 1.0f;
        this.mPageMode = -1;
        this.mEditorMode = -1;
        this.mBackGroundColor = -16777216;
        this.mVideoBackGroundColor = -16777216;
        this.model_sequence_time = 0;
        this.editor_time = 0;
        this.mPlayFps = 0.0f;
        this.mTextureListener = new j(this);
        this.mSurfaceCallback = new k(this);
        this.mOpenGLCallback = new l(this);
        this.mEncoderDataCallback = new m(this);
        this.mGetImageCallback = new n(this);
        this.mGetSeekFrameCallback = new o(this);
        this.mGetCompileFirstFrameCallback = new p(this);
        this.mMattingCallback = new a(this);
        this.mkeyFrameCallback = new b(this);
        y0.a("VEEditor-offscreen-config");
        if (TextUtils.isEmpty(r100) == true) goto L7;
        VELogUtil.i(TAG, "VEEditor offscreen");
        this.mVideoEditor = TEInterface.createEngine(r101);
        this.mResManager = new VEEditorResManager(r100);
        this.mVideoEditor.setOpenGLListeners(this.mOpenGLCallback);
        this.mVideoEditor.setInfoListener(this.mTeCommonInfoCallback);
        this.mVideoEditor.setErrorListener(this.mTeCommonErrorCallback);
        com.ss.android.ttve.monitor.g.b(null);
        enableEffectAmazing(false);
        createWrapperInvokers();
        y0.b();
        return;
    L7:
        throw new VEException(-100, "workspace is: " + r100);
    }

    private boolean _compileOnlyAudio(String r100, VEAudioEncodeSettings r101) throws VEException {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitSuccess == false) goto L17;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L8;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L18
        return false;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        this.mlCompileStartTime = System.currentTimeMillis();     // Catch: Throwable -> L18
        VELogUtil.i(TAG, "_compileOnlyAudio...");     // Catch: Throwable -> L18
        this.mVideoEditor.stop();     // Catch: Throwable -> L18
        this.mVideoEditor.setCompileType(16);     // Catch: Throwable -> L18
        this.mVideoEditor.setEngineCompilePath(r100 + DefaultDiskStorage.FileType.TEMP, r100);     // Catch: Throwable -> L18
        this.mVideoEditor.setEnableRemuxVideo(true);     // Catch: Throwable -> L18
        this.mVideoEditor.setAudioCompileSetting(r101.getSampleRate(), r101.getChannelCount(), r101.getBps());     // Catch: Throwable -> L18
        addCopyright();     // Catch: Throwable -> L18
        this.mVideoEditor.prepareEngine(1);     // Catch: Throwable -> L18
        this.mVideoEditor.start();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L17:
        throw new VEException(-105, "Make sure the initialization is successful before coding!!!");     // Catch: Throwable -> L18
    }

    public static /* synthetic */ boolean access$002(VEEditor r100, boolean r101) {
        r100.mBCompileHighQualityGif = r101;
        return r101;
    }

    public static /* synthetic */ VEListener.VEGetImageListener access$1402(VEEditor r100, VEListener.VEGetImageListener r101) {
        r100.mGetImageListener = r101;
        return r101;
    }

    public static /* synthetic */ SurfaceTexture access$1502(VEEditor r100, SurfaceTexture r101) {
        r100.mSurfaceTexture = r101;
        return r101;
    }

    public static /* synthetic */ Surface access$1602(VEEditor r100, Surface r101) {
        r100.mSurface = r101;
        return r101;
    }

    public static /* synthetic */ int access$1702(VEEditor r100, int r101) {
        r100.mSurfaceWidth = r101;
        return r101;
    }

    public static /* synthetic */ int access$1802(VEEditor r100, int r101) {
        r100.mSurfaceHeight = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2002(VEEditor r100, boolean r101) {
        r100.mFirstFrameDrawed = r101;
        return r101;
    }

    public static /* synthetic */ int access$2602(VEEditor r100, int r101) {
        r100.miFrameCount = r101;
        return r101;
    }

    public static /* synthetic */ long access$2702(VEEditor r100, long r101) {
        r100.mlCurTimeMS = r101;
        return r101;
    }

    public static /* synthetic */ long access$2802(VEEditor r100, long r101) {
        r100.mlLastTimeMS = r101;
        return r101;
    }

    public static /* synthetic */ VEListener.VEEditorCompileListener access$302(VEEditor r100, VEListener.VEEditorCompileListener r101) {
        r100.mCompileListener = r101;
        return r101;
    }

    public static /* synthetic */ VEListener.VEEditorSeekListener access$602(VEEditor r100, VEListener.VEEditorSeekListener r101) {
        r100.mSeekListener = r101;
        return r101;
    }

    public static /* synthetic */ long access$802(VEEditor r100, long r101) {
        r100.mlFirstFrameWithoutSurfaceTimeMS = r101;
        return r101;
    }

    public static /* synthetic */ float access$902(VEEditor r100, float r101) {
        r100.mPlayFps = r101;
        return r101;
    }

    private int calSeekToleranceBySpeed(float r100, float r110) {
        int r101 = 10;
        if (r110 != 0.0f) goto L5;
    L23:
        return 10;
    L5:
        if (r100 == 0.0f) goto L23;
        if (r110 >= 0.0f) goto L10;
        boolean r102 = true;
    L11:
        float r103 = Math.abs(r100);
        float r111 = Math.abs(r110);
        if (r111 > 0.1d) goto L17;
        float r104 = r103 / r111;
        float r112 = 10;
        float r105 = (r104 * r112) / 2.0f;
        if (r105 > r112) goto L16;
        return 10;
    L16:
        return (int) r105;
    L17:
        if (r102 == false) goto L19;
        r101 = 5;
    L19:
        float r113 = ((1000.0f / r101) * r103) / 2.0f;
        if (r113 > 100) goto L22;
        return 100;
    L22:
        return (int) r113;
    L10:
        r102 = false;
        goto L11
    }

    public static int genReverseVideo(String r100, String r101) {
        VELogUtil.w(TAG, "genReverseVideo width path");
        if (r100 != null) goto L5;
        return -100;
    L5:
        if (r100.length() == 0) goto L14;
        if (r101 != null) goto L8;
        return -100;
    L8:
        if (r101.length() == 0) goto L16;
        return 0;
    L16:
        return -100;
    L14:
        return -100;
    }

    private int reverseFilter(int r100, int r101) {
        monitor-enter(this);
        VELogUtil.w(TAG, "reverseFilter");     // Catch: Throwable -> L17
        TEInterface r102 = this.mVideoEditor;     // Catch: Throwable -> L17
        if (r102 != null) goto L10;
        VELogUtil.w(TAG, "VideoEditorgit is null ,init it first");     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return -1;
    L10:
        r102.stop();     // Catch: Throwable -> L17
        TEInterface r103 = this.mVideoEditor;     // Catch: Throwable -> L17
        r103.updateTrackFilterDuration(r100, r101, true, r103.getDurationUs());     // Catch: Throwable -> L17
        int r104 = this.mVideoEditor.prepareEngine(0);     // Catch: Throwable -> L17
        if (r104 == 0) goto L15;
        VELogUtil.e(TAG, "reverseFilter prepareEngine failed: result: " + r104);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r104;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public static void setSmartCodecPath(List<String> r100, float r101) {
        TEAvcEncoder.setSmartCodecPath(r100, r101);
    }

    public static int setTexturePoolLimit(int r100, int r101) {
        VELogUtil.i(TAG, "setTexturePoolLimit: " + r100 + ", " + r101);
        return TEInterface.setTexturePoolLimit(r100, r101);
    }

    public int addAudioTrackWithStruct(VECommonClipParam r100, boolean r110) {
        w0 r101 = (w0) this.mWrapperSequence;
        VEEditor r102 = r101.f455940a;
        monitor-enter(r102);
        int r103 = -100;
        if (TextUtils.isEmpty(r100.path) == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L30
    L29:
        return r103;
    L8:
        int r104 = r100.trimOut;     // Catch: Throwable -> L30
        int r105 = r100.trimIn;     // Catch: Throwable -> L30
        if (r104 <= r105) goto L28;
        if (r105 < 0) goto L28;
        int r106 = r100.seqOut;     // Catch: Throwable -> L30
        int r107 = r100.seqIn;     // Catch: Throwable -> L30
        int r108 = 0;
        if (r106 <= r107) goto L15;
        if (r107 < 0) goto L15;
    L16:
        int r111 = r101.f455941b.addAudioTrackWithStruct(r100, r110);     // Catch: Throwable -> L30
        r103 = r101.f455940a.getTrackIndexManager().a(1, r111);     // Catch: Throwable -> L30
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L23 Throwable -> L30
        r109.put("path", r100.path);     // Catch: JSONException -> L23 Throwable -> L30
        r109.put("sequenceIn", r100.seqIn);     // Catch: JSONException -> L23 Throwable -> L30
        r109.put("sequenceOut", r100.seqOut);     // Catch: JSONException -> L23 Throwable -> L30
        r109.put("trimIn", r100.trimIn);     // Catch: JSONException -> L23 Throwable -> L30
        r109.put("trimOut", r100.trimOut);     // Catch: JSONException -> L23 Throwable -> L30
        if (r103 >= 0) goto L21;
        r108 = r103;
    L21:
        r109.put("resultCode", r108);     // Catch: JSONException -> L23 Throwable -> L30
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_audio_track", r109, "business");     // Catch: JSONException -> L23 Throwable -> L30
    L25:
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrackWithStruct, trackIndexNative: " + r111 + ", trackIndex: " + r103);     // Catch: Throwable -> L30
        monitor-exit(r102);     // Catch: Throwable -> L30
        goto L29
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
    L15:
        r100.seqIn = 0;     // Catch: Throwable -> L30
        r100.seqOut = r104 - r105;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r102);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public int addInfoSticker(String r100, String[] r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "addInfoSticker 1 STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.c();
    }

    public int addInfoStickerOrEmoji(String r100, String r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "addInfoStickerOrEmoji STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.p();
    }

    public int addInfoStickerTemplate(String r100, String r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "addInfoStickerTemplate STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.k();
    }

    public int addMetadata(String r100, String r101) {
        monitor-enter(this);
        VELogUtil.w(TAG, "addMetadata...");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L15
        return -100;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        this.mVideoEditor.addMetaData(r100, r101);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return 0;
    L15:
        th = move-exception;
        throw th;
    }

    public int addTextStickerWithInitInfo(String r100, String r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "addTextStickerWithInitInfo2 STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.H();
    }

    public int changeTransitionAt(int r100, VETransitionFilterParam r110) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        VELogUtil.i("VEEditor_VEFilterInvoker", "changeTransition " + r100 + ", VETransitionFilterParam = " + r110);     // Catch: Throwable -> L34
        if (r100 < 0) goto L31;
        if (r110 == null) goto L31;
        if (r110.transName != null) goto L12;
        r110.transName = "";     // Catch: Throwable -> L34
    L12:
        if (r110.tranType >= 0) goto L15;
        r110.tranType = VETransitionFilterParam.TransitionType.TransitionType_DEFAULT.ordinal();     // Catch: Throwable -> L34
    L15:
        if (r110.tranDuration > 0) goto L17;
        r110.tranDuration = 500;     // Catch: Throwable -> L34
    L17:
        r101.f455860b.stop();     // Catch: Throwable -> L34
        int r103 = r101.f455860b.changeTransitionAt(r100, r110);     // Catch: Throwable -> L34
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L20 Throwable -> L34
        r104.put("transIndex", r100);     // Catch: JSONException -> L20 Throwable -> L34
        r104.put("param", r110.toString());     // Catch: JSONException -> L20 Throwable -> L34
        r104.put("resultCode", r103);     // Catch: JSONException -> L20 Throwable -> L34
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_transition_change_by_params", r104, "behavior");     // Catch: JSONException -> L20 Throwable -> L34
    L22:
        if (r103 == 0) goto L24;
        VELogUtil.e("VEEditor_VEFilterInvoker", "changeTransition " + r100 + ", VETransitionFilterParam=" + r110.toString() + " failed, result = " + r103);     // Catch: Throwable -> L34
    L24:
        int r105 = r101.f455859a.prepareWithCallback(0);     // Catch: Throwable -> L34
        if (r105 == 0) goto L29;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Prepare Engine failed, ret = " + r105);     // Catch: Throwable -> L34
        monitor-exit(r102);     // Catch: Throwable -> L34
        return r105;
    L29:
        monitor-exit(r102);     // Catch: Throwable -> L34
        return r105;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
    L31:
        monitor-exit(r102);     // Catch: Throwable -> L34
        return -100;
    L34:
        th = move-exception;
        throw th;
    }

    public int deleteAudioTrack(int r100, boolean r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.w("VEEditor_VESequenceInvoker", "deleteAudioTrack... trackIndex:" + r100 + " needPrepare:" + r101);     // Catch: Throwable -> L20
        if (r100 < 0) goto L17;
        if (r101 == false) goto L8;
        r102.f455941b.stop();     // Catch: Throwable -> L20
    L8:
        int r104 = r102.f455940a.getTrackIndexManager().b(1, r100);     // Catch: Throwable -> L20
        r102.f455940a.getTrackIndexManager().c(1, r100);     // Catch: Throwable -> L20
        int r105 = r102.f455941b.deleteAudioTrack(r104, r101);     // Catch: Throwable -> L20
        if (r101 == false) goto L15;
        TEInterface r106 = r102.f455941b;     // Catch: Throwable -> L20
        r106.setTimeRange(0, r106.getDuration(), 1);     // Catch: Throwable -> L20
        int r107 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L20
        if (r107 == 0) goto L15;
        VELogUtil.e("VEEditor_VESequenceInvoker", "deleteAudioTrack Prepare Engine failed, ret = " + r107);     // Catch: Throwable -> L20
        monitor-exit(r103);     // Catch: Throwable -> L20
        return r107;
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L20
        return r105;
    L17:
        monitor-exit(r103);     // Catch: Throwable -> L20
        return -100;
    L20:
        th = move-exception;
        throw th;
    }

    public int deleteClip(int r100, int r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "deleteClip, trackType:" + r100 + "clipIndex:" + r101);     // Catch: Throwable -> L16
        r102.f455941b.stop();     // Catch: Throwable -> L16
        int r104 = r102.f455941b.deleteClip(r100, 0, r101);     // Catch: Throwable -> L16
        if (r104 >= 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "deleteClip failed, ret = " + r104);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
    L20:
        return r104;
    L9:
        r102.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L16
        TEInterface r105 = r102.f455941b;     // Catch: Throwable -> L16
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L16
        r104 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L16
        if (r104 == 0) goto L14;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r104);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        goto L20
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
        return 0;
    L16:
        th = move-exception;
        throw th;
    }

    public int disableAudioEffect(int r100, int r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        VELogUtil.w("VEEditor_VEFilterInvoker", "disableAudioEffect... filterIndex " + r100 + ", outPoint " + r101);
        if (r100 != (-1)) goto L6;
        return -100;
    L6:
        return r102.f455860b.adjustFilterInOut(r100, -1, r101);
    }

    public int disableFilterEffect(int r100, int r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        VELogUtil.w("VEEditor_VEFilterInvoker", "disableFilterEffect... " + r100 + " " + r101);
        if (r100 < 0) goto L14;
        if (r101 < 0) goto L14;
        com.ss.android.ttve.monitor.j.a r103 = (com.ss.android.ttve.monitor.j.a) ((HashMap) r102.f455859a.getTEMonitorFilterMgr().f449944a).get(Integer.valueOf(r100));
        if (r103 == null) goto L16;
        r103.f449948c = r101 - r103.f449947b;
    L16:
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L11
        r104.put("outPoint", r101);     // Catch: JSONException -> L11
        r104.put("effectIndex", r100);     // Catch: JSONException -> L11
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_filter_effect_end", r104, "behavior");     // Catch: JSONException -> L11
    L18:
        return r102.f455860b.adjustFilterInOut(r100, -1, r101);
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        VELogUtil.e("VEEditor_VEFilterInvoker", "disableFilterEffect... error. effectIndex = " + r100 + ", outPoint = " + r101);
        return -100;
    }

    public int enableAudioEffect(int r100, VEAudioEffectBean r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        VELogUtil.w("VEEditor_VEFilterInvoker", "enableAudioEffect...");
        boolean r103 = r102.f455859a.getSeparateAV().booleanValue();
        cancelCompileProbe();
        int r104 = r102.d(0, r103 ? 1 : 0, r100, r101);
        r102.f455865g = r104;
        return r104;
    }

    public int enableFilterEffect(int r100, String r101) {
        return ((k0) this.mWrapperFilter).e(r100, r101, 0, 0, "");
    }

    public int enableStickerAnimationPreview(int r100, boolean r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "enableStickerAnimationPreview STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.u0();
    }

    public int enableStickerResourceLoadSync(int r100, boolean r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "enableStickerResourceLoadSync STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.x();
    }

    public int forceUpdateInfoSticker(int r100, boolean r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "forceUpdateInfoSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.W();
    }

    public List<VEClipParam> getAllClips(int r100, int r101) {
        List<VEClipParam> r102 = ((w0) this.mWrapperSequence).f455941b.getAllClips(r100, r101);
        int r103 = 0;
    L4:
        if (r103 >= r102.size()) goto L6;
        VELogUtil.w("VEEditor_VESequenceInvoker", "getAllClips: " + ((VEClipParam) ListProtector.get(r102, r103)).toString());
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    public Bitmap getCurrDecodeImage(int r100, int r101) {
        int r102 = this.mTrackIndexManager.b(2, r100);
        VELogUtil.i(TAG, "getCurrDecodeImage... trackIndex:" + r102 + " clipIndex:" + r101);
        monitor-enter(this);
        VERect r103 = this.mVideoEditor.getDecodeRect(r102, r101);     // Catch: Throwable -> L24
        int r104 = r103.width;     // Catch: Throwable -> L24
        int r105 = r103.height;     // Catch: Throwable -> L24
        if (r104 <= 0) goto L22;
        if (r105 <= 0) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L24
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L19
        int r107 = this.mVideoEditor.getDecodeImage(r106, r102, r101);
        if (r107 == 0) goto L18;
        VELogUtil.e(TAG, "getCurrDecodeImage failed " + r107);
        if (r106 != null) goto L15;
    L17:
        return null;
    L15:
        if (r106.isRecycled() == true) goto L17;
        r106.recycle();
        goto L17
    L18:
        return r106;
    L19:
        e = move-exception;
        VELogUtil.e(TAG, "getCurrDecodeImage createBitmap failed " + e.getMessage());
        return null;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L24
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    public VEBitmapWithInfo getCurrDecodeImageWithInfo(int r100, int r101) {
        int r102 = this.mTrackIndexManager.b(2, r100);
        VELogUtil.i(TAG, "getCurrDecodeImage... trackIndex:" + r102 + " clipIndex:" + r101);
        monitor-enter(this);
        int[] r103 = this.mVideoEditor.getDecodeInfo(r102, r101);     // Catch: Throwable -> L30
        int r104 = r103[2];     // Catch: Throwable -> L30
        int r105 = r103[3];     // Catch: Throwable -> L30
        int r106 = r103[7];     // Catch: Throwable -> L30
        if (r104 <= 0) goto L28;
        if (r105 <= 0) goto L28;
        monitor-exit(this);     // Catch: Throwable -> L30
        Bitmap r107 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L25
        int r108 = this.mVideoEditor.getDecodeImage(r107, r102, r101);
        if (r108 == 0) goto L18;
        VELogUtil.e(TAG, "getCurrDecodeImage failed " + r108);
        if (r107 != null) goto L15;
    L17:
        return null;
    L15:
        if (r107.isRecycled() == true) goto L17;
        r107.recycle();
        goto L17
    L18:
        VEBitmapWithInfo r109 = new VEBitmapWithInfo(r107);
        if (r106 != 16) goto L22;
        VEBitmapWithInfo.COLOR_TYPE r110 = VEBitmapWithInfo.COLOR_TYPE.BT2020_PQ;
        r109.setColorInfo(r110.ordinal(), r110.ordinal(), r110.ordinal());
    L24:
        return r109;
    L22:
        if (r106 != 18) goto L24;
        VEBitmapWithInfo.COLOR_TYPE r111 = VEBitmapWithInfo.COLOR_TYPE.BT2020_HLG;
        r109.setColorInfo(r111.ordinal(), r111.ordinal(), r111.ordinal());
    L25:
        e = move-exception;
        VELogUtil.e(TAG, "getCurrDecodeImage createBitmap failed " + e.getMessage());
        return null;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L30
        return null;
    L30:
        th = move-exception;
        throw th;
    }

    public Bitmap getCurrProcessedImage(int r100, int r101) {
        monitor-enter(this);
        VELogUtil.i(TAG, "getCurrProcessedImage... width:" + r100 + ",height:" + r101);     // Catch: Throwable -> L34
        Bitmap r102 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L30 Throwable -> L34
        int r103 = this.mVideoEditor.getProcessedImage(r102);     // Catch: Throwable -> L34
        VEState r104 = getState();     // Catch: Throwable -> L34
        VEState r105 = VEState.PAUSED;     // Catch: Throwable -> L34
        if (r104 != r105) goto L10;
    L16:
        if (r104 != r105) goto L19;
        refreshCurrentFrame();     // Catch: Throwable -> L34
    L19:
        if (r104 != VEState.STARTED) goto L21;
        pause();     // Catch: Throwable -> L34
        play();     // Catch: Throwable -> L34
    L21:
        monitor-exit(this);     // Catch: Throwable -> L34
        if (r103 == 0) goto L29;
        VELogUtil.e(TAG, "getDisplayImage failed " + r103);
        if (r102 != null) goto L26;
        return null;
    L26:
        if (r102.isRecycled() == true) goto L41;
        r102.recycle();
        return null;
    L41:
        return null;
    L29:
        return r102;
    L10:
        if (r104 == VEState.STARTED) goto L16;
        if (r104 == VEState.SEEKING) goto L16;
        VELogUtil.e(TAG, "getCurrProcessedImage createBitmap failed for invalid engine state:" + r104);     // Catch: Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L34
        return null;
    L30:
        e = move-exception;
        VELogUtil.e(TAG, "getCurrProcessedImage createBitmap failed " + e.getMessage());     // Catch: Throwable -> L34
        return null;
    L34:
        th = move-exception;
        throw th;
    }

    public int getInfoStickerFlip(int r100, boolean[] r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerFlip STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.r0();
    }

    public int getInfoStickerPinData(int r100, ByteBuffer[] r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerPinData STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.y0();
    }

    public int getInfoStickerPosition(int r100, float[] r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "getInfoStickerPosition STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.K();
    }

    public VESize getInitSize(int r100, int r110) {
        VESize r101 = new VESize(0, 0);
        VESize r102 = this.mInitSize;
        int r103 = r102.width;
        int r104 = r102.height;
        float r105 = r100;
        float r106 = r110;
        if ((r103 / r104) <= (r105 / r106)) goto L5;
        r101.width = r100;
        r101.height = (int) (r105 / (r102.width / r104));
    L6:
        VELogUtil.i(TAG, "getInitSize... surfaceWidth:" + r100 + ", surfaceHeight:" + r110 + ", width:" + r101.width + ", height:" + r101.height);
        return r101;
    L5:
        r101.height = r110;
        r101.width = (int) (r106 / (r102.height / r103));
        goto L6
    }

    public String getKeyFrameParam(int r100, int r101) {
        monitor-enter(this);
        String r102 = this.mKeyFrameMap.get(Integer.valueOf(r100));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public int getSrtInfoStickerInitPosition(int r100, float[] r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "getSrtInfoStickerInitPosition STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.f0();
    }

    public int init(VEEditorModel r110, VETimelineParams r111) {
        monitor-enter(this);
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L22
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L22
        this.mlLastTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L22
        this.mlInitTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L22
        VELogUtil.i(TAG, "init with model...");     // Catch: Throwable -> L22
        setDisplayState(1.0f, 1.0f, 0.0f, 0, 0);     // Catch: Throwable -> L22
        VEEditorResManager r100 = this.mResManager;     // Catch: Throwable -> L22
        if (r100 != null) goto L11;
        VELogUtil.e(TAG, "init mResManager is null");     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return -112;
    L11:
        this.mInitSuccess = true;     // Catch: Throwable -> L22
        r100.mReverseDone = r110.reverseDone;     // Catch: Throwable -> L22
        this.mVideoOutRes = r110.videoOutRes;     // Catch: Throwable -> L22
        r100.mAudioPaths = r110.audioPaths;     // Catch: Throwable -> L22
        r100.mVideoPaths = r110.videoPaths;     // Catch: Throwable -> L22
        r100.mTransitions = r110.transitions;     // Catch: Throwable -> L22
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L22
        this.mbSeparateAV = Boolean.valueOf(r110.separateAV);     // Catch: Throwable -> L22
        this.mResManager.mOriginalSoundTrackIndex = 0;     // Catch: Throwable -> L22
        this.mMasterTrackIndex = r110.masterTrackIndex;     // Catch: Throwable -> L22
        this.mVideoEditor.setHostTrackIndex(r110.hostTrackIndex);     // Catch: Throwable -> L22
        if (r111 == null) goto L19;
        int r112 = this.mVideoEditor.updateSenceTime(r111);     // Catch: Throwable -> L22
        if (r112 >= 0) goto L18;
        VELogUtil.e(TAG, "updateSceneTime failed, ret = " + r112);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r112;
    L18:
        this.mVideoEditor.setTimeRange(0, r112, 0);     // Catch: Throwable -> L22
    L19:
        k0 r113 = (k0) this.mWrapperFilter;     // Catch: Throwable -> L22
        r113.getClass();     // Catch: Throwable -> L22
        r113.f455862d = r110.colorFilterIndex;     // Catch: Throwable -> L22
        r113.f455863e = r110.effectHDRFilterIndex;     // Catch: Throwable -> L22
        r113.f455864f = r110.mLensHDRFilterIndex;     // Catch: Throwable -> L22
        r113.f455865g = r110.audioEffectFilterIndex;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return 0;
    L22:
        th = move-exception;
        throw th;
    }

    public int initWithAlgorithm(String[] r100, VIDEO_RATIO r101) throws VEException {
        return this.mWrapperBingo.p();
    }

    public int moveVideoClipWithAlgorithm(int r100, int r101) {
        return this.mWrapperBingo.l();
    }

    public void onSurfaceChanged(int r100, int r101) {
        VELogUtil.i(TAG, "onSurfaceChanged... " + r100 + ", " + r101);
        this.mSurfaceWidth = r100;
        this.mSurfaceHeight = r101;
        updateInitDisplaySize();
        if (r100 == 0) goto L8;
        if (r101 == 0) goto L9;
        this.mVideoEditor.setSurfaceSize(r100, r101);
        return;
    L9:
        return;
    }

    public int processDoubleClickEvent(float r100, float r101) {
        if (this.mSurfaceWidth != 0) goto L5;
        return -105;
    L5:
        if (this.mSurfaceHeight != 0) goto L8;
        return -105;
    L8:
        return this.mVideoEditor.processDoubleClickEvent(r100, r101);
    }

    public int processLongPressEvent(float r100, float r101) {
        if (this.mSurfaceWidth != 0) goto L5;
        return -105;
    L5:
        if (this.mSurfaceHeight != 0) goto L8;
        return -105;
    L8:
        return this.mVideoEditor.processLongPressEvent(r100, r101);
    }

    public int processRotationEvent(float r100, float r101) {
        return this.mVideoEditor.processRotationEvent(r100, r101);
    }

    public int processScaleEvent(float r100, float r101) {
        return this.mVideoEditor.processScaleEvent(r100, r101);
    }

    public int processTouchEvent(float r100, float r101) {
        VELogUtil.w(TAG, "processTouchEvent");
        int r102 = this.mVideoEditor.processTouchEvent(r100, r101);
        if (r102 == 0) goto L5;
        VELogUtil.e(TAG, "processTouchEvent failed, ret = " + r102);
    L5:
        return r102;
    }

    public int processTouchMoveEvent(float r100, float r101) {
        if (this.mSurfaceWidth != 0) goto L5;
        return -105;
    L5:
        if (this.mSurfaceHeight != 0) goto L8;
        return -105;
    L8:
        return this.mVideoEditor.processTouchMoveEvent(r100, r101);
    }

    public int restoreInfoStickerPinWithData(int r100, ByteBuffer r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "restoreInfoStickerPinWithData STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.n0();
    }

    public int seek(int r100, SEEK_MODE r101) {
        monitor-enter(this);
        VELogUtil.w(TAG, "seek... " + r100 + " flags " + r101);     // Catch: Throwable -> L12
        if ((r101.getValue() & SEEK_MODE.EDITOR_SEEK_FLAG_LastSeek.getValue()) == 0) goto L9;
        this.mSeekListener = null;     // Catch: Throwable -> L12
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L12
        this.mlLastSeekTimeMS = r102;     // Catch: Throwable -> L12
        if (this.mlFirstSeekTimeMS != 0) goto L9;
        this.mlFirstSeekTimeMS = r102;     // Catch: Throwable -> L12
    L9:
        int r103 = this.mVideoEditor.seek(r100, this.mSurfaceWidth, this.mSurfaceHeight, r101.getValue());     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public int seekIFrame(int r100, SEEK_MODE r101) {
        VELogUtil.w(TAG, "seekIFrame...");
        return this.mVideoEditor.seek(r100, this.mSurfaceWidth, this.mSurfaceHeight, r101.getValue() | 2);
    }

    public int seekWithResult(int r100, VEListener.VEGetImageListener r101) {
        monitor-enter(this);
        VELogUtil.w(TAG, "seekWithResult... " + r100);     // Catch: Throwable -> L9
        this.mGetSeekFrameListener = r101;     // Catch: Throwable -> L9
        this.mVideoEditor.setSeekFrameCallback(this.mGetSeekFrameCallback);     // Catch: Throwable -> L9
        int r102 = this.mVideoEditor.seekWithResult(r100, -1, -1);     // Catch: Throwable -> L9
        if (r102 == 0) goto L7;
        VELogUtil.e(TAG, "seek failed, result = " + r102);     // Catch: Throwable -> L9
        this.mGetSeekFrameListener = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public int setAIRotation(int r100, ROTATE_DEGREE r101) {
        return this.mWrapperBingo.n();
    }

    public int setAlgorithmPreConfig(int r100, int r101) {
        VELogUtil.w(TAG, "setAlgorithmPreConfig");
        int r102 = this.mVideoEditor.setAlgorithmPreConfig(r100, r101);
        if (r102 == 0) goto L5;
        VELogUtil.e(TAG, "setAlgorithmPreConfig failed, ret = " + r102);
    L5:
        return r102;
    }

    public int setAlgorithmSyncAndNum(boolean r100, int r101) {
        VELogUtil.w(TAG, "setAlgorithmSyncAndNum");
        int r102 = this.mVideoEditor.setAlgorithmSyncAndNum(r100, r101);
        if (r102 == 0) goto L5;
        VELogUtil.e(TAG, "setAlgorithmSyncAndNum failed, ret = " + r102);
    L5:
        return r102;
    }

    public int setAudioOffset(int r100, int r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "setAudioOffset, track=" + r100 + ", offset=" + r101);
        return r102.f455860b.setAudioOffset(r100, r101);
    }

    public int setCanvasMinDuration(int r100, boolean r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "setCanvasMinDuration: " + r100 + ", needPrepare: " + r101);     // Catch: Throwable -> L16
        if (r101 == false) goto L7;
        r102.f455941b.stop();     // Catch: Throwable -> L16
    L7:
        int r104 = r102.f455941b.setTrackMinMaxDuration(0, 0, r100, -1);     // Catch: Throwable -> L16
        TEInterface r105 = r102.f455941b;     // Catch: Throwable -> L16
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L16
        if (r101 == false) goto L14;
        int r106 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L16
        if (r106 == 0) goto L14;
        VELogUtil.e("VEEditor_VESequenceInvoker", "addAudioTrack Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        return r106;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
        return r104;
    L16:
        th = move-exception;
        throw th;
    }

    public int setColorFilter(String r100, float r101) {
        return ((k0) this.mWrapperFilter).h(r100, r101, false, false);
    }

    public int setColorFilterNew(String r100, float r110) {
        k0 r101 = (k0) this.mWrapperFilter;
        r101.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "setColorFilterNew normal...");
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
    L45:
        th = move-exception;
        throw th;
    L5:
        if (r101.f455862d >= 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setColorFilterNew... mColorFilterIndex error.");     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
        return -105;
    L9:
        if (r100 != null) goto L14;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setColorFilterNew... param error.");     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
        return -100;
    L14:
        if (r110 <= 1.0f) goto L17;
        r110 = 1.0f;
    L17:
        if (r110 >= 0.0f) goto L20;
        r110 = -1.0f;
    L20:
        if (r101.f455867i != null) goto L23;
        r101.f455867i = new com.ss.android.ttve.model.c();     // Catch: Throwable -> L45
    L23:
        if (r100.equals(r101.f455867i.f449907a) == true) goto L25;
    L32:
        com.ss.android.ttve.model.c r103 = r101.f455867i;     // Catch: Throwable -> L45
        r103.f449907a = r100;     // Catch: Throwable -> L45
        r103.f449908b = "";     // Catch: Throwable -> L45
        r103.f449909c = 1.0f;     // Catch: Throwable -> L45
        r103.f449910d = r110;     // Catch: Throwable -> L45
        r103.f449911e = r110;     // Catch: Throwable -> L45
        r103.f449912f = false;     // Catch: Throwable -> L45
        r101.f455860b.setFilterParam(r101.f455862d, "left filter", r100);     // Catch: Throwable -> L45
        r101.f455860b.setFilterParam(r101.f455862d, "left filter intensity", "" + r110);     // Catch: Throwable -> L45
        r101.f455860b.setFilterParam(r101.f455862d, "right filter", "");     // Catch: Throwable -> L45
        r101.f455860b.setFilterParam(r101.f455862d, "filter position", "1.0");     // Catch: Throwable -> L45
        r101.f455860b.setFilterParam(r101.f455862d, "filter use v3", String.valueOf(true));     // Catch: Throwable -> L45
        fic.a r104 = new fic.a();     // Catch: Throwable -> L45
        String r105 = "";
        if (TextUtils.isEmpty(r100) == true) goto L37;
        String[] r106 = r100.split(File.separator);     // Catch: Throwable -> L45
        if (r106.length <= 0) goto L37;
        r105 = r106[r106.length - 1];     // Catch: Throwable -> L45
    L37:
        r104.c("iesve_veeditor_set_filter_click_filter_id", r105);     // Catch: Throwable -> L45
        com.ss.android.ttve.monitor.g.b(r104);     // Catch: Throwable -> L45
        com.ss.android.ttve.monitor.i.g(1, "te_composition_filter_id", r100);     // Catch: Throwable -> L45
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L40 Throwable -> L45
        r107.put("filterPath", r100);     // Catch: JSONException -> L40 Throwable -> L45
        r107.put("intensity", String.valueOf(r110));     // Catch: JSONException -> L40 Throwable -> L45
        r107.put("tag", "setColorFilterNew");     // Catch: JSONException -> L40 Throwable -> L45
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_color_filter", r107, "behavior");     // Catch: JSONException -> L40 Throwable -> L45
    L42:
        monitor-exit(r102);     // Catch: Throwable -> L45
    L43:
        return 0;
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L45
        goto L42
    L25:
        if (r101.f455867i.f449908b.length() != 0) goto L32;
        com.ss.android.ttve.model.c r108 = r101.f455867i;     // Catch: Throwable -> L45
        if (r108.f449910d != r110) goto L32;
        if (r108.f449909c != 1.0f) goto L32;
        monitor-exit(r102);     // Catch: Throwable -> L45
        goto L43
    }

    public void setCompileListener(VEListener.VEEditorCompileListener r100, Looper r101) {
        this.mCompileListener = r100;
        if (r101 == null) goto L5;
        this.mMessageHandler = new t(this, r101);
        return;
    L5:
        this.mMessageHandler = null;
    }

    public int setComposerMode(int r100, int r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        VEEditor r103 = r102.f455859a;
        monitor-enter(r103);
        VELogUtil.w("VEEditor_VEFilterInvoker", "setComposerMode");     // Catch: Throwable -> L11
        int r104 = r102.f455860b.setComposerMode(r100, r101);     // Catch: Throwable -> L11
        if (r104 == 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setComposerMode failed, ret = " + r104);     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
    L10:
        return r104;
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int setDeviceRotation(float[] r100, double r101) {
        return this.mVideoEditor.setDeviceRotation(r100, r101);
    }

    public int setEffectHDRFilter(String r100, float r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "setEffectHDRFilter filterPath=" + r100 + ", intensity=" + r101);
        return r102.j(1, r100, r101);
    }

    public int setExtVideoTrackSeqIn(int r100, int r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "setExtVideoTrackSeqIn trackIndex:" + r100 + ", sequenceIn:" + r101);     // Catch: Throwable -> L19
        if (r100 <= 0) goto L15;
        if (r101 < 0) goto L15;
        r102.f455941b.stop();     // Catch: Throwable -> L19
        int r104 = r102.f455941b.setExtTrackSeqIn(0, r102.f455940a.getTrackIndexManager().b(2, r100), r101);     // Catch: Throwable -> L19
        TEInterface r105 = r102.f455941b;     // Catch: Throwable -> L19
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L19
        int r106 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L19
        if (r106 == 0) goto L13;
        VELogUtil.e("VEEditor_VESequenceInvoker", "setExtVideoTrackSeqIn Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
        return r106;
    L13:
        monitor-exit(r103);     // Catch: Throwable -> L19
        return r104;
    L15:
        VELogUtil.e("VEEditor_VESequenceInvoker", "setExtVideoTrackSeqIn invalid param");     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
        return -100;
    L19:
        th = move-exception;
        throw th;
    }

    public int setExternalVideoTrackLayer(int r100, int r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "setExternalVideoTrackLayer trackIndex:" + r100 + ", layer:" + r101);     // Catch: Throwable -> L15
        if (r100 <= 0) goto L11;
        if (r101 <= 0) goto L11;
        int r104 = r102.f455941b.setTrackLayer(0, r102.f455940a.getTrackIndexManager().b(2, r100), r101);     // Catch: Throwable -> L15
        monitor-exit(r103);     // Catch: Throwable -> L15
        return r104;
    L11:
        VELogUtil.e("VEEditor_VESequenceInvoker", "setExternalVideoTrackLayer invalid param");     // Catch: Throwable -> L15
        monitor-exit(r103);     // Catch: Throwable -> L15
        return -100;
    L15:
        th = move-exception;
        throw th;
    }

    public int setFilterInTimeOffset(int r100, int r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        VEEditor r103 = r102.f455859a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VEFilterInvoker", "setFilterOffsetIn... index: " + r100 + "offsetIn: " + r101);     // Catch: Throwable -> L11
        if (r100 >= 0) goto L8;
        monitor-exit(r103);     // Catch: Throwable -> L11
        return -100;
    L8:
        int r104 = r102.f455860b.setFilterParam(r100, "filter in time offset", String.valueOf(r101));     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    }

    public int setInOut(int r100, int r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        fic.a r104 = new fic.a();     // Catch: Throwable -> L7
        r104.b("iesve_veeditor_cut_duration", r101 - r100);     // Catch: Throwable -> L7
        com.ss.android.ttve.monitor.g.b(r104);     // Catch: Throwable -> L7
        VELogUtil.i("VEEditor_VESequenceInvoker", "setInOut... " + r100 + " " + r101);     // Catch: Throwable -> L7
        r102.f455941b.stop();     // Catch: Throwable -> L7
        r102.f455941b.setTimeRange(r100, r101, 0);     // Catch: Throwable -> L7
        int r105 = r102.f455941b.prepareEngine(0);     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public int setInfoStickerAlpha(int r100, float r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerAlpha STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.c0();
    }

    public int setInfoStickerLayer(int r100, int r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerLayer STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.d0();
    }

    public int setInfoStickerRotation(int r100, float r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerRotation STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.R();
    }

    public int setInfoStickerScale(int r100, float r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerScale STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.h();
    }

    public float setInfoStickerScaleSync(int r100, float r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerScaleSync STICKER IS NOT SUPPORT !!!");
        return -901.0f;
    L7:
        return r102.A0();
    }

    public int setInfoStickerTemplateParams(int r100, String r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerTemplateParams STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.m();
    }

    public int setInfoStickerVisible(int r100, boolean r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerVisible STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.t0();
    }

    public int setLensHDRFilter(String r100, int r101) {
        return ((k0) this.mWrapperFilter).k(r100, r101);
    }

    public int setMVoriginalAudio(boolean r100, float r101) {
        dic.d r102 = this.mWrapperMV;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r102.s();
    }

    public void setMaxWidthHeight(int r100, int r101) {
        VELogUtil.i(TAG, "setMaxWidthHeight... width:" + r100 + ", height:" + r101);
        this.mVideoEditor.setMaxWidthHeight(r100, r101);
    }

    public int setMusicSrtEffect(VEMusicSRTEffectParam r100, boolean r101) {
        return ((k0) this.mWrapperFilter).l(r100, r101);
    }

    public void setPreviewSurfaceBitmap(Bitmap r100, boolean r101) {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to setPreviewSurfaceBitmap, is destroying, just return");
        return;
    L6:
        VELogUtil.i(TAG, "setPreviewSurfaceBitmap...");
        this.mVideoEditor.setPreviewSurfaceBitmap(r100, r101);
    }

    public int setReverseMediaPaths(String[] r100, String[] r101) {
        VELogUtil.w(TAG, "setReverseMediaPaths");
        if (r100 != null) goto L5;
    L16:
        VELogUtil.e(TAG, "setReverseMediaPaths error, reverseVideoPaths = null");
        return -100;
    L5:
        if (r100.length <= 0) goto L16;
        if (r101 != null) goto L9;
    L10:
        VELogUtil.w(TAG, "setReverseMediaPaths with reverseAudioPaths is null");
    L11:
        VEEditorResManager r102 = this.mResManager;
        if (r102 == null) goto L18;
        r102.mReverseAudioPaths = r101;
        r102.mReverseVideoPath = r100;
        r102.mReverseDone = true;
        return 0;
    L18:
        return 0;
    L9:
        if (r101.length > 0) goto L11;
        goto L10
    }

    public int setSrtColor(int r100, int r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setSrtColor STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.k0();
    }

    public int setSrtFont(int r100, String r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setSrtFont STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.y();
    }

    public int setSrtManipulateState(int r100, boolean r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setSrtManipulateState STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.d();
    }

    public int setStickerAnimator(int r100, VEStickerAnimator r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setStickerAnimator STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.A();
    }

    public int setStickerPinArea(int r100, VEStickerPinAreaParam r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "setStickerPinArea STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.G();
    }

    public int setTransitionAt(long r100, String r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        VELogUtil.i("VEEditor_VEFilterInvoker", "setTransitionAt transTimePoint" + r100 + ", transName: " + r101);
        r102.f455859a.getBusinessManager().getClass();
        int r103 = r102.f455860b.setTransitionAt(0, r100, r101);
        if (r103 == 0) goto L8;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setTransitionAt trackIndex0, transTimePoint: " + r100 + ", transName: " + r101 + " failed, result = " + r103);
        return r103;
    L8:
        r102.f455860b.stop();
        return r102.f455860b.prepareEngine(0);
    }

    public void setWidthHeight(int r100, int r101) {
        VELogUtil.i(TAG, "setWidthHeight... width:" + r100 + ", height:" + r101);
        this.mVideoEditor.setWidthHeight(r100, r101);
    }

    public int startStickerAnimationPreview(int r100, int r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "startStickerAnimationPreview STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.O();
    }

    public boolean suspendGestureRecognizer(VEGestureEvent r100, boolean r101) {
        return this.mVideoEditor.suspendGestureRecognizer(r100, r101);
    }

    public int switchResourceLoadMode(boolean r100, int r101) {
        return this.mVideoEditor.switchResourceLoadMode(r100, r101);
    }

    public int updateAlgorithmRuntimeParam(VEAlgorithmRuntimeParamKey r100, float r101) {
        VELogUtil.w(TAG, "updateAlgorithmRuntimeParam");
        int r102 = this.mVideoEditor.updateAlgorithmRuntimeParam(r100.getValue(), r101);
        if (r102 == 0) goto L5;
        VELogUtil.e(TAG, "updateAlgorithmRuntimeParam failed, ret = " + r102);
    L5:
        return r102;
    }

    public void updateLoudnessFilter(int r100, float r101) {
        ((k0) this.mWrapperFilter).f455860b.setFilterParam(r100, "audio_loudness_volume", String.valueOf(r101));
    }

    public int updateSegmentVolume(int r100, float r101) {
        w0 r102 = (w0) this.mWrapperSequence;
        r102.getClass();
        if (r100 >= 0) goto L6;
        return -100;
    L6:
        if (r101 >= 0.0f) goto L9;
        r101 = 0.0f;
    L9:
        if (r101 <= 1.0f) goto L12;
        r101 = 1.0f;
    L12:
        return r102.f455941b.setFilterParam(r100, "audio volume", "" + r101);
    }

    public int updateTextSticker(int r100, String r101) {
        dic.f r102 = this.mWrapperSticker;
        if (r102 != null) goto L7;
        VELogUtil.e(TAG, "updateTextSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r102.T();
    }

    public int updateTrackFilterParam(int r100, VEBaseFilterParam r101) {
        k0 r102 = (k0) this.mWrapperFilter;
        VEEditor r103 = r102.f455859a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VEFilterInvoker", "updateTrackFilterParam, filterIndex: " + r100 + ", param = " + r101.toString());     // Catch: Throwable -> L18
        int r104 = -1;
        if (r101.filterType != 1) goto L12;
        TEAudioEffectInterface r105 = r102.f455861c;     // Catch: Throwable -> L18
        if (r105 != null) goto L11;
        VELogUtil.e("VEEditor_VEFilterInvoker", "DON'T SUPPORT AUDIO EFFECT!");     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
    L17:
        return r104;
    L11:
        int r106 = r105.updateAudioFilterParam(-1, r100, r101);     // Catch: Throwable -> L18
    L13:
        if (r106 < 0) goto L16;
        r104 = 0;
    L16:
        monitor-exit(r103);     // Catch: Throwable -> L18
        goto L17
    L12:
        r106 = r102.f455860b.updateFilterParam(-1, r100, r101);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public VEEditor(String r100, SurfaceView r101) {
        this(r100, r101, true, null);
    }

    public int changeTransitionAt(int r100, String r110) {
        k0 r101 = (k0) this.mWrapperFilter;
        VEEditor r102 = r101.f455859a;
        monitor-enter(r102);
        if (r110 != null) goto L31;
        r110 = "";
    L31:
        VELogUtil.i("VEEditor_VEFilterInvoker", "changeTransition " + r100 + ", transName = " + r110);     // Catch: Throwable -> L28
        if (r100 >= 0) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L28
        return -100;
    L10:
        VETransitionFilterParam r103 = new VETransitionFilterParam();     // Catch: Throwable -> L28
        r103.transName = r110;     // Catch: Throwable -> L28
        r103.tranDuration = 500;     // Catch: Throwable -> L28
        r103.tranType = VETransitionFilterParam.TransitionType.TransitionType_DEFAULT.ordinal();     // Catch: Throwable -> L28
        r101.f455860b.stop();     // Catch: Throwable -> L28
        int r104 = r101.f455860b.changeTransitionAt(r100, r103);     // Catch: Throwable -> L28
        if (com.ss.android.ttve.monitor.i.f449943c == false) goto L32;
    L16:
        if (r104 == 0) goto L20;
        VELogUtil.e("VEEditor_VEFilterInvoker", "changeTransition " + r100 + " ,VETransitionFilterParam=" + r103.toString() + " failed, result = " + r104);     // Catch: Throwable -> L28
        monitor-exit(r102);     // Catch: Throwable -> L28
        return r104;
    L20:
        int r105 = r101.f455859a.prepareWithCallback(0);     // Catch: Throwable -> L28
        if (r105 == 0) goto L25;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Prepare Engine failed, ret = " + r105);     // Catch: Throwable -> L28
        monitor-exit(r102);     // Catch: Throwable -> L28
        return r105;
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L28
        return 0;
    L32:
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L14 Throwable -> L28
        r106.put("transIndex", r100);     // Catch: JSONException -> L14 Throwable -> L28
        r106.put("transName", r110);     // Catch: JSONException -> L14 Throwable -> L28
        r106.put("resultCode", r104);     // Catch: JSONException -> L14 Throwable -> L28
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_transition_change_by_name", r106, "behavior");     // Catch: JSONException -> L14 Throwable -> L28
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public int init(VERecordData r100, boolean r101) {
        return init(r100, r101, true);
    }

    public boolean processTouchEvent(VETouchPointer r100, int r101) {
        if (r100.getEvent() == null) goto L8;
        if (r101 >= 0) goto L7;
        return false;
    L7:
        return this.mVideoEditor.processTouchEvent(r100, r101);
    L8:
        return false;
    }

    public VEEditor(String r100, TextureView r101) throws VEException {
        this(r100, r101, null);
    }

    public VEEditor(String r100, SurfaceView r101, long r110) {
        this.mInitSize = new VESize(-1, -1);
        this.mCompileType = "mp4";
        this.mMessageHandler = new t(this, Looper.getMainLooper());
        this.mSeekListener = null;
        this.mCompileListener = null;
        this.mFirstFrameListener = null;
        this.mVideoOutputListener = null;
        this.mAsyncReleaseEngineListener = null;
        this.mUserCommonInfoCallback = null;
        this.mUserCommonErrorCallback = null;
        this.mTrackIndexManager = new TETrackIndexManager();
        this.mBusinessManager = new ogc.a();
        this.mAutoPrepare = true;
        this.mUsageType = "unknown";
        this.mRecordData = null;
        this.mConcatVideoPath = "/concatShootVideo";
        this.mKeyFrameMap = new HashMap();
        this.mIsDestroying = new AtomicBoolean(false);
        this.mConcatVideoErrorForInvalidCodecs = -1;
        this.mTeCommonInfoCallback = new h(this);
        this.mTeCommonErrorCallback = new i(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInitDisplayWidth = 0;
        this.mInitDisplayHeight = 0;
        this.mbSeparateAV = Boolean.FALSE;
        this.mMasterTrackIndex = 0;
        this.miFrameCount = 0;
        this.mlCurTimeMS = 0;
        this.mlLastTimeMS = 0;
        this.mlInitTimeMS = 0;
        this.mlFirstSeekTimeMS = 0;
        this.mlFirstPlayTimeMS = 0;
        this.mlLastSeekTimeMS = 0;
        this.mlFirstFrameWithoutSurfaceTimeMS = 0;
        this.mFirstFrameDrawed = false;
        this.miCacheHitCount = 0;
        this.miCacheMissCount = 0;
        this.mInPoint = 0;
        this.mOutPoint = -1;
        this.mVideoGravity = VIDEO_GRAVITY.ALIGN_PARENT_BOTTOM;
        this.mVideoScaletype = VIDEO_SCALETYPE.CENTER;
        this.mInitSuccess = false;
        this.mReverseDone = false;
        this.mCancelReverse = false;
        this.mCanvasWrapFilterIndex = -1;
        this.mOutputFile = null;
        this.mlCompileStartTime = 0;
        this.mBReversePlay = false;
        this.mBCompileHighQualityGif = false;
        this.mp4ToGIFConverter = null;
        this.mEncoderListener = null;
        this.mGetImageListener = null;
        this.mGetSeekFrameListener = null;
        this.mTEMonitorFilterMgr = new com.ss.android.ttve.monitor.j();
        this.mReDrawSurface = false;
        this.mFirstTimeSurfaceCreate = true;
        this.mReDrawSurfaceOnce = false;
        this.mCurrentBmp = null;
        this.rotate = 0.0f;
        this.scaleW = 1.0f;
        this.scaleH = 1.0f;
        this.mPageMode = -1;
        this.mEditorMode = -1;
        this.mBackGroundColor = -16777216;
        this.mVideoBackGroundColor = -16777216;
        this.model_sequence_time = 0;
        this.editor_time = 0;
        this.mPlayFps = 0.0f;
        this.mTextureListener = new j(this);
        this.mSurfaceCallback = new k(this);
        this.mOpenGLCallback = new l(this);
        this.mEncoderDataCallback = new m(this);
        this.mGetImageCallback = new n(this);
        this.mGetSeekFrameCallback = new o(this);
        this.mGetCompileFirstFrameCallback = new p(this);
        this.mMattingCallback = new a(this);
        this.mkeyFrameCallback = new b(this);
        y0.a("VEEditor-surfaceView-handler");
        if (TextUtils.isEmpty(r100) == true) goto L7;
        VELogUtil.i(TAG, "VEEditor surfaceView with handler = " + r110);
        this.mVideoEditor = TEInterface.createEngine(r110);
        this.mResManager = new VEEditorResManager(r100);
        this.mSurfaceView = r101;
        r101.getHolder().addCallback(this.mSurfaceCallback);
        this.mVideoEditor.setOpenGLListeners(this.mOpenGLCallback);
        this.mVideoEditor.setInfoListener(this.mTeCommonInfoCallback);
        this.mVideoEditor.setErrorListener(this.mTeCommonErrorCallback);
        enableEffectAmazing(false);
        createWrapperInvokers();
        y0.b();
        return;
    L7:
        throw new VEException(-100, "workspace is: " + r100);
    }

    private boolean _concatShootVideo(String r100, String[] r101, long[] r110) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitSuccess == false) goto L27;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L28
        return false;
    L10:
        VEConfigCenter.ValuePkt r102 = VEConfigCenter.getInstance().getValue("video_duration_opt");     // Catch: Throwable -> L28
        if (r102 != null) goto L13;
    L17:
        boolean r103 = false;
    L18:
        int r104 = this.mVideoEditor.concatShootVideo(r100, r101, r110, r103);     // Catch: Throwable -> L28
        if (r104 == 0) goto L23;
        VELogUtil.e(TAG, "concatShootVideo failed = ret: " + r104);     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return false;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L28
        return true;
    L13:
        if (r102.getValue() == null) goto L17;
        if ((r102.getValue() instanceof Boolean) == false) goto L17;
        r103 = ((Boolean) r102.getValue()).booleanValue();     // Catch: Throwable -> L28
        goto L18
    L27:
        throw new VEException(-105, "Make sure the initialization is successful before coding!!!");     // Catch: Throwable -> L28
    }

    public static LoudnessDetectResult[] detectAudioLoudness(String[] r100, int[] r101, int[] r102) {
        int r103 = 0;
        if (r100 != null) goto L5;
        int r104 = 0;
    L6:
        if (r101 != null) goto L8;
        int r105 = 0;
    L9:
        if (r102 == null) goto L12;
        r103 = r102.length;
    L12:
        if (r104 <= 0) goto L19;
        if (r105 != r103) goto L19;
        if (r105 <= 0) goto L18;
        if (r105 != r104) goto L19;
    L18:
        return TEInterface.detectAudioLoudness(r100, r101, r102);
    L19:
        VELogUtil.e(TAG, "detectAudioLoudness invalid param, audioPathLength:" + r104 + " trimInLength: " + r105 + ", trimOutLength: " + r103);
        return null;
    L8:
        r105 = r101.length;
        goto L9
    L5:
        r104 = r100.length;
        goto L6
    }

    public static VEEditor genReverseVideo2(VEEditorResManager r100, VERecordData r101, VEListener.VEEditorGenReverseListener r102) {
        return genReverseVideo2(r100, r101, -1, -1, r102);
    }

    public static int setDropFrameParam(boolean r100, long r101, long r102) {
        return TEInterface.setDropFrameParam(r100, r101, r102);
    }

    public static int setImageBufferLimit(int r100, int r101, int r102) {
        VELogUtil.i(TAG, "setImageBufferLimit: " + r100 + ", " + r101 + ", " + r102);
        return TEInterface.setImageBufferLimit(r100, r101, r102);
    }

    public int[] addCherEffect(int r110, int r111, VECherEffectParam r112) {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        int r101 = r112.getMatrix().length;
        int[] r102 = new int[r101];
        int[] r103 = new int[r101];
        int[] r104 = new int[r101];
        String[] r105 = new String[r101];
        int[] r106 = new int[r101];
        int[] r107 = new int[r101];
        int r113 = 0;
        int r108 = 0;
    L3:
        if (r108 >= r101) goto L5;
        r102[r108] = r110;
        r103[r108] = r111;
        r105[r108] = "audio chereffect";
        r104[r108] = 1;
        int r114 = r108 * 2;
        r106[r108] = (int) r112.getDuration()[r114];
        r107[r108] = (int) r112.getDuration()[r114 + 1];
        r108 = r108 + 1;
        goto L3
    L5:
        int[] r109 = r100.f455860b.addFilters(r102, r105, r106, r107, r103, r104);
    L6:
        if (r113 >= r101) goto L8;
        r100.f455860b.setFilterParam(r109[r113], "cher_matrix", r112.getMatrix()[r113]);
        r113 = r113 + 1;
        goto L6
    L8:
        return r109;
    }

    public int addClipAuxiliaryParam(int r100, int r101, VEClipAuxiliaryParam[] r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        r103.getClass();
        int r104 = -100;
        if (r100 == 1) goto L5;
        if (r100 == 0) goto L5;
    L6:
        VELogUtil.e("VEEditor_VESequenceInvoker", "addClipAuxiliaryParam, invalid trackType: " + r100 + ", trackIndex: " + r101);
    L26:
        return r104;
    L5:
        if (r101 < 0) goto L6;
        if (r102 != null) goto L9;
    L25:
        VELogUtil.e("VEEditor_VESequenceInvoker", "addClipAuxiliaryParam, auxiliaryParamArray is empty");
        goto L26
    L9:
        if (r102.length <= 0) goto L25;
        VELogUtil.i("VEEditor_VESequenceInvoker", "addClipAuxiliaryParam, trackType: " + r100 + ", trackIndex: " + r101 + ", auxiliaryParamArray size: " + r102.length);
        VEEditor r105 = r103.f455940a;
        monitor-enter(r105);
        if (r100 != 1) goto L17;
        int r106 = r103.f455940a.getTrackIndexManager().b(1, r101);     // Catch: Throwable -> L15
    L20:
        VELogUtil.i("VEEditor_VESequenceInvoker", "addClipAuxiliaryParam, trackIndex: " + r101 + ", nativeTrackType: " + r106);     // Catch: Throwable -> L15
        r104 = r103.f455941b.addClipAuxiliaryParam(r100, r106, r102);     // Catch: Throwable -> L15
        monitor-exit(r105);     // Catch: Throwable -> L15
        goto L26
    L17:
        if (r100 != 0) goto L19;
        r106 = r103.f455940a.getTrackIndexManager().b(2, r101);     // Catch: Throwable -> L15
        goto L20
    L19:
        r106 = r101;
    L15:
        th = move-exception;
        throw th;
    }

    public int[] addFilterEffects(int[] r100, int[] r110, String[] r111) {
        k0 r101 = (k0) this.mWrapperFilter;
        r101.getClass();
        int r102 = r111.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L13;
        int r105 = r100[r104];
        if (r105 < 0) goto L27;
        if (r105 > r101.f455860b.getDuration()) goto L27;
        if (TextUtils.isEmpty(r111[r104]) == true) goto L27;
        r104 = r104 + 1;
    L27:
        return new int[]{-100};
    L13:
        boolean[] r106 = new boolean[r102];
        int[] r107 = new int[r102];
        int[] r108 = new int[r102];
        int r109 = 0;
    L14:
        if (r109 >= r102) goto L16;
        r106[r109] = false;
        r107[r109] = 0;
        r108[r109] = 0;
        r109 = r109 + 1;
        goto L14
    L16:
        int r112 = r111.length;
        String[] r113 = new String[r112];
    L17:
        if (r103 >= r112) goto L20;
        r113[r103] = "";
        r103 = r103 + 1;
        goto L17
    L20:
        return r101.a(r100, r110, r111, r107, r108, r113);
    }

    public int[] addFilterEffectsWithTagSync(int[] r110, int[] r111, VEEffectFilterParam[] r112) {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        if (r112 == null) goto L19;
        if (r110 == null) goto L19;
        if (r111 == null) goto L19;
        if (r112.length != r110.length) goto L19;
        if (r110.length != r111.length) goto L19;
        int r101 = r110.length;
        int[] r102 = new int[r101];
        int[] r103 = new int[r101];
        int[] r104 = new int[r101];
        String[] r105 = new String[r101];
        int r106 = 0;
        int r107 = 0;
    L12:
        if (r107 >= r101) goto L14;
        r100.f455859a.getBusinessManager().getClass();
        r102[r107] = 0;
        r103[r107] = 0;
        r105[r107] = "filter effect";
        r104[r107] = 8;
        r107 = r107 + 1;
        goto L12
    L14:
        int[] r108 = r100.f455860b.addFilters(r102, r105, r110, r111, r103, r104);
        if (r101 == r108.length) goto L17;
        int[] r109 = new int[r101];
        Arrays.fill(r109, -1);
        return r109;
    L17:
        if (r106 >= r101) goto L24;
        r100.f455860b.setFilterParam(r108[r106], "effectStickAndComposer", r112[r106]);
        com.ss.android.ttve.monitor.j.a r113 = new com.ss.android.ttve.monitor.j.a();
        r113.f449946a = r112[r106].effectPath;
        int r114 = r110[r106];
        r113.f449947b = r114;
        r113.f449948c = r111[r106] - r114;
        r100.f455859a.getTEMonitorFilterMgr().a(r108[r106], r113);
        r106 = r106 + 1;
        goto L17
    L24:
        return r108;
    L19:
        VELogUtil.e("VEEditor_VEFilterInvoker", "addFilterEffectsWithTagSync param is invalid");
        return null;
    }

    public int addInfoStickerWithInitInfo(String r100, String[] r101, String r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "addInfoStickerWithInitInfo STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.Z();
    }

    public int addTimeEffect(int r100, int r101, VEBaseFilterParam r102) {
        return ((k0) this.mWrapperFilter).b(r100, r101, r102);
    }

    public int addTrackFilter(int r100, int r101, VEBaseFilterParam r110) {
        k0 r102 = (k0) this.mWrapperFilter;
        return r102.c(r100, r101, r110, 0, r102.f455859a.getOutPoint());
    }

    public int appendComposerNodesWithTag(String[] r100, int r101, String[] r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VEEffectParams r105 = new VEEffectParams();     // Catch: Throwable -> L7
        r105.TYPE = VEEffectParams.EFFECT_TYPE_APPEND_COMPOSER_WITH_TAG;     // Catch: Throwable -> L7
        r105.intValueOne = r101;     // Catch: Throwable -> L7
        r105.stringArrayOne = new ArrayList(Arrays.asList(r100));     // Catch: Throwable -> L7
        r105.stringArrayTwo = new ArrayList(Arrays.asList(r102));     // Catch: Throwable -> L7
        VELogUtil.w("VEEditor_VEFilterInvoker", "appendComposerNodes...");     // Catch: Throwable -> L7
        int r106 = r103.f455860b.setEffectParams(r105);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r106;
    L7:
        th = move-exception;
        throw th;
    }

    public int[] checkComposerNodeExclusion(String r100, String r101, String r102) {
        if (r100 == null) goto L8;
        if (r102 == null) goto L8;
        k0 r103 = (k0) this.mWrapperFilter;
        r103.getClass();
        return r103.f455860b.checkComposerNodeExclusion(r100, r101, r102);
    L8:
        return new int[]{-1, 0};
    }

    public boolean compile(String r100, String r101, VEVideoEncodeSettings r102) throws VEException {
        this.mCompileListener = null;
        boolean r103 = _compile(r100, r101, r102, VEAudioEncodeSettings.DEFAULT);
        if (r103 == true) goto L5;
        VELogUtil.e(TAG, "_compile failed");
    L5:
        return r103;
    }

    public boolean compileOnlyAudio(String r100, VEAudioEncodeSettings r101, VEListener.VEEditorCompileListener r102) throws VEException {
        this.mCompileListener = r102;
        return _compileOnlyAudio(r100, r101);
    }

    public boolean compileSingleImage(String r100, VEVideoEncodeSettings r101, VEListener.VEEditorCompileListener r102) throws VEException {
        this.mCompileListener = r102;
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitSuccess == false) goto L31;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L9;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L32
        return false;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L27;
        int r103 = r100.lastIndexOf(".");     // Catch: Throwable -> L32
        if (r103 == (-1)) goto L26;
        this.mVideoEditor.stop();     // Catch: Throwable -> L32
        if (r101.getCompileType() != VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_WEBP) goto L17;
        this.mVideoEditor.setCompileType(256);     // Catch: Throwable -> L32
    L22:
        this.mCompileType = r100.substring(r103 + 1);     // Catch: Throwable -> L32
        this.mVideoEditor.setResizer(r101.getResizeMode(), r101.getResizeX(), r101.getResizeY());     // Catch: Throwable -> L32
        this.mVideoEditor.setEngineCompilePath(r100, null);     // Catch: Throwable -> L32
        this.mVideoEditor.setWidthHeight(r101.getVideoRes().width, r101.getVideoRes().height);     // Catch: Throwable -> L32
        this.mVideoEditor.setImageCompileQuality(r101.image_compile_quality);     // Catch: Throwable -> L32
        this.mVideoEditor.prepareEngine(1);     // Catch: Throwable -> L32
        this.mVideoEditor.start();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return true;
    L17:
        if (r101.getCompileType() != VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_JPEG) goto L20;
        this.mVideoEditor.setCompileType(64);     // Catch: Throwable -> L32
        goto L22
    L20:
        if (r101.getCompileType() != VEVideoEncodeSettings.COMPILE_TYPE.COMPILE_TYPE_PNG) goto L22;
        this.mVideoEditor.setCompileType(128);     // Catch: Throwable -> L32
        goto L22
    L26:
        throw new VEException(-105, "Compile single image outPath should contains *.png/*.jpg suffix!!!");     // Catch: Throwable -> L32
    L31:
        throw new VEException(-105, "Make sure the initialization is successful before coding!!!");     // Catch: Throwable -> L32
    }

    public int faceCoverClear(int r100, String r101, boolean r102) {
        return this.mVideoEditor.faceCoverClear(r100, r101, r102);
    }

    public VESize[] genVideoTrackSizeFromPath(String[] r100, String[] r101, List<VESize> r110) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L13;
        String r105 = r101[r104];
        int r106 = 0;
    L6:
        if (r106 >= r100.length) goto L11;
        if (r105.equals(r100[r106]) == true) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        r102.add((VESize) ListProtector.get(r110, r106));
        VELogUtil.e(TAG, r100[r106] + "... (" + ((VESize) ListProtector.get(r110, r106)).width + ", " + ((VESize) ListProtector.get(r110, r106)).height + ")");
    L11:
        r104 = r104 + 1;
        goto L3
    L13:
        return (VESize[]) r102.toArray(new VESize[0]);
    }

    public String getClipFileInfoString(int r100, int r101, int r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        VELogUtil.i("VEEditor_VESequenceInvoker", "getClipFileInfoString... " + r100 + ", " + r101 + ", " + r102);     // Catch: Throwable -> L7
        String r105 = r103.f455941b.getClipInfoString(r100, r101, r102);     // Catch: Throwable -> L7
        StringBuilder r106 = new StringBuilder("getClipFileInfoString result ");     // Catch: Throwable -> L7
        r106.append(r105);     // Catch: Throwable -> L7
        VELogUtil.i("VEEditor_VESequenceInvoker", r106.toString());     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public Bitmap getCurrDisplayImage(int r100, VEQualityScoreType r101, String r102) {
        VELogUtil.i(TAG, "getCurrDisplayImage... width:" + r100);
        monitor-enter(this);
        VESize r103 = getVideoResolution();     // Catch: Throwable -> L37
        int r104 = r103.width;     // Catch: Throwable -> L37
        if (r104 == 0) goto L35;
        int r105 = r103.height;     // Catch: Throwable -> L37
        if (r105 == 0) goto L35;
        if (r100 <= 0) goto L13;
        if (r100 >= r104) goto L13;
        r105 = (r105 * r100) / r104;     // Catch: Throwable -> L37
    L15:
        if ((r100 % 2) != 1) goto L18;
        r100 = r100 + 1;     // Catch: Throwable -> L37
    L18:
        if ((r105 % 2) != 1) goto L40;
        r105 = r105 + 1;
    L40:
        Bitmap r106 = Bitmap.createBitmap(r100, r105, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L31 Throwable -> L37
        int r107 = this.mVideoEditor.getDisplayImage(r106, r101, r102);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        if (r107 == 0) goto L30;
        VELogUtil.e(TAG, "getDisplayImage failed " + r107);
        if (r106 != null) goto L27;
        return null;
    L27:
        if (r106.isRecycled() == true) goto L44;
        r106.recycle();
        return null;
    L44:
        return null;
    L30:
        return r106;
    L31:
        e = move-exception;
        VELogUtil.e(TAG, "getDisplayImage createBitmap failed " + e.getMessage());     // Catch: Throwable -> L37
        return null;
    L13:
        r100 = r104;
    L35:
        monitor-exit(this);     // Catch: Throwable -> L37
        return null;
    L37:
        th = move-exception;
        throw th;
    }

    public Bitmap getSingleTrackProcessedImage(int r100, int r101, int r102) {
        monitor-enter(this);
        VELogUtil.i(TAG, "getSingleTrackProcessedImage... width:" + r100 + ",height:" + r101 + ",trackIndex:" + r102);     // Catch: Throwable -> L31
        if (r102 >= 0) goto L34;
        monitor-exit(this);     // Catch: Throwable -> L31
        return null;
    L34:
        Bitmap r103 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L27 Throwable -> L31
        int r104 = this.mVideoEditor.getSingleTrackProcessedImage(this.mTrackIndexManager.b(2, r102), r103);     // Catch: Throwable -> L31
        VEState r105 = getState();     // Catch: Throwable -> L31
        if (r105 != VEState.PAUSED) goto L12;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L31
        if (r104 == 0) goto L26;
        VELogUtil.e(TAG, "getSingleTrackProcessedImage failed " + r104);
        if (r103 != null) goto L23;
        return null;
    L23:
        if (r103.isRecycled() == true) goto L38;
        r103.recycle();
        return null;
    L38:
        return null;
    L26:
        return r103;
    L12:
        if (r105 == VEState.STARTED) goto L18;
        if (r105 == VEState.SEEKING) goto L18;
        VELogUtil.e(TAG, "getSingleTrackProcessedImage createBitmap failed for invalid engine state:" + r105);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return null;
    L27:
        e = move-exception;
        VELogUtil.e(TAG, "getSingleTrackProcessedImage createBitmap failed " + e.getMessage());     // Catch: Throwable -> L31
        return null;
    L31:
        th = move-exception;
        throw th;
    }

    public float getVolume(int r100, int r101, int r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        r103.getClass();
        VELogUtil.w("VEEditor_VESequenceInvoker", "getVolume...");
        if (r102 >= 0) goto L5;
    L8:
        return -100.0f;
    L5:
        if (r102 > r103.f455941b.getDuration()) goto L8;
        int r104 = r103.f455940a.getTrackIndexManager().b(1, r100);
        return r103.f455941b.getTrackVolume(r101, r104, r102);
    }

    public int init(VERecordData r210, boolean r211, boolean r212) {
        long r110 = System.currentTimeMillis();
        this.mRecordData = r210;
        if (r211 == true) goto L5;
        int r100 = r210.getSegmentData().size();
        String[] r101 = new String[r100];
        String[] r102 = new String[r100];
        int[] r103 = new int[r100];
        int[] r104 = new int[r100];
        int[] r111 = new int[r100];
        int[] r112 = new int[r100];
        float[] r105 = new float[r100];
        float[] r106 = new float[r100];
        ROTATE_DEGREE[] r107 = new ROTATE_DEGREE[r100];
        Iterator<VERecordData.VERecordSegmentData> r113 = r210.getSegmentData().iterator();
        int r108 = 0;
    L16:
        if (r113.hasNext() == false) goto L32;
        VERecordData.VERecordSegmentData r109 = r113.next();
        if (r109.mEnable == false) goto L31;
        r101[r108] = r109.mVideo;
        r102[r108] = r109.mAudio;
        r103[r108] = (int) (r109.getCutTrimIn() / 1000);
        r104[r108] = (int) (r109.getCutTrimOut() / 1000);
        float r114 = r109.mSpeed;
        if (r114 != 0.0f) goto L22;
        r114 = 1.0f;
    L22:
        r105[r108] = r114;
        float r115 = r109.mVideoSpeed;
        if (r115 != 0.0f) goto L25;
        r115 = 1.0f;
    L25:
        r106[r108] = r115;
        r107[r108] = r109.mRotate;
        if (r109.mWithNoSpeedBoth == false) goto L28;
        r111[r108] = (int) (r103[r108] * 1.0f);
        r112[r108] = (int) (r104[r108] * 1.0f);
    L29:
        r108 = r108 + 1;
        goto L31
    L28:
        float r116 = r103[r108];
        float r117 = r105[r108];
        r111[r108] = (int) (r116 * r117);
        r112[r108] = (int) (r104[r108] * r117);
    L31:
        r110 = r110;
        goto L16
    L32:
        long r213 = r110;
        if (r108 != 0) goto L36;
        VELogUtil.e(TAG, "There are no valid clips!");
        return -100;
    L36:
        String[] r118 = (String[]) Arrays.copyOf(r101, r108);
        String[] r119 = (String[]) Arrays.copyOf(r102, r108);
        int[] r120 = Arrays.copyOf(r103, r108);
        int[] r121 = Arrays.copyOf(r104, r108);
        int[] r122 = Arrays.copyOf(r111, r108);
        int[] r123 = Arrays.copyOf(r112, r108);
        float[] r124 = Arrays.copyOf(r105, r108);
        float[] r125 = Arrays.copyOf(r106, r108);
        ROTATE_DEGREE[] r126 = (ROTATE_DEGREE[]) Arrays.copyOf(r107, r108);
        ((k0) this.mWrapperFilter).f455867i = null;
        this.mVideoEditor.clearFilter();
        TETrackIndexManager r127 = this.mTrackIndexManager;
        r127.f449832a = -1;
        r127.f449833b = -1;
        ((ArrayList) r127.f449834c).clear();
        ((ArrayList) r127.f449835d).clear();
        if (r210.isUseMusic() == false) goto L39;
        String[] r128 = null;
        r122 = null;
        r123 = null;
        float[] r129 = null;
    L40:
        int r130 = init2(r118, r120, r121, null, r128, r122, r123, r125, r129, r126, VIDEO_RATIO.VIDEO_OUT_RATIO_ORIGINAL, r212);
        this.model_sequence_time += System.currentTimeMillis() - r213;
        VELogUtil.i(TAG, "init with VERecordData: " + (System.currentTimeMillis() - r213));
        return r130;
    L39:
        r128 = r119;
        r129 = r124;
        goto L40
    L5:
        if (r210.concatVideo.isEmpty() == false) goto L8;
        VELogUtil.e(TAG, "Merged video file path unconfigured!");
        return -100;
    L8:
        TETrackIndexManager r131 = this.mTrackIndexManager;
        r131.f449832a = -1;
        r131.f449833b = -1;
        ((ArrayList) r131.f449834c).clear();
        ((ArrayList) r131.f449835d).clear();
        ((k0) this.mWrapperFilter).f455867i = null;
        this.mVideoEditor.clearFilter();
        String[] r132 = {r210.concatVideo};
        if (r210.isUseMusic() == false) goto L11;
        String[] r133 = null;
    L13:
        return init(r132, null, r133, VIDEO_RATIO.VIDEO_OUT_RATIO_ORIGINAL);
    L11:
        r133 = new String[]{r210.concatAudio};
        goto L13
    }

    public int initMV(String r100, String[] r101, String[] r102) throws VEException {
        dic.d r103 = this.mWrapperMV;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r103.d();
    }

    public int moveClip(int r100, int r101, int r102) {
        return moveClip(r100, r101, r102, true);
    }

    public int processTouchDownEvent(float r100, float r101, VEGestureType r102) {
        return this.mVideoEditor.processTouchDownEvent(r100, r101, r102);
    }

    public int processTouchUpEvent(float r100, float r101, VEGestureType r102) {
        if (this.mSurfaceWidth != 0) goto L5;
        return -105;
    L5:
        if (this.mSurfaceHeight != 0) goto L8;
        return -105;
    L8:
        return this.mVideoEditor.processTouchUpEvent(r100, r101, r102);
    }

    public int reloadComposerNodesWithTag(String[] r100, int r101, String[] r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VEEffectParams r105 = new VEEffectParams();     // Catch: Throwable -> L7
        r105.TYPE = VEEffectParams.EFFECT_TYPE_RELOAD_COMPOSER_WITH_TAG;     // Catch: Throwable -> L7
        r105.intValueOne = r101;     // Catch: Throwable -> L7
        r105.stringArrayOne = new ArrayList(Arrays.asList(r100));     // Catch: Throwable -> L7
        r105.stringArrayTwo = new ArrayList(Arrays.asList(r102));     // Catch: Throwable -> L7
        VELogUtil.w("VEEditor_VEFilterInvoker", "reloadComposerNodes...");     // Catch: Throwable -> L7
        int r106 = r103.f455860b.setEffectParams(r105);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r106;
    L7:
        th = move-exception;
        throw th;
    }

    public int removeKeyFrameParam(int r100, int r101, int r102) {
        monitor-enter(this);
        int r103 = this.mVideoEditor.deleteKeyFrameParam(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    public int replaceOnlyAudioClip(int r100, VEClipSourceParam r101, VEClipTimelineParam r110) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "replaceAudioClip, clipIndex:" + r100);     // Catch: Throwable -> L17
        r102.f455941b.stop();     // Catch: Throwable -> L17
        int r104 = r102.f455941b.replaceClip(1, r100, r101, r110);     // Catch: Throwable -> L17
        if (r104 >= 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "replaceClip failed, ret = " + r104);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return r104;
    L9:
        r102.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L17
        TEInterface r105 = r102.f455941b;     // Catch: Throwable -> L17
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L17
        int r106 = r102.f455940a.prepareWithCallback(3);     // Catch: Throwable -> L17
        if (r106 == 0) goto L14;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return r106;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L17
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public int seek(int r100, SEEK_MODE r101, VEListener.VEEditorSeekListener r110) {
        monitor-enter(this);
        VELogUtil.w(TAG, "seek with cb... " + r100 + " flags " + r101);     // Catch: Throwable -> L14
        if ((r101.getValue() & SEEK_MODE.EDITOR_SEEK_FLAG_LastSeek.getValue()) == 0) goto L9;
        this.mSeekListener = r110;     // Catch: Throwable -> L14
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L14
        this.mlLastSeekTimeMS = r102;     // Catch: Throwable -> L14
        if (this.mlFirstSeekTimeMS != 0) goto L9;
        this.mlFirstSeekTimeMS = r102;     // Catch: Throwable -> L14
    L9:
        int r103 = this.mVideoEditor.seek(r100, this.mSurfaceWidth, this.mSurfaceHeight, r101.getValue());     // Catch: Throwable -> L14
        if (r103 == 0) goto L12;
        VELogUtil.e(TAG, "seek failed, result = " + r103);     // Catch: Throwable -> L14
        this.mSeekListener = null;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return r103;
    L14:
        th = move-exception;
        throw th;
    }

    public int seekWithResult(int r100, int r101, VEListener.VEGetImageListener r102) {
        monitor-enter(this);
        this.mGetSeekFrameListener = r102;     // Catch: Throwable -> L31
        this.mVideoEditor.setSeekFrameCallback(this.mGetSeekFrameCallback);     // Catch: Throwable -> L31
        int r103 = -1;
        if (r101 <= 0) goto L25;
        VESize r104 = getVideoResolution();     // Catch: Throwable -> L31
        int r105 = r104.width;     // Catch: Throwable -> L31
        if (r105 == 0) goto L23;
        int r106 = r104.height;     // Catch: Throwable -> L31
        if (r106 == 0) goto L23;
        if (r101 <= 0) goto L15;
        if (r101 >= r105) goto L15;
        r106 = (r106 * r101) / r105;     // Catch: Throwable -> L31
    L17:
        if ((r101 % 2) != 1) goto L19;
        r101 = r101 + 1;     // Catch: Throwable -> L31
    L19:
        r103 = r101;
        if ((r106 % 2) != 1) goto L22;
        r106 = r106 + 1;     // Catch: Throwable -> L31
    L22:
        VELogUtil.w(TAG, "seekWithResult... " + r100 + ", (" + r103 + ", " + r106 + ")");     // Catch: Throwable -> L31
    L26:
        int r107 = this.mVideoEditor.seekWithResult(r100, r103, r106);     // Catch: Throwable -> L31
        if (r107 == 0) goto L29;
        VELogUtil.e(TAG, "seek failed, result = " + r107);     // Catch: Throwable -> L31
        this.mGetSeekFrameListener = null;     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);     // Catch: Throwable -> L31
        return r107;
    L15:
        r101 = r105;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L31
        return -1;
    L25:
        r106 = -1;
    L31:
        th = move-exception;
        throw th;
    }

    public int setColorFilter(String r100, String r101, float r110) {
        return ((k0) this.mWrapperFilter).i(r100, r101, r110, 0.0f, true);
    }

    public int setComposerNodesWithTag(String[] r100, int r101, String[] r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VEEffectParams r105 = new VEEffectParams();     // Catch: Throwable -> L7
        r105.TYPE = VEEffectParams.EFFECT_TYPE_SET_COMPOSER_WITH_TAG;     // Catch: Throwable -> L7
        r105.intValueOne = r101;     // Catch: Throwable -> L7
        r105.stringArrayOne = new ArrayList(Arrays.asList(r100));     // Catch: Throwable -> L7
        r105.stringArrayTwo = new ArrayList(Arrays.asList(r102));     // Catch: Throwable -> L7
        VELogUtil.w("VEEditor_VEFilterInvoker", "setComposerNodesWithTag...");     // Catch: Throwable -> L7
        int r106 = r103.f455860b.setEffectParams(r105);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r106;
    L7:
        th = move-exception;
        throw th;
    }

    public int setEffectCacheInt(int r100, String r101, int r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        int r105 = r103.f455860b.setEffectCacheInt(r101, r102);     // Catch: Throwable -> L10
        if (r105 == 0) goto L7;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setEffectCacheInt failed, ret = " + r105);     // Catch: Throwable -> L10
    L7:
        r103.f455860b.setFilterParam(r100, "effect cache int key", r101);     // Catch: Throwable -> L10
        r103.f455860b.setFilterParam(r100, "effect cache int value", r102 + "");     // Catch: Throwable -> L10
        monitor-exit(r104);     // Catch: Throwable -> L10
        return r105;
    L10:
        th = move-exception;
        throw th;
    }

    public int setEffectFontPath(int r100, String r101, int r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "setEffectFontPath STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.a0();
    }

    public int setEffectHDRFilter(int r100, String r101, float r102) {
        return ((k0) this.mWrapperFilter).j(r100, r101, r102);
    }

    public int setExternalAlgorithmResult(String r100, String r101, String r102) {
        dic.d r103 = this.mWrapperMV;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r103.g();
    }

    public int setFileRotate(int r110, int r111, ROTATE_DEGREE r112) {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        VELogUtil.i("VEEditor_VESequenceInvoker", "setFileRotate..." + r110 + " " + r111 + " " + r112);
        return r100.f455941b.setClipAttr(0, r110, r111, "clip rotate", "" + r112.ordinal());
    }

    public void setImageResizeInfo(int r100, int r101, int r102) {
        setImageResizeInfo(r100, r101, r102, 0);
    }

    public int setInOut(int r100, int r101, SET_RANGE_MODE r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        fic.a r105 = new fic.a();     // Catch: Throwable -> L7
        r105.b("iesve_veeditor_cut_duration", r101 - r100);     // Catch: Throwable -> L7
        com.ss.android.ttve.monitor.g.b(r105);     // Catch: Throwable -> L7
        VELogUtil.i("VEEditor_VESequenceInvoker", "setInOut... " + r100 + " " + r101 + " mode " + r102.getValue());     // Catch: Throwable -> L7
        r103.f455941b.stop();     // Catch: Throwable -> L7
        r103.f455941b.setTimeRange(r100, r101, r102.getValue());     // Catch: Throwable -> L7
        int r106 = r103.f455941b.prepareEngine(0);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r106;
    L7:
        th = move-exception;
        throw th;
    }

    public int setInfoStickerFlip(int r100, boolean r101, boolean r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerFlip STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.l0();
    }

    public int setInfoStickerPosition(int r100, float r101, float r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerPosition STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.j0();
    }

    public int setInfoStickerTime(int r100, int r101, int r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "setInfoStickerTime STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.g0();
    }

    public int setScaleMode(SCALE_MODE r100, float r101, float r102) {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "set scale mode failed,is destroying, just return");
        return 0;
    L6:
        VELogUtil.w(TAG, "setScaleMode... mode:" + r100 + ", x = " + r101 + ", y = " + r102);
        switch(g.f455556a[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L15;
        };
    L9:
        this.mVideoEditor.setResizer(6, r101, r102);
        goto L15
    L10:
        this.mVideoEditor.setResizer(5, r101, r102);
        goto L15
    L11:
        this.mVideoEditor.setResizer(4, r101, r102);
        goto L15
    L12:
        this.mVideoEditor.setResizer(3, r101, r102);
        goto L15
    L13:
        this.mVideoEditor.setResizer(1, r101, r102);
        goto L15
    L14:
        this.mVideoEditor.setResizer(2, r101, r102);
    L15:
        return 0;
    }

    public int setSrtInfo(int r100, int r101, String r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "setSrtInfo STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.q();
    }

    public int setSrtInitialPosition(int r100, float r101, float r102) {
        dic.f r103 = this.mWrapperSticker;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "setSrtInitialPosition STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r103.D();
    }

    public int setTimeRange(int r100, int r101, SET_RANGE_MODE r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        int r105 = r103.f455941b.setTimeRange(r100, r101, r102.getValue());     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public int setTrackDurationType(int r100, int r101, int r102) {
        return ((w0) this.mWrapperSequence).f455941b.setTrackDurationType(r100, r101, r102);
    }

    public int setTrackFilterEnable(int r100, boolean r101, boolean r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VELogUtil.i("VEEditor_VEFilterInvoker", "setTrackFilterEnable... " + r100 + ", " + r101 + ", " + r102);     // Catch: Throwable -> L7
        int r105 = r103.f455860b.setTrackFilterEnable(r100, r101, r102);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setVolume(int r100, int r101, float r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        VELogUtil.w("VEEditor_VESequenceInvoker", "setVolume... index:" + r100 + " type:" + r101 + " volume:" + r102);     // Catch: Throwable -> L7
        boolean r105 = r103.f455941b.setTrackVolume(r101, r103.f455940a.getTrackIndexManager().b(1, r100), r102);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public int updateAICutOutClipParam(int r100, int r101, VEAICutOutClipParam r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VELogUtil.i("VEEditor_VEFilterInvoker", "addAIProcessFilter... " + r100 + ", " + r101);     // Catch: Throwable -> L7
        int r105 = r103.f455860b.updateAICutOutClipParam(r103.f455859a.getTrackIndexManager().b(2, r100), r101, r102);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public int updateClipSourceParam(int r100, int[] r101, VEClipSourceParam[] r102) {
        return updateClipSourceParam(r100, 0, r101, r102);
    }

    public int updateClipsTimelineParam(int r100, int[] r101, VEClipTimelineParam[] r102) {
        return updateClipsTimelineParam(r100, 0, r101, r102);
    }

    public int updateComposerNode(String r100, String r101, float r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VELogUtil.w("VEEditor_VEFilterInvoker", "updateComposerNode");     // Catch: Throwable -> L11
        int r105 = r103.f455860b.updateComposerNode(r100, r101, r102);     // Catch: Throwable -> L11
        if (r105 == 0) goto L9;
        VELogUtil.e("VEEditor_VEFilterInvoker", "updateComposerNode failed, ret = " + r105);     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
    L10:
        return r105;
    L9:
        monitor-exit(r104);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int updateMVBackgroundAudioTrack(String r100, int r101, int r102) {
        dic.d r103 = this.mWrapperMV;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r103.r();
    }

    public int updateMVBackgroundAudioTrack2(String r100, int r101, int r102) {
        dic.d r103 = this.mWrapperMV;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r103.k();
    }

    public int updateMVResources(String r100, String[] r101, String[] r102) {
        dic.d r103 = this.mWrapperMV;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r103.v();
    }

    public int updateMVResourcesRecreateEngine(String r100, String[] r101, String[] r102) {
        dic.d r103 = this.mWrapperMV;
        if (r103 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r103.a();
    }

    public int updateSceneTime(VETimelineParams r100, int r101, int r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        r103.getClass();
        VELogUtil.w("VEEditor_VESequenceInvoker", "updateSceneTime with start/end time" + r100.toString() + " startTime: " + r101 + " endTime: " + r102);
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        r103.f455941b.stop();     // Catch: Throwable -> L17
        int r105 = r103.f455941b.updateSenceTime(r100);     // Catch: Throwable -> L17
        if (r105 >= 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateSceneTime failed, ret = " + r105);     // Catch: Throwable -> L17
        monitor-exit(r104);     // Catch: Throwable -> L17
        return r105;
    L9:
        r103.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L17
        r103.f455941b.setTimeRange(r101, r102, 0);     // Catch: Throwable -> L17
        int r106 = r103.f455941b.prepareEngine(0);     // Catch: Throwable -> L17
        if (r106 == 0) goto L14;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L17
        monitor-exit(r104);     // Catch: Throwable -> L17
        return r106;
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L17
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public int updateTrackClipFilter(int r100, int r101, VEBaseFilterParam r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        VEEditor r104 = r103.f455859a;
        monitor-enter(r104);
        VELogUtil.d("VEEditor_VEFilterInvoker", "updateClipFilterParam, clipIndex:" + r100 + ",filterIndex:" + r101);     // Catch: Throwable -> L18
        int r105 = -1;
        if (r102.filterType != 1) goto L12;
        TEAudioEffectInterface r106 = r103.f455861c;     // Catch: Throwable -> L18
        if (r106 != null) goto L11;
        VELogUtil.e("VEEditor_VEFilterInvoker", "DON'T SUPPORT AUDIO EFFECT!");     // Catch: Throwable -> L18
        monitor-exit(r104);     // Catch: Throwable -> L18
    L17:
        return r105;
    L11:
        int r107 = r106.updateAudioFilterParam(r100, r101, r102);     // Catch: Throwable -> L18
    L13:
        if (r107 < 0) goto L16;
        r105 = 0;
    L16:
        monitor-exit(r104);     // Catch: Throwable -> L18
        goto L17
    L12:
        r107 = r103.f455860b.updateFilterParam(r100, r101, r102);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public int updateTrackFilterTime(int r100, int r101, int r102) {
        k0 r103 = (k0) this.mWrapperFilter;
        r103.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "updateTrackFilterTime, filterIndex: " + r100 + ", sequenceIn: " + r101 + ", sequenceOut: " + r102);
        return r103.f455860b.updateFilterTime(-1, r100, r101, r102);
    }

    public int updateVideoClips(String[] r100, int[] r101, int[] r102) {
        w0 r103 = (w0) this.mWrapperSequence;
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        VELogUtil.i("VEEditor_VESequenceInvoker", "update video clips reinit...");     // Catch: Throwable -> L12
        r103.f455941b.stop();     // Catch: Throwable -> L12
        r103.f455940a.setMusicSRTEffectFilterIndex(-1);     // Catch: Throwable -> L12
        r103.f455941b.updateScene(r100, r101, r102);     // Catch: Throwable -> L12
        r103.f455940a.getResManager().mVideoPaths = r100;     // Catch: Throwable -> L12
        r103.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L12
        r103.f455941b.createTimeline();     // Catch: Throwable -> L12
        int r105 = r103.f455941b.prepareEngine(0);     // Catch: Throwable -> L12
        if (r105 == 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r105);     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        return r105;
    L9:
        r103.f455940a.seek(0, SEEK_MODE.EDITOR_SEEK_FLAG_LastSeek);     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    public VEEditor(String r100, TextureView r101, VEUserConfig r110) throws VEException {
        this.mInitSize = new VESize(-1, -1);
        this.mCompileType = "mp4";
        this.mMessageHandler = new t(this, Looper.getMainLooper());
        this.mSeekListener = null;
        this.mCompileListener = null;
        this.mFirstFrameListener = null;
        this.mVideoOutputListener = null;
        this.mAsyncReleaseEngineListener = null;
        this.mUserCommonInfoCallback = null;
        this.mUserCommonErrorCallback = null;
        this.mTrackIndexManager = new TETrackIndexManager();
        this.mBusinessManager = new ogc.a();
        this.mAutoPrepare = true;
        this.mUsageType = "unknown";
        this.mRecordData = null;
        this.mConcatVideoPath = "/concatShootVideo";
        this.mKeyFrameMap = new HashMap();
        this.mIsDestroying = new AtomicBoolean(false);
        this.mConcatVideoErrorForInvalidCodecs = -1;
        this.mTeCommonInfoCallback = new h(this);
        this.mTeCommonErrorCallback = new i(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInitDisplayWidth = 0;
        this.mInitDisplayHeight = 0;
        this.mbSeparateAV = Boolean.FALSE;
        this.mMasterTrackIndex = 0;
        this.miFrameCount = 0;
        this.mlCurTimeMS = 0;
        this.mlLastTimeMS = 0;
        this.mlInitTimeMS = 0;
        this.mlFirstSeekTimeMS = 0;
        this.mlFirstPlayTimeMS = 0;
        this.mlLastSeekTimeMS = 0;
        this.mlFirstFrameWithoutSurfaceTimeMS = 0;
        this.mFirstFrameDrawed = false;
        this.miCacheHitCount = 0;
        this.miCacheMissCount = 0;
        this.mInPoint = 0;
        this.mOutPoint = -1;
        this.mVideoGravity = VIDEO_GRAVITY.ALIGN_PARENT_BOTTOM;
        this.mVideoScaletype = VIDEO_SCALETYPE.CENTER;
        this.mInitSuccess = false;
        this.mReverseDone = false;
        this.mCancelReverse = false;
        this.mCanvasWrapFilterIndex = -1;
        this.mOutputFile = null;
        this.mlCompileStartTime = 0;
        this.mBReversePlay = false;
        this.mBCompileHighQualityGif = false;
        this.mp4ToGIFConverter = null;
        this.mEncoderListener = null;
        this.mGetImageListener = null;
        this.mGetSeekFrameListener = null;
        this.mTEMonitorFilterMgr = new com.ss.android.ttve.monitor.j();
        this.mReDrawSurface = false;
        this.mFirstTimeSurfaceCreate = true;
        this.mReDrawSurfaceOnce = false;
        this.mCurrentBmp = null;
        this.rotate = 0.0f;
        this.scaleW = 1.0f;
        this.scaleH = 1.0f;
        this.mPageMode = -1;
        this.mEditorMode = -1;
        this.mBackGroundColor = -16777216;
        this.mVideoBackGroundColor = -16777216;
        this.model_sequence_time = 0;
        this.editor_time = 0;
        this.mPlayFps = 0.0f;
        j r102 = new j(this);
        this.mTextureListener = r102;
        this.mSurfaceCallback = new k(this);
        this.mOpenGLCallback = new l(this);
        this.mEncoderDataCallback = new m(this);
        this.mGetImageCallback = new n(this);
        this.mGetSeekFrameCallback = new o(this);
        this.mGetCompileFirstFrameCallback = new p(this);
        this.mMattingCallback = new a(this);
        this.mkeyFrameCallback = new b(this);
        y0.a("VEEditor-textureView");
        if (TextUtils.isEmpty(r100) == true) goto L7;
        VELogUtil.i(TAG, "VEEditor textureView");
        this.mVideoEditor = TEInterface.createEngine(r110);
        this.mResManager = new VEEditorResManager(r100);
        this.mTextureView = r101;
        r101.setSurfaceTextureListener(r102);
        this.mVideoEditor.setOpenGLListeners(this.mOpenGLCallback);
        this.mVideoEditor.setInfoListener(this.mTeCommonInfoCallback);
        this.mVideoEditor.setErrorListener(this.mTeCommonErrorCallback);
        enableEffectAmazing(false);
        createWrapperInvokers();
        y0.b();
        return;
    L7:
        throw new VEException(-100, "workspace is: " + r100);
    }

    public VEEditor(String r100, SurfaceView r101, VEUserConfig r102) {
        this(r100, r101, true, r102);
    }

    public VEEditor(String r100, SurfaceView r101, boolean r102) {
        this(r100, r101, r102, null);
    }

    public VEEditor(String r100, SurfaceView r101, boolean r110, VEUserConfig r111) {
        this.mInitSize = new VESize(-1, -1);
        this.mCompileType = "mp4";
        this.mMessageHandler = new t(this, Looper.getMainLooper());
        this.mSeekListener = null;
        this.mCompileListener = null;
        this.mFirstFrameListener = null;
        this.mVideoOutputListener = null;
        this.mAsyncReleaseEngineListener = null;
        this.mUserCommonInfoCallback = null;
        this.mUserCommonErrorCallback = null;
        this.mTrackIndexManager = new TETrackIndexManager();
        this.mBusinessManager = new ogc.a();
        this.mAutoPrepare = true;
        this.mUsageType = "unknown";
        this.mRecordData = null;
        this.mConcatVideoPath = "/concatShootVideo";
        this.mKeyFrameMap = new HashMap();
        this.mIsDestroying = new AtomicBoolean(false);
        this.mConcatVideoErrorForInvalidCodecs = -1;
        this.mTeCommonInfoCallback = new h(this);
        this.mTeCommonErrorCallback = new i(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mInitDisplayWidth = 0;
        this.mInitDisplayHeight = 0;
        this.mbSeparateAV = Boolean.FALSE;
        this.mMasterTrackIndex = 0;
        this.miFrameCount = 0;
        this.mlCurTimeMS = 0;
        this.mlLastTimeMS = 0;
        this.mlInitTimeMS = 0;
        this.mlFirstSeekTimeMS = 0;
        this.mlFirstPlayTimeMS = 0;
        this.mlLastSeekTimeMS = 0;
        this.mlFirstFrameWithoutSurfaceTimeMS = 0;
        this.mFirstFrameDrawed = false;
        this.miCacheHitCount = 0;
        this.miCacheMissCount = 0;
        this.mInPoint = 0;
        this.mOutPoint = -1;
        this.mVideoGravity = VIDEO_GRAVITY.ALIGN_PARENT_BOTTOM;
        this.mVideoScaletype = VIDEO_SCALETYPE.CENTER;
        this.mInitSuccess = false;
        this.mReverseDone = false;
        this.mCancelReverse = false;
        this.mCanvasWrapFilterIndex = -1;
        this.mOutputFile = null;
        this.mlCompileStartTime = 0;
        this.mBReversePlay = false;
        this.mBCompileHighQualityGif = false;
        this.mp4ToGIFConverter = null;
        this.mEncoderListener = null;
        this.mGetImageListener = null;
        this.mGetSeekFrameListener = null;
        this.mTEMonitorFilterMgr = new com.ss.android.ttve.monitor.j();
        this.mReDrawSurface = false;
        this.mFirstTimeSurfaceCreate = true;
        this.mReDrawSurfaceOnce = false;
        this.mCurrentBmp = null;
        this.rotate = 0.0f;
        this.scaleW = 1.0f;
        this.scaleH = 1.0f;
        this.mPageMode = -1;
        this.mEditorMode = -1;
        this.mBackGroundColor = -16777216;
        this.mVideoBackGroundColor = -16777216;
        this.model_sequence_time = 0;
        this.editor_time = 0;
        this.mPlayFps = 0.0f;
        this.mTextureListener = new j(this);
        this.mSurfaceCallback = new k(this);
        this.mOpenGLCallback = new l(this);
        this.mEncoderDataCallback = new m(this);
        this.mGetImageCallback = new n(this);
        this.mGetSeekFrameCallback = new o(this);
        this.mGetCompileFirstFrameCallback = new p(this);
        this.mMattingCallback = new a(this);
        this.mkeyFrameCallback = new b(this);
        long r102 = System.currentTimeMillis();
        y0.a("VEEditor-surfaceView");
        if (TextUtils.isEmpty(r100) == true) goto L10;
        VELogUtil.i(TAG, "VEEditor surfaceView");
        this.mVideoEditor = TEInterface.createEngine(r111);
        this.mResManager = new VEEditorResManager(r100);
        this.mSurfaceView = r101;
        if (r110 == false) goto L7;
        r101.getHolder().addCallback(this.mSurfaceCallback);
    L7:
        this.mVideoEditor.setOpenGLListeners(this.mOpenGLCallback);
        this.mVideoEditor.setInfoListener(this.mTeCommonInfoCallback);
        this.mVideoEditor.setErrorListener(this.mTeCommonErrorCallback);
        enableEffectAmazing(false);
        createWrapperInvokers();
        y0.b();
        this.editor_time += System.currentTimeMillis() - r102;
        return;
    L10:
        throw new VEException(-100, "workspace is: " + r100);
    }

    private boolean _compile(String r210, String r211, VEVideoEncodeSettings r212, VEAudioEncodeSettings r213) throws VEException {
        String r100 = r210;
        monitor-enter(this);
    L135:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitSuccess == false) goto L134;
        if (this.mVideoEditor.getNativeHandler() != 0) goto L9;
    L131:
        monitor-exit(this);     // Catch: Throwable -> L135
        return false;
    L9:
        if (TextUtils.isEmpty(r210) == true) goto L131;
        VELogUtil.i(TAG, "_compile mPageMode = " + this.mPageMode);     // Catch: Throwable -> L135
        VELogUtil.d(TAG, "_compile outFilePath = " + r100);     // Catch: Throwable -> L135
        if ((-1) != r212.getEnableRemuxVideoRes()) goto L22;
        VEConfigCenter.ValuePkt r101 = VEConfigCenter.getInstance().getValue("remux_video_res");     // Catch: Throwable -> L135
        if (r101 != null) goto L16;
    L20:
        VELogUtil.i("VESDK", "No remux video resolution config");     // Catch: Throwable -> L135
        goto L22
    L16:
        if (r101.getValue() == null) goto L20;
        if ((r101.getValue() instanceof Integer) == false) goto L20;
        int r102 = ((Integer) r101.getValue()).intValue();     // Catch: Throwable -> L135
        r212.setEnableRemuxVideoRes(r102);     // Catch: Throwable -> L135
        VELogUtil.i("VESDK", "remuxVideoRes = " + r102);     // Catch: Throwable -> L135
    L22:
        if (r212.isEnableRemuxVideoForShoot() == true) goto L24;
    L26:
        this.mVideoEditor.genEditorStatus();     // Catch: Throwable -> L135
        VEPublishSettingManager.b().e(r212, VERuntime.getInstance().getNativeContext());     // Catch: Throwable -> L135
        VEVideoEncodeSettings r103 = VEPublishSettingManager.b().f();     // Catch: Throwable -> L135
        VELogUtil.w(TAG, "VideoEncodeSettings = " + r103.toString());     // Catch: Throwable -> L135
        if (this.mUserCommonInfoCallback == null) goto L32;
        int r104 = VEPublishSettingManager.b().a();     // Catch: Throwable -> L135
        VELogUtil.w(TAG, "report remux error code = " + r104);     // Catch: Throwable -> L135
        int r105 = this.mConcatVideoErrorForInvalidCodecs;     // Catch: Throwable -> L135
        if (r105 == (-1)) goto L31;
        r104 = r105;
    L31:
        this.mUserCommonInfoCallback.onCallback(4130, r104, 0.0f, null);     // Catch: Throwable -> L135
    L32:
        this.mOutputFile = r100;     // Catch: Throwable -> L135
        this.mlCompileStartTime = System.currentTimeMillis();     // Catch: Throwable -> L135
        if (this.mReDrawSurface == false) goto L37;
        Bitmap r106 = getCurrDisplayImage();     // Catch: Throwable -> L135
        this.mCurrentBmp = r106;     // Catch: Throwable -> L135
        if (r106 == null) goto L37;
        Matrix r107 = new Matrix();     // Catch: Throwable -> L135
        r107.postRotate(this.rotate);     // Catch: Throwable -> L135
        r107.postScale(this.scaleW, this.scaleH);     // Catch: Throwable -> L135
        Bitmap r110 = this.mCurrentBmp;     // Catch: Throwable -> L135
        this.mCurrentBmp = Bitmap.createBitmap(r110, 0, 0, r110.getWidth(), this.mCurrentBmp.getHeight(), r107, true);     // Catch: Throwable -> L135
    L37:
        VELogUtil.w(TAG, "compile...");     // Catch: Throwable -> L135
        this.mVideoEditor.stop();     // Catch: Throwable -> L135
        switch(g.f455557b[r103.getCompileType().ordinal()]) {
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L53;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            default: goto L66;
        };     // Catch: Throwable -> L135
    L40:
        this.mVideoEditor.setCompileType(128);     // Catch: Throwable -> L135
        this.mCompileType = LoadParams.ImageFormat.PNG;     // Catch: Throwable -> L135
    L67:
        this.mVideoEditor.setCompileFps(r103.getFps());     // Catch: Throwable -> L135
        this.mVideoEditor.setCompilePublishFps(r103.getPublishFps());     // Catch: Throwable -> L135
        this.mVideoEditor.setCompileMVStillFramesPublishFps(r103.getMVStillFramesPublishFps());     // Catch: Throwable -> L135
        this.mVideoEditor.setCompileMVStillFramesWatermarkFps(r103.getMVStillFramesWatermarkFps());     // Catch: Throwable -> L135
        this.mVideoEditor.setEngineCompilePath(r100, r211);     // Catch: Throwable -> L135
        this.mVideoEditor.setResizer(r103.getResizeMode(), r103.getResizeX(), r103.getResizeY());     // Catch: Throwable -> L135
        VELogUtil.w(TAG, "compile... resizeMode:" + r103.getResizeMode() + ", resetX:" + r103.getResizeX() + ", resetY:" + r103.getResizeY());     // Catch: Throwable -> L135
        this.mVideoEditor.setVideoBackGroundColor(this.mVideoBackGroundColor);     // Catch: Throwable -> L135
        this.mVideoEditor.setUsrRotate(r103.getRotate());     // Catch: Throwable -> L135
        this.mVideoEditor.setSpeedRatio(r103.getSpeed());     // Catch: Throwable -> L135
        this.mVideoEditor.setEnableRemuxVideo(r103.isEnableRemuxVideo());     // Catch: Throwable -> L135
        this.mVideoEditor.setEnableInterLeave(r103.isEnableInterLeave());     // Catch: Throwable -> L135
        this.mVideoEditor.setEnableAvInterLeave(r103.isEnableAvInterLeave());     // Catch: Throwable -> L135
        this.mVideoEditor.setCompileSoftInfo(r103.isCompileSoftInfo());     // Catch: Throwable -> L135
        VEConfigCenter.ValuePkt r108 = VEConfigCenter.getInstance().getValue("vboost_compile");     // Catch: Throwable -> L135
        if (r108 != null) goto L70;
    L74:
        VEConfigCenter.ValuePkt r109 = VEConfigCenter.getInstance().getValue("ve_compile_report");     // Catch: Throwable -> L135
        if (r109 != null) goto L77;
    L81:
        this.mVideoEditor.setAudioCompileSetting(r213.getSampleRate(), r213.getChannelCount(), r213.getBps());     // Catch: Throwable -> L135
        if (this.mEncoderListener == null) goto L84;
        this.mVideoEditor.setEncoderParallel(true, false);     // Catch: Throwable -> L135
        this.mVideoEditor.setEncoderDataListener(this.mEncoderDataCallback);     // Catch: Throwable -> L135
    L85:
        addCopyright();     // Catch: Throwable -> L135
        this.mVideoEditor.setWidthHeight(r103.getVideoRes().width, r103.getVideoRes().height);     // Catch: Throwable -> L135
        if (r103.getWatermarkParam() != null) goto L88;
    L96:
        this.mVideoEditor.setWatermarkWidthHeight(r103.getVideoRes().width, r103.getVideoRes().height);     // Catch: Throwable -> L135
    L98:
        if (r103.getKeyFramePoints() == null) goto L100;
        this.mVideoEditor.setKeyFramePoints(r103.getKeyFramePoints());     // Catch: Throwable -> L135
    L100:
        VEWatermarkParam r111 = r103.getWatermarkParam();     // Catch: Throwable -> L135
        if (r111 != null) goto L103;
    L109:
        if (r111 == null) goto L114;
        if (r111.getEntities().length == 0) goto L114;
        r111.needExtFile = false;     // Catch: Throwable -> L135
        this.mVideoEditor.setCompileWatermark(r111);     // Catch: Throwable -> L135
        this.mVideoEditor.setEnableRemuxVideo(false);     // Catch: Throwable -> L135
    L114:
        if (this.mVideoEditor.prepareEngine(1) == 0) goto L118;
        onMonitorError();     // Catch: Throwable -> L135
        monitor-exit(this);     // Catch: Throwable -> L135
        return false;
    L118:
        if (r111 != null) goto L120;
        com.ss.android.ttve.monitor.i.f(1, "te_composition_watermark_add", 0);     // Catch: Throwable -> L135
    L124:
        this.mVideoEditor.start();     // Catch: Throwable -> L135
        fic.a r112 = new fic.a();     // Catch: Throwable -> L135
        r112.c("iesve_veeditor_composition_start_file", this.mCompileType);     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.g.b(r112);     // Catch: Throwable -> L135
        int r113 = VEPublishSettingManager.b().a();     // Catch: Throwable -> L135
        JSONObject r114 = new JSONObject();     // Catch: JSONException -> L127 Throwable -> L135
        r114.put("enableRemux", r113);     // Catch: JSONException -> L127 Throwable -> L135
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_compile", r114, "business");     // Catch: JSONException -> L127 Throwable -> L135
    L129:
        monitor-exit(this);     // Catch: Throwable -> L135
        return true;
    L127:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L135
        goto L129
    L120:
        if (r111.getEntities() == null) goto L122;
        this.mVideoEditor.setWaterMark(r111.getEntities(), r111.mask);     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.f(1, "te_composition_watermark_add", 1);     // Catch: Throwable -> L135
        goto L124
    L122:
        VELogUtil.w(TAG, "watermarkParam.images is null!!!");     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.f(1, "te_composition_watermark_add", 0);     // Catch: Throwable -> L135
        goto L124
    L103:
        if (r111.needExtFile == false) goto L109;
        this.mVideoEditor.setCompileWatermark(r111);     // Catch: Throwable -> L135
        if (this.mVideoEditor.prepareEngine(2) == 0) goto L118;
        onMonitorError();     // Catch: Throwable -> L135
        monitor-exit(this);     // Catch: Throwable -> L135
        return false;
    L88:
        if (r103.getWatermarkVideoRes().width <= 0) goto L96;
        if (r103.getWatermarkVideoRes().height <= 0) goto L96;
        if (r103.getWatermarkParam().needExtFile == false) goto L95;
        this.mVideoEditor.setWatermarkWidthHeight(r103.getWatermarkVideoRes().width, r103.getWatermarkVideoRes().height);     // Catch: Throwable -> L135
        goto L98
    L95:
        this.mVideoEditor.setWidthHeight(r103.getWatermarkVideoRes().width, r103.getWatermarkVideoRes().height);     // Catch: Throwable -> L135
        goto L98
    L84:
        this.mVideoEditor.setEncoderParallel(false, false);     // Catch: Throwable -> L135
        this.mVideoEditor.setEncoderDataListener(null);     // Catch: Throwable -> L135
        goto L85
    L77:
        if (r109.getValue() == null) goto L81;
        if ((r109.getValue() instanceof Integer) == false) goto L81;
        TEInterface.setCompileReportState(((Integer) r109.getValue()).intValue());     // Catch: Throwable -> L135
        goto L81
    L70:
        if (r108.getValue() == null) goto L74;
        if ((r108.getValue() instanceof Boolean) == false) goto L74;
        this.mVideoEditor.setEnableCompileVboost(((Boolean) r108.getValue()).booleanValue());     // Catch: Throwable -> L135
        goto L74
    L41:
        this.mVideoEditor.setCompileType(64);     // Catch: Throwable -> L135
        this.mCompileType = LoadParams.ImageFormat.JPEG;     // Catch: Throwable -> L135
        goto L67
    L42:
        q r115 = this.mp4ToGIFConverter;     // Catch: Throwable -> L135
        if (r115 != null) goto L45;
    L49:
        this.mBCompileHighQualityGif = true;     // Catch: Throwable -> L135
        this.mVideoEditor.setCompileType(32);     // Catch: Throwable -> L135
        if (this.mp4ToGIFConverter != null) goto L52;
        this.mp4ToGIFConverter = new q();     // Catch: Throwable -> L135
    L52:
        String r116 = this.mOutputFile;     // Catch: Throwable -> L135
        r100 = r116.substring(0, r116.lastIndexOf(".")) + Global.SUFFIX_DATA_FILE;     // Catch: Throwable -> L135
        this.mp4ToGIFConverter.f455585n = r103.getFps();     // Catch: Throwable -> L135
        q r117 = this.mp4ToGIFConverter;     // Catch: Throwable -> L135
        r117.f455582k = true;     // Catch: Throwable -> L135
        r117.f455573b = r100;     // Catch: Throwable -> L135
        r117.b(this.mOutputFile);     // Catch: Throwable -> L135
        this.mCompileType = "transparent_gif";     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.f(4, "te_composition_gif_ret", 0);     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.j(4);     // Catch: Throwable -> L135
        goto L67
    L45:
        if (r115.f455576e == false) goto L49;
        com.ss.android.ttve.monitor.i.f(4, "te_composition_gif_ret", -1);     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.j(4);     // Catch: Throwable -> L135
        monitor-exit(this);     // Catch: Throwable -> L135
        return false;
    L53:
        q r118 = this.mp4ToGIFConverter;     // Catch: Throwable -> L135
        if (r118 != null) goto L56;
    L60:
        this.mBCompileHighQualityGif = true;     // Catch: Throwable -> L135
        this.mVideoEditor.setCompileType(4);     // Catch: Throwable -> L135
        if (this.mp4ToGIFConverter != null) goto L63;
        this.mp4ToGIFConverter = new q();     // Catch: Throwable -> L135
    L63:
        r100 = new PolarisFileWrapper(this.mOutputFile).getParent() + File.separatorChar + "gif.mp4";     // Catch: Throwable -> L135
        q r119 = this.mp4ToGIFConverter;     // Catch: Throwable -> L135
        r119.f455573b = r100;     // Catch: Throwable -> L135
        r119.b(this.mOutputFile);     // Catch: Throwable -> L135
        q r120 = this.mp4ToGIFConverter;     // Catch: Throwable -> L135
        r120.f455577f = this.waterMarkFile;     // Catch: Throwable -> L135
        r120.f455578g = (int) (this.waterMarkWidth * ((double) r103.getVideoRes().width));     // Catch: Throwable -> L135
        this.mp4ToGIFConverter.f455579h = (int) (this.waterMarkHeight * ((double) r103.getVideoRes().height));     // Catch: Throwable -> L135
        this.mp4ToGIFConverter.f455580i = (int) (this.waterMarkOffsetX * ((double) r103.getVideoRes().width));     // Catch: Throwable -> L135
        this.mp4ToGIFConverter.f455581j = (int) (this.waterMarkOffsetY * ((double) r103.getVideoRes().height));     // Catch: Throwable -> L135
        this.mCompileType = "high_gif";     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.f(4, "te_composition_gif_ret", 0);     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.j(4);     // Catch: Throwable -> L135
        goto L67
    L56:
        if (r118.f455576e == false) goto L60;
        com.ss.android.ttve.monitor.i.f(4, "te_composition_gif_ret", -1);     // Catch: Throwable -> L135
        com.ss.android.ttve.monitor.i.j(4);     // Catch: Throwable -> L135
        monitor-exit(this);     // Catch: Throwable -> L135
        return false;
    L64:
        this.mVideoEditor.setCompileType(2);     // Catch: Throwable -> L135
        this.mCompileType = "gif";     // Catch: Throwable -> L135
        goto L67
    L65:
        this.mVideoEditor.setCompileType(1);     // Catch: Throwable -> L135
        this.mCompileType = "mp4";     // Catch: Throwable -> L135
        goto L67
    L66:
        this.mVideoEditor.setCompileType(1);     // Catch: Throwable -> L135
        this.mCompileType = "mp4";     // Catch: Throwable -> L135
        goto L67
    L24:
        if (concatShootVideo(r212) == true) goto L26;
        r212.setEnableRemuxVideoForShoot(false);     // Catch: Throwable -> L135
        goto L26
    L134:
        throw new VEException(-105, "Make sure the initialization is successful before coding!!!");     // Catch: Throwable -> L135
    }

    public static String audioExtend(String r100, float r101, float r102, float r103) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return TEInterface.audioExtend(r100, r101, r102, r103);
    }

    public static int setMaxVideoReaderLimits(int r100, int r101, int r102, int r103) {
        VELogUtil.i(TAG, "setMaxVideoReaderLimits... " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
        if (r103 == 0) goto L16;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        int r104 = TEMediaCodecDecoder.getMaxMediaCodecVideoDecoderCount();
        if (r104 <= 0) goto L12;
        if (r103 <= 0) goto L10;
        if (r103 <= r104) goto L10;
    L11:
        r103 = r104;
    L10:
        if (r103 >= 0) goto L16;
    L12:
        r103 = 0;
        goto L16
    L13:
        if (r103 >= 0) goto L16;
        r103 = 2;
    L16:
        return TEInterface.setMaxSoftWareVideoReaderCount(r100, r101, r102, r103);
    }

    public int addAudioCleanFilter(int r110, int r111, int r112, int r113) {
        return ((k0) this.mWrapperFilter).f455860b.addFilters(new int[]{r110}, new String[]{"audio cleaner"}, new int[]{r112}, new int[]{r113}, new int[]{r111}, new int[]{1})[0];
    }

    public int addAudioDRCFilter(int r110, float[] r111, int r112, int r113) {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        if (13 == r111.length) goto L5;
        return -1;
    L5:
        int[] r114 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio drc"}, new int[]{r112}, new int[]{r113}, new int[]{1}, new int[]{1});
        int r115 = 0;
    L7:
        if (r115 >= r111.length) goto L10;
        r100.f455860b.setFilterParam(r114[0], "drc_params_" + r115, "" + r111[r115]);
        r115 = r115 + 1;
        goto L7
    L10:
        return r114[0];
    }

    public int addAudioTrack(String r110, int r111, int r112, boolean r113) {
        w0 r114 = (w0) this.mWrapperSequence;
        VEEditor r115 = r114.f455940a;
        monitor-enter(r115);
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrack... " + r110 + " In " + r111 + " Out " + r112 + " " + r113);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r110) == false) goto L8;
        monitor-exit(r115);     // Catch: Throwable -> L26
    L24:
        return -100;
    L8:
        if (r112 <= r111) goto L23;
        if (r111 < 0) goto L23;
        com.ss.android.ttve.monitor.g.b(null);     // Catch: Throwable -> L26
        int r100 = r114.f455941b.addAudioTrack(r110, 0, r112 - r111, r111, r112, r113);     // Catch: Throwable -> L26
        VELogUtil.e("VEEditor_VESequenceInvoker", "trackIndexNative=" + r100);     // Catch: Throwable -> L26
        int r101 = r114.f455940a.getTrackIndexManager().a(1, r100);     // Catch: Throwable -> L26
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L18 Throwable -> L26
        r102.put("path", r110);     // Catch: JSONException -> L18 Throwable -> L26
        r102.put("trimIn", r111);     // Catch: JSONException -> L18 Throwable -> L26
        r102.put("trimOut", r112);     // Catch: JSONException -> L18 Throwable -> L26
        if (r101 < 0) goto L15;
        int r103 = 0;
    L16:
        r102.put("resultCode", r103);     // Catch: JSONException -> L18 Throwable -> L26
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_audio_track", r102, "business");     // Catch: JSONException -> L18 Throwable -> L26
    L20:
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrack... " + r101);     // Catch: Throwable -> L26
        monitor-exit(r115);     // Catch: Throwable -> L26
        return r101;
    L15:
        r103 = -1;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L23:
        monitor-exit(r115);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public int addEqualizer(int r110, VEEqualizerParams r111, int r112, int r113) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r114 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio equalizer"}, new int[]{r112}, new int[]{r113}, new int[]{1}, new int[]{1});
        TEInterface r115 = r100.f455860b;
        int r116 = r114[0];
        StringBuilder r101 = new StringBuilder("");
        r111.getClass();
        r101.append(r111.f455603a + "," + r111.f455604b + "," + r111.f455605c + "," + r111.f455606d + "," + r111.f455607e + "," + r111.f455608f + "," + r111.f455609g + "," + r111.f455610h + "," + r111.f455611i + "," + r111.f455612j + "," + r111.f455613k + "," + r111.f455614l + "," + r111.f455615m + "," + r111.f455616n + "," + r111.f455617o + "," + r111.f455618p + "," + r111.f455619q + "," + r111.f455620r + "," + r111.f455621s + "," + r111.f455622t + "," + r111.f455623u + "," + r111.f455624v);
        r115.setFilterParam(r116, "equalizer_params", r101.toString());
        return r114[0];
    }

    public int addLoudnessFilter(int r110, float r111, int r112, int r113) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r114 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio loudness"}, new int[]{r112}, new int[]{r113}, new int[]{1}, new int[]{1});
        r100.f455860b.setFilterParam(r114[0], "audio_loudness_volume", String.valueOf(r111));
        return r114[0];
    }

    public int addReverb(int r110, String r111, int r112, int r113) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r114 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio reverb"}, new int[]{r112}, new int[]{r113}, new int[]{1}, new int[]{1});
        r100.f455860b.setFilterParam(r114[0], "reverb_params", r111);
        return r114[0];
    }

    public int addReverb2(int r100, v0 r110, int r111, int r112) {
        int[] r101 = ((k0) this.mWrapperFilter).f455860b.addFilters(new int[]{r100}, new String[]{"audio reverb2"}, new int[]{r111}, new int[]{r112}, new int[]{1}, new int[]{1});
        VELogUtil.w("VEEditor_VEFilterInvoker", "addReverb2..." + r101[0]);
        int r102 = r101[0];
        throw null;
    }

    public int beginGenVideoFrames(int r100, int r101, boolean r102, VEListener.VEBeginVideoFrameListener r103) {
        return this.mWrapperBingo.c();
    }

    public void changeMvUserVideoInfo(int r100, int[] r101, VEClipTimelineParam[] r102, VEClipSourceParam[] r103) {
        dic.d r104 = this.mWrapperMV;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.x() == false) goto L9;
        this.mWrapperMV.e();
        return;
    }

    public boolean compile(String r100, String r101, VEVideoEncodeSettings r102, VEListener.VEEditorCompileListener r103) throws VEException {
        this.mCompileListener = r103;
        boolean r104 = _compile(r100, r101, r102, VEAudioEncodeSettings.DEFAULT);
        if (r104 == true) goto L5;
        this.mCompileListener = null;
    L5:
        return r104;
    }

    public int enableAudioEffect(int r100, int r101, int r102, VEAudioEffectBean r103) {
        return ((k0) this.mWrapperFilter).d(r100, r101, r102, r103);
    }

    public String getClipFileInfoStringWithPath(int r100, int r101, int r102, String r110) {
        w0 r103 = (w0) this.mWrapperSequence;
        VEEditor r104 = r103.f455940a;
        monitor-enter(r104);
        VELogUtil.i("VEEditor_VESequenceInvoker", "getClipFileInfoStringWithPath... " + r100 + ", " + r101 + ", " + r102);     // Catch: Throwable -> L7
        String r105 = r103.f455941b.getClipInfoStringWithPath(r100, r101, r102, r110);     // Catch: Throwable -> L7
        StringBuilder r106 = new StringBuilder("getClipInfoStringWithPath result ");     // Catch: Throwable -> L7
        r106.append(r105);     // Catch: Throwable -> L7
        VELogUtil.i("VEEditor_VESequenceInvoker", r106.toString());     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return r105;
    L7:
        th = move-exception;
        throw th;
    }

    public int init(String[] r110, String[] r111, String[] r112, VIDEO_RATIO r210) throws VEException {
        monitor-enter(this);
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L42
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L42
        this.mlLastTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L42
        this.mlInitTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L42
        VELogUtil.i(TAG, "init...");     // Catch: Throwable -> L42
        if (this.mResManager != null) goto L11;
        VELogUtil.e(TAG, "init mResManager is null");     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L42
        return -112;
    L11:
        VELogUtil.i(TAG, "disable file info cache");     // Catch: Throwable -> L42
        int r100 = this.mVideoEditor.initVideoEditor(this.mResManager.getWorkspace(), r110, r112, r111, null, r210.ordinal());     // Catch: Throwable -> L42
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L42
        if (r110 != null) goto L45;
        String r102 = "";
    L16:
        r101.put("videoFilePaths", r102);     // Catch: JSONException -> L22 Throwable -> L42
        if (r112 == null) goto L19;
        String r103 = Arrays.toString(r112);     // Catch: JSONException -> L22 Throwable -> L42
    L20:
        r101.put("audioFilePaths", r103);     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("vTrimIn", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("vTrimOut", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("aTrimIn", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("aTrimOut", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("videoSpeed", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("audioSpeed", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("rotate", "");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("videoOutRes", r210.name());     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("cacheCheckTime", "0");     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("createSceneTime", "" + (System.currentTimeMillis() - this.mlInitTimeMS));     // Catch: JSONException -> L22 Throwable -> L42
        StringBuilder r104 = new StringBuilder("");     // Catch: JSONException -> L22 Throwable -> L42
        int r105 = this.miCacheHitCount;     // Catch: JSONException -> L22 Throwable -> L42
        r104.append(((double) r105) / ((double) (this.miCacheMissCount + r105)));     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("hitRate", r104.toString());     // Catch: JSONException -> L22 Throwable -> L42
        r101.put("resultCode", r100);     // Catch: JSONException -> L22 Throwable -> L42
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_init_video", r101, "business");     // Catch: JSONException -> L22 Throwable -> L42
        VELogUtil.d(TAG, "file info cache json: " + r101.toString());     // Catch: JSONException -> L22 Throwable -> L42
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L42
    L25:
        if (r100 == 0) goto L29;
        VELogUtil.e(TAG, "initVideoEditor failed, ret = " + r100);     // Catch: Throwable -> L42
        onMonitorError();     // Catch: Throwable -> L42
        this.mInitSuccess = false;     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L42
        return r100;
    L29:
        this.mInitSuccess = true;     // Catch: Throwable -> L42
        VEEditorResManager r106 = this.mResManager;     // Catch: Throwable -> L42
        r106.mReverseDone = false;     // Catch: Throwable -> L42
        this.mVideoOutRes = r210;     // Catch: Throwable -> L42
        r106.mAudioPaths = r112;     // Catch: Throwable -> L42
        r106.mVideoPaths = r110;     // Catch: Throwable -> L42
        r106.mTransitions = r111;     // Catch: Throwable -> L42
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L42
        if (r112 != null) goto L32;
    L34:
        boolean r107 = false;
    L35:
        Boolean r108 = Boolean.valueOf(r107);     // Catch: Throwable -> L42
        this.mbSeparateAV = r108;     // Catch: Throwable -> L42
        if (r108.booleanValue() == false) goto L38;
        this.mResManager.mOriginalSoundTrackType = 1;     // Catch: Throwable -> L42
    L39:
        this.mResManager.mOriginalSoundTrackIndex = 0;     // Catch: Throwable -> L42
        this.mMasterTrackIndex = 0;     // Catch: Throwable -> L42
        ((k0) this.mWrapperFilter).f();     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L42
        return 0;
    L38:
        this.mResManager.mOriginalSoundTrackType = 0;     // Catch: Throwable -> L42
        goto L39
    L32:
        if (r112.length == 0) goto L34;
        r107 = true;
        goto L35
    L19:
        r103 = "";
        goto L20
    L45:
        r102 = Arrays.toString(r110);     // Catch: JSONException -> L22 Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public int initOnlyAudio(String[] r100, int[] r101, int[] r110, float[] r111) throws VEException {
        monitor-enter(this);
        this.mlLastTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L18
        this.mlInitTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L18
        VELogUtil.i(TAG, "initOnlyAudio...");     // Catch: Throwable -> L18
        VEEditorResManager r102 = this.mResManager;     // Catch: Throwable -> L18
        if (r102 != null) goto L10;
        VELogUtil.e(TAG, "init mResManager is null");     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return -112;
    L10:
        int r103 = this.mVideoEditor.initAudioEditor(r102.getWorkspace(), r100, r101, r110, r111);     // Catch: Throwable -> L18
        if (r103 == 0) goto L15;
        VELogUtil.e(TAG, "initAudioEditor failed, ret = " + r103);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r103;
    L15:
        this.mInitSuccess = true;     // Catch: Throwable -> L18
        VEEditorResManager r112 = this.mResManager;     // Catch: Throwable -> L18
        r112.mReverseDone = false;     // Catch: Throwable -> L18
        r112.mAudioPaths = r100;     // Catch: Throwable -> L18
        r112.mVideoPaths = null;     // Catch: Throwable -> L18
        r112.mTransitions = null;     // Catch: Throwable -> L18
        this.mVideoOutRes = null;     // Catch: Throwable -> L18
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L18
        this.mbSeparateAV = Boolean.TRUE;     // Catch: Throwable -> L18
        r112.mOriginalSoundTrackType = 1;     // Catch: Throwable -> L18
        r112.mOriginalSoundTrackIndex = 0;     // Catch: Throwable -> L18
        this.mMasterTrackIndex = 0;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return 0;
    L18:
        th = move-exception;
        throw th;
    }

    public int initWithStruct(VECommonClipParam[] r110, VECommonClipParam[] r111, String[] r112, VIDEO_RATIO r210) {
        monitor-enter(this);
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L66
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L66
        this.mlLastTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L66
        this.mlInitTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L66
        StringBuilder r100 = new StringBuilder("initWithStruct, videoClipArray size: ");     // Catch: Throwable -> L66
        if (r110 != null) goto L8;
        int r101 = 0;
    L9:
        r100.append(r101);     // Catch: Throwable -> L66
        r100.append(", audioClipArray size: ");     // Catch: Throwable -> L66
        if (r111 != null) goto L12;
        int r102 = 0;
    L13:
        r100.append(r102);     // Catch: Throwable -> L66
        VELogUtil.i(TAG, r100.toString());     // Catch: Throwable -> L66
        int r103 = this.mVideoEditor.initVideoEditorWithStruct(r110, r111, r112, r210.ordinal());     // Catch: Throwable -> L66
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L66
        if (r110 != null) goto L70;
    L25:
        r104.put("videoFilePaths", "");     // Catch: JSONException -> L42 Throwable -> L66
        r104.put("vTrimIn", "");     // Catch: JSONException -> L42 Throwable -> L66
        r104.put("vTrimOut", "");     // Catch: JSONException -> L42 Throwable -> L66
        r104.put("videoSpeed", "");     // Catch: JSONException -> L42 Throwable -> L66
        r104.put("rotate", "");     // Catch: JSONException -> L42 Throwable -> L66
        String[] r113 = null;
    L27:
        if (r111 != null) goto L29;
    L38:
        r104.put("audioFilePaths", "");     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("aTrimIn", "");     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("aTrimOut", "");     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("audioSpeed", "");     // Catch: JSONException -> L23 Throwable -> L66
        String[] r105 = null;
    L40:
        r104.put("videoOutRes", r210.name());     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("cacheCheckTime", "");     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("createSceneTime", "" + (System.currentTimeMillis() - this.mlInitTimeMS));     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("hitRate", "");     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("resultCode", r103);     // Catch: JSONException -> L36 Throwable -> L66
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_init_video", r104, "business");     // Catch: JSONException -> L36 Throwable -> L66
        VELogUtil.d(TAG, "file info cache json: " + r104.toString());     // Catch: JSONException -> L36 Throwable -> L66
    L46:
        if (r103 == 0) goto L50;
        VELogUtil.e(TAG, "initVideoEditorWithStruct failed, ret = " + r103);     // Catch: Throwable -> L66
        onMonitorError();     // Catch: Throwable -> L66
        this.mInitSuccess = false;     // Catch: Throwable -> L66
        monitor-exit(this);     // Catch: Throwable -> L66
        return r103;
    L50:
        this.mInitSuccess = true;     // Catch: Throwable -> L66
        TETrackIndexManager r106 = this.mTrackIndexManager;     // Catch: Throwable -> L66
        if (r106 == null) goto L53;
        r106.d();     // Catch: Throwable -> L66
    L53:
        VEEditorResManager r107 = this.mResManager;     // Catch: Throwable -> L66
        r107.mReverseDone = false;     // Catch: Throwable -> L66
        this.mVideoOutRes = r210;     // Catch: Throwable -> L66
        r107.mAudioPaths = r105;     // Catch: Throwable -> L66
        r107.mVideoPaths = r113;     // Catch: Throwable -> L66
        r107.mTransitions = r112;     // Catch: Throwable -> L66
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L66
        if (r105 != null) goto L56;
    L58:
        boolean r108 = false;
    L59:
        Boolean r109 = Boolean.valueOf(r108);     // Catch: Throwable -> L66
        this.mbSeparateAV = r109;     // Catch: Throwable -> L66
        if (r109.booleanValue() == false) goto L62;
        this.mResManager.mOriginalSoundTrackType = 1;     // Catch: Throwable -> L66
        int r114 = 0;
    L63:
        this.mResManager.mOriginalSoundTrackIndex = r114;     // Catch: Throwable -> L66
        this.mMasterTrackIndex = r114;     // Catch: Throwable -> L66
        ((k0) this.mWrapperFilter).f();     // Catch: Throwable -> L66
        monitor-exit(this);     // Catch: Throwable -> L66
        return r114;
    L62:
        r114 = 0;
        this.mResManager.mOriginalSoundTrackType = 0;     // Catch: Throwable -> L66
        goto L63
    L56:
        if (r105.length == 0) goto L58;
        r108 = true;
    L36:
        e = e;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L46
    L29:
        if (r111.length <= 0) goto L38;
        int r115 = r111.length;     // Catch: JSONException -> L23 Throwable -> L66
        r105 = new String[r115];     // Catch: JSONException -> L23 Throwable -> L66
        int[] r116 = new int[r115];     // Catch: JSONException -> L36 Throwable -> L66
        int[] r117 = new int[r115];     // Catch: JSONException -> L36 Throwable -> L66
        double[] r118 = new double[r115];     // Catch: JSONException -> L36 Throwable -> L66
        int r119 = 0;
    L32:
        if (r119 >= r115) goto L34;
        r105[r119] = r111[r119].path;     // Catch: JSONException -> L36 Throwable -> L66
        VECommonClipParam r120 = r111[r119];     // Catch: JSONException -> L36 Throwable -> L66
        r116[r119] = r120.trimIn;     // Catch: JSONException -> L36 Throwable -> L66
        r117[r119] = r120.trimOut;     // Catch: JSONException -> L36 Throwable -> L66
        r118[r119] = r120.speed;     // Catch: JSONException -> L36 Throwable -> L66
        r119 = r119 + 1;     // Catch: JSONException -> L36 Throwable -> L66
        goto L32
    L34:
        r104.put("audioFilePaths", Arrays.toString(r105));     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("aTrimIn", Arrays.toString(r116));     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("aTrimOut", Arrays.toString(r117));     // Catch: JSONException -> L36 Throwable -> L66
        r104.put("audioSpeed", Arrays.toString(r118));     // Catch: JSONException -> L36 Throwable -> L66
    L42:
        e = e;
        r113 = null;
    L44:
        r105 = null;
        goto L45
    L70:
        if (r110.length <= 0) goto L25;
        int r121 = r110.length;     // Catch: JSONException -> L42 Throwable -> L66
        r113 = new String[r121];     // Catch: JSONException -> L42 Throwable -> L66
        int[] r122 = new int[r121];     // Catch: JSONException -> L23 Throwable -> L66
        int[] r123 = new int[r121];     // Catch: JSONException -> L23 Throwable -> L66
        double[] r124 = new double[r121];     // Catch: JSONException -> L23 Throwable -> L66
        int[] r125 = new int[r121];     // Catch: JSONException -> L23 Throwable -> L66
        int r126 = 0;
    L19:
        if (r126 >= r121) goto L21;
        r113[r126] = r110[r126].path;     // Catch: JSONException -> L23 Throwable -> L66
        VECommonClipParam r127 = r110[r126];     // Catch: JSONException -> L23 Throwable -> L66
        r122[r126] = r127.trimIn;     // Catch: JSONException -> L23 Throwable -> L66
        r123[r126] = r127.trimOut;     // Catch: JSONException -> L23 Throwable -> L66
        r124[r126] = r127.speed;     // Catch: JSONException -> L23 Throwable -> L66
        r125[r126] = r127.videoClipRotate;     // Catch: JSONException -> L23 Throwable -> L66
        r126 = r126 + 1;     // Catch: JSONException -> L23 Throwable -> L66
        goto L19
    L21:
        r104.put("videoFilePaths", Arrays.toString(r113));     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("vTrimIn", Arrays.toString(r122));     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("vTrimOut", Arrays.toString(r123));     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("videoSpeed", Arrays.toString(r124));     // Catch: JSONException -> L23 Throwable -> L66
        r104.put("rotate", Arrays.toString(r125));     // Catch: JSONException -> L23 Throwable -> L66
    L23:
        e = e;
        goto L44
    L12:
        r102 = r111.length;     // Catch: Throwable -> L66
        goto L13
    L8:
        r101 = r110.length;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;
    }

    public int insertClip(int r110, int r111, VEClipSourceParam r112, VEClipTimelineParam r113) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        VELogUtil.i("VEEditor_VESequenceInvoker", "insertClip, trackType:" + r110 + "clipIndex:" + r111);     // Catch: Throwable -> L20
        r100.f455941b.stop();     // Catch: Throwable -> L20
        int r102 = r100.f455941b.insertClip(r110, 0, r111, r112, r113);     // Catch: Throwable -> L20
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("trackType", r110);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("clipIndex", r111);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("clipFilePath", r112.clipFilePath);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("sourceType", r112.sourceType);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("clipHeight", r112.clipHeight);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("clipWidth", r112.clipWidth);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("trimIn", r113.trimIn);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("trimOut", r113.trimOut);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("speed", r113.speed);     // Catch: JSONException -> L7 Throwable -> L20
        r103.put("resultCode", r102);     // Catch: JSONException -> L7 Throwable -> L20
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_clip_insert", r103, "business");     // Catch: JSONException -> L7 Throwable -> L20
    L9:
        if (r102 >= 0) goto L13;
        VELogUtil.e("VEEditor_VESequenceInvoker", "insertClip failed, ret = " + r102);     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r102;
    L13:
        r100.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L20
        TEInterface r114 = r100.f455941b;     // Catch: Throwable -> L20
        r114.setTimeRange(0, r114.getDuration(), 1);     // Catch: Throwable -> L20
        int r115 = r100.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L20
        if (r115 == 0) goto L18;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r115);     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r115;
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public int insertClips(int r110, int r111, ArrayList<VEClipSourceParam> r112, ArrayList<VEClipTimelineParam> r113) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        VELogUtil.w("VEEditor_VESequenceInvoker", "insertClip, trackType:" + r110 + "clipIndex:" + r111);     // Catch: Throwable -> L28
        int r102 = 0;
    L6:
        if (r102 >= r112.size()) goto L8;
        VELogUtil.w("VEEditor_VESequenceInvoker", "index: " + r102 + "clipSourceParams: " + r112.get(r102).toString());     // Catch: Throwable -> L28
        r102 = r102 + 1;     // Catch: Throwable -> L28
        goto L6
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r113.size()) goto L12;
        VELogUtil.w("VEEditor_VESequenceInvoker", "index: " + r103 + "clipTimelineParams: " + r113.get(r103).toString());     // Catch: Throwable -> L28
        r103 = r103 + 1;     // Catch: Throwable -> L28
        goto L10
    L12:
        r100.f455941b.stop();     // Catch: Throwable -> L28
        int r104 = 0;
    L14:
        if (r104 >= r112.size()) goto L21;
        int r105 = r100.f455941b.insertClip(r110, 0, r111, r112.get(r104), r113.get(r104));     // Catch: Throwable -> L28
        if (r105 < 0) goto L17;
        r111 = r111 + 1;     // Catch: Throwable -> L28
        r104 = r104 + 1;     // Catch: Throwable -> L28
        goto L14
    L17:
        VELogUtil.e("VEEditor_VESequenceInvoker", "insertClip failed, ret = " + r105);     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        return r105;
    L21:
        r100.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L28
        TEInterface r114 = r100.f455941b;     // Catch: Throwable -> L28
        r114.setTimeRange(0, r114.getDuration(), 1);     // Catch: Throwable -> L28
        int r115 = r100.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L28
        if (r115 == 0) goto L26;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r115);     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        return r115;
    L26:
        monitor-exit(r101);     // Catch: Throwable -> L28
        return 0;
    L28:
        th = move-exception;
        throw th;
    }

    public int moveClip(int r100, int r101, int r110, boolean r111) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.w("VEEditor_VESequenceInvoker", "moveClip, trackType:" + r100 + " from:" + r101 + " to:" + r110 + " isMoveEffect:" + r111);     // Catch: Throwable -> L17
        r102.f455941b.stop();     // Catch: Throwable -> L17
        int r104 = r102.f455941b.moveClip(r100, r101, r110, r111);     // Catch: Throwable -> L17
        if (r104 >= 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "moveClip failed, ret = " + r104);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return r104;
    L9:
        r102.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L17
        int r105 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L17
        if (r105 == 0) goto L14;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r105);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return r105;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L17
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public int replaceClip(int r100, int r101, VEClipSourceParam r110, VEClipTimelineParam r111) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "replaceClip, trackType:" + r100 + "clipIndex:" + r101);     // Catch: Throwable -> L17
        r102.f455941b.stop();     // Catch: Throwable -> L17
        int r104 = r102.f455941b.replaceClip(r100, r101, r110, r111);     // Catch: Throwable -> L17
        if (r104 >= 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "replaceClip failed, ret = " + r104);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return r104;
    L9:
        r102.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L17
        TEInterface r105 = r102.f455941b;     // Catch: Throwable -> L17
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L17
        int r106 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L17
        if (r106 == 0) goto L14;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return r106;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L17
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public int seekWithSpeed(int r100, SEEK_MODE r101, float r102, float r110) {
        monitor-enter(this);
        VELogUtil.w(TAG, "seekWithSpeed... " + r100 + " flags " + r101 + " durationSpeed " + r102 + " pxSpeed " + r110);     // Catch: Throwable -> L13
        if ((r101.getValue() & SEEK_MODE.EDITOR_SEEK_FLAG_LastSeek.getValue()) == 0) goto L7;
        this.mSeekListener = null;     // Catch: Throwable -> L13
    L7:
        if (r100 <= 0) goto L9;
        int r103 = calSeekToleranceBySpeed(r102, r110);     // Catch: Throwable -> L13
    L10:
        int r104 = this.mVideoEditor.seekWithTolerance(r100, this.mSurfaceWidth, this.mSurfaceHeight, r101.getValue(), r103);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r104;
    L9:
        r103 = 10;
    L13:
        th = move-exception;
        throw th;
    }

    public int setClipReservePitch(int r110, int r111, int r112, boolean r113) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        VELogUtil.i("VEEditor_VESequenceInvoker", "setClipReservePitch " + r110 + ", " + r111 + ", " + r112 + ", " + r113);     // Catch: Throwable -> L11
        TEInterface r102 = r100.f455941b;     // Catch: Throwable -> L11
        if (r113 == false) goto L7;
        String r114 = "1.0";
    L8:
        int r115 = r102.setClipAttr(r110, r111, r112, "audio reserve pitch", r114);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r115;
    L7:
        r114 = GLUtils.VERSION_UNKNOWN;
    L11:
        th = move-exception;
        throw th;
    }

    public int setColorFilter(String r100, String r101, float r110, float r111) {
        return ((k0) this.mWrapperFilter).i(r100, r101, r110, r111, false);
    }

    public void setCompileAudioDriver(String r100, int r101, int r102, String r103) {
        VELogUtil.i(TAG, "VEEditor-setCompileAudioDriver, path = " + r100 + ", trimIn = " + r101 + ", trimOut = " + r102);
        this.mVideoEditor.setCompileAudioDriver(r100, r101, r102, r103);
    }

    public void setCrop(int r100, int r101, int r102, int r103) {
        fic.a r104 = new fic.a();
        r104.b("iesve_veeditor_cut_scale", r103 / r102);
        com.ss.android.ttve.monitor.g.b(r104);
        this.mVideoEditor.setCrop(r100, r101, r102, r103);
    }

    public void setDisplayPos(int r100, int r110, int r111, int r112) {
        VELogUtil.i(TAG, "setDisplayPos... " + r100 + " " + r110 + " " + r111 + " " + r112);
        setDisplayState(((float) r111) / ((float) this.mInitDisplayWidth), ((float) r112) / ((float) this.mInitDisplayHeight), 0.0f, -(((this.mSurfaceWidth / 2) - (r111 / 2)) - r100), ((this.mSurfaceHeight / 2) - (r112 / 2)) - r110);
    }

    public int setExternalAlgorithmResult(String r100, String r101, String r102, VEMVAlgorithmConfig.MV_REESULT_IN_TYPE r103) {
        dic.d r104 = this.mWrapperMV;
        if (r104 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r104.y();
    }

    public void setImageResizeInfo(int r100, int r101, int r102, int r103) {
        VELogUtil.i(TAG, "setImageResizeInfo... width:" + r100 + ", height:" + r101 + ", resfillmode:" + r102 + ", resizeAlgro" + r103);
        this.mVideoEditor.setImageResizeinfo(r100, r101, r102, r103);
    }

    public int setKeyFrameParam(int r100, int r101, int r102, String r103) {
        monitor-enter(this);
        int r104 = this.mVideoEditor.setKeyFrameParam(r100, r101, r102, r103);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r104;
    L6:
        th = move-exception;
        throw th;
    }

    public int setMusicAndResult(String r100, int r101, int r102, VEAlgorithmPath r103) {
        return this.mWrapperBingo.b();
    }

    public int updateAudioTrack(int r110, int r111, int r112, boolean r113) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        VELogUtil.w("VEEditor_VESequenceInvoker", "updateAudioTrack...  Index " + r110 + " In " + r111 + " Out " + r112 + " " + r113);     // Catch: Throwable -> L16
        int r102 = -100;
        if (r110 >= 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L16
    L15:
        return r102;
    L8:
        if (r112 <= r111) goto L14;
        if (r111 < 0) goto L14;
        r102 = r100.f455941b.updateAudioTrack(r100.f455940a.getTrackIndexManager().b(1, r110), 0, r112 - r111, r111, r112, r113, false);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public int updateClipFilterTime(int r100, int r101, int r102, int r103) {
        k0 r104 = (k0) this.mWrapperFilter;
        r104.getClass();
        VELogUtil.d("VEEditor_VEFilterInvoker", "updateClipFilterTime, filterIndex: " + r100 + "clipIndex: " + r101 + ", startTime: " + r102 + ", endTime: " + r103);
        return r104.f455860b.updateFilterTime(r101, r100, r102, r103);
    }

    public int updateClipSourceParam(int r100, int r101, int[] r110, VEClipSourceParam[] r111) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        VELogUtil.i("VEEditor_VESequenceInvoker", "updateClipSourceParam, trackType:" + r100 + " trackIndex:" + r101);     // Catch: Throwable -> L28
        r102.f455940a.changeMvUserVideoInfo(r101, r110, null, r111);     // Catch: Throwable -> L28
        if (r110.length == r111.length) goto L7;
    L24:
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateClipSourceParam failed, clipIndexes not match clipSourceParams");     // Catch: Throwable -> L28
        monitor-exit(r103);     // Catch: Throwable -> L28
        return -100;
    L7:
        if (r110.length <= 0) goto L24;
        r102.f455941b.stop();     // Catch: Throwable -> L28
        if (r100 != 1) goto L12;
        r101 = r102.f455940a.getTrackIndexManager().b(1, r101);     // Catch: Throwable -> L28
    L14:
        int r104 = r102.f455941b.updateClipsSourceParam(r100, r101, r110, r111);     // Catch: Throwable -> L28
        if (r104 >= 0) goto L17;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateClipSourceParam failed, ret = " + r104);     // Catch: Throwable -> L28
    L17:
        r102.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L28
        TEInterface r105 = r102.f455941b;     // Catch: Throwable -> L28
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L28
        int r106 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L28
        if (r106 == 0) goto L22;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L28
        monitor-exit(r103);     // Catch: Throwable -> L28
        return r106;
    L22:
        monitor-exit(r103);     // Catch: Throwable -> L28
        return 0;
    L12:
        if (r100 != 0) goto L14;
        r101 = r102.f455940a.getTrackIndexManager().b(2, r101);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public int updateClipsTimelineParam(int r100, int r101, int[] r110, VEClipTimelineParam[] r111) {
        w0 r102 = (w0) this.mWrapperSequence;
        VEEditor r103 = r102.f455940a;
        monitor-enter(r103);
        r102.f455940a.changeMvUserVideoInfo(r101, r110, r111, null);     // Catch: Throwable -> L40
        VELogUtil.i("VEEditor_VESequenceInvoker", "updateClipsTimelineParam, trackType:" + r100 + " trackIndex:" + r101);     // Catch: Throwable -> L40
        if (r110.length == r111.length) goto L7;
    L37:
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateClipsTimelineParam failed, clipIndexes not match clipTimelineParams");     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        return -100;
    L7:
        if (r110.length <= 0) goto L37;
        int r104 = 0;
    L11:
        if (r104 >= r111.length) goto L20;
        VEClipTimelineParam r105 = r111[r104];     // Catch: Throwable -> L40
        int r106 = r105.trimOut;     // Catch: Throwable -> L40
        if (r106 < 0) goto L19;
        if (r106 > r105.trimIn) goto L19;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateClipsTimelineParam invalid param trimIn[" + r104 + "]=" + r111[r104].trimIn + ", trimOut[" + r104 + "]=" + r111[r104].trimOut);     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        return -100;
    L19:
        r104 = r104 + 1;     // Catch: Throwable -> L40
        goto L11
    L20:
        r102.f455941b.stop();     // Catch: Throwable -> L40
        if (r100 != 1) goto L23;
        r101 = r102.f455940a.getTrackIndexManager().b(1, r101);     // Catch: Throwable -> L40
    L25:
        int r107 = r102.f455941b.updateClipsTimelineParam(r100, r101, r110, r111);     // Catch: Throwable -> L40
        if (r107 >= 0) goto L30;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateClipsTimelineParam failed, ret = " + r107);     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        return r107;
    L30:
        r102.f455940a.setMasterTrackIndex(0);     // Catch: Throwable -> L40
        TEInterface r108 = r102.f455941b;     // Catch: Throwable -> L40
        r108.setTimeRange(0, r108.getDuration(), 1);     // Catch: Throwable -> L40
        int r109 = r102.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L40
        if (r109 == 0) goto L35;
        VELogUtil.e("VEEditor_VESequenceInvoker", "Prepare Engine failed, ret = " + r109);     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        return r109;
    L35:
        monitor-exit(r103);     // Catch: Throwable -> L40
        return 0;
    L23:
        if (r100 != 0) goto L25;
        r101 = r102.f455940a.getTrackIndexManager().b(2, r101);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    public int updateMultiComposerNodes(int r100, String[] r101, String[] r102, float[] r103) {
        k0 r104 = (k0) this.mWrapperFilter;
        VEEditor r105 = r104.f455859a;
        monitor-enter(r105);
        if (r100 != 0) goto L21;
    L15:
        monitor-exit(r105);     // Catch: Throwable -> L18
        return -100;
    L21:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r101.length != r102.length) goto L15;
        if (r102.length != r103.length) goto L15;
        int r106 = r104.f455860b.updateMultiComposerNodes(r100, r101, r102, r103);     // Catch: Throwable -> L18
        if (r106 == 0) goto L13;
        VELogUtil.e("VEEditor_VEFilterInvoker", "updateMultiComposerNodes failed, ret = " + r106);     // Catch: Throwable -> L18
    L13:
        monitor-exit(r105);     // Catch: Throwable -> L18
        return r106;
    }

    public void updatePreViewResolution(int r100, int r101, int r102, int r103) {
        this.mVideoEditor.updateResolution(r100, r101, r102, r103);
    }

    public int setColorFilter(String r100, float r101, boolean r102, boolean r103) {
        return ((k0) this.mWrapperFilter).h(r100, r101, r102, r103);
    }

    public static VEEditor genReverseVideo(VEEditorResManager r100, VETimelineParams r101, int r102, int r110, VEListener.VEEditorGenReverseListener r111) {
        return genReverseVideo(r100, r101, -1, -1, r102, r110, r111);
    }

    public static VEEditor genReverseVideo2(VEEditorResManager r100, VERecordData r101, int r110, int r111, VEListener.VEEditorGenReverseListener r112) {
        VELogUtil.w(TAG, "genReverseVideo2 with recordData.");
        if (r101.getSegmentData() != null) goto L5;
    L7:
        VEVideoEncodeSettings r113 = new VEVideoEncodeSettings.Builder(2).setVideoRes(r110, r111).setFps(30).setSupportHwEnc(false).setSWCRF(13).setGopSize(1).setWatermarkParam(null).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_BASELINE).setEncodePreset(VEVideoEncodeSettings.ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST).setEnableRemuxVideo(false, false).build();
    L8:
        VEEditor r114 = new VEEditor(r100.getWorkspace());
        int r102 = r114.init(r101, false, false);
        if (r102 == 0) goto L13;
        VELogUtil.e(TAG, "genReverseVideo2 init error:" + r102);
        return null;
    L13:
        return genReverseVideoWithEditor(r114, r100, r113, true, r112);
    L5:
        if (r101.getSegmentData().size() <= 1) goto L7;
        r113 = new VEVideoEncodeSettings.Builder(2).setVideoRes(r110, r111).setResizeMode(1).setFps(30).setSupportHwEnc(false).setSWCRF(13).setGopSize(1).setWatermarkParam(null).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_BASELINE).setEncodePreset(VEVideoEncodeSettings.ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST).setEnableRemuxVideo(false, false).build();
        goto L8
    }

    private static VEEditor genReverseVideoWithEditor(VEEditor r110, VEEditorResManager r111, VEVideoEncodeSettings r112, boolean r210, VEListener.VEEditorGenReverseListener r211) {
        System.currentTimeMillis();
        cancelCompileProbe();
        TEReverseCallback r100 = new TEReverseCallback();
        r100.setListener(r211);
        r111.mReverseDone = false;
        if (r112 != null) goto L5;
        VELogUtil.w(TAG, "using default video setting for genReverseVideo2");
        VEVideoEncodeSettings r113 = new VEVideoEncodeSettings.Builder(2).setVideoRes(-1, -1).setResizeMode(1).setFps(30).setSupportHwEnc(false).setSWCRF(13).setGopSize(1).setWatermarkParam(null).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_BASELINE).setEncodePreset(VEVideoEncodeSettings.ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST).build();
    L6:
        genReverseCount++;
        r111.clearReverseCacheFiles();
        String r101 = r111.genReverseVideoPath(genReverseCount + "-0");
        String r102 = r111.genReverseVideoPath(genReverseCount + "-1");
        String r103 = r111.genSeqAudioPath(genReverseCount + "-0");
        r110.setOnInfoListener(new c(r110, r210, r101, r102, r100, r103, r111, r211));
        r110.setOnErrorListener(new d(r110, r211));
        if (r113.isEnableHdr10BitEncode() == false) goto L9;
    L11:
        r110.compile(r101, r103, r113);
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L34
        r104.put("mWorkSpace", r111.getWorkspace());     // Catch: JSONException -> L34
        String[] r105 = r111.mVideoPaths;     // Catch: JSONException -> L34
        if (r105 == null) goto L15;
        String r106 = Arrays.toString(r105);     // Catch: JSONException -> L34
    L16:
        r104.put("mVideoPaths", r106);     // Catch: JSONException -> L34
        String[] r107 = r111.mAudioPaths;     // Catch: JSONException -> L34
        if (r107 == null) goto L19;
        String r108 = Arrays.toString(r107);     // Catch: JSONException -> L34
    L20:
        r104.put("mAudioPaths", r108);     // Catch: JSONException -> L34
        String[] r109 = r111.mTransitions;     // Catch: JSONException -> L34
        if (r109 == null) goto L23;
        String r114 = Arrays.toString(r109);     // Catch: JSONException -> L34
    L24:
        r104.put("mTransitions", r114);     // Catch: JSONException -> L34
        String[] r115 = r111.mReverseVideoPath;     // Catch: JSONException -> L34
        if (r115 == null) goto L27;
        String r116 = Arrays.toString(r115);     // Catch: JSONException -> L34
    L28:
        r104.put("mReverseVideoPath", r116);     // Catch: JSONException -> L34
        String[] r117 = r111.mReverseAudioPaths;     // Catch: JSONException -> L34
        if (r117 == null) goto L31;
        String r118 = Arrays.toString(r117);     // Catch: JSONException -> L34
    L32:
        r104.put("mReverseAudioPaths", r118);     // Catch: JSONException -> L34
        r104.put("resultCode", 0);     // Catch: JSONException -> L34
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_reverse_video", r104, "business");     // Catch: JSONException -> L34
    L36:
        return r110;
    L31:
        r118 = null;
        goto L32
    L27:
        r116 = null;
        goto L28
    L23:
        r114 = null;
        goto L24
    L19:
        r108 = null;
        goto L20
    L15:
        r106 = null;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L9:
        if (r110.mVideoEditor.getNativeHandler() == 0) goto L11;
        r110.mVideoEditor.setCompileColorTransferCharacteristic(1);
        goto L11
    L5:
        r113 = r112;
        goto L6
    }

    public int[] addAudioEffects(int r110, int r111, int[] r112, int[] r113, VEAudioEffectBean[] r114) {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        VELogUtil.w("VEEditor_VEFilterInvoker", "addAudioEffects...");
        int r101 = r112.length;
        int[] r102 = new int[r101];
        int[] r103 = new int[r101];
        int[] r104 = new int[r101];
        String[] r105 = new String[r101];
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r101) goto L5;
        r102[r107] = r110;
        r103[r107] = r111;
        r105[r107] = VEBaseAudioFilterParam.AUDIO_EFFECT_FILTER_NAME;
        r104[r107] = 1;
        r107 = r107 + 1;
        goto L3
    L5:
        int[] r115 = r100.f455860b.addFilters(r102, r105, r112, r113, r103, r104);
    L6:
        if (r106 >= r101) goto L8;
        r100.g(r115[r106], r114[r106]);
        r106 = r106 + 1;
        goto L6
    L8:
        return r115;
    }

    public int addEqualizer(int r110, int r111, int r112, int r113, int r114) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r115 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio equalizer"}, new int[]{r113}, new int[]{r114}, new int[]{r111}, new int[]{1});
        r100.f455860b.setFilterParam(r115[0], "preset_id", "" + r112);
        return r115[0];
    }

    public int addFFmpegPitchTempo(int r110, float r111, float r112, int r113, int r114) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r115 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio ffmpeg pitch tempo"}, new int[]{r113}, new int[]{r114}, new int[]{1}, new int[]{1});
        r100.f455860b.setFilterParam(r115[0], "pitch_scale", "" + r111);
        r100.f455860b.setFilterParam(r115[0], "time_ratio", "" + r112);
        return r115[0];
    }

    public int addImageSticker(String r100, float r101, float r102, float r103, float r104) {
        dic.f r105 = this.mWrapperSticker;
        if (r105 != null) goto L7;
        VELogUtil.e(TAG, "addImageSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r105.I();
    }

    public int addImageStickerWithRatio(String r100, float r101, float r102, float r103, float r104) {
        dic.f r105 = this.mWrapperSticker;
        if (r105 != null) goto L7;
        VELogUtil.e(TAG, "addImageStickerWithRatio STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r105.g();
    }

    public int addRepeatEffect(int r210, int r211, int r212, int r213, int r214) {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r110 = r100.f455859a;
        monitor-enter(r110);
        VELogUtil.w("VEEditor_VEFilterInvoker", "addRepeatEffect... " + r210 + " " + r211 + " " + r212 + " " + r213 + " " + r214);     // Catch: Throwable -> L23
        cancelCompileProbe();     // Catch: Throwable -> L23
        if (r100.f455860b.getCurState() == (-20000)) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == false) goto L10;
        int r112 = r100.f455860b.stop();     // Catch: Throwable -> L23
    L11:
        if (r112 != 0) goto L13;
    L17:
        int[] r101 = r100.f455860b.addFilters(new int[]{r210}, new String[]{"timeEffect repeating"}, new int[]{r212}, new int[]{r100.f455860b.getDuration()}, new int[]{r211}, new int[]{6});     // Catch: Throwable -> L23
        int r102 = r101[0];     // Catch: Throwable -> L23
        r100.f455865g = r102;     // Catch: Throwable -> L23
        r100.f455860b.setFilterParam(r102, VERepeatFilterParam.REPEAT_ATTR_DURATION, "" + r214);     // Catch: Throwable -> L23
        r100.f455860b.setFilterParam(r101[0], VERepeatFilterParam.REPEAT_ATTR_TIMES, "" + r213);     // Catch: Throwable -> L23
        if (r111 == false) goto L20;
        r100.f455860b.createTimeline();     // Catch: Throwable -> L23
        r100.f455860b.prepareEngine(0);     // Catch: Throwable -> L23
    L20:
        fic.a r103 = new fic.a();     // Catch: Throwable -> L23
        r103.c("iesve_veeditor_time_effect_id", SalesInfoStruct.REPEAT);     // Catch: Throwable -> L23
        com.ss.android.ttve.monitor.g.b(r103);     // Catch: Throwable -> L23
        r100.f455859a.getTEMonitorFilterMgr().getClass();     // Catch: Throwable -> L23
        int r104 = r101[0];     // Catch: Throwable -> L23
        monitor-exit(r110);     // Catch: Throwable -> L23
        return r104;
    L13:
        if (r112 == (-101)) goto L17;
        VELogUtil.e("VEEditor_VEFilterInvoker", "pauseSync failed in addRepeatEffect, ret " + r112);     // Catch: Throwable -> L23
        monitor-exit(r110);     // Catch: Throwable -> L23
        return -1;
    L10:
        r112 = 0;
        goto L11
    L7:
        r111 = false;
    L23:
        th = move-exception;
        throw th;
    }

    public int[] addSegmentVolume(int[] r110, int[] r111, int[] r112, int[] r113, float[] r114) {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        int r101 = r112.length;
        String[] r102 = new String[r101];
        int[] r103 = new int[r101];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r101) goto L5;
        r102[r105] = VEBaseAudioFilterParam.AUDIO_VOLUME_FILTER_NAME;
        r103[r105] = 1;
        r105 = r105 + 1;
        goto L3
    L5:
        VELogUtil.d("VEEditor_VESequenceInvoker", "addSegmentVolume " + Arrays.toString(r110) + "  trackTypes " + Arrays.toString(r111) + " volumes " + Arrays.toString(r114));
        int[] r115 = r100.f455941b.addFilters(r110, r102, r112, r113, r111, r103);
    L6:
        if (r104 >= r101) goto L8;
        r100.f455941b.setFilterParam(r115[r104], "audio volume", "" + r114[r104]);
        r104 = r104 + 1;
        goto L6
    L8:
        return r115;
    }

    public int addTrackFilter(int r100, int r101, VEBaseFilterParam r110, int r111, int r112) {
        return ((k0) this.mWrapperFilter).c(r100, r101, r110, r111, r112);
    }

    public int addWaterMark(String r110, double r111, double r112, double r210, double r211) {
        VELogUtil.w(TAG, "addWaterMark...");
        TEInterface r100 = this.mVideoEditor;
        return r100.addWaterMark(new String[]{r110}, null, new int[]{0}, new int[]{r100.getDuration()}, r210, r211, r111, r112);
    }

    public int addWaterMarkForGifHigh(String r100, double r101, double r102, double r103, double r104) {
        this.waterMarkFile = r100;
        this.waterMarkWidth = r101;
        this.waterMarkHeight = r102;
        this.waterMarkOffsetX = r103;
        this.waterMarkOffsetY = r104;
        return 0;
    }

    public boolean compile(String r100, String r101, VEVideoEncodeSettings r102, VEAudioEncodeSettings r103, VEListener.VEEditorCompileListener r104) throws VEException {
        this.mCompileListener = r104;
        return _compile(r100, r101, r102, r103);
    }

    public int enableFilterEffect(int r100, String r101, boolean r102, int r110, int r111) {
        return ((k0) this.mWrapperFilter).e(r100, r101, r110, r111, "");
    }

    public int enableFilterEffectWithTag(int r100, String r101, int r110, int r111, String r112) {
        return ((k0) this.mWrapperFilter).e(r100, r101, r110, r111, r112);
    }

    public int faceCoverLoad(int r100, String[] r101, int r102, String r110, boolean r111) {
        return this.mVideoEditor.faceCoverLoad(r100, r101, r102, r110, r111);
    }

    public int faceCoverSet(int r100, double r110, double r111, String r112, boolean r113) {
        return this.mVideoEditor.faceCoverSet(r100, r110, r111, r112, r113);
    }

    public int getCompileFirstFrame(Bitmap r100, int r110, int r111, VEGetCompileFirstFrameType r112, VEListener.a r113) {
        if (this.mIsDestroying.get() == false) goto L6;
        VELogUtil.w(TAG, "no need to getCompileFirstFrame, is destroying, just return");
        return -1;
    L6:
        VELogUtil.i(TAG, "getCompileFirstFrame bitmap = " + r100 + ", listener = " + r113);
        return this.mVideoEditor.getCompileFirstFrame(r100, r110, r111, r112.ordinal(), this.mGetCompileFirstFrameCallback);
    }

    public int getImages(int[] r100, int r101, int r110, GET_FRAMES_FLAGS r111, VEListener.VEGetImageListener r112) {
        return getImages(r100, r101, r110, false, r111, r112);
    }

    public int initMV(String r100, String[] r101, String[] r102, int[] r103, boolean r104) throws VEException {
        dic.d r105 = this.mWrapperMV;
        if (r105 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r105.w();
    }

    public int processPanEvent(float r100, float r101, float r110, float r111, float r112) {
        if (this.mSurfaceWidth != 0) goto L5;
        return -105;
    L5:
        if (this.mSurfaceHeight != 0) goto L8;
        return -105;
    L8:
        return this.mVideoEditor.processPanEvent(r100, r101, r110, r111, r112);
    }

    public int replaceComposerNodesWithTag(String[] r100, int r101, String[] r102, int r103, String[] r104) {
        k0 r105 = (k0) this.mWrapperFilter;
        VEEditor r106 = r105.f455859a;
        monitor-enter(r106);
        VEEffectParams r107 = new VEEffectParams();     // Catch: Throwable -> L7
        r107.TYPE = VEEffectParams.EFFECT_TYPE_REPLACE_COMPOSER_WITH_TAG;     // Catch: Throwable -> L7
        r107.intValueOne = r101;     // Catch: Throwable -> L7
        r107.intValueTwo = r103;     // Catch: Throwable -> L7
        r107.stringArrayOne = new ArrayList(Arrays.asList(r100));     // Catch: Throwable -> L7
        r107.stringArrayTwo = new ArrayList(Arrays.asList(r102));     // Catch: Throwable -> L7
        r107.stringArrayThree = new ArrayList(Arrays.asList(r104));     // Catch: Throwable -> L7
        VELogUtil.w("VEEditor_VEFilterInvoker", "replaceComposerNodes...");     // Catch: Throwable -> L7
        int r108 = r105.f455860b.setEffectParams(r107);     // Catch: Throwable -> L7
        monitor-exit(r106);     // Catch: Throwable -> L7
        return r108;
    L7:
        th = move-exception;
        throw th;
    }

    public int setColorFilter(String r100, String r101, float r110, float r111, boolean r112) {
        return ((k0) this.mWrapperFilter).i(r100, r101, r110, r111, r112);
    }

    public int setColorFilterNew(String r100, String r101, float r102, float r110, float r111) {
        k0 r103 = (k0) this.mWrapperFilter;
        r103.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "setColorFilterNew split...");
        if (r103.f455862d >= 0) goto L6;
        VELogUtil.e("VEEditor_VEFilterInvoker", "setColorFilterNew... mColorFilterIndex error.");
        return -105;
    L6:
        if (r102 >= 0.0f) goto L8;
    L54:
        VELogUtil.e("VEEditor_VEFilterInvoker", "setColorFilterNew... param error. position = " + r102);
        return -100;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L54;
        if (TextUtils.isEmpty(r101) == true) goto L54;
        cancelCompileProbe();
        if (r110 <= 1.0f) goto L16;
        r110 = 1.0f;
    L16:
        if (r111 <= 1.0f) goto L19;
        r111 = 1.0f;
    L19:
        if (r110 >= 0.0f) goto L22;
        r110 = -1.0f;
    L22:
        if (r111 >= 0.0f) goto L25;
        r111 = -1.0f;
    L25:
        if (r102 <= 1.0f) goto L28;
        r102 = 1.0f;
    L28:
        if (r103.f455867i != null) goto L31;
        r103.f455867i = new com.ss.android.ttve.model.c();
    L31:
        if (r100.equals(r103.f455867i.f449907a) == true) goto L33;
    L41:
        com.ss.android.ttve.model.c r104 = r103.f455867i;
        r104.f449907a = r100;
        r104.f449908b = r101;
        r104.f449909c = r102;
        r104.f449910d = r110;
        r104.f449911e = r111;
        r104.f449912f = false;
        VELogUtil.d("VEEditor_VEFilterInvoker", "leftFilterPath: " + r100 + "\nrightFilterPath: " + r101 + " position: " + r102 + "leftIntensity: " + r110 + "rightIntensity: " + r111);
        r103.f455860b.setFilterParam(r103.f455862d, "left filter", r100);
        r103.f455860b.setFilterParam(r103.f455862d, "right filter", r101);
        TEInterface r105 = r103.f455860b;
        int r106 = r103.f455862d;
        String r107 = "";
        StringBuilder r108 = new StringBuilder("");
        r108.append(r110);
        r105.setFilterParam(r106, "left filter intensity", r108.toString());
        r103.f455860b.setFilterParam(r103.f455862d, "right filter intensity", "" + r111);
        r103.f455860b.setFilterParam(r103.f455862d, "filter position", "" + r102);
        r103.f455860b.setFilterParam(r103.f455862d, "filter use v3", String.valueOf(true));
        fic.a r109 = new fic.a();
        if (TextUtils.isEmpty(r100) == true) goto L46;
        String[] r112 = r100.split(File.separator);
        if (r112.length <= 0) goto L46;
        String r113 = r112[r112.length - 1];
    L48:
        if (TextUtils.isEmpty(r101) == true) goto L52;
        String[] r114 = r101.split(File.separator);
        if (r114.length <= 0) goto L52;
        r107 = r114[r114.length - 1];
    L52:
        r109.c("iesve_veeditor_set_filter_slide_left_id", r113);
        r109.c("iesve_veeditor_set_filter_slide_right_id", r107);
        com.ss.android.ttve.monitor.g.b(r109);
    L53:
        return 0;
    L46:
        r113 = "";
        goto L48
    L33:
        if (r101.equals(r103.f455867i.f449908b) == false) goto L41;
        com.ss.android.ttve.model.c r115 = r103.f455867i;
        if (r115.f449910d != r110) goto L41;
        if (r115.f449911e != r111) goto L41;
        if (r115.f449909c != r102) goto L41;
        goto L41
    }

    public void setDisplayState(float r100, float r101, float r110, int r111, int r112) {
        setDisplayState(r100, r101, r110, r111, r112, 0);
    }

    public int setEffectInputText(int r100, String r101, int r102, int r103, String r104) {
        dic.f r105 = this.mWrapperSticker;
        if (r105 != null) goto L7;
        VELogUtil.e(TAG, "setEffectInputText STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r105.x0();
    }

    public int updateMVResources(String r100, String[] r101, String[] r102, int[] r103, boolean r104) {
        dic.d r105 = this.mWrapperMV;
        if (r105 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r105.t();
    }

    public static VEEditor genReverseVideo2(VEEditorResManager r110, VETimelineParams r111, VEVideoEncodeSettings r112, int r210, int r211, VEListener.VEEditorGenReverseListener r212) {
        VELogUtil.w(TAG, "genReverseVideo2 with param:startTime:" + r210 + "endTime:" + r211);
        float[] r113 = new float[r111.speed.length];
        int r100 = 0;
    L3:
        double[] r101 = r111.speed;
        if (r100 >= r101.length) goto L6;
        r113[r100] = (float) r101[r100];
        r100 = r100 + 1;
        goto L3
    L6:
        VEEditor r102 = new VEEditor(r110.getWorkspace());
        int r103 = r102.init2(r111.videoFilePaths, r111.vTrimIn, r111.vTrimOut, null, r111.audioFilePaths, r111.aTrimIn, r111.aTrimOut, r113, r113, r111.rotate, VIDEO_RATIO.VIDEO_OUT_RATIO_ORIGINAL);
        if (r103 == 0) goto L10;
        VELogUtil.e(TAG, "genReverseVideo2 init2 error:" + r103);
        return null;
    L10:
        r102.setTimeRange(r210, r211, SET_RANGE_MODE.EDITOR_TIMERANGE_FLAG_AFTER_SPEED);
        return genReverseVideoWithEditor(r102, r110, r112, true, r212);
    }

    public int addAudioTrack(String r100, int r110, int r111, int r112, int r113, boolean r114) {
        return addAudioTrack(r100, r110, r111, r112, r113, r114, false);
    }

    public int addExternalVideoTrack(String r100, int r110, int r111, int r112, int r113, int r114) {
        return addExternalVideoTrackWithFileInfo(r100, null, r110, r111, r112, r113, r114);
    }

    public int addFadeInFadeOut(int r110, int r111, int r112, int r113, int r114, int r115) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r116 = r100.f455860b.addFilters(new int[]{r110}, new String[]{VEBaseAudioFilterParam.AUDIO_FADING_TRANSITION_NAME}, new int[]{r112}, new int[]{r113}, new int[]{r111}, new int[]{1});
        r100.f455860b.setFilterParam(r116[0], "fade_int_length", "" + (r114 * 1000));
        r100.f455860b.setFilterParam(r116[0], "fade_out_length", "" + (r115 * 1000));
        return r116[0];
    }

    public int[] addFilterEffects(int[] r100, int[] r101, String[] r110, boolean[] r111, int[] r112, int[] r113) {
        k0 r102 = (k0) this.mWrapperFilter;
        r102.getClass();
        int r114 = r110.length;
        String[] r103 = new String[r114];
        int r104 = 0;
    L3:
        if (r104 >= r114) goto L6;
        r103[r104] = "";
        r104 = r104 + 1;
        goto L3
    L6:
        return r102.a(r100, r101, r110, r112, r113, r103);
    }

    public int[] addFilterEffectsWithTag(int[] r100, int[] r110, String[] r111, int[] r112, int[] r113, String[] r114) {
        return ((k0) this.mWrapperFilter).a(r100, r110, r111, r112, r113, r114);
    }

    public int addPitchTempo(int r110, int r111, float r112, float r113, int r114, int r115) {
        k0 r100 = (k0) this.mWrapperFilter;
        int[] r116 = r100.f455860b.addFilters(new int[]{r110}, new String[]{"audio pitch tempo"}, new int[]{r114}, new int[]{r115}, new int[]{r111}, new int[]{1});
        r100.f455860b.setFilterParam(r116[0], "pitch_scale", "" + r112);
        r100.f455860b.setFilterParam(r116[0], "time_ratio", "" + r113);
        return r116[0];
    }

    public int addSlowMotionEffect(int r210, int r211, int r212, int r213, float r214, float r310) {
        k0 r100 = (k0) this.mWrapperFilter;
        VEEditor r110 = r100.f455859a;
        monitor-enter(r110);
        VELogUtil.w("VEEditor_VEFilterInvoker", "addSlowMotionEffect... " + r210 + " " + r211 + " " + r212 + " " + r213 + " " + r214 + " " + r310);     // Catch: Throwable -> L23
        cancelCompileProbe();     // Catch: Throwable -> L23
        if (r100.f455860b.getCurState() == (-20000)) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == false) goto L10;
        int r112 = r100.f455860b.stop();     // Catch: Throwable -> L23
    L11:
        if (r112 != 0) goto L13;
    L17:
        int[] r101 = r100.f455860b.addFilters(new int[]{r210}, new String[]{"timeEffect slow motion"}, new int[]{r212}, new int[]{r100.f455860b.getDuration()}, new int[]{r211}, new int[]{6});     // Catch: Throwable -> L23
        int r102 = r101[0];     // Catch: Throwable -> L23
        r100.f455865g = r102;     // Catch: Throwable -> L23
        r100.f455860b.setFilterParam(r102, VESlowMotionFilterParam.SLOW_ATTR_DURATION, "" + r213);     // Catch: Throwable -> L23
        r100.f455860b.setFilterParam(r101[0], VESlowMotionFilterParam.SLOW_ATTR_SPEED, "" + r214);     // Catch: Throwable -> L23
        r100.f455860b.setFilterParam(r101[0], "timeEffect fast motion speed", "" + r310);     // Catch: Throwable -> L23
        if (r111 == false) goto L20;
        r100.f455860b.createTimeline();     // Catch: Throwable -> L23
        r100.f455860b.prepareEngine(0);     // Catch: Throwable -> L23
    L20:
        fic.a r103 = new fic.a();     // Catch: Throwable -> L23
        r103.c("iesve_veeditor_time_effect_id", "slow");     // Catch: Throwable -> L23
        com.ss.android.ttve.monitor.g.b(r103);     // Catch: Throwable -> L23
        r100.f455859a.getTEMonitorFilterMgr().getClass();     // Catch: Throwable -> L23
        int r104 = r101[0];     // Catch: Throwable -> L23
        monitor-exit(r110);     // Catch: Throwable -> L23
        return r104;
    L13:
        if (r112 == (-101)) goto L17;
        VELogUtil.e("VEEditor_VEFilterInvoker", "pauseSync failed in addSlowMotionEffect, ret " + r112);     // Catch: Throwable -> L23
        monitor-exit(r110);     // Catch: Throwable -> L23
        return -1;
    L10:
        r112 = 0;
        goto L11
    L7:
        r111 = false;
    L23:
        th = move-exception;
        throw th;
    }

    public int enableAudioCommonFilter(int r210, int r211, String r212, byte[] r213, int r214, VEListener.AudioCommonFilterListener r215) {
        k0 r110 = (k0) this.mWrapperFilter;
        r110.getClass();
        VELogUtil.i("VEEditor_VEFilterInvoker", "enableAudioCommonFilter...");
        cancelCompileProbe();
        int r100 = r110.f455860b.getDuration();
        TETrackIndexManager r101 = r110.f455859a.getTrackIndexManager();
        if (r210 != 1) goto L5;
        int r102 = 1;
    L6:
        int r103 = r101.b(r102, r211);
        if (r212.equals("") == false) goto L12;
        int[] r104 = r110.f455860b.addFilters(new int[]{r103}, new String[]{"audio original filter"}, new int[]{r214}, new int[]{r100}, new int[]{r210}, new int[]{1});
        VELogUtil.e("VEEditor_VEFilterInvoker", "audio original filter " + r104[0] + " seqIn: " + r214);
        if (r104[0] >= 0) goto L11;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Add filter failed!");
    L15:
        return -1;
    L11:
        VELogUtil.i("VEEditor_VEFilterInvoker", "enableAudioOriginalFilter...filterIndex = " + r104[0] + ", seqIn = " + r214);
        return r104[0];
    L12:
        int[] r105 = r110.f455860b.addFilters(new int[]{r103}, new String[]{"audio common filter"}, new int[]{r214}, new int[]{r100}, new int[]{r210}, new int[]{1});
        if (r105[0] >= 0) goto L16;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Add filter failed!");
        goto L15
    L16:
        long[] r111 = new long[1];
        int r106 = r110.f455860b.preprocessAudioTrackForFilter(r210, r103, r212, r213, r111);
        byte[] r107 = r110.f455860b.getAudioCommonFilterPreprocessResult(r111[0]);
        if (r215 == null) goto L19;
        r215.onPreprocess(r212, r106, r107);
    L19:
        if (r106 == 0) goto L21;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Add filter preprocess failed!");
        goto L15
    L21:
        r110.f455860b.setFilterParam(r105[0], "audio_common_filter_params", r212);
        r110.f455860b.setFilterParam(r105[0], "audio_common_filter_preresult", r107);
        VELogUtil.i("VEEditor_VEFilterInvoker", "enableAudioCommonFilter...filterIndex " + r105[0] + ", seqIn = " + r214);
        return r105[0];
    L5:
        r102 = 2;
        goto L6
    }

    public int faceCoverScale(int r110, double r111, double r112, double r113, String r114, boolean r210) {
        return this.mVideoEditor.faceCoverScale(r110, r111, r112, r113, r114, r210);
    }

    public int getImages(int[] r100, int r101, int r110, boolean r111, GET_FRAMES_FLAGS r112, VEListener.VEGetImageListener r113) {
        monitor-enter(this);
        VELogUtil.i(TAG, "getImages... width:" + r101 + ", height:" + r110 + ", flags:" + r112 + ", isRough: " + r111);     // Catch: Throwable -> L18
        if (r101 == 0) goto L9;
        if (r110 == 0) goto L9;
        this.mGetImageListener = r113;     // Catch: Throwable -> L18
        this.mVideoEditor.setGetImageCallback(this.mGetImageCallback);     // Catch: Throwable -> L18
        int r102 = this.mVideoEditor.getImages(r100, r101, r110, r111, r112.getValue());     // Catch: Throwable -> L18
    L10:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L18
        r103.put("resultCode", r102);     // Catch: JSONException -> L13 Throwable -> L18
        r103.put("has_effect", 1);     // Catch: JSONException -> L13 Throwable -> L18
    L15:
        com.ss.android.ttve.monitor.c.a("vesdk_editor_get_frame", r103, "performance");     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r102;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
    L9:
        VELogUtil.e(TAG, "getImages error, size invalid");     // Catch: Throwable -> L18
        r102 = -100;
    L18:
        th = move-exception;
        throw th;
    }

    public int initMV(String r100, String[] r101, String[] r102, String r103, int r104, int r105) {
        dic.d r106 = this.mWrapperMV;
        if (r106 != null) goto L7;
        VELogUtil.e(TAG, "MV IS NOT SUPPORT !!!");
        return -900;
    L7:
        return r106.b();
    }

    public void setDisplayState(float r110, float r111, float r112, int r113, int r114, int r115) {
        fic.a r100 = new fic.a();
        r100.a("iesve_veeditor_video_scale_width", r110);
        r100.a("iesve_veeditor_video_scale_heigh", r111);
        com.ss.android.ttve.monitor.g.b(r100);
        this.rotate = r112;
        this.scaleW = r111;
        this.scaleH = r111;
        VELogUtil.i(TAG, "setDisplayState... " + r110 + " " + r111 + " " + r112 + " " + r113 + " " + r114 + " " + r115);
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
        r101.put("scaleW", String.valueOf(r110));     // Catch: JSONException -> L5
        r101.put("scaleH", String.valueOf(r111));     // Catch: JSONException -> L5
        r101.put("degree", String.valueOf(r112));     // Catch: JSONException -> L5
        r101.put("transX", String.valueOf(r113));     // Catch: JSONException -> L5
        r101.put("transY", String.valueOf(r114));     // Catch: JSONException -> L5
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_scale_rotate_trans", r101, "business");     // Catch: JSONException -> L5
    L7:
        this.mVideoEditor.setDisplayState(r110, r111, r112, 0.0f, r113, r114, r115);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int setSrtAudioInfo(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        dic.f r106 = this.mWrapperSticker;
        if (r106 != null) goto L7;
        VELogUtil.e(TAG, "setSrtAudioInfo STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r106.v0();
    }

    public int setStickerAnimation(int r100, boolean r101, String r102, int r103, String r104, int r105) {
        dic.f r106 = this.mWrapperSticker;
        if (r106 != null) goto L7;
        VELogUtil.e(TAG, "setStickerAnimation STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r106.s0();
    }

    public int updateAudioTrack(int r100, int r110, int r111, int r112, int r113, boolean r114) {
        return updateAudioTrack(r100, r110, r111, r112, r113, r114, false);
    }

    public static VEEditor genReverseVideo(VEEditorResManager r100, VETimelineParams r101, int r102, int r110, int r111, int r112, VEListener.VEEditorGenReverseListener r113) {
        String[] r103 = r101.videoFilePaths;
        if (r103 != null) goto L5;
    L7:
        VEVideoEncodeSettings r104 = new VEVideoEncodeSettings.Builder(2).setVideoRes(-1, -1).setFps(30).setSupportHwEnc(false).setSWCRF(13).setGopSize(1).setWatermarkParam(null).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_BASELINE).setEncodePreset(VEVideoEncodeSettings.ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST).setEnableRemuxVideo(false, false).build();
    L9:
        return genReverseVideo2(r100, r101, r104, r111, r112, r113);
    L5:
        if (r103.length <= 1) goto L7;
        r104 = new VEVideoEncodeSettings.Builder(2).setVideoRes(r102, r110).setResizeMode(1).setFps(30).setSupportHwEnc(false).setSWCRF(13).setGopSize(1).setWatermarkParam(null).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_BASELINE).setEncodePreset(VEVideoEncodeSettings.ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST).setEnableRemuxVideo(false, false).build();
        goto L9
    }

    public int addAudioCommonFilter(int r210, int r211, String r212, byte[] r213, int r214, int r215, VEListener.AudioCommonFilterListener r216) {
        k0 r100 = (k0) this.mWrapperFilter;
        r100.getClass();
        if (TextUtils.isEmpty(r212) == false) goto L5;
        VELogUtil.e("VEEditor_VEFilterInvoker", "addAudioCommonFilter failed path is null or path not exist");
        return -205;
    L5:
        VELogUtil.i("VEEditor_VEFilterInvoker", "addAudioCommonFilter... trackType = " + r210 + ", trackIndex = " + r211);
        cancelCompileProbe();
        TETrackIndexManager r101 = r100.f455859a.getTrackIndexManager();
        if (r210 != 1) goto L8;
        int r102 = 1;
    L9:
        int r103 = r101.b(r102, r211);
        int[] r110 = r100.f455860b.addFilters(new int[]{r103}, new String[]{"audio common filter"}, new int[]{r214}, new int[]{r215}, new int[]{r210}, new int[]{1});
        if (r110[0] >= 0) goto L13;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Add filter failed!");
    L12:
        return -1;
    L13:
        long[] r111 = new long[1];
        int r104 = r100.f455860b.preprocessAudioTrackForFilter(r210, r103, r212, r213, r111);
        byte[] r105 = r100.f455860b.getAudioCommonFilterPreprocessResult(r111[0]);
        if (r216 == null) goto L16;
        r216.onPreprocess(r212, r104, r105);
    L16:
        if (r104 == 0) goto L18;
        VELogUtil.e("VEEditor_VEFilterInvoker", "Add filter preprocess failed!");
        goto L12
    L18:
        r100.f455860b.setFilterParam(r110[0], "audio_common_filter_params", r212);
        r100.f455860b.setFilterParam(r110[0], "audio_common_filter_preresult", r105);
        return r110[0];
    L8:
        r102 = 2;
        goto L9
    }

    public int addAudioTrack(String r110, int r111, int r112, int r113, int r114, boolean r115, boolean r116) {
        return addAudioTrackWithInfo(r110, null, r111, r112, r113, r114, r115, r116);
    }

    public int addExternalVideoTrackWithFileInfo(String r210, String r211, int r212, int r213, int r214, int r215, int r216) {
        w0 r110 = (w0) this.mWrapperSequence;
        VEEditor r111 = r110.f455940a;
        monitor-enter(r111);
        VELogUtil.i("VEEditor_VESequenceInvoker", "addExternalVideoTrack... " + r210 + ", " + r212 + ", " + r213 + ", " + r214 + ", " + r215 + ", " + r216);     // Catch: Throwable -> L24
        r110.f455941b.stop();     // Catch: Throwable -> L24
        if (r211 == null) goto L7;
        String[] r100 = {r211};     // Catch: Throwable -> L24
    L8:
        VEEditor r101 = r111;
        int r102 = r110.f455940a.getTrackIndexManager().a(2, r110.f455941b.addExternalVideoTrack(new String[]{r210}, r100, new int[]{r214}, new int[]{r215}, new int[]{r212}, new int[]{r213}, r216));     // Catch: Throwable -> L22
        TEInterface r103 = r110.f455941b;     // Catch: Throwable -> L22
        r103.setTimeRange(0, r103.getDuration(), 1);     // Catch: Throwable -> L22
        int r104 = r110.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L22
        if (r104 == 0) goto L33;
        VELogUtil.e("VEEditor_VESequenceInvoker", "addExternalVideoTrack Prepare Engine failed, ret = " + r104);     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        return r104;
    L33:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L17 Throwable -> L22
        r105.put("file", r210);     // Catch: JSONException -> L17 Throwable -> L22
        r105.put("fileInfo", r211);     // Catch: JSONException -> L17 Throwable -> L22
        r105.put("trimIn", r212);     // Catch: JSONException -> L17 Throwable -> L22
        r105.put("trimOut", r213);     // Catch: JSONException -> L17 Throwable -> L22
        r105.put("sequenceIn", r214);     // Catch: JSONException -> L17 Throwable -> L22
        r105.put("sequenceOut", r215);     // Catch: JSONException -> L17 Throwable -> L22
        r105.put(GXTemplateKey.GAIAX_LAYER, r216);     // Catch: JSONException -> L17 Throwable -> L22
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_external_video_track", r105, "business");     // Catch: JSONException -> L17 Throwable -> L22
    L19:
        VELogUtil.i("VEEditor_VESequenceInvoker", "addExternalVideoTrack success index:" + r102);     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        return r102;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = th;
    L35:
        monitor-exit(r101);     // Catch: Throwable -> L29
        throw th;
    L29:
        th = th;
        goto L35
    L7:
        r100 = null;
    L24:
        th = th;
        r101 = r111;
        goto L35
    }

    public int addSticker(String r100, int r101, int r102, float r103, float r104, float r105, float r106) {
        dic.f r107 = this.mWrapperSticker;
        if (r107 != null) goto L7;
        VELogUtil.e(TAG, "addSticker STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r107.v();
    }

    public int beginAudioExtendToFile(String r110, String r111, String r112, float r113, float r114, float r115, VEListener.t r116) {
        com.ss.android.vesdk.t r100 = (com.ss.android.vesdk.t) this.mWrapperAudioExtend;
        r100.getClass();
        VELogUtil.w("VEEditor_VESmartBGMInvoker", "audioExtendToFile start from " + r114 + " TO " + r115 + ". Target to(seconds):" + r113);
        return r100.f455933a.beginAudioExtendToFile(r110, r111, r112, r113, r114, r115, r116);
    }

    public int updateAudioTrack(int r110, int r111, int r112, int r113, int r114, boolean r115, boolean r210) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r116 = r100.f455940a;
        monitor-enter(r116);
        VELogUtil.i("VEEditor_VESequenceInvoker", "updateAudioTrack...");     // Catch: Throwable -> L31
        if (r110 >= 0) goto L9;
        monitor-exit(r116);     // Catch: Throwable -> L31
        return -100;
    L9:
        if (r112 <= r111) goto L29;
        if (r111 < 0) goto L29;
        if (r114 <= r113) goto L27;
        if (r113 < 0) goto L27;
        if (r210 == false) goto L18;
        r100.f455941b.stop();     // Catch: Throwable -> L31
    L18:
        int r101 = r100.f455941b.updateAudioTrack(r100.f455940a.getTrackIndexManager().b(1, r110), r113, r114, r111, r112, r115, r210);     // Catch: Throwable -> L31
        if (r210 == false) goto L25;
        TEInterface r102 = r100.f455941b;     // Catch: Throwable -> L31
        r102.setTimeRange(0, r102.getDuration(), 1);     // Catch: Throwable -> L31
        int r103 = r100.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L31
        if (r103 == 0) goto L25;
        VELogUtil.e("VEEditor_VESequenceInvoker", "updateAudioTrack Prepare Engine failed, ret = " + r103);     // Catch: Throwable -> L31
        monitor-exit(r116);     // Catch: Throwable -> L31
        return r103;
    L25:
        monitor-exit(r116);     // Catch: Throwable -> L31
        return r101;
    L27:
        monitor-exit(r116);     // Catch: Throwable -> L31
        return -100;
    L29:
        monitor-exit(r116);     // Catch: Throwable -> L31
        return -100;
    L31:
        th = move-exception;
        throw th;
    }

    public static int compileProbe(String r110, String r111, int r112, int r113, long r114, long r210, String r211, VEListener.l r212) {
        Object r100 = mCompileProbeLock;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mCompileProbeRunning == false) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L13
        return -2;
    L9:
        mCompileProbeRunning = true;     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        int r101 = _compileProbe(r110, r111, r112, r113, r114, r210, r211, 1, 0, r212, null);
        mCompileProbeRunning = false;
        return r101;
    }

    public int addAudioTrack(String r110, int r111, int r210, int r211, int r212, boolean r213, int r214, int r215) {
        w0 r112 = (w0) this.mWrapperSequence;
        VEEditor r100 = r112.f455940a;
        monitor-enter(r100);
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrack... " + r110 + " In " + r111 + " Out " + r210 + " SeqIn " + r211 + " seqOut " + r212 + " " + r213 + " " + r214 + " " + r215);     // Catch: Throwable -> L36
        int r101 = -100;
        if (TextUtils.isEmpty(r110) == false) goto L47;
        monitor-exit(r100);     // Catch: Throwable -> L36
    L33:
        return r101;
    L47:
        if (r210 <= r111) goto L32;
        if (r111 < 0) goto L32;
        if (r212 <= r211) goto L29;
        if (r211 < 0) goto L29;
        VEEditor r113 = r100;
        r101 = r112.f455940a.getTrackIndexManager().a(1, r112.f455941b.addAudioTrack(r110, r211, r212, r111, r210, r213, r214, r215));     // Catch: Throwable -> L34
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L23 Throwable -> L34
        r102.put("path", r110);     // Catch: JSONException -> L23 Throwable -> L34
        r102.put("sequenceIn", r211);     // Catch: JSONException -> L23 Throwable -> L34
        r102.put("sequenceOut", r212);     // Catch: JSONException -> L23 Throwable -> L34
        r102.put("trimIn", r111);     // Catch: JSONException -> L23 Throwable -> L34
        r102.put("trimOut", r210);     // Catch: JSONException -> L23 Throwable -> L34
        if (r101 < 0) goto L20;
        int r103 = 0;
    L21:
        r102.put("resultCode", r103);     // Catch: JSONException -> L23 Throwable -> L34
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_audio_track", r102, "business");     // Catch: JSONException -> L23 Throwable -> L34
    L25:
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrack... " + r101);     // Catch: Throwable -> L34
        monitor-exit(r113);     // Catch: Throwable -> L34
        goto L33
    L20:
        r103 = r101;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
    L29:
        monitor-exit(r100);     // Catch: Throwable -> L34
    L32:
        monitor-exit(r100);     // Catch: Throwable -> L34
    L34:
        th = th;
    L43:
        monitor-exit(r113);     // Catch: Throwable -> L41
        throw th;
    L41:
        th = th;
    L36:
        th = th;
        r113 = r100;
        goto L43
    }

    public int addAudioTrackWithInfo(String r110, String r210, int r211, int r212, int r213, int r214, boolean r215, boolean r216) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrack... " + r110 + " In " + r211 + " Out " + r212 + " SeqIn " + r213 + " seqOut " + r214 + " " + r215 + " " + r216);     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r110) == false) goto L54;
        monitor-exit(r101);     // Catch: Throwable -> L45
        return -100;
    L54:
        if (r212 <= r211) goto L41;
        if (r211 < 0) goto L41;
        if (r214 <= r213) goto L38;
        if (r213 < 0) goto L38;
        if (r216 == false) goto L17;
        r100.f455941b.stop();     // Catch: Throwable -> L45
    L17:
        VEEditor r111 = r101;
        int r102 = r100.f455940a.getTrackIndexManager().a(1, r100.f455941b.addAudioTrack(r110, r210, r213, r214, r211, r212, r215, r216));     // Catch: Throwable -> L43
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L26 Throwable -> L43
        r103.put("path", r110);     // Catch: JSONException -> L26 Throwable -> L43
        r103.put("sequenceIn", r213);     // Catch: JSONException -> L26 Throwable -> L43
        r103.put("sequenceOut", r214);     // Catch: JSONException -> L26 Throwable -> L43
        r103.put("trimIn", r211);     // Catch: JSONException -> L26 Throwable -> L43
        r103.put("trimOut", r212);     // Catch: JSONException -> L26 Throwable -> L43
        if (r102 < 0) goto L23;
        int r104 = 0;
    L24:
        r103.put("resultCode", r104);     // Catch: JSONException -> L26 Throwable -> L43
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_audio_track", r103, "business");     // Catch: JSONException -> L26 Throwable -> L43
    L28:
        if (r216 == false) goto L34;
        TEInterface r105 = r100.f455941b;     // Catch: Throwable -> L43
        r105.setTimeRange(0, r105.getDuration(), 1);     // Catch: Throwable -> L43
        int r106 = r100.f455940a.prepareWithCallback(0);     // Catch: Throwable -> L43
        if (r106 == 0) goto L34;
        VELogUtil.e("VEEditor_VESequenceInvoker", "addAudioTrack Prepare Engine failed, ret = " + r106);     // Catch: Throwable -> L43
        monitor-exit(r111);     // Catch: Throwable -> L43
        return r106;
    L34:
        VELogUtil.w("VEEditor_VESequenceInvoker", "addAudioTrack... " + r102);     // Catch: Throwable -> L43
        monitor-exit(r111);     // Catch: Throwable -> L43
        return r102;
    L23:
        r104 = r102;
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L43
    L38:
        monitor-exit(r101);     // Catch: Throwable -> L43
        return -100;
    L41:
        monitor-exit(r101);     // Catch: Throwable -> L43
        return -100;
    L43:
        th = th;
    L52:
        monitor-exit(r111);     // Catch: Throwable -> L50
        throw th;
    L50:
        th = th;
    L45:
        th = th;
        r111 = r101;
        goto L52
    }

    public int changeRes(String[] r110, int[] r111, int[] r112, String[] r113, String[] r114, int[] r210, int[] r211, VIDEO_RATIO r212) throws VEException {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        VELogUtil.i("VEEditor_VESequenceInvoker", "changeRes reInit...");
        int r101 = r100.f455941b.stop();
        if (r101 == 0) goto L5;
        VELogUtil.i("VEEditor_VESequenceInvoker", "stop in changeRes failed, ret = " + r101);
        return -1;
    L5:
        int r102 = r100.f455940a.init2(r110, r111, r112, r113, r114, r210, r211, r212);
        if (r102 == 0) goto L8;
        VELogUtil.e("VEEditor_VESequenceInvoker", "init2 in changeRes failed, ret = " + r102);
        return r102;
    L8:
        r100.f455941b.createTimeline();
        int r103 = r100.f455941b.prepareEngine(-1);
        if (r103 != 0) goto L14;
        r100.f455940a.getTrackIndexManager().d();
        return r103;
    L14:
        return r103;
    }

    public int init2(String[] r110, int[] r111, int[] r112, String[] r113, String[] r114, int[] r115, int[] r116, VIDEO_RATIO r210) throws VEException {
        return init2(r110, r111, r112, r113, r114, r115, r116, null, null, null, r210);
    }

    public int updateAudioTrack(int r110, int r111, int r112, int r113, int r114, boolean r115, int r116, int r210) {
        w0 r100 = (w0) this.mWrapperSequence;
        VEEditor r117 = r100.f455940a;
        monitor-enter(r117);
        VELogUtil.i("VEEditor_VESequenceInvoker", "updateAudioTrack...");     // Catch: Throwable -> L29
        int r101 = -100;
        if (r110 >= 0) goto L9;
        monitor-exit(r117);     // Catch: Throwable -> L29
    L28:
        return r101;
    L9:
        if (r112 <= r111) goto L27;
        if (r111 < 0) goto L27;
        if (r114 <= r113) goto L25;
        if (r113 < 0) goto L25;
        if (r210 <= r116) goto L23;
        if (r116 < 0) goto L23;
        int r102 = r100.f455940a.getTrackIndexManager().b(1, r110);     // Catch: Throwable -> L29
        r101 = r100.f455941b.updateAudioTrack(r102, r113, r114, r111, r112, r115, r116, r210);     // Catch: Throwable -> L29
        monitor-exit(r117);     // Catch: Throwable -> L29
    L23:
        monitor-exit(r117);     // Catch: Throwable -> L29
    L25:
        monitor-exit(r117);     // Catch: Throwable -> L29
    L27:
        monitor-exit(r117);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public int addExtRes(String r100, int r101, int r102, int r103, int r104, float r105, float r106, float r107, float r108) {
        dic.f r109 = this.mWrapperSticker;
        if (r109 != null) goto L7;
        VELogUtil.e(TAG, "addExtRes STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r109.h0();
    }

    public int addSticker(String r100, int r101, int r102, int r103, int r104, float r105, float r106, float r107, float r108) {
        dic.f r109 = this.mWrapperSticker;
        if (r109 != null) goto L7;
        VELogUtil.e(TAG, "addSticker2 STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r109.a();
    }

    public int changeBitmapRes(Bitmap[] r110, int[] r111, int[] r112, String[] r113, String[] r210, int[] r211, int[] r212, float[] r213, VIDEO_RATIO r214) throws VEException {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        VELogUtil.i("VEEditor_VESequenceInvoker", "changeBitmapRes reInit...");
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        r100.f455940a.releaseEngine();     // Catch: Throwable -> L15
        int r102 = r100.f455940a.init2(r110, r111, r112, r113, r210, r211, r212, r213, r214);     // Catch: Throwable -> L15
        if (r102 == 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "init2 in changeRes failed, ret = " + r102);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
    L14:
        return r102;
    L9:
        r102 = r100.f455941b.prepareEngine(0);     // Catch: Throwable -> L15
        if (r102 != 0) goto L12;
        r100.f455940a.getTrackIndexManager().d();     // Catch: Throwable -> L15
    L12:
        VELogUtil.i("VEEditor_VESequenceInvoker", "changeBitmapRes end");     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public int changeRes(String[] r110, int[] r111, int[] r210, String[] r211, String[] r212, int[] r213, int[] r214, float[] r215, VIDEO_RATIO r216) throws VEException {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        VELogUtil.i("VEEditor_VESequenceInvoker", "changeRes2 reInit...");
        VEEditor r101 = r100.f455940a;
        monitor-enter(r101);
        r100.f455940a.releaseEngine();     // Catch: Throwable -> L15
        int r102 = r100.f455940a.init2(r110, r111, r210, r211, r212, r213, r214, r215, r215, null, r216);     // Catch: Throwable -> L15
        if (r102 == 0) goto L9;
        VELogUtil.e("VEEditor_VESequenceInvoker", "init2 in changeRes failed, ret = " + r102);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
    L14:
        return r102;
    L9:
        r102 = r100.f455941b.prepareEngine(0);     // Catch: Throwable -> L15
        if (r102 != 0) goto L12;
        r100.f455940a.getTrackIndexManager().d();     // Catch: Throwable -> L15
    L12:
        VELogUtil.i("VEEditor_VESequenceInvoker", "changeRes2 end");     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public int init2(Bitmap[] r110, int[] r111, int[] r112, String[] r210, String[] r211, int[] r212, int[] r213, float[] r214, VIDEO_RATIO r215) throws VEException {
        monitor-enter(this);
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L23
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L23
        this.mlLastTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L23
        this.mlInitTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L23
        VELogUtil.i(TAG, "init2...");     // Catch: Throwable -> L23
        int r100 = this.mVideoEditor.initImageEditor(r110, r111, r112, r211, r212, r213, r210, null, r214, null, r215.ordinal());     // Catch: Throwable -> L23
        if (r100 == 0) goto L10;
        VELogUtil.e(TAG, "Create Scene failed, ret = " + r100);     // Catch: Throwable -> L23
        this.mInitSuccess = false;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r100;
    L10:
        this.mInitSuccess = true;     // Catch: Throwable -> L23
        VEEditorResManager r101 = this.mResManager;     // Catch: Throwable -> L23
        r101.mReverseDone = false;     // Catch: Throwable -> L23
        this.mVideoOutRes = r215;     // Catch: Throwable -> L23
        r101.mAudioPaths = r211;     // Catch: Throwable -> L23
        r101.mTransitions = r210;     // Catch: Throwable -> L23
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L23
        if (r211 != null) goto L13;
    L15:
        boolean r102 = false;
    L16:
        Boolean r103 = Boolean.valueOf(r102);     // Catch: Throwable -> L23
        this.mbSeparateAV = r103;     // Catch: Throwable -> L23
        if (r103.booleanValue() == false) goto L19;
        this.mResManager.mOriginalSoundTrackType = 1;     // Catch: Throwable -> L23
    L20:
        this.mResManager.mOriginalSoundTrackIndex = 0;     // Catch: Throwable -> L23
        this.mMasterTrackIndex = 0;     // Catch: Throwable -> L23
        ((k0) this.mWrapperFilter).f();     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return 0;
    L19:
        this.mResManager.mOriginalSoundTrackType = 0;     // Catch: Throwable -> L23
        goto L20
    L13:
        if (r211.length == 0) goto L15;
        r102 = true;
    L23:
        th = move-exception;
        throw th;
    }

    public static int compileProbe(String r110, String r111, int r112, int r113, long r114, long r210, String r211, int r212, int r213, VEListener.k r214) {
        Object r100 = mCompileProbeLock;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mCompileProbeRunning == false) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L16
        return -2;
    L9:
        mCompileProbeRunning = true;     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        if (r212 != 0) goto L14;
        VELogUtil.w(TAG, "compile use not hard encode, not soft encode");
        return -100;
    L14:
        int r101 = _compileProbe(r110, r111, r112, r113, r114, r210, r211, r212, r213, null, r214);
        mCompileProbeRunning = false;
        return r101;
    }

    public int setStickerAnimation(int r100, boolean r101, String r102, int r103, String r104, int r105, String r106, int r107, int r108, int r110) {
        dic.f r109 = this.mWrapperSticker;
        if (r109 != null) goto L7;
        VELogUtil.e(TAG, "setStickerAnimation STICKER IS NOT SUPPORT !!!");
        return -901;
    L7:
        return r109.s0();
    }

    private static int _compileProbe(String r210, String r211, int r212, int r310, long r311, long r312, String r313, int r314, int r315, VEListener.l r316, VEListener.k r317) {
        VEVideoEncodeSettings r100 = new VEVideoEncodeSettings.Builder(2).setExternalSettings(r313).build();
        VEConfigCenter.ValuePkt r101 = VEConfigCenter.getInstance().getValue("use_byte264");
        VEConfigCenter.ValuePkt r102 = VEConfigCenter.getInstance().getValue("compile_probe_use_byte264");
        VEConfigCenter.ValuePkt r103 = VEConfigCenter.getInstance().getValue("compile_probe_crf");
        if (r103 == null) goto L12;
        if (r103.getValue() == null) goto L12;
        if ((r103.getValue() instanceof Integer) == false) goto L12;
        int r104 = ((Integer) r103.getValue()).intValue();
        if (r104 <= 0) goto L12;
        r100.getVideoCompileEncodeSetting().mSWEncodeSetting.mCrf = r104;
    L12:
        if (r101 != null) goto L14;
    L18:
        int r105 = 0;
    L19:
        if (r102 != null) goto L21;
    L25:
        VELogUtil.i(TAG, "KEY_USE_BYTE264= " + ((Boolean) r101.getValue()).booleanValue() + "KEY_COMPILE_PROBE_USE_BYTE264= " + ((Boolean) r102.getValue()).booleanValue() + "tempValue= " + r105);
        if (r317 == null) goto L28;
        f r213 = null;
        e r214 = new e(r100, r105);
    L30:
        VEVideoCompileEncodeSettings r106 = r100.getVideoCompileEncodeSetting();
        if (r106.useHWEncoder == false) goto L37;
        if (r314 != 1) goto L37;
        VELogUtil.w(TAG, "compile use hard encode, not soft encode");
        return -100;
    L37:
        if (r211 != null) goto L39;
    L58:
        VELogUtil.w(TAG, "savepath is null or savepath is empty");
    L59:
        return -100;
    L39:
        if (r211.isEmpty() == true) goto L58;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r211);
        if (r107.exists() == true) goto L44;
    L56:
        VELogUtil.w(TAG, "savepath is not exist, savepath: ".concat(r211));
        return -1;
    L44:
        if (r107.isDirectory() == false) goto L56;
        String r108 = r211.concat("/probe/");
        if (new PolarisFileWrapper(r108).exists() == false) goto L49;
    L52:
        String r109 = r108 + "compile_probe";
        VEVideoSWEncodeSettings r110 = r106.mSWEncodeSetting;
        TEVideoUtils.nativeCompileProbe(r210, r109, r212, r310, r311, r312, r110.mPreset, r110.mCrf, r110.mGop, r110.mMaxRate, r110.mQPOffset, r213, r214, r314);
        PolarisFileWrapper r111 = new PolarisFileWrapper(r109);
        if (r111.exists() == false) goto L55;
        VELogUtil.w(TAG, "delete file: " + r109);
        r111.delete();
    L55:
        return 0;
    L49:
        if (VEFileUtils.mkdir(r108) == true) goto L52;
        VELogUtil.w(TAG, "create probeDir failed");
        return -1;
    L28:
        if (r316 == null) goto L59;
        r214 = null;
        r213 = new f(r105, r100);
        goto L30
    L21:
        if (r102.getValue() == null) goto L25;
        if (((Boolean) r102.getValue()).booleanValue() == true) goto L25;
        r105 = 0;
        goto L25
    L14:
        if (r101.getValue() == null) goto L18;
        if (((Boolean) r101.getValue()).booleanValue() == false) goto L18;
        r105 = 1;
        goto L19
    }

    public int changeBitmapRes(Bitmap[] r110, int[] r111, int[] r112, String[] r113, String[] r210, int[] r211, int[] r212, float[] r213, VIDEO_RATIO r214, int r215, int r216) throws VEException {
        w0 r100 = (w0) this.mWrapperSequence;
        r100.getClass();
        VELogUtil.i("VEEditor_VESequenceInvoker", "changeBitmapRes reInit...");
        int r101 = r100.f455941b.stop();
        if (r101 == 0) goto L5;
        VELogUtil.i("VEEditor_VESequenceInvoker", "stop in changeRes failed, ret = " + r101);
        return -1;
    L5:
        int r102 = r100.f455940a.init2(r110, r111, r112, r113, r210, r211, r212, r213, r214);
        if (r102 == 0) goto L8;
        VELogUtil.e("VEEditor_VESequenceInvoker", "init2 in changeRes failed, ret = " + r102);
        return r102;
    L8:
        r100.f455941b.createTimeline();
        r100.f455941b.setWidthHeight(r215, r216);
        return r100.f455941b.prepareEngine(-1);
    }

    public int changeResWithEffect(String[] r110, String[] r111, int[] r112, int[] r113, float[] r114, String[] r115, String[] r210, int[] r211, int[] r212, float[] r213, ROTATE_DEGREE[] r214) throws VEException {
        if (r110 != null) goto L5;
        return -100;
    L5:
        if (r110.length == 0) goto L11;
        boolean[] r100 = new boolean[r110.length];
        Arrays.fill(r100, true);
        return changeResWithEffect(r100, r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    L11:
        return -100;
    }

    public int init2(String[] r110, int[] r111, int[] r112, String[] r113, String[] r114, int[] r115, int[] r210, float[] r211, float[] r212, ROTATE_DEGREE[] r213, VIDEO_RATIO r214) {
        return init2(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, false);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private int init2(String[] r210, int[] r211, int[] r212, String[] r213, String[] r214, int[] r215, int[] r216, float[] r310, float[] r311, ROTATE_DEGREE[] r312, VIDEO_RATIO r313, boolean r314) throws VEException {
        monitor-enter(this);
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L71
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L71
        this.mlLastTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L71
        this.mlInitTimeMS = System.currentTimeMillis();     // Catch: Throwable -> L71
        VELogUtil.i(TAG, "init2... width rotate");     // Catch: Throwable -> L71
        VELogUtil.i(TAG, "disable file info cache");     // Catch: Throwable -> L71
        int r100 = this.mVideoEditor.initVideoEditor2(r210, r211, r212, r214, r215, r216, r213, null, r310, r311, ROTATE_DEGREE.toIntArray(r312), r313.ordinal(), r314);     // Catch: Throwable -> L71
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L71
        if (r210 != null) goto L77;
        String r102 = "";
    L11:
        r101.put("videoFilePaths", r102);     // Catch: JSONException -> L48 Throwable -> L71
        String[] r103 = r214;
        if (r103 != null) goto L74;
        String r104 = "";
    L16:
        r101.put("audioFilePaths", r104);     // Catch: JSONException -> L46 Throwable -> L71
        if (r211 == null) goto L19;
        String r105 = Arrays.toString(r211);     // Catch: JSONException -> L46 Throwable -> L71
    L20:
        r101.put("vTrimIn", r105);     // Catch: JSONException -> L46 Throwable -> L71
        if (r212 == null) goto L23;
        String r106 = Arrays.toString(r212);     // Catch: JSONException -> L46 Throwable -> L71
    L24:
        r101.put("vTrimOut", r106);     // Catch: JSONException -> L46 Throwable -> L71
        if (r215 == null) goto L27;
        String r107 = Arrays.toString(r215);     // Catch: JSONException -> L46 Throwable -> L71
    L28:
        r101.put("aTrimIn", r107);     // Catch: JSONException -> L46 Throwable -> L71
        if (r216 == null) goto L31;
        String r108 = Arrays.toString(r216);     // Catch: JSONException -> L46 Throwable -> L71
    L32:
        r101.put("aTrimOut", r108);     // Catch: JSONException -> L46 Throwable -> L71
        if (r310 == null) goto L35;
        String r109 = Arrays.toString(r310);     // Catch: JSONException -> L46 Throwable -> L71
    L36:
        r101.put("videoSpeed", r109);     // Catch: JSONException -> L46 Throwable -> L71
        if (r311 == null) goto L39;
        String r110 = Arrays.toString(r311);     // Catch: JSONException -> L46 Throwable -> L71
    L40:
        r101.put("audioSpeed", r110);     // Catch: JSONException -> L46 Throwable -> L71
        if (r312 == null) goto L43;
        String r111 = Arrays.toString(r312);     // Catch: JSONException -> L46 Throwable -> L71
    L44:
        r101.put("rotate", r111);     // Catch: JSONException -> L46 Throwable -> L71
        r101.put("videoOutRes", r313.name());     // Catch: JSONException -> L46 Throwable -> L71
        r101.put("cacheCheckTime", "0");     // Catch: JSONException -> L46 Throwable -> L71
        r101.put("createSceneTime", "" + (System.currentTimeMillis() - this.mlInitTimeMS));     // Catch: JSONException -> L46 Throwable -> L71
        StringBuilder r112 = new StringBuilder("");     // Catch: JSONException -> L46 Throwable -> L71
        int r113 = this.miCacheHitCount;     // Catch: JSONException -> L46 Throwable -> L71
        r112.append(((double) r113) / ((double) (this.miCacheMissCount + r113)));     // Catch: JSONException -> L46 Throwable -> L71
        r101.put("hitRate", r112.toString());     // Catch: JSONException -> L46 Throwable -> L71
        r101.put("resultCode", r100);     // Catch: JSONException -> L46 Throwable -> L71
        com.ss.android.ttve.monitor.c.a("vesdk_event_editor_init_video", r101, "business");     // Catch: JSONException -> L46 Throwable -> L71
        VELogUtil.d(TAG, "file info cache json: " + r101.toString());     // Catch: JSONException -> L46 Throwable -> L71
    L54:
        if (r100 == 0) goto L58;
        VELogUtil.e(TAG, "initVideoEditor2 failed, ret = " + r100);     // Catch: Throwable -> L71
        onMonitorError();     // Catch: Throwable -> L71
        this.mInitSuccess = false;     // Catch: Throwable -> L71
        monitor-exit(this);     // Catch: Throwable -> L71
        return r100;
    L58:
        this.mInitSuccess = true;     // Catch: Throwable -> L71
        VEEditorResManager r114 = this.mResManager;     // Catch: Throwable -> L71
        r114.mReverseDone = false;     // Catch: Throwable -> L71
        this.mVideoOutRes = r313;     // Catch: Throwable -> L71
        r114.mAudioPaths = r103;     // Catch: Throwable -> L71
        r114.mVideoPaths = r210;     // Catch: Throwable -> L71
        r114.mTransitions = r213;     // Catch: Throwable -> L71
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L71
        if (r103 != null) goto L61;
    L63:
        boolean r115 = false;
    L64:
        Boolean r116 = Boolean.valueOf(r115);     // Catch: Throwable -> L71
        this.mbSeparateAV = r116;     // Catch: Throwable -> L71
        if (r116.booleanValue() == false) goto L67;
        this.mResManager.mOriginalSoundTrackType = 1;     // Catch: Throwable -> L71
    L68:
        this.mResManager.mOriginalSoundTrackIndex = 0;     // Catch: Throwable -> L71
        this.mMasterTrackIndex = 0;     // Catch: Throwable -> L71
        ((k0) this.mWrapperFilter).f();     // Catch: Throwable -> L71
        monitor-exit(this);     // Catch: Throwable -> L71
        return 0;
    L67:
        this.mResManager.mOriginalSoundTrackType = 0;     // Catch: Throwable -> L71
        goto L68
    L61:
        if (r103.length == 0) goto L63;
        r115 = true;
    L46:
        e = e;
    L52:
        e.printStackTrace();     // Catch: Throwable -> L71
        goto L54
    L43:
        r111 = "";
        goto L44
    L39:
        r110 = "";
        goto L40
    L35:
        r109 = "";
        goto L36
    L31:
        r108 = "";
        goto L32
    L27:
        r107 = "";
        goto L28
    L23:
        r106 = "";
        goto L24
    L19:
        r105 = "";
        goto L20
    L74:
        r104 = Arrays.toString(r214);     // Catch: JSONException -> L46 Throwable -> L71
    L48:
        e = e;
        r103 = r214;
        goto L52
    L77:
        r102 = Arrays.toString(r210);     // Catch: JSONException -> L48 Throwable -> L71
    L71:
        th = move-exception;
        throw th;
    }

    public int changeResWithEffect(boolean[] r110, String[] r210, String[] r211, int[] r212, int[] r213, float[] r214, String[] r215, String[] r216, int[] r217, int[] r218, float[] r219, ROTATE_DEGREE[] r310) throws VEException {
        VELogUtil.i(TAG, "changeResWithEffect in...");
        if (r210.length != 0) goto L5;
        return -100;
    L5:
        if (r110.length != r210.length) goto L42;
        int r100 = this.mVideoEditor.stop();
        if (r100 == 0) goto L11;
        VELogUtil.i(TAG, "stop in changeResWithEffect failed, ret = " + r100);
        return -1;
    L11:
        VELogUtil.i(TAG, "changeResWithEffect clear reverse before, mOriginalSoundTrackType = " + this.mResManager.mOriginalSoundTrackType);
        VEEditorResManager r101 = this.mResManager;
        if (r101.mReverseDone == true) goto L14;
    L20:
        float r111 = -1.0f;
    L21:
        VEEditorResManager r102 = this.mResManager;
        r102.mReverseAudioPaths = null;
        r102.mReverseVideoPath = null;
        r102.mReverseDone = false;
        r102.mReverseAudioDone = false;
        if (r215 != null) goto L24;
    L26:
        boolean r103 = false;
    L27:
        Boolean r104 = Boolean.valueOf(r103);
        this.mbSeparateAV = r104;
        if (r104.booleanValue() == false) goto L30;
        this.mResManager.mOriginalSoundTrackType = 1;
    L31:
        VELogUtil.i(TAG, "changeResWithEffect clear reverse after, mOriginalSoundTrackType = " + this.mResManager.mOriginalSoundTrackType);
        VEEditorResManager r105 = this.mResManager;
        r105.mVideoPaths = r210;
        r105.mAudioPaths = r215;
        float r112 = r111;
        int r106 = this.mVideoEditor.changeResWithEffect(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, ROTATE_DEGREE.toIntArray(r310));
        if (r106 == 0) goto L35;
        VELogUtil.e(TAG, "updateRes in changeResWithEffect failed, ret = " + r106);
        return r106;
    L35:
        this.mVideoEditor.createTimeline();
        int r107 = this.mVideoEditor.prepareEngine(0);
        if (r112 < 0.0f) goto L38;
        VEEditorResManager r108 = this.mResManager;
        setVolume(r108.mOriginalSoundTrackIndex, r108.mOriginalSoundTrackType, r112);
    L38:
        VELogUtil.i(TAG, "changeResWithEffect done，mInitSize.width = " + this.mInitSize.width + ", mInitSize.height = " + this.mInitSize.height + ", ret = " + r107);
        return r107;
    L30:
        this.mResManager.mOriginalSoundTrackType = 0;
        goto L31
    L24:
        if (r215.length == 0) goto L26;
        r103 = true;
        goto L27
    L14:
        if (r101.mReverseAudioDone == false) goto L20;
        if (r101.mReverseAudioPaths == null) goto L20;
        if (r101.mOriginalSoundTrackType != 1) goto L20;
        float r109 = getVolume(r101.mOriginalSoundTrackIndex, 1, 0);
        deleteAudioTrack(this.mResManager.mOriginalSoundTrackIndex);
        this.mResManager.mOriginalSoundTrackIndex = 0;
        VELogUtil.w(TAG, "changeResWithEffect remove org audio track index " + this.mResManager.mOriginalSoundTrackIndex);
        r111 = r109;
        goto L21
    L42:
        return -100;
    }

    public int initWithCanvas(String[] r110, int[] r111, int[] r112, VETransitionFilterParam[] r113, String[] r210, int[] r211, int[] r212, float[] r213, VECanvasFilterParam[] r214, VIDEO_RATIO r215, VIDEO_GRAVITY r216, VIDEO_SCALETYPE r217) throws VEException {
        return initWithCanvasAndInfos(r110, null, r111, r112, r113, r210, null, r211, r212, r213, r214, r215, r216, r217);
    }

    public int initPictureWithMaxSide(Context r110, String[] r111, int[] r112, int[] r113, String[] r114, String[] r115, int[] r210, int[] r211, float[] r212, ROTATE_DEGREE[] r213, VIDEO_RATIO r214, int r215, VESize[] r216) throws VEException {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r111.length == 1) goto L10;
        VELogUtil.e(TAG, "pictureFilePaths.length is not 1");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return -100;
    L10:
        Point r100 = BitmapLoader.getPictureSize(r110.getContentResolver(), r111[0]);     // Catch: Throwable -> L30
        VESize r101 = new VESize(r100.x, r100.y);     // Catch: Throwable -> L30
        if (Math.round((Math.max(r101.width, r101.height) * 1.0f) / r215) > 1) goto L15;
        int r102 = init2(r111, r112, r113, r114, r115, r210, r211, r212, null, r213, r214);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return r102;
    L15:
        int r103 = r101.width;     // Catch: Throwable -> L30
        int r104 = r101.height;     // Catch: Throwable -> L30
        if (r103 <= r104) goto L18;
        int r105 = (int) (((r104 * r215) * 1.0f) / r103);     // Catch: Throwable -> L30
        int r106 = r105 + (r105 % 2);     // Catch: Throwable -> L30
        int r107 = r215;
    L19:
        BitmapLoader.isSampleSizeRound = true;     // Catch: Throwable -> L30
        Bitmap r108 = BitmapLoader.loadBitmapCompat(r110.getContentResolver(), r111[0], r107, r106);     // Catch: Throwable -> L30
        if (r108 != null) goto L25;
        VELogUtil.e(TAG, "BitmapLoader.loadBitmapCompat failed!");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return -105;
    L25:
        BitmapLoader.isSampleSizeRound = false;     // Catch: Throwable -> L30
        r216[0].width = r108.getWidth();     // Catch: Throwable -> L30
        r216[0].height = r108.getHeight();     // Catch: Throwable -> L30
        VELogUtil.i(TAG, "initPictureWithMaxSidemaxSide: " + r215 + "bitmap width: " + r108.getWidth() + "height: " + r108.getHeight());     // Catch: Throwable -> L30
        int r109 = init2(new Bitmap[]{r108}, r112, r113, r114, r115, r210, r211, r212, r214);     // Catch: Throwable -> L30
        if (r108.isRecycled() == true) goto L28;
        r108.recycle();     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);     // Catch: Throwable -> L30
        return r109;
    L18:
        int r116 = (int) (((r103 * r215) * 1.0f) / r104);     // Catch: Throwable -> L30
        r107 = r116 + (r116 % 2);     // Catch: Throwable -> L30
        r106 = r215;
        goto L19
    }

    public int initWithCanvas(String[] r110, int[] r111, int[] r112, VETransitionFilterParam[] r210, String[] r211, int[] r212, int[] r213, float[] r214, VECanvasFilterParam[] r215, VIDEO_RATIO r216, VIDEO_GRAVITY r217, VIDEO_SCALETYPE r218, VESize[] r219) throws VEException {
        return initWithCanvasAndInfos(r110, null, r111, r112, r210, r211, null, r212, r213, r214, r215, r216, r217, r218, r219);
    }

    public int initWithCanvasAndInfos(String[] r110, String[] r111, int[] r112, int[] r210, VETransitionFilterParam[] r211, String[] r212, String[] r213, int[] r214, int[] r215, float[] r216, VECanvasFilterParam[] r217, VIDEO_RATIO r218, VIDEO_GRAVITY r219, VIDEO_SCALETYPE r310) throws VEException {
        return initWithCanvasAndInfos(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, null);
    }

    public int initWithCanvasAndInfos(String[] r210, String[] r211, int[] r212, int[] r213, VETransitionFilterParam[] r214, String[] r215, String[] r216, int[] r217, int[] r218, float[] r310, VECanvasFilterParam[] r311, VIDEO_RATIO r312, VIDEO_GRAVITY r313, VIDEO_SCALETYPE r314, VESize[] r315) throws VEException {
        monitor-enter(this);
        if (r311 != null) goto L79;
    L71:
        VELogUtil.e(TAG, "initWithCanvas invalid canvasFilterParam!");     // Catch: Throwable -> L74
        monitor-exit(this);     // Catch: Throwable -> L74
        return -100;
    L79:
    L74:
        th = move-exception;
        throw th;
    L7:
        if (r311.length == 0) goto L71;
        VECanvasFilterParam r100 = r311[0];     // Catch: Throwable -> L74
        if (r100.height <= 0) goto L71;
        if (r100.width <= 0) goto L71;
        if (r210.length == r212.length) goto L16;
    L68:
        VELogUtil.e(TAG, "initWithCanvas invalid param, videoFilePaths.length: " + r210.length + ", vTrimIn.length: " + r212.length + ", vTrimOut.length: " + r213.length);     // Catch: Throwable -> L74
        monitor-exit(this);     // Catch: Throwable -> L74
        return -100;
    L16:
        if (r210.length != r213.length) goto L68;
        if (r315 != null) goto L20;
    L24:
        int r101 = 0;
    L26:
        if (r101 >= r212.length) goto L35;
        int r102 = r213[r101];     // Catch: Throwable -> L74
        if (r102 < 0) goto L34;
        if (r102 > r212[r101]) goto L34;
        VELogUtil.e(TAG, "initWithCanvas invalid param vTrimIn[" + r101 + "]=" + r212[r101] + ", vTrimOut[" + r101 + "]=" + r213[r101]);     // Catch: Throwable -> L74
        monitor-exit(this);     // Catch: Throwable -> L74
        return -100;
    L34:
        r101 = r101 + 1;     // Catch: Throwable -> L74
        goto L26
    L35:
        com.ss.android.ttve.monitor.i.a(1);     // Catch: Throwable -> L74
        com.ss.android.ttve.monitor.i.c(1);     // Catch: Throwable -> L74
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L74
        this.mlInitTimeMS = r103;     // Catch: Throwable -> L74
        this.mlLastTimeMS = r103;     // Catch: Throwable -> L74
        VELogUtil.i(TAG, "initWithCanvasAndInfos...");     // Catch: Throwable -> L74
        if (r214 != null) goto L38;
    L44:
        String[] r110 = null;
        int[] r111 = null;
        int[] r112 = null;
    L45:
        String[] r219 = r110;
        int r104 = this.mVideoEditor.initVideoEditorWithCanvas(r210, null, r210.length, r211, r212, r213, r215, r216, r217, r218, r219, r111, r112, null, r310, VIDEO_RATIO.VIDEO_OUT_RATIO_ORIGINAL.ordinal(), r315);     // Catch: Throwable -> L74
        if (r104 == 0) goto L50;
        VELogUtil.e(TAG, "initVideoEditorWithCanvas, ret = " + r104);     // Catch: Throwable -> L74
        onMonitorError();     // Catch: Throwable -> L74
        this.mInitSuccess = false;     // Catch: Throwable -> L74
        monitor-exit(this);     // Catch: Throwable -> L74
        return r104;
    L50:
        this.mInitSuccess = true;     // Catch: Throwable -> L74
        this.mReverseDone = false;     // Catch: Throwable -> L74
        this.mVideoOutRes = r312;     // Catch: Throwable -> L74
        VEEditorResManager r105 = this.mResManager;     // Catch: Throwable -> L74
        r105.mAudioPaths = r215;     // Catch: Throwable -> L74
        r105.mVideoPaths = r210;     // Catch: Throwable -> L74
        r105.mTransitions = r219;     // Catch: Throwable -> L74
        ((k0) this.mWrapperFilter).f455866h = -1;     // Catch: Throwable -> L74
        if (r215 != null) goto L53;
    L55:
        boolean r113 = false;
    L56:
        this.mbSeparateAV = Boolean.valueOf(r113);     // Catch: Throwable -> L74
        this.mMasterTrackIndex = 0;     // Catch: Throwable -> L74
        this.mVideoEditor.setTrackDurationType(0, 0, 1);     // Catch: Throwable -> L74
        setScaleMode(SCALE_MODE.SCALE_MODE_CANVAS);     // Catch: Throwable -> L74
        VECanvasFilterParam r106 = r311[0];     // Catch: Throwable -> L74
        setWidthHeight(r106.width, r106.height);     // Catch: Throwable -> L74
        this.mBusinessManager.f523232a = 1;     // Catch: Throwable -> L74
        int r107 = this.mVideoEditor.addFilters(new int[]{0}, new String[]{"canvas wrap"}, new int[]{0}, new int[]{this.mOutPoint}, new int[]{0}, new int[]{15}, new int[]{1})[0];     // Catch: NullPointerException -> L66 Throwable -> L74
        this.mCanvasWrapFilterIndex = r107;     // Catch: NullPointerException -> L66 Throwable -> L74
        updateTrackClipFilter(-1, r107, r311[0]);     // Catch: NullPointerException -> L66 Throwable -> L74
        int r108 = r210.length;     // Catch: NullPointerException -> L66 Throwable -> L74
        int r114 = 0;
    L58:
        if (r114 >= r108) goto L60;
        updateTrackClipFilter(r114, this.mCanvasWrapFilterIndex, r311[r114]);     // Catch: NullPointerException -> L66 Throwable -> L74
        r114 = r114 + 1;     // Catch: NullPointerException -> L66 Throwable -> L74
        goto L58
    L60:
        VEVideoTransformFilterParam r109 = new VEVideoTransformFilterParam();     // Catch: NullPointerException -> L66 Throwable -> L74
        int r115 = 0;
    L61:
        if (r115 >= r108) goto L64;
        updateTrackClipFilter(r115, this.mCanvasWrapFilterIndex, r109);     // Catch: NullPointerException -> L66 Throwable -> L74
        r115 = r115 + 1;
        goto L61
        goto L67
    L64:
        monitor-exit(this);     // Catch: Throwable -> L74
        return r104;
    L67:
        throw new VEException(-1, "init failed: VESDK need to be init");     // Catch: Throwable -> L74
    L53:
        if (r215.length == 0) goto L55;
        r113 = true;
        goto L56
    L38:
        if (r214.length <= 0) goto L44;
        String[] r116 = new String[r214.length];     // Catch: Throwable -> L74
        int[] r117 = new int[r214.length];     // Catch: Throwable -> L74
        int[] r118 = new int[r214.length];     // Catch: Throwable -> L74
        int r119 = 0;
    L41:
        if (r119 >= r214.length) goto L43;
        r116[r119] = r214[r119].transName;     // Catch: Throwable -> L74
        VETransitionFilterParam r120 = r214[r119];     // Catch: Throwable -> L74
        r117[r119] = r120.tranType;     // Catch: Throwable -> L74
        r118[r119] = r120.tranDuration;     // Catch: Throwable -> L74
        r119 = r119 + 1;     // Catch: Throwable -> L74
        goto L41
    L43:
        r110 = r116;
        r111 = r117;
        r112 = r118;
        goto L45
    L20:
        if (r210.length == r315.length) goto L24;
        VELogUtil.e(TAG, "initWithCanvas invalid param, videoFilePaths.length: " + r210.length + ", sizes.length: " + r315.length);     // Catch: Throwable -> L74
        monitor-exit(this);     // Catch: Throwable -> L74
        return -100;
    }
}
