package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public final class i2<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f241912a;

    public i2(String r100) {
        this.f241912a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        WikiDatabase.c().d().e(this.f241912a);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
