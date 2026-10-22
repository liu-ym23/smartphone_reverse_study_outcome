package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class OpenInstallerListenerAdaptor extends AbsOpenInstallerListener {
    private BaseDownloadListenerAdaptor<IOpenInstallerListener, AbsOpenInstallerListener> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.OpenInstallerListenerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final OpenInstallerListenerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new OpenInstallerListenerAdaptor(null);
        }

        public static /* synthetic */ OpenInstallerListenerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private OpenInstallerListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static OpenInstallerListenerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ OpenInstallerListenerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IOpenInstallerListener addListener(IOpenInstallerListener r100) {
        if ((r100 instanceof AbsOpenInstallerListener) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsOpenInstallerListener) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(DownloadInfo r100, String r101) {
        IOpenInstallerListener r102 = (IOpenInstallerListener) this.mBaseAdapter.getBizListener(r100);
        if (r102 == null) goto L6;
        r102.onOpenInstaller(r100, r101);
        return;
    L6:
        IOpenInstallerListener r103 = this.mBaseAdapter.getDefaultListener();
        if (r103 == null) goto L10;
        r103.onOpenInstaller(r100, r101);
        return;
    }
}
