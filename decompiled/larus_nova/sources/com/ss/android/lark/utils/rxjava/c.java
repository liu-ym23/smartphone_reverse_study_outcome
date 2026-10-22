package com.ss.android.lark.utils.rxjava;

import io.reactivex.Observer;
import io.reactivex.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c<T> implements q<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StackTraceElement[] f444762a;

    public c(StackTraceElement[] r100) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        this.f444762a = r100;
    }

    @Override // io.reactivex.q
    public final b a(Observer r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        return new b(r100, this);
    }
}
