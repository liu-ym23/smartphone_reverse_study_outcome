package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "drive_image_thumb_config")
public class DriveImageThumbConfig implements NonProguard {
    public Boolean enable;
    public Long minSize;
    public String[] supportAppId;
    public Map<String, Long> typesConfig;

    public DriveImageThumbConfig() {
    }
}
