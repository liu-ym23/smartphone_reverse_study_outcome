package com.ttnet.org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = null;
    private final long mHigh;
    private final long mLow;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        long r100 = this.mLow;
        int r101 = (int) (r100 ^ (r100 >>> 32));
        long r102 = this.mHigh;
        int r103 = r101 * 31;
        return r103 + ((int) (r102 ^ (r102 >>> 32)));
    }

    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel r100 = Parcel.obtain();
        writeToParcel(r100, 0);
        r100.setDataPosition(0);
        UnguessableToken r101 = CREATOR.createFromParcel(r100);
        r100.recycle();
        return r101;
    }

    public long getHighForSerialization() {
        return this.mHigh;
    }

    public long getLowForSerialization() {
        return this.mLow;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (getClass() != r100.getClass()) goto L16;
        UnguessableToken r101 = (UnguessableToken) r100;
        if (r101.mHigh == this.mHigh) goto L10;
        return false;
    L10:
        if (r101.mLow != this.mLow) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    private UnguessableToken(long r100, long r101) {
        this.mHigh = r100;
        this.mLow = r101;
    }

    private static UnguessableToken create(long r100, long r101) {
        return new UnguessableToken(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mHigh);
        r100.writeLong(this.mLow);
    }

    public /* synthetic */ UnguessableToken(long r100, long r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
