package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class ReadWhiteListInfo implements Parcelable {
    public static final Parcelable.Creator<ReadWhiteListInfo> CREATOR = null;

    public class a implements Parcelable.Creator<ReadWhiteListInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ReadWhiteListInfo createFromParcel(Parcel r100) {
            return new ReadWhiteListInfo();
        }

        @Override // android.os.Parcelable.Creator
        public final ReadWhiteListInfo[] newArray(int r100) {
            return new ReadWhiteListInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
    }

    static {
        CREATOR = new a();
    }

    public ReadWhiteListInfo() {
    }
}
