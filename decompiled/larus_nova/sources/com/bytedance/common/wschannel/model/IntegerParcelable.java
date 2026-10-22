package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = null;
    private final int mData;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getData() {
        return this.mData;
    }

    public IntegerParcelable(Parcel r100) {
        this.mData = r100.readInt();
    }

    public IntegerParcelable(int r100) {
        this.mData = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mData);
    }
}
