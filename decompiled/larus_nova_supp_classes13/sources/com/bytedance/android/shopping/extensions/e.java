package com.bytedance.android.shopping.extensions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final <T> MutableLiveData<T> a(LiveData<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$mutable");
        return (MutableLiveData) r1;
    }
}
