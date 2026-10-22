package com.ss.android.lark.flow.chat.message.system;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.ImPlugin;
import com.ss.android.lark.integrator.im.extension.ImContextImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@ImPlugin
public final class c implements qxa.b {
    public c() {
    }

    @Override // qxa.b
    public final void a(ImContextImpl r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.d(ImExtensionType.MESSAGE_ACTION_HANDLER_PROVIDER, CollectionsKt.listOf(d.class));
        r100.d(ImExtensionType.SYSTEM_MESSAGE_ACTION_PROCESSOR, CollectionsKt.listOf(new Class[]{b.class, a.class}));
    }
}
