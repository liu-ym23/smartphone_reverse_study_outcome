package com.xiaomi.push.service;

import com.xiaomi.push.hd;

/* JADX INFO: loaded from: classes41.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f464307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f1099a;

    public interface a {
        boolean a(hd r100);
    }

    public interface b {
    }

    public static boolean a(hd r100) {
        if (f464307a == null) goto L12;
        if (r100 == null) goto L12;
        if (com.xiaomi.push.j.m9295a(com.xiaomi.push.q.m9304a()) == true) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("rc app not permission to cpra");
        return false;
    L11:
        return f464307a.a(r100);
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8718a("rc params is null, not cpra");
        return false;
    }

    public static void a(b r100) {
        f1099a = r100;
    }
}
