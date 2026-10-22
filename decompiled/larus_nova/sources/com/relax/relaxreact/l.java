package com.relax.relaxreact;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l<T> implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context<T> f405545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f405546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<d> f405547c;

    public final Context<T> getContext() {
        Context<T> r100 = this.f405545a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.relax.relaxreact.k
    public final Object c() {
        return this.f405546b;
    }

    @Override // com.relax.relaxreact.k
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        com.bytedance.rts.kmp.foundation.i.f(this.f405547c, r100);
    }

    @Override // com.relax.relaxreact.k
    public final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        int r101 = com.bytedance.rts.kmp.foundation.i.d(this.f405547c, r100);
        if (r101 == (-1)) goto L6;
        com.bytedance.rts.kmp.foundation.i.i(this.f405547c, r101, new d[0]);
        return;
    }

    public l(Context<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f405547c = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405545a = r100;
        this.f405546b = r101;
    }
}
