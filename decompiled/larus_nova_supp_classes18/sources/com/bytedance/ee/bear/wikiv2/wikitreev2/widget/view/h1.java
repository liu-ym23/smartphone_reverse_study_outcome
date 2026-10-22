package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h1<T> implements Consumer {
    public final /* synthetic */ WikiTreeMoreProvider a;

    public h1(WikiTreeMoreProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        SpaceInfo r4 = (SpaceInfo) r3;
        WikiTreeMoreProvider r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.o = r4;
        this.a.g();
    }
}
