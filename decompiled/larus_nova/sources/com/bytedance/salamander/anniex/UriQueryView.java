package com.bytedance.salamander.anniex;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class UriQueryView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.anniex.bd.foundation.impl.u f267924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f267925b;

    public final com.bytedance.anniex.bd.foundation.impl.u c() {
        final com.bytedance.anniex.bd.foundation.impl.u r100 = this.f267924a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseUri");
        r100 = null;
    L5:
        r100.a();
        Intrinsics.checkNotNull(r100);
        com.bytedance.rts.foundation.m.d(this.f267925b, new UriQueryView$toUri$1(r100));
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public UriQueryView(String r100) {
        Intrinsics.checkNotNullParameter(r100, "baseUriString");
        this.f267925b = new LinkedHashMap();
        int r101 = com.bytedance.anniex.bd.foundation.impl.u.f190155c;
        com.bytedance.anniex.bd.foundation.impl.u r102 = com.bytedance.anniex.bd.foundation.impl.u.a.a(r100);
        Intrinsics.checkNotNull(r102);
        this.f267924a = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseUri");
        r102 = null;
    L5:
        Iterator r103 = com.bytedance.rts.foundation.m.c(r102.d()).iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        Map<String, Object> r105 = this.f267925b;
        com.bytedance.anniex.bd.foundation.impl.u r106 = this.f267924a;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("baseUri");
        r106 = null;
    L11:
        String r107 = r106.c(r104);
        Intrinsics.checkNotNull(r107);
        com.bytedance.rts.foundation.m.e(r105, r104, r107);
        goto L7
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f267925b).get(r100);
        if ((r101 instanceof UriQueryView) == true) goto L5;
        if (r101 == null) goto L11;
        int r102 = com.bytedance.rts.foundation.v.f267594a;
        if ((r101 instanceof String) == true) goto L10;
        return null;
    L10:
        return (String) r101;
    L11:
        return null;
    L5:
        return ((UriQueryView) r101).c().e();
    }

    public final UriQueryView d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f267925b).get(r100);
        if ((r101 instanceof UriQueryView) == true) goto L5;
        if (r101 == null) goto L10;
        int r102 = com.bytedance.rts.foundation.v.f267594a;
        if ((r101 instanceof String) == false) goto L10;
        int r103 = com.bytedance.anniex.bd.foundation.impl.u.f190155c;
        com.bytedance.anniex.bd.foundation.impl.u r104 = com.bytedance.anniex.bd.foundation.impl.u.a.a((String) r101);
        Intrinsics.checkNotNull(r104);
        UriQueryView r105 = new UriQueryView(r104);
    L11:
        com.bytedance.rts.foundation.m.e(this.f267925b, r100, r105);
        return r105;
    L10:
        r105 = new UriQueryView("");
        goto L11
    L5:
        return (UriQueryView) r101;
    }

    public UriQueryView(com.bytedance.anniex.bd.foundation.impl.u r100) {
        Intrinsics.checkNotNullParameter(r100, "baseUri");
        this.f267925b = new LinkedHashMap();
        this.f267924a = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseUri");
        r100 = null;
    L5:
        Iterator r101 = com.bytedance.rts.foundation.m.c(r100.d()).iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        String r102 = (String) r101.next();
        Map<String, Object> r103 = this.f267925b;
        com.bytedance.anniex.bd.foundation.impl.u r104 = this.f267924a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("baseUri");
        r104 = null;
    L11:
        String r105 = r104.c(r102);
        Intrinsics.checkNotNull(r105);
        com.bytedance.rts.foundation.m.e(r103, r102, r105);
        goto L7
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L5;
        com.bytedance.rts.foundation.m.e(this.f267925b, r100, r101);
        return;
    L5:
        com.bytedance.rts.foundation.m.delete(this.f267925b, r100);
    }
}
