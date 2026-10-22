package com.bytedance.ee.bear.drive.view.preview.wrapper;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public <T extends ViewModel> T viewModel(Class<T> r2) {
        return (T) this.provider.get(r2);
    }

    public ViewOwner(ViewModelStoreOwner r1, LifecycleOwner r2) {
        this.storeOwner = r1;
        this.lifecycleOwner = r2;
        this.provider = new ViewModelProvider(r1);
    }
}
