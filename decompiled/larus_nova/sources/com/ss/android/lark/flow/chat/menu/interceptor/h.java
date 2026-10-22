package com.ss.android.lark.flow.chat.menu.interceptor;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements yya.c {
    public h() {
    }

    @Override // yya.l
    public final String getTAG() {
        return "FlowReplyActionInterceptor";
    }

    @Override // yya.l
    public final boolean a(MessageActionType r100, yya.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r100 == MessageActionType.REPLY) goto L5;
        return false;
    L5:
        if (r101.r() != PageType.REPLY_IN_THREAD) goto L10;
        return true;
    L10:
        return false;
    }
}
