package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModelProvider$Factory;", "", "viewModelFactory", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ViewModelFactoryOwner<T extends ViewModelProvider.Factory> {
    T getViewModelFactory();
}
