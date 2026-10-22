package com.obric.assistant.utils;

import com.obric.aiagent.assistant.idl.bean.StateInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m {
    public static final String a(StateInfo r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L6;
        String r102 = r101.get("o_complex_source_type");
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public static final String b(StateInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return "StateInfo(requestType: " + r100.getRequestType() + ", refMessageId: " + r100.getRefMessageId() + ", taskType = " + r100.getTaskType() + ", isInIsland = " + r100.isInIsland() + ')';
    }
}
