package com.bytedance.awemeopen.bizmodels.feed.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\t\n\u0002\b&\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0088\u0001B\u000b\b\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001B\u0014\b\u0014\u0012\u0007\u0010\u0085\u0001\u001a\u00020\u000b¢\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016R\"\u0010\u0015\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001fR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR$\u00100\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R$\u00103\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R$\u00106\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\"\u0010<\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0016\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R$\u0010>\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010%\u001a\u0004\b?\u0010'\"\u0004\b@\u0010)R$\u0010A\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010%\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001b\u001a\u0004\bL\u0010\u001d\"\u0004\bM\u0010\u001fR$\u0010N\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010%\u001a\u0004\bO\u0010'\"\u0004\bP\u0010)R\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u001b\u001a\u0004\bR\u0010\u001d\"\u0004\bS\u0010\u001fR$\u0010T\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010%\u001a\u0004\bU\u0010'\"\u0004\bV\u0010)R$\u0010W\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010%\u001a\u0004\bX\u0010'\"\u0004\bY\u0010)R$\u0010Z\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010%\u001a\u0004\b[\u0010'\"\u0004\b\\\u0010)R$\u0010]\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010%\u001a\u0004\b^\u0010'\"\u0004\b_\u0010)R\"\u0010`\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u001b\u001a\u0004\ba\u0010\u001d\"\u0004\bb\u0010\u001fR\"\u0010d\u001a\u00020c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010j\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010%\u001a\u0004\bk\u0010'\"\u0004\bl\u0010)R\"\u0010m\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bm\u0010\u001b\u001a\u0004\bn\u0010\u001d\"\u0004\bo\u0010\u001fR\"\u0010p\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010\u0016\u001a\u0004\bp\u0010\u0017\"\u0004\bq\u0010\u0019R\"\u0010r\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010\u0016\u001a\u0004\br\u0010\u0017\"\u0004\bs\u0010\u0019R$\u0010t\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010\u0016\u001a\u0004\bz\u0010\u0017\"\u0004\b{\u0010\u0019R$\u0010|\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010%\u001a\u0004\b}\u0010'\"\u0004\b~\u0010)R&\u0010\u007f\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010%\u001a\u0005\b\u0080\u0001\u0010'\"\u0005\b\u0081\u0001\u0010)R\u0013\u0010\u0082\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0017¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/video/TextExtraStruct;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "", "subType", "", "setSubType", "followStatus", "setUserUserFollowStatus", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "", "o", "", "equals", "hashCode", "clone", "isStarAtlasTag", "Z", "()Z", "setStarAtlasTag", "(Z)V", "start", "I", "getStart", "()I", "setStart", "(I)V", "end", "getEnd", "setEnd", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "userFollowStatus", "getUserFollowStatus", "setUserFollowStatus", "type", "getType", "setType", "atUserType", "getAtUserType", "setAtUserType", "hashTagName", "getHashTagName", "setHashTagName", "cid", "getCid", "setCid", "color", "getColor", "setColor", "isCommerce", "setCommerce", "awemeId", "getAwemeId", "setAwemeId", "stickerId", "getStickerId", "setStickerId", "Lt14/a;", "stickerUrl", "Lt14/a;", "getStickerUrl", "()Lt14/a;", "setStickerUrl", "(Lt14/a;)V", "stickerSource", "getStickerSource", "setStickerSource", "schema", "getSchema", "setSchema", PushAction$ESubType.KEY_NAME, "getSubtype", "setSubtype", "liveData", "getLiveData", "setLiveData", "searchText", "getSearchText", "setSearchText", "link", "getLink", "setLink", "searchQueryId", "getSearchQueryId", "setSearchQueryId", "searchRank", "getSearchRank", "setSearchRank", "", "musicId", "J", "getMusicId", "()J", "setMusicId", "(J)V", "lotteryId", "getLotteryId", "setLotteryId", "searchHideWords", "getSearchHideWords", "setSearchHideWords", "isClickable", "setClickable", "isBoldText", "setBoldText", "customSpan", "Ljava/lang/Object;", "getCustomSpan", "()Ljava/lang/Object;", "setCustomSpan", "(Ljava/lang/Object;)V", "isInsertedLocally", "setInsertedLocally", "mentionMethod", "getMentionMethod", "setMentionMethod", "hashtagname", "getHashtagname", "setHashtagname", "isHideSearchWords", "<init>", "()V", "in", "(Landroid/os/Parcel;)V", "Companion", "b", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class TextExtraStruct implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;
    public static final b Companion = null;
    public static final int FANS_LUCKY_DRAW_JOIN_TEXT = 9;
    public static final int FANS_LUCKY_DRAW_WINNER_TEXT = 10;
    public static final int MIX_SEARCH_RELATED_EMPHASIZE_TEXT = 11;
    public static final int SUB_TYPE_COMMENT = 2;
    public static final int SUB_TYPE_COMMENT_VIDEO = 5;
    public static final int SUB_TYPE_DUET = 1;
    public static final int SUB_TYPE_LIVE_ANIM = 4;
    public static final int SUB_TYPE_LIVE_AT = 3;
    public static final int TYPE_AT = 0;
    public static final int TYPE_CUSTOM = 65281;
    public static final int TYPE_CUSTOM_AD_TAG = 65286;
    public static final int TYPE_CUSTOM_COLOR_CLICK_SPAN = 65282;
    public static final int TYPE_CUSTOM_COMMERCE_TAG = 65288;
    public static final int TYPE_CUSTOM_FORWARD_VIDEO = 65287;
    public static final int TYPE_CUSTOM_SEARCH_CAPTION = 65285;
    public static final int TYPE_FORWARD_USER = 2;
    public static final int TYPE_HASH_TAG = 1;
    public static final int TYPE_MUSIC = 6;
    public static final int TYPE_REPLY_USER = 3;
    public static final int TYPE_SEARCH_TEXT = 5;
    public static final int TYPE_SLIDES_TITLE = 7;
    public static final int TYPE_SLIDES_TITLE_SEPARATOR = 8;
    public static final int TYPE_STICKER = 4;

    @SerializedName("at_user_type")
    private String atUserType;

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String awemeId;

    @SerializedName("hashtag_id")
    private String cid;

    @SerializedName("color")
    private int color;
    private Object customSpan;

    @SerializedName("end")
    private int end;

    @SerializedName("hashtag_name")
    private String hashTagName;

    @SerializedName("hashTagName")
    private String hashtagname;
    private boolean isBoldText;
    private boolean isClickable;

    @SerializedName("is_commerce")
    private boolean isCommerce;
    private boolean isInsertedLocally;

    @SerializedName("star_atlas_tag")
    private boolean isStarAtlasTag;

    @SerializedName("link")
    private String link;

    @SerializedName("live_data")
    private String liveData;

    @SerializedName("fans_lucky_draw_id")
    private String lotteryId;
    private String mentionMethod;

    @SerializedName("music_id")
    private long musicId;
    private String schema;

    @SerializedName("search_hide_words")
    private int searchHideWords;

    @SerializedName("search_query_id")
    private String searchQueryId;

    @SerializedName("search_rank")
    private int searchRank;

    @SerializedName("search_text")
    private String searchText;

    @SerializedName("start")
    private int start;

    @SerializedName("sticker_id")
    private String stickerId;

    @SerializedName("sticker_source")
    private int stickerSource;

    @SerializedName("sticker_url")
    private t14.a stickerUrl;

    @SerializedName("sub_type")
    private int subtype;

    @SerializedName("type")
    private int type;

    @SerializedName("user_follow_status")
    private int userFollowStatus;

    @SerializedName("user_id")
    private String userId;

    public static final class a implements Parcelable.Creator<TextExtraStruct> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new TextExtraStruct(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct[] newArray(int r100) {
            return new TextExtraStruct[r100];
        }
    }

    public static final class b {
        public b() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public int hashCode() {
        int r100 = 0;
        int r101 = ((this.type + 0) + this.subtype) * 31;
        String r102 = this.atUserType;
        if (r102 == null) goto L6;
        if (r102 == null) goto L6;
        int r103 = r102.hashCode();
    L7:
        int r104 = (r101 + r103) * 31;
        String r105 = this.hashTagName;
        if (r105 == null) goto L12;
        if (r105 == null) goto L12;
        r100 = r105.hashCode();
    L12:
        return r104 + r100;
    L6:
        r103 = 0;
        goto L7
    }

    public final boolean isHideSearchWords() {
        if (this.searchHideWords == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public TextExtraStruct() {
        this.isClickable = true;
    }

    public TextExtraStruct clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct");
        return (TextExtraStruct) r100;
    }

    public final String getAtUserType() {
        return this.atUserType;
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getCid() {
        return this.cid;
    }

    public final int getColor() {
        return this.color;
    }

    public final Object getCustomSpan() {
        return this.customSpan;
    }

    public final int getEnd() {
        return this.end;
    }

    public final String getHashTagName() {
        return this.hashTagName;
    }

    public final String getHashtagname() {
        return this.hashtagname;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLiveData() {
        return this.liveData;
    }

    public final String getLotteryId() {
        return this.lotteryId;
    }

    public final String getMentionMethod() {
        return this.mentionMethod;
    }

    public final long getMusicId() {
        return this.musicId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final int getSearchHideWords() {
        return this.searchHideWords;
    }

    public final String getSearchQueryId() {
        return this.searchQueryId;
    }

    public final int getSearchRank() {
        return this.searchRank;
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final int getStart() {
        return this.start;
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final int getStickerSource() {
        return this.stickerSource;
    }

    public final t14.a getStickerUrl() {
        return this.stickerUrl;
    }

    public final int getSubtype() {
        return this.subtype;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUserFollowStatus() {
        return this.userFollowStatus;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isBoldText() {
        return this.isBoldText;
    }

    public final boolean isClickable() {
        return this.isClickable;
    }

    public final boolean isCommerce() {
        return this.isCommerce;
    }

    public final boolean isInsertedLocally() {
        return this.isInsertedLocally;
    }

    public final boolean isStarAtlasTag() {
        return this.isStarAtlasTag;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8303clone() {
        return clone();
    }

    public TextExtraStruct(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "in");
        this.isClickable = true;
        this.start = r100.readInt();
        this.end = r100.readInt();
        this.type = r100.readInt();
        this.atUserType = r100.readString();
        this.hashTagName = r100.readString();
        this.awemeId = r100.readString();
        this.schema = r100.readString();
        this.subtype = r100.readInt();
        this.musicId = r100.readLong();
        this.userFollowStatus = r100.readInt();
        this.searchText = r100.readString();
        this.searchQueryId = r100.readString();
        this.searchHideWords = r100.readInt();
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
    L28:
        return false;
    L11:
        if (this.subtype != r101.subtype) goto L28;
        if (TextUtils.equals(this.hashTagName, r101.hashTagName) == true) goto L16;
        return false;
    L16:
        String r102 = this.searchQueryId;
        if (r102 != null) goto L19;
    L21:
        String r103 = this.atUserType;
        String r104 = r101.atUserType;
        if (r103 != null) goto L29;
        if (r104 == null) goto L30;
        return false;
    L30:
        return true;
    L29:
        return Intrinsics.areEqual(r103, r104);
    L19:
        if (Intrinsics.areEqual(r102, r101.searchQueryId) == false) goto L21;
        return false;
    }

    public final void setAtUserType(String r100) {
        this.atUserType = r100;
    }

    public final void setAwemeId(String r100) {
        this.awemeId = r100;
    }

    public final void setBoldText(boolean r100) {
        this.isBoldText = r100;
    }

    public final void setCid(String r100) {
        this.cid = r100;
    }

    public final void setClickable(boolean r100) {
        this.isClickable = r100;
    }

    public final void setColor(int r100) {
        this.color = r100;
    }

    public final void setCommerce(boolean r100) {
        this.isCommerce = r100;
    }

    public final void setCustomSpan(Object r100) {
        this.customSpan = r100;
    }

    public final void setEnd(int r100) {
        this.end = r100;
    }

    public final void setHashTagName(String r100) {
        this.hashTagName = r100;
    }

    public final void setHashtagname(String r100) {
        this.hashtagname = r100;
    }

    public final void setInsertedLocally(boolean r100) {
        this.isInsertedLocally = r100;
    }

    public final void setLink(String r100) {
        this.link = r100;
    }

    public final void setLiveData(String r100) {
        this.liveData = r100;
    }

    public final void setLotteryId(String r100) {
        this.lotteryId = r100;
    }

    public final void setMentionMethod(String r100) {
        this.mentionMethod = r100;
    }

    public final void setMusicId(long r100) {
        this.musicId = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSearchHideWords(int r100) {
        this.searchHideWords = r100;
    }

    public final void setSearchQueryId(String r100) {
        this.searchQueryId = r100;
    }

    public final void setSearchRank(int r100) {
        this.searchRank = r100;
    }

    public final void setSearchText(String r100) {
        this.searchText = r100;
    }

    public final void setStarAtlasTag(boolean r100) {
        this.isStarAtlasTag = r100;
    }

    public final void setStart(int r100) {
        this.start = r100;
    }

    public final void setStickerId(String r100) {
        this.stickerId = r100;
    }

    public final void setStickerSource(int r100) {
        this.stickerSource = r100;
    }

    public final void setStickerUrl(t14.a r100) {
        this.stickerUrl = r100;
    }

    public final void setSubType(int r100) {
        this.subtype = r100;
    }

    public final void setSubtype(int r100) {
        this.subtype = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUserFollowStatus(int r100) {
        this.userFollowStatus = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public final void setUserUserFollowStatus(int r100) {
        this.userFollowStatus = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.start);
        r100.writeInt(this.end);
        r100.writeInt(this.type);
        r100.writeString(this.atUserType);
        r100.writeString(this.hashTagName);
        r100.writeString(this.awemeId);
        r100.writeString(this.schema);
        r100.writeInt(this.subtype);
        r100.writeLong(this.musicId);
        r100.writeInt(this.userFollowStatus);
        r100.writeString(this.searchText);
        r100.writeString(this.searchQueryId);
        r100.writeInt(this.searchHideWords);
    }
}
