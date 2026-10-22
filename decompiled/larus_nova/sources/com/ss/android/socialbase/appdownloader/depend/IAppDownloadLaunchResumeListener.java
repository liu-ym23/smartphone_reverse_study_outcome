package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppDownloadLaunchResumeListener {
    void onLaunchResume(List<DownloadInfo> r100);

    void onResumeDownload(DownloadInfo r100, boolean r101);
}
