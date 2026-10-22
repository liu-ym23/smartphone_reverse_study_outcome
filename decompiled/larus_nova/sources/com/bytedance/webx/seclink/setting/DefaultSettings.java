package com.bytedance.webx.seclink.setting;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public final class DefaultSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f272601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f272602b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f272603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DefaultSettings f272604d = null;

    static {
        f272601a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultSettings.class), "SETTINGS", "getSETTINGS()Lcom/bytedance/webx/seclink/setting/SettingConfig;"))};
        f272604d = new DefaultSettings();
        f272602b = "{\n    \"config\": {\n        \"custom_settings_biz_first\": true,\n        \"error_overwhelming_count\": 100,\n        \"error_overwhelming_duration\": 1800,\n        \"period\": 86400,\n        \"safe_duration_after_overwhelming\": 1800,\n        \"seclink_settings_version\": \"B350AFCAB4F3218AF5D74ADC624143E2\",\n        \"settings_url_array\": [\n            \"https://rc.zijieapi.com/seclink/setting/v1\",\n            \"https://seclink.bytedance.com/setting/v1\",\n            \"https://link.wtturl.cn/setting/v1\",\n            \"https://api.xseclink.cn/setting/v1\",\n            \"https://api.xseclink.com/setting/v1\"\n        ],\n        \"sync_check_time_limit\": 1,\n        \"use_cache\": true,\n        \"verify_host_array\": [\n            \"https://seclink.bytedance.com\",\n            \"https://api.xseclink.cn\",\n            \"https://link.wtturl.cn\"\n        ]\n    },\n    \"global\": {\n        \"async_mode\": true,\n        \"enable\": true,\n        \"scheme\": [\n            \"https\",\n            \"http\"\n        ],\n        \"use_verify_mode_v2\": true\n    }\n}\n ";
        f272603c = LazyKt.lazy(DefaultSettings$SETTINGS$2.INSTANCE);
    }

    public DefaultSettings() {
    }
}
