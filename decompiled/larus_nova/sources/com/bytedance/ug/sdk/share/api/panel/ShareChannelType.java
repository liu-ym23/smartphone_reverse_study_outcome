package com.bytedance.ug.sdk.share.api.panel;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayDiscountTextUtils;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.share.MatchShareConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.media.MediaScene;
import com.ss.android.cert.manager.constants.EventConstant;
import com.tencent.connect.common.Constants;
import ln7.a;
import no7.b;

/* JADX INFO: loaded from: classes3.dex */
public final enum ShareChannelType extends Enum<ShareChannelType> implements a {
    public static final ShareChannelType BAND = null;
    public static final ShareChannelType COPY_LINK = null;
    public static final ShareChannelType DINGDING = null;
    public static final ShareChannelType DOUYIN = null;
    public static final ShareChannelType DOUYIN_IM = null;
    public static final ShareChannelType DOUYIN_STORY = null;
    public static final ShareChannelType DUOSHAN = null;
    public static final ShareChannelType EMAIL = null;
    public static final ShareChannelType FACEBOOK = null;
    public static final ShareChannelType FACEBOOK_LITE = null;
    public static final ShareChannelType FACEBOOK_STORY = null;
    public static final ShareChannelType FEILIAO = null;
    public static final ShareChannelType FEISHU = null;
    public static final ShareChannelType IMAGE_SHARE = null;
    public static final ShareChannelType IMGUR = null;
    public static final ShareChannelType INSTAGRAM = null;
    public static final ShareChannelType INSTAGRAM_STORY = null;
    public static final ShareChannelType KAKAO = null;
    public static final ShareChannelType KAKAO_STORY = null;
    public static final ShareChannelType LINE = null;
    public static final ShareChannelType LONG_IMAGE = null;
    public static final ShareChannelType MESSENGER = null;
    public static final ShareChannelType MESSENGER_LITE = null;
    public static final ShareChannelType NAVERBLOG = null;
    public static final ShareChannelType NAVERCAFE = null;
    public static final ShareChannelType QQ = null;
    public static final ShareChannelType QZONE = null;
    public static final ShareChannelType REDDIT = null;
    public static final ShareChannelType SMS = null;
    public static final ShareChannelType SNAPCHAT = null;
    public static final ShareChannelType SYSTEM = null;
    public static final ShareChannelType TELEGRAM = null;
    public static final ShareChannelType TIKTOK = null;
    public static final ShareChannelType TOUTIAO = null;
    public static final ShareChannelType TWITTER = null;
    public static final ShareChannelType VIBER = null;
    public static final ShareChannelType VIDEO_SAVE = null;
    public static final ShareChannelType VK = null;
    public static final ShareChannelType WEIBO = null;
    public static final ShareChannelType WEIBO_SG = null;
    public static final ShareChannelType WHATSAPP = null;
    public static final ShareChannelType WHATSAPP_STATUS = null;
    public static final ShareChannelType WX = null;
    public static final ShareChannelType WX_TIMELINE = null;
    public static final ShareChannelType ZALO = null;
    public static final ShareChannelType ZHIFUBAO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareChannelType[] f272311a = null;
    private final String mChannelName;
    private final String mKey;
    private final String mPackageName;

