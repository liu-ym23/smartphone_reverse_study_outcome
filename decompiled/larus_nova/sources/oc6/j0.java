package oc6;

import com.amap.api.col.s.ce;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b!\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bZ\u0010[R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R*\u0010&\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109RB\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010:j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u00105\u001a\u0004\bC\u00107\"\u0004\bD\u00109R$\u0010E\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0014\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010\u0018R$\u0010H\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0014\u001a\u0004\bI\u0010\u0016\"\u0004\bJ\u0010\u0018R$\u0010K\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0014\u001a\u0004\bL\u0010\u0016\"\u0004\bM\u0010\u0018R*\u0010N\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u001c\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010 R\"\u0010Q\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u00105\u001a\u0004\bR\u00107\"\u0004\bS\u00109R\"\u0010T\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u00105\u001a\u0004\bU\u00107\"\u0004\bV\u00109R*\u0010W\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u001c\u001a\u0004\bX\u0010\u001e\"\u0004\bY\u0010 ¨\u0006\\"}, d2 = {"Loc6/j0;", "", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "J", "getScore", "()J", "p", "(J)V", "level", "getLevel", "l", "thisGradeMinDiamond", "getThisGradeMinDiamond", "t", "thisGradeMaxDiamond", "getThisGradeMaxDiamond", "s", "", "gradeDescribe", "Ljava/lang/String;", "getGradeDescribe", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/String;)V", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "newImIconWithLevel", "Lpy/k;", "getNewImIconWithLevel", "()Lpy/k;", "m", "(Lpy/k;)V", "newLiveIcon", "getNewLiveIcon", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/live/base/model/user/v;", "Lcom/bytedance/android/live/api/IGradeBuffInfoKt;", "buffInfo", "Lcom/bytedance/android/live/base/model/user/v;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/user/v;", "b", "(Lcom/bytedance/android/live/base/model/user/v;)V", "", "gradeDescribeShining", "Z", "getGradeDescribeShining", "()Z", ce.f26395j, "(Z)V", "", "describeType", "I", "getDescribeType", "()I", "c", "(I)V", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "h", "(Ljava/util/Map;)V", "effectType", "getEffectType", ce.f26391f, "shortDesc", "getShortDesc", "q", "shortPreDesc", "getShortPreDesc", "r", "jumpSchema", "getJumpSchema", ce.f26396k, "effectImg", "getEffectImg", "e", "effectDurationMilli", "getEffectDurationMilli", "d", "effectPlayTimes", "getEffectPlayTimes", "f", "recentConsumeBadge", "getRecentConsumeBadge", "o", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.top.PayGradeInfo")
public final class j0 {

    @SerializedName("buff_info")
    private com.bytedance.android.live.base.model.user.v buffInfo;

    @SerializedName("describe_type")
    private int describeType;

    @SerializedName("effect_duration_milli")
    private int effectDurationMilli;

    @SerializedName("effect_img")
    private py.k effectImg;

    @SerializedName("effect_play_times")
    private int effectPlayTimes;

    @SerializedName("effect_type")
    private int effectType;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("grade_describe")
    private String gradeDescribe;

    @SerializedName("grade_describe_shining")
    private boolean gradeDescribeShining;

    @SerializedName("jump_schema")
    private String jumpSchema;

    @SerializedName("level")
    private long level;

    @SerializedName("new_im_icon_with_level")
    private py.k newImIconWithLevel;

    @SerializedName("new_live_icon")
    private py.k newLiveIcon;

    @SerializedName("recent_consume_badge")
    private py.k recentConsumeBadge;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private long score;

    @SerializedName("short_desc")
    private String shortDesc;

    @SerializedName("short_pre_desc")
    private String shortPreDesc;

    @SerializedName("this_grade_max_diamond")
    private long thisGradeMaxDiamond;

    @SerializedName("this_grade_min_diamond")
    private long thisGradeMinDiamond;

    public j0() {
    }

    public final com.bytedance.android.live.base.model.user.v a() {
        return this.buffInfo;
    }

    public final void b(com.bytedance.android.live.base.model.user.v r100) {
        this.buffInfo = r100;
    }

    public final void c(int r100) {
        this.describeType = r100;
    }

    public final void d(int r100) {
        this.effectDurationMilli = r100;
    }

    public final void e(py.k r100) {
        this.effectImg = r100;
    }

    public final void f(int r100) {
        this.effectPlayTimes = r100;
    }

    public final void g(int r100) {
        this.effectType = r100;
    }

    public final void h(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void i(String r100) {
        this.gradeDescribe = r100;
    }

    public final void j(boolean r100) {
        this.gradeDescribeShining = r100;
    }

    public final void k(String r100) {
        this.jumpSchema = r100;
    }

    public final void l(long r100) {
        this.level = r100;
    }

    public final void m(py.k r100) {
        this.newImIconWithLevel = r100;
    }

    public final void n(py.k r100) {
        this.newLiveIcon = r100;
    }

    public final void o(py.k r100) {
        this.recentConsumeBadge = r100;
    }

    public final void p(long r100) {
        this.score = r100;
    }

    public final void q(String r100) {
        this.shortDesc = r100;
    }

    public final void r(String r100) {
        this.shortPreDesc = r100;
    }

    public final void s(long r100) {
        this.thisGradeMaxDiamond = r100;
    }

    public final void t(long r100) {
        this.thisGradeMinDiamond = r100;
    }
}
