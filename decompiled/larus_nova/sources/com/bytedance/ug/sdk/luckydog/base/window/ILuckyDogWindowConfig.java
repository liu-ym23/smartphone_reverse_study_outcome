package com.bytedance.ug.sdk.luckydog.base.window;

import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import ll7.b;
import ll7.c;
import ll7.f;
import ll7.h;
import org.json.JSONObject;
import wl7.a;

/* JADX INFO: loaded from: classes22.dex */
public interface ILuckyDogWindowConfig {
    void checkShowColdPopup();

    void checkShowFlexibleDialog();

    void checkShowNotification();

    c createDialogRequest(f r100);

    void dialogEnqueueShow(f r100);

    void handleFeedback(JSONObject r100);

    void handleFeedbackInDebug(JSONObject r100);

    void onProcessPopupDialog(b r100, f r101, a r102, String r103);

    void onShowData(h r100);

    void registerBridgeV3(WebView r100, Lifecycle r101);

    boolean showLowUpdateDialog();

    void showPopupDialog(f r100);

    void tryShowDialog(boolean r100);

    void tryShowNotification();
}
