package com.bytedance.badger.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class AppContextBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f199210a;

    public AppContextBridge() {
    }

    public static Context get() {
        if (f199210a == null) goto L7;
        return f199210a;
    L7:
        throw new IllegalStateException("Brige Context is null");
    }

    public static void set(Context r100) {
        if (r100 == null) goto L5;
        f199210a = r100.getApplicationContext();
        return;
    }
}
