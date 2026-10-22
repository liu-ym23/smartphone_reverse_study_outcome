package com.ss.android.download.api.runtime;

import android.content.Context;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH&J.\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J$\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J.\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&JD\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\rH&¨\u0006\u0018"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;", "", "onDelayCheckOpenAppState", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "downloadModel", "Lcom/ss/android/download/api/download/DownloadModel;", "downloadController", "Lcom/ss/android/download/api/download/DownloadController;", "downloadEvent", "Lcom/ss/android/download/api/download/DownloadEventConfig;", "openAppPackageName", "", "applinkSource", "onItemClick", "onItemStart", "onJumpManagementPage", "downloadEventConfig", "onOpenApp", "scene", RuleConditionBean.OPEN_URL_KEY, "", "url", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAdDownloadActionProvider {
    void onDelayCheckOpenAppState(Context r100, DownloadModel r101, DownloadController r102, DownloadEventConfig r103, String r104, String r105);

    void onItemClick(Context r100, DownloadModel r101, DownloadController r102, DownloadEventConfig r103);

    void onItemStart(Context r100, DownloadModel r101, DownloadController r102);

    void onJumpManagementPage(Context r100, DownloadModel r101, DownloadController r102, DownloadEventConfig r103);

    void onOpenApp(Context r100, DownloadModel r101, DownloadController r102, DownloadEventConfig r103, String r104, String r105);

    boolean openUrl(Context r100, String r101);
}
