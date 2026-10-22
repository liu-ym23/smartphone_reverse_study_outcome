package com.bytedance.ee.bear.browser.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q {
    public static <T extends ViewModel> T a(Fragment r1, Class<T> r2) {
        return (T) c(PluginHost.fromFragment(r1), r2, null);
    L4:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("PluginViewModelProviders", e);
        return r2.newInstance();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T extends ViewModel> T b(f r1, Class<T> r2) {
        return (T) c(r1.getHost(), r2, null);
    }

    public static <T extends ViewModel> T c(PluginHost r1, Class<T> r2, ViewModelProvider.Factory r3) {
        if (r3 != null) goto L5;
        r3 = new ViewModelProvider.NewInstanceFactory();
    L5:
        return (T) new ViewModelProvider(r1, r3).get(r2);
    }
}
