package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class f0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f344498a;

    public /* synthetic */ f0(int r100) {
        this.f344498a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        int r101 = this.f344498a;
        p r102 = (p) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        if (r102.getType() != r101) goto L5;
        boolean r103 = true;
    L7:
        return Boolean.valueOf(r103);
    L5:
        r103 = false;
        goto L7
    }
}
