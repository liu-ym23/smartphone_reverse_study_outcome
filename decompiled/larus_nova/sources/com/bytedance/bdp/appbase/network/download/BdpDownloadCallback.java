package com.bytedance.bdp.appbase.network.download;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdp/appbase/network/download/BdpDownloadCallback;", "", "onCancel", "", DBDefinition.TASK_ID, "", "request", "Lcom/bytedance/bdp/appbase/network/download/BdpDownloadRequest;", "onFinish", "response", "Lcom/bytedance/bdp/appbase/network/download/BdpDownloadResponse;", "onProgress", "download", "", "length", WidgetCostModule.TYPE_ON_START, "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public interface BdpDownloadCallback {
    void onCancel(int r100, BdpDownloadRequest r101);

    void onFinish(int r100, BdpDownloadRequest r101, BdpDownloadResponse r102);

    void onProgress(int r100, long r101, long r102);

    void onStart(int r100);
}
