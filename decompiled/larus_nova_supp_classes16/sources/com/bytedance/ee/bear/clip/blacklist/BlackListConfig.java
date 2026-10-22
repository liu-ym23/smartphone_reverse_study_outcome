package com.bytedance.ee.bear.clip.blacklist;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = BlackListConfig.KEY)
public class BlackListConfig implements NonProguard {
    public static final String KEY = "clip_black_list";
    public List<String> blackList;

    public BlackListConfig() {
    }

    public static BlackListConfig getConfigValue() {
        return (BlackListConfig) c.a.a.c(KEY, BlackListConfig.class, new BlackListConfig());
    }

    public String toString() {
        return "BlackListConfig{blackList=" + this.blackList + '}';
    }
}
