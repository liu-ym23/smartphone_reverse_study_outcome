package com.unicom.online.account.kernel;

import com.ss.android.dypay.api.DyPayConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f462049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f462050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f462051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f462052d;

    public g() {
    }

    public final HashMap<String, Object> a() {
        HashMap<String, Object> r100 = new HashMap();
        r100.put("url", this.f462049a);
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f462050b);
        r100.put(DyPayConstant.KEY_START_TIME, r101.toString());
        StringBuilder r102 = new StringBuilder();
        r102.append(this.f462051c);
        r100.put("endTime", r102.toString());
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f462052d);
        r100.put("forcedTime", r103.toString());
        return r100;
    }

    public final void b() {
        this.f462049a = "";
        this.f462050b = 0;
        this.f462051c = 0;
        this.f462052d = 0;
    }

    public final String toString() {
        return "{url':" + this.f462049a + "', startTime:" + this.f462050b + ", endTime:" + this.f462051c + '}';
    }
}
