package com.cmic.sso.sdk.c.d;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f273456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273457b;

    public int a() {
        return this.f273456a;
    }

    public String b() {
        return this.f273457b;
    }

    public static a a(int r100) {
        switch(r100) {
            case 102102: goto L17;
            case 102223: goto L15;
            case 102508: goto L13;
            case 200025: goto L11;
            case 200039: goto L9;
            case 200050: goto L7;
            default: goto L5;
        };
    L5:
        return new a(r100, "网络异常");
    L7:
        return new a(200050, "EOF异常");
    L9:
        return new a(200039, "电信取号接口失败");
    L11:
        return new a(200025, "登录超时");
    L13:
        return new a(102508, "数据网络切换失败");
    L15:
        return new a(102223, "数据解析异常");
    L17:
        return new a(102102, "网络异常");
    }

    private a(int r100, String r101) {
        this.f273456a = r100;
        this.f273457b = r101;
    }
}
