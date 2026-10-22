package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f235225a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemClick");
        this.f235225a = r100;
    }
}
