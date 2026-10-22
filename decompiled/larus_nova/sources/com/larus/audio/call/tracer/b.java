package com.larus.audio.call.tracer;

/* JADX INFO: loaded from: classes24.dex */
public abstract class b {
    public b() {
    }

    public abstract void a(String r100, String r101, Integer r102);

    public abstract void c();

    public abstract String d();

    public abstract String e();

    public abstract void f(String r100, String r101);

    public static /* synthetic */ void b(b r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.a(r101, r102, null);
    }
}
