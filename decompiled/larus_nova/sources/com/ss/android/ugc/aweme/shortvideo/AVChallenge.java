package com.ss.android.ugc.aweme.shortvideo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.android.ugc.aweme.shortvideo.mapping.AVChallengeExtrasAdapterFactory;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class AVChallenge implements Serializable, Parcelable {
    public static final Parcelable.Creator<AVChallenge> CREATOR = null;

    @SerializedName("activity_creation_schema")
    public String activityCreationSchema;

    @SerializedName("align")
    public int align;

    @SerializedName("can_use_under_line")
    public boolean canUseUnderLine;

    @SerializedName("cha_name")
    public String challengeName;

    @SerializedName("cid")
    public String cid;

    @SerializedName("dynamic_activity_info")
    public String dynamicRecordActivityInfo;

    @SerializedName("game_tpl_id")
    public String dynamicRecordLynxChannel;

    @JsonAdapter(AVChallengeExtrasAdapterFactory.class)
    @CreativeSuppressCheck
    private HashMap<String, Serializable> extras;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("init_offset_isLeftAxis")
    public boolean initOffsetIsLeftAxis;

    @SerializedName("init_offset_x")
    public float initOffsetX;

    @SerializedName("init_offset_y")
    public float initOffsetY;

    @SerializedName("is_commerce")
    public boolean isCommerce;

    @SerializedName("is_status")
    public Boolean mStatus;

    @SerializedName("with_sticker_on_edit_page")
    private int mWithStickerOnEditPage;

    @SerializedName("music_id")
    public String musicId;

    @SerializedName("mv_id")
    public String mvId;

    @SerializedName("sticker_id")
    public String stickerId;

    @SerializedName("text_color")
    public int textColor;

    @SerializedName("text_size")
    public float textSize;

    @SerializedName("type")
    public int type;

    @SerializedName("user_count")
    public int userCount;

    @SerializedName("view_count")
    public long viewCount;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r100 = this.cid;
        if (r100 != null) goto L5;
        String r101 = this.challengeName;
        if (r101 == null) goto L11;
        return r101.hashCode();
    L11:
        return super.hashCode();
    L5:
        return r100.hashCode();
    }

    public AVChallenge() {
        this.viewCount = -1;
        this.initOffsetX = 0.0f;
        this.initOffsetY = 0.0f;
        this.textSize = 24.0f;
        this.textColor = -1;
        this.align = 2;
        this.initOffsetIsLeftAxis = false;
        this.canUseUnderLine = true;
        this.mStatus = Boolean.FALSE;
        this.extras = new HashMap();
    }

    public long getDisplayCount() {
        long r100 = getViewCount();
        if (r100 < 0) goto L6;
        return r100;
    L6:
        return getUserCount();
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public String getCid() {
        return this.cid;
    }

    public Map<String, Serializable> getExtras() {
        return this.extras;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public float getInitOffsetX() {
        return this.initOffsetX;
    }

    public float getInitOffsetY() {
        return this.initOffsetY;
    }

    public String getMusicId() {
        return this.musicId;
    }

    public String getMvId() {
        return this.mvId;
    }

    public Boolean getStatus() {
        return this.mStatus;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public long getViewCount() {
        return this.viewCount;
    }

    public int getWithStickerOnEditPage() {
        return this.mWithStickerOnEditPage;
    }

    public boolean isCommerce() {
        return this.isCommerce;
    }

    public AVChallenge(Parcel r100) {
        this.viewCount = -1;
        this.initOffsetX = 0.0f;
        this.initOffsetY = 0.0f;
        this.textSize = 24.0f;
        this.textColor = -1;
        this.align = 2;
        boolean r101 = false;
        this.initOffsetIsLeftAxis = false;
        this.canUseUnderLine = true;
        this.mStatus = Boolean.FALSE;
        this.extras = new HashMap();
        this.cid = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isCommerce = r102;
        this.challengeName = r100.readString();
        this.type = r100.readInt();
        this.stickerId = r100.readString();
        this.viewCount = r100.readLong();
        this.userCount = r100.readInt();
        this.musicId = r100.readString();
        this.mvId = r100.readString();
        this.mWithStickerOnEditPage = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.mStatus = Boolean.valueOf(r103);
        this.extras = (HashMap) r100.readSerializable();
        this.initOffsetX = r100.readFloat();
        this.initOffsetY = r100.readFloat();
        this.textSize = r100.readFloat();
        this.textColor = r100.readInt();
        this.align = r100.readInt();
        if (r100.readInt() != 1) goto L13;
        boolean r104 = true;
    L14:
        this.initOffsetIsLeftAxis = r104;
        if (r100.readInt() != 1) goto L17;
        r101 = true;
    L17:
        this.canUseUnderLine = r101;
        this.dynamicRecordLynxChannel = r100.readString();
        this.activityCreationSchema = r100.readString();
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AVChallenge) == false) goto L9;
        AVChallenge r101 = (AVChallenge) r100;
        if (TextUtils.equals(r101.cid, this.cid) == false) goto L9;
        if (TextUtils.equals(r101.challengeName, this.challengeName) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public <T extends Serializable> T getFromExtra(String r100) {
        Serializable r101 = this.extras.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return (T) r101;
    }

    public boolean isNew(String r100) {
        if (TextUtils.isEmpty(this.cid) == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r100.equals(this.challengeName) == false) goto L9;
        return true;
    }

    public void setWithStickerOnEditPage(int r100) {
        this.mWithStickerOnEditPage = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.cid);
        r100.writeByte(this.isCommerce ? 1 : 0);
        r100.writeString(this.challengeName);
        r100.writeInt(this.type);
        r100.writeString(this.stickerId);
        r100.writeLong(this.viewCount);
        r100.writeInt(this.userCount);
        r100.writeString(this.musicId);
        r100.writeString(this.mvId);
        r100.writeInt(this.mWithStickerOnEditPage);
        r100.writeByte(this.mStatus.booleanValue() ? 1 : 0);
        r100.writeSerializable(this.extras);
        r100.writeFloat(this.initOffsetX);
        r100.writeFloat(this.initOffsetY);
        r100.writeFloat(this.textSize);
        r100.writeInt(this.textColor);
        r100.writeInt(this.align);
        r100.writeInt(this.initOffsetIsLeftAxis ? 1 : 0);
        r100.writeInt(this.canUseUnderLine ? 1 : 0);
        r100.writeString(this.dynamicRecordLynxChannel);
        r100.writeString(this.activityCreationSchema);
    }
}
