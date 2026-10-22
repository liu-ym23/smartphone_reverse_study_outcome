package com.bytedance.ies.android.base.runtime.thread;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p06.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ThreadUtils$normalExecutorService$2 extends Lambda implements Function0<ExecutorService> {
    public static final ThreadUtils$normalExecutorService$2 INSTANCE = null;

    static {
        INSTANCE = new ThreadUtils$normalExecutorService$2();
    }

    public ThreadUtils$normalExecutorService$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ExecutorService invoke2() {
        int r100 = a.f527294a;
        return TTExecutors.getNormalExecutor();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ExecutorService invoke() {
        return invoke2();
    }
}
