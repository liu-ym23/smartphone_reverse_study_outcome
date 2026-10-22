package com.ss.android.ugc.aweme.dependence.download.persistence;

import android.os.Looper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "Param", "Target", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class PrioritySerialTaskScheduler$mMainThread$2 extends Lambda implements Function0<Thread> {
    public static final PrioritySerialTaskScheduler$mMainThread$2 INSTANCE = null;

    static {
        INSTANCE = new PrioritySerialTaskScheduler$mMainThread$2();
    }

    public PrioritySerialTaskScheduler$mMainThread$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Thread invoke2() {
        return ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Thread invoke() {
        return invoke2();
    }
}
