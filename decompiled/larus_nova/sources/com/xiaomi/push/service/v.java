package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f464355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f1141a;

    public interface a {
        Map<String, String> a(Context r100, ha r101);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        void m9418a(Context r100, ha r101);

        void a(Context r100, ha r101, hd r102);

        boolean a(Context r100, ha r101, boolean r102);
    }

    public interface b {
        void a(ha r100);

        void a(String r100);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m9419a(ha r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9417a(ha r100) {
        b r101 = f1141a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return r101.m9419a(r100);
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(ha r100) {
        b r101 = f1141a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        r101.a(r100);
        return;
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("pepa clearMessage is null");
    }

    public static void a(String r100) {
        b r101 = f1141a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        r101.a(r100);
        return;
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("pepa clearMessage is null");
    }

    public static Map<String, String> a(Context r100, ha r101) {
        a r102 = f464355a;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        return r102.a(r100, r101);
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("pepa listener or container is null");
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9416a(Context r100, ha r101) {
        a r102 = f464355a;
        if (r102 == null) goto L7;
        if (r101 == null) goto L7;
        r102.m9418a(r100, r101);
        return;
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("handle msg wrong");
    }

    public static boolean a(Context r100, ha r101, boolean r102) {
        a r103 = f464355a;
        if (r103 == null) goto L7;
        if (r101 == null) goto L7;
        return r103.a(r100, r101, r102);
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("pepa judement listener or container is null");
        return false;
    }

    public static void a(Context r100, ha r101, hd r102) {
        a r103 = f464355a;
        if (r103 != null) goto L5;
        com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        return;
    L5:
        r103.a(r100, r101, r102);
    }
}
