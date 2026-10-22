package com.ss.android.cert.manager.web;

import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface ICertJsbDefine {
    void addEventListener(IBridgeContext r100, String r101);

    void canIUseNFC(IBridgeContext r100);

    void closePage(IBridgeContext r100, JSONObject r101);

    void doOCR(IBridgeContext r100);

    void doRequest(IBridgeContext r100, String r101, String r102, JSONObject r103);

    void faceLive(IBridgeContext r100, String r101, String r102, boolean r103, JSONObject r104, JSONObject r105, JSONObject r106, JSONObject r107, boolean r108, String r110);

    void faceVideoLive(IBridgeContext r100, String r101, String r102, JSONObject r103);

    void fetch(IBridgeContext r100, String r101, String r102, String r103, String r104, String r105, String r106, long r107, boolean r110);

    void hideLoading(IBridgeContext r100);

    void launchFlow(IBridgeContext r100, String r101, String r102, String r103, String r104, JSONObject r105);

    void manuallyVerify(IBridgeContext r100, String r101, String r102, String r103, String r104, int r105);

    void openAndClose(IBridgeContext r100, JSONObject r101, String r102);

    void openCNNetAuth(IBridgeContext r100, int r101);

    void openLoginPage(IBridgeContext r100);

    void openPage(IBridgeContext r100, String r101, String r102, String r103, int r104);

    void openVideoRecord(IBridgeContext r100, JSONObject r101, String r102, String r103);

    void preManualCheck(IBridgeContext r100, String r101, String r102, String r103);

    void receiveWebEvent(IBridgeContext r100, String r101, JSONObject r102);

    void removeEventListener(IBridgeContext r100, String r101);

    void sendAppLog(IBridgeContext r100, String r101, JSONObject r102);

    void sendEvent(IBridgeContext r100, String r101, JSONObject r102);

    void setCertStatus(IBridgeContext r100, int r101, int r102, int r103);

    void setPageLoaded(IBridgeContext r100);

    void showDialog(IBridgeContext r100, int r101, int r102, String r103, String r104, String r105, String r106);

    void showLoading(IBridgeContext r100, String r101);

    void showToast(IBridgeContext r100, String r101);

    void startNFC(IBridgeContext r100, String r101);

    void stopNFC(IBridgeContext r100);

    void switchLanguage(IBridgeContext r100, String r101);

    void takeOCRPhoto(IBridgeContext r100, String r101, String r102);

    void takePhoto(IBridgeContext r100, int r101, int r102, String r103, boolean r104, String r105, String r106, String r107, String r108, boolean r110, boolean r111, boolean r112, String r113);

    void trackFlowAbility(IBridgeContext r100, String r101);

    void uploadEvent(IBridgeContext r100, String r101, JSONObject r102);

    void uploadFile(IBridgeContext r100, String r101, String r102, String r103, String r104);

    void uploadPhoto(IBridgeContext r100, String r101, int r102);
}
