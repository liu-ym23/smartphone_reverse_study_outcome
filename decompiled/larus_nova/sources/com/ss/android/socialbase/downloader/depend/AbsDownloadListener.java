package com.ss.android.socialbase.downloader.depend;

import android.util.Pair;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = null;

    public AbsDownloadListener() {
    }

    static {
        TAG = "AbsDownloadListener";
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onCanceled", "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onFirstStart", "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onFirstSuccess", "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    public void onIntercept(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onIntercept", "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onPause", "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onPrepare", "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L9;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getTotalBytes() == 0) goto L11;
        Logger.taskDebug(TAG, r100.getId(), "onProgress", String.format("Name: %s %.2f%%", new Object[]{r100.getName(), Float.valueOf((r100.getCurBytes() / r100.getTotalBytes()) * 100.0f)}));
        return;
    L11:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, WidgetCostModule.TYPE_ON_START, "Name: " + r100.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onSuccessed", "Name: " + r100.getName() + " " + r100.isSuccessByCache());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo r100, BaseException r101) {
        if (Logger.debugScene(r100) == false) goto L11;
        if (r100 == null) goto L12;
        String r102 = TAG;
        Object[] r103 = new Object[2];
        r103[0] = r100.getName();
        if (r101 == null) goto L8;
        String r104 = r101.getErrorMessage();
    L9:
        r103[1] = r104;
        Logger.taskDebug(r102, r100, "onFailed", String.format("Name: %s because of : %s", r103));
        return;
    L8:
        r104 = "unkown";
        goto L9
    L12:
        return;
    }

    public void onReceiveHeader(DownloadInfo r100, List<Pair<String, String>> r101) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onReceiveHeader", "Name: " + r100.getName() + " header:" + r101);
        return;
    L8:
        return;
    }

    public void onReceiveRequestLog(DownloadInfo r100, String r101) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onReceiveRequestLog", "Name: " + r100.getName() + " requestLog:" + r101);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo r100, BaseException r101) {
        if (Logger.debugScene(r100) == false) goto L11;
        if (r100 == null) goto L12;
        String r102 = TAG;
        Object[] r103 = new Object[2];
        r103[0] = r100.getName();
        if (r101 == null) goto L8;
        String r104 = r101.getErrorMessage();
    L9:
        r103[1] = r104;
        Logger.taskDebug(r102, r100, "onRetry", String.format("Name: %s because of : %s", r103));
        return;
    L8:
        r104 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo r100, BaseException r101) {
        if (Logger.debugScene(r100) == false) goto L11;
        if (r100 == null) goto L12;
        String r102 = TAG;
        Object[] r103 = new Object[2];
        r103[0] = r100.getName();
        if (r101 == null) goto L8;
        String r104 = r101.getErrorMessage();
    L9:
        r103[1] = r104;
        Logger.taskDebug(r102, r100, "onRetryDelay", String.format("Name: %s because of : %s", r103));
        return;
    L8:
        r104 = "unkown";
        goto L9
    L12:
        return;
    }

    public void onReceiveData(DownloadInfo r100, byte[] r101, int r102) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onReceiveData", "Name: " + r100.getName() + " data len:" + r102);
        return;
    L8:
        return;
    }

    public void onReceiveSegmentData(DownloadInfo r100, long r101, byte[] r102, int r103) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onReceiveSegmentData", "Name: " + r100.getName() + "offset:" + r101 + " data len:" + r103);
        return;
    L8:
        return;
    }
}
