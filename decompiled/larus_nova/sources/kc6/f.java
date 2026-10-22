package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR6\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR6\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lkc6/f;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", sz1.a.KEY_LAST_SEND_TIME, "Ljava/util/Map;", "getLastSendTime", "()Ljava/util/Map;", "Lkc6/b;", "diyToolbarCache", "getDiyToolbarCache", "lastSendIds", "getLastSendIds", "lastSendCardName", "getLastSendCardName", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.DIYCache")
public final class f {

    @SerializedName("diy_toolbar_cache")
    private final Map<String, b> diyToolbarCache;

    @SerializedName("last_send_card_name")
    private final Map<String, String> lastSendCardName;

    @SerializedName("last_send_ids")
    private final Map<String, String> lastSendIds;

    @SerializedName("last_send_time")
    private final Map<String, String> lastSendTime;

    public f(Map<String, String> r100, Map<String, b> r101, Map<String, String> r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, sz1.a.KEY_LAST_SEND_TIME);
        Intrinsics.checkNotNullParameter(r101, "diyToolbarCache");
        Intrinsics.checkNotNullParameter(r102, "lastSendIds");
        Intrinsics.checkNotNullParameter(r103, "lastSendCardName");
        this.lastSendTime = r100;
        this.diyToolbarCache = r101;
        this.lastSendIds = r102;
        this.lastSendCardName = r103;
    }
}
