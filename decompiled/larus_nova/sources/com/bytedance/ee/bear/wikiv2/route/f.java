package com.bytedance.ee.bear.wikiv2.route;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;
import yq5.t;
import yq5.y;
import yq5.z;

/* JADX INFO: loaded from: classes18.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f241046a;

    public f(z r100) {
        this.f241046a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        t r100 = WikiDatabase.c().e();
        z r101 = this.f241046a;
        y r102 = (y) r100;
        r102.f568846a.beginTransaction();
        r102.c(r101.f568852b);     // Catch: Throwable -> L6
        r102.b(r101.f568853c);     // Catch: Throwable -> L6
        r102.f568846a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r102.f568846a.endTransaction();
        return;
    L6:
        th = move-exception;
        r102.f568846a.endTransaction();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
