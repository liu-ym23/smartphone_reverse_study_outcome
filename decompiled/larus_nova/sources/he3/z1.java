package he3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lhe3/z1;", "", "", "imprId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "groupId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "reason", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class z1 {

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("impr_id")
    private final String imprId;

    @SerializedName("reason")
    private final String reason;

    public z1() {
        this(0);
    }

    public final String a() {
        return this.groupId;
    }

    public final String b() {
        return this.imprId;
    }

    public final String c() {
        return this.reason;
    }

    public z1(int r100) {
        this.imprId = null;
        this.groupId = null;
        this.reason = null;
    }
}
