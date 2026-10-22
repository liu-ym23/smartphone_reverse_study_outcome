package com.ss.android.vesdk;

import android.os.Trace;

/* JADX INFO: loaded from: classes40.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f455944a;

    public static void b() {
        if (f455944a == true) goto L5;
        return;
    L5:
        Trace.endSection();
    }

    public static void a(String r100) {
        if (f455944a == true) goto L5;
        return;
    L5:
        Trace.beginSection(r100);
    }
}
