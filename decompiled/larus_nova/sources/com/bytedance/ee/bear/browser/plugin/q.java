package com.bytedance.ee.bear.browser.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: loaded from: classes16.dex */
public final class q {
    public static <T extends ViewModel> T a(Fragment r100, Class<T> r101) {
        return (T) c(PluginHost.fromFragment(r100), r101, null);
    L4:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("PluginViewModelProviders", e);
        return r101.newInstance();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T extends ViewModel> T b(f r100, Class<T> r101) {
        return (T) c(r100.getHost(), r101, null);
    }

    public static <T extends ViewModel> T c(PluginHost r100, Class<T> r101, ViewModelProvider.Factory r102) {
        if (r102 != null) goto L5;
        r102 = new ViewModelProvider.NewInstanceFactory();
    L5:
        return (T) new ViewModelProvider(r100, r102).get(r101);
    }
}
