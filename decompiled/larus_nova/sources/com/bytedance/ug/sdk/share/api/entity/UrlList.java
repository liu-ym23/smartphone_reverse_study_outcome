package com.bytedance.ug.sdk.share.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class UrlList implements Serializable, Parcelable {
    public static final Parcelable.Creator<UrlList> CREATOR = null;

    @SerializedName("url")
    public String mUrl;

    public static class a implements Parcelable.Creator<UrlList> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrlList createFromParcel(Parcel r100) {
            return new UrlList(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UrlList[] newArray(int r100) {
            return new UrlList[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public UrlList() {
    }

    public UrlList(Parcel r100) {
        this.mUrl = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mUrl);
    }
}
