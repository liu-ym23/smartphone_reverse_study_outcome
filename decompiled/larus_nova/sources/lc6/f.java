package lc6;

import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRB\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006)"}, d2 = {"Llc6/f;", "", "Lcom/bytedance/android/livesdk/gift/model/l1;", "giftBuffInfo", "Lcom/bytedance/android/livesdk/gift/model/l1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/gift/model/l1;", "setGiftBuffInfo", "(Lcom/bytedance/android/livesdk/gift/model/l1;)V", "", "selectPosition", "I", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "logExtra", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "giftPosition", "getGiftPosition", "setGiftPosition", "tabPosition", "getTabPosition", "setTabPosition", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.top.ObserveCurrentSelectBuffCardResponse")
public final class f {

    @SerializedName("gift_buff_info")
    private l1 giftBuffInfo;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    private long giftId;

    @SerializedName("gift_position")
    private int giftPosition;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("select_position")
    private int selectPosition;

    @SerializedName("tab_position")
    private int tabPosition;

    public f() {
        this.selectPosition = -1;
        this.giftId = 0;
    }

    public final l1 a() {
        return this.giftBuffInfo;
    }

    public final Map<String, String> b() {
        return this.logExtra;
    }
}
