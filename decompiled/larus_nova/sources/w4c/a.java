package w4c;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointKeyMaxCacheV2;", "", "<init>", "()V", "imReadMaxCacheSize", "", "getImReadMaxCacheSize", "()I", "setImReadMaxCacheSize", "(I)V", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("PointKey_IM_MSG_FILE_READ")
    private int imReadMaxCacheSize;

    public a() {
        this.imReadMaxCacheSize = 300;
    }

    public final int a() {
        return this.imReadMaxCacheSize;
    }
}
