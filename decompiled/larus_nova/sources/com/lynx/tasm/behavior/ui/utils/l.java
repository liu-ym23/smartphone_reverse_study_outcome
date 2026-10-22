package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f383154e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f383155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f383156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f383157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f383158d;

    static {
        f383154e = new l();
    }

    public l() {
        this.f383155a = 0.5f;
        this.f383156b = 1;
        this.f383157c = 0.5f;
        this.f383158d = 1;
    }

    public l(ReadableArray r100) {
        this.f383155a = (float) r100.getDouble(0);
        this.f383156b = r100.getInt(1);
        if (r100.size() < 4) goto L5;
        this.f383157c = (float) r100.getDouble(2);
        this.f383158d = r100.getInt(3);
        return;
    L5:
        this.f383157c = 0.5f;
        this.f383158d = 1;
    }
}
