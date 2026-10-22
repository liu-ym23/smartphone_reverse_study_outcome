package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class ReserveWifiStatusListenerAdaptor extends AbsReserveWifiStatusListener {
    private BaseDownloadListenerAdaptor<IReserveWifiStatusListener, AbsReserveWifiStatusListener> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.ReserveWifiStatusListenerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final ReserveWifiStatusListenerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new ReserveWifiStatusListenerAdaptor(null);
        }

        public static /* synthetic */ ReserveWifiStatusListenerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private ReserveWifiStatusListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static ReserveWifiStatusListenerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ ReserveWifiStatusListenerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IReserveWifiStatusListener addListener(IReserveWifiStatusListener r100) {
        if ((r100 instanceof AbsReserveWifiStatusListener) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsReserveWifiStatusListener) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(DownloadInfo r100, int r101, int r102) {
        IReserveWifiStatusListener r103 = (IReserveWifiStatusListener) this.mBaseAdapter.getBizListener(r100);
        if (r103 == null) goto L6;
        r103.onStatusChanged(r100, r101, r102);
        return;
    L6:
        IReserveWifiStatusListener r104 = this.mBaseAdapter.getDefaultListener();
        if (r104 == null) goto L10;
        r104.onStatusChanged(r100, r101, r102);
        return;
    }
}
