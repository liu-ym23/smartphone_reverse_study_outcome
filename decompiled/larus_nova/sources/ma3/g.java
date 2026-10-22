package ma3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lma3/g;", "", "", "cjInfo", "Ljava/lang/String;", "getCjInfo", "()Ljava/lang/String;", "isAccessible", "extraInfo", "getExtraInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO)
    private final String cjInfo;

    @SerializedName("extra_info")
    private final String extraInfo;

    @SerializedName("is_accessible")
    private final String isAccessible;

    public g() {
        this.cjInfo = null;
        this.isAccessible = null;
        this.extraInfo = null;
    }
}
