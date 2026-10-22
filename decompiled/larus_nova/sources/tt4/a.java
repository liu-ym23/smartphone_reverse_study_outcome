package tt4;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/BaseAddConfig;", "", "<init>", "()V", "submitFailedTips", "", "", "getSubmitFailedTips", "()Ljava/util/Map;", "setSubmitFailedTips", "(Ljava/util/Map;)V", "loadFailedTips", "getLoadFailedTips", "setLoadFailedTips", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("load_failed_tips")
    private Map<String, String> loadFailedTips;

    @SerializedName("submit_failed_tips")
    private Map<String, String> submitFailedTips;

    public a() {
    }

    public final Map<String, String> a() {
        return this.loadFailedTips;
    }

    public final Map<String, String> b() {
        return this.submitFailedTips;
    }
}
