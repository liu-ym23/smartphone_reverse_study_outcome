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
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.h;
import com.bytedance.ee.bear.templates.g;
import java.util.ArrayList;
import s35.b;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a extends s35.a {
    public final DocumentPluginHost b;
    public b c;
    public final SharePlugin.c d;
    public long e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.share.a$a, reason: collision with other inner class name */
    public class C0102a implements h {
        public final /* synthetic */ DocViewModel a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ a c;

        public final void a() {
            DocumentInfo r0 = this.a.getDocumentInfoData();
            if (this.b == false) goto L7;
            if (r0 == null) goto L8;
            String r3 = r0.getObjToken();
            String r4 = r0.getOwnerUid();
            String r1 = r0.getCreatorTenantId();
            int r2 = g.a;
            c r6 = new c(g.a(r0.getDocMetaInfo().getTemplate_type()), this.b, r1);
            a r5 = this.c;
            b r7 = r5.c;
            ArrayList<BlockSimpleInfo> r8 = r7.h;
            ArrayList<BlockSimpleInfo> r9 = r7.i;
            ((com.bytedance.ee.bear.document.bitable.g) r5.b.getHostAbility(com.bytedance.ee.bear.document.bitable.g.class)).showBitableProFragment(r3, r4, false, r6, r8, r9);
            return;
        L8:
            return;
        }

        public C0102a(a r1, DocViewModel r2, boolean r3, boolean r4) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public String a() {
        return "";
    }

    public final void c(b r26) {
        this.c = r26;
        if (r26 == null) goto L5;
        long r2 = System.currentTimeMillis();
        boolean r9 = false;
        if (Math.abs(r2 - this.e) >= 1500) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return;
    L16:
        DocViewModel r4 = this.b.a();
        String r5 = r4.getDocFeedId();
        String r6 = r4.getUrl();
        BearUrl r7 = p.a().Z(r6);
        int r8 = e.g(r7.a);
        String r10 = r4.getEditionId();
        if (r26.b == null) goto L23;
        DocumentPluginHost r11 = this.b;
        if (r11 == null) goto L23;
        BearUrl r12 = ((t45.c) r11.getUserComponent().a(t45.c.class)).Z(r26.b);
        int r13 = e.g(r12.a);
        if (r13 != 44) goto L23;
        r7.b = r12.b;
        r8 = r13;
    L23:
        boolean r14 = r4.isOwner();
        ShareDocInfo r16 = null;
        if (r4.getDocumentInfoData() == null) goto L36;
        boolean r17 = r4.getDocumentInfoData().adminPerceiveControl();
        if (this.f == false) goto L37;
        if (r14 == true) goto L35;
        DocumentInfo r18 = r4.getDocumentInfoData();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L31;
        UniBaseEntity r19 = new UniBaseEntity(r18.getObjToken(), e.d(r18.getType()), BizDomain.FileBizDomainCCM, r18.getCreatorTenantId(), r18.getOwnerUid(), null);
        boolean r20 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r19, "MANAGE_PERMISSION_META"), new UserPermissionEntity(r18.getDocPermission().a, null)).getAllow();
    L32:
        if (r20 == true) goto L35;
        r14 = false;
        goto L37
    L31:
        r20 = r18.getDocPermission().a.canManagePermissionMeta();
    L35:
        r14 = true;
    L37:
        boolean r21 = this.c.g;
        ShareParams.ShareParamsBuilder r22 = new ShareParams.ShareParamsBuilder(this.b.getActivity(), this.b.c()).source(2).type(r8).docName(this.c.a).token(r7.b).realToken(r7.b).realType(r8).url(this.c.b).originUrl(this.c.b).isOwner(r4.isOwner()).isFa(Boolean.valueOf(r14)).isPro(Boolean.valueOf(r21)).isProAccessConfigBindRole(Boolean.valueOf(this.c.j)).bitableRoleMembers(this.c.k).module(r7.a);
        e r110 = e.n;
        ShareParams.ShareParamsBuilder r23 = r22.isWiki(r4.isType(r110));
        int r111 = r4.getContainerType();
        int r112 = com.bytedance.ee.bear.a.a;
        if (r111 != 3) goto L40;
        r9 = true;
    L40:
        ShareParams.ShareParamsBuilder r24 = r23.isPhoenix(r9).docContent(this.c.c).docTopic(this.c.d).mindnoteViewType(a()).feedId(r5).adminPerceiveControl(r17).disabledShareTypes(this.c.e).badgeShareTypes(this.c.f);
        String r27 = r7.h;
        if (r27 != null) goto L43;
        r27 = "";
    L43:
        ShareParams r28 = r24.isAtVC("vc".equals(r27)).editionId(r10).build();
        C0102a r29 = new C0102a(this, r4, r21, r14);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.b(r28.getType()) == false) goto L56;
        cj5.c r30 = (cj5.c) org.koin.java.a.a(cj5.c.class);
        Bundle r31 = r4.getRemindBinder();
        DocumentInfo r32 = r4.getDocumentInfoData();
        if (r32 != null) goto L48;
    L55:
        r30.N2(r28, r31, r29, r16);
    L58:
        if (this.d == null) goto L66;
        ArrayList<Integer> r33 = r26.f;
        if (r33 == null) goto L66;
        if (r33.contains(Integer.valueOf(ShareType.ExportImage.ordinal())) == false) goto L66;
        ExportPlugin r34 = (ExportPlugin) SharePlugin.access$000(((SharePlugin.b) this.d).a, ExportPlugin.class);
        if (r34 == null) goto L66;
        r34.onShowExportBadges("share_panel", ShareItem.SHARE_IMAGE);
    L66:
        boolean r36 = r4.isType(r110);
        String r1 = r26.b;
        if (r36 == false) goto L69;
        String r37 = p.a().Z(r1).b;
        String r38 = FileInfoPuller.CALLER_WIKI;
    L70:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ea(r38, r37);
        return;
    L69:
        r38 = r7.a;
        r37 = r7.b;
        goto L70
    L48:
        if (r28.getType() == 44) goto L55;
        if (TextUtils.equals(r32.getObjToken(), r28.getToken()) == false) goto L55;
        if (r32.getType() != r28.getType()) goto L55;
        r16 = new ShareDocInfo(r28.getType(), r28.getUrl(), r28.getToken(), r32.getVersion(), r32.getDocMetaInfo(), r32.getDocPermission().a, r32.getDocPermission().b, true, true, false);
        goto L55
    L56:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).aa(r28, r4.getRemindBinder(), r29);
        goto L58
    L36:
        r17 = false;
        goto L37
    L13:
        this.e = r2;
        r3 = false;
        goto L14
    L5:
        if (eu5.c.d() == true) goto L9;
        tt5.a.d("ShareHandler", "share, shareItemModel is null.");
        return;
    L9:
        throw new IllegalArgumentException("shareItemModel must not be null.");
    }

    public a(DocumentPluginHost r3, SharePlugin.c r4) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.f = r0.h("base.advanced_permission.role_inheritance");
        this.g = r0.h("base.advanced_permission.2layerrole_reconciliation");
        this.b = r3;
        this.d = r4;
    }
}
