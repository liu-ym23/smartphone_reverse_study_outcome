package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes23.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f277364e;

    public i1(String r100, String r101, String r102, String r103, long r104) {
        this.f277360a = r100;
        this.f277361b = r101;
        this.f277362c = r102;
        this.f277363d = r103;
        this.f277364e = r104;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 r100 = new b1();
        r100.b(this.f277362c);
        r100.d(this.f277361b);
        r100.a(this.f277363d);
        r100.c(String.valueOf(this.f277364e));
        if ("oper".equals(this.f277361b) == true) goto L5;
    L7:
        String r101 = UUID.randomUUID().toString().replace("-", "");
        ArrayList r102 = new ArrayList();
        r102.add(r100);
        new l0(this.f277360a, this.f277361b, q0.g(), r102, r101).a();
        return;
    L5:
        if (z.i(this.f277360a, "oper") == false) goto L7;
        p0 r103 = y.a().a(this.f277360a, this.f277364e);
        String r104 = r103.a();
        Boolean r105 = Boolean.valueOf(r103.b());
        r100.f(r104);
        r100.e(String.valueOf(r105));
        goto L7
    }
}
