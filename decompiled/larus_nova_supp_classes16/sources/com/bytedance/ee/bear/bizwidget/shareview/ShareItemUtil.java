package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ShareItemUtil {
    public static final ShareItemUtil a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemUtil$DefaultItemStyle;", "", "itemId", "", "title", "iconRes", "", "tintColor", "bgColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;III)V", "getItemId", "()Ljava/lang/String;", "getTitle", "getIconRes", "()I", "getTintColor", "getBgColor", "Lark", "CopyLink", "QRCode", "PasswordLink", "ExportImage", "SlideExport", "Wechat", "WechatMoments", "QQ", "Weibo", "CopyText", "More", "Download", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public static final /* synthetic */ DefaultItemStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int bgColor;
        private final int iconRes;
        private final String itemId;
        private final int tintColor;
        private final String title;

        public static EnumEntries<DefaultItemStyle> getEntries() {
            return b;
        }

        static {
            DefaultItemStyle r8 = new DefaultItemStyle("Lark", 0, "send_to_chat", ContextCompat.getString(LarkContext.getApplication(), 2131889257), 2131247740, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            Lark = r8;
            DefaultItemStyle r0 = new DefaultItemStyle("CopyLink", 1, "copy_link", ContextCompat.getString(LarkContext.getApplication(), 2131889020), 2131247742, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            CopyLink = r0;
            DefaultItemStyle r1 = new DefaultItemStyle("QRCode", 2, "qr_code", ContextCompat.getString(LarkContext.getApplication(), 2131886676), 2131247745, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            QRCode = r1;
            DefaultItemStyle r2 = new DefaultItemStyle("PasswordLink", 3, "password_link", ContextCompat.getString(LarkContext.getApplication(), 2131889202), 2131247743, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            PasswordLink = r2;
            DefaultItemStyle r3 = new DefaultItemStyle("ExportImage", 4, "export_image", ContextCompat.getString(LarkContext.getApplication(), 2131889262), 2131247741, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            ExportImage = r3;
            DefaultItemStyle r4 = new DefaultItemStyle("SlideExport", 5, "slide_export", ContextCompat.getString(LarkContext.getApplication(), 2131887581), 2131247739, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            SlideExport = r4;
            DefaultItemStyle r5 = new DefaultItemStyle("Wechat", 6, "wechat", ContextCompat.getString(LarkContext.getApplication(), 2131887587), 2131256204, ShareItemModel.SRC_TINT_UNDEFINED, ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            Wechat = r5;
            DefaultItemStyle r6 = new DefaultItemStyle("WechatMoments", 7, "wechat_moments", ContextCompat.getString(LarkContext.getApplication(), 2131887582), 2131256206, ShareItemModel.SRC_TINT_UNDEFINED, ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            WechatMoments = r6;
            DefaultItemStyle r7 = new DefaultItemStyle("QQ", 8, "qq", ContextCompat.getString(LarkContext.getApplication(), 2131887584), 2131255470, ShareItemModel.SRC_TINT_UNDEFINED, ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            QQ = r7;
            DefaultItemStyle r19 = new DefaultItemStyle("Weibo", 9, "weibo", ContextCompat.getString(LarkContext.getApplication(), 2131887588), 2131256210, ShareItemModel.SRC_TINT_UNDEFINED, ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            Weibo = r19;
            DefaultItemStyle r11 = new DefaultItemStyle("CopyText", 10, "copy_text", ContextCompat.getString(LarkContext.getApplication(), 2131887145), 2131247737, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            CopyText = r11;
            DefaultItemStyle r12 = new DefaultItemStyle("More", 11, "more_apps", ContextCompat.getString(LarkContext.getApplication(), 2131889258), 2131247744, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            More = r12;
            DefaultItemStyle r13 = new DefaultItemStyle("Download", 12, "download", ContextCompat.getString(LarkContext.getApplication(), 2131887580), 2131247738, ContextCompat.getColor(LarkContext.getApplication(), 2131102418), ContextCompat.getColor(LarkContext.getApplication(), 2131100557));
            Download = r13;
            DefaultItemStyle[] r9 = {r8, r0, r1, r2, r3, r4, r5, r6, r7, r19, r11, r12, r13};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static DefaultItemStyle[] values() {
            return (DefaultItemStyle[]) a.clone();
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

        public static DefaultItemStyle valueOf(String r1) {
            return (DefaultItemStyle) r27.a.a(DefaultItemStyle.class, r1);
        }

        public DefaultItemStyle(String r1, int r2, String r3, String r4, int r5, int r6, int r7) {
            super(r1, r2);
            this.itemId = r3;
            this.title = r4;
            this.iconRes = r5;
            this.tintColor = r6;
            this.bgColor = r7;
        }
    }

    static {
        a = new ShareItemUtil();
    }

    public ShareItemUtil() {
    }

    public static ShareItemModel a(ShareType r4, ShareState r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r4, "type");
        Iterator r0 = DefaultItemStyle.getEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((DefaultItemStyle) r1).getItemId(), r4.getItemId()) == false) goto L4;
    L9:
        DefaultItemStyle r2 = (DefaultItemStyle) r1;
        if (r2 == null) goto L12;
        ShareItemModel r3 = new ShareItemModel(r4);
        r3.setDescription(r2.getTitle());
        r3.setIconResId(r2.getIconRes());
        r3.setSrcTint(r2.getTintColor());
        r3.setShareItemBackground(r2.getBgColor());
    L17:
        r3.setState(r5);
        return r3;
    L12:
        if (eu5.c.d() == true) goto L15;
        r3 = new ShareItemModel(r4);
        goto L17
    L15:
        throw new IllegalArgumentException("DefaultItemStyle must contain every style for each in ShareType");
    L8:
        r1 = null;
        goto L9
    }

    @JvmStatic
    public static final String b(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        return r2;
    L12:
        if (r3 != sbb.e.o.b) goto L15;
        int r4 = 2131887894;
    L40:
        return ContextCompat.getString(r1, r4);
    L15:
        if (r3 != sbb.e.h.b) goto L18;
        r4 = 2131887898;
        goto L40
    L18:
        if (r3 != sbb.e.m.b) goto L21;
        r4 = 2131889767;
        goto L40
    L21:
        if (r3 != sbb.e.k.b) goto L24;
        r4 = 2131887897;
        goto L40
    L24:
        if (r3 != sbb.e.l.b) goto L27;
        r4 = 2131887895;
        goto L40
    L27:
        if (r3 != sbb.e.i.b) goto L30;
        r4 = 2131887893;
        goto L40
    L30:
        if (r3 != sbb.e.f.b) goto L33;
        r4 = 2131887896;
        goto L40
    L33:
        if (r3 != sbb.e.n.b) goto L36;
        r4 = 2131887899;
        goto L40
    L36:
        if (r3 != sbb.e.v.b) goto L38;
        r4 = 2131888865;
        goto L40
    L38:
        r4 = 2131887745;
        goto L40
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
