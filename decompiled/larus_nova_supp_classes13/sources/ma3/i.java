package ma3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lma3/i;", "", "", "bcmChain", "Ljava/lang/String;", "getBcmChain", "()Ljava/lang/String;", "isVirtualClick", "cjInfo", "getCjInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("bcm_chain")
    private final String bcmChain;

    @SerializedName("cj_info")
    private final String cjInfo;

    @SerializedName("is_virtual_click")
    private final String isVirtualClick;

    public i(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "bcmChain");
        this.bcmChain = r2;
        this.isVirtualClick = r3;
        this.cjInfo = r4;
    }
}
