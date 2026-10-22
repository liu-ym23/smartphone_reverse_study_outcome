package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i2<V> implements Callable {
    public final /* synthetic */ String a;

    public i2(String r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        WikiDatabase.c().d().e(this.a);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
