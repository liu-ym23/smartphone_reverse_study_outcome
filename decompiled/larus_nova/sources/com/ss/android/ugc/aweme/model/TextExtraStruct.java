package com.ss.android.ugc.aweme.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class TextExtraStruct implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;
    private static final int I_CONSTANTS_31 = 31;
    public static final int SUB_TYPE_COMMENT = 2;
    public static final int SUB_TYPE_DUET = 1;
    public static final int TYPE_AT = 0;
    public static final int TYPE_CUSTOM = 65281;
    public static final int TYPE_CUSTOM_COLOR_CLICK_SPAN = 65282;
    public static final int TYPE_CUSTOM_SEARCH_CAPTION = 65285;
    public static final int TYPE_FORWARD_USER = 2;
    public static final int TYPE_HASH_TAG = 1;
    public static final int TYPE_REPLY_USER = 3;
    public static final int TYPE_STICKER = 4;

    @SerializedName("at_user_type")
    String atUserType;

    @SerializedName(SimilarProductParam.AWEME_ID)
    String awemeId;
    boolean boldText;

    @SerializedName("hashtag_id")
    String cid;

    @SerializedName("color")
    int color;
    private Object customSpan;

    @SerializedName("end")
    int end;

    @SerializedName("hashtag_name")
    String hashTagName;
    private boolean isClickable;

    @SerializedName("is_commerce")
    boolean isCommerce;

    @SerializedName("sec_uid")
    private String mSecUid;
    String schema;

    @SerializedName("star_atlas_tag")
    boolean starAtlasTag;

    @SerializedName("start")
    int start;

    @SerializedName("sticker_id")
    String stickerId;

    @SerializedName("sticker_source")
    int stickerSource;

    @SerializedName("sticker_url")
    UrlModel stickerUrl;

    @SerializedName("sub_type")
    int subType;

    @SerializedName("type")
    int type;

    @SerializedName("user_id")
    String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 + 0) * 31) + this.type) + this.subType) * 31;
        String r104 = this.atUserType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.hashTagName;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public TextExtraStruct() {
        this.starAtlasTag = false;
        this.isClickable = true;
    }

    public TextExtraStruct clone() {
        return (TextExtraStruct) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getAtUserType() {
        return this.atUserType;
    }

    public String getAwemeId() {
        return this.awemeId;
    }

    public String getCid() {
        return this.cid;
    }

    public int getColor() {
        return this.color;
    }

    public Object getCustomSpan() {
        return this.customSpan;
    }

    public int getEnd() {
        return this.end;
    }

    public String getHashTagName() {
        return this.hashTagName;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSecUid() {
        return this.mSecUid;
    }

    public int getStart() {
        return this.start;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public int getStickerSource() {
        return this.stickerSource;
    }

    public UrlModel getStickerUrl() {
        return this.stickerUrl;
    }

    public int getSubtype() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isBoldText() {
        return this.boldText;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public boolean isCommerce() {
        return this.isCommerce;
    }

    public boolean isStarAtlasTag() {
        return this.starAtlasTag;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8703clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextExtraStruct(Parcel r100) {
        this.starAtlasTag = false;
        this.isClickable = true;
        this.start = r100.readInt();
        this.end = r100.readInt();
        this.userId = r100.readString();
        this.mSecUid = r100.readString();
        this.type = r100.readInt();
        this.atUserType = r100.readString();
        this.hashTagName = r100.readString();
        this.awemeId = r100.readString();
        this.schema = r100.readString();
        this.subType = r100.readInt();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextExtraStruct) == true) goto L8;
        return false;
    L8:
        TextExtraStruct r101 = (TextExtraStruct) r100;
        if (this.type == r101.type) goto L11;
    L31:
        return false;
    L11:
        if (this.subType != r101.subType) goto L31;
        String r102 = this.userId;
        if (r102 == null) goto L19;
        if (r102.equals(r101.userId) == true) goto L22;
    L20:
        return false;
    L22:
        if (TextUtils.equals(this.hashTagName, r101.hashTagName) == true) goto L24;
        return false;
    L24:
        String r103 = this.atUserType;
        String r104 = r101.atUserType;
        if (r103 != null) goto L32;
        if (r104 == null) goto L33;
        return false;
    L33:
        return true;
    L32:
        return r103.equals(r104);
    L19:
        if (r101.userId == null) goto L22;
        goto L20
    }

    public void setAtUserType(String r100) {
        this.atUserType = r100;
    }

    public void setAwemeId(String r100) {
        this.awemeId = r100;
    }

    public void setBoldText(boolean r100) {
        this.boldText = r100;
    }

    public void setCid(String r100) {
        this.cid = r100;
    }

    public void setClickable(boolean r100) {
        this.isClickable = r100;
    }

    public void setColor(int r100) {
        this.color = r100;
    }

    public void setCommerce(boolean r100) {
        this.isCommerce = r100;
    }

    public void setCustomSpan(Object r100) {
        this.customSpan = r100;
    }

    public void setEnd(int r100) {
        this.end = r100;
    }

    public void setHashTagName(String r100) {
        this.hashTagName = r100;
    }

    public void setSchema(String r100) {
        this.schema = r100;
    }

    public void setSecUid(String r100) {
        this.mSecUid = r100;
    }

    public void setStarAtlasTag(boolean r100) {
        this.starAtlasTag = r100;
    }

    public void setStart(int r100) {
        this.start = r100;
    }

    public void setStickerId(String r100) {
        this.stickerId = r100;
    }

    public void setStickerSource(int r100) {
        this.stickerSource = r100;
    }

    public void setStickerUrl(UrlModel r100) {
        this.stickerUrl = r100;
    }

    public void setSubType(int r100) {
        this.subType = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.start);
        r100.writeInt(this.end);
        r100.writeString(this.userId);
        r100.writeString(this.mSecUid);
        r100.writeInt(this.type);
        r100.writeString(this.atUserType);
        r100.writeString(this.hashTagName);
        r100.writeString(this.awemeId);
        r100.writeString(this.schema);
        r100.writeInt(this.subType);
    }
}
