package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadProxyWrapper;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rB\u0019\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000eB\u0019\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000fB#\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u0010B+\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0016H\u0016R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadThreadV2;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxyWrapper;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ExtraProvider;", "()V", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "name", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", "target", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;)V", "stackSize", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "mExtra", "Ljava/util/concurrent/ConcurrentHashMap;", XmlPullParser.NO_NAMESPACE, "mThreadProxy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "getMThreadProxy", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "mThreadProxy$delegate", "Lkotlin/Lazy;", "getExtra", "key", "getProxy", "removeExtra", "run", XmlPullParser.NO_NAMESPACE, "setExtra", "value", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public class PthreadThreadV2 extends ThreadProxyWrapper implements ExtraProvider {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private ConcurrentHashMap<String, Object> mExtra;
    private final Lazy mThreadProxy$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PthreadThreadV2.class), "mThreadProxy", "getMThreadProxy()Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;"))};
    }

    public PthreadThreadV2() {
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(Runnable r1) {
        super(r1);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(Runnable r1, String r2) {
        super(r1, r2);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(String r1) {
        super(r1);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(ThreadGroup r1, Runnable r2) {
        super(r1, r2);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(ThreadGroup r1, Runnable r2, String r3) {
        super(r1, r2, r3);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(ThreadGroup r1, Runnable r2, String r3, long r4) {
        super(r1, r2, r3, r4);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    public PthreadThreadV2(ThreadGroup r1, String r2) {
        super(r1, r2);
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadThreadV2$mThreadProxy$2(this));
    }

    private final IThreadProxy getMThreadProxy() {
        Lazy r0 = this.mThreadProxy$delegate;
        KProperty r1 = $$delegatedProperties[0];
        return (IThreadProxy) r0.getValue();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider
    public Object getExtra(String r2) {
        return this.mExtra.get(r2);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public IThreadProxy getProxy() {
        if (isEnable$threadpool_plugin_base_release() == true) goto L7;
        return null;
    L7:
        return getMThreadProxy();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider
    public Object removeExtra(String r2) {
        return this.mExtra.remove(r2);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        if (r0.isEnable(1) == true) goto L5;
        IThreadMonitor r1 = r0.getThreadMonitor();
    L6:
        if (r1 == null) goto L16;
        r1.onThreadRunning(this);
    L16:
        super.run();     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        r1.onThreadExit(this);
        return;
    L18:
        return;
    L12:
        th = move-exception;
        if (r1 == null) goto L15;
        r1.onThreadExit(this);
    L15:
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider
    public void setExtra(String r2, Object r3) {
        this.mExtra.put(r2, r3);
    }
}
