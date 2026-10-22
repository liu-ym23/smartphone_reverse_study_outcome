package com.cmic.ida.sdk;

/* JADX INFO: loaded from: classes22.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f273147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273148b;

    public int a() {
        return this.f273147a;
    }

    public String b() {
        return this.f273148b;
    }

    public static l a(int r100) {
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
        return new l(r100, "网络异常");
    L7:
        return new l(200050, "EOF异常");
    L9:
        return new l(200039, "电信取号接口失败");
    L11:
        return new l(200025, "登录超时");
    L13:
        return new l(102508, "数据网络切换失败");
    L15:
        return new l(102223, "数据解析异常");
    L17:
        return new l(102102, "网络异常");
    }

    private l(int r100, String r101) {
        this.f273147a = r100;
        this.f273148b = r101;
    }
}
