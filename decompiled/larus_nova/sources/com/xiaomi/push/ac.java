package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes41.dex */
public class ac {
    public static boolean a(Context r100) {
        return ((KeyguardManager) r100.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return false;
    }

    public static boolean b(Context r100) {
        Intent r101 = null;
        r101 = l.a(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null);     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        int r102 = r101.getIntExtra("status", -1);
        if (r102 != 2) goto L12;
    L13:
        return true;
    L12:
        if (r102 == 5) goto L13;
        return false;
    }
}
