package com.privacy.azerothprivacy.alarm.receiver;

import android.content.Context;
import android.content.Intent;
import com.privacy.azerothprivacy.AzerothPrivacy;
import toa.a;
import toa.d;

/* JADX INFO: loaded from: classes5.dex */
public class KeyAgreementUpdater extends AzerothCustomReceiver {
    @Override // com.privacy.azerothprivacy.alarm.receiver.AzerothCustomReceiver
    public final long a() {
        Context r100 = AzerothPrivacy.getAppContext();
        String r101 = a.f546969a;
        epa.a r102 = epa.a.b(r100);
        String r103 = "KeyExpireTimeInUnixSeconds" + AzerothPrivacy.getAppInfo().f530146e;
        r102.getClass();
        long r104 = epa.a.c(r103);
        long r105 = 10000;
        if (r104 <= 0) goto L8;
        long r106 = (r104 * 1000) - System.currentTimeMillis();
        if (r106 >= 10000) goto L7;
        return 10000;
    L7:
        r105 = r106;
    L8:
        apa.a.a("KeyAgreementUpdater", "get next interval is " + r105);
        return r105;
    }

    public KeyAgreementUpdater() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        apa.a.a("KeyAgreementUpdater", "key agreement cron job start");
        d r102 = d.f546986h;
        monitor-enter(r102);
        r102.c(r100, AzerothPrivacy.getAppInfo().f530146e);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
