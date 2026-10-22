package com.bytedance.ug.sdk.luckydog.api.settings;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g37.a f271653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f271654b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f271655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f271656d;

    static {
        f271653a = g37.a.c("luckydog_settings");
        f271654b = new AtomicBoolean(false);
        f271655c = null;
        f271656d = false;
    }

    public static LuckyDogLocalSettings a() {
        return (LuckyDogLocalSettings) f271653a.b(LuckyDogLocalSettings.class);
    L4:
        th = move-exception;
        th.printStackTrace();
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogSettingsManager", "getLocalSettings meet error, " + th);
        return null;
    }

    public static synchronized void b(final Context r100) {
        monitor-enter(h.class);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSettingsManager", "init is called");     // Catch: Throwable -> L11
        AtomicBoolean r101 = f271654b;     // Catch: Throwable -> L11
        if (r101.get() == false) goto L8;
        monitor-exit(h.class);
        return;
    L8:
        g37.a r102 = f271653a;     // Catch: Throwable -> L11
        r102.f479824a = new f(r100);     // Catch: Throwable -> L11
        r101.compareAndSet(false, true);     // Catch: Throwable -> L11
        monitor-exit(h.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static String c(StringBuilder r100) {
        ILuckyDogSettingsService r101 = (ILuckyDogSettingsService) fk7.c.b(ILuckyDogSettingsService.class);
        String r102 = null;
        if (r101 == null) goto L15;
        r100.append(" settingsNonNull");
        zk7.c r103 = (zk7.c) r101.getSettingsByKey(ILuckyDogCommonSettingsService.Channel.STATIC, "data.common_info.domain", zk7.c.class);
        if (r103 == null) goto L15;
        r100.append(" domainNonNull");
        String r104 = r103.a();
        if (TextUtils.isEmpty(r104) == true) goto L15;
        r100.append(" dogSettingsDomainNotEmpty");
        String r105 = r104 + HTTP.URL_DEFAULT;
        String r106 = UriProtector.parse(r105).getHost();     // Catch: Exception -> L11
    L12:
        if (r106 == null) goto L14;
        r102 = r105;
    L14:
        r100.append(" authority=");
        r100.append(r106);
    L11:
        r106 = null;
    L15:
        return r102;
    }
}
