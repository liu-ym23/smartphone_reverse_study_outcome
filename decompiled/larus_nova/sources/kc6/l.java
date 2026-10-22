package kc6;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001R\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010$\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\u0012¨\u0006'"}, d2 = {"Lkc6/l;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "buffGiftId", "J", "getBuffGiftId", "()J", "", "buffLevel", "I", "getBuffLevel", "()I", "setBuffLevel", "(I)V", "buffDiamondCount", "getBuffDiamondCount", "setBuffDiamondCount", "(J)V", "defaultChose", "getDefaultChose", "setDefaultChose", "", "lockToast", "Ljava/lang/String;", "getLockToast", "()Ljava/lang/String;", "setLockToast", "(Ljava/lang/String;)V", "Lkc6/k;", "lockInfo", "Lkc6/k;", "getLockInfo", "()Lkc6/k;", "setLockInfo", "(Lkc6/k;)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftBuffModel")
public final class l {

    @SerializedName("buff_diamond_count")
    private long buffDiamondCount;

    @SerializedName("buff_gift_id")
    private final long buffGiftId;

    @SerializedName("buff_level")
    private int buffLevel;

    @SerializedName("default_chose_action")
    private long defaultChose;

    @SerializedName("buff_lock_info")
    private k lockInfo;

    @SerializedName("lock_toast")
    private String lockToast;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;
}
