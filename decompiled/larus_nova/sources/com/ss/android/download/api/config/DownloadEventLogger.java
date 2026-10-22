package com.ss.android.download.api.config;

import com.ss.android.download.api.model.DownloadEventModel;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadEventLogger {
    void onEvent(DownloadEventModel r100);

    void onV3Event(DownloadEventModel r100);
}
