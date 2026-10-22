package com.bytedance.badger.z;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class T extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final T f199448a = null;

    static {
        f199448a = new T();
    }

    public T() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Badger-Callback-Handler");
        ThreadMethodProxy.start(r100);
        return r100;
    }
}
