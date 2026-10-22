package com.ss.android.ugc.effectmanager.common.download;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/download/DownloadListener;", "", "onFinish", "", "result", "Lcom/ss/android/ugc/effectmanager/common/download/DownloadResult;", "onProgress", "progress", "", "totalSize", "", WidgetCostModule.TYPE_ON_START, "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public interface DownloadListener {
    void onFinish(DownloadResult r100);

    void onProgress(int r100, long r101);

    void onStart();
}
