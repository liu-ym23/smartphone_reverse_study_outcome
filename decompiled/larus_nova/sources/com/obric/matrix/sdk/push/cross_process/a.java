package com.obric.matrix.sdk.push.cross_process;

import java.util.List;
import kka.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements jka.a {
    public a() {
    }

    @Override // jka.a
    public final void onCallback(List<Object> r100) {
        String r101 = "sdk event: " + r100;
        int r102 = b.f503830a;
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.a("", r101);
    }
}
