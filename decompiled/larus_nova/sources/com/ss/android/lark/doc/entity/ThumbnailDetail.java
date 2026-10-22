package com.ss.android.lark.doc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ThumbnailDetail implements Serializable, Parcelable {
    public static final Parcelable.Creator<ThumbnailDetail> CREATOR = null;

    @SerializedName("cipher_type")
    public String cipherType;

    @SerializedName("decrypt_key_mobile")
    public String decryptKeyMobile;

    @SerializedName("decrypt_nonce_mobile")
    public String decryptNonceMobile;

    @SerializedName("thumbnail_url_mobile")
    public String thumbnailUrlMobile;

    public class a implements Parcelable.Creator<ThumbnailDetail> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailDetail createFromParcel(Parcel r100) {
            return new ThumbnailDetail(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailDetail[] newArray(int r100) {
            return new ThumbnailDetail[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ThumbnailDetail() {
    }

    public ThumbnailDetail(Parcel r100) {
        this.cipherType = r100.readString();
        this.decryptNonceMobile = r100.readString();
        this.thumbnailUrlMobile = r100.readString();
        this.decryptKeyMobile = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.cipherType);
        r100.writeString(this.decryptNonceMobile);
        r100.writeString(this.thumbnailUrlMobile);
        r100.writeString(this.decryptKeyMobile);
    }
}
