package com.bytedance.lynx.webview.bean;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum LoadType extends Enum<LoadType> {
    public static final LoadType SYSTEMWEBVIEW = null;
    public static final LoadType TTWEBVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadType[] f265074a = null;
    private String mTypeName;

    static {
        LoadType r100 = new LoadType("SYSTEMWEBVIEW", 0, "SystemWebView");
        SYSTEMWEBVIEW = r100;
        LoadType r101 = new LoadType("TTWEBVIEW", 1, "TTWebView");
        TTWEBVIEW = r101;
        f265074a = new LoadType[]{r100, r101};
    }

    public static LoadType[] values() {
        return (LoadType[]) f265074a.clone();
    }

    public String getName() {
        return this.mTypeName;
    }

    public static LoadType getLoadTypeByValue(String r100) {
        if (r100.equals("SystemWebView") == false) goto L7;
        return SYSTEMWEBVIEW;
    L7:
        if (r100.equals("TTWebView") == false) goto L11;
        return TTWEBVIEW;
    L11:
        throw new RuntimeException("Incorrect load type ".concat(r100));
    }

    public static LoadType valueOf(String r100) {
        return (LoadType) a.a(LoadType.class, r100);
    }

    public LoadType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mTypeName = r102;
    }
}
