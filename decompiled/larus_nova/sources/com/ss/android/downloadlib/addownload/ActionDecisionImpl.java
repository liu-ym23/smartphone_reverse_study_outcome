package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.ActionDecisionApi;

/* JADX INFO: loaded from: classes34.dex */
public class ActionDecisionImpl extends ActionUnitDecisionImpl implements ActionDecisionApi {
    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldAppLink() {
        return unitShouldAppLink();
    }

    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldBeginDownload() {
        if (unitShouldAppLink() == false) goto L6;
        return false;
    L6:
        if (unitShouldOpenMarket() == false) goto L9;
        return false;
    L9:
        if (this.actionType == 2) goto L12;
        return false;
    L12:
        if (unitShouldBeginDownload() == true) goto L14;
        return false;
    L14:
        if (unitShouldOpenWeb() == true) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldContinueDownload() {
        if (unitShouldAppLink() == false) goto L6;
        return false;
    L6:
        if (unitShouldOpenMarket() == false) goto L9;
        return false;
    L9:
        if (this.actionType == 2) goto L12;
        return false;
    L12:
        if (unitShouldBeginDownload() == false) goto L14;
    L18:
        return false;
    L14:
        if (unitShouldOpenWeb() == true) goto L18;
        return unitShouldContinueDownload();
    }

    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldInstallApp() {
        return unitShouldInstallApp();
    }

    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldOpenMarket() {
        if (unitShouldAppLink() == false) goto L5;
    L7:
        return false;
    L5:
        if (unitShouldOpenMarket() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldOpenWeb() {
        if (unitShouldAppLink() == false) goto L6;
        return false;
    L6:
        if (this.actionType != 1) goto L10;
        return !unitShouldInstallApp();
    L10:
        if (unitShouldOpenMarket() == false) goto L13;
        return false;
    L13:
        if (unitShouldBeginDownload() == true) goto L15;
        return false;
    L15:
        if (unitShouldOpenWeb() == false) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.ss.android.download.api.ActionDecisionApi
    public boolean shouldPauseDownload() {
        if (unitShouldAppLink() == false) goto L6;
        return false;
    L6:
        if (unitShouldOpenMarket() == false) goto L9;
        return false;
    L9:
        if (this.actionType == 2) goto L12;
        return false;
    L12:
        if (unitShouldBeginDownload() == false) goto L14;
    L18:
        return false;
    L14:
        if (unitShouldOpenWeb() == true) goto L18;
        return unitShouldPauseDownload();
    }

    public ActionDecisionImpl(CommonDownloadHandler r100, int r101) {
        super(r100, r101);
    }
}
