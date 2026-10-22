package dy1;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Ldy1/a;", "", "", "lynxUrl", "Ljava/lang/String;", "getLynxUrl", "()Ljava/lang/String;", "setLynxUrl", "(Ljava/lang/String;)V", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private String lynxUrl;

    public a() {
        this.lynxUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_interactive_gift_lynx_saas%2Fpages%2Factivity_combo_tray%2Ftemplate.js";
    }

    public final boolean a() {
        return this.enable;
    }
}
