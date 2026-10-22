package dl7;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\u0018\u00002\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\bL\u0010MR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R$\u0010.\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR$\u00101\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R$\u0010@\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR$\u0010C\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001e\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R$\u0010F\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u001e\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R$\u0010I\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u000b\u001a\u0004\bJ\u0010\r\"\u0004\bK\u0010\u000f¨\u0006N"}, d2 = {"Ldl7/f;", "", "", "enable", "Ljava/lang/Boolean;", ce.f26391f, "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "", "iconUrl", "Ljava/lang/String;", ce.f26396k, "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "textColor", "p", "setTextColor", "hasBorder", "Z", ce.f26395j, "()Z", "setHasBorder", "(Z)V", "borderColor", "c", "setBorderColor", "", "borderWidth", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setBorderWidth", "(Ljava/lang/Integer;)V", "", "bgColor", "Ljava/util/List;", "b", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "Ldl7/e;", "contents", "e", "setContents", "position", "l", "setPosition", "schema", OfficeSDKRequestTag.KEY_NEW_USER, "setSchema", "requireLogin", "m", "setRequireLogin", "targetTs", "I", "o", "()I", "setTargetTs", "(I)V", "ackedTs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "q", "extra", "getExtra", "setExtra", "exitDuration", "h", "setExitDuration", "fullDisplayDuration", RXScreenCaptureService.KEY_INDEX, "setFullDisplayDuration", "crossDomainId", "f", "setCrossDomainId", "<init>", "()V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f469134d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f469135a;

    @SerializedName("acked_ts")
    private volatile int ackedTs;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f469136b;

    @SerializedName("bg_color")
    private List<String> bgColor;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("border_width")
    private Integer borderWidth;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f469137c;

    @SerializedName("contents")
    private List<e> contents;

    @SerializedName("cross_domain_id")
    private String crossDomainId;

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("exit_duration")
    private Integer exitDuration;

    @SerializedName("extra")
    private String extra;

    @SerializedName("full_display_duration")
    private Integer fullDisplayDuration;

    @SerializedName("has_border")
    private boolean hasBorder;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("position")
    private String position;

    @SerializedName("require_login")
    private Boolean requireLogin;

    @SerializedName("schema")
    private String schema;

    @SerializedName("target_ts")
    private int targetTs;

    @SerializedName("text_color")
    private String textColor;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final String toString() {
        return "PendantModel(enable=" + this.enable + ", iconUrl=" + this.iconUrl + ", textColor=" + this.textColor + ", hasBorder=" + this.hasBorder + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", bgColor=" + this.bgColor + ", contents=" + this.contents + ", position=" + this.position + ", schema=" + this.schema + ", requireLogin=" + this.requireLogin + ", targetTs=" + this.targetTs + ", ackedTs=" + this.ackedTs + ", extra=" + this.extra + ", exitDuration=" + this.exitDuration + ", fullDisplayDuration=" + this.fullDisplayDuration + ", crossToken=" + this.f469136b + ", sceneId=" + this.f469135a + ')';
    }

    public final int a() {
        return this.ackedTs;
    }

    public final List<String> b() {
        return this.bgColor;
    }

    public final String c() {
        return this.borderColor;
    }

    public final Integer d() {
        return this.borderWidth;
    }

    public final List<e> e() {
        return this.contents;
    }

    public final String f() {
        return this.crossDomainId;
    }

    public final Boolean g() {
        return this.enable;
    }

    public final Integer h() {
        return this.exitDuration;
    }

    public final Integer i() {
        return this.fullDisplayDuration;
    }

    public final boolean j() {
        return this.hasBorder;
    }

    public final String k() {
        return this.iconUrl;
    }

    public final String l() {
        return this.position;
    }

    public final Boolean m() {
        return this.requireLogin;
    }

    public final String n() {
        return this.schema;
    }

    public final int o() {
        return this.targetTs;
    }

    public final String p() {
        return this.textColor;
    }

    public final void q(int r100) {
        this.ackedTs = r100;
    }
}
