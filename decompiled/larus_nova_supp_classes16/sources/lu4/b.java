package lu4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/setting/TimeoutConfig;", "", "<init>", "()V", "fetchOptionAttsEditPermission", "", "getFetchOptionAttsEditPermission", "()J", "setFetchOptionAttsEditPermission", "(J)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("fetch_option_atts_edit_permission")
    private long fetchOptionAttsEditPermission;

    public b() {
        this.fetchOptionAttsEditPermission = 5000;
    }

    public final long a() {
        return this.fetchOptionAttsEditPermission;
    }
}
