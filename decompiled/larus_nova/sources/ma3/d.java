package ma3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lma3/d;", "Lma3/m;", "Lma3/e;", "exParams", "Lma3/e;", "getExParams", "()Lma3/e;", "", "yataVersion", "Ljava/lang/String;", "getYataVersion", "()Ljava/lang/String;", "", "", "yataProtocolInfo", "Ljava/util/Map;", "getYataProtocolInfo", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements m {

    @SerializedName("ex_params")
    private final e exParams;

    @SerializedName("yata_protocol_info")
    private final Map<String, Object> yataProtocolInfo;

    @SerializedName("yata_version")
    private final String yataVersion;

    public d(e r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "exParams");
        Intrinsics.checkNotNullParameter("1.23.7", "yataVersion");
        this.exParams = r100;
        this.yataVersion = "1.23.7";
        this.yataProtocolInfo = r101;
    }
}
