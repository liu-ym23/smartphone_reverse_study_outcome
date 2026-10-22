package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f246467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f246468b;

    public c(Context r100, String r101) {
        this.f246467a = r100;
        this.f246468b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        int r100 = o16.a.f521705a;
        Activity r101 = o16.a.a(this.f246467a);
        if (r101 == null) goto L5;
        String r102 = this.f246468b;
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.g(r102, "Caller " + r101.getComponentName().toShortString() + ": " + r101.hashCode(), "XView", 8);
        Unit r104 = Unit.INSTANCE;
    L6:
        if (r104 != null) goto L9;
        ExecutorService r105 = BulletLogger.f247763a;
        BulletLogger.g(this.f246468b, "Caller unknown", "XView", 8);
        return;
    L9:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
