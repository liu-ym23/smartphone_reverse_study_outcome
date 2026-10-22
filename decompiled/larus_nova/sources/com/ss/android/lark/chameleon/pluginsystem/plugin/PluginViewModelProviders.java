package com.ss.android.lark.chameleon.pluginsystem.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes35.dex */
public class PluginViewModelProviders {
    private static final String TAG = "PluginViewModelProviders";

    public PluginViewModelProviders() {
    }

    public static <T extends ViewModel> T viewModel(Fragment r100, Class<T> r101) {
        return (T) viewModel(r100, r101, null);
    }

    public static <T extends ViewModel> T viewModel(Plugin r100, Class<T> r101) {
        return (T) viewModel(r100, r101, null);
    }

    public static <T extends ViewModel> T viewModel(PluginHost r100, Class<T> r101) {
        return (T) viewModel(r100, r101, null);
    }

    public static <T extends ViewModel> T viewModel(Fragment r100, Class<T> r101, ViewModelProvider.Factory r102) {
        return (T) viewModel(PluginHost.fromFragment(r100), r101, r102);
    L4:
        e = move-exception;
        Log.e(TAG, e.toString());
        return r101.newInstance();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T extends ViewModel> T viewModel(PluginHost r100, Class<T> r101, ViewModelProvider.Factory r102) {
        if (r102 != null) goto L5;
        r102 = new ViewModelProvider.NewInstanceFactory();
    L5:
        return (T) new ViewModelProvider(r100, r102).get(r101);
    }

    public static <T extends ViewModel> T viewModel(Plugin r100, Class<T> r101, ViewModelProvider.Factory r102) {
        return (T) viewModel(r100.getHost(), r101, r102);
    }
}
