package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f252308a;

    public n(int r100) {
        this.f252308a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        boolean r101 = true;
        if (this.f252308a == 1) goto L7;
        r101 = false;
    L7:
        return Boolean.valueOf(r101);
    }
}
