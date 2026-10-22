package oc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Loc6/i0;", "", "", "statusCode", "I", "getStatusCode", "()I", "", "", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftAIAgentOperationResult")
public final class i0 {

    @SerializedName("data")
    private final List<String> data;

    @SerializedName("error_message")
    private final String errorMessage;

    @SerializedName("status_code")
    private final int statusCode;

    public i0() {
        this(0, null, null, 7);
    }

    public i0(int r100, List r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.statusCode = r100;
        this.data = r101;
        this.errorMessage = r102;
    }
}
