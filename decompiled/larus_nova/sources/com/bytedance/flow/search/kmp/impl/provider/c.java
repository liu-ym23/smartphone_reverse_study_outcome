package com.bytedance.flow.search.kmp.impl.provider;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements IIMCallback<List<? extends wc9.e>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<Map<String, wc9.e>> f243640a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public c(SafeContinuation r100) {
        this.f243640a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f243640a.resumeWith(Result.m9449constructorimpl(null));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(List<? extends wc9.e> r100) {
        List<? extends wc9.e> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        Continuation<Map<String, wc9.e>> r102 = this.f243640a;
        List<? extends wc9.e> r103 = r101;
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Object r106 = r105.next();
        r104.put(((wc9.e) r106).f559198a, r106);
        goto L4
    L6:
        r102.resumeWith(Result.m9449constructorimpl(r104));
    }
}
