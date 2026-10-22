package com.ss.android.lark.forseti.global;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<tua.c.a> f424484a = null;

    static {
        f424484a = new ArrayList();
    }

    public static void a(boolean r100) {
        Iterator r101 = ((ArrayList) f424484a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((tua.c.a) r101.next()).a(r100);
        goto L4
    }
}
