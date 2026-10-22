package kc6;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001R\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016R\u001a\u0010;\u001a\u00020:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010?\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010\u0007R\u001a\u0010B\u001a\u00020A8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bB\u0010DR\u001a\u0010E\u001a\u00020A8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010C\u001a\u0004\bF\u0010DR \u0010I\u001a\b\u0012\u0004\u0012\u00020H0G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\"\u0010O\u001a\n\u0018\u00010Mj\u0004\u0018\u0001`N8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\"\u0010S\u001a\n\u0018\u00010Mj\u0004\u0018\u0001`N8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bT\u0010R¨\u0006U"}, d2 = {"Lkc6/w;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "availableDiamonds", "J", "getAvailableDiamonds", "()J", "Lkc6/x;", "locationInfo", "Lkc6/x;", "getLocationInfo", "()Lkc6/x;", "", "pageType", "I", "getPageType", "()I", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/gift/model/x2;", "pageInfo", "Lcom/bytedance/android/livesdk/gift/model/x2;", "getPageInfo", "()Lcom/bytedance/android/livesdk/gift/model/x2;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "currentReceiver", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getCurrentReceiver", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "currentReceiverType", "getCurrentReceiverType", "Lkc6/a;", "buffCache", "Lkc6/a;", "getBuffCache", "()Lkc6/a;", "Lcom/bytedance/android/livesdk/gift/model/g0;", "extraInfo", "Lcom/bytedance/android/livesdk/gift/model/g0;", "getExtraInfo", "()Lcom/bytedance/android/livesdk/gift/model/g0;", "Loc6/j0;", "payGradeInfo", "Loc6/j0;", "getPayGradeInfo", "()Loc6/j0;", "Lkc6/o;", "dialogInfo", "Lkc6/o;", "getDialogInfo", "()Lkc6/o;", "giftListRequestId", "getGiftListRequestId", "Lkc6/f;", "diyCache", "Lkc6/f;", "getDiyCache", "()Lkc6/f;", "startMillis", "getStartMillis", "", "isSupportRecipientEntrance", "Z", "()Z", "showRecipientEntrance", "getShowRecipientEntrance", "", "Llc6/c;", "receiverList", "Ljava/util/List;", "getReceiverList", "()Ljava/util/List;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "receiverBackgroundImg", "Lpy/k;", "getReceiverBackgroundImg", "()Lpy/k;", "backgroundImage", "getBackgroundImage", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.InitialPanelInfo")
public final class w {

    @SerializedName("available_diamonds")
    private final long availableDiamonds;

    @SerializedName("background_image")
    private final py.k backgroundImage;

    @SerializedName("buff_cache")
    private final a buffCache;

    @SerializedName("current_receiver")
    private final IBaseUser currentReceiver;

    @SerializedName("current_receiver_type")
    private final int currentReceiverType;

    @SerializedName("dialog_info")
    private final o dialogInfo;

    @SerializedName("diy_cache")
    private final f diyCache;

    @SerializedName("extra_info")
    private final com.bytedance.android.livesdk.gift.model.g0 extraInfo;

    @SerializedName("gift_list_request_id")
    private final String giftListRequestId;

    @SerializedName("is_support_recipient_entrance")
    private final boolean isSupportRecipientEntrance;

    @SerializedName("location_info")
    private final x locationInfo;

    @SerializedName("page_info")
    private final x2 pageInfo;

    @SerializedName("page_name")
    private final String pageName;

    @SerializedName("page_type")
    private final int pageType;

    @SerializedName("pay_grade")
    private final oc6.j0 payGradeInfo;

    @SerializedName("receiver_background_img")
    private final py.k receiverBackgroundImg;

    @SerializedName("receiver_list")
    private final List<lc6.c> receiverList;

    @SerializedName("show_recipient_entrance")
    private final boolean showRecipientEntrance;

    @SerializedName("start_millis")
    private final long startMillis;

    public w() {
        throw null;
    }
}
