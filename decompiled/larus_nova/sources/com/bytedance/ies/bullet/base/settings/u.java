package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/u;", "", "Lcom/bytedance/ies/bullet/base/settings/n;", "jsbAuthStrategySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/n;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/ies/bullet/base/settings/n;", "setJsbAuthStrategySettingConfig", "(Lcom/bytedance/ies/bullet/base/settings/n;)V", "Lcom/bytedance/ies/bullet/base/settings/p;", "lynxSignVerifyStrategyConfig", "Lcom/bytedance/ies/bullet/base/settings/p;", "b", "()Lcom/bytedance/ies/bullet/base/settings/p;", "setLynxSignVerifyStrategyConfig", "(Lcom/bytedance/ies/bullet/base/settings/p;)V", "Lcom/bytedance/ies/bullet/base/settings/t;", "secLinkConfig", "Lcom/bytedance/ies/bullet/base/settings/t;", "getSecLinkConfig", "()Lcom/bytedance/ies/bullet/base/settings/t;", "setSecLinkConfig", "(Lcom/bytedance/ies/bullet/base/settings/t;)V", "Lcom/bytedance/ies/bullet/base/settings/s;", "monitorConfig", "Lcom/bytedance/ies/bullet/base/settings/s;", "c", "()Lcom/bytedance/ies/bullet/base/settings/s;", "setMonitorConfig", "(Lcom/bytedance/ies/bullet/base/settings/s;)V", "Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "webcastConfig", "Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "d", "()Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "setWebcastConfig", "(Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("jsb_auth")
    private n jsbAuthStrategySettingConfig;

    @SerializedName("lynx_sign_verify")
    private p lynxSignVerifyStrategyConfig;

    @SerializedName("monitor_config")
    private s monitorConfig;

    @SerializedName("sec_link")
    private t secLinkConfig;

    @SerializedName("legacy_webcast")
    private LegacyWebcastConfig webcastConfig;

    public u() {
        this.jsbAuthStrategySettingConfig = new n();
        this.lynxSignVerifyStrategyConfig = new p();
        this.secLinkConfig = new t();
        this.monitorConfig = new s();
        this.webcastConfig = new LegacyWebcastConfig();
    }

    public final n a() {
        return this.jsbAuthStrategySettingConfig;
    }

    public final p b() {
        return this.lynxSignVerifyStrategyConfig;
    }

    public final s c() {
        return this.monitorConfig;
    }

    public final LegacyWebcastConfig d() {
        return this.webcastConfig;
    }
}
