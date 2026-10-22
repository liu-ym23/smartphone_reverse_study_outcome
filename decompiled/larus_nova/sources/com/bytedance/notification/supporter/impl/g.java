package com.bytedance.notification.supporter.impl;

import android.app.KeyguardManager;
import android.content.Context;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements w37.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f266102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f266103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KeyguardManager f266104c;

    public g(Context r100) {
        this.f266102a = null;
        this.f266103b = -1;
        this.f266104c = (KeyguardManager) r100.getSystemService("keyguard");
    }
}
