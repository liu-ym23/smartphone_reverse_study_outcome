package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadMonitorListenerAdaptor extends AbsAppDownloadMonitorListener {
    private BaseDownloadListenerAdaptor<IAppDownloadMonitorListener, AbsAppDownloadMonitorListener> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.AppDownloadMonitorListenerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final AppDownloadMonitorListenerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new AppDownloadMonitorListenerAdaptor(null);
        }

        public static /* synthetic */ AppDownloadMonitorListenerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private AppDownloadMonitorListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static AppDownloadMonitorListenerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ AppDownloadMonitorListenerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IAppDownloadMonitorListener addListener(IAppDownloadMonitorListener r100) {
        if ((r100 instanceof AbsAppDownloadMonitorListener) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsAppDownloadMonitorListener) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener
    public void onAppDownloadMonitorSend(DownloadInfo r100, BaseException r101, int r102) {
        IAppDownloadMonitorListener r103 = (IAppDownloadMonitorListener) this.mBaseAdapter.getBizListener(r100);
        if (r103 == null) goto L6;
        r103.onAppDownloadMonitorSend(r100, r101, r102);
        return;
    L6:
        IAppDownloadMonitorListener r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 == null) goto L10;
        r104.onAppDownloadMonitorSend(r100, r101, r102);
        return;
    }
}
