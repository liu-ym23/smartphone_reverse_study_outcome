package com.bytedance.salamander.adapter;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, j> f267800a = null;

    static {
        f267800a = new ConcurrentHashMap();
    }

    public static final j a(String r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        return new t(r100, r101);
    L5:
        return new a(r100, r101);
    }
}
