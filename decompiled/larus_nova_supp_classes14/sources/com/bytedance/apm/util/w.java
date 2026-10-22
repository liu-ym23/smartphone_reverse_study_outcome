package com.bytedance.apm.util;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w {
    public static volatile int a = -1;

    public static long a(Context r10, long r11, long r13, int r15) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 22) goto L5;
    L9:
        boolean r1 = false;
    L10:
        long r2 = 0;
        if (r1 == true) goto L13;
        return 0;
    L13:
        NetworkStatsManager r3 = (NetworkStatsManager) r10.getApplicationContext().getSystemService("netstats");
        if (r3 != null) goto L16;
        return 0;
    L16:
        NetworkStats.Bucket r4 = new NetworkStats.Bucket();
        NetworkStats r12 = r3.querySummary(r15, null, r11, r13);     // Catch: Exception -> L19
    L18:
        long r14 = 0;
    L21:
        if (r12 == null) goto L36;
        if (r12.hasNextBucket() == false) goto L36;
        r12.getNextBucket(r4);
        int r16 = r4.getUid();
        if (a != (-1)) goto L34;
        PackageInfo r17 = r10.getApplicationContext().getPackageManager().getPackageInfo(r10.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L31
        if (r17 == null) goto L34;
        a = r17.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        if (a != r16) goto L21;
        r2 = r2 + r4.getRxBytes();
        r14 = r14 + r4.getTxBytes();
    L36:
        if (r12 == null) goto L39;
        r12.close();
    L39:
        return r2 + r14;
    L19:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L18
    L5:
        if (r0 >= 28) goto L9;
        if (ContextCompat.checkSelfPermission(d.getContext(), "android.permission.READ_PHONE_STATE") != 0) goto L9;
        r1 = true;
        goto L10
    }
}
