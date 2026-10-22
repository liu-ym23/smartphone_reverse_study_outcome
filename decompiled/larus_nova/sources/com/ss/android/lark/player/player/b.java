package com.ss.android.lark.player.player;

import android.os.Bundle;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f438663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f438664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f438665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f438666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f438667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f438668f;

    public interface a {
        void a(float r100, float r101);
    }

    public b() {
        this.f438663a = 0;
    }

    public final void a(int r100, Bundle r101) {
        n r102 = this.f438664b;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
