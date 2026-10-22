package com.obric.sva.sdk.session;

import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.config.Stage1Config;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.data.IExtendedSmModel;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.sva.sdk.listen.ObricListenTypes;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.Utils;
import com.ss.ttm.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONException;
import org.json.JSONObject;
import rna.c;

/* JADX INFO: loaded from: classes34.dex */
public class OpaqueDataHelper {
    private static final boolean DEBUG_BYTES = false;
    private static final int KWS_THRESHOLD_MAGIC = 1264014164;
    public static int KWS_THRESHOLD_PROTO_VERSION = 0;
    private static final int MILLION = 1000000;
    private static final boolean SKIP_SOUND_MODEL_PARSE = true;
    private static final int STRING_SIZE_IN_OPAQUE_DATA = 32;
    private static final int ST_MAX_CONFIDENCE_KEYWORDS = 10;
    private static final int ST_MAX_CONFIDENCE_USERS = 10;
    private static final int ST_MAX_SOUND_MODELS = 10;
    public static final int ST_PARAM_KEY_FREE_WAKE_RESULT = 35;
    public static final int ST_PARAM_KEY_FTRT_DATA_INFO = 34;
    public static final int ST_PARAM_KEY_OBRIC_KEYWORD_LENGTH_TAG = 32;
    public static final int ST_PARAM_KEY_WAKEUP_MESSAGE = 33;
    private static final int ST_SM_ID_SVA_FIRST_STAGE = 1;
    private static final int ST_SM_ID_SVA_S_STAGE_KEYPHRASE = 2;
    private static final int ST_SM_ID_SVA_S_STAGE_USER = 4;
    private static final int ST_SM_ID_SVA_UDK7_S_STAGE_KEYPHRASE = 64;
    private static final String TAG = null;
    public static final int VER_1 = 1;
    public static final int VER_2 = 2;
    private final int SIZE_OF_ENUM_ST_SOUND_MODEL_ID;
    private final int SIZE_OF_KWS_THRESHOLD_ENTRY;
    private final int SIZE_OF_KWS_THRESHOLD_HEADER;
    private final int SIZE_OF_ST_CONFIDENCE_LEVELS_INFO;
    private final int SIZE_OF_ST_HIST_BUFFER_INFO;
    private final int SIZE_OF_ST_KEYWORD_INDICES_INFO;
    private final int SIZE_OF_ST_KEYWORD_LEVELS;
    private final int SIZE_OF_ST_PARAM_HEADER;
    private final int SIZE_OF_ST_PARAM_KEY;
    private final int SIZE_OF_ST_SOUND_MODEL_CONF_LEVELS;
    private final int SIZE_OF_ST_USER_LEVEL;
    private final int SIZE_OF_TIME_STAMP_INFO;
    private final int ST_SM_ID_CUSTOM_END;
    private final int ST_SM_ID_CUSTOM_START;
    private final int ST_SM_ID_NONE;
    private final int ST_SM_ID_SVA_END;
    private boolean mHasConfidenceLevelsParam;
    private boolean mHasFirstStage;
    private boolean mHasHistBufferConfigParam;
    private boolean mHasKeywordIndicesParam;
    private boolean mHasSecondStageKey;
    private boolean mHasSecondStageUser;
    private boolean mHasStage1ConfigParam;
    private boolean mHasTimeStampParam;
    private int mNumOfModels;
    public int mNumberOfStage1Config;
    private ObricListenTypes.SVASoundModelInfo mSmInfo;
    private String mSmName;

    /* JADX INFO: renamed from: com.obric.sva.sdk.session.OpaqueDataHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BreathStatistics extends VersionIndices {
        public static int CREDIBILITY_NONE = -1;
        public static int CREDIBILITY_SUSPECT = 0;
        public static int CREDIBILITY_TRUSTED = 100;
        public static int FLAG_NORMAL = 0;
        public static int FLAG_RECORDER_NOT_START = 2;
        public static int FLAG_USER_INTERCEPT_RECORDER_NOT_FULL = 1;

        @SerializedName("adspFirstStageDetEventTime")
        public long adspFirstStageDetEventTime;

        @SerializedName("apFirstStageDetEventTime")
        public long apFirstStageDetEventTime;

        @Expose
        public transient ByteArrayOutputStream audioStream;

        @SerializedName("born")
        public long born;

        @SerializedName("credibility")
        public int credibility;

        @SerializedName("curTime")
        public int curTime;

        @SerializedName("detectionTimestampLsw")
        public long detectionTimestampLsw;

        @SerializedName("detectionTimestampMsw")
        public long detectionTimestampMsw;

        @SerializedName("engineVersion")
        public String engineVersion;

        @SerializedName("imuStartTime")
        public int imuStartTime;

        @SerializedName("millisToRead")
        public int millisToRead;

        @SerializedName("nearStartTime")
        public int nearStartTime;

        @SerializedName(WsConstants.KEY_PAYLOAD)
        public int[] payload;

        @SerializedName("traceBack")
        public int traceBack;

        @SerializedName("uploadAlgoInfoSize")
        public int uploadAlgoInfoSize;

        @SerializedName("uploadAlgoResultNum")
        public int uploadAlgoResultNum;

        @SerializedName("userData")
        public Map<String, Object> userData;

        @SerializedName("userFlag")
        public int userFlag;

        @SerializedName("vadStartTime")
        public int vadStartTime;

        public BreathStatistics() {
            super(null);
            this.credibility = CREDIBILITY_NONE;
            this.userFlag = 0;
            this.userData = new HashMap();
            this.payload = null;
            this.audioStream = new ByteArrayOutputStream();
            this.born = System.currentTimeMillis();
        }

        public static /* synthetic */ void a(JSONObject r100, String r101, Object r102) {
            lambda$userDataAsJson$0(r100, r101, r102);
        }

        public byte[] audioDataAsBytes() {
            return this.audioStream.toByteArray();
        }

        public int getUniqueWakeupId() {
            return Math.abs((int) this.born);
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("BreathStatistics @ Ver: ");
            r100.append(this.mVersion);
            r100.append(" born:");
            r100.append(this.born);
            r100.append(" traceBack: ");
            r100.append(this.traceBack);
            r100.append(" curTime:");
            r100.append(this.curTime);
            r100.append(" imuStartTime:");
            r100.append(this.imuStartTime);
            r100.append(" vadStartTime:");
            r100.append(this.vadStartTime);
            r100.append(" nearStartTime:");
            r100.append(this.nearStartTime);
            r100.append(" credibility:");
            r100.append(this.credibility);
            r100.append(" millisToRead:");
            r100.append(this.millisToRead);
            r100.append(" engineVersion:");
            r100.append(this.engineVersion);
            r100.append(" uploadAlgoInfoSize:");
            r100.append(this.uploadAlgoInfoSize);
            r100.append(" uploadAlgoResultNum:");
            r100.append(this.uploadAlgoResultNum);
            r100.append(" detectionTimestampLsw:");
            r100.append(this.detectionTimestampLsw);
            r100.append(" detectionTimestampMsw:");
            r100.append(this.detectionTimestampMsw);
            r100.append(" adspFirstStageDetEventTime:");
            r100.append(this.adspFirstStageDetEventTime);
            r100.append(" apFirstStageDetEventTime:");
            r100.append(this.apFirstStageDetEventTime);
            r100.append(" payloadSize:");
            int[] r101 = this.payload;
            if (r101 == null) goto L5;
            Object r102 = Integer.valueOf(r101.length);
        L6:
            r100.append(r102);
            r100.append(" audioStream:");
            r100.append(this.audioStream.size());
            r100.append(" userFlag:");
            r100.append(this.userFlag);
            r100.append(" userData:");
            r100.append(this.userData.toString());
            r100.append(" UniqueWakeupId :");
            r100.append(getUniqueWakeupId());
            return r100.toString();
        L5:
            r102 = "null";
            goto L6
        }

