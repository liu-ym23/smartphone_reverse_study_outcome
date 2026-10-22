package com.obric.assistant.utils;

import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {
    public static final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("o_reference_msg_id");
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final String b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("o_omni_task_id");
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (o0.d(b(r100)) == true) goto L12;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L7;
        String r102 = r101.get("o_is_omni_agent");
    L9:
        if (Intrinsics.areEqual(r102, "1") == true) goto L12;
        return false;
    L7:
        r102 = null;
    L12:
        return true;
    }
}
