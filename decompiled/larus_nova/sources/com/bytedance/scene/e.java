package com.bytedance.scene;

import com.bytedance.scene.navigation.NavigationScene;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NavigationScene f268640a;

    @Override // com.bytedance.scene.j
    public final boolean onBackPressed() {
        if (this.f268640a.p0() == false) goto L5;
        return true;
    L5:
        return false;
    }

    public e(NavigationScene r100) {
        this.f268640a = r100;
    }
}
