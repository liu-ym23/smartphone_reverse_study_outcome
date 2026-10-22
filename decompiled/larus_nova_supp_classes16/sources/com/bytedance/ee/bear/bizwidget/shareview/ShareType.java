package com.bytedance.ee.bear.bizwidget.shareview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ShareType extends Enum<ShareType> {
    public static final ShareType CopyLink = null;
    public static final ShareType CopyText = null;
    public static final ShareType Download = null;
    public static final ShareType ExportImage = null;
    public static final ShareType Lark = null;
    public static final ShareType More = null;
    public static final ShareType PasswordLink = null;
    public static final ShareType QQ = null;
    public static final ShareType QRCode = null;
    public static final ShareType SlideExport = null;
    public static final ShareType Wechat = null;
    public static final ShareType WechatMoments = null;
    public static final ShareType Weibo = null;
    public static final /* synthetic */ ShareType[] a = null;
    private final String itemId;

    static {
        ShareType r0 = new ShareType("Lark", 0, "send_to_chat");
        Lark = r0;
        ShareType r1 = new ShareType("CopyLink", 1, "copy_link");
        CopyLink = r1;
        ShareType r2 = new ShareType("QRCode", 2, "qr_code");
        QRCode = r2;
        ShareType r4 = new ShareType("PasswordLink", 3, "password_link");
        PasswordLink = r4;
        ShareType r6 = new ShareType("ExportImage", 4, "export_image");
        ExportImage = r6;
        ShareType r8 = new ShareType("SlideExport", 5, "slide_export");
        SlideExport = r8;
        ShareType r10 = new ShareType("Wechat", 6, "wechat");
        Wechat = r10;
        ShareType r12 = new ShareType("WechatMoments", 7, "wechat_moments");
        WechatMoments = r12;
        ShareType r14 = new ShareType("QQ", 8, "qq");
        QQ = r14;
        ShareType r13 = new ShareType("Weibo", 9, "weibo");
        Weibo = r13;
        ShareType r11 = new ShareType("CopyText", 10, "copy_text");
        CopyText = r11;
        ShareType r9 = new ShareType("More", 11, "more_apps");
        More = r9;
        ShareType r7 = new ShareType("Download", 12, "download");
        Download = r7;
        a = new ShareType[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
    }

    public static ShareType[] values() {
        return (ShareType[]) a.clone();
    }

    public String getItemId() {
        return this.itemId;
    }

    public static ShareType valueOf(String r1) {
        return (ShareType) r27.a.a(ShareType.class, r1);
    }

    public ShareType(String r1, int r2, String r3) {
        super(r1, r2);
        this.itemId = r3;
    }
}
