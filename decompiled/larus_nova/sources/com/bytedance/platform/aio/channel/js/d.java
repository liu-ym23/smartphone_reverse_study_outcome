package com.bytedance.platform.aio.channel.js;

import com.bytedance.platform.aio.channel.e;
import com.bytedance.platform.aio.channel.js.model.g;
import com.bytedance.platform.aio.channel.js.model.j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    public static final g a(e<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJsModel");
        if ((r100 instanceof e.b) == false) goto L6;
        com.bytedance.platform.aio.channel.js.model.b r101 = new com.bytedance.platform.aio.channel.js.model.b();
        r101.f(r100.a());
        e.b r102 = (e.b) r100;
        r101.g(r102.f266581b);
        r101.h(r102.f266582c);
        r101.i(r102.f266583d.getType());
        return r101;
    L6:
        if ((r100 instanceof e.d.a) == false) goto L9;
        j r103 = new j();
        r103.g(r100.a());
        e.d.a r104 = (e.d.a) r100;
        r103.i(r104.f266586b);
        r103.h(r104.f266587c.getType());
        return r103;
    L9:
        if ((r100 instanceof e.d.b) == false) goto L12;
        j r105 = new j();
        r105.g(r100.a());
        com.bytedance.platform.aio.channel.a r106 = ((e.d.b) r100).f266589b;
        Intrinsics.checkNotNullParameter(r106, "$this$toJsModel");
        com.bytedance.platform.aio.channel.js.model.c r107 = new com.bytedance.platform.aio.channel.js.model.c();
        r107.e(r106.f266574a);
        r107.g(r106.f266575b);
        r107.f(r106.f266576c);
        r105.j(r107);
        return r105;
    L12:
        if ((r100 instanceof e.a) == false) goto L23;
        com.bytedance.platform.aio.channel.js.model.a r108 = new com.bytedance.platform.aio.channel.js.model.a();
        r108.d(r100.a());
        e.a r109 = (e.a) r100;
        Intrinsics.checkNotNullParameter(r109, "$this$flags");
        if (r109.f266578b == false) goto L16;
        int r110 = 2;
    L18:
        if (r109.f266579c == false) goto L20;
        r110 = r110 | 1;
    L20:
        r108.e(r110);
        return r108;
    L16:
        r110 = 0;
        goto L18
    L23:
        if ((r100 instanceof e.c) == false) goto L27;
        throw new UnsupportedOperationException();
    L27:
        throw new NoWhenBranchMatchedException();
    }
}
