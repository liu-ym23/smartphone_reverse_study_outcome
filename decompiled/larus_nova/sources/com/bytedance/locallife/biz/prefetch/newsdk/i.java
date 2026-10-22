package com.bytedance.locallife.biz.prefetch.newsdk;

import android.util.LruCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i<T> extends LruCache<String, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f256953a;

    public /* synthetic */ i(int r100) {
        this(r100, PrefetchLruCache$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(int r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "putRemovedListener");
        super(r100);
        this.f256953a = r101;
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r100, String r101, Object r102, Object r103) {
        String r104 = r101;
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r102, "oldValue");
        super.entryRemoved(r100, r104, r102, r103);
        if (r100 == false) goto L7;
        if (r103 == null) goto L8;
        this.f256953a.invoke(r103);
        return;
    L8:
        return;
    }
}
