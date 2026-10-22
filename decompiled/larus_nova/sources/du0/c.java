package du0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Ldu0/c;", "", "", "liveVipIconAudienceOptEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setLiveVipIconAudienceOptEnable", "(Z)V", "", "vipIconUnjoined", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setVipIconUnjoined", "(Ljava/lang/String;)V", "vipIconInActive", "b", "setVipIconInActive", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("live_vip_icon_audience_opt_enable")
    private boolean liveVipIconAudienceOptEnable;

    @SerializedName("vip_icon_inactive")
    private String vipIconInActive;

    @SerializedName("vip_icon_unjoined")
    private String vipIconUnjoined;

    public c() {
        this.vipIconUnjoined = "https://p6-webcast-material.byteimg.com/tos-cn-i-nvpupgq6uj/e66b2a9904504be5b141d4bf1effa0e3~tplv-nvpupgq6uj-tiny.png";
        this.vipIconInActive = "https://p6-webcast-material.byteimg.com/tos-cn-i-nvpupgq6uj/b812d782141f47ed965fd669073d5fac~tplv-nvpupgq6uj-tiny.png";
    }

    public final boolean a() {
        return this.liveVipIconAudienceOptEnable;
    }

    public final String b() {
        return this.vipIconInActive;
    }

    public final String c() {
        return this.vipIconUnjoined;
    }
}
