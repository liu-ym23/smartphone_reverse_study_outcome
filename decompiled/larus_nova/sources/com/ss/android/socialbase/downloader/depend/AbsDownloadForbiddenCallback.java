package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsDownloadForbiddenCallback implements IDownloadForbiddenCallback {
    private boolean hasCallback;

    public AbsDownloadForbiddenCallback() {
        this.hasCallback = false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
    public boolean hasCallback() {
        return this.hasCallback;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
    public void onCallback(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        this.hasCallback = true;
        return;
    }
}
