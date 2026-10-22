package ol;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.live.b;
import com.bytedance.android.ec.model.playback.AuthorInfo;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackExtraData;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bY\u0010ZR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u001c\u0010*\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\n\u001a\u0004\b8\u0010\fR\u001c\u00109\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'R\u001a\u0010<\u001a\u00020;8\u0006X\u0087D¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u0002018\u0006X\u0087D¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010%\u001a\u0004\bJ\u0010'R\u001c\u0010L\u001a\u0004\u0018\u00010K8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010%\u001a\u0004\bQ\u0010'R\u001a\u0010R\u001a\u00020;8\u0006X\u0087D¢\u0006\f\n\u0004\bR\u0010=\u001a\u0004\bS\u0010?R\u001c\u0010T\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010%\u001a\u0004\bU\u0010'R\"\u0010W\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bW\u0010\n\u001a\u0004\bX\u0010\f¨\u0006["}, d2 = {"Lol/a;", "Lcom/bytedance/android/ec/model/g;", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "promotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "", "Lcom/bytedance/android/ec/model/response/ECPromotionCampaign;", "campaignList", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "videoInfo", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "s", "()Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "videoInfoV2", "Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "t", "()Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "videoMdrInfo", "u", "Lcom/bytedance/android/ec/model/ECUrlModel;", "backgroundPic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackExtraData;", "extra", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackExtraData;", "f", "()Lcom/bytedance/android/ec/model/playback/ExplainPlaybackExtraData;", "", "roomId", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "enterRoomSchema", "e", "liveHintText", ce.f26391f, "", "liveStatus", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "", "showProductDetailPage", "Ljava/lang/Integer;", "q", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "commentaryTags", "d", "roomSchema", OfficeSDKRequestTag.KEY_NEW_USER, "", "serverTime", "J", "getServerTime", "()J", "commentaryType", "I", "getCommentaryType", "()I", "Lcom/bytedance/android/ec/model/playback/AuthorInfo;", "authorInfo", "Lcom/bytedance/android/ec/model/playback/AuthorInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/playback/AuthorInfo;", "roomTitle", "p", "Lcom/bytedance/android/ec/model/playback/ReplayCards;", "replayCards", "Lcom/bytedance/android/ec/model/playback/ReplayCards;", ce.f26395j, "()Lcom/bytedance/android/ec/model/playback/ReplayCards;", "replayViewCnt", ce.f26396k, "replayViewNum", "l", "roomSchemaV2", "o", "Lcom/bytedance/android/ec/model/live/b;", "topBanner", "r", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a extends g {

    @SerializedName("author_info")
    private final AuthorInfo authorInfo;

    @SerializedName("bg_pic")
    private final ECUrlModel backgroundPic;

    @SerializedName("campaigns")
    private final List<ECPromotionCampaign> campaignList;

    @SerializedName("commentary_tags")
    private final List<ECRitTag> commentaryTags;

    @SerializedName("commentary_type")
    private final int commentaryType;

    @SerializedName("schema")
    private final String enterRoomSchema;

    @SerializedName("extra")
    private final ExplainPlaybackExtraData extra;

    @SerializedName("live_hint_text")
    private final String liveHintText;

    @SerializedName("live_status")
    private final Boolean liveStatus;

    @SerializedName("promotion")
    private final ECPromotion promotion;

    @SerializedName("replay_cards")
    private final ReplayCards replayCards;

    @SerializedName("replay_view_cnt")
    private final String replayViewCnt;

    @SerializedName("replay_view_num")
    private final long replayViewNum;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("room_schema")
    private final String roomSchema;

    @SerializedName("room_schema_v2")
    private final String roomSchemaV2;

    @SerializedName("room_title")
    private final String roomTitle;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("show_product_detail_page")
    private final Integer showProductDetailPage;

    @SerializedName("top_banner")
    private final List<b> topBanner;

    @SerializedName("video")
    private final ExplainPlaybackVideoInfo videoInfo;

    @SerializedName("video_v2")
    private final ECReplayVideo videoInfoV2;

    @SerializedName("video_mbr")
    private final ECReplayVideo videoMdrInfo;

    /* JADX INFO: renamed from: ol.a$a, reason: collision with other inner class name */
    public static final class C7065a {
    }

    static {
    }

    public a() {
        this.commentaryType = -1;
    }

    public final AuthorInfo a() {
        return this.authorInfo;
    }

    public final ECUrlModel b() {
        return this.backgroundPic;
    }

    public final List<ECPromotionCampaign> c() {
        return this.campaignList;
    }

    public final List<ECRitTag> d() {
        return this.commentaryTags;
    }

    public final String e() {
        return this.enterRoomSchema;
    }

    public final ExplainPlaybackExtraData f() {
        return this.extra;
    }

    public final String g() {
        return this.liveHintText;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final Boolean h() {
        return this.liveStatus;
    }

    public final ECPromotion i() {
        return this.promotion;
    }

    public final ReplayCards j() {
        return this.replayCards;
    }

    public final String k() {
        return this.replayViewCnt;
    }

    public final long l() {
        return this.replayViewNum;
    }

    public final String m() {
        return this.roomId;
    }

    public final String n() {
        return this.roomSchema;
    }

    public final String o() {
        return this.roomSchemaV2;
    }

    public final String p() {
        return this.roomTitle;
    }

    public final Integer q() {
        return this.showProductDetailPage;
    }

    public final List<b> r() {
        return this.topBanner;
    }

    public final ExplainPlaybackVideoInfo s() {
        return this.videoInfo;
    }

    public final ECReplayVideo t() {
        return this.videoInfoV2;
    }

    public final ECReplayVideo u() {
        return this.videoMdrInfo;
    }
}
