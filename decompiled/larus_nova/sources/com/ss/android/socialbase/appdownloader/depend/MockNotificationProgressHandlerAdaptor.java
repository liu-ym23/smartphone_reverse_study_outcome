package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class MockNotificationProgressHandlerAdaptor extends AbsMockNotificationProgressHandler {
    private BaseDownloadListenerAdaptor<IMockNotificationProgressHandler, AbsMockNotificationProgressHandler> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.MockNotificationProgressHandlerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final MockNotificationProgressHandlerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new MockNotificationProgressHandlerAdaptor(null);
        }

        public static /* synthetic */ MockNotificationProgressHandlerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private MockNotificationProgressHandlerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static MockNotificationProgressHandlerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ MockNotificationProgressHandlerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IMockNotificationProgressHandler addListener(IMockNotificationProgressHandler r100) {
        if ((r100 instanceof AbsMockNotificationProgressHandler) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsMockNotificationProgressHandler) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler
    public long onNotificationUpdate(int r100, long r101, long r110) {
        DownloadInfo r102 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
        IMockNotificationProgressHandler r103 = (IMockNotificationProgressHandler) this.mBaseAdapter.getBizListener(r102);
        if (r103 != null) goto L5;
        IMockNotificationProgressHandler r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 != null) goto L9;
        return 0;
    L9:
        return r104.onNotificationUpdate(r100, r101, r110);
    L5:
        return r103.onNotificationUpdate(r100, r101, r110);
    }
}
