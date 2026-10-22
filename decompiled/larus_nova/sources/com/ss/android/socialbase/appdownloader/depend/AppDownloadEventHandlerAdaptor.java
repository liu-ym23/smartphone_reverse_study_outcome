package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadEventHandlerAdaptor extends AbsAppDownloadEventHandler {
    private BaseDownloadListenerAdaptor<IAppDownloadEventHandler, AbsAppDownloadEventHandler> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.AppDownloadEventHandlerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final AppDownloadEventHandlerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new AppDownloadEventHandlerAdaptor(null);
        }

        public static /* synthetic */ AppDownloadEventHandlerAdaptor access$100() {
            return INSTANCE;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean isForbidInvalidatePackageInstall() {
        return isForbidInvalidatePackageInstall(null);
    }

    private AppDownloadEventHandlerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static AppDownloadEventHandlerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ AppDownloadEventHandlerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IAppDownloadEventHandler addListener(IAppDownloadEventHandler r100) {
        if ((r100 instanceof AbsAppDownloadEventHandler) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsAppDownloadEventHandler) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadCancel(DownloadInfo r100) {
        IAppDownloadEventHandler r101 = (IAppDownloadEventHandler) this.mBaseAdapter.getBizListener(r100);
        if (r101 == null) goto L6;
        r101.handleDownloadCancel(r100);
        return;
    L6:
        IAppDownloadEventHandler r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 == null) goto L10;
        r102.handleDownloadCancel(r100);
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler
    public boolean isForbidInvalidatePackageInstall(DownloadInfo r100) {
        IAppDownloadEventHandler r101 = (IAppDownloadEventHandler) this.mBaseAdapter.getBizListener(r100);
        if (r101 != null) goto L5;
        IAppDownloadEventHandler r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.isForbidInvalidatePackageInstall();
    L5:
        return r101.isForbidInvalidatePackageInstall();
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstalled(Context r100, String r101) {
        handleAppInstalled(null, r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean installIntercept(int r100, boolean r101) {
        DownloadInfo r102 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
        IAppDownloadEventHandler r103 = (IAppDownloadEventHandler) this.mBaseAdapter.getBizListener(r102);
        if (r103 != null) goto L5;
        IAppDownloadEventHandler r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 != null) goto L9;
        return false;
    L9:
        return r104.installIntercept(r100, r101);
    L5:
        return r103.installIntercept(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler
    public void handleAppInstalled(DownloadInfo r100, Context r101, String r102) {
        IAppDownloadEventHandler r103 = (IAppDownloadEventHandler) this.mBaseAdapter.getBizListener(r100);
        if (r103 == null) goto L6;
        r103.handleAppInstalled(r101, r102);
        return;
    L6:
        IAppDownloadEventHandler r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 == null) goto L10;
        r104.handleAppInstalled(r101, r102);
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstallError(int r100, int r101, String r110, String r111, String r112) {
        DownloadInfo r102 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
        IAppDownloadEventHandler r103 = (IAppDownloadEventHandler) this.mBaseAdapter.getBizListener(r102);
        if (r103 == null) goto L6;
        r103.handleAppInstallError(r100, r101, r110, r111, r112);
        return;
    L6:
        IAppDownloadEventHandler r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 == null) goto L10;
        r104.handleAppInstallError(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadEvent(int r100, int r110, String r111, int r112, long r113) {
        DownloadInfo r101 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
        IAppDownloadEventHandler r102 = (IAppDownloadEventHandler) this.mBaseAdapter.getBizListener(r101);
        if (r102 == null) goto L6;
        r102.handleDownloadEvent(r100, r110, r111, r112, r113);
        return;
    L6:
        IAppDownloadEventHandler r103 = this.mBaseAdapter.getDefaultListener();
        if (r103 == null) goto L10;
        r103.handleDownloadEvent(r100, r110, r111, r112, r113);
        return;
    }
}
