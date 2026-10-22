package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import android.util.EventsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/DefaultThreadPoolExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getMExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "mExecutor$delegate", "Lkotlin/Lazy;", "execute", XmlPullParser.NO_NAMESPACE, "command", "Ljava/lang/Runnable;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final class DefaultThreadPoolExecutor implements Executor {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy mExecutor$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultThreadPoolExecutor.class), "mExecutor", "getMExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
    }

    public DefaultThreadPoolExecutor() {
        this.mExecutor$delegate = LazyKt.lazy(DefaultThreadPoolExecutor$mExecutor$2.INSTANCE);
    }

    private final ThreadPoolExecutor getMExecutor() {
        Lazy r0 = this.mExecutor$delegate;
        KProperty r1 = $$delegatedProperties[0];
        return (ThreadPoolExecutor) r0.getValue();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        getMExecutor().execute(r2);
    }
}
