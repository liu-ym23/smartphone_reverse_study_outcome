package com.larksuite.rucket.core;

import b38.b;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import d38.d;
import d38.f;
import d38.g;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class RucketImpl implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f286050e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Method, com.larksuite.rucket.core.proxymethod.a> f286051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f286052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<? extends Annotation>, Function1<Method, com.larksuite.rucket.core.proxymethod.a>> f286053d;

    public static final class a {
    }

    static {
    }

    public RucketImpl() {
        this.f286051b = new ConcurrentHashMap(2048);
        this.f286052c = new ConcurrentHashMap(128);
        this.f286053d = new ConcurrentHashMap();
        a(new d38.b());
        a(new d());
        a(new f());
        a(new g());
    }

    public final void a(c38.b r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f286053d.put(r100.a(), new RucketImpl$registerStrategy$1(r100));
    }

    @Override // b38.b
    public final <T> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ConcurrentHashMap<Class<?>, Object> r101 = this.f286052c;
        T r102 = (T) r101.get(r100);
        if (r102 != null) goto L8;
        r102 = (T) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new RucketImpl$create$1$1(this));
        Object r103 = r101.putIfAbsent((Class<?>) r100, r102);
        if (r103 == null) goto L8;
        r102 = (T) r103;
    L8:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.larksuite.rucket.core.RucketImpl.create");
        return r102;
    }
}
