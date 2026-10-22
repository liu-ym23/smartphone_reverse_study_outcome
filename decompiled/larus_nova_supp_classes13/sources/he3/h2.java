package he3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lhe3/h2;", "", "Lhe3/i2;", "qcpxInfo", "Lhe3/i2;", "b", "()Lhe3/i2;", "", "Lhe3/d1;", "applyPrizeInfoList", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h2 {

    @SerializedName("apply_prize_info_list")
    private final List<d1> applyPrizeInfoList;

    @SerializedName("qcpx_info")
    private final i2 qcpxInfo;

    public h2() {
    }

    public final List<d1> a() {
        return this.applyPrizeInfoList;
    }

    public final i2 b() {
        return this.qcpxInfo;
    }
}
