package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public g a;
    public final w b;
    public final String c;
    public final String d;
    public final com.bytedance.ee.bear.drive.report.c e;
    public int f;
    public long g;
    public long h;
    public long i;

    public static int a(int r3) {
        switch(r3) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return -1;
    L6:
        return 1;
    L7:
        return 3;
    L8:
        return 2;
    L9:
        return 4;
    L11:
        return 1;
    L12:
        return 3;
    L13:
        return 2;
    }

    public h(w r3, String r4, String r5, com.bytedance.ee.bear.drive.report.c r6) {
        this.f = 1500;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
