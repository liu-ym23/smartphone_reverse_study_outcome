package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.ActionUnitDecisionApi;
import com.ss.android.downloadlib.applink.AdMarketOpenSubManager;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes34.dex */
public class ActionUnitDecisionImpl implements ActionUnitDecisionApi {
    protected int actionType;
    protected CommonDownloadHandler handler;
    protected DownloadHelper helper;
    protected AdMarketOpenSubManager marketManager;

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldAppLink() {
        return ToolUtils.isInstalledApp(this.helper.nativeDownloadModel.getModel());
    }

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldBeginDownload() {
        return this.handler.needBeginDownload();
    }

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldContinueDownload() {
        DownloadInfo r100 = this.handler.mDownloadInfo;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getStatus() != (-2)) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldInstallApp() {
        return this.helper.shouldStartInstallView(this.handler.mDownloadInfo);
    }

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldOpenMarket() {
        return this.marketManager.shouldOpenMarket(this.helper.nativeDownloadModel, this.actionType, null);
    }

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldOpenWeb() {
        if (this.actionType == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.helper.shouldOpenWeb(this.handler.mIsNormalScene) == false) goto L7;
        return true;
    }

    @Override // com.ss.android.download.api.ActionUnitDecisionApi
    public boolean unitShouldPauseDownload() {
        DownloadInfo r100 = this.handler.mDownloadInfo;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ReverseWifiHelper.willPause(r100.getStatus());
    }

    public ActionUnitDecisionImpl(CommonDownloadHandler r100, int r101) {
        this.handler = r100;
        this.helper = r100.mHelper;
        this.actionType = r101;
        this.marketManager = AdMarketOpenSubManager.getInstance();
        this.helper.setAdId(r100.mCurrentId);
    }
}
