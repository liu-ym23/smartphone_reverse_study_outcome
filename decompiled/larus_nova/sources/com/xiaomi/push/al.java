package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f463133a;

    public static ah a(Context r100) {
        if (j.m9294a() == false) goto L7;
        f463133a = 1;
        return new ak(r100);
    L7:
        if (ag.a(r100) == false) goto L11;
        f463133a = 2;
        return new ag(r100);
    L11:
        if (an.a(r100) == false) goto L15;
        f463133a = 4;
        return new an(r100);
    L15:
        if (ap.a(r100) == false) goto L19;
        f463133a = 5;
        return new ap(r100);
    L19:
        if (aj.a(r100) == false) goto L22;
        f463133a = 3;
        return new ai(r100);
    L22:
        f463133a = 0;
        return new ao();
    }
}
