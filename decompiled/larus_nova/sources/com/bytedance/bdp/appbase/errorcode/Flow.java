package com.bytedance.bdp.appbase.errorcode;

import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public final enum Flow extends Enum<Flow> {
    public static final Flow Download = null;
    public static final Flow JsCore = null;
    public static final Flow Lynx = null;
    public static final Flow Main = null;
    public static final Flow Meta = null;
    public static final Flow WebView = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Flow[] f200796a = null;
    private String code;

    static {
        Flow r100 = new Flow("Meta", 0, "1");
        Meta = r100;
        Flow r101 = new Flow("Download", 1, "2");
        Download = r101;
        Flow r102 = new Flow("Main", 2, "3");
        Main = r102;
        Flow r103 = new Flow("WebView", 3, "4");
        WebView = r103;
        Flow r104 = new Flow("JsCore", 4, "5");
        JsCore = r104;
        Flow r105 = new Flow("Lynx", 5, "6");
        Lynx = r105;
        f200796a = new Flow[]{r100, r101, r102, r103, r104, r105};
    }

    public static Flow[] values() {
        return (Flow[]) f200796a.clone();
    }

    public String getCode() {
        return this.code;
    }

    public static Flow valueOf(String r100) {
        return (Flow) a.a(Flow.class, r100);
    }

    public Flow(String r100, int r101, String r102) {
        super(r100, r101);
        this.code = r102;
    }
}
