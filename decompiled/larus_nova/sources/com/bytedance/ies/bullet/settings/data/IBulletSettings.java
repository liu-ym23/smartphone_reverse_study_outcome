package com.bytedance.ies.bullet.settings.data;

import com.bytedance.ies.bullet.base.settings.AnnieXRedirectRules;
import com.bytedance.ies.bullet.base.settings.a;
import com.bytedance.ies.bullet.base.settings.e;
import com.bytedance.ies.bullet.base.settings.g;
import com.bytedance.ies.bullet.base.settings.h;
import com.bytedance.ies.bullet.base.settings.j;
import com.bytedance.ies.bullet.base.settings.l;
import com.bytedance.ies.bullet.base.settings.r;
import com.bytedance.ies.bullet.base.settings.u;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.bytedance.pia.core.setting.b;
import kotlin.Metadata;
import t16.d;
import t16.f;
import w26.i;

/* JADX INFO: loaded from: classes19.dex */
@Settings(migrations = {}, settingsId = "Bullet", storageKey = "bullet")
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'J\n\u0010\t\u001a\u0004\u0018\u00010\bH'J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH'J\n\u0010\r\u001a\u0004\u0018\u00010\fH'J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H'J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H'J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H'J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH'J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH'J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH'J\n\u0010!\u001a\u0004\u0018\u00010 H'J\n\u0010#\u001a\u0004\u0018\u00010\"H'J\n\u0010%\u001a\u0004\u0018\u00010$H'J\n\u0010'\u001a\u0004\u0018\u00010&H'¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "Lw26/j;", "getResourceLoaderConfig", "Lw26/e;", "getCommonConfig", "Lw26/h;", "getMonitorConfig", "Lw26/i;", "getPineappleConfig", "Lcom/bytedance/ies/bullet/base/settings/r;", "getMixConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "getSccSettingsConfig", "Lcom/bytedance/ies/bullet/base/settings/u;", "getSecuritySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/l;", "getForestSettingConfig", "Lcom/bytedance/pia/core/setting/b;", "getPIAConfig", "Lcom/bytedance/ies/bullet/base/settings/d;", "getAnnieXRedirectConfig", "Lt16/d;", "getAnnieXPredefineConfig", "Lt16/f;", "getAnnieXPredefineWasmConfig", "Lcom/bytedance/ies/bullet/base/settings/h;", "getArgusSecuritySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/f;", "getArgusRecoveryConfig", "Lcom/bytedance/ies/bullet/base/settings/g;", "getArgusSecurityDebugConfig", "Lcom/bytedance/ies/bullet/base/settings/j;", "getClientAiConfig", "Lcom/bytedance/ies/bullet/base/settings/e;", "getAnnieXSLConfig", "Lcom/bytedance/ies/bullet/base/settings/a;", "getAnnieXBatchFlowConfig", "Lcom/bytedance/ies/bullet/base/settings/AnnieXRedirectRules;", "getAnnieXRedirectRules", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IBulletSettings extends ISettings {
    a getAnnieXBatchFlowConfig();

    d getAnnieXPredefineConfig();

    f getAnnieXPredefineWasmConfig();

    com.bytedance.ies.bullet.base.settings.d getAnnieXRedirectConfig();

    AnnieXRedirectRules getAnnieXRedirectRules();

    e getAnnieXSLConfig();

    com.bytedance.ies.bullet.base.settings.f getArgusRecoveryConfig();

    g getArgusSecurityDebugConfig();

    h getArgusSecuritySettingConfig();

    j getClientAiConfig();

    w26.e getCommonConfig();

    l getForestSettingConfig();

    r getMixConfig();

    w26.h getMonitorConfig();

    b getPIAConfig();

    i getPineappleConfig();

    w26.j getResourceLoaderConfig();

    SccConfig getSccSettingsConfig();

    u getSecuritySettingConfig();
}
