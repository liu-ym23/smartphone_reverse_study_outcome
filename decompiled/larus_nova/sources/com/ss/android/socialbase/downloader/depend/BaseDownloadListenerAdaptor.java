package com.ss.android.socialbase.downloader.depend;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IBizCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class BaseDownloadListenerAdaptor<D, A extends IBizCallback> {
    private Map<String, A> mBizListener;
    private D mDefaultListener;

    public BaseDownloadListenerAdaptor() {
        this.mBizListener = new ConcurrentHashMap();
    }

    public D getDefaultListener() {
        return this.mDefaultListener;
    }

    public boolean addListener(A r100) {
        String r101 = r100.getMonitorScene();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        this.mBizListener.put(r101, r100);
        return true;
    L6:
        return false;
    }

    public A getBizListener(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (this.mBizListener.isEmpty() == false) goto L7;
        return null;
    L7:
        return (A) getBizListener(r100.getMonitorScene());
    }

    public void addListener(D r100) {
        this.mDefaultListener = r100;
    }

    public A getBizListener(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        return this.mBizListener.get(r100);
    }
}
