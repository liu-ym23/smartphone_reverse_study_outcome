package kbc;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.ImPlugin;
import com.ss.android.lark.integrator.im.extension.ImContextImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vote.message.cell.c;
import com.ss.android.lark.vote.message.cell.g;
import kotlin.jvm.internal.Intrinsics;
import qbc.d;
import qxa.b;

/* JADX INFO: loaded from: classes38.dex */
@ImPlugin
public final class a implements b {
    public a() {
    }

    @Override // qxa.b
    public final void a(ImContextImpl r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.a(new c());
        r100.e(ImExtensionType.MESSAGE_ACTION_INTERCEPTOR, lbc.a.class);
        r100.b(new g());
        r100.c(new d());
    }
}
