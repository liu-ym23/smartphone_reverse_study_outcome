package com.bytedance.locallife.live.goodsshelves.manager;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Predicate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f259743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PagedCacheManager f259744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f259745c;

    public r(String r100, PagedCacheManager r101, Map<String, String> r102) {
        this.f259743a = r100;
        this.f259744b = r101;
        this.f259745c = r102;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if ((r101 instanceof CronetIOException) == false) goto L9;
        CronetIOException r102 = (CronetIOException) r101;
        if (r102.getStatusCode() == 0) goto L7;
        int r103 = r102.getStatusCode();
    L8:
        String r104 = r102.url;
    L11:
        if ((r101 instanceof NullPointerException) == false) goto L14;
        r103 = -2;
    L14:
        if (r103 != (-2)) goto L16;
    L29:
        qv6.c.e(this.f259743a, false, r103, r104);
        this.f259744b.f259668m = false;
        return false;
    L16:
        if (400 > r103) goto L19;
        if (r103 >= 500) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L29;
        v r106 = v.f259753a;
        if (r106.c() == true) goto L29;
        if (r103 >= 500) goto L26;
    L28:
        this.f259745c.put("from", "1");
        qv6.c.e(this.f259743a, true, r103, r104);
        return true;
    L26:
        if (r106.c() == true) goto L28;
        r106.a();
    L19:
        r105 = false;
        goto L20
    L7:
        r103 = r102.getCronetInternalErrorCode();
        goto L8
    L9:
        r103 = -1;
        r104 = "/data/life/live/agg/card/detail/";
        goto L11
    }
}
