package com.bytedance.ee.bear.drive.loader.download;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DownStrategy implements IDownloadStrategy {
    private final com.bytedance.ee.bear.drive.config.strategy.d strategy;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy
    public DrivePriority.DownloadPriority downloadPriority() {
        return this.strategy.f();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy
    public boolean enablePreviewGetPolling() {
        return !TextUtils.equals(this.strategy.getPreviewFileSourceType(), "2");
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy
    public boolean enableStreaming() {
        return this.strategy.enableStreaming();
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy
    public String getPreviewFileSourceType() {
        return this.strategy.getPreviewFileSourceType();
    }

    public DownStrategy(com.bytedance.ee.bear.drive.config.strategy.d r1) {
        this.strategy = r1;
    }
}
