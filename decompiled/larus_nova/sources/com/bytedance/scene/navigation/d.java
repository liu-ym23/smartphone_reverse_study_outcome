package com.bytedance.scene.navigation;

import android.app.Activity;
import android.content.Context;
import com.bytedance.scene.Scene;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static NavigationScene a(Scene r100) {
        qa7.f.a();
    L3:
        if (r100 == null) goto L7;
        r100 = r100.f268587e;
        if ((r100 instanceof NavigationScene) == false) goto L3;
        return (NavigationScene) r100;
    L7:
        return null;
    }

    public static NavigationScene b(Scene r100) {
        qa7.f.a();
        NavigationScene r101 = a(r100);
        if (r101 != null) goto L18;
        Activity r102 = r100.f268583a;
        if (r102 != null) goto L7;
        Context r103 = null;
    L9:
        if (r103 == null) goto L17;
        if ((r100 instanceof NavigationScene) == false) goto L15;
        throw new IllegalStateException("Scene " + r100 + " is root Scene");
    L15:
        throw new IllegalStateException("The root of the Scene hierarchy is not NavigationScene");
    L17:
        throw new IllegalStateException("Scene " + r100 + " is not attached to any Scene");
    L7:
        r103 = r102.getApplicationContext();
        goto L9
    L18:
        return r101;
    }
}
