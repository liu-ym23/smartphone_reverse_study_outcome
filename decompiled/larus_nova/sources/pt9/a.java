package pt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/larus/settings/opt/launch/AppLaunchFeedOptConfig;", "", "enable", "", "optJatoConfig", "Lcom/larus/settings/opt/launch/JatoConfig;", "preInitLaunchInfo", "viewWaitTimeOutDuration", "", "optimizeLandingChatActivity", "<init>", "(ZLcom/larus/settings/opt/launch/JatoConfig;ZJZ)V", "getEnable", "()Z", "getOptJatoConfig", "()Lcom/larus/settings/opt/launch/JatoConfig;", "getPreInitLaunchInfo", "getViewWaitTimeOutDuration", "()J", "getOptimizeLandingChatActivity", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("opt_jato_config")
    private final f optJatoConfig;

    @SerializedName("optimize_landing_chat_activity")
    private final boolean optimizeLandingChatActivity;

    @SerializedName("pre_init_launch_info")
    private final boolean preInitLaunchInfo;

    @SerializedName("view_wait_timeout_duration")
    private final long viewWaitTimeOutDuration;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optJatoConfig, r101.optJatoConfig) == true) goto L15;
        return false;
    L15:
        if (this.preInitLaunchInfo == r101.preInitLaunchInfo) goto L18;
        return false;
    L18:
        if (this.viewWaitTimeOutDuration == r101.viewWaitTimeOutDuration) goto L21;
        return false;
    L21:
        if (this.optimizeLandingChatActivity == r101.optimizeLandingChatActivity) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        f r103 = this.optJatoConfig;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.preInitLaunchInfo == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        long r108 = this.viewWaitTimeOutDuration;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        if (this.optimizeLandingChatActivity == true) goto L19;
        r100 = 1237;
    L19:
        return r109 + r100;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppLaunchFeedOptConfig(enable=" + this.enable + ", optJatoConfig=" + this.optJatoConfig + ", preInitLaunchInfo=" + this.preInitLaunchInfo + ", viewWaitTimeOutDuration=" + this.viewWaitTimeOutDuration + ", optimizeLandingChatActivity=" + this.optimizeLandingChatActivity + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final f b() {
        return this.optJatoConfig;
    }

    public final boolean c() {
        return this.optimizeLandingChatActivity;
    }

    public final boolean d() {
        return this.preInitLaunchInfo;
    }

    public final long e() {
        return this.viewWaitTimeOutDuration;
    }

    public a(int r100) {
        f r101 = new f(0);
        this.enable = false;
        this.optJatoConfig = r101;
        this.preInitLaunchInfo = false;
        this.viewWaitTimeOutDuration = 5000;
        this.optimizeLandingChatActivity = false;
    }
}
