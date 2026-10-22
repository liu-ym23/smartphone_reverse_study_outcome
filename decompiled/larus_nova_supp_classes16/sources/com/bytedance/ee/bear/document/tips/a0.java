package com.bytedance.ee.bear.document.tips;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocShareUserInfo;
import com.bytedance.ee.bear.document.DocTipsLayout;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.document.w1;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.bytedance.ee.bear.facade.common.widget.ErrorTipsView;
import com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView;
import com.bytedance.ee.bear.facade.common.widget.TemplateTagTipsView;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.templates.TemplateViewModel;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0 implements LifecycleObserver, TemplateTagTipsView.e, SecretSetBannerView.b, TitleBar.a {
    public final PluginHost a;
    public final com.bytedance.ee.bear.browser.plugin.t b;
    public final DocViewModel c;
    public final boolean d;
    public final DocTipsLayout e;
    public final b f;
    public String g;
    public boolean h;
    public boolean i;
    public final CompositeDisposable j;
    public com.bytedance.ee.bear.document.tips.a k;
    public final int l;
    public boolean m;
    public final boolean n;
    public boolean o;
    public boolean p;

    public class a implements ax4.e<ShareUserInfoResult> {
        public final /* synthetic */ a0 a;

        public a(a0 r1) {
            this.a = r1;
        }

        @Override // ax4.e
        public final void onFailed(Throwable r4) {
            a0 r5 = this.a;
            r5.p = false;
            r5.c.getmDocShareInfo().setValue(new DocShareUserInfo(false, new ShareUserInfoResult()));
        }

        @Override // ax4.e
        public final void onSuccess(ShareUserInfoResult r4) {
            a0 r0 = this.a;
            r0.p = false;
            r0.c.getmDocShareInfo().setValue(new DocShareUserInfo(true, r4));
        }
    }

    public static class b implements com.bytedance.ee.bear.notification.a.a {
        public final WeakReference<a0> a;

        public b(a0 r2) {
            this.a = new WeakReference(r2);
        }

        public final void closeNotification(String r3) {
            a0 r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            final DocTipsLayout r1 = r0.e;
            if (TextUtils.equals(r3, r1.getNotificationView().g()) == false) goto L9;
            r1.post(new c0(r1));
            return;
        }

        public final void showNotification(final String r11, List<String> r12, final String r13) {
            final a0 r4 = this.a.get();
            if (r4 != null) goto L5;
            return;
        L5:
            PluginHost r0 = r4.a;
            if (r0.isDestroyed() == false) goto L8;
            return;
        L8:
            final y3 r9 = ((e4) r0.getHostAbility(e4.class)).getDocumentMetadata();
            final DocTipsLayout r1 = r4.e;
            final com.bytedance.ee.bear.notification.a.b r8 = r1.getNotificationView();
            String r2 = s45.p.a().Z(r9.getUrl()).a;
            Iterator<String> r14 = r12.iterator();
        L9:
            final boolean r3 = true;
            if (r14.hasNext() == false) goto L14;
            if (TextUtils.equals(r2, r14.next()) == false) goto L9;
            boolean r16 = true;
        L16:
            if (r9.isAnnounceDoc() == true) goto L19;
            if (r16 == false) goto L19;
        L20:
            r1.post(new d0(this, r3, r4, r1, r11, r13, r8, r9));
            return;
        L19:
            r3 = false;
            goto L20
        L14:
            r16 = false;
            goto L16
        }
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
    public final void a() {
        com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        s45.h r1 = s45.g.a;
        r0.u5(s45.g.a.a("secret_banner_help_center", "991220891340", "150212615307", null));
        DocumentInfo r2 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.c == null) goto L10;
        com.bytedance.ee.bear.middleground.permission.c.N(r2.getDocMetaInfo().isSecretAdminDefault(), "know_detail", "none");
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
    public final void b() {
        DocViewModel r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        DocumentInfo r1 = (DocumentInfo) r0.liveDocumentInfoData().getValue();
        if (r1 != null) goto L8;
        return;
    L8:
        DocMetaInfo r2 = r1.getDocMetaInfo();
        if (r2 != null) goto L11;
        return;
    L11:
        com.bytedance.ee.bear.middleground.permission.secret.c0 r9 = new com.bytedance.ee.bear.middleground.permission.secret.c0(this.c.getToken(), r1.getType(), r2.getRecommendLabelId(), "", "", -1);
        ((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.secret.d.class)).b(r9).subscribe(new w(this), new x(this));
        if (r2.isRecommendMark() == false) goto L15;
        com.bytedance.ee.bear.middleground.permission.c.G(fj5.a.d(r1.getDocMetaInfo(), r1.getDocPermission().a), TipCallBackData.CONFIRM);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
    public final void c() {
        DocViewModel r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        DocumentInfo r1 = (DocumentInfo) r0.liveDocumentInfoData().getValue();
        if (r1 != null) goto L8;
        return;
    L8:
        DocMetaInfo r2 = r1.getDocMetaInfo();
        if (r2 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r2.getRecommendLabelId()) == true) goto L14;
        String r3 = r2.getRecommendLabelId();
    L15:
        String r6 = r3;
        this.j.add(((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.secret.d.class)).d(r2.getObjId(), r1.getType(), r6, r2.getSecLabelBannerType(), this.l).subscribe(new y(), new z()));
        if (r2.isRecommendMark() == false) goto L18;
        com.bytedance.ee.bear.middleground.permission.c.G(fj5.a.d(r1.getDocMetaInfo(), r1.getDocPermission().a), "close");
    L18:
        DocTipsLayout r4 = this.e;
        r4.r.setVisibility(8);
        r4.f = false;
        return;
    L14:
        r3 = r2.getSecretLevel().getId();
        goto L15
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
    public final void d() {
        DocumentInfo r0 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r0 == null) goto L15;
        DocViewModel r1 = this.c;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getWikiInfo() != null) goto L10;
    L12:
        String r2 = "";
    L13:
        String r7 = r2;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(this.a.getActivity(), this.c.getToken(), this.c.getDocumentTypeValue(), r0.getDocMetaInfo(), r7, "from_banner");
        com.bytedance.ee.bear.middleground.permission.c.N(r0.getDocMetaInfo().isSecretAdminDefault(), "security_setting", "ccm_permission_security_setting_view");
        return;
    L10:
        if (this.c.getWikiInfo().getWikiToken() == null) goto L12;
        r2 = this.c.getWikiInfo().getWikiToken();
        goto L13
    }

    public final void e() {
        this.a.findPluginToDo(BaseTitlePlugin.class, new t());
    }

    public final String h() {
        String r0 = ((e4) this.a.getHostAbility(e4.class)).getDocumentMetadata().getDocumentType();
        if (TextUtils.equals(r0, sbb.e.g.getType()) == true) goto L30;
        if (TextUtils.equals(r0, sbb.e.o.getType()) == true) goto L30;
        if (TextUtils.equals(r0, sbb.e.h.getType()) == false) goto L12;
        return i(2131887833);
    L12:
        if (TextUtils.equals(r0, sbb.e.i.getType()) == false) goto L16;
        ((nw4.b) LarkContext.spiByDwarf(nw4.b.class)).b();
        return i(2131886359);
    L16:
        if (TextUtils.equals(r0, sbb.e.k.getType()) == false) goto L20;
        return i(2131887839);
    L20:
        if (TextUtils.equals(r0, sbb.e.m.getType()) == false) goto L24;
        return i(2131889766);
    L24:
        if (TextUtils.equals(r0, sbb.e.n.getType()) == false) goto L28;
        return i(2131887839);
    L28:
        return i(2131887744);
    L30:
        return i(2131887839);
    }

    public final void k() {
        tt5.a.h("TipsController", "hideAtTips");
        DocTipsLayout r0 = this.e;
        r0.b = false;
        r0.a();
        r0.b();
    }

    public final void l() {
        tt5.a.h("TipsController", "hideErrorTips");
        DocTipsLayout r0 = this.e;
        r0.d = false;
        r0.a();
        r0.b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        PluginHost r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        this.b.getTitleBar().c(this);
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).c(this.f);
        this.j.clear();
        return;
    L5:
        if (r0.getLifecycleOwner() == null) goto L7;
        this.a.getLifecycleOwner().getLifecycle().removeObserver(this);
        goto L7
    }

    public final void u() {
        DocumentInfo r1 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r1 != null) goto L6;
        tt5.a.h("TipsController", "updateTemplateTagState documentInfo == null");
        return;
    L6:
        int r2 = r1.getDocMetaInfo().getTemplate_type();
        tt5.a.h("TipsController", "updateTemplateTagState templateType:" + r2);
        int r3 = com.bytedance.ee.bear.templates.g.a;
        boolean r4 = false;
        if (r2 != 1) goto L9;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L30;
        DocumentInfo r6 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r6 == null) goto L59;
        boolean r7 = ku5.c.k(this.a.getContext());
        tt5.a.h("TipsController", "isPad:" + r7);
        if (r7 == false) goto L18;
        ((wn5.a) org.koin.java.a.a(wn5.a.class)).l("", r6.getObjToken(), r6.getType()).subscribe(new k(this), new l(this));
    L19:
        BenefitStore r8 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1();
        DocViewModel r9 = this.c;
        sbb.e r10 = sbb.e.i;
        if (r9.isDocumentType(r10) == false) goto L24;
        if (r8.hasBenefit("base_create_base") == false) goto L24;
    L27:
        r4 = true;
    L28:
        t(true, !r4);
        return;
    L24:
        if (this.c.isDocumentType(r10) == true) goto L28;
        if (r8.hasBenefit("ccm_create_doc") == false) goto L28;
    L18:
        this.e.setTemplateTagTitle(new TemplateTagTipsView.d(true, false, new TemplateTagTipsView.c(), 0));
        goto L19
    L59:
        return;
    L30:
        if (r2 != 2) goto L32;
        boolean r11 = true;
    L33:
        if (r11 == false) goto L58;
        DocumentInfo r12 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r12 == null) goto L60;
        DocMetaInfo r13 = r12.getDocMetaInfo();
        DocPermission r14 = r12.getDocPermission();
        IDocUserPermission r16 = r14.a;
        IDocPublicPermission r17 = r14.b;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r18 = jg5.e.a.a.g();
        BenefitStore r19 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1();
        DocViewModel r110 = this.c;
        sbb.e r111 = sbb.e.i;
        if (r110.isDocumentType(r111) == false) goto L42;
        if (r19.hasBenefit("base_create_base") == false) goto L42;
    L45:
        boolean r20 = true;
    L48:
        if (r18 == false) goto L50;
        PermissionResponse r21 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(new UniBaseEntity(this.c.getToken(), sbb.e.d(this.c.getDocumentTypeValue()), BizDomain.FileBizDomainCCM, this.c.getCreatorTenantId(), this.c.getOwnerUserId(), sbb.e.e), "CREATE_COPY"), null);
        tt5.a.h("TipsController", "canCopy:" + r21.getAllow());
        t(((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r21), r20 ^ true);
    L55:
        this.e.setTemplateTagTitle(new TemplateTagTipsView.d(false, false, new TemplateTagTipsView.c(r13.getOwnerName(), r13.getOwnerUid()), 0));
        return;
    L50:
        gj5.c r22 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, this.c.getDocumentTypeValue(), this.c.getToken());
        r17.isOwner();
        boolean r23 = r16.canCreateCopy();
        boolean r24 = r22.a;
        tt5.a.h("TipsController", "canCopy:" + r23);
        if (r23 == false) goto L54;
        if (r24 == false) goto L54;
        r4 = true;
    L54:
        t(r4, !r20);
    L42:
        if (this.c.isDocumentType(r111) == false) goto L44;
    L46:
        r20 = false;
        goto L48
    L44:
        if (r19.hasBenefit("ccm_create_doc") == false) goto L46;
    L60:
        return;
    L58:
        return;
    L32:
        r11 = false;
        goto L33
    L9:
        r5 = false;
        goto L11
    }

    public final void v() {
        PluginHost r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.h == false) goto L7;
    L10:
        final boolean r1 = true;
    L11:
        r0.findPluginToDo(BasePermApplyPlugin.class, new s(r1));
        return;
    L7:
        if (this.i == true) goto L10;
        r1 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ee.bear.document.tips.d] */
    public final void w() {
        String r0 = this.c.getToken();
        int r4 = this.c.getDocumentTypeValue();
        wn5.a r1 = (wn5.a) org.koin.java.a.a(wn5.a.class);
        if (r4 != 8) goto L5;
        ((nw4.b) LarkContext.spiByDwarf(nw4.b.class)).b();
    L5:
        r1.g(this.a.getActivity(), r0, r4, null, new d(this));
        m("use_click", r0, 0);
    }

    public final boolean x() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L9;
        UniBaseEntity r0 = new UniBaseEntity(this.c.getToken(), sbb.e.d(this.c.getDocumentTypeValue()), BizDomain.FileBizDomainCCM, this.c.getCreatorTenantId(), this.c.getOwnerUserId(), sbb.e.e);
        PermissionResponse r1 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r0, "CREATE_COPY"), null);
        r1.getCallback().a(this.a.getActivity(), r1);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r1) == false) goto L7;
        return true;
    L7:
        return false;
    L9:
        gj5.b r2 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r3 = FileBizDomain.FileBizDomainCCM;
        gj5.c r4 = r2.g("CCM_CREATE_COPY", r3, this.c.getDocumentTypeValue(), this.c.getToken());
        if (r4.a == true) goto L15;
        if (r4.b.equals(FileAuthResultFrom.COME_FROM_FILE_POLICY) == false) goto L15;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CREATE_COPY", r3, this.c.getDocumentTypeValue(), this.c.getToken());
    L19:
        return true;
    L15:
        if (r4.a == true) goto L19;
        if (r4.b.equals(FileAuthResultFrom.COME_FROM_AUTHZ) == false) goto L19;
        UDToast.show(eu5.b.a, 2131887246);
        goto L19
    }

    public final String i(int r2) {
        return this.b.getContext().getString(r2);
    }

    public final void n(int r4) {
        DocumentInfo r0 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        tt5.a.b("TipsController", "setSecretBannerShowOuter " + r4);
        if (this.n == false) goto L8;
        r(r0);
        return;
    L8:
        q(r0);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar.a
    public final void onTitleBarStateChanged(com.bytedance.ee.bear.browser.plugin.d r2) {
        DocTipsLayout r0 = this.e;
        if (r2.e == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void q(DocumentInfo r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (this.c.isEditionDoc() == false) goto L6;
        return;
    L6:
        if (this.d == true) goto L58;
        DocMetaInfo r0 = r12.getDocMetaInfo();
        if (r0 != null) goto L11;
        return;
    L11:
        if (r12.getDocPermission() != null) goto L13;
        return;
    L13:
        if (r12.getDocPermission().a == null) goto L59;
        boolean r1 = fj5.a.d(r12.getDocMetaInfo(), r12.getDocPermission().a);
        tt5.a.h("TipsController", "showSecretBanner " + r1);
        boolean r2 = r12.getDocPermission().a.canModifySecretLevel();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L19;
        r2 = this.c.getPermissionResponseWithUserPermission(BizDomain.FileBizDomainCCM, "SECRET_MODIFY").getAllow();
    L19:
        if (r12.getType() != sbb.e.n.b) goto L21;
        boolean r5 = fj5.a.b(r0.getRealType());
    L22:
        boolean r6 = r0.isVisibleSecList();
        DocShareUserInfo r7 = (DocShareUserInfo) this.c.getmDocShareInfo().getValue();
        if (r7 == null) goto L50;
        if (r7.isHasPullSuc() == false) goto L50;
        boolean r8 = r7.hasCollaborate();
        com.bytedance.ee.bear.document.tips.a r9 = this.k;
        if (r9 == null) goto L33;
        int r10 = r9.a();
        if (r10 <= 1) goto L31;
        r8 = true;
        goto L33
    L31:
        if (r10 != 1) goto L33;
        r8 = false;
    L33:
        boolean r11 = r0.isSecretBannerShow(r1, true, r8);
        tt5.a.b("TipsController", "initSecretBanner");
        if (r0.getSecretLevel() == null) goto L36;
        String r13 = r0.getSecretLevel().getName();
    L37:
        if (r2 == false) goto L42;
        if (r5 == false) goto L42;
        if (r6 == false) goto L42;
        if (r11 == false) goto L42;
        boolean r3 = true;
    L43:
        DocTipsLayout r14 = this.e;
        boolean r4 = r0.isSecretAdminDefault();
        Boolean r16 = Boolean.valueOf(r1);
        if (r3 == false) goto L46;
        r14.setVisibility(0);
        r14.f = true;
        r14.r.e(r4, r13, r16);
        r14.a();
        DocTipsLayout.d(new View[]{r14.n});
        com.bytedance.ee.bear.middleground.permission.c.O(r4);
    L47:
        this.i = r3;
        tt5.a.b("TipsController", "showSecretBanner " + r3);
        v();
        g(Boolean.valueOf(r1), r12);
        return;
    L46:
        r14.f = false;
        r14.a();
        r14.b();
    L42:
        r3 = false;
        goto L43
    L36:
        r13 = "";
    L50:
        if (this.p == true) goto L52;
        f(r12.getObjToken(), r12.getType());
    L52:
        this.p = true;
        return;
    L21:
        r5 = fj5.a.c(r12.getType(), r12.getVersion().isDocV2());
        goto L22
    L59:
        return;
    }

    public final void r(final DocumentInfo r23) {
        if (r23 != null) goto L5;
        return;
    L5:
        if (this.c.isEditionDoc() == false) goto L7;
        return;
    L7:
        if (this.d == true) goto L74;
        DocMetaInfo r0 = r23.getDocMetaInfo();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r23.getDocPermission() != null) goto L14;
        return;
    L14:
        if (r23.getDocPermission().a == null) goto L75;
        boolean r1 = fj5.a.d(r23.getDocMetaInfo(), r23.getDocPermission().a);
        boolean r3 = r0.isSecretAdminDefault();
        boolean r5 = true;
        boolean r12 = !TextUtils.equals("", r0.getSecretLevel().getId());
        boolean r10 = r0.isAutoMark();
        boolean r4 = r0.isRecommendMark();
        boolean r13 = r0.getDoubleCheckDefaultLabel();
        if (r0.getSecLabelStatus() == 1) goto L19;
        boolean r16 = true;
    L20:
        DocMetaInfo r6 = r23.getDocMetaInfo();
        if (r23.getType() != sbb.e.n.b) goto L23;
        boolean r8 = fj5.a.b(r6.getRealType());
    L24:
        boolean r7 = r6.isVisibleSecList();
        boolean r9 = r23.getDocPermission().a.canModifySecretLevel();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L27;
        r9 = this.c.getPermissionResponseWithUserPermission(BizDomain.FileBizDomainCCM, "SECRET_MODIFY").getAllow();
    L27:
        if (r8 == false) goto L31;
        if (r7 == false) goto L31;
        if (r9 == false) goto L31;
        boolean r11 = true;
    L33:
        if (r10 == false) goto L37;
        if (r16 == true) goto L37;
        tt5.a.h("TipsController", "is autoBanner");
        return;
    L37:
        tt5.a.h("TipsController", "showSecretBanner " + r1);
        final com.bytedance.ee.bear.middleground.permission.secret.n r14 = new com.bytedance.ee.bear.middleground.permission.secret.n(r3, r10, r4, r12, r13, r1, "", r16, false);
        if (r4 == false) goto L41;
        final boolean r17 = fj5.a.d(r23.getDocMetaInfo(), r23.getDocPermission().a);
        final boolean r18 = r23.getDocMetaInfo().isSecretAdminDefault();
        final boolean r19 = r11;
        this.j.add(((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.secret.d.class)).c(r23.getObjToken(), r23.getType()).subscribe(new u(this, r23, r14, r17, r19, r18), new v()));
        return;
    L41:
        DocShareUserInfo r20 = (DocShareUserInfo) this.c.getmDocShareInfo().getValue();
        if (r20 == null) goto L66;
        if (r20.isHasPullSuc() == false) goto L66;
        boolean r110 = r20.hasCollaborate();
        com.bytedance.ee.bear.document.tips.a r21 = this.k;
        if (r21 == null) goto L52;
        int r22 = r21.a();
        if (r22 <= 1) goto L50;
        r110 = true;
        goto L52
    L50:
        if (r22 != 1) goto L52;
        r110 = false;
    L52:
        r0.getSecretLevel();
        String r24 = r0.getSecretLevel().getName();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r14.g = r24;
        r14.i = r110;
        com.bytedance.ee.bear.middleground.permission.secret.o r26 = ((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.secret.d.class)).a(r14, this.a.getContext());
        tt5.a.b("TipsController", "showSecretBanner " + r26.d);
        if (r26.e == false) goto L58;
        if (this.m == false) goto L58;
        this.m = false;
        this.j.add(((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.secret.d.class)).d(r0.getObjId(), r23.getType(), r0.getSecretLevel().getId(), r0.getSecLabelBannerType(), this.l).subscribe(new e(), new f()));
    L58:
        r26.f = r1;
        if (r26.d == false) goto L62;
        if (r11 == false) goto L62;
    L63:
        r26.d = r5;
        this.e.f(r26, r3);
        this.i = r26.d;
        v();
        g(Boolean.valueOf(r1), r23);
        return;
    L62:
        r5 = false;
    L66:
        if (this.p == true) goto L68;
        f(r23.getObjToken(), r23.getType());
    L68:
        this.p = true;
        return;
    L31:
        r11 = false;
        goto L33
    L23:
        r8 = fj5.a.c(r23.getType(), r23.getVersion().isDocV2());
        goto L24
    L19:
        r16 = false;
        goto L20
    L75:
        return;
    }

    public final void s(boolean r3) {
        DocTipsLayout r0 = this.e;
        if (r3 == false) goto L5;
        r0.setVisibility(0);
        r0.e = true;
        r0.a();
        return;
    L5:
        r0.e = false;
        r0.a();
        r0.b();
    }

    public final void f(String r3, int r4) {
        this.p = true;
        jg5.j r0 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa();
        a r1 = new a(this);
        r0.getClass();
        li5.c.c(r4, r3, r1, null);
    }

    public final void g(Boolean r7, DocumentInfo r8) {
    L19:
        e = move-exception;
        tt5.a.d("TipsController", "forceSecretDialog error : " + e);
        return;
    L4:
        if (Math.abs(CastLongProtector.valueOf(r8.getDocMetaInfo().getServerTime()).longValue() - CastLongProtector.valueOf(r8.getDocMetaInfo().getCreateTime()).longValue()) >= 10) goto L6;
        boolean r1 = true;
    L7:
        Boolean r2 = Boolean.valueOf(r1);     // Catch: Exception -> L19
        if (r7.booleanValue() == true) goto L10;
        return;
    L10:
        if (r2.booleanValue() == false) goto L25;
        ml5.b r9 = mh5.e.a;     // Catch: Exception -> L19
        String r10 = r8.getObjToken();     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r10, "token");     // Catch: Exception -> L19
        if (Intrinsics.areEqual(mh5.e.c.get(du5.b.g(r10)), Boolean.TRUE) == false) goto L14;
        return;
    L14:
        if (this.c.hasAutoShownSecretSetting() == false) goto L16;
        tt5.a.h("TipsController", "forceSecretDialog, hasAutoShownSecretSetting is true");     // Catch: Exception -> L19
    L17:
        mh5.e.c(r8.getObjToken());     // Catch: Exception -> L19
        return;
    L16:
        this.c.onAutoShownSecretSetting();     // Catch: Exception -> L19
        d();     // Catch: Exception -> L19
        goto L17
    L25:
        return;
    L6:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ee.bear.document.tips.r] */
    public final void j(final boolean r7, final String r8) {
        if (this.c.getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r0 = true;
    L6:
        final Boolean r1 = Boolean.valueOf(r0);
        if (this.e.g == true) goto L9;
        String r2 = com.bytedance.ee.bear.middleground.permission.c.a;
        com.bytedance.ee.bear.middleground.permission.c.s(r7, r1.booleanValue());
    L9:
        final DocTipsLayout r3 = this.e;
        Function0<Unit> r4 = new q(r7, r1);
        final ?? r5 = new r(r8, r7, r1);
        r3.setVisibility(0);
        r3.g = true;
        r3.a();
        DLPRiskBannerView r9 = r3.s;
        Function0<Unit> r10 = new w1(r3, r5);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r4, "seeDetail");
        Intrinsics.checkNotNullParameter(r10, "closeAction");
        r9.e = r4;
        r9.f = r10;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void o(String r3, tb5.m r4) {
        tt5.a.h("TipsController", "showAtTips:" + r3);
        e();
        DocTipsLayout r0 = this.e;
        r0.setVisibility(0);
        r0.b = true;
        r0.l.o6(r3, r4);
        r0.a();
    }

    public final void t(boolean r2, boolean r3) {
        TemplateTagTipsView r0 = this.e.n;
        r0.d = r2;
        if (r3 == false) goto L5;
        r0.a.setVisibility(8);
    L6:
        r0.b();
        return;
    L5:
        r0.a.setVisibility(0);
        goto L6
    }

    public a0(PluginHost r6, com.bytedance.ee.bear.browser.plugin.t r7, DocViewModel r8) {
        this.h = false;
        this.i = false;
        this.j = new CompositeDisposable();
        this.l = 1;
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = false;
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r8.isSyncBlock();
        if (this.e == null) goto L5;
    L7:
        com.bytedance.ee.bear.notification.a.b r0 = this.e.getNotificationView();
        r0.f(new c(this));
        r0.d(new n(this));
        this.n = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.permission.secret_auto");
        b r1 = new b(this);
        this.f = r1;
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).b(r1);
        tt5.a.h("TipsController", "onSetBanner");
        String r2 = h();
        this.e.setNoNetworkTip(r2);
        r6.getLifecycleOwner().getLifecycle().addObserver(this);
        com.bytedance.ee.bear.contract.j.a.a.a().observe(r6.getLifecycleOwner(), new o(this));
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L10;
    L11:
        tt5.a.h("TipsController", "isOfficeSDK: false");
        if (r8.getOpenSource() != DocsOpenSource.template_preview) goto L14;
    L21:
        tt5.a.h("TipsController", "preview or vc no support");
    L22:
        this.e.setSecretBannerClick(this);
        r8.liveDocumentInfoData().observe(r6.getLifecycleOwner(), new i(this));
        r8.getmDocShareInfo().observe(r6.getLifecycleOwner(), new j(this));
        r8.liveDocumentInfoData().observe(r6.getLifecycleOwner(), new m(this));
    L23:
        r7.getTitleBar().g(this);
        return;
    L14:
        if (r8.getOpenSource() == DocsOpenSource.vc) goto L21;
        u();
        final TemplateViewModel r3 = ViewModelProviders.of(r6.getActivity()).get(TemplateViewModel.class);
        final MutableLiveData r4 = r3.getTemplateTagStatueLiveData();
        Lazy r5 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == false) goto L19;
        FragmentActivity r9 = r6.getActivity();
    L20:
        r4.observe(r9, new g(this));
        r8.liveDocumentInfoData().observe(r6.getLifecycleOwner(), new h(this, r4, r3));
        this.e.setTemplateClick(this);
        goto L22
    L19:
        r9 = r6.getLifecycleOwner();
        goto L20
    L10:
        if (CCMOfficeSDKAssembleFG.a() == false) goto L23;
    L5:
        if (r7.findView(2131369336) == null) goto L7;
        ViewStub r10 = (ViewStub) r7.findView(2131369336);
        r10.setLayoutResource(2131560089);
        this.e = (DocTipsLayout) r10.inflate();
        goto L7
    }

    public final void m(String r10, String r11, int r12) {
        String r2 = this.c.getToken();
        int r5 = this.c.getDocumentTypeValue();
        DocumentInfo r0 = (DocumentInfo) this.c.liveDocumentInfoData().getValue();
        if (r0 == null) goto L5;
        int r6 = r0.getDocMetaInfo().getTemplate_type();
    L6:
        yn5.c r1 = new yn5.c(r2, this.c.getDocTitle(), r11, r5, r6, this.c.isType(sbb.e.n), r12);
        ((wn5.a) org.koin.java.a.a(wn5.a.class)).n(r10, r1);
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public final void p(final ErrorTipsView.d r11, ErrorTipsView.c r12, final ErrorTipsView.b r13) {
        tt5.a.h("TipsController", "showErrorTips:" + r11.a + "with link : " + du5.b.g(r11.c) + " action:" + r12.b + " actionText:" + r12.c);
        e();
        DocTipsLayout r0 = this.e;
        final ErrorTipsView r7 = r0.p;
        r7.Z5();
        int r1 = ErrorTipsView.a.a[r11.d.ordinal()];
        if (r1 != 1) goto L5;
        r7.setType(UDNotice.Type.WARNING);
        r7.setIconColorful(true);
        r7.setIcon(2131256185);
    L9:
        r7.i6(r12.a);
        if (r12.a == false) goto L12;
        r7.setIconButtonListener(new com.bytedance.ee.bear.facade.common.widget.n(r13));
    L12:
        r7.setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
        if (TextUtils.isEmpty(r12.c) == true) goto L16;
        r7.setTextButton(r12.c);
        r7.setTextButtonListener(new com.bytedance.ee.bear.facade.common.widget.o(r13, r12));
    L19:
        if (TextUtils.isEmpty(r11.a) == false) goto L21;
        tt5.a.d("ErrorTipsView", "empty whole text");
    L29:
        r0.setVisibility(0);
        r0.d = true;
        r0.k = false;
        r0.a();
        return;
    L21:
        tt5.a.b("ErrorTipsView", "start render error tips");
        if (TextUtils.isEmpty(r11.b) == false) goto L24;
    L27:
        tt5.a.b("ErrorTipsView", "no need to render");
        r7.setText(r11.a);
    L28:
        r7.o6(r12.d, r12.e, r11.a, r13, r12.f);
        r7.o6(r12.g, r11.b, r11.a, r13, r12.f);
        goto L29
    L24:
        if (TextUtils.isEmpty(r11.c) == true) goto L27;
        Flowable.just(r11.a).map(new com.bytedance.ee.bear.facade.common.widget.f(r11)).subscribe(new com.bytedance.ee.bear.facade.common.widget.g(r7, r11, r13), new com.bytedance.ee.bear.facade.common.widget.h(r7, r11));
        goto L28
    L16:
        if (((UDNotice) r7).r == false) goto L19;
        r7.k6(false);
        goto L19
    L5:
        if (r1 == 2) goto L7;
        r7.setType(UDNotice.Type.INFO);
        r7.setIconColorful(true);
        r7.setIcon(2131254918);
        goto L9
    L7:
        r7.setType(UDNotice.Type.ERROR);
        r7.setIconColorful(true);
        r7.setIcon(2131254319);
        goto L9
    }
}
