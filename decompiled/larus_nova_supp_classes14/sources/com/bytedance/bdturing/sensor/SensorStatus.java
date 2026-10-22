package com.bytedance.bdturing.sensor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SensorStatus {
    boolean a;
    List<Long> b;
    List<Long> c;
    boolean cb;
    boolean ef;
    boolean ka;
    boolean ve;

    public JSONObject toJsonObj() {
        JSONObject r0 = new JSONObject();
        r0.put("ka", this.ka);     // Catch: Exception -> L13
        r0.put("cb", this.cb);     // Catch: Exception -> L13
        r0.put("ef", this.ef);     // Catch: Exception -> L13
        r0.put("ve", this.ve);     // Catch: Exception -> L13
        r0.put("a", this.a);     // Catch: Exception -> L13
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L13
        Iterator<Long> r2 = this.b.iterator();     // Catch: Exception -> L13
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.put(r2.next());     // Catch: Exception -> L13
        goto L5
    L7:
        r0.put("b", r1);     // Catch: Exception -> L13
        JSONArray r3 = new JSONArray();     // Catch: Exception -> L13
        Iterator<Long> r4 = this.c.iterator();     // Catch: Exception -> L13
    L9:
        if (r4.hasNext() == false) goto L11;
        r3.put(r4.next());     // Catch: Exception -> L13
        goto L9
    L11:
        r0.put("c", r3);     // Catch: Exception -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public SensorStatus() {
        this.b = new ArrayList();
        this.c = new ArrayList();
    }
}
