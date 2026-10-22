package com.bytedance.applog;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum WhalerGameHelper$Result extends Enum<WhalerGameHelper$Result> {
    public static final WhalerGameHelper$Result FAIL = null;
    public static final WhalerGameHelper$Result SUCCESS = null;
    public static final WhalerGameHelper$Result UNCOMPLETED = null;
    public static final /* synthetic */ WhalerGameHelper$Result[] a = null;
    final String gameResult;

    static {
        WhalerGameHelper$Result r0 = new WhalerGameHelper$Result("UNCOMPLETED", 0, "uncompleted");
        UNCOMPLETED = r0;
        WhalerGameHelper$Result r1 = new WhalerGameHelper$Result("SUCCESS", 1, "success");
        SUCCESS = r1;
        WhalerGameHelper$Result r2 = new WhalerGameHelper$Result("FAIL", 2, "fail");
        FAIL = r2;
        a = new WhalerGameHelper$Result[]{r0, r1, r2};
    }

    public static WhalerGameHelper$Result[] values() {
        return (WhalerGameHelper$Result[]) a.clone();
    }

    public static WhalerGameHelper$Result valueOf(String r1) {
        return (WhalerGameHelper$Result) a.a(WhalerGameHelper$Result.class, r1);
    }

    public WhalerGameHelper$Result(String r1, int r2, String r3) {
        super(r1, r2);
        this.gameResult = r3;
    }
}
