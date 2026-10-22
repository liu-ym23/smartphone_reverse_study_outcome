package com.bytedance.live.datacontext;

import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class DataContext_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f255062a = null;

    static {
        new ViewModelStore();
        f255062a = LazyKt.lazy(DataContext_androidKt$clearViewModelImpl$2.INSTANCE);
    }
}
