package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class NotificationClickCallbackAdaptor extends AbsNotificationClickCallback {
    private BaseDownloadListenerAdaptor<INotificationClickCallback, AbsNotificationClickCallback> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.NotificationClickCallbackAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final NotificationClickCallbackAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new NotificationClickCallbackAdaptor(null);
        }

        public static /* synthetic */ NotificationClickCallbackAdaptor access$100() {
            return INSTANCE;
        }
    }

    private NotificationClickCallbackAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static NotificationClickCallbackAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ NotificationClickCallbackAdaptor(AnonymousClass1 r100) {
        this();
    }

    public INotificationClickCallback addListener(INotificationClickCallback r100) {
        if ((r100 instanceof AbsNotificationClickCallback) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsNotificationClickCallback) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
    public boolean onClickWhenInstalled(DownloadInfo r100) {
        INotificationClickCallback r101 = (INotificationClickCallback) this.mBaseAdapter.getBizListener(r100);
        if (r101 != null) goto L5;
        INotificationClickCallback r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.onClickWhenInstalled(r100);
    L5:
        return r101.onClickWhenInstalled(r100);
    }

    @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
    public boolean onClickWhenSuccess(DownloadInfo r100) {
        INotificationClickCallback r101 = (INotificationClickCallback) this.mBaseAdapter.getBizListener(r100);
        if (r101 != null) goto L5;
        INotificationClickCallback r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.onClickWhenSuccess(r100);
    L5:
        return r101.onClickWhenSuccess(r100);
    }

    @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
    public boolean onClickWhenUnSuccess(DownloadInfo r100) {
        INotificationClickCallback r101 = (INotificationClickCallback) this.mBaseAdapter.getBizListener(r100);
        if (r101 != null) goto L5;
        INotificationClickCallback r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.onClickWhenUnSuccess(r100);
    L5:
        return r101.onClickWhenUnSuccess(r100);
    }
}
