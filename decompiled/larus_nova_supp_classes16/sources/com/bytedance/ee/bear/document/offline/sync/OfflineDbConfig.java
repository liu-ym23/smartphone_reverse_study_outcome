package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "offline_db_config")
public class OfflineDbConfig implements NonProguard {
    public long offline_db_item_count;
    public long offline_db_size;

    public String toString() {
        return "OfflineDbConfig{offline_db_size=" + this.offline_db_size + ", offline_db_item_count=" + this.offline_db_item_count + '}';
    }

    public OfflineDbConfig() {
        this.offline_db_size = 209715200;
        this.offline_db_item_count = 500;
    }

    public long getOffline_db_item_count() {
        return this.offline_db_item_count;
    }

    public long getOffline_db_size() {
        return this.offline_db_size;
    }

    public void setOffline_db_item_count(long r1) {
        this.offline_db_item_count = r1;
    }

    public void setOffline_db_size(long r1) {
        this.offline_db_size = r1;
    }
}
