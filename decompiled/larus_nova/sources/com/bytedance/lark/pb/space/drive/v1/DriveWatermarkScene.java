package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DriveWatermarkScene extends Enum<DriveWatermarkScene> implements WireEnum {
    private static final /* synthetic */ DriveWatermarkScene[] $VALUES = null;
    public static final ProtoAdapter<DriveWatermarkScene> ADAPTER = null;
    public static final DriveWatermarkScene DriveWatermarkScene_BASE_ATTACHMENT_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_BASE_DASHBOARD_IMAGE_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_BASE_EXCEL_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_BOARD_IMAGE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CALENDAR_ATTACHMENT_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CALENDAR_IMAGE_COPY = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CALENDAR_IMAGE_VIEWER_COPY = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CALENDAR_QR_SHARE_IMAGE_COPY = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CCM_ATTACHMENT_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CCM_MINDNOTE_IMAGE_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CCM_SHEET_IMAGE_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_IM_COMPANY_MOMENTS_IMAGE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_IM_EMOJI_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_IM_MSG_FILE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_IM_SUBSCRIPTION_IMAGE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_MAIL_ATTACHMENT_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_MAIL_IMAGE_VIEWER_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_MAIL_PDF_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_NONE = null;
    public static final DriveWatermarkScene DriveWatermarkScene_OKR_EXCEL_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_OKR_PROGRESS_IMAGE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_REPORT_FILE_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_REPORT_FILE_EXPORT = null;
    public static final DriveWatermarkScene DriveWatermarkScene_TASK_ATTACHMENT_DOWNLOAD = null;
    public static final DriveWatermarkScene DriveWatermarkScene_TASK_IMAGE_VIEWER_COPY = null;
    public static final DriveWatermarkScene DriveWatermarkScene_UNKNOWN = null;
    public static final DriveWatermarkScene DriveWatermarkScene_WORKFLOW_RECIPES_IMAGE_DOWNLOAD = null;
    private final int value;

    static {
        DriveWatermarkScene r100 = new DriveWatermarkScene("DriveWatermarkScene_NONE", 0, 0);
        DriveWatermarkScene_NONE = r100;
        DriveWatermarkScene r101 = new DriveWatermarkScene("DriveWatermarkScene_UNKNOWN", 1, 1);
        DriveWatermarkScene_UNKNOWN = r101;
        DriveWatermarkScene r102 = new DriveWatermarkScene("DriveWatermarkScene_IM_MSG_FILE_DOWNLOAD", 2, 11);
        DriveWatermarkScene_IM_MSG_FILE_DOWNLOAD = r102;
        DriveWatermarkScene r103 = new DriveWatermarkScene("DriveWatermarkScene_IM_EMOJI_DOWNLOAD", 3, 12);
        DriveWatermarkScene_IM_EMOJI_DOWNLOAD = r103;
        DriveWatermarkScene r104 = new DriveWatermarkScene("DriveWatermarkScene_IM_COMPANY_MOMENTS_IMAGE_DOWNLOAD", 4, 13);
        DriveWatermarkScene_IM_COMPANY_MOMENTS_IMAGE_DOWNLOAD = r104;
        DriveWatermarkScene r110 = new DriveWatermarkScene("DriveWatermarkScene_IM_SUBSCRIPTION_IMAGE_DOWNLOAD", 5, 14);
        DriveWatermarkScene_IM_SUBSCRIPTION_IMAGE_DOWNLOAD = r110;
        DriveWatermarkScene r111 = new DriveWatermarkScene("DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD", 6, 21);
        DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD = r111;
        DriveWatermarkScene r112 = new DriveWatermarkScene("DriveWatermarkScene_CCM_ATTACHMENT_DOWNLOAD", 7, 22);
        DriveWatermarkScene_CCM_ATTACHMENT_DOWNLOAD = r112;
        DriveWatermarkScene r105 = new DriveWatermarkScene("DriveWatermarkScene_CCM_SHEET_IMAGE_EXPORT", 8, 23);
        DriveWatermarkScene_CCM_SHEET_IMAGE_EXPORT = r105;
        DriveWatermarkScene r106 = new DriveWatermarkScene("DriveWatermarkScene_CCM_MINDNOTE_IMAGE_EXPORT", 9, 24);
        DriveWatermarkScene_CCM_MINDNOTE_IMAGE_EXPORT = r106;
        DriveWatermarkScene r107 = new DriveWatermarkScene("DriveWatermarkScene_BASE_ATTACHMENT_DOWNLOAD", 10, 31);
        DriveWatermarkScene_BASE_ATTACHMENT_DOWNLOAD = r107;
        DriveWatermarkScene r108 = new DriveWatermarkScene("DriveWatermarkScene_BASE_EXCEL_EXPORT", 11, 32);
        DriveWatermarkScene_BASE_EXCEL_EXPORT = r108;
        DriveWatermarkScene r113 = new DriveWatermarkScene("DriveWatermarkScene_BASE_DASHBOARD_IMAGE_EXPORT", 12, 33);
        DriveWatermarkScene_BASE_DASHBOARD_IMAGE_EXPORT = r113;
        DriveWatermarkScene r109 = new DriveWatermarkScene("DriveWatermarkScene_CALENDAR_ATTACHMENT_DOWNLOAD", 13, 41);
        DriveWatermarkScene_CALENDAR_ATTACHMENT_DOWNLOAD = r109;
        DriveWatermarkScene r114 = new DriveWatermarkScene("DriveWatermarkScene_CALENDAR_IMAGE_COPY", 14, 42);
        DriveWatermarkScene_CALENDAR_IMAGE_COPY = r114;
        DriveWatermarkScene r115 = new DriveWatermarkScene("DriveWatermarkScene_CALENDAR_IMAGE_VIEWER_COPY", 15, 43);
        DriveWatermarkScene_CALENDAR_IMAGE_VIEWER_COPY = r115;
        DriveWatermarkScene r116 = new DriveWatermarkScene("DriveWatermarkScene_CALENDAR_QR_SHARE_IMAGE_COPY", 16, 44);
        DriveWatermarkScene_CALENDAR_QR_SHARE_IMAGE_COPY = r116;
        DriveWatermarkScene r117 = new DriveWatermarkScene("DriveWatermarkScene_MAIL_ATTACHMENT_DOWNLOAD", 17, 51);
        DriveWatermarkScene_MAIL_ATTACHMENT_DOWNLOAD = r117;
        DriveWatermarkScene r118 = new DriveWatermarkScene("DriveWatermarkScene_MAIL_IMAGE_VIEWER_DOWNLOAD", 18, 52);
        DriveWatermarkScene_MAIL_IMAGE_VIEWER_DOWNLOAD = r118;
        DriveWatermarkScene r119 = new DriveWatermarkScene("DriveWatermarkScene_MAIL_PDF_EXPORT", 19, 53);
        DriveWatermarkScene_MAIL_PDF_EXPORT = r119;
        DriveWatermarkScene r120 = new DriveWatermarkScene("DriveWatermarkScene_TASK_ATTACHMENT_DOWNLOAD", 20, 61);
        DriveWatermarkScene_TASK_ATTACHMENT_DOWNLOAD = r120;
        DriveWatermarkScene r121 = new DriveWatermarkScene("DriveWatermarkScene_TASK_IMAGE_VIEWER_COPY", 21, 62);
        DriveWatermarkScene_TASK_IMAGE_VIEWER_COPY = r121;
        DriveWatermarkScene r122 = new DriveWatermarkScene("DriveWatermarkScene_REPORT_FILE_EXPORT", 22, 71);
        DriveWatermarkScene_REPORT_FILE_EXPORT = r122;
        DriveWatermarkScene r123 = new DriveWatermarkScene("DriveWatermarkScene_REPORT_FILE_DOWNLOAD", 23, 72);
        DriveWatermarkScene_REPORT_FILE_DOWNLOAD = r123;
        DriveWatermarkScene r124 = new DriveWatermarkScene("DriveWatermarkScene_OKR_EXCEL_EXPORT", 24, 81);
        DriveWatermarkScene_OKR_EXCEL_EXPORT = r124;
        DriveWatermarkScene r125 = new DriveWatermarkScene("DriveWatermarkScene_OKR_PROGRESS_IMAGE_DOWNLOAD", 25, 82);
        DriveWatermarkScene_OKR_PROGRESS_IMAGE_DOWNLOAD = r125;
        DriveWatermarkScene r126 = new DriveWatermarkScene("DriveWatermarkScene_BOARD_IMAGE_DOWNLOAD", 26, 91);
        DriveWatermarkScene_BOARD_IMAGE_DOWNLOAD = r126;
        DriveWatermarkScene r127 = new DriveWatermarkScene("DriveWatermarkScene_WORKFLOW_RECIPES_IMAGE_DOWNLOAD", 27, 101);
        DriveWatermarkScene_WORKFLOW_RECIPES_IMAGE_DOWNLOAD = r127;
        $VALUES = new DriveWatermarkScene[]{r100, r101, r102, r103, r104, r110, r111, r112, r105, r106, r107, r108, r113, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        ADAPTER = ProtoAdapter.newEnumAdapter(DriveWatermarkScene.class);
    }

    public static DriveWatermarkScene[] values() {
        return (DriveWatermarkScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DriveWatermarkScene fromValue(int r100) {
        if (r100 == 0) goto L83;
        if (r100 == 1) goto L81;
        if (r100 == 61) goto L79;
        if (r100 == 62) goto L77;
        if (r100 == 71) goto L75;
        if (r100 == 72) goto L73;
        if (r100 == 81) goto L71;
        if (r100 == 82) goto L69;
        if (r100 == 91) goto L67;
        if (r100 == 101) goto L65;
        switch(r100) {
            case 11: goto L63;
            case 12: goto L61;
            case 13: goto L59;
            case 14: goto L57;
            default: goto L22;
        };
    L22:
        switch(r100) {
            case 21: goto L55;
            case 22: goto L53;
            case 23: goto L51;
            case 24: goto L49;
            default: goto L23;
        };
    L23:
        switch(r100) {
            case 31: goto L47;
            case 32: goto L45;
            case 33: goto L43;
            default: goto L24;
        };
    L24:
        switch(r100) {
            case 41: goto L41;
            case 42: goto L39;
            case 43: goto L37;
            case 44: goto L35;
            default: goto L25;
        };
    L25:
        switch(r100) {
            case 51: goto L33;
            case 52: goto L31;
            case 53: goto L29;
            default: goto L26;
        };
    L26:
        return null;
    L29:
        return DriveWatermarkScene_MAIL_PDF_EXPORT;
    L31:
        return DriveWatermarkScene_MAIL_IMAGE_VIEWER_DOWNLOAD;
    L33:
        return DriveWatermarkScene_MAIL_ATTACHMENT_DOWNLOAD;
    L35:
        return DriveWatermarkScene_CALENDAR_QR_SHARE_IMAGE_COPY;
    L37:
        return DriveWatermarkScene_CALENDAR_IMAGE_VIEWER_COPY;
    L39:
        return DriveWatermarkScene_CALENDAR_IMAGE_COPY;
    L41:
        return DriveWatermarkScene_CALENDAR_ATTACHMENT_DOWNLOAD;
    L43:
        return DriveWatermarkScene_BASE_DASHBOARD_IMAGE_EXPORT;
    L45:
        return DriveWatermarkScene_BASE_EXCEL_EXPORT;
    L47:
        return DriveWatermarkScene_BASE_ATTACHMENT_DOWNLOAD;
    L49:
        return DriveWatermarkScene_CCM_MINDNOTE_IMAGE_EXPORT;
    L51:
        return DriveWatermarkScene_CCM_SHEET_IMAGE_EXPORT;
    L53:
        return DriveWatermarkScene_CCM_ATTACHMENT_DOWNLOAD;
    L55:
        return DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD;
    L57:
        return DriveWatermarkScene_IM_SUBSCRIPTION_IMAGE_DOWNLOAD;
    L59:
        return DriveWatermarkScene_IM_COMPANY_MOMENTS_IMAGE_DOWNLOAD;
    L61:
        return DriveWatermarkScene_IM_EMOJI_DOWNLOAD;
    L63:
        return DriveWatermarkScene_IM_MSG_FILE_DOWNLOAD;
    L65:
        return DriveWatermarkScene_WORKFLOW_RECIPES_IMAGE_DOWNLOAD;
    L67:
        return DriveWatermarkScene_BOARD_IMAGE_DOWNLOAD;
    L69:
        return DriveWatermarkScene_OKR_PROGRESS_IMAGE_DOWNLOAD;
    L71:
        return DriveWatermarkScene_OKR_EXCEL_EXPORT;
    L73:
        return DriveWatermarkScene_REPORT_FILE_DOWNLOAD;
    L75:
        return DriveWatermarkScene_REPORT_FILE_EXPORT;
    L77:
        return DriveWatermarkScene_TASK_IMAGE_VIEWER_COPY;
    L79:
        return DriveWatermarkScene_TASK_ATTACHMENT_DOWNLOAD;
    L81:
        return DriveWatermarkScene_UNKNOWN;
    L83:
        return DriveWatermarkScene_NONE;
    }

    public static DriveWatermarkScene valueOf(String r100) {
        return (DriveWatermarkScene) a.a(DriveWatermarkScene.class, r100);
    }

    private DriveWatermarkScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
