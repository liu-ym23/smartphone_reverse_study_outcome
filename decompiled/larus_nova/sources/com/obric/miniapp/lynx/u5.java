package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u5 extends com.lynx.tasm.behavior.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<LynxContext, LynxUI<?>> f398304a;

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI<?> createUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f398304a.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u5(String r100, Function1<? super LynxContext, ? extends LynxUI<?>> r101) {
        this.f398304a = r101;
        super(r100, false);
    }
}
