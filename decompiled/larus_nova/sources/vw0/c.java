package vw0;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.recharge.panel.aio.CustomPanelMode;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.panel.aio.OneStepPayInfo;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bK\u0010LR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR,\u0010\u000f\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00060\rj\u0002`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u00060\rj\u0002`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\b¨\u0006M"}, d2 = {"Lvw0/c;", "", "", "showFastPay", "Z", "getShowFastPay", "()Z", "l", "(Z)V", "showCombinedPay", "getShowCombinedPay", ce.f26396k, "", "", "Lcom/bytedance/android/live/recharge/utils/Fen;", "recommendedCustomPrices", "Ljava/util/List;", "getRecommendedCustomPrices", "()Ljava/util/List;", ce.f26395j, "(Ljava/util/List;)V", "minCustomPrice", "J", "getMinCustomPrice", "()J", "d", "(J)V", "maxCustomPrice", "getMaxCustomPrice", "c", "Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "panelProperties", "Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "getPanelProperties", "()Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", RXScreenCaptureService.KEY_INDEX, "(Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;)V", "Lcom/bytedance/android/live/recharge/h;", "exchangeInfo", "Lcom/bytedance/android/live/recharge/h;", "getExchangeInfo", "()Lcom/bytedance/android/live/recharge/h;", "b", "(Lcom/bytedance/android/live/recharge/h;)V", "", "panelMode", "I", "getPanelMode", "()I", "h", "(I)V", "Lcom/bytedance/android/live/recharge/panel/aio/OneStepPayInfo;", "oneStepPayInfo", "Lcom/bytedance/android/live/recharge/panel/aio/OneStepPayInfo;", "getOneStepPayInfo", "()Lcom/bytedance/android/live/recharge/panel/aio/OneStepPayInfo;", "f", "(Lcom/bytedance/android/live/recharge/panel/aio/OneStepPayInfo;)V", "Lvw0/g;", "commonParams", "Lvw0/g;", "getCommonParams", "()Lvw0/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lvw0/g;)V", "", "panelExtraInfo", "Ljava/lang/String;", "getPanelExtraInfo", "()Ljava/lang/String;", ce.f26391f, "(Ljava/lang/String;)V", "needManuallyAcceptAgreement", "getNeedManuallyAcceptAgreement", "e", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.panel.CustomRechargePanelInitParams")
public final class c {

    @SerializedName("common_params")
    private g commonParams;

    @SerializedName("exchange_info")
    private com.bytedance.android.live.recharge.h exchangeInfo;

    @SerializedName("max_custom_price")
    private long maxCustomPrice;

    @SerializedName("min_custom_price")
    private long minCustomPrice;

    @SerializedName("need_manually_accept_agreement")
    private boolean needManuallyAcceptAgreement;

    @SerializedName("one_step_pay_info")
    private OneStepPayInfo oneStepPayInfo;

    @SerializedName("panel_extra_info")
    private String panelExtraInfo;

    @SerializedName("panel_mode")
    private int panelMode;

    @SerializedName("panel_properties")
    private IPanelProperties panelProperties;

    @SerializedName("recommended_custom_prices")
    private List<Long> recommendedCustomPrices;

    @SerializedName("show_combined_pay")
    private boolean showCombinedPay;

    @SerializedName("show_fast_pay")
    private boolean showFastPay;

    public c() {
        this.recommendedCustomPrices = CollectionsKt.emptyList();
        this.panelMode = CustomPanelMode.UNKNOWN.getMode();
    }

    public final void a(g r100) {
        this.commonParams = r100;
    }

    public final void b(com.bytedance.android.live.recharge.h r100) {
        this.exchangeInfo = r100;
    }

    public final void c(long r100) {
        this.maxCustomPrice = r100;
    }

    public final void d(long r100) {
        this.minCustomPrice = r100;
    }

    public final void e(boolean r100) {
        this.needManuallyAcceptAgreement = r100;
    }

    public final void f(OneStepPayInfo r100) {
        this.oneStepPayInfo = r100;
    }

    public final void g(String r100) {
        this.panelExtraInfo = r100;
    }

    public final void h(int r100) {
        this.panelMode = r100;
    }

    public final void i(IPanelProperties r100) {
        this.panelProperties = r100;
    }

    public final void j(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recommendedCustomPrices = r100;
    }

    public final void k(boolean r100) {
        this.showCombinedPay = r100;
    }

    public final void l(boolean r100) {
        this.showFastPay = r100;
    }
}
