package com.bytedance.ee.bear.middleground.docsdk.analytic;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum AnalyticConstant$LinkLocation extends Enum<AnalyticConstant$LinkLocation> {
    public static final AnalyticConstant$LinkLocation EMAIL_BODY = null;
    public static final AnalyticConstant$LinkLocation EVENT_DESCRIPTION = null;
    public static final AnalyticConstant$LinkLocation OP_GADGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnalyticConstant$LinkLocation[] f232374a = null;
    String location;

    static {
        AnalyticConstant$LinkLocation r100 = new AnalyticConstant$LinkLocation("EVENT_DESCRIPTION", 0, "event_description");
        EVENT_DESCRIPTION = r100;
        AnalyticConstant$LinkLocation r101 = new AnalyticConstant$LinkLocation("EMAIL_BODY", 1, "email_body");
        EMAIL_BODY = r101;
        AnalyticConstant$LinkLocation r102 = new AnalyticConstant$LinkLocation("OP_GADGET", 2, "op_gadget");
        OP_GADGET = r102;
        f232374a = new AnalyticConstant$LinkLocation[]{r100, r101, r102};
    }

    public static AnalyticConstant$LinkLocation[] values() {
        return (AnalyticConstant$LinkLocation[]) f232374a.clone();
    }

    public String getLocation() {
        return this.location;
    }

    public static AnalyticConstant$LinkLocation valueOf(String r100) {
        return (AnalyticConstant$LinkLocation) a.a(AnalyticConstant$LinkLocation.class, r100);
    }

    public AnalyticConstant$LinkLocation(String r100, int r101, String r102) {
        super(r100, r101);
        this.location = r102;
    }
}
