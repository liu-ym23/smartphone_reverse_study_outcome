package com.ss.android.ainote;

import android.content.Context;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin$visitLink$1$1;
import com.ss.android.lark.keyboard.edittext2.mdeditor.link.TemporaryPreviewLoader;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a1 extends TemporaryPreviewLoader {
    public a1() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.mdeditor.link.TemporaryPreviewLoader, cab.b
    public final void b(Context r100, v7b.n r101, LarkLinkPlugin$visitLink$1$1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "link");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super.b(r100, r101, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r102.onError(new ErrorResult(e));
    }
}