    static {
        ShareChannelType r100 = new ShareChannelType("WX_TIMELINE", 0, ShareChannel.WX_MOMENTS, "朋友圈", "com.tencent.mm");
        WX_TIMELINE = r100;
        ShareChannelType r101 = new ShareChannelType("WX", 1, "wechat", "微信", "com.tencent.mm");
        WX = r101;
        ShareChannelType r102 = new ShareChannelType(Constants.SOURCE_QQ, 2, "qq", Constants.SOURCE_QQ, "com.tencent.mobileqq");
        QQ = r102;
        ShareChannelType r103 = new ShareChannelType("QZONE", 3, "qzone", "QQ空间", "com.tencent.mobileqq");
        QZONE = r103;
        ShareChannelType r104 = new ShareChannelType("WEIBO", 4, "weibo");
        WEIBO = r104;
        ShareChannelType r105 = new ShareChannelType("WEIBO_SG", 5, "weibo_sg");
        WEIBO_SG = r105;
        ShareChannelType r106 = new ShareChannelType("FEILIAO", 6, "feiliao");
        FEILIAO = r106;
        ShareChannelType r107 = new ShareChannelType("DUOSHAN", 7, MatchShareConstants.PLATFORM_DUOSHAN);
        DUOSHAN = r107;
        ShareChannelType r110 = new ShareChannelType("DINGDING", 8, "dingding");
        DINGDING = r110;
        ShareChannelType r111 = new ShareChannelType("DOUYIN", 9, "douyin");
        DOUYIN = r111;
        ShareChannelType r112 = new ShareChannelType("DOUYIN_IM", 10, "douyin_im");
        DOUYIN_IM = r112;
        ShareChannelType r113 = new ShareChannelType("DOUYIN_STORY", 11, "douyin_story");
        DOUYIN_STORY = r113;
        ShareChannelType r114 = new ShareChannelType("TOUTIAO", 12, "toutiao");
        TOUTIAO = r114;
        ShareChannelType r108 = new ShareChannelType("FEISHU", 13, "feishu");
        FEISHU = r108;
        ShareChannelType r109 = new ShareChannelType("ZHIFUBAO", 14, EventConstant.Value.ZHIFUBAO);
        ZHIFUBAO = r109;
        ShareChannelType r115 = new ShareChannelType(MediaScene.SYSTEM, 15, "sys_share");
        SYSTEM = r115;
        ShareChannelType r116 = new ShareChannelType("COPY_LINK", 16, "copy_link");
        COPY_LINK = r116;
        ShareChannelType r117 = new ShareChannelType(CancelRetainContactInfoFunctions.SMS, 17, "sms");
        SMS = r117;
        ShareChannelType r118 = new ShareChannelType(CommonConstant.RETKEY.EMAIL, 18, "email");
        EMAIL = r118;
        ShareChannelType r119 = new ShareChannelType("IMAGE_SHARE", 19, "image_share");
        IMAGE_SHARE = r119;
        ShareChannelType r120 = new ShareChannelType("LONG_IMAGE", 20, "long_image");
        LONG_IMAGE = r120;
        ShareChannelType r121 = new ShareChannelType("VIDEO_SAVE", 21, "video_save");
        VIDEO_SAVE = r121;
        ShareChannelType r122 = new ShareChannelType("FACEBOOK", 22, "facebook");
        FACEBOOK = r122;
        ShareChannelType r123 = new ShareChannelType("FACEBOOK_STORY", 23, "facebook_story");
        FACEBOOK_STORY = r123;
        ShareChannelType r124 = new ShareChannelType("FACEBOOK_LITE", 24, "facebook_lite");
        FACEBOOK_LITE = r124;
        ShareChannelType r125 = new ShareChannelType("MESSENGER", 25, "messenger");
        MESSENGER = r125;
        ShareChannelType r126 = new ShareChannelType("MESSENGER_LITE", 26, "messenger_lite");
        MESSENGER_LITE = r126;
        ShareChannelType r127 = new ShareChannelType(CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, 27, "line");
        LINE = r127;
        ShareChannelType r128 = new ShareChannelType("WHATSAPP", 28, "whatsapp");
        WHATSAPP = r128;
        ShareChannelType r129 = new ShareChannelType("WHATSAPP_STATUS", 29, IBaseHostShare.WHATS_APP_STATUS);
        WHATSAPP_STATUS = r129;
        ShareChannelType r130 = new ShareChannelType("INSTAGRAM", 30, "instagram");
        INSTAGRAM = r130;
        ShareChannelType r131 = new ShareChannelType("INSTAGRAM_STORY", 31, IBaseHostShare.INSTAGROM_STORY);
        INSTAGRAM_STORY = r131;
        ShareChannelType r132 = new ShareChannelType("TIKTOK", 32, "tiktok");
        TIKTOK = r132;
        ShareChannelType r133 = new ShareChannelType("TWITTER", 33, "twitter");
        TWITTER = r133;
        ShareChannelType r134 = new ShareChannelType("KAKAO", 34, "kakao");
        KAKAO = r134;
        ShareChannelType r135 = new ShareChannelType("KAKAO_STORY", 35, IBaseHostShare.KAKAO_STORY);
        KAKAO_STORY = r135;
        ShareChannelType r136 = new ShareChannelType("SNAPCHAT", 36, "snapchat");
        SNAPCHAT = r136;
        ShareChannelType r137 = new ShareChannelType("BAND", 37, IBaseHostShare.BAND);
        BAND = r137;
        ShareChannelType r138 = new ShareChannelType("IMGUR", 38, "imgur");
        IMGUR = r138;
        ShareChannelType r139 = new ShareChannelType("NAVERBLOG", 39, IBaseHostShare.NAVER_BLOG);
        NAVERBLOG = r139;
        ShareChannelType r140 = new ShareChannelType("NAVERCAFE", 40, IBaseHostShare.NAVER_CAFE);
        NAVERCAFE = r140;
        ShareChannelType r141 = new ShareChannelType("VIBER", 41, IBaseHostShare.VIBER);
        VIBER = r141;
        ShareChannelType r142 = new ShareChannelType("VK", 42, "vk");
        VK = r142;
        ShareChannelType r143 = new ShareChannelType("TELEGRAM", 43, ShareChannel.TELEGRAM);
        TELEGRAM = r143;
        ShareChannelType r144 = new ShareChannelType("ZALO", 44, IBaseHostShare.ZALO);
        ZALO = r144;
        ShareChannelType r145 = new ShareChannelType("REDDIT", 45, "reddit");
        REDDIT = r145;
        f272311a = new ShareChannelType[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145};
    }

