package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.ttve.nativePort.TEVideoUtils;
import com.ss.android.vesdk.runtime.VERecorderResManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VERecordData implements Parcelable {
    public static final String AUDIOEFFECTS = "audioEffects";
    public static final String AUDIOLENGTHS = "audioLengths";
    public static final String AUDIOPATHS = "audioPaths";
    public static final Parcelable.Creator<VERecordData> CREATOR = null;
    public static final String[] DATAFIELD = null;
    public static final String DUATSTARTTIME = "duatStartTime";
    public static final String ENCODEMETHOD = "encodeMethod";
    public static final String ENCODEMODE = "encodeMode";
    public static final String MUSICSTARTTIME = "musicStartTime";
    public static final String NEWSYNC = "newSync";
    public static final String OFFSET = "offset";
    public static final String RANDOM = "random";
    public static final String SPEEDS = "speeds";
    static final String TAG = null;
    public static final String VIDEOCOUNTS = "counts";
    public static final String VIDEOLENGTHS = "videoLengths";
    public static final String VIDEOPATHS = "videoPaths";
    public static final String VIDEOQUALITY = "videoQuality";
    public static final String audioSuffix = "_frag_a";
    public static final String[] suffixs = null;
    public static final String videoSuffix = "_frag_v";
    public String concatAudio;
    public String concatVideo;
    private List<VERecordSegmentData> mSegmentDataList;
    private boolean mUseMusic;

    public static final enum FILETYPE extends Enum<FILETYPE> {
        public static final FILETYPE AUDIO = null;
        public static final FILETYPE VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FILETYPE[] f455637a = null;

        static {
            FILETYPE r100 = new FILETYPE("AUDIO", 0);
            AUDIO = r100;
            FILETYPE r101 = new FILETYPE("VIDEO", 1);
            VIDEO = r101;
            f455637a = new FILETYPE[]{r100, r101};
        }

        public static FILETYPE[] values() {
            return (FILETYPE[]) f455637a.clone();
        }

        public static FILETYPE valueOf(String r100) {
            return (FILETYPE) r27.a.a(FILETYPE.class, r100);
        }

        public FILETYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class VERecordSegmentData implements Parcelable {
        public static final Parcelable.Creator<VERecordSegmentData> CREATOR = null;
        public String mAudio;
        public long mAudioLength;
        private long mCutTrimIn;
        private long mCutTrimOut;
        public boolean mEnable;
        public ROTATE_DEGREE mRotate;
        public float mSpeed;
        public long mTrimIn;
        public long mTrimOut;
        public String mVideo;
        public long mVideoLength;
        public float mVideoSpeed;
        public boolean mWithNoSpeedBoth;

        public class a implements Parcelable.Creator<VERecordSegmentData> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VERecordSegmentData createFromParcel(Parcel r100) {
                return new VERecordSegmentData(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final VERecordSegmentData[] newArray(int r100) {
                return new VERecordSegmentData[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public long getCutTrimIn() {
            return this.mCutTrimIn;
        }

        public long getCutTrimOut() {
            return this.mCutTrimOut;
        }

        public VERecordSegmentData(Parcel r100) {
            this.mVideoSpeed = 1.0f;
            boolean r101 = false;
            this.mWithNoSpeedBoth = false;
            this.mVideo = r100.readString();
            this.mAudio = r100.readString();
            this.mVideoLength = r100.readLong();
            this.mAudioLength = r100.readLong();
            this.mVideoSpeed = r100.readFloat();
            this.mSpeed = r100.readFloat();
            this.mRotate = (ROTATE_DEGREE) r100.readParcelable(ROTATE_DEGREE.class.getClassLoader());
            this.mTrimIn = r100.readLong();
            this.mTrimOut = r100.readLong();
            if (r100.readByte() == 0) goto L5;
            boolean r102 = true;
        L6:
            this.mEnable = r102;
            this.mCutTrimIn = r100.readLong();
            this.mCutTrimOut = r100.readLong();
            if (r100.readByte() == 0) goto L9;
            r101 = true;
        L9:
            this.mWithNoSpeedBoth = r101;
            return;
        L5:
            r102 = false;
            goto L6
        }

        public static /* synthetic */ long access$000(VERecordSegmentData r100) {
            return r100.mCutTrimOut;
        }

        public static /* synthetic */ long access$100(VERecordSegmentData r100) {
            return r100.mCutTrimIn;
        }

        public static /* synthetic */ long access$002(VERecordSegmentData r100, long r101) {
            r100.mCutTrimOut = r101;
            return r101;
        }

        public static /* synthetic */ long access$102(VERecordSegmentData r100, long r101) {
            r100.mCutTrimIn = r101;
            return r101;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.mVideo);
            r100.writeString(this.mAudio);
            r100.writeLong(this.mVideoLength);
            r100.writeLong(this.mAudioLength);
            r100.writeFloat(this.mVideoSpeed);
            r100.writeFloat(this.mSpeed);
            r100.writeParcelable(this.mRotate, r101);
            r100.writeLong(this.mTrimIn);
            r100.writeLong(this.mTrimOut);
            r100.writeByte(this.mEnable ? 1 : 0);
            r100.writeLong(this.mCutTrimIn);
            r100.writeLong(this.mCutTrimOut);
            r100.writeByte(this.mWithNoSpeedBoth ? 1 : 0);
        }

        public VERecordSegmentData(String r100, long r101, String r102, long r103, float r104, long r105, long r110, boolean r111) {
            this.mVideoSpeed = 1.0f;
            this.mVideo = r100;
            this.mAudio = r102;
            this.mVideoLength = r101;
            this.mAudioLength = r103;
            this.mSpeed = r104;
            this.mTrimIn = r105;
            this.mCutTrimIn = r105;
            this.mTrimOut = r110;
            this.mCutTrimOut = r110;
            this.mEnable = r111;
            this.mWithNoSpeedBoth = false;
        }

        public VERecordSegmentData(String r100, long r101, String r102, long r103, float r104, float r105, ROTATE_DEGREE r106, long r110, long r111, boolean r112) {
            this.mVideo = r100;
            this.mAudio = r102;
            this.mVideoLength = r101;
            this.mAudioLength = r103;
            this.mVideoSpeed = r104;
            this.mSpeed = r105;
            this.mRotate = r106;
            this.mTrimIn = r110;
            this.mCutTrimIn = r110;
            this.mTrimOut = r111;
            this.mCutTrimOut = r111;
            this.mEnable = r112;
            this.mWithNoSpeedBoth = false;
        }
    }

    public class a implements Parcelable.Creator<VERecordData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VERecordData createFromParcel(Parcel r100) {
            return new VERecordData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VERecordData[] newArray(int r100) {
            return new VERecordData[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
        TAG = "VERecordData";
        DATAFIELD = new String[]{VIDEOCOUNTS, AUDIOLENGTHS, SPEEDS, MUSICSTARTTIME, ENCODEMODE, "offset", VIDEOQUALITY, "random", DUATSTARTTIME, AUDIOEFFECTS, NEWSYNC, ENCODEMETHOD, VIDEOLENGTHS};
        suffixs = new String[]{videoSuffix, audioSuffix};
    }

    public boolean isSegmentOriginLenth() {
        Iterator<VERecordSegmentData> r100 = this.mSegmentDataList.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        VERecordSegmentData r101 = r100.next();
        long r102 = (r101.mTrimOut - r101.mTrimIn) / 1000;
        long r103 = (VERecordSegmentData.access$000(r101) - VERecordSegmentData.access$100(r101)) / 1000;
        String r104 = TAG;
        VELogUtil.d(r104, "segmentData.mTrimOut: " + r101.mTrimOut + " segmentData.mTrimIn: " + r101.mTrimIn + " segmentData.mVideoLength: " + r101.mVideoLength);
        VELogUtil.d(r104, "segmentData.mCutTrimOut: " + VERecordSegmentData.access$000(r101) + " segmentData.mCutTrimIn: " + VERecordSegmentData.access$100(r101) + " segmentData.mAudioLength: " + r101.mAudioLength);
        if (r101.mEnable == false) goto L11;
        long r105 = r101.mVideoLength;
        if (r102 < (r105 / 1000)) goto L11;
        if (r103 >= (r105 / 1000)) goto L4;
    L11:
        VELogUtil.e(r104, "is not Segment Origin Lenth");
        return false;
    L13:
        return true;
    }

    private VERecordData() {
    }

    public List<VERecordSegmentData> getSegmentData() {
        return this.mSegmentDataList;
    }

    public boolean isUseMusic() {
        return this.mUseMusic;
    }

    public VERecordData(Parcel r100) {
        this.mSegmentDataList = r100.createTypedArrayList(VERecordSegmentData.CREATOR);
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.mUseMusic = r101;
        this.concatVideo = r100.readString();
        this.concatAudio = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public VERecordSegmentData removeSegmentData(int r100) {
        String r101 = TAG;
        VELogUtil.i(r101, "removeSegmentData...");
        if (r100 >= 0) goto L5;
    L9:
        VELogUtil.e(r101, "Parameter error");
        return null;
    L5:
        if (r100 >= this.mSegmentDataList.size()) goto L9;
        return (VERecordSegmentData) ListProtector.remove(this.mSegmentDataList, r100);
    }

    public VERecordData(List<VERecordSegmentData> r100, boolean r101) {
        this.mSegmentDataList = r100;
        this.mUseMusic = r101;
    }

    public static int covertJsonToRecordData(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        VELogUtil.e(TAG, "Segmented video path is empty.");
        return -100;
    L7:
        if (r100.endsWith(File.separatorChar + "") == true) goto L25;
        r100 = r100 + File.separatorChar;
    L25:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100 + "data.txt");     // Catch: Exception -> L22
        r102.createNewFile();     // Catch: Exception -> L22
        BufferedWriter r103 = new BufferedWriter(new PolarisFileWriterWrapper(r102));     // Catch: Exception -> L22
        int r104 = 0;
    L10:
        String[] r105 = DATAFIELD;     // Catch: Exception -> L22
        if (r104 >= r105.length) goto L20;
        JSONArray r106 = (JSONArray) r101.get(r105[r104]);     // Catch: Exception -> L22
        String r107 = "";
        int r108 = 0;
    L14:
        if (r108 >= r106.length()) goto L19;
        r107 = r107 + r106.get(r108);     // Catch: Exception -> L22
        if (r108 == (r106.length() - 1)) goto L18;
        r107 = r107 + "\t";     // Catch: Exception -> L22
    L18:
        r108 = r108 + 1;     // Catch: Exception -> L22
        goto L14
    L19:
        r103.write(r107);     // Catch: Exception -> L22
        r103.write("\n");     // Catch: Exception -> L22
        r104 = r104 + 1;     // Catch: Exception -> L22
        goto L10
    L20:
        r103.close();     // Catch: Exception -> L22
        return 0;
    L22:
        e = move-exception;
        VELogUtil.e(TAG, "Reading file contents error");
        e.printStackTrace();
        return -1;
    }

    public static JSONObject covertRecordDataToJson(String r110, boolean r111) {
        if (TextUtils.isEmpty(r110) == false) goto L7;
        VELogUtil.e(TAG, "Segmented video path is empty.");
        return null;
    L7:
        if (r110.endsWith(File.separatorChar + "") == true) goto L9;
        r110 = r110 + File.separatorChar;
    L9:
        JSONObject r112 = new JSONObject();
        String r113 = r110 + "data.txt";
        PolarisFileWrapper r100 = new PolarisFileWrapper(r113);
        if (r100.exists() == true) goto L33;
        VELogUtil.e(TAG, r113 + " is not exist");
        return null;
    L33:
        InputStreamReader r114 = new InputStreamReader(new PolarisFileInputStreamWrapper(r100));     // Catch: Exception -> L30
        BufferedReader r101 = new BufferedReader(r114);     // Catch: Exception -> L30
        String[] r102 = DATAFIELD;     // Catch: Exception -> L30
        int r103 = r102.length;     // Catch: Exception -> L30
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L28;
        String r105 = r102[r104];     // Catch: Exception -> L30
        String r106 = r101.readLine();     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r106) == false) goto L21;
        if (r105 == "offset") goto L21;
        return null;
    L21:
        if (r105 != VIDEOCOUNTS) goto L23;
        CastIntegerProtector.valueOf(r106).intValue();     // Catch: Exception -> L30
    L23:
        String[] r107 = r106.split("\t");     // Catch: Exception -> L30
        JSONArray r108 = new JSONArray();     // Catch: Exception -> L30
        int r109 = 0;
    L25:
        if (r109 >= r107.length) goto L27;
        r108.put(r107[r109]);     // Catch: Exception -> L30
        r109 = r109 + 1;     // Catch: Exception -> L30
        goto L25
    L27:
        r112.put(r105, r108);     // Catch: Exception -> L30
        r104 = r104 + 1;     // Catch: Exception -> L30
        goto L14
    L28:
        r101.close();     // Catch: Exception -> L30
        r114.close();     // Catch: Exception -> L30
        return r112;
    L30:
        e = move-exception;
        VELogUtil.e(TAG, "Reading file contents error");
        e.printStackTrace();
        return null;
    }

    public static VERecordData create(VERecorderResManager r210, boolean r211) {
        String r100 = r210.getSegmentDirPath();
        if (TextUtils.isEmpty(r100) == false) goto L7;
        VELogUtil.e(TAG, "Segmented video path is empty.");
        return null;
    L7:
        if (r100.endsWith(File.separatorChar + "") == true) goto L9;
        r100 = r100 + File.separatorChar;
    L9:
        String r101 = r100 + "data.txt";
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        String[] r103 = new String[0];
        if (r102.exists() == true) goto L77;
        VELogUtil.e(TAG, r101 + " is not exist");
        return null;
    L77:
        InputStreamReader r104 = new InputStreamReader(new PolarisFileInputStreamWrapper(r102));     // Catch: Exception -> L74
        BufferedReader r105 = new BufferedReader(r104);     // Catch: Exception -> L74
        String r106 = r105.readLine();     // Catch: Exception -> L74
        if (TextUtils.isEmpty(r106) == false) goto L17;
        VELogUtil.e(TAG, "not found count");     // Catch: Exception -> L74
        return null;
    L17:
        int r107 = CastIntegerProtector.valueOf(r106).intValue();     // Catch: Exception -> L74
        String r108 = r105.readLine();     // Catch: Exception -> L74
        if (TextUtils.isEmpty(r108) == false) goto L21;
        VELogUtil.e(TAG, "not found audioLength");     // Catch: Exception -> L74
        return null;
    L21:
        String[] r109 = r108.split("\t");     // Catch: Exception -> L74
        String r110 = r105.readLine();     // Catch: Exception -> L74
        if (TextUtils.isEmpty(r110) == false) goto L25;
        VELogUtil.e(TAG, "not found speed");     // Catch: Exception -> L74
        return null;
    L25:
        String[] r111 = r110.split("\t");     // Catch: Exception -> L74
        String r112 = r105.readLine();     // Catch: Exception -> L74
        if (TextUtils.isEmpty(r112) == false) goto L29;
        VELogUtil.e(TAG, "not found music start time");     // Catch: Exception -> L74
        return null;
    L29:
        String[] r113 = r112.split("\t");     // Catch: Exception -> L74
        int r114 = 0;
    L31:
        if (r114 >= 8) goto L33;
        r105.readLine();     // Catch: Exception -> L74
        r114 = r114 + 1;     // Catch: Exception -> L74
        goto L31
    L33:
        String r115 = r105.readLine();     // Catch: Exception -> L74
        if (TextUtils.isEmpty(r115) == false) goto L36;
        VELogUtil.i(TAG, "not found video length");     // Catch: Exception -> L74
    L37:
        r105.close();     // Catch: Exception -> L74
        r104.close();     // Catch: Exception -> L74
        if (r107 != 0) goto L40;
    L72:
        VELogUtil.e(TAG, "Read file contents error, segmented information mismatch!");
        return null;
    L40:
        if (r107 != r109.length) goto L72;
        if (r107 != r111.length) goto L72;
        VERecordData r116 = new VERecordData();
        r116.mSegmentDataList = new LinkedList();
        int r117 = 1;
        if (r113.length != r107) goto L47;
        if (r211 == false) goto L47;
        r116.mUseMusic = true;
    L48:
        if (r117 > r107) goto L71;
        String r118 = r100 + r117 + videoSuffix;
        if (r116.mUseMusic == false) goto L52;
        String r119 = "";
    L53:
        boolean r120 = r116.mUseMusic;
        if (r120 == true) goto L56;
    L59:
        if (r120 == true) goto L61;
    L63:
        if (r120 == true) goto L65;
        long r121 = CastLongProtector.valueOf(r109[r117 - 1]).longValue();
    L67:
        if (r121 > 0) goto L69;
        int[] r122 = new int[10];
        TEVideoUtils.getVideoFileInfo(r118, r122);
        long r123 = r122[3] * 1000;
        VELogUtil.i(TAG, "audioLength is 0, use file length: " + r123);
        long r212 = r123;
    L70:
        r116.mSegmentDataList.add(new VERecordSegmentData(r118, r212, r119, r212, CastFloatProtector.valueOf(r111[r117 - 1]).floatValue(), 0, r212, true));
        r117 = r117 + 1;
        goto L48
    L69:
        r212 = r121;
        goto L70
    L65:
        r121 = 0;
        goto L67
    L61:
        if (r103.length < r117) goto L63;
        long r124 = CastLongProtector.valueOf(r103[r117 - 1]).longValue();
    L58:
        r121 = r124 * 1000;
        goto L67
    L56:
        if (r113.length <= r117) goto L59;
        r124 = CastLongProtector.valueOf(r113[r117]).longValue() - CastLongProtector.valueOf(r113[r117 - 1]).longValue();
        goto L58
    L52:
        r119 = r100 + r117 + audioSuffix;
        goto L53
    L71:
        return r116;
    L47:
        r116.mUseMusic = false;
        goto L48
    L36:
        r103 = r115.split("\t");     // Catch: Exception -> L74
    L74:
        e = move-exception;
        VELogUtil.e(TAG, "Reading file contents error");
        e.printStackTrace();
        return null;
    }

    public int addSegmentData(int r100, VERecordSegmentData r101) {
        String r102 = TAG;
        VELogUtil.i(r102, "addSegmentData...");
        if (r100 >= 0) goto L5;
    L9:
        VELogUtil.e(r102, "Parameter error");
        return -100;
    L5:
        if (r100 > this.mSegmentDataList.size()) goto L9;
        ListProtector.add(this.mSegmentDataList, r100, r101);
        return 0;
    }

    public VERecordSegmentData replaceSegmentData(int r110, VERecordData r111) {
        String r100 = TAG;
        VELogUtil.i(r100, "replaceSegmentData...");
        if (r110 >= 0) goto L5;
    L19:
        VELogUtil.e(r100, "Parameter error");
        return null;
    L5:
        if (r110 >= this.mSegmentDataList.size()) goto L19;
        List<VERecordSegmentData> r101 = r111.mSegmentDataList;
        if (r101 == null) goto L19;
        if (r101.size() == 0) goto L19;
        VERecordSegmentData r102 = (VERecordSegmentData) ListProtector.remove(this.mSegmentDataList, r110);
        long r103 = r102.mVideoLength;
        Iterator<VERecordSegmentData> r112 = r111.mSegmentDataList.iterator();
        long r104 = 0;
    L13:
        if (r112.hasNext() == false) goto L18;
        VERecordSegmentData r105 = r112.next();
        if (((r105.mVideoLength + r104) - r103) >= 0) goto L16;
        ListProtector.add(this.mSegmentDataList, r110, r105);
        r104 = r104 + r105.mVideoLength;
        r110 = r110 + 1;
        goto L13
    L16:
        long r106 = r103 - r104;
        r105.mAudioLength = r106;
        r105.mVideoLength = r106;
        r105.mTrimOut = VERecordSegmentData.access$002(r105, r106);
        ListProtector.add(this.mSegmentDataList, r110, r105);
    L18:
        return r102;
    }

    public int setTimeRange(long r210, long r211) {
        VELogUtil.i(TAG, "setTimeRange, start: " + r210 + " end: " + r211);
        if (r211 > r210) goto L6;
        return -100;
    L6:
        Iterator<VERecordSegmentData> r100 = this.mSegmentDataList.iterator();
        long r101 = 0;
    L8:
        if (r100.hasNext() == false) goto L28;
        VERecordSegmentData r110 = r100.next();
        long r111 = r110.mTrimOut;
        long r112 = r110.mTrimIn;
        long r113 = r111 - r112;
        if (r101 < r210) goto L14;
        if ((r101 + r113) > r211) goto L14;
    L27:
        r101 = r101 + r113;
    L14:
        if ((r101 + r113) > r210) goto L16;
    L26:
        VERecordSegmentData.access$102(r110, 0);
        VERecordSegmentData.access$002(r110, 0);
        r110.mEnable = false;
        goto L27
    L16:
        if (r101 >= r211) goto L26;
        long r114 = (r210 - r101) + r112;
        long r115 = (r211 - r101) + r112;
        if (r114 <= r112) goto L21;
        r112 = r114;
    L21:
        VERecordSegmentData.access$102(r110, r112);
        long r116 = r110.mTrimOut;
        if (r115 > r116) goto L25;
        r116 = r115;
    L25:
        VERecordSegmentData.access$002(r110, r116);
        goto L27
    L28:
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.mSegmentDataList);
        r100.writeByte(this.mUseMusic ? 1 : 0);
        r100.writeString(this.concatVideo);
        r100.writeString(this.concatAudio);
    }

    public static String getVideoRecordFilePath(String r100, int r101, FILETYPE r102) {
        if (r102 != FILETYPE.VIDEO) goto L5;
        String r103 = videoSuffix;
    L7:
        return r100 + r101 + r103;
    L5:
        r103 = audioSuffix;
        goto L7
    }
}
