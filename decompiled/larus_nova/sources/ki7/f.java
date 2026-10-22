package ki7;

import android.app.Application;
import android.content.SharedPreferences;
import ci7.l;
import ci7.p;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public f() {
    }

    public static void a() {
        String r100 = g.f503645a;
        mi7.e.a(r100, "updateSettingsIfNeed()....");
        IZlinkDepend r101 = p.a();
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.settingsRefactorEnable();
    L6:
        mi7.e.c(r100, "settingsRefactorEnable = " + r103);
        if (r103 == true) goto L10;
        a.a("init");
        return;
    L10:
        Application r104 = l.a();
        if (d.b(r104).length() <= 0) goto L13;
        r102 = true;
    L13:
        SharedPreferences r105 = d.a(r104);
        if (r105 == null) goto L16;
        long r106 = r105.getLong("key_settings_lastest_update_time", 0);
    L17:
        long r107 = d.b(r104).optLong("update_settings_interval", TimeUtils.SECONDS_PER_HOUR);
        mi7.e.c(r100, "hasCache = " + r102 + ", lastestUpdateTime = " + r106 + ", updateInterval = " + r107);
        if (r102 == true) goto L20;
    L28:
        a.a("init");
        return;
    L20:
        if (r106 <= 0) goto L28;
        if (r107 <= 0) goto L28;
        if ((System.currentTimeMillis() - r106) > (1000 * r107)) goto L28;
        g.a(r107);
        return;
    L16:
        r106 = 0;
        goto L17
    L5:
        r103 = false;
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
}
