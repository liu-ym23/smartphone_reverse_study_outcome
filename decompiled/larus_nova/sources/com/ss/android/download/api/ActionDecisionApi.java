package com.ss.android.download.api;

/* JADX INFO: loaded from: classes34.dex */
public interface ActionDecisionApi extends ActionUnitDecisionApi {
    boolean shouldAppLink();

    boolean shouldBeginDownload();

    boolean shouldContinueDownload();

    boolean shouldInstallApp();

    boolean shouldOpenMarket();

    boolean shouldOpenWeb();

    boolean shouldPauseDownload();
}
