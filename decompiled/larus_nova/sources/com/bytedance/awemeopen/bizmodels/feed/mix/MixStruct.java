package com.bytedance.awemeopen.bizmodels.feed.mix;

import com.bytedance.awemeopen.bizmodels.profile.User;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t14.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b)\u0018\u00002\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0006\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\nR$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR$\u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0006\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\"\u0010N\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010C\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR\"\u0010Q\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010<\u001a\u0004\bR\u0010>\"\u0004\bS\u0010@R\u0018\u0010T\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010V\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010<\u001a\u0004\bV\u0010>\"\u0004\bW\u0010@R\"\u0010X\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010<\u001a\u0004\bY\u0010>\"\u0004\bZ\u0010@R$\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0006\u001a\u0004\b\\\u0010\b\"\u0004\b]\u0010\nR\u0011\u0010`\u001a\u00020:8F¢\u0006\u0006\u001a\u0004\b_\u0010>R\u0011\u0010b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\ba\u0010\bR\u0011\u0010d\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bc\u0010\bR\u0011\u0010f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\be\u0010\b¨\u0006j"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;", "Ljava/io/Serializable;", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct$MixExtra;", "getExtraData", "", "mixId", "Ljava/lang/String;", "getMixId", "()Ljava/lang/String;", "setMixId", "(Ljava/lang/String;)V", "mixName", "getMixName", "setMixName", "Lt14/a;", "cover", "Lt14/a;", "getCover", "()Lt14/a;", "setCover", "(Lt14/a;)V", "icon", "getIcon", "setIcon", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatusStruct;", "status", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatusStruct;", "getStatus", "()Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatusStruct;", "setStatus", "(Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatusStruct;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatisStruct;", "statis", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatisStruct;", "getStatis", "()Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatisStruct;", "setStatis", "(Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatisStruct;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "author", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "getAuthor", "()Lcom/bytedance/awemeopen/bizmodels/profile/User;", "setAuthor", "(Lcom/bytedance/awemeopen/bizmodels/profile/User;)V", "extra", "getExtra", "setExtra", "Lx14/a;", "shareInfo", "Lx14/a;", "getShareInfo", "()Lx14/a;", "setShareInfo", "(Lx14/a;)V", "", "mixType", "I", "getMixType", "()I", "setMixType", "(I)V", "", "createTime", "J", "getCreateTime", "()J", "setCreateTime", "(J)V", UserInfo.UPDATE_TIME, "getUpdateTime", "setUpdateTime", "watchedItem", "getWatchedItem", "setWatchedItem", "watchedEpisode", "getWatchedEpisode", "setWatchedEpisode", "hasRecommendMix", "getHasRecommendMix", "setHasRecommendMix", ControlRule.KEY_EXTRA_DATA, "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct$MixExtra;", "isSerialMix", "setSerialMix", "mixPicType", "getMixPicType", "setMixPicType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getHostSceme", "setHostSceme", "hostSceme", "getSubType", "subType", "getGameContentCollectionId", "gameContentCollectionId", "getPlayListInfo", "playListInfo", "getPlayListSchema", "playListSchema", "<init>", "()V", "MixExtra", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class MixStruct implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f198180a;

    @SerializedName("author")
    private User author;

    @SerializedName("cover_url")
    private a cover;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("extra")
    private String extra;
    private MixExtra extraData;

    @SerializedName("has_recommend_mix")
    private int hasRecommendMix;

    @SerializedName("icon_url")
    private a icon;

    @SerializedName("is_serial_mix")
    private int isSerialMix;

    @SerializedName("mix_id")
    private String mixId;

    @SerializedName("mix_name")
    private String mixName;

    @SerializedName("mix_pic_type")
    private int mixPicType;

    @SerializedName("mix_type")
    private int mixType;

    @SerializedName("share_info")
    private x14.a shareInfo;

    @SerializedName("statis")
    private MixStatisStruct statis;

    @SerializedName("status")
    private MixStatusStruct status;

    @SerializedName("update_time")
    private long updateTime;

    @SerializedName("watched_episode")
    private long watchedEpisode;

    @SerializedName("watched_item")
    private String watchedItem;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct$MixExtra;", "Ljava/io/Serializable;", "()V", "gameContentCollectionId", "", "getGameContentCollectionId", "()Ljava/lang/String;", "setGameContentCollectionId", "(Ljava/lang/String;)V", "mixSubType", "", "getMixSubType", "()I", "setMixSubType", "(I)V", "playListInfo", "getPlayListInfo", "setPlayListInfo", "playListSchema", "getPlayListSchema", "setPlayListSchema", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MixExtra implements Serializable {

        @SerializedName("game_content_collection_id")
        private String gameContentCollectionId;

        @SerializedName("sub_type")
        private int mixSubType;

        @SerializedName("playlist_info")
        private String playListInfo;

        @SerializedName("playlist_schema")
        private String playListSchema;

        public MixExtra() {
            this.gameContentCollectionId = "";
            this.playListInfo = "";
            this.playListSchema = "";
        }

        public final String getGameContentCollectionId() {
            return this.gameContentCollectionId;
        }

        public final int getMixSubType() {
            return this.mixSubType;
        }

        public final String getPlayListInfo() {
            return this.playListInfo;
        }

        public final String getPlayListSchema() {
            return this.playListSchema;
        }

        public final void setGameContentCollectionId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.gameContentCollectionId = r100;
        }

        public final void setMixSubType(int r100) {
            this.mixSubType = r100;
        }

        public final void setPlayListInfo(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.playListInfo = r100;
        }

        public final void setPlayListSchema(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.playListSchema = r100;
        }
    }

    public MixStruct() {
    }

    public final MixExtra getExtraData() {
        if (this.extraData != null) goto L9;
        this.extraData = (MixExtra) new Gson().fromJson(this.extra, MixExtra.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return this.extraData;
    }

    public final String getGameContentCollectionId() {
        MixExtra r100 = getExtraData();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getGameContentCollectionId();
    }

    public final String getPlayListInfo() {
        MixExtra r100 = getExtraData();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getPlayListInfo();
    }

    public final String getPlayListSchema() {
        MixExtra r100 = getExtraData();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getPlayListSchema();
    }

    public final int getSubType() {
        MixExtra r100 = getExtraData();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMixSubType();
    }

    public final User getAuthor() {
        return this.author;
    }

    public final a getCover() {
        return this.cover;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getHasRecommendMix() {
        return this.hasRecommendMix;
    }

    public final String getHostSceme() {
        return this.f198180a;
    }

    public final a getIcon() {
        return this.icon;
    }

    public final String getMixId() {
        return this.mixId;
    }

    public final String getMixName() {
        return this.mixName;
    }

    public final int getMixPicType() {
        return this.mixPicType;
    }

    public final int getMixType() {
        return this.mixType;
    }

    public final x14.a getShareInfo() {
        return this.shareInfo;
    }

    public final MixStatisStruct getStatis() {
        return this.statis;
    }

    public final MixStatusStruct getStatus() {
        return this.status;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final long getWatchedEpisode() {
        return this.watchedEpisode;
    }

    public final String getWatchedItem() {
        return this.watchedItem;
    }

    public final int isSerialMix() {
        return this.isSerialMix;
    }

    public final void setAuthor(User r100) {
        this.author = r100;
    }

    public final void setCover(a r100) {
        this.cover = r100;
    }

    public final void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setHasRecommendMix(int r100) {
        this.hasRecommendMix = r100;
    }

    public final void setHostSceme(String r100) {
        this.f198180a = r100;
    }

    public final void setIcon(a r100) {
        this.icon = r100;
    }

    public final void setMixId(String r100) {
        this.mixId = r100;
    }

    public final void setMixName(String r100) {
        this.mixName = r100;
    }

    public final void setMixPicType(int r100) {
        this.mixPicType = r100;
    }

    public final void setMixType(int r100) {
        this.mixType = r100;
    }

    public final void setSerialMix(int r100) {
        this.isSerialMix = r100;
    }

    public final void setShareInfo(x14.a r100) {
        this.shareInfo = r100;
    }

    public final void setStatis(MixStatisStruct r100) {
        this.statis = r100;
    }

    public final void setStatus(MixStatusStruct r100) {
        this.status = r100;
    }

    public final void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public final void setWatchedEpisode(long r100) {
        this.watchedEpisode = r100;
    }

    public final void setWatchedItem(String r100) {
        this.watchedItem = r100;
    }
}
