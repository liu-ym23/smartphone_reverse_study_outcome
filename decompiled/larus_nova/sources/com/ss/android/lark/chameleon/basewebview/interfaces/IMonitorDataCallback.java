package com.ss.android.lark.chameleon.basewebview.interfaces;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J,\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/interfaces/IMonitorDataCallback;", "", "monitorStatusAndDuration", "", "serviceName", "", "status", "", "duration", "Lorg/json/JSONObject;", "logExtr", "webViewType", "monitorWhiteScreen", "url", "isWhiteScreen", "", "webViewIsDestroy", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IMonitorDataCallback {
    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103, String r104);

    void monitorWhiteScreen(String r100, boolean r101, String r102, boolean r103);
}
