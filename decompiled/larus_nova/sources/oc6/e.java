package oc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b*\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\"\u00107\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011¨\u0006<"}, d2 = {"Loc6/e;", "", "", "exchangeBalance", "I", "getExchangeBalance", "()I", "setExchangeBalance", "(I)V", "exchangeDiamond", "getExchangeDiamond", "setExchangeDiamond", "", "isFirstExchange", "Z", "()Z", "setFirstExchange", "(Z)V", "", "flameTitle", "Ljava/lang/String;", "getFlameTitle", "()Ljava/lang/String;", "setFlameTitle", "(Ljava/lang/String;)V", "rebateLimit", "getRebateLimit", "setRebateLimit", "giftAmount", "getGiftAmount", "setGiftAmount", "leftAmount", "getLeftAmount", "setLeftAmount", "maxCash", "getMaxCash", "setMaxCash", "maxGoldCount", "getMaxGoldCount", "setMaxGoldCount", "goldBalance", "getGoldBalance", "setGoldBalance", "hideCombineExchange", "getHideCombineExchange", "c", "hideCashExchange", "getHideCashExchange", "b", "giftPanelType", "getGiftPanelType", "setGiftPanelType", "disable", "getDisable", "setDisable", "enableShowExchange", "getEnableShowExchange", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.top.ExchangeInfo")
public final class e {

    @SerializedName("disable")
    private boolean disable;

    @SerializedName("enable_show_exchange")
    private boolean enableShowExchange;

    @SerializedName("exchange_balance")
    private int exchangeBalance;

    @SerializedName("exchange_diamond")
    private int exchangeDiamond;

    @SerializedName("flame_title")
    private String flameTitle;

    @SerializedName("gift_amount")
    private int giftAmount;

    @SerializedName("gift_panel_type")
    private int giftPanelType;

    @SerializedName("gold_balance")
    private int goldBalance;

    @SerializedName("hide_cash_exchange")
    private boolean hideCashExchange;

    @SerializedName("hide_combine_exchange")
    private boolean hideCombineExchange;

    @SerializedName("is_first_exchange")
    private boolean isFirstExchange;

    @SerializedName("left_amount")
    private int leftAmount;

    @SerializedName("max_cash")
    private int maxCash;

    @SerializedName("max_gold_count")
    private int maxGoldCount;

    @SerializedName("rebate_limit")
    private int rebateLimit;

    public e() {
    }

    public final void a(boolean r100) {
        this.enableShowExchange = r100;
    }

    public final void b(boolean r100) {
        this.hideCashExchange = r100;
    }

    public final void c(boolean r100) {
        this.hideCombineExchange = r100;
    }
}
