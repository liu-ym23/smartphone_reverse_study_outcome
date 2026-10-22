package yu9;

import com.google.gson.annotations.SerializedName;
import com.larus.network.HttpConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/settings/provider/lark/LarkTokenRequestConfig;", "", "<init>", "()V", "hostPostfix", "", "", "getHostPostfix", "()Ljava/util/List;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("host_postfix")
    private final List<String> hostPostfix;

    public a() {
        HttpConst.f359979a.getClass();
        this.hostPostfix = CollectionsKt.listOf(HttpConst.f359985d);
    }
}
