package com.bytedance.awemeopen.apps.framework.comment.write.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TextExtraStruct implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;
    public static final int FANS_LUCKY_DRAW_JOIN_TEXT = 9;
    public static final int FANS_LUCKY_DRAW_WINNER_TEXT = 10;
    private static final int I_CONSTANTS_31 = 31;
    public static final int LVIDEO_SPLIT_LINE = 20;
    public static final int LVIDEO_WORK_DETAIL = 19;
    public static final int MIX_SEARCH_DEEPQA_HIGHLIGHT = 13;
    public static final int MIX_SEARCH_RELATED_EMPHASIZE_TEXT = 11;
    public static final int SUB_TYPE_AI_IMAGE_EXPAND = 10;
    public static final int SUB_TYPE_BAIKE_FLOAT_PAGE = 8;
    public static final int SUB_TYPE_BAIKE_SEARCH = 7;
    public static final int SUB_TYPE_COMMENT = 2;
    public static final int SUB_TYPE_COMMENT_DUET = 9;
    public static final int SUB_TYPE_COMMENT_VIDEO = 5;
    public static final int SUB_TYPE_DUET = 1;
    public static final int SUB_TYPE_LIVE_ANIM = 4;
    public static final int SUB_TYPE_LIVE_AT = 3;
    public static final int TYPE_AT = 0;
    public static final int TYPE_AT_PREFIX = 100;
    public static final int TYPE_BAIKE_TEXT = 15;
    public static final int TYPE_CUSTOM = 65281;
    public static final int TYPE_CUSTOMIZE_RICH_TEXT = 14;
    public static final int TYPE_CUSTOM_AD_TAG = 65286;
    public static final int TYPE_CUSTOM_COLOR_CLICK_SPAN = 65282;
    public static final int TYPE_CUSTOM_COMMERCE_TAG = 65288;
    public static final int TYPE_CUSTOM_FORWARD_VIDEO = 65287;
    public static final int TYPE_CUSTOM_SEARCH_CAPTION = 65285;
    public static final int TYPE_CUSTOM_VIDEO_ABSTRACT_TIME = 65289;
    public static final int TYPE_FORWARD_USER = 2;
    public static final int TYPE_GROUP_CHAT = 16;
    public static final int TYPE_HASH_TAG = 1;
    public static final int TYPE_HOT_SPOT = 12;
    public static final int TYPE_MUSIC = 6;
    public static final int TYPE_REPLY_USER = 3;
    public static final int TYPE_SEARCH_TEXT = 5;
    public static final int TYPE_SLIDES_TITLE = 7;
    public static final int TYPE_SLIDES_TITLE_SEPARATOR = 8;
    public static final int TYPE_STICKER = 4;

    @SerializedName("at_user_type")
    String atUserType;

    @SerializedName("aweme_id")
    String awemeId;

    @SerializedName("baike_float_page_schema")
    String baikeFloatPageSchema;

    @SerializedName("baike_search_extra_param")
    String baikeSearchExtraParam;

    @SerializedName("baike_search_text")
    String baikeSearchText;
    boolean boldText;

    @SerializedName("hashtag_id")
    String cid;

    @SerializedName("color")
    int color;

    @SerializedName("conv_ticket")
    String convTicket;

    @SerializedName("conversation_id")
    String conversationId;
    private Object customSpan;

    @SerializedName("is_hide_icon")
    boolean customizeCanHideIcon;

    @SerializedName("icon_horizontal_position")
    int customizeIconHorizontalPosition;

    @SerializedName("icon_length")
    int customizeIconLength;

    @SerializedName("icon_url_dark")
    String customizeIconUrlDark;

    @SerializedName("icon_url_light")
    String customizeIconUrlLight;

    @SerializedName("icon_vertical_position")
    int customizeIconVerticalPosition;

    @SerializedName("customize_rich_text")
    String customizeRichText;

    @SerializedName("text_color_dark")
    String customizeTextColorDark;

    @SerializedName("text_color_light")
    String customizeTextColorLight;

    @SerializedName("end")
    int end;
    public HashMap<String, Object> extraParams;

    @SerializedName("hashtag_name")
    String hashTagName;

    @SerializedName("hashTagName")
    public String hashtagname;

    @SerializedName("hotspot_text")
    public String hotspotText;
    boolean indexModified;
    private boolean insertedLocally;
    private boolean isClickable;

    @SerializedName("is_commerce")
    boolean isCommerce;

    @SerializedName("link")
    String link;

    @SerializedName("live_data")
    String liveData;

    @SerializedName("fans_lucky_draw_id")
    String lotteryId;

    @SerializedName("sec_uid")
    String mSecUid;
    private String mentionMethod;

    @SerializedName("music_id")
    long musicId;

    @SerializedName("related_sentence")
    public String relatedSentence;
    String schema;

    @SerializedName("search_entity_id")
    String searchEntityId;

    @SerializedName("search_extra")
    public String searchExtra;

    @SerializedName("search_hide_words")
    int searchHideWords;

    @SerializedName("search_query_id")
    String searchQueryId;

    @SerializedName("search_rank")
    int searchRank;

    @SerializedName("search_text")
    String searchText;

    @SerializedName("sentence_id")
    public String sentenceId;

    @SerializedName("star_atlas_tag")
    boolean starAtlasTag;

    @SerializedName(UploadTypeInf.START)
    int start;

    @SerializedName("sticker_id")
    String stickerId;

    @SerializedName("sticker_source")
    int stickerSource;

    @SerializedName("sticker_url")
    t14.a stickerUrl;

    @SerializedName("sub_type")
    int subType;

    @SerializedName("tag_mention_need_fold")
    public int tagMentionNeedFold;

    @SerializedName("type")
    int type;

    @SerializedName("user_follow_status")
    int userFollowStatus;

    @SerializedName("user_id")
    String userId;

    public static class a implements Parcelable.Creator<TextExtraStruct> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct createFromParcel(Parcel r2) {
            return new TextExtraStruct(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct[] newArray(int r1) {
            return new TextExtraStruct[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int hashCode() {
        String r0 = this.userId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 + 0) * 31) + this.type) + this.subType) * 31;
        String r4 = this.atUserType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.hashTagName;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public TextExtraStruct() {
        this.starAtlasTag = false;
        this.isClickable = true;
        this.insertedLocally = false;
    }

    public TextExtraStruct clone() {
        return (TextExtraStruct) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean isHideSearchWords() {
        if (getSearchHideWords() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String getAtUserType() {
        return this.atUserType;
    }

    public String getAwemeId() {
        return this.awemeId;
    }

    public String getBaikeFloatPageSchema() {
        return this.baikeFloatPageSchema;
    }

    public String getBaikeSearchExtraParam() {
        return this.baikeSearchExtraParam;
    }

    public String getBaikeSearchText() {
        return this.baikeSearchText;
    }

    public String getCid() {
        return this.cid;
    }

    public int getColor() {
        return this.color;
    }

    public String getConvTicket() {
        return this.convTicket;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Object getCustomSpan() {
        return this.customSpan;
    }

    public boolean getCustomizeCanHideIcon() {
        return this.customizeCanHideIcon;
    }

    public int getCustomizeIconHorizontalPosition() {
        return this.customizeIconHorizontalPosition;
    }

    public int getCustomizeIconLength() {
        return this.customizeIconLength;
    }

    public String getCustomizeIconUrlDark() {
        return this.customizeIconUrlDark;
    }

    public String getCustomizeIconUrlLight() {
        return this.customizeIconUrlLight;
    }

    public int getCustomizeIconVerticalPosition() {
        return this.customizeIconVerticalPosition;
    }

    public String getCustomizeRichText() {
        return this.customizeRichText;
    }

    public String getCustomizeTextColorDark() {
        return this.customizeTextColorDark;
    }

    public String getCustomizeTextColorLight() {
        return this.customizeTextColorLight;
    }

    public int getEnd() {
        return this.end;
    }

    public String getHashTagName() {
        return this.hashTagName;
    }

    public String getLink() {
        return this.link;
    }

    public String getLiveData() {
        return this.liveData;
    }

    public String getLotteryId() {
        return this.lotteryId;
    }

    public String getMentionMethod() {
        return this.mentionMethod;
    }

    public long getMusicId() {
        return this.musicId;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSearchEntityId() {
        return this.searchEntityId;
    }

    public String getSearchExtra() {
        return this.searchExtra;
    }

    public int getSearchHideWords() {
        return this.searchHideWords;
    }

    public String getSearchQueryId() {
        return this.searchQueryId;
    }

    public int getSearchRank() {
        return this.searchRank;
    }

    public String getSearchText() {
        return this.searchText;
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

    public t14.a getStickerUrl() {
        return this.stickerUrl;
    }

    public int getSubtype() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public int getUserFollowStatus() {
        return this.userFollowStatus;
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

    public boolean isIndexModified() {
        return this.indexModified;
    }

    public boolean isInsertedLocally() {
        return this.insertedLocally;
    }

    public boolean isStarAtlasTag() {
        return this.starAtlasTag;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1286clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextExtraStruct(Parcel r3) {
        this.starAtlasTag = false;
        this.isClickable = true;
        this.insertedLocally = false;
        this.start = r3.readInt();
        this.end = r3.readInt();
        this.userId = r3.readString();
        this.mSecUid = r3.readString();
        this.type = r3.readInt();
        this.atUserType = r3.readString();
        this.hashTagName = r3.readString();
        this.awemeId = r3.readString();
        this.schema = r3.readString();
        this.subType = r3.readInt();
        this.musicId = r3.readLong();
        this.userFollowStatus = r3.readInt();
        this.searchText = r3.readString();
        this.searchQueryId = r3.readString();
        this.searchHideWords = r3.readInt();
        this.searchExtra = r3.readString();
        this.hotspotText = r3.readString();
        this.sentenceId = r3.readString();
        this.conversationId = r3.readString();
        this.convTicket = r3.readString();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextExtraStruct) == true) goto L8;
        return false;
    L8:
        TextExtraStruct r6 = (TextExtraStruct) r5;
        if (this.type == r6.type) goto L11;
    L36:
        return false;
    L11:
        if (this.subType != r6.subType) goto L36;
        String r1 = this.userId;
        if (r1 == null) goto L19;
        if (r1.equals(r6.userId) == true) goto L22;
    L20:
        return false;
    L22:
        if (TextUtils.equals(this.hashTagName, r6.hashTagName) == true) goto L24;
        return false;
    L24:
        String r2 = this.searchQueryId;
        if (r2 != null) goto L27;
    L29:
        String r3 = this.atUserType;
        String r7 = r6.atUserType;
        if (r3 != null) goto L37;
        if (r7 == null) goto L38;
        return false;
    L38:
        return true;
    L37:
        return r3.equals(r7);
    L27:
        if (r2.equals(r6.searchQueryId) == false) goto L29;
        return false;
    L19:
        if (r6.userId == null) goto L22;
        goto L20
    }

    public void setAtUserType(String r1) {
        this.atUserType = r1;
    }

    public void setAwemeId(String r1) {
        this.awemeId = r1;
    }

    public void setBaikeSearchText(String r1) {
        this.baikeSearchText = r1;
    }

    public void setBoldText(boolean r1) {
        this.boldText = r1;
    }

    public void setCid(String r1) {
        this.cid = r1;
    }

    public void setClickable(boolean r1) {
        this.isClickable = r1;
    }

    public void setColor(int r1) {
        this.color = r1;
    }

    public void setCommerce(boolean r1) {
        this.isCommerce = r1;
    }

    public void setConvTicket(String r1) {
        this.convTicket = r1;
    }

    public void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public void setCustomSpan(Object r1) {
        this.customSpan = r1;
    }

    public void setCustomizeCanHideIcon(boolean r1) {
        this.customizeCanHideIcon = r1;
    }

    public void setCustomizeIconHorizontalPosition(int r1) {
        this.customizeIconHorizontalPosition = r1;
    }

    public void setCustomizeIconLength(int r1) {
        this.customizeIconLength = r1;
    }

    public void setCustomizeIconUrlDark(String r1) {
        this.customizeIconUrlDark = r1;
    }

    public void setCustomizeIconVerticalPosition(int r1) {
        this.customizeIconVerticalPosition = r1;
    }

    public void setCustomizeRichText(String r1) {
        this.customizeRichText = r1;
    }

    public void setCustomizeTextColorDark(String r1) {
        this.customizeTextColorDark = r1;
    }

    public void setCustomizeTextColorLight(String r1) {
        this.customizeTextColorLight = r1;
    }

    public void setEnd(int r1) {
        this.end = r1;
    }

    public void setHashTagName(String r1) {
        this.hashTagName = r1;
    }

    public void setIndexModified(boolean r1) {
        this.indexModified = r1;
    }

    public void setInsertedLocally(boolean r1) {
        this.insertedLocally = r1;
    }

    public void setLink(String r1) {
        this.link = r1;
    }

    public void setLotteryId(String r1) {
        this.lotteryId = r1;
    }

    public void setMentionMethod(String r1) {
        this.mentionMethod = r1;
    }

    public void setMusicId(long r1) {
        this.musicId = r1;
    }

    public void setSchema(String r1) {
        this.schema = r1;
    }

    public void setSearchExtra(String r1) {
        this.searchExtra = r1;
    }

    public void setSearchHideWords(int r1) {
        this.searchHideWords = r1;
    }

    public void setSearchQueryId(String r1) {
        this.searchQueryId = r1;
    }

    public void setSearchRank(int r1) {
        this.searchRank = r1;
    }

    public void setSearchText(String r1) {
        this.searchText = r1;
    }

    public void setSecUid(String r1) {
        this.mSecUid = r1;
    }

    public void setStarAtlasTag(boolean r1) {
        this.starAtlasTag = r1;
    }

    public void setStart(int r1) {
        this.start = r1;
    }

    public void setStickerId(String r1) {
        this.stickerId = r1;
    }

    public void setStickerSource(int r1) {
        this.stickerSource = r1;
    }

    public void setStickerUrl(t14.a r1) {
        this.stickerUrl = r1;
    }

    public void setSubType(int r1) {
        this.subType = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setTypeCustomizeRichText(String r1) {
        this.customizeIconUrlLight = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setUserUserFollowStatus(int r1) {
        this.userFollowStatus = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.start);
        r3.writeInt(this.end);
        r3.writeString(this.userId);
        r3.writeString(this.mSecUid);
        r3.writeInt(this.type);
        r3.writeString(this.atUserType);
        r3.writeString(this.hashTagName);
        r3.writeString(this.awemeId);
        r3.writeString(this.schema);
        r3.writeInt(this.subType);
        r3.writeLong(this.musicId);
        r3.writeInt(this.userFollowStatus);
        r3.writeString(this.searchText);
        r3.writeString(this.searchQueryId);
        r3.writeInt(this.searchHideWords);
        r3.writeString(this.searchExtra);
        r3.writeString(this.hotspotText);
        r3.writeString(this.sentenceId);
        r3.writeString(this.conversationId);
        r3.writeString(this.convTicket);
    }
}
