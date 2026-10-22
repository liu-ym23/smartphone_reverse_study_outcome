package com.ss.android.vesdk;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ttve.model.VEFrame;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class VEGetFrameSettings {
    private boolean forceDriveRenderFrame;
    private Bitmap mDirectBitmap;
    private boolean mDrawToScreen;
    private int mEffectRotation;
    private VEGetFrameEffectType mEffectType;
    private int mFacing;
    private String mFileCacheDir;
    private String mFileName;
    private VEGetFrameFitMode mFitMode;
    private int mFrameInterval;
    private String mFrameToken;
    private b mGetBitmapFrameCallback;
    private IGetFrameCallback mGetFrameCallback;
    private VEGetFrameType mGetFrameType;
    private IGetOriginFrameCallback mGetOriginFrameCallback;
    private String mKey;
    private VEMirrorMode mMirrorMode;
    private boolean mNeedDelay;
    private boolean mNeedProcessAsCameraFrame;
    private IGetFrameOnInfoCallback mOnInfoCallback;
    private boolean mOnlyRequestFrameToken;
    private VESize mOriginFrameTargetResolution;
    private String mPathOfTexture;
    private long mRecordTimestamp;
    private VEResultType mResultType;
    private int mRotation;
    private VESize mTargetResolution;
    private boolean mTwoFrameOpt;
    private boolean mUseSyncCapture;
    private boolean mWithOrigin;
    private String qualityScoreModelPath;
    private String qualityScoreSequenceId;
    private VEQualityScoreType qualityScoreType;

    public static final class Builder {
        private final VEGetFrameSettings mGetFrameSettings;

        public Builder() {
            this.mGetFrameSettings = new VEGetFrameSettings(null);
        }

        public VEGetFrameSettings build() {
            return this.mGetFrameSettings;
        }

        public Builder(VEGetFrameSettings r100) {
            this.mGetFrameSettings = r100;
        }

        public Builder setCameraFacing(int r100) {
            VEGetFrameSettings.access$2402(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setDirectBitmap(Bitmap r100) {
            VEGetFrameSettings.access$2302(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setDrawToScreen(boolean r100) {
            VEGetFrameSettings.access$602(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setEffectRotation(int r100) {
            VEGetFrameSettings.access$1402(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setEffectType(VEGetFrameEffectType r100) {
            VEGetFrameSettings.access$502(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setFileCacheDir(String r100) {
            VEGetFrameSettings.access$1702(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setFileName(String r100) {
            VEGetFrameSettings.access$1902(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setFitMode(VEGetFrameFitMode r100) {
            VEGetFrameSettings.access$1102(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setForceDriveRenderFrame(boolean r100) {
            VEGetFrameSettings.access$3202(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setFrameInterval(int r100) {
            VEGetFrameSettings.access$1802(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setGetBitmapFrameCallback(b r100) {
            VEGetFrameSettings.access$1002(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setGetFrameCallback(IGetFrameCallback r100) {
            VEGetFrameSettings.access$702(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setGetFrameOnInfoCallback(IGetFrameOnInfoCallback r100) {
            VEGetFrameSettings.access$902(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setGetFrameType(VEGetFrameType r100) {
            VEGetFrameSettings.access$102(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setGetOriginFrameCallback(IGetOriginFrameCallback r100) {
            VEGetFrameSettings.access$802(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setKey(String r100) {
            VEGetFrameSettings.access$2802(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setMirrorMode(VEMirrorMode r100) {
            VEGetFrameSettings.access$1202(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setNeedDelay(boolean r100) {
            VEGetFrameSettings.access$1602(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setNeedProcessAsCameraFrame(boolean r100) {
            VEGetFrameSettings.access$1302(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setOriginFrameTargetResolution(VESize r100) {
            VEGetFrameSettings.access$302(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setPathOfTexture(String r100) {
            VEGetFrameSettings.access$2102(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setRecordTimestamp(long r100) {
            VEGetFrameSettings.access$2602(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setRequestFrameToken(boolean r100) {
            VEGetFrameSettings.access$2702(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setResultType(VEResultType r100) {
            VEGetFrameSettings.access$2002(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setRotation(int r100) {
            VEGetFrameSettings.access$1502(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setTargetResolution(VESize r100) {
            VEGetFrameSettings.access$202(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setTwoFrameOpt(boolean r100) {
            VEGetFrameSettings.access$402(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setUseSyncCapture(boolean r100) {
            VEGetFrameSettings.access$2202(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder setWithOrigin(boolean r100) {
            VEGetFrameSettings.access$2502(this.mGetFrameSettings, r100);
            return this;
        }

        public Builder needQualityScore(VEQualityScoreType r100, String r101, String r102) {
            VEGetFrameSettings.access$2902(this.mGetFrameSettings, r100);
            VEGetFrameSettings.access$3002(this.mGetFrameSettings, r101);
            VEGetFrameSettings.access$3102(this.mGetFrameSettings, r102);
            return this;
        }
    }

    public interface IGetFrameCallback {

        /* JADX INFO: renamed from: com.ss.android.vesdk.VEGetFrameSettings$IGetFrameCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onResult(IGetFrameCallback r100, VEFrame r101, int r102) {
            }
        }

        void onResult(VEFrame r100, int r101);

        void onResult(int[] r100, int r101, int r102);
    }

    public interface IGetFrameOnInfoCallback {
        void onInfo(HashMap<String, String> r100);
    }

    public interface IGetOriginFrameCallback {
        void onResult(VEFrame r100, int r101);
    }

    public static final enum VEGetFrameEffectType extends Enum<VEGetFrameEffectType> {
        private static final /* synthetic */ VEGetFrameEffectType[] $VALUES = null;
        public static final VEGetFrameEffectType CAPTURE_IMAGE = null;
        public static final VEGetFrameEffectType FULL_EFFECT = null;
        public static final VEGetFrameEffectType NO_EFFECT = null;
        public static final VEGetFrameEffectType ORIGIN_AND_SOME_EFFECT = null;
        public static final VEGetFrameEffectType SOME_EFFECT = null;

        private static /* synthetic */ VEGetFrameEffectType[] $values() {
            return new VEGetFrameEffectType[]{NO_EFFECT, SOME_EFFECT, FULL_EFFECT, CAPTURE_IMAGE, ORIGIN_AND_SOME_EFFECT};
        }

        static {
            NO_EFFECT = new VEGetFrameEffectType("NO_EFFECT", 0);
            SOME_EFFECT = new VEGetFrameEffectType("SOME_EFFECT", 1);
            FULL_EFFECT = new VEGetFrameEffectType("FULL_EFFECT", 2);
            CAPTURE_IMAGE = new VEGetFrameEffectType("CAPTURE_IMAGE", 3);
            ORIGIN_AND_SOME_EFFECT = new VEGetFrameEffectType("ORIGIN_AND_SOME_EFFECT", 4);
            $VALUES = $values();
        }

        public static VEGetFrameEffectType[] values() {
            return (VEGetFrameEffectType[]) $VALUES.clone();
        }

        public static VEGetFrameEffectType valueOf(String r100) {
            return (VEGetFrameEffectType) r27.a.a(VEGetFrameEffectType.class, r100);
        }

        private VEGetFrameEffectType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEGetFrameFitMode extends Enum<VEGetFrameFitMode> {
        private static final /* synthetic */ VEGetFrameFitMode[] $VALUES = null;
        public static final VEGetFrameFitMode CENTER_CROP = null;
        public static final VEGetFrameFitMode CENTER_INSIDE = null;
        public static final VEGetFrameFitMode NONE = null;

        private static /* synthetic */ VEGetFrameFitMode[] $values() {
            return new VEGetFrameFitMode[]{NONE, CENTER_INSIDE, CENTER_CROP};
        }

        static {
            NONE = new VEGetFrameFitMode(UserProfileEvent.POSITION_NONE, 0);
            CENTER_INSIDE = new VEGetFrameFitMode("CENTER_INSIDE", 1);
            CENTER_CROP = new VEGetFrameFitMode("CENTER_CROP", 2);
            $VALUES = $values();
        }

        public static VEGetFrameFitMode[] values() {
            return (VEGetFrameFitMode[]) $VALUES.clone();
        }

        public static VEGetFrameFitMode valueOf(String r100) {
            return (VEGetFrameFitMode) r27.a.a(VEGetFrameFitMode.class, r100);
        }

        private VEGetFrameFitMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEGetFrameType extends Enum<VEGetFrameType> {
        private static final /* synthetic */ VEGetFrameType[] $VALUES = null;
        public static final VEGetFrameType EFF_FRAME_BY_CONFIG = null;
        public static final VEGetFrameType FOLLOW_SHOT_FRAME_MODE = null;
        public static final VEGetFrameType HD_GET_FRAME_MODE = null;
        public static final VEGetFrameType NORMAL_GET_FRAME_MODE = null;
        public static final VEGetFrameType NO_FRAME_MODE = null;
        public static final VEGetFrameType RECORD_FRAME_MODE = null;
        public static final VEGetFrameType RENDER_PICTURE_MODE = null;
        public static final VEGetFrameType SEQUENCE_FRAME_MODE = null;

        private static /* synthetic */ VEGetFrameType[] $values() {
            return new VEGetFrameType[]{NORMAL_GET_FRAME_MODE, HD_GET_FRAME_MODE, RENDER_PICTURE_MODE, FOLLOW_SHOT_FRAME_MODE, SEQUENCE_FRAME_MODE, RECORD_FRAME_MODE, EFF_FRAME_BY_CONFIG, NO_FRAME_MODE};
        }

        static {
            NORMAL_GET_FRAME_MODE = new VEGetFrameType("NORMAL_GET_FRAME_MODE", 0);
            HD_GET_FRAME_MODE = new VEGetFrameType("HD_GET_FRAME_MODE", 1);
            RENDER_PICTURE_MODE = new VEGetFrameType("RENDER_PICTURE_MODE", 2);
            FOLLOW_SHOT_FRAME_MODE = new VEGetFrameType("FOLLOW_SHOT_FRAME_MODE", 3);
            SEQUENCE_FRAME_MODE = new VEGetFrameType("SEQUENCE_FRAME_MODE", 4);
            RECORD_FRAME_MODE = new VEGetFrameType("RECORD_FRAME_MODE", 5);
            EFF_FRAME_BY_CONFIG = new VEGetFrameType("EFF_FRAME_BY_CONFIG", 6);
            NO_FRAME_MODE = new VEGetFrameType("NO_FRAME_MODE", 7);
            $VALUES = $values();
        }

        public static VEGetFrameType[] values() {
            return (VEGetFrameType[]) $VALUES.clone();
        }

        public static VEGetFrameType valueOf(String r100) {
            return (VEGetFrameType) r27.a.a(VEGetFrameType.class, r100);
        }

        private VEGetFrameType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEMirrorMode extends Enum<VEMirrorMode> {
        public static final VEMirrorMode NO_MIRROR = null;
        public static final VEMirrorMode X_MIRROR = null;
        public static final VEMirrorMode Y_MIRROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEMirrorMode[] f455626a = null;

        static {
            VEMirrorMode r100 = new VEMirrorMode("NO_MIRROR", 0);
            NO_MIRROR = r100;
            VEMirrorMode r101 = new VEMirrorMode("X_MIRROR", 1);
            X_MIRROR = r101;
            VEMirrorMode r102 = new VEMirrorMode("Y_MIRROR", 2);
            Y_MIRROR = r102;
            f455626a = new VEMirrorMode[]{r100, r101, r102};
        }

        public static VEMirrorMode[] values() {
            return (VEMirrorMode[]) f455626a.clone();
        }

        public static VEMirrorMode valueOf(String r100) {
            return (VEMirrorMode) r27.a.a(VEMirrorMode.class, r100);
        }

        public VEMirrorMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEResultType extends Enum<VEResultType> {
        private static final /* synthetic */ VEResultType[] $VALUES = null;
        public static final VEResultType IMAGE_FILE = null;
        public static final VEResultType RGBA_ARRAY = null;
        public static final VEResultType TEXTURE = null;

        private static /* synthetic */ VEResultType[] $values() {
            return new VEResultType[]{RGBA_ARRAY, IMAGE_FILE, TEXTURE};
        }

        static {
            RGBA_ARRAY = new VEResultType("RGBA_ARRAY", 0);
            IMAGE_FILE = new VEResultType("IMAGE_FILE", 1);
            TEXTURE = new VEResultType("TEXTURE", 2);
            $VALUES = $values();
        }

        public static VEResultType[] values() {
            return (VEResultType[]) $VALUES.clone();
        }

        public static VEResultType valueOf(String r100) {
            return (VEResultType) r27.a.a(VEResultType.class, r100);
        }

        private VEResultType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public interface b {
        void onResult(Bitmap r100);
    }

    public String getRequestFrameToken() {
        if (this.mFrameToken != null) goto L6;
        long r100 = System.currentTimeMillis();
        StringBuilder r101 = new StringBuilder();
        r101.append("token:");
        r101.append(r101.hashCode());
        r101.append(":");
        r101.append(r100);
        this.mFrameToken = r101.toString();
    L6:
        return this.mFrameToken;
    }

    private VEGetFrameSettings() {
        this.mGetFrameType = VEGetFrameType.NORMAL_GET_FRAME_MODE;
        this.mTargetResolution = new VESize(576, 1024);
        this.mOriginFrameTargetResolution = new VESize(360, 640);
        this.mTwoFrameOpt = false;
        this.mEffectType = VEGetFrameEffectType.NO_EFFECT;
        this.mFitMode = VEGetFrameFitMode.CENTER_CROP;
        this.mGetFrameCallback = null;
        this.mGetBitmapFrameCallback = null;
        this.mMirrorMode = VEMirrorMode.NO_MIRROR;
        this.mNeedProcessAsCameraFrame = true;
        this.mEffectRotation = 0;
        this.mRotation = 0;
        this.mNeedDelay = false;
        this.mFileName = "";
        this.mResultType = VEResultType.RGBA_ARRAY;
        this.mRecordTimestamp = 0;
        this.mOnlyRequestFrameToken = false;
        this.mFrameToken = null;
        this.mPathOfTexture = "";
        this.mFileCacheDir = "";
        this.mFrameInterval = -1;
        this.mUseSyncCapture = false;
        this.mDirectBitmap = null;
        this.mFacing = -1;
        this.mWithOrigin = false;
        this.mKey = "";
        this.qualityScoreType = VEQualityScoreType.VQScoreNone;
        this.qualityScoreSequenceId = null;
        this.qualityScoreModelPath = null;
        this.forceDriveRenderFrame = false;
    }

    public int getCameraFacing() {
        return this.mFacing;
    }

    public Bitmap getDirectBitmap() {
        return this.mDirectBitmap;
    }

    public int getEffectRotation() {
        return this.mEffectRotation;
    }

    public VEGetFrameEffectType getEffectType() {
        return this.mEffectType;
    }

    public String getFileCacheDir() {
        return this.mFileCacheDir;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public VEGetFrameFitMode getFitMode() {
        return this.mFitMode;
    }

    public int getFrameInterval() {
        return this.mFrameInterval;
    }

    public b getGetBitmapFrameCallback() {
        return this.mGetBitmapFrameCallback;
    }

    public IGetFrameCallback getGetFrameCallback() {
        return this.mGetFrameCallback;
    }

    public IGetFrameOnInfoCallback getGetFrameOnInfoCallback() {
        return this.mOnInfoCallback;
    }

    public VEGetFrameType getGetFrameType() {
        return this.mGetFrameType;
    }

    public IGetOriginFrameCallback getGetOriginFrameCallback() {
        return this.mGetOriginFrameCallback;
    }

    public String getKey() {
        return this.mKey;
    }

    public VEMirrorMode getMirrorMode() {
        return this.mMirrorMode;
    }

    public boolean getNeedDelay() {
        return this.mNeedDelay;
    }

    public boolean getNeedProcessAsCameraFrame() {
        return this.mNeedProcessAsCameraFrame;
    }

    public VESize getOriginFrameTargetResolution() {
        return this.mOriginFrameTargetResolution;
    }

    public String getPathOfTexture() {
        return this.mPathOfTexture;
    }

    public String getQualityScoreModelPath() {
        return this.qualityScoreModelPath;
    }

    public String getQualityScoreSequenceId() {
        return this.qualityScoreSequenceId;
    }

    public VEQualityScoreType getQualityScoreType() {
        return this.qualityScoreType;
    }

    public long getRecordTimestamp() {
        return this.mRecordTimestamp;
    }

    public VEResultType getResultType() {
        return this.mResultType;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public VESize getTargetResolution() {
        return this.mTargetResolution;
    }

    public boolean getUseTwoFrameOpt() {
        return this.mTwoFrameOpt;
    }

    public boolean isDrawToScreen() {
        return this.mDrawToScreen;
    }

    public boolean isForceDriveRenderFrame() {
        return this.forceDriveRenderFrame;
    }

    public boolean isOnlyRequestFrameToken() {
        return this.mOnlyRequestFrameToken;
    }

    public boolean isSyncCapture() {
        return this.mUseSyncCapture;
    }

    public boolean isWithOrigin() {
        return this.mWithOrigin;
    }

    public /* synthetic */ VEGetFrameSettings(a r100) {
        this();
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof VEGetFrameSettings) == false) goto L65;
        VEGetFrameSettings r101 = (VEGetFrameSettings) r100;
        if (this.mGetFrameType == r101.mGetFrameType) goto L9;
        return false;
    L9:
        if (this.mEffectType == r101.mEffectType) goto L11;
        return false;
    L11:
        if (this.mDrawToScreen == r101.mDrawToScreen) goto L13;
        return false;
    L13:
        if (this.mFitMode == r101.mFitMode) goto L15;
        return false;
    L15:
        if (this.mTargetResolution.equals(r101.mTargetResolution) == true) goto L17;
        return false;
    L17:
        if (this.mOriginFrameTargetResolution.equals(r101.mOriginFrameTargetResolution) == true) goto L19;
        return false;
    L19:
        if (this.mFitMode == r101.mFitMode) goto L21;
        return false;
    L21:
        if (this.mMirrorMode == r101.mMirrorMode) goto L23;
        return false;
    L23:
        if (this.mNeedProcessAsCameraFrame == r101.mNeedProcessAsCameraFrame) goto L25;
        return false;
    L25:
        if (this.mEffectRotation == r101.mEffectRotation) goto L27;
        return false;
    L27:
        if (this.mRotation == r101.mRotation) goto L29;
        return false;
    L29:
        if (this.mNeedDelay == r101.mNeedDelay) goto L31;
        return false;
    L31:
        if (this.mFileName.equals(r101.mFileName) == true) goto L33;
        return false;
    L33:
        if (this.mResultType == r101.mResultType) goto L35;
        return false;
    L35:
        if (this.mPathOfTexture.equals(r101.mPathOfTexture) == true) goto L37;
        return false;
    L37:
        if (this.mFileCacheDir.equals(r101.mFileCacheDir) == true) goto L39;
        return false;
    L39:
        if (this.mFrameInterval == r101.mFrameInterval) goto L41;
        return false;
    L41:
        if (this.mDirectBitmap == r101.mDirectBitmap) goto L43;
        return false;
    L43:
        if (this.mUseSyncCapture == r101.mUseSyncCapture) goto L45;
        return false;
    L45:
        if (this.mFacing == r101.mFacing) goto L47;
        return false;
    L47:
        if (this.mWithOrigin == r101.mWithOrigin) goto L49;
        return false;
    L49:
        if (this.mOnlyRequestFrameToken == r101.mOnlyRequestFrameToken) goto L51;
        return false;
    L51:
        if (Objects.equals(this.mFrameToken, r101.mFrameToken) == true) goto L53;
        return false;
    L53:
        if (Objects.equals(this.mKey, r101.mKey) == true) goto L55;
        return false;
    L55:
        if (this.mRecordTimestamp == r101.mRecordTimestamp) goto L57;
        return false;
    L57:
        if (TextUtils.equals(this.qualityScoreSequenceId, r101.qualityScoreSequenceId) == true) goto L59;
        return false;
    L59:
        if (TextUtils.equals(this.qualityScoreModelPath, r101.qualityScoreModelPath) == true) goto L61;
        return false;
    L61:
        if (this.forceDriveRenderFrame != r101.forceDriveRenderFrame) goto L93;
        return true;
    L93:
        return false;
    L65:
        return false;
    }

    public boolean setPathOfTexture(String r100) {
        this.mPathOfTexture = r100;
        return true;
    }

    public boolean setResultType(VEResultType r100) {
        this.mResultType = r100;
        return true;
    }

    public static /* synthetic */ b access$1002(VEGetFrameSettings r100, b r101) {
        r100.mGetBitmapFrameCallback = r101;
        return r101;
    }

    public static /* synthetic */ VEGetFrameType access$102(VEGetFrameSettings r100, VEGetFrameType r101) {
        r100.mGetFrameType = r101;
        return r101;
    }

    public static /* synthetic */ VEGetFrameFitMode access$1102(VEGetFrameSettings r100, VEGetFrameFitMode r101) {
        r100.mFitMode = r101;
        return r101;
    }

    public static /* synthetic */ VEMirrorMode access$1202(VEGetFrameSettings r100, VEMirrorMode r101) {
        r100.mMirrorMode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1302(VEGetFrameSettings r100, boolean r101) {
        r100.mNeedProcessAsCameraFrame = r101;
        return r101;
    }

    public static /* synthetic */ int access$1402(VEGetFrameSettings r100, int r101) {
        r100.mEffectRotation = r101;
        return r101;
    }

    public static /* synthetic */ int access$1502(VEGetFrameSettings r100, int r101) {
        r100.mRotation = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1602(VEGetFrameSettings r100, boolean r101) {
        r100.mNeedDelay = r101;
        return r101;
    }

    public static /* synthetic */ String access$1702(VEGetFrameSettings r100, String r101) {
        r100.mFileCacheDir = r101;
        return r101;
    }

    public static /* synthetic */ int access$1802(VEGetFrameSettings r100, int r101) {
        r100.mFrameInterval = r101;
        return r101;
    }

    public static /* synthetic */ String access$1902(VEGetFrameSettings r100, String r101) {
        r100.mFileName = r101;
        return r101;
    }

    public static /* synthetic */ VEResultType access$2002(VEGetFrameSettings r100, VEResultType r101) {
        r100.mResultType = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$202(VEGetFrameSettings r100, VESize r101) {
        r100.mTargetResolution = r101;
        return r101;
    }

    public static /* synthetic */ String access$2102(VEGetFrameSettings r100, String r101) {
        r100.mPathOfTexture = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2202(VEGetFrameSettings r100, boolean r101) {
        r100.mUseSyncCapture = r101;
        return r101;
    }

    public static /* synthetic */ Bitmap access$2302(VEGetFrameSettings r100, Bitmap r101) {
        r100.mDirectBitmap = r101;
        return r101;
    }

    public static /* synthetic */ int access$2402(VEGetFrameSettings r100, int r101) {
        r100.mFacing = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2502(VEGetFrameSettings r100, boolean r101) {
        r100.mWithOrigin = r101;
        return r101;
    }

    public static /* synthetic */ long access$2602(VEGetFrameSettings r100, long r101) {
        r100.mRecordTimestamp = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2702(VEGetFrameSettings r100, boolean r101) {
        r100.mOnlyRequestFrameToken = r101;
        return r101;
    }

    public static /* synthetic */ String access$2802(VEGetFrameSettings r100, String r101) {
        r100.mKey = r101;
        return r101;
    }

    public static /* synthetic */ VEQualityScoreType access$2902(VEGetFrameSettings r100, VEQualityScoreType r101) {
        r100.qualityScoreType = r101;
        return r101;
    }

    public static /* synthetic */ String access$3002(VEGetFrameSettings r100, String r101) {
        r100.qualityScoreSequenceId = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$302(VEGetFrameSettings r100, VESize r101) {
        r100.mOriginFrameTargetResolution = r101;
        return r101;
    }

    public static /* synthetic */ String access$3102(VEGetFrameSettings r100, String r101) {
        r100.qualityScoreModelPath = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3202(VEGetFrameSettings r100, boolean r101) {
        r100.forceDriveRenderFrame = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(VEGetFrameSettings r100, boolean r101) {
        r100.mTwoFrameOpt = r101;
        return r101;
    }

    public static /* synthetic */ VEGetFrameEffectType access$502(VEGetFrameSettings r100, VEGetFrameEffectType r101) {
        r100.mEffectType = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(VEGetFrameSettings r100, boolean r101) {
        r100.mDrawToScreen = r101;
        return r101;
    }

    public static /* synthetic */ IGetFrameCallback access$702(VEGetFrameSettings r100, IGetFrameCallback r101) {
        r100.mGetFrameCallback = r101;
        return r101;
    }

    public static /* synthetic */ IGetOriginFrameCallback access$802(VEGetFrameSettings r100, IGetOriginFrameCallback r101) {
        r100.mGetOriginFrameCallback = r101;
        return r101;
    }

    public static /* synthetic */ IGetFrameOnInfoCallback access$902(VEGetFrameSettings r100, IGetFrameOnInfoCallback r101) {
        r100.mOnInfoCallback = r101;
        return r101;
    }
}
