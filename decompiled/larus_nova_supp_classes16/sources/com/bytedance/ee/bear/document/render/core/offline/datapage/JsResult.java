package com.bytedance.ee.bear.document.render.core.offline.datapage;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum JsResult extends Enum<JsResult> {
    public static final JsResult FAIL = null;
    public static final JsResult FAILED_HAS_NEW_DATA = null;
    public static final JsResult SUCCESS = null;
    public static final /* synthetic */ JsResult[] a = null;
    private int code;
    private String message;

    static {
        JsResult r0 = new JsResult("FAILED_HAS_NEW_DATA", 0, 100, "drop because has new data");
        FAILED_HAS_NEW_DATA = r0;
        JsResult r1 = new JsResult("FAIL", 1, 1, "");
        FAIL = r1;
        JsResult r2 = new JsResult("SUCCESS", 2, 0, "");
        SUCCESS = r2;
        a = new JsResult[]{r0, r1, r2};
    }

    public static JsResult[] values() {
        return (JsResult[]) a.clone();
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static JsResult valueOf(String r1) {
        return (JsResult) a.a(JsResult.class, r1);
    }

    public JsResult(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.message = r4;
    }
}
