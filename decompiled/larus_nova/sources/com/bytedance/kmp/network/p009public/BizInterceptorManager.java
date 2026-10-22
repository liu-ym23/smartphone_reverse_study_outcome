package com.bytedance.kmp.network.p009public;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jd6.b;
import jd6.c;
import jd6.e;
import jd6.f;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class BizInterceptorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BizInterceptorManager f252555a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f252556b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<b> f252557c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<a> f252558d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<b> f252559e = null;

    public BizInterceptorManager() {
    }

    static {
        f252555a = new BizInterceptorManager();
        f252556b = new ArrayList();
        f252557c = new ArrayList();
        f252558d = new ArrayList();
        f252559e = new ArrayList();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00f2 -> B:38:0x00f5). Please report as a decompilation issue!!! */
    public final Object a(c r110, Continuation<? super c> r111) {
        if ((r111 instanceof BizInterceptorManager$intercept$1) == false) goto L7;
        BizInterceptorManager$intercept$1 r100 = (BizInterceptorManager$intercept$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Iterator r113 = (Iterator) r100.L$3;
        f r104 = (f) r100.L$2;
        Map r105 = (Map) r100.L$1;
        Map r106 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L38:
        e r114 = (e) r112;
    L34:
        if (r113.hasNext() == false) goto L39;
        b r115 = (b) r113.next();
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.L$2 = r104;
        r100.L$3 = r113;
        r100.label = 1;
        r112 = r115.intercept();
        if (r112 != r102) goto L38;
        return r102;
    L39:
        f r116 = r104;
        Map r107 = r105;
        e r108 = r114;
        Map r117 = r106;
    L40:
        r116.getClass();
        String r118 = com.bytedance.kmp.network.f.a(r108.f498630a, r117);
        Intrinsics.checkNotNullParameter(r118, "url");
        r108.f498630a = r118;
        LinkedHashMap r119 = new LinkedHashMap();
        r119.putAll(r108.f498632c);
        r119.putAll(r107);
        Intrinsics.checkNotNullParameter(r119, "headers");
        r108.f498632c = r119;
        return r108.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r117 = new LinkedHashMap();
        r107 = new LinkedHashMap();
        r110.getClass();
        r108 = new e(r110);
        r116 = r110.f498628e;
        if (r116.f498640e == false) goto L26;
        Iterator r109 = ((ArrayList) f252556b).iterator();
    L18:
        if (r109.hasNext() == false) goto L21;
        b r120 = (b) r109.next();
        r117.putAll(r120.getCommonParams());
        r117.putAll(r120.a());
        goto L18
    L21:
        if (r116.f498644i == false) goto L26;
        Iterator r121 = ((ArrayList) f252557c).iterator();
    L24:
        if (r121.hasNext() == false) goto L26;
        r117.putAll(((b) r121.next()).a());
    L26:
        Iterator r122 = ((ArrayList) f252558d).iterator();
    L28:
        if (r122.hasNext() == false) goto L30;
        a r123 = (a) r122.next();
        r107.putAll(r123.q());
        r107.putAll(r123.a());
        goto L28
    L30:
        ArrayList r124 = (ArrayList) f252559e;
        if ((!r124.isEmpty()) == true) goto L40;
        r104 = r116;
        r113 = r124.iterator();
        r106 = r117;
        r114 = r108;
        r105 = r107;
    L7:
        r100 = new BizInterceptorManager$intercept$1(this, r111);
        goto L8
    }
}
