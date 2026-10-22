package com.obric.assistant.obric_action;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {
    public static final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get("o_obric_action_key");
    }
}
