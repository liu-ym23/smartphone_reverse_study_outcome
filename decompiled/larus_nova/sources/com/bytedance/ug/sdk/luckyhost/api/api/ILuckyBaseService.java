package com.bytedance.ug.sdk.luckyhost.api.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import bk7.c;
import com.bytedance.ug.sdk.luckydog.api.model.CrossZoneUserType;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import gk7.j;
import gk7.l;
import gn7.f;
import java.util.Map;
import kk7.a;
import kk7.b;
import org.json.JSONObject;
import ti7.e;
import zl7.k;

/* JADX INFO: loaded from: classes3.dex */
public interface ILuckyBaseService {
    String addCommonParams(String r100);

    void checkIsCrossZoneUser(long r100, CrossZoneUserType r101, boolean r102, b r103);

    boolean closeSchema(Context r100, String r101);

    void doActionWithToken(String r100, String r101, String r102, String r103, JSONObject r104, a r105);

    void doActionWithToken(String r100, String r101, String r102, JSONObject r103, a r104);

    void executeTask(tk7.a r100, l r101);

    boolean getABTestShouldShowCrossoverGuide();

    String getRedirectSchema(String r100);

    Map<String, String> getSDKCommonParams();

    long getServerTime();

    ILuckyDogCommonSettingsService getSettingsService();

    boolean isLuckyProxySchema(String r100);

    boolean isLuckySchema(String r100);

    boolean isLuckySchema(String r100, String... r101);

    boolean isSDKInited();

    void onAccountBindUpdate();

    void onAccountRefresh(boolean r100);

    void onBasicModeRefresh(boolean r100);

    void onDeviceIdUpdate(String r100);

    void onDeviceStatusChanged(int r100, Bundle r101);

    void onHostRouteFail(String r100);

    void onHostRouteStart(String r100);

    void onHostRouteSuccess(String r100);

    void onPrivacyOk();

    void onTeenModeRefresh(boolean r100);

    void openLynxDialog(FragmentActivity r100, String r101, c r102);

    void openSchema(Context r100, String r101, k r102);

    void openSchema(Context r100, String r101, k r102, gn7.a r103);

    boolean openSchema(Context r100, String r101);

    boolean openSchema(Context r100, String r101, gn7.a r102);

    boolean openSchema(Context r100, e r101);

    void putCommonParams(Map<String, String> r100);

    void registerNotifyCheckCrossCallback(gk7.c r100);

    boolean registerRouteInterceptor(f r100);

    void registerServerTimeListener(j r100);

    void registerTaskClazz(String r100, Class<? extends bl7.a> r101);

    void setAppId(String r100);

    void setCrossOverGuideListener(cl7.b r100);

    void stashPopTaskById(String r100, l r101);

    void stashPopTaskByType(String r100, l r101);

    void stashPopTaskByUniqueType(String r100, l r101);

    void stashTask(String r100, tk7.a r101);

    void stopTaskById(String r100);

    void unRegisterNotifyCheckCrossCallback(gk7.c r100);

    void unRegisterTaskClazz(String r100);

    void unregisterServerTimeListener(j r100);

    void updateSettings(JSONObject r100);
}
