package com.bytedance.ee.bear.middleground.permission.apply;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.facade.common.BaseFragment;

/* JADX INFO: loaded from: classes18.dex */
public interface c0 {
    DialogFragment a(FragmentActivity r100, int r101, String r102, boolean r103, Runnable r104);

    au5.a b(NoPermission r100);

    j1 c();

    au5.a d(NoPermission r100);

    BaseFragment e(FragmentManager r100, String r101, int r102, int r103, boolean r104, Runnable r105);

    au5.a f(NoPermission r100);
}
