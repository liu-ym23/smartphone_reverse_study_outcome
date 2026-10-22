package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public static final /* synthetic */ int c = 0;
    public final ConcurrentHashMap<String, CompletableDeferred<Object>> a;
    public final CoroutineScope b;

    public static final class a {
    }

    static {
    }

    public n() {
        this.a = new ConcurrentHashMap();
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public final <T> T a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "requestKey");
        CompletableDeferred<Object> r4 = this.a.get(r3);
        if (r4 == null) goto L5;
        Object r5 = r4.getCompleted();
    L7:
        if ((r5 instanceof Object) == true) goto L10;
        return null;
    L10:
        return (T) r5;
    L5:
        r5 = null;
        goto L7
    }
}
