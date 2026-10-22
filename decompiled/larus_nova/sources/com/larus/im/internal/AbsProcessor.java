package com.larus.im.internal;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.callback.IMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class AbsProcessor<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mf9.a<T> f347146a;

    public AbsProcessor(mf9.a<T> r100) {
        this.f347146a = r100;
    }

    public final void a(IMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        CoroutineExtKt.b(new AbsProcessor$onFailure$1(this, r100, null));
    }

    public final void b(mf9.c r100) {
        CoroutineExtKt.b(new AbsProcessor$onSuccess$1(this, r100, null));
    }
}
