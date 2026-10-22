package com.bytedance.ee.bear.share.externalshare.external;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler;
import com.bytedance.ee.bear.share.externalshare.external.handler.n;
import com.bytedance.ee.bear.share.newshare.y;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a implements com.bytedance.ee.bear.bizwidget.shareview.b {
    public final ShareParams a;
    public final Context b;
    public final com.bytedance.ee.bear.share.newshare.b c;
    public ShareType d;
    public BearUrl e;
    public final ExternalShareMinaConfig f;
    public BaseOpenTencentHandler g;
    public com.bytedance.ee.bear.share.externalshare.external.handler.b h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.share.externalshare.external.a$a, reason: collision with other inner class name */
    public static final class C0173a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[ShareType.CopyLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[ShareType.PasswordLink.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[ShareType.ExportImage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[ShareType.SlideExport.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[ShareType.Download.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[ShareType.Wechat.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[ShareType.WechatMoments.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[ShareType.QQ.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[ShareType.Weibo.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[ShareType.CopyText.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[ShareType.More.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    static {
    }

    public com.bytedance.ee.bear.share.export.f a() {
        throw null;
    }

    public void d() {
        throw null;
    }

    public void f() {
    }

    public final boolean rF(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        return true;
    }

    public final void b() {
        tt5.a.h("BaseShareExternalPresenter", "onCopyLink");
        this.d = ShareType.CopyLink;
        int r0 = g.a;
        g.e("copy", a(), this.a);
        com.bytedance.ee.bear.share.d.c(this.a.getToken(), this.a.getType(), this.a.getSubType(), this.a.isWiki());
    }

    public final void e() {
        tt5.a.h("BaseShareExternalPresenter", "onExportImage");
        this.d = ShareType.ExportImage;
        String r0 = this.a.getToken();
        ShareParams r1 = this.a;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        r0 = ((k) org.koin.java.a.c(k.class, null, null, 6)).s(r0, this.a.getEditionId());
    L11:
        com.bytedance.ee.bear.share.d.e(r0, this.a.getType(), this.a.getSubType(), this.a.isWiki());
        int r3 = g.a;
        g.e("gene_long_image", a(), this.a);
        g.a(AppDetail.AppDetailUnknown, this.a, this.e);
        int r4 = n.a;
        int r5 = this.a.getType();
        Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.d(r5).b, r0, OperationName.OPERATION_DOWNLOAD);
        return;
    L5:
        if (r1.isAtVC() == true) goto L8;
        r2 = ((k) org.koin.java.a.c(k.class, null, null, 6)).p(r1.getToken(), r1.getEditionId(), r1.isAtVC());
        goto L9
    }

    public final void g() {
        tt5.a.h("BaseShareExternalPresenter", "onShareToLark");
        this.d = ShareType.Lark;
        int r0 = g.a;
        g.e("lark", a(), this.a);
        String r1 = this.a.getToken();
        int r2 = this.a.getType();
        String r3 = this.a.getSubType();
        boolean r4 = this.a.isWiki();
        String r5 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "subType");
        com.bytedance.ee.bear.share.d.f("share_lark", "ccm_permission_share_lark_view", new com.bytedance.ee.bear.share.c(r1, r2, r3, r4));
        String r6 = this.a.getToken();
        int r7 = this.a.getType();
        String r8 = this.a.getSubType();
        boolean r9 = this.a.isWiki();
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_share_lark_view", r6, r7, r8, r9);
        String r10 = this.a.getDocName();
        BaseOpenTencentHandler r11 = this.g;
        if (r11 == null) goto L6;
        String r12 = r11.e();
        if (r12 == null) goto L6;
    L7:
        y.a(r10, r12);
        com.bytedance.ee.bear.share.newshare.b r13 = this.c;
        if (r13 == null) goto L11;
        r13.a();
        return;
    L11:
        return;
    L6:
        r12 = "";
        goto L7
    }

    public final void h() {
        tt5.a.h("BaseShareExternalPresenter", "onSlideExport");
        this.d = ShareType.SlideExport;
        com.bytedance.ee.bear.share.d.e(this.a.getToken(), this.a.getType(), this.a.getSubType(), this.a.isWiki());
        int r0 = g.a;
        g.e("export", a(), this.a);
    }

    public final boolean U10(ShareItemModel r11) {
        Intrinsics.checkNotNullParameter(r11, "shareItem");
        tt5.a.h("BaseShareExternalPresenter", "doShareCustom, itemId: " + r11.getItemId());
        ShareItemModel.a r0 = r11.getOnClickedListener();
        if (r0 == null) goto L52;
        Context r3 = this.b;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L7;
    L29:
        String r5 = this.a.getUrl();
        if (r5.length() != 0) goto L32;
        boolean r7 = true;
    L33:
        if (r7 == false) goto L36;
        r5 = null;
    L36:
        if (r5 != null) goto L38;
        r5 = this.a.getOriginUrl();
    L38:
        t45.c r8 = p.a();
        Integer r9 = Integer.valueOf(this.a.getRealType());
        if (r9.intValue() <= 0) goto L41;
        boolean r10 = true;
    L42:
        if (r10 == true) goto L45;
        r9 = null;
    L45:
        if (r9 == null) goto L47;
        int r12 = r9.intValue();
    L48:
        String r6 = r8.T6(r5, Integer.valueOf(r12));
        if (r6 != null) goto L51;
        r6 = "";
    L51:
        boolean r1 = r0.a(r3, r11, new com.bytedance.ee.bear.share.g(r6, ShareItemUtil.b(this.b, this.a.getDocName(), this.a.getType()), null, null));
    L53:
        if (r1 == false) goto L57;
        this.c.a();
        return true;
    L57:
        if (r11.getType() != null) goto L59;
        r11.getItemId();
        r11.getType();
    L59:
        return false;
    L47:
        r12 = this.a.getType();
        goto L48
    L41:
        r10 = false;
        goto L42
    L32:
        r7 = false;
        goto L33
    L7:
        if (this.a.getType() == sbb.e.v.b) goto L29;
        BaseOpenTencentHandler r13 = this.g;
        if (r13 == null) goto L20;
        r5 = r13.g();
        if (r5.length() != 0) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == false) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L20;
    L14:
        r14 = false;
    L20:
        r5 = this.a.getUrl();
        if (r5.length() != 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L27;
        r5 = null;
    L27:
        if (r5 != null) goto L38;
        r5 = this.a.getOriginUrl();
        goto L38
    L23:
        r15 = false;
        goto L24
    L52:
        r1 = false;
        goto L53
    }

    public void i(com.bytedance.ee.bear.share.export.f r2) {
        Intrinsics.checkNotNullParameter(r2, "shareInfo");
        BaseOpenTencentHandler r0 = this.g;
        if (r0 == null) goto L6;
        r0.c = r2;
        return;
    }

    public void s10(ShareType r4) {
        Intrinsics.checkNotNullParameter(r4, "shareType");
        Intrinsics.checkNotNullParameter(r4, "shareType");
        r4.getItemId();
        switch(b.a[r4.ordinal()]) {
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L39;
            case 8: goto L30;
            case 9: goto L21;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        tt5.a.k("BaseShareExternalPresenter", "doShareToType, not supported shareType: " + r4);
        return;
    L5:
        tt5.a.h("BaseShareExternalPresenter", "onShareMore");
        ShareType r0 = ShareType.More;
        this.d = r0;
        BaseOpenTencentHandler r2 = this.g;
        if (r2 == null) goto L56;
        tt5.a.h("BaseShareExternalPresenter", "onShareMore");
        r2.h(r0);
        if (r2.c != null) goto L10;
        tt5.a.d("BaseShareExternalPresenter", "onShareMore()...mShareInfo is null!");
        return;
    L10:
        r2.b();
        return;
    L56:
        return;
    L11:
        tt5.a.h("BaseShareExternalPresenter", "onCopyText");
        this.d = ShareType.CopyText;
        return;
    L12:
        tt5.a.h("BaseShareExternalPresenter", "onShareToWeibo");
        ShareType r1 = ShareType.Weibo;
        this.d = r1;
        BaseOpenTencentHandler r3 = this.g;
        if (r3 == null) goto L60;
        tt5.a.h("BaseShareExternalPresenter", "onShareToWeibo");
        r3.h(r1);
        if (km5.c.e(r3.b, r1) == true) goto L18;
        return;
    L18:
        if (r3.c != null) goto L20;
        tt5.a.d("BaseShareExternalPresenter", "onShareToWeibo()...mShareInfo is null!");
        return;
    L20:
        r3.d();
        return;
    L60:
        return;
    L21:
        tt5.a.h("BaseShareExternalPresenter", "onShareToQQ");
        ShareType r5 = ShareType.QQ;
        this.d = r5;
        BaseOpenTencentHandler r6 = this.g;
        if (r6 == null) goto L63;
        tt5.a.h("BaseShareExternalPresenter", "onShareToQQ");
        r6.h(r5);
        if (km5.c.e(r6.b, r5) == true) goto L27;
        return;
    L27:
        if (r6.c != null) goto L29;
        tt5.a.d("BaseShareExternalPresenter", "onShareToQQ()...mShareInfo is null!");
        return;
    L29:
        r6.c(r5, "qq");
        return;
    L63:
        return;
    L30:
        tt5.a.h("BaseShareExternalPresenter", "onShareToWechatMoments");
        ShareType r7 = ShareType.WechatMoments;
        this.d = r7;
        BaseOpenTencentHandler r8 = this.g;
        if (r8 == null) goto L66;
        tt5.a.h("BaseShareExternalPresenter", "onShareToWechatMoments");
        r8.h(r7);
        if (km5.c.e(r8.b, r7) == true) goto L36;
        return;
    L36:
        if (r8.c != null) goto L38;
        tt5.a.d("BaseShareExternalPresenter", "onShareToWechatMoments()...mShareInfo is null!");
        return;
    L38:
        r8.c(r7, "wechat_article");
        return;
    L66:
        return;
    L39:
        tt5.a.h("BaseShareExternalPresenter", "onShareToWechat");
        ShareType r9 = ShareType.Wechat;
        this.d = r9;
        BaseOpenTencentHandler r10 = this.g;
        if (r10 == null) goto L69;
        r10.h(r9);
        if (km5.c.e(r10.b, r9) == true) goto L45;
        return;
    L45:
        if (r10.c != null) goto L47;
        tt5.a.d("BaseShareExternalPresenter", "onShareToWechat()...mShareInfo is null!");
        return;
    L47:
        r10.c(r9, "wechat");
        return;
    L69:
        return;
    L48:
        tt5.a.h("BaseShareExternalPresenter", "onDownLoad");
        this.d = ShareType.Download;
        return;
    L49:
        h();
        return;
    L50:
        e();
        return;
    L51:
        tt5.a.h("BaseShareExternalPresenter", "onPasswordLink()...");
        this.d = ShareType.PasswordLink;
        return;
    L52:
        b();
        return;
    L53:
        g();
    }

    public final void c(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "password");
        com.bytedance.ee.bear.share.externalshare.external.handler.b r1 = this.h;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r5, "password");
        if (r4 == true) goto L7;
    L9:
        r1.a(false, r5);
        return;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        com.bytedance.ee.bear.widgets.a r0 = new com.bytedance.ee.bear.widgets.a(r1.a);
        r0.k(r1.b(2131887725));
        r0.g(r1.b(2131887722), new com.bytedance.ee.bear.share.externalshare.external.handler.c(r1, r5));
        r0.g(r1.b(2131887726), new com.bytedance.ee.bear.share.externalshare.external.handler.d(r1, r5));
        r0.b(new com.bytedance.ee.bear.share.externalshare.external.handler.e(r1));
        r0.q();
        String r6 = r1.b.getToken();
        int r7 = r1.b.getType();
        String r2 = r1.b.getSubType();
        boolean r3 = r1.b.isWiki();
        String r8 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r2, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_copy_link_view", r6, r7, r2, r3);
        return;
    }

    public a(ShareParams r8, Context r9, com.bytedance.ee.bear.share.newshare.b r10) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "shareHost");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.f = new ExternalShareMinaConfig();
        ExternalShareMinaConfig r4 = com.bytedance.ee.bear.appsetting.c.a.a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig());
        this.f = r4;
        if (TextUtils.isEmpty(r8.getOriginUrl()) == true) goto L5;
        this.e = p.a().Z(r8.getOriginUrl());
    L5:
        this.g = new BaseOpenTencentHandler(r8, r9, a(), r4, this.e, new BaseShareExternalPresenter$initData$1(this));
        this.h = new com.bytedance.ee.bear.share.externalshare.external.handler.b(r9, r8, this.g, new BaseShareExternalPresenter$initData$2(this));
    }

    public final void xq(ShareType r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "shareType");
        tt5.a.h("BaseShareExternalPresenter", "onCacControlled, shareType: " + r6 + ", token: " + r7 + ", type: " + r8);
        this.d = r6;
        if (r6 != ShareType.ExportImage) goto L13;
        gj5.c r9 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r8, r7);
        if (r9.a == true) goto L13;
        if (r9.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L13;
        tt5.a.h("BaseShareExternalPresenter", "onCacControlled - ExportImage disabled by cac.");
        ValidateResult r10 = r9.c;
        if (r10 == null) goto L16;
        r10.handleAction();
        return;
    L16:
        return;
    L13:
        if (r8 == 12) goto L17;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r8, "");
        return;
    }
}
