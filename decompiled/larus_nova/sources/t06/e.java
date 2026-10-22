package t06;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001a"}, d2 = {"Lt06/e;", "Lt06/a;", "", "enableHandleRedirect", "Z", "getEnableHandleRedirect", "()Z", "setEnableHandleRedirect", "(Z)V", "", "", "blackList", "Ljava/util/List;", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "whiteList", "getWhiteList", "setWhiteList", "interceptExternalMainFrame", "getInterceptExternalMainFrame", "setInterceptExternalMainFrame", "enableTtnetPureMode", "getEnableTtnetPureMode", "setEnableTtnetPureMode", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class e extends a {

    @SerializedName("black_list")
    private List<String> blackList;

    @SerializedName("enable_handle_redirect")
    private boolean enableHandleRedirect;

    @SerializedName("enable_ttnet_pure_mode")
    private boolean enableTtnetPureMode;

    @SerializedName("intercept_external_main_frame")
    private boolean interceptExternalMainFrame;

    @SerializedName("white_list")
    private List<String> whiteList;

    public e() {
        this.enableHandleRedirect = false;
        this.blackList = null;
        this.whiteList = null;
        this.interceptExternalMainFrame = false;
        this.enableTtnetPureMode = true;
    }
}
