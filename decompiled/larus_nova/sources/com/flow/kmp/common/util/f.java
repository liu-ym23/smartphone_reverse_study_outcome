package com.flow.kmp.common.util;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.a0;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static final boolean b(ouc.i r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof d0) == false) goto L12;
        return ((d0) r100).keySet().isEmpty();
    L12:
        if ((r100 instanceof ouc.b) == false) goto L15;
        return ((ouc.b) r100).isEmpty();
    L15:
        if ((r100 instanceof g0) == false) goto L22;
        g0 r101 = (g0) r100;
        if (r101.c() == true) goto L25;
        return false;
    L25:
        return StringsKt.isBlank(r101.a());
    L22:
        throw new NoWhenBranchMatchedException();
    }

    public static final String d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if ((true ^ r101) == true) goto L14;
        return null;
    L14:
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static final d0 e(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return new d0(MapsKt.emptyMap());
    L12:
        if (StringsKt.startsWith$default(r100, "{", false, 2, null) == false) goto L25;
        if (StringsKt.endsWith$default(r100, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L25;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        Object r103 = Result.m9449constructorimpl(ouc.k.n(xt7.d.f565073b.e(r100)));     // Catch: Throwable -> L18
    L20:
        d0 r104 = new d0(MapsKt.emptyMap());
        if (Result.m9455isFailureimpl(r103) == false) goto L29;
        r103 = r104;
    L29:
        return (d0) r103;
    L18:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        return new d0(MapsKt.emptyMap());
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final d0 c(d0 r100, d0 r101, boolean r102) {
        if (b(r101) == false) goto L6;
        return r100;
    L6:
        if (b(r100) == false) goto L8;
        return r101;
    L8:
        Map r103 = MapsKt.toMutableMap(r100);
        Iterator<String> r104 = r101.keySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L44;
        String r105 = r104.next();
        ouc.i r106 = (ouc.i) r101.get(r105);
        ouc.i r107 = (ouc.i) r103.get(r105);
        if (r103.containsKey(r105) == false) goto L36;
        if (b(r107) == true) goto L36;
        if (b(r106) == true) goto L18;
        if (r106.getClass() != r107.getClass()) goto L10;
        if ((r107 instanceof d0) == true) goto L27;
        if ((r107 instanceof ouc.b) == true) goto L30;
        if ((r107 instanceof g0) == false) goto L35;
        r103.put(r105, r106);
        goto L10
    L35:
        throw new NoWhenBranchMatchedException();
    L30:
        ArrayList r108 = new ArrayList();
        Collection r109 = (Collection) r107;
        Intrinsics.checkNotNullParameter(r109, SlcElement.KEY_ELEMENTS);
        r108.addAll(r109);
        ouc.b r110 = ouc.k.m(r106);
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        r108.addAll(r110);
        r103.put(r105, new ouc.b(r108));
        goto L10
    L27:
        r103.put(r105, c((d0) r107, ouc.k.n(r106), r102));
        goto L10
    L18:
        if (r102 == false) goto L10;
        if (r106 != null) goto L21;
        r106 = a0.INSTANCE;
    L21:
        r103.put(r105, r106);
    L36:
        if (r102 == true) goto L37;
        if (b(r106) == true) goto L10;
        r103.put(r105, r106);
        goto L10
    L37:
        if (r106 != null) goto L39;
        r106 = a0.INSTANCE;
    L39:
        r103.put(r105, r106);
        goto L10
    L44:
        return new d0(r103);
    }
}
