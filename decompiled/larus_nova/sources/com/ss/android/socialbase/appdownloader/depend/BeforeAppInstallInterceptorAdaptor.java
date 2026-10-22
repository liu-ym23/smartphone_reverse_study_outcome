package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class BeforeAppInstallInterceptorAdaptor extends AbsBeforeAppInstallInterceptor {
    private BaseDownloadListenerAdaptor<IBeforeAppInstallInterceptor, AbsBeforeAppInstallInterceptor> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.BeforeAppInstallInterceptorAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final BeforeAppInstallInterceptorAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new BeforeAppInstallInterceptorAdaptor(null);
        }

        public static /* synthetic */ BeforeAppInstallInterceptorAdaptor access$100() {
            return INSTANCE;
        }
    }

    private BeforeAppInstallInterceptorAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static BeforeAppInstallInterceptorAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ BeforeAppInstallInterceptorAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IBeforeAppInstallInterceptor addListener(IBeforeAppInstallInterceptor r100) {
        if ((r100 instanceof AbsBeforeAppInstallInterceptor) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsBeforeAppInstallInterceptor) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor
    public void intercept(DownloadInfo r100, IAppInstallInterceptCallback r101) {
        IBeforeAppInstallInterceptor r102 = (IBeforeAppInstallInterceptor) this.mBaseAdapter.getBizListener(r100);
        if (r102 == null) goto L6;
        r102.intercept(r100, r101);
        return;
    L6:
        IBeforeAppInstallInterceptor r103 = this.mBaseAdapter.getDefaultListener();
        if (r103 == null) goto L10;
        r103.intercept(r100, r101);
        return;
    }
}
