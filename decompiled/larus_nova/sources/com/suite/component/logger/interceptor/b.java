package com.suite.component.logger.interceptor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.suite.component.logger.api.d;
import com.suite.component.logger.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f460146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f460147b;

    @Override // com.suite.component.logger.api.d.a
    public final b clone() {
        return new b(this.f460146a, this.f460147b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int r100, List<? extends d> r101) {
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        this.f460146a = r100;
        this.f460147b = r101;
    }

    @Override // com.suite.component.logger.api.d.a
    public final void a(com.suite.component.logger.b r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "logContext");
        Intrinsics.checkNotNullParameter(r101, "logEntity");
        int r102 = this.f460146a + 1;
        this.f460146a = r102;
        if (r102 >= this.f460147b.size()) goto L6;
        ((d) ListProtector.get(this.f460147b, this.f460146a)).a(this, r100, r101);
        return;
    }
}
