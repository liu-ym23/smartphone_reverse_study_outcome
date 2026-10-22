package com.ss.android.downloadlib.runtime.impl;

import android.content.Context;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.runtime.IAdDownloadActionProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J.\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0013\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J.\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016JD\u0010\u0016\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdDownloadActionProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;", "()V", "inserted", "", "onDelayCheckOpenAppState", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "downloadModel", "Lcom/ss/android/download/api/download/DownloadModel;", "downloadController", "Lcom/ss/android/download/api/download/DownloadController;", "downloadEvent", "Lcom/ss/android/download/api/download/DownloadEventConfig;", "openAppPackageName", "", "applinkSource", "onItemClick", "onItemStart", "onJumpManagementPage", "downloadEventConfig", "onOpenApp", "scene", RuleConditionBean.OPEN_URL_KEY, "url", "Companion", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AdDownloadActionProviderImpl implements IAdDownloadActionProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdDownloadActionProviderImpl";
    private final boolean inserted;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdDownloadActionProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
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

    public AdDownloadActionProviderImpl() {
        if (GlobalInfo.getDownloadActionFactory() == null) goto L5;
        boolean r100 = true;
    L6:
        this.inserted = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadActionProvider
    public boolean openUrl(Context r100, String r101) {
        if (this.inserted == false) goto L7;
        IAdDownloadActionProvider r102 = GlobalInfo.getDownloadActionFactory();
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.openUrl(r100, r101);
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, RuleConditionBean.OPEN_URL_KEY, "未注入跳转能力,执行失败");
        return false;
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadActionProvider
    public void onItemStart(Context r100, DownloadModel r101, DownloadController r102) {
        if (this.inserted == false) goto L7;
        IAdDownloadActionProvider r103 = GlobalInfo.getDownloadActionFactory();
        if (r103 == null) goto L9;
        r103.onItemStart(r100, r101, r102);
        return;
    L9:
        return;
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onItemStart", "未注入跳转能力,执行失败");
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadActionProvider
    public void onItemClick(Context r100, DownloadModel r101, DownloadController r102, DownloadEventConfig r103) {
        if (this.inserted == false) goto L7;
        IAdDownloadActionProvider r104 = GlobalInfo.getDownloadActionFactory();
        if (r104 == null) goto L9;
        r104.onItemClick(r100, r101, r102, r103);
        return;
    L9:
        return;
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onItemClick", "未注入跳转能力,执行失败");
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadActionProvider
    public void onJumpManagementPage(Context r100, DownloadModel r101, DownloadController r102, DownloadEventConfig r103) {
        if (this.inserted == false) goto L7;
        IAdDownloadActionProvider r104 = GlobalInfo.getDownloadActionFactory();
        if (r104 == null) goto L9;
        r104.onJumpManagementPage(r100, r101, r102, r103);
        return;
    L9:
        return;
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onJumpManagementPage", "未注入跳转能力,执行失败");
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadActionProvider
    public void onDelayCheckOpenAppState(Context r100, DownloadModel r110, DownloadController r111, DownloadEventConfig r112, String r113, String r114) {
        if (this.inserted == false) goto L7;
        IAdDownloadActionProvider r101 = GlobalInfo.getDownloadActionFactory();
        if (r101 == null) goto L9;
        r101.onDelayCheckOpenAppState(r100, r110, r111, r112, r113, r114);
        return;
    L9:
        return;
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onDelayCheckOpenAppState", "未注入跳转能力,执行失败");
    }

    @Override // com.ss.android.download.api.runtime.IAdDownloadActionProvider
    public void onOpenApp(Context r100, DownloadModel r110, DownloadController r111, DownloadEventConfig r112, String r113, String r114) {
        if (this.inserted == false) goto L7;
        IAdDownloadActionProvider r101 = GlobalInfo.getDownloadActionFactory();
        if (r101 == null) goto L9;
        r101.onOpenApp(r100, r110, r111, r112, r113, r114);
        return;
    L9:
        return;
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onOpenApp", "未注入跳转能力,执行失败");
    }
}
