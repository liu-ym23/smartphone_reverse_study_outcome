package com.obric.assistant.special_input.util;

import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.voice.ContentScene;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j {
    public static final boolean a(StateInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != null) goto L5;
        boolean r101 = false;
    L6:
        if (r101 == false) goto L15;
        Map<String, String> r102 = r100.getExt();
        if (r102 == null) goto L10;
        String r103 = r102.get("o_complex_call_for_me_directly");
    L12:
        if (Intrinsics.areEqual(r103, "1") == false) goto L16;
        return true;
    L16:
        return false;
    L10:
        r103 = null;
        goto L12
    L15:
        return false;
    L5:
        r101 = Intrinsics.areEqual(r100.getTaskType(), "complex_task");
        goto L6
    }

    public static final StateInfo b(int r100, boolean r101, Map<String, String> r102, String r103, DMTaskState r110) {
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("mockComplexTaskStateInfo: requestType = ");
        r105.append(r100);
        r105.append(", taskState = ");
        String r106 = null;
        if (r110 == null) goto L5;
        String r107 = com.obric.assistant.utils.l.g(r110);
    L6:
        r105.append(r107);
        r104.i("SpecialInputMsgEx", r105.toString());
        if (r102 == null) goto L10;
        Map r108 = MapsKt.toMutableMap(r102);
        if (r108 == null) goto L10;
    L11:
        if (r110 == null) goto L15;
        DMTaskInfo r109 = r110.getTaskInfo();
        if (r109 == null) goto L15;
        IMMessage r111 = r109.getMessage();
    L16:
        if (r111 == null) goto L23;
        Map<String, String> r112 = r111.getExt();
        if (r112 == null) goto L20;
        String r113 = r112.get("inner_log_id");
    L21:
        if (r113 == null) goto L23;
        r108.put("log_id", r113);
        goto L23
    L20:
        r113 = null;
    L23:
        if (r111 == null) goto L30;
        Map<String, String> r114 = r111.getExt();
        if (r114 == null) goto L27;
        String r115 = r114.get("o_omni_instruction_type");
    L28:
        if (r115 == null) goto L30;
        r108.put("instruction_type", r115);
        goto L30
    L27:
        r115 = null;
    L30:
        if (r111 == null) goto L37;
        Map<String, String> r116 = r111.getExt();
        if (r116 == null) goto L34;
        String r117 = r116.get("o_task_type");
    L35:
        if (r117 == null) goto L37;
        r108.put(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r117);
        goto L37
    L34:
        r117 = null;
    L37:
        boolean r118 = true;
        if (r103 != null) goto L40;
    L43:
        boolean r119 = true;
    L44:
        if (r119 == false) goto L53;
        if (r110 == null) goto L51;
        DMTaskInfo r120 = r110.getTaskInfo();
        if (r120 == null) goto L51;
        IMMessage r121 = r120.getMessage();
        if (r121 == null) goto L51;
        r103 = r121.getMessageId();
    L51:
        r103 = null;
    L53:
        if (r100 != ObricComplexTaskPanelType.CLARIFYING.getValue()) goto L68;
        Set<String> r122 = com.obric.assistant.utils.l.f393882a;
        if (r110 == null) goto L59;
        Map<String, String> r123 = r110.getExtra();
        if (r123 == null) goto L59;
        r106 = r123.get("clarify_message_content");
    L59:
        if (r106 != null) goto L62;
        r106 = "";
    L62:
        if (r106.length() == 0) goto L65;
        r118 = false;
    L65:
        if (r118 == false) goto L68;
        r104.w("SpecialInputMsgEx", "mockComplexTaskStateInfo: clarify is empty");
    L68:
        return e(r100, r106, r103, r101, r108);
    L40:
        if (r103.length() == 0) goto L43;
        r119 = false;
    L15:
        r111 = null;
    L10:
        r108 = new LinkedHashMap();
        goto L11
    L5:
        r107 = null;
        goto L6
    }

    public static StateInfo e(int r110, String r111, String r112, boolean r113, Map r114) {
        return new StateInfo(r110, r111, r112, "complex_task", 0, false, r113, r114);
    }

    public static StateInfo c(int r100, boolean r101, String r102, String r103, Map r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = true;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        ContentScene r106 = ContentScene.UNKNOWN;
    L16:
        if ((r105 & 32) == 0) goto L18;
        r104 = null;
    L18:
        Intrinsics.checkNotNullParameter(r106, "contentScene");
        return e(r100, r102, r103, r101, r104);
    L14:
        r106 = null;
        goto L16
    }

    public static StateInfo d(int r100, boolean r101, Map r102, String r103, DMTaskState r104, int r105) {
        boolean r106 = true;
        if ((r105 & 2) == 0) goto L6;
        r101 = true;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L27;
        if (r100 != 1) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
    L25:
        ObricTaskStatusManager.f393357a.getClass();
        r104 = ObricTaskStatusManager.c();
        goto L27
    L19:
        if (r100 == 2) goto L22;
        r106 = false;
    L22:
        if (r106 == true) goto L25;
        r104 = null;
        goto L27
    L16:
        r107 = false;
    L27:
        return b(r100, r101, r102, r103, r104);
    }
}
