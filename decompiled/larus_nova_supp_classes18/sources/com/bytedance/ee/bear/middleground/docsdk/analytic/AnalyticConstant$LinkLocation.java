package com.bytedance.ee.bear.middleground.docsdk.analytic;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum AnalyticConstant$LinkLocation extends Enum<AnalyticConstant$LinkLocation> {
    public static final AnalyticConstant$LinkLocation EMAIL_BODY = null;
    public static final AnalyticConstant$LinkLocation EVENT_DESCRIPTION = null;
    public static final AnalyticConstant$LinkLocation OP_GADGET = null;
    public static final /* synthetic */ AnalyticConstant$LinkLocation[] a = null;
    String location;

    static {
        AnalyticConstant$LinkLocation r0 = new AnalyticConstant$LinkLocation("EVENT_DESCRIPTION", 0, "event_description");
        EVENT_DESCRIPTION = r0;
        AnalyticConstant$LinkLocation r1 = new AnalyticConstant$LinkLocation("EMAIL_BODY", 1, "email_body");
        EMAIL_BODY = r1;
        AnalyticConstant$LinkLocation r2 = new AnalyticConstant$LinkLocation("OP_GADGET", 2, "op_gadget");
        OP_GADGET = r2;
        a = new AnalyticConstant$LinkLocation[]{r0, r1, r2};
    }

    public static AnalyticConstant$LinkLocation[] values() {
        return (AnalyticConstant$LinkLocation[]) a.clone();
    }

    public String getLocation() {
        return this.location;
    }

    public static AnalyticConstant$LinkLocation valueOf(String r1) {
        return (AnalyticConstant$LinkLocation) a.a(AnalyticConstant$LinkLocation.class, r1);
    }

    public AnalyticConstant$LinkLocation(String r1, int r2, String r3) {
        super(r1, r2);
        this.location = r3;
    }
}
