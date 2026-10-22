package com.bytedance.apm.doctor;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import f27.g;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DoctorManager$b implements g {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public final void run() {
        JSONObject r0 = JSONObjectProtectorUtils.getJSONObject(this.a, "DATA_DOCTOR");     // Catch: Exception -> L8
        r0.put(this.b, System.currentTimeMillis());     // Catch: Exception -> L8
        int r1 = r0.optInt("DATA_ID");     // Catch: Exception -> L8
        Iterator r2 = this.c.iterator();     // Catch: Exception -> L8
    L4:
        if (r2.hasNext() == false) goto L13;
        ((DoctorManager.ApmListener) r2.next()).onDataEvent(r1, this.b, this.a);     // Catch: Exception -> L8
    L13:
        return;
    }

    public final AsyncTaskType getTaskType() {
        return AsyncTaskType.LIGHT_WEIGHT;
    }

    public DoctorManager$b(JSONObject r1, String r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
