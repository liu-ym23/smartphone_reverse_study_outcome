package com.ss.android.ttvecamera;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes38.dex */
public class TEFocusParameters implements Parcelable {
    public static final Parcelable.Creator<TEFocusParameters> CREATOR = null;
    public Rect mActiveSize;
    public Rect mCropSize;
    public int mMaxRegionsAE;
    public int mMaxRegionsAF;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "active size is:" + this.mActiveSize.toString() + " crop size is: " + this.mCropSize.toString() + "  max AF regions is: " + this.mMaxRegionsAF + "  max AE regions is: " + this.mMaxRegionsAE;
    }

    public TEFocusParameters() {
    }

    public TEFocusParameters(Parcel r100) {
        this.mActiveSize = (Rect) r100.readParcelable(Rect.class.getClassLoader());
        this.mMaxRegionsAF = r100.readInt();
        this.mMaxRegionsAE = r100.readInt();
        this.mCropSize = (Rect) r100.readParcelable(Rect.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mActiveSize, r101);
        r100.writeInt(this.mMaxRegionsAF);
        r100.writeInt(this.mMaxRegionsAE);
        r100.writeParcelable(this.mCropSize, r101);
    }
}
