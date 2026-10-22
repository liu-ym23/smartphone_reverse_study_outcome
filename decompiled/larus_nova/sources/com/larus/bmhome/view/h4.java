package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h4 {
    public static BaseTextAnswerActionButton a(rs8.g r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = 0;
        int r103 = 6;
        AttributeSet r104 = null;
        if ((r100 instanceof rs8.j) == false) goto L6;
        BaseTextAnswerActionButton r105 = new TextAnswerSingleActionButton(r101, r104, r103, r102);
    L12:
        FLogger.f375446a.d("TextAnswerActionButtonFactory", "create action type: ".concat(r100.getClass().getName()));
        return r105;
    L6:
        if ((r100 instanceof rs8.n) == false) goto L9;
        r105 = new TextAnswerSingleActionButton(r101, r104, r103, r102);
        goto L12
    L9:
        if ((r100 instanceof rs8.o) == false) goto L11;
        r105 = new TextAnswerMultiActionButton(r101, null, 6, 0);
        goto L12
    L11:
        FLogger.f375446a.w("TextAnswerActionButtonFactory", "unknown action type: ".concat(r100.getClass().getName()));
        r105 = new TextAnswerSingleActionButton(r101, r104, r103, r102);
        goto L12
    }
}
