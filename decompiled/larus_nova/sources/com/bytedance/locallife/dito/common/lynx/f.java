package com.bytedance.locallife.dito.common.lynx;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f257394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f257395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f257396c;

    public static final class a {
    }

    static {
    }

    public final Map<String, Object> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("msg", Integer.valueOf(this.f257394a));
        r100.put("code", this.f257395b);
        r100.put("data", this.f257396c);
        return r100;
    }

    public f(int r100, String r101, Object r102) {
        this.f257394a = r100;
        this.f257395b = r101;
        this.f257396c = r102;
    }
}
