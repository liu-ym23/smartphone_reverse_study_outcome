package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.utils.TTHelper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoInfo implements IVideoInfo {
    public static final String KEY_LOGO_TYPE = "logo_type";
    private static final String KEY_VER1_AI_BARRAGE_URL = "effect_barrage_url";
    private static final String KEY_VER1_ATYPE = "atype";
    private static final String KEY_VER1_AVG_BITRATE = "avg_bitrate";
    private static final String KEY_VER1_BACKUP_URL = "backup_url";
    private static final String KEY_VER1_BACKUP_URL_1 = "backup_url_1";
    private static final String KEY_VER1_BACKUP_URL_2 = "backup_url_2";
    private static final String KEY_VER1_BACKUP_URL_3 = "backup_url_3";
    private static final String KEY_VER1_BARRAGE_MASK_OFFSET = "barrage_mask_offset";
    private static final String KEY_VER1_BARRAGE_MASK_URL = "barrage_mask_url";
    private static final String KEY_VER1_BITRATE = "bitrate";
    private static final String KEY_VER1_CHECK_INFO = "check_info";
    private static final String KEY_VER1_CODEC_TYPE = "codec_type";
    private static final String KEY_VER1_DEFINITION = "definition";
    private static final String KEY_VER1_DUB_VERSION = "dub_version";
    private static final String KEY_VER1_ENCRYPT = "encrypt";
    private static final String KEY_VER1_FILEID = "file_id";
    private static final String KEY_VER1_FILE_HASH = "file_hash";
    private static final String KEY_VER1_FIRST_MOOF_RANGE = "first_moof_range";
    private static final String KEY_VER1_FITTER_INFO = "fitter_info";
    private static final String KEY_VER1_GBR = "gbr";
    private static final String KEY_VER1_INDEX_RANGE = "index_range";
    private static final String KEY_VER1_INIT_RANGE = "init_range";
    private static final String KEY_VER1_KID = "kid";
    private static final String KEY_VER1_LANGUAGE_CODE = "language_code";
    private static final String KEY_VER1_LANGUAGE_ID = "language_id";
    private static final String KEY_VER1_LOUDNESS = "loudness";
    private static final String KEY_VER1_MAIN_URL = "main_url";
    private static final String KEY_VER1_P2PVERIFYURL = "p2p_verify_url";
    private static final String KEY_VER1_PACKET_OFFSET = "pkt_offset";
    private static final String KEY_VER1_PALLAS_FID_LABELS = "pallas_fid_labels";
    private static final String KEY_VER1_PEAK = "peak";
    private static final String KEY_VER1_PLAY_LOAD_MAX_STEP = "play_load_max_step";
    private static final String KEY_VER1_PLAY_LOAD_MIN_STEP = "play_load_min_step";
    private static final String KEY_VER1_PRELOAD_INTERVAL = "preload_interval";
    private static final String KEY_VER1_PRELOAD_SIZE = "preload_size";
    private static final String KEY_VER1_QUALITY = "quality";
    private static final String KEY_VER1_QUALITY_DESC = "quality_desc";
    private static final String KEY_VER1_QUALITY_TYPE = "quality_type";
    private static final String KEY_VER1_REAL_BITRATE = "real_bitrate";
    private static final String KEY_VER1_SEGMENT_SIZE_INFO = "segment_size_info";
    private static final String KEY_VER1_SIZE = "size";
    private static final String KEY_VER1_SOCKET_BUFFER = "socket_buffer";
    private static final String KEY_VER1_SPADEA = "spade_a";
    private static final String KEY_VER1_STOREPATH = "storePath";
    private static final String KEY_VER1_URL_EXPIRED = "url_expire";
    private static final String KEY_VER1_USE_VIDEO_PROXY = "use_video_proxy";
    private static final String KEY_VER1_VHEIGHT = "vheight";
    private static final String KEY_VER1_VOLUME = "volume";
    private static final String KEY_VER1_VOLUME_INFO_JSON = "volume_info_json";
    private static final String KEY_VER1_VOLUME_LOUDNESS_END = "loudness_range_end";
    private static final String KEY_VER1_VOLUME_LOUDNESS_RANGE = "loudness_range";
    private static final String KEY_VER1_VOLUME_LOUDNESS_START = "loudness_range_start";
    private static final String KEY_VER1_VOLUME_MAX_MOM = "maximum_momentary_loudness";
    private static final String KEY_VER1_VOLUME_SHORTERM = "maximum_short_term_loudness";
    private static final String KEY_VER1_VOLUME_VER = "version";
    private static final String KEY_VER1_VTYPE = "vtype";
    private static final String KEY_VER1_VWIDTH = "vwidth";
    private static final String KEY_VER2_AVG_BITRATE = "AvgBitrate";
    private static final String KEY_VER2_BACKUP_URL = "BackupPlayUrl";
    private static final String KEY_VER2_BITRATE = "Bitrate";
    private static final String KEY_VER2_CHECK_INFO = "CheckInfo";
    private static final String KEY_VER2_CODEC_TYPE = "Codec";
    private static final String KEY_VER2_DEFINITION = "Definition";
    private static final String KEY_VER2_DUB_VERSION = "DubVersion";
    private static final String KEY_VER2_FILEID = "FileID";
    private static final String KEY_VER2_FILE_HASH = "FileHash";
    private static final String KEY_VER2_FIRST_MOOF_RANGE = "FirstMoofRange";
    private static final String KEY_VER2_INDEX_RANGE = "IndexRange";
    private static final String KEY_VER2_INIT_RANGE = "InitRange";
    private static final String KEY_VER2_KID = "PlayAuthID";
    private static final String KEY_VER2_LANGUAGE_CODE = "LanguageCode";
    private static final String KEY_VER2_LANGUAGE_ID = "LanguageId";
    private static final String KEY_VER2_LOGO_TYPE = "Logo";
    private static final String KEY_VER2_MAIN_URL = "MainPlayUrl";
    private static final String KEY_VER2_MEDIA_TYPE = "MediaType";
    private static final String KEY_VER2_P2PVERIFYURL = "P2pVerifyURL";
    private static final String KEY_VER2_PLAY_LOAD_MAX_STEP = "PreloadMaxStep";
    private static final String KEY_VER2_PLAY_LOAD_MIN_STEP = "PreloadMinStep";
    private static final String KEY_VER2_PRELOAD_INTERVAL = "PreloadInterval";
    private static final String KEY_VER2_PRELOAD_SIZE = "PreloadSize";
    private static final String KEY_VER2_QUALITY = "Quality";
    private static final String KEY_VER2_QUALITY_TYPE = "QualityType";
    private static final String KEY_VER2_REAL_BITRATE = "RealBitrate";
    private static final String KEY_VER2_SEGMENT_SIZE_INFO = "SegmentSizeInfo";
    private static final String KEY_VER2_SIZE = "Size";
    private static final String KEY_VER2_SPADEA = "PlayAuth";
    private static final String KEY_VER2_VHEIGHT = "Height";
    private static final String KEY_VER2_VTYPE = "Format";
    private static final String KEY_VER2_VWIDTH = "Width";
    private static final String KEY_VER3_AUDIO_PROFILE = "audio_profile";
    private static final String KEY_VER3_ENCODE_USER_TAG = "encode_user_tag";
    private static final String KEY_VER4_AVG_BITRATE = "AvgBitrate";
    private static final String KEY_VER4_BACKUP_URL = "BackupPlayUrl";
    private static final String KEY_VER4_BACKUP_URL_EXPIRE = "BackupUrlExpire";
    private static final String KEY_VER4_BITRATE = "Bitrate";
    private static final String KEY_VER4_CHECK_INFO = "CheckInfo";
    private static final String KEY_VER4_CODEC_TYPE = "Codec";
    private static final String KEY_VER4_DEFINITION = "Definition";
    private static final String KEY_VER4_FILEID = "FileId";
    private static final String KEY_VER4_FILE_TYPE = "FileType";
    private static final String KEY_VER4_FIRST_MOOF_RANGE = "FirstMoofRange";
    private static final String KEY_VER4_INDEX_RANGE = "IndexRange";
    private static final String KEY_VER4_INIT_RANGE = "InitRange";
    private static final String KEY_VER4_LOGO_TYPE = "LogoType";
    private static final String KEY_VER4_LOUDNESS = "Loudness";
    private static final String KEY_VER4_MAIN_URL = "MainPlayUrl";
    private static final String KEY_VER4_MAIN_URL_EXPIRE = "MainUrlExpire";
    private static final String KEY_VER4_MD5 = "Md5";
    private static final String KEY_VER4_PEAK = "Peak";
    private static final String KEY_VER4_PLAYAUTH = "PlayAuth";
    private static final String KEY_VER4_PLAYAUTHID = "PlayAuthId";
    private static final String KEY_VER4_QUALITY = "Quality";
    private static final String KEY_VER4_QUALITY_TYPE = "QualityType";
    private static final String KEY_VER4_REAL_BITRATE = "RealBitrate";
    private static final String KEY_VER4_SEGMENT_SIZE_INFO = "SegmentSizeInfo";
    private static final String KEY_VER4_SIZE = "Size";
    private static final String KEY_VER4_VHEIGHT = "Height";
    private static final String KEY_VER4_VOLUME = "Volume";
    private static final String KEY_VER4_VTYPE = "Format";
    private static final String KEY_VER4_VWIDTH = "Width";
    public static final int VALUE_VIDEO_HEAD_SIZE = 38;
    public static final int VALUE_VIDEO_INFO_AI_BARRAGE_URL = 43;
    public static final int VALUE_VIDEO_INFO_AUDIO_PROFILE = 55;
    public static final int VALUE_VIDEO_INFO_AVG_BITRATE = 52;
    public static final int VALUE_VIDEO_INFO_BACKUP_URL_1 = 17;
    public static final int VALUE_VIDEO_INFO_BACKUP_URL_2 = 23;
    public static final int VALUE_VIDEO_INFO_BACKUP_URL_3 = 24;
    public static final int VALUE_VIDEO_INFO_BACKUP_URL_EXPIRE = 50;
    public static final int VALUE_VIDEO_INFO_BARRAGE_OFFSET = 33;
    public static final int VALUE_VIDEO_INFO_BARRAGE_URL = 37;
    public static final int VALUE_VIDEO_INFO_BITRATE = 3;
    public static final int VALUE_VIDEO_INFO_CHECK_INFO = 31;
    public static final int VALUE_VIDEO_INFO_CODEC_TYPE = 8;
    public static final int VALUE_VIDEO_INFO_DEFINITION = 7;
    public static final int VALUE_VIDEO_INFO_DURATION = 27;
    public static final int VALUE_VIDEO_INFO_ENCODE_USER_TAG = 54;
    public static final int VALUE_VIDEO_INFO_ENCRYPT = 4;
    public static final int VALUE_VIDEO_INFO_FILEID = 28;
    public static final int VALUE_VIDEO_INFO_FILE_HASH = 15;
    public static final int VALUE_VIDEO_INFO_FIRST_MOOF_RANGE = 47;
    public static final int VALUE_VIDEO_INFO_FORMAT_TYPE = 6;
    public static final int VALUE_VIDEO_INFO_GBR = 20;
    public static final int VALUE_VIDEO_INFO_INDEX_RANGE = 35;
    public static final int VALUE_VIDEO_INFO_INFO_ID = 42;
    public static final int VALUE_VIDEO_INFO_INIT_RANGE = 34;
    public static final int VALUE_VIDEO_INFO_KID = 36;
    public static final int VALUE_VIDEO_INFO_LOGO_TYPE = 19;
    public static final int VALUE_VIDEO_INFO_LOUDNESS = 39;
    public static final int VALUE_VIDEO_INFO_MAIN_URL = 0;
    public static final int VALUE_VIDEO_INFO_MAIN_URL_EXPIRE = 49;
    public static final int VALUE_VIDEO_INFO_P2PVERIFYURL = 29;
    public static final int VALUE_VIDEO_INFO_PEAK = 40;
    public static final int VALUE_VIDEO_INFO_PLAY_AUTH = 5;
    public static final int VALUE_VIDEO_INFO_PRELOAD_INTERVAL = 13;
    public static final int VALUE_VIDEO_INFO_PRELOAD_MAX_STEP = 11;
    public static final int VALUE_VIDEO_INFO_PRELOAD_MIN_STEP = 10;
    public static final int VALUE_VIDEO_INFO_PRELOAD_SIZE = 9;
    public static final int VALUE_VIDEO_INFO_QUALITY = 18;
    public static final int VALUE_VIDEO_INFO_QUALITY_DESC = 32;
    public static final int VALUE_VIDEO_INFO_QUALITY_TYPE = 41;
    public static final int VALUE_VIDEO_INFO_REAL_BITRATE = 44;
    public static final int VALUE_VIDEO_INFO_RESOLUTION = 48;
    public static final int VALUE_VIDEO_INFO_RESOLUTION_FILEID = 46;
    public static final int VALUE_VIDEO_INFO_RESOLUTION_STR = 26;
    public static final int VALUE_VIDEO_INFO_SEGMENT_SIZE_INFO = 53;
    public static final int VALUE_VIDEO_INFO_SIZE = 12;
    public static final int VALUE_VIDEO_INFO_SOCKET_BUFFER = 22;
    public static final int VALUE_VIDEO_INFO_STORE_PATH = 25;
    public static final int VALUE_VIDEO_INFO_URLEXPIRED = 30;
    public static final int VALUE_VIDEO_INFO_URLS = 16;
    public static final int VALUE_VIDEO_INFO_URL_EXPIRES = 51;
    public static final int VALUE_VIDEO_INFO_USE_VIDEO_PROXY = 21;
    public static final int VALUE_VIDEO_INFO_VHEIGHT = 2;
    public static final int VALUE_VIDEO_INFO_VWIDTH = 1;
    public static final int VALUE_VIDEO_VIEWPORT = 45;
    public boolean isAutoDefinition;
    private String mAIBarrageUrl;
    private String mAudioProfile;
    private int mAvgBitrate;
    public String mBackupUrl1;
    private String mBackupUrl1Ver2;
    public String mBackupUrl2;
    public String mBackupUrl3;
    public String mBackupUrlExpire;
    private String mBarrageMaskOffset;
    private String mBarrageMaskUrl;
    public int mBitrate;
    private MediaBitrateFitterInfo mBitrateFitterInfo;
    private int mBitrateVer2;
    private String mCheckInfo;
    public String mCodecType;
    private String mCodecTypeVer2;
    public String mDefinition;
    private String mDefinitionVer2;
    public String mDubVersion;
    private String mEncodeUserTag;
    public boolean mEncrypt;
    public String mFileHash;
    private String mFileHashVer2;
    private String mFileId;
    private String mFirstMoofRange;
    public int mGbr;
    private String mIndexRange;
    public int mInfoId;
    private String mInitRange;
    private String mKeyseed;
    private String mKid;
    public String mLanguageCode;
    public int mLanguageId;
    private String mLogoType;
    private String mLogoTypeVer2;
    public float mLoudness;
    private float mLuEnd;
    private float mLuRange;
    private float mLuStart;
    public String mMainUrl;
    public String mMainUrlExpire;
    private String mMainUrlVer2;
    private float mMaxMomLu;
    private float mMaxShortermLu;
    private int mMediaType;
    private String mP2pVerifyUrl;
    public HashMap<Double, Long> mPacketOffset;
    public float mPeak;
    protected JSONObject mPreloadGear;
    public String mQuality;
    private String mQualityDesc;
    private int mQualityType;
    private String mQualityVer2;
    public int mRealBitrate;
    private Resolution mResolution;
    private String mResolutionStr;
    private String mSegmentSizeInfo;
    public long mSize;
    private long mSizeVer2;
    private int mSocketBuffer;
    public String mSpadea;
    private String mSpadeaVer2;
    public String mStorePath;
    public String[] mURLExpires;
    public String[] mURLs;
    private String[] mURLsVer2;
    private long mUrlExpiredT;
    public int mVHeight;
    private int mVHeightVer2;
    public String mVType;
    private String mVTypeVer2;
    public int mVWidth;
    private int mVWidthVer2;
    private int mVersion;
    public int mVideoDuration;
    private int mVolumInfoVer;
    private String mVolumeInfoJson;
    public int playLoadMaxStep;
    public int playLoadMinStep;
    private int preLoadIntervalVer2;
    private int preLoadMaxStepVer2;
    private int preLoadMinStepVer2;
    private int preLoadSizeVer2;
    public int preloadInterval;
    public int preloadSize;
    public int useVideoProxy;

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public int fromMediaInfoJsonObject(JSONObject r100) {
        return -1;
    }

    public void parseFromPb(VideoModelPb.Audio r100) {
    }

    public void parseFromPb(VideoModelPb.Video r100) {
    }

    public VideoInfo copyInfo() {
        VideoInfo r100 = new VideoInfo(this.mKeyseed);
        r100.mVersion = this.mVersion;
        r100.mURLs = this.mURLs;
        r100.mURLExpires = this.mURLExpires;
        r100.mMainUrlExpire = this.mMainUrlExpire;
        r100.mBackupUrlExpire = this.mBackupUrlExpire;
        r100.mMainUrl = this.mMainUrl;
        r100.mBackupUrl1 = this.mBackupUrl1;
        r100.mBackupUrl2 = this.mBackupUrl2;
        r100.mBackupUrl3 = this.mBackupUrl3;
        r100.mVWidth = this.mVWidth;
        r100.mVHeight = this.mVHeight;
        r100.mEncrypt = this.mEncrypt;
        r100.mSpadea = this.mSpadea;
        r100.mGbr = this.mGbr;
        r100.mStorePath = this.mStorePath;
        r100.mVType = this.mVType;
        r100.mCodecType = this.mCodecType;
        r100.mFileHash = this.mFileHash;
        r100.mDefinition = this.mDefinition;
        r100.preloadSize = this.preloadSize;
        r100.playLoadMinStep = this.playLoadMinStep;
        r100.playLoadMaxStep = this.playLoadMaxStep;
        r100.mSize = this.mSize;
        r100.mVideoDuration = this.mVideoDuration;
        r100.preloadInterval = this.preloadInterval;
        r100.useVideoProxy = this.useVideoProxy;
        r100.mSocketBuffer = this.mSocketBuffer;
        r100.isAutoDefinition = this.isAutoDefinition;
        r100.mQuality = this.mQuality;
        r100.mLogoType = this.mLogoType;
        r100.mFileHash = this.mFileHash;
        r100.mCheckInfo = this.mCheckInfo;
        r100.mInitRange = this.mInitRange;
        r100.mIndexRange = this.mIndexRange;
        r100.mFirstMoofRange = this.mFirstMoofRange;
        r100.mSegmentSizeInfo = this.mSegmentSizeInfo;
        r100.mEncodeUserTag = this.mEncodeUserTag;
        r100.mAudioProfile = this.mAudioProfile;
        r100.mKid = this.mKid;
        r100.mQualityType = this.mQualityType;
        r100.mBitrateFitterInfo = this.mBitrateFitterInfo;
        r100.mURLsVer2 = this.mURLsVer2;
        r100.mMainUrlVer2 = this.mMainUrlVer2;
        r100.mVWidthVer2 = this.mVWidthVer2;
        r100.mVHeightVer2 = this.mVHeightVer2;
        r100.mSpadeaVer2 = this.mSpadeaVer2;
        r100.mVTypeVer2 = this.mVTypeVer2;
        r100.mCodecTypeVer2 = this.mCodecTypeVer2;
        r100.mDefinitionVer2 = this.mDefinitionVer2;
        r100.preLoadSizeVer2 = this.preLoadSizeVer2;
        r100.preLoadMinStepVer2 = this.preLoadMinStepVer2;
        r100.preLoadMaxStepVer2 = this.preLoadMaxStepVer2;
        r100.mSizeVer2 = this.mSizeVer2;
        r100.preLoadIntervalVer2 = this.preLoadIntervalVer2;
        r100.mLogoTypeVer2 = this.mLogoTypeVer2;
        r100.mFileId = this.mFileId;
        r100.mP2pVerifyUrl = this.mP2pVerifyUrl;
        r100.mMediaType = this.mMediaType;
        r100.mFileHashVer2 = this.mFileHashVer2;
        r100.mRealBitrate = this.mRealBitrate;
        r100.mInfoId = this.mInfoId;
        r100.mBitrate = this.mBitrate;
        r100.mQualityVer2 = this.mQualityVer2;
        r100.mBackupUrl1Ver2 = this.mBackupUrl1Ver2;
        r100.mBitrateVer2 = this.mBitrateVer2;
        r100.mAvgBitrate = this.mAvgBitrate;
        return r100;
    }

    public int getPreloadInterval() {
        int r100 = this.mVersion;
        if (r100 == 2) goto L10;
        if (r100 == 4) goto L10;
        return this.preloadInterval;
    L10:
        return this.preLoadIntervalVer2;
    }

    public int getSocketBuffer() {
        int r100 = this.mVersion;
        if (r100 != 2) goto L5;
        return 0;
    L5:
        if (r100 != 4) goto L8;
        return 0;
    L8:
        return this.mSocketBuffer;
    }

    public boolean isUseVideoProxy() {
        int r100 = this.mVersion;
        if (r100 != 2) goto L5;
        return false;
    L5:
        if (r100 != 4) goto L8;
        return false;
    L8:
        if (this.useVideoProxy != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public JSONObject toBashJsonObject() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L22
        String[] r101 = getValueStrArr(16);     // Catch: Exception -> L22
        if (r101 != null) goto L6;
    L21:
        return null;
    L6:
        if (r101.length <= 0) goto L21;
        String r102 = getValueStr(34);     // Catch: Exception -> L22
        String r103 = getValueStr(6);     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r103) == false) goto L11;
    L15:
        r100.put(KEY_VER1_MAIN_URL, r101[0]);     // Catch: Exception -> L22
        if (r101.length <= 1) goto L18;
        String r104 = r101[1];     // Catch: Exception -> L22
    L19:
        r100.put(KEY_VER1_BACKUP_URL_1, r104);     // Catch: Exception -> L22
        r100.put("bitrate", getValueInt(3));     // Catch: Exception -> L22
        r100.put(KEY_VER1_VWIDTH, getValueInt(1));     // Catch: Exception -> L22
        r100.put(KEY_VER1_VHEIGHT, getValueInt(2));     // Catch: Exception -> L22
        r100.put(KEY_VER1_INIT_RANGE, r102);     // Catch: Exception -> L22
        r100.put(KEY_VER1_INDEX_RANGE, getValueStr(35));     // Catch: Exception -> L22
        r100.put(KEY_VER1_FIRST_MOOF_RANGE, getValueStr(47));     // Catch: Exception -> L22
        r100.put(KEY_VER1_SEGMENT_SIZE_INFO, getValueStr(53));     // Catch: Exception -> L22
        r100.put(KEY_VER1_CHECK_INFO, getValueStr(31));     // Catch: Exception -> L22
        r100.put("kid", getValueStr(36));     // Catch: Exception -> L22
        r100.put("file_hash", TTHelper.encodeUrl(getValueStr(15)));     // Catch: Exception -> L22
        r100.put(KEY_VER1_LOUDNESS, getValueFloat(39));     // Catch: Exception -> L22
        r100.put(KEY_VER1_PEAK, getValueFloat(40));     // Catch: Exception -> L22
        r100.put("info_id", getValueInt(42));     // Catch: Exception -> L22
        return r100;
    L18:
        r104 = "";
        goto L19
    L11:
        if (r103.equals("mp4") == false) goto L15;
        int r105 = getValueInt(38);     // Catch: Exception -> L22
        if (r105 <= 0) goto L15;
        r102 = "0-" + (r105 - 1);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public Map<String, Object> toMediaInfo() {
        HashMap r100 = new HashMap();
        r100.put("file_id", getValueStr(28));
        if (getMediatype() != VideoRef.TYPE_VIDEO) goto L5;
        String r101 = "video";
    L6:
        r100.put(a.KEY_MEDIA_TYPE, r101);
        r100.put("file_size", Long.valueOf(getValueLong(12)));
        if (1 == EngineGlobalConfig.getInstance().getEnableUseRealBitrate()) goto L9;
        r100.put("bitrate", Integer.valueOf(getValueInt(3)));
    L13:
        r100.put(KEY_VER1_REAL_BITRATE, Integer.valueOf(getValueInt(44)));
        r100.put(KEY_VER1_AVG_BITRATE, Integer.valueOf(getValueInt(52)));
        r100.put("quality", getValueStr(18));
        r100.put(KEY_VER1_DEFINITION, getValueStr(7));
        r100.put(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_RESOLUTION, getValueStr(48));
        Resolution r102 = this.mResolution;
        if (r102 == null) goto L16;
        int r103 = r102.getIndex();
    L17:
        r100.put("resolution", Integer.valueOf(r103));
        r100.put("width", Integer.valueOf(getValueInt(1)));
        r100.put("height", Integer.valueOf(getValueInt(2)));
        r100.put("codec", getValueStr(8));
        r100.put("urls", getValueStrArr(16));
        r100.put("file_hash", getValueStr(15));
        r100.put(MediaBitrateFitterInfo.KEY_FITTER_HEADER_SIZE, Integer.valueOf(getValueInt(38)));
        r100.put("quality_desc", getValueStr(32));
        r100.put(KEY_VER1_FIRST_MOOF_RANGE, getValueStr(47));
        r100.put(KEY_VER1_SEGMENT_SIZE_INFO, getValueStr(53));
        JSONObject r104 = this.mPreloadGear;
        if (r104 == null) goto L20;
        r100.put("preload_gear_data", r104);
    L20:
        String r105 = getValueStr(29);
        if (r105 != null) goto L23;
        r105 = "";
    L23:
        r100.put("p2p_crc", TTHelper.encodeUrl(r105));
        return r100;
    L16:
        r103 = 0;
        goto L17
    L9:
        if (getValueInt(44) <= 0) goto L11;
        r100.put("bitrate", Integer.valueOf(getValueInt(44)));
        goto L13
    L11:
        r100.put("bitrate", Integer.valueOf(getValueInt(3)));
        goto L13
    L5:
        r101 = "audio";
        goto L6
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public MediaBitrateFitterInfo getBitrateFitterInfo() {
        return this.mBitrateFitterInfo;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public int getMediatype() {
        return this.mMediaType;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public Resolution getResolution() {
        return this.mResolution;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public VideoInfo(String r100) {
        this.mVersion = 1;
        Resolution r101 = Resolution.Standard;
        this.mResolution = r101;
        this.mResolutionStr = r101.toString(VideoRef.TYPE_VIDEO);
        this.mFileId = null;
        this.mP2pVerifyUrl = null;
        this.mUrlExpiredT = 0;
        this.mEncrypt = false;
        this.mSpadea = null;
        this.mSize = 0;
        this.mVideoDuration = 0;
        this.preloadInterval = 0;
        this.useVideoProxy = 1;
        this.mSocketBuffer = 0;
        this.isAutoDefinition = false;
        this.mMediaType = 0;
        this.mPreloadGear = null;
        this.mLoudness = 0.0f;
        this.mPeak = 0.0f;
        this.mLuRange = 0.0f;
        this.mLuStart = 0.0f;
        this.mLuEnd = 0.0f;
        this.mMaxMomLu = 0.0f;
        this.mMaxShortermLu = 0.0f;
        this.mVolumInfoVer = 0;
        this.mVolumeInfoJson = "";
        this.mQualityType = 0;
        this.mInfoId = -1;
        this.mLanguageId = -1;
        this.mLanguageCode = "";
        this.mDubVersion = "";
        this.mURLsVer2 = null;
        this.mSpadeaVer2 = null;
        this.mCodecTypeVer2 = null;
        this.preLoadIntervalVer2 = 0;
        this.mSizeVer2 = 0;
        this.mLogoTypeVer2 = null;
        this.mQualityVer2 = null;
        this.mBackupUrl1Ver2 = null;
        this.mEncodeUserTag = null;
        this.mAudioProfile = null;
        this.mQualityDesc = null;
        this.mBarrageMaskOffset = null;
        this.mBitrateFitterInfo = null;
        this.mMainUrlExpire = "";
        this.mBackupUrlExpire = "";
        this.mURLExpires = null;
        this.mKeyseed = r100;
    }

    private void externalizablePallasLabels(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L24;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L15
        if (r101.has("preloadsize") == false) goto L21;
        String r102 = r101.optString("preloadsize");     // Catch: JSONException -> L15
        if (r102 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L23;
        this.mPreloadGear = new JSONObject(r102);     // Catch: JSONException -> L15
        return;
    L23:
        return;
    L21:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 4 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:315:0x08b2
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    public void extractFields(org.json.JSONObject r31) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 3292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.VideoInfo.extractFields(org.json.JSONObject):void");
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public boolean getValueBool(int r100) {
        if (r100 == 4) goto L5;
        return false;
    L5:
        int r101 = this.mVersion;
        if (r101 == 1) goto L12;
        if (r101 == 3) goto L12;
        return false;
    L12:
        return this.mEncrypt;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public float getValueFloat(int r100) {
        if (r100 == 39) goto L24;
        if (r100 == 40) goto L22;
        if (r100 == 252) goto L20;
        switch(r100) {
            case 247: goto L18;
            case 248: goto L16;
            case 249: goto L14;
            case 250: goto L12;
            default: goto L9;
        };
    L9:
        return 0.0f;
    L12:
        return this.mMaxShortermLu;
    L14:
        return this.mMaxMomLu;
    L16:
        return this.mLuEnd;
    L18:
        return this.mLuStart;
    L20:
        return this.mLuRange;
    L22:
        return this.mPeak;
    L24:
        return this.mLoudness;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public int getValueInt(int r110) {
        if (r110 != 38) goto L11;
        MediaBitrateFitterInfo r111 = this.mBitrateFitterInfo;
        if (r111 != null) goto L7;
        return 0;
    L7:
        return r111.getHeaderSize();
    L11:
        if (this.mVersion != 2) goto L47;
        if (r110 == 1) goto L46;
        if (r110 == 2) goto L44;
        if (r110 == 3) goto L42;
        if (r110 == 13) goto L40;
        if (r110 == 44) goto L38;
        if (r110 == 52) goto L36;
        if (r110 == 251) goto L34;
        if (r110 == 41) goto L32;
        if (r110 == 42) goto L30;
        switch(r110) {
            case 9: goto L28;
            case 10: goto L26;
            case 11: goto L24;
            default: goto L22;
        };
    L22:
        return -1;
    L24:
        return this.preLoadMaxStepVer2;
    L26:
        return this.preLoadMinStepVer2;
    L28:
        return this.preLoadSizeVer2;
    L30:
        return this.mInfoId;
    L32:
        return this.mQualityType;
    L34:
        return this.mVolumInfoVer;
    L36:
        return this.mAvgBitrate;
    L38:
        return this.mRealBitrate;
    L40:
        return this.preLoadIntervalVer2;
    L42:
        return this.mBitrateVer2;
    L44:
        return this.mVHeightVer2;
    L46:
        return this.mVWidthVer2;
    L47:
        if (r110 == 1) goto L92;
        if (r110 == 2) goto L90;
        if (r110 == 3) goto L88;
        if (r110 == 13) goto L86;
        if (r110 == 27) goto L84;
        if (r110 == 44) goto L82;
        if (r110 == 52) goto L80;
        if (r110 == 251) goto L78;
        if (r110 == 41) goto L76;
        if (r110 == 42) goto L74;
        switch(r110) {
            case 9: goto L72;
            case 10: goto L70;
            case 11: goto L68;
            default: goto L59;
        };
    L59:
        switch(r110) {
            case 20: goto L66;
            case 21: goto L64;
            case 22: goto L62;
            default: goto L60;
        };
    L60:
        return -1;
    L62:
        return this.mSocketBuffer;
    L64:
        return this.useVideoProxy;
    L66:
        return this.mGbr;
    L68:
        return this.playLoadMaxStep;
    L70:
        return this.playLoadMinStep;
    L72:
        return this.preloadSize;
    L74:
        return this.mInfoId;
    L76:
        return this.mQualityType;
    L78:
        return this.mVolumInfoVer;
    L80:
        return this.mAvgBitrate;
    L82:
        return this.mRealBitrate;
    L84:
        return this.mVideoDuration;
    L86:
        return this.preloadInterval;
    L88:
        return this.mBitrate;
    L90:
        return this.mVHeight;
    L92:
        return this.mVWidth;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public long getValueLong(int r100) {
        if (this.mVersion != 2) goto L8;
        if (r100 == 12) goto L7;
        return -1;
    L7:
        return this.mSizeVer2;
    L8:
        if (r100 == 12) goto L15;
        if (r100 == 30) goto L13;
        return -1;
    L13:
        return this.mUrlExpiredT;
    L15:
        return this.mSize;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public String getValueStr(int r100) {
        if (r100 == 26) goto L132;
        if (r100 == 31) goto L130;
        if (r100 == 42) goto L128;
        if (r100 == 260) goto L126;
        if (r100 == 28) goto L124;
        if (r100 == 29) goto L122;
        if (r100 == 47) goto L120;
        if (r100 == 48) goto L118;
        switch(r100) {
            case 34: goto L116;
            case 35: goto L114;
            case 36: goto L112;
            default: goto L19;
        };
    L19:
        switch(r100) {
            case 53: goto L110;
            case 54: goto L108;
            case 55: goto L106;
            default: goto L21;
        };
    L21:
        if (this.mVersion != 2) goto L48;
        if (r100 == 0) goto L47;
        if (r100 == 15) goto L45;
        if (r100 == 5) goto L43;
        if (r100 == 6) goto L41;
        if (r100 == 7) goto L39;
        if (r100 == 8) goto L37;
        switch(r100) {
            case 17: goto L35;
            case 18: goto L33;
            case 19: goto L31;
            default: goto L29;
        };
    L29:
        return "";
    L31:
        return this.mLogoTypeVer2;
    L33:
        return this.mQualityVer2;
    L35:
        return this.mBackupUrl1Ver2;
    L37:
        return this.mCodecTypeVer2;
    L39:
        return this.mDefinitionVer2;
    L41:
        return this.mVTypeVer2;
    L43:
        return this.mSpadeaVer2;
    L45:
        return this.mFileHashVer2;
    L47:
        return this.mMainUrlVer2;
    L48:
        if (r100 == 0) goto L104;
        if (r100 == 15) goto L102;
        if (r100 == 37) goto L100;
        if (r100 == 43) goto L98;
        if (r100 == 5) goto L96;
        if (r100 == 6) goto L94;
        if (r100 == 7) goto L92;
        if (r100 == 8) goto L90;
        if (r100 == 32) goto L88;
        if (r100 == 33) goto L86;
        if (r100 == 49) goto L84;
        if (r100 == 50) goto L82;
        switch(r100) {
            case 17: goto L80;
            case 18: goto L78;
            case 19: goto L76;
            default: goto L67;
        };
    L67:
        switch(r100) {
            case 23: goto L74;
            case 24: goto L72;
            case 25: goto L70;
            default: goto L68;
        };
    L68:
        return "";
    L70:
        return this.mStorePath;
    L72:
        return this.mBackupUrl3;
    L74:
        return this.mBackupUrl2;
    L76:
        return this.mLogoType;
    L78:
        return this.mQuality;
    L80:
        return this.mBackupUrl1;
    L82:
        return this.mBackupUrlExpire;
    L84:
        return this.mMainUrlExpire;
    L86:
        return this.mBarrageMaskOffset;
    L88:
        return this.mQualityDesc;
    L90:
        return this.mCodecType;
    L92:
        return this.mDefinition;
    L94:
        return this.mVType;
    L96:
        return this.mSpadea;
    L98:
        return this.mAIBarrageUrl;
    L100:
        return this.mBarrageMaskUrl;
    L102:
        return this.mFileHash;
    L104:
        return this.mMainUrl;
    L106:
        return this.mAudioProfile;
    L108:
        return this.mEncodeUserTag;
    L110:
        return this.mSegmentSizeInfo;
    L112:
        return this.mKid;
    L114:
        return this.mIndexRange;
    L116:
        return this.mInitRange;
    L118:
        return this.mResolution.toString(VideoRef.TYPE_VIDEO);
    L120:
        return this.mFirstMoofRange;
    L122:
        return this.mP2pVerifyUrl;
    L124:
        return this.mFileId;
    L126:
        return this.mVolumeInfoJson;
    L128:
        return "" + this.mInfoId;
    L130:
        return this.mCheckInfo;
    L132:
        return this.mResolutionStr;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public String[] getValueStrArr(int r100) {
        if (this.mVersion != 2) goto L9;
        if (r100 == 16) goto L8;
        return new String[0];
    L8:
        return this.mURLsVer2;
    L9:
        if (r100 == 16) goto L17;
        if (r100 == 51) goto L15;
        return new String[0];
    L15:
        return this.mURLExpires;
    L17:
        return this.mURLs;
    }

    public void setMediaType(int r100) {
        this.mMediaType = r100;
    }

    public void setResolution(Resolution r100) {
        this.mResolution = r100;
    }

    public void setResolutionBaseMap(HashMap<String, Resolution> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L23;
        int r101 = this.mMediaType;
        if (r101 != VideoRef.TYPE_AUDIO) goto L12;
        String r102 = getValueStr(18);
        if (TextUtils.isEmpty(r102) == false) goto L17;
        r102 = Resolution.Standard.toString(this.mMediaType);
    L17:
        Resolution r103 = r100.get(r102);
        this.mResolution = r103;
        if (r103 != null) goto L22;
        this.mResolution = Resolution.Standard;
        return;
    L22:
        return;
    L12:
        if (r101 != VideoRef.TYPE_VIDEO) goto L16;
        r102 = getValueStr(7);
        if (TextUtils.isEmpty(r102) == false) goto L17;
        r102 = Resolution.Standard.toString(this.mMediaType);
        goto L17
    L16:
        r102 = null;
        goto L17
    }

    public void setVersion(int r100) {
        this.mVersion = r100;
    }

    public void setValue(int r100, String r101) {
        if (r100 != 0) goto L4;
        this.mMainUrlVer2 = r101;
        this.mMainUrl = r101;
        return;
    L4:
        if (r100 != 15) goto L6;
        this.mFileHashVer2 = r101;
        this.mFileHash = r101;
        return;
    L6:
        if (r100 != 5) goto L8;
        this.mSpadeaVer2 = r101;
        this.mSpadea = r101;
        return;
    L8:
        if (r100 != 6) goto L10;
        this.mVTypeVer2 = r101;
        this.mVType = r101;
        return;
    L10:
        if (r100 != 7) goto L12;
        this.mDefinitionVer2 = r101;
        this.mDefinition = r101;
        return;
    L12:
        if (r100 != 8) goto L14;
        this.mCodecTypeVer2 = r101;
        this.mCodecType = r101;
        return;
    L14:
        if (r100 != 49) goto L16;
        this.mMainUrlExpire = r101;
        return;
    L16:
        if (r100 == 50) goto L34;
        switch(r100) {
            case 17: goto L32;
            case 18: goto L30;
            case 19: goto L28;
            default: goto L18;
        };
    L18:
        switch(r100) {
            case 23: goto L26;
            case 24: goto L24;
            case 25: goto L22;
            case 26: goto L20;
            default: goto L19;
        };
    L19:
        return;
    L20:
        this.mResolutionStr = r101;
        return;
    L22:
        this.mStorePath = r101;
        return;
    L24:
        this.mBackupUrl3 = r101;
        return;
    L26:
        this.mBackupUrl2 = r101;
        return;
    L28:
        this.mLogoTypeVer2 = r101;
        this.mLogoType = r101;
        return;
    L30:
        this.mQualityVer2 = r101;
        this.mQuality = r101;
        return;
    L32:
        this.mBackupUrl1Ver2 = r101;
        this.mBackupUrl1 = r101;
        return;
    L34:
        this.mBackupUrlExpire = r101;
    }

    public void setValue(int r100, int r101) {
        if (r100 != 1) goto L5;
        this.mVWidth = r101;
        this.mVWidthVer2 = r101;
        return;
    L5:
        if (r100 != 2) goto L7;
        this.mVHeight = r101;
        this.mVHeightVer2 = r101;
        return;
    L7:
        if (r100 != 3) goto L9;
        this.mBitrate = r101;
        this.mBitrateVer2 = r101;
        return;
    L9:
        if (r100 != 13) goto L11;
        this.preloadInterval = r101;
        this.preLoadIntervalVer2 = r101;
        return;
    L11:
        if (r100 == 27) goto L27;
        switch(r100) {
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            default: goto L13;
        };
    L13:
        switch(r100) {
            case 20: goto L19;
            case 21: goto L17;
            case 22: goto L15;
            default: goto L14;
        };
    L14:
        return;
    L15:
        this.mSocketBuffer = r101;
        return;
    L17:
        this.useVideoProxy = r101;
        return;
    L19:
        this.mGbr = r101;
        return;
    L21:
        this.playLoadMaxStep = r101;
        return;
    L23:
        this.playLoadMinStep = r101;
        return;
    L25:
        this.preloadSize = r101;
        this.preLoadSizeVer2 = r101;
        return;
    L27:
        this.mVideoDuration = r101;
    }

    public void setValue(int r100, float r101) {
        if (r100 != 39) goto L5;
        this.mLoudness = r101;
        return;
    L5:
        if (r100 == 40) goto L7;
        return;
    L7:
        this.mPeak = r101;
    }

    public void setValue(int r100, long r101) {
        if (r100 == 12) goto L5;
        return;
    L5:
        this.mSize = r101;
        this.mSizeVer2 = r101;
    }

    public void setValue(int r100, String[] r101) {
        if (r100 == 16) goto L5;
        return;
    L5:
        this.mURLs = r101;
        this.mURLsVer2 = r101;
    }

    public void setValue(int r100, boolean r101) {
        if (r100 == 4) goto L5;
        return;
    L5:
        this.mEncrypt = r101;
    }
}
