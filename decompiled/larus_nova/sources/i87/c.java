package i87;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v67.u;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f488669b;

    public final void a() {
        if (TextUtils.isEmpty(this.f488668a) == false) goto L6;
        com.bytedance.push.utils.f.b("UidSync", "action is null");
        return;
    L6:
        Application r100 = AppProvider.getApp();
        monitor-enter(d.class);
        d.a(r100);     // Catch: Throwable -> L79
        Map<Integer, y67.f> r101 = d.f488670a;     // Catch: Throwable -> L79
        if (r101 != null) goto L13;
        monitor-exit(d.class);
        Map r102 = null;
    L15:
        if (r102 != null) goto L17;
    L77:
        com.bytedance.push.utils.f.b("UidSync", "token is empty");
        return;
    L17:
        if (r102.isEmpty() == true) goto L77;
        JSONArray r103 = new JSONArray();
        Iterator r104 = r102.values().iterator();
    L21:
        if (r104.hasNext() == false) goto L65;
        y67.f r105 = (y67.f) r104.next();
        if (r105 == null) goto L64;
        if (r105.f566393e <= 0) goto L64;
        if (TextUtils.isEmpty(r105.f566392d) == true) goto L64;
        IPushAdapter r106 = PushChannelHelper.inst(r100).getAdapterInstance(r105.f566393e);
        com.bytedance.push.utils.f.b("UidSync", "pushAdapter: " + r106 + " mAction:" + this.f488668a);
        String r107 = this.f488668a;
        r107.getClass();
        int r108 = r107.hashCode();
        if (r108 == (-1797256964)) goto L45;
        if (r108 == 119615063) goto L41;
        if (r108 == 327471105) goto L37;
    L46:
        byte r109 = -1;
    L48:
        if (r109 == 0) goto L55;
        if (r109 == 1) goto L53;
        if (r109 != 2) goto L54;
        f77.a r110 = (f77.a) PushSupporter.get().getIProfileIdService();
        r110.getClass();
        com.bytedance.push.utils.f.b("ProfileIdServiceImpl", "onAccountSwitch");
        r110.a(r106, false);
        String r111 = r110.b(r106);
    L56:
        JSONObject r112 = new JSONObject();
        r112.put("sender_id", r105.f566393e);     // Catch: JSONException -> L62
        r112.put("token", r105.f566392d);     // Catch: JSONException -> L62
        if (TextUtils.isEmpty(r111) == true) goto L60;
        r112.put("profile_id", r111);     // Catch: JSONException -> L62
    L60:
        r103.put(r112);     // Catch: JSONException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
    L54:
        r111 = null;
        goto L56
    L53:
        f77.a r113 = (f77.a) PushSupporter.get().getIProfileIdService();
        r113.getClass();
        com.bytedance.push.utils.f.b("ProfileIdServiceImpl", "onLogOut");
        r113.a(r106, false);
        goto L54
    L55:
        f77.a r114 = (f77.a) PushSupporter.get().getIProfileIdService();
        r114.getClass();
        com.bytedance.push.utils.f.b("ProfileIdServiceImpl", "onLogIn");
        r111 = r114.b(r106);
        goto L56
    L37:
        if (r107.equals("passport_switch") == false) goto L46;
        r109 = 2;
        goto L48
    L41:
        if (r107.equals("passport_logout") == false) goto L46;
        r109 = 1;
        goto L48
    L45:
        if (r107.equals("passport_login") == false) goto L46;
        r109 = 0;
    L64:
        com.bytedance.push.utils.f.b("UidSync", "invalid cache : " + r105);
        goto L21
    L65:
        Map<String, String> r115 = this.f488669b.getCommonParams();
        r115.put("update_event", this.f488668a);
        Set<Integer> r116 = yfc.d.f567458a;
        String r117 = ToolUtils.addUrlParam(yfc.a.a("/service/1/update_token/"), r115);
        ArrayList r118 = new ArrayList();
        r118.add(new Pair("sender_token_list", r103.toString()));
        r118.add(new Pair("push_sdk", PushChannelHelper.inst(r100).buildApplogHeader().toString()));
        int r119 = 0;
    L66:
        if (r119 >= 2) goto L76;
        com.bytedance.push.utils.f.b("UidSync", "request url = " + r117);     // Catch: Throwable -> L73
        NetworkClient.ReqContext r120 = new NetworkClient.ReqContext();     // Catch: Throwable -> L73
        r120.addCommonParams = false;     // Catch: Throwable -> L73
        if ("success".equals(new JSONObject(NetworkClient.getDefault().post(r117, r118, ToolUtils.addNetworkTagToHeader(null), r120)).optString("message")) == false) goto L75;
        sgc.a r121 = (sgc.a) rgc.b.a(sgc.a.class);     // Catch: Throwable -> L73
        com.bytedance.push.utils.f.g("UidSync", "success sync uid-token to server,set last_sec_uid,accountService=" + r121);     // Catch: Throwable -> L73
        if (r121 == null) goto L103;
        String r122 = r121.getSecUid();     // Catch: Throwable -> L73
        com.bytedance.push.utils.f.g("UidSync", "success sync uid-token to server,set last_sec_uid,secUid=" + r122);     // Catch: Throwable -> L73
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L73
        com.ss.android.pushmanager.setting.b.c().k(r122);     // Catch: Throwable -> L73
        return;
    L103:
        return;
    L75:
        r119 = r119 + 1;
    L73:
        th = move-exception;
        th.printStackTrace();
        goto L75
    L76:
        return;
    L13:
        r102 = Collections.unmodifiableMap(r101);     // Catch: Throwable -> L79
        monitor-exit(d.class);
    L79:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = b.f488660f;     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        a();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
    L13:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }

    public c(u r100, String r101) {
        this.f488669b = r100;
        this.f488668a = r101;
    }
}
