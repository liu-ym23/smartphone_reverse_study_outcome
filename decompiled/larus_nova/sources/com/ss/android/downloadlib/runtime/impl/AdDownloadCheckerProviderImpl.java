package com.ss.android.downloadlib.runtime.impl;

import com.ss.android.download.api.common.DefaultAppStatusChecker;
import com.ss.android.download.api.runtime.IAdDownloadCheckerProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdDownloadCheckerProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;", "enableReplace", "", "(Z)V", "checkBasicMode", "installInterceptChecker", "byUser", "isAppBackground", "isOpenUpgradeChecker", "packageChannelNeedHandleChecker", "downloadInfo", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "Companion", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AdDownloadCheckerProviderImpl implements IAdDownloadCheckerProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdDownloadCheckerProviderImpl";
    private final boolean enableReplace;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdDownloadCheckerProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadCheckerProvider
    public boolean isAppBackground() {
        if (this.enableReplace == false) goto L5;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "isAppBackground", "闭环实现前后台监听逻辑");
        return DefaultAppStatusChecker.INSTANCE.isAppBackground();
    L5:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "isAppBackground", "使用端上注入的逻辑实现前后台监听");
        IAdDownloadCheckerProvider r100 = GlobalInfo.getDownloadCheckerFactory();
        if (r100 != null) goto L11;
        return false;
    L11:
        return r100.isAppBackground();
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadCheckerProvider
    public boolean checkBasicMode() {
        IAdDownloadCheckerProvider r100 = GlobalInfo.getDownloadCheckerFactory();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.checkBasicMode();
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadCheckerProvider
    public boolean isOpenUpgradeChecker() {
        IAdDownloadCheckerProvider r100 = GlobalInfo.getDownloadCheckerFactory();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isOpenUpgradeChecker();
    }

    public AdDownloadCheckerProviderImpl(boolean r100) {
        this.enableReplace = r100;
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadCheckerProvider
    public boolean installInterceptChecker(boolean r100) {
        IAdDownloadCheckerProvider r101 = GlobalInfo.getDownloadCheckerFactory();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.installInterceptChecker(r100);
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadCheckerProvider
    public boolean packageChannelNeedHandleChecker(DownloadInfo r100) {
        IAdDownloadCheckerProvider r101 = GlobalInfo.getDownloadCheckerFactory();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.packageChannelNeedHandleChecker(r100);
    }
}
