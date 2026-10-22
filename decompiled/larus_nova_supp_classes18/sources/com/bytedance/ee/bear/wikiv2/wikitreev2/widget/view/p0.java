package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ WikiSpaceMoreProvider a;

    public p0(WikiSpaceMoreProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        SpaceInfo r3 = (SpaceInfo) r2;
        Intrinsics.checkNotNullParameter(r3, "spaceInfo");
        WikiSpaceMoreProvider r0 = this.a;
        r0.s = r3;
        r0.g();
    }
}
