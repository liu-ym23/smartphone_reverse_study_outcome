package com.ss.android.lark.passportc.api;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements f {
    @Inject
    public c() {
    }

    @Override // com.ss.android.lark.passportc.api.f
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.ss.android.lark.passportc.api.f
    public final Observable<Boolean> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return Observable.just(Boolean.FALSE);
    }
}
