package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory implements Factory<com.bytedance.lark.rustclient.api.o> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory f425684a = null;

        static {
            f425684a = new OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory();
        }
    }

    public OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory() {
    }

    public static com.bytedance.lark.rustclient.api.o provideLoginCallbackExecutorGroup() {
        q r100 = q.f425709a;
        r100.getClass();
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.larksuite.framework.thread.n("office-sdk-login-callback"));
        r101.allowCoreThreadTimeOut(true);
        StringBuilder r102 = new StringBuilder("register login callback executor group, commands=");
        Set<Integer> r103 = q.f425710b;
        r102.append(r103.size());
        Log.i("OfficeSDKRustCallback", r102.toString());
        return (com.bytedance.lark.rustclient.api.o) Preconditions.checkNotNullFromProvides(new com.bytedance.lark.rustclient.api.o(r103, r101, new OfficeSDKRustCallbackDispatchModule$provideLoginCallbackExecutorGroup$1(r100)));
    }

    @Override // javax.inject.Provider
    public com.bytedance.lark.rustclient.api.o get() {
        return provideLoginCallbackExecutorGroup();
    }

    public static OfficeSDKRustCallbackDispatchModule_ProvideLoginCallbackExecutorGroupFactory create() {
        return a.f425684a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
