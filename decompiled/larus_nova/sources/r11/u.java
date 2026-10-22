package r11;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.revenue.common.k0;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010&\u001a\u00020%8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lr11/u;", "", "", "inviterTitle", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setInviterTitle", "(Ljava/lang/String;)V", "inviterSubtitle", "e", "setInviterSubtitle", "inviterExplainImage", "d", "setInviterExplainImage", "receiverTitle", RXScreenCaptureService.KEY_INDEX, "setReceiverTitle", "receiverSubtitle", "h", "setReceiverSubtitle", "receiverExplainImage", ce.f26391f, "setReceiverExplainImage", "", "commentIntroEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setCommentIntroEnable", "(Z)V", "commentAudienceStatusSync", "getCommentAudienceStatusSync", "setCommentAudienceStatusSync", "commentIntroLynxUrl", "b", "setCommentIntroLynxUrl", "", "commentIntroVersion", "I", "c", "()I", "setCommentIntroVersion", "(I)V", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class u {

    @SerializedName("intercom_comment_audience_status_sync")
    private boolean commentAudienceStatusSync;

    @SerializedName("intercom_comment_intro_enable")
    private boolean commentIntroEnable;

    @SerializedName("intercom_comment_intro_lynx_url")
    private String commentIntroLynxUrl;

    @SerializedName("intercom_comment_intro_version")
    private int commentIntroVersion;

    @SerializedName("inviter_explain_image")
    private String inviterExplainImage;

    @SerializedName("inviter_subtitle")
    private String inviterSubtitle;

    @SerializedName("inviter_title")
    private String inviterTitle;

    @SerializedName("receiver_explain_image")
    private String receiverExplainImage;

    @SerializedName("receiver_subtitle")
    private String receiverSubtitle;

    @SerializedName("receiver_title")
    private String receiverTitle;

    public u() {
        this.inviterTitle = "";
        this.inviterSubtitle = "";
        StringBuilder r100 = new StringBuilder("https://");
        String r101 = k0.f90841a;
        String r102 = k0.f90841a;
        r100.append(r102);
        r100.append("/obj/live-android/ttlive_inter_comment_caption.png");
        this.inviterExplainImage = r100.toString();
        this.receiverTitle = "";
        this.receiverSubtitle = "";
        this.receiverExplainImage = "https://" + r102 + "/obj/live-android/ttlive_inter_comment_caption.png";
        this.commentIntroEnable = true;
        this.commentIntroLynxUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fcommunity_intercom_lynx_douyin%2Fpages%2Frule_intro%2Ftemplate.js&gravity=bottom&type=popup&rate_height=365&radius=8&pull_down_close=1&pull_down_indicator_not_show=1";
        this.commentIntroVersion = 1;
    }

    public boolean a() {
        return this.commentIntroEnable;
    }

    public String b() {
        return this.commentIntroLynxUrl;
    }

    public int c() {
        return this.commentIntroVersion;
    }

    public String d() {
        return this.inviterExplainImage;
    }

    public String e() {
        return this.inviterSubtitle;
    }

    public String f() {
        return this.inviterTitle;
    }

    public String g() {
        return this.receiverExplainImage;
    }

    public String h() {
        return this.receiverSubtitle;
    }

    public String i() {
        return this.receiverTitle;
    }
}
