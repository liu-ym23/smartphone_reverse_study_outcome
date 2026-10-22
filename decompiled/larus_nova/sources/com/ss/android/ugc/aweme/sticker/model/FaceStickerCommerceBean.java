package com.ss.android.ugc.aweme.sticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes40.dex */
public class FaceStickerCommerceBean implements Parcelable {
    public static final Parcelable.Creator<FaceStickerCommerceBean> CREATOR = null;

    @SerializedName("commerce_sticker_buy_text")
    private String commerceStickerBuyText;

    @SerializedName("commerce_sticker_open_url")
    private String commerceStickerOpenUrl;

    @SerializedName("commerce_sticker_type")
    private int commerceStickerType;

    @SerializedName("commerce_sticker_web_url")
    private String commerceStickerWebUrl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public FaceStickerCommerceBean(Parcel r100) {
        this.commerceStickerWebUrl = r100.readString();
        this.commerceStickerOpenUrl = r100.readString();
        this.commerceStickerBuyText = r100.readString();
        this.commerceStickerType = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.commerceStickerWebUrl);
        r100.writeString(this.commerceStickerOpenUrl);
        r100.writeString(this.commerceStickerBuyText);
        r100.writeInt(this.commerceStickerType);
    }
}
