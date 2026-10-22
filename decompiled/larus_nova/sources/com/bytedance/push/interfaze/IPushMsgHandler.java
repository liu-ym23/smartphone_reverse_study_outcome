package com.bytedance.push.interfaze;

import android.content.Context;
import android.content.Intent;
import com.bytedance.push.PushBody;
import com.bytedance.push.b0;
import com.bytedance.push.client.intelligence.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IPushMsgHandler {
    b handleMessageShow(b0 r100);

    void handlePassThroughMsg(String r100, int r101, String r102);

    void handlePassThroughMsg(JSONObject r100, int r101, String r102);

    void handlePassThroughMsg(JSONObject r100, int r101, String r102, boolean r103);

    boolean onClickMsg(Context r100, String r101, int r102, String r103);

    boolean showNotification(int r100, PushBody r101, boolean r102, boolean r103, boolean r104, String r105, long r106);

    void trackClickPush(Context r100, long r101, String r102, String r103, boolean r104, JSONObject r105, boolean r106);

    void trackClickPush(Context r100, Intent r101, String r102, JSONObject r103);

    void trackClickPush(Context r100, PushBody r101, boolean r102, JSONObject r103);

    void trySupplyIntentData(Intent r100);
}
