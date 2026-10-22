package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AhAttempt;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class OnAhAttemptListenerAdaptor extends AbsOnAhAttemptListener {
    private BaseDownloadListenerAdaptor<AhUtils.OnAhAttemptListener, AbsOnAhAttemptListener> mBaseAdapter;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.depend.OnAhAttemptListenerAdaptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonInstance {
        private static final OnAhAttemptListenerAdaptor INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new OnAhAttemptListenerAdaptor(null);
        }

        public static /* synthetic */ OnAhAttemptListenerAdaptor access$100() {
            return INSTANCE;
        }
    }

    private OnAhAttemptListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor();
    }

    public static OnAhAttemptListenerAdaptor getInstance() {
        return SingletonInstance.access$100();
    }

    public /* synthetic */ OnAhAttemptListenerAdaptor(AnonymousClass1 r100) {
        this();
    }

    public AhUtils.OnAhAttemptListener addListener(AhUtils.OnAhAttemptListener r100) {
        if ((r100 instanceof AbsOnAhAttemptListener) == false) goto L5;
        boolean r101 = this.mBaseAdapter.addListener((AbsOnAhAttemptListener) r100);
    L6:
        if (r101 == true) goto L8;
        this.mBaseAdapter.addListener(r100);
    L8:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.AhUtils.OnAhAttemptListener
    public void onAhAttemptResult(DownloadInfo r100, AhAttempt r101) {
        AhUtils.OnAhAttemptListener r102 = (AhUtils.OnAhAttemptListener) this.mBaseAdapter.getBizListener(r100);
        if (r102 == null) goto L6;
        r102.onAhAttemptResult(r100, r101);
        return;
    L6:
        AhUtils.OnAhAttemptListener r103 = this.mBaseAdapter.getDefaultListener();
        if (r103 == null) goto L10;
        r103.onAhAttemptResult(r100, r101);
        return;
    }
}
