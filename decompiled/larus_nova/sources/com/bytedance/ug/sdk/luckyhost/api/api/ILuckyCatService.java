package com.bytedance.ug.sdk.luckyhost.api.api;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import pi7.b;
import pi7.c;
import pi7.e;
import pi7.f;
import pi7.h;
import uc7.a;
import vi7.g;

/* JADX INFO: loaded from: classes22.dex */
public interface ILuckyCatService {
    public static final String ACTION_BEGIN_LISTENING = "beginListening";
    public static final String ACTION_STOP_LISTENING = "stopListening";

    void checkForeground();

    void checkInviteCode();

    boolean checkInviteCode(String r100);

    void executeGet(String r100, Map<String, String> r101, f r102);

    void executeGet(String r100, f r101);

    void executePost(String r100, JSONObject r101, f r102);

    a getBridgeMonitorInterceptor();

    String getGeckoOfflinePath(String r100);

    g getH5TaskTabFragment();

    Object getLuckyCatBulletPackageBundle();

    List<Class<? extends XBridgeMethod>> getLuckyCatXBridges(boolean r100);

    kl7.a getLuckyLynxView(Context r100);

    g getLynxTaskTabFragment();

    void getReward(String r100, JSONObject r101, b r102);

    void getTaskList(String r100, f r101);

    g getTaskTabFragment();

    g getTaskTabFragment(String r100);

    ui7.a getTimerTask(h r100);

    void getUserInfo(c r100);

    boolean hadShowBigRedPacket();

    void initLuckyCatLynxServices();

    boolean isTigerBlockRequest();

    void onListenStatusChange(String r100);

    void onLynxPluginReady();

    void openLuckCatProjectMode(Activity r100);

    boolean openLuckyCatLynxPageWithInitData(Context r100, String r101, JSONObject r102);

    void registerXBridges(List<Class<? extends XBridgeMethod>> r100);

    void removeRedPacketRequestCallback();

    void requestRedPacketActivityData(e r100);

    void requestRedPacketActivityData(e r100, HashMap<String, String> r101);

    void sendEventToLuckyCatWebView(String r100, JSONObject r101);

    void sendEventToLynxView(String r100, JSONObject r101);

    void setFissionEnable(boolean r100);

    void setRedPacketRequestCallback(qj7.a.f r100);

    boolean tryShowBigRedPacket(Activity r100, pi7.a r101);

    void tryUpdatePageUrlConfig();
}
