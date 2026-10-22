package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class RssiDropThreshold implements Parcelable {
    public static final Parcelable.Creator<RssiDropThreshold> CREATOR = null;
    public int dropDb;
    public int durationSec;

    public class a implements Parcelable.Creator<RssiDropThreshold> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RssiDropThreshold createFromParcel(Parcel r100) {
            return new RssiDropThreshold(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RssiDropThreshold[] newArray(int r100) {
            return new RssiDropThreshold[r100];
        }
    }

    public RssiDropThreshold() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RssiDropThreshold(Parcel r100) {
        this.durationSec = r100.readInt();
        this.dropDb = r100.readInt();
    }

    public RssiDropThreshold(int r100, int r101) {
        this.durationSec = r100;
        this.dropDb = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.durationSec);
        r100.writeInt(this.dropDb);
    }
}
