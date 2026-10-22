package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IDownloadStrategy {
    DrivePriority.DownloadPriority downloadPriority();

    boolean enablePreviewGetPolling();

    boolean enableStreaming();

    String getPreviewFileSourceType();
}
