package com.bytedance.ee.bear.contract;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnalyticConstant$LinkLocation[] f216892a = null;
    String location;

    static {
        AnalyticConstant$LinkLocation r100 = new AnalyticConstant$LinkLocation("CCM_DOCS", 0, "ccm_docs");
        CCM_DOCS = r100;
        AnalyticConstant$LinkLocation r101 = new AnalyticConstant$LinkLocation("CCM_SHEET", 1, "ccm_sheet");
        CCM_SHEET = r101;
        AnalyticConstant$LinkLocation r102 = new AnalyticConstant$LinkLocation("CCM_SLIDE", 2, "ccm_slide");
        CCM_SLIDE = r102;
        AnalyticConstant$LinkLocation r103 = new AnalyticConstant$LinkLocation("CCM_BITABLE", 3, "ccm_bitable");
        CCM_BITABLE = r103;
        AnalyticConstant$LinkLocation r104 = new AnalyticConstant$LinkLocation("CCM_MINDNOTE", 4, "ccm_mindnote");
        CCM_MINDNOTE = r104;
        AnalyticConstant$LinkLocation r105 = new AnalyticConstant$LinkLocation("CCM_DRIVE", 5, "ccm_drive");
        CCM_DRIVE = r105;
        AnalyticConstant$LinkLocation r110 = new AnalyticConstant$LinkLocation("CCM_WIKI", 6, "ccm_wiki");
        CCM_WIKI = r110;
        AnalyticConstant$LinkLocation r111 = new AnalyticConstant$LinkLocation("DRIVESDK_CREATION", 7, "drivesdk_creation");
        DRIVESDK_CREATION = r111;
        AnalyticConstant$LinkLocation r112 = new AnalyticConstant$LinkLocation("EMAIL_ATTACHMENT_PREVIEW", 8, "email_attachment_preview");
        EMAIL_ATTACHMENT_PREVIEW = r112;
        AnalyticConstant$LinkLocation r113 = new AnalyticConstant$LinkLocation("EVENT_ATTACHMENT_PREVIEW", 9, "event_attachment_preview");
        EVENT_ATTACHMENT_PREVIEW = r113;
        AnalyticConstant$LinkLocation r114 = new AnalyticConstant$LinkLocation("EVENT_DESCRIPTION", 10, "event_description");
        EVENT_DESCRIPTION = r114;
        AnalyticConstant$LinkLocation r106 = new AnalyticConstant$LinkLocation("EMAIL_BODY", 11, "email_body");
        EMAIL_BODY = r106;
        AnalyticConstant$LinkLocation r107 = new AnalyticConstant$LinkLocation("OP_GADGET", 12, "op_gadget");
        OP_GADGET = r107;
        AnalyticConstant$LinkLocation r108 = new AnalyticConstant$LinkLocation("DOCS_SDK_COMMENT", 13, "docs_sdk_comment");
        DOCS_SDK_COMMENT = r108;
        AnalyticConstant$LinkLocation r109 = new AnalyticConstant$LinkLocation("BITABLE_SDK_APPBUILDER", 14, "bitable_sdk_appbuilder");
        BITABLE_SDK_APPBUILDER = r109;
        AnalyticConstant$LinkLocation r115 = new AnalyticConstant$LinkLocation("MESSENGER_GROUP_ANNOUNCEMENT", 15, "messenger_group_announcement");
        MESSENGER_GROUP_ANNOUNCEMENT = r115;
        AnalyticConstant$LinkLocation r116 = new AnalyticConstant$LinkLocation("OPENDOC_CONFERENCE_RECORDS", 16, "opendoc_conference_records");
        OPENDOC_CONFERENCE_RECORDS = r116;
        AnalyticConstant$LinkLocation r117 = new AnalyticConstant$LinkLocation("MESSENGER_LARK_FEED", 17, "messenger_lark_feed");
        MESSENGER_LARK_FEED = r117;
        f216892a = new AnalyticConstant$LinkLocation[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117};
    }

    public static AnalyticConstant$LinkLocation[] values() {
        return (AnalyticConstant$LinkLocation[]) f216892a.clone();
    }

    public String getLocation() {
        return this.location;
    }

    public static AnalyticConstant$LinkLocation valueOf(String r100) {
        return (AnalyticConstant$LinkLocation) r27.a.a(AnalyticConstant$LinkLocation.class, r100);
    }

    public AnalyticConstant$LinkLocation(String r100, int r101, String r102) {
        super(r100, r101);
        this.location = r102;
    }
}
