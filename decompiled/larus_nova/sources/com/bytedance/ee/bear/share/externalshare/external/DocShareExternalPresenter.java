package com.bytedance.ee.bear.share.externalshare.external;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
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
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
public final class DocShareExternalPresenter extends com.bytedance.ee.bear.share.externalshare.external.a implements th5.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ShareParams f237024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.ee.bear.share.newshare.b f237025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ShareDocInfo f237026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f237027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<SecretLevel> f237028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f237029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f237030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m f237031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.ee.bear.share.externalshare.external.handler.f f237032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f237033r;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f237034a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            r100[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[ShareType.More.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[ShareType.PasswordLink.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[ShareType.ExportImage.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[ShareType.CopyLink.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[ShareType.Lark.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[ShareType.SlideExport.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f237034a = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocShareExternalPresenter f237035a;

        public c(DocShareExternalPresenter r100) {
            this.f237035a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            VisibleSecretResult r101 = (VisibleSecretResult) r100;
            Intrinsics.checkNotNullParameter(r101, "visibleSecretResult");
            tt5.a.h("DocShareExternalPresenter", "fetchVisibleSecret()...visibleSecretResult = " + r101);
            this.f237035a.f237028m = (List) r101.data;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f237036a = null;

        static {
            f237036a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.h("DocShareExternalPresenter", "fetchVisibleSecret()...error = " + r101);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void d() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        j.f499016j = null;
        Disposable r100 = this.f237030o;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void f() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        j.f499016j = new WeakReference(this);
    }

    public final void k() {
        tt5.a.h("DocShareExternalPresenter", "fetchVisibleSecret()...");
        Disposable r100 = this.f237029n;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        Disposable r102 = this.f237029n;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        j r103 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        ShareDocInfo r104 = this.f237026k;
        String r105 = r104.f234244c;
        int r106 = r104.getType();
        r103.getClass();
        this.f237029n = p.a(r105, r106).subscribe(new c(this), d.f237036a);
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final com.bytedance.ee.bear.share.export.f a() {
        return this.f237026k;
    }

    public static final boolean j(DocShareExternalPresenter r100) {
        if (r100.f237028m != null) goto L5;
        r100.k();
        return false;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r101 = jg5.e.a.f499003a;
        List<SecretLevel> r102 = r100.f237028m;
        ShareType r103 = r100.f237046d;
        if (r103 != null) goto L9;
        r103 = ShareType.PasswordLink;
    L9:
        return hu5.a.f(b0.c(r102, g.d(r103), EntityType.LINK_SHARE_ANYONE_READABLE));
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r210) {
        Intrinsics.checkNotNullParameter(r210, "shareType");
        this.f237046d = r210;
        boolean r100 = false;
        switch(b.f237034a[r210.ordinal()]) {
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
        com.bytedance.ee.bear.share.externalshare.external.handler.f r101 = this.f237032q;
        if (r101 != null) goto L8;
        Intrinsics.checkNotNullParameter(r210, "shareType");
        return true;
    L8:
        if (r101.f237086b.getType() != 125) goto L10;
        tt5.a.b("DocExportImageHandler", "canExportImage... doubao conversation, skip ccm export guard");
    L113:
        r100 = true;
    L120:
        return r100;
    L10:
        ShareDocInfo r102 = r101.f237085a;
        if (r102 == null) goto L25;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L17;
        PermissionResponse r103 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new UniBaseEntity(r102.f234244c, sbb.e.d(r102.getType()), BizDomain.FileBizDomainCCM, r102.a(), r102.d(), null, null, null, null, 480, null), "EXPORT"), null);
        r103.getCallback().a(eu5.b.f474075a, r103);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r103) == false) goto L25;
        r101.f237088d.invoke();
        goto L120
    L17:
        int r104 = com.bytedance.ee.bear.share.h.f237124a;
        if (r102.getType() == 125) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L25;
        String r106 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).a(r102.f234244c, r102.getType(), "CCM_EXPORT", "", r102.a());
        if (TextUtils.isEmpty(r106) == true) goto L25;
        Toast.showFailureText(eu5.b.f474075a, r106);
        r101.f237088d.invoke();
        goto L120
    L20:
        r105 = false;
    L25:
        tt5.a.b("DocExportImageHandler", "onExportImage... triggered with status: " + CipherManager.d());
        if (CipherManager.d() != 1) goto L113;
        Context r107 = r101.f237087c;
        Toast.showText(r107, r107.getString(R.string.CreationMobile_ECM_ShareSecuritySettingKAToast), 1);
        CipherManager.h();
        r101.f237088d.invoke();
        goto L120
    L29:
        m r108 = this.f237031p;
        if (r108 == null) goto L63;
        Function0<Boolean> r109 = new DocShareExternalPresenter$canShareToType$1(this);
        Intrinsics.checkNotNullParameter(r109, "checkUsableSecret");
        ShareDocInfo r110 = r108.f237107b;
        if (r110 == null) goto L113;
        IDocPublicPermission r111 = r110.f234248g;
        if (r111.isLinkShareAnyoneRead() == true) goto L113;
        if (r111.isLinkShareAnyoneEdit() == true) goto L113;
        if (r111.isLinkShareAnyoneRead() == true) goto L48;
        if (r111.isLinkShareAnyoneEdit() == true) goto L48;
        if (r111.getLinkShareAnyoneReadBlockValue() != 0) goto L45;
    L46:
        int r112 = n.f237111a;
        n.h(r110, ShareType.PasswordLink, r108.f237108c, r108.f237106a);
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r111.getReportJson());
        goto L120
    L45:
        if (r111.getLinkShareAnyoneReadBlockValue() == 3) goto L46;
    L48:
        if (r111.getLinkShareAnyoneReadBlockValue() != 5) goto L55;
        if (r109.invoke().booleanValue() == false) goto L52;
        int r113 = n.f237111a;
        n.h(r110, ShareType.PasswordLink, r108.f237108c, r108.f237106a);
    L53:
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r111.getReportJson());
        goto L120
    L52:
        Toast.showFailureText(r108.f237106a, R.string.CreationMobile_SecureLabel_PermSettings_RestrictedSelect);
        goto L53
    L55:
        if (r111.adminCanCross() == true) goto L58;
        Toast.showFailureText(r108.f237106a, R.string.CreationMobile_ECM_AdminDisableToast);
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r111.getReportJson());
        goto L120
    L58:
        if (r108.f237108c.isWiki() == true) goto L60;
    L62:
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r111.getReportJson());
        goto L113
    L60:
        if (r111.getLinkShareAnyoneReadBlockValue() != 1) goto L62;
        Toast.showFailureText(r108.f237106a, R.string.CreationMobile_ECM_Permission_SpaceAdmin_tooltips);
        tt5.a.h("OpenPasswordLinkHandler", "canOpenPasswordLink()...publicPerm " + r111.getReportJson());
        goto L120
    L63:
        Intrinsics.checkNotNullParameter(r210, "shareType");
        return true;
    L64:
        BaseOpenTencentHandler r114 = this.f237049g;
        if ((r114 instanceof com.bytedance.ee.bear.share.externalshare.external.handler.g) == false) goto L67;
        com.bytedance.ee.bear.share.externalshare.external.handler.g r115 = (com.bytedance.ee.bear.share.externalshare.external.handler.g) r114;
    L68:
        if (r115 == null) goto L115;
        Intrinsics.checkNotNullParameter(r210, "shareType");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.i() == false) goto L86;
        ShareDocInfo r116 = r115.f237089g;
        if (r116 == null) goto L83;
        boolean r117 = r116.f234247f.isFullAccess();
        if (r116.isLinkShareAnyoneRead() == false) goto L76;
    L79:
        boolean r118 = true;
    L80:
        if (r117 == true) goto L83;
        if (r118 == true) goto L83;
        boolean r119 = true;
    L84:
        if (r119 == false) goto L86;
        Toast.showFailureText(r115.getContext(), R.string.LarkCCM_CM_Mobile_ExSharing_TurnOnSwitchToViewOrEdit_Toast);
        goto L120
    L76:
        if (r116.isLinkShareAnyoneEdit() == true) goto L79;
        r118 = false;
    L83:
        r119 = false;
    L86:
        int r120 = n.f237111a;
        if (n.c(r115.f237089g, r115.f237059a) == false) goto L113;
        ShareDocInfo r121 = r115.f237089g;
        if (r121 == null) goto L113;
        IDocPublicPermission r122 = r121.f234248g;
        if (r122 == null) goto L113;
        if (r122.isLinkShareAnyoneRead() == true) goto L113;
        if (r122.isLinkShareAnyoneEdit() == true) goto L113;
        if (r122.getLinkShareAnyoneReadBlockValue() != 0) goto L103;
    L112:
        n.h(r121, r210, r115.f237059a, r115.getContext());
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...linkShareAnyOneRead block_value = " + r122.getLinkShareAnyoneReadBlockValue());
        goto L120
    L103:
        if (r122.getLinkShareAnyoneReadBlockValue() == 3) goto L112;
        if (r122.getLinkShareAnyoneReadBlockValue() == 5) goto L108;
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...use default share, block_value = " + r122.getLinkShareAnyoneReadBlockValue());
        goto L113
    L108:
        if (r115.f237091i.invoke().booleanValue() == false) goto L110;
        n.h(r121, r210, r115.f237059a, r115.getContext());
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...linkShareAnyOneRead block_value = " + r122.getLinkShareAnyoneReadBlockValue());
        goto L120
    L110:
        tt5.a.h("DocOpenTencentHandler", "canPassLinkShareGuard()...no usable secret, use default share.");
        goto L113
    L115:
        Intrinsics.checkNotNullParameter(r210, "shareType");
        return true;
    L67:
        r115 = null;
        goto L68
    L116:
        Intrinsics.checkNotNullParameter(r210, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void i(com.bytedance.ee.bear.share.export.f r110) {
        Intrinsics.checkNotNullParameter(r110, "shareInfo");
        super.i(r110);
        com.bytedance.ee.bear.share.externalshare.external.handler.g r100 = null;
        if ((r110 instanceof ShareDocInfo) == false) goto L5;
        ShareDocInfo r111 = (ShareDocInfo) r110;
    L6:
        if (r111 != null) goto L8;
        r111 = new ShareDocInfo(0, null, null, null, null, null, 1023);
    L8:
        this.f237026k = r111;
        com.bytedance.ee.bear.share.externalshare.external.handler.f r101 = this.f237032q;
        if (r101 == null) goto L11;
        r101.f237085a = r111;
    L11:
        BaseOpenTencentHandler r102 = this.f237049g;
        if ((r102 instanceof com.bytedance.ee.bear.share.externalshare.external.handler.g) == false) goto L14;
        r100 = (com.bytedance.ee.bear.share.externalshare.external.handler.g) r102;
    L14:
        if (r100 == null) goto L16;
        r100.f237089g = r111;
    L16:
        if (r101 == null) goto L18;
        r101.f237085a = r111;
    L18:
        m r103 = this.f237031p;
        if (r103 == null) goto L22;
        r103.f237107b = r111;
        return;
    L22:
        return;
    L5:
        r111 = null;
        goto L6
    }

    @Override // th5.a
    public final void rU(int r100) {
        tt5.a.h("DocShareExternalPresenter", "onAdjustExternalFinished()...result = " + r100);
        if (r100 == AdjustExternalResult.SUCCESS.getValue()) goto L5;
        return;
    L5:
        if (this.f237046d != ShareType.PasswordLink) goto L7;
        boolean r101 = true;
    L8:
        this.f237033r = r101;
        Disposable r102 = this.f237030o;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f237030o = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().b(this.f237024i.getToken(), this.f237024i.getType()).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.share.externalshare.external.b(this), new com.bytedance.ee.bear.share.externalshare.external.c(this));
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a, com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        Intrinsics.checkNotNullParameter(r100, "shareType");
        r100.getItemId();
        switch(b.f237034a[r100.ordinal()]) {
            case 6: goto L26;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r100);
        return;
    L5:
        h();
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).i();
        this.f237025j.a();
        return;
    L6:
        h r101 = this.f237027l;
        if (r101 == null) goto L9;
        SharePlugin.c r102 = ((com.bytedance.ee.bear.document.share.a.C3158a) r101).f221771c.f221765d;
    L9:
        g();
        return;
    L10:
        b();
        c(this.f237026k.f234248g.hasLinkPassword(), this.f237026k.f234248g.linkPassword());
        return;
    L11:
        e();
        com.bytedance.ee.bear.share.externalshare.external.handler.f r103 = this.f237032q;
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.f237086b.getType() != 3) goto L17;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).i();
    L25:
        r103.f237088d.invoke();
        return;
    L17:
        if (r103.f237086b.getType() != 28) goto L19;
    L22:
        tt5.a.b("DocExportImageHandler", "onExportImage... for " + r103.f237086b.getType());
        Runnable r104 = r103.f237086b.getExportImageRunnable();
        if (r104 == null) goto L25;
        r104.run();
        goto L25
    L19:
        if (r103.f237086b.getType() == 125) goto L22;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m("ExportImage");
        goto L25
    L26:
        tt5.a.h("BaseShareExternalPresenter", "onPasswordLink()...");
        this.f237046d = ShareType.PasswordLink;
        m r105 = this.f237031p;
        if (r105 == null) goto L36;
        int r106 = m.f237105f;
        r105.a(false);
        return;
    }

    public DocShareExternalPresenter(ShareParams r110, Context r111, com.bytedance.ee.bear.share.newshare.b r112, ShareDocInfo r113, h r114) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "shareHost");
        Intrinsics.checkNotNullParameter(r113, "shareInfo");
        super(r110, r111, r112);
        this.f237024i = r110;
        this.f237025j = r112;
        this.f237026k = r113;
        this.f237027l = r114;
        k();
        ShareDocInfo r100 = this.f237026k;
        this.f237049g = new com.bytedance.ee.bear.share.externalshare.external.handler.g(r110, r111, r100, this.f237048f, this.f237047e, r100.f234248g, new AnonymousClass1(this), new AnonymousClass2(this));
        ShareDocInfo r101 = this.f237026k;
        BaseOpenTencentHandler r102 = this.f237049g;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable_pro_add_to_new_share_panel") == false) goto L23;
        Boolean r103 = r110.isPro();
        boolean r104 = false;
        if (r103 == null) goto L7;
        boolean r105 = r103.booleanValue();
    L8:
        Boolean r106 = r110.isProAccessConfigBindRole();
        if (r106 == null) goto L11;
        boolean r107 = r106.booleanValue();
    L12:
        IDocPublicPermission r108 = this.f237026k.f234248g;
        if (r108 != null) goto L15;
    L17:
        if (r104 == false) goto L23;
        if (r105 == false) goto L23;
        if (r107 == false) goto L21;
        int r109 = R.string.Bitable_AdvancedPermission_Enabled_Desc;
    L22:
        String r115 = r111.getString(r109);
    L24:
        this.f237031p = new m(r111, r101, r110, r102, r115);
        this.f237032q = new com.bytedance.ee.bear.share.externalshare.external.handler.f(this.f237026k, r110, r111, new AnonymousClass3(this));
        return;
    L21:
        r109 = R.string.Bitable_AdvancedPermission_SomeCantAccess_Desc;
        goto L22
    L15:
        if (r108.isLinkShareClose() == true) goto L17;
        r104 = true;
        goto L17
    L11:
        r107 = false;
        goto L12
    L7:
        r105 = false;
    L23:
        r115 = null;
        goto L24
    }

    @Override // th5.a
    public final void QQ(qe5.e.c r110, qe5.e.b r111, SecretApprovalInstanceModel r112, SecretApprovalDefModel r113, SecretLevel r114, SecretLevel r115) {
        Intrinsics.checkNotNullParameter(r112, "secretApprovalInstanceModel");
        Intrinsics.checkNotNullParameter(r113, "secretApprovalDefModel");
        Intrinsics.checkNotNullParameter(r114, "targetSecretLevel");
        Intrinsics.checkNotNullParameter(r115, "originSecretLevel");
        tt5.a.h("DocShareExternalPresenter", "notifyShowSecLabelResubmitApprovalDialog()...");
        if (this.f237025j.p0() == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).l5(this.f237024i.getActivity(), this.f237026k.getType(), r110, r111, r112, r113, r114, r115);
        return;
    }

    @Override // th5.a
    public final void sJ(String r110, int r111, String r112, String r113, int r210, String r211, String r212, SecretLevel r213, SecretApprovalDefModel r214, Map<String, ? extends Serializable> r215, SecretLevel r216) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "secLabelId");
        Intrinsics.checkNotNullParameter(r113, "secLabelName");
        Intrinsics.checkNotNullParameter(r211, "applyTips");
        Intrinsics.checkNotNullParameter(r212, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r213, "oldSecretLevel");
        Intrinsics.checkNotNullParameter(r214, "defModel");
        tt5.a.h("DocShareExternalPresenter", "notifyShowSecretApprovalDialog()...");
        if (this.f237025j.p0() == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).ad(this.f237024i.getActivity(), r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216);
        return;
    }
}
