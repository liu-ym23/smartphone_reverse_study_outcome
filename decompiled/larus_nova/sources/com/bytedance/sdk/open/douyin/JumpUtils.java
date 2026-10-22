package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class JumpUtils {
    public JumpUtils() {
    }

    public static boolean jumpProductionManager(Activity r100, String r101, String r102, String r103, String r104) {
        if (r100 != null) goto L5;
    L20:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        DouYinOpenApi r105 = a.create(r100);
        if (r105 != null) goto L10;
    L19:
        Toast.makeText(r100, "当前抖音版本过低，请将抖音更新到最新版本", 0).show();
        goto L20
    L10:
        if (r105.isSupportCommonAbility(3) == false) goto L19;
        CommonAbility.Request r106 = new CommonAbility.Request();
        r106.commonType = 3;
        r106.mState = "jump_producation_from_sdk";
        r106.callerLocalEntry = r103;
        Bundle r107 = new Bundle();
        r107.putString(WindowEvent.Params.LAUNCH_METHOD, r102);
        r107.putString("show_card_type", r104);
        r106.extras = r107;
        JSONObject r108 = new JSONObject();
        r108.put("from_open_id", r101);     // Catch: JSONException -> L15
    L17:
        r106.data = r108.toString();
        return r105.openCommon(r106);
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean jumpToDouyinIM(Activity r100, String r101, String r102, String r103, String r104) {
        if (r100 != null) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if (TextUtils.isEmpty(r102) == true) goto L22;
        DouYinOpenApi r105 = a.create(r100);
        if (r105 != null) goto L12;
    L21:
        Toast.makeText(r100, "当前抖音版本过低，请将抖音更新到最新版本", 0).show();
        goto L22
    L12:
        if (r105.isSupportCommonAbility(2) == false) goto L21;
        CommonAbility.Request r106 = new CommonAbility.Request();
        r106.commonType = 2;
        r106.mState = "jump_im_from_sdk";
        r106.callerLocalEntry = r104;
        Bundle r107 = new Bundle();
        r107.putString(WindowEvent.Params.LAUNCH_METHOD, r103);
        r106.extras = r107;
        JSONObject r108 = new JSONObject();
        r108.put("from_open_id", r101);     // Catch: JSONException -> L17
        r108.put("target_open_id", r102);     // Catch: JSONException -> L17
    L19:
        r106.data = r108.toString();
        return r105.openCommon(r106);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static boolean jumpToDouyinProfile(Activity r100, String r101, String r102, String r103, String r104) {
        if (r100 != null) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if (TextUtils.isEmpty(r102) == true) goto L22;
        DouYinOpenApi r105 = a.create(r100);
        if (r105 != null) goto L12;
    L21:
        Toast.makeText(r100, "当前抖音版本过低，请将抖音更新到最新版本", 0).show();
        goto L22
    L12:
        if (r105.isSupportCommonAbility(1) == false) goto L21;
        CommonAbility.Request r106 = new CommonAbility.Request();
        r106.commonType = 1;
        r106.mState = "jump_profile_from_sdk";
        r106.callerLocalEntry = r104;
        Bundle r107 = new Bundle();
        r107.putString(WindowEvent.Params.LAUNCH_METHOD, r103);
        r106.extras = r107;
        JSONObject r108 = new JSONObject();
        r108.put("from_open_id", r101);     // Catch: JSONException -> L17
        r108.put("target_open_id", r102);     // Catch: JSONException -> L17
    L19:
        r106.data = r108.toString();
        return r105.openCommon(r106);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
