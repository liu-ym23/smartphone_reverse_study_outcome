package com.bytedance.sdk.xbridge.cn.registry.core;

import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.xbridge.cn.utils.ThreadPool;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me7.f;
import me7.n;
import me7.o;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f270083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, IDLXBridgeMethod>> f270084b;

    public a(int r100) {
        this.f270083a = r100;
        this.f270084b = new ConcurrentHashMap();
    }

    public final IDLXBridgeMethod a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        ConcurrentHashMap<String, IDLXBridgeMethod> r102 = this.f270084b.get(r100);
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        if (r103 == true) goto L9;
        return null;
    L9:
        return r102.get(r101);
    L5:
        if (r102.containsKey(r101) != true) goto L7;
        r103 = true;
        goto L7
    }

    public final void b(String r100, IDLXBridgeMethod r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        String r102 = r101.getName();
        ConcurrentHashMap<String, IDLXBridgeMethod> r103 = this.f270084b.get(r100);
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.containsKey(r102) != true) goto L7;
    L8:
        if (r104 == false) goto L11;
        return;
    L11:
        if (r101.getCompatibility().getValue() == true) goto L16;
        Class<?> r105 = r101.getClass();
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> r106 = o.f513548a;
        Intrinsics.checkNotNullParameter(r105, "clazz");
        if (o.f513548a.contains(r105) == true) goto L16;
        ThreadPool.b(new n(r105));
    L16:
        if (r103 != null) goto L18;
        this.f270084b.put(r100, new ConcurrentHashMap(this.f270083a));
    L18:
        ConcurrentHashMap<String, IDLXBridgeMethod> r107 = this.f270084b.get(r100);
        if (r107 == null) goto L22;
        r107.put(r102, r101);
        return;
    L22:
        return;
    L7:
        r104 = false;
        goto L8
    }
}
