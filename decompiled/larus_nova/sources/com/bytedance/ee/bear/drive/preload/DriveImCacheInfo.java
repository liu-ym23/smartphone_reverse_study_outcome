package com.bytedance.ee.bear.drive.preload;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes16.dex */
public class DriveImCacheInfo implements NonProguard {
    LinkedHashMap<String, String> previewUrls;

    public DriveImCacheInfo() {
    }

    public LinkedHashMap<String, String> getPreviewUrls() {
        return this.previewUrls;
    }

    public DriveImCacheInfo(f85.b r100) {
        if (hu5.a.e(r100.f558538g) == true) goto L6;
        this.previewUrls = r100.f558538g;
        return;
    L6:
        if (TextUtils.isEmpty(r100.f558540i) == true) goto L10;
        LinkedHashMap<String, String> r101 = new LinkedHashMap();
        this.previewUrls = r101;
        r101.put("default", r100.f558540i);
        return;
    }

    public void setPreviewUrls(LinkedHashMap<String, String> r100) {
        this.previewUrls = r100;
    }
}
