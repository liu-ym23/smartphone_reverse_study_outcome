package com.bytedance.ee.bear.document.render.core.offline.datapage;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum JsResult extends Enum<JsResult> {
    public static final JsResult FAIL = null;
    public static final JsResult FAILED_HAS_NEW_DATA = null;
    public static final JsResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsResult[] f221278a = null;
    private int code;
    private String message;

    static {
        JsResult r100 = new JsResult("FAILED_HAS_NEW_DATA", 0, 100, "drop because has new data");
        FAILED_HAS_NEW_DATA = r100;
        JsResult r101 = new JsResult("FAIL", 1, 1, "");
        FAIL = r101;
        JsResult r102 = new JsResult("SUCCESS", 2, 0, "");
        SUCCESS = r102;
        f221278a = new JsResult[]{r100, r101, r102};
    }

    public static JsResult[] values() {
        return (JsResult[]) f221278a.clone();
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static JsResult valueOf(String r100) {
        return (JsResult) a.a(JsResult.class, r100);
    }

    public JsResult(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.message = r103;
    }
}
