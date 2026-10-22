package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lt06/t;", "", "", "", "headerSensitiveKeyList", "Ljava/util/List;", "e", "()Ljava/util/List;", "setHeaderSensitiveKeyList", "(Ljava/util/List;)V", "cookieSensitiveKeyList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCookieSensitiveKeyList", "extraSafeHostList", "d", "setExtraSafeHostList", "", "enableRemoveSessionForThirdParty", "Z", "c", "()Z", "setEnableRemoveSessionForThirdParty", "(Z)V", "enableRemoveSessionForAll", "b", "setEnableRemoveSessionForAll", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("share_cookie_sensitive_key")
    private List<String> cookieSensitiveKeyList;

    @SerializedName("share_cookie_limit_all")
    private boolean enableRemoveSessionForAll;

    @SerializedName("share_cookie_limit_third")
    private boolean enableRemoveSessionForThirdParty;

    @SerializedName("extra_safe_host_list")
    private List<String> extraSafeHostList;

    @SerializedName("share_header_sensitive_key")
    private List<String> headerSensitiveKeyList;

    public t() {
        this.headerSensitiveKeyList = null;
        this.cookieSensitiveKeyList = null;
        this.extraSafeHostList = null;
        this.enableRemoveSessionForThirdParty = false;
        this.enableRemoveSessionForAll = false;
    }

    public final List<String> a() {
        return this.cookieSensitiveKeyList;
    }

    public final boolean b() {
        return this.enableRemoveSessionForAll;
    }

    public final boolean c() {
        return this.enableRemoveSessionForThirdParty;
    }

    public final List<String> d() {
        return this.extraSafeHostList;
    }

    public final List<String> e() {
        return this.headerSensitiveKeyList;
    }
}
