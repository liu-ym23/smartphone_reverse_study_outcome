package com.bytedance.push.notification;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f266978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f266980c;

    public final void a() {
        com.ss.android.pushmanager.setting.b.b().getClass();
        boolean r100 = com.ss.android.pushmanager.setting.b.e();
        LocalFrequencySettings r101 = (LocalFrequencySettings) j77.i.a(this.f266978a, LocalFrequencySettings.class);
        PushOnlineSettings r102 = (PushOnlineSettings) j77.i.a(this.f266978a, PushOnlineSettings.class);
        long r103 = ToolUtils.currentTimeMillis();
        long r104 = r101.t();
        long r105 = r102.x();
        long r106 = Math.abs(r103 - r104);
        if (r106 <= r105) goto L5;
        boolean r110 = true;
    L6:
        com.bytedance.push.utils.f.b("NoticeStateSync", "[syncNotifySwitchStatus] needUploadWithFrequency: " + r110 + " lastUploadSwitchTs:" + r104 + " currentTimeMillis:" + r103 + " uploadSwitchInterval:" + r105 + " actualInterval:" + r106);
        if (r110 == false) goto L9;
    L12:
        com.bytedance.push.utils.f.b("NoticeStateSync", "[syncNotifySwitchStatus] sendPushEnableToServer");
        if (TextUtils.isEmpty(this.f266979b) == true) goto L21;
        n r107 = this.f266980c;
        Context r108 = this.f266978a;
        String r109 = this.f266979b;
        r107.getClass();
        LocalFrequencySettings r111 = (LocalFrequencySettings) j77.i.a(r108, LocalFrequencySettings.class);
        if (NetworkUtils.isNetworkAvailable(r108) == true) goto L17;
        r111.f0(false);
    L28:
        n r112 = this.f266980c;
        Context r113 = this.f266978a;
        r112.getClass();
        JSONObject r114 = new JSONObject();
        String r115 = "open";
        if (r100 == false) goto L33;
        Object r116 = "open";
    L42:
        r114.put("in_status", r116);     // Catch: Throwable -> L41
        if (1 == ToolUtils.areNotificationsEnabled(r113)) goto L38;
        r115 = "close";
    L38:
        r114.put("out_status", r115);     // Catch: Throwable -> L41
    L39:
        ((n67.c) r112.f266983a.getStatisticsService()).b("ttpush_push_notification_status", r114);
        return;
    L33:
        r116 = "close";
        goto L42
    L17:
        t r117 = new t(r108, r107.f266983a, r100, r109);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L20;
        ThreadPlus.submitRunnable(r117);
        goto L28
    L20:
        r117.run();
        goto L28
    L21:
        n r118 = this.f266980c;
        Context r119 = this.f266978a;
        r118.getClass();
        LocalFrequencySettings r120 = (LocalFrequencySettings) j77.i.a(r119, LocalFrequencySettings.class);
        if (NetworkUtils.isNetworkAvailable(r119) == true) goto L24;
        r120.f0(false);
        goto L28
    L24:
        t r121 = new t(r119, r118.f266983a, r100);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L27;
        ThreadPlus.submitRunnable(r121);
        goto L28
    L27:
        r121.run();
        goto L28
    L9:
        if (r101.W() == false) goto L12;
        n r122 = this.f266980c;
        Context r123 = this.f266978a;
        r122.getClass();
        if (i.f266961a.a(r123, ((LocalFrequencySettings) j77.i.a(r123, LocalFrequencySettings.class)).P()) == false) goto L28;
    L5:
        r110 = false;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l(n r100, Context r101, String r102) {
        this.f266980c = r100;
        this.f266978a = r101;
        this.f266979b = r102;
    }
}
