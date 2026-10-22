package com.bytedance.ee.bear.contract.drive;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "drive_rust_config")
public class DriveCommonConstants$DriveRustFgConfig implements NonProguard {
    public boolean disable_cdn_download;
    public int max_download_part_size;
    public int max_thread_size;
    public int small_upload_file_size;

    public DriveCommonConstants$DriveRustFgConfig() {
        this.max_thread_size = 5;
        this.max_download_part_size = 3145728;
        this.small_upload_file_size = 20971520;
        this.disable_cdn_download = true;
    }
}
