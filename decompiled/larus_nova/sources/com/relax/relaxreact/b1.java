package com.relax.relaxreact;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f405466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f405467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<Object, Unit> f405468c;

    public final int getType() {
        return this.f405467b;
    }

    public b1(String r100, int r101, Function1<Object, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f405466a = r100;
        this.f405467b = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405468c = r102;
    }
}
