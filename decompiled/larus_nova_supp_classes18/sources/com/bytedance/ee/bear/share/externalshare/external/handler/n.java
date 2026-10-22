package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.info.DocAppIdConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
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

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ ShareDocInfo a;
        public final /* synthetic */ ShareType b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ ShareParams d;

        public b(ShareDocInfo r1, ShareType r2, Context r3, ShareParams r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r20, int r21) {
            tt5.a.h("ShareOpenCommonHandler", "showAnyOneLinkShareTipsDialog()...click confirm.");
            int r2 = n.a;
            ShareDocInfo r3 = this.a;
            ShareType r4 = this.b;
            Context r5 = this.c;
            ShareParams r6 = this.d;
            tt5.a.h("ShareOpenCommonHandler", "showAdjustExternalPanel()...");
            if (r5 == null) goto L31;
            String r7 = r3.c;
            int r8 = r3.getType();
            boolean r9 = r6.isWiki();
            int r10 = a.a[r4.ordinal()];
            if (r10 == 1) goto L15;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L13;
            if (r10 == 4) goto L12;
            if (r10 == 5) goto L11;
            SceneType r11 = SceneType.PASSWORD_SHARE;
        L16:
            EntityType r14 = EntityType.LINK_SHARE_ANYONE_READABLE;
            int r12 = r3.f.getShareExternal();
            int r16 = r3.f.getSharePartnerTenant();
            HashMap<String, Serializable> r17 = com.bytedance.ee.bear.share.externalshare.external.g.b(r3);
            Map r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to(ResourceData.KEY_TOKEN, r3.c), TuplesKt.to(ResourceData.KEY_TYPE, Integer.valueOf(r3.getType())), TuplesKt.to("realToken", r6.getRealToken()), TuplesKt.to("realType", Integer.valueOf(r6.getRealType())), TuplesKt.to("external_access_entity", 1), TuplesKt.to("link_share_entity", 4)});     // Catch: Exception -> L27
            if (r6.isWiki() == false) goto L25;
            Map r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to("link_share_entity", 2), TuplesKt.to("external_access_switch", 2)});     // Catch: Exception -> L27
            if (com.bytedance.ee.bear.middleground.permission.b.m() == false) goto L23;
            tt5.a.h("ShareOpenCommonHandler", "[perm-password-support] createUpdatePermissionInfo use object perm_type for wiki");     // Catch: Exception -> L27
            Map r18 = MapsKt.plus(r13, TuplesKt.to("perm_type", r15));     // Catch: Exception -> L27
        L24:
            String r19 = new Gson().toJson(r18);     // Catch: Exception -> L27
            Intrinsics.checkNotNull(r19);     // Catch: Exception -> L27
        L28:
            ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).Ee(new th5.b(r5, r7, r8, r9, r11, r14, r12, r16, r17, 1, r19));
            return;
        L23:
            tt5.a.h("ShareOpenCommonHandler", "[perm-password-support] createUpdatePermissionInfo keep legacy string perm_type for wiki");     // Catch: Exception -> L27
            r18 = MapsKt.plus(r13, TuplesKt.to("perm_type", new Gson().toJson(r15)));     // Catch: Exception -> L27
            goto L24
        L25:
            r19 = new Gson().toJson(r13);     // Catch: Exception -> L27
            Intrinsics.checkNotNull(r19);     // Catch: Exception -> L27
        L27:
            tt5.a.d("ShareOpenCommonHandler", "createPermissionUpdateInfo failed");
            r19 = "";
            goto L28
        L11:
            r11 = SceneType.MORE_SHARE;
            goto L16
        L12:
            r11 = SceneType.WEIBO_SHARE;
            goto L16
        L13:
            r11 = SceneType.WECHAT_MOMENTS_SHARE;
            goto L16
        L14:
            r11 = SceneType.WECHAT_SHARE;
            goto L16
        L15:
            r11 = SceneType.QQ_SHARE;
            goto L16
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            tt5.a.h("ShareOpenCommonHandler", "showAnyOneLinkShareTipsDialog()...click cancel.");
        }
    }

    static {
    }

    public static String b(String r5) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
        if (AppInfoUtils.e().booleanValue() == true) goto L5;
        return r5;
    L5:
        Uri r6 = UriProtector.parse(r5);
        Uri.Builder r0 = r6.buildUpon().clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r6).iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) r1.next();
        if (Intrinsics.areEqual(r2, "app_source") == true) goto L7;
        if (Intrinsics.areEqual(r2, "doc_app_id") == true) goto L7;
        r0.appendQueryParameter(r2, UriProtector.getQueryParameter(r6, r2));
        goto L7
    L13:
        r0.appendQueryParameter("app_source", "mempope");
        r0.appendQueryParameter("doc_app_id", DocAppIdConst.Mempope.value);
        return r0.toString();
    }

    public static boolean e(ShareParams r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.isAtVC() == false) goto L7;
        return false;
    L7:
        return ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).p(r3.getToken(), r3.getEditionId(), r3.isAtVC());
    }

    public static String a(String r1, ShareParams r2) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r2, "params");
        String r3 = r2.getEditionId();
        if (r3 != null) goto L5;
        return r1;
    L5:
        return UriProtector.parse(r1).buildUpon().appendQueryParameter("edition_id", r3).toString();
    }

    public static boolean c(ShareDocInfo r2, ShareParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r2 == null) goto L9;
        IDocUserPermission r4 = r2.f;
        if (r4 == null) goto L9;
        if (r4.canManagePermissionMeta() != true) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L12;
        return false;
    L12:
        if (r3.getType() == sbb.e.q.b) goto L16;
        return true;
    L16:
        return false;
    L9:
        r5 = false;
        goto L10
    }

    public static String d(Context r6, int r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        if (r7 != sbb.e.f.b) goto L8;
        boolean r1 = true;
    L10:
        if (ui5.c.b(((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2()) == false) goto L12;
    L13:
        r2 = true;
    L14:
        if (r1 == false) goto L17;
        if (r2 == false) goto L17;
        int r0 = 2131889678;
    L22:
        u4.a.getClass();
        return r6.getString(r0) + '\n' + xo5.a.c(r6, 2131888781, "FileType", u4.a(r6, r7));
    L17:
        if (r1 == false) goto L19;
        r0 = 2131889677;
        goto L22
    L19:
        if (r2 == false) goto L21;
        r0 = 2131889680;
        goto L22
    L21:
        r0 = 2131889679;
        goto L22
    L12:
        if (((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).c() == false) goto L14;
    L8:
        r1 = false;
        goto L10
    }

    public static String f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r3, "shareUrl");
        String r4 = new URL(r2).getHost();     // Catch: Exception -> L8
        if (Intrinsics.areEqual(r4, new URL(r3).getHost()) == true) goto L13;
        String r5 = UriProtector.parse(r3).buildUpon().authority(r4).build().toString();     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L8
        return r5;
    L13:
        return r3;
    L8:
        e = move-exception;
        tt5.a.d("ShareReportUtils", "get error while replaceHost  " + e);
        return r3;
    }

    public static void g(com.bytedance.ee.bear.share.export.f r14, com.bytedance.ee.bear.middleground_permission_export.model.a r15, ShareParams r16, Context r17) {
        Intrinsics.checkNotNullParameter(r14, "shareInfo");
        Intrinsics.checkNotNullParameter(r15, "externalShareCallback");
        Intrinsics.checkNotNullParameter(r16, "params");
        cj5.c r0 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        int r3 = r16.getType();
        String r4 = r14.j();
        if (r14.isLinkShareAnyoneRead() == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        r0.C8(r17, r3, r4, r5, r14.e(), r14.adminCanCross(), r14.externalAccess(), r14.i(), r15, r16.getSubType(), r16.isWiki(), r14.g());
        return;
    L5:
        if (r14.isLinkShareAnyoneEdit() == true) goto L8;
        r5 = false;
        goto L9
    }

    public static void h(ShareDocInfo r15, ShareType r16, ShareParams r17, Context r18) {
        Intrinsics.checkNotNullParameter(r15, "shareInfo");
        Intrinsics.checkNotNullParameter(r16, "shareType");
        Intrinsics.checkNotNullParameter(r17, "params");
        ShareType r4 = ShareType.PasswordLink;
        if (r16 != r4) goto L5;
        Integer r10 = Integer.valueOf(SceneType.PASSWORD_SHARE.getValue());
    L6:
        if (r16 != r4) goto L8;
        String r11 = d(r18, r15.getType());
    L9:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).le(r18, r15.getType(), r15.c, r17.getSubType(), r17.isWiki(), true, "from_share", new b(r15, r16, r18, r17), c.a, r10, r11);
        return;
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }
}
