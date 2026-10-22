package lra;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Llra/c;", "", "", "", "adAutoJumpAllowList", "Ljava/util/List;", "getAdAutoJumpAllowList", "()Ljava/util/List;", "adClickAutoJumpAllowList", "getAdClickAutoJumpAllowList", "doNotHandleUrl", "getDoNotHandleUrl", "", "showInterceptPop", "I", "getShowInterceptPop", "()I", "enableDeeplinkSuccessOpt", "getEnableDeeplinkSuccessOpt", "<init>", "()V", "applinksdk_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("ad_auto_jump_allow_list")
    private final List<String> adAutoJumpAllowList;

    @SerializedName("ad_click_auto_jump_allow_list")
    private final List<String> adClickAutoJumpAllowList;

    @SerializedName("do_not_handle_url")
    private final List<String> doNotHandleUrl;

    @SerializedName("enable_deeplink_success_opt")
    private final int enableDeeplinkSuccessOpt;

    @SerializedName("show_intercept_pop")
    private final int showInterceptPop;

    public c() {
        this.showInterceptPop = 1;
    }

    public final List<String> a() {
        return this.adAutoJumpAllowList;
    }

    public final List<String> b() {
        return this.adClickAutoJumpAllowList;
    }

    public final List<String> c() {
        return this.doNotHandleUrl;
    }

    public final int d() {
        return this.enableDeeplinkSuccessOpt;
    }
}
