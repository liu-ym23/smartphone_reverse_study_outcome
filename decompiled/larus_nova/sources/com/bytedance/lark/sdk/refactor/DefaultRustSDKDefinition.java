package com.bytedance.lark.sdk.refactor;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes20.dex */
public class DefaultRustSDKDefinition implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f254204a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public boolean e(int r100) {
        return false;
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public Executor f() {
        return null;
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public te6.d h() {
        return null;
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public final Executor g() {
        return (Executor) this.f254204a.getValue();
    }

    @Inject
    public DefaultRustSDKDefinition() {
        this.f254204a = LazyKt.lazy(DefaultRustSDKDefinition$pushCallbackExecutor$2.INSTANCE);
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public final Executor c() {
        return CoreThreadPool.getDefault().getCachedThreadPool();
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public Set<te6.b> d() {
        return SetsKt.emptySet();
    }

    @Override // com.bytedance.lark.sdk.refactor.o
    public final SDKInitStrategy b() {
        return SDKInitStrategy.ASYNC;
    }
}
