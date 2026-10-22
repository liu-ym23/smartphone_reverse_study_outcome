package com.bytedance.ee.bear.more.protocol3.panel;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<x, Boolean, Boolean> f234981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<x, Boolean, Boolean> f234982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<x, i> f234983c;

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final i a(x r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Function1<x, i> r101 = this.f234983c;
        if (r101 == null) goto L7;
        i r102 = r101.invoke(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return i.b.f234980a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean b(x r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Function2<x, Boolean, Boolean> r102 = this.f234981a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.invoke(r100, Boolean.valueOf(r101)).booleanValue();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean c(x r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Function2<x, Boolean, Boolean> r102 = this.f234982b;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.invoke(r100, Boolean.valueOf(r101)).booleanValue();
    }

    public j(Function2 r100, Function2 r101, Function1 r102) {
        this.f234981a = r100;
        this.f234982b = r101;
        this.f234983c = r102;
    }
}
