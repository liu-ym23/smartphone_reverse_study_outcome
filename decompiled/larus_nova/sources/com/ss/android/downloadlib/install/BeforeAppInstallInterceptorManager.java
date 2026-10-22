package com.ss.android.downloadlib.install;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallInterceptCallback;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class BeforeAppInstallInterceptorManager implements IBeforeAppInstallInterceptor {
    private static volatile BeforeAppInstallInterceptorManager sInstance;
    private List<IBeforeAppInstallInterceptor> mInterceptors;

    public static BeforeAppInstallInterceptorManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BeforeAppInstallInterceptorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BeforeAppInstallInterceptorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BeforeAppInstallInterceptorManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private BeforeAppInstallInterceptorManager() {
        ArrayList r100 = new ArrayList();
        this.mInterceptors = r100;
        r100.add(new AppInstallParamsInterceptor());
        this.mInterceptors.add(new AppInstallInvokeInterceptor());
        this.mInterceptors.add(new AppFloatingWindowInterceptor());
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor
    public void intercept(DownloadInfo r100, IAppInstallInterceptCallback r101) {
        if (r100 != null) goto L4;
    L8:
        if (r101 == null) goto L11;
        r101.onInterceptFinish();
        return;
    L11:
        return;
    L4:
        if (this.mInterceptors.size() == 0) goto L8;
        executeInterceptors(r100, 0, r101);
    }

    private void executeInterceptors(final DownloadInfo r100, final int r101, final IAppInstallInterceptCallback r102) {
        if (r101 == this.mInterceptors.size()) goto L8;
        if (r101 < 0) goto L8;
        ((IBeforeAppInstallInterceptor) ListProtector.get(this.mInterceptors, r101)).intercept(r100, new AnonymousClass1(this, r101, r100, r102));
        return;
    L8:
        r102.onInterceptFinish();
    }

    public static /* synthetic */ void access$000(BeforeAppInstallInterceptorManager r100, DownloadInfo r101, int r102, IAppInstallInterceptCallback r103) {
        r100.executeInterceptors(r101, r102, r103);
    }
}
