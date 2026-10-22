package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.monitor.InnerEventListener;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsInnerEventListener extends BaseDownloadListenerAdaptor<InnerEventListener, AbsInnerEventListener> implements InnerEventListener, IBizCallback {
    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    public AbsInnerEventListener() {
    }
}
