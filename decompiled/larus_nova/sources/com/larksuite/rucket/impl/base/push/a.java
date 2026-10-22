package com.larksuite.rucket.impl.base.push;

import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.RucketJobImpl;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a<T extends Message<?, ?>> extends RucketJobImpl<T> implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f286058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<RucketJob<T>> f286059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f286060c;

    /* JADX INFO: renamed from: com.larksuite.rucket.impl.base.push.a$a, reason: collision with other inner class name */
    public static final class C3935a {
    }

    static {
    }

    public abstract void b();

    public abstract void c();

    @Override // com.larksuite.rucket.job.RucketJobImpl, com.larksuite.rucket.job.RucketJob
    public final void cancel() {
        CopyOnWriteArrayList<RucketJob<T>> r100 = this.f286059b;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((true ^ ((RucketJob) r103).isCanceled()) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        this.f286059b.clear();
        if ((!r101.isEmpty()) == false) goto L12;
        this.f286059b.addAll(r101);
        return;
    L12:
        if (this.f286060c.compareAndSet(true, false) == false) goto L21;
        c();
        return;
    }

    public a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "responseClazz");
        this.f286058a = r100;
        this.f286059b = new CopyOnWriteArrayList();
        this.f286060c = new AtomicBoolean(false);
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        BuildersKt.launch$default(this, null, null, new BasePushRucketJob$onPush$1(this, r100, null), 3, null);
    }
}
