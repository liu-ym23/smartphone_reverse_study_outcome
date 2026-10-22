package t06;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lt06/b;", "Lt06/a;", "", "enableRLIntercept", "Ljava/lang/Boolean;", "getEnableRLIntercept", "()Ljava/lang/Boolean;", "enableForestIntercept", "getEnableForestIntercept", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b extends a {

    @SerializedName("enable_forest_intercept")
    private final Boolean enableForestIntercept;

    @SerializedName("enable_rl_intercept")
    private final Boolean enableRLIntercept;

    public b() {
        Boolean r100 = Boolean.FALSE;
        this.enableRLIntercept = r100;
        this.enableForestIntercept = r100;
    }
}
