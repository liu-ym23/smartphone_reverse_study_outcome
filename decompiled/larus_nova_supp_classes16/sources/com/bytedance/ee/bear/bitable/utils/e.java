package com.bytedance.ee.bear.bitable.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final void a(boolean r1, Fragment r2, FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        if (r1 == false) goto L5;
        r3.beginTransaction().show(r2).commitAllowingStateLoss();
        return;
    L5:
        r3.beginTransaction().hide(r2).commitAllowingStateLoss();
    }
}
