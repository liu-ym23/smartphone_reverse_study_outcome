package com.ss.android.lark.passportc.internal;

import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class n implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<List<h>, Unit> f438476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<h> f438477b;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Function1<? super List<h>, Unit> r100, List<h> r101) {
        this.f438476a = r100;
        this.f438477b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Function1<List<h>, Unit> r100 = this.f438476a;
        List<h> r101 = this.f438477b;
        Intrinsics.checkNotNull(r101);
        r100.invoke(r101);
    }
}
