package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes6.dex */
public class GnssSvAwareInfo implements Parcelable {
    public static final Parcelable.Creator<GnssSvAwareInfo> CREATOR = null;
    public static final int MASK_AIDING_DATA_ALMANAC = 2;
    public static final int MASK_AIDING_DATA_EPHEMERIS = 1;
    public static final int MASK_AIDING_DATA_NONE = 0;
    private static final int VERSION = 2;
    private final float[] mAzimuths;
    private final float[] mCarrierFrequencies;
    private final float[] mCn0DbHzs;
    private final int[] mConstellationType;
    private final float[] mElevations;
    private final int[] mHasAidingData;
    private final boolean[] mIsUsedInFix;
    private final int mSvCount;
    private final int[] mSvId;
    private final long mTimestamp;
    private int mVisibleSvs;
    private float mVisibleSvsMeanCn0;

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<GnssSvAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GnssSvAwareInfo createFromParcel(Parcel r100) {
            return new GnssSvAwareInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GnssSvAwareInfo[] newArray(int r100) {
            return new GnssSvAwareInfo[r100];
        }
    }

    public final void a() {
        int r100 = 0;
    L4:
        if (r100 >= this.mSvCount) goto L9;
        float r101 = this.mCn0DbHzs[r100];
        if (r101 <= 0.0f) goto L8;
        this.mVisibleSvs++;
        this.mVisibleSvsMeanCn0 += r101;
    L8:
        r100 = r100 + 1;
        goto L4
    L9:
        int r102 = this.mVisibleSvs;
        if (r102 <= 0) goto L12;
        this.mVisibleSvsMeanCn0 /= r102;
        return;
    L12:
        this.mVisibleSvsMeanCn0 = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersion() {
        return 2;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("GnssSvAwareInfo[2,");
        r100.append(this.mTimestamp);
        r100.append(",");
        r100.append(this.mVisibleSvs);
        r100.append(",");
        r100.append(this.mVisibleSvsMeanCn0);
        if (this.mVisibleSvs <= 0) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= this.mSvCount) goto L8;
        r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r100.append(this.mSvId[r101]);
        r100.append(",");
        r100.append(this.mCn0DbHzs[r101]);
        r100.append(",");
        r100.append(this.mElevations[r101]);
        r100.append(",");
        r100.append(this.mAzimuths[r101]);
        r100.append(",");
        r100.append(this.mCarrierFrequencies[r101]);
        r100.append(",");
        r100.append(this.mConstellationType[r101]);
        r100.append(",");
        r100.append(this.mHasAidingData[r101]);
        r100.append(",");
        r100.append(this.mIsUsedInFix[r101]);
        r101 = r101 + 1;
    L8:
        r100.append(']');
        return r100.toString();
    }

    public float[] getAzimuths() {
        return this.mAzimuths;
    }

    public float[] getCarrierFrequencies() {
        return this.mCarrierFrequencies;
    }

    public float[] getCn0DbHzs() {
        return this.mCn0DbHzs;
    }

    public int[] getConstellationType() {
        return this.mConstellationType;
    }

    public float[] getElevations() {
        return this.mElevations;
    }

    public int[] getHasAidingData() {
        return this.mHasAidingData;
    }

    public boolean[] getIsUsedInFix() {
        return this.mIsUsedInFix;
    }

    public int getSvCount() {
        return this.mSvCount;
    }

    public int[] getSvId() {
        return this.mSvId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getVisibleSvCount() {
        return this.mVisibleSvs;
    }

    public float getVisibleSvMeanCn0() {
        return this.mVisibleSvsMeanCn0;
    }

    public GnssSvAwareInfo(Parcel r100) {
        this.mVisibleSvs = 0;
        this.mVisibleSvsMeanCn0 = 0.0f;
        this.mTimestamp = r100.readLong();
        int r101 = r100.readInt();
        this.mSvCount = r101;
        float[] r102 = new float[r101];
        this.mCn0DbHzs = r102;
        r100.readFloatArray(r102);
        float[] r103 = new float[r101];
        this.mElevations = r103;
        r100.readFloatArray(r103);
        float[] r104 = new float[r101];
        this.mAzimuths = r104;
        r100.readFloatArray(r104);
        float[] r105 = new float[r101];
        this.mCarrierFrequencies = r105;
        r100.readFloatArray(r105);
        int[] r106 = new int[r101];
        this.mConstellationType = r106;
        r100.readIntArray(r106);
        int[] r107 = new int[r101];
        this.mHasAidingData = r107;
        r100.readIntArray(r107);
        boolean[] r108 = new boolean[r101];
        this.mIsUsedInFix = r108;
        r100.readBooleanArray(r108);
        this.mVisibleSvs = r100.readInt();
        this.mVisibleSvsMeanCn0 = r100.readFloat();
        int[] r109 = new int[r101];
        this.mSvId = r109;
        if (r100.dataAvail() <= 0) goto L6;
        r100.readIntArray(r109);
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mTimestamp);
        r100.writeInt(this.mSvCount);
        r100.writeFloatArray(this.mCn0DbHzs);
        r100.writeFloatArray(this.mElevations);
        r100.writeFloatArray(this.mAzimuths);
        r100.writeFloatArray(this.mCarrierFrequencies);
        r100.writeIntArray(this.mConstellationType);
        r100.writeIntArray(this.mHasAidingData);
        r100.writeBooleanArray(this.mIsUsedInFix);
        r100.writeInt(this.mVisibleSvs);
        r100.writeFloat(this.mVisibleSvsMeanCn0);
        r100.writeIntArray(this.mSvId);
    }

    public GnssSvAwareInfo(int r100, int[] r101, float[] r102, float[] r103, float[] r104, float[] r105, int[] r106, int[] r110, boolean[] r111) {
        this.mVisibleSvs = 0;
        this.mVisibleSvsMeanCn0 = 0.0f;
        this.mTimestamp = System.currentTimeMillis();
        this.mSvCount = r100;
        this.mSvId = r101;
        this.mCn0DbHzs = r102;
        this.mElevations = r103;
        this.mAzimuths = r104;
        this.mCarrierFrequencies = r105;
        this.mConstellationType = r106;
        this.mHasAidingData = r110;
        this.mIsUsedInFix = r111;
        a();
    }
}
