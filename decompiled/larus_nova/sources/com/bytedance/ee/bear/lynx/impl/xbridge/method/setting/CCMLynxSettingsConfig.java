package com.bytedance.ee.bear.lynx.impl.xbridge.method.setting;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@AppConfig(key = CCMLynxSettingsConfig.CONFIG_NAME)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/xbridge/method/setting/CCMLynxSettingsConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "toString", "", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxSettingsConfig implements NonProguard {
    public static final String CONFIG_NAME = "ccm_lynx_setting_config";
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CCMLynxSettingsConfig() {
    }

    public String toString() {
        return "CCMLynxSettingsConfig@" + hashCode();
    }
}
