package com.bytedance.scene;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.scene.navigation.NavigationScene;

/* JADX INFO: loaded from: classes19.dex */
public abstract class LifeCycleFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavigationScene f268582a;

    public void setRootSceneComponentFactory(h r100) {
    }

    public void setRootScopeFactory(n.b r100) {
    }

    public NavigationScene getNavigationScene() {
        return this.f268582a;
    }

    public LifeCycleFrameLayout(Context r100) {
        super(r100);
        SceneLifecycleManager.SceneLifecycleManagerState r101 = SceneLifecycleManager.SceneLifecycleManagerState.NONE;
    }

    public void setNavigationScene(NavigationScene r100) {
        this.f268582a = r100;
    }

    public LifeCycleFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        SceneLifecycleManager.SceneLifecycleManagerState r102 = SceneLifecycleManager.SceneLifecycleManagerState.NONE;
    }

    public LifeCycleFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        SceneLifecycleManager.SceneLifecycleManagerState r103 = SceneLifecycleManager.SceneLifecycleManagerState.NONE;
    }
}
