package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadInterceptorAdaptor extends AbsAppDownloadInterceptor {
    private BaseDownloadListenerAdaptor<IAppDownloadInterceptor, AbsAppDownloadInterceptor> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.AppDownloadInterceptorAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final AppDownloadInterceptorAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new AppDownloadInterceptorAdaptor(null);
        }

        public static /* synthetic */ AppDownloadInterceptorAdaptor access$100() {
            return INSTANCE;
        }
    }

    private AppDownloadInterceptorAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static AppDownloadInterceptorAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ AppDownloadInterceptorAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IAppDownloadInterceptor addListener(IAppDownloadInterceptor r100) {
        if ((r100 instanceof AbsAppDownloadInterceptor) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsAppDownloadInterceptor) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadInterceptor
    public boolean intercept(AppTaskBuilder r100) {
        IAppDownloadInterceptor r101 = (IAppDownloadInterceptor) this.mBaseAdapter.getBizListener(r100.getMonitorScene());
        if (r101 != null) goto L5;
        IAppDownloadInterceptor r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.intercept(r100);
    L5:
        return r101.intercept(r100);
    }
}
