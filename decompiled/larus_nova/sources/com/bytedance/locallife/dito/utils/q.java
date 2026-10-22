package com.bytedance.locallife.dito.utils;

import com.bytedance.locallife.dito.Dito;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes21.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f258714a;

    static {
    }

    public static final Gson a() {
        Gson r100 = f258714a;
        if (r100 != null) goto L6;
        Dito r101 = Dito.f257280a;
        Gson r102 = l.d();
        f258714a = r102;
        return r102;
    L6:
        return r100;
    }
}
