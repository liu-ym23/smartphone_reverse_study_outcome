package com.bytedance.applog.priority;

import java.util.List;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ JSONObject a;

    public /* synthetic */ p(JSONObject r1) {
        this.a = r1;
    }

    public final Object invoke() {
        JSONObject r0 = this.a;
        List r1 = PriorityWrapper.f;
        return "sart update priority config by default response: " + r0;
    }
}
