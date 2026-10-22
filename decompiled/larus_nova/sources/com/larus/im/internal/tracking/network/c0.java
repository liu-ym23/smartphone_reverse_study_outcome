package com.larus.im.internal.tracking.network;

import com.larus.im.internal.delegate.o0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c0 implements Function0 {
    public /* synthetic */ c0() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (o0.f348249a.isNetworkAvailable() == false) goto L5;
        long r100 = 1;
    L7:
        return Long.valueOf(r100);
    L5:
        r100 = 0;
        goto L7
    }
}
