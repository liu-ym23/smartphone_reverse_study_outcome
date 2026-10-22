package lbc;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;
import yya.p;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements p {
    public a() {
    }

    @Override // yya.l
    public final String getTAG() {
        return getMessageType().name() + "_interceptor";
    }

    @Override // yya.p
    public final Message.Type getMessageType() {
        return Message.Type.VOTE;
    }

    @Override // yya.l
    public final boolean a(MessageActionType r100, yya.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r100 != MessageActionType.ADD_TO_FAVORITE) goto L5;
        return true;
    L5:
        if (r100 == MessageActionType.FORWARD) goto L11;
        return false;
    L11:
        return true;
    }
}
