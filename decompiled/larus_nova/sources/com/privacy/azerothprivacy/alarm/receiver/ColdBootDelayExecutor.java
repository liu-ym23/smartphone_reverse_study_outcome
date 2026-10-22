package com.privacy.azerothprivacy.alarm.receiver;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import apa.a;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.privacy.azerothprivacy.AzerothPrivacy;
import dpa.c;
import dpa.d;
import dpa.g;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import roa.b;

/* JADX INFO: loaded from: classes5.dex */
public class ColdBootDelayExecutor extends AzerothCustomReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f404394a = 0;

    @Override // com.privacy.azerothprivacy.alarm.receiver.AzerothCustomReceiver
    public final long a() {
        return 10000;
    }

    public ColdBootDelayExecutor() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r110, Intent r111) {
        a.a("DelayInitiator", "onReceive start");
        c r100 = d.a();
        a.a("EnvReporter", r100.toString());
        if (r100.azerothGlobalSettings.global_function_switch == true) goto L5;
    L35:
        DateFormat r101 = b.f538803a;
        if (d.a().azerothGlobalSettings.global_function_switch == true) goto L38;
    L44:
        Runnable r112 = new roa.a();
        fpa.c.f478390a.execute(r112);
        a.a("DelayInitiator", "onReceive end");
        return;
    L38:
        if (d.a().dailyReportSetting.enabled == false) goto L44;
        String r102 = b.f538803a.format(new Date());
        epa.a.b(r110).getClass();
        if (r102.equals(epa.a.f473440b.getString("DailyReporter.lastReportDate", "")) == false) goto L43;
        a.a("DailyReporter", "have reported today, skip");
        goto L44
    L43:
        a.a("DailyReporter", "report daily...");
        bpa.a.b("daily_user", null, null, null);
        epa.a.b(r110).getClass();
        epa.a.e("DailyReporter.lastReportDate", r102);
        goto L44
    L5:
        if (r100.envReportSetting.enabled == false) goto L35;
        epa.a.b(r110).getClass();
        long r103 = epa.a.c("EnvReporter.lastReportTime");
        int r104 = r100.envReportSetting.min_report_interval;
        if (r104 <= 0) goto L10;
        long r105 = ((long) r104) * 1000;
    L12:
        if ((System.currentTimeMillis() - r103) < r105) goto L35;
        JSONObject r106 = new JSONObject();
        g r107 = r100.envReportSetting;
        if (r107 != null) goto L17;
    L46:
        r106.put("user_id", AzerothPrivacy.getAppInfo().f530146e);     // Catch: JSONException -> L32
        r106.put("settings", r100.toString());     // Catch: JSONException -> L32
    L34:
        bpa.a.b("env", null, null, r106);
        a.a("EnvReporter", "report env...");
        epa.a r108 = epa.a.b(r110);
        long r109 = System.currentTimeMillis();
        r108.getClass();
        epa.a.d("EnvReporter.lastReportTime", r109);
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L17:
        if (r107.collect_android_id == false) goto L46;
        String r113 = woa.a.a(r110.getContentResolver());     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r113) == false) goto L25;
    L23:
        r113 = "";
    L25:
        if (TextUtils.isEmpty(r113) == true) goto L46;
        r106.put("android_id", r113);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L10:
        r105 = LocationInfoConst.defaultsOverseasCacheValidity;
        goto L12
    }
}
