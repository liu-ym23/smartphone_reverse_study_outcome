package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.v.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f199241b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f199242c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f199243d = null;

    static {
        f199240a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(f.class), "transferThread", "getTransferThread()Landroid/os/HandlerThread;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(f.class), "transferHandler", "getTransferHandler()Landroid/os/Handler;"))};
        f199243d = new f();
        f199241b = LazyKt.lazy(D.f199212a);
        f199242c = LazyKt.lazy(C.f199211a);
    }

    public f() {
    }

    public static final Handler a(f r100) {
        r100.getClass();
        Lazy r101 = f199242c;
        KProperty r102 = f199240a[1];
        return (Handler) r101.getValue();
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [T, com.bytedance.badger.utils.f0] */
    public static b0 b(Context r210, Long r211, Function3 r310) {
        Context r100 = r210.getApplicationContext();
        AtomicBoolean r110 = new AtomicBoolean(false);
        CountDownLatch r111 = new CountDownLatch(1);
        AtomicInteger r112 = new AtomicInteger(0);
        long r113 = System.currentTimeMillis();
        AtomicReference r114 = new AtomicReference(null);
        AtomicReference r101 = new AtomicReference(null);
        Object r102 = new Object();
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = false;
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = false;
        r r105 = new r(r102, r104, r103, r100);
        t r106 = new t(r101, r110, r111, r105);
        AtomicReference r107 = new AtomicReference(null);
        Ref.ObjectRef r108 = new Ref.ObjectRef();
        b r115 = new b(r110, r107, r102, r103, r100, r108, r106, r104);
        r108.element = new f0(r107, r106, r115, r112, r114, r211, r113, r310, r110, r111, r105, r101);
        Intent r109 = new Intent();
        f199243d.getClass();
        BadgerCore.Companion.getClass();
        r109.setComponent(new ComponentName(com.bytedance.badger.j.b(1227696027139978936L), com.bytedance.badger.j.b(1497361586704392952L)));
        if (r100.bindService(r109, r115, 1) == true) goto L8;
        return new b0(null, -1003, "bind account service returned false");
    L8:
        monitor-enter(r102);
        r103.element = true;     // Catch: Throwable -> L37
        monitor-exit(r102);
        d.f199322f0.getClass();
        com.bytedance.badger.v.g r116 = d.f199318d0;
        KProperty r117 = d.f199311a[56];
        com.bytedance.badger.v.w r118 = (com.bytedance.badger.v.w) r116.a();
        if (r111.await(r118.f199356a, r118.f199357b) == true) goto L16;
        r112.compareAndSet(0, 2);
        return new b0(null, -1000, "Timeout");
    L16:
        Throwable r119 = (Throwable) r101.get();
        if (r119 == null) goto L24;
        String r120 = r119.getMessage();
        if (r120 != null) goto L23;
        r120 = "";
    L23:
        return new b0(null, -1003, r120);
    L24:
        String r121 = (String) r114.get();
        if (r121 != null) goto L28;
        r121 = "";
    L28:
        String r122 = StringsKt.trim(r121).toString();
        if (r122.length() != 0) goto L31;
        boolean r123 = true;
    L32:
        if (r123 == false) goto L36;
        return new b0(null, -1001, "empty");
    L36:
        return new b0(r122, null, null);
    L31:
        r123 = false;
    L37:
        th = move-exception;
        throw th;
    L41:
        th = move-exception;
        StringBuilder r124 = new StringBuilder();
        r124.append(th.getClass().getSimpleName());
        r124.append(": ");
        String r125 = th.getMessage();
        if (r125 != null) goto L46;
        r125 = "";
    L46:
        r124.append(r125);
        return new b0(null, -1003, r124.toString());
    }

    public static final void c(f r100, AtomicBoolean r101, CountDownLatch r102, Function0 r103) {
        r100.getClass();
        if (r101.compareAndSet(false, true) == false) goto L13;
        r103.invoke();     // Catch: Throwable -> L8
        r102.countDown();
        return;
    L8:
        th = move-exception;
        r102.countDown();
        throw th;
    }
}
