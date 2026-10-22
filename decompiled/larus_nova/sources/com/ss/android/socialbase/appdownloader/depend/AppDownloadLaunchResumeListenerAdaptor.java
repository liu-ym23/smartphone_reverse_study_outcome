package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadLaunchResumeListenerAdaptor extends AbsAppDownloadLaunchResumeListener {
    private BaseDownloadListenerAdaptor<IAppDownloadLaunchResumeListener, AbsAppDownloadLaunchResumeListener> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.AppDownloadLaunchResumeListenerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final AppDownloadLaunchResumeListenerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new AppDownloadLaunchResumeListenerAdaptor(null);
        }

        public static /* synthetic */ AppDownloadLaunchResumeListenerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private AppDownloadLaunchResumeListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static AppDownloadLaunchResumeListenerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ AppDownloadLaunchResumeListenerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public IAppDownloadLaunchResumeListener addListener(IAppDownloadLaunchResumeListener r100) {
        if ((r100 instanceof AbsAppDownloadLaunchResumeListener) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsAppDownloadLaunchResumeListener) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadLaunchResumeListener
    public void onLaunchResume(List<DownloadInfo> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L44;
        HashMap r101 = new HashMap();
        IAppDownloadLaunchResumeListener r102 = this.mBaseAdapter.getDefaultListener();
        if (r102 == null) goto L9;
        ArrayList r103 = new ArrayList();
    L10:
        Iterator<DownloadInfo> r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L22;
        DownloadInfo r105 = r104.next();
        IAppDownloadLaunchResumeListener r106 = (IAppDownloadLaunchResumeListener) this.mBaseAdapter.getBizListener(r105);
        if (r106 != null) goto L15;
        if (r103 == null) goto L12;
        r103.add(r105);
        goto L12
    L15:
        List r107 = (List) r101.get(r106);
        if (r107 != null) goto L18;
        r107 = new ArrayList();
    L18:
        r107.add(r105);
        r101.put(r106, r107);
        goto L12
    L22:
        if (r101.isEmpty() == true) goto L27;
        Iterator r108 = r101.entrySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L27;
        Map.Entry r109 = (Map.Entry) r108.next();
        ((IAppDownloadLaunchResumeListener) r109.getKey()).onLaunchResume((List) r109.getValue());
    L27:
        if (r103 != null) goto L29;
        return;
    L29:
        if (r103.isEmpty() == true) goto L43;
        r102.onLaunchResume(r103);
        return;
    L43:
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadLaunchResumeListener
    public void onResumeDownload(DownloadInfo r100, boolean r101) {
        IAppDownloadLaunchResumeListener r102 = (IAppDownloadLaunchResumeListener) this.mBaseAdapter.getBizListener(r100);
        if (r102 == null) goto L6;
        r102.onResumeDownload(r100, r101);
        return;
    L6:
        IAppDownloadLaunchResumeListener r103 = this.mBaseAdapter.getDefaultListener();
        if (r103 == null) goto L10;
        r103.onResumeDownload(r100, r101);
        return;
    }
}
