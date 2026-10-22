package com.larus.doc.impl.operation;

import com.larus.utils.logger.FLogger;
import kotlin.Result;

/* JADX INFO: loaded from: classes27.dex */
public final class m implements n39.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Integer> f331427a;

    @Override // n39.e
    public final void a() {
        FLogger.f375446a.i("DocOpManager", "delete success v2: " + System.currentTimeMillis());
        kotlinx.coroutines.i<Integer> r100 = this.f331427a;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(3));
    }

    @Override // n39.e
    public final void b() {
        kotlinx.coroutines.i<Integer> r100 = this.f331427a;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(1));
    }

    public m(kotlinx.coroutines.j r100) {
        this.f331427a = r100;
    }
}
