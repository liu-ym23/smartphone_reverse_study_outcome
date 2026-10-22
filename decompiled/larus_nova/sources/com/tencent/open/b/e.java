package com.tencent.open.b;

import android.os.Bundle;
import com.tencent.open.utils.m;

/* JADX INFO: loaded from: classes31.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static e f461724a;

    public void a(int r100, String r101, String r102, String r103, String r104, Long r105, int r106, int r107, String r108) {
    }

    public static synchronized e a() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f461724a != null) goto L7;
        f461724a = new e();     // Catch: Throwable -> L10
    L7:
        e r100 = f461724a;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r100;
    }

    public e() {
    }

    public void a(String r100, String r101, String r102, String r110, String r111, String r112) {
        Bundle r103 = m.a(r100, r102, r110, r111, r101, r112);
        h.a().a(r103, r101, true);
    }

    public void a(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210) {
        Bundle r100 = m.a(r110, r113, r114, r112, r111, r115, "", r116, r210, "", "", "");
        h.a().a(r100, r111, false);
    }

    public void a(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        Bundle r100 = m.a(r110, r113, r114, r112, r111, r115, r116, "", "", r210, r211, r212);
        h.a().a(r100, r111, false);
    }
}
