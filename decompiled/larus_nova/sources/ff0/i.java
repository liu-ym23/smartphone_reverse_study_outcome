package ff0;

import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends AbsDownloadListener {
    public i() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        HamletAvatarContext r101 = HamletAvatarContext.Companion.getContext();
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.isLipSyncModelDownloaded();
        if (r102 == null) goto L9;
        r102.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }
}
