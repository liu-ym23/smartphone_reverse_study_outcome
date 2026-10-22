package com.bytedance.caijing.sdk.infra.base.impl.ttnet;

import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Interceptor> f202747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f202748b;

    static {
        f202747a = new ArrayList();
        int r100 = 0;
        f202748b = false;
        ve4.a.f554342a.getClass();
        ArrayList<? extends Object> r101 = ((CJHostService) ve4.a.d(CJHostService.class)).getTTNetInterceptors();
    L4:
        if (r100 >= r101.size()) goto L11;
        Object r102 = ListProtector.get(r101, r100);
        if ((r102 instanceof Interceptor) == false) goto L10;
        Interceptor r103 = (Interceptor) r102;
        ArrayList r104 = (ArrayList) f202747a;
        if (r104.contains(r103) == true) goto L10;
        r104.add(r103);
    L10:
        r100 = r100 + 1;
        goto L4
    }
}
