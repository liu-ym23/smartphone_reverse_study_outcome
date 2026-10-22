package com.bytedance.jedi.model.util;

import com.bytedance.jedi.model.datasource.AbstractDataSource;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/util/ValueReference;", "K", "V", "Ljava/lang/ref/WeakReference;", "model_release"}, k = 1, mv = {1, 7, 1})
public final class ValueReference<K, V> extends WeakReference<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f251214a;

    /* JADX WARN: Multi-variable type inference failed */
    public ValueReference(Object r100, AbstractDataSource r101, ReferenceQueue r102) {
        Intrinsics.checkNotNullParameter(r102, "q");
        super(r101, r102);
        this.f251214a = r100;
    }
}
