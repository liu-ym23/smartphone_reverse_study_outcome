package com.bytedance.scene;

import android.R;
import com.bytedance.scene.Scene;
import com.bytedance.scene.m;
import com.bytedance.scene.navigation.NavigationScene;

/* JADX INFO: loaded from: classes19.dex */
public final class l<T extends Scene & m> implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f268734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f268735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f268736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n.b f268737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f268738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SceneLifecycleManager<T> f268739f;

    public l(b r100, NavigationScene r101, ScopeHolderFragment r102, boolean r103) {
        this.f268739f = new SceneLifecycleManager();
        this.f268734a = R.id.content;
        this.f268735b = r100;
        this.f268736c = r101;
        this.f268737d = r102;
        this.f268738e = r103;
    }
}
