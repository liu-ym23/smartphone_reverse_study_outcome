package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f246464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f246465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Scenes f246466c;

    public b(Context r100, String r101, Scenes r102) {
        this.f246464a = r100;
        this.f246465b = r101;
        this.f246466c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        int r100 = o16.a.f521705a;
        Activity r101 = o16.a.a(this.f246464a);
        if (r101 == null) goto L5;
        String r102 = this.f246465b;
        Scenes r103 = this.f246466c;
        ExecutorService r104 = BulletLogger.f247763a;
        BulletLogger.g(r102, "Callee " + r101.getComponentName().toShortString() + ": " + r101.hashCode() + " on " + r103.getTag(), "XView", 8);
        Unit r105 = Unit.INSTANCE;
    L6:
        if (r105 != null) goto L9;
        ExecutorService r106 = BulletLogger.f247763a;
        BulletLogger.g(this.f246465b, "Callee unknown on " + this.f246466c.getTag(), "XView", 8);
        return;
    L9:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
