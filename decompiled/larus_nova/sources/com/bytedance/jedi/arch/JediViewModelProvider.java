package com.bytedance.jedi.arch;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/* JADX INFO: loaded from: classes19.dex */
public class JediViewModelProvider {
    private final ViewModelProvider mViewModelProvider;

    public <T extends JediViewModel> T get(Class<T> r100) {
        if (r100.getCanonicalName() == null) goto L7;
        return (T) get(r100.getName(), r100);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public JediViewModelProvider(ViewModelStore r100, ViewModelProvider.Factory r101) {
        this.mViewModelProvider = new ViewModelProvider(r100, r101);
    }

    public <T extends JediViewModel> T get(String r100, Class<T> r101) {
        return (T) this.mViewModelProvider.get(r100, r101);
    }

    public JediViewModelProvider(ViewModelStoreOwner r100, ViewModelProvider.Factory r101) {
        this(r100.getViewModelStore(), r101);
    }
}
