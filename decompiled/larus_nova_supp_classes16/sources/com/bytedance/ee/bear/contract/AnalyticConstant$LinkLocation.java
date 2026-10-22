package com.bytedance.ee.bear.contract;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum AnalyticConstant$LinkLocation extends Enum<AnalyticConstant$LinkLocation> {
    public static final AnalyticConstant$LinkLocation BITABLE_SDK_APPBUILDER = null;
    public static final AnalyticConstant$LinkLocation CCM_BITABLE = null;
    public static final AnalyticConstant$LinkLocation CCM_DOCS = null;
    public static final AnalyticConstant$LinkLocation CCM_DRIVE = null;
    public static final AnalyticConstant$LinkLocation CCM_MINDNOTE = null;
    public static final AnalyticConstant$LinkLocation CCM_SHEET = null;
    public static final AnalyticConstant$LinkLocation CCM_SLIDE = null;
    public static final AnalyticConstant$LinkLocation CCM_WIKI = null;
    public static final AnalyticConstant$LinkLocation DOCS_SDK_COMMENT = null;
    public static final AnalyticConstant$LinkLocation DRIVESDK_CREATION = null;
    public static final AnalyticConstant$LinkLocation EMAIL_ATTACHMENT_PREVIEW = null;
    public static final AnalyticConstant$LinkLocation EMAIL_BODY = null;
    public static final AnalyticConstant$LinkLocation EVENT_ATTACHMENT_PREVIEW = null;
    public static final AnalyticConstant$LinkLocation EVENT_DESCRIPTION = null;
    public static final AnalyticConstant$LinkLocation MESSENGER_GROUP_ANNOUNCEMENT = null;
    public static final AnalyticConstant$LinkLocation MESSENGER_LARK_FEED = null;
    public static final AnalyticConstant$LinkLocation OPENDOC_CONFERENCE_RECORDS = null;
    public static final AnalyticConstant$LinkLocation OP_GADGET = null;
    public static final /* synthetic */ AnalyticConstant$LinkLocation[] a = null;
    String location;

    static {
        AnalyticConstant$LinkLocation r0 = new AnalyticConstant$LinkLocation("CCM_DOCS", 0, "ccm_docs");
        CCM_DOCS = r0;
        AnalyticConstant$LinkLocation r1 = new AnalyticConstant$LinkLocation("CCM_SHEET", 1, "ccm_sheet");
        CCM_SHEET = r1;
        AnalyticConstant$LinkLocation r2 = new AnalyticConstant$LinkLocation("CCM_SLIDE", 2, "ccm_slide");
        CCM_SLIDE = r2;
        AnalyticConstant$LinkLocation r4 = new AnalyticConstant$LinkLocation("CCM_BITABLE", 3, "ccm_bitable");
        CCM_BITABLE = r4;
        AnalyticConstant$LinkLocation r6 = new AnalyticConstant$LinkLocation("CCM_MINDNOTE", 4, "ccm_mindnote");
        CCM_MINDNOTE = r6;
        AnalyticConstant$LinkLocation r8 = new AnalyticConstant$LinkLocation("CCM_DRIVE", 5, "ccm_drive");
        CCM_DRIVE = r8;
        AnalyticConstant$LinkLocation r10 = new AnalyticConstant$LinkLocation("CCM_WIKI", 6, "ccm_wiki");
        CCM_WIKI = r10;
        AnalyticConstant$LinkLocation r12 = new AnalyticConstant$LinkLocation("DRIVESDK_CREATION", 7, "drivesdk_creation");
        DRIVESDK_CREATION = r12;
        AnalyticConstant$LinkLocation r14 = new AnalyticConstant$LinkLocation("EMAIL_ATTACHMENT_PREVIEW", 8, "email_attachment_preview");
        EMAIL_ATTACHMENT_PREVIEW = r14;
        AnalyticConstant$LinkLocation r13 = new AnalyticConstant$LinkLocation("EVENT_ATTACHMENT_PREVIEW", 9, "event_attachment_preview");
        EVENT_ATTACHMENT_PREVIEW = r13;
        AnalyticConstant$LinkLocation r11 = new AnalyticConstant$LinkLocation("EVENT_DESCRIPTION", 10, "event_description");
        EVENT_DESCRIPTION = r11;
        AnalyticConstant$LinkLocation r9 = new AnalyticConstant$LinkLocation("EMAIL_BODY", 11, "email_body");
        EMAIL_BODY = r9;
        AnalyticConstant$LinkLocation r7 = new AnalyticConstant$LinkLocation("OP_GADGET", 12, "op_gadget");
        OP_GADGET = r7;
        AnalyticConstant$LinkLocation r5 = new AnalyticConstant$LinkLocation("DOCS_SDK_COMMENT", 13, "docs_sdk_comment");
        DOCS_SDK_COMMENT = r5;
        AnalyticConstant$LinkLocation r3 = new AnalyticConstant$LinkLocation("BITABLE_SDK_APPBUILDER", 14, "bitable_sdk_appbuilder");
        BITABLE_SDK_APPBUILDER = r3;
        AnalyticConstant$LinkLocation r16 = new AnalyticConstant$LinkLocation("MESSENGER_GROUP_ANNOUNCEMENT", 15, "messenger_group_announcement");
        MESSENGER_GROUP_ANNOUNCEMENT = r16;
        AnalyticConstant$LinkLocation r17 = new AnalyticConstant$LinkLocation("OPENDOC_CONFERENCE_RECORDS", 16, "opendoc_conference_records");
        OPENDOC_CONFERENCE_RECORDS = r17;
        AnalyticConstant$LinkLocation r18 = new AnalyticConstant$LinkLocation("MESSENGER_LARK_FEED", 17, "messenger_lark_feed");
        MESSENGER_LARK_FEED = r18;
        a = new AnalyticConstant$LinkLocation[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r16, r17, r18};
    }

    public static AnalyticConstant$LinkLocation[] values() {
        return (AnalyticConstant$LinkLocation[]) a.clone();
    }

    public String getLocation() {
        return this.location;
    }

    public static AnalyticConstant$LinkLocation valueOf(String r1) {
        return (AnalyticConstant$LinkLocation) r27.a.a(AnalyticConstant$LinkLocation.class, r1);
    }

    public AnalyticConstant$LinkLocation(String r1, int r2, String r3) {
        super(r1, r2);
        this.location = r3;
    }
}
