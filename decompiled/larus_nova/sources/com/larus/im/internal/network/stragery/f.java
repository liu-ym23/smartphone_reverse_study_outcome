package com.larus.im.internal.network.stragery;

import com.larus.im.callback.IIMError;
import com.larus.im.callback.IMError;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.StatusCode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f349540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f349541b = null;

    static {
        f349540a = LazyKt.lazy(new d());
        f349541b = LazyKt.lazy(new e());
    }

    public static final boolean a() {
        return ((Boolean) f349540a.getValue()).booleanValue();
    }

    public static final com.larus.im.internal.network.e<DownlinkMessage> c(DownlinkMessage r100) {
        if (r100 == null) goto L10;
        int r101 = r100.statusCode;
        if (r101 == StatusCode.OK.value) goto L9;
        return new com.larus.im.internal.network.e.d(new IMError(r101, r100.statusDesc, null, null, 12, null), r100, 4);
    L9:
        return new com.larus.im.internal.network.e.f(r100, null, 6);
    L10:
        return new com.larus.im.internal.network.e.g(null, 3);
    }

    public static final <T, R> com.larus.im.internal.network.e<R> b(com.larus.im.internal.network.e<T> r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        R r102 = null;
        if ((r100 instanceof com.larus.im.internal.network.e.g) == false) goto L7;
        return new com.larus.im.internal.network.e.g(null, 3);
    L7:
        if ((r100 instanceof com.larus.im.internal.network.e.d) == false) goto L14;
        com.larus.im.internal.network.e.d r103 = (com.larus.im.internal.network.e.d) r100;
        T r104 = r103.f349181b;
        IIMError r105 = r103.f349180a;
        if (r104 == null) goto L12;
        r102 = r101.invoke(r104);
    L12:
        return new com.larus.im.internal.network.e.d(r105, r102, 4);
    L14:
        if ((r100 instanceof com.larus.im.internal.network.e.b) == false) goto L18;
        return new com.larus.im.internal.network.e.b(((com.larus.im.internal.network.e.b) r100).f349176a);
    L18:
        if ((r100 instanceof com.larus.im.internal.network.e.f) == false) goto L30;
        com.larus.im.internal.network.e.f r106 = (com.larus.im.internal.network.e.f) r100;
        R r107 = r101.invoke(r106.f349185a);
        if (r107 != null) goto L28;
        if (r106.f349186b.getCode() != StatusCode.OK.value) goto L24;
        int r108 = -1001;
    L26:
        return new com.larus.im.internal.network.e.d(new IMError(r108, r106.f349186b.getTips(), r106.f349186b.getException(), r106.f349186b.getExt()), null, 4);
    L24:
        r108 = r106.f349186b.getCode();
        goto L26
    L28:
        return new com.larus.im.internal.network.e.f(r107, r106.f349186b, 4);
    L30:
        if ((r100 instanceof com.larus.im.internal.network.e.C4366e) == false) goto L34;
        return new com.larus.im.internal.network.e.C4366e(((com.larus.im.internal.network.e.C4366e) r100).f349183a, null, 2);
    L34:
        if ((r100 instanceof com.larus.im.internal.network.e.a) == false) goto L38;
        return new com.larus.im.internal.network.e.a(((com.larus.im.internal.network.e.a) r100).f349174a, null, 2);
    L38:
        if ((r100 instanceof com.larus.im.internal.network.e.c) == false) goto L42;
        return new com.larus.im.internal.network.e.c(((com.larus.im.internal.network.e.c) r100).f349178a, null, 2);
    L42:
        if ((r100 instanceof com.larus.im.internal.network.e.h) == false) goto L46;
        return new com.larus.im.internal.network.e.h(((com.larus.im.internal.network.e.h) r100).f349190a, 2);
    L46:
        throw new NoWhenBranchMatchedException();
    }
}
