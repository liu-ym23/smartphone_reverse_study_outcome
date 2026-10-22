package com.bytedance.ee.bear.drive.view.preview.wrapper;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class ViewOwner implements NonProguard {
    private LifecycleOwner lifecycleOwner;
    private ViewModelProvider provider;
    private ViewModelStoreOwner storeOwner;

    public LifecycleOwner lifecycleOwner() {
        return this.lifecycleOwner;
    }

    public ViewModelStoreOwner storeOwner() {
        return this.storeOwner;
    }

    public <T extends ViewModel> T viewModel(Class<T> r100) {
        return (T) this.provider.get(r100);
    }

    public ViewOwner(ViewModelStoreOwner r100, LifecycleOwner r101) {
        this.storeOwner = r100;
        this.lifecycleOwner = r101;
        this.provider = new ViewModelProvider(r100);
    }
}
