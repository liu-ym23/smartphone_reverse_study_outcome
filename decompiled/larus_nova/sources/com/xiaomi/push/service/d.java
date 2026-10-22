package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<a> f464302a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f464303a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f1095a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1096a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f1097a;

        public a(String r100, long r101, int r102, Notification.Action[] r103) {
            this.f1096a = r100;
            this.f1095a = r101;
            this.f464303a = r102;
            this.f1097a = r103;
        }
    }

    static {
        f464302a = new CopyOnWriteArrayList();
    }

    private static void a() {
        int r100 = f464302a.size() - 1;
    L3:
        if (r100 < 0) goto L9;
        a r101 = (a) ListProtector.get(f464302a, r100);
        if ((SystemClock.elapsedRealtime() - r101.f1095a) <= 5000) goto L7;
        f464302a.remove(r101);
    L7:
        r100 = r100 - 1;
        goto L3
    L9:
        if (f464302a.size() <= 10) goto L15;
        ListProtector.remove(f464302a, 0);
        return;
    }

    private static void a(a r100) {
        f464302a.add(r100);
        a();
    }

    public static void a(Context r100, StatusBarNotification r101, int r102) {
        if (com.xiaomi.push.j.m9295a(r100) == false) goto L8;
        if (r102 <= 0) goto L9;
        if (r101 == null) goto L10;
        a(new a(r101.getKey(), SystemClock.elapsedRealtime(), r102, ag.m9358a(r101.getNotification())));
        return;
    L10:
        return;
    L9:
        return;
    }
}
