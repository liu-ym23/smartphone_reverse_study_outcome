package com.bytedance.ies.bullet.lynx.init;

import com.lynx.animax.util.LynxAnimaX;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class j<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<V> f247361a = null;

    static {
        f247361a = new j();
    }

    public j() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        LynxAnimaX.inst().init();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
