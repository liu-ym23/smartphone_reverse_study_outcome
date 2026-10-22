package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class InnerEventListenerAdaptor extends AbsInnerEventListener {
    private BaseDownloadListenerAdaptor<InnerEventListener, AbsInnerEventListener> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.InnerEventListenerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final InnerEventListenerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new InnerEventListenerAdaptor(null);
        }

        public static /* synthetic */ InnerEventListenerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private InnerEventListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static InnerEventListenerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ InnerEventListenerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public InnerEventListener addEventListener(InnerEventListener r100) {
        if ((r100 instanceof AbsInnerEventListener) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsInnerEventListener) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int r100, String r101, JSONObject r102) {
        DownloadInfo r103 = Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getDownloadInfo(r100);
        InnerEventListener r104 = (InnerEventListener) this.mBaseAdapter.getBizListener(r103);
        if (r104 == null) goto L6;
        r104.onEvent(r100, r101, r102);
        return;
    L6:
        InnerEventListener r105 = this.mBaseAdapter.getDefaultListener();
        if (r105 == null) goto L10;
        r105.onEvent(r100, r101, r102);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int r100, String r101, JSONObject r102) {
        DownloadInfo r103 = Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getDownloadInfo(r100);
        InnerEventListener r104 = (InnerEventListener) this.mBaseAdapter.getBizListener(r103);
        if (r104 == null) goto L6;
        r104.onUnityEvent(r100, r101, r102);
        return;
    L6:
        InnerEventListener r105 = this.mBaseAdapter.getDefaultListener();
        if (r105 == null) goto L10;
        r105.onUnityEvent(r100, r101, r102);
        return;
    }
}
