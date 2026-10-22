package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadInterceptorAdaptor extends AbsDownloadInterceptor {
    private BaseDownloadListenerAdaptor<IDownloadInterceptor, AbsDownloadInterceptor> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.DownloadInterceptorAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final DownloadInterceptorAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new DownloadInterceptorAdaptor(null);
        }

        public static /* synthetic */ DownloadInterceptorAdaptor access$100() {
            return INSTANCE;
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadInterceptor, com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
    public boolean intercepte() {
        IDownloadInterceptor r100 = this.mBaseAdapter.getDefaultListener();
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.intercepte();
    }

    private DownloadInterceptorAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static DownloadInterceptorAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ DownloadInterceptorAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IDownloadInterceptor addListener(IDownloadInterceptor r100) {
        if ((r100 instanceof AbsDownloadInterceptor) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsDownloadInterceptor) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadInterceptor
    public boolean intercept(DownloadInfo r100) {
        AbsDownloadInterceptor r101 = (AbsDownloadInterceptor) this.mBaseAdapter.getBizListener(r100);
        if (r101 != null) goto L5;
        IDownloadInterceptor r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 != null) goto L9;
        return false;
    L9:
        if ((r102 instanceof AbsDownloadInterceptor) == true) goto L11;
        return false;
    L11:
        return ((AbsDownloadInterceptor) r102).intercept(r100);
    L5:
        return r101.intercept(r100);
    }
}
