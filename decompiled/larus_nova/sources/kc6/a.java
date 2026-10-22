package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lkc6/a;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "lastSendIds", "Ljava/util/Map;", "getLastSendIds", "()Ljava/util/Map;", sz1.a.KEY_LAST_SEND_TIME, "getLastSendTime", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.BuffCache")
public final class a {

    @SerializedName("last_send_ids")
    private final Map<String, String> lastSendIds;

    @SerializedName("last_send_time")
    private final Map<String, String> lastSendTime;

    public a(Map<String, String> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "lastSendIds");
        Intrinsics.checkNotNullParameter(r101, sz1.a.KEY_LAST_SEND_TIME);
        this.lastSendIds = r100;
        this.lastSendTime = r101;
    }
}
