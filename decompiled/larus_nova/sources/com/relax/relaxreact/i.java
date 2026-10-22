package com.relax.relaxreact;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i<T> extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f405510c;

    @Override // com.relax.relaxreact.a0
    public final void a() {
        d r100 = this.f405462b;
        if (r100 == null) goto L8;
        k r101 = this.f405510c;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        r101.b(r100);
        return;
    L9:
        return;
    }

    public i(Context<T> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(HookType.Context);
        d r101 = this.f405462b;
        if (r101 == null) goto L7;
        Map<Integer, k> r102 = r101.f405483j;
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r100.f405396a);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        k r104 = r102.get(r103);
    L8:
        if (r104 == null) goto L11;
        this.f405510c = r104;
        Intrinsics.checkNotNull(r104);
        d r105 = this.f405462b;
        Intrinsics.checkNotNull(r105);
        r104.a(r105);
        return;
    L11:
        return;
    L7:
        r104 = null;
        goto L8
    }
}
