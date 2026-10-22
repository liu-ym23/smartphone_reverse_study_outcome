package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final boolean a(FragmentActivity r3, LifecycleOwner r4) {
        if (r3.isFinishing() == false) goto L6;
    L4:
        boolean r5 = false;
    L9:
        if (r5 == true) goto L11;
    L14:
        return false;
    L11:
        if (r4.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L14;
        return true;
    L6:
        if (r3.isDestroyed() == true) goto L4;
        r5 = true;
        goto L9
    }
}
