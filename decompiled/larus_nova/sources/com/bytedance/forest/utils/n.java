package com.bytedance.forest.utils;

import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f244584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f244585b = null;

    public n() {
    }

    static {
        f244585b = new n();
        f244584a = Keva.getRepo("forest_cdn", 1);
    }

    public final void delete(String r100) {
        Keva r101 = f244584a;
        if (r101 == null) goto L6;
        r101.erase(r100);
        return;
    }
}
