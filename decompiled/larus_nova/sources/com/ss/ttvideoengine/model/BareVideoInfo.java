package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public class BareVideoInfo extends VideoInfo {
    private static final String TAG = "TTVideoEngine.BareVideoInfo";
    private List<BareGearInfo> mBareGearInfo;
    private long mBitrate;
    private Builder mBuilder;
    private String mCheckInfo;
    private String mCodecType;
    private long mDuration;
    private long mExpire;
    private String mFileHash;
    private String mFileId;
    private String mFormat;
    private String mGear;
    private int mMediaType;
    private String mQuality;
    private String mQualityDesc;
    private Resolution mResolution;
    private String mSegmentSizeInfo;
    private long mSize;
    private String mSpadea;
    private List<String> mUrlExpires;
    private List<String> mUrls;
    private int mVHeight;
    private int mVWidth;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.model.BareVideoInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BareGearInfo {
        public int key;
        public GearType mGearType;
        public int value;

        public BareGearInfo(GearType r100, int r101, int r102) {
            this.mGearType = r100;
            this.key = r101;
            this.value = r102;
        }
    }

    public static class Builder {
        private List<BareGearInfo> mBareGearInfo;
        private long mBitrate;
        private String mCheckInfo;
        private String mCodecType;
        private long mDuration;
        private long mExpire;
        private String mFileHash;
        private String mFileId;
        private String mFormat;
        private String mGear;
        private int mMediaType;
        private String mQuality;
        private String mQualityDesc;
        private Resolution mResolution;
        private String mSegmentSizeInfo;
        private long mSize;
        private String mSpadea;
        private List<String> mUrlExpires;
        private List<String> mUrls;
        private int mVHeight;
        private int mVWidth;

        public BareVideoInfo build() {
            BareVideoInfo r100 = new BareVideoInfo(null);
            BareVideoInfo.access$102(r100, this.mMediaType);
            BareVideoInfo.access$202(r100, this.mVWidth);
            BareVideoInfo.access$302(r100, this.mVHeight);
            BareVideoInfo.access$402(r100, this.mBitrate);
            BareVideoInfo.access$502(r100, this.mDuration);
            BareVideoInfo.access$602(r100, this.mSize);
            BareVideoInfo.access$702(r100, this.mExpire);
            BareVideoInfo.access$802(r100, this.mFileHash);
            BareVideoInfo.access$902(r100, this.mFileId);
            BareVideoInfo.access$1002(r100, this.mCodecType);
            BareVideoInfo.access$1102(r100, this.mFormat);
            BareVideoInfo.access$1202(r100, this.mCheckInfo);
            BareVideoInfo.access$1302(r100, this.mResolution);
            BareVideoInfo.access$1402(r100, this.mQuality);
            BareVideoInfo.access$1502(r100, this.mQualityDesc);
            BareVideoInfo.access$1602(r100, this.mGear);
            BareVideoInfo.access$1702(r100, this.mSpadea);
            BareVideoInfo.access$1802(r100, this.mUrls);
            BareVideoInfo.access$1902(r100, this.mUrlExpires);
            BareVideoInfo.access$2002(r100, this.mBareGearInfo);
            BareVideoInfo.access$2102(r100, this.mSegmentSizeInfo);
            BareVideoInfo.access$2202(r100, this);
            return r100;
        }

        public Builder() {
            this.mMediaType = 0;
            this.mVWidth = 0;
            this.mVHeight = 0;
            this.mBitrate = 0;
            this.mDuration = 0;
            this.mSize = 0;
            this.mExpire = -1;
            this.mFileHash = null;
            this.mFileId = null;
            this.mCodecType = null;
            this.mFormat = null;
            this.mCheckInfo = null;
            this.mResolution = null;
            this.mQuality = null;
            this.mQualityDesc = null;
            this.mGear = null;
            this.mSpadea = null;
            this.mSegmentSizeInfo = null;
            this.mUrls = null;
            this.mUrlExpires = null;
            this.mBareGearInfo = null;
        }

        public Builder addUrl(String r100) {
            if (this.mUrls != null) goto L5;
            this.mUrls = new ArrayList();
        L5:
            this.mUrls.add(r100);
            return this;
        }

        public Builder addUrlExpire(String r100) {
            if (this.mUrlExpires != null) goto L5;
            this.mUrlExpires = new ArrayList();
        L5:
            this.mUrlExpires.add(r100);
            return this;
        }

        public Builder bitrate(long r100) {
            this.mBitrate = r100;
            return this;
        }

        public Builder checkInfo(String r100) {
            this.mCheckInfo = r100;
            return this;
        }

        public Builder codecType(String r100) {
            this.mCodecType = r100;
            return this;
        }

        public Builder duration(long r100) {
            this.mDuration = r100;
            return this;
        }

        public Builder expire(long r100) {
            this.mExpire = r100;
            return this;
        }

        public Builder fileHash(String r100) {
            this.mFileHash = r100;
            return this;
        }

        public Builder fileId(String r100) {
            this.mFileId = r100;
            return this;
        }

        public Builder format(String r100) {
            this.mFormat = r100;
            return this;
        }

        public Builder gear(String r100) {
            this.mGear = r100;
            return this;
        }

        public Builder mediaType(int r100) {
            this.mMediaType = r100;
            return this;
        }

        public Builder quality(String r100) {
            this.mQuality = r100;
            return this;
        }

        public Builder qualityDesc(String r100) {
            this.mQualityDesc = r100;
            return this;
        }

        public Builder resolution(Resolution r100) {
            this.mResolution = r100;
            return this;
        }

        public Builder segmentSizeInfo(String r100) {
            this.mSegmentSizeInfo = r100;
            return this;
        }

        public Builder size(long r100) {
            this.mSize = r100;
            return this;
        }

        public Builder spadea(String r100) {
            this.mSpadea = r100;
            return this;
        }

        public Builder urlExpires(List<String> r100) {
            this.mUrlExpires = r100;
            return this;
        }

        public Builder urls(List<String> r100) {
            this.mUrls = r100;
            return this;
        }

        public Builder vHeight(int r100) {
            this.mVHeight = r100;
            return this;
        }

        public Builder vWidth(int r100) {
            this.mVWidth = r100;
            return this;
        }

        public Builder gearInfo(GearType r100, int r101, int r102) {
            if (this.mBareGearInfo != null) goto L5;
            this.mBareGearInfo = new ArrayList();
        L5:
            this.mBareGearInfo.add(new BareGearInfo(r100, r101, r102));
            return this;
        }
    }

    public static final enum GearType extends Enum<GearType> {
        private static final /* synthetic */ GearType[] $VALUES = null;
        public static final GearType Frame = null;
        public static final GearType TimeInSecond = null;
        private int gearType;

        static {
            GearType r100 = new GearType("Frame", 0, 0);
            Frame = r100;
            GearType r101 = new GearType("TimeInSecond", 1, 1);
            TimeInSecond = r101;
            $VALUES = new GearType[]{r100, r101};
        }

        public static GearType[] values() {
            return (GearType[]) $VALUES.clone();
        }

        public int getGearType() {
            return this.gearType;
        }

        public static GearType valueOf(String r100) {
            return (GearType) a.a(GearType.class, r100);
        }

        public void setGearType(int r100) {
            this.gearType = r100;
        }

        private GearType(String r100, int r101, int r102) {
            super(r100, r101);
            this.gearType = r102;
        }
    }

    private BareVideoInfo() {
        super(null);
        this.mMediaType = -1;
        this.mVWidth = 0;
        this.mVHeight = 0;
        this.mBitrate = 0;
        this.mDuration = 0;
        this.mSize = 0;
        this.mExpire = -1;
        this.mFileHash = null;
        this.mFileId = null;
        this.mCodecType = null;
        this.mFormat = null;
        this.mCheckInfo = null;
        this.mResolution = null;
        this.mQuality = null;
        this.mGear = null;
        this.mSpadea = null;
        this.mQualityDesc = null;
        this.mSegmentSizeInfo = null;
        this.mUrls = null;
        this.mUrlExpires = null;
        this.mBareGearInfo = null;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public MediaBitrateFitterInfo getBitrateFitterInfo() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public boolean getValueBool(int r100) {
        return false;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo
    public BareVideoInfo copyInfo() {
        BareVideoInfo r100 = new BareVideoInfo();
        r100.mUrls = new ArrayList(this.mUrls);
        r100.mUrlExpires = new ArrayList(this.mUrlExpires);
        r100.mMainUrl = this.mMainUrl;
        r100.mMainUrlExpire = this.mMainUrlExpire;
        r100.mBackupUrlExpire = this.mBackupUrlExpire;
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
        r100.isAutoDefinition = this.isAutoDefinition;
        r100.mQuality = this.mQuality;
        r100.mFileHash = this.mFileHash;
        r100.mCheckInfo = this.mCheckInfo;
        r100.mFileId = this.mFileId;
        r100.mMediaType = this.mMediaType;
        r100.mRealBitrate = this.mRealBitrate;
        r100.mInfoId = this.mInfoId;
        r100.mBitrate = this.mBitrate;
        r100.mSegmentSizeInfo = this.mSegmentSizeInfo;
        return r100;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public Map<String, Object> toMediaInfo() {
        HashMap r100 = new HashMap();
        r100.put("file_id", getValueStr(28));
        if (getMediatype() != VideoRef.TYPE_VIDEO) goto L5;
        String r101 = "video";
    L6:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r101);
        r100.put("file_size", Long.valueOf(getValueLong(12)));
        r100.put("bitrate", Integer.valueOf(getValueInt(3)));
        r100.put(GearStrategyConsts.EV_QUALITY, getValueStr(18));
        r100.put("definition", getValueStr(7));
        Resolution r102 = this.mResolution;
        if (r102 == null) goto L9;
        int r103 = r102.getIndex();
    L10:
        r100.put("resolution", Integer.valueOf(r103));
        r100.put("width", Integer.valueOf(getValueInt(1)));
        r100.put("height", Integer.valueOf(getValueInt(2)));
        r100.put("codec", getValueStr(8));
        r100.put("urls", getValueStrArr(16));
        r100.put(BarrageMaskInfo.KEY_MASK_FILE_HASH, getValueStr(15));
        r100.put("segment_size_info", getValueStr(53));
        JSONObject r104 = this.mPreloadGear;
        if (r104 == null) goto L14;
        r100.put("preload_gear_data", r104);
    L14:
        if (this.mBareGearInfo != null) goto L29;
    L28:
        return r100;
    L29:
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L26
        Iterator<BareGearInfo> r106 = this.mBareGearInfo.iterator();     // Catch: Exception -> L26
    L17:
        if (r106.hasNext() == false) goto L24;
        BareGearInfo r107 = r106.next();     // Catch: Exception -> L26
        GearType r108 = r107.mGearType;     // Catch: Exception -> L26
        if (r108 == GearType.Frame) goto L20;
        if (r108 != GearType.TimeInSecond) goto L17;
        r105.put("t_" + r107.key, r107.value);     // Catch: Exception -> L26
        goto L17
    L20:
        r105.put("g_" + r107.key, r107.value);     // Catch: Exception -> L26
        goto L17
    L24:
        r100.put("preload_gear_data", r105);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = "audio";
        goto L6
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public JSONObject toBashJsonObject() {
        return super.toBashJsonObject();
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public int getMediatype() {
        return this.mMediaType;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public Resolution getResolution() {
        return this.mResolution;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo
    public /* bridge */ /* synthetic */ VideoInfo copyInfo() {
        return copyInfo();
    }

    public /* synthetic */ BareVideoInfo(AnonymousClass1 r100) {
        this();
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public int fromMediaInfoJsonObject(JSONObject r100) {
        this.mFileId = r100.optString("file_id");     // Catch: Exception -> L18
        if (r100.optString(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE).compareTo("audio") != 0) goto L5;
        int r101 = VideoRef.TYPE_AUDIO;     // Catch: Exception -> L18
    L6:
        this.mMediaType = r101;     // Catch: Exception -> L18
        this.mSize = r100.optLong("file_size");     // Catch: Exception -> L18
        this.mBitrate = r100.optInt("bitrate");     // Catch: Exception -> L18
        this.mQuality = r100.optString(GearStrategyConsts.EV_QUALITY);     // Catch: Exception -> L18
        this.mDefinition = r100.optString("definition");     // Catch: Exception -> L18
        this.mResolution = Resolution.valueOf(r100.optInt("resolution", 0));     // Catch: Exception -> L18
        this.mVWidth = r100.optInt("width");     // Catch: Exception -> L18
        this.mVHeight = r100.optInt("height");     // Catch: Exception -> L18
        this.mCodecType = r100.optString("codec");     // Catch: Exception -> L18
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r100, "urls");     // Catch: Exception -> L18
        int r103 = 0;
    L8:
        if (r103 >= r102.length()) goto L16;
        String r104 = JSONArrayProtectorUtils.getString(r102, r103);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r104) == true) goto L15;
        if (this.mUrls != null) goto L14;
        this.mUrls = new ArrayList();     // Catch: Exception -> L18
    L14:
        this.mUrls.add(r104);     // Catch: Exception -> L18
    L15:
        r103 = r103 + 1;     // Catch: Exception -> L18
        goto L8
    L16:
        this.mFileHash = r100.optString(BarrageMaskInfo.KEY_MASK_FILE_HASH);     // Catch: Exception -> L18
        this.mSegmentSizeInfo = r100.optString("segment_size_info");     // Catch: Exception -> L18
        return 0;
    L5:
        r101 = VideoRef.TYPE_VIDEO;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        TTVideoEngineLog.i(TAG, "[GearStrategy]fromMediaInfoJsonObject exception=" + e);
        return -1;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public int getValueInt(int r100) {
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 != 3) goto L9;
        long r101 = this.mBitrate;
    L18:
        return (int) r101;
    L9:
        if (r100 == 27) goto L11;
        return 0;
    L11:
        r101 = this.mDuration;
        goto L18
    L19:
        return this.mVHeight;
    L16:
        return this.mVWidth;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public long getValueLong(int r100) {
        if (r100 == 12) goto L9;
        if (r100 == 30) goto L11;
        return 0;
    L11:
        return this.mExpire;
    L9:
        return this.mSize;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public String getValueStr(int r100) {
        if (r100 == 5) goto L33;
        if (r100 == 6) goto L43;
        if (r100 == 7) goto L42;
        if (r100 == 8) goto L41;
        if (r100 == 15) goto L40;
        if (r100 == 18) goto L39;
        if (r100 == 28) goto L38;
        if (r100 == 53) goto L37;
        if (r100 == 31) goto L36;
        if (r100 == 32) goto L35;
        return null;
    L35:
        return this.mQualityDesc;
    L36:
        return this.mCheckInfo;
    L37:
        return this.mSegmentSizeInfo;
    L38:
        return this.mFileId;
    L39:
        return this.mQuality;
    L40:
        return this.mFileHash;
    L41:
        return this.mCodecType;
    L42:
        return this.mGear;
    L43:
        return this.mFormat;
    L33:
        return this.mSpadea;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public String[] getValueStrArr(int r100) {
        if (r100 != 16) goto L5;
        List<String> r101 = this.mUrls;
        if (r101 == null) goto L15;
        return (String[]) r101.toArray(new String[0]);
    L15:
        return new String[0];
    L5:
        if (r100 != 51) goto L16;
        List<String> r102 = this.mUrlExpires;
        if (r102 == null) goto L18;
        return (String[]) r102.toArray(new String[0]);
    L18:
        return new String[0];
    L16:
        return new String[0];
    }

    public static /* synthetic */ String access$1002(BareVideoInfo r100, String r101) {
        r100.mCodecType = r101;
        return r101;
    }

    public static /* synthetic */ int access$102(BareVideoInfo r100, int r101) {
        r100.mMediaType = r101;
        return r101;
    }

    public static /* synthetic */ String access$1102(BareVideoInfo r100, String r101) {
        r100.mFormat = r101;
        return r101;
    }

    public static /* synthetic */ String access$1202(BareVideoInfo r100, String r101) {
        r100.mCheckInfo = r101;
        return r101;
    }

    public static /* synthetic */ Resolution access$1302(BareVideoInfo r100, Resolution r101) {
        r100.mResolution = r101;
        return r101;
    }

    public static /* synthetic */ String access$1402(BareVideoInfo r100, String r101) {
        r100.mQuality = r101;
        return r101;
    }

    public static /* synthetic */ String access$1502(BareVideoInfo r100, String r101) {
        r100.mQualityDesc = r101;
        return r101;
    }

    public static /* synthetic */ String access$1602(BareVideoInfo r100, String r101) {
        r100.mGear = r101;
        return r101;
    }

    public static /* synthetic */ String access$1702(BareVideoInfo r100, String r101) {
        r100.mSpadea = r101;
        return r101;
    }

    public static /* synthetic */ List access$1802(BareVideoInfo r100, List r101) {
        r100.mUrls = r101;
        return r101;
    }

    public static /* synthetic */ List access$1902(BareVideoInfo r100, List r101) {
        r100.mUrlExpires = r101;
        return r101;
    }

    public static /* synthetic */ List access$2002(BareVideoInfo r100, List r101) {
        r100.mBareGearInfo = r101;
        return r101;
    }

    public static /* synthetic */ int access$202(BareVideoInfo r100, int r101) {
        r100.mVWidth = r101;
        return r101;
    }

    public static /* synthetic */ String access$2102(BareVideoInfo r100, String r101) {
        r100.mSegmentSizeInfo = r101;
        return r101;
    }

    public static /* synthetic */ Builder access$2202(BareVideoInfo r100, Builder r101) {
        r100.mBuilder = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(BareVideoInfo r100, int r101) {
        r100.mVHeight = r101;
        return r101;
    }

    public static /* synthetic */ long access$402(BareVideoInfo r100, long r101) {
        r100.mBitrate = r101;
        return r101;
    }

    public static /* synthetic */ long access$502(BareVideoInfo r100, long r101) {
        r100.mDuration = r101;
        return r101;
    }

    public static /* synthetic */ long access$602(BareVideoInfo r100, long r101) {
        r100.mSize = r101;
        return r101;
    }

    public static /* synthetic */ long access$702(BareVideoInfo r100, long r101) {
        r100.mExpire = r101;
        return r101;
    }

    public static /* synthetic */ String access$802(BareVideoInfo r100, String r101) {
        r100.mFileHash = r101;
        return r101;
    }

    public static /* synthetic */ String access$902(BareVideoInfo r100, String r101) {
        r100.mFileId = r101;
        return r101;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo
    public void setValue(int r100, String[] r101) {
        if (r100 != 16) goto L5;
        ArrayList r102 = new ArrayList();
        this.mUrls = r102;
        Collections.addAll(r102, r101);
        return;
    L5:
        if (r100 == 51) goto L7;
        return;
    L7:
        ArrayList r103 = new ArrayList();
        this.mUrlExpires = r103;
        Collections.addAll(r103, r101);
    }
}
