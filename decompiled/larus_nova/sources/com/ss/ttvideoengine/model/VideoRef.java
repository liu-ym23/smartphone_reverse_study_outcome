package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoRef {
    private static final String KEY_VER1_AI_BARRAGE_URL = "effect_barrage_url";
    private static final String KEY_VER1_AUTO_DEFINITION = "auto_definition";
    private static final String KEY_VER1_BARRAGE_MASK_INFO = "barrage_mask_info";
    private static final String KEY_VER1_BARRAGE_MASK_URL = "barrage_mask_url";
    private static final String KEY_VER1_BIG_THUMBS = "big_thumbs";
    private static final String KEY_VER1_CONST_DEPTH = "const_depth";
    private static final String KEY_VER1_DECODING_MODE = "optimal_decoding_mode";
    private static final String KEY_VER1_DEPTH_ESTIMATION = "depth_estimation";
    private static final String KEY_VER1_DNS_INFO = "dns_info";
    private static final String KEY_VER1_DNS_TIME = "dns_time";
    private static final String KEY_VER1_DYNAMIC_AUDIO_LIST = "dynamic_audio_list";
    private static final String KEY_VER1_DYNAMIC_DUBBED_AUDIOS = "dynamic_dubbed_audios";
    private static final String KEY_VER1_DYNAMIC_TYPE = "dynamic_type";
    private static final String KEY_VER1_DYNAMIC_VIDEO = "dynamic_video";
    private static final String KEY_VER1_DYNAMIC_VIDEO_LIST = "dynamic_video_list";
    private static final String KEY_VER1_ENABLE_ADAPTIVE = "enable_adaptive";
    private static final String KEY_VER1_FALLBACK_API = "fallback_api";
    private static final String KEY_VER1_FULL_SCREEN_STRATEGY = "full_screen_strategy";
    private static final String KEY_VER1_HAS_EMBEDDED_SUBTITLE = "has_embedded_subtitle";
    private static final String KEY_VER1_LOUDNESS = "loudness";
    private static final String KEY_VER1_MEDIA_TYPE = "media_type";
    private static final String KEY_VER1_PALLAS_DID_LABELS = "pallas_did_labels";
    private static final String KEY_VER1_PALLAS_VID_LABELS = "pallas_vid_labels";
    private static final String KEY_VER1_PEAK = "peak";
    private static final String KEY_VER1_POPULARITY_LEVEL = "popularity_level";
    private static final String KEY_VER1_SEED = "key_seed";
    private static final String KEY_VER1_SEEK_TS = "seek_ts";
    private static final String KEY_VER1_SUBTITLE_INFO = "subtitle_infos";
    private static final String KEY_VER1_SUBTITLE_LANGS = "subtitle_langs";
    private static final String KEY_VER1_SUBTITLE_POSITION = "subtitle_position";
    private static final String KEY_VER1_SUBTITLE_POSITION_X = "x";
    private static final String KEY_VER1_SUBTITLE_POSITION_Y = "y";
    private static final String KEY_VER1_URL_EXPIRE = "url_expire";
    private static final String KEY_VER1_USER_ID = "user_id";
    private static final String KEY_VER1_VIDEOMODEL_VERSION = "version";
    private static final String KEY_VER1_VIDEO_1 = "video_1";
    private static final String KEY_VER1_VIDEO_2 = "video_2";
    private static final String KEY_VER1_VIDEO_3 = "video_3";
    private static final String KEY_VER1_VIDEO_4 = "video_4";
    private static final String KEY_VER1_VIDEO_5 = "video_5";
    private static final String KEY_VER1_VIDEO_6 = "video_6";
    private static final String KEY_VER1_VIDEO_7 = "video_7";
    private static final String KEY_VER1_VIDEO_8 = "video_8";
    private static final String KEY_VER1_VIDEO_DURATION = "video_duration";
    private static final String KEY_VER1_VIDEO_ENABLE_SSL = "enable_ssl";
    private static final String KEY_VER1_VIDEO_ID = "video_id";
    private static final String KEY_VER1_VIDEO_LIST = "video_list";
    private static final String KEY_VER1_VIDEO_NAME = "video_name";
    private static final String KEY_VER1_VIDEO_STATUS = "status";
    private static final String KEY_VER1_VIDEO_STYLE = "video_style";
    private static final String KEY_VER1_VIDEO_VALIDATE = "validate";
    private static final String KEY_VER1_VOLUME = "volume";
    private static final String KEY_VER1_VOLUME_INFO_JSON = "volume_info_json";
    private static final String KEY_VER1_VOLUME_LOUDNESS_END = "loudness_range_end";
    private static final String KEY_VER1_VOLUME_LOUDNESS_RANGE = "loudness_range";
    private static final String KEY_VER1_VOLUME_LOUDNESS_START = "loudness_range_start";
    private static final String KEY_VER1_VOLUME_MAX_MOM = "maximum_momentary_loudness";
    private static final String KEY_VER1_VOLUME_SHORTERM = "maximum_short_term_loudness";
    private static final String KEY_VER1_VOLUME_VER = "version";
    private static final String KEY_VER2_ADAPTIVE_INFO = "AdaptiveInfo";
    private static final String KEY_VER2_BIG_THUMBS = "BigThumbs";
    private static final String KEY_VER2_ENABLE_ADAPTIVE = "EnableAdaptive";
    private static final String KEY_VER2_MEDIA_TYPE = "MediaType";
    private static final String KEY_VER2_PLAY_INFO_LIST = "PlayInfoList";
    private static final String KEY_VER2_POSTER_URL = "CoverUrl";
    private static final String KEY_VER2_SEEK_TS = "Seekts";
    private static final String KEY_VER2_TOTAL_COUNT = "TotalCount";
    private static final String KEY_VER2_VIDEO_DURATION = "Duration";
    private static final String KEY_VER2_VIDEO_ENABLE_SSL = "EnableSSL";
    private static final String KEY_VER2_VIDEO_ID = "VideoID";
    private static final String KEY_VER2_VIDEO_STATUS = "Status";
    private static final String KEY_VER4_ADAPTIVE_INFO = "AdaptiveInfo";
    private static final String KEY_VER4_BARRAGE_MASK_INFO = "BarrageMaskInfo";
    private static final String KEY_VER4_BARRAGE_MASK_URL = "BarrageMaskUrl";
    private static final String KEY_VER4_ENABLE_ADAPTIVE = "EnableAdaptive";
    private static final String KEY_VER4_FILE_TYPE = "FileType";
    private static final String KEY_VER4_PLAY_INFO_LIST = "PlayInfoList";
    private static final String KEY_VER4_POSTER_URL = "PosterUrl";
    private static final String KEY_VER4_SUBTITLE_INFO = "SubtitleInfoList";
    private static final String KEY_VER4_THUMB_INFO_LIST = "ThumbInfoList";
    private static final String KEY_VER4_TOTAL_COUNT = "TotalCount";
    private static final String KEY_VER4_VIDEOMODEL_VERSION = "Version";
    private static final String KEY_VER4_VIDEO_DURATION = "Duration";
    private static final String KEY_VER4_VIDEO_ENABLE_SSL = "EnableSSL";
    private static final String KEY_VER4_VIDEO_ID = "Vid";
    private static final String KEY_VER4_VIDEO_STATUS = "Status";
    public static int TYPE_AUDIO = 1;
    public static int TYPE_VIDEO = 0;
    public static final int VALUE_VIDEO_REF_AI_BARRAGE_URL = 235;
    public static final int VALUE_VIDEO_REF_AUTO_DEFINITION = 107;
    public static final int VALUE_VIDEO_REF_BARRAGE_MASK_URL = 221;
    public static final int VALUE_VIDEO_REF_BASH_STRING = 8;
    public static final int VALUE_VIDEO_REF_BUSINESS_ID = 246;
    public static final int VALUE_VIDEO_REF_CATEGORY = 232;
    public static final int VALUE_VIDEO_REF_CODEC_HAS_BYTEVC1 = 204;
    public static final int VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2 = 228;
    public static final int VALUE_VIDEO_REF_CODEC_HAS_H264 = 203;
    public static final int VALUE_VIDEO_REF_CONST_DEPTH = 236;
    public static final int VALUE_VIDEO_REF_DECODING_MODE = 223;
    public static final int VALUE_VIDEO_REF_DEFAULT_AUDIO_INFO_ID = 230;
    public static final int VALUE_VIDEO_REF_DNS_TIME = 216;
    public static final int VALUE_VIDEO_REF_DUBBED_AUDIO_INFO_LIST = 231;
    public static final int VALUE_VIDEO_REF_DYNAMIC_BACKUP_URL = 109;
    public static final int VALUE_VIDEO_REF_DYNAMIC_MAIN_URL = 108;
    public static final int VALUE_VIDEO_REF_DYNAMIC_TYPE = 215;
    public static final int VALUE_VIDEO_REF_DYNAMIC_URLS = 213;
    public static final int VALUE_VIDEO_REF_DYNAMIC_VIDEO_List = 210;
    public static final int VALUE_VIDEO_REF_ENABLE_ADAPTIVE = 222;
    public static final int VALUE_VIDEO_REF_FALLBACK_API = 217;
    public static final int VALUE_VIDEO_REF_FIRST_SUB_VID = 233;
    public static final int VALUE_VIDEO_REF_FORMAT = 211;
    public static final int VALUE_VIDEO_REF_FORMAT_HAS_DASH = 205;
    public static final int VALUE_VIDEO_REF_FORMAT_HAS_HLS = 208;
    public static final int VALUE_VIDEO_REF_FORMAT_HAS_MP4 = 206;
    public static final int VALUE_VIDEO_REF_FORMAT_HAS_MPD = 207;
    public static final int VALUE_VIDEO_REF_FULL_SCREEN_STRATEGY = 226;
    public static final int VALUE_VIDEO_REF_HAS_EMBEDED_SUBTITLE = 229;
    public static final int VALUE_VIDEO_REF_KEY_SEED = 218;
    public static final int VALUE_VIDEO_REF_KEY_URL_ENCRYPTED = 219;
    public static final int VALUE_VIDEO_REF_LABEL_USAGE = 245;
    public static final int VALUE_VIDEO_REF_LOUDNESS = 224;
    public static final int VALUE_VIDEO_REF_MASK_FILE_HASH = 241;
    public static final int VALUE_VIDEO_REF_MASK_FILE_SIZE = 243;
    public static final int VALUE_VIDEO_REF_MASK_HEAD_LEN = 242;
    public static final int VALUE_VIDEO_REF_MEDIA_TYPE = 7;
    public static final int VALUE_VIDEO_REF_MODEL_VERSION = 9;
    public static final int VALUE_VIDEO_REF_MULTI_BITRATE_REFACTOR = 253;
    public static final int VALUE_VIDEO_REF_ORIGINAL_AUDIO_INFO_LIST = 234;
    public static final int VALUE_VIDEO_REF_PALLAS_DID_LABELS = 244;
    public static final int VALUE_VIDEO_REF_PALLAS_VID_LABELS = 237;
    public static final int VALUE_VIDEO_REF_PEAK = 225;
    public static final int VALUE_VIDEO_REF_PLACEHOLDER = 254;
    public static final int VALUE_VIDEO_REF_POPULARITY_LEVEL = 227;
    public static final int VALUE_VIDEO_REF_POSTER_URL = 201;
    public static final int VALUE_VIDEO_REF_STATUS = 4;
    public static final int VALUE_VIDEO_REF_SUBTITLE_POSITION_X = 239;
    public static final int VALUE_VIDEO_REF_SUBTITLE_POSITION_Y = 240;
    public static final int VALUE_VIDEO_REF_THUMB_INFO_LIST = 212;
    public static final int VALUE_VIDEO_REF_TOTAL_COUNT = 209;
    public static final int VALUE_VIDEO_REF_URL_EXPIRE = 220;
    public static final int VALUE_VIDEO_REF_USER_ID = 1;
    public static final int VALUE_VIDEO_REF_VIDEO_DURATION = 3;
    public static final int VALUE_VIDEO_REF_VIDEO_ENABLE_SSL = 106;
    public static final int VALUE_VIDEO_REF_VIDEO_ID = 2;
    public static final int VALUE_VIDEO_REF_VIDEO_LIST = 5;
    public static final int VALUE_VIDEO_REF_VIDEO_NAME = 104;
    public static final int VALUE_VIDEO_REF_VIDEO_SEEK_TS = 214;
    public static final int VALUE_VIDEO_REF_VIDEO_VALIDATE = 105;
    public static final int VALUE_VIDEO_REF_VOLUME_INFO_JSON = 260;
    public static final int VALUE_VIDEO_REF_VOLUME_LU_END = 248;
    public static final int VALUE_VIDEO_REF_VOLUME_LU_RANGE = 252;
    public static final int VALUE_VIDEO_REF_VOLUME_LU_START = 247;
    public static final int VALUE_VIDEO_REF_VOLUME_MAX_MOM = 249;
    public static final int VALUE_VIDEO_REF_VOLUME_MAX_SHOTERM = 250;
    public static final int VALUE_VIDEO_REF_VOLUME_VER = 251;
    private String mAIBarrageUrl;
    private VideoAdaptiveInfo mAdaptiveInfo;
    private VideoAdaptiveInfo mAdaptiveInfoVer2;
    private ArrayList<String> mAllQualityArray;
    private String[] mAllQualityInfos;
    private Resolution[] mAllResolutions;
    private ArrayList<Resolution> mAllResolutionsArray;
    private HashMap<String, Resolution> mAudioResolutionMap;
    public String mAutoDefinition;
    public String mBackupURL;
    private String mBarrageMaskUrl;
    private String mBashString;
    private String mBid;
    private int mCategory;
    private String[] mCodecArray;
    private boolean mCodecHasByteVC1;
    private boolean mCodecHasByteVC2;
    private boolean mCodecHasH264;
    public float mConstDepth;
    public String mDecodingMode;
    public int[] mDefaultInfoId;
    private JSONObject mDnsInfo;
    private Map<String, VideoModelPb.DNS> mDnsInfoVer3;
    private long mDnsTime;
    public List<VideoInfo> mDubbedAudioInfo;
    private String mDynamicType;
    public List<VideoInfo> mDynamicVideoList;
    public boolean mEnableAdaptive;
    public boolean mEnableSSL;
    public String mFallbackApi;
    private String mFirstSubVid;
    private String mFormat;
    private boolean mFormatHasDASH;
    private boolean mFormatHasHls;
    private boolean mFormatHasMP4;
    private boolean mFormatHasMPD;
    public String mFullScreen;
    private boolean mHasEmbeddedSubtitle;
    public String mKeyseed;
    public String mLabelUsage;
    public float mLoudness;
    private float mLuEnd;
    private float mLuRange;
    private float mLuStart;
    private boolean mMBRefactor;
    public String mMainURL;
    private String mMaskFileHash;
    private long mMaskFileSize;
    private int mMaskHeadLen;
    public BarrageMaskInfo mMaskInfo;
    private float mMaxMomLu;
    private float mMaxShortermLu;
    public String mMediaType;
    public int mMediaTypeInt;
    private int mMediaTypeIntVer2;
    private String mMediaTypeVer2;
    public List<VideoInfo> mOriginalAudioInfo;
    private String mPallasDidLabels;
    private String mPallasVidLabels;
    public float mPeak;
    public int mPopularityLevel;
    private String mPosterUrl;
    private String mPosterUrlVer2;
    public VideoSeekTs mSeekTs;
    private VideoSeekTs mSeekTsVer2;
    public int mStatus;
    private int mStatusVer2;
    public List<SubInfo> mSubInfoList;
    public int[] mSubLangs;
    public float mSubtitlePositionX;
    public float mSubtitlePositionY;
    public List<VideoThumbInfo> mThumbInfoList;
    private List<VideoThumbInfo> mThumbInfoListVer2;
    private int mTotalCount;
    private int mTotalCountVer2;
    private boolean mURLEncrypted;
    public String[] mURLs;
    private long mUrlExpire;
    public String mUserId;
    public String mValidate;
    private int mVersion;
    public int mVideoDuration;
    private int mVideoDurationVer2;
    public String mVideoId;
    private String mVideoIdVer2;
    public List<VideoInfo> mVideoList;
    private List<VideoInfo> mVideoListVer2;
    public String mVideoName;
    private HashMap<String, Resolution> mVideoResolutionMap;
    public VideoStyle mVideoStyle;
    private int mVolumInfoVer;
    private String mVolumeInfoJson;

    public void parseFromPb(VideoModelPb.VideoInfo r100) {
    }

    public String[] getCodecs() {
        if (this.mCodecArray != null) goto L20;
        List<VideoInfo> r100 = getVideoInfoList();
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L7;
    L18:
        String[] r102 = new String[r101.size()];
        this.mCodecArray = r102;
        r101.toArray(r102);
        goto L20
    L7:
        if (r100.size() <= 0) goto L18;
        Iterator<VideoInfo> r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L18;
        VideoInfo r104 = r103.next();
        if (r104 == null) goto L10;
        String r105 = r104.getValueStr(8);
        if (TextUtils.isEmpty(r105) == true) goto L10;
        if (r101.contains(r105) == true) goto L10;
        r101.add(r105);
    L20:
        return this.mCodecArray;
    }

    public VideoSeekTs getSeekTs() {
        if (this.mVersion != 2) goto L7;
        return this.mSeekTsVer2;
    L7:
        return this.mSeekTs;
    }

    public List<VideoThumbInfo> getThumbInfoList() {
        if (this.mVersion != 2) goto L7;
        return this.mThumbInfoListVer2;
    L7:
        return this.mThumbInfoList;
    }

    public List<VideoInfo> getVideoInfoList() {
        if (this.mVersion == 2) goto L5;
        List<VideoInfo> r100 = this.mVideoList;
        if (r100 != null) goto L9;
    L11:
        List<VideoInfo> r101 = null;
    L12:
        List<VideoInfo> r102 = this.mDynamicVideoList;
        if (r102 != null) goto L15;
        return r101;
    L15:
        if (r102.size() > 0) goto L17;
        return r101;
    L17:
        return this.mDynamicVideoList;
    L9:
        if (r100.size() <= 0) goto L11;
        r101 = this.mVideoList;
        goto L12
    L5:
        return this.mVideoListVer2;
    }

    public VideoRef() {
        this.mVersion = 1;
        this.mAllResolutionsArray = new ArrayList();
        this.mAllQualityArray = new ArrayList();
        this.mCodecArray = null;
        this.mDynamicType = "";
        this.mFormat = "mp4";
        this.mBashString = "";
        this.mCodecHasByteVC1 = false;
        this.mCodecHasByteVC2 = false;
        this.mCodecHasH264 = false;
        this.mFormatHasDASH = false;
        this.mFormatHasMPD = false;
        this.mFormatHasMP4 = false;
        this.mFormatHasHls = false;
        this.mHasEmbeddedSubtitle = false;
        this.mDefaultInfoId = new int[]{-1, -1};
        this.mMBRefactor = false;
        this.mConstDepth = 0.0f;
        this.mSubtitlePositionX = 0.0f;
        this.mSubtitlePositionY = 0.0f;
        this.mURLEncrypted = false;
        this.mVideoResolutionMap = TTHelper.defaultVideoResolutionMap();
        this.mAudioResolutionMap = TTHelper.defaultAudioResolutionMap();
        int r100 = TYPE_VIDEO;
        this.mMediaTypeInt = r100;
        this.mLoudness = 0.0f;
        this.mPeak = 0.0f;
        this.mLuRange = 0.0f;
        this.mLuStart = 0.0f;
        this.mLuEnd = 0.0f;
        this.mMaxMomLu = 0.0f;
        this.mMaxShortermLu = 0.0f;
        this.mVolumInfoVer = 0;
        this.mVolumeInfoJson = "";
        this.mFirstSubVid = null;
        this.mPallasVidLabels = "";
        this.mPallasDidLabels = "";
        this.mBid = "";
        this.mCategory = 0;
        this.mVideoListVer2 = null;
        this.mMediaTypeIntVer2 = r100;
        this.mUrlExpire = 0;
        this.mMaskFileSize = 0;
    }

    public JSONObject toBashJsonObject() {
        return VideoListToJsonObject(getVideoInfoList());
    }

    public String toBashString() {
        return VideoListToBashString(getVideoInfoList());
    }

    public JSONObject getDnsInfo() {
        return this.mDnsInfo;
    }

    public List<SubInfo> getSubInfoList() {
        return this.mSubInfoList;
    }

    public String[] getSupportQualityInfos() {
        return this.mAllQualityInfos;
    }

    public Resolution[] getSupportResolutions() {
        return this.mAllResolutions;
    }

    public int[] getSupportSubtitleLangs() {
        return this.mSubLangs;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public static String VideoListToBashString(List<VideoInfo> r100) {
        JSONObject r101 = VideoListToJsonObject(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.toString();
    }

    public static JSONObject VideoListToJsonObject(List<VideoInfo> r100) {
        if (r100 != null) goto L30;
    L29:
        return null;
    L30:
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L5:
        if (r100.size() <= 0) goto L29;
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L27
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L27
        Iterator<VideoInfo> r103 = r100.iterator();     // Catch: Exception -> L27
    L9:
        if (r103.hasNext() == false) goto L22;
        VideoInfo r104 = r103.next();     // Catch: Exception -> L27
        if (r104 == null) goto L9;
        JSONObject r105 = r104.toBashJsonObject();     // Catch: Exception -> L27
        if (r105 == null) goto L9;
        if (r104.getMediatype() == TYPE_VIDEO) goto L17;
        if (r104.getMediatype() != TYPE_AUDIO) goto L9;
        r102.put(r105);     // Catch: Exception -> L27
        goto L9
    L17:
        r101.put(r105);     // Catch: Exception -> L27
        goto L9
    L22:
        if (r101.length() <= 0) goto L24;
    L25:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L27
        r106.put(KEY_VER1_DYNAMIC_VIDEO_LIST, r101);     // Catch: Exception -> L27
        r106.put(KEY_VER1_DYNAMIC_AUDIO_LIST, r102);     // Catch: Exception -> L27
        return r106;
    L24:
        if (r102.length() <= 0) goto L29;
        goto L25
    }

    public void extractFields(JSONObject r210) throws JSONException {
        if (r210 != null) goto L5;
        return;
    L5:
        JSONArray r100 = r210.optJSONArray("PlayInfoList");
        if (r100 == null) goto L10;
        if (r100.length() <= 0) goto L10;
    L21:
        if (r210.optInt("Version") != 4) goto L23;
        this.mVersion = 4;
    L24:
        int r101 = this.mVersion;
        int r110 = 0;
        if (r101 == 1) goto L136;
        if (r101 == 3) goto L136;
        if (r101 != 2) goto L82;
        this.mStatusVer2 = r210.optInt("Status");
        this.mVideoIdVer2 = r210.optString(KEY_VER2_VIDEO_ID);
        this.mPosterUrlVer2 = r210.optString(KEY_VER2_POSTER_URL);
        this.mVideoDurationVer2 = r210.optInt("Duration");
        this.mMediaTypeVer2 = r210.optString(KEY_VER2_MEDIA_TYPE);
        this.mTotalCountVer2 = r210.optInt("TotalCount");
        this.mEnableSSL = r210.optBoolean("EnableSSL");
        this.mEnableAdaptive = r210.optBoolean("EnableAdaptive");
        if (this.mMediaTypeVer2.equals("video") == false) goto L34;
        this.mMediaTypeIntVer2 = TYPE_VIDEO;
    L37:
        if (r210.has(KEY_VER2_SEEK_TS) == false) goto L40;
        VideoSeekTs r102 = new VideoSeekTs();
        this.mSeekTsVer2 = r102;
        r102.extractFields(JSONObjectProtectorUtils.getJSONObject(r210, KEY_VER2_SEEK_TS));
    L40:
        if (r210.has(KEY_VER2_BIG_THUMBS) == false) goto L51;
        JSONArray r103 = r210.optJSONArray(KEY_VER2_BIG_THUMBS);
        if (r103 == null) goto L51;
        if (r103.length() <= 0) goto L51;
        this.mThumbInfoListVer2 = new ArrayList();
        int r104 = 0;
    L47:
        if (r104 >= r103.length()) goto L51;
        VideoThumbInfo r105 = new VideoThumbInfo();     // Catch: JSONException -> L429
        r105.setVersion(this.mVersion);     // Catch: JSONException -> L429
        r105.extractFields(JSONArrayProtectorUtils.getJSONObject(r103, r104));     // Catch: JSONException -> L429
        this.mThumbInfoListVer2.add(r105);     // Catch: JSONException -> L429
    L49:
        r104 = r104 + 1;
    L51:
        if (r210.has(KEY_VER4_SUBTITLE_INFO) == false) goto L60;
        JSONArray r106 = r210.optJSONArray(KEY_VER4_SUBTITLE_INFO);
        if (r106 == null) goto L60;
        if (r106.length() <= 0) goto L60;
        this.mSubInfoList = new ArrayList();
        int r107 = 0;
    L58:
        if (r107 >= r106.length()) goto L60;
        SubInfo r108 = new SubInfo();
        r108.extractFields(JSONArrayProtectorUtils.getJSONObject(r106, r107));
        this.mSubInfoList.add(r108);
        r107 = r107 + 1;
    L60:
        if (r100 == null) goto L72;
        if (r100.length() <= 0) goto L72;
        this.mVideoListVer2 = new ArrayList();
        int r109 = 0;
    L65:
        if (r110 >= r100.length()) goto L72;
        JSONObject r111 = JSONArrayProtectorUtils.getJSONObject(r100, r110);
        int r112 = this.mMediaTypeIntVer2;
        if (this.mURLEncrypted == false) goto L69;
        String r113 = this.mKeyseed;
    L70:
        VideoInfo r114 = _generateVideoInfo(r111, r112, r113);
        int r115 = r109 + 1;
        r114.mInfoId = r109;
        this.mVideoListVer2.add(r114);
        r110 = r110 + 1;
        r109 = r115;
        goto L65
    L69:
        r113 = null;
    L72:
        if (r210.has("AdaptiveInfo") == false) goto L412;
        JSONObject r116 = r210.optJSONObject("AdaptiveInfo");
        if (r116 == null) goto L412;
        VideoAdaptiveInfo r117 = new VideoAdaptiveInfo();
        this.mAdaptiveInfoVer2 = r117;
        r117.extractFields(r116);
        this.mDynamicType = this.mAdaptiveInfoVer2.getValueStr(215);
        this.mMainURL = this.mAdaptiveInfoVer2.getValueStr(108);
        this.mBackupURL = this.mAdaptiveInfoVer2.getValueStr(109);
        ArrayList r118 = new ArrayList();
        if (TextUtils.isEmpty(this.mMainURL) == true) goto L79;
        r118.add(this.mMainURL);
    L79:
        if (TextUtils.isEmpty(this.mBackupURL) == true) goto L81;
        r118.add(this.mBackupURL);
    L81:
        String[] r119 = new String[r118.size()];
        this.mURLs = r119;
        r118.toArray(r119);
    L412:
        List<VideoInfo> r120 = getVideoInfoList();
        if (r120 != null) goto L415;
    L425:
        this.mBashString = toBashString();
        Resolution[] r121 = new Resolution[this.mAllResolutionsArray.size()];
        this.mAllResolutions = r121;
        this.mAllResolutionsArray.toArray(r121);
        String[] r122 = new String[this.mAllQualityArray.size()];
        this.mAllQualityInfos = r122;
        this.mAllQualityArray.toArray(r122);
        if (TextUtils.isEmpty(this.mBid) == false) goto L472;
        this.mBid = getValueStr(2);
        return;
    L472:
        return;
    L415:
        if (r120.size() <= 0) goto L425;
        Iterator<VideoInfo> r123 = r120.iterator();
    L418:
        if (r123.hasNext() == false) goto L425;
        VideoInfo r124 = r123.next();
        int r125 = r124.getMediatype();
        int r126 = TYPE_VIDEO;
        if (r125 == r126) goto L421;
        int r127 = r124.getMediatype();
        int r128 = TYPE_AUDIO;
        if (r127 != r128) goto L418;
        this.mMediaTypeIntVer2 = r128;
        this.mMediaTypeInt = r128;
        goto L418
    L421:
        this.mMediaTypeIntVer2 = r126;
        this.mMediaTypeInt = r126;
        goto L425
    L34:
        if (this.mMediaTypeVer2.equals("audio") == false) goto L37;
        this.mMediaTypeIntVer2 = TYPE_AUDIO;
        goto L37
    L82:
        if (r101 != 4) goto L412;
        this.mStatus = r210.optInt("Status");
        this.mVideoId = r210.optString(KEY_VER4_VIDEO_ID);
        this.mPosterUrl = r210.optString(KEY_VER4_POSTER_URL);
        this.mVideoDuration = r210.optInt("Duration");
        this.mMediaType = r210.optString(KEY_VER4_FILE_TYPE);
        this.mTotalCount = r210.optInt("TotalCount");
        this.mEnableSSL = r210.optBoolean("EnableSSL");
        this.mEnableAdaptive = r210.optBoolean("EnableAdaptive");
        this.mBarrageMaskUrl = r210.optString("BarrageMaskUrl");
        if (r210.has(KEY_VER4_BARRAGE_MASK_INFO) == false) goto L87;
        BarrageMaskInfo r129 = new BarrageMaskInfo();
        this.mMaskInfo = r129;
        r129.extractFieldsV4(r210.optJSONObject(KEY_VER4_BARRAGE_MASK_INFO));
        this.mBarrageMaskUrl = this.mMaskInfo.getValueStr(1);
        this.mMaskHeadLen = this.mMaskInfo.getValueInt(7);
        this.mMaskFileHash = this.mMaskInfo.getValueStr(3);
        this.mMaskFileSize = this.mMaskInfo.getValueLong(4);
    L87:
        if (this.mMediaType.equals("video") == false) goto L90;
        this.mMediaTypeInt = TYPE_VIDEO;
    L92:
        if (r100 == null) goto L105;
        if (r100.length() <= 0) goto L105;
        this.mVideoList = new ArrayList();
        int r130 = 0;
        int r131 = 0;
    L97:
        if (r130 >= r100.length()) goto L103;
        JSONObject r132 = JSONArrayProtectorUtils.getJSONObject(r100, r130);
        int r133 = this.mMediaTypeInt;
        if (this.mURLEncrypted == false) goto L101;
        String r134 = this.mKeyseed;
    L102:
        VideoInfo r135 = _generateVideoInfo(r132, r133, r134);
        int r136 = r131 + 1;
        r135.mInfoId = r131;
        this.mVideoList.add(r135);
        r130 = r130 + 1;
        r131 = r136;
        goto L97
    L101:
        r134 = null;
        goto L102
    L103:
        this.mLoudness = ((VideoInfo) ListProtector.get(this.mVideoList, 0)).mLoudness;
        this.mPeak = ((VideoInfo) ListProtector.get(this.mVideoList, 0)).mPeak;
    L105:
        if (r210.has("AdaptiveInfo") == false) goto L116;
        JSONObject r137 = r210.optJSONObject("AdaptiveInfo");
        if (r137 == null) goto L116;
        VideoAdaptiveInfo r138 = new VideoAdaptiveInfo();
        this.mAdaptiveInfo = r138;
        r138.extractFields(r137);
        this.mDynamicType = this.mAdaptiveInfo.getValueStr(215);
        this.mMainURL = this.mAdaptiveInfo.getValueStr(108);
        this.mBackupURL = this.mAdaptiveInfo.getValueStr(109);
        ArrayList r139 = new ArrayList();
        if (TextUtils.isEmpty(this.mMainURL) == true) goto L112;
        r139.add(this.mMainURL);
    L112:
        if (TextUtils.isEmpty(this.mBackupURL) == true) goto L114;
        r139.add(this.mBackupURL);
    L114:
        String[] r140 = new String[r139.size()];
        this.mURLs = r140;
        r139.toArray(r140);
    L116:
        if (r210.has(KEY_VER4_SUBTITLE_INFO) == false) goto L126;
        JSONArray r141 = r210.optJSONArray(KEY_VER4_SUBTITLE_INFO);
        if (r141 == null) goto L126;
        if (r141.length() <= 0) goto L126;
        this.mSubInfoList = new ArrayList();
        int r142 = 0;
    L123:
        if (r142 >= r141.length()) goto L126;
        SubInfo r143 = new SubInfo();
        r143.extractFields(JSONArrayProtectorUtils.getJSONObject(r141, r142));
        this.mSubInfoList.add(r143);
        r142 = r142 + 1;
    L126:
        if (r210.has(KEY_VER4_THUMB_INFO_LIST) == false) goto L412;
        JSONArray r144 = r210.optJSONArray(KEY_VER4_THUMB_INFO_LIST);
        if (r144 == null) goto L412;
        if (r144.length() <= 0) goto L412;
        this.mThumbInfoList = new ArrayList();
    L133:
        if (r110 >= r144.length()) goto L412;
        VideoThumbInfo r145 = new VideoThumbInfo();
        r145.setVersion(this.mVersion);
        r145.extractFields(JSONArrayProtectorUtils.getJSONObject(r144, r110));
        this.mThumbInfoList.add(r145);
        r110 = r110 + 1;
        goto L133
    L90:
        if (this.mMediaType.equals("audio") == false) goto L92;
        this.mMediaTypeInt = TYPE_AUDIO;
    L136:
        if (r101 != 1) goto L140;
        this.mFallbackApi = r210.optString("fallback_api");
        String r146 = r210.optString(KEY_VER1_SEED);
        if (TextUtils.isEmpty(r146) == true) goto L145;
        this.mKeyseed = r146;
    L145:
        this.mVideoDuration = r210.optInt(KEY_VER1_VIDEO_DURATION);
        this.mStatus = r210.optInt("status");
        this.mEnableSSL = r210.optBoolean(KEY_VER1_VIDEO_ENABLE_SSL);
        this.mEnableAdaptive = r210.optBoolean("enable_adaptive");
        this.mVideoId = r210.optString("video_id");
        this.mPopularityLevel = r210.optInt(KEY_VER1_POPULARITY_LEVEL);
        this.mMediaType = r210.optString("media_type");
        this.mDecodingMode = r210.optString(KEY_VER1_DECODING_MODE);
        this.mUrlExpire = r210.optLong(KEY_VER1_URL_EXPIRE);
        this.mValidate = r210.optString("validate");
        this.mAutoDefinition = r210.optString(KEY_VER1_AUTO_DEFINITION);
        this.mVideoName = r210.optString(KEY_VER1_VIDEO_NAME);
        this.mUserId = r210.optString("user_id");
        this.mMBRefactor = r210.optBoolean(IVideoEventLogger.FEATURE_KEY_MULTI_BITRATE_REFACTOR, false);
        if (this.mVersion != 1) goto L161;
        String r147 = r210.optString("barrage_mask_url");
        if (TextUtils.isEmpty(r147) == false) goto L150;
    L154:
        String r148 = r210.optString(KEY_VER1_AI_BARRAGE_URL);
        if (TextUtils.isEmpty(r148) == false) goto L157;
    L162:
        String r149 = r210.optString("video_meta");
        boolean r150 = TextUtils.isEmpty(r149);
        String r151 = KEY_VER1_VOLUME_SHORTERM;
        if (r150 == false) goto L431;
        Object r152 = "audio";
        Object r153 = "video";
    L216:
        if (this.mMediaType.equals(r153) == false) goto L219;
        this.mMediaTypeInt = TYPE_VIDEO;
    L222:
        if (r210.has(KEY_VER1_SUBTITLE_LANGS) == false) goto L232;
        JSONArray r154 = r210.optJSONArray(KEY_VER1_SUBTITLE_LANGS);
        if (r154 == null) goto L232;
        if (r154.length() <= 0) goto L232;
        this.mSubLangs = new int[r154.length()];
        int r155 = 0;
    L229:
        if (r155 >= r154.length()) goto L232;
        this.mSubLangs[r155] = r154.optInt(r155);
        r155 = r155 + 1;
    L232:
        if (r210.has(KEY_VER1_SUBTITLE_INFO) == false) goto L241;
        JSONArray r156 = r210.optJSONArray(KEY_VER1_SUBTITLE_INFO);
        if (r156 == null) goto L241;
        if (r156.length() <= 0) goto L241;
        this.mSubInfoList = new ArrayList();
        int r157 = 0;
    L239:
        if (r157 >= r156.length()) goto L241;
        SubInfo r158 = new SubInfo();
        r158.extractFields(JSONArrayProtectorUtils.getJSONObject(r156, r157));
        this.mSubInfoList.add(r158);
        r157 = r157 + 1;
    L241:
        this.mHasEmbeddedSubtitle = r210.optBoolean(KEY_VER1_HAS_EMBEDDED_SUBTITLE);
        JSONObject r159 = r210.optJSONObject(KEY_VER1_DEPTH_ESTIMATION);
        if (r159 == null) goto L244;
        this.mConstDepth = (float) r159.optDouble(KEY_VER1_CONST_DEPTH);
    L244:
        JSONObject r160 = r210.optJSONObject(KEY_VER1_SUBTITLE_POSITION);
        if (r160 == null) goto L248;
        this.mSubtitlePositionX = (float) r160.optDouble("x");
        this.mSubtitlePositionY = (float) r160.optDouble("y");
    L248:
        if (this.mVersion != 1) goto L264;
        JSONObject r161 = r210.optJSONObject(KEY_VER1_VIDEO_LIST);
        if (r161 == null) goto L263;
        this.mVideoList = new ArrayList();
        String[] r162 = {KEY_VER1_VIDEO_1, KEY_VER1_VIDEO_2, KEY_VER1_VIDEO_3, KEY_VER1_VIDEO_4, KEY_VER1_VIDEO_5, KEY_VER1_VIDEO_6, KEY_VER1_VIDEO_7, KEY_VER1_VIDEO_8};
        String r163 = KEY_VER1_VOLUME_INFO_JSON;
        int r164 = 0;
        int r165 = 0;
    L253:
        if (r164 >= 8) goto L277;
        String r166 = r162[r164];
        if (r161.has(r166) == false) goto L262;
        JSONObject r167 = JSONObjectProtectorUtils.getJSONObject(r161, r166);
        int r168 = this.mMediaTypeInt;
        if (this.mURLEncrypted == false) goto L259;
        String r169 = this.mKeyseed;
    L260:
        VideoInfo r170 = _generateVideoInfo(r167, r168, r169);
        r170.mVideoDuration = this.mVideoDuration;
        int r171 = r165 + 1;
        r170.mInfoId = r165;
        this.mVideoList.add(r170);
        r165 = r171;
        goto L262
    L259:
        r169 = null;
    L262:
        r164 = r164 + 1;
        r161 = r161;
        r162 = r162;
    L277:
        this.mDnsInfo = r210.optJSONObject(KEY_VER1_DNS_INFO);
        int r172 = r165;
        this.mDnsTime = r210.optLong(KEY_VER1_DNS_TIME);
        JSONObject r173 = r210.optJSONObject(KEY_VER1_DYNAMIC_VIDEO);
        if (r173 != null) goto L280;
        String r174 = KEY_VER1_VOLUME_SHORTERM;
    L348:
        if (r210.has(KEY_VER1_BARRAGE_MASK_INFO) == false) goto L361;
        BarrageMaskInfo r175 = new BarrageMaskInfo();
        this.mMaskInfo = r175;
        r175.extractFields(JSONObjectProtectorUtils.getJSONObject(r210, KEY_VER1_BARRAGE_MASK_INFO));
        if (this.mVersion != 1) goto L358;
        String r176 = this.mMaskInfo.getValueStr(1);
        if (TextUtils.isEmpty(r176) == false) goto L354;
    L359:
        this.mMaskHeadLen = this.mMaskInfo.getValueInt(7);
        this.mMaskFileHash = this.mMaskInfo.getValueStr(3);
        this.mMaskFileSize = this.mMaskInfo.getValueLong(4);
        goto L361
    L354:
        if (this.mURLEncrypted == false) goto L356;
        String r177 = this.mKeyseed;
    L357:
        this.mBarrageMaskUrl = TTHelper.base64Decode(r176, r177);
        goto L359
    L356:
        r177 = null;
        goto L357
    L358:
        this.mBarrageMaskUrl = this.mMaskInfo.getValueStr(1);
    L361:
        if (r210.has(KEY_VER1_SEEK_TS) == false) goto L364;
        VideoSeekTs r178 = new VideoSeekTs();
        this.mSeekTs = r178;
        r178.extractFields(JSONObjectProtectorUtils.getJSONObject(r210, KEY_VER1_SEEK_TS));
    L364:
        if (r210.has(KEY_VER1_BIG_THUMBS) == false) goto L374;
        JSONArray r179 = r210.optJSONArray(KEY_VER1_BIG_THUMBS);
        if (r179 == null) goto L374;
        if (r179.length() <= 0) goto L374;
        this.mThumbInfoList = new ArrayList();
        int r180 = 0;
    L371:
        if (r180 >= r179.length()) goto L374;
        VideoThumbInfo r181 = new VideoThumbInfo();
        r181.setVersion(this.mVersion);
        r181.extractFields(JSONArrayProtectorUtils.getJSONObject(r179, r180));
        this.mThumbInfoList.add(r181);
        r180 = r180 + 1;
    L374:
        if (r210.has("volume") == false) goto L403;
        JSONObject r182 = r210.optJSONObject("volume");
        if (r182 == null) goto L403;
        if (r182.has(KEY_VER1_LOUDNESS) == false) goto L380;
    L381:
        this.mLoudness = (float) r182.optDouble(KEY_VER1_LOUDNESS);
        this.mPeak = (float) r182.optDouble(KEY_VER1_PEAK);
    L383:
        if (r182.has("version") == false) goto L386;
        this.mVolumInfoVer = r182.optInt("version");
    L386:
        if (r182.has(KEY_VER1_VOLUME_LOUDNESS_RANGE) == false) goto L389;
        this.mLuRange = (float) r182.optDouble(KEY_VER1_VOLUME_LOUDNESS_RANGE);
    L389:
        if (r182.has(KEY_VER1_VOLUME_LOUDNESS_START) == false) goto L392;
        this.mLuStart = (float) r182.optDouble(KEY_VER1_VOLUME_LOUDNESS_START);
    L392:
        if (r182.has(KEY_VER1_VOLUME_LOUDNESS_END) == false) goto L395;
        this.mLuEnd = (float) r182.optDouble(KEY_VER1_VOLUME_LOUDNESS_END);
    L395:
        if (r182.has(KEY_VER1_VOLUME_MAX_MOM) == false) goto L397;
        this.mMaxMomLu = (float) r182.optDouble(KEY_VER1_VOLUME_MAX_MOM);
    L397:
        String r183 = r174;
        if (r182.has(r183) == false) goto L400;
        this.mMaxShortermLu = (float) r182.optDouble(r183);
    L400:
        String r184 = r163;
        if (r182.has(r184) == false) goto L403;
        this.mVolumeInfoJson = r182.optString(r184);
        goto L403
    L380:
        if (r182.has(KEY_VER1_PEAK) == false) goto L383;
    L403:
        this.mFullScreen = r210.optString(KEY_VER1_FULL_SCREEN_STRATEGY);
        if (r210.has("video_style") == false) goto L407;
        VideoStyle r185 = new VideoStyle();
        this.mVideoStyle = r185;
        r185.extractFields(r210.optJSONObject("video_style"));
    L407:
        if (r210.has(KEY_VER1_PALLAS_VID_LABELS) == false) goto L410;
        this.mPallasVidLabels = r210.optString(KEY_VER1_PALLAS_VID_LABELS);
    L410:
        if (r210.has(KEY_VER1_PALLAS_DID_LABELS) == false) goto L412;
        this.mPallasDidLabels = r210.optString(KEY_VER1_PALLAS_DID_LABELS);
        goto L412
    L280:
        if (this.mVersion != 1) goto L295;
        String r186 = r173.optString("main_url");
        if (TextUtils.isEmpty(r186) == false) goto L284;
    L288:
        String r187 = r173.optString("backup_url_1");
        if (TextUtils.isEmpty(r187) == false) goto L291;
    L296:
        this.mDynamicType = r173.optString(KEY_VER1_DYNAMIC_TYPE);
        this.mDynamicVideoList = new ArrayList();
        JSONArray r188 = r173.optJSONArray(KEY_VER1_DYNAMIC_VIDEO_LIST);
        if (r188 != null) goto L299;
    L309:
        r174 = KEY_VER1_VOLUME_SHORTERM;
        int r189 = r172;
    L310:
        JSONArray r190 = r173.optJSONArray(KEY_VER1_DYNAMIC_DUBBED_AUDIOS);
        if (r190 != null) goto L313;
    L322:
        JSONArray r191 = r173.optJSONArray(KEY_VER1_DYNAMIC_AUDIO_LIST);
        if (r191 == null) goto L338;
        if (r191.length() <= 0) goto L338;
        this.mOriginalAudioInfo = new ArrayList();
        int r192 = Integer.MAX_VALUE;
        int r193 = 0;
    L328:
        if (r193 >= r191.length()) goto L338;
        JSONObject r194 = JSONArrayProtectorUtils.getJSONObject(r191, r193);
        int r195 = TYPE_AUDIO;
        JSONArray r196 = r191;
        if (this.mURLEncrypted == false) goto L332;
        String r197 = this.mKeyseed;
    L333:
        VideoInfo r198 = _generateVideoInfo(r194, r195, r197);
        int r199 = r189 + 1;
        r198.mInfoId = r189;
        int r1100 = r198.mBitrate;
        if (r192 <= r1100) goto L336;
        this.mDefaultInfoId[TYPE_AUDIO] = r189;
        r192 = r1100;
    L336:
        this.mDynamicVideoList.add(r198);
        this.mOriginalAudioInfo.add(r198);
        r193 = r193 + 1;
        r189 = r199;
        r191 = r196;
        goto L328
    L332:
        r197 = null;
    L338:
        if (this.mDynamicVideoList.size() <= 0) goto L348;
        ArrayList r200 = new ArrayList();
        if (TextUtils.isEmpty(this.mMainURL) == true) goto L343;
        r200.add(this.mMainURL);
    L343:
        if (TextUtils.isEmpty(this.mBackupURL) == true) goto L345;
        r200.add(this.mBackupURL);
    L345:
        String[] r201 = new String[r200.size()];
        this.mURLs = r201;
        r200.toArray(r201);
        goto L348
    L313:
        if (r190.length() <= 0) goto L322;
        this.mDubbedAudioInfo = new ArrayList();
        int r1101 = 0;
    L316:
        if (r1101 >= r190.length()) goto L322;
        JSONObject r1102 = JSONArrayProtectorUtils.getJSONObject(r190, r1101);
        int r1103 = TYPE_AUDIO;
        JSONArray r1104 = r190;
        if (this.mURLEncrypted == false) goto L320;
        String r202 = this.mKeyseed;
    L321:
        VideoInfo r203 = _generateVideoInfo(r1102, r1103, r202);
        int r1105 = r189 + 1;
        r203.mInfoId = r189;
        this.mDynamicVideoList.add(r203);
        this.mDubbedAudioInfo.add(r203);
        r1101 = r1101 + 1;
        r189 = r1105;
        r190 = r1104;
        goto L316
    L320:
        r202 = null;
        goto L321
    L299:
        if (r188.length() <= 0) goto L309;
        r189 = r172;
        int r204 = 0;
    L302:
        if (r204 >= r188.length()) goto L308;
        JSONObject r1106 = JSONArrayProtectorUtils.getJSONObject(r188, r204);
        JSONArray r1107 = r188;
        int r1108 = TYPE_VIDEO;
        String r1109 = r151;
        if (this.mURLEncrypted == false) goto L306;
        String r1110 = this.mKeyseed;
    L307:
        VideoInfo r1111 = _generateVideoInfo(r1106, r1108, r1110);
        int r1112 = r189 + 1;
        r1111.mInfoId = r189;
        this.mDynamicVideoList.add(r1111);
        r204 = r204 + 1;
        r189 = r1112;
        r188 = r1107;
        r151 = r1109;
        goto L302
    L306:
        r1110 = null;
        goto L307
    L308:
        r174 = r151;
        goto L310
    L291:
        if (this.mURLEncrypted == false) goto L293;
        String r1113 = this.mKeyseed;
    L294:
        this.mBackupURL = TTHelper.base64Decode(r187, r1113);
        goto L296
    L293:
        r1113 = null;
        goto L294
    L284:
        if (this.mURLEncrypted == false) goto L286;
        String r1114 = this.mKeyseed;
    L287:
        this.mMainURL = TTHelper.base64Decode(r186, r1114);
        goto L288
    L286:
        r1114 = null;
        goto L287
    L295:
        this.mMainURL = r173.optString("main_url");
        this.mBackupURL = r173.optString(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL);
        goto L296
    L263:
        r163 = KEY_VER1_VOLUME_INFO_JSON;
    L276:
        r165 = 0;
        goto L277
    L264:
        r163 = KEY_VER1_VOLUME_INFO_JSON;
        this.mVideoList = new ArrayList();
        JSONArray r205 = r210.optJSONArray(KEY_VER1_VIDEO_LIST);
        if (r205 == null) goto L276;
        if (r205.length() <= 0) goto L276;
        int r206 = 0;
        r165 = 0;
    L270:
        if (r206 >= r205.length()) goto L277;
        JSONObject r1115 = JSONArrayProtectorUtils.getJSONObject(r205, r206);
        int r1116 = this.mMediaTypeInt;
        JSONArray r1117 = r205;
        if (this.mURLEncrypted == false) goto L274;
        String r207 = this.mKeyseed;
    L275:
        VideoInfo r208 = _generateVideoInfo(r1115, r1116, r207);
        int r1118 = r165 + 1;
        r208.mInfoId = r165;
        this.mVideoList.add(r208);
        r206 = r206 + 1;
        r165 = r1118;
        r205 = r1117;
        goto L270
    L274:
        r207 = null;
        goto L275
    L219:
        if (this.mMediaType.equals(r152) == false) goto L222;
        this.mMediaTypeInt = TYPE_AUDIO;
        goto L222
    L431:
        JSONObject r209 = new JSONObject(r149);     // Catch: Throwable -> L212
        this.mEnableSSL = r209.optBoolean(KEY_VER1_VIDEO_ENABLE_SSL);     // Catch: Throwable -> L212
        this.mEnableAdaptive = r209.optBoolean("enable_adaptive");     // Catch: Throwable -> L212
        JSONObject r211 = r209.optJSONObject(KEY_VER1_BARRAGE_MASK_INFO);     // Catch: Throwable -> L212
        if (r211 == null) goto L179;
        BarrageMaskInfo r212 = new BarrageMaskInfo();     // Catch: Throwable -> L212
        this.mMaskInfo = r212;     // Catch: Throwable -> L212
        r212.extractFields(r211);     // Catch: Throwable -> L212
        if (this.mVersion != 1) goto L175;
        String r213 = this.mMaskInfo.getValueStr(1);     // Catch: Throwable -> L212
        if (TextUtils.isEmpty(r213) == false) goto L171;
    L176:
        this.mMaskHeadLen = this.mMaskInfo.getValueInt(7);     // Catch: Throwable -> L212
        this.mMaskFileHash = this.mMaskInfo.getValueStr(3);     // Catch: Throwable -> L212
        r152 = "audio";
        r153 = "video";
        this.mMaskFileSize = this.mMaskInfo.getValueLong(4);     // Catch: Throwable -> L430
    L180:
        JSONObject r214 = r209.optJSONObject("volume");     // Catch: Throwable -> L430
        if (r214 == null) goto L209;
        if (r214.has(KEY_VER1_LOUDNESS) == false) goto L185;
    L186:
        this.mLoudness = (float) r214.optDouble(KEY_VER1_LOUDNESS);     // Catch: Throwable -> L430
        this.mPeak = (float) r214.optDouble(KEY_VER1_PEAK);     // Catch: Throwable -> L430
    L188:
        if (r214.has("version") == false) goto L191;
        this.mVolumInfoVer = r214.optInt("version");     // Catch: Throwable -> L430
    L191:
        if (r214.has(KEY_VER1_VOLUME_LOUDNESS_RANGE) == false) goto L194;
        this.mLuRange = (float) r214.optDouble(KEY_VER1_VOLUME_LOUDNESS_RANGE);     // Catch: Throwable -> L430
    L194:
        if (r214.has(KEY_VER1_VOLUME_LOUDNESS_START) == false) goto L197;
        this.mLuStart = (float) r214.optDouble(KEY_VER1_VOLUME_LOUDNESS_START);     // Catch: Throwable -> L430
    L197:
        if (r214.has(KEY_VER1_VOLUME_LOUDNESS_END) == false) goto L200;
        this.mLuEnd = (float) r214.optDouble(KEY_VER1_VOLUME_LOUDNESS_END);     // Catch: Throwable -> L430
    L200:
        if (r214.has(KEY_VER1_VOLUME_MAX_MOM) == false) goto L203;
        this.mMaxMomLu = (float) r214.optDouble(KEY_VER1_VOLUME_MAX_MOM);     // Catch: Throwable -> L430
    L203:
        if (r214.has(KEY_VER1_VOLUME_SHORTERM) == false) goto L206;
        this.mMaxShortermLu = (float) r214.optDouble(KEY_VER1_VOLUME_SHORTERM);     // Catch: Throwable -> L430
    L206:
        if (r214.has(KEY_VER1_VOLUME_INFO_JSON) == false) goto L209;
        this.mVolumeInfoJson = r214.optString(KEY_VER1_VOLUME_INFO_JSON);     // Catch: Throwable -> L430
        goto L209
    L185:
        if (r214.has(KEY_VER1_PEAK) == false) goto L188;
    L209:
        if (r209.has(KEY_VER1_SEEK_TS) == false) goto L216;
        VideoSeekTs r215 = new VideoSeekTs();     // Catch: Throwable -> L430
        this.mSeekTs = r215;     // Catch: Throwable -> L430
        r215.extractFields(JSONObjectProtectorUtils.getJSONObject(r209, KEY_VER1_SEEK_TS));     // Catch: Throwable -> L430
    L213:
        TTVideoEngineLog.e("VideoRef", "parse video meta error");
        goto L216
    L171:
        if (this.mURLEncrypted == false) goto L173;
        String r216 = this.mKeyseed;     // Catch: Throwable -> L212
    L174:
        this.mBarrageMaskUrl = TTHelper.base64Decode(r213, r216);     // Catch: Throwable -> L212
        goto L176
    L173:
        r216 = null;
        goto L174
    L175:
        this.mBarrageMaskUrl = this.mMaskInfo.getValueStr(1);     // Catch: Throwable -> L212
        goto L176
    L179:
        r152 = "audio";
        r153 = "video";
    L212:
        r152 = "audio";
        r153 = "video";
        goto L213
    L157:
        if (this.mURLEncrypted == false) goto L159;
        String r217 = this.mKeyseed;
    L160:
        this.mAIBarrageUrl = TTHelper.base64Decode(r148, r217);
        goto L162
    L159:
        r217 = null;
        goto L160
    L150:
        if (this.mURLEncrypted == false) goto L152;
        String r218 = this.mKeyseed;
    L153:
        this.mBarrageMaskUrl = TTHelper.base64Decode(r147, r218);
        goto L154
    L152:
        r218 = null;
        goto L153
    L161:
        this.mBarrageMaskUrl = r210.optString("barrage_mask_url");
        this.mAIBarrageUrl = r210.optString(KEY_VER1_AI_BARRAGE_URL);
        goto L162
    L140:
        JSONObject r219 = r210.optJSONObject("fallback_api");
        if (r219 == null) goto L145;
        this.mFallbackApi = r219.optString("fallback_api");
        String r220 = r219.optString(KEY_VER1_SEED);
        if (TextUtils.isEmpty(r220) == true) goto L145;
        this.mKeyseed = r220;
        goto L145
    L23:
        this.mVersion = 2;
    L10:
        if (TextUtils.isEmpty(r210.optString(KEY_VER2_VIDEO_ID)) == false) goto L21;
        if (TextUtils.isEmpty(r210.optString(KEY_VER4_VIDEO_ID)) == false) goto L21;
        if (TextUtils.isEmpty(r210.optString("video_id")) == true) goto L24;
        if (r210.optInt("version") != 3) goto L19;
        this.mVersion = 3;
        goto L24
    L19:
        this.mVersion = 1;
        goto L24
    }

    public String getResolutionStr(VideoInfo r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getMediatype();
        if (r101 != TYPE_AUDIO) goto L13;
        String r102 = r100.getValueStr(18);
        if (r102 == null) goto L11;
        return r102;
    L11:
        return resolutionToString(Resolution.Standard, r101);
    L13:
        if (r101 != TYPE_VIDEO) goto L20;
        String r103 = r100.getValueStr(7);
        if (r103 == null) goto L18;
        return r103;
    L18:
        return resolutionToString(Resolution.Standard, r101);
    L20:
        return resolutionToString(Resolution.Standard);
    L4:
        return resolutionToString(Resolution.Standard);
    }

    public Boolean getValueBool(int r100) {
        if (r100 == 106) goto L36;
        if (r100 == 222) goto L34;
        if (r100 == 253) goto L32;
        if (r100 == 228) goto L30;
        if (r100 == 229) goto L28;
        switch(r100) {
            case 203: goto L26;
            case 204: goto L24;
            case 205: goto L22;
            case 206: goto L20;
            case 207: goto L18;
            case 208: goto L16;
            default: goto L14;
        };
    L14:
        return Boolean.FALSE;
    L16:
        return Boolean.valueOf(this.mFormatHasHls);
    L18:
        return Boolean.valueOf(this.mFormatHasMPD);
    L20:
        return Boolean.valueOf(this.mFormatHasMP4);
    L22:
        return Boolean.valueOf(this.mFormatHasDASH);
    L24:
        return Boolean.valueOf(this.mCodecHasByteVC1);
    L26:
        return Boolean.valueOf(this.mCodecHasH264);
    L28:
        return Boolean.valueOf(this.mHasEmbeddedSubtitle);
    L30:
        return Boolean.valueOf(this.mCodecHasByteVC2);
    L32:
        return Boolean.valueOf(this.mMBRefactor);
    L34:
        return Boolean.valueOf(this.mEnableAdaptive);
    L36:
        return Boolean.valueOf(this.mEnableSSL);
    }

    public float getValueFloat(int r100) {
        if (r100 == 224) goto L36;
        if (r100 == 225) goto L34;
        if (r100 == 236) goto L32;
        if (r100 == 252) goto L30;
        if (r100 == 239) goto L28;
        if (r100 == 240) goto L26;
        switch(r100) {
            case 247: goto L24;
            case 248: goto L22;
            case 249: goto L20;
            case 250: goto L18;
            default: goto L15;
        };
    L15:
        return 0.0f;
    L18:
        return this.mMaxShortermLu;
    L20:
        return this.mMaxMomLu;
    L22:
        return this.mLuEnd;
    L24:
        return this.mLuStart;
    L26:
        return this.mSubtitlePositionY;
    L28:
        return this.mSubtitlePositionX;
    L30:
        return this.mLuRange;
    L32:
        return this.mConstDepth;
    L34:
        return this.mPeak;
    L36:
        return this.mLoudness;
    }

    public int getValueInt(int r110) {
        int r100 = this.mVersion;
        if (r100 != 2) goto L29;
        if (r110 == 3) goto L28;
        if (r110 == 4) goto L26;
        if (r110 == 7) goto L24;
        if (r110 == 209) goto L22;
        if (r110 == 230) goto L20;
        if (r110 == 232) goto L18;
        if (r110 == 242) goto L16;
        if (r110 == 251) goto L14;
        return 0;
    L14:
        return this.mVolumInfoVer;
    L16:
        return this.mMaskHeadLen;
    L18:
        return this.mCategory;
    L20:
        return this.mDefaultInfoId[TYPE_AUDIO];
    L22:
        return this.mTotalCountVer2;
    L24:
        return this.mMediaTypeIntVer2;
    L26:
        return this.mStatusVer2;
    L28:
        return this.mVideoDurationVer2;
    L29:
        if (r110 == 3) goto L60;
        if (r110 == 4) goto L58;
        if (r110 == 7) goto L56;
        if (r110 == 9) goto L54;
        if (r110 == 209) goto L53;
        if (r110 == 227) goto L51;
        if (r110 == 230) goto L49;
        if (r110 == 232) goto L47;
        if (r110 == 242) goto L45;
        if (r110 == 251) goto L43;
        return 0;
    L43:
        return this.mVolumInfoVer;
    L45:
        return this.mMaskHeadLen;
    L47:
        return this.mCategory;
    L49:
        return this.mDefaultInfoId[TYPE_AUDIO];
    L51:
        return this.mPopularityLevel;
    L53:
        return this.mTotalCount;
    L54:
        return r100;
    L56:
        return this.mMediaTypeInt;
    L58:
        return this.mStatus;
    L60:
        return this.mVideoDuration;
    }

    public List<VideoInfo> getValueList(int r100) {
        if (this.mVersion != 2) goto L8;
        if (r100 == 5) goto L7;
        return null;
    L7:
        return this.mVideoListVer2;
    L8:
        if (r100 == 5) goto L23;
        if (r100 == 210) goto L21;
        if (r100 == 231) goto L19;
        if (r100 == 234) goto L17;
        return null;
    L17:
        return this.mOriginalAudioInfo;
    L19:
        return this.mDubbedAudioInfo;
    L21:
        return this.mDynamicVideoList;
    L23:
        return this.mVideoList;
    }

    public long getValueLong(int r100) {
        if (r100 == 216) goto L15;
        if (r100 == 220) goto L13;
        if (r100 == 243) goto L11;
        return 0;
    L11:
        return this.mMaskFileSize;
    L13:
        return this.mUrlExpire;
    L15:
        return this.mDnsTime;
    }

    public String getValueStr(int r100) {
        if (r100 != 211) goto L7;
        return this.mFormat;
    L7:
        if (r100 != 215) goto L11;
        return this.mDynamicType;
    L11:
        if (r100 != 8) goto L15;
        return this.mBashString;
    L15:
        if (r100 != 233) goto L19;
        return this.mFirstSubVid;
    L19:
        if (r100 != 237) goto L23;
        return this.mPallasVidLabels;
    L23:
        if (r100 != 244) goto L27;
        return this.mPallasDidLabels;
    L27:
        if (r100 != 245) goto L31;
        return this.mLabelUsage;
    L31:
        if (r100 != 260) goto L35;
        return this.mVolumeInfoJson;
    L35:
        if (this.mVersion != 2) goto L47;
        if (r100 == 2) goto L45;
        if (r100 == 7) goto L43;
        if (r100 == 201) goto L41;
        return "";
    L41:
        return this.mPosterUrlVer2;
    L43:
        return this.mMediaTypeVer2;
    L45:
        return this.mVideoIdVer2;
    L47:
        if (r100 == 1) goto L106;
        if (r100 == 2) goto L104;
        if (r100 == 7) goto L102;
        if (r100 == 201) goto L100;
        if (r100 == 221) goto L98;
        if (r100 == 223) goto L96;
        if (r100 == 226) goto L94;
        if (r100 == 235) goto L92;
        if (r100 == 241) goto L90;
        if (r100 == 246) goto L88;
        if (r100 == 104) goto L86;
        if (r100 == 105) goto L84;
        if (r100 == 217) goto L82;
        if (r100 == 218) goto L80;
        switch(r100) {
            case 107: goto L78;
            case 108: goto L76;
            case 109: goto L74;
            default: goto L72;
        };
    L72:
        return "";
    L74:
        return this.mBackupURL;
    L76:
        return this.mMainURL;
    L78:
        return this.mAutoDefinition;
    L80:
        return this.mKeyseed;
    L82:
        return this.mFallbackApi;
    L84:
        return this.mValidate;
    L86:
        return this.mVideoName;
    L88:
        return this.mBid;
    L90:
        return this.mMaskFileHash;
    L92:
        return this.mAIBarrageUrl;
    L94:
        return this.mFullScreen;
    L96:
        return this.mDecodingMode;
    L98:
        return this.mBarrageMaskUrl;
    L100:
        return this.mPosterUrl;
    L102:
        return this.mMediaType;
    L104:
        return this.mVideoId;
    L106:
        return this.mUserId;
    }

    public VideoInfo getVideoInfo(Map<Integer, String> r100) {
        List<VideoInfo> r101 = getVideoInfoList();
        if (r101 != null) goto L5;
    L28:
        return null;
    L5:
        if (r101.size() == 0) goto L28;
        Iterator<VideoInfo> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L28;
        VideoInfo r103 = r102.next();
        if (r103 == null) goto L9;
        if (r100 == null) goto L27;
        if (r100.size() == 0) goto L27;
        Iterator<Map.Entry<Integer, String>> r104 = r100.entrySet().iterator();
    L19:
        if (r104.hasNext() == false) goto L25;
        Map.Entry<Integer, String> r105 = r104.next();
        int r106 = r105.getKey().intValue();
        String r107 = r105.getValue();
        if (TextUtils.isEmpty(r107) == true) goto L19;
        if (r107.equals(r103.getValueStr(r106)) == true) goto L19;
        boolean r108 = false;
    L26:
        if (r108 == false) goto L9;
    L25:
        r108 = true;
    L27:
        return r103;
    }

    public VideoInfo getVideoInfoWithClarity(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        List<VideoInfo> r101 = getVideoInfoList();
        if (r101 != null) goto L8;
    L23:
        return null;
    L8:
        if (r101.size() == 0) goto L23;
        int r102 = 0;
    L12:
        if (r102 >= r101.size()) goto L22;
        if (ListProtector.get(r101, r102) == null) goto L20;
        if (getResolutionStr((VideoInfo) ListProtector.get(r101, r102)).equals(r100) == false) goto L20;
        return (VideoInfo) ListProtector.get(r101, r102);
    L20:
        r102 = r102 + 1;
        goto L12
    L22:
        return (VideoInfo) ListProtector.get(r101, 0);
    }

    public String resolutionToString(Resolution r100) {
        return resolutionToString(r100, getValueInt(7));
    }

    public void setUpResolution(HashMap<String, Resolution> r100) {
        int r101 = getValueInt(7);
        if (r100 == null) goto L12;
        if (r100.size() <= 0) goto L12;
        if (r101 != TYPE_AUDIO) goto L10;
        this.mAudioResolutionMap = r100;
    L15:
        Resolution r102 = Resolution.Undefine;
        List<VideoInfo> r103 = getVideoInfoList();
        if (r103 == null) goto L32;
        int r104 = 0;
    L19:
        if (r104 >= r103.size()) goto L32;
        VideoInfo r105 = (VideoInfo) ListProtector.get(r103, r104);
        if (r105 == null) goto L31;
        if (r105.getMediatype() != r101) goto L31;
        r105.setResolutionBaseMap(r100);
        Resolution r106 = r105.getResolution();
        String r107 = r105.getValueStr(32);
        if (this.mAllQualityArray.contains(r107) == true) goto L29;
        this.mAllQualityArray.add(r107);
    L29:
        if (this.mAllResolutionsArray.contains(r106) == true) goto L31;
        this.mAllResolutionsArray.add(r106);
    L31:
        r104 = r104 + 1;
    L32:
        Resolution[] r108 = new Resolution[this.mAllResolutionsArray.size()];
        this.mAllResolutions = r108;
        this.mAllResolutionsArray.toArray(r108);
        String[] r109 = new String[this.mAllQualityArray.size()];
        this.mAllQualityInfos = r109;
        this.mAllQualityArray.toArray(r109);
        return;
    L10:
        this.mVideoResolutionMap = r100;
    L12:
        if (r101 != TYPE_AUDIO) goto L14;
        r100 = this.mAudioResolutionMap;
        goto L15
    L14:
        r100 = this.mVideoResolutionMap;
        goto L15
    }

    public void setVersion(int r100) {
        this.mVersion = r100;
    }

    public String[] allVideoURLs(Resolution r100, Map<Integer, String> r101) {
        String[] r102 = this.mURLs;
        if (r102 != null) goto L5;
    L7:
        VideoInfo r103 = getVideoInfo(r100, r101);
        if (r103 != null) goto L12;
        return new String[0];
    L12:
        return r103.getValueStrArr(16);
    L5:
        if (r102.length <= 0) goto L7;
        return r102;
    }

    public VideoInfo getVideoInfo(Resolution r100, Map<Integer, String> r101) {
        return getVideoInfo(r100, getValueInt(7), r101);
    }

    public String resolutionToString(Resolution r100, int r101) {
        if (r101 != TYPE_AUDIO) goto L5;
        HashMap<String, Resolution> r102 = this.mAudioResolutionMap;
    L6:
        Iterator<Map.Entry<String, Resolution>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, Resolution> r104 = r103.next();
        if (r104.getValue().getIndex() != r100.getIndex()) goto L8;
        String r105 = r104.getKey();
    L14:
        if (TextUtils.isEmpty(r105) == true) goto L16;
        return r105;
    L16:
        return r100.toString(r101);
    L12:
        r105 = null;
        goto L14
    L5:
        r102 = this.mVideoResolutionMap;
        goto L6
    }

    public void setValue(int r100, String r101) {
        if (r100 != 1) goto L5;
        this.mUserId = r101;
        return;
    L5:
        if (r100 != 2) goto L7;
        this.mVideoId = r101;
        this.mVideoIdVer2 = r101;
        if (TextUtils.isEmpty(this.mBid) == false) goto L40;
        this.mBid = r101;
        return;
    L40:
        return;
    L7:
        if (r100 != 7) goto L9;
        this.mMediaTypeVer2 = r101;
        this.mMediaType = r101;
        return;
    L9:
        if (r100 != 201) goto L11;
        this.mPosterUrlVer2 = r101;
        return;
    L11:
        if (r100 != 233) goto L13;
        this.mFirstSubVid = r101;
        return;
    L13:
        if (r100 != 104) goto L15;
        this.mVideoName = r101;
        return;
    L15:
        if (r100 == 105) goto L24;
        switch(r100) {
            case 107: goto L22;
            case 108: goto L20;
            case 109: goto L18;
            default: goto L17;
        };
    L17:
        return;
    L18:
        this.mBackupURL = r101;
        return;
    L20:
        this.mMainURL = r101;
        return;
    L22:
        this.mAutoDefinition = r101;
        return;
    L24:
        this.mValidate = r101;
    }

    public void setValueStr(int r100, String r101) {
        if (r100 != 218) goto L5;
        this.mKeyseed = r101;
        return;
    L5:
        if (r100 == 245) goto L11;
        if (r100 != 246) goto L18;
        this.mBid = r101;
        return;
    L18:
        return;
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        this.mLabelUsage = r101;
        return;
    }

    public void setValue(int r100, int r101) {
        if (r100 != 3) goto L5;
        this.mVideoDuration = r101;
        this.mVideoDurationVer2 = r101;
        return;
    L5:
        if (r100 != 4) goto L7;
        this.mStatus = r101;
        return;
    L7:
        if (r100 != 7) goto L9;
        this.mMediaTypeInt = r101;
        this.mMediaTypeIntVer2 = r101;
        return;
    L9:
        if (r100 != 209) goto L11;
        this.mTotalCountVer2 = r101;
        return;
    L11:
        if (r100 == 232) goto L13;
        return;
    L13:
        this.mCategory = r101;
    }

    public void setValue(int r100, List r101) {
        if (r100 != 5) goto L5;
        this.mVideoList = r101;
        this.mVideoListVer2 = r101;
        return;
    L5:
        if (r100 != 210) goto L7;
        this.mDynamicVideoList = r101;
        return;
    L7:
        if (r100 == 212) goto L9;
        return;
    L9:
        this.mThumbInfoListVer2 = r101;
        this.mThumbInfoList = r101;
    }

    public void setValue(int r100, boolean r101) {
        if (r100 != 106) goto L5;
        this.mEnableSSL = r101;
        return;
    L5:
        if (r100 == 219) goto L7;
        return;
    L7:
        this.mURLEncrypted = r101;
    }

    public void setValue(int r100, VideoSeekTs r101) {
        if (r100 == 214) goto L5;
        return;
    L5:
        this.mSeekTs = r101;
        this.mSeekTsVer2 = r101;
    }

    public void setValue(int r100, String[] r101) {
        if (r100 == 213) goto L5;
        return;
    L5:
        this.mURLs = r101;
    }

    private VideoInfo _generateVideoInfo(JSONObject r100, int r101, String r102) {
        VideoInfo r103 = new VideoInfo(r102);
        r103.setVersion(this.mVersion);
        r103.setMediaType(r101);
        r103.setValue(39, this.mLoudness);
        r103.setValue(40, this.mPeak);
        r103.extractFields(r100);
        Resolution r104 = Resolution.Standard;
        int r105 = r103.getMediatype();
        if (r105 != TYPE_AUDIO) goto L6;
        String r106 = r103.getValueStr(18);
    L10:
        if (TextUtils.isEmpty(r106) == true) goto L97;
        Resolution r107 = Resolution.L_Standard;
        if (r106.equals(r107.toString(r105)) == false) goto L15;
    L13:
        r104 = r107;
        goto L97
    L15:
        if (r106.equals(r104.toString(r105)) == true) goto L97;
        r107 = Resolution.High;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.H_High;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.SuperHigh;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.ExtremelyHigh;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.TwoK;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        if (r106.equals("1440p") == true) goto L13;
        r107 = Resolution.FourK;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.ExtremelyHigh_50F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.TwoK_50F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.FourK_50F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.ExtremelyHigh_60F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.TwoK_60F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.FourK_60F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.ExtremelyHigh_120F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.TwoK_120F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.FourK_120F;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.L_Standard_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.Standard_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.High_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.H_High_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.SuperHigh_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.ExtremelyHigh_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.TwoK_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.FourK_HDR;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.EightK;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
        r107 = Resolution.ExtremelyHighPlus;
        if (r106.equals(r107.toString(r105)) == true) goto L13;
    L97:
        r103.setResolution(r104);
        r103.setValue(26, r106);
        String r108 = r103.getValueStr(6);
        if (TextUtils.isEmpty(r108) == true) goto L101;
        this.mFormat = r108;
    L101:
        if (this.mFormatHasMPD == true) goto L106;
        if (this.mFormat.equals(TTVideoEngineInterface.FORMAT_TYPE_MPD) == false) goto L106;
        this.mFormatHasMPD = true;
    L120:
        String r109 = (String) TTHelper.nonNullElse(r103.getValueStr(8), "");
        if (this.mCodecHasH264 == true) goto L126;
        if (r109.equals("h264") == false) goto L126;
        this.mCodecHasH264 = true;
    L135:
        return r103;
    L126:
        if (this.mCodecHasByteVC1 == true) goto L131;
        if (r109.equals("bytevc1") == false) goto L131;
        this.mCodecHasByteVC1 = true;
    L131:
        if (this.mCodecHasByteVC2 == true) goto L135;
        if (r109.equals("bytevc2") == false) goto L135;
        this.mCodecHasByteVC2 = true;
    L106:
        if (this.mFormatHasDASH == true) goto L111;
        if (this.mFormat.equals("dash") == false) goto L111;
        this.mFormatHasDASH = true;
    L111:
        if (this.mFormatHasMP4 == true) goto L116;
        if (this.mFormat.equals("mp4") == false) goto L116;
        this.mFormatHasMP4 = true;
    L116:
        if (this.mFormatHasHls == true) goto L120;
        if (this.mFormat.equals(TTVideoEngineInterface.FORMAT_TYPE_HLS) == false) goto L120;
        this.mFormatHasHls = true;
        goto L120
    L6:
        if (r105 != TYPE_VIDEO) goto L8;
        r106 = r103.getValueStr(7);
        goto L10
    L8:
        r106 = null;
        goto L10
    }

    public VideoInfo getVideoInfo(Resolution r100, int r101, Map<Integer, String> r110) {
        List<VideoInfo> r102 = getVideoInfoList();
        if (r102 != null) goto L5;
    L58:
        return null;
    L5:
        if (r102.size() == 0) goto L58;
        Iterator<VideoInfo> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L58;
        VideoInfo r104 = r103.next();
        if (r104 == null) goto L9;
        if (r101 != r104.getMediatype()) goto L9;
        if (r110 != null) goto L18;
    L24:
        if (r110 != null) goto L26;
    L32:
        if (r110 == null) goto L41;
        if (r110.containsKey(18) == false) goto L41;
        String r105 = r110.get(18);
        if (TextUtils.isEmpty(r104.getValueStr(18)) == true) goto L41;
        if (r104.getValueStr(18).equals(r105) == false) goto L41;
        return r104;
    L41:
        if (r100 != r104.getResolution()) goto L9;
        if (r110 == null) goto L57;
        if (r110.size() == 0) goto L57;
        Iterator<Map.Entry<Integer, String>> r106 = r110.entrySet().iterator();
    L49:
        if (r106.hasNext() == false) goto L55;
        Map.Entry<Integer, String> r107 = r106.next();
        int r108 = r107.getKey().intValue();
        String r109 = r107.getValue();
        if (TextUtils.isEmpty(r109) == true) goto L49;
        if (r109.equals(r104.getValueStr(r108)) == true) goto L49;
        boolean r111 = false;
    L56:
        if (r111 == false) goto L9;
    L55:
        r111 = true;
    L57:
        return r104;
    L26:
        if (r110.containsKey(32) == false) goto L32;
        String r112 = r110.get(32);
        if (TextUtils.isEmpty(r104.getValueStr(32)) == true) goto L32;
        if (r104.getValueStr(32).equals(r112) == false) goto L32;
        return r104;
    L18:
        if (r110.containsKey(42) == false) goto L24;
        String r113 = r110.get(42);
        if (TextUtils.isEmpty(r104.getValueStr(42)) == true) goto L24;
        if (r104.getValueStr(42).equals(r113) == false) goto L24;
        return r104;
    }
}
