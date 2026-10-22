package com.bytedance.ee.bear.middleground.permission.leader;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes18.dex */
@AppConfig(key = LeaderPermCenterConfig.KEY)
public class LeaderPermCenterConfig implements NonProguard {
    public static final String KEY = "leader_perm_center";
    private String cn_url;
    private String en_url;
    private String jp_url;

    public LeaderPermCenterConfig() {
    }

    public String toString() {
        return "LeaderPermCenterConfig{cn_url='" + this.cn_url + "', en_url='" + this.en_url + "', jp_url='" + this.jp_url + "'}";
    }

    public String getCn_url() {
        return this.cn_url;
    }

    public String getEn_url() {
        return this.en_url;
    }

    public String getJp_url() {
        return this.jp_url;
    }

    public void setCn_url(String r100) {
        this.cn_url = r100;
    }

    public void setEn_url(String r100) {
        this.en_url = r100;
    }

    public void setJp_url(String r100) {
        this.jp_url = r100;
    }
}
