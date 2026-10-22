package com.ss.android.lark.movable.selection;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements h {

    /* JADX INFO: renamed from: com.ss.android.lark.movable.selection.a$a, reason: collision with other inner class name */
    public static final class C5141a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final boolean a(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return false;
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final void b(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        Context r104 = r102.getApplicationContext();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        Object r106 = r104.getSystemService(DataType.CLIPBOARD);     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Throwable -> L11
        qf7.a r107 = qf7.a.f532746a;     // Catch: Throwable -> L11
        r107.a((ClipboardManager) r106, ClipData.newPlainText(null, r100), new Token("LARK-PSDA-knowledge_ai_long_selection"));     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L11
        UDToast.show(r104, R.string.Lark_Legacy_CopySuccess);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        r103 = false;
        goto L6
    }
}
