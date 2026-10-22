package com.larus.feishu.office.im.impl.smart_reply;

import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {
    public static final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("smart_reply_trigger_user_id");
    L7:
        if (Intrinsics.areEqual(r102, AccountService.f365697a.getUserId()) == false) goto L9;
        return "adopt_action_user";
    L9:
        return "adopt_receive_user";
    L5:
        r102 = null;
        goto L7
    }

    public static final String b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 == null) goto L7;
        String r102 = r101.get("smart_reply_message_id");
        if (r102 == null) goto L7;
        return r102;
    L7:
        return r100.getMessageId();
    }
}
