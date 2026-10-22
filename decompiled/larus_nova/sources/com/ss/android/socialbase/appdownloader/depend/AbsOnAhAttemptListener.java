package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.downloader.depend.IBizCallback;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsOnAhAttemptListener implements AhUtils.OnAhAttemptListener, IBizCallback {
    public AbsOnAhAttemptListener() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }
}
