package ma3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lma3/j;", "", "", "yataParam", "Ljava/lang/String;", "getYataParam", "()Ljava/lang/String;", "originYataParam", "getOriginYataParam", "", "uplinkTime", "Ljava/lang/Long;", "getUplinkTime", "()Ljava/lang/Long;", "Lma3/i;", "extra", "Lma3/i;", "getExtra", "()Lma3/i;", "", "yataProtocolInfo", "Ljava/util/Map;", "getYataProtocolInfo", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("extra")
    private final i extra;

    @SerializedName("origin_yata_param")
    private final String originYataParam;

    @SerializedName("uplink_time")
    private final Long uplinkTime;

    @SerializedName("yata_param")
    private final String yataParam;

    @SerializedName("yata_protocol_info")
    private final Map<String, Object> yataProtocolInfo;

    public j() {
        this("", "", 0L, null, null);
    }

    public j(String r100, String r101, Long r102, i r103, Map<String, ? extends Object> r104) {
        this.yataParam = r100;
        this.originYataParam = r101;
        this.uplinkTime = r102;
        this.extra = r103;
        this.yataProtocolInfo = r104;
    }
}
