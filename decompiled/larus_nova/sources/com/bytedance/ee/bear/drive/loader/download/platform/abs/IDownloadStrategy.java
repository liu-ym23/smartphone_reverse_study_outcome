package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;

/* JADX INFO: loaded from: classes16.dex */
public interface IDownloadStrategy {
    DrivePriority$DownloadPriority downloadPriority();

    boolean enablePreviewGetPolling();

    boolean enableStreaming();

    String getPreviewFileSourceType();
}
