package com.bytedance.scene.group;

import android.os.Bundle;
import com.bytedance.scene.n;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public abstract class InheritedScene extends GroupScene {
    public InheritedScene() {
    }

    @Override // com.bytedance.scene.Scene
    public final void T(Bundle r100) {
        super.T(r100);
        n r101 = this.f268589g;
        if (r101 == null) goto L7;
        Class<?> r102 = getClass();
        ((HashMap) r101.f268745d).put(r102, this);
        return;
    L7:
        throw new IllegalStateException("Scope is not created, you can't call before onCreate");
    }
}
