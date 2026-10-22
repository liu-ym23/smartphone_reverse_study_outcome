package com.larus.bmhome.share;

import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b2\b\u0086\u0081\u0002\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00065"}, d2 = {"Lcom/larus/bmhome/share/ShareScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "SHARE_APP", "COMMON_BOT", "COMMON_BOT_WITH_SAVE", "NOTICE_LIST", "IMAGE_VIEWER", "WEBVIEW", "MESSAGES_LINK", "MESSAGES_LINK_SUB_CONV", "MESSAGES_LINK_IMAGE", "MUSIC_VIDEO", "VIDEO_VIEWER", "VIDEO_COMPREHEND", "CONVERSATION_GROUP", "CONVERSATION_GROUP_WITH_SAVE", "IMAGE_VIEWER_REPORT", "MUSIC_VIDEO_REPORT", "SHOW_LONG_IMAGE", "SHOW_LONG_ALBUM", "TABLE_FULL_SCREEN_PAGE", "CODE_FULL_SCREEN_PAGE", "SDK_VIDEO", "SIDEBAR_LONG_PRESS_CELL", "CASE", "DEEP_RESEARCH_EPISODE", "DOCUMENT", "DOCUMENT_CANNOT_EXPORT", "SLIDES", "SHEET", "BITABLE", "DRIVE", "MINI_ARTIFACT", "SINGLE_IMAGE", "SHARE_LINK", "SAAS_SHARE", "Z_SHARE_LINK_PLANB", "OFFICE_MY_QR_CODE", "OFFICE_SHARE_CHAT", "BOT_FILE_PREVIEW", "OFFICE_GROUP_QR_CODE", "OFFICE_SHARE_THREAD", "SOCIAL_IMAGE_SHARE", "SOCIAL_VIDEO_SHARE", "CONVERSATION_CCM", "UNKNOWN", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShareScene extends Enum<ShareScene> {
    public static final ShareScene BITABLE = null;
    public static final ShareScene BOT_FILE_PREVIEW = null;
    public static final ShareScene CASE = null;
    public static final ShareScene CODE_FULL_SCREEN_PAGE = null;
    public static final ShareScene COMMON_BOT = null;
    public static final ShareScene COMMON_BOT_WITH_SAVE = null;
    public static final ShareScene CONVERSATION_CCM = null;
    public static final ShareScene CONVERSATION_GROUP = null;
    public static final ShareScene CONVERSATION_GROUP_WITH_SAVE = null;
    public static final a Companion = null;
    public static final ShareScene DEEP_RESEARCH_EPISODE = null;
    public static final ShareScene DOCUMENT = null;
    public static final ShareScene DOCUMENT_CANNOT_EXPORT = null;
    public static final ShareScene DRIVE = null;
    public static final ShareScene IMAGE_VIEWER = null;
    public static final ShareScene IMAGE_VIEWER_REPORT = null;
    public static final ShareScene MESSAGES_LINK = null;
    public static final ShareScene MESSAGES_LINK_IMAGE = null;
    public static final ShareScene MESSAGES_LINK_SUB_CONV = null;
    public static final ShareScene MINI_ARTIFACT = null;
    public static final ShareScene MUSIC_VIDEO = null;
    public static final ShareScene MUSIC_VIDEO_REPORT = null;
    public static final ShareScene NOTICE_LIST = null;
    public static final ShareScene OFFICE_GROUP_QR_CODE = null;
    public static final ShareScene OFFICE_MY_QR_CODE = null;
    public static final ShareScene OFFICE_SHARE_CHAT = null;
    public static final ShareScene OFFICE_SHARE_THREAD = null;
    public static final ShareScene SAAS_SHARE = null;
    public static final ShareScene SDK_VIDEO = null;
    public static final ShareScene SHARE_APP = null;
    public static final ShareScene SHARE_LINK = null;
    public static final ShareScene SHEET = null;
    public static final ShareScene SHOW_LONG_ALBUM = null;
    public static final ShareScene SHOW_LONG_IMAGE = null;
    public static final ShareScene SIDEBAR_LONG_PRESS_CELL = null;
    public static final ShareScene SINGLE_IMAGE = null;
    public static final ShareScene SLIDES = null;
    public static final ShareScene SOCIAL_IMAGE_SHARE = null;
    public static final ShareScene SOCIAL_VIDEO_SHARE = null;
    public static final ShareScene TABLE_FULL_SCREEN_PAGE = null;
    public static final ShareScene UNKNOWN = null;
    public static final ShareScene VIDEO_COMPREHEND = null;
    public static final ShareScene VIDEO_VIEWER = null;
    public static final ShareScene WEBVIEW = null;
    public static final ShareScene Z_SHARE_LINK_PLANB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareScene[] f313825a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313826b = null;
    private final String scene;

    public static final class a {
        public a() {
        }

        public static ShareScene a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            ShareScene[] r101 = ShareScene.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ShareScene r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getScene(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    public static EnumEntries<ShareScene> getEntries() {
        return f313826b;
    }

    static {
        ShareScene r100 = new ShareScene("SHARE_APP", 0, "share_app");
        SHARE_APP = r100;
        ShareScene r101 = new ShareScene("COMMON_BOT", 1, "common_bot");
        COMMON_BOT = r101;
        ShareScene r102 = new ShareScene("COMMON_BOT_WITH_SAVE", 2, "common_bot_with_save");
        COMMON_BOT_WITH_SAVE = r102;
        ShareScene r103 = new ShareScene("NOTICE_LIST", 3, "notice_list");
        NOTICE_LIST = r103;
        ShareScene r104 = new ShareScene("IMAGE_VIEWER", 4, "image_viewer");
        IMAGE_VIEWER = r104;
        ShareScene r105 = new ShareScene("WEBVIEW", 5, "webview");
        WEBVIEW = r105;
        ShareScene r110 = new ShareScene("MESSAGES_LINK", 6, "messages_link");
        MESSAGES_LINK = r110;
        ShareScene r111 = new ShareScene("MESSAGES_LINK_SUB_CONV", 7, "messages_link_sub_conv");
        MESSAGES_LINK_SUB_CONV = r111;
        ShareScene r112 = new ShareScene("MESSAGES_LINK_IMAGE", 8, "messages_link_image");
        MESSAGES_LINK_IMAGE = r112;
        ShareScene r113 = new ShareScene("MUSIC_VIDEO", 9, "music_video");
        MUSIC_VIDEO = r113;
        ShareScene r106 = new ShareScene("VIDEO_VIEWER", 10, "video_viewer");
        VIDEO_VIEWER = r106;
        ShareScene r107 = new ShareScene("VIDEO_COMPREHEND", 11, "share_video");
        VIDEO_COMPREHEND = r107;
        ShareScene r108 = new ShareScene("CONVERSATION_GROUP", 12, "conversation_group");
        CONVERSATION_GROUP = r108;
        ShareScene r109 = new ShareScene("CONVERSATION_GROUP_WITH_SAVE", 13, "conversation_group_with_save");
        CONVERSATION_GROUP_WITH_SAVE = r109;
        ShareScene r114 = new ShareScene("IMAGE_VIEWER_REPORT", 14, "image_viewer_report");
        IMAGE_VIEWER_REPORT = r114;
        ShareScene r115 = new ShareScene("MUSIC_VIDEO_REPORT", 15, "music_video_report");
        MUSIC_VIDEO_REPORT = r115;
        ShareScene r116 = new ShareScene("SHOW_LONG_IMAGE", 16, "show_long_image");
        SHOW_LONG_IMAGE = r116;
        ShareScene r117 = new ShareScene("SHOW_LONG_ALBUM", 17, "show_long_album");
        SHOW_LONG_ALBUM = r117;
        ShareScene r118 = new ShareScene("TABLE_FULL_SCREEN_PAGE", 18, "table_full_screen_page");
        TABLE_FULL_SCREEN_PAGE = r118;
        ShareScene r119 = new ShareScene("CODE_FULL_SCREEN_PAGE", 19, "code_full_screen_page");
        CODE_FULL_SCREEN_PAGE = r119;
        ShareScene r120 = new ShareScene("SDK_VIDEO", 20, "sdk_video");
        SDK_VIDEO = r120;
        ShareScene r121 = new ShareScene("SIDEBAR_LONG_PRESS_CELL", 21, "long_press_cell");
        SIDEBAR_LONG_PRESS_CELL = r121;
        ShareScene r122 = new ShareScene("CASE", 22, "user_case");
        CASE = r122;
        ShareScene r123 = new ShareScene("DEEP_RESEARCH_EPISODE", 23, "deep_research_episode");
        DEEP_RESEARCH_EPISODE = r123;
        ShareScene r124 = new ShareScene("DOCUMENT", 24, "document");
        DOCUMENT = r124;
        ShareScene r125 = new ShareScene("DOCUMENT_CANNOT_EXPORT", 25, "document_cannot_export");
        DOCUMENT_CANNOT_EXPORT = r125;
        ShareScene r126 = new ShareScene("SLIDES", 26, "aippt_new");
        SLIDES = r126;
        ShareScene r127 = new ShareScene("SHEET", 27, "aisheet");
        SHEET = r127;
        ShareScene r128 = new ShareScene("BITABLE", 28, "aibase");
        BITABLE = r128;
        ShareScene r129 = new ShareScene("DRIVE", 29, "ai_space");
        DRIVE = r129;
        ShareScene r130 = new ShareScene("MINI_ARTIFACT", 30, "mini_artifact");
        MINI_ARTIFACT = r130;
        ShareScene r131 = new ShareScene("SINGLE_IMAGE", 31, "single_image");
        SINGLE_IMAGE = r131;
        ShareScene r132 = new ShareScene("SHARE_LINK", 32, InvHitPoint.ShareMethod.SHARE_LINK);
        SHARE_LINK = r132;
        ShareScene r133 = new ShareScene("SAAS_SHARE", 33, "saas_share");
        SAAS_SHARE = r133;
        ShareScene r134 = new ShareScene("Z_SHARE_LINK_PLANB", 34, "z_share_link_planb");
        Z_SHARE_LINK_PLANB = r134;
        ShareScene r135 = new ShareScene("OFFICE_MY_QR_CODE", 35, "office_my_qr_code");
        OFFICE_MY_QR_CODE = r135;
        ShareScene r136 = new ShareScene("OFFICE_SHARE_CHAT", 36, "office_share_chat");
        OFFICE_SHARE_CHAT = r136;
        ShareScene r137 = new ShareScene("BOT_FILE_PREVIEW", 37, "bot_file_preview");
        BOT_FILE_PREVIEW = r137;
        ShareScene r138 = new ShareScene("OFFICE_GROUP_QR_CODE", 38, "office_group_qr_code");
        OFFICE_GROUP_QR_CODE = r138;
        ShareScene r139 = new ShareScene("OFFICE_SHARE_THREAD", 39, "office_share_thread");
        OFFICE_SHARE_THREAD = r139;
        ShareScene r140 = new ShareScene("SOCIAL_IMAGE_SHARE", 40, "social_image_share");
        SOCIAL_IMAGE_SHARE = r140;
        ShareScene r141 = new ShareScene("SOCIAL_VIDEO_SHARE", 41, "social_video_share");
        SOCIAL_VIDEO_SHARE = r141;
        ShareScene r142 = new ShareScene("CONVERSATION_CCM", 42, "conversation_ccm");
        CONVERSATION_CCM = r142;
        ShareScene r143 = new ShareScene("UNKNOWN", 43, "unknown");
        UNKNOWN = r143;
        ShareScene[] r144 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143};
        f313825a = r144;
        f313826b = EnumEntriesKt.enumEntries(r144);
        Companion = new a();
    }

    public static ShareScene[] values() {
        return (ShareScene[]) f313825a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static ShareScene valueOf(String r100) {
        return (ShareScene) r27.a.a(ShareScene.class, r100);
    }

    public ShareScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
