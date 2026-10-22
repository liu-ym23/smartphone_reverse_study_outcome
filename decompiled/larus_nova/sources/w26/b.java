package w26;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lw26/b;", "", "", "settingsVersion", "I", "getSettingsVersion", "()I", "setSettingsVersion", "(I)V", "", "", "closeAuthUrls", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setCloseAuthUrls", "(Ljava/util/List;)V", "", "isCloseAllAuth", "Z", "b", "()Z", "setCloseAllAuth", "(Z)V", "enableConfigUpdate", "getEnableConfigUpdate", "setEnableConfigUpdate", "enableAuthConfigRequest", "getEnableAuthConfigRequest", "setEnableAuthConfigRequest", "", "authRequestInterval", "J", "getAuthRequestInterval", "()J", "setAuthRequestInterval", "(J)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("auto_request_internal")
    private long authRequestInterval;

    @SerializedName("close_auth_urls")
    private List<String> closeAuthUrls;

    @SerializedName("open_auto_config_request")
    private boolean enableAuthConfigRequest;

    @SerializedName("open_config_update")
    private boolean enableConfigUpdate;

    @SerializedName("is_close_auth")
    private boolean isCloseAllAuth;

    @SerializedName("settings_version")
    private int settingsVersion;

    public b() {
        this.closeAuthUrls = CollectionsKt.listOf(new String[]{"^https://i\\.snssdk\\.com/magic/eco/runtime/release", "^https://i\\.snssdk\\.com/magic/eco/runtime/beta", "^https://aweme\\.snssdk\\.com/magic/eco/runtime/release", "^https://aweme\\.snssdk\\.com/magic/eco/runtime/beta", "^https://hotsoon\\.snssdk\\.com/magic/eco/runtime/release", "^https://hotsoon\\.snssdk\\.com/magic/eco/runtime/beta", "^https://reading\\.snssdk\\.com/magic/eco/runtime/release", "^https://reading\\.snssdk\\.com/magic/eco/runtime/beta", "^https://lf-sourcecdn-tos\\.bytegecko\\.com/obj/byte-gurd-source", "^https://lf-dy-sourcecdn-tos\\.bytegecko\\.com/obj/byte-gurd-source", "^https://test-aweme\\.snssdk\\.com/falcon/jsb_tester_web/dmt"});
        this.enableAuthConfigRequest = true;
        this.authRequestInterval = TimeUtils.SECONDS_PER_HOUR;
    }

    public final List<String> a() {
        return this.closeAuthUrls;
    }

    public final boolean b() {
        return this.isCloseAllAuth;
    }
}
