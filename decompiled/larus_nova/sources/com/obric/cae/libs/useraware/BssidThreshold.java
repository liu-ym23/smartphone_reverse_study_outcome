package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class BssidThreshold implements Parcelable {
    public static final Parcelable.Creator<BssidThreshold> CREATOR = null;
    public String bssid;
    public int threshold;

    public class a implements Parcelable.Creator<BssidThreshold> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BssidThreshold createFromParcel(Parcel r100) {
            return new BssidThreshold(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BssidThreshold[] newArray(int r100) {
            return new BssidThreshold[r100];
        }
    }

    public BssidThreshold() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BssidThreshold(Parcel r100) {
        this.bssid = r100.readString();
        this.threshold = r100.readInt();
    }

    public BssidThreshold(String r100, int r101) {
        this.bssid = r100;
        this.threshold = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.bssid);
        r100.writeInt(this.threshold);
    }
}
