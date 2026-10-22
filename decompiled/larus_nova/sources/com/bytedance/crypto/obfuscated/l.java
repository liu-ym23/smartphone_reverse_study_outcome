package com.bytedance.crypto.obfuscated;

import android.content.Context;

/* JADX INFO: loaded from: classes15.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile l f204265c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f204266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f204267b;

    public l(Context r100) {
        this.f204267b = r100;
        this.f204266a = k.a(r100);
    }

    public static i a(i r100) {
        i r101 = new i();
        r101.f204250a = r100.f204250a;
        r101.f204251b = r100.f204251b;
        r101.f204252c = r100.f204252c;
        r101.f204253d = r100.f204253d;
        r101.f204254e = r100.f204254e;
        r101.f204255f = r100.f204255f;
        r101.f204256g = r100.f204256g;
        r101.f204257h = r100.f204257h;
        r101.f204258i = r100.f204258i;
        r101.f204259j = r100.f204259j;
        r101.f204260k = r100.f204260k;
        r101.f204261l = r100.f204261l;
        r101.f204262m = r100.f204262m;
        return r101;
    }

    public static l a(Context r100) {
        if (f204265c != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f204265c != null) goto L9;
        f204265c = new l(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f204265c;
    }
}
