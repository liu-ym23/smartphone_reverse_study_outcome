package com.bytedance.ee.bear.list.listsync.entity;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.concurrent.TimeUnit;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
@AppConfig(key = SyncPushConfig.FG_KEY)
public class SyncPushConfig implements NonProguard {
    public static final String FG_KEY = "list_push_sync_config";
    private static volatile SyncPushConfig sInstance;
    private long allowed_time_offset;
    private int background_refresh_size;
    private boolean enable_msg_time_check;
    private int first_screen_item_count;
    private long minimum_tip_interval;
    private long refresh_interval;
    private long refresh_tip_duration;
    private int register_size;
    private boolean show_refresh_tips_ui;

    public static SyncPushConfig instance() {
        if (sInstance != null) goto L15;
        monitor-enter(SyncPushConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = (SyncPushConfig) c.a.f206237a.c(FG_KEY, SyncPushConfig.class, new SyncPushConfig());     // Catch: Throwable -> L11
        a.h(FG_KEY, "sync config=" + sInstance);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SyncPushConfig.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public String toString() {
        return "SyncPushConfig{register_size=" + this.register_size + ", show_refresh_tips_ui=" + this.show_refresh_tips_ui + ", background_refresh_size=" + this.background_refresh_size + ", enable_msg_time_check=" + this.enable_msg_time_check + ", allowed_time_offset=" + this.allowed_time_offset + ", first_screen_item_count=" + this.first_screen_item_count + ", refresh_tip_duration=" + this.refresh_tip_duration + ", minimum_tip_interval=" + this.minimum_tip_interval + ", refresh_interval=" + this.refresh_interval + '}';
    }

    public SyncPushConfig() {
        this.register_size = 100;
        this.background_refresh_size = 50;
        this.enable_msg_time_check = true;
        this.allowed_time_offset = TimeUnit.MILLISECONDS.convert(3, TimeUnit.MINUTES);
        this.first_screen_item_count = 15;
        this.refresh_tip_duration = 2000;
        this.minimum_tip_interval = 10000;
        this.refresh_interval = 30;
    }

    public long getAllowed_time_offset() {
        return this.allowed_time_offset;
    }

    public int getBackground_refresh_size() {
        return this.background_refresh_size;
    }

    public int getFirst_screen_item_count() {
        return this.first_screen_item_count;
    }

    public long getMinimum_tip_interval() {
        return this.minimum_tip_interval;
    }

    public long getRefresh_interval() {
        return this.refresh_interval;
    }

    public long getRefresh_tip_duration() {
        return this.refresh_tip_duration;
    }

    public int getRegister_size() {
        return this.register_size;
    }

    public boolean isEnable_msg_time_check() {
        return this.enable_msg_time_check;
    }

    public boolean isShow_refresh_tips_ui() {
        return this.show_refresh_tips_ui;
    }

    public void setAllowed_time_offset(long r100) {
        this.allowed_time_offset = r100;
    }

    public void setBackground_refresh_size(int r100) {
        this.background_refresh_size = r100;
    }

    public void setEnable_msg_time_check(boolean r100) {
        this.enable_msg_time_check = r100;
    }

    public void setFirst_screen_item_count(int r100) {
        this.first_screen_item_count = r100;
    }

    public void setMinimum_tip_interval(long r100) {
        this.minimum_tip_interval = r100;
    }

    public void setRefresh_interval(long r100) {
        this.refresh_interval = r100;
    }

    public void setRefresh_tip_duration(long r100) {
        this.refresh_tip_duration = r100;
    }

    public void setRegister_size(int r100) {
        this.register_size = r100;
    }

    public void setShow_refresh_tips_ui(boolean r100) {
        this.show_refresh_tips_ui = r100;
    }
}
