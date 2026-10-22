package i87;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.e0;
import com.bytedance.push.notification.n;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.third.PushManager;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import j77.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v67.s;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f488671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f488672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile AtomicBoolean f488673c;

    public e(s r100) {
        this.f488673c = new AtomicBoolean(false);
        this.f488671a = r100;
    }

    public final synchronized void c(boolean r310) {
        monitor-enter(this);
        Application r110 = AppProvider.getApp();     // Catch: Throwable -> L92
        LocalFrequencySettings r100 = (LocalFrequencySettings) i.a(r110, LocalFrequencySettings.class);     // Catch: Throwable -> L92
        PushOnlineSettings r101 = (PushOnlineSettings) i.a(r110, PushOnlineSettings.class);     // Catch: Throwable -> L92
        long r102 = ToolUtils.currentTimeMillis();     // Catch: Throwable -> L92
        long r111 = r100.l0();     // Catch: Throwable -> L92
        if (Math.abs(r102 - r111) >= r101.t()) goto L7;
        boolean r112 = true;
    L8:
        String r103 = r100.H();     // Catch: Throwable -> L92
        String r113 = r100.d();     // Catch: Throwable -> L92
        String r104 = r100.p0();     // Catch: Throwable -> L92
        String r105 = r100.s0();     // Catch: Throwable -> L92
        String r106 = r100.k0();     // Catch: Throwable -> L92
        Map<String, String> r107 = PushSupporter.get().getCommonParams();     // Catch: Throwable -> L92
        String r114 = r107.get("device_id");     // Catch: Throwable -> L92
        String r115 = r107.get("version_code");     // Catch: Throwable -> L92
        String r116 = r107.get("update_version_code");     // Catch: Throwable -> L92
        String r108 = r107.get("channel");     // Catch: Throwable -> L92
        String r109 = r107.get("alias");     // Catch: Throwable -> L92
        com.bytedance.push.utils.f.g("UpdateSenderTask", "handleAppLogUpdate requestFrequent=" + r112 + ",lastDeviceId=" + r103 + ",deviceId=" + r114 + ",lastVersionCode=" + r113 + ",versionCode=" + r115 + ",lastUpdateVersionCode=" + r104 + ",updateVersionCode=" + r116 + ",lastChannel=" + r105 + ",channel=" + r108 + ",lastAlias=" + r106 + ",alias=" + r109 + ",forceUpdate=" + r310);     // Catch: Throwable -> L92
        if (r112 == false) goto L12;
        com.bytedance.push.utils.f.g("UpdateSenderTask", "requestFrequent is true,current=" + r102 + ",lastTime=" + r111);     // Catch: Throwable -> L92
    L12:
        ((e0) this.f488671a).getClass();     // Catch: Throwable -> L92
        boolean r117 = !TextUtils.equals(PushChannelHelper.inst(r110).buildApplogHeader().toString(), ((LocalFrequencySettings) i.a(r110, LocalFrequencySettings.class)).A());     // Catch: Throwable -> L92
        if (TextUtils.equals(r103, r114) == true) goto L15;
    L28:
        boolean r118 = true;
    L29:
        if (r112 == false) goto L34;
        if (r118 == true) goto L34;
        if (r117 == true) goto L34;
        boolean r119 = false;
    L35:
        if (r119 == true) goto L37;
    L38:
        if (r310 == false) goto L78;
    L39:
        b77.a r120 = (b77.a) rgc.b.a(b77.a.class);     // Catch: Throwable -> L92
        if (r120 == null) goto L101;
        r120.p0();     // Catch: Throwable -> L92
    L101:
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L71
        if (com.ss.android.pushmanager.setting.b.e() == false) goto L45;
        String r121 = "0";
    L46:
        r107.put("notice", r121);     // Catch: Throwable -> L71
        r107.put("system_notify_status", ToolUtils.areNotificationsEnabled(AppProvider.getApp()) + "");     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r109) == true) goto L49;
        r107.put("device_login_id", r109);     // Catch: Throwable -> L71
    L49:
        String r122 = "";
    L57:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L71
        com.bytedance.push.utils.f.f("UpdateSenderTask", "error when parse push service version ", th);     // Catch: Throwable -> L71
    L59:
        com.bytedance.push.utils.f.b("UpdateSenderTask", "sysPushVersion:" + r122);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r122) == true) goto L62;
        r107.put("sys_push_version", r122);     // Catch: Throwable -> L71
    L62:
        Set<Integer> r123 = yfc.d.f567458a;     // Catch: Throwable -> L71
        String r124 = ToolUtils.addUrlParam(yfc.a.a("/cloudpush/update_sender/"), r107);     // Catch: Throwable -> L71
        ArrayList r125 = new ArrayList();     // Catch: Throwable -> L71
        String r126 = PushChannelHelper.inst(r110).buildApplogHeader().toString();     // Catch: Throwable -> L71
        r125.add(new Pair("push_sdk", r126));     // Catch: Throwable -> L71
        r125.add(new Pair("live_activity_oem_version", ToolUtils.getFocusPermissionVersion(r110)));     // Catch: Throwable -> L71
        String r127 = ToolUtils.getLaunchActivity(r110);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r127) == true) goto L65;
        r125.add(new Pair("launcher", r127));     // Catch: Throwable -> L71
    L65:
        com.bytedance.push.utils.f.g("Start", "start request sender. support ：" + r126 + ", " + r124);     // Catch: Throwable -> L71
        NetworkClient.ReqContext r128 = new NetworkClient.ReqContext();     // Catch: Throwable -> L71
        r128.addCommonParams = false;     // Catch: Throwable -> L71
        String r129 = PushNetworkClient.getDefault().post(r124, r125, ToolUtils.addNetworkTagToHeader(null), r128);     // Catch: Throwable -> L71
        com.bytedance.push.utils.f.b("Start", "UpdateSenderTask response = " + r129);     // Catch: Throwable -> L71
        b(r129, r110, r126, r114, r115, r116, r108, r109);     // Catch: Throwable -> L69
        this.f488672b = true;     // Catch: Throwable -> L69
    L90:
        monitor-exit(this);
        return;
    L69:
        th = th;
    L74:
        if ((th instanceof CommonHttpException) == false) goto L76;
        int r130 = th.getResponseCode();     // Catch: Throwable -> L92
    L77:
        a(r110, 301, r130, th.getMessage(), Log.getStackTraceString(th));     // Catch: Throwable -> L92
        com.bytedance.push.utils.f.e("Start", "run: UPDATE_SENDER_URL e = " + th.getMessage());     // Catch: Throwable -> L92
        th.printStackTrace();     // Catch: Throwable -> L92
        goto L90
    L76:
        r130 = -100;
        goto L77
    L51:
        if (ToolUtils.isHuaweiDevice() == false) goto L54;
        r122 = AppProvider.getApp().getPackageManager().getPackageInfo("com.huawei.android.pushagent", 0).versionName;     // Catch: Throwable -> L57
    L95:
    L54:
        if (ToolUtils.isOppoDevice() == false) goto L95;
        r122 = AppProvider.getApp().getPackageManager().getPackageInfo("com.heytap.mcs", 0).versionName;     // Catch: Throwable -> L57
        goto L95
    L45:
        r121 = "1";
    L71:
        th = th;
        goto L74
    L78:
        HashMap r131 = new HashMap();     // Catch: Throwable -> L92
        com.ss.android.pushmanager.setting.a.b().c(r131);     // Catch: Throwable -> L92
        String r132 = (String) r131.get("clientudid");     // Catch: Throwable -> L92
        String r133 = (String) r131.get("device_id");     // Catch: Throwable -> L92
        String r134 = (String) r131.get("install_id");     // Catch: Throwable -> L92
        if (StringUtils.isEmpty(r132) == false) goto L81;
    L85:
        boolean r135 = false;
    L86:
        if (r135 == false) goto L90;
        if (this.f488673c.compareAndSet(false, true) == false) goto L90;
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L92
        d(r110, com.ss.android.pushmanager.setting.b.c().g0(), false);     // Catch: Throwable -> L92
        goto L90
    L81:
        if (StringUtils.isEmpty(r133) == true) goto L85;
        if (StringUtils.isEmpty(r134) == true) goto L85;
        r135 = true;
        goto L86
    L37:
        if (this.f488672b == false) goto L39;
    L34:
        r119 = true;
        goto L35
    L15:
        if (TextUtils.equals(r113, r115) == false) goto L28;
        if (TextUtils.equals(r104, r116) == false) goto L28;
        if (TextUtils.equals(r105, r108) == false) goto L28;
        if (TextUtils.isEmpty(r106) == false) goto L25;
        if (TextUtils.isEmpty(r109) == false) goto L25;
    L27:
        r118 = false;
    L25:
        if (TextUtils.equals(r106, r109) == true) goto L27;
    L7:
        r112 = false;
    L92:
        th = move-exception;
        throw th;
    }

    public final void d(Context r100, String r101, boolean r102) {
        b77.a r103 = (b77.a) rgc.b.a(b77.a.class);
        if (r103 == null) goto L5;
        r103.v();
    L5:
        boolean r104 = PushChannelHelper.inst(r100).hasSupportChannel(r101);
        com.bytedance.push.utils.f.g("Start", "tryRegisterServerPush " + r101 + " hasSupport = " + r104);
        boolean r105 = false;
        if (r102 == false) goto L14;
        if (r104 == true) goto L14;
        com.ss.android.pushmanager.setting.b.b().getClass();
        r101 = com.ss.android.pushmanager.setting.b.c().g0();
        if (PushChannelHelper.inst(r100).hasSupportChannel(r101) == true) goto L14;
        PushSupporter.monitor().monitorSenderSupport(false, r101);
        if (r103 == null) goto L59;
        r103.D();
        return;
    L59:
        return;
    L14:
        com.bytedance.push.utils.f.g("Start", "tryRegisterAllSelectedPush: the senders = " + r101);
        if (r102 == false) goto L18;
        if (r104 == false) goto L18;
        boolean r106 = true;
    L19:
        com.bytedance.push.third.a.handlerApplogConfig(r101, r106);
        if (r103 == null) goto L22;
        r103.D();
    L22:
        e0 r107 = (e0) this.f488671a;
        r107.getClass();
    L32:
        th = move-exception;
        th.printStackTrace();
    L34:
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.e() == false) goto L41;
        Iterator r108 = PushChannelHelper.inst(r100).getChannels().iterator();
    L38:
        if (r108.hasNext() == false) goto L40;
        r105 = r105 | r107.b(r100, ((Integer) r108.next()).intValue());
        goto L38
    L40:
        r107.c(r100.getApplicationContext());
    L49:
        PushSupporter.monitor().monitorSenderSupport(r105, r101);
        return;
    L41:
        Iterator r109 = PushChannelHelper.inst(r100).getChannels().iterator();
    L43:
        if (r109.hasNext() == false) goto L48;
        int r110 = ((Integer) r109.next()).intValue();
        if (r100 == null) goto L43;
        PushManager.inst().unregisterPush(r100.getApplicationContext(), r110);
        goto L43
    L48:
        ((ConcurrentHashMap) r107.f266850a).clear();
        goto L49
    L24:
        if (com.bytedance.push.third.a.isServerSupportChannel(PushChannelHelper.inst(r100).getTryRegisterChannelId()) == true) goto L26;
        int r111 = -1;
    L30:
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L32
        com.ss.android.pushmanager.setting.b.c().E(r111);     // Catch: Throwable -> L32
        goto L34
    L26:
        if (com.bytedance.push.utils.f.f267065a == false) goto L28;
        com.bytedance.push.utils.f.b("PushStart", "registerUmPush process = " + ToolUtils.getCurProcessName(r100));     // Catch: Throwable -> L32
    L28:
        r111 = PushChannelHelper.inst(r100).getTryRegisterChannelId();     // Catch: Throwable -> L32
        r105 = r107.b(r100, PushChannelHelper.inst(r100).getTryRegisterChannelId());     // Catch: Throwable -> L32
    L18:
        r106 = false;
        goto L19
    }

    public final void a(Context r100, int r101, int r102, String r103, String r104) {
        PushSupporter.monitor().markUpdateSenderFailed(r101, r102, r103, r104);
        com.bytedance.push.utils.f.e("Start", "request UPDATE_SENDER_URL failed: " + r104);
        PushCommonConfiguration r105 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r101 != 301) goto L13;
        if (r105.mIsDebugMode == true) goto L7;
    L11:
        StringBuilder r106 = new StringBuilder("error when request /cloudpush/update_sender/ , please check whether to configure TLB, url is ");
        Set<Integer> r107 = yfc.d.f567458a;
        r106.append(yfc.a.a("/cloudpush/update_sender/"));
        com.bytedance.push.utils.f.e("UpdateSenderTask", r106.toString());
        goto L13
    L7:
        if (r105.mIPushCommonConfiguration.enableExceptionInDebugModeWhenFatalError() == false) goto L11;
        StringBuilder r108 = new StringBuilder("error when request /cloudpush/update_sender/ , please check whether to configure TLB, url is ");
        Set<Integer> r109 = yfc.d.f567458a;
        r108.append(yfc.a.a("/cloudpush/update_sender/"));
        throw new RuntimeException(r108.toString());
    L13:
        if (this.f488673c.compareAndSet(false, true) == false) goto L16;
        com.ss.android.pushmanager.setting.b.b().getClass();
        d(r100, com.ss.android.pushmanager.setting.b.c().g0(), false);
        return;
    }

    public final void b(String r110, Application r111, String r112, String r113, String r114, String r115, String r116, String r117) throws JSONException {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        a(r111, 304, -1, null, r110);
        return;
    L6:
        JSONObject r100 = new JSONObject(r110);
        if (TextUtils.equals("success", r100.optString("message")) == true) goto L10;
        a(r111, 302, -1, null, r110);
        return;
    L10:
        PushSupporter.get().setFrontierSetting(r100.optJSONObject("frontier_setting"));
        JSONArray r101 = r100.optJSONArray("channels");
        boolean r102 = false;
        if (r101 != null) goto L13;
    L46:
        String r103 = r100.optString("allow_push_list");
        if (TextUtils.isEmpty(r103) == false) goto L50;
        a(r111, 303, -1, null, r110);
        return;
    L50:
        LocalFrequencySettings r104 = (LocalFrequencySettings) i.a(r111, LocalFrequencySettings.class);
        r104.i(ToolUtils.currentTimeMillis());
        r104.S(r113);
        r104.a(r114);
        r104.v0(r115);
        r104.i0(r116);
        r104.M(r112);
        r104.O(r117);
        if (new JSONArray(r103).length() <= 0) goto L56;
        r102 = true;
    L56:
        if (r102 == true) goto L58;
        a(r111, 303, -1, null, r110);
    L59:
        this.f488673c.set(true);
        d(AppProvider.getApp(), r103, true);
        return;
    L58:
        PushSupporter.monitor().markUpdateSenderSuccess();
    L54:
        e = move-exception;
        e.printStackTrace();
        goto L56
    L13:
        if (r101.length() <= 0) goto L46;
        ArrayList r105 = new ArrayList();
        int r106 = 0;
    L17:
        if (r106 >= r101.length()) goto L28;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r101, r106);     // Catch: JSONException -> L25
        String r108 = r107.optString("id");     // Catch: JSONException -> L25
        String r118 = r107.optString("name");     // Catch: JSONException -> L25
        if (TextUtils.isEmpty(r108) == true) goto L27;
        if (TextUtils.isEmpty(r118) == true) goto L27;
        r105.add(new y67.d(r107));     // Catch: JSONException -> L25
    L27:
        r106 = r106 + 1;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    L28:
        ((n) PushSupporter.get().getNotificationService()).getClass();
        if (CollectionUtils.isEmpty(r105) == true) goto L46;
        Iterator r109 = r105.iterator();
    L33:
        if (r109.hasNext() == false) goto L46;
        y67.d r119 = (y67.d) r109.next();
        if (r119 == null) goto L33;
        if (r119.f566377b == true) goto L39;
        if (TextUtils.equals(r119.f566378c, "push") == true) goto L33;
        com.bytedance.push.notification.i.f266961a.c(r111, r119);     // Catch: Exception -> L44
        goto L33
    L39:
        com.bytedance.push.notification.i.f266961a.d(r111, r119);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }
}
