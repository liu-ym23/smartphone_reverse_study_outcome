package nh0;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayType;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\u0011R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\u0011¨\u0006-"}, d2 = {"Lnh0/m;", "Ltf0/d;", "", "dressId", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "playType", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", ce.f26396k, "()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "o", "(Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;)V", "backgroundColor", ce.f26391f, "setBackgroundColor", "(Ljava/lang/String;)V", "", "styleType", "Ljava/lang/Integer;", "m", "()Ljava/lang/Integer;", "setStyleType", "(Ljava/lang/Integer;)V", "", "forcePlay", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "setForcePlay", "(Z)V", "", "targetScore", "J", OfficeSDKRequestTag.KEY_NEW_USER, "()J", "setTargetScore", "(J)V", "sponsorAvatarUrl", "l", "setSponsorAvatarUrl", "hatUrl", ce.f26395j, "setHatUrl", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m extends tf0.d {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("dress_id")
    private final String dressId;

    @SerializedName("force_play")
    private boolean forcePlay;

    @SerializedName("hat_url")
    private String hatUrl;

    @SerializedName("play_type")
    private PlayType playType;

    @SerializedName("sponsor_avatar_url")
    private String sponsorAvatarUrl;

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private Integer styleType;

    @SerializedName("target_score")
    private long targetScore;

    @Override // tf0.d
    public final String toString() {
        return "SeatWidgetElementInfo( " + a().name() + ", forcr_play=" + this.forcePlay + ", visible = " + d() + ", userId = " + c() + ", position = " + b() + ", dressId=" + this.dressId + ", playType=" + this.playType + ", backgroundColor=" + this.backgroundColor + ", styleType=" + this.styleType + ')';
    }

    public final String g() {
        return this.backgroundColor;
    }

    public final String h() {
        return this.dressId;
    }

    public final boolean i() {
        return this.forcePlay;
    }

    public final String j() {
        return this.hatUrl;
    }

    public final PlayType k() {
        return this.playType;
    }

    public final String l() {
        return this.sponsorAvatarUrl;
    }

    public final Integer m() {
        return this.styleType;
    }

    public final long n() {
        return this.targetScore;
    }

    @Override // tf0.d
    public final boolean e(tf0.d r100) {
        if (super.e(r100) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        if (r100 != null) goto L10;
        return false;
    L10:
        if ((!Intrinsics.areEqual(m.class, r100.getClass())) == true) goto L39;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.dressId, r101.dressId) == true) goto L15;
        return false;
    L15:
        if (this.playType == r101.playType) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.styleType, r101.styleType) == true) goto L21;
        return false;
    L21:
        if (this.forcePlay == r101.forcePlay) goto L23;
        return false;
    L23:
        if (this.targetScore == r101.targetScore) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.sponsorAvatarUrl, r101.sponsorAvatarUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hatUrl, r101.hatUrl) == false) goto L38;
        return true;
    L38:
        return false;
    L39:
        return false;
    }

    public final void o(PlayType r100) {
        this.playType = r100;
    }
}
