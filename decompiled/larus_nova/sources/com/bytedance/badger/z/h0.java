package com.bytedance.badger.z;

import android.content.Context;
import android.os.Handler;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class h0 extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f199470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f199471b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e0 f199472c = null;

    public h0() {
    }

    static {
        f199472c = new e0();
        f199470a = LazyKt.lazy(T.f199448a);
        f199471b = LazyKt.lazy(S.f199447a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r110, BadgerModuleBase.BadgerRequestData r111) {
        if (com.bytedance.badger.utils.y.d() == false) goto L5;
        CountDownLatch r100 = new CountDownLatch(1);
        AtomicInteger r101 = new AtomicInteger(0);
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = "";
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        r113.element = "";
        long r102 = System.currentTimeMillis();
        f199472c.getClass();
        Lazy r103 = f199471b;
        KProperty r104 = e0.f199459a[1];
        com.bytedance.badger.utils.x r114 = new com.bytedance.badger.utils.x(r110, (Handler) r103.getValue());
        r114.b(new g0(this, r101, r112, r111, r102, r100, r114, r113));
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r105 = com.bytedance.badger.v.d.f199318d0;
        KProperty r106 = com.bytedance.badger.v.d.f199311a[56];
        com.bytedance.badger.v.w r107 = (com.bytedance.badger.v.w) r105.a();
        if (r100.await(r107.f199356a, r107.f199357b) == true) goto L10;
        r101.compareAndSet(0, 2);
        return new BadgerResult.Failure(-1000, "Timeout");
    L10:
        boolean r108 = false;
        if (((String) r113.element).length() != 0) goto L13;
        r108 = true;
    L13:
        if (r108 == true) goto L17;
        return new BadgerResult.Failure(-1001, (String) r113.element);
    L17:
        return new BadgerResult.Success(new DataString((String) r112.element));
    L5:
        return new BadgerResult.Failure(-999, "not support");
    }
}
