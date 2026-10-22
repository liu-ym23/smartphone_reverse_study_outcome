package com.bytedance.ee.bear.middleground.drive.export;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class DriveRustFgConfig implements NonProguard {
    public boolean disable_cdn_download;
    public Map<String, String> extra;
    public int max_download_part_size;
    public int max_thread_size;
    public boolean pause_background;
    public int small_upload_file_size;

    public String toString() {
        return "DriveRustFgConfig{disable_cdn_download=" + this.disable_cdn_download + ", max_thread_size=" + this.max_thread_size + ", max_download_part_size=" + this.max_download_part_size + ", small_upload_file_size=" + this.small_upload_file_size + ", pause_background=" + this.pause_background + ", extra=" + this.extra + '}';
    }

    public DriveRustFgConfig(boolean r100, int r101, int r102, int r103, boolean r104) {
        this.extra = new HashMap();
        this.disable_cdn_download = r100;
        this.max_thread_size = r101;
        this.max_download_part_size = r102;
        this.pause_background = r104;
        this.small_upload_file_size = r103;
    }
}
