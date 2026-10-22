package com.xiaomi.push;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f463227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f463228c;

    public ca() {
        this(0, 0, 0, null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m8885a() {
        JSONObject r100 = new JSONObject();
        r100.put(ChameleonOpenTracker.ParamKey.COST, this.f299a);
        r100.put("size", this.f463228c);
        r100.put("ts", this.f463227b);
        r100.put("wt", this.f463226a);
        r100.put("expt", this.f300a);
        return r100;
    }

    public int a() {
        return this.f463226a;
    }

    public ca a(JSONObject r100) {
        this.f299a = JSONObjectProtectorUtils.getLong(r100, ChameleonOpenTracker.ParamKey.COST);
        this.f463228c = JSONObjectProtectorUtils.getLong(r100, "size");
        this.f463227b = JSONObjectProtectorUtils.getLong(r100, "ts");
        this.f463226a = JSONObjectProtectorUtils.getInt(r100, "wt");
        this.f300a = r100.optString("expt");
        return this;
    }

    public ca(int r100, long r101, long r102, Exception r103) {
        this.f463226a = r100;
        this.f299a = r101;
        this.f463228c = r102;
        this.f463227b = System.currentTimeMillis();
        if (r103 == null) goto L6;
        this.f300a = r103.getClass().getSimpleName();
        return;
    }
}
