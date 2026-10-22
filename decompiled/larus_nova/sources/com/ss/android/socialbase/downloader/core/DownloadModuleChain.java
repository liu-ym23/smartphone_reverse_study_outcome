package com.ss.android.socialbase.downloader.core;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.exception.BaseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadModuleChain implements IDownloadModuleChain {
    private DownloadCommonParams mCommonParams;
    private List<IDownloadModule> mDownloadModules;
    private int mIndex;
    private volatile boolean mStartDownload;

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModuleChain
    public void onDownloadStart() {
        this.mStartDownload = true;
    }

    public void reset() {
        this.mIndex = 0;
        this.mCommonParams.mHasRunNetworkModule = false;
    }

    public void cancel() {
        Iterator<IDownloadModule> r100 = this.mDownloadModules.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();
        goto L4
    }

    public void pause() {
        Iterator<IDownloadModule> r100 = this.mDownloadModules.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().pause();
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModuleChain
    public void proceed() throws BaseException {
        if (this.mIndex != this.mDownloadModules.size()) goto L5;
        return;
    L5:
        IDownloadModule r100 = (IDownloadModule) ListProtector.get(this.mDownloadModules, this.mIndex);
        this.mIndex++;
        r100.proceed(this);
    }

    public boolean isStartDownload() {
        return this.mStartDownload;
    }

    public DownloadModuleChain(DownloadCommonParams r100) {
        this.mDownloadModules = new CopyOnWriteArrayList();
        this.mStartDownload = false;
        this.mCommonParams = r100;
    }

    public DownloadModuleChain addDownloadModule(IDownloadModule r100) {
        IDownloadModule r101 = r100.init(this.mCommonParams);
        if (r101 != null) goto L5;
        return this;
    L5:
        this.mDownloadModules.add(r101);
        return this;
    }

    public void setThrottleNetSpeed(long r100, int r101) {
        Iterator<IDownloadModule> r102 = this.mDownloadModules.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().setThrottleNetSpeed(r100, r101);
        goto L4
    }
}
