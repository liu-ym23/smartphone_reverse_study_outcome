package com.bytedance.ee.bear.bitable.superagent;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "bitable_mobile_ai_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableMobileAIConfig;", "", "<init>", "()V", "disableWidgetSender", "", "getDisableWidgetSender", "()Z", "setDisableWidgetSender", "(Z)V", "disableWidgetRender", "getDisableWidgetRender", "setDisableWidgetRender", "onlyLowDevice", "getOnlyLowDevice", "setOnlyLowDevice", "disableFabCarouselAnim", "getDisableFabCarouselAnim", "setDisableFabCarouselAnim", "disableLandingGlowAnim", "getDisableLandingGlowAnim", "setDisableLandingGlowAnim", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMobileAIConfig {

    @SerializedName("disable_fab_carousel_anim")
    private boolean disableFabCarouselAnim;

    @SerializedName("disable_landing_glow_anim")
    private boolean disableLandingGlowAnim;

    @SerializedName("disable_widget_render")
    private boolean disableWidgetRender;

    @SerializedName("disable_widget_sender")
    private boolean disableWidgetSender;

    @SerializedName("only_low_device")
    private boolean onlyLowDevice;

    public BitableMobileAIConfig() {
    }

    public final boolean a() {
        return this.disableFabCarouselAnim;
    }

    public final boolean b() {
        return this.disableLandingGlowAnim;
    }

    public final boolean c() {
        return this.disableWidgetRender;
    }

    public final boolean d() {
        return this.disableWidgetSender;
    }

    public final boolean e() {
        return this.onlyLowDevice;
    }
}
