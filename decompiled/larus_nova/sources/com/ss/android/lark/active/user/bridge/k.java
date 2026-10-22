package com.ss.android.lark.active.user.bridge;

import dagger.hilt.EntryPoints;
import io.reactivex.functions.Function;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p<Object, Object> f408572a;

    public k(p<Object, Object> r100) {
        this.f408572a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponent");
        p<Object, Object> r101 = this.f408572a;
        r101.getClass();
        q r102 = (q) EntryPoints.get(r100, q.class);
        Provider<e<?, ?>> r103 = r102.b().get(r101.f408577a.f408587b);
        if (r103 != null) goto L5;
        r103 = r102.u().a().get(r101.f408577a.f408587b);
    L5:
        if (r103 == null) goto L7;
        e<?, ?> r104 = r103.get();
    L8:
        if (r104 == null) goto L11;
        r101.f408577a.getClass();
        return new c(r104.a());
    L11:
        return new a(10002, "user scope handler not found", new IllegalStateException("user scope handler not found"));
    L7:
        r104 = null;
        goto L8
    }
}
