package com.xiaomi.push;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes41.dex */
public class p {
    public static String a(String r100, String r101) {
        return (String) q.a(null, "android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, r101});
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("SystemProperties.get: " + e);
        return r101;
    }
}
