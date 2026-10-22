package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class CellAwareInfo implements Parcelable {
    public static final Parcelable.Creator<CellAwareInfo> CREATOR = null;
    private static final String LTE = "LTE";
    private static final long MAX_NCI = 68719476735L;
    private static final int MAX_NRARFCN = 3279165;
    private static final int MAX_PCI = 1007;
    private static final int MAX_TAC = 16777215;
    private static final String NR = "NR";
    private static final int VERSION = 2;
    private int mArfcn;
    private int[] mBands;
    private long mCi;
    private int mLevel;
    private String mMcc;
    private String mMnc;
    private int mPci;
    private boolean mRegistered;
    private int mSignalQuality;
    private int mSignalStrength;
    private String mStandard;
    private int mTac;
    private String mTimestamp;

    /* JADX INFO: loaded from: classes33.dex */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f395926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f395927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f395928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f395929d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f395930e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f395931f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int[] f395932g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f395933h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f395934i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f395935j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f395936k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f395937l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f395938m;

        public Builder() {
        }

        public CellAwareInfo build() {
            return new CellAwareInfo(this);
        }

        public static /* synthetic */ String a(Builder r100) {
            return r100.f395926a;
        }

        public static /* synthetic */ String b(Builder r100) {
            return r100.f395927b;
        }

        public static /* synthetic */ int c(Builder r100) {
            return r100.f395936k;
        }

        public static /* synthetic */ int d(Builder r100) {
            return r100.f395937l;
        }

        public static /* synthetic */ boolean e(Builder r100) {
            return r100.f395938m;
        }

        public static /* synthetic */ int f(Builder r100) {
            return r100.f395928c;
        }

        public static /* synthetic */ int g(Builder r100) {
            return r100.f395929d;
        }

        public static /* synthetic */ int h(Builder r100) {
            return r100.f395930e;
        }

        public static /* synthetic */ long i(Builder r100) {
            return r100.f395931f;
        }

        public static /* synthetic */ int[] j(Builder r100) {
            return r100.f395932g;
        }

        public static /* synthetic */ String k(Builder r100) {
            return r100.f395933h;
        }

        public static /* synthetic */ String l(Builder r100) {
            return r100.f395934i;
        }

        public static /* synthetic */ int m(Builder r100) {
            return r100.f395935j;
        }

        public Builder arfcn(int r100) {
            this.f395928c = r100;
            return this;
        }

        public Builder bands(int[] r100) {
            this.f395932g = r100;
            return this;
        }

        public Builder ci(long r100) {
            this.f395931f = r100;
            return this;
        }

        public Builder level(int r100) {
            this.f395937l = r100;
            return this;
        }

        public Builder mcc(String r100) {
            this.f395933h = r100;
            return this;
        }

        public Builder mnc(String r100) {
            this.f395934i = r100;
            return this;
        }

        public Builder pci(int r100) {
            this.f395929d = r100;
            return this;
        }

        public Builder registered(boolean r100) {
            this.f395938m = r100;
            return this;
        }

        public Builder signalQuality(int r100) {
            this.f395936k = r100;
            return this;
        }

        public Builder signalStrength(int r100) {
            this.f395935j = r100;
            return this;
        }

        public Builder standard(String r100) {
            this.f395927b = r100;
            return this;
        }

        public Builder tac(int r100) {
            this.f395930e = r100;
            return this;
        }

        public Builder timestamp(String r100) {
            this.f395926a = r100;
            return this;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<CellAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo createFromParcel(Parcel r100) {
            return new CellAwareInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo[] newArray(int r100) {
            return new CellAwareInfo[r100];
        }
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
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=" + this.mTac + ", mCi=" + this.mCi + ", mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
    }

    public CellAwareInfo() {
        this.mTimestamp = String.valueOf(System.currentTimeMillis());
        this.mStandard = "";
        this.mArfcn = 0;
        this.mPci = 0;
        this.mTac = 0;
        this.mCi = 0;
        this.mBands = new int[0];
        this.mMcc = "";
        this.mMnc = "";
        this.mSignalStrength = 0;
        this.mSignalQuality = 0;
        this.mLevel = 0;
        this.mRegistered = false;
    }

    public int getArfcn() {
        return this.mArfcn;
    }

    public int[] getBands() {
        return this.mBands;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getMcc() {
        return this.mMcc;
    }

    public long getMci() {
        return this.mCi;
    }

    public String getMnc() {
        return this.mMnc;
    }

    public int getPci() {
        return this.mPci;
    }

    public int getSignalQuality() {
        return this.mSignalQuality;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public String getStandard() {
        return this.mStandard;
    }

    public int getTac() {
        return this.mTac;
    }

    public String getTimestamp() {
        return this.mTimestamp;
    }

    public boolean isRegistered() {
        return this.mRegistered;
    }

    public CellAwareInfo(Parcel r100) {
        this.mTimestamp = r100.readString();
        this.mStandard = r100.readString();
        this.mArfcn = r100.readInt();
        this.mPci = r100.readInt();
        this.mTac = r100.readInt();
        this.mCi = r100.readLong();
        this.mBands = r100.createIntArray();
        this.mMcc = r100.readString();
        this.mMnc = r100.readString();
        this.mSignalStrength = r100.readInt();
        this.mSignalQuality = r100.readInt();
        this.mLevel = r100.readInt();
        this.mRegistered = r100.readBoolean();
    }

    public boolean compareTo(CellAwareInfo r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        if (this.mArfcn == r100.mArfcn) goto L13;
    L23:
        return false;
    L13:
        if (this.mPci != r100.mPci) goto L23;
        if (this.mTac != r100.mTac) goto L23;
        if (this.mCi != r100.mCi) goto L23;
        if (this.mRegistered != r100.mRegistered) goto L23;
        if (Objects.equals(this.mStandard, r100.mStandard) == false) goto L23;
        return true;
    }

    public void readFromParcel(Parcel r100) {
        this.mTimestamp = r100.readString();
        this.mStandard = r100.readString();
        this.mArfcn = r100.readInt();
        this.mPci = r100.readInt();
        this.mTac = r100.readInt();
        this.mCi = r100.readLong();
        this.mBands = r100.createIntArray();
        this.mMcc = r100.readString();
        this.mMnc = r100.readString();
        this.mSignalStrength = r100.readInt();
        this.mSignalQuality = r100.readInt();
        this.mLevel = r100.readInt();
        this.mRegistered = r100.readBoolean();
    }

    public void setArfcn(int r100) {
        this.mArfcn = r100;
    }

    public void setBands(int[] r100) {
        this.mBands = r100;
    }

    public void setLevel(int r100) {
        this.mLevel = r100;
    }

    public void setMcc(String r100) {
        this.mMcc = r100;
    }

    public void setMci(long r100) {
        this.mCi = r100;
    }

    public void setMnc(String r100) {
        this.mMnc = r100;
    }

    public void setPci(int r100) {
        this.mPci = r100;
    }

    public void setRegistered(boolean r100) {
        this.mRegistered = r100;
    }

    public void setSignalQuality(int r100) {
        this.mSignalQuality = r100;
    }

    public void setSignalStrength(int r100) {
        this.mSignalStrength = r100;
    }

    public void setStandard(String r100) {
        this.mStandard = r100;
    }

    public void setTac(int r100) {
        this.mTac = r100;
    }

    public void setTimestamp(String r100) {
        this.mTimestamp = r100;
    }

    public CellAwareInfo(Builder r100) {
        this.mTimestamp = Builder.a(r100);
        this.mStandard = Builder.b(r100);
        this.mArfcn = Builder.f(r100);
        this.mPci = Builder.g(r100);
        this.mTac = Builder.h(r100);
        this.mCi = Builder.i(r100);
        this.mBands = Builder.j(r100);
        this.mMcc = Builder.k(r100);
        this.mMnc = Builder.l(r100);
        this.mSignalStrength = Builder.m(r100);
        this.mSignalQuality = Builder.c(r100);
        this.mLevel = Builder.d(r100);
        this.mRegistered = Builder.e(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mTimestamp);
        r100.writeString(this.mStandard);
        r100.writeInt(this.mArfcn);
        r100.writeInt(this.mPci);
        r100.writeInt(this.mTac);
        r100.writeLong(this.mCi);
        r100.writeIntArray(this.mBands);
        r100.writeString(this.mMcc);
        r100.writeString(this.mMnc);
        r100.writeInt(this.mSignalStrength);
        r100.writeInt(this.mSignalQuality);
        r100.writeInt(this.mLevel);
        r100.writeBoolean(this.mRegistered);
    }
}
