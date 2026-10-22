package com.ss.android.lark.officewebview.webview_api.adapter;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeWebViewServiceManager implements txb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeWebView f437567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, txb.c> f437568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f437569c;

    public OfficeWebViewServiceManager(OfficeWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "officeWebView");
        this.f437567a = r100;
        this.f437568b = new ConcurrentHashMap();
        this.f437569c = LazyKt.lazy(new OfficeWebViewServiceManager$renderServiceAdapter$2(this));
    }

    @Override // txb.b
    public final void b(Class<? extends txb.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceImplClass");
        boolean r101 = false;
        txb.c r102 = r100.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        Class<?>[] r103 = r100.getInterfaces();
        Intrinsics.checkNotNull(r103);
        if (r103.length != 0) goto L5;
        r101 = true;
    L5:
        if (r101 == false) goto L7;
        return;
    L7:
        Iterator r104 = ArrayIteratorKt.iterator(r103);
    L9:
        if (r104.hasNext() == false) goto L13;
        Class r105 = (Class) r104.next();
        if (txb.c.class.isAssignableFrom(r105) == false) goto L9;
        this.f437568b.put(r105.getCanonicalName(), r102);
        goto L9
    }

    @Override // txb.b
    public final <T extends txb.c> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceInterface");
        if (Intrinsics.areEqual(r100, txb.a.class) == false) goto L8;
        txb.a r101 = (txb.a) this.f437569c.getValue();
        if ((r101 instanceof txb.c) == true) goto L7;
        return null;
    L7:
        return r101;
    L8:
        txb.c r102 = this.f437568b.get(r100.getCanonicalName());
        if ((r102 instanceof txb.c) == true) goto L11;
        return null;
    L11:
        return (T) r102;
    }
}
