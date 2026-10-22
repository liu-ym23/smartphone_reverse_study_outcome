package com.obric.assistant.utils;

import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes33.dex */
public final class f {
    public static final String a(DMTaskInfo r100) {
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("o_last_reply_message_id");
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
