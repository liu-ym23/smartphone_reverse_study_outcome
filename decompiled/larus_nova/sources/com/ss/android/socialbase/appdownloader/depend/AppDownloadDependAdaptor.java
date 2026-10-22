package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadDependAdaptor extends AbsAppDownloadDepend {
    private BaseDownloadListenerAdaptor<IAppDownloadDepend, AbsAppDownloadDepend> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.AppDownloadDependAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final AppDownloadDependAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new AppDownloadDependAdaptor(null);
        }

        public static /* synthetic */ AppDownloadDependAdaptor access$100() {
            return INSTANCE;
        }
    }

    private AppDownloadDependAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static AppDownloadDependAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ AppDownloadDependAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IAppDownloadDepend addListener(IAppDownloadDepend r100) {
        if ((r100 instanceof AbsAppDownloadDepend) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsAppDownloadDepend) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowNetwork(Context r100) {
        return getAllowNetwork(0, r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(Context r100) {
        return getThemedAlertDlgBuilder(0, r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public boolean isForbiddenInstallForInvalidatePackageName(DownloadInfo r100) {
        AbsAppDownloadDepend r101 = (AbsAppDownloadDepend) this.mBaseAdapter.getBizListener(r100);
        if (r101 != null) goto L5;
        IAppDownloadDepend r102 = this.mBaseAdapter.getDefaultListener();
        if (r101 != null) goto L9;
        return false;
    L9:
        if ((r102 instanceof AbsAppDownloadDepend) == true) goto L11;
        return false;
    L11:
        return r101.isForbiddenInstallForInvalidatePackageName(r100);
    L5:
        return r101.isForbiddenInstallForInvalidatePackageName(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public boolean getAllowNetwork(int r100, Context r101) {
        if (r100 == 0) goto L4;
        DownloadInfo r102 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
    L5:
        IAppDownloadDepend r103 = (IAppDownloadDepend) this.mBaseAdapter.getBizListener(r102);
        if (r103 != null) goto L8;
        IAppDownloadDepend r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 != null) goto L12;
        return true;
    L12:
        return r104.getAllowNetwork(r101);
    L8:
        return r103.getAllowNetwork(r101);
    L4:
        r102 = null;
        goto L5
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(int r100, Context r101) {
        if (r100 == 0) goto L5;
        DownloadInfo r102 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
    L6:
        IAppDownloadDepend r103 = (IAppDownloadDepend) this.mBaseAdapter.getBizListener(r102);
        if (r103 != null) goto L9;
        IAppDownloadDepend r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.getThemedAlertDlgBuilder(r101);
    L9:
        return r103.getThemedAlertDlgBuilder(r101);
    L5:
        r102 = null;
        goto L6
    }
}
