package com.relax.relaxframework;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j5 f405114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Integer, Integer> f405115b;

    public h3(l7 r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "getElementIndexByItemIndex");
        this.f405114a = r100;
        this.f405115b = r101;
    }
}