    public static ShareChannelType[] values() {
        return (ShareChannelType[]) f272311a.clone();
    }

    public static String getShareChannelName(ShareChannelType r100) {
        if (r100 != null) goto L4;
    L7:
        b r101 = com.bytedance.ug.sdk.share.impl.manager.b.b(r100);
        if (r101 != null) goto L10;
        return "";
    L10:
        if (r101.getChannelName() != null) goto L12;
        return "";
    L12:
        return r101.getChannelName();
    L4:
        if (TextUtils.isEmpty(r100.mChannelName) == true) goto L7;
        return r100.mChannelName;
    }

    public static ShareChannelType getShareItemType(String r100) {
        ShareChannelType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ShareChannelType r104 = r101[r103];
        if (r104.mKey.equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static String getShareItemTypeName(ShareChannelType r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.mKey;
    }

    public static String getSharePackageName(ShareChannelType r100) {
        if (r100 != null) goto L4;
    L7:
        b r101 = com.bytedance.ug.sdk.share.impl.manager.b.b(r100);
        if (r101 != null) goto L10;
        return "";
    L10:
        if (r101.getPackageName() != null) goto L12;
        return "";
    L12:
        return r101.getPackageName();
    L4:
        if (TextUtils.isEmpty(r100.mPackageName) == true) goto L7;
        return r100.mPackageName;
    }

    public static ShareChannelType valueOf(String r100) {
        return (ShareChannelType) r27.a.a(ShareChannelType.class, r100);
    }

    public ShareChannelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mKey = r102;
        this.mChannelName = "";
        this.mPackageName = "";
    }

    public ShareChannelType(String r100, int r101, String r102, String r103, String r104) {
        super(r100, r101);
        this.mKey = r102;
        this.mChannelName = r103;
        this.mPackageName = r104;
    }
}
