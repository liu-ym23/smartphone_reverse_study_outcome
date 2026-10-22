package com.bytedance.scene.navigation;

import android.os.Bundle;
import com.bytedance.scene.Scene;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f268816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f268817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f268818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f268819e;

    public i(Class<? extends Scene> r100, Bundle r101) {
        this.f268817c = true;
        this.f268818d = true;
        this.f268819e = 0;
        if (r100.isAssignableFrom(NavigationScene.class) == true) goto L7;
        this.f268815a = r100.getName();
        this.f268816b = r101;
        return;
    L7:
        throw new IllegalArgumentException("cant use NavigationScene as root scene");
    }

    public i(String r100, Bundle r101) {
        this.f268817c = true;
        this.f268818d = true;
        this.f268819e = 0;
        this.f268815a = r100;
        this.f268816b = r101;
    }
}