        public String userDataAsJson() {
            final JSONObject r100 = new JSONObject();
            Map<String, Object> r101 = this.userData;
            if (r101 == null) goto L8;
            if (Build.VERSION.SDK_INT < 24) goto L8;
            r101.forEach(new a(r100));
        L8:
            return r100.toString();
        }

        public boolean valid() {
            int[] r100 = this.payload;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.length <= 0) goto L7;
            return true;
        }

        private static /* synthetic */ void lambda$userDataAsJson$0(JSONObject r100, String r101, Object r102) {
            r100.put(r101, r102);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    public static class ConfidenceLevel {
        private List<KeywordLevel> mKeywordLevels;
        private int mModeId;

        private ConfidenceLevel() {
            this.mKeywordLevels = new ArrayList();
        }

        public static /* synthetic */ int access$2300(ConfidenceLevel r100) {
            return r100.mModeId;
        }

        public static /* synthetic */ List access$2400(ConfidenceLevel r100) {
            return r100.mKeywordLevels;
        }
    }

    public static class ConfidenceLevelInfo {
        private List<ConfidenceLevel> mConfidenceLevels;
        private int mVersion;

        private ConfidenceLevelInfo() {
            this.mConfidenceLevels = new ArrayList();
        }

        public /* synthetic */ ConfidenceLevelInfo(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ List access$2200(ConfidenceLevelInfo r100) {
            return r100.mConfidenceLevels;
        }
    }

    public static class CredibilityIndices extends VersionIndices {
        private int mAecState;
        private float mConfidence;
        private int mCredibility;
        public String mKeyword;
        private String mModelVersion;
        private float mThreshold;
        public float mTraceback;

        private CredibilityIndices() {
            super(null);
        }

        public /* synthetic */ CredibilityIndices(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ float access$1000(CredibilityIndices r100) {
            return r100.mThreshold;
        }

        public static /* synthetic */ int access$1100(CredibilityIndices r100) {
            return r100.mAecState;
        }

        public static /* synthetic */ String access$1200(CredibilityIndices r100) {
            return r100.mModelVersion;
        }

        public static /* synthetic */ int access$800(CredibilityIndices r100) {
            return r100.mCredibility;
        }

        public static /* synthetic */ float access$900(CredibilityIndices r100) {
            return r100.mConfidence;
        }

        public static /* synthetic */ float access$1002(CredibilityIndices r100, float r101) {
            r100.mThreshold = r101;
            return r101;
        }

        public static /* synthetic */ int access$1102(CredibilityIndices r100, int r101) {
            r100.mAecState = r101;
            return r101;
        }

        public static /* synthetic */ String access$1202(CredibilityIndices r100, String r101) {
            r100.mModelVersion = r101;
            return r101;
        }

        public static /* synthetic */ int access$802(CredibilityIndices r100, int r101) {
            r100.mCredibility = r101;
            return r101;
        }

        public static /* synthetic */ float access$902(CredibilityIndices r100, float r101) {
            r100.mConfidence = r101;
            return r101;
        }
    }

    public static class DetectionConfLevel {
        private int mAecState;
        private int mCredibility;
        private int mFKeywordLevel;
        private int mFUserLevel;
        private int mKwLength;
        private int mSKeywordLevel;
        private int mSUserLevel;
        private float mStage1Confidence;
        private String mStage1Keyword;
        private String mStage1ModelVersion;
        private float mStage1Threshold;
        private long[] mStage1TimeStamps;
        private float mStage1Traceback;
        private int mUniqueWakeupID;

        public long getAdspStage1DetEventTime() {
            return this.mStage1TimeStamps[0];
        }

        public long getApStage1DetEventTime() {
            return this.mStage1TimeStamps[1];
        }

        public String toString() {
            return "DetectionConfLevel{1st_kw=" + this.mFKeywordLevel + ",1st_user=" + this.mFUserLevel + ",2nd_kw=" + this.mSKeywordLevel + ",2nd_user=" + this.mSUserLevel + ",kw_length =" + this.mKwLength + ",credibility = " + this.mCredibility + ", adsp_stage1 = " + getAdspStage1DetEventTime() + ", ap_stage1 = " + getApStage1DetEventTime() + ", confidence =" + this.mStage1Confidence + ", threshold =" + this.mStage1Threshold + ", aec_state =" + this.mAecState + ", model_version =" + this.mStage1ModelVersion + ", keyword  = " + this.mStage1Keyword + ", traceback = " + this.mStage1Traceback + ", UniqueWakeupId = " + this.mUniqueWakeupID + i.f25855d;
        }

        public DetectionConfLevel() {
            this.mKwLength = -1;
            this.mCredibility = -1;
            this.mStage1Confidence = -1.0f;
            this.mStage1Threshold = -1.0f;
            this.mAecState = 0;
            this.mStage1Keyword = "NA";
            this.mStage1Traceback = -1.0f;
            this.mStage1TimeStamps = new long[]{0, 0};
            this.mUniqueWakeupID = Math.abs((int) System.currentTimeMillis());
        }

        public int getAecState() {
            return this.mAecState;
        }

        public float getConfidence() {
            return this.mStage1Confidence;
        }

        public int getCredibility() {
            return this.mCredibility;
        }

        public int getFKeywordLevel() {
            return this.mFKeywordLevel;
        }

        public int getFUserLevel() {
            return this.mFUserLevel;
        }

        public int getKwLength() {
            return this.mKwLength;
        }

        public String getModelVersion() {
            return this.mStage1ModelVersion;
        }

        public int getSKeywordLevel() {
            return this.mSKeywordLevel;
        }

        public int getSUserLevel() {
            return this.mSUserLevel;
        }

        public String getStage1Keyword() {
            return this.mStage1Keyword;
        }

        public float getStage1Threshold() {
            return this.mStage1Threshold;
        }

        public float getStage1Traceback() {
            return this.mStage1Traceback;
        }

        public int getUniqueWakeupID() {
            return this.mUniqueWakeupID;
        }

        public static /* synthetic */ long[] access$2100(DetectionConfLevel r100) {
            return r100.mStage1TimeStamps;
        }

        public static /* synthetic */ int access$2600(DetectionConfLevel r100) {
            return r100.mFKeywordLevel;
        }

        public static /* synthetic */ int access$2900(DetectionConfLevel r100) {
            return r100.mFUserLevel;
        }

        public static /* synthetic */ int access$3000(DetectionConfLevel r100) {
            return r100.mSKeywordLevel;
        }

        public static /* synthetic */ int access$3100(DetectionConfLevel r100) {
            return r100.mSUserLevel;
        }

        public static /* synthetic */ int access$1302(DetectionConfLevel r100, int r101) {
            r100.mKwLength = r101;
            return r101;
        }

        public static /* synthetic */ int access$1402(DetectionConfLevel r100, int r101) {
            r100.mCredibility = r101;
            return r101;
        }

        public static /* synthetic */ float access$1502(DetectionConfLevel r100, float r101) {
            r100.mStage1Confidence = r101;
            return r101;
        }

        public static /* synthetic */ float access$1602(DetectionConfLevel r100, float r101) {
            r100.mStage1Threshold = r101;
            return r101;
        }

        public static /* synthetic */ int access$1702(DetectionConfLevel r100, int r101) {
            r100.mAecState = r101;
            return r101;
        }

        public static /* synthetic */ String access$1802(DetectionConfLevel r100, String r101) {
            r100.mStage1ModelVersion = r101;
            return r101;
        }

        public static /* synthetic */ String access$1902(DetectionConfLevel r100, String r101) {
            r100.mStage1Keyword = r101;
            return r101;
        }

        public static /* synthetic */ float access$2002(DetectionConfLevel r100, float r101) {
            r100.mStage1Traceback = r101;
            return r101;
        }

        public static /* synthetic */ int access$2602(DetectionConfLevel r100, int r101) {
            r100.mFKeywordLevel = r101;
            return r101;
        }

        public static /* synthetic */ int access$2902(DetectionConfLevel r100, int r101) {
            r100.mFUserLevel = r101;
            return r101;
        }

        public static /* synthetic */ int access$3002(DetectionConfLevel r100, int r101) {
            r100.mSKeywordLevel = r101;
            return r101;
        }

        public static /* synthetic */ int access$3102(DetectionConfLevel r100, int r101) {
            r100.mSUserLevel = r101;
            return r101;
        }
    }

    public static class KeywordIndices extends VersionIndices {
        private int mLength;

        private KeywordIndices() {
            super(null);
        }

        public /* synthetic */ KeywordIndices(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ int access$700(KeywordIndices r100) {
            return r100.mLength;
        }

        public static /* synthetic */ int access$702(KeywordIndices r100, int r101) {
            r100.mLength = r101;
            return r101;
        }
    }

    public static class KeywordLevel {
        private int mLevel;
        private List<UserLevel> mUserLevels;

        private KeywordLevel() {
            this.mUserLevels = new ArrayList();
        }

        public static /* synthetic */ int access$2500(KeywordLevel r100) {
            return r100.mLevel;
        }

        public static /* synthetic */ List access$2700(KeywordLevel r100) {
            return r100.mUserLevels;
        }
    }

    public static final enum ST_Param_Key extends Enum<ST_Param_Key> {
        private static final /* synthetic */ ST_Param_Key[] $VALUES = null;
        public static final ST_Param_Key ST_PARAM_KEY_CONFIDENCE_LEVELS = null;
        public static final ST_Param_Key ST_PARAM_KEY_HISTORY_BUFFER_CONFIG = null;
        public static final ST_Param_Key ST_PARAM_KEY_KEYWORD_INDICES = null;
        public static final ST_Param_Key ST_PARAM_KEY_STAGE1_CONFIG_THRESHOLD = null;
        public static final ST_Param_Key ST_PARAM_KEY_TIMESTAMP = null;
        private final int code;

        static {
            ST_Param_Key r100 = new ST_Param_Key("ST_PARAM_KEY_CONFIDENCE_LEVELS", 0, 0);
            ST_PARAM_KEY_CONFIDENCE_LEVELS = r100;
            ST_Param_Key r101 = new ST_Param_Key("ST_PARAM_KEY_HISTORY_BUFFER_CONFIG", 1, 1);
            ST_PARAM_KEY_HISTORY_BUFFER_CONFIG = r101;
            ST_Param_Key r102 = new ST_Param_Key("ST_PARAM_KEY_KEYWORD_INDICES", 2, 2);
            ST_PARAM_KEY_KEYWORD_INDICES = r102;
            ST_Param_Key r103 = new ST_Param_Key("ST_PARAM_KEY_TIMESTAMP", 3, 3);
            ST_PARAM_KEY_TIMESTAMP = r103;
            ST_Param_Key r104 = new ST_Param_Key("ST_PARAM_KEY_STAGE1_CONFIG_THRESHOLD", 4, 32);
            ST_PARAM_KEY_STAGE1_CONFIG_THRESHOLD = r104;
            $VALUES = new ST_Param_Key[]{r100, r101, r102, r103, r104};
        }

        public static ST_Param_Key[] values() {
            return (ST_Param_Key[]) $VALUES.clone();
        }

        public int getCode() {
            return this.code;
        }

        public static ST_Param_Key valueOf(String r100) {
            return (ST_Param_Key) r27.a.a(ST_Param_Key.class, r100);
        }

        private ST_Param_Key(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public static class TimeStampIndices extends VersionIndices {
        private long adsp_stage1_det_event_time;
        private long ap_stage1_det_event_time;

        private TimeStampIndices() {
            super(null);
        }

        public /* synthetic */ TimeStampIndices(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ long access$500(TimeStampIndices r100) {
            return r100.adsp_stage1_det_event_time;
        }

        public static /* synthetic */ long access$600(TimeStampIndices r100) {
            return r100.ap_stage1_det_event_time;
        }

        public static /* synthetic */ long access$502(TimeStampIndices r100, long r101) {
            r100.adsp_stage1_det_event_time = r101;
            return r101;
        }

        public static /* synthetic */ long access$602(TimeStampIndices r100, long r101) {
            r100.ap_stage1_det_event_time = r101;
            return r101;
        }
    }

    public static class UserLevel {
        private int mLevel;
        private int mUserId;

        private UserLevel() {
        }

        public static /* synthetic */ int access$2800(UserLevel r100) {
            return r100.mLevel;
        }
    }

    public static abstract class VersionIndices {

        @SerializedName("mVersion")
        public int mVersion;

        private VersionIndices() {
        }

        public /* synthetic */ VersionIndices(AnonymousClass1 r100) {
            this();
        }
    }

    private int sizeOfEntry() {
        return 40;
    }

    private int sizeOfHeader() {
        return 12;
    }

    public byte[] fillOpaqueDataByteBuffer(int r100, int r101) {
        return new byte[]{(byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255), (byte) (r101 & 255), (byte) ((r101 >> 8) & 255), (byte) ((r101 >> 16) & 255), (byte) ((r101 >> 24) & 255)};
    }

    static {
        TAG = "OpaqueDataHelper";
        KWS_THRESHOLD_PROTO_VERSION = 2;
    }

    private int protoVersion() {
        return KWS_THRESHOLD_PROTO_VERSION;
    }

    public static float[] calculateAverageScores(int[] r100) {
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (r100.length == 0) goto L16;
        int r101 = r100.length / 4;
        if (r101 != 0) goto L10;
        return null;
    L10:
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L12:
        if (r102 >= r101) goto L14;
        int r106 = r102 * 4;
        r103 = r103 + r100[r106 + 1];
        r104 = r104 + r100[r106 + 2];
        r105 = r105 + r100[r106 + 3];
        r102 = r102 + 1;
        goto L12
    L14:
        float r107 = r101 * 1000;
        return new float[]{r103 / r107, r104 / r107, r105 / r107};
    }

    private int getTotalBufferSize(Stage1Config r100) {
        if (this.mHasConfidenceLevelsParam == false) goto L5;
        int r101 = 8896;
    L7:
        if (this.mHasHistBufferConfigParam == false) goto L10;
        r101 = r101 + 20;
    L10:
        if (this.mHasKeywordIndicesParam == false) goto L13;
        r101 = r101 + 20;
    L13:
        if (this.mHasTimeStampParam == false) goto L16;
        r101 = r101 + 16;
    L16:
        if (this.mHasStage1ConfigParam == false) goto L26;
        if (r100 != null) goto L19;
        return r101;
    L19:
        if (r100.size() <= 0) goto L28;
        int r102 = (r100.size() * 40) + 12;
        if (protoVersion() != 1) goto L24;
    L29:
        return r101 + r102;
    L24:
        if (protoVersion() != 2) goto L30;
        r102 = r102 + 8;
        goto L29
    L30:
        return r101;
    L28:
        return r101;
    L26:
        return r101;
    L5:
        r101 = 0;
        goto L7
    }

    public static BreathStatistics parseBreath(byte[] r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        if (r110.length == 0) goto L69;
        LogUtils.d(TAG, "parseBreath opaqueData.length = " + r110.length, new Object[0]);
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L9:
        if (r101 >= r110.length) goto L11;
        r100.append(byte2Int(r110, r101));
        r100.append(",");
        r101 = r101 + 4;
        goto L9
    L11:
        LogUtils.d(TAG, "parse opaqueData = " + r100, new Object[0]);
        if (r110.length != 1) goto L14;
        return null;
    L14:
        BreathStatistics r102 = new BreathStatistics();
        int r103 = 0;
    L16:
        if (r103 >= r110.length) goto L51;
        if ((r103 + 8) >= r110.length) goto L51;
        int r104 = byte2Int(r110, r103);
        int r105 = r103 + 4;
        int r106 = byte2Int(r110, r105);
        r103 = r105 + 4;
        String r107 = TAG;
        LogUtils.d(r107, "tag = " + r104, new Object[0]);
        LogUtils.d(r107, "payloadSize = " + r106, new Object[0]);
        if (r104 != 35) goto L16;
        LogUtils.d(r107, "ST_PARAM_BREATH_DETECT_RESULT " + r104, new Object[0]);
        int r108 = byte2Int(r110, r103);
        r102.mVersion = r108;
        int r109 = r103 + 4;
        if (r108 != 1) goto L33;
        r102.traceBack = byte2Int(r110, r109);
        int r111 = r109 + 4;
        r102.curTime = byte2Int(r110, r111);
        int r112 = r111 + 4;
        r102.imuStartTime = byte2Int(r110, r112);
        int r113 = r112 + 4;
        r102.vadStartTime = byte2Int(r110, r113);
        int r114 = r113 + 4;
        r102.nearStartTime = byte2Int(r110, r114);
        int r115 = r114 + 4;
        byte[] r116 = new byte[32];
        System.arraycopy(r110, r115, r116, 0, 32);
        LogUtils.d(r107, "byte array of engineVersion is : " + Arrays.toString(r116), new Object[0]);
        StringBuilder r117 = new StringBuilder();
        int r118 = 0;
    L25:
        if (r118 >= 32) goto L29;
        byte r119 = r116[r118];
        if (r119 <= 0) goto L29;
        r117.append((char) r119);
        r118 = r118 + 1;
    L29:
        r102.engineVersion = r117.toString();
        int r120 = r115 + 32;
        r102.uploadAlgoInfoSize = byte2Int(r110, r120);
        int r121 = r120 + 4;
        int r122 = byte2Int(r110, r121);
        r102.uploadAlgoResultNum = r122;
        int r123 = r121 + 4;
        int r124 = r102.uploadAlgoInfoSize * r122;
        r102.payload = new int[r124];
        int r125 = 0;
    L30:
        if (r125 >= r124) goto L49;
        r102.payload[r125] = byte2Int(r110, (r125 * 4) + r123);
        r125 = r125 + 1;
    L49:
        r103 = r103 + r106;
        goto L16
    L33:
        if (r108 == 2) goto L35;
        if (r108 != 3) goto L49;
    L35:
        r102.traceBack = byte2Int(r110, r109);
        int r126 = r109 + 4;
        r102.curTime = byte2Int(r110, r126);
        int r127 = r126 + 4;
        r102.imuStartTime = byte2Int(r110, r127);
        int r128 = r127 + 4;
        r102.vadStartTime = byte2Int(r110, r128);
        int r129 = r128 + 4;
        r102.nearStartTime = byte2Int(r110, r129);
        int r130 = r129 + 4;
        r102.credibility = byte2Int(r110, r130);
        int r131 = r130 + 4;
        r102.millisToRead = byte2Int(r110, r131);
        int r132 = r131 + 4;
        byte[] r133 = new byte[32];
        System.arraycopy(r110, r132, r133, 0, 32);
        LogUtils.d(r107, "byte array of engineVersion is : " + Arrays.toString(r133), new Object[0]);
        StringBuilder r134 = new StringBuilder();
        int r135 = 0;
    L36:
        if (r135 >= 32) goto L40;
        byte r136 = r133[r135];
        if (r136 <= 0) goto L40;
        r134.append((char) r136);
        r135 = r135 + 1;
    L40:
        String r137 = r134.toString();
        String r138 = TAG;
        LogUtils.d(r138, "engineVersion is : " + r137, new Object[0]);
        r102.engineVersion = r137;
        int r139 = r132 + 32;
        if (r102.mVersion != 3) goto L46;
        int r140 = Math.min(r103 + r106, r110.length);
        if ((r139 + 24) > r140) goto L45;
        r102.detectionTimestampLsw = byte2UInt(r110, r139);
        int r141 = r139 + 4;
        r102.detectionTimestampMsw = byte2UInt(r110, r141);
        int r142 = r141 + 4;
        r102.adspFirstStageDetEventTime = byte2Long(r110, r142);
        int r143 = r142 + 8;
        r102.apFirstStageDetEventTime = byte2Long(r110, r143);
        r139 = r143 + 8;
        LogUtils.d(r138, "breath v3 timestamps detectionTimestampLsw=" + r102.detectionTimestampLsw + ", detectionTimestampMsw=" + r102.detectionTimestampMsw + ", adspFirstStageDetEventTime=" + r102.adspFirstStageDetEventTime + ", apFirstStageDetEventTime=" + r102.apFirstStageDetEventTime, new Object[0]);
        goto L46
    L45:
        LogUtils.d(r138, "breath v3 timestamp fields missing before payload, localIndex=" + r139 + ", payloadEnd=" + r140, new Object[0]);
    L46:
        r102.uploadAlgoInfoSize = byte2Int(r110, r139);
        int r144 = r139 + 4;
        int r145 = byte2Int(r110, r144);
        r102.uploadAlgoResultNum = r145;
        int r146 = r144 + 4;
        int r147 = r102.uploadAlgoInfoSize * r145;
        r102.payload = new int[r147];
        int r148 = 0;
    L47:
        if (r148 >= r147) goto L49;
        r102.payload[r148] = byte2Short(r110, (r148 * 2) + r146);
        r148 = r148 + 1;
    L51:
        if (r102.payload != null) goto L54;
        return null;
    L54:
        return r102;
    L69:
        return null;
    }

    public static DetectionConfLevel parseVoice(byte[] r210) {
        int r100 = 0;
        LogUtils.d(TAG, "parseVoice opaqueData.length = " + r210.length, new Object[0]);
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= r210.length) goto L6;
        r101.append(byte2Int(r210, r102));
        r101.append(",");
        r102 = r102 + 4;
        goto L4
    L6:
        LogUtils.d(TAG, "parse opaqueData = " + r101, new Object[0]);
        AnonymousClass1 r103 = null;
        if (r210.length != 1) goto L9;
        return null;
    L9:
        ConfidenceLevelInfo r104 = new ConfidenceLevelInfo(r103);
        KeywordIndices r105 = new KeywordIndices(r103);
        CredibilityIndices r106 = new CredibilityIndices(r103);
        TimeStampIndices r107 = new TimeStampIndices(r103);
        int r108 = 0;
    L11:
        if (r108 >= r210.length) goto L59;
        if ((r108 + 8) >= r210.length) goto L59;
        int r109 = byte2Int(r210, r108);
        int r110 = r108 + 4;
        int r111 = byte2Int(r210, r110);
        int r112 = r110 + 4;
        String r113 = TAG;
        LogUtils.d(r113, "tag = " + r109, new Object[r100]);
        LogUtils.d(r113, "payloadSize = " + r111, new Object[r100]);
        if (r109 != ST_Param_Key.ST_PARAM_KEY_HISTORY_BUFFER_CONFIG.getCode()) goto L18;
    L55:
        r104 = r104;
        r105 = r105;
        int r211 = r112;
        r107 = r107;
        LogUtils.d(r113, "ST_PARAM_KEY_HISTORY_BUFFER_CONFIG or ST_PARAM_KEY_TIMESTAMP  or ST_PARAM_KEY_KEYWORD_INDICES= " + r109, new Object[0]);
    L56:
        r108 = r211 + r111;
    L57:
        r104 = r104;
        r105 = r105;
        r107 = r107;
        r100 = 0;
        goto L11
    L18:
        if (r109 == ST_Param_Key.ST_PARAM_KEY_KEYWORD_INDICES.getCode()) goto L55;
        if (r109 != ST_Param_Key.ST_PARAM_KEY_TIMESTAMP.getCode()) goto L26;
        LogUtils.d(r113, "ST_PARAM_KEY_TIMESTAMP " + r109, new Object[r100]);
        r107.mVersion = byte2Int(r210, r112);
        int r114 = ((r112 + 4) + 8) + 8;
        TimeStampIndices.access$502(r107, byte2Long(r210, r114));
        TimeStampIndices.access$602(r107, byte2Long(r210, r114 + 8));
    L23:
        r108 = r112 + r111;
        goto L57
    L26:
        if (r109 != 32) goto L29;
        LogUtils.d(r113, "ST_PARAM_KEY_OBRIC_KEYWORD_LENGTH_TAG = " + r109 + " startIndex :" + r112, new Object[r100]);
        r105.mVersion = byte2Int(r210, r112);
        KeywordIndices.access$702(r105, byte2Int(r210, r112 + 4));
        LogUtils.d(r113, "version =  " + r105.mVersion + ", length=" + KeywordIndices.access$700(r105), new Object[r100]);
        goto L23
    L29:
        if (r109 != ST_Param_Key.ST_PARAM_KEY_CONFIDENCE_LEVELS.getCode()) goto L35;
        LogUtils.d(r113, "ST_PARAM_KEY_CONFIDENCE_LEVELS = " + r109, new Object[r100]);
        int r115 = r111 + r112;
        if (r115 >= r210.length) goto L59;
        LogUtils.d(r113, "version = " + byte2Int(r210, r112) + ",confidenceLevelsSize=" + byte2Int(r210, r112 + 4), new Object[r100]);
        r108 = r115;
        goto L57
    L35:
        if (r109 != 33) goto L51;
        LogUtils.d(r113, "ST_PARAM_KEY_CREDIBILITY_TAG = " + r109 + " payload size = " + r111 + "", new Object[r100]);
        int r116 = byte2Int(r210, r112);
        int r117 = r112 + 4;
        int r118 = byte2Int(r210, r117);
        int r119 = r117 + 4;
        float r120 = ((float) byte2Int(r210, r119)) / 1000000.0f;
        int r121 = r119 + 4;
        float r122 = byte2Int(r210, r121) / 1000000.0f;
        int r123 = r121 + 4;
        int r124 = byte2Int(r210, r123);
        int r125 = r123 + 4;
        byte[] r126 = new byte[32];
        System.arraycopy(r210, r125, r126, 0, 32);
        LogUtils.d(r113, "byte array of modleVersion is : " + Arrays.toString(r126), new Object[0]);
        StringBuilder r127 = new StringBuilder();
        int r128 = 0;
    L38:
        if (r128 >= 32) goto L42;
        byte r129 = r126[r128];
        if (r129 <= 0) goto L42;
        r127.append((char) r129);
        r128 = r128 + 1;
    L42:
        String r130 = r127.toString();
        int r131 = r125 + 32;
        byte[] r132 = new byte[32];
        System.arraycopy(r210, r131, r132, 0, 32);
        LogUtils.d(TAG, "byte array of keywords is : " + Arrays.toString(r132), new Object[0]);
        int r133 = 0;
        int r134 = 0;
    L43:
        if (r133 >= 32) goto L47;
        if (r132[r133] == 0) goto L47;
        r134 = r134 + 1;
        r133 = r133 + 1;
    L47:
        if (r134 <= 0) goto L49;
        byte[] r135 = new byte[r134];
        System.arraycopy(r132, 0, r135, 0, r134);
        String r136 = Utils.byteToUtf8(r135);
    L50:
        float r137 = byte2Int(r210, r131 + 32) / 1000000.0f;
        LogUtils.d(TAG, "version = " + r116 + ",credibility=" + r118 + " confidence=" + r120 + " threshold:" + r122 + " aecState :" + r124 + " modelVersion:" + r130 + " keyword:" + r136 + " traceback:" + r137, new Object[0]);
        CredibilityIndices.access$802(r106, r118);
        r106.mVersion = r116;
        CredibilityIndices.access$902(r106, r120);
        CredibilityIndices.access$1002(r106, r122);
        CredibilityIndices.access$1102(r106, r124);
        CredibilityIndices.access$1202(r106, r130);
        r106.mKeyword = r136;
        r106.mTraceback = r137;
        r108 = r112 + r111;
        goto L57
    L49:
        r136 = "";
        goto L50
    L51:
        r104 = r104;
        r105 = r105;
        r211 = r112;
        r107 = r107;
        if (r109 != 34) goto L54;
        LogUtils.d(r113, "ST_PARAM_KEY_FTRT_DATA_INFO = " + r109, new Object[0]);
        goto L56
    L54:
        r108 = r211;
    L59:
        return convert2ConfLevel(r104, r105, r106, r107);
    }

    private ObricListenTypes.SVASoundModelInfo query(String r100) {
        String r101 = TAG;
        LogUtils.d(r101, "query: smFullName = " + r100, new Object[0]);
        if (r100 != null) goto L7;
        LogUtils.d(r101, "query: invalid input param", new Object[0]);
        return null;
    L7:
        if (c.c(Global.getInstance().PATH_ROOT + HTTP.URL_DEFAULT + r100) == true) goto L15;
        LogUtils.d(r101, "query: error file not exists", new Object[0]);
        return null;
    L15:
        ObricListenTypes.SVASoundModelInfo r102 = new ObricListenTypes.SVASoundModelInfo();     // Catch: Exception -> L10
        r102.version = 0;     // Catch: Exception -> L10
        r102.type = 0;     // Catch: Exception -> L10
        r102.keywordInfo = new ObricListenTypes.KeywordInfo[1];     // Catch: Exception -> L10
        ObricListenTypes.KeywordInfo r103 = new ObricListenTypes.KeywordInfo();     // Catch: Exception -> L10
        r103.keywordPhrase = "obric";     // Catch: Exception -> L10
        r103.activeUsers = new String[]{"obric"};     // Catch: Exception -> L10
        r102.keywordInfo[0] = r103;     // Catch: Exception -> L10
        r102.userNames = new String[]{"obric"};     // Catch: Exception -> L10
        return r102;
    L10:
        e = move-exception;
        LogUtils.e(TAG, "query: error " + e, new Object[0]);
        return null;
    }

    public static float byte2Float(byte[] r100, int r101) {
        byte[] r102 = new byte[4];
        System.arraycopy(r100, r101, r102, 0, 4);
        return ByteBuffer.wrap(r102).getFloat();
    }

    public static int byte2Int(byte[] r100, int r101) {
        if ((r101 + 4) <= r100.length) goto L6;
        LogUtils.d("byte2Int start + 4 out of array", new Object[0]);
        return 0;
    L6:
        int r102 = r101 + 1;
        int r103 = r102 + 1;
        int r104 = (r100[r101] & UByte.MAX_VALUE) | ((r100[r102] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        return ((r100[r105] & UByte.MAX_VALUE) << 24) | r106;
    }

    public static long byte2Long(byte[] r100, int r101) {
        if ((r101 + 8) <= r100.length) goto L6;
        LogUtils.d("byte2Long start + 8 out of array", new Object[0]);
        return 0;
    L6:
        int r102 = r101 + 1;
        int r103 = r102 + 1;
        int r104 = (r100[r101] & UByte.MAX_VALUE) | ((r100[r102] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        long r106 = r104 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        int r107 = r105 + 1;
        int r108 = r107 + 1;
        long r109 = (r106 | (((long) (r100[r105] & UByte.MAX_VALUE)) << 24)) | (((long) (r100[r107] & UByte.MAX_VALUE)) << 32);
        int r110 = r108 + 1;
        long r111 = r109 | (((long) (r100[r108] & UByte.MAX_VALUE)) << 40);
        int r112 = r110 + 1;
        return (((long) (r100[r112] & UByte.MAX_VALUE)) << 56) | (r111 | (((long) (r100[r110] & UByte.MAX_VALUE)) << 48));
    }

    public static short byte2Short(byte[] r100, int r101) {
        if ((r101 + 2) <= r100.length) goto L6;
        LogUtils.d("byte2Short start + 2 out of array", new Object[0]);
        return 0;
    L6:
        int r102 = r101 + 1;
        int r103 = r100[r101] & UByte.MAX_VALUE;
        return (short) (((r100[r102] & UByte.MAX_VALUE) << 8) | r103);
    }

    public static long byte2UInt(byte[] r100, int r101) {
        return ((long) byte2Int(r100, r101)) & BodyPartID.bodyIdMax;
    }

    private void fillTimeStampParam(byte[] r100, int r101) {
        fillInt(r100, r101, ST_Param_Key.ST_PARAM_KEY_TIMESTAMP.getCode());
        fillInt(r100, r101 + 4, 8);
        int r102 = r101 + 8;
        fillLong(r100, r102, System.currentTimeMillis());
    }

    private void fillInt(byte[] r100, int r101, int r102) {
        r100[r101] = (byte) (r102 & 255);
        int r103 = r101 + 1;
        r100[r103] = (byte) ((r102 >> 8) & 255);
        int r104 = r103 + 1;
        r100[r104] = (byte) ((r102 >> 16) & 255);
        r100[r104 + 1] = (byte) ((r102 >> 24) & 255);
    }

    private void fillLong(byte[] r100, int r101, long r102) {
        r100[r101] = (byte) (r102 & 255);
        int r103 = r101 + 1;
        r100[r103] = (byte) ((r102 >> 8) & 255);
        int r104 = r103 + 1;
        r100[r104] = (byte) ((r102 >> 16) & 255);
        int r105 = r104 + 1;
        r100[r105] = (byte) ((r102 >> 24) & 255);
        int r106 = r105 + 1;
        r100[r106] = (byte) ((r102 >> 32) & 255);
        int r107 = r106 + 1;
        r100[r107] = (byte) ((r102 >> 40) & 255);
        int r108 = r107 + 1;
        r100[r108] = (byte) ((r102 >> 48) & 255);
        r100[r108 + 1] = (byte) ((r102 >> 56) & 255);
    }

    private void fillStage1ConfigParam(byte[] r110, int r111, Stage1Config r112) {
        int r100 = r112.size();
        int r101 = protoVersion();
        if (r101 != 1) goto L5;
        if (r100 != 0) goto L13;
        return;
    L13:
        fillInt(r110, r111, KWS_THRESHOLD_MAGIC);
        int r113 = r111 + 4;
        r110[r113] = 1;
        r110[r113 + 1] = 0;
        r110[r113 + 2] = (byte) (r100 & 255);
        r110[r113 + 3] = (byte) ((r100 >> 8) & 255);
        int r102 = sizeOfHeader() + (sizeOfEntry() * r100);
        r110[r113 + 4] = (byte) (r102 & 255);
        r110[r113 + 5] = (byte) ((r102 >> 8) & 255);
        r110[r113 + 6] = 0;
        r110[r113 + 7] = 0;
    L14:
        int r114 = r113 + 8;
        LogUtils.d(TAG, "fillStage1ConfigParam number entry " + r100 + " with version:  " + protoVersion(), new Object[0]);
        int r103 = 0;
    L15:
        if (r103 >= r100) goto L29;
        Stage1Config.MiniConfig r104 = (Stage1Config.MiniConfig) ListProtector.get(r112.getConfigList(), r103);
        if (r104 == null) goto L28;
        int r105 = (sizeOfEntry() * r103) + r114;
        byte[] r106 = r104.getVersion().getBytes();
        int r107 = 0;
    L21:
        if (r107 >= 32) goto L27;
        int r108 = r105 + r107;
        if (r107 >= r106.length) goto L25;
        byte r109 = r106[r107];
    L26:
        r110[r108] = r109;
        r107 = r107 + 1;
        goto L21
    L25:
        r109 = 0;
        goto L26
    L27:
        r110[r105 + 32] = r104.getEnable().booleanValue();
        r110[r105 + 33] = 0;
        r110[r105 + 34] = 0;
        r110[r105 + 35] = 0;
        fillInt(r110, r105 + 36, Float.floatToIntBits(r104.getThreshold().floatValue()));
    L28:
        r103 = r103 + 1;
        goto L15
    L29:
        return;
    L5:
        if (r101 == 2) goto L8;
        LogUtils.e(TAG, "fillStage1ConfigParam unknown protoVersion " + protoVersion(), new Object[0]);
        return;
    L8:
        if (r100 != 0) goto L10;
        return;
    L10:
        fillInt(r110, r111, ST_Param_Key.ST_PARAM_KEY_STAGE1_CONFIG_THRESHOLD.getCode());
        int r115 = r111 + 4;
        int r116 = sizeOfHeader() + (sizeOfEntry() * r100);
        fillInt(r110, r115, r116);
        int r117 = r115 + 4;
        fillInt(r110, r117, KWS_THRESHOLD_MAGIC);
        r113 = r117 + 4;
        r110[r113] = 1;
        r110[r113 + 1] = 0;
        r110[r113 + 2] = (byte) (r100 & 255);
        r110[r113 + 3] = (byte) ((r100 >> 8) & 255);
        r110[r113 + 4] = (byte) (r116 & 255);
        r110[r113 + 5] = (byte) ((r116 >> 8) & 255);
        r110[r113 + 6] = 0;
        r110[r113 + 7] = 0;
        goto L14
    }

    private static DetectionConfLevel convert2ConfLevel(ConfidenceLevelInfo r100, KeywordIndices r101, CredibilityIndices r102, TimeStampIndices r103) {
        DetectionConfLevel r104 = new DetectionConfLevel();
        DetectionConfLevel.access$1302(r104, KeywordIndices.access$700(r101));
        DetectionConfLevel.access$1402(r104, CredibilityIndices.access$800(r102));
        DetectionConfLevel.access$1502(r104, CredibilityIndices.access$900(r102));
        DetectionConfLevel.access$1602(r104, CredibilityIndices.access$1000(r102));
        DetectionConfLevel.access$1702(r104, CredibilityIndices.access$1100(r102));
        DetectionConfLevel.access$1802(r104, CredibilityIndices.access$1200(r102));
        DetectionConfLevel.access$1902(r104, r102.mKeyword);
        DetectionConfLevel.access$2002(r104, r102.mTraceback);
        DetectionConfLevel.access$2100(r104)[0] = TimeStampIndices.access$500(r103) / 1000;
        DetectionConfLevel.access$2100(r104)[1] = TimeStampIndices.access$600(r103) / 1000;
        Iterator r105 = ConfidenceLevelInfo.access$2200(r100).iterator();
    L4:
        if (r105.hasNext() == false) goto L30;
        ConfidenceLevel r106 = (ConfidenceLevel) r105.next();
        int r107 = ConfidenceLevel.access$2300(r106);
        String r108 = TAG;
        LogUtils.d(r108, "modeId = " + r107, new Object[0]);
        if (1 == r107) goto L8;
        if (2 == r107) goto L18;
        if (4 != r107) goto L4;
        if (ConfidenceLevel.access$2400(r106).isEmpty() == false) goto L25;
        LogUtils.e(r108, "sStage keywordLevels is empty", new Object[0]);
        goto L4
    L25:
        KeywordLevel r109 = (KeywordLevel) ListProtector.get(ConfidenceLevel.access$2400(r106), 0);
        if (KeywordLevel.access$2700(r109).isEmpty() == false) goto L27;
        LogUtils.e(r108, "sStage userLevels is empty", new Object[0]);
        goto L4
    L27:
        DetectionConfLevel.access$3102(r104, UserLevel.access$2800((UserLevel) ListProtector.get(KeywordLevel.access$2700(r109), 0)));
        LogUtils.d(r108, "sStage user level = " + DetectionConfLevel.access$3100(r104), new Object[0]);
        goto L4
    L18:
        if (ConfidenceLevel.access$2400(r106).isEmpty() == false) goto L19;
        LogUtils.e(r108, "sStage keywordLevels is empty", new Object[0]);
        goto L4
    L19:
        DetectionConfLevel.access$3002(r104, KeywordLevel.access$2500((KeywordLevel) ListProtector.get(ConfidenceLevel.access$2400(r106), 0)));
        LogUtils.d(r108, "sStage keyword level = " + DetectionConfLevel.access$3000(r104), new Object[0]);
        goto L4
    L8:
        if (ConfidenceLevel.access$2400(r106).isEmpty() == false) goto L9;
        LogUtils.e(r108, "fStage keywordLevels is empty", new Object[0]);
        goto L4
    L9:
        KeywordLevel r110 = (KeywordLevel) ListProtector.get(ConfidenceLevel.access$2400(r106), 0);
        LogUtils.d(r108, "fStage keyword level = " + KeywordLevel.access$2500(r110), new Object[0]);
        DetectionConfLevel.access$2602(r104, KeywordLevel.access$2500(r110));
        if (KeywordLevel.access$2700(r110).isEmpty() == true) goto L12;
        UserLevel r111 = (UserLevel) ListProtector.get(KeywordLevel.access$2700(r110), 0);
        LogUtils.d(r108, "fStage user level = " + UserLevel.access$2800(r111), new Object[0]);
        DetectionConfLevel.access$2902(r104, UserLevel.access$2800(r111));
    L13:
        LogUtils.d(r108, "fStage keyword level = " + DetectionConfLevel.access$2600(r104) + " user level = " + DetectionConfLevel.access$2900(r104), new Object[0]);
        goto L4
    L12:
        LogUtils.e(r108, "fStage userLevels is empty", new Object[0]);
        goto L13
    L30:
        return r104;
    }

    private void fillHistBufferConfigParam(byte[] r100, int r101, int r102, int r103) {
        fillInt(r100, r101, ST_Param_Key.ST_PARAM_KEY_HISTORY_BUFFER_CONFIG.getCode());
        fillInt(r100, r101 + 4, 12);
        fillInt(r100, r101 + 8, 2);
        fillInt(r100, r101 + 12, r102);
        fillInt(r100, r101 + 16, r103);
    }

    private void fillKeywordIndicesParam(byte[] r100, int r101, int r102, int r103) {
        fillInt(r100, r101, ST_Param_Key.ST_PARAM_KEY_KEYWORD_INDICES.getCode());
        fillInt(r100, r101 + 4, 12);
        fillInt(r100, r101 + 8, 1);
        fillInt(r100, r101 + 12, r102);
        fillInt(r100, r101 + 16, r103);
    }

    public OpaqueDataHelper(String r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.SIZE_OF_ENUM_ST_SOUND_MODEL_ID = 4;
        this.SIZE_OF_ST_PARAM_KEY = 4;
        this.ST_SM_ID_NONE = 0;
        this.ST_SM_ID_SVA_END = 128;
        this.ST_SM_ID_CUSTOM_START = 256;
        this.ST_SM_ID_CUSTOM_END = 32768;
        this.SIZE_OF_ST_PARAM_HEADER = 8;
        this.SIZE_OF_ST_USER_LEVEL = 8;
        this.SIZE_OF_ST_KEYWORD_LEVELS = 88;
        this.SIZE_OF_ST_SOUND_MODEL_CONF_LEVELS = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION;
        this.SIZE_OF_ST_CONFIDENCE_LEVELS_INFO = 8888;
        this.SIZE_OF_ST_HIST_BUFFER_INFO = 12;
        this.SIZE_OF_ST_KEYWORD_INDICES_INFO = 12;
        this.SIZE_OF_TIME_STAMP_INFO = 8;
        this.SIZE_OF_KWS_THRESHOLD_HEADER = 12;
        this.SIZE_OF_KWS_THRESHOLD_ENTRY = 40;
        this.mHasSecondStageUser = true;
        this.mHasFirstStage = true;
        this.mHasSecondStageKey = true;
        this.mHasStage1ConfigParam = true;
        this.mNumOfModels = 3;
        this.mNumberOfStage1Config = 0;
        this.mSmName = r100;
        this.mSmInfo = query(r100);
        this.mHasHistBufferConfigParam = r101;
        IExtendedSmModel r105 = Global.getInstance().getExtendedSmMgr().getSoundModel(r100);
        if (this.mSmInfo == null) goto L8;
        if (r105 == null) goto L8;
        if (r105.isSupportExtendedOpaqueData() == false) goto L8;
        this.mHasConfidenceLevelsParam = true;
    L9:
        this.mHasKeywordIndicesParam = r102;
        this.mHasTimeStampParam = r103;
        this.mHasStage1ConfigParam = r104;
        return;
    L8:
        this.mHasConfidenceLevelsParam = false;
        goto L9
    }

    private void fillConfidenceLevelParam(byte[] r210, int r211, int r212, int r213, int r214, int r215) {
        int r100 = r211;
        fillInt(r210, r100, ST_Param_Key.ST_PARAM_KEY_CONFIDENCE_LEVELS.getCode());
        fillInt(r210, r100 + 4, 8888);
        fillInt(r210, r100 + 8, 2);
        fillInt(r210, r100 + 12, this.mNumOfModels);
        IExtendedSmModel r101 = Global.getInstance().getExtendedSmMgr().getSoundModel(this.mSmName);
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r102 = r101.getKeyphraseRecognitionExtra();
        if (r102 != null) goto L5;
    L7:
        boolean r110 = false;
    L8:
        String r111 = TAG;
        LogUtils.d(r111, "fillConfidenceLevelParam: bMatchWithExtra = " + r110, new Object[0]);
        if (this.mHasFirstStage == false) goto L38;
        fillInt(r210, r100 + 16, 1);
        ObricListenTypes.SVASoundModelInfo r112 = this.mSmInfo;
        if (r112 == null) goto L13;
        int r113 = r112.keywordInfo.length;
    L14:
        if (r110 == false) goto L16;
        r113 = r102.length;
    L16:
        LogUtils.d(r111, "fillConfidenceLevelParam: GMM keyphraseCount = " + r113, new Object[0]);
        fillInt(r210, r100 + 20, r113);
        int r103 = r100 + 24;
        int r114 = 0;
    L17:
        if (r114 >= r113) goto L38;
        ObricListenTypes.SVASoundModelInfo r115 = this.mSmInfo;
        if (r115 == null) goto L23;
        ObricListenTypes.KeywordInfo r116 = r115.keywordInfo[r114];
        if (r116 == null) goto L23;
        int r117 = r116.activeUsers.length;
    L24:
        String r104 = TAG;
        int r118 = r113;
        LogUtils.d(r104, "fillConfidenceLevelParam: GMM query userCount = " + r117, new Object[0]);
        if (r110 == false) goto L27;
        r117 = r102[r114]._confidenceLevels().length;
    L27:
        LogUtils.d(r104, "fillConfidenceLevelParam: GMM userCount = " + r117, new Object[0]);
        int r105 = (r114 * 84) + r103;
        fillInt(r210, r105, r212);
        int r106 = r105 + 4;
        fillInt(r210, r106, r117);
        if (r110 == false) goto L33;
        SoundTriggerWrapper.ConfidenceLevelWrapper[] r119 = r102[r114]._confidenceLevels();
        int r120 = r119.length;
        int r121 = 0;
        int r122 = 0;
    L30:
        if (r121 >= r120) goto L32;
        int r107 = (r106 + 4) + (r122 * 8);
        fillInt(r210, r107, r119[r121].userId());
        r106 = r107 + 4;
        fillInt(r210, r106, r213);
        r122 = r122 + 1;
        r121 = r121 + 1;
        r103 = r103;
        goto L30
    L32:
        int r216 = r103;
    L36:
        r114 = r114 + 1;
        r113 = r118;
        r103 = r216;
        goto L17
    L33:
        r216 = r103;
        int r123 = 0;
    L34:
        if (r123 >= r117) goto L36;
        int r108 = (r106 + 4) + (r123 * 8);
        fillInt(r210, r108, r123);
        r106 = r108 + 4;
        fillInt(r210, r106, r213);
        r123 = r123 + 1;
    L23:
        r117 = 0;
        goto L24
    L13:
        r113 = 0;
    L38:
        if (this.mHasSecondStageKey == false) goto L60;
        if (r101.isUdkSm() == true) goto L42;
    L44:
        int r109 = 2;
    L46:
        if (this.mHasFirstStage == false) goto L48;
        int r124 = r100 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION;
    L49:
        fillInt(r210, r124 + 16, r109);
        ObricListenTypes.SVASoundModelInfo r125 = this.mSmInfo;
        if (r125 == null) goto L52;
        int r126 = r125.keywordInfo.length;
    L53:
        fillInt(r210, r124 + 20, r126);
        int r127 = r124 + 24;
        int r128 = 0;
    L54:
        if (r128 >= r126) goto L60;
        int r129 = this.mSmInfo.keywordInfo[r128].activeUsers.length;
        int r130 = (r128 * 84) + r127;
        fillInt(r210, r130, r214);
        int r131 = 4;
        int r132 = r130 + 4;
        fillInt(r210, r132, r129);
        int r133 = 0;
    L56:
        if (r133 >= r129) goto L58;
        int r134 = (r132 + r131) + (r133 * 8);
        fillInt(r210, r134, r133);
        r132 = r134 + r131;
        fillInt(r210, r132, r215);
        r133 = r133 + 1;
        r131 = 4;
        goto L56
    L58:
        r128 = r128 + 1;
        goto L54
    L52:
        r126 = 0;
        goto L53
    L48:
        r124 = r100;
        goto L49
    L42:
        if (r101.getSoundModelVersion().getVersionNumber() <= ISmModel.ModelVersion.VERSION_6_0.getVersionNumber()) goto L44;
        r109 = 64;
    L60:
        if (this.mHasSecondStageUser == true) goto L62;
        return;
    L62:
        if (this.mHasFirstStage == false) goto L67;
        if (this.mHasSecondStageKey == false) goto L68;
        r100 = r100 + 1776;
    L69:
        fillInt(r210, r100 + 16, 4);
        ObricListenTypes.SVASoundModelInfo r135 = this.mSmInfo;
        if (r135 == null) goto L72;
        int r136 = r135.keywordInfo.length;
    L73:
        fillInt(r210, r100 + 20, r136);
        int r137 = r100 + 24;
        int r138 = 0;
    L74:
        if (r138 >= r136) goto L91;
        int r139 = this.mSmInfo.keywordInfo[r138].activeUsers.length;
        String r140 = TAG;
        LogUtils.d(r140, "fillConfidenceLevelParam: VOP query userCount = " + r139, new Object[0]);
        if (r110 == false) goto L78;
        r139 = r102[r138]._confidenceLevels().length;
    L78:
        LogUtils.d(r140, "fillConfidenceLevelParam: VOP userCount = " + r139, new Object[0]);
        int r141 = (r138 * 84) + r137;
        fillInt(r210, r141, r214);
        int r142 = r141 + 4;
        fillInt(r210, r142, r139);
        int r143 = 0;
    L79:
        if (r143 >= r139) goto L81;
        int r144 = (r142 + 4) + (r143 * 8);
        fillInt(r210, r144, r143);
        r142 = r144 + 4;
        fillInt(r210, r142, r215);
        r143 = r143 + 1;
        goto L79
    L81:
        r138 = r138 + 1;
        goto L74
    L91:
        return;
    L72:
        r136 = 0;
    L68:
        r100 = r100 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION;
        goto L69
    L67:
        if (this.mHasSecondStageKey == false) goto L69;
    L5:
        if (r102.length <= 0) goto L7;
        r110 = true;
        goto L8
    }

    public byte[] fillOpaqueDataByteBuffer(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, Stage1Config r211) {
        int r100 = getTotalBufferSize(r211);
        if (r100 <= 0) goto L24;
        byte[] r117 = new byte[r100];
        if (this.mHasConfidenceLevelsParam == false) goto L7;
        fillConfidenceLevelParam(r117, 0, r110, r111, r112, r113);
        int r101 = 8896;
    L9:
        if (this.mHasHistBufferConfigParam == false) goto L12;
        fillHistBufferConfigParam(r117, r101, r114, r115);
        r101 = r101 + 20;
    L12:
        if (this.mHasKeywordIndicesParam == false) goto L15;
        fillKeywordIndicesParam(r117, r101, r116, r210);
        r101 = r101 + 20;
    L15:
        if (this.mHasTimeStampParam == false) goto L18;
        fillTimeStampParam(r117, r101);
        r101 = r101 + 16;
    L18:
        if (this.mHasStage1ConfigParam == true) goto L20;
    L22:
        LogUtils.d(TAG, "fillStage1ConfigParam with data length=" + r100 + " bytes", new Object[0]);
        return r117;
    L20:
        if (r211.valid() == false) goto L22;
        LogUtils.d(TAG, "fillStage1ConfigParam with " + r211 + " from pos " + r101, new Object[0]);
        fillStage1ConfigParam(r117, r101, r211);
        goto L22
    L7:
        r101 = 0;
        goto L9
    L24:
        return null;
    }
}
