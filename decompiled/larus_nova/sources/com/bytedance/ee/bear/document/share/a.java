package com.bytedance.ee.bear.document.share;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.bitable.c;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.export.ExportPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.h;
import com.bytedance.ee.bear.templates.g;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.ArrayList;
import s35.b;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public class a extends s35.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DocumentPluginHost f221763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f221764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharePlugin.c f221765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f221766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f221767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f221768g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.share.a$a, reason: collision with other inner class name */
    public class C3158a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocViewModel f221769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f221770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f221771c;

        public final void a() {
            DocumentInfo r100 = this.f221769a.getDocumentInfoData();
            if (this.f221770b == false) goto L7;
            if (r100 == null) goto L8;
            String r101 = r100.getObjToken();
            String r102 = r100.getOwnerUid();
            String r103 = r100.getCreatorTenantId();
            int r104 = g.f239075a;
            c r105 = new c(g.a(r100.getDocMetaInfo().getTemplate_type()), this.f221770b, r103);
            a r106 = this.f221771c;
            b r107 = r106.f221764c;
            ArrayList<BlockSimpleInfo> r108 = r107.f540474h;
            ArrayList<BlockSimpleInfo> r109 = r107.f540475i;
            ((com.bytedance.ee.bear.document.bitable.g) r106.f221763b.getHostAbility(com.bytedance.ee.bear.document.bitable.g.class)).showBitableProFragment(r101, r102, false, r105, r108, r109);
            return;
        L8:
            return;
        }

        public C3158a(a r100, DocViewModel r101, boolean r102, boolean r103) {
            this.f221771c = r100;
            this.f221769a = r101;
            this.f221770b = r102;
        }
    }

    public String a() {
        return "";
    }

    public final void c(b r210) {
        this.f221764c = r210;
        if (r210 == null) goto L5;
        long r100 = System.currentTimeMillis();
        boolean r101 = false;
        if (Math.abs(r100 - this.f221766e) >= 1500) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
        return;
    L16:
        DocViewModel r103 = this.f221763b.a();
        String r104 = r103.getDocFeedId();
        String r105 = r103.getUrl();
        BearUrl r106 = p.a().Z(r105);
        int r107 = e.g(r106.f222560a);
        String r108 = r103.getEditionId();
        if (r210.f540468b == null) goto L23;
        DocumentPluginHost r109 = this.f221763b;
        if (r109 == null) goto L23;
        BearUrl r110 = ((t45.c) r109.getUserComponent().a(t45.c.class)).Z(r210.f540468b);
        int r111 = e.g(r110.f222560a);
        if (r111 != 44) goto L23;
        r106.f222561b = r110.f222561b;
        r107 = r111;
    L23:
        boolean r112 = r103.isOwner();
        ShareDocInfo r113 = null;
        if (r103.getDocumentInfoData() == null) goto L36;
        boolean r114 = r103.getDocumentInfoData().adminPerceiveControl();
        if (this.f221767f == false) goto L37;
        if (r112 == true) goto L35;
        DocumentInfo r115 = r103.getDocumentInfoData();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L31;
        UniBaseEntity r116 = new UniBaseEntity(r115.getObjToken(), e.d(r115.getType()), BizDomain.FileBizDomainCCM, r115.getCreatorTenantId(), r115.getOwnerUid(), null);
        boolean r117 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r116, "MANAGE_PERMISSION_META"), new UserPermissionEntity(r115.getDocPermission().f234419a, null)).getAllow();
    L32:
        if (r117 == true) goto L35;
        r112 = false;
        goto L37
    L31:
        r117 = r115.getDocPermission().f234419a.canManagePermissionMeta();
    L35:
        r112 = true;
    L37:
        boolean r118 = this.f221764c.f540473g;
        ShareParams.ShareParamsBuilder r119 = new ShareParams.ShareParamsBuilder(this.f221763b.getActivity(), this.f221763b.c()).source(2).type(r107).docName(this.f221764c.f540467a).token(r106.f222561b).realToken(r106.f222561b).realType(r107).url(this.f221764c.f540468b).originUrl(this.f221764c.f540468b).isOwner(r103.isOwner()).isFa(Boolean.valueOf(r112)).isPro(Boolean.valueOf(r118)).isProAccessConfigBindRole(Boolean.valueOf(this.f221764c.f540476j)).bitableRoleMembers(this.f221764c.f540477k).module(r106.f222560a);
        e r120 = e.f541303n;
        ShareParams.ShareParamsBuilder r121 = r119.isWiki(r103.isType(r120));
        int r122 = r103.getContainerType();
        int r123 = com.bytedance.ee.bear.a.f206186a;
        if (r122 != 3) goto L40;
        r101 = true;
    L40:
        ShareParams.ShareParamsBuilder r124 = r121.isPhoenix(r101).docContent(this.f221764c.f540469c).docTopic(this.f221764c.f540470d).mindnoteViewType(a()).feedId(r104).adminPerceiveControl(r114).disabledShareTypes(this.f221764c.f540471e).badgeShareTypes(this.f221764c.f540472f);
        String r125 = r106.f222567h;
        if (r125 != null) goto L43;
        r125 = "";
    L43:
        ShareParams r126 = r124.isAtVC(ThumbGlideUrl.SOURCE_VC.equals(r125)).editionId(r108).build();
        C3158a r127 = new C3158a(this, r103, r118, r112);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.b(r126.getType()) == false) goto L56;
        cj5.c r128 = (cj5.c) org.koin.java.a.a(cj5.c.class);
        Bundle r129 = r103.getRemindBinder();
        DocumentInfo r130 = r103.getDocumentInfoData();
        if (r130 != null) goto L48;
    L55:
        r128.N2(r126, r129, r127, r113);
    L58:
        if (this.f221765d == null) goto L66;
        ArrayList<Integer> r131 = r210.f540472f;
        if (r131 == null) goto L66;
        if (r131.contains(Integer.valueOf(ShareType.ExportImage.ordinal())) == false) goto L66;
        ExportPlugin r132 = (ExportPlugin) SharePlugin.access$000(((SharePlugin.b) this.f221765d).f221762a, ExportPlugin.class);
        if (r132 == null) goto L66;
        r132.onShowExportBadges("share_panel", ShareItem.SHARE_IMAGE);
    L66:
        boolean r133 = r103.isType(r120);
        String r134 = r210.f540468b;
        if (r133 == false) goto L69;
        String r135 = p.a().Z(r134).f222561b;
        String r136 = "wiki";
    L70:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ea(r136, r135);
        return;
    L69:
        r136 = r106.f222560a;
        r135 = r106.f222561b;
        goto L70
    L48:
        if (r126.getType() == 44) goto L55;
        if (TextUtils.equals(r130.getObjToken(), r126.getToken()) == false) goto L55;
        if (r130.getType() != r126.getType()) goto L55;
        r113 = new ShareDocInfo(r126.getType(), r126.getUrl(), r126.getToken(), r130.getVersion(), r130.getDocMetaInfo(), r130.getDocPermission().f234419a, r130.getDocPermission().f234420b, true, true, false);
        goto L55
    L56:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).aa(r126, r103.getRemindBinder(), r127);
        goto L58
    L36:
        r114 = false;
        goto L37
    L13:
        this.f221766e = r100;
        r102 = false;
        goto L14
    L5:
        if (eu5.c.d() == true) goto L9;
        tt5.a.d("ShareHandler", "share, shareItemModel is null.");
        return;
    L9:
        throw new IllegalArgumentException("shareItemModel must not be null.");
    }

    public a(DocumentPluginHost r100, SharePlugin.c r101) {
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f221767f = r102.h("base.advanced_permission.role_inheritance");
        this.f221768g = r102.h("base.advanced_permission.2layerrole_reconciliation");
        this.f221763b = r100;
        this.f221765d = r101;
    }
}
