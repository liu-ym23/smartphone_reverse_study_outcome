package t06;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lt06/b0;", "Lt06/a;", "", "enableInjectJsbAuthToken", "Z", "getEnableInjectJsbAuthToken", "()Z", "setEnableInjectJsbAuthToken", "(Z)V", "", "Lt06/i;", "injectScriptList", "Ljava/util/List;", "getInjectScriptList", "()Ljava/util/List;", "setInjectScriptList", "(Ljava/util/List;)V", "handleCsp", "getHandleCsp", "setHandleCsp", "", "blackList", "getBlackList", "setBlackList", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b0 extends a {

    @SerializedName("black_list")
    private List<String> blackList;

    @SerializedName("enable_inject_jsb_auth_token")
    private boolean enableInjectJsbAuthToken;

    @SerializedName("handle_content_security_policy")
    private boolean handleCsp;

    @SerializedName("inject_script_info_list")
    private List<i> injectScriptList;

    public b0() {
        this.enableInjectJsbAuthToken = false;
        this.injectScriptList = null;
        this.handleCsp = false;
        this.blackList = null;
    }
}
