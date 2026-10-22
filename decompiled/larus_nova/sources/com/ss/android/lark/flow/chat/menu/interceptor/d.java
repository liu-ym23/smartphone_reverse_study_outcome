package com.ss.android.lark.flow.chat.menu.interceptor;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;
import yya.p;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements p {
    public d() {
    }

    @Override // yya.l
    public final String getTAG() {
        return "FlowAudioMessageInterceptor";
    }

    @Override // yya.p
    public final Message.Type getMessageType() {
        return Message.Type.AUDIO;
    }

    @Override // yya.l
    public final boolean a(MessageActionType r100, yya.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r100 != MessageActionType.FORWARD) goto L6;
        return true;
    L6:
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        return false;
    }
}
