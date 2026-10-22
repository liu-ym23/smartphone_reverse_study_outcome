package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.tracing.TraceMachine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class JSONObjectInstrumentation {
    private static final String TAG = "JSONInstrumentation";

    public JSONObjectInstrumentation() {
    }

    public static JSONObject init(String r3) throws Exception {
        TraceMachine.enterMethod("JSONObject", "init", "json_trace");
        JSONObject r0 = new JSONObject(r3);
        TraceMachine.exitMethod();
        return r0;
    }
}
