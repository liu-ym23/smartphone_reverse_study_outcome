package dm2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Ldm2/a;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "liveEnablePreviewState", "c", "setLiveEnablePreviewState", "liveEnableInLiveWidget", "b", "setLiveEnableInLiveWidget", "liveEnableCastShareChange", "a", "setLiveEnableCastShareChange", "liveLandscapeJumpFix", "d", "setLiveLandscapeJumpFix", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("live_enable_cast_share_change")
    private boolean liveEnableCastShareChange;

    @SerializedName("live_enable_in_live_widget")
    private boolean liveEnableInLiveWidget;

    @SerializedName("live_enable_landscape_preview_state")
    private boolean liveEnablePreviewState;

    @SerializedName("live_landscape_jump_fix")
    private boolean liveLandscapeJumpFix;

    public a() {
    }

    public final boolean a() {
        return this.liveEnableCastShareChange;
    }

    public final boolean b() {
        return this.liveEnableInLiveWidget;
    }

    public final boolean c() {
        return this.liveEnablePreviewState;
    }

    public final boolean d() {
        return this.liveLandscapeJumpFix;
    }
}
