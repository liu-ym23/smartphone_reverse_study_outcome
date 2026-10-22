package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes14.dex */
public final class g {
    public static final boolean a(FragmentActivity r100, LifecycleOwner r101) {
        if (r100.isFinishing() == false) goto L6;
    L4:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L11;
    L14:
        return false;
    L11:
        if (r101.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L14;
        return true;
    L6:
        if (r100.isDestroyed() == true) goto L4;
        r102 = true;
        goto L9
    }
}
