package com.bytedance.ee.bear.bitable.jsapi;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "bitable_config")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/SettingsBitableConfig;", "", "<init>", "()V", "hosts", "", "", "getHosts", "()Ljava/util/List;", "setHosts", "(Ljava/util/List;)V", "abilityConfig", "", "", "getAbilityConfig", "()Ljava/util/Map;", "setAbilityConfig", "(Ljava/util/Map;)V", "openFullScreen", "getOpenFullScreen", "()Z", "formsPathReg", "getFormsPathReg", "()Ljava/lang/String;", "formsPreloadUrl", "getFormsPreloadUrl", "baseAddConfig", "Lcom/bytedance/ee/bear/bitable/jsapi/BaseAddConfig;", "getBaseAddConfig", "()Lcom/bytedance/ee/bear/bitable/jsapi/BaseAddConfig;", "codeMsg", "Lcom/bytedance/ee/bear/bitable/jsapi/report/CodeMsg;", "getCodeMsg", "()Lcom/bytedance/ee/bear/bitable/jsapi/report/CodeMsg;", "timeoutConfig", "Lcom/bytedance/ee/bear/bitable/setting/TimeoutConfig;", "getTimeoutConfig", "()Lcom/bytedance/ee/bear/bitable/setting/TimeoutConfig;", "perfConfig", "Lcom/bytedance/ee/bear/bitable/setting/PerfConfig;", "getPerfConfig", "()Lcom/bytedance/ee/bear/bitable/setting/PerfConfig;", "baseAppBehaviorPreloadConfig", "Lcom/bytedance/ee/bear/bitable/jsapi/BaseAppBehaviorPreloadConfig;", "getBaseAppBehaviorPreloadConfig", "()Lcom/bytedance/ee/bear/bitable/jsapi/BaseAppBehaviorPreloadConfig;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingsBitableConfig {

    @SerializedName("ability_config")
    private Map<String, Boolean> abilityConfig;

    @SerializedName("base_add")
    private final tt4.a baseAddConfig;

    @SerializedName("base_app_behavior_preload")
    private final tt4.b baseAppBehaviorPreloadConfig;

    @SerializedName("code_msg")
    private final vt4.a codeMsg;

    @SerializedName("forms_path_reg")
    private final String formsPathReg;

    @SerializedName("forms_preload_url")
    private final String formsPreloadUrl;

    @SerializedName("form_domain_regs")
    private List<String> hosts;

    @SerializedName("support_full_screen")
    private final boolean openFullScreen;

    @SerializedName("pref_config")
    private final lu4.a perfConfig;

    @SerializedName("timeout_config")
    private final lu4.b timeoutConfig;

    public SettingsBitableConfig() {
        this.openFullScreen = true;
        this.timeoutConfig = new lu4.b();
        this.perfConfig = new lu4.a();
        this.baseAppBehaviorPreloadConfig = new tt4.b();
    }

    public final Map<String, Boolean> a() {
        return this.abilityConfig;
    }

    public final tt4.a b() {
        return this.baseAddConfig;
    }

    public final tt4.b c() {
        return this.baseAppBehaviorPreloadConfig;
    }

    public final vt4.a d() {
        return this.codeMsg;
    }

    public final boolean e() {
        return this.openFullScreen;
    }

    public final lu4.a f() {
        return this.perfConfig;
    }

    public final lu4.b g() {
        return this.timeoutConfig;
    }
}
