package com.bytedance.ee.bear.bizwidget.shareview;

import com.larus.bmhome.share.panel.ShareChannel;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareType[] f216540a = null;
    private final String itemId;

    static {
        ShareType r100 = new ShareType("Lark", 0, "send_to_chat");
        Lark = r100;
        ShareType r101 = new ShareType("CopyLink", 1, "copy_link");
        CopyLink = r101;
        ShareType r102 = new ShareType("QRCode", 2, "qr_code");
        QRCode = r102;
        ShareType r103 = new ShareType("PasswordLink", 3, "password_link");
        PasswordLink = r103;
        ShareType r104 = new ShareType("ExportImage", 4, "export_image");
        ExportImage = r104;
        ShareType r105 = new ShareType("SlideExport", 5, "slide_export");
        SlideExport = r105;
        ShareType r110 = new ShareType("Wechat", 6, "wechat");
        Wechat = r110;
        ShareType r111 = new ShareType("WechatMoments", 7, "wechat_moments");
        WechatMoments = r111;
        ShareType r112 = new ShareType(Constants.SOURCE_QQ, 8, "qq");
        QQ = r112;
        ShareType r113 = new ShareType("Weibo", 9, "weibo");
        Weibo = r113;
        ShareType r114 = new ShareType("CopyText", 10, ShareChannel.COPY_TEXT);
        CopyText = r114;
        ShareType r106 = new ShareType("More", 11, "more_apps");
        More = r106;
        ShareType r107 = new ShareType("Download", 12, "download");
        Download = r107;
        f216540a = new ShareType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public static ShareType[] values() {
        return (ShareType[]) f216540a.clone();
    }

    public String getItemId() {
        return this.itemId;
    }

    public static ShareType valueOf(String r100) {
        return (ShareType) r27.a.a(ShareType.class, r100);
    }

    public ShareType(String r100, int r101, String r102) {
        super(r100, r101);
        this.itemId = r102;
    }
}
