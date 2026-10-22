package com.larksuite.component.card.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f283927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends c>, c> f283928b;

    public final void a() {
        Iterator r100 = ((HashMap) this.f283928b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) ((Map.Entry) r100.next()).getValue()).destroy();
        goto L4
    L6:
        ((HashMap) this.f283928b).clear();
        this.f283927a = true;
    }

    public a() {
        this.f283928b = new HashMap();
    }

    public final <T extends c> T b(Class<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceClass");
        Intrinsics.checkNotNullParameter(r101, "initBlock");
        T r102 = (T) ((HashMap) this.f283928b).get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        T r103 = r101.invoke();
        ((HashMap) this.f283928b).put(r100, r103);
        return r103;
    }
}
