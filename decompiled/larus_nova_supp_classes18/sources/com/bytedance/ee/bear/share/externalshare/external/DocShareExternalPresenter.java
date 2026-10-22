package com.bytedance.ee.bear.share.externalshare.external;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.share.SharePlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.external.AdjustExternalResult;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.secret.b0;
import com.bytedance.ee.bear.middleground.permission.secret.p;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.h;
import com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler;
import com.bytedance.ee.bear.share.externalshare.external.handler.m;
import com.bytedance.ee.bear.share.externalshare.external.handler.n;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import jg5.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DocShareExternalPresenter extends com.bytedance.ee.bear.share.externalshare.external.a implements th5.a {
    public final ShareParams i;
    public final com.bytedance.ee.bear.share.newshare.b j;
    public ShareDocInfo k;
    public final h l;
    public List<SecretLevel> m;
    public Disposable n;
    public Disposable o;
    public final m p;
    public final com.bytedance.ee.bear.share.externalshare.external.handler.f q;
    public boolean r;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[ShareType.More.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[ShareType.PasswordLink.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[ShareType.ExportImage.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[ShareType.CopyLink.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[ShareType.Lark.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[ShareType.SlideExport.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DocShareExternalPresenter a;

        public c(DocShareExternalPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            VisibleSecretResult r4 = (VisibleSecretResult) r3;
            Intrinsics.checkNotNullParameter(r4, "visibleSecretResult");
            tt5.a.h("DocShareExternalPresenter", "fetchVisibleSecret()...visibleSecretResult = " + r4);
            this.a.m = (List) ((Result) r4).data;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.h("DocShareExternalPresenter", "fetchVisibleSecret()...error = " + r4);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void d() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        j.j = null;
        Disposable r0 = this.o;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void f() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        j.j = new WeakReference(this);
    }

    public final void k() {
        tt5.a.h("DocShareExternalPresenter", "fetchVisibleSecret()...");
        Disposable r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        Disposable r2 = this.n;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        j r3 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        ShareDocInfo r4 = this.k;
        String r5 = r4.c;
        int r6 = r4.getType();
        r3.getClass();
        this.n = p.a(r5, r6).subscribe(new c(this), d.a);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final com.bytedance.ee.bear.share.export.f a() {
        return this.k;
    }

    public static final boolean j(DocShareExternalPresenter r3) {
        if (r3.m != null) goto L5;
        r3.k();
        return false;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        List<SecretLevel> r1 = r3.m;
        ShareType r4 = r3.d;
        if (r4 != null) goto L9;
        r4 = ShareType.PasswordLink;
    L9:
        return hu5.a.f(b0.c(r1, g.d(r4), EntityType.LINK_SHARE_ANYONE_READABLE));
    }

    public final boolean Yl(ShareType r23) {
        Intrinsics.checkNotNullParameter(r23, "shareType");
        this.d = r23;
        boolean r8 = false;
        switch(b.a[r23.ordinal()]) {
            case 1: goto L64;
            case 2: goto L64;
            case 3: goto L64;
            case 4: goto L64;
            case 5: goto L64;
            case 6: goto L29;
            case 7: goto L5;
            default: goto L116;
        };
    L5:
        com.bytedance.ee.bear.share.externalshare.external.handler.f r3 = this.q;
        if (r3 != null) goto L8;
        Intrinsics.checkNotNullParameter(r23, "shareType");
        return true;
    L8:
        if (r3.b.getType() != 125) goto L10;
        tt5.a.b("DocExportImageHandler", "canExportImage... doubao conversation, skip ccm export guard");
    L113:
        r8 = true;
    L120:
        return r8;
    L10:
        ShareDocInfo r1 = r3.a;
        if (r1 == null) goto L25;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L17;
        PermissionResponse r2 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new UniBaseEntity(r1.c, sbb.e.d(r1.getType()), BizDomain.FileBizDomainCCM, r1.a(), r1.d(), null, null, null, null, 480, null), "EXPORT"), null);
        r2.getCallback().a(eu5.b.a, r2);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r2) == false) goto L25;
        r3.d.invoke();
        goto L120
    L17:
        int r6 = com.bytedance.ee.bear.share.h.a;
        if (r1.getType() == 125) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L25;
        String r5 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).a(r1.c, r1.getType(), "CCM_EXPORT", "", r1.a());
        if (TextUtils.isEmpty(r5) == true) goto L25;
        Toast.showFailureText(eu5.b.a, r5);
        r3.d.invoke();
        goto L120
    L20:
        r4 = false;
    L25:
        tt5.a.b("DocExportImageHandler", "onExportImage... triggered with status: " + CipherManager.d());
        if (CipherManager.d() != 1) goto L113;
        Context r7 = r3.c;
        Toast.showText(r7, r7.getString(2131887299), 1);
        CipherManager.h();
        r3.d.invoke();
        goto L120
    L29:
        m r9 = this.p;
        if (r9 == null) goto L63;
        Function0<Boolean> r10 = new DocShareExternalPresenter$canShareToType$1(this);
        Intrinsics.checkNotNullParameter(r10, "checkUsableSecret");
        ShareDocInfo r11 = r9.b;
        if (r11 == null) goto L113;
        IDocPublicPermission r12 = r11.g;
        if (r12.isLinkShareAnyoneRead() == true) goto L113;
        if (r12.isLinkShareAnyoneEdit() == true) goto L113;
        if (r12.isLinkShareAnyoneRead() == true) goto L48;
        if (r12.isLinkShareAnyoneEdit() == true) goto L48;
        if (r12.getLinkShareAnyoneReadBlockValue() != 0) goto L45;
    L46:
        int r13 = n.a;
        n.h(r11, ShareType.PasswordLink, r9.c, r9.a);
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r12.getReportJson());
        goto L120
    L45:
        if (r12.getLinkShareAnyoneReadBlockValue() == 3) goto L46;
    L48:
        if (r12.getLinkShareAnyoneReadBlockValue() != 5) goto L55;
        if (((Boolean) r10.invoke()).booleanValue() == false) goto L52;
        int r14 = n.a;
        n.h(r11, ShareType.PasswordLink, r9.c, r9.a);
    L53:
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r12.getReportJson());
        goto L120
    L52:
        Toast.showFailureText(r9.a, 2131887387);
        goto L53
    L55:
        if (r12.adminCanCross() == true) goto L58;
        Toast.showFailureText(r9.a, 2131887246);
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r12.getReportJson());
        goto L120
    L58:
        if (r9.c.isWiki() == true) goto L60;
    L62:
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r12.getReportJson());
        goto L113
    L60:
        if (r12.getLinkShareAnyoneReadBlockValue() != 1) goto L62;
        Toast.showFailureText(r9.a, 2131887282);
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r12.getReportJson());
        goto L120
    L63:
        Intrinsics.checkNotNullParameter(r23, "shareType");
        return true;
    L64:
        BaseOpenTencentHandler r15 = this.g;
        if ((r15 instanceof com.bytedance.ee.bear.share.externalshare.external.handler.g) == false) goto L67;
        com.bytedance.ee.bear.share.externalshare.external.handler.g r16 = (com.bytedance.ee.bear.share.externalshare.external.handler.g) r15;
    L68:
        if (r16 == null) goto L115;
        Intrinsics.checkNotNullParameter(r23, "shareType");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.i() == false) goto L86;
        ShareDocInfo r17 = r16.g;
        if (r17 == null) goto L83;
        boolean r18 = r17.f.isFullAccess();
        if (r17.isLinkShareAnyoneRead() == false) goto L76;
    L79:
        boolean r19 = true;
    L80:
        if (r18 == true) goto L83;
        if (r19 == true) goto L83;
        boolean r20 = true;
    L84:
        if (r20 == false) goto L86;
        Toast.showFailureText(r16.getContext(), 2131888785);
        goto L120
    L76:
        if (r17.isLinkShareAnyoneEdit() == true) goto L79;
        r19 = false;
    L83:
        r20 = false;
    L86:
        int r21 = n.a;
        if (n.c(r16.g, r16.a) == false) goto L113;
        ShareDocInfo r22 = r16.g;
        if (r22 == null) goto L113;
        IDocPublicPermission r24 = r22.g;
        if (r24 == null) goto L113;
        if (r24.isLinkShareAnyoneRead() == true) goto L113;
        if (r24.isLinkShareAnyoneEdit() == true) goto L113;
        if (r24.getLinkShareAnyoneReadBlockValue() != 0) goto L103;
    L112:
        n.h(r22, r23, r16.a, r16.getContext());
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...linkShareAnyOneRead block_value = " + r24.getLinkShareAnyoneReadBlockValue());
        goto L120
    L103:
        if (r24.getLinkShareAnyoneReadBlockValue() == 3) goto L112;
        if (r24.getLinkShareAnyoneReadBlockValue() == 5) goto L108;
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...use default share, block_value = " + r24.getLinkShareAnyoneReadBlockValue());
        goto L113
    L108:
        if (((Boolean) r16.i.invoke()).booleanValue() == false) goto L110;
        n.h(r22, r23, r16.a, r16.getContext());
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...linkShareAnyOneRead block_value = " + r24.getLinkShareAnyoneReadBlockValue());
        goto L120
    L110:
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...no usable secret, use default share.");
        goto L113
    L115:
        Intrinsics.checkNotNullParameter(r23, "shareType");
        return true;
    L67:
        r16 = null;
        goto L68
    L116:
        Intrinsics.checkNotNullParameter(r23, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void i(com.bytedance.ee.bear.share.export.f r11) {
        Intrinsics.checkNotNullParameter(r11, "shareInfo");
        super.i(r11);
        com.bytedance.ee.bear.share.externalshare.external.handler.g r1 = null;
        if ((r11 instanceof ShareDocInfo) == false) goto L5;
        ShareDocInfo r12 = (ShareDocInfo) r11;
    L6:
        if (r12 != null) goto L8;
        r12 = new ShareDocInfo(0, null, null, null, null, null, 1023);
    L8:
        this.k = r12;
        com.bytedance.ee.bear.share.externalshare.external.handler.f r0 = this.q;
        if (r0 == null) goto L11;
        r0.a = r12;
    L11:
        BaseOpenTencentHandler r2 = this.g;
        if ((r2 instanceof com.bytedance.ee.bear.share.externalshare.external.handler.g) == false) goto L14;
        r1 = (com.bytedance.ee.bear.share.externalshare.external.handler.g) r2;
    L14:
        if (r1 == null) goto L16;
        r1.g = r12;
    L16:
        if (r0 == null) goto L18;
        r0.a = r12;
    L18:
        m r3 = this.p;
        if (r3 == null) goto L22;
        r3.b = r12;
        return;
    L22:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // th5.a
    public final void rU(int r3) {
        tt5.a.h("DocShareExternalPresenter", "onAdjustExternalFinished()...result = " + r3);
        if (r3 == AdjustExternalResult.SUCCESS.getValue()) goto L5;
        return;
    L5:
        if (this.d != ShareType.PasswordLink) goto L7;
        boolean r4 = true;
    L8:
        this.r = r4;
        Disposable r5 = this.o;
        if (r5 == null) goto L11;
        r5.dispose();
    L11:
        this.o = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().b(this.i.getToken(), this.i.getType()).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.share.externalshare.external.b(this), new com.bytedance.ee.bear.share.externalshare.external.c(this));
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void s10(ShareType r5) {
        Intrinsics.checkNotNullParameter(r5, "shareType");
        Intrinsics.checkNotNullParameter(r5, "shareType");
        r5.getItemId();
        switch(b.a[r5.ordinal()]) {
            case 6: goto L26;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r5);
        return;
    L5:
        h();
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).i();
        this.j.a();
        return;
    L6:
        com.bytedance.ee.bear.document.share.a.a r6 = this.l;
        if (r6 == null) goto L9;
        SharePlugin.c r7 = r6.c.d;
    L9:
        g();
        return;
    L10:
        b();
        c(this.k.g.hasLinkPassword(), this.k.g.linkPassword());
        return;
    L11:
        e();
        com.bytedance.ee.bear.share.externalshare.external.handler.f r8 = this.q;
        if (r8 != null) goto L14;
        return;
    L14:
        if (r8.b.getType() != 3) goto L17;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).i();
    L25:
        r8.d.invoke();
        return;
    L17:
        if (r8.b.getType() != 28) goto L19;
    L22:
        tt5.a.b("DocExportImageHandler", "onExportImage... for " + r8.b.getType());
        Runnable r0 = r8.b.getExportImageRunnable();
        if (r0 == null) goto L25;
        r0.run();
        goto L25
    L19:
        if (r8.b.getType() == 125) goto L22;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m("ExportImage");
        goto L25
    L26:
        tt5.a.h("BaseShareExternalPresenter", "onPasswordLink()...");
        this.d = ShareType.PasswordLink;
        m r9 = this.p;
        if (r9 == null) goto L36;
        int r1 = m.f;
        r9.a(false);
        return;
    }

    public DocShareExternalPresenter(ShareParams r14, Context r15, com.bytedance.ee.bear.share.newshare.b r16, ShareDocInfo r17, h r18) {
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "shareHost");
        Intrinsics.checkNotNullParameter(r17, "shareInfo");
        super(r14, r15, r16);
        this.i = r14;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        k();
        ShareDocInfo r4 = this.k;
        this.g = new com.bytedance.ee.bear.share.externalshare.external.handler.g(r14, r15, r4, this.f, this.e, r4.g, new AnonymousClass1(this), new AnonymousClass2(this));
        ShareDocInfo r3 = this.k;
        BaseOpenTencentHandler r5 = this.g;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable_pro_add_to_new_share_panel") == false) goto L23;
        Boolean r1 = r14.isPro();
        boolean r2 = false;
        if (r1 == null) goto L7;
        boolean r6 = r1.booleanValue();
    L8:
        Boolean r7 = r14.isProAccessConfigBindRole();
        if (r7 == null) goto L11;
        boolean r8 = r7.booleanValue();
    L12:
        IDocPublicPermission r9 = this.k.g;
        if (r9 != null) goto L15;
    L17:
        if (r2 == false) goto L23;
        if (r6 == false) goto L23;
        if (r8 == false) goto L21;
        int r10 = 2131886154;
    L22:
        String r11 = r15.getString(r10);
    L24:
        this.p = new m(r15, r3, r14, r5, r11);
        this.q = new com.bytedance.ee.bear.share.externalshare.external.handler.f(this.k, r14, r15, new AnonymousClass3(this));
        return;
    L21:
        r10 = 2131886198;
        goto L22
    L15:
        if (r9.isLinkShareClose() == true) goto L17;
        r2 = true;
        goto L17
    L11:
        r8 = false;
        goto L12
    L7:
        r6 = false;
    L23:
        r11 = null;
        goto L24
    }

    @Override // th5.a
    public final void QQ(qe5.e.c r12, qe5.e.b r13, SecretApprovalInstanceModel r14, SecretApprovalDefModel r15, SecretLevel r16, SecretLevel r17) {
        Intrinsics.checkNotNullParameter(r14, "secretApprovalInstanceModel");
        Intrinsics.checkNotNullParameter(r15, "secretApprovalDefModel");
        Intrinsics.checkNotNullParameter(r16, "targetSecretLevel");
        Intrinsics.checkNotNullParameter(r17, "originSecretLevel");
        tt5.a.h("DocShareExternalPresenter", "notifyShowSecLabelResubmitApprovalDialog()...");
        if (this.j.p0() == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).l5(this.i.getActivity(), this.k.getType(), r12, r13, r14, r15, r16, r17);
        return;
    }

    @Override // th5.a
    public final void sJ(String r16, int r17, String r18, String r19, int r20, String r21, String r22, SecretLevel r23, SecretApprovalDefModel r24, Map<String, ? extends Serializable> r25, SecretLevel r26) {
        Intrinsics.checkNotNullParameter(r16, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "secLabelId");
        Intrinsics.checkNotNullParameter(r19, "secLabelName");
        Intrinsics.checkNotNullParameter(r21, "applyTips");
        Intrinsics.checkNotNullParameter(r22, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r23, "oldSecretLevel");
        Intrinsics.checkNotNullParameter(r24, "defModel");
        tt5.a.h("DocShareExternalPresenter", "notifyShowSecretApprovalDialog()...");
        if (this.j.p0() == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).ad(this.i.getActivity(), r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        return;
    }
}
