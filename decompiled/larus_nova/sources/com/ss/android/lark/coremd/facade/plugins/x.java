package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class x implements com.ss.android.lark.coremd.base.parse.n.b<eab.b> {
    public x() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IMContextExtend.A.b(new ChatMessageClickPlugin$configureClick$7$1(r100));
    }
}
