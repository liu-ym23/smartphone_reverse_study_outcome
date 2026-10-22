package com.bytedance.ee.bear.drive.loader.download;

import com.bytedance.ee.bear.drive.cache.t;
import g85.f;

/* JADX INFO: loaded from: classes16.dex */
public interface IFileDownloadDependency {
    String getAppId();

    String getCacheKey(String r100, String r101);

    t getCacheManager();

    com.bytedance.ee.bear.drive.report.a getDevReport();

    f getMimeTypeManager();

    com.bytedance.ee.bear.drive.config.strategy.d getPreviewStrategy();
}
