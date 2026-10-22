package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.u;
import java.util.HashSet;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TraceMachine {
    private static final String TAG = "TraceMachine";
    private static AgentLog log;
    private static HashSet<String> sMethodSet;
    private static ThreadLocal<Stack<Trace>> traceStackThreadLocal;

    public TraceMachine() {
    }

    static {
        traceStackThreadLocal = new ThreadLocal();
        sMethodSet = new HashSet(32);
        log = AgentLogManager.getAgentLog();
    }

    public static void exitMethod() {
        exitMethod("");
    }

    public static void exitMethod(String r3) {
        if (traceStackThreadLocal.get() != null) goto L5;
        return;
    L5:
        Stack<Trace> r0 = traceStackThreadLocal.get();
        if (r0.isEmpty() == true) goto L9;
        Trace r1 = r0.pop();
        r1.setExitTime(System.currentTimeMillis());
        r1.setExtraData(r3);
        handleCost(r1);
        return;
    }

    private static void handleCost(Trace r10) {
        long r1 = r10.entryTime;     // Catch: Exception -> L19
        long r3 = r10.exitTime;     // Catch: Exception -> L19
        long r5 = Long.valueOf(r3 - r1).longValue();     // Catch: Exception -> L19
        if (r5 <= 0) goto L24;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L19
        r7.put("begin_time", r1);     // Catch: Exception -> L19
        r7.put("end_time", r3);     // Catch: Exception -> L19
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L19
        if (UploadTypeInf.PAGE_LOAD.equals(r10.traceType) == false) goto L8;
        r2.put(r10.methodName, r5);     // Catch: Exception -> L19
    L9:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L19
        if (UploadTypeInf.PAGE_LOAD.equals(r10.traceType) == false) goto L16;
        r4.put("scene", r10.scene);     // Catch: Exception -> L19
        if (sMethodSet.contains(r10.className + r10.methodName) == true) goto L14;
        boolean r6 = true;
    L15:
        r4.put("is_first", r6);     // Catch: Exception -> L19
        sMethodSet.add(r10.className + r10.methodName);     // Catch: Exception -> L19
    L17:
        r7.put("extra_data", r10.extraData);     // Catch: Exception -> L19
        return;
    L14:
        r6 = false;
        goto L15
    L16:
        r4.put("is_main", u.a());     // Catch: Exception -> L19
        goto L17
    L8:
        r2.put(r10.className + "#" + r10.methodName, r5);     // Catch: Exception -> L19
        goto L9
    L24:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public static void enterMethod(String r0, String r1, String r2) {
        enterMethod(r0, r0, r1, r2);
    }

    public static void enterMethod(String r8, String r9, String r10, String r11) {
        Trace r7 = new Trace(r8, r9, r10, System.currentTimeMillis(), r11);
        if (traceStackThreadLocal.get() != null) goto L5;
        Stack<Trace> r12 = new Stack();
        r12.push(r7);
        traceStackThreadLocal.set(r12);
        return;
    L5:
        traceStackThreadLocal.get().push(r7);
    }
}
