package com.bytedance.bdnavigationsdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Exception c;

    public /* synthetic */ h(String r1, int r2, Exception r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r8) {
        String r1 = this.a;
        int r2 = this.b;
        Exception r4 = this.c;
        w r9 = (w) r8;
        Intrinsics.checkNotNullParameter(r9, "listener");
        r9.k(new com.bytedance.bdnavigationsdk.navigation.x(r1, r2, null, r4, 4));
        return Unit.INSTANCE;
    }
}
