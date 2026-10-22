package com.bytedance.ee.bear.share.externalshare.external;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.ShareAnalytic;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.pb.security_event.ContainerType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.QQ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ShareType.Wechat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ShareType.WechatMoments.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ShareType.More.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final HashMap<String, Serializable> b(ShareDocInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "shareInfo");
        HashMap<String, Serializable> r0 = new HashMap();
        r0.put("file_id", du5.b.g(r3.c));
        r0.put("file_type", sbb.e.f(r3.getType()));
        r0.put("app_form", "none");
        r0.put("sub_file_type", "");
        r0.put("module", "");
        r0.put("user_permission", r3.f.getReportJson());
        r0.put("file_permission", r3.g.getReportJson());
        if (r3.g.isOwner() == false) goto L5;
        String r4 = "true";
    L6:
        r0.put("is_owner", r4);
        return r0;
    L5:
        r4 = "false";
        goto L6
    }

    @JvmStatic
    public static final SceneType d(ShareType r1) {
        Intrinsics.checkNotNullParameter(r1, "shareType");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L17;
        if (r2 == 5) goto L15;
        return SceneType.PASSWORD_SHARE;
    L15:
        return SceneType.MORE_SHARE;
    L17:
        return SceneType.WEIBO_SHARE;
    L19:
        return SceneType.WECHAT_MOMENTS_SHARE;
    L21:
        return SceneType.WECHAT_SHARE;
    L23:
        return SceneType.QQ_SHARE;
    }

    @JvmStatic
    public static final HashMap<String, Serializable> c(String r4, DocPermSetInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "permSerInfo");
        HashMap<String, Serializable> r1 = new HashMap();
        r1.put("file_id", du5.b.g(r5.c));
        r1.put("file_type", sbb.e.f(r5.getType()));
        r1.put("app_form", "none");
        r1.put("sub_file_type", r5.e.getSubType());
        r1.put("module", r4);
        r1.put("user_permission", r5.f.a.getReportJson());
        r1.put("file_permission", r5.f.b.getReportJson());
        if (r5.b() == false) goto L5;
        String r6 = "true";
    L6:
        r1.put("is_owner", r6);
        return r1;
    L5:
        r6 = "false";
        goto L6
    }

    public static void a(AppDetail r9, ShareParams r10, BearUrl r11) {
        Intrinsics.checkNotNullParameter(r9, "app");
        Intrinsics.checkNotNullParameter(r10, "params");
        String r2 = "";
        if (r9 != AppDetail.AppDetailUnknown) goto L16;
        com.bytedance.ee.bear.middleground_permission_export.model.c r12 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        sbb.e r0 = sbb.e.d(r10.getType());
        String r1 = r10.getToken();
        if (r10.isWiki() == false) goto L7;
        ContainerType r3 = ContainerType.Wiki;
    L9:
        if (r10.isWiki() == false) goto L15;
        if (r11 == null) goto L15;
        String r13 = r11.b;
        if (r13 == null) goto L15;
        r2 = r13;
    L15:
        r12.e(r0, r1, r3, r2);
        return;
    L7:
        r3 = ContainerType.ContainerTypeUnknown;
        goto L9
    L16:
        com.bytedance.ee.bear.middleground_permission_export.model.c r4 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        sbb.e r5 = sbb.e.d(r10.getType());
        String r6 = r10.getToken();
        if (r10.isWiki() == false) goto L19;
        ContainerType r7 = ContainerType.Wiki;
    L20:
        ContainerType r8 = r7;
        if (r10.isWiki() == false) goto L27;
        if (r11 == null) goto L27;
        String r14 = r11.b;
        if (r14 == null) goto L27;
        String r15 = r14;
    L28:
        r4.c(r5, r6, r9, r8, r15);
        return;
    L27:
        r15 = "";
        goto L28
    L19:
        r7 = ContainerType.ContainerTypeUnknown;
        goto L20
    }

    public static void e(String r1, com.bytedance.ee.bear.share.export.f r2, ShareParams r3) {
        Intrinsics.checkNotNullParameter(r1, "platform");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r3, "params");
        int r4 = r3.getSource();
        if (r4 != 0) goto L5;
        String r5 = "left_slide";
    L9:
        String[] r0 = ShareAnalytic.a;
        Intrinsics.checkNotNullParameter(r1, "toPlatform");
        ShareAnalytic.b(r2, r5, r1, null);
        return;
    L5:
        if (r4 == 1) goto L7;
        r5 = "innerpage";
        goto L9
    L7:
        r5 = "grid_more";
        goto L9
    }

    @JvmStatic
    public static final DocPermSetInfo g(ShareDocInfo r16, boolean r17, ShareParams r18) {
        Intrinsics.checkNotNullParameter(r16, "shareInfo");
        Intrinsics.checkNotNullParameter(r18, "params");
        DocVersion r2 = r16.d;
        if (r18.getType() != 44) goto L5;
        r2 = new DocVersion(5);
        r18.setWiki(false);
    L5:
        String r5 = r16.b;
        int r6 = r16.getType();
        String r7 = r16.c;
        boolean r8 = r18.isWiki();
        DocMetaInfo r9 = r16.e;
        DocPermission r10 = new DocPermission(r16.f, 2);
        return new DocPermSetInfo(r5, r6, r7, r8, r9, r10, r2, r18.getPasswordSharingEnable(), r18.getTransferOwnerEnable(), r17, DocUserPermission.USER_PERM_FULL_ACCESS);
    }

    public static void f(String r1, String r2, com.bytedance.ee.bear.share.export.f r3, ShareParams r4) {
        Intrinsics.checkNotNullParameter(r1, "platform");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r4, "params");
        int r5 = r4.getSource();
        if (r5 != 0) goto L5;
        String r6 = "left_slide";
    L9:
        ShareAnalytic.b(r3, r6, r1, r2);
        return;
    L5:
        if (r5 == 1) goto L7;
        r6 = "innerpage";
        goto L9
    L7:
        r6 = "grid_more";
        goto L9
    }
}
