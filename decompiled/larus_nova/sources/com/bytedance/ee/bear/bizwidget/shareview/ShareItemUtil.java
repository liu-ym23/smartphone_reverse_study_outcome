package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class ShareItemUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShareItemUtil f216536a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemUtil$DefaultItemStyle;", "", "itemId", "", "title", "iconRes", "", "tintColor", "bgColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;III)V", "getItemId", "()Ljava/lang/String;", "getTitle", "getIconRes", "()I", "getTintColor", "getBgColor", "Lark", "CopyLink", "QRCode", "PasswordLink", "ExportImage", "SlideExport", "Wechat", "WechatMoments", Constants.SOURCE_QQ, "Weibo", "CopyText", "More", "Download", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DefaultItemStyle extends Enum<DefaultItemStyle> {
        public static final DefaultItemStyle CopyLink = null;
        public static final DefaultItemStyle CopyText = null;
        public static final DefaultItemStyle Download = null;
        public static final DefaultItemStyle ExportImage = null;
        public static final DefaultItemStyle Lark = null;
        public static final DefaultItemStyle More = null;
        public static final DefaultItemStyle PasswordLink = null;
        public static final DefaultItemStyle QQ = null;
        public static final DefaultItemStyle QRCode = null;
        public static final DefaultItemStyle SlideExport = null;
        public static final DefaultItemStyle Wechat = null;
        public static final DefaultItemStyle WechatMoments = null;
        public static final DefaultItemStyle Weibo = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DefaultItemStyle[] f216537a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f216538b = null;
        private final int bgColor;
        private final int iconRes;
        private final String itemId;
        private final int tintColor;
        private final String title;

        public static EnumEntries<DefaultItemStyle> getEntries() {
            return f216538b;
        }

        static {
            DefaultItemStyle r100 = new DefaultItemStyle("Lark", 0, "send_to_chat", ContextCompat.getString(LarkContext.getApplication(), R.string.LarkCCM_Docs_SendToChat_Button_Mob), R.drawable.share_icon_forward_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            Lark = r100;
            DefaultItemStyle r101 = new DefaultItemStyle("CopyLink", 1, "copy_link", ContextCompat.getString(LarkContext.getApplication(), R.string.LarkCCM_Docs_CopyLink_Button_Mob), R.drawable.share_icon_link_copy_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            CopyLink = r101;
            DefaultItemStyle r102 = new DefaultItemStyle("QRCode", 2, "qr_code", ContextCompat.getString(LarkContext.getApplication(), R.string.Bitable_NewSurvey_Sharing_ShareQRCode_Title), R.drawable.share_icon_qr_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            QRCode = r102;
            DefaultItemStyle r103 = new DefaultItemStyle("PasswordLink", 3, "password_link", ContextCompat.getString(LarkContext.getApplication(), R.string.LarkCCM_Docs_PasswordProtectedLink_Button_Mob), R.drawable.share_icon_link_lock_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            PasswordLink = r103;
            DefaultItemStyle r104 = new DefaultItemStyle("ExportImage", 4, "export_image", ContextCompat.getString(LarkContext.getApplication(), R.string.LarkCCM_Docs_ShareImage_Button_Mob), R.drawable.share_icon_image_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            ExportImage = r104;
            DefaultItemStyle r105 = new DefaultItemStyle("SlideExport", 5, "slide_export", ContextCompat.getString(LarkContext.getApplication(), R.string.Doc_BizWidget_Export), R.drawable.share_icon_export_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            SlideExport = r105;
            DefaultItemStyle r106 = new DefaultItemStyle("Wechat", 6, "wechat", ContextCompat.getString(LarkContext.getApplication(), R.string.Doc_BizWidget_WeChat), R.drawable.ud_icon_wechat_colorful, Integer.MIN_VALUE, ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            Wechat = r106;
            DefaultItemStyle r107 = new DefaultItemStyle("WechatMoments", 7, "wechat_moments", ContextCompat.getString(LarkContext.getApplication(), R.string.Doc_BizWidget_Moments), R.drawable.ud_icon_wechat_friend_colorful, Integer.MIN_VALUE, ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            WechatMoments = r107;
            DefaultItemStyle r108 = new DefaultItemStyle(Constants.SOURCE_QQ, 8, "qq", ContextCompat.getString(LarkContext.getApplication(), R.string.Doc_BizWidget_QQ), R.drawable.ud_icon_qq_colorful, Integer.MIN_VALUE, ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            QQ = r108;
            DefaultItemStyle r110 = new DefaultItemStyle("Weibo", 9, "weibo", ContextCompat.getString(LarkContext.getApplication(), R.string.Doc_BizWidget_Weibo), R.drawable.ud_icon_weibo_colorful, Integer.MIN_VALUE, ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            Weibo = r110;
            DefaultItemStyle r111 = new DefaultItemStyle("CopyText", 10, ShareChannel.COPY_TEXT, ContextCompat.getString(LarkContext.getApplication(), R.string.CreationMobile_CopyText), R.drawable.share_icon_copy_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            CopyText = r111;
            DefaultItemStyle r112 = new DefaultItemStyle("More", 11, "more_apps", ContextCompat.getString(LarkContext.getApplication(), R.string.LarkCCM_Docs_SendToOtherApps_Button_Mob), R.drawable.share_icon_more_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            More = r112;
            DefaultItemStyle r113 = new DefaultItemStyle("Download", 12, "download", ContextCompat.getString(LarkContext.getApplication(), R.string.Doc_BizWidget_Download), R.drawable.share_icon_download_outlined, ContextCompat.getColor(LarkContext.getApplication(), R.color.icon_n1), ContextCompat.getColor(LarkContext.getApplication(), R.color.bg_float));
            Download = r113;
            DefaultItemStyle[] r109 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113};
            f216537a = r109;
            f216538b = EnumEntriesKt.enumEntries(r109);
        }

        public static DefaultItemStyle[] values() {
            return (DefaultItemStyle[]) f216537a.clone();
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final int getTintColor() {
            return this.tintColor;
        }

        public final String getTitle() {
            return this.title;
        }

        public static DefaultItemStyle valueOf(String r100) {
            return (DefaultItemStyle) r27.a.a(DefaultItemStyle.class, r100);
        }

        public DefaultItemStyle(String r100, int r101, String r102, String r103, int r104, int r105, int r106) {
            super(r100, r101);
            this.itemId = r102;
            this.title = r103;
            this.iconRes = r104;
            this.tintColor = r105;
            this.bgColor = r106;
        }
    }

    static {
        f216536a = new ShareItemUtil();
    }

    public ShareItemUtil() {
    }

    public static ShareItemModel a(ShareType r100, ShareState r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r100, "type");
        Iterator<DefaultItemStyle> r102 = DefaultItemStyle.getEntries().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        DefaultItemStyle r103 = r102.next();
        if (Intrinsics.areEqual(r103.getItemId(), r100.getItemId()) == false) goto L4;
    L9:
        DefaultItemStyle r104 = r103;
        if (r104 == null) goto L12;
        ShareItemModel r105 = new ShareItemModel(r100);
        r105.setDescription(r104.getTitle());
        r105.setIconResId(r104.getIconRes());
        r105.setSrcTint(r104.getTintColor());
        r105.setShareItemBackground(r104.getBgColor());
    L17:
        r105.setState(r101);
        return r105;
    L12:
        if (eu5.c.d() == true) goto L15;
        r105 = new ShareItemModel(r100);
        goto L17
    L15:
        throw new IllegalArgumentException("DefaultItemStyle must contain every style for each in ShareType");
    L8:
        r103 = null;
        goto L9
    }

    @JvmStatic
    public static final String b(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        return r101;
    L12:
        if (r102 != sbb.e.f541304o.f541317b) goto L15;
        int r104 = R.string.Doc_List_DocumentTypeDocs;
    L40:
        return ContextCompat.getString(r100, r104);
    L15:
        if (r102 != sbb.e.f541297h.f541317b) goto L18;
        r104 = R.string.Doc_List_DocumentTypeSheets;
        goto L40
    L18:
        if (r102 != sbb.e.f541302m.f541317b) goto L21;
        r104 = R.string.LarkCCM_Slides_ProductName;
        goto L40
    L21:
        if (r102 != sbb.e.f541300k.f541317b) goto L24;
        r104 = R.string.Doc_List_DocumentTypeMindNotes;
        goto L40
    L24:
        if (r102 != sbb.e.f541301l.f541317b) goto L27;
        r104 = R.string.Doc_List_DocumentTypeFile;
        goto L40
    L27:
        if (r102 != sbb.e.f541298i.f541317b) goto L30;
        r104 = R.string.Doc_List_DocumentTypeBase;
        goto L40
    L30:
        if (r102 != sbb.e.f541295f.f541317b) goto L33;
        r104 = R.string.Doc_List_DocumentTypeFolder;
        goto L40
    L33:
        if (r102 != sbb.e.f541303n.f541317b) goto L36;
        r104 = R.string.Doc_List_DocumentTypeWiki;
        goto L40
    L36:
        if (r102 != sbb.e.f541311v.f541317b) goto L38;
        r104 = R.string.LarkCCM_ChatShare_ChatsTc_Text;
        goto L40
    L38:
        r104 = R.string.Doc_Facade_Document;
        goto L40
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
