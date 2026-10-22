package com.obric.assistant.utils;

import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f393882a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393883a = null;

        static {
            int[] r100 = new int[DMConstData.DMComplexTaskState.values().length];
            r100[DMConstData.DMComplexTaskState.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DMConstData.DMComplexTaskState.Queueing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DMConstData.DMComplexTaskState.Terminated.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f393883a = r100;
        }
    }

    static {
        f393882a = SetsKt.setOf(new String[]{"o_omni_task_id", "o_complex_source_type", "clarify_message_content", "message_id_for_clarify"});
    }

    public static final String a(DMTaskState r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.getExtra();
        if (r101 == null) goto L6;
        String r102 = r101.get("message_id_for_clarify");
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public static final String b(DMTaskState r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.getExtra();
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

    public static final String c(DMTaskInfo r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L6;
        String r102 = r101.get("o_omni_task_id");
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public static final String d(DMTaskState r100) {
        if (r100 == null) goto L6;
        DMTaskInfo r101 = r100.getTaskInfo();
        if (r101 == null) goto L6;
        String r102 = c(r101);
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public static final boolean e(DMTaskState r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (h(r100.getState()) != DMConstData.DMComplexTaskState.Clarify) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean f(DMTaskState r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        DMConstData.DMComplexTaskState r101 = h(r100.getState());
        int r102 = a.f393883a[r101.ordinal()];
        if (r102 != 1) goto L8;
        return false;
    L8:
        if (r102 != 2) goto L10;
        return false;
    L10:
        if (r102 == 3) goto L15;
        return true;
    L15:
        return false;
    }

    public static final String g(DMTaskState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder("DMTaskState(taskId: ");
        r101.append(r100.getTaskId());
        r101.append(", omniTaskId: ");
        r101.append(d(r100));
        r101.append(", state: ");
        r101.append(h(r100.getState()));
        r101.append(", ");
        r101.append(r100.getState());
        r101.append(", keyExtra: ");
        Map<String, String> r102 = r100.getExtra();
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, String> r105 = r104.next();
        if (f393882a.contains(r105.getKey()) == false) goto L4;
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L8:
        r101.append(r103);
        r101.append(')');
        return r101.toString();
    }

    public static final DMConstData.DMComplexTaskState h(int r100) {
        Iterator<DMConstData.DMComplexTaskState> r101 = DMConstData.DMComplexTaskState.getEntries().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        DMConstData.DMComplexTaskState r102 = r101.next();
        if (r102.ordinal() != r100) goto L4;
        return r102;
    L9:
        return DMConstData.DMComplexTaskState.Idle;
    }
}
