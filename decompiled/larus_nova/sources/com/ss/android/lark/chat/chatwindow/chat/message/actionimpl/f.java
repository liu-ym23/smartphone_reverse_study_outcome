package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.app.Activity;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import mya.r;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements r {
    public f() {
    }

    @Override // mya.p
    public final void e(Activity r100, View r101, nya.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r102, "params");
        int r103 = e.f412609a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r102, "params");
        e.a(null, r100, r101, r102);
    }
}
