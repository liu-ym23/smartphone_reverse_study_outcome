package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ CCMLynxCacheManager a;

    public b(CCMLynxCacheManager r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        i r5 = (i) r4;
        Intrinsics.checkNotNullParameter(r5, "model");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "model");
        LynxCacheDatabase r0 = CCMLynxCacheManager.a();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L9
        h r1 = (h) r0.c();     // Catch: Exception -> L9
        r1.a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r1.a.beginTransaction();     // Catch: Exception -> L9
        long r2 = r1.b.insertAndReturnId(r5);     // Catch: Throwable -> L6
        r1.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        Long r6 = Long.valueOf(r2);     // Catch: Throwable -> L6
        r1.a.endTransaction();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L9
        long r3 = r6.longValue();     // Catch: Exception -> L9
    L12:
        return Long.valueOf(r3);
    L6:
        th = move-exception;
        r1.a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        r3 = -1;
        goto L12
    }
}
