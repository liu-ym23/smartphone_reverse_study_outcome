package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.UrlSplicer;

/* JADX INFO: loaded from: classes16.dex */
public class DriveDownloadUrlProvider {
    public DriveDownloadUrlProvider() {
    }

    public String getDownloadAllUrl(String r100) {
        return UrlSplicer.downloadAllUrl(r100);
    }
}
