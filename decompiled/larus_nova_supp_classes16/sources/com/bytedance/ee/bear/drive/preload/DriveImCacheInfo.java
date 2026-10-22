package com.bytedance.ee.bear.drive.preload;

import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveImCacheInfo implements NonProguard {
    LinkedHashMap<String, String> previewUrls;

    public DriveImCacheInfo() {
    }

    public LinkedHashMap<String, String> getPreviewUrls() {
        return this.previewUrls;
    }

    public DriveImCacheInfo(f85.b r3) {
        if (hu5.a.e(r3.g) == true) goto L6;
        this.previewUrls = r3.g;
        return;
    L6:
        if (TextUtils.isEmpty(r3.i) == true) goto L10;
        LinkedHashMap<String, String> r0 = new LinkedHashMap();
        this.previewUrls = r0;
        r0.put(BottomPopupData.Default, r3.i);
        return;
    }

    public void setPreviewUrls(LinkedHashMap<String, String> r1) {
        this.previewUrls = r1;
    }
}
