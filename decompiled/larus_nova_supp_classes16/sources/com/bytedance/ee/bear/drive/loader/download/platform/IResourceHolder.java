package com.bytedance.ee.bear.drive.loader.download.platform;

import c85.e;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy;
import g85.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IResourceHolder {
    IApiExecutor getApiExecutor();

    String getAppId();

    e getCacheHandler();

    com.bytedance.ee.bear.drive.report.a getDevReport();

    IDownloadStrategy getDownloadStrategy();

    q75.a getDriveConfig();

    f getMimeTypeManager();
}
