package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SessionSettingUtil {
    public static final Gson a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    static {
        a = new Gson();
        b = LazyKt.lazy(SessionSettingUtil$deliveryExtractRule$2.INSTANCE);
        c = LazyKt.lazy(SessionSettingUtil$defaultAddParams$2.INSTANCE);
        d = LazyKt.lazy(SessionSettingUtil$stageConfigSetting$2.INSTANCE);
        e = LazyKt.lazy(SessionSettingUtil$useGeneralApi$2.INSTANCE);
        f = LazyKt.lazy(SessionSettingUtil$deliveryActionReportSetting$2.INSTANCE);
        g = LazyKt.lazy(SessionSettingUtil$stageMappingSetting$2.INSTANCE);
    }
}
