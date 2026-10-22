package com.bytedance.badger.utils;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class D extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f199212a = null;

    static {
        f199212a = new D();
    }

    public D() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Badger-VivoId-Transfer");
        ThreadMethodProxy.start(r100);
        return r100;
    }
}
