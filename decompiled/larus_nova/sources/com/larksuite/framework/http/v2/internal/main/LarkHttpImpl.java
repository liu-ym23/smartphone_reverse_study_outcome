package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.http.v2.internal.rust.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes24.dex */
public final class LarkHttpImpl implements com.larksuite.framework.http.v2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.framework.http.v2.internal.rust.d f285588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larksuite.framework.http.v2.a f285589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e28.c f285590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f285591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<WeakReference<com.larksuite.framework.http.v2.c>> f285592e;

    @Override // com.larksuite.framework.http.v2.b
    public final b a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "configureSpec");
        com.larksuite.framework.http.v2.c.b r101 = new com.larksuite.framework.http.v2.c.b(new OkHttpClient.Builder());
        r100.invoke(r101);
        Intrinsics.checkNotNullParameter(r101, "spec");
        OkHttpClient.Builder r102 = r101.f285579a.build().newBuilder();
        if (Intrinsics.areEqual(r101.f285580b, com.larksuite.framework.http.v2.d.c.f285586a) == false) goto L6;
        r102.cookieJar(this.f285589b.a());
    L6:
        if (r101.f285581c == false) goto L9;
        CollectionsKt.removeAll(r102.interceptors(), LarkHttpImpl$doCreateClient$1.INSTANCE);
        r102.addInterceptor(new e28.b(this.f285590c));
    L9:
        if (r101.f285582d == false) goto L12;
        CollectionsKt.removeAll(r102.interceptors(), LarkHttpImpl$doCreateClient$2.INSTANCE);
        r102.addInterceptor(new f());
    L12:
        if (r101.f285583e == false) goto L14;
        CollectionsKt.removeAll(r102.interceptors(), LarkHttpImpl$doCreateClient$3.INSTANCE);
        ListProtector.add(r102.interceptors(), 0, new e());
    L14:
        CollectionsKt.removeAll(r102.interceptors(), LarkHttpImpl$doCreateClient$4.INSTANCE);
        CollectionsKt.removeAll(r102.interceptors(), LarkHttpImpl$doCreateClient$5.INSTANCE);
        CollectionsKt.removeAll(r102.interceptors(), LarkHttpImpl$doCreateClient$6.INSTANCE);
        r102.addInterceptor(new g(r102.build().cookieJar()));
        Iterator<T> r103 = r102.networkInterceptors().iterator();
    L16:
        if (r103.hasNext() == false) goto L18;
        r102.addInterceptor((Interceptor) r103.next());
        goto L16
    L18:
        com.larksuite.framework.http.v2.d r104 = r101.f285580b;
        r102.addInterceptor(new com.larksuite.framework.http.v2.internal.rust.stream.a(0));
        r102.addInterceptor(new com.larksuite.framework.http.v2.internal.rust.a(this.f285588a.a(r104), com.larksuite.framework.http.v2.e.f285587a.contains(Reflection.getOrCreateKotlinClass(r104.getClass()))));
        b r105 = new b(r102.build(), r101, this);
        List<WeakReference<com.larksuite.framework.http.v2.c>> r106 = this.f285592e;
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) r106;
        r107.add(new WeakReference(r105));
        return r105;
    }

    public LarkHttpImpl(com.larksuite.framework.http.v2.internal.rust.d r100, com.larksuite.framework.http.v2.a r101, e28.c r102) {
        Intrinsics.checkNotNullParameter(r100, "clientProvider");
        Intrinsics.checkNotNullParameter(r101, "larkCookies");
        Intrinsics.checkNotNullParameter(r102, "uaSupporter");
        this.f285588a = r100;
        this.f285589b = r101;
        this.f285590c = r102;
        this.f285591d = LazyKt.lazy(new LarkHttpImpl$defaultClient$2(this));
        this.f285592e = new CopyOnWriteArrayList();
    }
}
