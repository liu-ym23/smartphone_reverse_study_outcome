package com.bytedance.awemeopen.apps.framework.comment.write.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
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

    @SerializedName(SimilarProductParam.AWEME_ID)
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

    @SerializedName("start")
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
        public final TextExtraStruct createFromParcel(Parcel r100) {
            return new TextExtraStruct(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct[] newArray(int r100) {
            return new TextExtraStruct[r100];
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
    public /* bridge */ /* synthetic */ Object m8302clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextExtraStruct(Parcel r100) {
        this.starAtlasTag = false;
        this.isClickable = true;
        this.insertedLocally = false;
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
        this.musicId = r100.readLong();
        this.userFollowStatus = r100.readInt();
        this.searchText = r100.readString();
        this.searchQueryId = r100.readString();
        this.searchHideWords = r100.readInt();
        this.searchExtra = r100.readString();
        this.hotspotText = r100.readString();
        this.sentenceId = r100.readString();
        this.conversationId = r100.readString();
        this.convTicket = r100.readString();
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
    L36:
        return false;
    L11:
        if (this.subType != r101.subType) goto L36;
        String r102 = this.userId;
        if (r102 == null) goto L19;
        if (r102.equals(r101.userId) == true) goto L22;
    L20:
        return false;
    L22:
        if (TextUtils.equals(this.hashTagName, r101.hashTagName) == true) goto L24;
        return false;
    L24:
        String r103 = this.searchQueryId;
        if (r103 != null) goto L27;
    L29:
        String r104 = this.atUserType;
        String r105 = r101.atUserType;
        if (r104 != null) goto L37;
        if (r105 == null) goto L38;
        return false;
    L38:
        return true;
    L37:
        return r104.equals(r105);
    L27:
        if (r103.equals(r101.searchQueryId) == false) goto L29;
        return false;
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

    public void setBaikeSearchText(String r100) {
        this.baikeSearchText = r100;
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

    public void setConvTicket(String r100) {
        this.convTicket = r100;
    }

    public void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public void setCustomSpan(Object r100) {
        this.customSpan = r100;
    }

    public void setCustomizeCanHideIcon(boolean r100) {
        this.customizeCanHideIcon = r100;
    }

    public void setCustomizeIconHorizontalPosition(int r100) {
        this.customizeIconHorizontalPosition = r100;
    }

    public void setCustomizeIconLength(int r100) {
        this.customizeIconLength = r100;
    }

    public void setCustomizeIconUrlDark(String r100) {
        this.customizeIconUrlDark = r100;
    }

    public void setCustomizeIconVerticalPosition(int r100) {
        this.customizeIconVerticalPosition = r100;
    }

    public void setCustomizeRichText(String r100) {
        this.customizeRichText = r100;
    }

    public void setCustomizeTextColorDark(String r100) {
        this.customizeTextColorDark = r100;
    }

    public void setCustomizeTextColorLight(String r100) {
        this.customizeTextColorLight = r100;
    }

    public void setEnd(int r100) {
        this.end = r100;
    }

    public void setHashTagName(String r100) {
        this.hashTagName = r100;
    }

    public void setIndexModified(boolean r100) {
        this.indexModified = r100;
    }

    public void setInsertedLocally(boolean r100) {
        this.insertedLocally = r100;
    }

    public void setLink(String r100) {
        this.link = r100;
    }

    public void setLotteryId(String r100) {
        this.lotteryId = r100;
    }

    public void setMentionMethod(String r100) {
        this.mentionMethod = r100;
    }

    public void setMusicId(long r100) {
        this.musicId = r100;
    }

    public void setSchema(String r100) {
        this.schema = r100;
    }

    public void setSearchExtra(String r100) {
        this.searchExtra = r100;
    }

    public void setSearchHideWords(int r100) {
        this.searchHideWords = r100;
    }

    public void setSearchQueryId(String r100) {
        this.searchQueryId = r100;
    }

    public void setSearchRank(int r100) {
        this.searchRank = r100;
    }

    public void setSearchText(String r100) {
        this.searchText = r100;
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

    public void setStickerUrl(t14.a r100) {
        this.stickerUrl = r100;
    }

    public void setSubType(int r100) {
        this.subType = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setTypeCustomizeRichText(String r100) {
        this.customizeIconUrlLight = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setUserUserFollowStatus(int r100) {
        this.userFollowStatus = r100;
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
        r100.writeLong(this.musicId);
        r100.writeInt(this.userFollowStatus);
        r100.writeString(this.searchText);
        r100.writeString(this.searchQueryId);
        r100.writeInt(this.searchHideWords);
        r100.writeString(this.searchExtra);
        r100.writeString(this.hotspotText);
        r100.writeString(this.sentenceId);
        r100.writeString(this.conversationId);
        r100.writeString(this.convTicket);
    }
}
