package com.bytedance.jedi.model.traceable;

import com.bytedance.jedi.model.cache.AbstractCache;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/model/traceable/TraceableObserverImpl;", "K", "V", "", "Lkotlin/Pair;", "model_release"}, k = 1, mv = {1, 7, 1})
public final class TraceableObserverImpl<K, V> {
    public TraceableObserverImpl(AbstractCache r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        new WeakReference(r100);
    }
}
