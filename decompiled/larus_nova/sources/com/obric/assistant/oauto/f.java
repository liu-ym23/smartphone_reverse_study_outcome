package com.obric.assistant.oauto;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f390393a = 0;

    static {
    }

    public static boolean a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("o_task_type");
    L7:
        return Intrinsics.areEqual(r102, "complex_task");
    L5:
        r102 = null;
        goto L7
    }

    public static boolean b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.get("o_task_type");
    L7:
        if (Intrinsics.areEqual(r103, "complex_task") == false) goto L14;
        Map<String, String> r104 = r100.getExt();
        if (r104 == null) goto L12;
        r102 = r104.get("o_complex_task_message_type");
    L12:
        if (Intrinsics.areEqual(r102, "clarify") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public static boolean c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.get("o_task_type");
    L7:
        if (Intrinsics.areEqual(r103, "complex_task") == false) goto L14;
        Map<String, String> r104 = r100.getExt();
        if (r104 == null) goto L12;
        r102 = r104.get("o_complex_task_message_type");
    L12:
        if (Intrinsics.areEqual(r102, "summary") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r103 = null;
        goto L7
    }
}
