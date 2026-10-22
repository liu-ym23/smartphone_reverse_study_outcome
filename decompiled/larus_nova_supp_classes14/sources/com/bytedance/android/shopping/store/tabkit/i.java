package com.bytedance.android.shopping.store.tabkit;

import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public final HashMap<String, MutableLiveData<Object>> a;
    public final TabKitViewModel b;

    public i(TabKitViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.b = r2;
        this.a = new HashMap();
    }
}
