package com.bytedance.ee.bear.middleground.permission.apply;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.facade.common.BaseFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c0 {
    DialogFragment a(FragmentActivity r1, int r2, String r3, boolean r4, Runnable r5);

    au5.a b(NoPermission r1);

    j1 c();

    au5.a d(NoPermission r1);

    BaseFragment e(FragmentManager r1, String r2, int r3, int r4, boolean r5, Runnable r6);

    au5.a f(NoPermission r1);
}
