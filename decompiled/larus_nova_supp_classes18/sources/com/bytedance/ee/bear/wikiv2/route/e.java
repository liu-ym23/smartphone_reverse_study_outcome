package com.bytedance.ee.bear.wikiv2.route;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;
import yq5.t;
import yq5.y;
import yq5.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<V> implements Callable {
    public final /* synthetic */ z a;

    public e(z r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        t r0 = WikiDatabase.c().e();
        z r1 = this.a;
        y r2 = (y) r0;
        r2.a.beginTransaction();
        y.a(r2, r1);     // Catch: Throwable -> L6
        r2.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r2.a.endTransaction();
        return;
    L6:
        th = move-exception;
        r2.a.endTransaction();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
